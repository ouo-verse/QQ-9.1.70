package com.tencent.mobileqq.vasgift.utils;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0005R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\tR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vasgift/utils/e;", "", "", "giftId", "b", "", "c", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "curWaitReqNum", "", "recodeTime", "<init>", "()V", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f312015a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, Integer> curWaitReqNum = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, Long> recodeTime = new ConcurrentHashMap<>();

    e() {
    }

    public final void a() {
        curWaitReqNum.clear();
    }

    public final int b(int giftId) {
        ConcurrentHashMap<Integer, Long> concurrentHashMap = recodeTime;
        Long l3 = concurrentHashMap.get(Integer.valueOf(giftId));
        long currentTimeMillis = System.currentTimeMillis();
        concurrentHashMap.put(Integer.valueOf(giftId), Long.valueOf(currentTimeMillis));
        if (l3 != null && l3.longValue() > 0 && currentTimeMillis - l3.longValue() > 3000) {
            curWaitReqNum.put(Integer.valueOf(giftId), 0);
            return 0;
        }
        Integer num = curWaitReqNum.get(Integer.valueOf(giftId));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void c(int giftId) {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = curWaitReqNum;
        Integer num = concurrentHashMap.get(Integer.valueOf(giftId));
        if (num == null) {
            num = 0;
        }
        concurrentHashMap.put(Integer.valueOf(giftId), Integer.valueOf(num.intValue() + 1));
    }
}
