package com.tencent.mobileqq.intimate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J0\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0014R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/intimate/CircleLayout;", "Landroid/view/ViewGroup;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "", "changed", "l", "t", "r", "b", "onLayout", "d", "I", "getMRadius", "()I", "setMRadius", "(I)V", "mRadius", "e", "getChildViewSize", "setChildViewSize", "childViewSize", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class CircleLayout extends ViewGroup {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mRadius;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int childViewSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CircleLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
        double d16;
        CircleLayout circleLayout = this;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, circleLayout, Boolean.valueOf(changed), Integer.valueOf(l3), Integer.valueOf(t16), Integer.valueOf(r16), Integer.valueOf(b16));
            return;
        }
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int childCount = getChildCount();
        if (childCount == 2) {
            d16 = 3.141592653589793d;
        } else {
            d16 = 1.5707963267948966d;
        }
        while (i3 < childCount) {
            View childAt = circleLayout.getChildAt(i3);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            double d17 = ((i3 * 6.283185307179586d) / childCount) - d16;
            double cos = (width + (circleLayout.mRadius * Math.cos(d17))) - (measuredWidth / 2);
            double sin = (height + (circleLayout.mRadius * Math.sin(d17))) - (measuredHeight / 2);
            childAt.layout((int) cos, (int) sin, (int) (cos + measuredWidth), (int) (sin + measuredHeight));
            i3++;
            circleLayout = this;
            width = width;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            measureChild(getChildAt(i3), widthMeasureSpec, heightMeasureSpec);
        }
        int i16 = this.mRadius;
        int i17 = this.childViewSize;
        setMeasuredDimension((i16 * 2) + i17, (i16 * 2) + i17);
    }

    public final void setChildViewSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.childViewSize = i3;
        }
    }

    public final void setMRadius(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mRadius = i3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CircleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mRadius = ViewUtils.dpToPx(100.0f);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public /* synthetic */ CircleLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
