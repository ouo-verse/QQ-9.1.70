package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.util.LoadingUtil;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.handler.EditFeedActionHandler$prepareArgsAndStartEditor$1", f = "EditFeedActionHandler.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class EditFeedActionHandler$prepareArgsAndStartEditor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PanelContext<Activity, vk1.b> $panelContext;
    int label;
    final /* synthetic */ EditFeedActionHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFeedActionHandler$prepareArgsAndStartEditor$1(PanelContext<Activity, vk1.b> panelContext, EditFeedActionHandler editFeedActionHandler, Continuation<? super EditFeedActionHandler$prepareArgsAndStartEditor$1> continuation) {
        super(2, continuation);
        this.$panelContext = panelContext;
        this.this$0 = editFeedActionHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EditFeedActionHandler editFeedActionHandler, DialogInterface dialogInterface) {
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar;
        Job f16;
        Logger.f235387a.d().i("EditFeedActionHandler", 1, "prepareArgsAndStartEditor cancel edit");
        bVar = editFeedActionHandler.startEditorTask;
        if (bVar != null && (f16 = bVar.f()) != null) {
            f16.cancel(new CancellationException("EditFeedActionHandler,cancel for cancel dialog"));
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new EditFeedActionHandler$prepareArgsAndStartEditor$1(this.$panelContext, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar;
        Job f16;
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
            this.label = 1;
            if (DelayKt.delay(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (!this.$panelContext.h().isFinishing()) {
            bVar = this.this$0.startEditorTask;
            boolean z16 = false;
            if (bVar != null && (f16 = bVar.f()) != null && f16.isActive()) {
                z16 = true;
            }
            if (z16) {
                EditFeedActionHandler editFeedActionHandler = this.this$0;
                Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(this.$panelContext.h(), 2, true);
                final EditFeedActionHandler editFeedActionHandler2 = this.this$0;
                showOnlyLoadingImageDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.a
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        EditFeedActionHandler$prepareArgsAndStartEditor$1.b(EditFeedActionHandler.this, dialogInterface);
                    }
                });
                showOnlyLoadingImageDialog.show();
                editFeedActionHandler.loadDialog = showOnlyLoadingImageDialog;
                Logger.f235387a.d().i("EditFeedActionHandler", 1, "prepareArgsAndStartEditor dialog show");
            }
            return Unit.INSTANCE;
        }
        Logger.f235387a.d().i("EditFeedActionHandler", 1, "prepareArgsAndStartEditor context is finished");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((EditFeedActionHandler$prepareArgsAndStartEditor$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
