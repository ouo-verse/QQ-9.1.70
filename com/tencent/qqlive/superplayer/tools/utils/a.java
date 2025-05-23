package com.tencent.qqlive.superplayer.tools.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<String> f345476a;

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, String> f345477b;

    static {
        HashMap hashMap = new HashMap();
        f345477b = hashMap;
        hashMap.put("fhd", "\u84dd\u5149  1080P");
        f345477b.put("hd", "\u9ad8\u6e05  360P");
        f345477b.put("msd", "\u6d41\u7545 180P");
        f345477b.put("sd", "\u6807\u6e05  270P");
        f345477b.put("mp4", "\u9ad8\u6e05  360P");
        f345477b.put("shd", "\u8d85\u6e05  720P");
        ArrayList<String> arrayList = new ArrayList<>();
        f345476a = arrayList;
        arrayList.add("msd");
        f345476a.add("hd");
        f345476a.add("mp4");
        f345476a.add("sd");
        f345476a.add("fhd");
        f345476a.add("shd");
    }

    public static String a(String str) {
        String str2 = f345477b.get(str);
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        return str2;
    }
}
