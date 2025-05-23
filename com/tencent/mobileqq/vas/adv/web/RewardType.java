package com.tencent.mobileqq.vas.adv.web;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/web/RewardType;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "UNKNOWN_REWARD_TYPE", "QQ_VIP_PERSONAL", "QZONE_GIFT", "GROUP_GIFT", "QQSPORT_PATCHCARD", "QQSPORT_SCORE", "XSJ_AI_POSTER", "XSJ_GENERAL_ACTIVITY", "QQ_VIP_PERSONAL_AVATAR", "QQ_VIP_PERSONAL_BACKGROUND", "QQ_VIP_NOVEL_CREATURE", "QQWEATHER_SCORE", "QZONE_ACTIVITY", "SUPER_SHOW", "SUPER_SHOW_AD_ACTIVITY", "SUPER_SHOW_FREE_ITEM", "SUPER_SHOW_CREATIVE_VOUCHER", "QQ_VIP_NOVEL_CREATURE_ACCELERATE_WORKTIME", "SUPER_SHOW_MOB", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public enum RewardType {
    UNKNOWN_REWARD_TYPE(0),
    QQ_VIP_PERSONAL(1),
    QZONE_GIFT(2),
    GROUP_GIFT(11),
    QQSPORT_PATCHCARD(12),
    QQSPORT_SCORE(18),
    XSJ_AI_POSTER(20),
    XSJ_GENERAL_ACTIVITY(21),
    QQ_VIP_PERSONAL_AVATAR(22),
    QQ_VIP_PERSONAL_BACKGROUND(23),
    QQ_VIP_NOVEL_CREATURE(24),
    QQWEATHER_SCORE(25),
    QZONE_ACTIVITY(26),
    SUPER_SHOW(27),
    SUPER_SHOW_AD_ACTIVITY(28),
    SUPER_SHOW_FREE_ITEM(29),
    SUPER_SHOW_CREATIVE_VOUCHER(30),
    QQ_VIP_NOVEL_CREATURE_ACCELERATE_WORKTIME(31),
    SUPER_SHOW_MOB(32);

    private final int value;

    RewardType(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
