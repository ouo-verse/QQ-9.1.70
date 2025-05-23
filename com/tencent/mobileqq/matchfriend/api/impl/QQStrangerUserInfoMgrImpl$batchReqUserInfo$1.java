package com.tencent.mobileqq.matchfriend.api.impl;

import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.QQStrangerRecentContactHelper;
import com.tencent.mobileqq.matchfriend.reborn.userinfo.QQStrangerUserInfoRepository;
import com.tencent.mobileqq.matchfriend.reborn.userinfo.QQStrangerUserInfoRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.api.impl.QQStrangerUserInfoMgrImpl$batchReqUserInfo$1", f = "QQStrangerUserInfoMgrImpl.kt", i = {0, 0, 0}, l = {116}, m = "invokeSuspend", n = {"userInfoList", "total", "i"}, s = {"L$0", "I$0", "I$1"})
/* loaded from: classes33.dex */
public final class QQStrangerUserInfoMgrImpl$batchReqUserInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<List<QQStrangerUserInfo>, Unit> $cb;
    final /* synthetic */ List<com.tencent.mobileqq.matchfriend.bean.c> $contacts;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ QQStrangerUserInfoMgrImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QQStrangerUserInfoMgrImpl$batchReqUserInfo$1(List<com.tencent.mobileqq.matchfriend.bean.c> list, Function1<? super List<QQStrangerUserInfo>, Unit> function1, QQStrangerUserInfoMgrImpl qQStrangerUserInfoMgrImpl, Continuation<? super QQStrangerUserInfoMgrImpl$batchReqUserInfo$1> continuation) {
        super(2, continuation);
        this.$contacts = list;
        this.$cb = function1;
        this.this$0 = qQStrangerUserInfoMgrImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerUserInfoMgrImpl$batchReqUserInfo$1(this.$contacts, this.$cb, this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fb A[LOOP:1: B:30:0x00f5->B:32:0x00fb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00ad  */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x009d -> B:5:0x00a6). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ArrayList<QQStrangerUserInfo> arrayList;
        IntRange until;
        IntProgression step;
        int first;
        int step2;
        QQStrangerUserInfoMgrImpl$batchReqUserInfo$1 qQStrangerUserInfoMgrImpl$batchReqUserInfo$1;
        ArrayList arrayList2;
        QQStrangerUserInfoMgrImpl$batchReqUserInfo$1 qQStrangerUserInfoMgrImpl$batchReqUserInfo$12;
        int i3;
        int i16;
        List<QQStrangerUserInfo> emptyList;
        List list;
        Iterator it;
        Function1<List<QQStrangerUserInfo>, Unit> function1;
        QQStrangerUserInfoRepository qQStrangerUserInfoRepository;
        Object b16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i17 = this.label;
        if (i17 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$contacts.isEmpty()) {
                Function1<List<QQStrangerUserInfo>, Unit> function12 = this.$cb;
                if (function12 != null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    function12.invoke(emptyList);
                }
                return Unit.INSTANCE;
            }
            arrayList = new ArrayList();
            int size = this.$contacts.size();
            until = RangesKt___RangesKt.until(0, size);
            step = RangesKt___RangesKt.step(until, 50);
            first = step.getFirst();
            int last = step.getLast();
            step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                arrayList2 = arrayList;
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$12 = this;
                i3 = last;
                i16 = size;
                int i18 = step2;
                int i19 = i3;
                int min = Math.min(first + 50, i16);
                QQStrangerUserInfoRequest qQStrangerUserInfoRequest = QQStrangerUserInfoRequest.f245443a;
                List<com.tencent.mobileqq.matchfriend.bean.c> subList = qQStrangerUserInfoMgrImpl$batchReqUserInfo$12.$contacts.subList(first, min);
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$12.L$0 = arrayList2;
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$12.L$1 = arrayList2;
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$12.I$0 = i16;
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$12.I$1 = first;
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$12.I$2 = i19;
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$12.I$3 = i18;
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$12.label = 1;
                b16 = qQStrangerUserInfoRequest.b(subList, qQStrangerUserInfoMgrImpl$batchReqUserInfo$12);
                if (b16 != coroutine_suspended) {
                }
            } else {
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$1 = this;
                QQStrangerUserInfoMgrImpl qQStrangerUserInfoMgrImpl = qQStrangerUserInfoMgrImpl$batchReqUserInfo$1.this$0;
                while (r1.hasNext()) {
                }
                list = qQStrangerUserInfoMgrImpl$batchReqUserInfo$1.this$0.userInfoChangeListeners;
                it = list.iterator();
                while (it.hasNext()) {
                }
                function1 = qQStrangerUserInfoMgrImpl$batchReqUserInfo$1.$cb;
                if (function1 != null) {
                }
                return Unit.INSTANCE;
            }
        } else if (i17 == 1) {
            int i26 = this.I$3;
            int i27 = this.I$2;
            int i28 = this.I$1;
            int i29 = this.I$0;
            ?? r75 = (List) this.L$1;
            ?? r85 = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList3 = r85;
            ArrayList arrayList4 = r75;
            int i36 = i29;
            int i37 = i28;
            int i38 = i27;
            step2 = i26;
            Object obj2 = coroutine_suspended;
            qQStrangerUserInfoMgrImpl$batchReqUserInfo$1 = this;
            arrayList4.addAll((Collection) obj);
            if (i37 == i38) {
                int i39 = i37 + step2;
                i16 = i36;
                arrayList2 = arrayList3;
                i3 = i38;
                first = i39;
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$12 = qQStrangerUserInfoMgrImpl$batchReqUserInfo$1;
                coroutine_suspended = obj2;
                int i182 = step2;
                int i192 = i3;
                int min2 = Math.min(first + 50, i16);
                QQStrangerUserInfoRequest qQStrangerUserInfoRequest2 = QQStrangerUserInfoRequest.f245443a;
                List<com.tencent.mobileqq.matchfriend.bean.c> subList2 = qQStrangerUserInfoMgrImpl$batchReqUserInfo$12.$contacts.subList(first, min2);
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$12.L$0 = arrayList2;
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$12.L$1 = arrayList2;
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$12.I$0 = i16;
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$12.I$1 = first;
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$12.I$2 = i192;
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$12.I$3 = i182;
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$12.label = 1;
                b16 = qQStrangerUserInfoRequest2.b(subList2, qQStrangerUserInfoMgrImpl$batchReqUserInfo$12);
                if (b16 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                arrayList3 = arrayList2;
                i36 = i16;
                i37 = first;
                i38 = i192;
                step2 = i182;
                obj2 = coroutine_suspended;
                qQStrangerUserInfoMgrImpl$batchReqUserInfo$1 = qQStrangerUserInfoMgrImpl$batchReqUserInfo$12;
                obj = b16;
                arrayList4 = arrayList3;
                arrayList4.addAll((Collection) obj);
                if (i37 == i38) {
                    arrayList = arrayList3;
                    QQStrangerUserInfoMgrImpl qQStrangerUserInfoMgrImpl2 = qQStrangerUserInfoMgrImpl$batchReqUserInfo$1.this$0;
                    for (QQStrangerUserInfo qQStrangerUserInfo : arrayList) {
                        qQStrangerUserInfoRepository = qQStrangerUserInfoMgrImpl2.repo;
                        if (qQStrangerUserInfoRepository != null) {
                            qQStrangerUserInfoRepository.r(qQStrangerUserInfo, QQStrangerRecentContactHelper.f244865a.g(String.valueOf(qQStrangerUserInfo.tinyId)) != null);
                        }
                    }
                    list = qQStrangerUserInfoMgrImpl$batchReqUserInfo$1.this$0.userInfoChangeListeners;
                    it = list.iterator();
                    while (it.hasNext()) {
                        ((com.tencent.mobileqq.matchfriend.api.d) it.next()).a(arrayList);
                    }
                    function1 = qQStrangerUserInfoMgrImpl$batchReqUserInfo$1.$cb;
                    if (function1 != null) {
                        function1.invoke(arrayList);
                    }
                    return Unit.INSTANCE;
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerUserInfoMgrImpl$batchReqUserInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
