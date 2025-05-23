package com.tencent.luggage.wxa.z8;

import androidx.lifecycle.LifecycleObserver;
import com.tencent.luggage.wxa.tn.w;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a extends com.tencent.luggage.wxa.un.a {

    /* renamed from: e, reason: collision with root package name */
    public static final C6976a f146382e = new C6976a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.z8.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6976a {
        public C6976a() {
        }

        public /* synthetic */ C6976a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a() {
        super(b.f146383a);
    }

    @Override // com.tencent.luggage.wxa.un.a, androidx.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver observer) {
        Integer num;
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.addObserver(observer);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("addObserver totalCount:");
        ConcurrentHashMap a16 = a();
        if (a16 != null) {
            num = Integer.valueOf(a16.size());
        } else {
            num = null;
        }
        sb5.append(num);
        sb5.append(" observer:");
        sb5.append(observer);
        w.d("MicroMsg.Mvvm.ApplicationLifecycleRegistry", sb5.toString());
    }

    @Override // com.tencent.luggage.wxa.un.a, androidx.lifecycle.Lifecycle
    public void removeObserver(LifecycleObserver observer) {
        Integer num;
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.removeObserver(observer);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("removeObserver totalCount:");
        ConcurrentHashMap a16 = a();
        if (a16 != null) {
            num = Integer.valueOf(a16.size());
        } else {
            num = null;
        }
        sb5.append(num);
        sb5.append(" observer:");
        sb5.append(observer);
        w.d("MicroMsg.Mvvm.ApplicationLifecycleRegistry", sb5.toString());
    }
}
