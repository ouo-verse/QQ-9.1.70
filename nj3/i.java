package nj3;

import com.tencent.filament.zplanservice.pbjava.ZPlanInfoChannel$GetNowAvatarInfoResponse;
import com.tencent.filament.zplanservice.pbjava.avatar_info.AvatarDressInfo$AvatarCharacter;
import com.tencent.mobileqq.zplan.utils.SknNetworkUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lnj3/i;", "Lel0/i;", "Lkotlin/Function1;", "Lcom/tencent/filament/zplanservice/pbjava/ZPlanInfoChannel$GetNowAvatarInfoResponse;", "", "Lcom/tencent/filament/zplanservice/proxy/api/channel/IZPlanInfoGetNowAvatarInfoResponse;", "callback", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i implements el0.i {
    @Override // el0.i
    public void a(Function1<? super ZPlanInfoChannel$GetNowAvatarInfoResponse, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZPlanInfoChannel$GetNowAvatarInfoResponse zPlanInfoChannel$GetNowAvatarInfoResponse = new ZPlanInfoChannel$GetNowAvatarInfoResponse();
        zPlanInfoChannel$GetNowAvatarInfoResponse.avatar_info = new AvatarDressInfo$AvatarCharacter().mergeFrom(SknNetworkUtilKt.i(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b().getAvatarCharacter()));
        callback.invoke(zPlanInfoChannel$GetNowAvatarInfoResponse);
    }
}
