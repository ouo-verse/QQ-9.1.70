package com.tencent.open.agent.auth.model;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/open/agent/auth/model/a;", "", "", "appId", "", "beginTime", "delayTime", "", "b", "a", "", "Lcom/tencent/open/agent/auth/model/a$a;", "Ljava/util/Map;", "appLoginLimitInfoList", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f340155a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, C9265a> appLoginLimitInfoList = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005\u00a8\u0006\f"}, d2 = {"Lcom/tencent/open/agent/auth/model/a$a;", "", "", "a", "J", "()J", "beginTime", "b", "delayTime", "<init>", "(JJ)V", "c", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.open.agent.auth.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C9265a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long beginTime;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long delayTime;

        public C9265a(long j3, long j16) {
            long coerceAtMost;
            this.beginTime = j3;
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(j16, 10000L);
            this.delayTime = coerceAtMost;
        }

        /* renamed from: a, reason: from getter */
        public final long getBeginTime() {
            return this.beginTime;
        }

        /* renamed from: b, reason: from getter */
        public final long getDelayTime() {
            return this.delayTime;
        }
    }

    a() {
    }

    @JvmStatic
    public static final long a(@Nullable String appId) {
        C9265a c9265a;
        long coerceAtLeast;
        if (appId == null || (c9265a = appLoginLimitInfoList.get(appId)) == null) {
            return 0L;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((c9265a.getBeginTime() + c9265a.getDelayTime()) - System.currentTimeMillis(), 0L);
        return coerceAtLeast;
    }

    @JvmStatic
    public static final void b(@Nullable String appId, long beginTime, long delayTime) {
        if (appId == null) {
            return;
        }
        appLoginLimitInfoList.put(appId, new C9265a(beginTime, delayTime));
    }
}
