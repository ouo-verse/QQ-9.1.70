package com.sina.weibo.sdk.net;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class HttpManager {
    static {
        System.loadLibrary("weibosdkcore");
    }

    public static String a(Context context, String str, String str2, String str3, String str4) {
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb5.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb5.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb5.append(str3);
        }
        return calcOauthSignNative(context, sb5.toString(), str4);
    }

    private static native String calcOauthSignNative(Context context, String str, String str2);
}
