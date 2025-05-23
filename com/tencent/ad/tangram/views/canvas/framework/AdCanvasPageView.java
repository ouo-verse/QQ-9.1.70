package com.tencent.ad.tangram.views.canvas.framework;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.ImageLoadParams;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentData;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentView;
import com.tencent.ad.tangram.views.canvas.components.appicon.AdCanvasAppIconComponentData;
import com.tencent.ad.tangram.views.canvas.components.appicon.AdCanvasAppIconComponentView;
import com.tencent.ad.tangram.views.canvas.components.appinfobutton.AdCanvasAppInfoButtonComponentData;
import com.tencent.ad.tangram.views.canvas.components.appinfobutton.AdCanvasAppInfoButtonComponentView;
import com.tencent.ad.tangram.views.canvas.components.imagescarousel.AdCanvasImagesCarouselComponentData;
import com.tencent.ad.tangram.views.canvas.components.imagescarousel.AdCanvasImagesCarouselComponentView;
import com.tencent.ad.tangram.views.canvas.components.layercard.AdCanvasLayerCardData;
import com.tencent.ad.tangram.views.canvas.components.layercard.AdCanvasLayerCardView;
import com.tencent.ad.tangram.views.canvas.components.picture.AdCanvasPictureComponentData;
import com.tencent.ad.tangram.views.canvas.components.picture.AdCanvasPictureComponentView;
import com.tencent.ad.tangram.views.canvas.components.pictures.AdCanvasMultiPictureComponentData;
import com.tencent.ad.tangram.views.canvas.components.pictures.AdCanvasMultiPictureComponentView;
import com.tencent.ad.tangram.views.canvas.components.text.AdCanvasTextComponentData;
import com.tencent.ad.tangram.views.canvas.components.text.AdCanvasTextComponentView;
import com.tencent.ad.tangram.views.canvas.components.title.AdCanvasTitleComponentData;
import com.tencent.ad.tangram.views.canvas.components.title.AdCanvasTitleComponentView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@AdKeep
/* loaded from: classes3.dex */
public final class AdCanvasPageView extends ScrollView {
    private static final String TAG = "GdtCanvasPageView";
    private WeakReference<AdCanvasViewListener> canvasViewListener;
    private LinearLayout container;

    @Nullable
    private AdCanvasPageData data;
    private float mDownPosX;
    private float mDownPosY;
    private Handler mHandler;
    private int mMaxDepth;

    /* loaded from: classes3.dex */
    public static class AdCanvasPageViewHandler extends Handler {
        private static final String TAG = "AdCanvasPageViewHandler";

        @NonNull
        private final WeakReference<AdCanvasPageView> adCanvasPageViewWeakReference;

