package com.tencent.filament.zplan.scene.multiCartoon;

import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import com.tencent.zplan.zplantracing.b;
import com.tencent.zplan.zplantracing.c;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.multiCartoon.MultiCartoonScene$bootAsync$1", f = "MultiCartoonScene.kt", i = {0}, l = {273}, m = "invokeSuspend", n = {"bootSpan"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class MultiCartoonScene$bootAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $filamatPath;
    final /* synthetic */ c $spanContext;
    Object L$0;
    int label;
    final /* synthetic */ MultiCartoonScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiCartoonScene$bootAsync$1(MultiCartoonScene multiCartoonScene, c cVar, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = multiCartoonScene;
        this.$spanContext = cVar;
        this.$filamatPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new MultiCartoonScene$bootAsync$1(this.this$0, this.$spanContext, this.$filamatPath, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MultiCartoonScene$bootAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        AtomicBoolean atomicBoolean;
        FilamentUrlTemplate filamentUrlTemplate;
        final b bVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                bVar = (b) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            atomicBoolean = this.this$0.booted;
            if (atomicBoolean.get()) {
                return Unit.INSTANCE;
            }
            b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("boot", this.$spanContext);
            ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
            c cVar = this.$spanContext;
            filamentUrlTemplate = this.this$0.urlTemplate;
            this.L$0 = startSpan;
            this.label = 1;
            Object F = zPlanAvatarResourceHelper.F(cVar, filamentUrlTemplate, this);
            if (F == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar = startSpan;
            obj = F;
        }
        final BootResourceModel bootResourceModel = (BootResourceModel) obj;
        com.tencent.filament.zplanservice.util.b.a(new File(this.$filamatPath), new File(FilamentFileUtil.INSTANCE.pathAppend(String.valueOf(bootResourceModel.getShaderDir()), com.tencent.filament.zplanservice.util.c.a(this.$filamatPath))));
        this.this$0.k().d("boot", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.multiCartoon.MultiCartoonScene$bootAsync$1.1
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
                FilamentViewerV2305 viewer;
                AtomicBoolean atomicBoolean2;
                viewer = MultiCartoonScene$bootAsync$1.this.this$0.getViewer();
                if (!(viewer != null ? FilamentViewerV2.boot$default(viewer, bootResourceModel, "", false, false, false, FilamentFeatureUtil.f106409g.K(), false, 64, null) : false)) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a("boot fail");
                    }
                    MultiCartoonScene$bootAsync$1.this.this$0.o(201024, "boot fail");
                    return;
                }
                b bVar3 = bVar;
                if (bVar3 != null) {
                    bVar3.b();
                }
                atomicBoolean2 = MultiCartoonScene$bootAsync$1.this.this$0.booted;
                atomicBoolean2.set(true);
            }
        });
        return Unit.INSTANCE;
    }
}
