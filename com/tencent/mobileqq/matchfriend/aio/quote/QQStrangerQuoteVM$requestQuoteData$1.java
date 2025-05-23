package com.tencent.mobileqq.matchfriend.aio.quote;

import com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteUIState;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteVM$requestQuoteData$1", f = "QQStrangerQuoteVM.kt", i = {2}, l = {166, 168, 176, 177}, m = "invokeSuspend", n = {"quoteData"}, s = {"L$0"})
/* loaded from: classes33.dex */
public final class QQStrangerQuoteVM$requestQuoteData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ QQStrangerQuoteVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteVM$requestQuoteData$1$1", f = "QQStrangerQuoteVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteVM$requestQuoteData$1$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ QQStrangerQuoteData $quoteData;
        int label;
        final /* synthetic */ QQStrangerQuoteVM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(QQStrangerQuoteVM qQStrangerQuoteVM, QQStrangerQuoteData qQStrangerQuoteData, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = qQStrangerQuoteVM;
            this.$quoteData = qQStrangerQuoteData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$quoteData, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                QLog.d("QQStrangerQuoteVM", 1, "AddQuoteView");
                this.this$0.updateUI(new QQStrangerQuoteUIState.AddQuoteView(this.$quoteData));
                this.this$0.isQuoteShow = true;
                this.this$0.hasQuoteInit = true;
                this.this$0.K();
                QQStrangerQuoteVM.x(this.this$0, false, 1, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerQuoteVM$requestQuoteData$1(QQStrangerQuoteVM qQStrangerQuoteVM, Continuation<? super QQStrangerQuoteVM$requestQuoteData$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerQuoteVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerQuoteVM$requestQuoteData$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00ce A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Long longOrNull;
        String str;
        QQStrangerQuoteRepo B;
        int y16;
        String str2;
        Object a16;
        QQStrangerQuoteRepo B2;
        int y17;
        Object b16;
        QQStrangerQuoteData qQStrangerQuoteData;
        MainCoroutineDispatcher main;
        AnonymousClass1 anonymousClass1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.this$0.A());
            long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
            str = this.this$0.feedId;
            if (str == null || str.length() == 0) {
                B2 = this.this$0.B();
                y17 = this.this$0.y();
                this.label = 1;
                b16 = QQStrangerQuoteRepo.b(B2, y17, longValue, null, this, 4, null);
                if (b16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                qQStrangerQuoteData = (QQStrangerQuoteData) b16;
            } else {
                B = this.this$0.B();
                y16 = this.this$0.y();
                str2 = this.this$0.feedId;
                this.label = 2;
                a16 = B.a(y16, longValue, str2, this);
                if (a16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                qQStrangerQuoteData = (QQStrangerQuoteData) a16;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
            b16 = obj;
            qQStrangerQuoteData = (QQStrangerQuoteData) b16;
        } else {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                qQStrangerQuoteData = (QQStrangerQuoteData) this.L$0;
                ResultKt.throwOnFailure(obj);
                main = Dispatchers.getMain();
                anonymousClass1 = new AnonymousClass1(this.this$0, qQStrangerQuoteData, null);
                this.L$0 = null;
                this.label = 4;
                if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            a16 = obj;
            qQStrangerQuoteData = (QQStrangerQuoteData) a16;
        }
        if (qQStrangerQuoteData == null) {
            this.this$0.hasQuoteInit = true;
            this.this$0.K();
            return Unit.INSTANCE;
        }
        this.L$0 = qQStrangerQuoteData;
        this.label = 3;
        if (DelayKt.delay(200L, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        main = Dispatchers.getMain();
        anonymousClass1 = new AnonymousClass1(this.this$0, qQStrangerQuoteData, null);
        this.L$0 = null;
        this.label = 4;
        if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerQuoteVM$requestQuoteData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
