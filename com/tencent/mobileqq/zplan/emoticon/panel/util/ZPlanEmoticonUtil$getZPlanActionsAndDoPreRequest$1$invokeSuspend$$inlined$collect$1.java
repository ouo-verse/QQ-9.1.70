package com.tencent.mobileqq.zplan.emoticon.panel.util;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanEmoticonTabCloudCacheRequestConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.FlowCollector;
import mqq.app.AppRuntime;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Panel> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f333181d;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1$invokeSuspend$$inlined$collect$1", f = "ZPlanEmoticonUtil.kt", i = {}, l = {151}, m = "emit", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public ZPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1$invokeSuspend$$inlined$collect$1(CoroutineScope coroutineScope) {
        this.f333181d = coroutineScope;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(Panel panel, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i3;
        List<ZPlanActionInfo> v3;
        Object first;
        Object first2;
        ZPlanEmoticonTabCloudCacheRequestConfig v16;
        List chunked;
        int collectionSizeOrDefault;
        Deferred async$default;
        long j3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i16 = anonymousClass1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i16 - Integer.MIN_VALUE;
                Object obj = anonymousClass1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = anonymousClass1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Panel panel2 = panel;
                    com.tencent.mobileqq.zplan.aio.panel.page.a a16 = com.tencent.mobileqq.zplan.aio.panel.page.a.INSTANCE.a(panel2);
                    if (a16 != null && (v3 = a16.v()) != null) {
                        QLog.i("[zplan][ZPlanEmoticonUtil]", 1, "getZPlanActionsAndDoPreRequest onResp, dataSource=" + panel2.getDataSource() + ", size=" + v3.size());
                        if (!v3.isEmpty()) {
                            AppRuntime d16 = bb.f335811a.d();
                            String currentUin = d16 != null ? d16.getCurrentUin() : null;
                            if (currentUin != null) {
                                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) v3);
                                int width = ((ZPlanActionInfo) first).getWidth();
                                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) v3);
                                int height = ((ZPlanActionInfo) first2).getHeight();
                                v16 = ZPlanEmoticonUtil.f333176e.v();
                                chunked = CollectionsKt___CollectionsKt.chunked(v3, v16.getPerPageMaxCount());
                                List list = chunked;
                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    async$default = BuildersKt__Builders_commonKt.async$default(this.f333181d, null, null, new ZPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1$1$1$1((List) it.next(), currentUin, width, height, null), 3, null);
                                    arrayList.add(async$default);
                                }
                                anonymousClass1.label = 1;
                                if (AwaitKt.awaitAll(arrayList, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ZPlanEmoticonUtil zPlanEmoticonUtil = ZPlanEmoticonUtil.f333176e;
                ZPlanEmoticonUtil.lastBatchPreRequestTimestamp = NetConnInfoCenter.getServerTime();
                ZPlanEmoticonUtil.isDoingBatchPreRequest = false;
                ZPlanEmoticonUtil.appearanceKeyChanged = false;
                j3 = ZPlanEmoticonUtil.lastBatchPreRequestTimestamp;
                QLog.i("[zplan][ZPlanEmoticonUtil]", 1, "getZPlanActionsAndDoPreRequest, finish, lastBatchPreRequestTimestamp:" + j3);
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = anonymousClass1.label;
        if (i3 != 0) {
        }
        ZPlanEmoticonUtil zPlanEmoticonUtil2 = ZPlanEmoticonUtil.f333176e;
        ZPlanEmoticonUtil.lastBatchPreRequestTimestamp = NetConnInfoCenter.getServerTime();
        ZPlanEmoticonUtil.isDoingBatchPreRequest = false;
        ZPlanEmoticonUtil.appearanceKeyChanged = false;
        j3 = ZPlanEmoticonUtil.lastBatchPreRequestTimestamp;
        QLog.i("[zplan][ZPlanEmoticonUtil]", 1, "getZPlanActionsAndDoPreRequest, finish, lastBatchPreRequestTimestamp:" + j3);
        return Unit.INSTANCE;
    }
}
