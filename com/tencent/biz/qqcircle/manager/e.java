package com.tencent.biz.qqcircle.manager;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    public static final String f91556c = "e";

    /* renamed from: d, reason: collision with root package name */
    private static volatile e f91557d;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, Boolean> f91558a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private List<SoftReference<Object>> f91559b = new LinkedList();

    public static e b() {
        if (f91557d == null) {
            synchronized (e.class) {
                if (f91557d == null) {
                    f91557d = new e();
                }
            }
        }
        return f91557d;
    }

    public void a() {
        if (this.f91558a != null) {
            QLog.i(f91556c, 1, "clear all");
            this.f91558a.clear();
        }
    }

    public void c(String str, boolean z16) {
        ConcurrentHashMap<String, Boolean> concurrentHashMap = this.f91558a;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str, Boolean.valueOf(z16));
        }
    }
}
