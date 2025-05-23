package com.tencent.android.androidbypass.custom.feedstyle;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.android.androidbypass.custom.b;
import com.tencent.android.androidbypass.custom.e;
import com.tencent.android.androidbypass.custom.f;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0001\u001dB\u001f\u0012\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070(\u0012\u0006\u0010,\u001a\u00020+\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J \u0010\u0014\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019R$\u0010!\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R$\u0010#\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\"\u0010 R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010&R\u001c\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/android/androidbypass/custom/feedstyle/a;", "", "", "newWidth", "", "e", "d", "Lcom/tencent/android/androidbypass/custom/f;", "child", "childLeft", "childTop", "j", "", "reason", "widthRemain", "heightRemain", "", "b", "it", "c", "l", "remain", "measureSizeSpec", "i", "k", "Landroid/graphics/Canvas;", PM.CANVAS, "f", "<set-?>", "a", "I", "g", "()I", "height", h.F, "width", "getMaxHeight", "setMaxHeight", "(I)V", NodeProps.MAX_HEIGHT, "", "[Lcom/tencent/android/androidbypass/custom/f;", Node.CHILDREN_ATTR, "Lcom/tencent/android/androidbypass/custom/b;", "callbackDelegate", "<init>", "([Lcom/tencent/android/androidbypass/custom/f;Lcom/tencent/android/androidbypass/custom/b;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int height;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int width;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int maxHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final f[] children;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/android/androidbypass/custom/feedstyle/a$a;", "", "", "ELEMENT_COUNT", "I", "INDEX_AVATAR", "INDEX_DESC", "INDEX_HEADER", "INDEX_IMAGE", "INDEX_NICKNAME", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.custom.feedstyle.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16816);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull f[] children, @NotNull b callbackDelegate) {
        boolean z16;
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(callbackDelegate, "callbackDelegate");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) children, (Object) callbackDelegate);
            return;
        }
        this.children = children;
        if (children.length > 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            for (f fVar : children) {
                if (fVar != null) {
                    fVar.l(callbackDelegate);
                }
            }
            this.maxHeight = -1;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final boolean b(String reason, int widthRemain, int heightRemain) {
        if (widthRemain > 0 && heightRemain > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void d() {
        boolean z16;
        int i3;
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        int e16;
        f fVar5;
        int i16 = 0;
        f fVar6 = this.children[0];
        if (fVar6 != null && fVar6.i()) {
            z16 = true;
        } else {
            z16 = false;
        }
        f fVar7 = null;
        if (fVar6 != null) {
            if (fVar6.i()) {
                fVar5 = fVar6;
            } else {
                fVar5 = null;
            }
            if (fVar5 != null) {
                int c16 = e.c(fVar5);
                int e17 = e.e(fVar5);
                j(fVar5, c16, e17);
                i3 = c16 + fVar5.b().width() + e.d(fVar5);
                i16 = e17;
                fVar = this.children[1];
                if (fVar != null) {
                    if (!fVar.i()) {
                        fVar = null;
                    }
                    if (fVar != null) {
                        int e18 = i16 + e.e(fVar);
                        j(fVar, e.c(fVar) + i3, e18);
                        i16 = e18 + fVar.b().height() + e.a(fVar);
                    }
                }
                fVar2 = this.children[2];
                if (fVar2 != null) {
                    if (!fVar2.i()) {
                        fVar2 = null;
                    }
                    if (fVar2 != null) {
                        int e19 = i16 + e.e(fVar2);
                        j(fVar2, e.c(fVar2) + i3, e19);
                        i16 = e19 + fVar2.b().height() + e.a(fVar2);
                    }
                }
                fVar3 = this.children[3];
                if (fVar3 != null && fVar3.i()) {
                    int c17 = i3 + e.c(fVar3);
                    if (!z16) {
                        Intrinsics.checkNotNull(fVar6);
                        i16 = (fVar6.b().bottom - e.a(fVar3)) - fVar3.e();
                    } else {
                        i16 += e.e(fVar3);
                    }
                    j(fVar3, c17, i16);
                    i3 = c17 + fVar3.b().width() + e.d(fVar3);
                }
                fVar4 = this.children[4];
                if (fVar4 == null) {
                    if (fVar4.i()) {
                        fVar7 = fVar4;
                    }
                    if (fVar7 != null) {
                        if (fVar3 != null && fVar3.i()) {
                            e16 = (fVar3.b().height() - fVar7.e()) / 2;
                        } else {
                            e16 = e.e(fVar7);
                        }
                        j(fVar7, i3 + e.c(fVar7), i16 + e16);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        i3 = 0;
        fVar = this.children[1];
        if (fVar != null) {
        }
        fVar2 = this.children[2];
        if (fVar2 != null) {
        }
        fVar3 = this.children[3];
        if (fVar3 != null) {
            int c172 = i3 + e.c(fVar3);
            if (!z16) {
            }
            j(fVar3, c172, i16);
            i3 = c172 + fVar3.b().width() + e.d(fVar3);
        }
        fVar4 = this.children[4];
        if (fVar4 == null) {
        }
    }

    private final void e(int newWidth) {
        int i3;
        int i16 = this.maxHeight;
        if (i16 <= 0) {
            i16 = Integer.MAX_VALUE;
        }
        f fVar = this.children[0];
        if (fVar != null) {
            if (l(fVar, newWidth, i16)) {
                newWidth -= fVar.f() + e.b(fVar);
                i16 = fVar.e() + e.f(fVar);
            }
            c(fVar);
        }
        int i17 = i16;
        f fVar2 = this.children[1];
        if (fVar2 != null) {
            if (l(fVar2, newWidth, i16)) {
                i16 -= fVar2.e() + e.f(fVar2);
            }
            c(fVar2);
        }
        f fVar3 = this.children[2];
        if (fVar3 != null) {
            if (l(fVar3, newWidth, i16)) {
                i16 -= fVar3.e() + e.f(fVar3);
            }
            c(fVar3);
        }
        f fVar4 = this.children[3];
        if (fVar4 != null) {
            if (l(fVar4, newWidth, i16)) {
                newWidth -= fVar4.f() + e.b(fVar4);
                i3 = i16 - (fVar4.e() + e.f(fVar4));
            } else {
                i3 = i16;
            }
            c(fVar4);
        } else {
            i3 = i16;
        }
        f fVar5 = this.children[4];
        if (fVar5 != null) {
            if (l(fVar5, newWidth, i16)) {
                fVar5.f();
                e.b(fVar5);
                if (i3 == i16) {
                    i3 -= fVar5.e() + e.f(fVar5);
                }
            }
            c(fVar5);
        }
        f fVar6 = this.children[0];
        if (fVar6 == null || !fVar6.i()) {
            i17 -= i3;
        }
        this.height = i17;
    }

    private final boolean i(int remain, int measureSizeSpec) {
        if (View.MeasureSpec.getMode(measureSizeSpec) != 0 && View.MeasureSpec.getSize(measureSizeSpec) <= remain) {
            return true;
        }
        return false;
    }

    private final void j(f child, int childLeft, int childTop) {
        boolean z16;
        Rect b16 = child.b();
        if (b16.left == childLeft && b16.top == childTop && child.b().width() == child.f() && b16.height() == child.e()) {
            z16 = false;
        } else {
            z16 = true;
        }
        child.j(z16, childLeft, childTop, childLeft + child.f(), childTop + child.e());
    }

    private final boolean l(f child, int widthRemain, int heightRemain) {
        if (!b("measure: " + child.c(), widthRemain, heightRemain)) {
            return false;
        }
        ViewGroup.MarginLayoutParams d16 = child.d();
        if (d16 != null) {
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(widthRemain, Integer.MIN_VALUE), d16.leftMargin + d16.rightMargin, d16.width);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(heightRemain, Integer.MIN_VALUE), d16.topMargin + d16.bottomMargin, d16.height);
            if (!i(widthRemain - e.b(child), childMeasureSpec) || !i(heightRemain - e.f(child), childMeasureSpec2)) {
                return false;
            }
            child.measure(childMeasureSpec, childMeasureSpec2);
            return child.i();
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void f(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        for (f fVar : this.children) {
            if (fVar != null) {
                fVar.a(canvas);
            }
        }
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.height;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.width;
    }

    public final void k(int newWidth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, newWidth);
            return;
        }
        this.width = newWidth;
        e(newWidth);
        d();
    }

    private final void c(f it) {
    }
}
