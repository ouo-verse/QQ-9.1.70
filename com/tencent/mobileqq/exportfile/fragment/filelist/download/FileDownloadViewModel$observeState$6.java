package com.tencent.mobileqq.exportfile.fragment.filelist.download;

import com.tencent.mobileqq.exportfile.fragment.filelist.download.data.a;
import com.tencent.mobileqq.exportfile.fragment.filelist.t;
import com.tencent.mobileqq.exportfile.global.p;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/exportfile/global/p;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadViewModel$observeState$6", f = "FileDownloadViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class FileDownloadViewModel$observeState$6 extends SuspendLambda implements Function2<p, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FileDownloadViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileDownloadViewModel$observeState$6(FileDownloadViewModel fileDownloadViewModel, Continuation<? super FileDownloadViewModel$observeState$6> continuation) {
        super(2, continuation);
        this.this$0 = fileDownloadViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fileDownloadViewModel, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        FileDownloadViewModel$observeState$6 fileDownloadViewModel$observeState$6 = new FileDownloadViewModel$observeState$6(this.this$0, continuation);
        fileDownloadViewModel$observeState$6.L$0 = obj;
        return fileDownloadViewModel$observeState$6;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull p pVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((FileDownloadViewModel$observeState$6) create(pVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) pVar, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                p pVar = (p) this.L$0;
                QLog.d("FileListViewModel", 1, "observeState createDownloadProgressFlow completedSize: " + pVar.a() + ", totalSize: " + pVar.c());
                if (pVar.c() > 0) {
                    i3 = (int) ((pVar.a() * 100) / pVar.c());
                    str = "\u4e0b\u8f7d\u4e2d...(" + t.b(pVar.a(), FileDownloadViewModel$observeState$6$curSizeStr$1.INSTANCE) + "/" + t.b(pVar.c(), FileDownloadViewModel$observeState$6$totalSizeStr$1.INSTANCE) + ")";
                } else {
                    str = "\u4e0b\u8f7d\u4e2d...(0KB/0KB)";
                    i3 = 0;
                }
                this.this$0.obtainUiState().setValue(new a.b(pVar.b(), Math.min(Math.max(0, i3), 100), str));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
