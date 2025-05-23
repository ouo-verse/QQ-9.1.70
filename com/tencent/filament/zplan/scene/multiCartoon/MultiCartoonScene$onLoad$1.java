package com.tencent.filament.zplan.scene.multiCartoon;

import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.zplan.common.utils.h;
import com.tencent.zplan.zplantracing.c;
import java.util.List;
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
@DebugMetadata(c = "com.tencent.filament.zplan.scene.multiCartoon.MultiCartoonScene$onLoad$1", f = "MultiCartoonScene.kt", i = {0, 0, 0}, l = {115}, m = "invokeSuspend", n = {"resourceConfig", "rightAvatarCharacter", "leftAvatarGltfPath"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes6.dex */
public final class MultiCartoonScene$onLoad$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eventData;
    final /* synthetic */ c $spanContext;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MultiCartoonScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiCartoonScene$onLoad$1(MultiCartoonScene multiCartoonScene, String str, c cVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = multiCartoonScene;
        this.$eventData = str;
        this.$spanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new MultiCartoonScene$onLoad$1(this.this$0, this.$eventData, this.$spanContext, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MultiCartoonScene$onLoad$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred O;
        Deferred V;
        Deferred U;
        List listOf;
        final JSONObject jSONObject;
        final String str;
        final JSONObject jSONObject2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                String str2 = (String) this.L$2;
                JSONObject jSONObject3 = (JSONObject) this.L$1;
                JSONObject jSONObject4 = (JSONObject) this.L$0;
                ResultKt.throwOnFailure(obj);
                str = str2;
                jSONObject2 = jSONObject3;
                jSONObject = jSONObject4;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            JSONObject b16 = h.f385294a.b(this.$eventData);
            if (b16 != null) {
                JSONObject optJSONObject = b16.optJSONObject("rightAvatarCharacter");
                if (optJSONObject != null) {
                    String configPath = b16.optString("configPath");
                    String filamatPath = b16.optString("filamatPath");
                    String optString = b16.optString("leftAvatarGltfPath");
                    MultiCartoonScene multiCartoonScene = this.this$0;
                    c cVar = this.$spanContext;
                    Intrinsics.checkNotNullExpressionValue(filamatPath, "filamatPath");
                    O = multiCartoonScene.O(cVar, filamatPath);
                    V = this.this$0.V(this.$spanContext, optJSONObject);
                    MultiCartoonScene multiCartoonScene2 = this.this$0;
                    c cVar2 = this.$spanContext;
                    Intrinsics.checkNotNullExpressionValue(configPath, "configPath");
                    U = multiCartoonScene2.U(cVar2, configPath);
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Deferred[]{O, V, U});
                    this.L$0 = b16;
                    this.L$1 = optJSONObject;
                    this.L$2 = optString;
                    this.label = 1;
                    obj = AwaitKt.awaitAll(listOf, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    jSONObject = b16;
                    str = optString;
                    jSONObject2 = optJSONObject;
                } else {
                    return Unit.INSTANCE;
                }
            } else {
                return Unit.INSTANCE;
            }
        }
        List list = (List) obj;
        if (list.size() != 3) {
            return Unit.INSTANCE;
        }
        final Object obj2 = list.get(1);
        if (!(obj2 instanceof ReloadAvatarResourceModel)) {
            return Unit.INSTANCE;
        }
        Object obj3 = list.get(2);
        if (obj3 instanceof JSONObject) {
            this.this$0.attachments = ((JSONObject) obj3).optJSONObject("attachments");
            this.this$0.k().d("configRenderObjects", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.multiCartoon.MultiCartoonScene$onLoad$1$invokeSuspend$$inlined$apply$lambda$1
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
                    MultiCartoonScene$onLoad$1 multiCartoonScene$onLoad$1 = this;
                    MultiCartoonScene multiCartoonScene3 = multiCartoonScene$onLoad$1.this$0;
                    c cVar3 = multiCartoonScene$onLoad$1.$spanContext;
                    String leftAvatarGltfPath = str;
                    Intrinsics.checkNotNullExpressionValue(leftAvatarGltfPath, "leftAvatarGltfPath");
                    multiCartoonScene3.P(cVar3, leftAvatarGltfPath, (ReloadAvatarResourceModel) obj2, jSONObject2, jSONObject);
                }
            });
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
