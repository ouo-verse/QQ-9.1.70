package com.tencent.could.component.common.ai.eventreport.utils;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {
    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + "?FaceIdToken=" + str2;
    }
}
