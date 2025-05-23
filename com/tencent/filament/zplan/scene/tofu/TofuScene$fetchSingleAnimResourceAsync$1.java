package com.tencent.filament.zplan.scene.tofu;

import android.text.TextUtils;
import com.tencent.filament.zplan.scene.couple.config.AvatarConfig;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/filament/zplan/scene/couple/config/a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.tofu.TofuScene$fetchSingleAnimResourceAsync$1", f = "TofuScene.kt", i = {}, l = {314}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class TofuScene$fetchSingleAnimResourceAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AvatarConfig>, Object> {
    final /* synthetic */ String $bodyAnimation;
    final /* synthetic */ String $headAnimation;
    final /* synthetic */ c $spanContext;
    int label;
    final /* synthetic */ TofuScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TofuScene$fetchSingleAnimResourceAsync$1(TofuScene tofuScene, String str, String str2, c cVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = tofuScene;
        this.$headAnimation = str;
        this.$bodyAnimation = str2;
        this.$spanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new TofuScene$fetchSingleAnimResourceAsync$1(this.this$0, this.$headAnimation, this.$bodyAnimation, this.$spanContext, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AvatarConfig> continuation) {
        return ((TofuScene$fetchSingleAnimResourceAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FilamentUrlTemplate filamentUrlTemplate;
        String replace$default;
        String replace$default2;
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
            filamentUrlTemplate = this.this$0.urlTemplate;
            String animPathUrl = filamentUrlTemplate.getAnimPathUrl();
            if (!TextUtils.isEmpty(animPathUrl)) {
                replace$default = StringsKt__StringsJVMKt.replace$default(animPathUrl, "{action_path}", this.$headAnimation, false, 4, (Object) null);
                replace$default2 = StringsKt__StringsJVMKt.replace$default(animPathUrl, "{action_path}", this.$bodyAnimation, false, 4, (Object) null);
                TofuScene tofuScene = this.this$0;
                c cVar = this.$spanContext;
                this.label = 1;
                obj = tofuScene.d0(cVar, replace$default, replace$default2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw new RuntimeException("fetchActionWithPath, animTemplate is empty");
            }
        }
        return obj;
    }
}
