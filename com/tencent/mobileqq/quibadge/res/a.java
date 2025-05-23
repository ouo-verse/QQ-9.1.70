package com.tencent.mobileqq.quibadge.res;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010&\u001a\u00020!\u00a2\u0006\u0004\b'\u0010(J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R(\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/quibadge/res/a;", "", "Landroid/graphics/Typeface;", "o", "", "k", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", DomainData.DOMAIN_NAME, "l", "f", "i", h.F, "j", "", "p", "a", "I", "getCurViewType", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", "getCurViewType$annotations", "()V", "curViewType", "", "b", "Z", "isTextColorUseCache", "()Z", "r", "(Z)V", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "QUIBadge_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static int f276987d;

    /* renamed from: e, reason: collision with root package name */
    private static int f276988e;

    /* renamed from: f, reason: collision with root package name */
    private static int f276989f;

    /* renamed from: g, reason: collision with root package name */
    private static int f276990g;

    /* renamed from: h, reason: collision with root package name */
    private static int f276991h;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int curViewType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isTextColorUseCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/quibadge/res/a$a;", "", "", "textColor", "I", "getTextColor", "()I", "d", "(I)V", "aioTextColor", "getAioTextColor", "a", "grayBgColor", "getGrayBgColor", "b", "redBgColor", "getRedBgColor", "c", "<init>", "()V", "QUIBadge_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.quibadge.res.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                return;
            }
            iPatchRedirector.redirect((short) 11, (Object) this);
        }

        public final void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                a.f276988e = i3;
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
        }

        public final void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                a.f276989f = i3;
            } else {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
        }

        public final void c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                a.f276991h = i3;
            } else {
                iPatchRedirector.redirect((short) 10, (Object) this, i3);
            }
        }

        public final void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.f276987d = i3;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
                return;
            }
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9776);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) context);
        } else {
            this.context = context;
            this.isTextColorUseCache = true;
        }
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int i3 = f276990g;
        if (i3 == 0) {
            int a16 = com.tencent.mobileqq.quibadge.helper.a.a(this.context);
            f276990g = a16;
            return a16;
        }
        return i3;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return com.tencent.mobileqq.quibadge.helper.a.b();
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        int i3 = this.curViewType;
        if (i3 != 1 && i3 != 3 && i3 != 5) {
            if (i3 != 6) {
                if (i3 != 8) {
                    if (i3 != 9) {
                        return m();
                    }
                    return e();
                }
            } else {
                return -1;
            }
        }
        return k();
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        if (this.curViewType == 9) {
            return e.c(6.0f);
        }
        return com.tencent.mobileqq.quibadge.helper.a.d();
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return com.tencent.mobileqq.quibadge.helper.a.e();
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return com.tencent.mobileqq.quibadge.helper.a.g();
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        int i3 = f276989f;
        if (i3 == 0) {
            int h16 = com.tencent.mobileqq.quibadge.helper.a.h(this.context);
            f276989f = h16;
            return h16;
        }
        return i3;
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return com.tencent.mobileqq.quibadge.helper.a.i();
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        int i3 = f276991h;
        if (i3 == 0) {
            int j3 = com.tencent.mobileqq.quibadge.helper.a.j(this.context);
            f276991h = j3;
            return j3;
        }
        return i3;
    }

    public int n() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        if (!this.isTextColorUseCache) {
            if (this.curViewType == 9) {
                return com.tencent.mobileqq.quibadge.helper.a.n(this.context);
            }
            return com.tencent.mobileqq.quibadge.helper.a.m(this.context);
        }
        int i16 = this.curViewType;
        if (i16 == 9) {
            i3 = f276988e;
        } else {
            i3 = f276987d;
        }
        if (i3 == 0) {
            if (i16 == 9) {
                int n3 = com.tencent.mobileqq.quibadge.helper.a.n(this.context);
                f276988e = n3;
                return n3;
            }
            int m3 = com.tencent.mobileqq.quibadge.helper.a.m(this.context);
            f276987d = m3;
            return m3;
        }
        return i3;
    }

    @Nullable
    public Typeface o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Typeface) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return com.tencent.mobileqq.quibadge.helper.a.o();
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        f276987d = 0;
        f276989f = 0;
        f276990g = 0;
        f276991h = 0;
        f276988e = 0;
    }

    public final void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.curViewType = i3;
        }
    }

    public final void r(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.isTextColorUseCache = z16;
        }
    }
}
