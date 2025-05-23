package com.tencent.luggage.wxa.n3;

import android.text.TextUtils;
import java.io.File;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class m0 {

    /* renamed from: a, reason: collision with root package name */
    public static String f135220a = "__MAGIC_MD5_SKIP_CHECK__";

    static {
        com.tencent.luggage.wxa.y7.a.a();
    }

    public static String a(String str, String str2, int i3, String str3, int i16) {
        if (!TextUtils.isEmpty(str2)) {
            str2 = URLEncoder.encode(str2);
        }
        return new File(b(), str + "_" + str2 + "_" + i3 + "_" + str3 + "_" + i16).getAbsolutePath();
    }

    public static String b() {
        return a();
    }

    public static String a() {
        File file = new File(com.tencent.luggage.wxa.tn.z.c().getFilesDir(), "wxapkg");
        file.mkdirs();
        return file.getAbsolutePath();
    }
}
