package com.tencent.qqnt.util;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\t\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\t\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\u000b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\r\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\u000e\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\u000f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\u0011\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\u0012\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0014\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J!\u0010\u0017\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0016\u001a\n \u0005*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\u0019\u0010\u0018\u001a\u00020\u00022\u000e\u0010\u0016\u001a\n \u0005*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010\u001e\u001a\u00020\u00022\u000e\u0010\u0016\u001a\n \u0005*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\t\u0010\u001f\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010 \u001a\u00020\u00022\u000e\u0010\u0016\u001a\n \u0005*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\t\u0010!\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010#\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u0002H\u0096\u0001\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/util/b;", "Lcom/tencent/mobileqq/inject/b;", "", "enableTalkBack", "", "kotlin.jvm.PlatformType", "i", "", "getAppId", "g", "getBranchName", "f", "getChannel", "getQUA", "getQimei36", "d", "getReportVersionName", "e", "getSubVersion", "a", "getVersion", "Landroid/content/Context;", "p0", "b", "isAllowLandscape", "c", "isDebugVersion", "j", "isGooglePlayVersion", "isGrayVersion", h.F, "isPublicVersion", "isSplitViewMode", "isUiTest", "", "k", "<init>", "()V", "nt_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements com.tencent.mobileqq.inject.b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f362976b;

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.inject.b f362977a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38779);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
        } else {
            f362976b = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        com.tencent.mobileqq.inject.b a16 = a.f362973a.a();
        Intrinsics.checkNotNull(a16);
        this.f362977a = a16;
    }

    @Override // com.tencent.mobileqq.inject.b
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.f362977a.a();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String b(Context p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) p06);
        }
        return this.f362977a.b(p06);
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.f362977a.c();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f362977a.d();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f362977a.e();
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean enableTalkBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f362977a.enableTalkBack();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f362977a.f();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f362977a.g();
    }

    @Override // com.tencent.mobileqq.inject.b
    public int getAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f362977a.getAppId();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String getBranchName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f362977a.getBranchName();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String getChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f362977a.getChannel();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String getQUA() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f362977a.getQUA();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String getQimei36() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f362977a.getQimei36();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String getReportVersionName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f362977a.getReportVersionName();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String getSubVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.f362977a.getSubVersion();
    }

    @Override // com.tencent.mobileqq.inject.b
    public String getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f362977a.getVersion();
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean h(Context p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) p06)).booleanValue();
        }
        return this.f362977a.h(p06);
    }

    @Override // com.tencent.mobileqq.inject.b
    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f362977a.i();
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean isAllowLandscape(Context p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) p06)).booleanValue();
        }
        return this.f362977a.isAllowLandscape(p06);
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean isDebugVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this.f362977a.isDebugVersion();
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean isGooglePlayVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.f362977a.isGooglePlayVersion();
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean isGrayVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.f362977a.isGrayVersion();
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean isPublicVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.f362977a.isPublicVersion();
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean isSplitViewMode(Context p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) p06)).booleanValue();
        }
        return this.f362977a.isSplitViewMode(p06);
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean isUiTest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return this.f362977a.isUiTest();
    }

    @Override // com.tencent.mobileqq.inject.b
    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.f362977a.j();
    }

    @Override // com.tencent.mobileqq.inject.b
    public void k(boolean p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, p06);
        } else {
            this.f362977a.k(p06);
        }
    }
}
