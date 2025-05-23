package com.tencent.mobileqq.zplan.setting;

import com.tencent.mobileqq.profilecard.api.ProfileContants;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rj\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/setting/SwitchSetting;", "", "key", "", "pbName", "", "pbType", "onValue", "offValue", "(Ljava/lang/String;ILjava/lang/String;IIII)V", "getKey", "()Ljava/lang/String;", "getOffValue", "()I", "getOnValue", "getPbName", "getPbType", "getSwitchValue", "checked", "", "MASTER_SETTING", "PROFILE_CARD_SETTING", "DYNAMIC_SETTING", "AIO_AVATAR_SETTING", "DRAWER_SETTING", "ADD_FRIEND_SETTING", "SHOOT_ASSETS_SETTING", "SHOOT_PACKAGE_SETTING", "OPERATOR_DOWNLOAD_SETTING", "SHOW_PARADISE_SCORE_SETTING", "MESSAGE_NOTICE_SETTING", "CMSHOW_MONTH_USER_SETTING", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public enum SwitchSetting {
    MASTER_SETTING("key_avatar_show_master", ProfileContants.FIELD_ZPLAN_MASTER_SHOW_SWITCH, 1, 0, 1),
    PROFILE_CARD_SETTING("key_avatar_show_profile_card", ProfileContants.FIELD_ZPLAN_PROFILE_CARD_SHOW_SWITCH, 1, 0, 1),
    DYNAMIC_SETTING("key_avatar_show_qzone", 45103, 1, 0, 1),
    AIO_AVATAR_SETTING("key_avatar_show_aio_avatar", 15, 1, 0, 1),
    DRAWER_SETTING("key_avatar_show_drawer", 18, 5, 0, 1),
    ADD_FRIEND_SETTING("key_privacy_add_friend", 42532, 1, 0, 1),
    SHOOT_ASSETS_SETTING("key_privacy_shoot_assets", 45122, 1, 0, 1),
    SHOOT_PACKAGE_SETTING("key_privacy_shoot_package", 45121, 1, 1, 0),
    OPERATOR_DOWNLOAD_SETTING("key_common_operator_download", 45120, 1, 1, 0),
    SHOW_PARADISE_SCORE_SETTING("key_privacy_show_paradise_score", 6, 1, 1, 0),
    MESSAGE_NOTICE_SETTING("key_common_message_notice", 45119, 1, 0, 1),
    CMSHOW_MONTH_USER_SETTING("key_cmshow_month_active_user", 46006, 1, 1, 0);

    private final String key;
    private final int offValue;
    private final int onValue;
    private final int pbName;
    private final int pbType;

    SwitchSetting(String str, int i3, int i16, int i17, int i18) {
        this.key = str;
        this.pbName = i3;
        this.pbType = i16;
        this.onValue = i17;
        this.offValue = i18;
    }

    public final String getKey() {
        return this.key;
    }

    public final int getOffValue() {
        return this.offValue;
    }

    public final int getOnValue() {
        return this.onValue;
    }

    public final int getPbName() {
        return this.pbName;
    }

    public final int getPbType() {
        return this.pbType;
    }

    public final int getSwitchValue(boolean checked) {
        if (checked) {
            return this.onValue;
        }
        return this.offValue;
    }
}
