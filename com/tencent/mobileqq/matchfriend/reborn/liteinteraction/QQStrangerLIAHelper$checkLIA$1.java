package com.tencent.mobileqq.matchfriend.reborn.liteinteraction;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper$checkLIA$1", f = "QQStrangerLIAHelper.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerLIAHelper$checkLIA$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper$checkLIA$1$2", f = "QQStrangerLIAHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper$checkLIA$1$2, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Contact> $diffList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<Contact> list, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$diffList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$diffList, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                QQStrangerLIAHelper.f245114a.y(this.$diffList);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerLIAHelper$checkLIA$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ConcurrentHashMap concurrentHashMap;
        Collection values;
        o82.b s16;
        ConcurrentHashMap q16;
        List m3;
        int collectionSizeOrDefault;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            concurrentHashMap = QQStrangerLIAHelper.liaItemMap;
            if (concurrentHashMap != null && (values = concurrentHashMap.values()) != null) {
                ArrayList arrayList = new ArrayList(values);
                if (arrayList.isEmpty()) {
                    return Unit.INSTANCE;
                }
                QLog.d("QQStrangerLIAHelper", 1, "checkLIA");
                QQStrangerLIAHelper qQStrangerLIAHelper = QQStrangerLIAHelper.f245114a;
                s16 = qQStrangerLIAHelper.s();
                List<QQStrangerLIAItem> b16 = s16.b(arrayList);
                q16 = qQStrangerLIAHelper.q(b16);
                QQStrangerLIAHelper.liaItemMap = q16;
                m3 = qQStrangerLIAHelper.m(b16, arrayList);
                List<Contact> list = m3;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                for (Contact contact : list) {
                    arrayList2.add(contact.chatType + "-" + contact.peerUid);
                }
                QLog.d("QQStrangerLIAHelper", 1, "diffList " + arrayList2);
                i.e eVar = i.e.f261783e;
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(m3, null);
                this.label = 1;
                if (CorountineFunKt.i(eVar, null, null, anonymousClass2, this, 6, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                return Unit.INSTANCE;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QQStrangerLIAHelper$checkLIA$1(Continuation<? super QQStrangerLIAHelper$checkLIA$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerLIAHelper$checkLIA$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
