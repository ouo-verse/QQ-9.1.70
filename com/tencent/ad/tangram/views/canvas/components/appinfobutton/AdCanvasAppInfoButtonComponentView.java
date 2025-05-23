package com.tencent.ad.tangram.views.canvas.components.appinfobutton;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentView;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import cooperation.qzone.util.WnsError;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCanvasAppInfoButtonComponentView extends AdCanvasComponentView implements AdImageViewAdapter.Callback {
    private static final String TAG = "GdtCanvasAppInfoButtonComponentView";

    @Nullable
    private AdCanvasAppInfoButtonComponentData data;
    private AdCanvasAppBtnComponentView gdtCanvasAppBtnComponentView;

    @Nullable
    private View imageView;
    private final WeakReference<AdImageViewBuilder.Listener> imageViewlistener;

    public AdCanvasAppInfoButtonComponentView(@NonNull Context context) {
        super(context);
        this.imageViewlistener = new WeakReference<>(new AdImageViewBuilder.Listener() { // from class: com.tencent.ad.tangram.views.canvas.components.appinfobutton.AdCanvasAppInfoButtonComponentView.1
            @Override // com.tencent.ad.tangram.image.AdImageViewBuilder.Listener
            public void onStopLoad(boolean z16) {
                AdCanvasAppInfoButtonComponentView.this.onStopLoad(z16);
            }
        });
    }

    private void init(@NonNull Context context, WeakReference<AdCanvasViewListener> weakReference, @Nullable AdCanvasAppInfoButtonComponentData adCanvasAppInfoButtonComponentData, boolean z16) {
        startLoad();
        if (adCanvasAppInfoButtonComponentData != null && getResources() != null) {
            this.data = adCanvasAppInfoButtonComponentData;
            setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            setPadding(getData().paddingLeft, getData().paddingTop, getData().paddingRight, getData().paddingBottom);
            RelativeLayout relativeLayout = new RelativeLayout(context);
            addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -2));
            RelativeLayout relativeLayout2 = new RelativeLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            relativeLayout2.setBackgroundColor(adCanvasAppInfoButtonComponentData.backgroundColor);
            int dp2px = AdUIUtils.dp2px(12.0f, context.getResources());
            layoutParams.rightMargin = dp2px;
            layoutParams.leftMargin = dp2px;
            layoutParams.bottomMargin = dp2px;
            layoutParams.topMargin = AdUIUtils.dp2px(40.0f, context.getResources());
            relativeLayout.addView(relativeLayout2, layoutParams);
            RelativeLayout relativeLayout3 = new RelativeLayout(context);
            relativeLayout3.setId(1365);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(AdUIUtils.dp2px(82.0f, context.getResources()), AdUIUtils.dp2px(82.0f, context.getResources()));
            layoutParams2.addRule(14);
            layoutParams2.topMargin = AdUIUtils.dp2px(10.0f, context.getResources());
            relativeLayout.addView(relativeLayout3, layoutParams2);
            AdImageViewBuilder.Params params = new AdImageViewBuilder.Params();
            params.context = new WeakReference<>(getContext());
            params.url = this.data.logoUrl;
            params.callback = new WeakReference<>(this);
            params.listener = this.imageViewlistener;
            View buildImageView = AdImageViewBuilder.getInstance().buildImageView(params);
            this.imageView = buildImageView;
            if (buildImageView == null) {
                AdLog.e(TAG, "build image failed");
                stopLoad(false);
                return;
            }
            relativeLayout3.addView(buildImageView);
            TextView textView = new TextView(context);
            textView.setId(2457);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = AdUIUtils.dp2px(60.0f, context.getResources());
            layoutParams3.addRule(14);
            layoutParams3.addRule(3, relativeLayout3.getId());
            textView.setMaxWidth(AdUIUtils.dp2px(310.0f, context.getResources()));
            textView.setText(this.data.appName);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextColor(-16777216);
            textView.setTextSize(16.0f);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            relativeLayout2.addView(textView, layoutParams3);
            TextView textView2 = new TextView(context);
            textView2.setId(WnsError.WNS_CODE_LOGIN_B2_EXPIRED);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(14);
            layoutParams4.addRule(3, textView.getId());
            textView2.setMaxWidth(AdUIUtils.dp2px(120.0f, context.getResources()));
            String formatNumberToChineseUnit = AdUIUtils.formatNumberToChineseUnit(this.data.downloadCount);
            String fileSizeDesc = AdUIUtils.getFileSizeDesc(this.data.fileSize);
            if (!TextUtils.isEmpty(formatNumberToChineseUnit)) {
                fileSizeDesc = formatNumberToChineseUnit + " " + fileSizeDesc;
            }
            textView2.setText(fileSizeDesc);
            textView2.setMaxLines(1);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setTextColor(Color.parseColor("#cccccc"));
            textView2.setTextSize(12.0f);
            relativeLayout2.addView(textView2, layoutParams4);
            TextView textView3 = new TextView(context);
            textView3.setId(1911);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
            int dp2px2 = AdUIUtils.dp2px(20.0f, context.getResources());
            layoutParams5.rightMargin = dp2px2;
            layoutParams5.leftMargin = dp2px2;
            int dp2px3 = AdUIUtils.dp2px(5.0f, context.getResources());
            layoutParams5.topMargin = dp2px3;
            layoutParams5.bottomMargin = dp2px3;
            layoutParams5.addRule(14);
            layoutParams5.addRule(3, textView2.getId());
            textView3.setMaxWidth(AdUIUtils.dp2px(310.0f, context.getResources()));
            textView3.setMaxLines(3);
            textView3.setTextColor(-16777216);
            textView3.setTextSize(14.0f);
            textView3.setText(this.data.desc);
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            relativeLayout2.addView(textView3, layoutParams5);
            RelativeLayout relativeLayout4 = new RelativeLayout(context);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams6.addRule(15, -1);
            layoutParams6.addRule(3, textView3.getId());
            relativeLayout2.addView(relativeLayout4, layoutParams6);
            RelativeLayout relativeLayout5 = new RelativeLayout(context);
            relativeLayout5.setId(1638);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams7.topMargin = AdUIUtils.dp2px(10.0f, context.getResources());
            layoutParams7.bottomMargin = AdUIUtils.dp2px(10.0f, context.getResources());
            layoutParams7.addRule(14, -1);
            relativeLayout4.addView(relativeLayout5, layoutParams7);
            this.gdtCanvasAppBtnComponentView = new AdCanvasAppBtnComponentView(context, weakReference, this.data, true, false);
            AdCanvasAppInfoButtonComponentData adCanvasAppInfoButtonComponentData2 = this.data;
            relativeLayout5.addView(this.gdtCanvasAppBtnComponentView, new RelativeLayout.LayoutParams(adCanvasAppInfoButtonComponentData2.width, adCanvasAppInfoButtonComponentData2.height));
            stopLoad(true);
            return;
        }
        AdLog.e(TAG, "init error");
        stopLoad(false);
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdViewStatus getStatus() {
        return this.status;
    }

    @Override // com.tencent.ad.tangram.image.AdImageViewAdapter.Callback
    public void onStopLoad(boolean z16) {
        stopLoad(z16);
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdCanvasAppInfoButtonComponentData getData() {
        return this.data;
    }

    public AdCanvasAppInfoButtonComponentView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.imageViewlistener = new WeakReference<>(new AdImageViewBuilder.Listener() { // from class: com.tencent.ad.tangram.views.canvas.components.appinfobutton.AdCanvasAppInfoButtonComponentView.1
            @Override // com.tencent.ad.tangram.image.AdImageViewBuilder.Listener
            public void onStopLoad(boolean z16) {
                AdCanvasAppInfoButtonComponentView.this.onStopLoad(z16);
            }
        });
    }

    public AdCanvasAppInfoButtonComponentView(@NonNull Context context, WeakReference<AdCanvasViewListener> weakReference, AdCanvasAppInfoButtonComponentData adCanvasAppInfoButtonComponentData, boolean z16) {
        super(context, weakReference);
        this.imageViewlistener = new WeakReference<>(new AdImageViewBuilder.Listener() { // from class: com.tencent.ad.tangram.views.canvas.components.appinfobutton.AdCanvasAppInfoButtonComponentView.1
            @Override // com.tencent.ad.tangram.image.AdImageViewBuilder.Listener
            public void onStopLoad(boolean z162) {
                AdCanvasAppInfoButtonComponentView.this.onStopLoad(z162);
            }
        });
        init(context, weakReference, adCanvasAppInfoButtonComponentData, z16);
    }
}
