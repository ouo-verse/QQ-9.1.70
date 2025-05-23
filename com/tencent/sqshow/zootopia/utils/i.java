package com.tencent.sqshow.zootopia.utils;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0012\"(\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"\u0015\u0010\f\u001a\u00020\t*\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\u000f\u001a\u00020\t*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u000f\u001a\u00020\t*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014\"\u0015\u0010\u001a\u001a\u00020\u0001*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Landroid/widget/TextView;", "", "value", "g", "(Landroid/widget/TextView;)F", "i", "(Landroid/widget/TextView;F)V", "textSizeDp", "Landroid/view/View;", "", tl.h.F, "(Landroid/view/View;)I", ParseCommon.LAYOUT_PARAMS_WRAP_CONTENT, "a", "(F)I", "dp", "d", "(F)F", "dpf", "e", "(I)F", "b", "(I)I", "f", "px2dp", "c", "dp2px", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class i {
    public static final int a(float f16) {
        return Utils.n(f16, BaseApplication.getContext().getResources());
    }

    public static final float d(float f16) {
        return Utils.o(f16, BaseApplication.getContext().getResources());
    }

    public static final float f(int i3) {
        return Utils.R(i3, BaseApplication.getContext().getResources());
    }

    public static final float g(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        return textView.getTextSize();
    }

    public static final int h(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return -2;
    }

    public static final void i(TextView textView, float f16) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setTextSize(1, f16);
    }

    public static final int b(int i3) {
        return Utils.n(i3, BaseApplication.getContext().getResources());
    }

    public static final float c(int i3) {
        return Utils.o(i3, BaseApplication.getContext().getResources());
    }

    public static final float e(int i3) {
        return Utils.o(i3, BaseApplication.getContext().getResources());
    }
}
