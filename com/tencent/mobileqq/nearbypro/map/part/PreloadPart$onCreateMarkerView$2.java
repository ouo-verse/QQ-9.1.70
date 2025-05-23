package com.tencent.mobileqq.nearbypro.map.part;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
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

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0003*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.map.part.PreloadPart$onCreateMarkerView$2", f = "PreloadPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
final class PreloadPart$onCreateMarkerView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<View>>, Object> {
    final /* synthetic */ InflateConfig $config;
    int label;
    final /* synthetic */ PreloadPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadPart$onCreateMarkerView$2(InflateConfig inflateConfig, PreloadPart preloadPart, Continuation<? super PreloadPart$onCreateMarkerView$2> continuation) {
        super(2, continuation);
        this.$config = inflateConfig;
        this.this$0 = preloadPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PreloadPart$onCreateMarkerView$2(this.$config, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        View inflate;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                InflateConfig inflateConfig = this.$config;
                PreloadPart preloadPart = this.this$0;
                int preloadCount = inflateConfig.getPreloadCount();
                for (int i3 = 0; i3 < preloadCount; i3++) {
                    LayoutInflater from = LayoutInflater.from(preloadPart.getContext());
                    if (from != null && (inflate = from.inflate(inflateConfig.getInflateId(), (ViewGroup) null)) != null) {
                        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(config.inflateId, null)");
                        arrayList.add(inflate);
                    }
                }
                com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.PreloadPart", "onCreateMarkerView inflateId: " + inflateConfig.getInflateId() + " size:" + arrayList.size() + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
                return arrayList;
            } catch (Throwable th5) {
                com.tencent.mobileqq.nearbypro.base.j.c().d("NBP.PreloadPart", "onCreateMarkerView inflateName: " + this.$config.getInflateName() + " e:" + com.tencent.mobileqq.nearbypro.base.j.c().a(th5));
                return null;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ArrayList<View>> continuation) {
        return ((PreloadPart$onCreateMarkerView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
