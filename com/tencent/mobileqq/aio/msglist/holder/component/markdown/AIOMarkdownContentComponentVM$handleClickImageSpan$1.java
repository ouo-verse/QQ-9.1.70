package com.tencent.mobileqq.aio.msglist.holder.component.markdown;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.a;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.markdown.AIOMarkdownContentComponentVM$handleClickImageSpan$1", f = "AIOMarkdownContentComponentVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOMarkdownContentComponentVM$handleClickImageSpan$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AppRuntime $app;
    final /* synthetic */ a.c $intent;
    final /* synthetic */ String $localPath;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIOMarkdownContentComponentVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.markdown.AIOMarkdownContentComponentVM$handleClickImageSpan$1$1", f = "AIOMarkdownContentComponentVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.AIOMarkdownContentComponentVM$handleClickImageSpan$1$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ AppRuntime $app;
        final /* synthetic */ MsgRecord $fakeMsgRecord;
        final /* synthetic */ MsgElement $msgElement;
        int label;
        final /* synthetic */ AIOMarkdownContentComponentVM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AppRuntime appRuntime, AIOMarkdownContentComponentVM aIOMarkdownContentComponentVM, MsgRecord msgRecord, MsgElement msgElement, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$app = appRuntime;
            this.this$0 = aIOMarkdownContentComponentVM;
            this.$fakeMsgRecord = msgRecord;
            this.$msgElement = msgElement;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, appRuntime, aIOMarkdownContentComponentVM, msgRecord, msgElement, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.$app, this.this$0, this.$fakeMsgRecord, this.$msgElement, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
                    AppRuntime appRuntime = this.$app;
                    Context requireContext = ((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).c().requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
                    IRichMediaBrowserApi.a.a(iRichMediaBrowserApi, appRuntime, requireContext, null, new AIOMsgItem(this.$fakeMsgRecord), this.$msgElement, true, null, null, false, TroopInfo.PAY_PRIVILEGE_ALL, null);
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
    public AIOMarkdownContentComponentVM$handleClickImageSpan$1(AIOMarkdownContentComponentVM aIOMarkdownContentComponentVM, String str, a.c cVar, AppRuntime appRuntime, Continuation<? super AIOMarkdownContentComponentVM$handleClickImageSpan$1> continuation) {
        super(2, continuation);
        this.this$0 = aIOMarkdownContentComponentVM;
        this.$localPath = str;
        this.$intent = cVar;
        this.$app = appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aIOMarkdownContentComponentVM, str, cVar, appRuntime, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOMarkdownContentComponentVM$handleClickImageSpan$1 aIOMarkdownContentComponentVM$handleClickImageSpan$1 = new AIOMarkdownContentComponentVM$handleClickImageSpan$1(this.this$0, this.$localPath, this.$intent, this.$app, continuation);
        aIOMarkdownContentComponentVM$handleClickImageSpan$1.L$0 = obj;
        return aIOMarkdownContentComponentVM$handleClickImageSpan$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MsgElement F;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                F = this.this$0.F(this.$localPath);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass1(this.$app, this.this$0, com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils.b.b(com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils.b.f191112a, this.$intent.c().getMsgRecord(), F, 0, 0, 0, 0, 60, null), F, null), 2, null);
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOMarkdownContentComponentVM$handleClickImageSpan$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
