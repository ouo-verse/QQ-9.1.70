package com.tencent.gdtad.views.carousel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.widget.carouselcard.TGCarouselCardLayoutManager;
import com.tencent.ad.tangram.widget.carouselcard.TGCarouselCardLayoutManagerParams;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtCarouselCardView extends RecyclerView implements TGCarouselCardLayoutManager.IOnItemScrollListener {
    public static final int ID_FOR_POSITION = 2131296418;
    private static final String TAG = "GdtCarouselCardView";
    private Params mParams;
    private final Rect mRect;
    private WeakReference<IOnActionListener> mWeakOnActionListener;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static final class Adapter extends RecyclerView.Adapter<ViewHolder> {
        private static final String TAG = "GdtCarouselCardView.Adapter";
        private int mCardHeightPx;
        private int mCardWidthPx;
        private List<GdtCarouselCardData> mDataList;
        private boolean mIsFirstTimeLayout;
        private int mStartPosition;
        private ViewHolder mVideoViewHolder;
        private WeakReference<IAdapterForViews> mWeakAdapterForPlayer;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes6.dex */
        public class a extends ViewOutlineProvider {
            a() {
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (view == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), AdUIUtils.dp2px(5.0f, view.getResources()));
            }
        }

        Adapter() {
            this.mIsFirstTimeLayout = true;
            this.mStartPosition = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addVideoViewToTargetViewHolder(ViewHolder viewHolder, int i3) {
            View videoView;
            GdtLog.i(TAG, "[addVideoViewToTargetViewHolder] " + viewHolder);
            if (viewHolder != null && viewHolder.videoView == null) {
                View view = viewHolder.itemView;
                if ((view instanceof ViewGroup) && (videoView = getVideoView(i3)) != null && videoView.getParent() == null) {
                    ImageView imageView = viewHolder.imageView;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    videoView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    videoView.setTag(2131296418, Integer.valueOf(i3));
                    ViewGroup viewGroup = (ViewGroup) view;
                    viewGroup.addView(videoView);
                    viewGroup.bringChildToFront(viewHolder.textView);
                    viewHolder.videoView = videoView;
                    this.mVideoViewHolder = viewHolder;
                }
            }
        }

        private GdtCarouselCardData getData(int i3) {
            List<GdtCarouselCardData> list = this.mDataList;
            if (list != null && i3 < list.size()) {
                return this.mDataList.get(i3);
            }
            return null;
        }

        @Nullable
        private ImageView getImageView() {
            IAdapterForViews iAdapterForViews;
            WeakReference<IAdapterForViews> weakReference = this.mWeakAdapterForPlayer;
            if (weakReference != null) {
                iAdapterForViews = weakReference.get();
            } else {
                iAdapterForViews = null;
            }
            if (iAdapterForViews == null) {
                return null;
            }
            return iAdapterForViews.getImageView();
        }

        private View getVideoView(int i3) {
            IAdapterForViews iAdapterForViews;
            WeakReference<IAdapterForViews> weakReference = this.mWeakAdapterForPlayer;
            if (weakReference != null) {
                iAdapterForViews = weakReference.get();
            } else {
                iAdapterForViews = null;
            }
            if (iAdapterForViews == null) {
                return null;
            }
            return iAdapterForViews.getVideoView(i3, this.mCardWidthPx, this.mCardHeightPx);
        }

        private void recycleVideoView() {
            IAdapterForViews iAdapterForViews;
            WeakReference<IAdapterForViews> weakReference = this.mWeakAdapterForPlayer;
            if (weakReference != null) {
                iAdapterForViews = weakReference.get();
            } else {
                iAdapterForViews = null;
            }
            if (iAdapterForViews == null) {
                return;
            }
            iAdapterForViews.recycleVideoView();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeVideoViewFromTargetViewHolder() {
            if (this.mVideoViewHolder == null) {
                return;
            }
            GdtLog.i(TAG, "[removeVideoViewFromTargetViewHolder]");
            ViewHolder viewHolder = this.mVideoViewHolder;
            View view = viewHolder.itemView;
            if ((view instanceof ViewGroup) && viewHolder.videoView != null) {
                ImageView imageView = viewHolder.imageView;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                ((ViewGroup) view).removeView(this.mVideoViewHolder.videoView);
                recycleVideoView();
                this.mVideoViewHolder.videoView = null;
                this.mVideoViewHolder = null;
            }
        }

        private void updateImageDrawable(ImageView imageView, int i3) {
            IAdapterForViews iAdapterForViews;
            WeakReference<IAdapterForViews> weakReference = this.mWeakAdapterForPlayer;
            if (weakReference != null) {
                iAdapterForViews = weakReference.get();
            } else {
                iAdapterForViews = null;
            }
            if (iAdapterForViews == null) {
                return;
            }
            iAdapterForViews.updateImageDrawable(imageView, i3, this.mCardWidthPx, this.mCardHeightPx);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<GdtCarouselCardData> list = this.mDataList;
            if (list != null && !list.isEmpty()) {
                return this.mDataList.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@Nullable ViewHolder viewHolder, int i3) {
            List<GdtCarouselCardData> list;
            GdtCarouselCardData data;
            ImageView imageView;
            int i16;
            if (viewHolder == null || (list = this.mDataList) == null || i3 >= list.size() || (data = getData(i3)) == null || (imageView = viewHolder.imageView) == null) {
                return;
            }
            updateImageDrawable(imageView, i3);
            imageView.setTag(2131296418, Integer.valueOf(i3));
            TextView textView = viewHolder.textView;
            String text = data.getText();
            if (textView != null) {
                if (!TextUtils.isEmpty(text)) {
                    textView.setVisibility(0);
                    textView.setText(text);
                } else {
                    textView.setVisibility(8);
                }
            }
            if (this.mIsFirstTimeLayout && i3 == (i16 = this.mStartPosition)) {
                addVideoViewToTargetViewHolder(viewHolder, i16);
                this.mIsFirstTimeLayout = false;
            }
            GdtLog.i(TAG, "[onBindViewHolder] " + viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            if (viewGroup == null || viewGroup.getContext() == null || this.mCardWidthPx <= 0 || this.mCardHeightPx <= 0) {
                return null;
            }
            RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(this.mCardWidthPx, this.mCardHeightPx));
            relativeLayout.setOutlineProvider(new a());
            relativeLayout.setClipToOutline(true);
            ImageView imageView = getImageView();
            if (imageView != null) {
                imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                relativeLayout.addView(imageView);
            }
            ViewHolder viewHolder = new ViewHolder(relativeLayout);
            viewHolder.imageView = imageView;
            TextView textView = new TextView(viewGroup.getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mCardWidthPx, AdUIUtils.dp2px(80.0f, viewGroup.getResources()));
            int dp2px = AdUIUtils.dp2px(12.0f, viewGroup.getResources());
            textView.setPadding(dp2px, 0, 0, dp2px);
            layoutParams.addRule(12);
            textView.setLayoutParams(layoutParams);
            textView.setIncludeFontPadding(false);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setSingleLine();
            textView.setTextSize(1, 18.0f);
            textView.setTextColor(-1);
            textView.setGravity(80);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColors(new int[]{0, HWColorFormat.COLOR_FormatVendorStartUnused});
            textView.setBackground(gradientDrawable);
            viewHolder.textView = textView;
            relativeLayout.addView(textView);
            GdtLog.i(TAG, "[onCreateViewHolder] " + viewHolder);
            return viewHolder;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(@NonNull ViewHolder viewHolder) {
            if (viewHolder == this.mVideoViewHolder) {
                removeVideoViewFromTargetViewHolder();
            }
            super.onViewRecycled((Adapter) viewHolder);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface IAdapterForViews {
        ImageView getImageView();

        View getVideoView(int i3, int i16, int i17);

        void recycleVideoView();

        void updateImageDrawable(ImageView imageView, int i3, int i16, int i17);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface IOnActionListener {
        void onItemScrolled(int i3, int i16);

        void onTouchEvent(MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class Params implements Cloneable {
        public TGCarouselCardLayoutManagerParams layoutManagerParams;
        public WeakReference<IAdapterForViews> weakAdapterForPlayer;
        public WeakReference<Context> weakContext;
        public WeakReference<IOnActionListener> weakOnActionListener;

        @IntRange(from = 0)
        public int cardWidthPx = 0;

        @IntRange(from = 0)
        public int cardHeightPx = 0;
        public List<GdtCarouselCardData> dataList = null;

        @NonNull
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public boolean isValid() {
            List<GdtCarouselCardData> list;
            TGCarouselCardLayoutManagerParams tGCarouselCardLayoutManagerParams;
            WeakReference<IAdapterForViews> weakReference;
            WeakReference<Context> weakReference2 = this.weakContext;
            if (weakReference2 != null && weakReference2.get() != null && (list = this.dataList) != null && !list.isEmpty() && (tGCarouselCardLayoutManagerParams = this.layoutManagerParams) != null && tGCarouselCardLayoutManagerParams.isValid() && this.layoutManagerParams.startPosition < this.dataList.size() && (weakReference = this.weakAdapterForPlayer) != null && weakReference.get() != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        View videoView;

        public ViewHolder(View view) {
            super(view);
        }
    }

    GdtCarouselCardView(Context context) {
        super(context);
        this.mRect = new Rect();
    }

    public static GdtCarouselCardView build(Params params) {
        Context context;
        if (params == null || !params.isValid() || (context = params.weakContext.get()) == null) {
            return null;
        }
        GdtCarouselCardView gdtCarouselCardView = new GdtCarouselCardView(context);
        try {
            gdtCarouselCardView.mParams = (Params) params.clone();
        } catch (Throwable unused) {
        }
        TGCarouselCardLayoutManager build = TGCarouselCardLayoutManager.build(gdtCarouselCardView, params.layoutManagerParams);
        if (build == null) {
            return null;
        }
        build.setOnScrollListener(new WeakReference<>(gdtCarouselCardView));
        gdtCarouselCardView.setLayoutManager(build);
        Adapter adapter = new Adapter();
        adapter.mCardWidthPx = params.cardWidthPx;
        adapter.mCardHeightPx = params.cardHeightPx;
        adapter.mWeakAdapterForPlayer = params.weakAdapterForPlayer;
        adapter.mDataList = params.dataList;
        adapter.mStartPosition = params.layoutManagerParams.startPosition;
        gdtCarouselCardView.mWeakOnActionListener = params.weakOnActionListener;
        gdtCarouselCardView.setAdapter(adapter);
        gdtCarouselCardView.setHasFixedSize(true);
        gdtCarouselCardView.setItemAnimator(null);
        return gdtCarouselCardView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IOnActionListener iOnActionListener;
        WeakReference<IOnActionListener> weakReference = this.mWeakOnActionListener;
        if (weakReference != null) {
            iOnActionListener = weakReference.get();
        } else {
            iOnActionListener = null;
        }
        if (iOnActionListener != null) {
            iOnActionListener.onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        Params params = this.mParams;
        if (params != null && params.isValid()) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (!(layoutManager instanceof TGCarouselCardLayoutManager)) {
                return;
            }
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (childAt == null) {
                    return;
                }
                if (childCount == getChildCount() - 1) {
                    i3 = this.mParams.cardWidthPx;
                } else if (childCount == getChildCount() - 2) {
                    i3 = this.mParams.layoutManagerParams.horizontalOffsetPx + ((TGCarouselCardLayoutManager) layoutManager).getFirstVisibleItemConsumedOffsetPx();
                } else {
                    i3 = this.mParams.layoutManagerParams.horizontalOffsetPx;
                }
                float f16 = i3;
                Rect rect = this.mRect;
                int scaleX = (int) (this.mParams.cardWidthPx - (f16 / childAt.getScaleX()));
                Params params2 = this.mParams;
                rect.set(scaleX, 0, params2.cardWidthPx, params2.cardHeightPx);
                childAt.setClipBounds(this.mRect);
            }
            super.onDraw(canvas);
        }
    }

    @Override // com.tencent.ad.tangram.widget.carouselcard.TGCarouselCardLayoutManager.IOnItemScrollListener
    public void onItemScrolled(int i3, int i16) {
        IOnActionListener iOnActionListener;
        WeakReference<IOnActionListener> weakReference = this.mWeakOnActionListener;
        if (weakReference != null) {
            iOnActionListener = weakReference.get();
        } else {
            iOnActionListener = null;
        }
        if (getAdapter() instanceof Adapter) {
            Adapter adapter = (Adapter) getAdapter();
            if (i3 != i16) {
                try {
                    adapter.removeVideoViewFromTargetViewHolder();
                    adapter.addVideoViewToTargetViewHolder((ViewHolder) findViewHolderForLayoutPosition(i16), i16);
                } catch (Throwable unused) {
                    GdtLog.i(TAG, "[onItemScrolled] internal error");
                }
            }
        }
        if (iOnActionListener != null) {
            iOnActionListener.onItemScrolled(i3, i16);
        }
    }
}
