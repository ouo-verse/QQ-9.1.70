package com.tencent.mobileqq.vas.adv.kuikly.cardad;

import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.vas.adv.kuikly.cardad.VasKuiklyCardAdManager$asyncRequestKuiklyCardAd$2", f = "VasKuiklyCardAdManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes20.dex */
public final class VasKuiklyCardAdManager$asyncRequestKuiklyCardAd$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enableShowMask;
    final /* synthetic */ List<String> $posIds;
    final /* synthetic */ String $sourceFrom;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasKuiklyCardAdManager$asyncRequestKuiklyCardAd$2(List<String> list, boolean z16, String str, Continuation<? super VasKuiklyCardAdManager$asyncRequestKuiklyCardAd$2> continuation) {
        super(2, continuation);
        this.$posIds = list;
        this.$enableShowMask = z16;
        this.$sourceFrom = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VasKuiklyCardAdManager$asyncRequestKuiklyCardAd$2(this.$posIds, this.$enableShowMask, this.$sourceFrom, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        VasAdCallback f16;
        List listOf;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<String> list = this.$posIds;
            boolean z16 = this.$enableShowMask;
            String str = this.$sourceFrom;
            int i3 = 0;
            for (Object obj2 : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                String str2 = (String) obj2;
                VasKuiklyCardAdManager vasKuiklyCardAdManager = VasKuiklyCardAdManager.f308031a;
                f16 = vasKuiklyCardAdManager.f(i3, str2);
                listOf = CollectionsKt__CollectionsJVMKt.listOf("");
                vasKuiklyCardAdManager.q(f16, new VasKuiklyCardAdReqParams(str2, -1, z16, str, listOf));
                i3 = i16;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VasKuiklyCardAdManager$asyncRequestKuiklyCardAd$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
