package com.tencent.ad.tangram.views.canvas.components.picture;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.components.pictures.HotArea;
import com.tencent.ad.tangram.views.canvas.components.roundview.RoundViewHelper;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasReporterForLinkEvent;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasView;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class AdCanvasPictureComponentView extends AdCanvasComponentView implements AdImageViewAdapter.Callback {
    private static final String TAG = "GdtCanvasPictureComponentView";
    private RoundViewHelper containerHelper;

    @Nullable
    private AdCanvasPictureComponentData data;

    @NonNull
    private volatile Boolean hasImageLoad;
    private RoundViewHelper helper;
    private Handler imageLoadHandler;

    @Nullable
    private View imageView;
    private WeakReference<AdImageViewBuilder.Listener> imageViewlistener;
    private volatile boolean needNoticeToLoadImage;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class HotAreaClickListener implements View.OnClickListener {
        private String linkType;
        private String url;

        HotAreaClickListener(String str, String str2) {
            this.linkType = str;
            this.url = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdCanvasViewListener adCanvasViewListener;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (((AdCanvasComponentView) AdCanvasPictureComponentView.this).canvasViewListener != null && (adCanvasViewListener = (AdCanvasViewListener) ((AdCanvasComponentView) AdCanvasPictureComponentView.this).canvasViewListener.get()) != null) {
                adCanvasViewListener.hotAreaClick(this.linkType, AdCanvasPictureComponentView.this.data.f61339id, this.url);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class OnTouchListener implements View.OnTouchListener {
        private int actionDownX = 0;
        private int actionDownY = 0;
        private int allowClickMove;
        private Runnable clickRunnable;

        public OnTouchListener(Runnable runnable, @Nullable Resources resources) {
            this.allowClickMove = 3;
            this.clickRunnable = runnable;
            this.allowClickMove = AdUIUtils.dp2px(3.0f, resources);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, @NonNull MotionEvent motionEvent) {
            Runnable runnable;
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    int abs = Math.abs(x16 - this.actionDownX);
                    int abs2 = Math.abs(y16 - this.actionDownY);
                    int i3 = this.allowClickMove;
                    if (abs < i3 && abs2 < i3 && (runnable = this.clickRunnable) != null) {
                        runnable.run();
                        return false;
                    }
                    return false;
                }
                return false;
            }
            this.actionDownX = x16;
            this.actionDownY = y16;
            return true;
        }
    }

    public AdCanvasPictureComponentView(@NonNull Context context, WeakReference<AdCanvasViewListener> weakReference, AdCanvasPictureComponentData adCanvasPictureComponentData, View.OnTouchListener onTouchListener) {
        super(context, weakReference);
        this.hasImageLoad = Boolean.FALSE;
        this.imageViewlistener = new WeakReference<>(new AdImageViewBuilder.Listener() { // from class: com.tencent.ad.tangram.views.canvas.components.picture.AdCanvasPictureComponentView.1
            @Override // com.tencent.ad.tangram.image.AdImageViewBuilder.Listener
            public void onStopLoad(boolean z16) {
                AdCanvasPictureComponentView.this.onStopLoad(z16);
            }
        });
        init(context, adCanvasPictureComponentData, onTouchListener);
    }

    private void firstLoadExp(Context context, @NonNull AdCanvasPictureComponentData adCanvasPictureComponentData) {
        AdImageViewBuilder.Params params = new AdImageViewBuilder.Params();
        params.context = new WeakReference<>(context);
        params.callback = new WeakReference<>(this);
        params.url = adCanvasPictureComponentData.url;
        params.gaussianUrl = adCanvasPictureComponentData.gaussianUrl;
        params.isHitImageExp = true;
        params.listener = this.imageViewlistener;
        this.needNoticeToLoadImage = true;
        if (adCanvasPictureComponentData.isLoadFirst) {
            this.hasImageLoad = Boolean.TRUE;
            this.imageView = AdImageViewBuilder.getInstance().buildImageView(params);
            AdLog.d(TAG, "load image, the image url is " + params.url);
        } else {
            params.isOnlyLoadGaussianUrl = true;
            this.imageView = AdImageViewBuilder.getInstance().buildImageView(params);
            AdLog.d(TAG, "load guassian image, the image url is " + adCanvasPictureComponentData.url);
        }
        if (this.imageView == null) {
            AdLog.e(TAG, "build image failed");
            stopLoad(false);
        }
    }

    private void init(Context context, @Nullable final AdCanvasPictureComponentData adCanvasPictureComponentData, @Nullable View.OnTouchListener onTouchListener) {
        startLoad();
        if (adCanvasPictureComponentData != null && adCanvasPictureComponentData.isValid()) {
            this.data = adCanvasPictureComponentData;
            LinearLayout linearLayout = new LinearLayout(context);
            addView(linearLayout);
            RelativeLayout relativeLayout = new RelativeLayout(context);
            if (adCanvasPictureComponentData.isHotAreaValild()) {
                ArrayList<HotArea> arrayList = adCanvasPictureComponentData.hotAreaList;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    View button = new Button(getContext());
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(arrayList.get(i3).width, arrayList.get(i3).height);
                    layoutParams.topMargin = arrayList.get(i3).f61343y;
                    layoutParams.leftMargin = arrayList.get(i3).f61342x;
                    button.setLayoutParams(layoutParams);
                    button.setBackgroundColor(0);
                    relativeLayout.addView(button);
                    button.setOnClickListener(new HotAreaClickListener(arrayList.get(i3).linkType, arrayList.get(i3).url));
                }
            }
            addView(relativeLayout);
            linearLayout.setPadding(getData().paddingLeft, getData().paddingTop, getData().paddingRight, getData().paddingBottom);
            firstLoadExp(context, adCanvasPictureComponentData);
            View view = this.imageView;
            if (view != null && (view instanceof ImageView)) {
                if (adCanvasPictureComponentData.enableRoundRectBackground) {
                    RoundViewHelper roundViewHelper = new RoundViewHelper(new WeakReference(linearLayout));
                    this.containerHelper = roundViewHelper;
                    roundViewHelper.setRadius(this.data.radius);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
                    int i16 = this.data.borderWidth;
                    marginLayoutParams.leftMargin = i16;
                    marginLayoutParams.topMargin = i16;
                    marginLayoutParams.rightMargin = i16;
                    marginLayoutParams.bottomMargin = i16;
                    linearLayout.setLayoutParams(marginLayoutParams);
                    RoundViewHelper roundViewHelper2 = new RoundViewHelper(new WeakReference(this));
                    this.helper = roundViewHelper2;
                    roundViewHelper2.setBorderColor(Color.parseColor(this.data.borderColor));
                    this.helper.setBorderWidth(this.data.borderWidth);
                    this.helper.setRadius(this.data.radius);
                }
                linearLayout.addView(this.imageView);
                ViewGroup.LayoutParams layoutParams2 = this.imageView.getLayoutParams();
                layoutParams2.width = getData().width;
                layoutParams2.height = getData().height;
                this.imageView.setLayoutParams(layoutParams2);
                if (onTouchListener != null) {
                    this.imageView.setOnTouchListener(onTouchListener);
                } else {
                    this.imageView.setOnTouchListener(new OnTouchListener(new Runnable() { // from class: com.tencent.ad.tangram.views.canvas.components.picture.AdCanvasPictureComponentView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Ad ad5;
                            if (!TextUtils.isEmpty(adCanvasPictureComponentData.actionUrl)) {
                                AdBrowser.Params params = new AdBrowser.Params();
                                params.activity = new WeakReference<>((Activity) AdCanvasPictureComponentView.this.getContext());
                                if (AdCanvasPictureComponentView.this.getCanvasData() != null) {
                                    ad5 = AdCanvasPictureComponentView.this.getCanvasData().f61337ad;
                                } else {
                                    ad5 = null;
                                }
                                params.f61348ad = ad5;
                                params.url = adCanvasPictureComponentData.actionUrl;
                                AdBrowser.getInstance().show(params);
                            }
                        }
                    }, getResources()));
                }
                this.status = new AdViewStatus(new WeakReference(this.imageView), new WeakReference(this));
                return;
            }
            AdLog.e(TAG, "buildImageView Failed");
            stopLoad(false);
            return;
        }
        stopLoad(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas canvas) {
        RoundViewHelper roundViewHelper = this.helper;
        if (roundViewHelper != null) {
            roundViewHelper.dispatchDraw(canvas);
        }
        RoundViewHelper roundViewHelper2 = this.containerHelper;
        if (roundViewHelper2 != null) {
            roundViewHelper2.dispatchDraw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdViewStatus getStatus() {
        return this.status;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    public void onActivityDestroy() {
        super.onActivityDestroy();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        RoundViewHelper roundViewHelper = this.helper;
        if (roundViewHelper != null) {
            roundViewHelper.onLayout(z16, i3, i16, i17, i18);
        }
        RoundViewHelper roundViewHelper2 = this.containerHelper;
        if (roundViewHelper2 != null) {
            roundViewHelper2.onLayout(z16, i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    public void onLocationChanged() {
        boolean z16;
        AdViewStatus adViewStatus = this.status;
        if (adViewStatus != null && !adViewStatus.visible) {
            double percentageOfGlobalVisibleRect = AdUIUtils.getPercentageOfGlobalVisibleRect(this.imageView);
            AdViewStatus adViewStatus2 = this.status;
            if (percentageOfGlobalVisibleRect > 0.0d) {
                z16 = true;
            } else {
                z16 = false;
            }
            adViewStatus2.visible = z16;
            if (z16) {
                refreshImageView();
            }
        }
    }

    @Override // com.tencent.ad.tangram.image.AdImageViewAdapter.Callback
    public void onStopLoad(boolean z16) {
        AdCanvasViewListener adCanvasViewListener;
        stopLoad(z16);
        AdLog.d(TAG, "loaded image, the image url is " + this.data.url);
        WeakReference<AdCanvasViewListener> weakReference = this.canvasViewListener;
        Ad ad5 = null;
        if (weakReference != null) {
            adCanvasViewListener = weakReference.get();
        } else {
            adCanvasViewListener = null;
        }
        if (adCanvasViewListener != null && adCanvasViewListener.getContentView() != null && this.imageLoadHandler == null) {
            this.imageLoadHandler = adCanvasViewListener.getContentView().getMHandler();
        }
        if (this.imageLoadHandler != null && this.needNoticeToLoadImage) {
            this.imageLoadHandler.sendEmptyMessage(1);
        }
        if (getData() != null && getData().needFirstImageReport && z16) {
            Context context = getContext();
            if (getCanvasData() != null) {
                ad5 = getCanvasData().f61337ad;
            }
            AdCanvasReporterForLinkEvent.reportForNativeLandingPage(context, ad5, sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_LOAD_FIRSTPAGE_RENDERED, AdCanvasView.sStartTimeMillis, Integer.MIN_VALUE);
            getData().needFirstImageReport = false;
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView, com.tencent.ad.tangram.views.AdViewStatus.Listener
    public void onViewResume() {
        super.onViewResume();
        refreshImageView();
    }

    public void refreshImageView() {
        AdLog.d(TAG, "notice to refresh image, the image url is " + this.data.url);
        synchronized (this) {
            if (!this.hasImageLoad.booleanValue()) {
                AdLog.d(TAG, "refresh image, the image url is " + this.data.url);
                this.hasImageLoad = Boolean.TRUE;
                AdImageViewBuilder.Params params = new AdImageViewBuilder.Params();
                params.context = new WeakReference<>(getContext());
                params.url = this.data.url;
                params.isOnlyLoadGaussianUrl = false;
                params.callback = new WeakReference<>(this);
                params.listener = this.imageViewlistener;
                AdImageViewBuilder.getInstance().buildImageView(params, this.imageView);
                this.needNoticeToLoadImage = false;
            }
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdCanvasPictureComponentData getData() {
        return this.data;
    }

    public AdCanvasPictureComponentView(@NonNull Context context, WeakReference<AdCanvasViewListener> weakReference, AdCanvasPictureComponentData adCanvasPictureComponentData, View.OnTouchListener onTouchListener, Handler handler) {
        super(context, weakReference);
        this.hasImageLoad = Boolean.FALSE;
        this.imageViewlistener = new WeakReference<>(new AdImageViewBuilder.Listener() { // from class: com.tencent.ad.tangram.views.canvas.components.picture.AdCanvasPictureComponentView.1
            @Override // com.tencent.ad.tangram.image.AdImageViewBuilder.Listener
            public void onStopLoad(boolean z16) {
                AdCanvasPictureComponentView.this.onStopLoad(z16);
            }
        });
        this.imageLoadHandler = handler;
        init(context, adCanvasPictureComponentData, onTouchListener);
    }
}
