package com.tencent.robot.discoveryv2.common.repository.proxy;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotBaseInfo;
import com.tencent.robot.discoveryv2.common.data.RecommendRobotsData;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryDetailData;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryNextPageData;
import com.tencent.robot.discoveryv2.common.repository.core.RepositoryParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s34.a;
import s34.b;
import tl.h;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b+\u0010,J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u0002J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u001f\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR2\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0 j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e`!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R,\u0010)\u001a\u001a\u0012\u0004\u0012\u00020&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00060'0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010(R,\u0010*\u001a\u001a\u0012\u0004\u0012\u00020&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060'0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/repository/proxy/RecommendRobotsDataProxy;", "", "", "robotUin", "", "isAdd", "", h.F, "Lcom/tencent/robot/discoveryv2/common/repository/core/c;", "repositoryParams", "k", "l", "d", "categoryId", "Lcom/tencent/robot/discoveryv2/common/data/e;", "singleCategoryDetailData", "o", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotBaseInfo;", "e", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/robot/discoveryv2/common/data/d;", "c", "Lcom/tencent/robot/discoveryv2/common/data/i;", "g", "j", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "a", "Lcom/tencent/robot/discoveryv2/common/repository/core/c;", "mRepositoryParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "mCategoryDetailDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Function1;", "Ljava/util/concurrent/ConcurrentHashMap;", "mRecommendRobotsDataChangedListener", "mHaveNextPageDataChangedListener", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RecommendRobotsDataProxy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private RepositoryParams mRepositoryParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, SingleCategoryDetailData> mCategoryDetailDataMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, Function1<RecommendRobotsData, Unit>> mRecommendRobotsDataChangedListener = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, Function1<SingleCategoryNextPageData, Unit>> mHaveNextPageDataChangedListener = new ConcurrentHashMap<>();

    private final void h(String robotUin, boolean isAdd) {
        boolean z16;
        QLog.i("RecommendRobotsDataProxy", 1, "modifyRobotAddedStatus robotUin = " + robotUin + " isAdd = " + isAdd);
        for (Map.Entry<String, SingleCategoryDetailData> entry : this.mCategoryDetailDataMap.entrySet()) {
            if (!entry.getValue().d().contains(robotUin)) {
                QLog.i("RecommendRobotsDataProxy", 1, "modifyRobotAddedStatus robotUin = " + robotUin + " isAdd = " + isAdd + " continue");
            } else {
                Iterator<b> it = entry.getValue().c().iterator();
                boolean z17 = false;
                int i3 = 0;
                while (true) {
                    if (it.hasNext()) {
                        if (Intrinsics.areEqual(it.next().k(), robotUin) && (!r12.getIsAdded()) == isAdd) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                Integer valueOf = Integer.valueOf(i3);
                if (valueOf.intValue() != -1) {
                    z17 = true;
                }
                b bVar = null;
                if (!z17) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    int intValue = valueOf.intValue();
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(entry.getValue().c());
                    a d16 = ((b) arrayList.get(intValue)).d();
                    if (d16 instanceof b) {
                        bVar = (b) d16;
                    }
                    if (bVar != null) {
                        bVar.n(isAdd);
                        arrayList.set(intValue, bVar);
                    }
                    SingleCategoryDetailData singleCategoryDetailData = new SingleCategoryDetailData(entry.getValue().getCategoryId(), entry.getValue().getSvrCookie(), entry.getValue().getSvrDataVersion(), entry.getValue().getHaveNextPage(), arrayList, entry.getValue().d());
                    QLog.i("RecommendRobotsDataProxy", 1, "modifyRobotAddedStatus robotUin = " + robotUin + " isAdd = " + isAdd + " notifyRecommendRobotsDataChanged");
                    o(entry.getKey(), singleCategoryDetailData);
                    j(entry.getKey());
                }
            }
        }
    }

    @NotNull
    public final Flow<RecommendRobotsData> c() {
        return FlowKt.callbackFlow(new RecommendRobotsDataProxy$categoryRobotsDataChangedNotificationFlow$1(this, null));
    }

    public final void d() {
        this.mCategoryDetailDataMap.clear();
    }

    @Nullable
    public final GroupRobotBaseInfo e(@NotNull String robotUin) {
        boolean z16;
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Iterator<Map.Entry<String, SingleCategoryDetailData>> it = this.mCategoryDetailDataMap.entrySet().iterator();
        while (true) {
            Object obj = null;
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<String, SingleCategoryDetailData> next = it.next();
            if (next.getValue().d().contains(robotUin)) {
                Iterator<T> it5 = next.getValue().c().iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next2 = it5.next();
                    b bVar = (b) next2;
                    if (Intrinsics.areEqual(bVar.k(), robotUin) && !bVar.getIsAdded()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        obj = next2;
                        break;
                    }
                }
                b bVar2 = (b) obj;
                if (bVar2 != null) {
                    GroupRobotBaseInfo groupRobotBaseInfo = new GroupRobotBaseInfo();
                    groupRobotBaseInfo.robotUin = Util.toLongOrDefault(bVar2.k(), 0L);
                    groupRobotBaseInfo.robotName = bVar2.getRobotName();
                    groupRobotBaseInfo.robotAvatar = bVar2.getRobotAvatar();
                    groupRobotBaseInfo.robotDesc = bVar2.getRobotDesc();
                    return groupRobotBaseInfo;
                }
            }
        }
    }

    @Nullable
    public final SingleCategoryDetailData f(@NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        return this.mCategoryDetailDataMap.get(categoryId);
    }

    @NotNull
    public final Flow<SingleCategoryNextPageData> g() {
        return FlowKt.callbackFlow(new RecommendRobotsDataProxy$haveNextPageDataChangedNotificationFlow$1(this, null));
    }

    public final void i(@NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        SingleCategoryDetailData singleCategoryDetailData = this.mCategoryDetailDataMap.get(categoryId);
        if (singleCategoryDetailData == null) {
            return;
        }
        Iterator<Map.Entry<Integer, Function1<SingleCategoryNextPageData, Unit>>> it = this.mHaveNextPageDataChangedListener.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().invoke(new SingleCategoryNextPageData(categoryId, singleCategoryDetailData.getHaveNextPage()));
        }
    }

    public final void j(@NotNull String categoryId) {
        List<b> emptyList;
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        SingleCategoryDetailData singleCategoryDetailData = this.mCategoryDetailDataMap.get(categoryId);
        if (singleCategoryDetailData == null || (emptyList = singleCategoryDetailData.c()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        RecommendRobotsData recommendRobotsData = new RecommendRobotsData(categoryId, emptyList);
        Iterator<Map.Entry<Integer, Function1<RecommendRobotsData, Unit>>> it = this.mRecommendRobotsDataChangedListener.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().invoke(recommendRobotsData);
        }
    }

    public final void k(@NotNull RepositoryParams repositoryParams) {
        Intrinsics.checkNotNullParameter(repositoryParams, "repositoryParams");
        this.mRepositoryParams = repositoryParams;
    }

    public final void m(@NotNull String robotUin) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        h(robotUin, true);
    }

    public final void n(@NotNull String robotUin) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        h(robotUin, false);
    }

    public final void o(@NotNull String categoryId, @NotNull SingleCategoryDetailData singleCategoryDetailData) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(singleCategoryDetailData, "singleCategoryDetailData");
        this.mCategoryDetailDataMap.put(categoryId, singleCategoryDetailData);
    }

    public final void l() {
    }
}
