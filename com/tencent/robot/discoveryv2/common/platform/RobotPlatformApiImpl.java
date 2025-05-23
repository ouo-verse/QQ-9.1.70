package com.tencent.robot.discoveryv2.common.platform;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.IListRobotCallback;
import com.tencent.qqnt.kernel.nativeinterface.ListRobotReq;
import com.tencent.qqnt.kernel.nativeinterface.ListRobotRsp;
import com.tencent.robot.discoveryv2.common.data.FirstScreenFetchArgs;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryFetchArgs;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryRsp;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p34.a;
import u64.h;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0016R,\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u0019\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u001a0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001bR,\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u0019\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00120\u001a0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/robot/discoveryv2/common/platform/RobotPlatformApiImpl;", "Lp34/a;", "Lcom/tencent/robot/discoveryv2/common/data/a;", "fetchArgs", "Lcom/tencent/robot/discoveryv2/common/data/b;", "i", "(Lcom/tencent/robot/discoveryv2/common/data/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/robot/discoveryv2/common/data/f;", "", "svrCookie", "", "svrDataVersion", "Lcom/tencent/robot/discoveryv2/common/data/j;", "j", "(Lcom/tencent/robot/discoveryv2/common/data/f;[BLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "c", "d", "", "a", "b", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "mLifecycleOwner", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Function1;", "Ljava/util/concurrent/ConcurrentHashMap;", "mFirstScreenRspListener", "mSingleCategoryRspListener", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotPlatformApiImpl implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner mLifecycleOwner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, Function1<com.tencent.robot.discoveryv2.common.data.b, Unit>> mFirstScreenRspListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, Function1<SingleCategoryRsp, Unit>> mSingleCategoryRspListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernel/nativeinterface/ListRobotRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class b implements IListRobotCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<com.tencent.robot.discoveryv2.common.data.b> f367670a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FirstScreenFetchArgs f367671b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super com.tencent.robot.discoveryv2.common.data.b> continuation, FirstScreenFetchArgs firstScreenFetchArgs) {
            this.f367670a = continuation;
            this.f367671b = firstScreenFetchArgs;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IListRobotCallback
        public final void onResult(int i3, String str, ListRobotRsp listRobotRsp) {
            Continuation<com.tencent.robot.discoveryv2.common.data.b> continuation = this.f367670a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(new com.tencent.robot.discoveryv2.common.data.b(i3, str, listRobotRsp, this.f367671b)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernel/nativeinterface/ListRobotRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class c implements IListRobotCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<SingleCategoryRsp> f367672a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SingleCategoryFetchArgs f367673b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super SingleCategoryRsp> continuation, SingleCategoryFetchArgs singleCategoryFetchArgs) {
            this.f367672a = continuation;
            this.f367673b = singleCategoryFetchArgs;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IListRobotCallback
        public final void onResult(int i3, String str, ListRobotRsp listRobotRsp) {
            Continuation<SingleCategoryRsp> continuation = this.f367672a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(new SingleCategoryRsp(i3, str, listRobotRsp, this.f367673b)));
        }
    }

    public RobotPlatformApiImpl(@NotNull LifecycleOwner mLifecycleOwner) {
        Intrinsics.checkNotNullParameter(mLifecycleOwner, "mLifecycleOwner");
        this.mLifecycleOwner = mLifecycleOwner;
        this.mFirstScreenRspListener = new ConcurrentHashMap<>();
        this.mSingleCategoryRspListener = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i(FirstScreenFetchArgs firstScreenFetchArgs, Continuation<? super com.tencent.robot.discoveryv2.common.data.b> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.i("TroopRobotPlatformApiImpl", 1, "fetchFirstScreenInternal network false");
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(new com.tencent.robot.discoveryv2.common.data.b(0, null, null, null, 15, null)));
        } else {
            ac a16 = h.a();
            if (a16 == null) {
                QLog.i("TroopRobotPlatformApiImpl", 1, "fetchFirstScreenInternal robotService null");
                Result.Companion companion2 = Result.INSTANCE;
                safeContinuation.resumeWith(Result.m476constructorimpl(new com.tencent.robot.discoveryv2.common.data.b(0, null, null, null, 15, null)));
            } else {
                ListRobotReq listRobotReq = new ListRobotReq();
                listRobotReq.groupId = Util.toLongOrDefault(firstScreenFetchArgs.getUin(), 0L);
                listRobotReq.pageNum = 15;
                listRobotReq.queryTab = true;
                listRobotReq.queryAddedRobot = true;
                QLog.i("TroopRobotPlatformApiImpl", 1, "send fetchListRobot req uin = " + firstScreenFetchArgs.getUin());
                a16.fetchListRobot(listRobotReq, new b(safeContinuation, firstScreenFetchArgs));
            }
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object j(SingleCategoryFetchArgs singleCategoryFetchArgs, byte[] bArr, String str, Continuation<? super SingleCategoryRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.i("TroopRobotPlatformApiImpl", 1, "fetchSingleCategoryInternal network false " + singleCategoryFetchArgs.getCategoryId());
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(new SingleCategoryRsp(0, null, null, singleCategoryFetchArgs, 7, null)));
        } else {
            ac a16 = h.a();
            if (a16 == null) {
                QLog.i("TroopRobotPlatformApiImpl", 1, "fetchSingleCategoryInternal robotService null " + singleCategoryFetchArgs.getCategoryId());
                Result.Companion companion2 = Result.INSTANCE;
                safeContinuation.resumeWith(Result.m476constructorimpl(new SingleCategoryRsp(0, null, null, singleCategoryFetchArgs, 7, null)));
            } else {
                ListRobotReq listRobotReq = new ListRobotReq();
                listRobotReq.groupId = Util.toLongOrDefault(singleCategoryFetchArgs.getUin(), 0L);
                listRobotReq.listId = singleCategoryFetchArgs.getCategoryId();
                listRobotReq.reqPagingCookie = bArr;
                listRobotReq.dataVersion = str;
                listRobotReq.pageNum = 15;
                QLog.i("TroopRobotPlatformApiImpl", 1, "send fetchListRobot categoryId = " + singleCategoryFetchArgs.getCategoryId());
                a16.fetchListRobot(listRobotReq, new c(safeContinuation, singleCategoryFetchArgs));
            }
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Override // p34.a
    public void a(@NotNull FirstScreenFetchArgs fetchArgs) {
        Intrinsics.checkNotNullParameter(fetchArgs, "fetchArgs");
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this.mLifecycleOwner), "TroopRobotPlatformApiImplfetchFirstScreen", Boolean.TRUE, null, null, new RobotPlatformApiImpl$fetchFirstScreenDataFromServer$1(this, fetchArgs, null), 12, null);
    }

    @Override // p34.a
    public void b(@NotNull SingleCategoryFetchArgs fetchArgs, @Nullable byte[] svrCookie, @Nullable String svrDataVersion) {
        Intrinsics.checkNotNullParameter(fetchArgs, "fetchArgs");
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this.mLifecycleOwner), "TroopRobotPlatformApiImplfetchSinglePage", Boolean.TRUE, null, null, new RobotPlatformApiImpl$fetchSingleCategoryDataFromServer$1(this, fetchArgs, svrCookie, svrDataVersion, null), 12, null);
    }

    @Override // p34.a
    @NotNull
    public Flow<com.tencent.robot.discoveryv2.common.data.b> c() {
        return FlowKt.callbackFlow(new RobotPlatformApiImpl$firstScreenRspNotificationFlow$1(this, null));
    }

    @Override // p34.a
    @NotNull
    public Flow<SingleCategoryRsp> d() {
        return FlowKt.callbackFlow(new RobotPlatformApiImpl$singleCategoryRspNotificationFlow$1(this, null));
    }
}
