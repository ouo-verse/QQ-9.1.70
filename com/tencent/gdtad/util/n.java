package com.tencent.gdtad.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher;
import com.tencent.gdtad.config.IGdtConfigAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.mobileqq.qroute.QRoute;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class n {

    /* renamed from: c, reason: collision with root package name */
    private static n f109563c;

    /* renamed from: a, reason: collision with root package name */
    private volatile String f109564a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Boolean f109565b = null;

    n() {
    }

    private static boolean a(Context context, String str) {
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            GdtLog.e("GdtQuickAppManager", "[checkIfSupported] error, deeplink is empty");
            return false;
        }
        AdAppDeeplinkLauncher.Params params = new AdAppDeeplinkLauncher.Params();
        params.deeplink = str;
        params.addflags = 268435456;
        AdAppDeeplinkLauncher.Result canLaunch = AdAppDeeplinkLauncher.canLaunch(context, params);
        if (canLaunch != null && canLaunch.isSuccess()) {
            z16 = true;
        }
        GdtLog.i("GdtQuickAppManager", "[checkIfSupported] result:" + z16 + " deeplink:" + str);
        return z16;
    }

    public static n c() {
        if (f109563c == null) {
            synchronized (n.class) {
                if (f109563c == null) {
                    f109563c = new n();
                }
            }
        }
        return f109563c;
    }

    public String b() {
        String str;
        if (TextUtils.isEmpty(this.f109564a)) {
            try {
                com.tencent.gdtad.config.data.j configForQuickApp = ((IGdtConfigAPI) QRoute.api(IGdtConfigAPI.class)).getConfigForQuickApp();
                if (configForQuickApp != null) {
                    str = configForQuickApp.deeplink;
                } else {
                    str = null;
                }
                this.f109564a = str;
            } catch (Throwable th5) {
                GdtLog.e("GdtQuickAppManager", "[getDeeplink]", th5);
            }
            GdtLog.i("GdtQuickAppManager", "[getDeeplink] deeplink:" + this.f109564a);
        }
        return this.f109564a;
    }

    public Boolean d(Context context) {
        if (this.f109565b == null) {
            if (!PrivacyPolicyHelper.isUserAllow()) {
                GdtLog.e("GdtQuickAppManager", "[isSupported] not allowed");
            } else {
                String b16 = b();
                if (TextUtils.isEmpty(b16)) {
                    GdtLog.e("GdtQuickAppManager", "[isSupported] deeplink is empty");
                } else {
                    this.f109565b = Boolean.valueOf(a(context, b16));
                }
            }
        }
        return this.f109565b;
    }
}
