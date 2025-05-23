package com.tencent.qcircle.tavcut.timeline;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.qcircle.tavcut.cover.CoverListener;
import com.tencent.qcircle.tavcut.cover.CoverProvider;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.qcircle.tavcut.util.FloatUtils;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.util.Util;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer;
import com.tencent.tavkit.composition.TAVSource;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TimelineView extends FrameLayout implements IPlayer.PlayerListener {
    private static final int DEFAULT_MAX_SELECT_DURATION = 60000;
    private static final int DEFAULT_MIN_SELECT_DURATION = 2000;
    private static final int SELECT_AREA_ITEM_COUNT = 8;
    private static final String TAG = "TimelineView";
    private View allMaskView;
    boolean hasEditStartAndEnd;
    private RecyclerView.Adapter mAdapter;
    private CoverProvider mCoverProvider;
    private Drawable mDefaultImgBg;
    private long mEndDurationMs;
    private Drawable mGradientMask;
    private int mHeadItemWidth;
    private float mIndicatorProgress;
    private int mItemCount;
    private long mItemDurationMs;
    private int mItemHeight;
    private int mItemWidth;
    private int mLastItemWidth;
    private LinearLayoutManager mLayoutManager;
    private ImageView mLeftGradientMaskIv;
    private int mLeftGradientMaskMargin;
    private int mLeftGradientMaskWidth;
    private ImageView mLeftMaskIv;
    private int mLeftMaskMargin;
    private int mLeftMaskWidth;
    private int mLeftSliderOffset;
    private Drawable mLeftTimelineMask;
    private boolean mLockMode;
    private String mMaxDurationTps;
    private long mMaxSelectDurationMs;
    private MediaModel mMediaModel;
    private long mMinSelectDurationMs;
    private long mOriginMaxSelectDurationMs;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private long mPlayDurationMs;
    private MoviePlayer mPlayer;
    private RecyclerView mRecycleView;
    private ImageView mRightMaskIv;
    private int mRightMaskMargin;
    private int mRightMaskWidth;
    private int mRightSliderOffset;
    private Drawable mRightTimelineMask;
    private boolean mScrollEnable;
    private float mSelectAreaLeft;
    private float mSelectAreaRight;
    private long mSelectDurationMs;
    private boolean mShowDuration;
    private boolean mShowMask;
    private boolean mSliderBarMode;
    private float mSliderBarWidth;
    private SliderChangeListener mSliderChangeListener;
    private SliderView mSliderView;
    private float mSpeed;
    private long mSpeedSelectDurationMs;
    private long mSpeedTotalDurationMs;
    private long mStartDurationMs;
    private int mTailItemWidth;
    private TAVSource mTavSource;
    private long mTotalDurationMs;
    private int selectAreaItemCount;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface SpeedChangeCallback {
        public static final int CODE_TOO_FAST_FOR_1_5_TIME_SPEED = 1001;
        public static final int CODE_TOO_FAST_FOR_2_0_TIME_SPEED = 1000;

        void onChangeFailed(int i3);

        void onChangeSucc(float f16);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View view) {
            super(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCover() {
            Bitmap cover;
            int adapterPosition = getAdapterPosition();
            Bitmap bitmap = null;
            if (adapterPosition != 0 && adapterPosition != TimelineView.this.mItemCount + 1) {
                if (TimelineView.this.mCoverProvider != null && (cover = TimelineView.this.mCoverProvider.getCover(adapterPosition - 1)) != null && !cover.isRecycled()) {
                    bitmap = cover;
                }
                if (bitmap != null && !bitmap.isRecycled()) {
                    ((ImageView) this.itemView).setImageBitmap(bitmap);
                    return;
                } else {
                    ((ImageView) this.itemView).setImageDrawable(TimelineView.this.mDefaultImgBg);
                    return;
                }
            }
            ((ImageView) this.itemView).setImageBitmap(null);
        }
    }

    public TimelineView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCanAdjust() {
        SliderView sliderView = this.mSliderView;
        if (sliderView != null) {
            if (this.mSelectDurationMs <= this.mMinSelectDurationMs) {
                sliderView.setCanAdjust(false);
            } else {
                sliderView.setCanAdjust(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void correctParams() {
        int selectAreaWidth = this.mSliderView.getSelectAreaWidth() - (this.mItemWidth * this.selectAreaItemCount);
        if (selectAreaWidth == 0) {
            return;
        }
        this.mRightSliderOffset += selectAreaWidth;
        initSliderParams();
        initHeadAndTailParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCoverInsideScreen() {
        CoverProvider coverProvider;
        int findFirstVisibleItemPosition = this.mLayoutManager.findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition > 0) {
            findFirstVisibleItemPosition--;
        }
        int findLastVisibleItemPosition = this.mLayoutManager.findLastVisibleItemPosition();
        if (findLastVisibleItemPosition == this.mAdapter.getItemCount() - 1) {
            findLastVisibleItemPosition -= 2;
        }
        if (findFirstVisibleItemPosition >= 0 && findLastVisibleItemPosition >= 0 && (coverProvider = this.mCoverProvider) != null) {
            coverProvider.getCoverByIndexRange(findFirstVisibleItemPosition, findLastVisibleItemPosition);
            Logger.d(TAG, "getCoverInsideScreen: startIndex is " + findFirstVisibleItemPosition);
            Logger.d(TAG, "getCoverInsideScreen: endIndex is " + findLastVisibleItemPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSliderBarMove(float f16, float f17) {
        this.mSelectAreaLeft = f16;
        this.mSelectAreaRight = f17;
        updateSelectDuration();
        updateStartDuration();
        updateEndDuration();
        setSliderSelectDuration();
        updateMask();
    }

    private void initAdapter() {
        if (this.mAdapter != null) {
            for (int i3 = 1; i3 < this.mAdapter.getItemCount() - 1; i3++) {
                ImageView imageView = (ImageView) this.mLayoutManager.findViewByPosition(i3);
                if (imageView != null) {
                    imageView.setImageBitmap(null);
                    imageView.setImageDrawable(null);
                    imageView.setImageDrawable(this.mDefaultImgBg);
                }
            }
            this.mAdapter = null;
            this.mRecycleView.setAdapter(null);
            CoverProvider coverProvider = this.mCoverProvider;
            if (coverProvider != null) {
                coverProvider.release();
                this.mCoverProvider.setCoverListener(null);
                this.mCoverProvider = null;
            }
        }
        RecyclerView.Adapter adapter = new RecyclerView.Adapter() { // from class: com.tencent.qcircle.tavcut.timeline.TimelineView.4
            @Override // android.support.v7.widget.RecyclerView.Adapter
            public int getItemCount() {
                return TimelineView.this.mItemCount + 2;
            }

            @Override // android.support.v7.widget.RecyclerView.Adapter
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i16) {
                ((ViewHolder) viewHolder).setCover();
                ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
                if (layoutParams != null) {
                    if (i16 == 0) {
                        layoutParams.width = TimelineView.this.mHeadItemWidth;
                    } else if (i16 == TimelineView.this.mItemCount + 1) {
                        layoutParams.width = TimelineView.this.mTailItemWidth;
                    } else if (i16 == TimelineView.this.mItemCount) {
                        layoutParams.width = TimelineView.this.mLastItemWidth;
                    } else {
                        layoutParams.width = TimelineView.this.mItemWidth;
                    }
                    viewHolder.itemView.setBackgroundColor(0);
                    viewHolder.itemView.setLayoutParams(layoutParams);
                }
                EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i16, getItemId(i16));
            }

            @Override // android.support.v7.widget.RecyclerView.Adapter
            @NonNull
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i16) {
                ImageView imageView2 = new ImageView(viewGroup.getContext());
                imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView2.setLayoutParams(new ViewGroup.LayoutParams(TimelineView.this.mItemWidth, -1));
                return new ViewHolder(imageView2);
            }
        };
        this.mAdapter = adapter;
        this.mRecycleView.setAdapter(adapter);
        scrollToStart();
    }

    private void initConfig() {
        this.mLeftSliderOffset = (int) Util.dp2px(getContext(), 16.0f);
        this.mRightSliderOffset = (int) Util.dp2px(getContext(), 16.0f);
        this.mPaddingLeft = (int) Util.dp2px(getContext(), 17.0f);
        this.mPaddingTop = (int) Util.dp2px(getContext(), 12.5f);
        this.mPaddingRight = (int) Util.dp2px(getContext(), 17.0f);
        this.mPaddingBottom = (int) Util.dp2px(getContext(), 12.5f);
        this.mLeftGradientMaskWidth = this.mLeftSliderOffset;
        this.mRightMaskWidth = this.mRightSliderOffset;
        this.mSliderBarWidth = (int) Util.dp2px(getContext(), 17.0f);
    }

    private void initHeadAndTailParams() {
        int i3;
        boolean z16 = this.mSliderBarMode;
        int i16 = 0;
        if (z16) {
            i3 = (int) (this.mLeftSliderOffset + this.mSliderBarWidth);
        } else {
            i3 = 0;
        }
        this.mHeadItemWidth = i3;
        if (z16) {
            i16 = (int) (this.mRightSliderOffset + this.mSliderBarWidth);
        }
        this.mTailItemWidth = i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initItemParams() {
        this.mItemWidth = this.mSliderView.getSelectAreaWidth() / this.selectAreaItemCount;
        this.mItemHeight = (getMeasuredHeight() - this.mPaddingTop) - this.mPaddingBottom;
        Logger.d(TAG, "setClipData: mSliderView.getSelectAreaWidth() " + this.mSliderView.getSelectAreaWidth());
        Logger.d(TAG, "setClipData: mItemWidth is " + this.mItemWidth);
        Logger.d(TAG, "setClipData: mItemHeight is " + this.mItemHeight);
        if (!this.mLockMode && this.mSliderBarMode) {
            long min = Math.min(60000L, getCurrentTotalDurationMs());
            this.mMaxSelectDurationMs = min;
            this.mItemDurationMs = min / this.selectAreaItemCount;
        } else {
            this.mItemDurationMs = this.mSelectDurationMs / this.selectAreaItemCount;
        }
        Logger.d(TAG, "setClipData: mItemDurationMs is  " + this.mItemDurationMs);
        Logger.d(TAG, "setClipData: mSelectDurationMs is " + this.mSelectDurationMs);
        if (this.mItemDurationMs != 0) {
            this.mItemCount = (int) (getCurrentTotalDurationMs() / this.mItemDurationMs);
            long currentTotalDurationMs = getCurrentTotalDurationMs() % this.mItemDurationMs;
            if (currentTotalDurationMs != 0) {
                int i3 = this.mItemWidth;
                int i16 = (int) ((((((float) currentTotalDurationMs) * 1.0f) * this.selectAreaItemCount) * i3) / ((float) this.mMaxSelectDurationMs));
                this.mLastItemWidth = i16;
                if (i16 == 0) {
                    this.mLastItemWidth = i3;
                } else {
                    this.mItemCount++;
                }
            } else {
                this.mLastItemWidth = this.mItemWidth;
            }
            Logger.d(TAG, "setClipData: mItemCount is " + this.mItemCount);
            initAdapter();
            initProvider(this.mTavSource);
            post(new Runnable() { // from class: com.tencent.qcircle.tavcut.timeline.TimelineView.3
                @Override // java.lang.Runnable
                public void run() {
                    TimelineView.this.setSliderBarPosition();
                    TimelineView.this.correctParams();
                    TimelineView.this.setSliderConfig();
                    TimelineView.this.updateMask();
                }
            });
        }
    }

    private void initMask() {
        this.mLeftGradientMaskIv = new ImageView(getContext());
        this.mLeftMaskIv = new ImageView(getContext());
        this.mRightMaskIv = new ImageView(getContext());
        initMaskParams();
        this.mLeftGradientMaskIv.setImageDrawable(this.mGradientMask);
        this.mLeftGradientMaskIv.setPadding(0, this.mPaddingTop, 0, this.mPaddingBottom);
        this.mLeftGradientMaskIv.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.mLeftGradientMaskIv);
        this.mLeftMaskIv.setImageDrawable(this.mLeftTimelineMask);
        this.mLeftMaskIv.setPadding(0, this.mPaddingTop, 0, this.mPaddingBottom);
        this.mLeftMaskIv.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.mLeftMaskIv);
        this.mRightMaskIv.setImageDrawable(this.mRightTimelineMask);
        this.mRightMaskIv.setPadding(0, this.mPaddingTop, 0, this.mPaddingBottom);
        this.mRightMaskIv.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.mRightMaskIv);
    }

    private void initMaskParams() {
        ImageView imageView = this.mLeftGradientMaskIv;
        if (imageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.mLeftGradientMaskWidth, -1, 8388627);
            }
            layoutParams.width = this.mLeftGradientMaskWidth;
            layoutParams.leftMargin = this.mLeftGradientMaskMargin;
            this.mLeftGradientMaskIv.setLayoutParams(layoutParams);
        }
        ImageView imageView2 = this.mLeftMaskIv;
        if (imageView2 != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView2.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(this.mLeftMaskWidth, -1, 8388627);
            }
            layoutParams2.width = this.mLeftMaskWidth;
            layoutParams2.leftMargin = this.mLeftMaskMargin;
            this.mLeftMaskIv.setLayoutParams(layoutParams2);
        }
        ImageView imageView3 = this.mRightMaskIv;
        if (imageView3 != null) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) imageView3.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new FrameLayout.LayoutParams(this.mRightMaskWidth, -1, 8388629);
            }
            layoutParams3.width = this.mRightMaskWidth;
            layoutParams3.rightMargin = this.mRightMaskMargin;
            this.mRightMaskIv.setLayoutParams(layoutParams3);
        }
    }

    private void initProvider(TAVSource tAVSource) {
        CoverProvider coverProvider = new CoverProvider();
        this.mCoverProvider = coverProvider;
        coverProvider.setCoverListener(new CoverListener() { // from class: com.tencent.qcircle.tavcut.timeline.TimelineView.5
            @Override // com.tencent.qcircle.tavcut.cover.CoverListener
            public void onCover(final int i3, final Bitmap bitmap) {
                TimelineView.this.post(new Runnable() { // from class: com.tencent.qcircle.tavcut.timeline.TimelineView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ImageView imageView = (ImageView) TimelineView.this.mLayoutManager.findViewByPosition(i3 + 1);
                        if (imageView != null) {
                            try {
                                Bitmap bitmap2 = bitmap;
                                if (bitmap2 != null && !bitmap2.isRecycled()) {
                                    imageView.setImageBitmap(bitmap);
                                }
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
        this.mCoverProvider.init(tAVSource, this.mItemDurationMs, this.mItemCount, this.mItemWidth, this.mItemHeight);
        getCoverInsideScreen();
    }

    private void initRecycleView() {
        this.mLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.mRecycleView = new RecyclerView(getContext());
        initRecycleViewParams();
        this.mRecycleView.setOverScrollMode(2);
        this.mRecycleView.setLayoutManager(this.mLayoutManager);
        this.mRecycleView.setItemViewCacheSize(0);
        this.mRecycleView.setItemAnimator(null);
        this.mRecycleView.setHasFixedSize(true);
        this.mRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qcircle.tavcut.timeline.TimelineView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                if (!TimelineView.this.mScrollEnable) {
                    return;
                }
                Logger.d(TimelineView.TAG, "onScrollStateChanged: newState is " + i3);
                boolean z16 = true;
                if (i3 == 0) {
                    TimelineView.this.getCoverInsideScreen();
                } else {
                    if (i3 == 1) {
                        TimelineView.this.hasEditStartAndEnd = true;
                    }
                    z16 = false;
                }
                TimelineView.this.updateSelection(z16);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
                TimelineView.this.updateMask();
            }
        });
        addView(this.mRecycleView);
    }

    private void initRecycleViewParams() {
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRecycleView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 16);
        }
        this.mRecycleView.setLayoutParams(layoutParams);
        boolean z16 = this.mSliderBarMode;
        int i16 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = this.mPaddingLeft;
        }
        if (!z16) {
            i16 = this.mPaddingRight;
        }
        this.mRecycleView.setPadding(i3, this.mPaddingTop, i16, this.mPaddingBottom);
    }

    private void initSlider() {
        initSliderParams();
        this.mSliderView.setSliderChangeListener(new SliderChangeListener() { // from class: com.tencent.qcircle.tavcut.timeline.TimelineView.2
            @Override // com.tencent.qcircle.tavcut.timeline.SliderChangeListener
            public void onIndicatorMove(long j3) {
            }

            @Override // com.tencent.qcircle.tavcut.timeline.SliderChangeListener
            public void onIndicatorPress() {
                TimelineView.this.notifyIndicatorPress();
            }

            @Override // com.tencent.qcircle.tavcut.timeline.SliderChangeListener
            public void onIndicatorRelease() {
                TimelineView.this.notifyIndicatorRelease();
            }

            @Override // com.tencent.qcircle.tavcut.timeline.SliderChangeListener
            public void onSliderBarMove(boolean z16, float f16, float f17) {
                TimelineView timelineView = TimelineView.this;
                timelineView.hasEditStartAndEnd = true;
                timelineView.checkCanAdjust();
                TimelineView.this.handleSliderBarMove(f16, f17);
                TimelineView.this.notifySliderBarMove(z16, f16, f17);
                TimelineView.this.notifySelectionChange(false);
            }

            @Override // com.tencent.qcircle.tavcut.timeline.SliderChangeListener
            public void onSliderBarRelease(boolean z16) {
                TimelineView timelineView = TimelineView.this;
                timelineView.hasEditStartAndEnd = true;
                timelineView.checkCanAdjust();
                TimelineView.this.setSliderSelectDuration();
                TimelineView.this.notifySliderBarRelease(z16);
                TimelineView.this.notifySelectionChange(true);
            }

            @Override // com.tencent.qcircle.tavcut.timeline.SliderChangeListener
            public void onIndicatorMove(float f16) {
                TimelineView.this.notifyIndicatorMove(f16);
            }

            @Override // com.tencent.qcircle.tavcut.timeline.SliderChangeListener
            public void onSelectionChange(long j3, long j16, boolean z16) {
            }
        });
        addView(this.mSliderView);
    }

    private void initSliderParams() {
        int i3;
        int i16;
        int i17;
        SliderView sliderView = this.mSliderView;
        if (sliderView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) sliderView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            boolean z16 = this.mSliderBarMode;
            int i18 = 0;
            if (z16) {
                i3 = this.mLeftSliderOffset;
            } else {
                i3 = 0;
            }
            if (z16) {
                i16 = this.mRightSliderOffset;
            } else {
                i16 = 0;
            }
            layoutParams.leftMargin = i3;
            layoutParams.rightMargin = i16;
            this.mSliderView.setLayoutParams(layoutParams);
            boolean z17 = this.mSliderBarMode;
            if (z17) {
                i17 = 0;
            } else {
                i17 = this.mPaddingLeft;
            }
            if (!z17) {
                i18 = this.mPaddingRight;
            }
            SliderView sliderView2 = this.mSliderView;
            sliderView2.setPadding(i17, sliderView2.getPaddingTop(), i18, this.mSliderView.getPaddingBottom());
        }
    }

    private void initView(int i3, int i16, int i17, int i18) {
        initConfig();
        initRecycleView();
        initMask();
        this.mSliderView = new SliderView(getContext(), i3, i16, i17, i18);
        initSlider();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyIndicatorMove(float f16) {
        this.mIndicatorProgress = f16;
        this.mPlayDurationMs = (((float) this.mSelectDurationMs) * f16) + ((float) this.mStartDurationMs);
        syncPlayerTimeWithIndicatorPosition();
        Logger.d(TAG, "notifyIndicatorMove: playDurationMs is " + this.mPlayDurationMs);
        SliderChangeListener sliderChangeListener = this.mSliderChangeListener;
        if (sliderChangeListener != null) {
            sliderChangeListener.onIndicatorMove(this.mPlayDurationMs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyIndicatorPress() {
        SliderChangeListener sliderChangeListener = this.mSliderChangeListener;
        if (sliderChangeListener != null) {
            sliderChangeListener.onIndicatorPress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyIndicatorRelease() {
        Logger.d(TAG, "notifyIndicator Release");
        SliderChangeListener sliderChangeListener = this.mSliderChangeListener;
        if (sliderChangeListener != null) {
            sliderChangeListener.onIndicatorRelease();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySelectionChange(boolean z16) {
        SliderChangeListener sliderChangeListener = this.mSliderChangeListener;
        if (sliderChangeListener != null) {
            sliderChangeListener.onSelectionChange(this.mStartDurationMs, this.mEndDurationMs, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySliderBarMove(boolean z16, float f16, float f17) {
        SliderChangeListener sliderChangeListener = this.mSliderChangeListener;
        if (sliderChangeListener != null) {
            sliderChangeListener.onSliderBarMove(z16, f16, f17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySliderBarRelease(boolean z16) {
        SliderChangeListener sliderChangeListener = this.mSliderChangeListener;
        if (sliderChangeListener != null) {
            sliderChangeListener.onSliderBarRelease(z16);
        }
    }

    private void scrollToStart() {
        if (getCurrentTotalDurationMs() == 0) {
            return;
        }
        float currentTotalDurationMs = ((this.mItemCount * 1.0f) * ((float) this.mStartDurationMs)) / ((float) getCurrentTotalDurationMs());
        Log.d("lingeng", "scrollToStart:  startIndex = " + currentTotalDurationMs);
        this.mRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qcircle.tavcut.timeline.TimelineView.7
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
                super.onScrolled(recyclerView, i3, i16);
                Log.d("lingeng_ui", "onScrolled:  dx = " + i3);
            }
        });
        Log.d("lingeng_ui", "canScrollRight: " + this.mRecycleView.canScrollHorizontally(1) + " canScrollLeft:" + this.mRecycleView.canScrollHorizontally(-1));
        this.mLayoutManager.scrollToPositionWithOffset((int) currentTotalDurationMs, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSliderBarPosition() {
        int i3;
        if (this.mMaxSelectDurationMs == this.mSelectDurationMs) {
            this.mSelectAreaLeft = this.mSliderBarWidth;
            float width = (getWidth() - this.mLeftSliderOffset) - this.mRightSliderOffset;
            float f16 = this.mSliderBarWidth;
            float f17 = width - f16;
            this.mSelectAreaRight = f17;
            SliderView sliderView = this.mSliderView;
            if (sliderView != null) {
                sliderView.setSliderBarPosition(this.mSelectAreaLeft - f16, f17);
                return;
            }
            return;
        }
        Log.d(TAG, "setSliderBarPosition: mSliderView.getLeft() = " + this.mSliderView.getLeft());
        Log.d(TAG, "setSliderBarPosition: mSliderView.getWidth() = " + this.mSliderView.getWidth());
        int findFirstCompletelyVisibleItemPosition = this.mLayoutManager.findFirstCompletelyVisibleItemPosition();
        View findViewByPosition = this.mLayoutManager.findViewByPosition(findFirstCompletelyVisibleItemPosition);
        if (findFirstCompletelyVisibleItemPosition < 0) {
            this.mSelectAreaLeft = (((((float) this.mStartDurationMs) * 1.0f) * this.mItemWidth) / ((this.selectAreaItemCount * 1.0f) / ((float) this.mMaxSelectDurationMs))) + this.mSliderBarWidth;
        }
        if (findViewByPosition != null) {
            i3 = findViewByPosition.getLeft();
        } else {
            i3 = 0;
        }
        if (findFirstCompletelyVisibleItemPosition == 0) {
            this.mSelectAreaLeft = ((((((float) this.mStartDurationMs) * 1.0f) * this.mItemWidth) * this.selectAreaItemCount) / ((float) this.mMaxSelectDurationMs)) + this.mSliderBarWidth;
        } else if (findFirstCompletelyVisibleItemPosition == 1) {
            this.mSelectAreaLeft = (((((((float) this.mStartDurationMs) * 1.0f) * this.mItemWidth) * this.selectAreaItemCount) / ((float) this.mMaxSelectDurationMs)) + i3) - this.mLeftSliderOffset;
        } else if (findFirstCompletelyVisibleItemPosition > 0) {
            float f18 = (float) this.mStartDurationMs;
            int i16 = this.mItemWidth;
            long j3 = this.mItemDurationMs;
            this.mSelectAreaLeft = ((((f18 - ((((((findFirstCompletelyVisibleItemPosition - 1) * i16) - i3) * 1.0f) * ((float) j3)) / i16)) * 1.0f) * i16) / ((float) j3)) - this.mLeftSliderOffset;
        }
        float f19 = this.mSelectAreaLeft;
        long j16 = this.mSelectDurationMs;
        int i17 = this.mItemWidth;
        int i18 = this.selectAreaItemCount;
        long j17 = this.mMaxSelectDurationMs;
        float f26 = f19 + ((((((float) j16) * 1.0f) * i17) * i18) / ((float) j17));
        this.mSelectAreaRight = f26;
        float f27 = f26 - ((((((float) j16) * 1.0f) * i17) * i18) / ((float) j17));
        this.mSelectAreaLeft = f27;
        this.mSelectAreaLeft = Math.max(f27, this.mSliderBarWidth);
        float min = Math.min(this.mSelectAreaRight, ((getWidth() - this.mLeftSliderOffset) - this.mRightSliderOffset) - this.mSliderBarWidth);
        this.mSelectAreaRight = min;
        SliderView sliderView2 = this.mSliderView;
        if (sliderView2 != null) {
            sliderView2.setSliderBarPosition(this.mSelectAreaLeft - this.mSliderBarWidth, min);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSliderConfig() {
        setSliderMinSelectionWidth();
        setSliderMaxSelectionWidth();
        setSliderMaxSelectDuration();
        setSliderTotalDuration();
        setSliderSelectDuration();
    }

    private void setSliderMaxSelectDuration() {
        SliderView sliderView = this.mSliderView;
        if (sliderView != null) {
            sliderView.setMaxSelectDuration(this.mMaxSelectDurationMs);
        }
    }

    private void setSliderMaxSelectionWidth() {
        SliderView sliderView = this.mSliderView;
        if (sliderView != null && !this.mLockMode && this.mSliderBarMode) {
            sliderView.setMaxSelectAreaWidth(this.mItemWidth * this.selectAreaItemCount);
        }
    }

    private void setSliderMinSelectionWidth() {
        SliderView sliderView = this.mSliderView;
        if (sliderView != null && !this.mLockMode && this.mSliderBarMode) {
            sliderView.setMinSelectAreaWidth((int) ((((this.mSpeed * ((float) this.mMinSelectDurationMs)) * this.mItemWidth) * this.selectAreaItemCount) / ((float) this.mOriginMaxSelectDurationMs)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSliderSelectDuration() {
        SliderView sliderView = this.mSliderView;
        if (sliderView != null) {
            sliderView.setSelectDuration(Long.valueOf(this.mSelectDurationMs));
        }
    }

    private void setSliderTotalDuration() {
        SliderView sliderView = this.mSliderView;
        if (sliderView != null) {
            sliderView.setTotalDurationMs(getCurrentTotalDurationMs());
        }
    }

    private boolean shouldSyncIndicatorPositionWithPlayerTime() {
        if (this.mSliderView.isDragging() || this.mSliderView.isIndicatorMoving() || this.mPlayer.getCurrentStatus() == IPlayer.PlayerStatus.PAUSED) {
            return false;
        }
        return true;
    }

    private void syncIndicatorPositionWithPlayerTime() {
        MoviePlayer moviePlayer = this.mPlayer;
        if (moviePlayer == null) {
            return;
        }
        setPlayPosition(moviePlayer.getPosition().getTimeUs() / 1000);
    }

    private void syncPlayerTimeWithIndicatorPosition() {
        if (this.mPlayer == null) {
            Log.e(TAG, "syncPlayerTimeWithIndicatorPosition: mPlayer is null!");
            return;
        }
        this.mPlayer.seekToTime(CMTime.convertTimeScale(CMTime.fromUs(this.mPlayer.getPlayRange().getStartUs() + (((float) r0.getPlayRange().getDurationUs()) * this.mSliderView.getIndicatorProgress())), 1000));
    }

    private void updateClipData() {
        boolean z16;
        if (getCurrentTotalDurationMs() != this.mMaxSelectDurationMs) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mScrollEnable = z16;
        post(new Runnable() { // from class: com.tencent.qcircle.tavcut.timeline.TimelineView.8
            @Override // java.lang.Runnable
            public void run() {
                TimelineView.this.initItemParams();
            }
        });
    }

    private void updateEndDuration() {
        long j3 = this.mStartDurationMs + this.mSelectDurationMs;
        this.mEndDurationMs = j3;
        long min = Math.min(j3, getCurrentTotalDurationMs());
        this.mEndDurationMs = min;
        this.mStartDurationMs = min - this.mSelectDurationMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMask() {
        int i3;
        int i16;
        int i17;
        int i18;
        SliderView sliderView;
        int i19;
        SliderView sliderView2;
        int i26 = 8;
        if (this.mSelectDurationMs != this.mTotalDurationMs && this.mShowMask) {
            if (this.mSelectAreaLeft == 0.0f && (sliderView2 = this.mSliderView) != null && sliderView2.getLeftBarIv() != null) {
                this.mSelectAreaLeft = this.mSliderView.getLeftBarIv().getX() + this.mSliderBarWidth;
            }
            int findFirstCompletelyVisibleItemPosition = this.mLayoutManager.findFirstCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition <= 0) {
                this.mLeftGradientMaskIv.setVisibility(8);
                ImageView imageView = this.mLeftMaskIv;
                if (this.mSelectAreaLeft > this.mSliderBarWidth * 2.0f) {
                    i19 = 0;
                } else {
                    i19 = 8;
                }
                imageView.setVisibility(i19);
                SliderView sliderView3 = this.mSliderView;
                if (sliderView3 != null && sliderView3.getLeftBarIv() != null) {
                    this.mLeftMaskWidth = (int) (this.mSliderView.getLeftBarIv().getX() - this.mSliderBarWidth);
                } else {
                    this.mLeftMaskWidth = (int) (this.mSelectAreaLeft - (this.mSliderBarWidth * 2.0f));
                }
                this.mLeftMaskMargin = (int) (this.mLeftSliderOffset + this.mSliderBarWidth);
            } else if (findFirstCompletelyVisibleItemPosition == 1) {
                View findViewByPosition = this.mLayoutManager.findViewByPosition(findFirstCompletelyVisibleItemPosition);
                if (findViewByPosition == null) {
                    return;
                }
                int left = findViewByPosition.getLeft();
                ImageView imageView2 = this.mLeftMaskIv;
                if (this.mSelectAreaLeft > this.mSliderBarWidth) {
                    i17 = 0;
                } else {
                    i17 = 8;
                }
                imageView2.setVisibility(i17);
                if (left > this.mLeftSliderOffset) {
                    this.mLeftGradientMaskIv.setVisibility(8);
                    int i27 = (int) (((this.mSelectAreaLeft - this.mSliderBarWidth) - left) + this.mLeftSliderOffset);
                    this.mLeftMaskWidth = i27;
                    this.mLeftMaskMargin = left;
                    ImageView imageView3 = this.mLeftMaskIv;
                    if (i27 > 0) {
                        i18 = 0;
                    } else {
                        i18 = 8;
                    }
                    imageView3.setVisibility(i18);
                } else {
                    if (left < 0) {
                        left = 0;
                    }
                    this.mLeftGradientMaskIv.setVisibility(0);
                    int i28 = this.mLeftSliderOffset;
                    this.mLeftGradientMaskWidth = i28 - left;
                    this.mLeftGradientMaskMargin = left;
                    this.mLeftMaskWidth = (int) (this.mSelectAreaLeft - this.mSliderBarWidth);
                    this.mLeftMaskMargin = i28;
                }
            } else if (findFirstCompletelyVisibleItemPosition > 1) {
                this.mLeftGradientMaskIv.setVisibility(0);
                this.mLeftGradientMaskWidth = this.mLeftSliderOffset;
                this.mLeftGradientMaskMargin = 0;
                ImageView imageView4 = this.mLeftMaskIv;
                if (this.mSelectAreaLeft > this.mSliderBarWidth) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                imageView4.setVisibility(i3);
                int i29 = (int) (this.mSelectAreaLeft - this.mSliderBarWidth);
                this.mLeftMaskWidth = i29;
                ImageView imageView5 = this.mLeftMaskIv;
                if (i29 > 0) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                imageView5.setVisibility(i16);
                this.mLeftMaskMargin = this.mLeftSliderOffset;
            }
            int findLastCompletelyVisibleItemPosition = this.mLayoutManager.findLastCompletelyVisibleItemPosition();
            if (this.mSelectAreaRight == 0.0f && (sliderView = this.mSliderView) != null && sliderView.getRightBarIv() != null) {
                this.mSelectAreaRight = this.mSliderView.getRightBarIv().getX();
            }
            int i36 = this.mItemCount;
            if (findLastCompletelyVisibleItemPosition == i36 + 1) {
                ImageView imageView6 = this.mRightMaskIv;
                if (((getWidth() - this.mSelectAreaRight) - (this.mSliderBarWidth * 2.0f)) - this.mLeftSliderOffset > this.mRightSliderOffset) {
                    i26 = 0;
                }
                imageView6.setVisibility(i26);
                float width = getWidth() - this.mSelectAreaRight;
                float f16 = this.mSliderBarWidth;
                int i37 = this.mRightSliderOffset;
                this.mRightMaskWidth = (int) (((width - (2.0f * f16)) - this.mLeftSliderOffset) - i37);
                if (this.mSelectDurationMs == this.mMaxSelectDurationMs) {
                    this.mRightMaskWidth = i37;
                }
                this.mRightMaskMargin = (int) (i37 + f16);
            } else if (findLastCompletelyVisibleItemPosition == i36) {
                View findViewByPosition2 = this.mLayoutManager.findViewByPosition(findLastCompletelyVisibleItemPosition);
                if (findViewByPosition2 == null) {
                    return;
                }
                int width2 = getWidth() - findViewByPosition2.getRight();
                this.mRightMaskIv.setVisibility(0);
                this.mRightMaskWidth = (int) ((((getWidth() - this.mSelectAreaRight) - this.mSliderBarWidth) - this.mLeftSliderOffset) - width2);
                if (this.mSelectDurationMs == this.mMaxSelectDurationMs) {
                    this.mRightMaskWidth = this.mRightSliderOffset - width2;
                }
                this.mRightMaskMargin = width2;
                ImageView imageView7 = this.mRightMaskIv;
                if (this.mRightMaskWidth > 0) {
                    i26 = 0;
                }
                imageView7.setVisibility(i26);
            } else if (findLastCompletelyVisibleItemPosition < i36) {
                this.mRightMaskIv.setVisibility(0);
                this.mRightMaskWidth = (int) (((getWidth() - this.mSelectAreaRight) - this.mSliderBarWidth) - this.mLeftSliderOffset);
                if (this.mSelectDurationMs == this.mMaxSelectDurationMs) {
                    this.mRightMaskWidth = this.mRightSliderOffset;
                }
                ImageView imageView8 = this.mRightMaskIv;
                if (this.mRightMaskWidth > 0) {
                    i26 = 0;
                }
                imageView8.setVisibility(i26);
                this.mRightMaskMargin = 0;
            }
            initMaskParams();
            return;
        }
        this.mLeftGradientMaskIv.setVisibility(8);
        this.mLeftMaskIv.setVisibility(8);
        this.mRightMaskIv.setVisibility(8);
    }

    private void updateSelectDuration() {
        float f16 = this.mSelectAreaRight - this.mSelectAreaLeft;
        Logger.d(TAG, "updateSelectDuration: selectWidth" + f16);
        Logger.d(TAG, "updateSelectDuration: mSelectAreaRight" + this.mSelectAreaRight);
        Logger.d(TAG, "updateSelectDuration: mSelectAreaLeft" + this.mSelectAreaLeft);
        if (FloatUtils.isEquals(f16, (getWidth() - this.mHeadItemWidth) - this.mTailItemWidth)) {
            this.mSelectDurationMs = this.mMaxSelectDurationMs;
        } else {
            this.mSelectDurationMs = (long) Math.ceil((((float) this.mMaxSelectDurationMs) * f16) / (this.selectAreaItemCount * this.mItemWidth));
        }
        long min = Math.min(this.mSelectDurationMs, this.mMaxSelectDurationMs);
        this.mSelectDurationMs = min;
        if (!this.mLockMode && this.mSliderBarMode) {
            this.mSelectDurationMs = Math.max(min, this.mMinSelectDurationMs);
            this.mSpeedSelectDurationMs = ((float) r0) / this.mSpeed;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelection(boolean z16) {
        updateSelectDuration();
        updateStartDuration();
        updateEndDuration();
        setSliderSelectDuration();
        updateMask();
        long j3 = ((float) this.mStartDurationMs) + (((float) this.mSelectDurationMs) * this.mIndicatorProgress);
        this.mPlayDurationMs = j3;
        long j16 = this.mTotalDurationMs;
        if (j3 > j16) {
            this.mPlayDurationMs = j16;
        }
        notifySelectionChange(z16);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateStartDuration() {
        int i3;
        float f16;
        float f17;
        int findFirstCompletelyVisibleItemPosition = this.mLayoutManager.findFirstCompletelyVisibleItemPosition();
        int i16 = 0;
        if (findFirstCompletelyVisibleItemPosition < 0) {
            i3 = (int) (this.mSelectAreaLeft - this.mSliderBarWidth);
        } else {
            i3 = 0;
        }
        View findViewByPosition = this.mLayoutManager.findViewByPosition(findFirstCompletelyVisibleItemPosition);
        if (findViewByPosition != null) {
            i16 = findViewByPosition.getLeft();
        }
        if (findFirstCompletelyVisibleItemPosition == 0) {
            f16 = this.mSelectAreaLeft;
            f17 = this.mSliderBarWidth;
        } else {
            if (findFirstCompletelyVisibleItemPosition > 0) {
                f16 = ((this.mHeadItemWidth + ((findFirstCompletelyVisibleItemPosition - 1) * this.mItemWidth)) - i16) + this.mSelectAreaLeft;
                f17 = this.mSliderBarWidth;
            }
            this.mStartDurationMs = (((float) (i3 * this.mMaxSelectDurationMs)) * 1.0f) / (this.mItemWidth * this.selectAreaItemCount);
            Log.d(TAG, "updateStartDuration: startOffset = " + i3 + "\n mMaxSelectDurationMs = " + this.mMaxSelectDurationMs + "\n mItemWidth = " + this.mItemWidth + "\n selectAreaItemCount = " + this.selectAreaItemCount + "\n ************\n mStartDurationMs = " + this.mStartDurationMs);
            if (this.mStartDurationMs >= 0) {
                this.mStartDurationMs = 0L;
                return;
            }
            return;
        }
        i3 = (int) (f16 - f17);
        this.mStartDurationMs = (((float) (i3 * this.mMaxSelectDurationMs)) * 1.0f) / (this.mItemWidth * this.selectAreaItemCount);
        Log.d(TAG, "updateStartDuration: startOffset = " + i3 + "\n mMaxSelectDurationMs = " + this.mMaxSelectDurationMs + "\n mItemWidth = " + this.mItemWidth + "\n selectAreaItemCount = " + this.selectAreaItemCount + "\n ************\n mStartDurationMs = " + this.mStartDurationMs);
        if (this.mStartDurationMs >= 0) {
        }
    }

    public void bindPlayer(MoviePlayer moviePlayer) {
        this.mPlayer = moviePlayer;
        moviePlayer.addPlayerListener(this);
    }

    public long getCurrentTotalDurationMs() {
        return ((float) this.mTotalDurationMs) / this.mSpeed;
    }

    public long getPlayPosition() {
        return this.mPlayDurationMs;
    }

    public int getRecyclerViewPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getRecyclerViewPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getRecyclerViewPaddingRight() {
        return this.mPaddingRight;
    }

    public int getRecyclerViewPaddingTop() {
        return this.mPaddingTop;
    }

    public int getSelectAreaItemCount() {
        return this.selectAreaItemCount;
    }

    @Override // com.tencent.tav.player.IPlayer.PlayerListener
    public void onPositionChanged(CMTime cMTime) {
        if (shouldSyncIndicatorPositionWithPlayerTime()) {
            syncIndicatorPositionWithPlayerTime();
        }
    }

    public void release() {
        this.mScrollEnable = false;
        CoverProvider coverProvider = this.mCoverProvider;
        if (coverProvider != null) {
            coverProvider.release();
        }
        SliderView sliderView = this.mSliderView;
        if (sliderView != null) {
            sliderView.release();
        }
        this.mSliderChangeListener = null;
    }

    public void setClipData(TAVSource tAVSource, long j3, long j16, long j17) {
        boolean z16;
        this.mTavSource = tAVSource;
        this.mTotalDurationMs = j3;
        this.mStartDurationMs = j16;
        this.mEndDurationMs = j17;
        long min = Math.min(j3, this.mMaxSelectDurationMs);
        this.mMaxSelectDurationMs = min;
        long min2 = Math.min(this.mEndDurationMs - this.mStartDurationMs, min);
        this.mSelectDurationMs = min2;
        this.mSpeedSelectDurationMs = min2;
        if (this.mTotalDurationMs != min2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mScrollEnable = z16;
        post(new Runnable() { // from class: com.tencent.qcircle.tavcut.timeline.TimelineView.9
            @Override // java.lang.Runnable
            public void run() {
                TimelineView.this.initItemParams();
            }
        });
    }

    public void setDurationBgRes(int i3) {
        this.mSliderView.setDurationBgRes(i3);
    }

    public void setIndicatorRes(int i3) {
        this.mSliderView.setIndicatorRes(i3);
    }

    public void setMediaModel(MediaModel mediaModel) {
        this.mMediaModel = mediaModel;
    }

    public void setPlayPosition(long j3) {
        if (this.mSelectDurationMs == 0 || this.mPlayDurationMs == j3) {
            return;
        }
        this.mPlayDurationMs = j3;
        if (j3 > getCurrentTotalDurationMs() + this.mStartDurationMs) {
            this.mPlayDurationMs = getCurrentTotalDurationMs() + this.mStartDurationMs;
        }
        float f16 = (((float) (this.mPlayDurationMs - this.mStartDurationMs)) * 1.0f) / ((float) this.mSelectDurationMs);
        this.mIndicatorProgress = f16;
        SliderView sliderView = this.mSliderView;
        if (sliderView != null) {
            sliderView.setIndicatorProgress(f16);
        }
    }

    public void setRecyclerViewPadding(int i3, int i16, int i17, int i18) {
        this.mPaddingLeft = i3;
        this.mPaddingTop = i16;
        this.mPaddingRight = i17;
        this.mPaddingBottom = i18;
        this.mRecycleView.setPadding(i3, i16, i17, i18);
    }

    public void setSelectAreaItemCount(int i3) {
        this.selectAreaItemCount = i3;
    }

    public void setShowIndicator(boolean z16) {
        this.mSliderView.setShowIndicator(z16);
    }

    public void setSliderChangeListener(SliderChangeListener sliderChangeListener) {
        this.mSliderChangeListener = sliderChangeListener;
    }

    public void setSliderFrameColor(int i3) {
        this.mSliderView.setFrameColor(i3);
    }

    public void setSpeed(float f16) {
        if (!FloatUtils.isEquals(f16, this.mSpeed) && !FloatUtils.isEquals(0.0f, f16)) {
            this.mSpeed = f16;
            this.mSpeedTotalDurationMs = ((float) this.mTotalDurationMs) / f16;
            if (getCurrentTotalDurationMs() > this.mOriginMaxSelectDurationMs) {
                this.mMaxSelectDurationMs = ((float) r2) * this.mSpeed;
            } else {
                this.mMaxSelectDurationMs = Math.max(this.mTotalDurationMs, this.mMaxSelectDurationMs);
            }
            updateClipData();
        }
    }

    public void setTimelineBuilder(TimelineBuilder timelineBuilder) {
        long maxSelectDurationMs;
        long minSelectDurationMs;
        if (timelineBuilder == null) {
            return;
        }
        if (timelineBuilder.getMaxSelectDurationMs() == -1) {
            maxSelectDurationMs = 60000;
        } else {
            maxSelectDurationMs = timelineBuilder.getMaxSelectDurationMs();
        }
        this.mMaxSelectDurationMs = maxSelectDurationMs;
        this.mOriginMaxSelectDurationMs = maxSelectDurationMs;
        if (timelineBuilder.getMinSelectDurationMs() == -1) {
            minSelectDurationMs = 2000;
        } else {
            minSelectDurationMs = timelineBuilder.getMinSelectDurationMs();
        }
        this.mMinSelectDurationMs = minSelectDurationMs;
        this.mLockMode = timelineBuilder.isLockMode();
        this.mSliderBarMode = timelineBuilder.isSliderBarMode();
        this.mShowMask = timelineBuilder.isShowMask();
        this.mShowDuration = timelineBuilder.isShowDuration();
        this.mMaxDurationTps = timelineBuilder.getMaxDurationTps();
        SliderView sliderView = this.mSliderView;
        if (sliderView != null) {
            sliderView.setLockMode(this.mLockMode);
            this.mSliderView.setSliderBarMode(this.mSliderBarMode);
            this.mSliderView.setShowDuration(this.mShowDuration);
            this.mSliderView.setMaxDurationTips(this.mMaxDurationTps);
            initRecycleViewParams();
            initHeadAndTailParams();
            initSliderParams();
            initMaskParams();
        }
    }

    public void setTypeface(Typeface typeface) {
        this.mSliderView.setTypeface(typeface);
    }

    public void showAllMask(int i3) {
        if (this.allMaskView == null) {
            this.allMaskView = new View(getContext());
        }
        removeView(this.allMaskView);
        this.allMaskView.setBackgroundColor(i3);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
        addView(this.allMaskView, layoutParams);
    }

    public void updateSpeed(float f16) {
        updateSpeed(f16, null);
    }

    public void updateTavSource(TAVSource tAVSource) {
        this.mTavSource = tAVSource;
        post(new Runnable() { // from class: com.tencent.qcircle.tavcut.timeline.TimelineView.6
            @Override // java.lang.Runnable
            public void run() {
                TimelineView.this.initItemParams();
            }
        });
    }

    public void updateTimeRange(long j3, long j16) {
        if (j16 == -1) {
            this.mStartDurationMs = 0L;
            this.mEndDurationMs = this.mTotalDurationMs;
        } else {
            this.mStartDurationMs = j3;
            this.mEndDurationMs = j16;
        }
        post(new Runnable() { // from class: com.tencent.qcircle.tavcut.timeline.TimelineView.11
            @Override // java.lang.Runnable
            public void run() {
                TimelineView.this.initItemParams();
            }
        });
    }

    public void updateTimeRangeAndSource(TAVSource tAVSource, long j3, long j16) {
        boolean z16;
        this.mTavSource = tAVSource;
        if (j16 == -1) {
            this.mStartDurationMs = 0L;
            this.mEndDurationMs = this.mTotalDurationMs;
        } else {
            this.mStartDurationMs = j3;
            this.mEndDurationMs = j16;
        }
        long min = Math.min(this.mEndDurationMs - this.mStartDurationMs, this.mMaxSelectDurationMs);
        this.mSelectDurationMs = min;
        this.mSpeedSelectDurationMs = min;
        if (this.mTotalDurationMs != min) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mScrollEnable = z16;
        post(new Runnable() { // from class: com.tencent.qcircle.tavcut.timeline.TimelineView.10
            @Override // java.lang.Runnable
            public void run() {
                TimelineView.this.initItemParams();
            }
        });
    }

    public TimelineView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void updateSpeed(float f16, SpeedChangeCallback speedChangeCallback) {
        if (FloatUtils.isEquals(f16, this.mSpeed) || FloatUtils.isEquals(0.0f, f16)) {
            return;
        }
        float f17 = f16 / this.mSpeed;
        long currentTotalDurationMs = getCurrentTotalDurationMs();
        long j3 = ((float) this.mSelectDurationMs) / f17;
        long j16 = ((float) currentTotalDurationMs) / f17;
        float f18 = ((float) this.mTotalDurationMs) / f16;
        long j17 = this.mMinSelectDurationMs;
        if (f18 < ((float) j17)) {
            if (f16 == 2.0f && speedChangeCallback != null) {
                speedChangeCallback.onChangeFailed(1000);
                return;
            } else {
                if (f16 != 1.5f || speedChangeCallback == null) {
                    return;
                }
                speedChangeCallback.onChangeFailed(1001);
                return;
            }
        }
        this.mSpeedTotalDurationMs = j16;
        this.mSpeed = f16;
        if (j16 > 60000) {
            this.mMaxSelectDurationMs = 60000L;
            if (this.hasEditStartAndEnd) {
                this.mSpeedSelectDurationMs = Math.min(j3, 60000L);
            } else {
                this.mSpeedSelectDurationMs = 60000L;
            }
            long max = Math.max(this.mSpeedSelectDurationMs, this.mMinSelectDurationMs);
            this.mSelectDurationMs = max;
            long j18 = ((float) this.mStartDurationMs) / f17;
            this.mStartDurationMs = j18;
            this.mEndDurationMs = j18 + max;
            Log.d("updateStartDuration", "updateSpeed: start = " + this.mStartDurationMs);
            Log.d("updateStartDuration", "updateSpeed: end = " + this.mEndDurationMs);
            if (speedChangeCallback != null) {
                speedChangeCallback.onChangeSucc(f16);
            }
            updateClipData();
            notifySelectionChange(true);
        } else {
            this.mMaxSelectDurationMs = j16;
            if (this.hasEditStartAndEnd) {
                this.mSpeedSelectDurationMs = j3;
            } else {
                this.mSpeedSelectDurationMs = j16;
            }
            long max2 = Math.max(this.mSpeedSelectDurationMs, j17);
            this.mSelectDurationMs = max2;
            long j19 = ((float) this.mStartDurationMs) / f17;
            this.mStartDurationMs = j19;
            this.mEndDurationMs = j19 + max2;
            Log.d("updateStartDuration", "updateSpeed: start = " + this.mStartDurationMs);
            Log.d("updateStartDuration", "updateSpeed: end = " + this.mEndDurationMs);
            if (speedChangeCallback != null) {
                speedChangeCallback.onChangeSucc(f16);
            }
            if (currentTotalDurationMs < 60000) {
                setSliderBarPosition();
                updateMask();
                setSliderSelectDuration();
                setSliderMinSelectionWidth();
                setSliderMaxSelectionWidth();
            } else {
                updateClipData();
            }
            notifySelectionChange(true);
        }
        checkCanAdjust();
    }

    public TimelineView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.selectAreaItemCount = 8;
        this.mLockMode = false;
        this.mSliderBarMode = true;
        this.mShowMask = true;
        this.mShowDuration = true;
        this.mIndicatorProgress = 0.0f;
        this.mSpeed = 1.0f;
        this.hasEditStartAndEnd = false;
        initView();
    }

    private void initView() {
        initConfig();
        initRecycleView();
        initMask();
        this.mSliderView = new SliderView(getContext());
        initSlider();
    }

    public TimelineView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        super(context, attributeSet, 0);
        this.selectAreaItemCount = 8;
        this.mLockMode = false;
        this.mSliderBarMode = true;
        this.mShowMask = true;
        this.mShowDuration = true;
        this.mIndicatorProgress = 0.0f;
        this.mSpeed = 1.0f;
        this.hasEditStartAndEnd = false;
        this.mDefaultImgBg = context.getResources().getDrawable(i3);
        this.mGradientMask = context.getResources().getDrawable(i16);
        this.mLeftTimelineMask = context.getResources().getDrawable(i17);
        this.mRightTimelineMask = context.getResources().getDrawable(i17);
        initView(i18, i19, i26, i27);
    }

    @Override // com.tencent.tav.player.IPlayer.PlayerListener
    public void onStatusChanged(IPlayer.PlayerStatus playerStatus) {
    }
}
