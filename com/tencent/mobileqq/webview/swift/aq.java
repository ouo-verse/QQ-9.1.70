package com.tencent.mobileqq.webview.swift;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.comic.ui.QQComicTabBarView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class aq {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_web_view_tab_bar_map.yml", version = 3)
    public static HashMap<String, Class<? extends i>> f314206a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49169);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<String, Class<? extends i>> hashMap = new HashMap<>();
        f314206a = hashMap;
        hashMap.put("1", QQComicTabBarView.class);
        if (f314206a.size() > 0) {
            if (QLog.isColorLevel()) {
                for (Map.Entry<String, Class<? extends i>> entry : f314206a.entrySet()) {
                    QLog.i("WebviewFragmentTabBarBuilder", 2, "Key = " + entry.getKey() + ", Value = " + entry.getValue().toString());
                }
                return;
            }
            return;
        }
        QLog.e("WebviewFragmentTabBarBuilder", 1, "sWebViewTabBar inject failed !");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static View a(Context context, Intent intent, List<WebViewTabBarData> list, TabBarView.d dVar) {
        int i3;
        i iVar;
        boolean isDebugVersion;
        RuntimeException runtimeException;
        if (intent != null) {
            i3 = intent.getIntExtra("tabBarStyle", 0);
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.i("WebviewFragmentTabBarBuilder", 1, "tab bar style =" + i3);
        }
        String valueOf = String.valueOf(i3);
        if (!TextUtils.isEmpty(valueOf) && f314206a.containsKey(valueOf)) {
            try {
                Constructor<? extends i> declaredConstructor = f314206a.get(valueOf).getDeclaredConstructor(Context.class);
                declaredConstructor.setAccessible(true);
                iVar = declaredConstructor.newInstance(context);
            } finally {
                if (isDebugVersion) {
                }
            }
            if (iVar == null) {
                iVar = new SwiftFragmentTabBar(context);
            }
            iVar.a(intent, list, dVar);
            return iVar.b();
        }
        iVar = null;
        if (iVar == null) {
        }
        iVar.a(intent, list, dVar);
        return iVar.b();
    }

    @NonNull
    public static ArrayList<WebViewTabBarData> b(Intent intent) {
        ArrayList<WebViewTabBarData> arrayList;
        Serializable serializableExtra = intent.getSerializableExtra(QQBrowserActivity.TAB_CONFIG_DATA);
        if (serializableExtra instanceof ArrayList) {
            arrayList = (ArrayList) serializableExtra;
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            WebViewTabBarData webViewTabBarData = new WebViewTabBarData();
            webViewTabBarData.tag = "web";
            String stringExtra = intent.getStringExtra("url");
            webViewTabBarData.url = stringExtra;
            if (stringExtra == null) {
                webViewTabBarData.url = "";
                QLog.e(QQBrowserActivity.TAG, 1, "url = null");
            }
            ArrayList<WebViewTabBarData> arrayList2 = new ArrayList<>(1);
            arrayList2.add(webViewTabBarData);
            return arrayList2;
        }
        return arrayList;
    }
}
