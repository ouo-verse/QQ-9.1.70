package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.comic.ui.QQComicFragment;
import com.tencent.gdtad.web.GdtWebViewFragment;
import com.tencent.mobileqq.activity.about.PolarLightWebViewFragment;
import com.tencent.mobileqq.ad.landingpage.LandingPageWebFragment;
import com.tencent.mobileqq.emoticonview.EmoStoreWebViewFragment;
import com.tencent.mobileqq.matchfriend.fragment.MatchFriendVerifyWebFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgift.verify.QQGiftPanelVerifyWebFragment;
import com.tencent.mobileqq.qqlive.widget.verify.FaceVerifyWebFragment;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneTranslucentBrowserFragment;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class aa {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_web_fragment_map.yml", version = 3)
    public static final HashMap<String, Class<? extends h>> f314185a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49097);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<String, Class<? extends h>> hashMap = new HashMap<>();
        f314185a = hashMap;
        hashMap.put("12", GdtWebViewFragment.class);
        hashMap.put("11", LandingPageWebFragment.class);
        hashMap.put("10", PolarLightWebViewFragment.class);
        hashMap.put("9", MatchFriendVerifyWebFragment.class);
        hashMap.put("8", QQGiftPanelVerifyWebFragment.class);
        hashMap.put("7", FaceVerifyWebFragment.class);
        hashMap.put("5", com.tencent.mobileqq.nearby.verify.FaceVerifyWebFragment.class);
        hashMap.put("4", EmoStoreWebViewFragment.class);
        hashMap.put("2", QzoneTranslucentBrowserFragment.class);
        hashMap.put("1", QQComicFragment.class);
        if (hashMap.size() > 0) {
            if (QLog.isColorLevel()) {
                for (Map.Entry<String, Class<? extends h>> entry : hashMap.entrySet()) {
                    QLog.i("WebViewFragmentBuilder", 2, "Key = " + entry.getKey() + ", Value = " + entry.getValue().toString());
                }
                return;
            }
            return;
        }
        QLog.e("WebViewFragmentBuilder", 1, "S_WEB_VIEW_FRAGMENT inject failed !");
    }

    public static WebViewFragment a(u uVar, WebViewTabBarData webViewTabBarData, Intent intent) {
        int i3;
        if (webViewTabBarData.url.contains("https://ida.webank.com/api/web/login")) {
            i3 = 5;
        } else if (!webViewTabBarData.url.contains("https://jiazhang.qq.com/wap/zk") && !webViewTabBarData.url.contains("https://test.jiazhang.qq.com/wap/zk")) {
            if (webViewTabBarData.url.equals("https://qlive.qq.com/pages/name-auth.html")) {
                i3 = 7;
            } else {
                if (webViewTabBarData.url.contains("_webviewtype=")) {
                    Uri parse = Uri.parse(webViewTabBarData.url);
                    if (parse.isHierarchical() && "4".equals(parse.getQueryParameter("_webviewtype"))) {
                        intent.putExtra("fragmentStyle", 1);
                        intent.putExtra("tabBarStyle", 1);
                        intent.putExtra("titleBarStyle", 1);
                        intent.putExtra("hide_operation_bar", true);
                        intent.putExtra("hide_more_button", true);
                        intent.putExtra("isScreenOrientationPortrait", true);
                        i3 = 1;
                    }
                }
                i3 = 0;
            }
        } else {
            i3 = 9;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebViewFragmentBuilder", 2, "crateWebViewFragmentByUrl style=", Integer.valueOf(i3), ", url=", webViewTabBarData.url);
        }
        return b(i3, uVar, webViewTabBarData, intent);
    }

    public static WebViewFragment b(int i3, u uVar, WebViewTabBarData webViewTabBarData, Intent intent) {
        boolean isDebugVersion;
        RuntimeException runtimeException;
        if (QLog.isColorLevel()) {
            QLog.d("WebViewFragmentBuilder", 2, "createFragmentByStyle style=", Integer.valueOf(i3));
        }
        String valueOf = String.valueOf(i3);
        if (!TextUtils.isEmpty(valueOf)) {
            HashMap<String, Class<? extends h>> hashMap = f314185a;
            if (hashMap.containsKey(valueOf)) {
                try {
                    return hashMap.get(valueOf).newInstance().newInstance(i3, uVar, webViewTabBarData, intent);
                } finally {
                    if (isDebugVersion) {
                    }
                }
            }
        }
        return null;
    }
}
