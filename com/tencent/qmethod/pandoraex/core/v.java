package com.tencent.qmethod.pandoraex.core;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Long> f344166a = new ConcurrentHashMap<>();

    public static synchronized void a(String str, Long l3) {
        synchronized (v.class) {
            if (!TextUtils.isEmpty(str) && l3 != null) {
                f344166a.put(str, l3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized String b(long j3) {
        synchronized (v.class) {
            StringBuilder sb5 = null;
            int i3 = 0;
            for (String str : f344166a.keySet()) {
                if (j3 >= f344166a.get(str).longValue()) {
                    if (sb5 == null) {
                        sb5 = new StringBuilder();
                    }
                    if (i3 == 0) {
                        sb5.append(str);
                    } else {
                        sb5.append("|");
                        sb5.append(str);
                    }
                    i3++;
                }
            }
            if (sb5 == null) {
                return "";
            }
            return sb5.toString();
        }
    }
}
