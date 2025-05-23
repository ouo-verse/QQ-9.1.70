package com.tencent.robot.discover.viewmodel;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.CategoryRobot;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobot;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotStoreDiscoveryReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotStoreDiscoveryRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGroupRobotStoreDiscoveryCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRecentUsedRobotsCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentUsedRobotsReq;
import com.tencent.qqnt.kernel.nativeinterface.RecentUsedRobotsRsp;
import com.tencent.qqnt.kernel.nativeinterface.RobotBase;
import com.tencent.robot.discover.data.RobotRecentUsedData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0016\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J)\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0016J\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018R \u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/robot/discover/viewmodel/RobotDiscoveryListViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "Lk34/a;", "R1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "groupId", "", WadlProxyConsts.SCENE_ID, "Q1", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotStoreDiscoveryRsp;", "rsp", "U1", "getLogTag", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "S1", "Landroidx/lifecycle/MutableLiveData;", "T1", "", ViewStickEventHelper.IS_SHOW, "W1", "i", "Landroidx/lifecycle/MutableLiveData;", "mListData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mShowSearchBar", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class RobotDiscoveryListViewModel extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<k34.a>> mListData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mShowSearchBar = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotStoreDiscoveryRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class b implements IGroupRobotStoreDiscoveryCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<List<? extends k34.a>> f367604b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GroupRobotStoreDiscoveryReq f367605c;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super List<? extends k34.a>> continuation, GroupRobotStoreDiscoveryReq groupRobotStoreDiscoveryReq) {
            this.f367604b = continuation;
            this.f367605c = groupRobotStoreDiscoveryReq;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupRobotStoreDiscoveryCallback
        public final void onResult(int i3, String str, GroupRobotStoreDiscoveryRsp groupRobotStoreDiscoveryRsp) {
            List emptyList;
            QLog.d(RobotDiscoveryListViewModel.this.getTAG(), 1, "fetchRobotDiscoverList result:" + i3 + " errMsg:" + str);
            if (i3 == 0 && groupRobotStoreDiscoveryRsp != null) {
                this.f367604b.resumeWith(Result.m476constructorimpl(RobotDiscoveryListViewModel.this.U1(String.valueOf(this.f367605c.groupId), groupRobotStoreDiscoveryRsp, this.f367605c.sceneId)));
            } else {
                Continuation<List<? extends k34.a>> continuation = this.f367604b;
                Result.Companion companion = Result.INSTANCE;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                continuation.resumeWith(Result.m476constructorimpl(emptyList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentUsedRobotsRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class c implements IRecentUsedRobotsCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<List<? extends k34.a>> f367607b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super List<? extends k34.a>> continuation) {
            this.f367607b = continuation;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IRecentUsedRobotsCallback
        public final void onResult(int i3, String str, RecentUsedRobotsRsp recentUsedRobotsRsp) {
            List emptyList;
            List emptyList2;
            boolean z16;
            List listOf;
            QLog.d(RobotDiscoveryListViewModel.this.getTAG(), 1, "fetchRecentUsedRobots result:" + i3 + " errMsg:" + str);
            if (i3 == 0 && recentUsedRobotsRsp != null) {
                if (recentUsedRobotsRsp.total != 0) {
                    ArrayList<GroupRobot> arrayList = recentUsedRobotsRsp.robots;
                    if (arrayList != null && !arrayList.isEmpty()) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        Continuation<List<? extends k34.a>> continuation = this.f367607b;
                        ArrayList<GroupRobot> arrayList2 = recentUsedRobotsRsp.robots;
                        Intrinsics.checkNotNullExpressionValue(arrayList2, "rsp.robots");
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(new RobotRecentUsedData(arrayList2, recentUsedRobotsRsp.total));
                        continuation.resumeWith(Result.m476constructorimpl(listOf));
                        return;
                    }
                }
                QLog.d(RobotDiscoveryListViewModel.this.getTAG(), 1, "fetchRecentUsedRobots empty");
                Continuation<List<? extends k34.a>> continuation2 = this.f367607b;
                Result.Companion companion = Result.INSTANCE;
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                continuation2.resumeWith(Result.m476constructorimpl(emptyList2));
                return;
            }
            Continuation<List<? extends k34.a>> continuation3 = this.f367607b;
            Result.Companion companion2 = Result.INSTANCE;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            continuation3.resumeWith(Result.m476constructorimpl(emptyList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Q1(long j3, int i3, Continuation<? super List<? extends k34.a>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        List emptyList;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ac a16 = n34.a.a();
        if (a16 == null) {
            Result.Companion companion = Result.INSTANCE;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            safeContinuation.resumeWith(Result.m476constructorimpl(emptyList));
            QLog.d(getTAG(), 1, "fetchRobotDiscoverList null");
        } else {
            GroupRobotStoreDiscoveryReq groupRobotStoreDiscoveryReq = new GroupRobotStoreDiscoveryReq();
            groupRobotStoreDiscoveryReq.groupId = j3;
            groupRobotStoreDiscoveryReq.sceneId = i3;
            a16.fetchGroupRobotStoreDiscovery(groupRobotStoreDiscoveryReq, new b(safeContinuation, groupRobotStoreDiscoveryReq));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object R1(Continuation<? super List<? extends k34.a>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        List emptyList;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ac a16 = n34.a.a();
        if (a16 == null) {
            Result.Companion companion = Result.INSTANCE;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            safeContinuation.resumeWith(Result.m476constructorimpl(emptyList));
            QLog.d(getTAG(), 1, "fetchRecentUsedRobots null");
        } else {
            RecentUsedRobotsReq recentUsedRobotsReq = new RecentUsedRobotsReq();
            recentUsedRobotsReq.offset = 0;
            recentUsedRobotsReq.num = 5;
            a16.fetchRecentUsedRobots(recentUsedRobotsReq, new c(safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<k34.a> U1(String troopUin, GroupRobotStoreDiscoveryRsp rsp, int sceneId) {
        ArrayList arrayList = new ArrayList();
        if (sceneId == 0) {
            ArrayList<RobotBase> arrayList2 = rsp.addedRobots;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "rsp.addedRobots");
            arrayList.add(new k34.b(troopUin, arrayList2, rsp.maxRobotNum));
        }
        Iterator<CategoryRobot> it = rsp.categoryRobots.iterator();
        while (it.hasNext()) {
            CategoryRobot next = it.next();
            int i3 = next.categoryId;
            String str = next.categoryName;
            Intrinsics.checkNotNullExpressionValue(str, "category.categoryName");
            arrayList.add(new k34.g(troopUin, i3, str));
            ArrayList<GroupRobot> arrayList3 = next.robots;
            if (arrayList3 != null) {
                int i16 = 0;
                for (Object obj : arrayList3) {
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    GroupRobot robot = (GroupRobot) obj;
                    Intrinsics.checkNotNullExpressionValue(robot, "robot");
                    String str2 = next.categoryName;
                    Intrinsics.checkNotNullExpressionValue(str2, "category.categoryName");
                    arrayList.add(new k34.d(troopUin, robot, i17, str2, false, 16, null));
                    i16 = i17;
                }
            }
        }
        return arrayList;
    }

    public final void S1(@NotNull String troopUin, int sceneId, @NotNull LifecycleOwner lifecycleOwner) {
        Long longOrNull;
        long j3;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        QLog.d(getTAG(), 1, "fetchRobotDiscoverList troopUin=" + troopUin + " sceneId=" + sceneId);
        Ref.LongRef longRef = new Ref.LongRef();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        longRef.element = j3;
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner);
        String tag = getTAG();
        Boolean bool = Boolean.TRUE;
        CorountineFunKt.e(lifecycleScope, tag, bool, null, bool, new RobotDiscoveryListViewModel$fetchRobotDiscoverList$1(this, sceneId, longRef, null), 4, null);
    }

    @NotNull
    public final MutableLiveData<List<k34.a>> T1() {
        return this.mListData;
    }

    public final void W1(boolean isShow) {
        this.mShowSearchBar = isShow;
        List<k34.a> value = this.mListData.getValue();
        if (value != null && (!value.isEmpty()) && (value.get(0) instanceof k34.e)) {
            k34.a aVar = value.get(0);
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.robot.discover.data.RobotSearchBarBlockData");
            ((k34.e) aVar).b(isShow);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "RobotDiscoveryListViewModel";
    }
}
