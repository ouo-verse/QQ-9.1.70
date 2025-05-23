package com.tencent.mobileqq.zplan.emoticon.panel.util;

import by4.ZPlanRecordResourceStatistic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil;
import com.tencent.mobileqq.zplan.meme.ZPlanRecordScene;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil$recordEmoticonCoverAndPicByResourceCenter$2", f = "ZPlanEmoticonUtil.kt", i = {}, l = {457, 458, 1009}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonUtil$recordEmoticonCoverAndPicByResourceCenter$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ZPlanActionInfo> $actionListPic;
    final /* synthetic */ Function1<ZPlanEmoticonUtil.EmotionTabRecordReportData, Unit> $callback;
    final /* synthetic */ Ref.IntRef $coverCacheNum;
    final /* synthetic */ Ref.IntRef $coverCloudRecordNum;
    final /* synthetic */ Ref.IntRef $coverLocalRecordNum;
    final /* synthetic */ Ref.LongRef $coverTimeCost;
    final /* synthetic */ int $height;
    final /* synthetic */ ReentrantLock $lock;
    final /* synthetic */ Ref.IntRef $picCacheNum;
    final /* synthetic */ Ref.IntRef $picCloudRecordNum;
    final /* synthetic */ Ref.IntRef $picLocalRecordNum;
    final /* synthetic */ Priority $picPriority;
    final /* synthetic */ int $reqFrom;
    final /* synthetic */ String $selfUin;
    final /* synthetic */ long $timeStart;
    final /* synthetic */ int $total;
    final /* synthetic */ int $width;
    int label;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f333222a;

        static {
            int[] iArr = new int[Source.values().length];
            try {
                iArr[Source.LOCAL_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Source.CLOUD_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Source.LOCAL_RECORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f333222a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ZPlanEmoticonUtil$recordEmoticonCoverAndPicByResourceCenter$2(List<ZPlanActionInfo> list, String str, int i3, int i16, Priority priority, int i17, ReentrantLock reentrantLock, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, Ref.IntRef intRef4, Ref.IntRef intRef5, Ref.IntRef intRef6, int i18, Ref.LongRef longRef, long j3, Function1<? super ZPlanEmoticonUtil.EmotionTabRecordReportData, Unit> function1, Continuation<? super ZPlanEmoticonUtil$recordEmoticonCoverAndPicByResourceCenter$2> continuation) {
        super(2, continuation);
        this.$actionListPic = list;
        this.$selfUin = str;
        this.$width = i3;
        this.$height = i16;
        this.$picPriority = priority;
        this.$reqFrom = i17;
        this.$lock = reentrantLock;
        this.$picLocalRecordNum = intRef;
        this.$picCacheNum = intRef2;
        this.$picCloudRecordNum = intRef3;
        this.$coverCacheNum = intRef4;
        this.$coverCloudRecordNum = intRef5;
        this.$coverLocalRecordNum = intRef6;
        this.$total = i18;
        this.$coverTimeCost = longRef;
        this.$timeStart = j3;
        this.$callback = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanEmoticonUtil$recordEmoticonCoverAndPicByResourceCenter$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00af A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object j06;
        Object e16;
        b bVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanEmoticonUtil zPlanEmoticonUtil = ZPlanEmoticonUtil.f333176e;
            List<ZPlanActionInfo> list = this.$actionListPic;
            String str = this.$selfUin;
            MODE mode = MODE.SHARPP;
            int i16 = this.$width;
            int i17 = this.$height;
            Priority priority = this.$picPriority;
            int i18 = this.$reqFrom;
            this.label = 1;
            j06 = zPlanEmoticonUtil.j0(list, str, mode, i16, i17, (r21 & 16) != 0 ? Priority.LOW : priority, (r21 & 32) != 0 ? 0 : i18, (r21 & 64) != 0, this);
            if (j06 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                e16 = obj;
                bVar = new b(this.$lock, this.$picLocalRecordNum, this.$picCacheNum, this.$picCloudRecordNum, this.$coverCacheNum, this.$coverCloudRecordNum, this.$coverLocalRecordNum, this.$total, this.$coverTimeCost, this.$timeStart, this.$callback);
                this.label = 3;
                if (((Flow) e16).collect(bVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            j06 = obj;
        }
        ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
        List<Source> recordSourceWhenUsingFilament = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getRecordSourceWhenUsingFilament(ZPlanRecordScene.EMOTICON);
        this.label = 2;
        e16 = zPlanRecordResourceCenter.e((BatchRecordRequestParams) j06, recordSourceWhenUsingFilament, this);
        if (e16 == coroutine_suspended) {
            return coroutine_suspended;
        }
        bVar = new b(this.$lock, this.$picLocalRecordNum, this.$picCacheNum, this.$picCloudRecordNum, this.$coverCacheNum, this.$coverCloudRecordNum, this.$coverLocalRecordNum, this.$total, this.$coverTimeCost, this.$timeStart, this.$callback);
        this.label = 3;
        if (((Flow) e16).collect(bVar, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements FlowCollector<ZPlanRecordResource> {
        final /* synthetic */ Ref.IntRef C;
        final /* synthetic */ int D;
        final /* synthetic */ Ref.LongRef E;
        final /* synthetic */ long F;
        final /* synthetic */ Function1 G;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ReentrantLock f333223d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f333224e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f333225f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f333226h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f333227i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f333228m;

        public b(ReentrantLock reentrantLock, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, Ref.IntRef intRef4, Ref.IntRef intRef5, Ref.IntRef intRef6, int i3, Ref.LongRef longRef, long j3, Function1 function1) {
            this.f333223d = reentrantLock;
            this.f333224e = intRef;
            this.f333225f = intRef2;
            this.f333226h = intRef3;
            this.f333227i = intRef4;
            this.f333228m = intRef5;
            this.C = intRef6;
            this.D = i3;
            this.E = longRef;
            this.F = j3;
            this.G = function1;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public Object emit(ZPlanRecordResource zPlanRecordResource, Continuation<? super Unit> continuation) {
            ZPlanRecordResource zPlanRecordResource2 = zPlanRecordResource;
            ZPlanRecordResourceStatistic statistic = zPlanRecordResource2 != null ? zPlanRecordResource2.getStatistic() : null;
            if (QLog.isColorLevel()) {
                QLog.i("[zplan][ZPlanEmoticonUtil]", 2, "get pic end:" + zPlanRecordResource2 + ", sourceType:" + (statistic != null ? statistic.getSource() : null));
            }
            ReentrantLock reentrantLock = this.f333223d;
            reentrantLock.lock();
            try {
                if (statistic == null) {
                    this.f333224e.element++;
                } else {
                    int i3 = a.f333222a[statistic.getSource().ordinal()];
                    if (i3 == 1) {
                        this.f333225f.element++;
                    } else if (i3 == 2) {
                        this.f333226h.element++;
                    } else if (i3 == 3) {
                        this.f333224e.element++;
                    }
                }
                ZPlanEmoticonUtil.S(this.f333223d, this.f333227i, this.f333228m, this.C, this.D, this.f333225f, this.f333226h, this.f333224e, this.E, this.F, this.G);
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                return Unit.INSTANCE;
            } catch (Throwable th5) {
                reentrantLock.unlock();
                throw th5;
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanEmoticonUtil$recordEmoticonCoverAndPicByResourceCenter$2(this.$actionListPic, this.$selfUin, this.$width, this.$height, this.$picPriority, this.$reqFrom, this.$lock, this.$picLocalRecordNum, this.$picCacheNum, this.$picCloudRecordNum, this.$coverCacheNum, this.$coverCloudRecordNum, this.$coverLocalRecordNum, this.$total, this.$coverTimeCost, this.$timeStart, this.$callback, continuation);
    }
}
