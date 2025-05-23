package com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor;

import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.model.c;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.d;
import com.tencent.qqnt.aio.assistedchat.polish.WriteWhilePolishingFrequencyHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.WriteWhilePolishingProcessor$doAutomaticPolish$1", f = "WriteWhilePolishingProcessor.kt", i = {}, l = {266, 268}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class WriteWhilePolishingProcessor$doAutomaticPolish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $inputContent;
    int label;
    final /* synthetic */ WriteWhilePolishingProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.WriteWhilePolishingProcessor$doAutomaticPolish$1$1", f = "WriteWhilePolishingProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.WriteWhilePolishingProcessor$doAutomaticPolish$1$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ d $polishingResult;
        int label;
        final /* synthetic */ WriteWhilePolishingProcessor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(d dVar, WriteWhilePolishingProcessor writeWhilePolishingProcessor, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$polishingResult = dVar;
            this.this$0 = writeWhilePolishingProcessor;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, dVar, writeWhilePolishingProcessor, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.$polishingResult, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            String str;
            Handler M;
            Runnable J;
            Handler M2;
            Runnable J2;
            WriteWhilePolishingFrequencyHelper L;
            Object first;
            String str2;
            String str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    QLog.i("WriteWhilePolishingProcessor", 1, "on polish result. success=" + this.$polishingResult.i() + ", size=" + this.$polishingResult.g().size());
                    if (this.$polishingResult.i() && (!this.$polishingResult.g().isEmpty())) {
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.$polishingResult.g());
                        WriteWhilePolishingProcessor writeWhilePolishingProcessor = this.this$0;
                        c cVar = (c) first;
                        writeWhilePolishingProcessor.currentPolishContent = cVar.a();
                        writeWhilePolishingProcessor.trace = cVar.e();
                        str2 = this.this$0.currentPolishContent;
                        str3 = this.this$0.trace;
                        QLog.i("WriteWhilePolishingProcessor", 1, "on polish success, currentPolishContent=" + str2 + ", trace=" + str3);
                        this.this$0.Q(2);
                    } else {
                        WriteWhilePolishingProcessor writeWhilePolishingProcessor2 = this.this$0;
                        if (this.$polishingResult.b() != 27008 && this.$polishingResult.b() != 27009) {
                            str = "\u62b1\u6b49\uff0c\u65e0\u6cd5\u6da6\u8272\u76f8\u5173\u5185\u5bb9\u3002";
                        } else {
                            str = "\u5185\u5bb9\u8fc7\u957f\uff0c\u8bf7\u7f29\u77ed\u5185\u5bb9\u540e\u91cd\u8bd5\u3002";
                        }
                        writeWhilePolishingProcessor2.failedMessage = str;
                        this.this$0.Q(3);
                        M = this.this$0.M();
                        J = this.this$0.J();
                        M.removeCallbacks(J);
                        M2 = this.this$0.M();
                        J2 = this.this$0.J();
                        M2.postDelayed(J2, 2000L);
                    }
                    L = this.this$0.L();
                    L.c();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WriteWhilePolishingProcessor$doAutomaticPolish$1(WriteWhilePolishingProcessor writeWhilePolishingProcessor, String str, Continuation<? super WriteWhilePolishingProcessor$doAutomaticPolish$1> continuation) {
        super(2, continuation);
        this.this$0 = writeWhilePolishingProcessor;
        this.$inputContent = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, writeWhilePolishingProcessor, str, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new WriteWhilePolishingProcessor$doAutomaticPolish$1(this.this$0, this.$inputContent, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
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
                WriteWhilePolishingProcessor writeWhilePolishingProcessor = this.this$0;
                String str = this.$inputContent;
                this.label = 1;
                obj = writeWhilePolishingProcessor.W(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            QLog.i("WriteWhilePolishingProcessor", 1, "on polish result after request.");
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1((d) obj, this.this$0, null);
            this.label = 2;
            if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((WriteWhilePolishingProcessor$doAutomaticPolish$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
