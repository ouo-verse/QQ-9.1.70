package com.tencent.aio.part.root.panel.content.thirdLevel.mvx.layout;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aio.api.b;
import com.tencent.aio.api.c;
import com.tencent.aio.part.root.panel.content.thirdLevel.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00130\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J0\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016R(\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/thirdLevel/mvx/layout/a;", "Lcom/tencent/aio/api/b;", "Lcom/tencent/aio/part/root/panel/content/thirdLevel/b;", "type", "Landroid/view/View;", "d", "", "parentWidthMeasureSpec", "parentHeightMeasureSpec", "Lcom/tencent/aio/api/c;", "parentPadding", "", "c", "parentLeft", "parentTop", "parentRight", "parentBottom", "a", "", "Lcom/tencent/aio/base/mvvm/a;", "Ljava/util/Map;", "childrenVB", "<init>", "(Ljava/util/Map;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<com.tencent.aio.part.root.panel.content.thirdLevel.b, com.tencent.aio.base.mvvm.a<?, ?>> childrenVB;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Map<com.tencent.aio.part.root.panel.content.thirdLevel.b, ? extends com.tencent.aio.base.mvvm.a<?, ?>> childrenVB) {
        Intrinsics.checkNotNullParameter(childrenVB, "childrenVB");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) childrenVB);
        } else {
            this.childrenVB = childrenVB;
        }
    }

    private final View d(com.tencent.aio.part.root.panel.content.thirdLevel.b type) {
        com.tencent.aio.base.mvvm.a<?, ?> aVar = this.childrenVB.get(type);
        if (aVar != null) {
            return aVar.getHostView();
        }
        return null;
    }

    @Override // com.tencent.aio.api.b
    public void a(int parentLeft, int parentTop, int parentRight, int parentBottom, @NotNull c parentPadding) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(parentLeft), Integer.valueOf(parentTop), Integer.valueOf(parentRight), Integer.valueOf(parentBottom), parentPadding);
            return;
        }
        Intrinsics.checkNotNullParameter(parentPadding, "parentPadding");
        int i16 = parentBottom - 0;
        View d16 = d(b.d.f69712b);
        if (d16 != null) {
            ViewGroup.LayoutParams layoutParams = d16.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i17 = marginLayoutParams.leftMargin + 0;
                int i18 = marginLayoutParams.topMargin + 0;
                d16.layout(i17, i18, d16.getMeasuredWidth() + i17, d16.getMeasuredHeight() + i18);
                i3 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + d16.getMeasuredHeight() + 0;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        } else {
            i3 = 0;
        }
        View d17 = d(b.e.f69713b);
        if (d17 != null) {
            ViewGroup.LayoutParams layoutParams2 = d17.getLayoutParams();
            if (layoutParams2 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                int i19 = marginLayoutParams2.leftMargin + 0;
                int i26 = i3 + marginLayoutParams2.topMargin;
                d17.layout(i19, i26, d17.getMeasuredWidth() + i19, d17.getMeasuredHeight() + i26);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
        View d18 = d(b.c.f69711b);
        if (d18 != null) {
            ViewGroup.LayoutParams layoutParams3 = d18.getLayoutParams();
            if (layoutParams3 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                int i27 = marginLayoutParams3.leftMargin + 0;
                int i28 = i16 - marginLayoutParams3.bottomMargin;
                d18.layout(i27, i28 - d18.getMeasuredHeight(), d18.getMeasuredWidth() + i27, i28);
                i16 = ((i16 - marginLayoutParams3.bottomMargin) - marginLayoutParams3.topMargin) - d18.getMeasuredHeight();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
        View d19 = d(b.C0651b.f69710b);
        if (d19 != null) {
            ViewGroup.LayoutParams layoutParams4 = d19.getLayoutParams();
            if (layoutParams4 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                int i29 = marginLayoutParams4.leftMargin + 0;
                int i36 = i16 - marginLayoutParams4.bottomMargin;
                d19.layout(i29, i36 - d19.getMeasuredHeight(), d19.getMeasuredWidth() + i29, i36);
                i16 = ((i16 - marginLayoutParams4.bottomMargin) - marginLayoutParams4.topMargin) - d19.getMeasuredHeight();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
        View d26 = d(b.a.f69709b);
        if (d26 != null) {
            ViewGroup.LayoutParams layoutParams5 = d26.getLayoutParams();
            if (layoutParams5 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams5;
                int i37 = marginLayoutParams5.leftMargin + 0;
                int i38 = i16 - marginLayoutParams5.bottomMargin;
                d26.layout(i37, i38 - d26.getMeasuredHeight(), d26.getMeasuredWidth() + i37, i38);
                d26.getMeasuredHeight();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    @Override // com.tencent.aio.api.b
    public void b(@Nullable Canvas canvas, @NotNull c parentPadding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas, (Object) parentPadding);
        } else {
            Intrinsics.checkNotNullParameter(parentPadding, "parentPadding");
            b.a.a(this, canvas, parentPadding);
        }
    }

    @Override // com.tencent.aio.api.b
    public void c(int parentWidthMeasureSpec, int parentHeightMeasureSpec, @NotNull c parentPadding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(parentWidthMeasureSpec), Integer.valueOf(parentHeightMeasureSpec), parentPadding);
            return;
        }
        Intrinsics.checkNotNullParameter(parentPadding, "parentPadding");
        View d16 = d(b.d.f69712b);
        if (d16 != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, d16, parentWidthMeasureSpec, 0, parentHeightMeasureSpec, 0, 0, 0, parentPadding.d(), parentPadding.a(), 116, null);
        }
        View d17 = d(b.e.f69713b);
        if (d17 != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, d17, parentWidthMeasureSpec, 0, parentHeightMeasureSpec, 0, 0, 0, parentPadding.d(), parentPadding.a(), 116, null);
        }
        View d18 = d(b.c.f69711b);
        if (d18 != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, d18, parentWidthMeasureSpec, 0, parentHeightMeasureSpec, 0, 0, 0, parentPadding.d(), parentPadding.a(), 116, null);
        }
        View d19 = d(b.C0651b.f69710b);
        if (d19 != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, d19, parentWidthMeasureSpec, 0, parentHeightMeasureSpec, 0, 0, 0, parentPadding.d(), parentPadding.a(), 116, null);
        }
        View d26 = d(b.a.f69709b);
        if (d26 != null) {
            com.tencent.aio.base.tool.b.d(com.tencent.aio.base.tool.b.f69219a, d26, parentWidthMeasureSpec, 0, parentHeightMeasureSpec, 0, 0, 0, parentPadding.d(), parentPadding.a(), 116, null);
        }
    }
}
