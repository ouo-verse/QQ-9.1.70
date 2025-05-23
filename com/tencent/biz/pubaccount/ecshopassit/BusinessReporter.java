package com.tencent.biz.pubaccount.ecshopassit;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.BusinessReportPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class BusinessReporter {

    /* renamed from: a, reason: collision with root package name */
    private static List<List<String>> f79566a;

    /* renamed from: b, reason: collision with root package name */
    private static List<Map<String, Integer>> f79567b;

    public static boolean a() {
        if (f79566a != null) {
            return true;
        }
        return false;
    }

    public static boolean b(String str) {
        List<List<String>> list = f79566a;
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            String host = Uri.parse(str).getHost();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            Iterator<List<String>> it = f79566a.iterator();
            while (it.hasNext()) {
                Iterator<String> it5 = it.next().iterator();
                while (it5.hasNext()) {
                    if (host.contains(it5.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void c(CustomWebView customWebView) {
        if (customWebView != null && customWebView.getPluginEngine() != null) {
            final String url = customWebView.getUrl();
            final WebViewPluginEngine pluginEngine = customWebView.getPluginEngine();
            WebViewPlugin m3 = pluginEngine.m("JD_REPORT");
            if (m3 == null) {
                if (!a()) {
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.ecshopassit.BusinessReporter.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WebViewPluginEngine webViewPluginEngine;
                            BusinessReporter.d();
                            if (BusinessReporter.b(url) && (webViewPluginEngine = pluginEngine) != null) {
                                webViewPluginEngine.D(new String[]{"JD_REPORT"});
                                WebViewPlugin m16 = pluginEngine.m("JD_REPORT");
                                if (m16 != null) {
                                    ((BusinessReportPlugin) m16).p(url);
                                }
                            }
                        }
                    }, 5, null, true);
                    return;
                } else {
                    if (b(url)) {
                        pluginEngine.D(new String[]{"JD_REPORT"});
                        return;
                    }
                    return;
                }
            }
            ((BusinessReportPlugin) m3).p(url);
        }
    }

    public static void d() {
        if (f79567b == null && f79566a == null) {
            f79567b = new ArrayList();
            f79566a = new ArrayList();
            File file = new File(EcShopAssistantManager.T);
            if (file.exists() && file.isFile()) {
                try {
                    JSONArray jSONArray = new JSONArray(FileUtils.readFileContent(file));
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(0);
                        if (jSONObject.getInt("repflag") != 0) {
                            ArrayList arrayList = new ArrayList();
                            HashMap hashMap = new HashMap();
                            JSONArray jSONArray2 = jSONObject.getJSONArray(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
                            for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                                arrayList.add(jSONArray2.getString(i16));
                            }
                            f79566a.add(arrayList);
                            JSONArray jSONArray3 = jSONObject.getJSONArray("report");
                            for (int i17 = 0; i17 < jSONArray3.length(); i17++) {
                                JSONObject jSONObject2 = jSONArray3.getJSONObject(i17);
                                hashMap.put(jSONObject2.getString("urlprefix"), Integer.valueOf(jSONObject2.getInt("tvalue")));
                            }
                            f79567b.add(hashMap);
                        }
                    }
                } catch (Exception e16) {
                    QLog.e("BusinessReporter", 1, "parse report json error:" + e16);
                }
            }
        }
    }

    public static void e(AppInterface appInterface, String str, String str2) {
        EcshopReportHandler ecshopReportHandler;
        boolean z16;
        if ((appInterface instanceof BrowserAppInterface) && !TextUtils.isEmpty(str) && f79567b != null) {
            String host = Uri.parse(str2).getHost();
            if (TextUtils.isEmpty(host)) {
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            Map<String, Integer> map = null;
            for (int i3 = 0; i3 < f79566a.size(); i3++) {
                Iterator<String> it = f79566a.get(i3).iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (host.contains(it.next())) {
                            map = f79567b.get(i3);
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (z16) {
                    break;
                }
            }
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    String key = entry.getKey();
                    int intValue = entry.getValue().intValue();
                    if (!TextUtils.isEmpty(key)) {
                        sb5.append("https://");
                        sb5.append(key);
                        if (str.startsWith(sb5.toString())) {
                            EcshopReportHandler ecshopReportHandler2 = (EcshopReportHandler) appInterface.getBusinessHandler(BrowserAppInterface.J);
                            if (ecshopReportHandler2 != null) {
                                ecshopReportHandler2.H2(intValue, null, str2, null, null, 0L, false);
                                return;
                            }
                        } else {
                            sb5.setLength(0);
                            sb5.append("https://");
                            sb5.append(key);
                            if (str.startsWith(sb5.toString()) && (ecshopReportHandler = (EcshopReportHandler) appInterface.getBusinessHandler(BrowserAppInterface.J)) != null) {
                                ecshopReportHandler.H2(intValue, null, str2, null, null, 0L, false);
                                return;
                            }
                        }
                        sb5.setLength(0);
                    }
                }
            }
        }
    }
}
