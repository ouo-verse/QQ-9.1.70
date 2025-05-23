package com.tencent.mobileqq.webview.swift.injector;

import com.tencent.hippy.qq.intercept.HippyWebNavigationItem;
import com.tencent.mobileqq.flashtransfer.FlashTransferWebNavigationItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.intercept.QQKuiklyWebNavigationItem;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ac {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_web_navigation.yml", version = 2)
    public static ArrayList<Class<? extends com.tencent.mobileqq.webview.swift.d>> f314603a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49385);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends com.tencent.mobileqq.webview.swift.d>> arrayList = new ArrayList<>();
        f314603a = arrayList;
        arrayList.add(com.tencent.mobileqq.webview.swift.component.navigate.b.class);
        f314603a.add(com.tencent.mobileqq.webview.swift.component.navigate.a.class);
        f314603a.add(com.tencent.mobileqq.remoteweb.ab.class);
        f314603a.add(com.tencent.mobileqq.zplan.web.g.class);
        f314603a.add(FlashTransferWebNavigationItem.class);
        f314603a.add(QQKuiklyWebNavigationItem.class);
        f314603a.add(HippyWebNavigationItem.class);
        f314603a.add(com.tencent.mobileqq.nsr.d.class);
    }

    public static ArrayList<com.tencent.mobileqq.webview.swift.d> a() {
        try {
            ArrayList<com.tencent.mobileqq.webview.swift.d> arrayList = new ArrayList<>();
            ArrayList<Class<? extends com.tencent.mobileqq.webview.swift.d>> arrayList2 = f314603a;
            if (arrayList2 == null) {
                return arrayList;
            }
            Iterator<Class<? extends com.tencent.mobileqq.webview.swift.d>> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().newInstance());
            }
            return arrayList;
        } catch (Throwable th5) {
            QLog.e("SwiftBrowserNavigatorInjectUtil", 1, "registerNavigationItems Fail,", th5);
            if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                return null;
            }
            throw new RuntimeException("SwiftBrowserNavigatorInjectUtil.registerNavigationItems failed", th5);
        }
    }
}
