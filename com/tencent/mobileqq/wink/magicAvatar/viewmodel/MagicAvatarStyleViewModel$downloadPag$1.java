package com.tencent.mobileqq.wink.magicAvatar.viewmodel;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.manager.ak;
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
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarStyleViewModel$downloadPag$1", f = "MagicAvatarStyleViewModel.kt", i = {}, l = {51, 55}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicAvatarStyleViewModel$downloadPag$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MetaMaterial $metaMaterial;
    int label;
    final /* synthetic */ MagicAvatarStyleViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarStyleViewModel$downloadPag$1(MetaMaterial metaMaterial, MagicAvatarStyleViewModel magicAvatarStyleViewModel, Continuation<? super MagicAvatarStyleViewModel$downloadPag$1> continuation) {
        super(2, continuation);
        this.$metaMaterial = metaMaterial;
        this.this$0 = magicAvatarStyleViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarStyleViewModel$downloadPag$1(this.$metaMaterial, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableSharedFlow mutableSharedFlow;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            WinkEditorResourceManager a16 = WinkEditorResourceManager.a1();
            Intrinsics.checkNotNullExpressionValue(a16, "getInstance()");
            MetaMaterial metaMaterial = this.$metaMaterial;
            this.label = 1;
            obj = ak.d(a16, metaMaterial, null, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (((Boolean) obj).booleanValue()) {
            String str = WinkEditorResourceManager.a1().m(this.$metaMaterial) + File.separator + com.tencent.mobileqq.wink.editor.c.k0(this.$metaMaterial);
            w53.b.f("MagicAvatarStyleViewModel", "downloadPag path = " + str);
            mutableSharedFlow = this.this$0._path;
            this.label = 2;
            if (mutableSharedFlow.emit(str, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarStyleViewModel$downloadPag$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
