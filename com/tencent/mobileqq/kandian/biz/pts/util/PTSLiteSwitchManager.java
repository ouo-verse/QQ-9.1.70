package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes33.dex */
public class PTSLiteSwitchManager {

    /* renamed from: c, reason: collision with root package name */
    private static volatile PTSLiteSwitchManager f239396c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f239397a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f239398b = true;

    PTSLiteSwitchManager() {
    }

    public static PTSLiteSwitchManager c() {
        if (f239396c == null) {
            synchronized (PTSLiteSwitchManager.class) {
                if (f239396c == null) {
                    f239396c = new PTSLiteSwitchManager();
                }
            }
        }
        return f239396c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(final b62.a aVar) {
        e();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteSwitchManager.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("PTSLiteSwitchManager", 1, "[init], ptsLiteSwitchTmp = true");
                QLog.i("PTSLiteSwitchManager", 1, "[init], ptsLiteMasterSwitchTmp = true");
                try {
                    c.d();
                    c62.a.d().h("ptslite", aVar);
                    PTSLiteSwitchManager.this.f239397a = true;
                    PTSLiteSwitchManager.this.f239398b = true;
                } catch (NoSuchMethodError unused) {
                    QLog.e("PTSLiteSwitchManager", 1, "[init] PTSHelper.registerPtsComponent() failed.");
                    PTSLiteSwitchManager.this.f239397a = false;
                    PTSLiteSwitchManager.this.f239398b = false;
                }
            }
        }, 64, null, false);
    }

    private void e() {
        this.f239397a = false;
        this.f239398b = true;
        c.e();
    }
}
