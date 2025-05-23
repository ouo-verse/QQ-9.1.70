package com.tencent.ad.tangram.views.canvas.components.title;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCanvasTitleComponentView extends AdCanvasComponentView {
    private static final int DEFAULT_TEXT_PADDING = 10;
    private static final String TAG = "AdCanvasTitleComponentView";

    @Nullable
    private AdCanvasTitleComponentData value;

    public AdCanvasTitleComponentView(@NonNull Context context, WeakReference<AdCanvasViewListener> weakReference, AdCanvasTitleComponentData adCanvasTitleComponentData) {
        super(context, weakReference);
        init(context, adCanvasTitleComponentData);
    }

    private void init(@Nullable Context context, @Nullable AdCanvasTitleComponentData adCanvasTitleComponentData) {
        startLoad();
        if (context != null && adCanvasTitleComponentData != null && adCanvasTitleComponentData.isValid()) {
            this.value = adCanvasTitleComponentData;
            RelativeLayout relativeLayout = new RelativeLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            AdCanvasTitleComponentData adCanvasTitleComponentData2 = this.value;
            layoutParams.leftMargin = adCanvasTitleComponentData2.marginLeft;
            layoutParams.rightMargin = adCanvasTitleComponentData2.marginRight;
            layoutParams.topMargin = adCanvasTitleComponentData2.marginTop;
            layoutParams.bottomMargin = adCanvasTitleComponentData2.marginBottom;
            relativeLayout.setBackgroundColor(adCanvasTitleComponentData2.backgroundColor);
            addView(relativeLayout, layoutParams);
            TextView textView = new TextView(context);
            textView.setText(adCanvasTitleComponentData.adTextData.text);
            textView.setTextSize(adCanvasTitleComponentData.adTextData.size);
            textView.setTextColor(adCanvasTitleComponentData.adTextData.color);
            textView.setGravity(adCanvasTitleComponentData.textAlignGravity);
            if (adCanvasTitleComponentData.adTextData.weight.equals("bold")) {
                textView.getPaint().setFakeBoldText(true);
            }
            setDecorationType(context, relativeLayout, this.value, textView);
            stopLoad(true);
            return;
        }
        stopLoad(false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void setDecorationType(@NonNull Context context, @NonNull RelativeLayout relativeLayout, @NonNull AdCanvasTitleComponentData adCanvasTitleComponentData, @NonNull TextView textView) {
        char c16;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(adCanvasTitleComponentData.justifyContent);
        String str = adCanvasTitleComponentData.titleDecorationType;
        str.hashCode();
        switch (str.hashCode()) {
            case -1621218170:
                if (str.equals("left-underline")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case -691523076:
                if (str.equals("title-normal")) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3317767:
                if (str.equals("left")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 55395275:
                if (str.equals("left-bg")) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case 530693527:
                if (str.equals("title-underline")) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
            case 4:
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setId(4660);
                linearLayout.setOrientation(1);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(adCanvasTitleComponentData.justifyContent);
                relativeLayout.addView(linearLayout, layoutParams2);
                linearLayout.addView(textView, layoutParams);
                RelativeLayout relativeLayout2 = new RelativeLayout(context);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, AdUIUtils.dp2px(2.0f, context.getResources()));
                relativeLayout2.setBackgroundColor(adCanvasTitleComponentData.decoration);
                setTextViewPadding(textView, adCanvasTitleComponentData.textAlignGravity, layoutParams3);
                linearLayout.addView(relativeLayout2, layoutParams3);
                View relativeLayout3 = new RelativeLayout(context);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, AdUIUtils.dp2px(2.0f, context.getResources()));
                layoutParams4.addRule(3, linearLayout.getId());
                if ("left-underline".equals(adCanvasTitleComponentData.titleDecorationType)) {
                    relativeLayout3.setBackgroundColor(adCanvasTitleComponentData.backgroundColor);
                } else {
                    relativeLayout3.setBackgroundColor(Color.parseColor("#eeeeee"));
                }
                relativeLayout.addView(relativeLayout3, layoutParams4);
                return;
            case 1:
                setTextViewPadding(textView, adCanvasTitleComponentData.textAlignGravity, null);
                relativeLayout.addView(textView, layoutParams);
                return;
            case 2:
            case 3:
                LinearLayout linearLayout2 = new LinearLayout(context);
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams5.addRule(adCanvasTitleComponentData.justifyContent);
                relativeLayout.addView(linearLayout2, layoutParams5);
                RelativeLayout relativeLayout4 = new RelativeLayout(context);
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(AdUIUtils.dp2px(4.0f, context.getResources()), -1);
                relativeLayout4.setBackgroundColor(adCanvasTitleComponentData.decoration);
                linearLayout2.addView(relativeLayout4, layoutParams6);
                setTextViewPadding(textView, adCanvasTitleComponentData.textAlignGravity, null);
                linearLayout2.addView(textView, layoutParams);
                return;
            default:
                AdLog.e(TAG, "type error");
                return;
        }
    }

    private void setTextViewPadding(@NonNull TextView textView, int i3, @Nullable RelativeLayout.LayoutParams layoutParams) {
        Resources resources;
        if (getContext() != null) {
            resources = getContext().getResources();
        } else {
            resources = null;
        }
        if (textView == null) {
            return;
        }
        if (i3 == 8388611) {
            textView.setPadding(10, AdUIUtils.dp2px(4.0f, resources), 0, AdUIUtils.dp2px(4.0f, resources));
            if (layoutParams != null) {
                layoutParams.setMargins(10, 0, 0, 0);
            }
        } else if (i3 == 8388613) {
            textView.setPadding(0, AdUIUtils.dp2px(4.0f, resources), 10, AdUIUtils.dp2px(4.0f, resources));
            if (layoutParams != null) {
                layoutParams.setMargins(10, 0, 0, 0);
            }
        } else {
            textView.setPadding(0, AdUIUtils.dp2px(4.0f, resources), 0, AdUIUtils.dp2px(4.0f, resources));
        }
        textView.setIncludeFontPadding(false);
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdViewStatus getStatus() {
        return this.status;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdCanvasTitleComponentData getData() {
        return this.value;
    }
}
