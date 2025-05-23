package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WujiShopOuterClass$WujiShopCommonRewardConf extends MessageMicro<WujiShopOuterClass$WujiShopCommonRewardConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 48, 58, 66, 74, 82, 88, 96}, new String[]{"reward_id", "type", "name", "count", "ams_goods_id", "package_group_id", "service_type", "big_pic", "small_pic", "jump_url", "game_id", "bind_game_role"}, new Object[]{0, 0, "", 0, "", 0, "", "", "", "", 0, Boolean.FALSE}, WujiShopOuterClass$WujiShopCommonRewardConf.class);
    public final PBInt32Field reward_id = PBField.initInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBStringField ams_goods_id = PBField.initString("");
    public final PBInt32Field package_group_id = PBField.initInt32(0);
    public final PBStringField service_type = PBField.initString("");
    public final PBStringField big_pic = PBField.initString("");
    public final PBStringField small_pic = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBBoolField bind_game_role = PBField.initBool(false);
}
