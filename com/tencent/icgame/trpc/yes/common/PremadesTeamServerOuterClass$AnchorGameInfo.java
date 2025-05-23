package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$AnchorGameInfo extends MessageMicro<PremadesTeamServerOuterClass$AnchorGameInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 66}, new String[]{"title", "desc", "hero_url_list", "url", "is_playing", "new_title", "equip_url_list", "fans_data"}, new Object[]{"", "", "", "", 0, "", "", ""}, PremadesTeamServerOuterClass$AnchorGameInfo.class);
    public final PBRepeatField<String> equip_url_list;
    public final PBStringField fans_data;
    public final PBRepeatField<String> hero_url_list;
    public final PBInt32Field is_playing;
    public final PBRepeatField<String> new_title;
    public final PBStringField url;
    public final PBStringField title = PBField.initString("");
    public final PBStringField desc = PBField.initString("");

    public PremadesTeamServerOuterClass$AnchorGameInfo() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.hero_url_list = PBField.initRepeat(pBStringField);
        this.url = PBField.initString("");
        this.is_playing = PBField.initInt32(0);
        this.new_title = PBField.initRepeat(pBStringField);
        this.equip_url_list = PBField.initRepeat(pBStringField);
        this.fans_data = PBField.initString("");
    }
}
