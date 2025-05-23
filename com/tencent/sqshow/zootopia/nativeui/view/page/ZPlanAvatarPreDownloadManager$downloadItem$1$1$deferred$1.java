package com.tencent.sqshow.zootopia.nativeui.view.page;

import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import uv4.bk;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.nativeui.view.page.ZPlanAvatarPreDownloadManager$downloadItem$1$1$deferred$1", f = "ZPlanAvatarPreDownloadManager.kt", i = {}, l = {183}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class ZPlanAvatarPreDownloadManager$downloadItem$1$1$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ bk $data;
    final /* synthetic */ Ref.BooleanRef $localCache;
    final /* synthetic */ String $url;
    final /* synthetic */ FilamentUrlTemplate $urlTemplate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarPreDownloadManager$downloadItem$1$1$deferred$1(Ref.BooleanRef booleanRef, bk bkVar, FilamentUrlTemplate filamentUrlTemplate, String str, Continuation<? super ZPlanAvatarPreDownloadManager$downloadItem$1$1$deferred$1> continuation) {
        super(2, continuation);
        this.$localCache = booleanRef;
        this.$data = bkVar;
        this.$urlTemplate = filamentUrlTemplate;
        this.$url = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanAvatarPreDownloadManager$downloadItem$1$1$deferred$1(this.$localCache, this.$data, this.$urlTemplate, this.$url, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, (Continuation<Object>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean j3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.BooleanRef booleanRef = this.$localCache;
                j3 = ZPlanAvatarPreDownloadManager.f371947a.j(this.$data, this.$urlTemplate);
                booleanRef.element = j3;
                ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                String str = this.$url;
                FilamentUrlTemplate filamentUrlTemplate = this.$urlTemplate;
                this.label = 1;
                obj = ZPlanAvatarResourceHelper.h0(zPlanAvatarResourceHelper, null, str, filamentUrlTemplate, false, this, 8, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        } catch (FetchFileException e16) {
            QLog.i("ZPlanAvatarPreDownloadManager", 1, "fetchZipFileWithUrl failed: " + e16);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((ZPlanAvatarPreDownloadManager$downloadItem$1$1$deferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
