package com.tencent.sqshow.zootopia.nativeui.view.page;

import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import uv4.az;
import uv4.bk;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.nativeui.view.page.ZPlanAvatarPreDownloadManager$downloadItem$1", f = "ZPlanAvatarPreDownloadManager.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanAvatarPreDownloadManager$downloadItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ bk $data;
    final /* synthetic */ Ref.BooleanRef $localCache;
    final /* synthetic */ long $start;
    final /* synthetic */ az $storeItem;
    final /* synthetic */ String $url;
    final /* synthetic */ FilamentUrlTemplate $urlTemplate;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarPreDownloadManager$downloadItem$1(az azVar, long j3, Ref.BooleanRef booleanRef, bk bkVar, FilamentUrlTemplate filamentUrlTemplate, String str, Continuation<? super ZPlanAvatarPreDownloadManager$downloadItem$1> continuation) {
        super(2, continuation);
        this.$storeItem = azVar;
        this.$start = j3;
        this.$localCache = booleanRef;
        this.$data = bkVar;
        this.$urlTemplate = filamentUrlTemplate;
        this.$url = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanAvatarPreDownloadManager$downloadItem$1(this.$storeItem, this.$start, this.$localCache, this.$data, this.$urlTemplate, this.$url, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanAvatarPreDownloadManager$downloadItem$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        Deferred async$default;
        az azVar;
        long j3;
        Ref.BooleanRef booleanRef;
        FilamentUrlTemplate filamentUrlTemplate;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = ZPlanAvatarPreDownloadManager.coroutineScope;
            if (coroutineScope != null) {
                az azVar2 = this.$storeItem;
                long j16 = this.$start;
                Ref.BooleanRef booleanRef2 = this.$localCache;
                bk bkVar = this.$data;
                FilamentUrlTemplate filamentUrlTemplate2 = this.$urlTemplate;
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ZPlanAvatarPreDownloadManager$downloadItem$1$1$deferred$1(booleanRef2, bkVar, filamentUrlTemplate2, this.$url, null), 3, null);
                this.L$0 = azVar2;
                this.L$1 = booleanRef2;
                this.L$2 = filamentUrlTemplate2;
                this.J$0 = j16;
                this.label = 1;
                if (async$default.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                azVar = azVar2;
                j3 = j16;
                booleanRef = booleanRef2;
                filamentUrlTemplate = filamentUrlTemplate2;
            }
            return Unit.INSTANCE;
        }
        if (i3 == 1) {
            j3 = this.J$0;
            filamentUrlTemplate = (FilamentUrlTemplate) this.L$2;
            booleanRef = (Ref.BooleanRef) this.L$1;
            azVar = (az) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ZPlanAvatarPreDownloadManager.isDownloading = false;
        long currentTimeMillis = System.currentTimeMillis();
        ZPlanAvatarPreDownloadManager zPlanAvatarPreDownloadManager = ZPlanAvatarPreDownloadManager.f371947a;
        zPlanAvatarPreDownloadManager.n(false, azVar, currentTimeMillis - j3);
        if (!booleanRef.element) {
            zPlanAvatarPreDownloadManager.o(r94.b.M(azVar), azVar.f440275b);
        }
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new ZPlanAvatarPreDownloadManager$downloadItem$1$1$1(filamentUrlTemplate, null), 2, null);
        return Unit.INSTANCE;
    }
}
