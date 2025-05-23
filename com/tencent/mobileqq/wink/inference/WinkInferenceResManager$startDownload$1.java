package com.tencent.mobileqq.wink.inference;

import com.tencent.mobileqq.wink.inference.WinkInferenceResManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.inference.WinkInferenceResManager$startDownload$1", f = "WinkInferenceResManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkInferenceResManager$startDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WinkInferenceResManager$startDownload$1(Continuation<? super WinkInferenceResManager$startDownload$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkInferenceResManager$startDownload$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        File file;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                WinkInferenceResManager winkInferenceResManager = WinkInferenceResManager.f322940a;
                winkInferenceResManager.G();
                file = WinkInferenceResManager.lockFile;
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                FileChannel channel = fileOutputStream.getChannel();
                Intrinsics.checkNotNullExpressionValue(channel, "fileOutputStream.channel");
                WinkInferenceResManager.fileLock = channel.lock();
                String str = (String) WinkInferenceResManager.downloadQueue.poll();
                if (str != null) {
                    winkInferenceResManager.u(str, fileOutputStream);
                }
            } catch (Exception e16) {
                QLog.e("WinkInferenceResManager", 1, "Failed to acquire file lock", e16);
                WinkInferenceResManager.L(WinkInferenceResManager.f322940a, WinkInferenceResManager.Error.FILE_LOCK_ERROR, null, 2, null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkInferenceResManager$startDownload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
