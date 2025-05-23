package com.tencent.filament.zplan.scene.gltfViewer;

import com.tencent.zplan.zplantracing.c;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.gltfViewer.GltfViewerScene$eventListener$1$handleEvent$1", f = "GltfViewerScene.kt", i = {0}, l = {58}, m = "invokeSuspend", n = {"gltfPath"}, s = {"L$0"})
/* loaded from: classes6.dex */
final class GltfViewerScene$eventListener$1$handleEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $eventData;
    final /* synthetic */ c $spanContext;
    Object L$0;
    int label;
    final /* synthetic */ GltfViewerScene$eventListener$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GltfViewerScene$eventListener$1$handleEvent$1(GltfViewerScene$eventListener$1 gltfViewerScene$eventListener$1, JSONObject jSONObject, c cVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = gltfViewerScene$eventListener$1;
        this.$eventData = jSONObject;
        this.$spanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new GltfViewerScene$eventListener$1$handleEvent$1(this.this$0, this.$eventData, this.$spanContext, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GltfViewerScene$eventListener$1$handleEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String str;
        Deferred a06;
        List listOf;
        String str2;
        AtomicBoolean atomicBoolean;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                str2 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            JSONObject jSONObject = this.$eventData;
            if (jSONObject == null || (str = jSONObject.optString("gltf_path", "")) == null) {
                str = "";
            }
            a06 = this.this$0.f105960d.a0(this.$spanContext);
            listOf = CollectionsKt__CollectionsJVMKt.listOf(a06);
            this.L$0 = str;
            this.label = 1;
            Object awaitAll = AwaitKt.awaitAll(listOf, this);
            if (awaitAll == coroutine_suspended) {
                return coroutine_suspended;
            }
            str2 = str;
            obj = awaitAll;
        }
        this.this$0.f105960d.e0(this.$spanContext);
        this.this$0.f105960d.f0(this.$spanContext);
        atomicBoolean = this.this$0.f105960d.resReady;
        atomicBoolean.set(true);
        this.this$0.f105960d.d0(this.$spanContext, str2);
        return Unit.INSTANCE;
    }
}
