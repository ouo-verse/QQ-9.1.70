package com.tencent.ad.tangram.views.canvas.components.appicon;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentData;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentView;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCanvasAppIconComponentView extends AdCanvasComponentView implements AdImageViewAdapter.Callback {
    private static final int DOWNLOAD_BUTTON_TOP_MARGIN = 14;
    private static final String TAG = "GdtCanvasAppIconComponentView";
    private AdCanvasAppBtnComponentView adCanvasAppBtnComponentView;

    @Nullable
    private View imageView;
    private final WeakReference<AdImageViewBuilder.Listener> imageViewlistener;

    @Nullable
    private AdCanvasAppIconComponentData value;

    public AdCanvasAppIconComponentView(@NonNull Context context, WeakReference<AdCanvasViewListener> weakReference, AdCanvasAppIconComponentData adCanvasAppIconComponentData) {
        super(context, weakReference);
        this.imageViewlistener = new WeakReference<>(new AdImageViewBuilder.Listener() { // from class: com.tencent.ad.tangram.views.canvas.components.appicon.AdCanvasAppIconComponentView.1
            @Override // com.tencent.ad.tangram.image.AdImageViewBuilder.Listener
            public void onStopLoad(boolean z16) {
                AdCanvasAppIconComponentView.this.onStopLoad(z16);
            }
        });
        init(context, adCanvasAppIconComponentData);
    }

    private void init(@Nullable Context context, @Nullable AdCanvasAppIconComponentData adCanvasAppIconComponentData) {
        if (context != null && adCanvasAppIconComponentData != null && adCanvasAppIconComponentData.isValid()) {
            this.value = adCanvasAppIconComponentData;
            RelativeLayout relativeLayout = new RelativeLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            addView(relativeLayout);
            AdCanvasAppIconComponentData adCanvasAppIconComponentData2 = this.value;
            layoutParams.leftMargin = adCanvasAppIconComponentData2.marginLeft;
            layoutParams.topMargin = adCanvasAppIconComponentData2.marginTop;
            layoutParams.rightMargin = adCanvasAppIconComponentData2.marginRight;
            layoutParams.bottomMargin = adCanvasAppIconComponentData2.marginBottom;
            relativeLayout.setLayoutParams(layoutParams);
            relativeLayout.setGravity(15);
            AdImageViewBuilder.Params params = new AdImageViewBuilder.Params();
            params.context = new WeakReference<>(context);
            params.url = this.value.logoUrl;
            params.callback = new WeakReference<>(this);
            params.listener = this.imageViewlistener;
            View buildImageView = AdImageViewBuilder.getInstance().buildImageView(params);
            this.imageView = buildImageView;
            if (buildImageView == null) {
                AdLog.e(TAG, "buildImageView Failed");
                stopLoad(false);
                return;
            }
            buildImageView.setId(PlayerResources.RawId.BASE);
            relativeLayout.addView(this.imageView);
            ViewGroup.LayoutParams layoutParams2 = this.imageView.getLayoutParams();
            AdCanvasAppIconComponentData adCanvasAppIconComponentData3 = this.value;
            layoutParams2.width = adCanvasAppIconComponentData3.logoWidth;
            layoutParams2.height = adCanvasAppIconComponentData3.logoHeight;
            this.imageView.setLayoutParams(layoutParams2);
            TextView textView = new TextView(context);
            textView.setId(8738);
            textView.setText(adCanvasAppIconComponentData.name);
            textView.setTextSize(20.0f);
            textView.setMaxLines(1);
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setMaxWidth(AdUIUtils.dp2px(170.0f, context.getResources()));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.getPaint().setFakeBoldText(true);
            relativeLayout.addView(textView);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams3.addRule(1, this.imageView.getId());
            layoutParams3.leftMargin = AdUIUtils.dp2px(15.0f, context.getResources());
            layoutParams3.topMargin = AdUIUtils.dp2px(10.0f, context.getResources());
            TextView textView2 = new TextView(context);
            String formatNumberToChineseUnit = AdUIUtils.formatNumberToChineseUnit(adCanvasAppIconComponentData.downloadCount);
            textView2.setId(13107);
            textView2.setTextColor(Color.parseColor("#8C8C8C"));
            textView2.setMaxLines(1);
            textView2.setMaxWidth(AdUIUtils.dp2px(170.0f, context.getResources()));
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setText(adCanvasAppIconComponentData.starCount + "\u5206 " + formatNumberToChineseUnit + " " + AdUIUtils.getFileSizeDesc(adCanvasAppIconComponentData.fileSize));
            textView2.setTextSize(12.0f);
            relativeLayout.addView(textView2);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
            layoutParams4.addRule(1, this.imageView.getId());
            layoutParams4.addRule(3, textView.getId());
            layoutParams4.leftMargin = AdUIUtils.dp2px(15.0f, context.getResources());
            layoutParams4.topMargin = AdUIUtils.dp2px(5.0f, context.getResources());
            RelativeLayout relativeLayout2 = new RelativeLayout(context);
            relativeLayout2.setId(17476);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.topMargin = AdUIUtils.dp2px(14.0f, context.getResources());
            layoutParams5.addRule(11, -1);
            layoutParams5.addRule(15, -1);
            AdCanvasAppBtnComponentData adCanvasAppBtnComponentData = adCanvasAppIconComponentData.adCanvasAppBtnComponentData;
            adCanvasAppBtnComponentData.canShowProgress = true;
            this.adCanvasAppBtnComponentView = new AdCanvasAppBtnComponentView(context, this.canvasViewListener, adCanvasAppBtnComponentData, true, false);
            AdCanvasAppBtnComponentData adCanvasAppBtnComponentData2 = this.value.adCanvasAppBtnComponentData;
            relativeLayout2.addView(this.adCanvasAppBtnComponentView, new RelativeLayout.LayoutParams(adCanvasAppBtnComponentData2.width, adCanvasAppBtnComponentData2.height));
            relativeLayout.addView(relativeLayout2, layoutParams5);
        }
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdCanvasComponentData getData() {
        return this.value;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdViewStatus getStatus() {
        return this.status;
    }

    @Override // com.tencent.ad.tangram.image.AdImageViewAdapter.Callback
    public void onStopLoad(boolean z16) {
    }
}
