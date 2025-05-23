package com.tencent.qqmini.sdk.browser;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes23.dex */
public class BrowserPluginEngine {
    private static final String TAG = "BrowserPluginEngine";
    public Activity mActivity;
    Fragment mBrowserFragment;
    private volatile WebView mWebview;
    private final ConcurrentHashMap<String, BrowserPlugin> pluginHashMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, BrowserPlugin> pluginEventHashMap = new ConcurrentHashMap<>();

    public BrowserPluginEngine(Activity activity, WebView webView) {
        this.mActivity = activity;
        this.mWebview = webView;
        preCreatePlugin();
    }

    private BrowserPlugin createPlugin(String str) {
        BrowserPlugin createWebViewPlugin = BrowserPluginFactory.createWebViewPlugin(str);
        insertPlugin(str, createWebViewPlugin);
        initPlugin(createWebViewPlugin);
        return createWebViewPlugin;
    }

    private static boolean handleJsBridgeUrlRequest(BrowserPluginEngine browserPluginEngine, WebView webView, String str) {
        String str2;
        String[] strArr;
        String[] split = (str + "/#").split("/");
        if (split.length < 5) {
            QMLog.e(TAG, "illegal jsbridge:" + str);
            return true;
        }
        String str3 = split[2];
        if (split.length == 5) {
            String[] split2 = split[3].split("#");
            if (split2.length > 1) {
                try {
                    Integer.parseInt(split2[1]);
                } catch (NumberFormatException e16) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("");
                    StringBuilder sb6 = new StringBuilder("illegal jsbridge[");
                    sb6.append(str);
                    sb6.append("] error:");
                    sb6.append(e16.toString());
                    sb5.append((Object) sb6);
                    QMLog.e(TAG, sb5.toString());
                    return true;
                }
            }
            String[] split3 = split2[0].split("\\?");
            str2 = split3[0];
            if (split3.length > 1) {
                strArr = split3[1].split(ContainerUtils.FIELD_DELIMITER);
                if (strArr.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    int length = strArr.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        int indexOf = strArr[i3].indexOf(61);
                        if (indexOf != -1) {
                            if (!"mqq_tt".equals(strArr[i3].substring(0, indexOf))) {
                                arrayList.add(URLDecoder.decode(strArr[i3].substring(indexOf + 1)));
                            }
                        } else {
                            arrayList.add("");
                        }
                    }
                    strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                }
            } else {
                strArr = new String[0];
            }
        } else {
            String str4 = split[3];
            try {
                Long.parseLong(split[4]);
                int length2 = split.length - 6;
                String[] strArr2 = new String[length2];
                System.arraycopy(split, 5, strArr2, 0, length2);
                for (int i16 = 0; i16 < length2; i16++) {
                    strArr2[i16] = URLDecoder.decode(strArr2[i16]);
                }
                str2 = str4;
                strArr = strArr2;
            } catch (Exception e17) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("");
                StringBuilder sb8 = new StringBuilder("illegal jsbridge[");
                sb8.append(str);
                sb8.append("] error:");
                sb8.append(e17.toString());
                sb7.append((Object) sb8);
                QMLog.e(TAG, sb7.toString());
                return true;
            }
        }
        webView.getUrl();
        BrowserPlugin pluginByNameSpace = browserPluginEngine.getPluginByNameSpace(str3);
        if (pluginByNameSpace == null) {
            pluginByNameSpace = browserPluginEngine.createPlugin(str3);
        }
        if (pluginByNameSpace != null) {
            handleJsRequest(pluginByNameSpace, str, str3, str2, strArr);
        }
        return true;
    }

    private static boolean handleJsRequest(BrowserPlugin browserPlugin, String str, String str2, String str3, String[] strArr) {
        long currentTimeMillis;
        if (browserPlugin == null) {
            return false;
        }
        try {
            currentTimeMillis = System.currentTimeMillis();
        } catch (Exception e16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            StringBuilder sb6 = new StringBuilder("plugin[");
            sb6.append(browserPlugin.getClass().getSimpleName());
            sb6.append("] handle JsApi[");
            sb6.append(str2);
            sb6.append(".");
            sb6.append(str3);
            sb6.append("] error:");
            sb6.append(e16.toString());
            sb5.append((Object) sb6);
            QMLog.e(TAG, sb5.toString());
        }
        if (browserPlugin.handleJsRequest(str, str2, str3, strArr)) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (QMLog.isColorLevel()) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("");
                StringBuilder sb8 = new StringBuilder("plugin[");
                sb8.append(browserPlugin.getClass().getSimpleName());
                sb8.append("] handle JsApi[");
                sb8.append(str2);
                sb8.append(".");
                sb8.append(str3);
                sb8.append("] cost ");
                sb8.append(currentTimeMillis2);
                sb8.append(" ms.");
                sb7.append((Object) sb8);
                QMLog.d(TAG, sb7.toString());
                return true;
            }
            return true;
        }
        if (QMLog.isColorLevel()) {
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            StringBuilder sb9 = new StringBuilder();
            sb9.append("");
            StringBuilder sb10 = new StringBuilder("plugin[");
            sb10.append(browserPlugin.getClass().getSimpleName());
            sb10.append("] ignore JsApi[");
            sb10.append(str2);
            sb10.append(".");
            sb10.append(str3);
            sb10.append("] cost ");
            sb10.append(currentTimeMillis3);
            sb10.append(" ms.");
            sb9.append((Object) sb10);
            QMLog.d(TAG, sb9.toString());
        }
        return false;
    }

    private void initPlugin(BrowserPlugin browserPlugin) {
        if (browserPlugin != null) {
            browserPlugin.initRuntime(this.mActivity);
            browserPlugin.setFragment(this.mBrowserFragment);
            browserPlugin.onCreate();
            if (this.mWebview != null) {
                browserPlugin.onWebViewCreated(this.mWebview);
            }
        }
    }

    private void insertPlugin(String str, BrowserPlugin browserPlugin) {
        if (!TextUtils.isEmpty(str) && browserPlugin != null) {
            if (this.pluginHashMap.containsKey(str)) {
                QMLog.e(TAG, "insertPlugin:namespace " + str + " already exists!");
                return;
            }
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "insertPlugin:add pair [" + str + "] -> " + browserPlugin.getClass().getSimpleName());
            }
            this.pluginHashMap.put(str, browserPlugin);
        }
    }

    private boolean internalShouldOverrideUrlRequest(String str) {
        String schemeFromUrl = BrowserUtils.getSchemeFromUrl(str);
        if (TextUtils.isEmpty(schemeFromUrl) || !"jsbridge".equals(schemeFromUrl)) {
            return false;
        }
        return handleJsBridgeUrlRequest(this, this.mWebview, str);
    }

    private void preCreatePlugin() {
        createPlugin("miniApp");
    }

    public void bindFragment(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        this.mBrowserFragment = fragment;
        for (BrowserPlugin browserPlugin : this.pluginHashMap.values()) {
            if (browserPlugin != null) {
                browserPlugin.setFragment(fragment);
            }
        }
    }

    public BrowserPlugin getPluginByNameSpace(String str) {
        if (this.pluginHashMap.containsKey(str)) {
            return this.pluginHashMap.get(str);
        }
        return null;
    }

    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        StringBuilder sb5;
        Collection<BrowserPlugin> values = this.pluginHashMap.values();
        if (QMLog.isColorLevel()) {
            sb5 = new StringBuilder(values.size() * 64);
        } else {
            sb5 = new StringBuilder();
        }
        for (BrowserPlugin browserPlugin : values) {
            if (browserPlugin != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (browserPlugin.handleEvent(str, j3, map)) {
                    if (QMLog.isColorLevel()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 50) {
                            sb5.append("plugin[");
                            sb5.append(browserPlugin.getClass().getSimpleName());
                            sb5.append("] handled event[");
                            sb5.append("] success cost ");
                            sb5.append(currentTimeMillis2);
                            sb5.append(" ms.");
                            QMLog.i(TAG, sb5.toString());
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
            }
        }
        if (QMLog.isColorLevel() && sb5.length() > 0) {
            sb5.append("handleEvent error: no plugin can handleEvent(");
            sb5.append(")");
            QMLog.i(TAG, sb5.toString());
            return false;
        }
        return false;
    }

    public void onDestroy() {
        HashMap hashMap = new HashMap();
        for (BrowserPlugin browserPlugin : this.pluginHashMap.values()) {
            if (browserPlugin != null && !hashMap.containsKey(browserPlugin)) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    browserPlugin.onDestroy();
                    hashMap.put(browserPlugin, Boolean.TRUE);
                } catch (Exception e16) {
                    if (QMLog.isColorLevel()) {
                        QMLog.d(TAG, "", e16);
                    }
                }
                if (QMLog.isColorLevel()) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 > 50) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("");
                        StringBuilder sb6 = new StringBuilder("plugin[");
                        sb6.append(browserPlugin.getClass().getSimpleName());
                        sb6.append("] onDestroy cost ");
                        sb6.append(currentTimeMillis2);
                        sb6.append(" ms.");
                        sb5.append((Object) sb6);
                        QMLog.d(TAG, sb5.toString());
                    }
                }
            }
        }
        this.pluginHashMap.clear();
        this.mWebview = null;
        this.mActivity = null;
        this.mBrowserFragment = null;
    }

    public boolean shouldOverrideUrlRequest(String str) {
        return internalShouldOverrideUrlRequest(str);
    }
}
