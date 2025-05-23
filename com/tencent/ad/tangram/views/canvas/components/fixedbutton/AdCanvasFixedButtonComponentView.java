package com.tencent.ad.tangram.views.canvas.components.fixedbutton;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentView;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCanvasFixedButtonComponentView extends AdCanvasComponentView {
    private static final String TAG = "GdtCanvasButtonComponentView";

    @Nullable
    private View fixedView;

    @Nullable
    private AdCanvasFixedButtonComponentData gdtCanvasFixedButtonComponentData;

    public AdCanvasFixedButtonComponentView(@NonNull Context context) {
        super(context);
        this.fixedView = null;
    }

    public void doClick() {
        View view = this.fixedView;
        if (view != null) {
            if (view instanceof AdCanvasFixedButtonWithComplexStyle) {
                ((AdCanvasFixedButtonWithComplexStyle) view).doClick();
            } else if (view instanceof AdCanvasAppBtnComponentView) {
                ((AdCanvasAppBtnComponentView) view).doClick();
            }
        }
    }

    public String getButtonStyle() {
        return this.gdtCanvasFixedButtonComponentData.buttonStyle;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdViewStatus getStatus() {
        return this.status;
    }

    public void init(@NonNull Context context, @Nullable AdCanvasFixedButtonComponentData adCanvasFixedButtonComponentData, @NonNull Ad ad5, WeakReference<AdCanvasViewListener> weakReference) {
        RelativeLayout.LayoutParams layoutParams;
        startLoad();
        if (adCanvasFixedButtonComponentData != null && adCanvasFixedButtonComponentData.isValid()) {
            this.gdtCanvasFixedButtonComponentData = adCanvasFixedButtonComponentData;
            if (adCanvasFixedButtonComponentData.buttonStyle.equals(AdCanvasFixedButtonComponentData.BUTTON_STYLE_1)) {
                this.fixedView = new AdCanvasFixedButtonWithComplexStyle(context, this.gdtCanvasFixedButtonComponentData, ad5, weakReference);
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            } else if (this.gdtCanvasFixedButtonComponentData.buttonStyle.equals(AdCanvasFixedButtonComponentData.BUTTON_STYLE_2)) {
                this.fixedView = new AdCanvasAppBtnComponentView(context, weakReference, adCanvasFixedButtonComponentData, true, true);
                AdCanvasFixedButtonComponentData adCanvasFixedButtonComponentData2 = this.gdtCanvasFixedButtonComponentData;
                layoutParams = new RelativeLayout.LayoutParams(-1, adCanvasFixedButtonComponentData2.height + adCanvasFixedButtonComponentData2.paddingTop + adCanvasFixedButtonComponentData2.paddingBottom);
                this.fixedView.setBackgroundColor(-1);
            } else {
                AdLog.e(TAG, "buttonStyle unknown");
                stopLoad(false);
                return;
            }
            addView(this.fixedView, layoutParams);
            this.status = new AdViewStatus(new WeakReference(this.fixedView), new WeakReference(this));
            return;
        }
        AdLog.e(TAG, "init error");
        stopLoad(false);
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    public void onActivityDestroy() {
        super.onActivityDestroy();
        View view = this.fixedView;
        if (view != null) {
            ((AdCanvasComponentView) view).onActivityDestroy();
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    public void onActivityResume() {
        super.onActivityResume();
        View view = this.fixedView;
        if (view != null) {
            ((AdCanvasComponentView) view).onActivityResume();
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdCanvasFixedButtonComponentData getData() {
        return this.gdtCanvasFixedButtonComponentData;
    }

    public AdCanvasFixedButtonComponentView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fixedView = null;
    }

    public AdCanvasFixedButtonComponentView(@NonNull Context context, WeakReference<AdCanvasViewListener> weakReference) {
        super(context, weakReference);
        this.fixedView = null;
    }
}
