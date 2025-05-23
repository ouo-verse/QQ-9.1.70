package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click;

import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.preprocess.WinkMaterialResourceLoader;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s53.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.WinkMemoryAlbumClickDelegator$getMaterialInfo$2$1", f = "WinkMemoryAlbumClickDelegator.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkMemoryAlbumClickDelegator$getMaterialInfo$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $data;
    final /* synthetic */ CancellableContinuation<MetaMaterial> $it;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WinkMemoryAlbumClickDelegator$getMaterialInfo$2$1(a aVar, CancellableContinuation<? super MetaMaterial> cancellableContinuation, Continuation<? super WinkMemoryAlbumClickDelegator$getMaterialInfo$2$1> continuation) {
        super(2, continuation);
        this.$data = aVar;
        this.$it = cancellableContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkMemoryAlbumClickDelegator$getMaterialInfo$2$1(this.$data, this.$it, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            WinkMaterialResourceLoader winkMaterialResourceLoader = WinkMaterialResourceLoader.f325333a;
            String templateID = this.$data.d().getTemplateID();
            MutableLiveData<List<MetaCategory>> h26 = WinkEditorResourceManager.a1().h2();
            Intrinsics.checkNotNullExpressionValue(h26, "getInstance().videoTemplateLiveData");
            this.label = 1;
            obj = winkMaterialResourceLoader.d("MqKuaishanTemplate", templateID, h26, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        MetaMaterial metaMaterial = (MetaMaterial) obj;
        if (metaMaterial == null) {
            ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).fetchEditorResource();
        }
        if (this.$it.isActive()) {
            this.$it.resumeWith(Result.m476constructorimpl(metaMaterial));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkMemoryAlbumClickDelegator$getMaterialInfo$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
