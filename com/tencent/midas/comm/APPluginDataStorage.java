package com.tencent.midas.comm;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* loaded from: classes9.dex */
public class APPluginDataStorage {
    private static ExecutorService poolExecutor;
    private static final ExecutorService singleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
    private static final HashMap<String, String> spCache = new HashMap<>();
    private static boolean hasInit = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static void commit(final SharedPreferences.Editor editor) {
        singleThreadExecutor.execute(new Runnable() { // from class: com.tencent.midas.comm.APPluginDataStorage.2
            @Override // java.lang.Runnable
            public void run() {
                editor.commit();
            }
        });
    }

    public static void doAsyncTask(Runnable runnable) {
        if (poolExecutor == null) {
            try {
                poolExecutor = ProxyExecutors.newCachedThreadPool();
            } catch (Exception e16) {
                e16.printStackTrace();
                new BaseThread(runnable).start();
                return;
            }
        }
        poolExecutor.execute(runnable);
    }

    public static String getData(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        HashMap<String, String> hashMap = spCache;
        if (hashMap.get(str2) == null) {
            return "";
        }
        return hashMap.get(str2);
    }

    public static void initCache(final Context context, final String str) {
        if (context != null && !hasInit) {
            doAsyncTask(new Runnable() { // from class: com.tencent.midas.comm.APPluginDataStorage.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        boolean unused = APPluginDataStorage.hasInit = true;
                        Map<String, ?> all = context.getSharedPreferences(str, 4).getAll();
                        for (String str2 : all.keySet()) {
                            try {
                                Object obj = all.get(str2);
                                if (obj instanceof String) {
                                    APPluginDataStorage.spCache.put(str2, String.valueOf(obj));
                                }
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
            });
        }
    }

    public static void storeData(final Context context, final String str, final String str2, final String str3) {
        if (context == null) {
            return;
        }
        spCache.put(str2, str3);
        doAsyncTask(new Runnable() { // from class: com.tencent.midas.comm.APPluginDataStorage.3
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                if (context2 == null) {
                    return;
                }
                try {
                    SharedPreferences.Editor edit = context2.getSharedPreferences(str, 4).edit();
                    edit.putString(str2, str3);
                    APPluginDataStorage.commit(edit);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        });
    }
}
