package com.tencent.mobileqq.exportfile.fragment.filelist;

import com.tencent.mobileqq.exportfile.global.QFileBridgeService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetPageContentCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.exportfile.fragment.filelist.FileListRepository$getFileListRecords$2", f = "FileListRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class FileListRepository$getFileListRecords$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function2<Integer, List<com.tencent.mobileqq.exportfile.fragment.filelist.data.c>, Unit> $callback;
    final /* synthetic */ String $fileId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileListRepository$getFileListRecords$2(String str, Function2<? super Integer, ? super List<com.tencent.mobileqq.exportfile.fragment.filelist.data.c>, Unit> function2, Continuation<? super FileListRepository$getFileListRecords$2> continuation) {
        super(2, continuation);
        this.$fileId = str;
        this.$callback = function2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, function2, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function2 function2, int i3, ArrayList arrayList) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new FileListRepository$getFileListRecords$2$1$1(function2, i3, arrayList, null), 3, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new FileListRepository$getFileListRecords$2(this.$fileId, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                com.tencent.qqnt.kernel.api.p A = QFileBridgeService.f205517a.A();
                if (A != null) {
                    String str = this.$fileId;
                    final Function2<Integer, List<com.tencent.mobileqq.exportfile.fragment.filelist.data.c>, Unit> function2 = this.$callback;
                    A.getPageContent(false, str, new IKernelGetPageContentCallback() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.q
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetPageContentCallback
                        public final void onResult(int i3, ArrayList arrayList) {
                            FileListRepository$getFileListRecords$2.b(Function2.this, i3, arrayList);
                        }
                    });
                    return Unit.INSTANCE;
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((FileListRepository$getFileListRecords$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
