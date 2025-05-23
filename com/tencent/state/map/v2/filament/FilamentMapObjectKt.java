package com.tencent.state.map.v2.filament;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.filament.zplan.scene.square.SquareInteractionEventData;
import com.tencent.state.square.avatar.filament.AnimType;
import com.tencent.state.square.avatar.filament.AvatarType;
import com.tencent.state.square.avatar.filament.MoodConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0006"}, d2 = {"getInteractionEventData", "Lcom/tencent/filament/zplan/scene/square/SquareInteractionEventData;", "moodConfig", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "playData", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FilamentMapObjectKt {
    public static final SquareInteractionEventData getInteractionEventData(MoodConfig moodConfig, SquareAvatarData playData) {
        Intrinsics.checkNotNullParameter(moodConfig, "moodConfig");
        Intrinsics.checkNotNullParameter(playData, "playData");
        EnumUserGender gender = playData.getHost().getGender();
        AvatarType avatarType = AvatarType.HOST;
        AnimType animType = AnimType.CLICK;
        SquareAvatarData.AvatarAnim avatarAnim = moodConfig.getAvatarAnim(gender, avatarType, animType);
        SquareAvatarData.AvatarData guest = playData.getGuest();
        SquareAvatarData.AvatarAnim avatarAnim2 = guest != null ? moodConfig.getAvatarAnim(guest.getGender(), AvatarType.GUEST, animType) : null;
        SquareAvatarData.ExtraActorData extraActorData = moodConfig.getExtraActorData(animType, playData.getHost().getGender());
        return new SquareInteractionEventData(avatarAnim, avatarAnim2, extraActorData != null ? extraActorData.getAnimGltf() : null);
    }
}
