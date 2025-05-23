package com.tencent.mobileqq.guild.share;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.tencent.mobileqq.guild.discoveryv2.share.oldpicture.GuildSearchLLMChatPictureOldGenerator;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.share.ShareScreenshot$startShare$1", f = "ShareScreenshot.kt", i = {0}, l = {82}, m = "invokeSuspend", n = {"dialog"}, s = {"L$0"})
/* loaded from: classes14.dex */
public final class ShareScreenshot$startShare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GuildSearchLLMChatPictureOldGenerator.GeneratorParam $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ShareScreenshot this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareScreenshot$startShare$1(ShareScreenshot shareScreenshot, GuildSearchLLMChatPictureOldGenerator.GeneratorParam generatorParam, Continuation<? super ShareScreenshot$startShare$1> continuation) {
        super(2, continuation);
        this.this$0 = shareScreenshot;
        this.$params = generatorParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ShareScreenshot shareScreenshot, DialogInterface dialogInterface) {
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar;
        Job f16;
        Logger.f235387a.d().i("ShareScreenshot", 1, "cancel share");
        bVar = shareScreenshot.task;
        if (bVar != null && (f16 = bVar.f()) != null) {
            f16.cancel(new CancellationException("ShareScreenshot,cancel for generate picture by cancel dialog"));
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ShareScreenshot$startShare$1 shareScreenshot$startShare$1 = new ShareScreenshot$startShare$1(this.this$0, this.$params, continuation);
        shareScreenshot$startShare$1.L$0 = obj;
        return shareScreenshot$startShare$1;
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
        Object i3;
        ShareScreenshot shareScreenshot;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        try {
            if (i16 != 0) {
                if (i16 == 1) {
                    shareScreenshot = (ShareScreenshot) this.L$1;
                    ?? r17 = (Dialog) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    i16 = r17;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                ?? showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(this.this$0.com.tencent.qqlive.module.videoreport.constants.EventKey.ACT java.lang.String, 2, true);
                final ShareScreenshot shareScreenshot2 = this.this$0;
                showOnlyLoadingImageDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.guild.share.ad
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        ShareScreenshot$startShare$1.b(ShareScreenshot.this, dialogInterface);
                    }
                });
                showOnlyLoadingImageDialog.show();
                ShareScreenshot shareScreenshot3 = this.this$0;
                GuildSearchLLMChatPictureOldGenerator.GeneratorParam generatorParam = this.$params;
                Result.Companion companion = Result.INSTANCE;
                this.L$0 = showOnlyLoadingImageDialog;
                this.L$1 = shareScreenshot3;
                this.label = 1;
                i3 = shareScreenshot3.i(generatorParam, this);
                if (i3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                shareScreenshot = shareScreenshot3;
                obj = i3;
                i16 = showOnlyLoadingImageDialog;
            }
            Logger.f235387a.d().i("ShareScreenshot", 1, "assemble img success");
            shareScreenshot.o(shareScreenshot.com.tencent.qqlive.module.videoreport.constants.EventKey.ACT java.lang.String, (Bitmap) obj);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            r16 = i16;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            r16 = i16;
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
        return ((ShareScreenshot$startShare$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