        public AdCanvasPageViewHandler(AdCanvasPageView adCanvasPageView) {
            this.adCanvasPageViewWeakReference = new WeakReference<>(adCanvasPageView);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00c2 A[SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(@NonNull Message message) {
            AdCanvasPageView adCanvasPageView;
            ImageLoadParams imageLoadParams;
            if (message.what == 1) {
                WeakReference<AdCanvasPageView> weakReference = this.adCanvasPageViewWeakReference;
                if (weakReference != null) {
                    adCanvasPageView = weakReference.get();
                } else {
                    adCanvasPageView = null;
                }
                if (adCanvasPageView == null || adCanvasPageView.data == null || (imageLoadParams = adCanvasPageView.data.imageLoadParams) == null) {
                    return;
                }
                imageLoadParams.hasLoadedFirstImages.addAndGet(-1);
                AdLog.d(TAG, "load to noticed");
                AdLog.d(TAG, "image has loaded number is " + imageLoadParams.hasLoadedFirstImages);
                if (imageLoadParams.hasLoadedFirstImages.get() <= 0) {
                    for (int i3 = 0; i3 < adCanvasPageView.getCount(); i3++) {
                        AdCanvasComponentView view = adCanvasPageView.getView(i3);
                        List<AdCanvasPictureComponentView> arrayList = new ArrayList<>();
                        if (view instanceof AdCanvasMultiPictureComponentView) {
                            AdCanvasMultiPictureComponentView adCanvasMultiPictureComponentView = (AdCanvasMultiPictureComponentView) view;
                            if (adCanvasMultiPictureComponentView.getAdCanvasPictureComponentViews() != null) {
                                arrayList = adCanvasMultiPictureComponentView.getAdCanvasPictureComponentViews();
                                if (arrayList != null) {
                                    for (AdCanvasPictureComponentView adCanvasPictureComponentView : arrayList) {
                                        if (adCanvasPictureComponentView != null && adCanvasPictureComponentView.getData() != null && !adCanvasPictureComponentView.getData().isLoadFirst) {
                                            adCanvasPictureComponentView.refreshImageView();
                                        }
                                    }
                                }
                            }
                        }
                        if (view instanceof AdCanvasLayerCardView) {
                            AdCanvasLayerCardView adCanvasLayerCardView = (AdCanvasLayerCardView) view;
                            if (adCanvasLayerCardView.getAdCanvasImagesCarouselComponentView() != null) {
                                arrayList = adCanvasLayerCardView.getAdCanvasImagesCarouselComponentView().getAdCanvasPictureComponentViews();
                                if (arrayList != null) {
                                }
                            }
                        }
                        if (view instanceof AdCanvasImagesCarouselComponentView) {
                            AdCanvasImagesCarouselComponentView adCanvasImagesCarouselComponentView = (AdCanvasImagesCarouselComponentView) view;
                            if (adCanvasImagesCarouselComponentView.getAdCanvasPictureComponentViews() != null) {
                                arrayList = adCanvasImagesCarouselComponentView.getAdCanvasPictureComponentViews();
                            }
                        }
                        if (arrayList != null) {
                        }
                    }
                }
            }
        }
    }

    public AdCanvasPageView(Context context, WeakReference<AdCanvasViewListener> weakReference, AdCanvasPageData adCanvasPageData) {
        super(context);
        this.mDownPosX = 0.0f;
        this.mDownPosY = 0.0f;
        this.mMaxDepth = 0;
        this.canvasViewListener = weakReference;
        setVerticalScrollBarEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        initView(adCanvasPageData);
    }

    @Nullable
    private AdCanvasComponentView getComponentViewFromData(@Nullable AdCanvasComponentData adCanvasComponentData, AdCanvasPageData adCanvasPageData) {
        AdCanvasComponentView adCanvasComponentView = null;
        if (adCanvasComponentData != null && adCanvasComponentData.isValid()) {
            if (adCanvasComponentData instanceof AdCanvasAppInfoButtonComponentData) {
                adCanvasComponentView = new AdCanvasAppInfoButtonComponentView(getContext(), this.canvasViewListener, (AdCanvasAppInfoButtonComponentData) adCanvasComponentData, true);
            } else if (adCanvasComponentData instanceof AdCanvasPictureComponentData) {
                adCanvasComponentView = new AdCanvasPictureComponentView(getContext(), this.canvasViewListener, (AdCanvasPictureComponentData) AdCanvasPictureComponentData.class.cast(adCanvasComponentData), null, this.mHandler);
            } else if (adCanvasComponentData instanceof AdCanvasAppBtnComponentData) {
                adCanvasComponentView = new AdCanvasAppBtnComponentView(getContext(), this.canvasViewListener, (AdCanvasAppBtnComponentData) AdCanvasAppBtnComponentData.class.cast(adCanvasComponentData), ((AdCanvasAppBtnComponentData) AdCanvasAppBtnComponentData.class.cast(adCanvasComponentData)).canShowProgress, false);
            } else if (adCanvasComponentData instanceof AdCanvasMultiPictureComponentData) {
                adCanvasComponentView = new AdCanvasMultiPictureComponentView(getContext(), this.canvasViewListener, (AdCanvasMultiPictureComponentData) AdCanvasMultiPictureComponentData.class.cast(adCanvasComponentData), this.mHandler);
            } else if (adCanvasComponentData instanceof AdCanvasImagesCarouselComponentData) {
                adCanvasComponentView = new AdCanvasImagesCarouselComponentView(getContext(), this.canvasViewListener, (AdCanvasImagesCarouselComponentData) AdCanvasImagesCarouselComponentData.class.cast(adCanvasComponentData));
            } else if (adCanvasComponentData instanceof AdCanvasAppIconComponentData) {
                adCanvasComponentView = new AdCanvasAppIconComponentView(getContext(), this.canvasViewListener, (AdCanvasAppIconComponentData) AdCanvasAppIconComponentData.class.cast(adCanvasComponentData));
            } else if (adCanvasComponentData instanceof AdCanvasTextComponentData) {
                adCanvasComponentView = new AdCanvasTextComponentView(getContext(), this.canvasViewListener, (AdCanvasTextComponentData) adCanvasComponentData);
            } else if (adCanvasComponentData instanceof AdCanvasLayerCardData) {
                adCanvasComponentView = new AdCanvasLayerCardView(getContext(), this.canvasViewListener, (AdCanvasLayerCardData) adCanvasComponentData, this.mHandler);
            } else if (adCanvasComponentData instanceof AdCanvasTitleComponentData) {
                adCanvasComponentView = new AdCanvasTitleComponentView(getContext(), this.canvasViewListener, (AdCanvasTitleComponentData) adCanvasComponentData);
            }
            if (adCanvasComponentView != null) {
                adCanvasComponentView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
        }
        return adCanvasComponentView;
    }

    private void initView(@Nullable AdCanvasPageData adCanvasPageData) {
        if (adCanvasPageData != null && adCanvasPageData.isValid()) {
            this.data = adCanvasPageData;
            setFillViewport(true);
            setBackgroundColor(adCanvasPageData.backgroundColor);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.container = linearLayout;
            addView(linearLayout);
            this.container.setOrientation(1);
            ViewGroup.LayoutParams layoutParams = this.container.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            this.container.setLayoutParams(layoutParams);
            this.mHandler = new AdCanvasPageViewHandler(this);
            int size = adCanvasPageData.getSize();
            for (int i3 = 0; i3 < size; i3++) {
                AdCanvasComponentView componentViewFromData = getComponentViewFromData(adCanvasPageData.getComponent(i3), adCanvasPageData);
                if (componentViewFromData != null) {
                    this.container.addView(componentViewFromData);
                }
            }
        }
    }

    public boolean back() {
        for (int i3 = 0; i3 < getCount(); i3++) {
            if (getView(i3) != null && getView(i3).back()) {
                return true;
            }
        }
        return false;
    }

    public LinearLayout getContainer() {
        return this.container;
    }

    public int getCount() {
        if (!(getChildAt(0) instanceof ViewGroup)) {
            return 0;
        }
        return ((ViewGroup) getChildAt(0)).getChildCount();
    }

    @Nullable
    public AdCanvasPageData getData() {
        return this.data;
    }

    public Handler getMHandler() {
        return this.mHandler;
    }

    public int getMaxDepth() {
        return this.mMaxDepth;
    }

    @Nullable
    public AdCanvasComponentView getView(int i3) {
        if (i3 < 0 || i3 >= getCount() || !(getChildAt(0) instanceof ViewGroup)) {
            return null;
        }
        View childAt = ((ViewGroup) getChildAt(0)).getChildAt(i3);
        if (!(childAt instanceof AdCanvasComponentView)) {
            return null;
        }
        return (AdCanvasComponentView) childAt;
    }

    public void onActivityDestroy() {
        for (int i3 = 0; i3 < getCount(); i3++) {
            AdCanvasComponentView view = getView(i3);
            if (view != null) {
                view.onActivityDestroy();
            }
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void onActivityPause() {
        for (int i3 = 0; i3 < getCount(); i3++) {
            AdCanvasComponentView view = getView(i3);
            if (view != null) {
                view.onActivityPause();
            }
        }
    }

    public void onActivityResume() {
        for (int i3 = 0; i3 < getCount(); i3++) {
            AdCanvasComponentView view = getView(i3);
            if (view != null) {
                view.onActivityResume();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 2) && Math.abs(rawX - this.mDownPosX) > Math.abs(rawY - this.mDownPosY)) {
                return false;
            }
        } else {
            this.mDownPosX = rawX;
            this.mDownPosY = rawY;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onLocationChanged() {
        for (int i3 = 0; i3 < getCount(); i3++) {
            AdCanvasComponentView view = getView(i3);
            if (view != null) {
                view.onLocationChanged();
            }
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        this.mMaxDepth = Math.max(i16, this.mMaxDepth);
        onLocationChanged();
    }

    public void setPageViewLayoutParams(int i3) {
        LinearLayout linearLayout = this.container;
        if (linearLayout != null) {
            try {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
                marginLayoutParams.topMargin = i3;
                setLayoutParams(marginLayoutParams);
            } catch (Throwable th5) {
                AdLog.e(TAG, "setPageViewLayoutParams:" + th5);
            }
        }
    }
}
