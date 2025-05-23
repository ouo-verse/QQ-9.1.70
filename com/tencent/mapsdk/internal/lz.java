package com.tencent.mapsdk.internal;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class lz {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f149292a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private List<String> f149293b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final int f149294c = 300;

    public final synchronized boolean a(String str) {
        if (str != null) {
            if (str.trim().length() != 0) {
                return !this.f149293b.contains(str);
            }
        }
        return false;
    }

    public final synchronized void b(String str) {
        if (str != null) {
            if (str.trim().length() != 0) {
                if (this.f149293b.contains(str)) {
                    this.f149293b.remove(str);
                    this.f149293b.add(str);
                } else if (this.f149292a.contains(str)) {
                    a(this.f149293b);
                    this.f149293b.add(str);
                    this.f149292a.remove(str);
                } else {
                    a(this.f149292a);
                    this.f149292a.add(str);
                }
            }
        }
    }

    private static void a(List<String> list) {
        if (list != null && list.size() > 300) {
            list.remove(0);
        }
    }

    private synchronized void a() {
        this.f149292a.clear();
        this.f149293b.clear();
    }
}
