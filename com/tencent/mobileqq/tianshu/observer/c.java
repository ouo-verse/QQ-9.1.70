package com.tencent.mobileqq.tianshu.observer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010\"J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\u0004H\u0016R\u001a\u0010\u000e\u001a\u00020\u00048\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rRA\u0010\u001a\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\rR$\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b\u001b\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/tianshu/observer/c;", "", "Lcom/tencent/mobileqq/tianshu/api/IRedTouchManager;", "a", "", "argPath", "b", "path", "", "f", "toString", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/tianshu/observer/b;", "Lkotlin/ParameterName;", "name", "info", "", "Lkotlin/jvm/functions/Function1;", "d", "()Lkotlin/jvm/functions/Function1;", "e", "(Lkotlin/jvm/functions/Function1;)V", "notifyBusinessUpdateEnd", "c", "getPath", "Lcom/tencent/mobileqq/tianshu/observer/b;", "()Lcom/tencent/mobileqq/tianshu/observer/b;", "setInfo", "(Lcom/tencent/mobileqq/tianshu/observer/b;)V", "<init>", "(Ljava/lang/String;)V", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super b, Unit> notifyBusinessUpdateEnd;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String path;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b info;

    public c(@NotNull String argPath) {
        Intrinsics.checkNotNullParameter(argPath, "argPath");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) argPath);
            return;
        }
        this.TAG = "RedBadgeDelayInteraction";
        this.path = argPath;
        this.info = new b(argPath);
        f(argPath);
    }

    private final IRedTouchManager a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
        return (IRedTouchManager) runtimeService;
    }

    private final String b(String argPath) {
        return argPath + ".0";
    }

    @Nullable
    public final b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.info;
    }

    @Nullable
    public final Function1<b, Unit> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Function1) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.notifyBusinessUpdateEnd;
    }

    public final void e(@Nullable Function1<? super b, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) function1);
        } else {
            this.notifyBusinessUpdateEnd = function1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f(@NotNull String path) {
        BusinessInfoCheckUpdate.AppInfo appInfo;
        boolean z16;
        boolean z17;
        IRedTouchManager a16;
        BusinessInfoCheckUpdate.AppInfo appInfo2;
        b bVar;
        BusinessInfoCheckUpdate.AppInfo appInfo3;
        boolean z18;
        BusinessInfoCheckUpdate.AppInfo c16;
        String str;
        BusinessInfoCheckUpdate.AppInfo appInfo4;
        boolean z19;
        BusinessInfoCheckUpdate.AppInfo b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) path)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(path, "path");
        IRedTouchManager a17 = a();
        String str2 = null;
        if (a17 != null) {
            appInfo = a17.getAppInfoByPath(path.toString());
        } else {
            appInfo = null;
        }
        boolean z26 = false;
        if (appInfo != null && com.tencent.mobileqq.tianshu.ui.a.d(appInfo)) {
            b bVar2 = this.info;
            if (bVar2 != null) {
                appInfo4 = bVar2.b();
            } else {
                appInfo4 = null;
            }
            if (appInfo4 != null) {
                b bVar3 = this.info;
                if (bVar3 != null && (b16 = bVar3.b()) != null && com.tencent.mobileqq.tianshu.ui.a.f(b16, appInfo)) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (!z19) {
                    b bVar4 = this.info;
                    if (bVar4 != null) {
                        bVar4.f(appInfo);
                    }
                }
            } else {
                b bVar5 = this.info;
                if (bVar5 != null) {
                    bVar5.f(appInfo);
                }
            }
            z16 = true;
            if (appInfo == null && com.tencent.mobileqq.tianshu.ui.a.d(appInfo)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                String str3 = this.TAG;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("red dot delay appInfo: ");
                if (appInfo != null) {
                    str = com.tencent.mobileqq.tianshu.ui.a.g(appInfo);
                } else {
                    str = null;
                }
                sb5.append(str);
                QLog.i(str3, 1, sb5.toString());
            }
            String b17 = b(path);
            a16 = a();
            if (a16 == null) {
                appInfo2 = a16.getAppInfoByPath(b17.toString());
            } else {
                appInfo2 = null;
            }
            if (appInfo2 == null && com.tencent.mobileqq.tianshu.ui.a.a(appInfo2)) {
                b bVar6 = this.info;
                if (bVar6 != null) {
                    appInfo3 = bVar6.c();
                } else {
                    appInfo3 = null;
                }
                if (appInfo3 != null) {
                    b bVar7 = this.info;
                    if (bVar7 != null && (c16 = bVar7.c()) != null && com.tencent.mobileqq.tianshu.ui.a.f(c16, appInfo2)) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        z16 = false;
                    } else {
                        b bVar8 = this.info;
                        if (bVar8 != null) {
                            bVar8.g(appInfo2);
                        }
                    }
                } else {
                    b bVar9 = this.info;
                    if (bVar9 != null) {
                        bVar9.g(appInfo2);
                    }
                }
                z16 = true;
            } else {
                bVar = this.info;
                if (bVar != null) {
                    bVar.g(null);
                }
            }
            if (z16) {
                b bVar10 = this.info;
                if (bVar10 != null) {
                    bVar10.i();
                }
                b bVar11 = this.info;
                if (bVar11 != null) {
                    d.f293094a.f(bVar11);
                }
            }
            if (appInfo2 != null && com.tencent.mobileqq.tianshu.ui.a.a(appInfo2)) {
                z26 = true;
            }
            if (z26) {
                String str4 = this.TAG;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("red number delay appInfo: ");
                if (appInfo2 != null) {
                    str2 = com.tencent.mobileqq.tianshu.ui.a.g(appInfo2);
                }
                sb6.append(str2);
                QLog.i(str4, 1, sb6.toString());
            }
            return z16;
        }
        b bVar12 = this.info;
        if (bVar12 != null) {
            bVar12.f(null);
        }
        z16 = false;
        if (appInfo == null) {
        }
        z17 = false;
        if (z17) {
        }
        String b172 = b(path);
        a16 = a();
        if (a16 == null) {
        }
        if (appInfo2 == null) {
        }
        bVar = this.info;
        if (bVar != null) {
        }
        if (z16) {
        }
        if (appInfo2 != null) {
            z26 = true;
        }
        if (z26) {
        }
        return z16;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "super" + super.toString() + "subpath" + this.path + " delayInfoData" + this.info;
    }
}
