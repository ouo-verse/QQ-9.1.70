package com.tencent.robot.discoveryv2.common.repository.proxy;

import com.tencent.robot.discoveryv2.common.data.LoadState;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryLoadData;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryLoadType;
import com.tencent.robot.discoveryv2.common.data.c;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fR \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R,\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u00160\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/repository/proxy/SingleCategoryLoadStateProxy;", "", "", "categoryId", "", "c", "Lcom/tencent/robot/discoveryv2/common/data/g;", "b", "Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "loadState", "Lcom/tencent/robot/discoveryv2/common/data/SingleCategoryLoadType;", "loadType", "", "f", "d", "Lkotlinx/coroutines/flow/Flow;", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "mSingleCategoryLoadDataMap", "", "Lkotlin/Function1;", "mSingleCategoryLoadDataListener", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SingleCategoryLoadStateProxy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, SingleCategoryLoadData> mSingleCategoryLoadDataMap = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, Function1<SingleCategoryLoadData, Unit>> mSingleCategoryLoadDataListener = new ConcurrentHashMap<>();

    @NotNull
    public final SingleCategoryLoadData b(@NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        SingleCategoryLoadData singleCategoryLoadData = this.mSingleCategoryLoadDataMap.get(categoryId);
        if (singleCategoryLoadData == null) {
            return new SingleCategoryLoadData(categoryId, LoadState.NONE, SingleCategoryLoadType.NONE);
        }
        return singleCategoryLoadData;
    }

    public final boolean c(@NotNull String categoryId) {
        LoadState loadState;
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        SingleCategoryLoadData singleCategoryLoadData = this.mSingleCategoryLoadDataMap.get(categoryId);
        if (singleCategoryLoadData == null || (loadState = singleCategoryLoadData.getLoadState()) == null || !c.b(loadState)) {
            return false;
        }
        return true;
    }

    public final void d(@NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        SingleCategoryLoadData singleCategoryLoadData = this.mSingleCategoryLoadDataMap.get(categoryId);
        if (singleCategoryLoadData == null) {
            return;
        }
        Iterator<Map.Entry<Integer, Function1<SingleCategoryLoadData, Unit>>> it = this.mSingleCategoryLoadDataListener.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().invoke(singleCategoryLoadData);
        }
    }

    @NotNull
    public final Flow<SingleCategoryLoadData> e() {
        return FlowKt.callbackFlow(new SingleCategoryLoadStateProxy$singleCategoryLoadStateNotificationFlow$1(this, null));
    }

    public final void f(@NotNull String categoryId, @NotNull LoadState loadState, @NotNull SingleCategoryLoadType loadType) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        this.mSingleCategoryLoadDataMap.put(categoryId, new SingleCategoryLoadData(categoryId, loadState, loadType));
    }
}
