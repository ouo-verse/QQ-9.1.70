package com.tencent.mobileqq.guid;

import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guid/c;", "", "", "d", "c", "Lcom/tencent/mobileqq/guid/d;", "callback", "", "g", "e", "b", "[B", "guid", "", "J", "lastLogTime", "<init>", "()V", "guid-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f213821a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static byte[] guid;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long lastLogTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36671);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f213821a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final byte[] d() {
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e("GuidManager", 1, "appRuntime is null");
                return null;
            }
            WtloginManager wtloginManager = (WtloginManager) peekAppRuntime.getManager(1);
            if (wtloginManager == null) {
                return null;
            }
            return wtloginManager.getGUID();
        } catch (Exception e16) {
            QLog.e("GuidManager", 1, e16, new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        byte[] d16 = f213821a.d();
        if (d16 != null) {
            guid = d16;
        }
        QLog.d("GuidManager", 1, "refreshGuid : " + HexUtil.bytes2HexStr(guid));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(d callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        byte[] bArr = guid;
        if (bArr != null) {
            callback.a(bArr);
            QLog.d("GuidManager", 1, "requestGuid, use cache : " + HexUtil.bytes2HexStr(bArr));
            return;
        }
        byte[] d16 = f213821a.d();
        if (d16 != null) {
            guid = d16;
            callback.a(d16);
        }
        QLog.d("GuidManager", 1, "requestGuid : " + HexUtil.bytes2HexStr(guid));
    }

    @Nullable
    public final byte[] c() {
        byte[] d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (guid == null && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102813", false) && (d16 = d()) != null) {
            guid = d16;
            QLog.d("GuidManager", 1, "getGuid load guid: " + HexUtil.bytes2HexStr(d16));
        }
        if (Math.abs(System.currentTimeMillis() - lastLogTime) >= 2000) {
            QLog.d("GuidManager", 1, "getGuid : " + HexUtil.bytes2HexStr(guid));
            lastLogTime = System.currentTimeMillis();
        }
        return guid;
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guid.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.f();
                }
            }, 16, null, false);
        }
    }

    public final void g(@NotNull final d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guid.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.h(d.this);
                }
            }, 16, null, false);
        }
    }
}
