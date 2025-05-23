package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.canvas.AdReporterForDMPWithCanvas;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnView;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import com.tencent.ad.tangram.views.xijing.AdButtonData;
import com.tencent.ad.tangram.views.xijing.AdTextData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCanvasAppBtnComponentView extends AdCanvasComponentView {
    private static final String TAG = "GdtCanvasButtonComponentView";

    @Nullable
    private AdCanvasAppBtnComponentData data;

    @Nullable
    private AdAppDownloadManager downloadManager;

    @NonNull
    private View.OnClickListener listener;

    @Nullable
    private AdCanvasAppBtnUIAdapter mGdtAppBtnPresenter;
    private boolean mIsFixedButtonOrFloatingBar;

    public AdCanvasAppBtnComponentView(@NonNull Context context) {
        super(context);
        this.mIsFixedButtonOrFloatingBar = false;
        this.listener = new View.OnClickListener() { // from class: com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                AdCanvasAppBtnComponentView.this.doClick();
                EventCollector.getInstance().onViewClicked(view);
            }
        };
    }

    private void init(@NonNull Context context, @Nullable AdCanvasAppBtnComponentData adCanvasAppBtnComponentData, boolean z16) {
        AdCanvasViewListener adCanvasViewListener;
        startLoad();
        if (adCanvasAppBtnComponentData != null && adCanvasAppBtnComponentData.isValid() && getCanvasData() != null) {
            this.data = adCanvasAppBtnComponentData;
            AdLog.i(TAG, "init appId " + getCanvasData().f61337ad.getAppId() + " autodownload " + getCanvasData().getAutoDownLoad());
            if (getData().isFixed) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                setLayoutParams(layoutParams);
                setPadding(getData().paddingLeft, getData().paddingTop, getData().paddingRight, getData().toBottom + getData().paddingBottom);
            } else {
                setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                setPadding(getData().paddingLeft, getData().paddingTop, getData().paddingRight, getData().paddingBottom);
            }
            AdCanvasAppBtnView.Params params = new AdCanvasAppBtnView.Params();
            AdButtonData adButtonData = this.data.button;
            AdTextData adTextData = adButtonData.text;
            params.textSize = adTextData.size;
            int i3 = adButtonData.backgroundColor;
            params.leftBackgroundColor = i3;
            int i16 = adTextData.color;
            params.leftTextColor = i16;
            params.rightBackgroundColor = i16;
            params.rightTextColor = i3;
            params.borderCornerRadius = AdUIUtils.dp2px(adButtonData.borderCornerRadius, context.getResources());
            AdButtonData adButtonData2 = this.data.button;
            params.borderWidth = adButtonData2.borderWidth;
            params.borderColor = adButtonData2.backgroundColor;
            AdCanvasAppBtnView adCanvasAppBtnView = new AdCanvasAppBtnView(context, params);
            AdCanvasAppBtnComponentData adCanvasAppBtnComponentData2 = this.data;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(adCanvasAppBtnComponentData2.width, adCanvasAppBtnComponentData2.height);
            AdCanvasAppBtnComponentData adCanvasAppBtnComponentData3 = this.data;
            int i17 = adCanvasAppBtnComponentData3.gravity;
            layoutParams2.gravity = i17 | 16;
            if (i17 == 17) {
                layoutParams2.gravity = 17;
            } else if (i17 == 3) {
                layoutParams2.gravity = 3;
            } else if (i17 == 5) {
                layoutParams2.gravity = 5;
            } else {
                layoutParams2.gravity = 17;
            }
            adCanvasAppBtnView.setText(adCanvasAppBtnComponentData3.button.text.text);
            addView(adCanvasAppBtnView, layoutParams2);
            adCanvasAppBtnView.setOnClickListener(this.listener);
            WeakReference<AdCanvasViewListener> weakReference = this.canvasViewListener;
            AdAppDownloadManager adAppDownloadManager = null;
            if (weakReference != null) {
                adCanvasViewListener = weakReference.get();
            } else {
                adCanvasViewListener = null;
            }
            if (adCanvasViewListener != null) {
                adAppDownloadManager = adCanvasViewListener.getDownloadManager();
            }
            this.downloadManager = adAppDownloadManager;
            if (adAppDownloadManager != null) {
                adAppDownloadManager.init(context, getCanvasData().getAutoDownLoad(), getCanvasData().f61337ad, getCanvasData().sourceId);
                AdCanvasAppBtnComponentData adCanvasAppBtnComponentData4 = this.data;
                AdCanvasAppBtnUIAdapter adCanvasAppBtnUIAdapter = new AdCanvasAppBtnUIAdapter(adCanvasAppBtnComponentData4, adCanvasAppBtnComponentData4.button.text.text, adCanvasAppBtnView, this.downloadManager, z16);
                this.mGdtAppBtnPresenter = adCanvasAppBtnUIAdapter;
                this.downloadManager.setAppBtnUIPresenter(adCanvasAppBtnUIAdapter);
            }
            this.status = new AdViewStatus(new WeakReference(adCanvasAppBtnView), new WeakReference(this));
            if (!this.mIsFixedButtonOrFloatingBar && !getData().isFixed) {
                stopLoad(true);
                return;
            }
            return;
        }
        AdLog.e(TAG, "init error");
        stopLoad(false);
    }

    public void doClick() {
        int i3;
        if (getCanvasData() != null && getCanvasData().isValid()) {
            AdReporterForDMPWithCanvas.reportAppBtnClickAsync(getCanvasData().f61337ad);
        } else {
            AdLog.e(TAG, "onClick error");
        }
        AdAppBtnData gdtAppBtnData = this.downloadManager.getGdtAppBtnData();
        AdCanvasAppBtnUIAdapter adCanvasAppBtnUIAdapter = this.mGdtAppBtnPresenter;
        String str = this.data.f61339id;
        if (gdtAppBtnData != null) {
            i3 = gdtAppBtnData.cState;
        } else {
            i3 = 0;
        }
        adCanvasAppBtnUIAdapter.updateUIByClick(str, gdtAppBtnData, i3);
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdViewStatus getStatus() {
        return this.status;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    public void onActivityDestroy() {
        super.onActivityDestroy();
        AdCanvasAppBtnUIAdapter adCanvasAppBtnUIAdapter = this.mGdtAppBtnPresenter;
        if (adCanvasAppBtnUIAdapter != null) {
            this.downloadManager.removePresenter(adCanvasAppBtnUIAdapter);
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    public void onActivityResume() {
        super.onActivityResume();
        if (this.downloadManager != null) {
            AdLog.i(TAG, "onActivityResume callDownloadStatusCallbacks");
            this.downloadManager.callDownloadStatusCallbacks();
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdCanvasAppBtnComponentData getData() {
        return this.data;
    }

    public AdCanvasAppBtnComponentView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsFixedButtonOrFloatingBar = false;
        this.listener = new View.OnClickListener() { // from class: com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                AdCanvasAppBtnComponentView.this.doClick();
                EventCollector.getInstance().onViewClicked(view);
            }
        };
    }

    public AdCanvasAppBtnComponentView(@NonNull Context context, WeakReference<AdCanvasViewListener> weakReference, AdCanvasAppBtnComponentData adCanvasAppBtnComponentData, boolean z16, boolean z17) {
        super(context, weakReference);
        this.mIsFixedButtonOrFloatingBar = false;
        this.listener = new View.OnClickListener() { // from class: com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                AdCanvasAppBtnComponentView.this.doClick();
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mIsFixedButtonOrFloatingBar = z17;
        init(context, adCanvasAppBtnComponentData, z16);
    }
}
