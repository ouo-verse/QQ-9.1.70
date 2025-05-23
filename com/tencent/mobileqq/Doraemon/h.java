package com.tencent.mobileqq.Doraemon;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h implements com.tencent.mobileqq.webview.nativeapi.b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f154096b;

    /* renamed from: a, reason: collision with root package name */
    private LruCache<String, com.tencent.mobileqq.Doraemon.impl.webview.a> f154097a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends LruCache<String, com.tencent.mobileqq.Doraemon.impl.webview.a> {
        static IPatchRedirector $redirector_;

        a(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z16, String str, com.tencent.mobileqq.Doraemon.impl.webview.a aVar, com.tencent.mobileqq.Doraemon.impl.webview.a aVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, aVar, aVar2);
            } else {
                super.entryRemoved(z16, str, aVar, aVar2);
                aVar.s();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29762);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f154096b = false;
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.nativeapi.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        LruCache<String, com.tencent.mobileqq.Doraemon.impl.webview.a> lruCache = this.f154097a;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }

    @Override // com.tencent.mobileqq.webview.nativeapi.b
    public boolean b(CustomWebView customWebView, String str, Activity activity, boolean z16) {
        JSONObject jSONObject;
        com.tencent.mobileqq.Doraemon.impl.webview.b bVar;
        String h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, customWebView, str, activity, Boolean.valueOf(z16))).booleanValue();
        }
        String url = customWebView.getUrl();
        int indexOf = str.indexOf(63);
        if (indexOf == -1) {
            if (QLog.isColorLevel()) {
                QLog.d("NativeApiManagerImpl", 2, "invalid native api call, '?' request");
            }
            return true;
        }
        String substring = str.substring(12, indexOf);
        if (!str.startsWith("p=", indexOf + 1)) {
            if (QLog.isColorLevel()) {
                QLog.d("NativeApiManagerImpl", 2, "invalid native api call, param key not found");
            }
            return true;
        }
        if (!z16 && WebViewPluginEngine.c(customWebView.getUrl(), "nativeapi", substring, false)) {
            return true;
        }
        try {
            jSONObject = new JSONObject(URLDecoder.decode(str.substring(indexOf + 3)));
            bVar = new com.tencent.mobileqq.Doraemon.impl.webview.b(customWebView, jSONObject);
            h16 = DoraemonUtil.h(url);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("NativeApiManagerImpl", 2, "invalid native api call, parse param error", e16);
            }
        }
        if (TextUtils.isEmpty(h16)) {
            if (QLog.isColorLevel()) {
                QLog.d("NativeApiManagerImpl", 2, "invalid native api call, url is illegal");
            }
            return true;
        }
        if (this.f154097a == null) {
            if (!f154096b) {
                f154096b = true;
                ((IDoraemonService) QRoute.api(IDoraemonService.class)).prepare();
            }
            this.f154097a = new a(2);
        }
        com.tencent.mobileqq.Doraemon.impl.webview.a aVar = this.f154097a.get(h16);
        if (DownloadInfo.spKey_Config.equals(substring)) {
            if (aVar == null) {
                String optString = jSONObject.optString("appid");
                Bundle bundle = new Bundle();
                bundle.putString("urlSummary", h16);
                aVar = (com.tencent.mobileqq.Doraemon.impl.webview.a) ((IDoraemonService) QRoute.api(IDoraemonService.class)).createAPIManager(activity, 0, optString, bundle);
                if (aVar != null) {
                    String optString2 = jSONObject.optString("state");
                    String optString3 = jSONObject.optString(CommonConstant.ReqAccessTokenParam.REDIRECT_URI);
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        aVar.f154213v = true;
                        aVar.f154214w = optString2;
                        aVar.f154215x = optString3;
                    }
                    this.f154097a.put(h16, aVar);
                }
            }
            if (aVar != null) {
                aVar.d(substring, jSONObject, bVar);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("NativeApiManagerImpl", 2, "apimgr create fail");
                }
                DoraemonUtil.d(bVar, 11);
            }
        } else if (aVar != null && aVar.G()) {
            aVar.d(substring, jSONObject, bVar);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("NativeApiManagerImpl", 2, "apimgr not verified");
            }
            DoraemonUtil.d(bVar, 10);
        }
        return true;
    }

    public DoraemonAPIManager c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (DoraemonAPIManager) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        String h16 = DoraemonUtil.h(str);
        if (TextUtils.isEmpty(h16)) {
            if (QLog.isColorLevel()) {
                QLog.d("NativeApiManagerImpl", 2, "invalid native api call, url is illegal");
            }
            return null;
        }
        LruCache<String, com.tencent.mobileqq.Doraemon.impl.webview.a> lruCache = this.f154097a;
        if (lruCache == null) {
            return null;
        }
        return lruCache.get(h16);
    }
}
