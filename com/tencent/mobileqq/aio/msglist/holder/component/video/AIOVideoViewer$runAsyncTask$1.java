package com.tencent.mobileqq.aio.msglist.holder.component.video;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoViewer$runAsyncTask$1", f = "AIOVideoViewer.kt", i = {}, l = {258}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOVideoViewer$runAsyncTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AIOMsgItem $msgItem;
    final /* synthetic */ Function0<Unit> $updateUI;
    final /* synthetic */ Function0<Unit> $work;
    int label;
    final /* synthetic */ AIOVideoViewer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoViewer$runAsyncTask$1$1", f = "AIOVideoViewer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoViewer$runAsyncTask$1$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ AIOMsgItem $msgItem;
        final /* synthetic */ Function0<Unit> $updateUI;
        int label;
        final /* synthetic */ AIOVideoViewer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AIOMsgItem aIOMsgItem, AIOVideoViewer aIOVideoViewer, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$msgItem = aIOMsgItem;
            this.this$0 = aIOVideoViewer;
            this.$updateUI = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aIOMsgItem, aIOVideoViewer, function0, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.$msgItem, this.this$0, this.$updateUI, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    long msgId = this.$msgItem.getMsgId();
                    ShortVideoMsgItem shortVideoMsgItem = this.this$0.currentMsgItem;
                    ShortVideoMsgItem shortVideoMsgItem2 = null;
                    if (shortVideoMsgItem == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                        shortVideoMsgItem = null;
                    }
                    if (msgId != shortVideoMsgItem.getMsgId()) {
                        AIOVideoViewer aIOVideoViewer = this.this$0;
                        long msgId2 = this.$msgItem.getMsgId();
                        ShortVideoMsgItem shortVideoMsgItem3 = this.this$0.currentMsgItem;
                        if (shortVideoMsgItem3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                        } else {
                            shortVideoMsgItem2 = shortVideoMsgItem3;
                        }
                        aIOVideoViewer.X("runAsyncTask, ignored, msgId=" + msgId2 + "!=" + shortVideoMsgItem2.getMsgId());
                        return Unit.INSTANCE;
                    }
                    this.$updateUI.invoke();
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
    public AIOVideoViewer$runAsyncTask$1(Function0<Unit> function0, AIOMsgItem aIOMsgItem, AIOVideoViewer aIOVideoViewer, Function0<Unit> function02, Continuation<? super AIOVideoViewer$runAsyncTask$1> continuation) {
        super(2, continuation);
        this.$work = function0;
        this.$msgItem = aIOMsgItem;
        this.this$0 = aIOVideoViewer;
        this.$updateUI = function02;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, function0, aIOMsgItem, aIOVideoViewer, function02, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AIOVideoViewer$runAsyncTask$1(this.$work, this.$msgItem, this.this$0, this.$updateUI, continuation);
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
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                this.$work.invoke();
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$msgItem, this.this$0, this.$updateUI, null);
                this.label = 1;
                if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOVideoViewer$runAsyncTask$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
