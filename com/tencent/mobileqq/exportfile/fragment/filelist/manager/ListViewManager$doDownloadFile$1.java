package com.tencent.mobileqq.exportfile.fragment.filelist.manager;

import com.tencent.mobileqq.exportfile.global.QFileBridgeService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.p;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeDownloadState;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
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
@DebugMetadata(c = "com.tencent.mobileqq.exportfile.fragment.filelist.manager.ListViewManager$doDownloadFile$1", f = "ListViewManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class ListViewManager$doDownloadFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $fileId;
    final /* synthetic */ CoroutineScope $scope;
    int label;
    final /* synthetic */ ListViewManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListViewManager$doDownloadFile$1(String str, CoroutineScope coroutineScope, ListViewManager listViewManager, Continuation<? super ListViewManager$doDownloadFile$1> continuation) {
        super(2, continuation);
        this.$fileId = str;
        this.$scope = coroutineScope;
        this.this$0 = listViewManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, coroutineScope, listViewManager, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CoroutineScope coroutineScope, ListViewManager listViewManager, String str, int i3, String str2) {
        FileBridgeDownloadState fileBridgeDownloadState;
        QLog.d("ListViewManager", 1, "showMobileConnTips errCode: " + i3 + ", msg: " + str2);
        if (i3 == 0) {
            fileBridgeDownloadState = FileBridgeDownloadState.KWAITING;
        } else {
            fileBridgeDownloadState = FileBridgeDownloadState.KFAILED;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new ListViewManager$doDownloadFile$1$1$1(listViewManager, str, fileBridgeDownloadState, null), 2, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new ListViewManager$doDownloadFile$1(this.$fileId, this.$scope, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                p A = QFileBridgeService.f205517a.A();
                if (A != null) {
                    final String str = this.$fileId;
                    final CoroutineScope coroutineScope = this.$scope;
                    final ListViewManager listViewManager = this.this$0;
                    A.getFile(str, new IOperateCallback() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.manager.a
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i3, String str2) {
                            ListViewManager$doDownloadFile$1.b(CoroutineScope.this, listViewManager, str, i3, str2);
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((ListViewManager$doDownloadFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
