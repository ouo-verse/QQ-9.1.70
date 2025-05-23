package com.tencent.qfsmonet.process;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.api.config.MonetConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, MonetConfig> f342564a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26293);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f342564a = new HashMap();
        }
    }

    public static synchronized void a(String str, @NonNull MonetConfig monetConfig) {
        synchronized (b.class) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessConfig", "setMonetConfig, type=" + str);
            if (f342564a.containsKey(str)) {
                g(str, monetConfig);
            } else {
                f342564a.put(str, monetConfig);
            }
        }
    }

    private static boolean b(@NonNull String str, @NonNull String str2) {
        try {
            for (String str3 : str.split(",")) {
                if (str2.equalsIgnoreCase(str3)) {
                    return true;
                }
            }
        } catch (Throwable th5) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessConfig", "inTheListByName, ex=" + th5.toString());
        }
        return false;
    }

    private static boolean c(@NonNull MonetConfig monetConfig) {
        String modelBlackList = monetConfig.getModelBlackList();
        if (!TextUtils.isEmpty(modelBlackList) && b(modelBlackList, com.tencent.qfsmonet.utils.b.b())) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessConfig", "in model black list!");
            return true;
        }
        String manufacturerBlackList = monetConfig.getManufacturerBlackList();
        if (!TextUtils.isEmpty(manufacturerBlackList) && b(manufacturerBlackList, com.tencent.qfsmonet.utils.b.c())) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessConfig", "in manufacturer black list!");
            return true;
        }
        String chipBlackList = monetConfig.getChipBlackList();
        if (!TextUtils.isEmpty(chipBlackList) && b(chipBlackList, com.tencent.qfsmonet.utils.b.a())) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessConfig", "in chip black list!");
            return true;
        }
        return false;
    }

    private static boolean d(@NonNull MonetConfig monetConfig) {
        String modelWhiteList = monetConfig.getModelWhiteList();
        if (!TextUtils.isEmpty(modelWhiteList) && b(modelWhiteList, com.tencent.qfsmonet.utils.b.b())) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessConfig", "in model white list!");
            return true;
        }
        String manufacturerWhiteList = monetConfig.getManufacturerWhiteList();
        if (!TextUtils.isEmpty(manufacturerWhiteList) && b(manufacturerWhiteList, com.tencent.qfsmonet.utils.b.c())) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessConfig", "in manufacturer white list!");
            return true;
        }
        String chipWhiteList = monetConfig.getChipWhiteList();
        if (!TextUtils.isEmpty(chipWhiteList) && b(chipWhiteList, com.tencent.qfsmonet.utils.b.a())) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessConfig", "in chip white list!");
            return true;
        }
        return false;
    }

    public static boolean e() {
        MonetConfig monetConfig = f342564a.get(MonetConfig.MonetConfigType.CROP_INFO_CONFIG);
        if (monetConfig != null && !f(monetConfig)) {
            return false;
        }
        return true;
    }

    private static boolean f(@NonNull MonetConfig monetConfig) {
        try {
        } catch (Throwable th5) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessConfig", "isInBlacklistForCrop:" + th5.toString());
        }
        if (!monetConfig.getConfigEnable()) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessConfig", "enable is false!");
            return false;
        }
        if (d(monetConfig)) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessConfig", "in white list!");
            return true;
        }
        if (monetConfig.getSupportApiVersion() > Build.VERSION.SDK_INT) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessConfig", "api level not support!");
            return false;
        }
        if (c(monetConfig)) {
            com.tencent.qfsmonet.utils.a.c("MonetProcessConfig", "in black list!");
            return false;
        }
        return true;
    }

    private static void g(String str, @NonNull MonetConfig monetConfig) {
        int supportApiVersion;
        String chipBlackList;
        String chipWhiteList;
        String modelBlackList;
        String modelWhiteList;
        String manufacturerWhiteList;
        String manufacturerBlackList;
        MonetConfig monetConfig2 = f342564a.get(str);
        MonetConfig.Builder builder = new MonetConfig.Builder();
        if (monetConfig.getSupportApiVersion() > 0) {
            supportApiVersion = monetConfig.getSupportApiVersion();
        } else {
            supportApiVersion = monetConfig2.getSupportApiVersion();
        }
        builder.setSupportApiVersion(supportApiVersion);
        if (monetConfig.getChipBlackList() == null) {
            chipBlackList = monetConfig.getChipBlackList();
        } else {
            chipBlackList = monetConfig2.getChipBlackList();
        }
        builder.setChipBlackList(chipBlackList);
        if (monetConfig.getChipWhiteList() == null) {
            chipWhiteList = monetConfig.getChipWhiteList();
        } else {
            chipWhiteList = monetConfig2.getChipWhiteList();
        }
        builder.setChipWhiteList(chipWhiteList);
        if (monetConfig.getModelBlackList() == null) {
            modelBlackList = monetConfig.getModelBlackList();
        } else {
            modelBlackList = monetConfig2.getModelBlackList();
        }
        builder.setModelBlackList(modelBlackList);
        if (monetConfig.getModelWhiteList() == null) {
            modelWhiteList = monetConfig.getModelWhiteList();
        } else {
            modelWhiteList = monetConfig2.getModelWhiteList();
        }
        builder.setModelWhiteList(modelWhiteList);
        if (monetConfig.getManufacturerWhiteList() == null) {
            manufacturerWhiteList = monetConfig.getManufacturerWhiteList();
        } else {
            manufacturerWhiteList = monetConfig2.getManufacturerWhiteList();
        }
        builder.setManufacturerWhiteList(manufacturerWhiteList);
        if (monetConfig.getManufacturerBlackList() == null) {
            manufacturerBlackList = monetConfig.getManufacturerBlackList();
        } else {
            manufacturerBlackList = monetConfig2.getManufacturerBlackList();
        }
        builder.setManufacturerBlackList(manufacturerBlackList);
        if (monetConfig.getConfigEnableAlive()) {
            builder.setConfigEnable(monetConfig.getConfigEnable());
        } else if (monetConfig2.getConfigEnableAlive()) {
            builder.setConfigEnable(monetConfig2.getConfigEnable());
        }
        f342564a.put(str, monetConfig);
    }
}
