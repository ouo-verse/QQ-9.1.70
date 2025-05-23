package com.tencent.mobileqq.minigame.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes15.dex */
public final class MetaFarmWidgetProto {
    public static final int SOURCE_ADD_WIDGET = 4;
    public static final int SOURCE_GAME_END_REQUEST = 2;
    public static final int SOURCE_GUIDE_ADD_WIDGET = 5;
    public static final int SOURCE_QQ_LOGIN = 1;
    public static final int SOURCE_REGULAR_INTERVAL_REFRESH = 3;
    public static final int SOURCR_UNKNOWN = 0;

    /* loaded from: classes15.dex */
    public static final class CropCard extends MessageMicro<CropCard> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{"icon", "text", "text_highlight", "time_text", "time_stamp"}, new Object[]{"", "", Boolean.FALSE, "", 0L}, CropCard.class);
        public final PBStringField icon = PBField.initString("");
        public final PBStringField text = PBField.initString("");
        public final PBBoolField text_highlight = PBField.initBool(false);
        public final PBStringField time_text = PBField.initString("");
        public final PBUInt64Field time_stamp = PBField.initUInt64(0);
    }

    /* loaded from: classes15.dex */
    public static final class GetWidgetReq extends MessageMicro<GetWidgetReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"source"}, new Object[]{0}, GetWidgetReq.class);
        public final PBEnumField source = PBField.initEnum(0);
    }

    /* loaded from: classes15.dex */
    public static final class GetWidgetRsp extends MessageMicro<GetWidgetRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"next_pull_gap_second", "user_info", "cards", "jump_url"}, new Object[]{0L, null, null, ""}, GetWidgetRsp.class);
        public final PBInt64Field next_pull_gap_second = PBField.initInt64(0);
        public UserInfo user_info = new UserInfo();
        public final PBRepeatMessageField<CropCard> cards = PBField.initRepeatMessage(CropCard.class);
        public final PBStringField jump_url = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class UserInfo extends MessageMicro<UserInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 50, 58, 64, 72}, new String[]{"nick", "avatar", "level", "level_icon", "coin", "coin_desc", "coin_icon", "stealable_times", "blessing_times"}, new Object[]{"", "", 0, "", 0L, "", "", 0, 0}, UserInfo.class);
        public final PBStringField nick = PBField.initString("");
        public final PBStringField avatar = PBField.initString("");
        public final PBUInt32Field level = PBField.initUInt32(0);
        public final PBStringField level_icon = PBField.initString("");
        public final PBUInt64Field coin = PBField.initUInt64(0);
        public final PBStringField coin_desc = PBField.initString("");
        public final PBStringField coin_icon = PBField.initString("");
        public final PBUInt32Field stealable_times = PBField.initUInt32(0);
        public final PBUInt32Field blessing_times = PBField.initUInt32(0);
    }

    MetaFarmWidgetProto() {
    }
}
