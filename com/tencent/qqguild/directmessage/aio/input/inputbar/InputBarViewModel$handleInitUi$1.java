package com.tencent.qqguild.directmessage.aio.input.inputbar;

import com.tencent.guild.aio.input.at.DMSlashMsgIntent;
import com.tencent.guild.api.media.album.GuildAIOMediasRepository;
import com.tencent.guild.api.media.album.INTGuildAlbumApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqguild.directmessage.aio.input.UIState;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqguild.directmessage.aio.input.inputbar.InputBarViewModel$handleInitUi$1", f = "InputBarViewModel.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes22.dex */
public final class InputBarViewModel$handleInitUi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InputBarViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputBarViewModel$handleInitUi$1(InputBarViewModel inputBarViewModel, Continuation<? super InputBarViewModel$handleInitUi$1> continuation) {
        super(2, continuation);
        this.this$0 = inputBarViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new InputBarViewModel$handleInitUi$1(this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        GuildAIOMediasRepository mediaRepo;
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
            InputBarViewModel inputBarViewModel = this.this$0;
            this.label = 1;
            obj = com.tencent.qqguild.directmessage.aio.input.mixin.d.c(inputBarViewModel, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        List<MsgElement> list = (List) obj;
        ((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).e().h(new DMSlashMsgIntent.SetSlashAbility(false));
        this.this$0.updateUI(new UIState.RecoverDraft(list, false, 2, null));
        ((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).e().h(new DMSlashMsgIntent.SetSlashAbility(true));
        z16 = this.this$0.isDirectSwitchOn;
        if (z16 && (mediaRepo = this.this$0.getMediaRepo()) != null) {
            mediaRepo.p(((INTGuildAlbumApi) QRoute.api(INTGuildAlbumApi.class)).msgElement2MediaInfo(list));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((InputBarViewModel$handleInitUi$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
