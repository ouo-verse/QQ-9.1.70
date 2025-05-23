package com.qq.e.comm.util;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;

/* loaded from: classes3.dex */
public class ProductConfigUtil {
    private static volatile Class productConfig;

    private static Object getProductCustomConfig(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (productConfig == null) {
                try {
                    if (GDTADManager.getInstance().getPM() == null || GDTADManager.getInstance().getPM().getClass().getClassLoader() == null) {
                        return null;
                    }
                    productConfig = GDTADManager.getInstance().getPM().getClass().getClassLoader().loadClass("com.qq.e.adnet.ProductConfig");
                } catch (ClassNotFoundException unused) {
                    return null;
                }
            }
            try {
                return productConfig.getDeclaredField(str).get(productConfig);
            } catch (IllegalAccessException | NoSuchFieldException unused2) {
            }
        }
        return null;
    }

    public static boolean isControlServerHostOn() {
        Object productCustomConfig = getProductCustomConfig("testControlServerOn");
        if (productCustomConfig instanceof Boolean) {
            return ((Boolean) productCustomConfig).booleanValue();
        }
        return false;
    }
}
