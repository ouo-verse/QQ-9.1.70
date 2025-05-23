package com.tencent.open.agent.util;

import android.view.View;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/open/agent/util/r;", "", "Landroid/view/View;", "view", "", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "clickTimeMap", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f340618a = new r();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, Long> clickTimeMap = new ConcurrentHashMap<>();

    r() {
    }

    @JvmStatic
    public static final boolean a(@Nullable View view) {
        if (view == null) {
            return false;
        }
        int hashCode = view.hashCode();
        long currentTimeMillis = System.currentTimeMillis();
        ConcurrentHashMap<Integer, Long> concurrentHashMap = clickTimeMap;
        Long l3 = concurrentHashMap.get(Integer.valueOf(hashCode));
        if (l3 == null) {
            l3 = 0L;
        }
        long longValue = l3.longValue();
        concurrentHashMap.put(Integer.valueOf(hashCode), Long.valueOf(currentTimeMillis));
        if (longValue <= 0) {
            return false;
        }
        long j3 = currentTimeMillis - longValue;
        if (j3 > 500) {
            return false;
        }
        t.b("QuickClickFilter", "quickClick duration: " + j3);
        return true;
    }
}
