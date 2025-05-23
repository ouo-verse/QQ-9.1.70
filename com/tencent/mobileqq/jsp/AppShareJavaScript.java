package com.tencent.mobileqq.jsp;

import android.content.Context;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.jsbridge.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.webview.api.IJsApi;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes15.dex */
public class AppShareJavaScript extends a.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private w f238552d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f238553e;

    /* renamed from: f, reason: collision with root package name */
    Context f238554f;

    public AppShareJavaScript(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f238553e = false;
        this.f238554f = context;
        this.f238552d = (w) ((IJsApi) QRoute.api(IJsApi.class)).getQQApiPlugin();
        try {
            Field declaredField = w.class.getDeclaredField("d");
            declaredField.setAccessible(true);
            declaredField.set(this.f238552d, context);
            this.f238553e = true;
        } catch (Exception e16) {
            QLog.d("QQApi", 2, "QQApi init error: " + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.jsbridge.a.b
    public void call(String str, List<String> list, a.C7950a c7950a) {
        Object obj;
        a.C7950a c7950a2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, list, c7950a);
            return;
        }
        if (!this.f238553e) {
            QLog.d("QQApi", 2, "QQApi not ready");
            return;
        }
        int size = list.size();
        try {
            if ("isAppInstalled".equals(str) && size == 1) {
                obj = Boolean.valueOf(PackageUtil.isAppInstalled(this.f238554f, list.get(0)));
            } else if ("checkAppInstalled".equals(str) && size == 1) {
                obj = PackageUtil.checkAppInstalled(this.f238554f, list.get(0));
            } else if ("checkAppInstalledBatch".equals(str) && size == 1) {
                obj = PackageUtil.checkAppInstalledBatch(this.f238554f, list.get(0));
            } else if ("isAppInstalledBatch".equals(str) && size == 1) {
                obj = PackageUtil.isAppInstalledBatch(this.f238554f, list.get(0));
            } else if ("startAppWithPkgName".equals(str) && size == 1) {
                obj = Boolean.valueOf(PackageUtil.startAppWithPkgName(this.f238554f, list.get(0), null));
            } else if ("startAppWithPkgNameAndOpenId".equals(str) && size == 2) {
                obj = Boolean.valueOf(PackageUtil.startAppWithPkgName(this.f238554f, list.get(0), list.get(1)));
            } else if ("getOpenidBatch".equals(str) && size == 1) {
                obj = "";
            } else {
                if ("launchAppWithTokens".equals(str) && size == 4) {
                    this.f238552d.s(list.get(0), list.get(1), list.get(2), list.get(3), null, "");
                    c7950a2 = c7950a;
                    obj = null;
                    c7950a2.a(obj);
                }
                if ("getAppsVerionCodeBatch".equals(str) && size == 1) {
                    obj = PackageUtil.getAppsVerionCodeBatch(this.f238554f, list.get(0));
                } else if ("setShareURL".equals(str) && size == 1) {
                    obj = Boolean.FALSE;
                } else if ("setShareInfo".equals(str) && size == 1) {
                    obj = Boolean.FALSE;
                } else if ("sendDocToChat".equals(str) && size == 1) {
                    obj = Boolean.FALSE;
                } else {
                    c7950a.c();
                    return;
                }
            }
            c7950a2 = c7950a;
            c7950a2.a(obj);
        } catch (Exception e16) {
            QLog.d("QQApi", 2, "error in QQApi." + str + MsgSummary.STR_COLON + e16.getMessage());
        }
    }
}
