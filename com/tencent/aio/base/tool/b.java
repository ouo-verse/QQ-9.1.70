package com.tencent.aio.base.tool;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004JZ\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/aio/base/tool/b;", "", "Landroid/content/Context;", "context", "", "size", "b", "width", "height", "Landroid/widget/FrameLayout$LayoutParams;", "a", "Landroid/view/View;", "child", "parentWidthMeasureSpec", "widthUsed", "parentHeightMeasureSpec", "heightUsed", NodeProps.PADDING_LEFT, NodeProps.PADDING_RIGHT, NodeProps.PADDING_TOP, NodeProps.PADDING_BOTTOM, "", "c", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f69219a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31708);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f69219a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    private final int b(Context context, int size) {
        if (size >= 0) {
            return a.INSTANCE.b(context, size);
        }
        return size;
    }

    public static /* synthetic */ void d(b bVar, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, Object obj) {
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        if ((i29 & 4) != 0) {
            i36 = 0;
        } else {
            i36 = i16;
        }
        if ((i29 & 16) != 0) {
            i37 = 0;
        } else {
            i37 = i18;
        }
        if ((i29 & 32) != 0) {
            i38 = 0;
        } else {
            i38 = i19;
        }
        if ((i29 & 64) != 0) {
            i39 = 0;
        } else {
            i39 = i26;
        }
        if ((i29 & 128) != 0) {
            i46 = 0;
        } else {
            i46 = i27;
        }
        if ((i29 & 256) != 0) {
            i47 = 0;
        } else {
            i47 = i28;
        }
        bVar.c(view, i3, i36, i17, i37, i38, i39, i46, i47);
    }

    @NotNull
    public final FrameLayout.LayoutParams a(@NotNull Context context, int width, int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (FrameLayout.LayoutParams) iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(width), Integer.valueOf(height));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new FrameLayout.LayoutParams(b(context, width), b(context, height));
    }

    public final void c(@NotNull View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed, int paddingLeft, int paddingRight, int paddingTop, int paddingBottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, child, Integer.valueOf(parentWidthMeasureSpec), Integer.valueOf(widthUsed), Integer.valueOf(parentHeightMeasureSpec), Integer.valueOf(heightUsed), Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight), Integer.valueOf(paddingTop), Integer.valueOf(paddingBottom));
            return;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            child.measure(ViewGroup.getChildMeasureSpec(parentWidthMeasureSpec, paddingLeft + paddingRight + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + widthUsed, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(parentHeightMeasureSpec, paddingTop + paddingBottom + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + heightUsed, marginLayoutParams.height));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
