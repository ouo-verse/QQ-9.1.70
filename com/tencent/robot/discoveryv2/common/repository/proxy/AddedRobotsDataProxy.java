package com.tencent.robot.discoveryv2.common.repository.proxy;

import com.tencent.qqnt.kernel.nativeinterface.GroupRobotBaseInfo;
import com.tencent.robot.discoveryv2.common.repository.core.RepositoryParams;
import com.tencent.robot.discoveryv2.troop.added.AddedRobotsData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u001c\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0013J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0006\u0010\u0019\u001a\u00020\bR\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001dR,\u0010\"\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b0 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/repository/proxy/AddedRobotsDataProxy;", "", "", "robotUinL", "", "c", "Lcom/tencent/robot/discoveryv2/common/repository/core/c;", "repositoryParams", "", "e", "f", "", "robotUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotBaseInfo;", "baseInfo", "g", h.F, "", "maxRobotCount", "", "addedRobotList", "i", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/robot/discoveryv2/troop/added/a;", "b", "d", "a", "Lcom/tencent/robot/discoveryv2/common/repository/core/c;", "mRepositoryParams", "Lcom/tencent/robot/discoveryv2/troop/added/a;", "mAddedRobotsData", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Function1;", "Ljava/util/concurrent/ConcurrentHashMap;", "mAddedRobotsDataChangedListener", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AddedRobotsDataProxy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private RepositoryParams mRepositoryParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AddedRobotsData mAddedRobotsData = new AddedRobotsData(0, null, 3, null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, Function1<AddedRobotsData, Unit>> mAddedRobotsDataChangedListener = new ConcurrentHashMap<>();

    private final boolean c(long robotUinL) {
        Object obj;
        boolean z16;
        Iterator<T> it = this.mAddedRobotsData.a().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((GroupRobotBaseInfo) obj).robotUin == robotUinL) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Flow<AddedRobotsData> b() {
        return FlowKt.callbackFlow(new AddedRobotsDataProxy$addedRobotsDataChangedNotificationFlow$1(this, null));
    }

    public final void d() {
        Iterator<Map.Entry<Integer, Function1<AddedRobotsData, Unit>>> it = this.mAddedRobotsDataChangedListener.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().invoke(this.mAddedRobotsData);
        }
    }

    public final void e(@NotNull RepositoryParams repositoryParams) {
        Intrinsics.checkNotNullParameter(repositoryParams, "repositoryParams");
        this.mRepositoryParams = repositoryParams;
    }

    public final void g(@NotNull String robotUin, @NotNull GroupRobotBaseInfo baseInfo) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(baseInfo, "baseInfo");
        if (c(Util.toLongOrDefault(robotUin, 0L))) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(baseInfo);
        arrayList.addAll(this.mAddedRobotsData.a());
        i(this.mAddedRobotsData.getMaxRobotCount(), arrayList);
        d();
    }

    public final void h(@NotNull String robotUin) {
        boolean z16;
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        long longOrDefault = Util.toLongOrDefault(robotUin, 0L);
        if (!c(longOrDefault)) {
            return;
        }
        List<GroupRobotBaseInfo> a16 = this.mAddedRobotsData.a();
        ArrayList arrayList = new ArrayList();
        for (Object obj : a16) {
            if (((GroupRobotBaseInfo) obj).robotUin != longOrDefault) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        i(this.mAddedRobotsData.getMaxRobotCount(), arrayList);
        d();
    }

    public final void i(int maxRobotCount, @NotNull List<GroupRobotBaseInfo> addedRobotList) {
        Intrinsics.checkNotNullParameter(addedRobotList, "addedRobotList");
        this.mAddedRobotsData = new AddedRobotsData(maxRobotCount, addedRobotList);
    }

    public final void f() {
    }
}
