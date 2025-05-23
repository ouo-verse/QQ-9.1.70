package com.tencent.mobileqq.matchfriend.reborn.liteinteraction;

import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.repo.QQStrangerLIARepo;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper$removeAndReportLIA$1", f = "QQStrangerLIAHelper.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerLIAHelper$removeAndReportLIA$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $closeMsgList;
    final /* synthetic */ QQStrangerLIAItem $item;
    final /* synthetic */ boolean $showSceneChanged;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper$removeAndReportLIA$1$1", f = "QQStrangerLIAHelper.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper$removeAndReportLIA$1$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $closeMsgList;
        final /* synthetic */ QQStrangerLIAItem $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z16, QQStrangerLIAItem qQStrangerLIAItem, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$closeMsgList = z16;
            this.$item = qQStrangerLIAItem;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$closeMsgList, this.$item, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            QQStrangerLIARepo w3;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$closeMsgList) {
                    w3 = QQStrangerLIAHelper.f245114a.w();
                    int chatType = this.$item.getChatType();
                    long peerTinyId = this.$item.getPeerTinyId();
                    int type = this.$item.getType();
                    this.label = 1;
                    if (w3.a(chatType, peerTinyId, type, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerLIAHelper$removeAndReportLIA$1(QQStrangerLIAItem qQStrangerLIAItem, boolean z16, boolean z17, Continuation<? super QQStrangerLIAHelper$removeAndReportLIA$1> continuation) {
        super(2, continuation);
        this.$item = qQStrangerLIAItem;
        this.$showSceneChanged = z16;
        this.$closeMsgList = z17;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerLIAHelper$removeAndReportLIA$1(this.$item, this.$showSceneChanged, this.$closeMsgList, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        r11 = com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper.liaItemMap;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List listOf;
        ConcurrentHashMap concurrentHashMap;
        String F;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$item.getShowScene() == 0 && concurrentHashMap != null) {
                F = QQStrangerLIAHelper.f245114a.F(e.e(this.$item));
            }
            if (this.$showSceneChanged) {
                QQStrangerLIAHelper qQStrangerLIAHelper = QQStrangerLIAHelper.f245114a;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(e.e(this.$item));
                qQStrangerLIAHelper.y(listOf);
            }
            i.b bVar = i.b.f261780e;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$closeMsgList, this.$item, null);
            this.label = 1;
            if (CorountineFunKt.i(bVar, null, null, anonymousClass1, this, 6, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerLIAHelper$removeAndReportLIA$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
