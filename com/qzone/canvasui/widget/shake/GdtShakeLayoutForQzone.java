package com.qzone.canvasui.widget.shake;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.gdtad.views.shake.GdtShakeIconView;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class GdtShakeLayoutForQzone extends GdtShakeLayoutForQzoneBase {
    private static final String TAG = "GdtShakeLayoutForQzone";
    private final LinearLayout mContainerLayout;

    public GdtShakeLayoutForQzone(Context context) {
        this(context, null);
    }

    private void initContainerLayout() {
        this.mContainerLayout.setOrientation(0);
        this.mContainerLayout.setGravity(17);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.weight = 1.0f;
        this.mContainerLayout.addView(view, layoutParams);
        int i3 = AreaConst.dp36;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i3);
        layoutParams2.gravity = 16;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(AreaConst.dp18);
        gradientDrawable.setColor(2080374784);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this.mShakeIconView, layoutParams2);
        frameLayout.setBackground(gradientDrawable);
        this.mContainerLayout.addView(frameLayout);
        TextView textView = new TextView(getContext());
        textView.setText("\u6447\u4e00\u6447\u4e86\u89e3\u66f4\u591a");
        textView.setIncludeFontPadding(false);
        textView.setTextColor(-1);
        textView.setTextSize(1, 14.0f);
        textView.setGravity(17);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams3.leftMargin = AreaConst.dp5;
        this.mContainerLayout.addView(textView, layoutParams3);
        View view2 = new View(getContext());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.weight = 1.0f;
        this.mContainerLayout.addView(view2, layoutParams4);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColors(new int[]{0, HWColorFormat.COLOR_FormatVendorStartUnused});
        gradientDrawable2.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        setBackground(gradientDrawable2);
    }

    public GdtShakeLayoutForQzone(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        GdtShakeIconView gdtShakeIconView = this.mShakeIconView;
        int i3 = AreaConst.dp6;
        gdtShakeIconView.setPadding(i3, i3, i3, i3);
        LinearLayout linearLayout = new LinearLayout(context);
        this.mContainerLayout = linearLayout;
        initContainerLayout();
        addView(linearLayout);
    }
}
