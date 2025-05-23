package com.tencent.filament.zplan.record;

import com.tencent.ark.ark;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.Resource;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.Pair;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "Lcom/tencent/filament/zplan/avatar/model/b;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.record.FilamentRecordHelper$fetchStickerAnimation$2$faceDeferred$1", f = "FilamentRecordHelper.kt", i = {1}, l = {59, 60}, m = "invokeSuspend", n = {"gltf"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class FilamentRecordHelper$fetchStickerAnimation$2$faceDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Resource, ? extends Resource>>, Object> {
    final /* synthetic */ String $faceName;
    final /* synthetic */ String $faceUrl;
    Object L$0;
    int label;
    final /* synthetic */ FilamentRecordHelper$fetchStickerAnimation$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentRecordHelper$fetchStickerAnimation$2$faceDeferred$1(FilamentRecordHelper$fetchStickerAnimation$2 filamentRecordHelper$fetchStickerAnimation$2, String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filamentRecordHelper$fetchStickerAnimation$2;
        this.$faceUrl = str;
        this.$faceName = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FilamentRecordHelper$fetchStickerAnimation$2$faceDeferred$1(this.this$0, this.$faceUrl, this.$faceName, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Resource, ? extends Resource>> continuation) {
        return ((FilamentRecordHelper$fetchStickerAnimation$2$faceDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Resource resource;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    resource = (Resource) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return new Pair(resource, (Resource) obj);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
            String str = this.$faceUrl;
            String str2 = this.$faceName;
            FilamentUrlTemplate filamentUrlTemplate = this.this$0.$urlTemplate;
            this.label = 1;
            obj = ZPlanAvatarResourceHelper.M(zPlanAvatarResourceHelper, null, str, str2, "gltf", filamentUrlTemplate, false, this, 32, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Resource resource2 = (Resource) obj;
        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper2 = ZPlanAvatarResourceHelper.f105660o;
        String str3 = this.$faceUrl;
        FilamentUrlTemplate filamentUrlTemplate2 = this.this$0.$urlTemplate;
        this.L$0 = resource2;
        this.label = 2;
        Object M = ZPlanAvatarResourceHelper.M(zPlanAvatarResourceHelper2, null, str3, DownloadInfo.spKey_Config, ark.ARKMETADATA_JSON, filamentUrlTemplate2, false, this, 32, null);
        if (M == coroutine_suspended) {
            return coroutine_suspended;
        }
        resource = resource2;
        obj = M;
        return new Pair(resource, (Resource) obj);
    }
}
