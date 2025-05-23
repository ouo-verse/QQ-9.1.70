package com.tencent.filament.light.camera;

import com.tencent.filament.zplanservice.download.ZPlanAvatarInterfaceResult;
import com.tencent.filament.zplanservice.util.log.FLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.light.camera.ZPlanFilamentRequestManager$fetchParticle$2", f = "ZPlanFilamentRequestManager.kt", i = {0, 1}, l = {313, 331}, m = "invokeSuspend", n = {"$this$coroutineScope", "bootResource"}, s = {"L$0", "L$0"})
/* loaded from: classes2.dex */
public final class ZPlanFilamentRequestManager$fetchParticle$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ JSONObject $avatarInfo;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanFilamentRequestManager$fetchParticle$2(JSONObject jSONObject, Continuation continuation) {
        super(2, continuation);
        this.$avatarInfo = jSONObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        ZPlanFilamentRequestManager$fetchParticle$2 zPlanFilamentRequestManager$fetchParticle$2 = new ZPlanFilamentRequestManager$fetchParticle$2(this.$avatarInfo, completion);
        zPlanFilamentRequestManager$fetchParticle$2.L$0 = obj;
        return zPlanFilamentRequestManager$fetchParticle$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((ZPlanFilamentRequestManager$fetchParticle$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0085  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        Deferred async$default;
        CoroutineScope coroutineScope2;
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult;
        Deferred async$default2;
        ZPlanAvatarInterfaceResult zPlanAvatarInterfaceResult2;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    zPlanAvatarInterfaceResult2 = (ZPlanAvatarInterfaceResult) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (((ZPlanAvatarInterfaceResult) obj) != null) {
                        return zPlanAvatarInterfaceResult2.getResult();
                    }
                    return "";
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ZPlanFilamentRequestManager$fetchParticle$2$particleCachePathDeferred$1(null), 3, null);
            if (async$default != null) {
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = async$default.await(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                coroutineScope2 = coroutineScope;
                zPlanAvatarInterfaceResult = null;
                if (zPlanAvatarInterfaceResult == null) {
                    async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope2, null, null, new ZPlanFilamentRequestManager$fetchParticle$2$particleResourceDeferred$1(this, null), 3, null);
                    if (async$default2 != null) {
                        this.L$0 = zPlanAvatarInterfaceResult;
                        this.label = 2;
                        Object await = async$default2.await(this);
                        if (await == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        zPlanAvatarInterfaceResult2 = zPlanAvatarInterfaceResult;
                        obj = await;
                        if (((ZPlanAvatarInterfaceResult) obj) != null) {
                        }
                    }
                    return "";
                }
                FLog fLog = FLog.INSTANCE;
                ZPlanFilamentRequestManager zPlanFilamentRequestManager = ZPlanFilamentRequestManager.INSTANCE;
                str = ZPlanFilamentRequestManager.TAG;
                fLog.e(str, "fetch particle cache path failed");
                return "";
            }
        }
        zPlanAvatarInterfaceResult = (ZPlanAvatarInterfaceResult) obj;
        coroutineScope2 = coroutineScope;
        if (zPlanAvatarInterfaceResult == null) {
        }
    }
}
