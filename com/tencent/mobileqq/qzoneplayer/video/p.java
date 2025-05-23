package com.tencent.mobileqq.qzoneplayer.video;

import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, com.tencent.mobileqq.qzoneplayer.videosource.e> f280018a = new ConcurrentHashMap();

    public static List<String> a(String str) {
        com.tencent.mobileqq.qzoneplayer.videosource.e eVar;
        if (TextUtils.isEmpty(str) || !f280018a.containsKey(str) || (eVar = f280018a.get(str)) == null) {
            return null;
        }
        return eVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        String lastPathSegment = parse.getLastPathSegment();
        long currentTimeMillis = System.currentTimeMillis();
        for (String str2 : strArr) {
            if (host != null && !str2.contains(host)) {
                arrayList.add(str2);
            }
        }
        if (TextUtils.isEmpty(lastPathSegment)) {
            return;
        }
        com.tencent.mobileqq.qzoneplayer.videosource.e eVar = new com.tencent.mobileqq.qzoneplayer.videosource.e(lastPathSegment, currentTimeMillis, arrayList);
        Map<String, com.tencent.mobileqq.qzoneplayer.videosource.e> map = f280018a;
        if (map != null) {
            if (map.containsKey(lastPathSegment)) {
                f280018a.remove(lastPathSegment);
            }
            f280018a.put(lastPathSegment, eVar);
            for (Map.Entry<String, com.tencent.mobileqq.qzoneplayer.videosource.e> entry : f280018a.entrySet()) {
                if (entry.getValue().b() - currentTimeMillis > 1500000) {
                    f280018a.remove(entry.getKey());
                }
            }
        }
    }
}
