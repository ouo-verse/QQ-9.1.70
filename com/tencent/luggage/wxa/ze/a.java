package com.tencent.luggage.wxa.ze;

import com.tencent.luggage.wxa.k0.d;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C6981a f146560a = new C6981a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final ReentrantLock f146561b = new ReentrantLock();

    /* renamed from: c, reason: collision with root package name */
    public static final Map f146562c = new LinkedHashMap();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ze.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6981a {
        public C6981a() {
        }

        public /* synthetic */ C6981a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(String appId) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            ReentrantLock reentrantLock = a.f146561b;
            reentrantLock.lock();
            try {
                d.a(a.f146562c.remove(appId));
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
