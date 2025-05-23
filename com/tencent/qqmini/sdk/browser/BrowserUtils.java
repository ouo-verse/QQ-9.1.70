package com.tencent.qqmini.sdk.browser;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BrowserUtils {
    public static String getSchemeFromUrl(String str) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf(":")) > 0) {
            return str.substring(0, indexOf).toLowerCase();
        }
        return "";
    }
}
