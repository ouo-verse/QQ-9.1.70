package com.tencent.ad.tangram.views.canvas.components.fixedbutton;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.canvas.AdTimeStatistics;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentView;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCanvasFixedButtonWithComplexStyle extends AdCanvasComponentView implements AdImageViewAdapter.Callback {
    private static final int DOWNLOAD_BUTTON_HEIGHT = 40;
    private static final int DOWNLOAD_BUTTON_WIDTH = 81;
    private static final int LOGO_WIDTH = 56;
    private static final int RIGHT_MARGIN = 20;

    @NonNull
    private static final String TAG = "GdtCanvasFixedButtonComplexStyle";
    private AdCanvasAppBtnComponentView gdtCanvasAppBtnComponentView;

    @Nullable
    private View imageView;
    private final WeakReference<AdImageViewBuilder.Listener> imageViewlistener;

    public AdCanvasFixedButtonWithComplexStyle(@NonNull Context context) {
        super(context);
        this.imageViewlistener = new WeakReference<>(new AdImageViewBuilder.Listener() { // from class: com.tencent.ad.tangram.views.canvas.components.fixedbutton.AdCanvasFixedButtonWithComplexStyle.1
            @Override // com.tencent.ad.tangram.image.AdImageViewBuilder.Listener
            public void onStopLoad(boolean z16) {
                AdCanvasFixedButtonWithComplexStyle.this.onStopLoad(z16);
            }
        });
    }

    private void notifyLoaded(boolean z16) {
        WeakReference<AdCanvasViewListener> weakReference = this.canvasViewListener;
        if (weakReference != null && this.loadTimeStatistics != null) {
            AdCanvasViewListener adCanvasViewListener = weakReference.get();
            if (adCanvasViewListener != null) {
                long time = this.loadTimeStatistics.getTime();
                if (time < 0) {
                    return;
                }
                adCanvasViewListener.onLoaded(getData(), time, z16);
                return;
            }
            return;
        }
        AdLog.e(TAG, "notifyLoaded error");
    }

    public void doClick() {
        AdCanvasAppBtnComponentView adCanvasAppBtnComponentView = this.gdtCanvasAppBtnComponentView;
        if (adCanvasAppBtnComponentView != null) {
            adCanvasAppBtnComponentView.doClick();
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdCanvasComponentData getData() {
        return null;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdViewStatus getStatus() {
        return this.status;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    public void onActivityDestroy() {
        AdCanvasAppBtnComponentView adCanvasAppBtnComponentView = this.gdtCanvasAppBtnComponentView;
        if (adCanvasAppBtnComponentView != null) {
            adCanvasAppBtnComponentView.onActivityDestroy();
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    public void onActivityResume() {
        AdCanvasAppBtnComponentView adCanvasAppBtnComponentView = this.gdtCanvasAppBtnComponentView;
        if (adCanvasAppBtnComponentView != null) {
            adCanvasAppBtnComponentView.onActivityResume();
        }
    }

    @Override // com.tencent.ad.tangram.image.AdImageViewAdapter.Callback
    public void onStopLoad(boolean z16) {
        stopLoad(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    public void stopLoad(boolean z16) {
        AdTimeStatistics adTimeStatistics = this.loadTimeStatistics;
        if (adTimeStatistics != null) {
            adTimeStatistics.stop();
        }
        notifyLoaded(z16);
        this.loadTimeStatistics = null;
    }

    public AdCanvasFixedButtonWithComplexStyle(@NonNull final Context context, @NonNull AdCanvasFixedButtonComponentData adCanvasFixedButtonComponentData, @NonNull Ad ad5, WeakReference<AdCanvasViewListener> weakReference) {
        super(context);
        WeakReference<AdImageViewBuilder.Listener> weakReference2 = new WeakReference<>(new AdImageViewBuilder.Listener() { // from class: com.tencent.ad.tangram.views.canvas.components.fixedbutton.AdCanvasFixedButtonWithComplexStyle.1
            @Override // com.tencent.ad.tangram.image.AdImageViewBuilder.Listener
            public void onStopLoad(boolean z16) {
                AdCanvasFixedButtonWithComplexStyle.this.onStopLoad(z16);
            }
        });
        this.imageViewlistener = weakReference2;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AdUIUtils.dp2px(76.0f, context.getResources()));
        relativeLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        addView(relativeLayout, layoutParams);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(1365);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = AdUIUtils.dp2px(10.0f, context.getResources());
        layoutParams2.leftMargin = AdUIUtils.dp2px(9.0f, context.getResources());
        relativeLayout.addView(frameLayout, layoutParams2);
        AdImageViewBuilder.Params params = new AdImageViewBuilder.Params();
        params.context = new WeakReference<>(getContext());
        params.url = adCanvasFixedButtonComponentData.imageUrl;
        params.callback = new WeakReference<>(this);
        params.listener = weakReference2;
        View buildImageView = AdImageViewBuilder.getInstance().buildImageView(params);
        this.imageView = buildImageView;
        if (buildImageView == null) {
            AdLog.e(TAG, "build image failed");
            stopLoad(false);
            return;
        }
        frameLayout.addView(buildImageView);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.addRule(15, -1);
        layoutParams3.addRule(1, frameLayout.getId());
        relativeLayout.addView(relativeLayout2, layoutParams3);
        RelativeLayout relativeLayout3 = new RelativeLayout(context);
        relativeLayout3.setId(1638);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = AdUIUtils.dp2px(10.0f, context.getResources());
        layoutParams4.rightMargin = AdUIUtils.dp2px(10.0f, context.getResources());
        layoutParams4.addRule(11, -1);
        layoutParams4.addRule(15, -1);
        relativeLayout2.addView(relativeLayout3, layoutParams4);
        this.gdtCanvasAppBtnComponentView = new AdCanvasAppBtnComponentView(context, weakReference, adCanvasFixedButtonComponentData, true, true);
        relativeLayout3.addView(this.gdtCanvasAppBtnComponentView, new RelativeLayout.LayoutParams(AdUIUtils.dp2px(81.0f, getContext() != null ? getContext().getResources() : null), AdUIUtils.dp2px(40.0f, getContext() != null ? getContext().getResources() : null)));
        final TextView textView = new TextView(context);
        textView.setId(2457);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = AdUIUtils.dp2px(15.0f, context.getResources());
        layoutParams5.leftMargin = AdUIUtils.dp2px(10.0f, context.getResources());
        textView.setMaxWidth(AdUIUtils.dp2px(120.0f, context.getResources()));
        textView.setText(ad5.getAppName());
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(Color.parseColor("#000000"));
        textView.setTextSize(18.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        relativeLayout2.addView(textView, layoutParams5);
        final TextView textView2 = new TextView(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = AdUIUtils.dp2px(20.0f, context.getResources());
        layoutParams6.leftMargin = AdUIUtils.dp2px(10.0f, context.getResources());
        layoutParams6.rightMargin = AdUIUtils.dp2px(10.0f, context.getResources());
        layoutParams6.addRule(1, textView.getId());
        layoutParams6.addRule(0, relativeLayout3.getId());
        textView2.setMaxLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setTextColor(Color.parseColor("#80000000"));
        textView2.setTextSize(14.0f);
        relativeLayout2.addView(textView2, layoutParams6);
        textView2.setText(AdUIUtils.getFileSizeDesc(adCanvasFixedButtonComponentData.fileSize));
        TextView textView3 = new TextView(context);
        textView3.setId(1911);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.bottomMargin = AdUIUtils.dp2px(15.0f, context.getResources());
        layoutParams7.leftMargin = AdUIUtils.dp2px(10.0f, context.getResources());
        layoutParams7.addRule(12, -1);
        textView3.setLayoutParams(layoutParams7);
        textView3.setMaxLines(1);
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setTextColor(Color.parseColor("#CC000000"));
        textView3.setTextSize(12.0f);
        relativeLayout2.addView(textView3, layoutParams7);
        textView3.setText(adCanvasFixedButtonComponentData.desc);
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) textView3.getLayoutParams();
        layoutParams8.setMargins(layoutParams8.leftMargin, layoutParams8.topMargin, layoutParams8.rightMargin + AdUIUtils.dp2px(101.0f, getContext() != null ? getContext().getResources() : null), layoutParams8.bottomMargin);
        final float measureText = textView2.getPaint().measureText(textView2.getText().toString());
        post(new Runnable() { // from class: com.tencent.ad.tangram.views.canvas.components.fixedbutton.AdCanvasFixedButtonWithComplexStyle.2
            @Override // java.lang.Runnable
            public void run() {
                int width = textView2.getWidth();
                int measuredWidth = textView.getMeasuredWidth();
                if (width > 0) {
                    float f16 = measureText;
                    float f17 = width;
                    if (f16 > f17) {
                        textView2.setWidth((int) f16);
                        textView.setWidth((int) (measuredWidth - (measureText - f17)));
                    }
                }
            }
        });
        this.imageView.post(new Runnable() { // from class: com.tencent.ad.tangram.views.canvas.components.fixedbutton.AdCanvasFixedButtonWithComplexStyle.3
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams9 = AdCanvasFixedButtonWithComplexStyle.this.imageView.getLayoutParams();
                int dp2px = AdUIUtils.dp2px(56.0f, context.getResources());
                layoutParams9.width = dp2px;
                layoutParams9.height = dp2px;
                AdCanvasFixedButtonWithComplexStyle.this.imageView.setLayoutParams(layoutParams9);
            }
        });
    }
}
