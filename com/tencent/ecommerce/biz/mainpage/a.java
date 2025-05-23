package com.tencent.ecommerce.biz.mainpage;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R0\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/a;", "", "", "callbackId", "Lcom/tencent/ecommerce/biz/mainpage/IECMainFragmentCallback;", "a", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "callbackMap", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f102955c = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final AtomicInteger callbackId = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, IECMainFragmentCallback> callbackMap = new HashMap<>();

    a() {
    }

    public final IECMainFragmentCallback a(String callbackId2) {
        return callbackMap.get(callbackId2);
    }
}
