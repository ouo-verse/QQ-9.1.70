package com.tencent.mtt.hippy.runtime.builtins;

import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class h extends i {

    /* renamed from: a, reason: collision with root package name */
    private final HashSet<Object> f337635a = new HashSet<>();

    public HashSet<Object> a() {
        return this.f337635a;
    }

    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h clone() throws CloneNotSupportedException {
        h hVar = (h) super.clone();
        HashSet<Object> a16 = hVar.a();
        Iterator<Object> it = this.f337635a.iterator();
        while (it.hasNext()) {
            a16.add(i.b(it.next()));
        }
        return hVar;
    }
}
