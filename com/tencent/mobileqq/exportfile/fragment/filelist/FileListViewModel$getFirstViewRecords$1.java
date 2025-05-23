package com.tencent.mobileqq.exportfile.fragment.filelist;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.exportfile.fragment.filelist.data.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.exportfile.fragment.filelist.FileListViewModel$getFirstViewRecords$1", f = "FileListViewModel.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class FileListViewModel$getFirstViewRecords$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $fileId;
    int label;
    final /* synthetic */ FileListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileListViewModel$getFirstViewRecords$1(FileListViewModel fileListViewModel, String str, Continuation<? super FileListViewModel$getFirstViewRecords$1> continuation) {
        super(2, continuation);
        this.this$0 = fileListViewModel;
        this.$fileId = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, fileListViewModel, str, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new FileListViewModel$getFirstViewRecords$1(this.this$0, this.$fileId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FileListRepository d26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
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
                d26 = this.this$0.d2();
                String str = this.$fileId;
                Function2<Integer, List<? extends com.tencent.mobileqq.exportfile.fragment.filelist.data.c>, Unit> function2 = new Function2<Integer, List<? extends com.tencent.mobileqq.exportfile.fragment.filelist.data.c>, Unit>() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.FileListViewModel$getFirstViewRecords$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(2);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FileListViewModel.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, List<? extends com.tencent.mobileqq.exportfile.fragment.filelist.data.c> list) {
                        invoke(num.intValue(), (List<com.tencent.mobileqq.exportfile.fragment.filelist.data.c>) list);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i16, @NotNull List<com.tencent.mobileqq.exportfile.fragment.filelist.data.c> recordList) {
                        MutableLiveData mUiState;
                        MutableLiveData mUiState2;
                        MutableLiveData mUiState3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, i16, (Object) recordList);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(recordList, "recordList");
                        if (i16 != 0) {
                            mUiState3 = FileListViewModel.this.getMUiState();
                            mUiState3.setValue(a.g.f205421a);
                        } else if (recordList.isEmpty()) {
                            FileListViewModel.this.S1(new ArrayList());
                            mUiState2 = FileListViewModel.this.getMUiState();
                            mUiState2.setValue(new a.e(new ArrayList()));
                        } else {
                            FileListViewModel.this.S1(recordList);
                            mUiState = FileListViewModel.this.getMUiState();
                            mUiState.setValue(new a.e(recordList));
                        }
                    }
                };
                this.label = 1;
                if (FileListRepository.b(d26, str, null, function2, this, 2, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((FileListViewModel$getFirstViewRecords$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
