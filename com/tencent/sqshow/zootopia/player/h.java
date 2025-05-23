package com.tencent.sqshow.zootopia.player;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\nR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\nR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/h;", "", "Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/player/c;", "c", "b", "", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "playerPool", "bannerPlayerPool", "", "Lcom/tencent/sqshow/zootopia/player/q;", "d", "videoFeedsPlayerMap", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f372229a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Context, c> playerPool = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Context, c> bannerPlayerPool = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, q> videoFeedsPlayerMap = new ConcurrentHashMap<>();

    h() {
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConcurrentHashMap<Context, c> concurrentHashMap = playerPool;
        c cVar = concurrentHashMap.get(context);
        if (cVar != null) {
            cVar.destroy();
        }
        concurrentHashMap.remove(context);
        ConcurrentHashMap<Context, c> concurrentHashMap2 = bannerPlayerPool;
        c cVar2 = concurrentHashMap2.get(context);
        if (cVar2 != null) {
            cVar2.destroy();
        }
        concurrentHashMap2.remove(context);
    }

    public final c b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConcurrentHashMap<Context, c> concurrentHashMap = bannerPlayerPool;
        if (concurrentHashMap.containsKey(context)) {
            return concurrentHashMap.get(context);
        }
        q qVar = new q();
        concurrentHashMap.put(context, qVar);
        return qVar;
    }

    public final c c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConcurrentHashMap<Context, c> concurrentHashMap = playerPool;
        if (concurrentHashMap.containsKey(context)) {
            return concurrentHashMap.get(context);
        }
        q qVar = new q();
        concurrentHashMap.put(context, qVar);
        return qVar;
    }
}
