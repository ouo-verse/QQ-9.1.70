package com.tencent.mobileqq.zplan.proxy;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.proxy.QQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2", f = "QQZPlanAssetsProxy.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class QQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ EnumUserGender $gender;
    final /* synthetic */ List<jx4.b> $stickerConfigList;
    final /* synthetic */ FilamentUrlTemplate $urlTemplate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2(List<jx4.b> list, EnumUserGender enumUserGender, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super QQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2> continuation) {
        super(2, continuation);
        this.$stickerConfigList = list;
        this.$gender = enumUserGender;
        this.$urlTemplate = filamentUrlTemplate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2 qQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2 = new QQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2(this.$stickerConfigList, this.$gender, this.$urlTemplate, continuation);
        qQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2.L$0 = obj;
        return qQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int collectionSizeOrDefault;
        Deferred async$default;
        List<ZPlanAction> filterNotNull;
        boolean z16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            List<jx4.b> list = this.$stickerConfigList;
            EnumUserGender enumUserGender = this.$gender;
            FilamentUrlTemplate filamentUrlTemplate = this.$urlTemplate;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new QQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2$results$1$1((jx4.b) it.next(), enumUserGender, filamentUrlTemplate, null), 3, null);
                arrayList.add(async$default);
            }
            this.label = 1;
            obj = AwaitKt.awaitAll(arrayList, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull((List) obj);
        while (true) {
            for (ZPlanAction zPlanAction : filterNotNull) {
                z16 = z16 || zPlanAction.getDownloadFromNet();
            }
            return Boxing.boxBoolean(z16);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((QQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
