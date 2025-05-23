package com.tencent.mobileqq.troop.troopgame.api;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopGameCardService extends IRuntimeService {
    public static final String GAME_PROFILE_NEW_SWITCH = "game_profile_new_switch";

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void onResult(Object obj);
    }

    @Nullable
    Drawable getDrawableByGameGradeLevel(int i3, @Nullable Consumer<Drawable> consumer);

    void getMemberGradeLevelInfoAsync(String str, a aVar);

    boolean isNewCardEnable();

    void saveMemberGradeLevelInfo(MemberGradeLevelInfo memberGradeLevelInfo);

    @Nullable
    MemberGradeLevelInfo tryGetMemberGradeLevelInfo(String str, a aVar);
}
