package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.persistence.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes18.dex */
public class o {

    /* renamed from: h, reason: collision with root package name */
    static o f285061h;

    /* renamed from: a, reason: collision with root package name */
    ArrayList<Entity> f285062a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f285063b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f285064c = true;

    /* renamed from: d, reason: collision with root package name */
    String f285065d = "0";

    /* renamed from: e, reason: collision with root package name */
    AtomicBoolean f285066e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    boolean f285067f = false;

    /* renamed from: g, reason: collision with root package name */
    HashMap<String, Integer> f285068g = new HashMap<>();

    o() {
        this.f285062a = null;
        this.f285062a = new ArrayList<>(1024);
    }

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            if (f285061h == null) {
                f285061h = new o();
            }
            oVar = f285061h;
        }
        return oVar;
    }

    public boolean b(String str) {
        if (str == null) {
            return false;
        }
        if (this.f285068g == null) {
            this.f285068g = new HashMap<>();
        }
        return this.f285068g.containsKey(str);
    }

    public void c() {
        this.f285062a.clear();
    }
}
