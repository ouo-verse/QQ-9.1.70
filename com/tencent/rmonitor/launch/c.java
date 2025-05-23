package com.tencent.rmonitor.launch;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes25.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<String> f365636a = new CopyOnWriteArrayList<>();

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && !this.f365636a.contains(str)) {
            this.f365636a.add(str);
        }
    }

    public void b() {
        this.f365636a.clear();
    }

    public List<String> c() {
        return new ArrayList(this.f365636a);
    }
}
