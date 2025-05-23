package com.tencent.mobileqq.zplan.avatar;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/ZPlanEditAvatarEntranceScene;", "", "sourceString", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getSourceString", "()Ljava/lang/String;", "FOLLOW_APPEARANCE", "PROFILE_AVATAR_SHOP", "PROFILE_AVATAR_ZPLAN", "CONCISE_PROFILE_AVATAR", "CONCISE_EDIT_PROFILE_AVATAR", "SHARE_QZONE_FEEDA", "FRIEND_PROFILE", "ZPLAN_CREATE_ROLE", "QCIRCLE_VIDEO", "QBOX_MINI_APP", "YEAR_END_SUMMARY", "REGISTER", "UNKNOWN", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum ZPlanEditAvatarEntranceScene {
    FOLLOW_APPEARANCE("0"),
    PROFILE_AVATAR_SHOP("1"),
    PROFILE_AVATAR_ZPLAN("2"),
    CONCISE_PROFILE_AVATAR("3"),
    CONCISE_EDIT_PROFILE_AVATAR("4"),
    SHARE_QZONE_FEEDA("5"),
    FRIEND_PROFILE("6"),
    ZPLAN_CREATE_ROLE("7"),
    QCIRCLE_VIDEO("8"),
    QBOX_MINI_APP("9"),
    YEAR_END_SUMMARY("10"),
    REGISTER("19"),
    UNKNOWN("-1");


    @NotNull
    private final String sourceString;

    ZPlanEditAvatarEntranceScene(String str) {
        this.sourceString = str;
    }

    @NotNull
    public final String getSourceString() {
        return this.sourceString;
    }
}
