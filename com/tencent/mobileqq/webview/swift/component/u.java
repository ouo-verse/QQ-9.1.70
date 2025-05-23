package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.comic.api.IQQComicRedTouchService;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.open.appstore.js.DINewForCommonWebView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class u implements com.tencent.mobileqq.webview.swift.injector.p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    com.tencent.biz.troop.b f314497a;

    /* renamed from: b, reason: collision with root package name */
    Map<String, RedAppInfo> f314498b;

    public u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String b(b.c cVar) {
        QQBrowserActivity qQBrowserActivity;
        ArrayList<WebViewTabBarData> arrayList;
        RedAppInfo redAppInfo;
        if (cVar.getActivity() instanceof QQBrowserActivity) {
            qQBrowserActivity = (QQBrowserActivity) cVar.getActivity();
        } else {
            qQBrowserActivity = null;
        }
        if (qQBrowserActivity != null && (arrayList = qQBrowserActivity.tabBarConfigData) != null && arrayList.size() > 1) {
            if (this.f314498b == null) {
                IQQComicRedTouchService iQQComicRedTouchService = (IQQComicRedTouchService) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web")).getRuntimeService(IQQComicRedTouchService.class, "all");
                ArrayList<String> arrayList2 = new ArrayList<>();
                arrayList2.add("1113.100803");
                Map<String, Object> redAppInfo2 = iQQComicRedTouchService.getRedAppInfo(arrayList2);
                if (redAppInfo2 != null) {
                    this.f314498b = new HashMap();
                    for (String str : redAppInfo2.keySet()) {
                        Object obj = redAppInfo2.get(str);
                        if (obj instanceof RedAppInfo) {
                            this.f314498b.put(str, (RedAppInfo) obj);
                        }
                    }
                }
            }
            Map<String, RedAppInfo> map = this.f314498b;
            boolean z16 = false;
            if (map != null && (redAppInfo = map.get("1113.100803")) != null && redAppInfo.M() != 0) {
                z16 = true;
            }
            if (z16 && qQBrowserActivity.tabBarConfigData.size() > 4 && qQBrowserActivity.currentTabIndex == 0) {
                WebViewTabBarData webViewTabBarData = qQBrowserActivity.tabBarConfigData.get(4);
                if (webViewTabBarData == null) {
                    return "";
                }
                return webViewTabBarData.url;
            }
            int i3 = qQBrowserActivity.currentTabIndex + 1;
            if (i3 >= qQBrowserActivity.tabBarConfigData.size()) {
                i3 = -1;
            }
            if (i3 > 0) {
                WebViewTabBarData webViewTabBarData2 = qQBrowserActivity.tabBarConfigData.get(i3);
                if (webViewTabBarData2 == null) {
                    return "";
                }
                return webViewTabBarData2.url;
            }
        }
        return null;
    }

    private void c(Bundle bundle) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserTBSInjectorImpl", 2, "start put data , bundle = ", bundle);
            }
            DINewForCommonWebView.b g16 = new DINewForCommonWebView.b(bundle.getString("url")).g();
            bundle.putString("date", g16.f());
            bundle.putString("ip", g16.d());
            bundle.putString("guid", g16.c());
            bundle.putString("version", g16.e());
            com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
            A.p();
            A.q0(bundle);
        } catch (Exception e16) {
            QLog.e("SwiftBrowserTBSInjectorImpl", 1, " check exception:", e16);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.p
    public void a(b.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            return;
        }
        if (com.tencent.mobileqq.webview.swift.utils.i.p()) {
            String b16 = b(cVar);
            if (!TextUtils.isEmpty(b16) && com.tencent.mobileqq.webview.swift.utils.i.q(b16) && !b16.contains("asyncMode=3") && !b16.contains("sonic=1")) {
                SwiftBrowserTBSHandler.s(b16, cVar.getWebView());
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.p
    public void handlerMiscCallback(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) bundle);
            return;
        }
        if ("onDownloadStart".equals(str)) {
            c(bundle);
            return;
        }
        if ("onUploadLiveLogFinished".equals(str)) {
            int i3 = 0;
            boolean z16 = bundle.getBoolean("result", false);
            QLog.d("SwiftBrowserTBSInjectorImpl", 1, "onUploadLiveLogFinished, result: " + z16);
            if (UiApiPlugin.B0 != null && UiApiPlugin.A0.get() != -1) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong("seq", UiApiPlugin.A0.get());
                ResultReceiver resultReceiver = UiApiPlugin.B0;
                if (!z16) {
                    i3 = -3;
                }
                resultReceiver.send(i3, bundle2);
                UiApiPlugin.B0 = null;
                UiApiPlugin.A0.set(-1L);
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.p
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.biz.troop.b bVar = this.f314497a;
        if (bVar != null) {
            bVar.q();
        }
    }
}
