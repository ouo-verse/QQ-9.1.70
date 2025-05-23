package com.tencent.qqmini.sdk.browser;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes23.dex */
public class BrowserPluginFactory {
    public static final HashMap<String, Integer> S_PLUGIN_NAME_SPACE_HASH_MAP;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        S_PLUGIN_NAME_SPACE_HASH_MAP = hashMap;
        hashMap.put("miniApp", 1);
    }

    public static BrowserPlugin createWebViewPlugin(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, Integer> hashMap = S_PLUGIN_NAME_SPACE_HASH_MAP;
        if (hashMap.containsKey(str)) {
            return createWebViewPlugin(hashMap.get(str).intValue());
        }
        return null;
    }

    public static BrowserPlugin createWebViewPlugin(int i3) {
        if (i3 != 1) {
            return null;
        }
        return new BrowserMiniAppPlugin();
    }
}
