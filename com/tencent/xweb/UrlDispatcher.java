package com.tencent.xweb;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.wq.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UrlDispatcher {
    public static final String TAG = "UrlDispatcher";

    /* renamed from: a, reason: collision with root package name */
    public static List f384970a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static List f384971b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static List f384972c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public static boolean f384973d;

    static {
        init();
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (!trim.startsWith("http")) {
            trim = "http://" + trim;
        }
        String host = Uri.parse(trim).getHost();
        x0.d(TAG, "getHost, host:" + host + ", url:" + trim);
        return host;
    }

    public static List b(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        String[] split = str.split(",");
        if (split != null && split.length != 0) {
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2.trim());
                }
            }
        }
        return arrayList;
    }

    public static synchronized boolean init() {
        synchronized (UrlDispatcher.class) {
            if (f384973d) {
                return true;
            }
            try {
                String cmd = CommandCfg.getInstance().getCmd("tools_white_list_host_suffix", "tools");
                String cmd2 = CommandCfg.getInstance().getCmd("new_white_list_host_suffix", "tools");
                String cmd3 = CommandCfg.getInstance().getCmd("new_black_list_host_suffix", "tools");
                f384970a.addAll(b(cmd));
                f384971b.addAll(b(cmd2));
                f384972c.addAll(b(cmd3));
                f384973d = true;
            } catch (Throwable th5) {
                x0.a(TAG, "init failed error", th5);
            }
            return f384973d;
        }
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static boolean needSwitchToTools(String str) {
        if (!init()) {
            x0.d(TAG, "needSwitchToTools false, init failed, url:" + str);
            return false;
        }
        String a16 = a(str);
        if (TextUtils.isEmpty(a16)) {
            x0.c(TAG, "needSwitchToTools false, host is empty");
            return false;
        }
        if (a(a16, f384970a)) {
            x0.d(TAG, "needSwitchToTools true, host in whitelist, host:" + a16);
            p.a(a16, 1);
            return true;
        }
        x0.d(TAG, "needSwitchToTools false, host:" + a16 + ", url:" + str);
        return false;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static boolean needUseXWeb(String str) {
        if (!init()) {
            x0.d(TAG, "needUseXWeb true, init failed, url:" + str);
            return true;
        }
        String a16 = a(str);
        if (TextUtils.isEmpty(a16)) {
            x0.c(TAG, "needUseXWeb true, host is empty");
            return true;
        }
        if (a(a16, f384971b)) {
            x0.d(TAG, "needUseXWeb true, host in whitelist, host:" + a16);
            p.a(a16, 2);
            return true;
        }
        if (a(a16, f384972c)) {
            x0.d(TAG, "needUseXWeb false, host in blacklist, host:" + a16);
            p.a(a16, 3);
            return false;
        }
        x0.d(TAG, "needUseXWeb true, host:" + a16 + ", url:" + str);
        return true;
    }

    public static synchronized void refresh() {
        synchronized (UrlDispatcher.class) {
            f384973d = false;
            f384970a = new ArrayList();
            f384971b = new ArrayList();
            f384972c = new ArrayList();
            init();
        }
    }

    public static boolean a(String str, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!TextUtils.isEmpty(str)) {
                if ("all".equalsIgnoreCase(str2)) {
                    return true;
                }
                if (str.endsWith(str2) && (str.length() == str2.length() || str.charAt((str.length() - str2.length()) - 1) == '.')) {
                    return true;
                }
            }
        }
        return false;
    }
}
