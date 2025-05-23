package com.tencent.filament.zplan.scene.tofu;

import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.scene.couple.config.AvatarConfig;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.common.utils.h;
import com.tencent.zplan.zplantracing.c;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.tofu.TofuScene$loadScene$1", f = "TofuScene.kt", i = {0}, l = {162}, m = "invokeSuspend", n = {"avatarCharacter"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class TofuScene$loadScene$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eventData;
    final /* synthetic */ c $spanContext;
    Object L$0;
    int label;
    final /* synthetic */ TofuScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TofuScene$loadScene$1(TofuScene tofuScene, String str, c cVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = tofuScene;
        this.$eventData = str;
        this.$spanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new TofuScene$loadScene$1(this.this$0, this.$eventData, this.$spanContext, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TofuScene$loadScene$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        AtomicBoolean atomicBoolean;
        Deferred e06;
        Deferred f06;
        Deferred g06;
        List listOf;
        final JSONObject jSONObject;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                JSONObject jSONObject2 = (JSONObject) this.L$0;
                ResultKt.throwOnFailure(obj);
                jSONObject = jSONObject2;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.this$0.hasDownloadFromNet = false;
            this.this$0.hasPaused = false;
            JSONObject b16 = h.f385294a.b(this.$eventData);
            if (b16 != null) {
                JSONObject optJSONObject = b16.optJSONObject("avatarCharacter");
                if (optJSONObject != null) {
                    String optString = b16.optString("headAnimPath");
                    if (optString != null) {
                        String optString2 = b16.optString("bodyAnimPath");
                        if (optString2 != null) {
                            this.this$0.animationGapTime = b16.optLong("animationGapTime", 3000L);
                            String bodyTypeName = b16.optString("bodyTypeName", "BodyType40");
                            atomicBoolean = this.this$0.needRecordFrame;
                            atomicBoolean.set(b16.optBoolean("needRecordFrame", true));
                            TofuScene tofuScene = this.this$0;
                            c cVar = this.$spanContext;
                            Intrinsics.checkNotNullExpressionValue(bodyTypeName, "bodyTypeName");
                            e06 = tofuScene.e0(cVar, bodyTypeName);
                            f06 = this.this$0.f0(this.$spanContext, optJSONObject);
                            g06 = this.this$0.g0(this.$spanContext, optString, optString2);
                            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Deferred[]{e06, f06, g06});
                            this.L$0 = optJSONObject;
                            this.label = 1;
                            obj = AwaitKt.awaitAll(listOf, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            jSONObject = optJSONObject;
                        } else {
                            throw new IllegalArgumentException("bodyAnimPathEmpty");
                        }
                    } else {
                        throw new IllegalArgumentException("headAnimPathEmpty");
                    }
                } else {
                    throw new IllegalArgumentException("avatarCharacter is null");
                }
            } else {
                throw new IllegalArgumentException("eventData parse fail");
            }
        }
        List list = (List) obj;
        if (list.size() == 3) {
            final Object obj2 = list.get(0);
            if (obj2 instanceof BootResourceModel) {
                final Object obj3 = list.get(1);
                if (obj3 instanceof ReloadAvatarResourceModel) {
                    final Object obj4 = list.get(2);
                    if (obj4 instanceof AvatarConfig) {
                        this.this$0.k().d("configRenderObjects", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.tofu.TofuScene$loadScene$1$invokeSuspend$$inlined$apply$lambda$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                try {
                                    TofuScene$loadScene$1 tofuScene$loadScene$1 = this;
                                    tofuScene$loadScene$1.this$0.a0(tofuScene$loadScene$1.$spanContext, (BootResourceModel) obj2, (ReloadAvatarResourceModel) obj3, jSONObject, (AvatarConfig) obj4);
                                } catch (Throwable th5) {
                                    FLog.INSTANCE.e("TofuScene", "configRenderObjects failed, t:" + th5);
                                    this.this$0.h0(th5);
                                }
                            }
                        });
                        return Unit.INSTANCE;
                    }
                    throw new IllegalArgumentException("thirdParam isn't AvatarConfig");
                }
                throw new IllegalArgumentException("secondParam isn't ReloadAvatarResourceModel");
            }
            throw new IllegalArgumentException("firstParam isn't BootResourceModel");
        }
        throw new IllegalArgumentException("defer count is mismatched");
    }
}
