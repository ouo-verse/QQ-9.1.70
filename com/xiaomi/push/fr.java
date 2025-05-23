package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fr {
    private static HashMap<String, ArrayList<gj>> a(Context context, List<gj> list) {
        if (list != null && list.size() != 0) {
            HashMap<String, ArrayList<gj>> hashMap = new HashMap<>();
            for (gj gjVar : list) {
                d(context, gjVar);
                ArrayList<gj> arrayList = hashMap.get(gjVar.c());
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    hashMap.put(gjVar.c(), arrayList);
                }
                arrayList.add(gjVar);
            }
            return hashMap;
        }
        return null;
    }

    private static void b(Context context, ft ftVar, HashMap<String, ArrayList<gj>> hashMap) {
        for (Map.Entry<String, ArrayList<gj>> entry : hashMap.entrySet()) {
            try {
                ArrayList<gj> value = entry.getValue();
                if (value != null && value.size() != 0) {
                    ftVar.a(value, value.get(0).e(), entry.getKey());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void c(Context context, ft ftVar, List<gj> list) {
        HashMap<String, ArrayList<gj>> a16 = a(context, list);
        if (a16 != null && a16.size() != 0) {
            b(context, ftVar, a16);
            return;
        }
        jz4.c.m("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
    }

    private static void d(Context context, gj gjVar) {
        if (gjVar.f24735a) {
            gjVar.a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(gjVar.d())) {
            gjVar.f(com.xiaomi.push.service.af.b());
        }
        gjVar.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(gjVar.e())) {
            gjVar.e(context.getPackageName());
        }
        if (TextUtils.isEmpty(gjVar.c())) {
            gjVar.e(gjVar.e());
        }
    }
}
