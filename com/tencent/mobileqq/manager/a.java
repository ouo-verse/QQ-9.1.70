package com.tencent.mobileqq.manager;

import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f243590b;

    /* renamed from: a, reason: collision with root package name */
    private c f243591a;

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f243591a = (c) am.s().x(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION);
        }
    }

    public static a b() {
        if (f243590b == null) {
            synchronized (a.class) {
                if (f243590b == null) {
                    f243590b = new a();
                }
            }
        }
        return f243590b;
    }

    public void a(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else if (cVar == null) {
            QLog.e("QSafeConfigManager", 1, "setConfig, config is null");
        } else {
            this.f243591a = cVar;
        }
    }
}
