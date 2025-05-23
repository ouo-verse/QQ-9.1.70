package com.tencent.qmethod.pandoraex.core;

import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f344151a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f344152b = new Object();

    public static String[] a() {
        String[] strArr;
        synchronized (f344152b) {
            List<String> list = f344151a;
            if (list.size() > 0) {
                strArr = (String[]) list.toArray(new String[0]);
            } else {
                strArr = null;
            }
        }
        return strArr;
    }
}
