package com.tencent.mobileqq.troop.homework.file.view;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.troop.homework.file.vm.TroopTeacherFileVM;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import rs2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.file.view.TroopTeacherFileFragment$onViewCreated$1", f = "TroopTeacherFileFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class TroopTeacherFileFragment$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TroopTeacherFileFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopTeacherFileFragment$onViewCreated$1(TroopTeacherFileFragment troopTeacherFileFragment, Continuation<? super TroopTeacherFileFragment$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = troopTeacherFileFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TroopTeacherFileFragment$onViewCreated$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TroopTeacherFileVM Ah;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Ah = this.this$0.Ah();
            MutableLiveData<rs2.a> obtainUiState = Ah.obtainUiState();
            LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
            final TroopTeacherFileFragment troopTeacherFileFragment = this.this$0;
            final Function1<rs2.a, Unit> function1 = new Function1<rs2.a, Unit>() { // from class: com.tencent.mobileqq.troop.homework.file.view.TroopTeacherFileFragment$onViewCreated$1.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(rs2.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(rs2.a aVar) {
                    ScanningLightView scanningLightView;
                    TroopTeacherFileAdapter troopTeacherFileAdapter;
                    if (aVar instanceof a.FileListUpdate) {
                        scanningLightView = TroopTeacherFileFragment.this.loadingView;
                        TroopTeacherFileAdapter troopTeacherFileAdapter2 = null;
                        if (scanningLightView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                            scanningLightView = null;
                        }
                        scanningLightView.setVisibility(8);
                        a.FileListUpdate fileListUpdate = (a.FileListUpdate) aVar;
                        TroopTeacherFileFragment.this.isFileEnd = fileListUpdate.getIsEnd();
                        if (!fileListUpdate.getIsEnd() || !fileListUpdate.a().isEmpty()) {
                            troopTeacherFileAdapter = TroopTeacherFileFragment.this.adapter;
                            if (troopTeacherFileAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                            } else {
                                troopTeacherFileAdapter2 = troopTeacherFileAdapter;
                            }
                            troopTeacherFileAdapter2.i0(fileListUpdate.a(), fileListUpdate.getIsEnd());
                            return;
                        }
                        TroopTeacherFileFragment.this.Bh();
                    }
                }
            };
            obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.file.view.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj2) {
                    Function1.this.invoke(obj2);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TroopTeacherFileFragment$onViewCreated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
