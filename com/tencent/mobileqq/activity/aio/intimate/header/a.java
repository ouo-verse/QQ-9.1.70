package com.tencent.mobileqq.activity.aio.intimate.header;

import android.util.LruCache;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J0\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0007J\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0015R0\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0017j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0019R3\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/header/a;", "", "", "uin", "", "type", "e", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/aio/intimate/header/g;", "Lkotlin/collections/ArrayList;", IQQGameCommApi.K_ABTEST_MODELS, "g", "Lf61/h;", "stateInfo", "", "a", "c", "", "f", "b", "Landroid/util/LruCache;", "Landroid/util/LruCache;", "intimateMutualMarkListCache", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "intimateHeaderCardSelectType", "d", "()Landroid/util/LruCache;", "modelCache", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f179009a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<String, f61.h> intimateMutualMarkListCache = new LruCache<>(10);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Long> intimateHeaderCardSelectType = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<String, ArrayList<g>> modelCache = new LruCache<>(10);

    a() {
    }

    @JvmStatic
    public static final int e(@NotNull String uin, int type) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ArrayList<g> arrayList = modelCache.get(uin);
        if (arrayList != null && !arrayList.isEmpty()) {
            for (g gVar : arrayList) {
                if (gVar.getType() == type) {
                    return gVar.getRealDays();
                }
            }
        }
        return 0;
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<g> g(@NotNull ArrayList<g> models) {
        Intrinsics.checkNotNullParameter(models, "models");
        ArrayList<g> arrayList = new ArrayList<>();
        for (g gVar : models) {
            arrayList.add(new g(gVar.getType(), gVar.getLevel(), gVar.getRealDays(), gVar.getRealDays(), gVar.getLightUpTime(), gVar.getScores(), gVar.getFlag(), gVar.getExtendName()));
        }
        return arrayList;
    }

    public final void a(@NotNull String uin, @NotNull f61.h stateInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(stateInfo, "stateInfo");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        intimateMutualMarkListCache.put(peekAppRuntime.getCurrentUin() + "_" + uin, stateInfo);
    }

    public final long b(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return -1L;
        }
        Long l3 = intimateHeaderCardSelectType.get(peekAppRuntime.getCurrentUin() + "_" + uin);
        if (l3 == null) {
            return -1L;
        }
        return l3.longValue();
    }

    @Nullable
    public final f61.h c(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return intimateMutualMarkListCache.get(peekAppRuntime.getCurrentUin() + "_" + uin);
    }

    @NotNull
    public final LruCache<String, ArrayList<g>> d() {
        return modelCache;
    }

    public final void f(@NotNull String uin, long type) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        Long valueOf = Long.valueOf(type);
        intimateHeaderCardSelectType.put(peekAppRuntime.getCurrentUin() + "_" + uin, valueOf);
    }
}
