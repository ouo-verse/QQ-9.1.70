package com.tencent.sqshow.zootopia.nativeui.view.color.list;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.sqshow.zootopia.utils.i;
import da4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import qu4.l;
import qu4.p;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011B\u001f\b\u0017\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0010\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/color/list/CircleColorView;", "Landroid/view/View;", "Lqu4/p;", "singleColor", "", "setSingleColor", "Lqu4/l;", "gradientColor", "setGradientColor", "setHueColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CircleColorView extends View {
    public CircleColorView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    public final void setHueColor(l gradientColor) {
        p pVar;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(a.f393479a.b((gradientColor == null || (pVar = gradientColor.f429615b) == null) ? 0 : pVar.f429637b));
        gradientDrawable.setCornerRadius(i.e(30));
        setBackground(gradientDrawable);
    }

    public final void setSingleColor(p singleColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(a.f393479a.b(singleColor != null ? singleColor.f429637b : 0));
        gradientDrawable.setCornerRadius(i.e(30));
        setBackground(gradientDrawable);
    }

    public CircleColorView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public final void setGradientColor(l gradientColor) {
        p pVar;
        p pVar2;
        int[] iArr = new int[2];
        a aVar = a.f393479a;
        int i3 = 0;
        iArr[0] = aVar.b((gradientColor == null || (pVar2 = gradientColor.f429615b) == null) ? 0 : pVar2.f429637b);
        if (gradientColor != null && (pVar = gradientColor.f429616c) != null) {
            i3 = pVar.f429637b;
        }
        iArr[1] = aVar.b(i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(iArr);
        gradientDrawable.setCornerRadius(i.e(30));
        setBackground(gradientDrawable);
    }

    public CircleColorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public /* synthetic */ CircleColorView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
