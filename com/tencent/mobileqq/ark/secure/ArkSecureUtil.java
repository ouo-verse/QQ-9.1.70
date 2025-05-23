package com.tencent.mobileqq.ark.secure;

import android.text.TextUtils;
import com.tencent.ark.Constants;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkSecureUtil {

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements ArkAppMgr.IGetAppPathByNameCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f199606a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f199607b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f199608c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.ark.secure.b f199609d;

        a(String str, String str2, String str3, com.tencent.mobileqq.ark.secure.b bVar) {
            this.f199606a = str;
            this.f199607b = str2;
            this.f199608c = str3;
            this.f199609d = bVar;
        }

        @Override // com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback
        public void onGetAppPathByName(int i3, String str, ArkAppMgr.AppPathInfo appPathInfo) {
            String str2;
            if (i3 == 0 && appPathInfo != null && (str2 = appPathInfo.path) != null) {
                ark.Application Create = ark.Application.Create(this.f199606a, this.f199607b, str2);
                if (Create != null) {
                    boolean CheckShareUrlLegality = Create.CheckShareUrlLegality(this.f199608c);
                    Create.Release();
                    if (CheckShareUrlLegality) {
                        this.f199609d.a(true);
                        QLog.i("ArkApp.ArkSecureUtil", 1, String.format("CheckShareUrlLegality, url is in whileList, appName=%s and url=%s", this.f199606a, this.f199608c));
                        return;
                    } else {
                        this.f199609d.a(false);
                        QLog.i("ArkApp.ArkSecureUtil", 1, String.format("CheckShareUrlLegality, url is not in whileList, appName=%s and url=%s", this.f199606a, this.f199608c));
                        return;
                    }
                }
                return;
            }
            this.f199609d.a(false);
            com.tencent.mobileqq.ark.util.b.b(null, this.f199606a, "ArkCheckShareUrlLegality", i3, 0, 0L, 0L, 0L, "", "");
            QLog.i("ArkApp.ArkSecureUtil", 1, String.format("CheckShareUrlLegality,getAppInfo is failed and msg=%s", str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements ArkAppMgr.IGetAppPathByNameCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f199610a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f199611b;

        b(c cVar, String str) {
            this.f199610a = cVar;
            this.f199611b = str;
        }

        @Override // com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback
        public void onGetAppPathByName(int i3, String str, ArkAppMgr.AppPathInfo appPathInfo) {
            ArkAppMgr.IGetAppPathByNameCallback a16 = this.f199610a.a();
            if (a16 != null) {
                QLog.i("ArkApp.ArkSecureUtil", 1, "getAppPathByNameTimeout success, app=" + this.f199611b);
                a16.onGetAppPathByName(i3, str, appPathInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        ArkAppMgr.IGetAppPathByNameCallback f199612a;

        c() {
        }

        synchronized ArkAppMgr.IGetAppPathByNameCallback a() {
            ArkAppMgr.IGetAppPathByNameCallback iGetAppPathByNameCallback;
            iGetAppPathByNameCallback = this.f199612a;
            this.f199612a = null;
            return iGetAppPathByNameCallback;
        }
    }

    public static void a(String str, String str2, String str3, String str4, com.tencent.mobileqq.ark.secure.b bVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str4)) {
            b(3000L, str, str3, Constants.DEFAULT_MIN_APP_VERSION, new a(str, str3, str4, bVar));
        }
    }

    public static void b(long j3, final String str, String str2, String str3, ArkAppMgr.IGetAppPathByNameCallback iGetAppPathByNameCallback) {
        final c cVar = new c();
        cVar.f199612a = iGetAppPathByNameCallback;
        ArkAppMgr.getInstance().getAppPathByName(str, str3, str2, new b(cVar, str));
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToLogicThreadDelay(new Runnable() { // from class: com.tencent.mobileqq.ark.secure.ArkSecureUtil.3
            @Override // java.lang.Runnable
            public void run() {
                ArkAppMgr.IGetAppPathByNameCallback a16 = c.this.a();
                if (a16 != null) {
                    QLog.i("ArkApp.ArkSecureUtil", 1, "getAppPathByNameTimeout timeout, app=" + str);
                    a16.onGetAppPathByName(-7, HardCodeUtil.qqStr(R.string.f1628521j), null);
                }
            }
        }, (int) j3);
    }
}
