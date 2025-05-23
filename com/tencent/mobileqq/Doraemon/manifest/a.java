package com.tencent.mobileqq.Doraemon.manifest;

import b91.b;
import com.tencent.luggage.wxa.gg.c;
import com.tencent.mobileqq.Doraemon.e;
import com.tencent.mobileqq.Doraemon.impl.commonModule.f;
import com.tencent.mobileqq.Doraemon.impl.internalModule.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/DoraemonApi/doraemon_module_inject.yml")
    public static HashMap<String, Class<? extends e>> f154225a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.Doraemon.manifest.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C7084a {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.Doraemon.manifest.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C7085a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private static Map<String, com.tencent.mobileqq.Doraemon.b> f154226a;

            public static Map<String, com.tencent.mobileqq.Doraemon.b> a() {
                if (f154226a == null) {
                    synchronized (C7084a.class) {
                        if (f154226a == null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("getLocation", new com.tencent.mobileqq.Doraemon.b("getLocation", 7, 1, a.f154225a.get("getLocation")));
                            hashMap.put("getCity", new com.tencent.mobileqq.Doraemon.b("getCity", 6, 1, a.f154225a.get("getCity")));
                            hashMap.put("login", new com.tencent.mobileqq.Doraemon.b("login", 17, 0, a.f154225a.get("login")));
                            hashMap.put("loginSilent", new com.tencent.mobileqq.Doraemon.b("loginSilent", 18, 0, a.f154225a.get("loginSilent")));
                            hashMap.put("getUserInfo", new com.tencent.mobileqq.Doraemon.b("getUserInfo", 10, 2, a.f154225a.get("getUserInfo")));
                            hashMap.put("getAppFriends", new com.tencent.mobileqq.Doraemon.b("getAppFriends", 5, 2, a.f154225a.get("getAppFriends")));
                            hashMap.put("getRankingList", new com.tencent.mobileqq.Doraemon.b("getRankingList", 8, 2, a.f154225a.get("getRankingList")));
                            hashMap.put("reportScore", new com.tencent.mobileqq.Doraemon.b("reportScore", 24, 2, a.f154225a.get("reportScore")));
                            hashMap.put(c.NAME, new com.tencent.mobileqq.Doraemon.b(c.NAME, 30, 0, a.f154225a.get(c.NAME)));
                            hashMap.put("shareMessage", new com.tencent.mobileqq.Doraemon.b("shareMessage", 27, 0, a.f154225a.get("shareMessage")));
                            hashMap.put("showActionSheet", new com.tencent.mobileqq.Doraemon.b("showActionSheet", 28, 0, a.f154225a.get("showActionSheet")));
                            hashMap.put("showDialog", new com.tencent.mobileqq.Doraemon.b("showDialog", 29, 0, a.f154225a.get("showDialog")));
                            hashMap.put("getSkey", new com.tencent.mobileqq.Doraemon.b("getSkey", 9, 0, a.f154225a.get("getSkey")));
                            hashMap.put("openWebView", new com.tencent.mobileqq.Doraemon.b("openWebView", 21, 0, a.f154225a.get("openWebView")));
                            hashMap.put("openPlatoView", new com.tencent.mobileqq.Doraemon.b("openPlatoView", 20, 0, a.f154225a.get("openPlatoView")));
                            hashMap.put("openNativeView", new com.tencent.mobileqq.Doraemon.b("openNativeView", 19, 0, a.f154225a.get("openNativeView")));
                            hashMap.put("addEventListener", new com.tencent.mobileqq.Doraemon.b("addEventListener", 1, 0, a.f154225a.get("addEventListener")));
                            hashMap.put("removeEventListener", new com.tencent.mobileqq.Doraemon.b("removeEventListener", 23, 0, a.f154225a.get("removeEventListener")));
                            hashMap.put("dispatchEvent", new com.tencent.mobileqq.Doraemon.b("dispatchEvent", 4, 0, a.f154225a.get("dispatchEvent")));
                            hashMap.put("sdk_dynamic_avatar_edit", new com.tencent.mobileqq.Doraemon.b("sdk_dynamic_avatar_edit", 31, 0, a.f154225a.get("sdk_dynamic_avatar_edit")));
                            hashMap.put("sdk_face_collection", new com.tencent.mobileqq.Doraemon.b("sdk_face_collection", 32, 0, a.f154225a.get("sdk_face_collection")));
                            hashMap.put("sdk_avatar_edit", new com.tencent.mobileqq.Doraemon.b("sdk_avatar_edit", 33, 0, a.f154225a.get("sdk_avatar_edit")));
                            f154226a = Collections.unmodifiableMap(hashMap);
                        }
                    }
                }
                return f154226a;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.Doraemon.manifest.a$a$b */
        /* loaded from: classes9.dex */
        public static final class b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private static Map<String, com.tencent.mobileqq.Doraemon.b> f154227a;

            public static Map<String, com.tencent.mobileqq.Doraemon.b> a() {
                if (f154227a == null) {
                    synchronized (C7084a.class) {
                        if (f154227a == null) {
                            HashMap hashMap = new HashMap();
                            hashMap.putAll(C7085a.a());
                            hashMap.put(DownloadInfo.spKey_Config, new com.tencent.mobileqq.Doraemon.b(DownloadInfo.spKey_Config, 3, 0, a.f154225a.get(DownloadInfo.spKey_Config)));
                            hashMap.put("setShareInfo", new com.tencent.mobileqq.Doraemon.b("setShareInfo", 25, 0, a.f154225a.get("setShareInfo")));
                            hashMap.put("closeWebview", new com.tencent.mobileqq.Doraemon.b("closeWebview", 2, 0, a.f154225a.get("closeWebview")));
                            hashMap.put("refreshTitle", new com.tencent.mobileqq.Doraemon.b("refreshTitle", 22, 0, a.f154225a.get("refreshTitle")));
                            hashMap.put("setShareListener", new com.tencent.mobileqq.Doraemon.b("setShareListener", 26, 0, a.f154225a.get("setShareListener")));
                            hashMap.put("lightappGetSDKVersion", new com.tencent.mobileqq.Doraemon.b("lightappGetSDKVersion", 13, 0, a.f154225a.get("lightappGetSDKVersion")));
                            hashMap.put("lightappShareCallback", new com.tencent.mobileqq.Doraemon.b("lightappShareCallback", 15, 0, a.f154225a.get("lightappShareCallback")));
                            hashMap.put("lightappShareMessage", new com.tencent.mobileqq.Doraemon.b("lightappShareMessage", 16, 0, a.f154225a.get("lightappShareMessage")));
                            hashMap.put("lightappOpenApp", new com.tencent.mobileqq.Doraemon.b("lightappOpenApp", 14, 0, a.f154225a.get("lightappOpenApp")));
                            hashMap.put("lightappDisableLongPress", new com.tencent.mobileqq.Doraemon.b("lightappDisableLongPress", 11, 0, a.f154225a.get("lightappDisableLongPress")));
                            hashMap.put("lightappDisableWebViewLongPress", new com.tencent.mobileqq.Doraemon.b("lightappDisableWebViewLongPress", 12, 0, a.f154225a.get("lightappDisableWebViewLongPress")));
                            f154227a = Collections.unmodifiableMap(hashMap);
                        }
                    }
                }
                return f154227a;
            }
        }

        public C7084a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34261);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<String, Class<? extends e>> hashMap = new HashMap<>();
        f154225a = hashMap;
        hashMap.put("lightappDisableWebViewLongPress", b.class);
        f154225a.put("lightappDisableLongPress", b.class);
        f154225a.put("lightappOpenApp", b.class);
        f154225a.put("lightappShareMessage", b.class);
        f154225a.put("lightappShareCallback", b.class);
        f154225a.put("lightappGetSDKVersion", b.class);
        f154225a.put("setShareListener", com.tencent.mobileqq.Doraemon.impl.webviewModule.c.class);
        f154225a.put("refreshTitle", com.tencent.mobileqq.Doraemon.impl.webviewModule.c.class);
        f154225a.put("closeWebview", com.tencent.mobileqq.Doraemon.impl.webviewModule.c.class);
        f154225a.put("setShareInfo", com.tencent.mobileqq.Doraemon.impl.webviewModule.c.class);
        f154225a.put(DownloadInfo.spKey_Config, com.tencent.mobileqq.Doraemon.impl.webviewModule.b.class);
        f154225a.put("sdk_avatar_edit", d.class);
        f154225a.put("sdk_face_collection", d.class);
        f154225a.put("sdk_dynamic_avatar_edit", d.class);
        f154225a.put("dispatchEvent", com.tencent.mobileqq.Doraemon.impl.internalModule.a.class);
        f154225a.put("removeEventListener", com.tencent.mobileqq.Doraemon.impl.internalModule.a.class);
        f154225a.put("addEventListener", com.tencent.mobileqq.Doraemon.impl.internalModule.a.class);
        f154225a.put("openNativeView", com.tencent.mobileqq.Doraemon.impl.internalModule.c.class);
        f154225a.put("openPlatoView", com.tencent.mobileqq.Doraemon.impl.internalModule.c.class);
        f154225a.put("openWebView", com.tencent.mobileqq.Doraemon.impl.internalModule.c.class);
        f154225a.put("getSkey", com.tencent.mobileqq.Doraemon.impl.internalModule.b.class);
        f154225a.put("showDialog", f.class);
        f154225a.put("showActionSheet", f.class);
        f154225a.put("shareMessage", com.tencent.mobileqq.Doraemon.impl.commonModule.c.class);
        f154225a.put(c.NAME, com.tencent.mobileqq.Doraemon.impl.commonModule.c.class);
        f154225a.put("reportScore", com.tencent.mobileqq.Doraemon.impl.commonModule.a.class);
        f154225a.put("getRankingList", com.tencent.mobileqq.Doraemon.impl.commonModule.a.class);
        f154225a.put("getAppFriends", com.tencent.mobileqq.Doraemon.impl.commonModule.d.class);
        f154225a.put("getUserInfo", com.tencent.mobileqq.Doraemon.impl.commonModule.d.class);
        f154225a.put("loginSilent", com.tencent.mobileqq.Doraemon.impl.commonModule.d.class);
        f154225a.put("login", com.tencent.mobileqq.Doraemon.impl.commonModule.d.class);
        f154225a.put("getCity", com.tencent.mobileqq.Doraemon.impl.commonModule.b.class);
        f154225a.put("getLocation", com.tencent.mobileqq.Doraemon.impl.commonModule.b.class);
        if (f154225a.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.i("Dmanifest", 2, f154225a.toString());
                return;
            }
            return;
        }
        QLog.i("Dmanifest", 1, "D#sModuleMap inject failed !");
    }
}
