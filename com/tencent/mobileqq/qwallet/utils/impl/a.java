package com.tencent.mobileqq.qwallet.utils.impl;

import android.net.Uri;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    public static String a(String str, String str2, String str3) {
        if (str.indexOf(str2) == -1) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter(str2, str3);
            return buildUpon.build().toString();
        }
        return str;
    }
}
