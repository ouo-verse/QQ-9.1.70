package com.tencent.sqshow.zootopia.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.graphics.ColorUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/ZootopiaMaskView;", "Landroid/widget/FrameLayout;", "", "color", "", "needMiddle", "", "setMaskBackground", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "d", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaMaskView extends FrameLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaMaskView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setMaskBackground(String color, boolean needMiddle) {
        int i3;
        int i16;
        int[] iArr;
        if (getChildCount() > 0) {
            removeAllViews();
        }
        if (TextUtils.isEmpty(color)) {
            return;
        }
        try {
            i3 = Color.parseColor(color);
            try {
                i16 = ColorUtils.setAlphaComponent(i3, 180);
            } catch (IllegalArgumentException unused) {
                QLog.e("ZootopiaMaskView", 2, "Unknown color");
                i16 = 0;
                if (!needMiddle) {
                }
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setGradientType(0);
                gradientDrawable.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
                gradientDrawable.setColors(iArr);
                setBackgroundDrawable(gradientDrawable);
            }
        } catch (IllegalArgumentException unused2) {
            i3 = 0;
        }
        if (!needMiddle) {
            iArr = new int[]{i3, i16, 0};
        } else {
            iArr = new int[]{i3, 0};
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setGradientType(0);
        gradientDrawable2.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        gradientDrawable2.setColors(iArr);
        setBackgroundDrawable(gradientDrawable2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaMaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaMaskView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaMaskView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void setMaskBackground$default(ZootopiaMaskView zootopiaMaskView, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        zootopiaMaskView.setMaskBackground(str, z16);
    }
}
