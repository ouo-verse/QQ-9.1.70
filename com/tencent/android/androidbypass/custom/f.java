package com.tencent.android.androidbypass.custom;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b \u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001\u0006B\u000f\u0012\u0006\u00107\u001a\u000204\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\b\u0010\tJ0\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fR*\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8\u0006@DX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8\u0006@DX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u0017\u0010\"\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010!R$\u0010)\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R*\u0010,\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8\u0006@DX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R$\u00103\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0017\u00107\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b\b\u00105\u001a\u0004\b\u001f\u00106R$\u0010=\u001a\u00020\n2\u0006\u00108\u001a\u00020\n8F@DX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010@\u001a\u00020\n2\u0006\u00108\u001a\u00020\n8F@DX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<\u00a8\u0006C"}, d2 = {"Lcom/tencent/android/androidbypass/custom/f;", "Lcom/tencent/android/androidbypass/custom/d;", "", "Landroid/graphics/Canvas;", PM.CANVAS, "", "a", "k", "g", "()Lkotlin/Unit;", "", "changed", "", "left", "top", "right", "bottom", "j", "Landroid/graphics/Rect;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<set-?>", "I", "f", "()I", "r", "(I)V", "measuredWidth", "b", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "measuredHeight", "c", "Landroid/graphics/Rect;", "()Landroid/graphics/Rect;", AIInput.KEY_FRAME, "Landroid/view/ViewGroup$MarginLayoutParams;", "d", "Landroid/view/ViewGroup$MarginLayoutParams;", "()Landroid/view/ViewGroup$MarginLayoutParams;", "o", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "layoutParam", "getFlags", "setFlags", WadlProxyConsts.FLAGS, "Lcom/tencent/android/androidbypass/custom/b;", "Lcom/tencent/android/androidbypass/custom/b;", "getCallback", "()Lcom/tencent/android/androidbypass/custom/b;", "l", "(Lcom/tencent/android/androidbypass/custom/b;)V", "callback", "", "Ljava/lang/String;", "()Ljava/lang/String;", "id", "value", "i", "()Z", "p", "(Z)V", "isMeasured", h.F, DomainData.DOMAIN_NAME, "isLaidout", "<init>", "(Ljava/lang/String;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public abstract class f implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int measuredWidth;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int measuredHeight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect frame;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup.MarginLayoutParams layoutParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int flags;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b callback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/android/androidbypass/custom/f$a;", "", "", "size", "measureSpec", "a", "FLAG_INVALIDATED", "I", "FLAG_LAID_OUT", "FLAG_MEASURED", "SIZE_NOT_ENOUGH", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.custom.f$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        public final int a(int size, int measureSpec) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Integer) iPatchRedirector.redirect((short) 1, this, Integer.valueOf(size), Integer.valueOf(measureSpec))).intValue();
            }
            int size2 = View.MeasureSpec.getSize(measureSpec);
            int mode = View.MeasureSpec.getMode(measureSpec);
            if (mode != Integer.MIN_VALUE) {
                if (mode == 1073741824) {
                    return size2;
                }
                return size;
            }
            if (size > size2) {
                return -1;
            }
            return size;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15910);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f(@NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) id5);
        } else {
            this.id = id5;
            this.frame = new Rect();
        }
    }

    public void a(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!h()) {
            return;
        }
        Rect rect = this.frame;
        float f16 = rect.left;
        float f17 = rect.top;
        canvas.translate(f16, f17);
        k(canvas);
        canvas.translate(-f16, -f17);
    }

    @NotNull
    public final Rect b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Rect) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.frame;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.id;
    }

    @Nullable
    public final ViewGroup.MarginLayoutParams d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ViewGroup.MarginLayoutParams) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.layoutParam;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.measuredHeight;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.measuredWidth;
    }

    @Nullable
    public final Unit g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Unit) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        b bVar = this.callback;
        if (bVar != null) {
            bVar.invalidate();
            return Unit.INSTANCE;
        }
        return null;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if ((this.flags & 3) == 3) {
            return true;
        }
        return false;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if ((this.flags & 1) != 0) {
            return true;
        }
        return false;
    }

    public void j(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            return;
        }
        if (changed && i()) {
            m(left, top, right, bottom);
            n(true);
        } else if (!i()) {
            n(false);
        }
    }

    protected void k(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) canvas);
        } else {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
        }
    }

    public final void l(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bVar);
        } else {
            this.callback = bVar;
        }
    }

    @NotNull
    public final Rect m(int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Rect) iPatchRedirector.redirect((short) 20, this, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
        }
        Rect rect = this.frame;
        rect.left = left;
        rect.top = top;
        rect.right = right;
        rect.bottom = bottom;
        return rect;
    }

    protected final void n(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        if (z16) {
            i3 = this.flags | 3;
        } else {
            i3 = this.flags & (-4);
        }
        this.flags = i3;
    }

    public final void o(@Nullable ViewGroup.MarginLayoutParams marginLayoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) marginLayoutParams);
        } else {
            this.layoutParam = marginLayoutParams;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        if (z16) {
            i3 = this.flags | 1;
        } else {
            i3 = this.flags & (-2);
        }
        this.flags = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.measuredHeight = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.measuredWidth = i3;
        }
    }
}
