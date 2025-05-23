package com.tencent.filament.zplan.avatar;

import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.avatar.model.Resource;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2$fetchShaderJob$1", f = "ZPlanAvatarResourceHelper.kt", i = {}, l = {865}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2$fetchShaderJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.zplan.zplantracing.b $fetchSplitShaderWithSpan;
    final /* synthetic */ String $filamatName;
    final /* synthetic */ String $filamatUrl;
    int label;
    final /* synthetic */ ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2$fetchShaderJob$1(ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2 zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2, com.tencent.zplan.zplantracing.b bVar, String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2;
        this.$fetchSplitShaderWithSpan = bVar;
        this.$filamatUrl = str;
        this.$filamatName = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2$fetchShaderJob$1(this.this$0, this.$fetchSplitShaderWithSpan, this.$filamatUrl, this.$filamatName, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2$fetchShaderJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.zplan.zplantracing.c cVar;
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
            ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
            com.tencent.zplan.zplantracing.b bVar = this.$fetchSplitShaderWithSpan;
            if (bVar != null) {
                cVar = bVar.c();
            } else {
                cVar = null;
            }
            String str = this.$filamatUrl;
            FilamentUrlTemplate filamentUrlTemplate = this.this$0.$urlTemplate;
            this.label = 1;
            obj = ZPlanAvatarResourceHelper.h0(zPlanAvatarResourceHelper, cVar, str, filamentUrlTemplate, false, this, 8, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        String pathAppend = FilamentFileUtil.INSTANCE.pathAppend(((Resource) obj).e(), this.$filamatName);
        File file = new File(pathAppend);
        if (file.exists() && file.length() == 0) {
            FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchSplitShaderWithGltf fail. file is empty. filePath:" + pathAppend + ", gltfPath:" + this.this$0.$gltfPath + ", url:" + this.$filamatUrl);
            com.tencent.zplan.zplantracing.b bVar2 = this.$fetchSplitShaderWithSpan;
            if (bVar2 != null) {
                bVar2.a("file is empty. filePath:" + pathAppend + ", gltfPath:" + this.this$0.$gltfPath);
            }
            throw new FetchFileException(FetchFileException.Type.FILE_IS_EMPTY, 201022, "file is empty. filePath:" + pathAppend, this.$filamatUrl);
        }
        return Unit.INSTANCE;
    }
}
