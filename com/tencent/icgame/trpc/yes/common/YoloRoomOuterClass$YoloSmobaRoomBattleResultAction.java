package com.tencent.icgame.trpc.yes.common;

import com.tencent.icgame.trpc.yes.wuji.WujiSmobaOuterClass$WujiSmobaHeroConfList;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloSmobaRoomBattleResultAction extends MessageMicro<YoloRoomOuterClass$YoloSmobaRoomBattleResultAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 34, 42, 50, 58}, new String[]{"smoba_battle_result", "smoba_hero_conf_list", "user_id_list", "battle_result_text", "gift_room_battle_result_text", "gift_config"}, new Object[]{null, null, null, "", "", null}, YoloRoomOuterClass$YoloSmobaRoomBattleResultAction.class);
    public YoloBattleSmobaOuterClass$YoloSmobaBattleResult smoba_battle_result = new YoloBattleSmobaOuterClass$YoloSmobaBattleResult();
    public WujiSmobaOuterClass$WujiSmobaHeroConfList smoba_hero_conf_list = new MessageMicro<WujiSmobaOuterClass$WujiSmobaHeroConfList>() { // from class: com.tencent.icgame.trpc.yes.wuji.WujiSmobaOuterClass$WujiSmobaHeroConfList
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, WujiSmobaOuterClass$WujiSmobaHeroConfList.class);
        public final PBRepeatMessageField<WujiSmobaOuterClass$WujiSmobaHeroConf> data = PBField.initRepeatMessage(WujiSmobaOuterClass$WujiSmobaHeroConf.class);
    };
    public final PBRepeatMessageField<CommonOuterClass$QQUserId> user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
    public final PBRepeatField<String> battle_result_text = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField gift_room_battle_result_text = PBField.initString("");
    public YoloRoomOuterClass$YoloGiftConfig gift_config = new YoloRoomOuterClass$YoloGiftConfig();
}
