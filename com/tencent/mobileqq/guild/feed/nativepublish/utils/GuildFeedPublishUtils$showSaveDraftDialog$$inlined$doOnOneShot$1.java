package com.tencent.mobileqq.guild.feed.nativepublish.utils;

import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorDraftUseCaseMsgIntent;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\u008a@"}, d2 = {"Lcom/tencent/mvi/base/route/MsgIntent;", "T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils$showSaveDraftDialog$$inlined$doOnOneShot$1", f = "GuildFeedPublishUtils.kt", i = {0}, l = {106}, m = "invokeSuspend", n = {"$this$awaitOneShot$iv"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class GuildFeedPublishUtils$showSaveDraftDialog$$inlined$doOnOneShot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0 $callback$inlined;
    final /* synthetic */ com.tencent.mvi.base.route.j $this_doOnOneShot;
    final /* synthetic */ Object $token$inlined;
    Object L$0;
    Object L$1;
    int label;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/util/IVMessengerKtKt$awaitOneShot$2$action$1", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements com.tencent.mvi.base.route.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mvi.base.route.j f222316d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f222317e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation f222318f;

        public a(com.tencent.mvi.base.route.j jVar, String str, CancellableContinuation cancellableContinuation) {
            this.f222316d = jVar;
            this.f222317e = str;
            this.f222318f = cancellableContinuation;
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof FeedEditorDraftUseCaseMsgIntent.OnUserFinishSaveDraftDialogMsgIntent) {
                this.f222316d.b(this.f222317e, this);
                this.f222318f.resumeWith(Result.m476constructorimpl(i3));
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedPublishUtils$showSaveDraftDialog$$inlined$doOnOneShot$1(com.tencent.mvi.base.route.j jVar, Continuation continuation, Object obj, Function0 function0) {
        super(2, continuation);
        this.$this_doOnOneShot = jVar;
        this.$token$inlined = obj;
        this.$callback$inlined = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFeedPublishUtils$showSaveDraftDialog$$inlined$doOnOneShot$1(this.$this_doOnOneShot, continuation, this.$token$inlined, this.$callback$inlined);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        Object coroutine_suspended2;
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
            final com.tencent.mvi.base.route.j jVar = this.$this_doOnOneShot;
            this.L$0 = jVar;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            final String b16 = com.tencent.mvi.base.route.c.b(FeedEditorDraftUseCaseMsgIntent.OnUserFinishSaveDraftDialogMsgIntent.class);
            Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
            final a aVar = new a(jVar, b16, cancellableContinuationImpl);
            jVar.d(b16, aVar);
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils$showSaveDraftDialog$$inlined$doOnOneShot$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th5) {
                    com.tencent.mvi.base.route.j.this.b(b16, aVar);
                }
            });
            obj = cancellableContinuationImpl.getResult();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (obj == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        FeedEditorDraftUseCaseMsgIntent.OnUserFinishSaveDraftDialogMsgIntent onUserFinishSaveDraftDialogMsgIntent = (FeedEditorDraftUseCaseMsgIntent.OnUserFinishSaveDraftDialogMsgIntent) obj;
        if (onUserFinishSaveDraftDialogMsgIntent.getToken() != this.$token$inlined) {
            return Unit.INSTANCE;
        }
        onUserFinishSaveDraftDialogMsgIntent.a();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedPublishUtils$showSaveDraftDialog$$inlined$doOnOneShot$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
