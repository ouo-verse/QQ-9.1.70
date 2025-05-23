package com.tencent.mobileqq.matchfriend.aio.quote;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.aio.interactive.AIOInteractiveResult;
import com.tencent.mobileqq.matchfriend.aio.interactive.QQStrangerAIOInteractiveRequest;
import com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteUIState;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$InteractiveOption;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$InteractiveParam;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteVM$sendQuoteMsg$1", f = "QQStrangerQuoteVM.kt", i = {}, l = {208, 222}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerQuoteVM$sendQuoteMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ QQStrangerQuoteAction $action;
    final /* synthetic */ QQStrangerQuoteData $data;
    int label;
    final /* synthetic */ QQStrangerQuoteVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteVM$sendQuoteMsg$1$1", f = "QQStrangerQuoteVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteVM$sendQuoteMsg$1$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AIOInteractiveResult $result;
        int label;
        final /* synthetic */ QQStrangerQuoteVM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(QQStrangerQuoteVM qQStrangerQuoteVM, AIOInteractiveResult aIOInteractiveResult, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = qQStrangerQuoteVM;
            this.$result = aIOInteractiveResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$result, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AtomicBoolean atomicBoolean;
            String string;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                atomicBoolean = this.this$0.isSendingMsg;
                atomicBoolean.set(false);
                if (this.$result.getSuccess()) {
                    this.this$0.updateUI(new QQStrangerQuoteUIState.RemoveQuoteView(false));
                } else {
                    if (this.$result.getMsg().length() > 0) {
                        string = this.$result.getMsg();
                    } else if (!NetworkUtil.isNetworkAvailable()) {
                        string = BaseApplication.context.getString(R.string.f170722lt);
                        Intrinsics.checkNotNullExpressionValue(string, "{\n                      \u2026ps)\n                    }");
                    } else {
                        string = BaseApplication.context.getString(R.string.f201274ud);
                        Intrinsics.checkNotNullExpressionValue(string, "{\n                      \u2026nd)\n                    }");
                    }
                    QQToast.makeText(BaseApplication.context, 1, string, 0).show();
                }
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
    public QQStrangerQuoteVM$sendQuoteMsg$1(QQStrangerQuoteVM qQStrangerQuoteVM, QQStrangerQuoteAction qQStrangerQuoteAction, QQStrangerQuoteData qQStrangerQuoteData, Continuation<? super QQStrangerQuoteVM$sendQuoteMsg$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerQuoteVM;
        this.$action = qQStrangerQuoteAction;
        this.$data = qQStrangerQuoteData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerQuoteVM$sendQuoteMsg$1(this.this$0, this.$action, this.$data, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerQuoteVM$sendQuoteMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0096, code lost:
    
        r6 = r7.feedId;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        AtomicBoolean atomicBoolean;
        Long longOrNull;
        Object c16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            atomicBoolean = this.this$0.isSendingMsg;
            if (!atomicBoolean.getAndSet(true)) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.this$0.A());
                long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
                QLog.d("QQStrangerQuoteVM", 1, "sendQuoteMsg action=" + this.$action + ", tinyId=" + longValue);
                QQStrangerAIOInteractiveRequest qQStrangerAIOInteractiveRequest = QQStrangerAIOInteractiveRequest.f243904a;
                int z16 = this.this$0.z();
                Prompt$InteractiveParam prompt$InteractiveParam = new Prompt$InteractiveParam();
                QQStrangerQuoteData qQStrangerQuoteData = this.$data;
                QQStrangerQuoteVM qQStrangerQuoteVM = this.this$0;
                PBStringField pBStringField = prompt$InteractiveParam.Interactive_object;
                String feedId = qQStrangerQuoteData.getFeedId();
                if ((feedId.length() == 0) && feedId == null) {
                    feedId = "";
                }
                pBStringField.set(feedId);
                prompt$InteractiveParam.tinyid.set(longValue);
                Unit unit = Unit.INSTANCE;
                Prompt$InteractiveOption prompt$InteractiveOption = new Prompt$InteractiveOption();
                QQStrangerQuoteAction qQStrangerQuoteAction = this.$action;
                prompt$InteractiveOption.interactive_id.set(qQStrangerQuoteAction.getActionId());
                prompt$InteractiveOption.content.set(qQStrangerQuoteAction.getContent());
                this.label = 1;
                c16 = qQStrangerAIOInteractiveRequest.c(z16, longValue, 1, prompt$InteractiveParam, prompt$InteractiveOption, this);
                if (c16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                QLog.d("QQStrangerQuoteVM", 1, "sending msg, ignore repeat send");
                return Unit.INSTANCE;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            c16 = obj;
        }
        AIOInteractiveResult aIOInteractiveResult = (AIOInteractiveResult) c16;
        QLog.d("QQStrangerQuoteVM", 1, "sendQuoteMsg result=" + aIOInteractiveResult);
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, aIOInteractiveResult, null);
        this.label = 2;
        if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
