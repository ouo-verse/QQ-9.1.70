package com.tencent.mobileqq.nearbypro.map.avatar;

import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.map.request.SetAvatarHeadRequest;
import com.tencent.mobileqq.nearbypro.repository.service.BDHService;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.nearbypro.request.RspStatus;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.zplan.avatar.edit.d;
import com.tencent.qphone.base.util.BaseApplication;
import fu4.w;
import hq4.l;
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
import op4.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.map.avatar.MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1", f = "MapAvatarUtils.kt", i = {}, l = {264}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
final class MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cropFilePath;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1(String str, Continuation<? super MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1> continuation) {
        super(2, continuation);
        this.$cropFilePath = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(w wVar, NearbyProBaseRequest nearbyProBaseRequest, RspStatus rspStatus, l lVar) {
        if (rspStatus.c() && lVar != null) {
            j.c().e("MapAvatarUtils", "setAvatarHead success");
            CorountineFunKt.e(fa2.a.c(), "reqDownPhoto", null, null, null, new MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1$1$1(wVar, null), 14, null);
        } else {
            j.c().d("MapAvatarUtils", "setAvatarHead failed");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1(this.$cropFilePath, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        d dVar;
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
            BDHService bDHService = new BDHService();
            String str = this.$cropFilePath;
            this.label = 1;
            obj = bDHService.o(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        final w wVar = (w) obj;
        if (wVar != null) {
            g gVar = new g();
            gVar.f423329a = wVar;
            com.tencent.mobileqq.nearbypro.base.d<NearbyProBaseRequest> e16 = j.e();
            BaseApplication context = BaseApplication.getContext();
            dVar = MapAvatarUtils.editAvatarData;
            Intrinsics.checkNotNull(dVar);
            e16.c(context, new SetAvatarHeadRequest(gVar, dVar), new com.tencent.mobileqq.nearbypro.request.b() { // from class: com.tencent.mobileqq.nearbypro.map.avatar.b
                @Override // com.tencent.mobileqq.nearbypro.request.b
                public final void a(Object obj2, RspStatus rspStatus, Object obj3) {
                    MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1.b(w.this, (NearbyProBaseRequest) obj2, rspStatus, (l) obj3);
                }
            });
        } else {
            j.c().d("MapAvatarUtils", "sendPhoto fail, msgInfo is null");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
