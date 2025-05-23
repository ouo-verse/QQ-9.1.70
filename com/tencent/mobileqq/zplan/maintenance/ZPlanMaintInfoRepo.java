package com.tencent.mobileqq.zplan.maintenance;

import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.mobileqq.zplan.model.ZPlanMaintInfo;
import com.tencent.mobileqq.zplan.model.d;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u001b\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\u0010R \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/maintenance/ZPlanMaintInfoRepo;", "", "Lcom/tencent/mobileqq/zplan/model/MaintEntryType;", "type", "Lcom/tencent/mobileqq/zplan/model/i;", "b", "e", "Lcom/tencent/mobileqq/zplan/model/d;", "listener", "", "d", "c", "(Lcom/tencent/mobileqq/zplan/model/MaintEntryType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "Lcom/tencent/mobileqq/zplan/maintenance/b;", "a", "", "Lkotlin/coroutines/Continuation;", "Ljava/util/List;", "mConts", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanMaintInfoRepo {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanMaintInfoRepo f333853a = new ZPlanMaintInfoRepo();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final List<Continuation<Unit>> mConts = new ArrayList();

    ZPlanMaintInfoRepo() {
    }

    public final ZPlanManageMaintConfig a() {
        Object x16 = am.s().x(807);
        Intrinsics.checkNotNullExpressionValue(x16, "getSingleton().loadConOb\u2026tInfoProcessor.CONFIG_ID)");
        return (ZPlanManageMaintConfig) x16;
    }

    public final ZPlanMaintInfo b(MaintEntryType type) {
        ZPlanMaintInfo zPlanMaintInfo;
        Intrinsics.checkNotNullParameter(type, "type");
        Map<String, ZPlanMaintInfo> a16 = a().a();
        return (a16 == null || (zPlanMaintInfo = a16.get(type.getMTypeKey())) == null) ? new ZPlanMaintInfo() : zPlanMaintInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(MaintEntryType maintEntryType, Continuation<? super ZPlanMaintInfo> continuation) {
        ZPlanMaintInfoRepo$refetchMaintInfo$1 zPlanMaintInfoRepo$refetchMaintInfo$1;
        Object coroutine_suspended;
        int i3;
        ZPlanMaintInfoRepo zPlanMaintInfoRepo;
        if (continuation instanceof ZPlanMaintInfoRepo$refetchMaintInfo$1) {
            zPlanMaintInfoRepo$refetchMaintInfo$1 = (ZPlanMaintInfoRepo$refetchMaintInfo$1) continuation;
            int i16 = zPlanMaintInfoRepo$refetchMaintInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanMaintInfoRepo$refetchMaintInfo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanMaintInfoRepo$refetchMaintInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanMaintInfoRepo$refetchMaintInfo$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    zPlanMaintInfoRepo$refetchMaintInfo$1.L$0 = this;
                    zPlanMaintInfoRepo$refetchMaintInfo$1.L$1 = maintEntryType;
                    zPlanMaintInfoRepo$refetchMaintInfo$1.label = 1;
                    if (g(zPlanMaintInfoRepo$refetchMaintInfo$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zPlanMaintInfoRepo = this;
                } else if (i3 == 1) {
                    maintEntryType = (MaintEntryType) zPlanMaintInfoRepo$refetchMaintInfo$1.L$1;
                    zPlanMaintInfoRepo = (ZPlanMaintInfoRepo) zPlanMaintInfoRepo$refetchMaintInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return zPlanMaintInfoRepo.b(maintEntryType);
            }
        }
        zPlanMaintInfoRepo$refetchMaintInfo$1 = new ZPlanMaintInfoRepo$refetchMaintInfo$1(this, continuation);
        Object obj2 = zPlanMaintInfoRepo$refetchMaintInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanMaintInfoRepo$refetchMaintInfo$1.label;
        if (i3 != 0) {
        }
        return zPlanMaintInfoRepo.b(maintEntryType);
    }

    public final void d(MaintEntryType type, d listener) {
        Intrinsics.checkNotNullParameter(type, "type");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ZPlanMaintInfoRepo$refetchMaintInfoAsync$1(type, listener, null), 2, null);
    }

    public final ZPlanMaintInfo e(MaintEntryType type) {
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(type, "type");
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new ZPlanMaintInfoRepo$refetchMaintInfoSync$1(type, null), 1, null);
        return (ZPlanMaintInfo) runBlocking$default;
    }

    public final void f() {
        List<Continuation<Unit>> list = mConts;
        QLog.d("ZPlanMaintInfoRepo", 1, "An config update occurred with conts size: " + list.size());
        synchronized (this) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Continuation continuation = (Continuation) it.next();
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
            }
            mConts.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Object g(Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        synchronized (this) {
            mConts.add(safeContinuation);
        }
        am.s().P(807, 0);
        am.s().M(new int[]{807});
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return orThrow == coroutine_suspended2 ? orThrow : Unit.INSTANCE;
    }
}
