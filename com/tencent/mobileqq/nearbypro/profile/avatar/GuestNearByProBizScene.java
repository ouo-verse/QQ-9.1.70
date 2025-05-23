package com.tencent.mobileqq.nearbypro.profile.avatar;

import com.tencent.filament.zplan.business.impl.AbsBusinessScene;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.repository.service.AvatarService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/profile/avatar/GuestNearByProBizScene;", "Lcom/tencent/mobileqq/nearbypro/profile/avatar/MyNearbyProBizScene;", "tinyId", "", "(J)V", "getTinyId", "()J", "fetchAvatarInfo", "Lorg/json/JSONObject;", "from", "Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;", "(Lcom/tencent/filament/zplan/business/impl/AbsBusinessScene$FetchAvatarInfoFrom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class GuestNearByProBizScene extends MyNearbyProBizScene {
    private final long tinyId;

    public GuestNearByProBizScene(long j3) {
        this.tinyId = j3;
    }

    @Override // com.tencent.mobileqq.nearbypro.profile.avatar.MyNearbyProBizScene, com.tencent.filament.zplan.business.impl.AbsBusinessScene
    @Nullable
    public Object fetchAvatarInfo(@NotNull AbsBusinessScene.FetchAvatarInfoFrom fetchAvatarInfoFrom, @NotNull Continuation<? super JSONObject> continuation) {
        j.c().e("GuestNearByProBizScene", "tinyID: " + this.tinyId);
        return AvatarService.INSTANCE.reqOtherAvatarInfo(this.tinyId, "0.2.23.0", continuation);
    }

    public final long getTinyId() {
        return this.tinyId;
    }
}
