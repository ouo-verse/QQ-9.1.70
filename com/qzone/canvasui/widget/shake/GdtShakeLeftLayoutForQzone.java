package com.qzone.canvasui.widget.shake;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.tencent.gdtad.views.shake.GdtShakeIconView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GdtShakeLeftLayoutForQzone extends GdtShakeLayoutForQzoneBase {
    private static final String TAG = "GdtShakeLeftLayoutForQzone";
    private boolean hasAddText;
    private final LinearLayout mContainerLayout;

    public GdtShakeLeftLayoutForQzone(Context context) {
        this(context, null);
    }

    private void initContainerLayout() {
        this.mContainerLayout.setOrientation(0);
        this.mContainerLayout.setGravity(80);
        int i3 = AreaConst.dp25;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 16;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(AreaConst.f48747dp2);
        gradientDrawable.setColor(2080374784);
        this.mContainerLayout.setBackground(gradientDrawable);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this.mShakeIconView, layoutParams);
        this.mContainerLayout.addView(frameLayout);
    }

    public void addGuideText(String str) {
        if (this.hasAddText) {
            return;
        }
        this.hasAddText = true;
        TextView textView = new TextView(getContext());
        if (TextUtils.isEmpty(str)) {
            str = "\u6447\u4e00\u6447\u4e86\u89e3\u66f4\u591a";
        }
        textView.setText(str);
        textView.setIncludeFontPadding(false);
        textView.setTextColor(-1);
        textView.setTextSize(1, 12.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int i3 = AreaConst.f48747dp2;
        int i16 = AreaConst.dp5;
        textView.setPadding(i3, i16, i16, i16);
        this.mContainerLayout.addView(textView, layoutParams);
    }

    public GdtShakeLeftLayoutForQzone(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hasAddText = false;
        GdtShakeIconView gdtShakeIconView = this.mShakeIconView;
        int i3 = AreaConst.dp5;
        gdtShakeIconView.setPadding(i3, i3, i3, i3);
        LinearLayout linearLayout = new LinearLayout(context);
        this.mContainerLayout = linearLayout;
        initContainerLayout();
        addView(linearLayout);
    }
}
