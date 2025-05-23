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
import java.util.Iterator;
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
import nh3.ZPlanEmoticonReportData;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil$recordEmoticonCoverAndPicByResourceCenter$1", f = "ZPlanEmoticonUtil.kt", i = {1}, l = {418, 419, 1009}, m = "invokeSuspend", n = {"batchFrameParams"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonUtil$recordEmoticonCoverAndPicByResourceCenter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ZPlanActionInfo> $actionInfoList;
    final /* synthetic */ Function1<ZPlanEmoticonUtil.EmotionTabRecordReportData, Unit> $callback;
    final /* synthetic */ Ref.IntRef $coverCacheNum;
    final /* synthetic */ Ref.IntRef $coverCloudRecordNum;
    final /* synthetic */ Ref.IntRef $coverLocalRecordNum;
    final /* synthetic */ Priority $coverPriority;
    final /* synthetic */ Ref.LongRef $coverTimeCost;
    final /* synthetic */ int $height;
    final /* synthetic */ jh3.a $listener;
    final /* synthetic */ ReentrantLock $lock;
    final /* synthetic */ Ref.IntRef $picCacheNum;
    final /* synthetic */ Ref.IntRef $picCloudRecordNum;
    final /* synthetic */ Ref.IntRef $picLocalRecordNum;
    final /* synthetic */ int $reqFrom;
    final /* synthetic */ String $selfUin;
    final /* synthetic */ long $timeStart;
    final /* synthetic */ int $total;
    final /* synthetic */ int $width;
    Object L$0;
    int label;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f333215a;

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
            f333215a = iArr;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanEmoticonUtil$recordEmoticonCoverAndPicByResourceCenter$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ZPlanEmoticonUtil$recordEmoticonCoverAndPicByResourceCenter$1(List<ZPlanActionInfo> list, String str, int i3, int i16, Priority priority, int i17, jh3.a aVar, ReentrantLock reentrantLock, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, int i18, Ref.LongRef longRef, long j3, Ref.IntRef intRef4, Ref.IntRef intRef5, Ref.IntRef intRef6, Function1<? super ZPlanEmoticonUtil.EmotionTabRecordReportData, Unit> function1, Continuation<? super ZPlanEmoticonUtil$recordEmoticonCoverAndPicByResourceCenter$1> continuation) {
        super(2, continuation);
        this.$actionInfoList = list;
        this.$selfUin = str;
        this.$width = i3;
        this.$height = i16;
        this.$coverPriority = priority;
        this.$reqFrom = i17;
        this.$listener = aVar;
        this.$lock = reentrantLock;
        this.$coverLocalRecordNum = intRef;
        this.$coverCacheNum = intRef2;
        this.$coverCloudRecordNum = intRef3;
        this.$total = i18;
        this.$coverTimeCost = longRef;
        this.$timeStart = j3;
        this.$picCacheNum = intRef4;
        this.$picCloudRecordNum = intRef5;
        this.$picLocalRecordNum = intRef6;
        this.$callback = function1;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00ca A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object j06;
        BatchRecordRequestParams batchRecordRequestParams;
        Object e16;
        Flow flow;
        b bVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanEmoticonUtil zPlanEmoticonUtil = ZPlanEmoticonUtil.f333176e;
            List<ZPlanActionInfo> list = this.$actionInfoList;
            String str = this.$selfUin;
            MODE mode = MODE.FRAME;
            int i16 = this.$width;
            int i17 = this.$height;
            Priority priority = this.$coverPriority;
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
                batchRecordRequestParams = (BatchRecordRequestParams) this.L$0;
                ResultKt.throwOnFailure(obj);
                e16 = obj;
                flow = (Flow) e16;
                bVar = new b(batchRecordRequestParams, this.$listener, this.$lock, this.$actionInfoList, this.$coverLocalRecordNum, this.$coverCacheNum, this.$coverCloudRecordNum, this.$total, this.$coverTimeCost, this.$timeStart, this.$picCacheNum, this.$picCloudRecordNum, this.$picLocalRecordNum, this.$callback);
                this.L$0 = null;
                this.label = 3;
                if (flow.collect(bVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            j06 = obj;
        }
        batchRecordRequestParams = (BatchRecordRequestParams) j06;
        ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
        List<Source> recordSourceWhenUsingFilament = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getRecordSourceWhenUsingFilament(ZPlanRecordScene.EMOTICON);
        this.L$0 = batchRecordRequestParams;
        this.label = 2;
        e16 = zPlanRecordResourceCenter.e(batchRecordRequestParams, recordSourceWhenUsingFilament, this);
        if (e16 == coroutine_suspended) {
            return coroutine_suspended;
        }
        flow = (Flow) e16;
        bVar = new b(batchRecordRequestParams, this.$listener, this.$lock, this.$actionInfoList, this.$coverLocalRecordNum, this.$coverCacheNum, this.$coverCloudRecordNum, this.$total, this.$coverTimeCost, this.$timeStart, this.$picCacheNum, this.$picCloudRecordNum, this.$picLocalRecordNum, this.$callback);
        this.L$0 = null;
        this.label = 3;
        if (flow.collect(bVar, this) == coroutine_suspended) {
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
        final /* synthetic */ Ref.IntRef G;
        final /* synthetic */ Ref.IntRef H;
        final /* synthetic */ Ref.IntRef I;
        final /* synthetic */ Function1 J;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BatchRecordRequestParams f333216d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ jh3.a f333217e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ReentrantLock f333218f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f333219h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f333220i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f333221m;

        public b(BatchRecordRequestParams batchRecordRequestParams, jh3.a aVar, ReentrantLock reentrantLock, List list, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, int i3, Ref.LongRef longRef, long j3, Ref.IntRef intRef4, Ref.IntRef intRef5, Ref.IntRef intRef6, Function1 function1) {
            this.f333216d = batchRecordRequestParams;
            this.f333217e = aVar;
            this.f333218f = reentrantLock;
            this.f333219h = list;
            this.f333220i = intRef;
            this.f333221m = intRef2;
            this.C = intRef3;
            this.D = i3;
            this.E = longRef;
            this.F = j3;
            this.G = intRef4;
            this.H = intRef5;
            this.I = intRef6;
            this.J = function1;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x00c7  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object emit(ZPlanRecordResource zPlanRecordResource, Continuation<? super Unit> continuation) {
            ZPlanActionInfo zPlanActionInfo;
            String d16;
            ZPlanEmoticonReportData e06;
            Object obj;
            ZPlanRecordResource zPlanRecordResource2 = zPlanRecordResource;
            ZPlanRecordResourceStatistic statistic = zPlanRecordResource2 != null ? zPlanRecordResource2.getStatistic() : null;
            if (QLog.isColorLevel()) {
                QLog.i("[zplan][ZPlanEmoticonUtil]", 2, "get cover end:" + zPlanRecordResource2 + ", sourceType:" + (statistic != null ? statistic.getSource() : null));
            }
            boolean o16 = zPlanRecordResource2 != null ? zPlanRecordResource2.o() : false;
            int resId = statistic != null ? statistic.getResId() : -1;
            if (statistic != null) {
                Iterator it = this.f333219h.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((ZPlanActionInfo) obj).getId() == resId) {
                        break;
                    }
                }
                ZPlanActionInfo zPlanActionInfo2 = (ZPlanActionInfo) obj;
                if (zPlanActionInfo2 != null) {
                    zPlanActionInfo = zPlanActionInfo2;
                    d16 = this.f333216d.a().getSenderInfo().d();
                    if (d16 != null) {
                        QLog.i("[zplan][ZPlanEmoticonUtil]", 1, "single record done, id: " + zPlanActionInfo.getId() + ", keyOnRecord: " + d16);
                        jh3.a aVar = this.f333217e;
                        if (aVar != null) {
                            String localPath = zPlanRecordResource2 != null ? zPlanRecordResource2.getLocalPath() : null;
                            e06 = ZPlanEmoticonUtil.f333176e.e0(statistic);
                            aVar.a(o16, localPath, zPlanActionInfo, e06, d16);
                        }
                        ReentrantLock reentrantLock = this.f333218f;
                        reentrantLock.lock();
                        try {
                            if (statistic == null) {
                                this.f333220i.element++;
                            } else {
                                int i3 = a.f333215a[statistic.getSource().ordinal()];
                                if (i3 == 1) {
                                    this.f333221m.element++;
                                } else if (i3 == 2) {
                                    this.C.element++;
                                } else if (i3 == 3) {
                                    this.f333220i.element++;
                                }
                            }
                            if (this.f333221m.element + this.C.element + this.f333220i.element == this.D) {
                                this.E.element = System.currentTimeMillis() - this.F;
                            }
                            ZPlanEmoticonUtil.S(this.f333218f, this.f333221m, this.C, this.f333220i, this.D, this.G, this.H, this.I, this.E, this.F, this.J);
                            Unit unit = Unit.INSTANCE;
                        } finally {
                            reentrantLock.unlock();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            zPlanActionInfo = new ZPlanActionInfo(0, null, 0, null, null, 0, 0, null, null, 0, 0, 0, 0, null, null, null, 0, 0, 0, 0, null, null, 4194303, null);
            d16 = this.f333216d.a().getSenderInfo().d();
            if (d16 != null) {
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanEmoticonUtil$recordEmoticonCoverAndPicByResourceCenter$1(this.$actionInfoList, this.$selfUin, this.$width, this.$height, this.$coverPriority, this.$reqFrom, this.$listener, this.$lock, this.$coverLocalRecordNum, this.$coverCacheNum, this.$coverCloudRecordNum, this.$total, this.$coverTimeCost, this.$timeStart, this.$picCacheNum, this.$picCloudRecordNum, this.$picLocalRecordNum, this.$callback, continuation);
    }
}
