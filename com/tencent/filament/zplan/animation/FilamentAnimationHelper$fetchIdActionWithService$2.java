package com.tencent.filament.zplan.animation;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.download.ZPlanAvatarFileDownloadDescriptor;
import com.tencent.filament.zplanservice.download.ZPlanAvatarInterfaceResult;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.animation.FilamentAnimationHelper$fetchIdActionWithService$2", f = "FilamentAnimationHelper.kt", i = {0, 1}, l = {51, 52}, m = "invokeSuspend", n = {"bodyPathDeferred", "faceResult"}, s = {"L$0", "L$0"})
/* loaded from: classes6.dex */
public final class FilamentAnimationHelper$fetchIdActionWithService$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAction>, Object> {
    final /* synthetic */ long $actionId;
    final /* synthetic */ ZPlanAvatarService $avatarService;
    final /* synthetic */ EnumUserGender $gender;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentAnimationHelper$fetchIdActionWithService$2(ZPlanAvatarService zPlanAvatarService, long j3, EnumUserGender enumUserGender, Continuation continuation) {
        super(2, continuation);
        this.$avatarService = zPlanAvatarService;
        this.$actionId = j3;
        this.$gender = enumUserGender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        FilamentAnimationHelper$fetchIdActionWithService$2 filamentAnimationHelper$fetchIdActionWithService$2 = new FilamentAnimationHelper$fetchIdActionWithService$2(this.$avatarService, this.$actionId, this.$gender, completion);
        filamentAnimationHelper$fetchIdActionWithService$2.L$0 = obj;
        return filamentAnimationHelper$fetchIdActionWithService$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAction> continuation) {
        return ((FilamentAnimationHelper$fetchIdActionWithService$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        Deferred async$default2;
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult;
        Object firstOrNull;
        ZPlanAvatarFileDownloadDescriptor zPlanAvatarFileDownloadDescriptor;
        String str;
        Object firstOrNull2;
        ZPlanAvatarFileDownloadDescriptor zPlanAvatarFileDownloadDescriptor2;
        String url;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult2 = (ZPlanAvatarInterfaceResult) obj;
                    String result = zPlanAvatarInterfaceResult.getResult();
                    String result2 = zPlanAvatarInterfaceResult2.getResult();
                    firstOrNull = ArraysKt___ArraysKt.firstOrNull(zPlanAvatarInterfaceResult.getAllFiles());
                    zPlanAvatarFileDownloadDescriptor = (ZPlanAvatarFileDownloadDescriptor) firstOrNull;
                    str = "";
                    if (zPlanAvatarFileDownloadDescriptor != null || (r5 = zPlanAvatarFileDownloadDescriptor.getUrl()) == null) {
                        String str2 = "";
                    }
                    firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(zPlanAvatarInterfaceResult2.getAllFiles());
                    zPlanAvatarFileDownloadDescriptor2 = (ZPlanAvatarFileDownloadDescriptor) firstOrNull2;
                    if (zPlanAvatarFileDownloadDescriptor2 != null && (url = zPlanAvatarFileDownloadDescriptor2.getUrl()) != null) {
                        str = url;
                    }
                    ZPlanAction zPlanAction = new ZPlanAction(result, result2, str2, str);
                    if (!zPlanAvatarInterfaceResult.isDownload() && !zPlanAvatarInterfaceResult2.isDownload()) {
                        z16 = false;
                    }
                    zPlanAction.f(z16);
                    return zPlanAction;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            async$default2 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FilamentAnimationHelper$fetchIdActionWithService$2$facePathDeferred$1(this, null), 3, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FilamentAnimationHelper$fetchIdActionWithService$2$bodyPathDeferred$1(this, null), 3, null);
            this.L$0 = async$default2;
            this.label = 1;
            obj = async$default.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult3 = (ZPlanAvatarInterfaceResult) obj;
        this.L$0 = zPlanAvatarInterfaceResult3;
        this.label = 2;
        Object await = async$default2.await(this);
        if (await == coroutine_suspended) {
            return coroutine_suspended;
        }
        zPlanAvatarInterfaceResult = zPlanAvatarInterfaceResult3;
        obj = await;
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult22 = (ZPlanAvatarInterfaceResult) obj;
        String result3 = zPlanAvatarInterfaceResult.getResult();
        String result22 = zPlanAvatarInterfaceResult22.getResult();
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(zPlanAvatarInterfaceResult.getAllFiles());
        zPlanAvatarFileDownloadDescriptor = (ZPlanAvatarFileDownloadDescriptor) firstOrNull;
        str = "";
        if (zPlanAvatarFileDownloadDescriptor != null) {
        }
        String str22 = "";
        firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(zPlanAvatarInterfaceResult22.getAllFiles());
        zPlanAvatarFileDownloadDescriptor2 = (ZPlanAvatarFileDownloadDescriptor) firstOrNull2;
        if (zPlanAvatarFileDownloadDescriptor2 != null) {
            str = url;
        }
        ZPlanAction zPlanAction2 = new ZPlanAction(result3, result22, str22, str);
        if (!zPlanAvatarInterfaceResult.isDownload()) {
            z16 = false;
        }
        zPlanAction2.f(z16);
        return zPlanAction2;
    }
}
