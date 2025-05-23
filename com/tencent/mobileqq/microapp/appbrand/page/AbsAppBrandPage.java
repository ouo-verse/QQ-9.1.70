package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.widget.TabBarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes15.dex */
public abstract class AbsAppBrandPage {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "AbsAppBrandPage";
    protected c apkgInfo$5475ea27;
    protected AppBrandPageContainer appBrandPageContainer;
    private boolean isShow;

    public AbsAppBrandPage(Context context, AppBrandPageContainer appBrandPageContainer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) appBrandPageContainer);
        } else {
            this.appBrandPageContainer = appBrandPageContainer;
            this.apkgInfo$5475ea27 = appBrandPageContainer.appBrandRuntime.f245898c;
        }
    }

    private void dispatch(String str, String str2) {
        Object obj;
        HashMap hashMap = new HashMap();
        String l3 = c.l(str2);
        Map m3 = c.m(str2);
        hashMap.put("path", l3);
        hashMap.put("query", m3);
        if (str != null) {
            hashMap.put("openType", str);
        }
        if (EventListener.APPLAUNCH.equals(str)) {
            hashMap.put("scene", Integer.valueOf(this.apkgInfo$5475ea27.f245825f.launchParam.scene));
            if (TextUtils.isEmpty(this.apkgInfo$5475ea27.f245825f.launchParam.navigateExtData)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appId", this.apkgInfo$5475ea27.f245823d);
                    jSONObject.put(WadlProxyConsts.EXTRA_DATA, this.apkgInfo$5475ea27.f245825f.launchParam.navigateExtData);
                    hashMap.put("referrerInfo", jSONObject.toString());
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 4, "dispatch referrerInfo parse error", e16);
                    }
                }
            }
        }
        c.a(hashMap);
        JSONObject jSONObject2 = new JSONObject(hashMap);
        PageWebview webView = getWebView(str2);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("dispatch openType=");
            sb5.append(str);
            sb5.append(JefsClass.INDEX_URL);
            sb5.append(str2);
            sb5.append(",webView=");
            if (webView != null) {
                obj = Integer.valueOf(webView.pageWebviewId);
            } else {
                obj = GlobalUtil.DEF_STRING;
            }
            sb5.append(obj);
            sb5.append(",jsonParams=");
            sb5.append(jSONObject2.toString());
            QLog.d(TAG, 2, sb5.toString());
        }
        if (webView != null) {
            this.appBrandPageContainer.appBrandRuntime.f245904i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onAppRoute\", " + jSONObject2 + ", " + webView.pageWebviewId + ");");
            this.appBrandPageContainer.appBrandRuntime.f245904i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onAppRouteDone\", " + jSONObject2 + ", " + webView.pageWebviewId + ");");
        }
    }

    public void cleanup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "cleanup");
        }
    }

    public abstract View createContentView();

    public boolean forceRemoveNoMatchOnPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }

    public abstract FrameLayout getCenterLayout();

    public PageWebview getCurrentPageWebview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (PageWebview) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return null;
    }

    public abstract WebviewContainer getCurrentWebviewContainer();

    public abstract TabBarView getTabBar();

    public abstract String getUrl();

    public abstract PageWebview getWebView(int i3);

    public abstract PageWebview getWebView(String str);

    public final void hide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "hide isShow=" + this.isShow);
        }
    }

    public void hideToastView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    public abstract boolean isHomePage();

    public abstract boolean isTabPage();

    public abstract void loadUrl(String str, String str2);

    public abstract void notifyChangePullDownRefreshStyle();

    public void onAppRoute(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "onAppRoute openType=" + str + JefsClass.INDEX_URL + str2);
        }
        dispatch(str, str2);
    }

    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public void onPageBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "onPageBackground");
        }
        this.isShow = false;
    }

    public void onPageForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "onPageForeground");
        }
        this.isShow = true;
    }

    public void showToastView(String str, String str2, CharSequence charSequence, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, charSequence, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }

    public abstract void stopPullDownRefresh();

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "[currUrl=" + getUrl() + "]";
    }
}
