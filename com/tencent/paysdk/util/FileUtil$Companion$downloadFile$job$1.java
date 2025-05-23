package com.tencent.paysdk.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.paysdk.util.FileUtil;
import java.io.File;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.paysdk.util.FileUtil$Companion$downloadFile$job$1", f = "FileUtil.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes22.dex */
public final class FileUtil$Companion$downloadFile$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $destFilePath;
    final /* synthetic */ FileUtil.a $listener;
    final /* synthetic */ String $urlPath;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileUtil$Companion$downloadFile$job$1(String str, String str2, FileUtil.a aVar, Continuation continuation) {
        super(2, continuation);
        this.$urlPath = str;
        this.$destFilePath = str2;
        this.$listener = aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, aVar, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) completion);
        }
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FileUtil$Companion$downloadFile$job$1(this.$urlPath, this.$destFilePath, this.$listener, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
        return ((FileUtil$Companion$downloadFile$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.paysdk.log.c.b("FileUtil", "downloadFile urlPath=" + this.$urlPath + " destFilePath=" + this.$destFilePath);
                    FileUtil.Companion companion = FileUtil.INSTANCE;
                    String str = this.$urlPath;
                    String str2 = this.$destFilePath;
                    this.label = 1;
                    obj = companion.a(str, str2, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                File file = (File) obj;
                if (file != null && file.exists()) {
                    this.$listener.a(file);
                } else {
                    this.$listener.onFailed(-1, "file not exist! urlPath=" + this.$urlPath);
                }
            } catch (Exception e16) {
                this.$listener.onFailed(-2, e16.getMessage());
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 1, (Object) this, obj);
    }
}
