package com.tencent.minibox.loader.core;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.recyclerview.BuildConfig;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f151656a = Arrays.asList("com.tencent.minibox.dynamic.api", "com.tencent.minibox.contract", "com.tencent.minibox.proxy", BuildConfig.LIBRARY_PACKAGE_NAME);

    /* renamed from: b, reason: collision with root package name */
    private static DexClassLoader f151657b;

    private static String a(String str) {
        File file = new File(str);
        if (file.exists()) {
            StringBuilder sb5 = new StringBuilder();
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                sb5.append(listFiles[0]);
                for (int i3 = 1; i3 < listFiles.length; i3++) {
                    sb5.append(":");
                    sb5.append(listFiles[i3]);
                }
                return sb5.toString();
            }
            LogUtils.e("PluginClassLoaderHelper", "[getFormatDexPath] plugins is null or empty");
            return "";
        }
        return "";
    }

    public static synchronized ClassLoader b(Context context) throws Exception {
        synchronized (b.class) {
            if (f151657b == null) {
                LogUtils.d("PluginClassLoaderHelper", "getOrCreateClassLoader");
                long currentTimeMillis = System.currentTimeMillis();
                PluginVersionManager pluginVersionManager = PluginVersionManager.f151646b;
                PluginPathConfig g16 = pluginVersionManager.g(context);
                if (g16 == null) {
                    LogUtils.e("PluginClassLoaderHelper", "getOrCreateClassLoader: dex config is null");
                    Toast.makeText(context, R.string.f161991z8, 1).show();
                    pluginVersionManager.f(context);
                    SystemMethodProxy.killProcess(Process.myPid());
                    return null;
                }
                String a16 = a(g16.getDexPath());
                LogUtils.w("PluginClassLoaderHelper", "plugin dex path: " + a16);
                if (TextUtils.isEmpty(a16)) {
                    LogUtils.w("PluginClassLoaderHelper", "plugin not installed");
                    return null;
                }
                f151657b = new c(a16, g16.getOdexPath(), g16.getLibPath(), context.getClassLoader(), f151656a);
                LogUtils.w("PluginClassLoaderHelper", "getOrCreateClassLoaderCost c:" + (System.currentTimeMillis() - currentTimeMillis));
            }
            return f151657b;
        }
    }
}
