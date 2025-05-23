package com.tencent.mtt.hippy.runtime.builtins;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d extends i {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<Object, Object> f337621a = new HashMap<>();

    public HashMap<Object, Object> a() {
        return this.f337621a;
    }

    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d clone() throws CloneNotSupportedException {
        d dVar = (d) super.clone();
        HashMap<Object, Object> a16 = dVar.a();
        for (Map.Entry<Object, Object> entry : this.f337621a.entrySet()) {
            a16.put(entry.getKey(), i.b(entry.getValue()));
        }
        return dVar;
    }
}
