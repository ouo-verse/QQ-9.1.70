package com.qzone.video.TVK_SDK.mediaplayer.utils;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace(";(", "  ").replace(")", "");
    }
}
