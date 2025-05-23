package com.tencent.mobileqq.guild.share;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator;
import com.tencent.mobileqq.guild.share.GuildLLMChatShareScreenshot;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.share.GuildLLMChatShareScreenshot$startShare$1", f = "GuildLLMChatShareScreenshot.kt", i = {0}, l = {78}, m = "invokeSuspend", n = {"dialog"}, s = {"L$0"})
/* loaded from: classes14.dex */
public final class GuildLLMChatShareScreenshot$startShare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GuildLLMChatShareScreenshot this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildLLMChatShareScreenshot$startShare$1(GuildLLMChatShareScreenshot guildLLMChatShareScreenshot, Continuation<? super GuildLLMChatShareScreenshot$startShare$1> continuation) {
        super(2, continuation);
        this.this$0 = guildLLMChatShareScreenshot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildLLMChatShareScreenshot guildLLMChatShareScreenshot, DialogInterface dialogInterface) {
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar;
        Job f16;
        Logger.f235387a.d().i("ShareScreenshot", 1, "cancel share");
        bVar = guildLLMChatShareScreenshot.task;
        if (bVar != null && (f16 = bVar.f()) != null) {
            f16.cancel(new CancellationException("ShareScreenshot,cancel for generate picture by cancel dialog"));
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildLLMChatShareScreenshot$startShare$1 guildLLMChatShareScreenshot$startShare$1 = new GuildLLMChatShareScreenshot$startShare$1(this.this$0, continuation);
        guildLLMChatShareScreenshot$startShare$1.L$0 = obj;
        return guildLLMChatShareScreenshot$startShare$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.app.Dialog] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.app.Dialog, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.app.Dialog] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object m476constructorimpl;
        ?? r16;
        Activity activity;
        Activity activity2;
        Object b16;
        GuildLLMChatShareScreenshot guildLLMChatShareScreenshot;
        Activity activity3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    guildLLMChatShareScreenshot = (GuildLLMChatShareScreenshot) this.L$1;
                    ?? r17 = (Dialog) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    i3 = r17;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                activity = this.this$0.mActivity;
                ?? showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(activity, 2, true);
                final GuildLLMChatShareScreenshot guildLLMChatShareScreenshot2 = this.this$0;
                showOnlyLoadingImageDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.guild.share.f
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        GuildLLMChatShareScreenshot$startShare$1.b(GuildLLMChatShareScreenshot.this, dialogInterface);
                    }
                });
                showOnlyLoadingImageDialog.show();
                GuildLLMChatShareScreenshot guildLLMChatShareScreenshot3 = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                GuildLLMChatShareScreenshot.Companion companion2 = GuildLLMChatShareScreenshot.INSTANCE;
                GuildSearchLLMChatPictureGenerator.GeneratorParam generatorParam = guildLLMChatShareScreenshot3.mPictureOriginParams;
                activity2 = guildLLMChatShareScreenshot3.mActivity;
                this.L$0 = showOnlyLoadingImageDialog;
                this.L$1 = guildLLMChatShareScreenshot3;
                this.label = 1;
                b16 = companion2.b(generatorParam, activity2, this);
                if (b16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                guildLLMChatShareScreenshot = guildLLMChatShareScreenshot3;
                obj = b16;
                i3 = showOnlyLoadingImageDialog;
            }
            Logger.f235387a.d().i("ShareScreenshot", 1, "assemble img success");
            activity3 = guildLLMChatShareScreenshot.mActivity;
            guildLLMChatShareScreenshot.l(activity3, (Bitmap) obj);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            r16 = i3;
        } catch (Throwable th5) {
            Result.Companion companion3 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            r16 = i3;
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("generate failed");
            Iterator it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("ShareScreenshot", 1, (String) it.next(), m479exceptionOrNullimpl);
            }
            if (!(m479exceptionOrNullimpl instanceof CancellationException)) {
                QQToastUtil.showQQToast(1, "\u751f\u6210\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
            }
        }
        r16.dismiss();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildLLMChatShareScreenshot$startShare$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
