package com.tencent.mobileqq.exportfile.fragment;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.exportfile.global.QFileBridgeService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IKernelQueryUncompleteDownloadRecordsCallback;
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
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.exportfile.fragment.DialogHelperKt$checkUnCompletedTask$1", f = "DialogHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class DialogHelperKt$checkUnCompletedTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ Fragment $this_checkUnCompletedTask;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogHelperKt$checkUnCompletedTask$1(CoroutineScope coroutineScope, Fragment fragment, Continuation<? super DialogHelperKt$checkUnCompletedTask$1> continuation) {
        super(2, continuation);
        this.$scope = coroutineScope;
        this.$this_checkUnCompletedTask = fragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, coroutineScope, fragment, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CoroutineScope coroutineScope, Fragment fragment, int i3, boolean z16, byte[] bArr) {
        QLog.d("DialogHelper", 1, "checkUnCompletedTask queryUncompleteDownloadRecords result: " + i3 + ", has: " + z16);
        if (i3 == 0 && z16) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new DialogHelperKt$checkUnCompletedTask$1$1$1(fragment, bArr, null), 2, null);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new DialogHelperKt$checkUnCompletedTask$1(this.$scope, this.$this_checkUnCompletedTask, continuation);
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
                    final CoroutineScope coroutineScope = this.$scope;
                    final Fragment fragment = this.$this_checkUnCompletedTask;
                    A.queryUncompleteDownloadRecords(new IKernelQueryUncompleteDownloadRecordsCallback() { // from class: com.tencent.mobileqq.exportfile.fragment.i
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelQueryUncompleteDownloadRecordsCallback
                        public final void onResult(int i3, boolean z16, byte[] bArr) {
                            DialogHelperKt$checkUnCompletedTask$1.b(CoroutineScope.this, fragment, i3, z16, bArr);
                        }
                    });
                }
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((DialogHelperKt$checkUnCompletedTask$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
