package com.tencent.mobileqq.msgbackup.util;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0001\u00a8\u0006\u0006"}, d2 = {"T", "K", "", "initialCapacity", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "msgbackup_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {
    @JvmOverloads
    @NotNull
    public static final <T, K> ConcurrentHashMap<T, K> a() {
        return c(0, 1, null);
    }

    @JvmOverloads
    @NotNull
    public static final <T, K> ConcurrentHashMap<T, K> b(int i3) {
        return new ConcurrentHashMap<>(i3);
    }

    public static /* synthetic */ ConcurrentHashMap c(int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 10000;
        }
        return b(i3);
    }
}
