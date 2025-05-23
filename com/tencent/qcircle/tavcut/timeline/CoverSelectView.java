package com.tencent.qcircle.tavcut.timeline;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.qcircle.tavcut.R;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.tavcut.timeline.CoverPreviewBar;
import com.tencent.qcircle.tavcut.util.Util;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CoverSelectView extends FrameLayout {
    public static final float TIMELINE_LR_PADDING = 17.0f;
    CoverPreviewBar coverPreviewBar;
    private float currCoverProgress;
    private long maxDurationMs;
    private MoviePlayer player;
    private TAVCutVideoSession tavCutVideoSession;
    TimelineView timelineView;
    private UIConfigWrapper wrapper;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class UIConfigWrapper {
        private static final int DYNAMIC_VALUE = -1;
        Context context;
        private int defaultImgRes;
        private int durationBg;
        private int gradientMaskRes;
        private ImageView ivPreviewBar;
        private int lockLeft;
        private int lockRight;
        private int previewBarWidth;
        private int rangeLeft;
        private int rangeRight;
        private int showItemCount;
        private int timelineMaskRes;
        private int previbarHeight = -1;
        private float coverDefaultProgress = 0.5f;

        public UIConfigWrapper(Context context, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29) {
            this.context = context;
            this.defaultImgRes = i3;
            this.gradientMaskRes = i16;
            this.timelineMaskRes = i17;
            this.lockLeft = i18;
            this.lockRight = i19;
            this.rangeLeft = i26;
            this.rangeRight = i27;
            this.durationBg = i28;
            this.showItemCount = i29;
            this.previewBarWidth = (int) Util.dp2px(context, 40.0f);
        }

        public UIConfigWrapper setCoverDefaultProgress(float f16) {
            this.coverDefaultProgress = f16;
            return this;
        }

        public UIConfigWrapper setPrevibarHeight(int i3) {
            this.previbarHeight = i3;
            return this;
        }

        public UIConfigWrapper setPreviewBar(ImageView imageView) {
            this.ivPreviewBar = imageView;
            return this;
        }

        public UIConfigWrapper setPreviewBarWidth(int i3) {
            this.previewBarWidth = i3;
            return this;
        }
    }

    public CoverSelectView(@NonNull Context context, UIConfigWrapper uIConfigWrapper) {
        super(context);
        this.currCoverProgress = 0.0f;
        this.maxDurationMs = 60000L;
        this.wrapper = uIConfigWrapper;
        initialize();
    }

    private void initCoverPreviewBar() {
        this.coverPreviewBar = new CoverPreviewBar(getContext());
        this.currCoverProgress = this.wrapper.coverDefaultProgress;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.wrapper.previewBarWidth, this.wrapper.previbarHeight);
        layoutParams.gravity = 16;
        this.coverPreviewBar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.coverPreviewBar, layoutParams);
        post(new Runnable() { // from class: com.tencent.qcircle.tavcut.timeline.CoverSelectView.1
            @Override // java.lang.Runnable
            public void run() {
                int recyclerViewPaddingLeft = CoverSelectView.this.timelineView.getRecyclerViewPaddingLeft();
                int recyclerViewPaddingRight = CoverSelectView.this.timelineView.getRecyclerViewPaddingRight();
                CoverSelectView coverSelectView = CoverSelectView.this;
                coverSelectView.coverPreviewBar.initCoverSlider(recyclerViewPaddingLeft, recyclerViewPaddingRight, (coverSelectView.timelineView.getWidth() - recyclerViewPaddingLeft) - recyclerViewPaddingRight, CoverSelectView.this.currCoverProgress);
            }
        });
        this.coverPreviewBar.setOnSliderSlideListener(new CoverPreviewBar.OnPreviewBarSlideListener() { // from class: com.tencent.qcircle.tavcut.timeline.CoverSelectView.2
            @Override // com.tencent.qcircle.tavcut.timeline.CoverPreviewBar.OnPreviewBarSlideListener
            public void onProgressChanged(CoverPreviewBar coverPreviewBar, float f16, int i3) {
                if (CoverSelectView.this.tavCutVideoSession != null && CoverSelectView.this.tavCutVideoSession.getDuration() != null) {
                    float timeSeconds = ((1.0f * f16) / 100.0f) * CoverSelectView.this.tavCutVideoSession.getDuration().getTimeSeconds();
                    if (CoverSelectView.this.player != null) {
                        CoverSelectView.this.player.seekToTime(new CMTime(timeSeconds));
                    }
                    if (CoverSelectView.this.player != null && CoverSelectView.this.player.isPlaying()) {
                        CoverSelectView.this.player.pause();
                    }
                    CoverSelectView.this.currCoverProgress = f16;
                }
            }

            @Override // com.tencent.qcircle.tavcut.timeline.CoverPreviewBar.OnPreviewBarSlideListener
            public void onStartTouchSlide(CoverPreviewBar coverPreviewBar) {
            }

            @Override // com.tencent.qcircle.tavcut.timeline.CoverPreviewBar.OnPreviewBarSlideListener
            public void onStopTouchSlide(CoverPreviewBar coverPreviewBar) {
            }
        });
    }

    private void initTimeLineView() {
        if (this.wrapper == null) {
            this.wrapper = new UIConfigWrapper(getContext(), R.drawable.pic_music_default_w, R.drawable.bg_timeline_mask_gradient, R.drawable.bg_timeline_mask, R.drawable.icon_blockbuster_timeline_range_lock_left, R.drawable.icon_blockbuster_timeline_range_lock_right, R.drawable.icon_blockbuster_timeline_range_left, R.drawable.icon_blockbuster_timeline_range_right, R.drawable.duration_bg, 8);
        }
        this.timelineView = new TimelineView(getContext(), null, this.wrapper.defaultImgRes, this.wrapper.gradientMaskRes, this.wrapper.timelineMaskRes, this.wrapper.lockLeft, this.wrapper.lockRight, this.wrapper.rangeLeft, this.wrapper.rangeRight);
        this.timelineView.setTimelineBuilder(new TimelineBuilder().setMaxSelectDurationMs(this.maxDurationMs).setLockMode(true).setSliderBarMode(false).setShowMask(false).setShowDuration(false).setMaxDurationTps("\u5df2\u8fbe\u5230\u6a21\u677f\u6700\u5927\u65f6\u957f"));
        this.timelineView.setSliderFrameColor(0);
        this.timelineView.setShowIndicator(false);
        this.timelineView.setSelectAreaItemCount(this.wrapper.showItemCount);
        this.timelineView.setDurationBgRes(this.wrapper.durationBg);
        this.timelineView.setRecyclerViewPadding(16, 5, 16, 5);
        this.timelineView.showAllMask(Color.parseColor("#99ffffff"));
        addView(this.timelineView);
    }

    private void initialize() {
        initTimeLineView();
        initCoverPreviewBar();
    }

    public void bindPlayer(MoviePlayer moviePlayer) {
        this.player = moviePlayer;
        TimelineView timelineView = this.timelineView;
        if (timelineView != null) {
            timelineView.bindPlayer(moviePlayer);
        }
        CoverPreviewBar coverPreviewBar = this.coverPreviewBar;
        if (coverPreviewBar != null) {
            coverPreviewBar.bindPlayer(moviePlayer);
        }
    }

    public Bitmap getCurrCoverBitmap() {
        Bitmap currCover = this.coverPreviewBar.getCurrCover();
        CGSize renderSize = this.tavCutVideoSession.getRenderSize();
        return Bitmap.createScaledBitmap(currCover, (int) renderSize.width, (int) renderSize.height, true);
    }

    public float getCurrCoverProgress() {
        return this.currCoverProgress;
    }

    public void release() {
        TimelineView timelineView = this.timelineView;
        if (timelineView != null) {
            timelineView.release();
        }
    }

    public void setClipAndSpeed(float f16, long j3, long j16, long j17) {
        TimelineView timelineView = this.timelineView;
        if (timelineView != null) {
            timelineView.setSpeed(f16);
            this.timelineView.setClipData(this.tavCutVideoSession.getTAVSourceForCover(), j3, ((float) j16) / f16, ((float) j17) / f16);
        }
    }

    public void setCoverPreviewBarBg(Drawable drawable) {
        this.coverPreviewBar.setBackgroundDrawable(drawable);
    }

    public void setMaxDurationMs(long j3) {
        this.maxDurationMs = j3;
    }

    public void setPreviewBar(ImageView imageView) {
        CoverPreviewBar coverPreviewBar = this.coverPreviewBar;
        if (coverPreviewBar != null) {
            coverPreviewBar.setPreviewBarView(imageView);
        }
    }

    public void setPreviewBarElevation(float f16) {
        CoverPreviewBar coverPreviewBar = this.coverPreviewBar;
        if (coverPreviewBar != null) {
            coverPreviewBar.setElevation(f16);
        }
    }

    public void setTimelineBuilder(TimelineBuilder timelineBuilder) {
        TimelineView timelineView = this.timelineView;
        if (timelineView != null) {
            timelineView.setTimelineBuilder(timelineBuilder);
        }
    }

    public void setTimelineViewPadding(int i3, int i16, int i17, int i18) {
        TimelineView timelineView = this.timelineView;
        if (timelineView != null) {
            timelineView.setRecyclerViewPadding(i3, i16, i17, i18);
            this.timelineView.showAllMask(Color.parseColor("#99ffffff"));
            this.coverPreviewBar.initCoverSlider(i3, i17, (this.timelineView.getWidth() - i3) - i17, this.currCoverProgress);
        }
    }

    public void updateTavVideoSession(TAVCutVideoSession tAVCutVideoSession) {
        if (tAVCutVideoSession != null) {
            this.tavCutVideoSession = tAVCutVideoSession;
        }
    }

    public void updateTimeRange(long j3, long j16) {
        TimelineView timelineView = this.timelineView;
        if (timelineView != null) {
            timelineView.updateTimeRange(j3, j16);
        }
    }

    public CoverSelectView(@NonNull Context context, @Nullable AttributeSet attributeSet, UIConfigWrapper uIConfigWrapper) {
        super(context, attributeSet);
        this.currCoverProgress = 0.0f;
        this.maxDurationMs = 60000L;
        this.wrapper = uIConfigWrapper;
        initialize();
    }

    public CoverSelectView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, UIConfigWrapper uIConfigWrapper) {
        super(context, attributeSet, i3);
        this.currCoverProgress = 0.0f;
        this.maxDurationMs = 60000L;
        this.wrapper = uIConfigWrapper;
        initialize();
    }
}
