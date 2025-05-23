package com.tencent.mobileqq.winkpublish.outbox.slot;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/slot/c;", "", "", "businessType", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/b;", "a", "", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/BusinessQueueSlotManager;", "b", "Ljava/util/Map;", "realQueueSlotManagerMap", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f327281a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<Integer, BusinessQueueSlotManager> realQueueSlotManagerMap = new LinkedHashMap();

    c() {
    }

    public final b a(int businessType) {
        Map<Integer, BusinessQueueSlotManager> map = realQueueSlotManagerMap;
        Integer valueOf = Integer.valueOf(businessType);
        BusinessQueueSlotManager businessQueueSlotManager = map.get(valueOf);
        if (businessQueueSlotManager == null) {
            businessQueueSlotManager = new BusinessQueueSlotManager();
            map.put(valueOf, businessQueueSlotManager);
        }
        return businessQueueSlotManager;
    }
}
