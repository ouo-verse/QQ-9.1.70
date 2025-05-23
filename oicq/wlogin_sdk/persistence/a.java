package oicq.wlogin_sdk.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f422781a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<String, Object> f422782b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final Map<String, b> f422783c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public static ExecutorService f422784d = null;

    public static Object a(String str) {
        Object obj;
        Map<String, Object> map = f422782b;
        synchronized (map) {
            obj = map.get(str);
            if (obj == null) {
                obj = new Object();
                map.put(str, obj);
            }
        }
        return obj;
    }

    public static SharedPreferences a(@NonNull Context context, @NonNull String str) {
        c cVar;
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(context, str, QMMKVFile.FILE_WTLOGIN);
        synchronized (a(str)) {
            Map<String, String> map = f422781a;
            if (map.containsKey(str)) {
                cVar = new c(context, fromSpAdapter, str, QMMKVFile.FILE_WTLOGIN, true);
            } else {
                if (!fromSpAdapter.getBoolean("_wtlogin_migrate_flag", false)) {
                    Map<String, ?> all = context.getSharedPreferences(str, 0).getAll();
                    if (all == null || all.isEmpty()) {
                        util.LOGI("WtloginMMKV [getMMkvSp], SP: " + str + " is null, return MMKV", "");
                        fromSpAdapter.edit().putBoolean("_wtlogin_migrate_flag", true).apply();
                        return new c(context, fromSpAdapter, str, QMMKVFile.FILE_WTLOGIN, true);
                    }
                    int i3 = fromSpAdapter.getInt("_wtlogin_migrate_count", 0);
                    if (i3 > 10) {
                        util.LOGI("WtloginMMKV migrate " + str + " to " + QMMKVFile.FILE_WTLOGIN + " fail " + i3 + " times, use old sp", "");
                        return new c(context, context.getSharedPreferences(str, 4), str, QMMKVFile.FILE_WTLOGIN, false);
                    }
                    String f16 = u.f();
                    if (TextUtils.isEmpty(f16) || !f16.endsWith(":MSF")) {
                        util.LOGI("WtloginMMKV migrate " + str + " to " + QMMKVFile.FILE_WTLOGIN + " with " + f16 + " is not allowed", "");
                        return new c(context, context.getSharedPreferences(str, 4), str, QMMKVFile.FILE_WTLOGIN, false);
                    }
                    Map<String, b> map2 = f422783c;
                    if (map2.get(str) == null) {
                        b bVar = new b(context, str, QMMKVFile.FILE_WTLOGIN);
                        map2.put(str, bVar);
                        if (f422784d == null) {
                            f422784d = ProxyExecutors.newFixedThreadPool(2);
                        }
                        f422784d.submit(bVar);
                    }
                    util.LOGI("WtloginMMKV sp has not migrate to mmkv\uff0cuse old sp: " + str, "");
                    return new c(context, context.getSharedPreferences(str, 4), str, QMMKVFile.FILE_WTLOGIN, false);
                }
                map.put(str, str);
                cVar = new c(context, fromSpAdapter, str, QMMKVFile.FILE_WTLOGIN, true);
            }
            return cVar;
        }
    }
}
