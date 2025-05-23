package com.tencent.mobileqq.matchfriend.reborn.liteinteraction;

import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.repo.QQStrangerLIARepo;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$MessageNodeInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
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
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper$refreshLIA$1", f = "QQStrangerLIAHelper.kt", i = {}, l = {54, 76}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerLIAHelper$refreshLIA$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<RecentContactInfo> $contactList;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper$refreshLIA$1$4", f = "QQStrangerLIAHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper$refreshLIA$1$4, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Contact> $diffList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(List<Contact> list, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$diffList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$diffList, continuation);
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
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerLIAHelper$refreshLIA$1(List<RecentContactInfo> list, Continuation<? super QQStrangerLIAHelper$refreshLIA$1> continuation) {
        super(2, continuation);
        this.$contactList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerLIAHelper$refreshLIA$1(this.$contactList, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        b v3;
        QQStrangerLIARepo w3;
        int collectionSizeOrDefault;
        o82.b s16;
        ConcurrentHashMap concurrentHashMap;
        List emptyList;
        ConcurrentHashMap q16;
        List m3;
        int collectionSizeOrDefault2;
        Collection values;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            QLog.d("QQStrangerLIAHelper", 1, "start refresh LIA");
            QQStrangerLIAHelper qQStrangerLIAHelper = QQStrangerLIAHelper.f245114a;
            v3 = qQStrangerLIAHelper.v();
            List<Relation$MessageNodeInfo> a16 = v3.a(this.$contactList);
            if (!a16.isEmpty()) {
                w3 = qQStrangerLIAHelper.w();
                this.label = 1;
                obj = w3.c(a16, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                QLog.i("QQStrangerLIAHelper", 1, "nodeList is empty");
                return Unit.INSTANCE;
            }
        }
        List<QQStrangerLIAItem> list = (List) obj;
        List<QQStrangerLIAItem> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (QQStrangerLIAItem qQStrangerLIAItem : list2) {
            arrayList.add(qQStrangerLIAItem.getChatType() + "-" + qQStrangerLIAItem.getPeerTinyId() + "-" + qQStrangerLIAItem.getType());
        }
        QLog.d("QQStrangerLIAHelper", 1, "refresh LIA result " + arrayList);
        QQStrangerLIAHelper qQStrangerLIAHelper2 = QQStrangerLIAHelper.f245114a;
        s16 = qQStrangerLIAHelper2.s();
        List<QQStrangerLIAItem> b16 = s16.b(list);
        concurrentHashMap = QQStrangerLIAHelper.liaItemMap;
        if (concurrentHashMap == null || (values = concurrentHashMap.values()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = new ArrayList(values);
        }
        q16 = qQStrangerLIAHelper2.q(b16);
        QQStrangerLIAHelper.liaItemMap = q16;
        m3 = qQStrangerLIAHelper2.m(b16, emptyList);
        if (QLog.isDevelopLevel()) {
            List<Contact> list3 = m3;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            for (Contact contact : list3) {
                arrayList2.add(contact.chatType + "-" + contact.peerUid);
            }
            QLog.d("QQStrangerLIAHelper", 1, "diffList " + arrayList2);
        }
        i.e eVar = i.e.f261783e;
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(m3, null);
        this.label = 2;
        if (CorountineFunKt.i(eVar, null, null, anonymousClass4, this, 6, null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerLIAHelper$refreshLIA$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
