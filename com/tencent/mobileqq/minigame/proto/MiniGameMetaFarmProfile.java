package com.tencent.mobileqq.minigame.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;

/* loaded from: classes15.dex */
public final class MiniGameMetaFarmProfile {
    public static final int CROP_STATUS_CAN_ENCOURAGE = 4;
    public static final int CROP_STATUS_CAN_PLANT = 6;
    public static final int CROP_STATUS_DRY = 2;
    public static final int CROP_STATUS_HUNGRY = 7;
    public static final int CROP_STATUS_NOT_OPEN = 5;
    public static final int CROP_STATUS_PLANTED = 1;
    public static final int CROP_STATUS_RIPE = 3;
    public static final int CROP_STATUS_UNSPECIFIED = 0;
    public static final int FARM_CARD_SWITCH_CLOSE = 2;
    public static final int FARM_CARD_SWITCH_OPEN = 1;
    public static final int FARM_CARD_SWITCH_UNSPECIFIED = 0;
    public static final int PLAT_ANDROID = 1;
    public static final int PLAT_IOS = 0;

    /* loaded from: classes15.dex */
    public static final class FarmCard extends MessageMicro<FarmCard> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 88, 96, 104, 112, 170, 178, 186, 194}, new String[]{"gender", "uid", "farm_level", "status", "farm_level_icon", "status_icon", "status_desc", "crop_status", "animal_status", "fish_status", "machine_status", "crop_icon", "animal_icon", "fish_icon", "machine_icon"}, new Object[]{0, 0L, 0, 0, "", "", "", 0, 0, 0, 0, "", "", "", ""}, FarmCard.class);
        public final PBUInt32Field gender = PBField.initUInt32(0);
        public final PBUInt64Field uid = PBField.initUInt64(0);
        public final PBInt32Field farm_level = PBField.initInt32(0);
        public final PBUInt32Field status = PBField.initUInt32(0);
        public final PBStringField farm_level_icon = PBField.initString("");
        public final PBStringField status_icon = PBField.initString("");
        public final PBStringField status_desc = PBField.initString("");
        public final PBEnumField crop_status = PBField.initEnum(0);
        public final PBEnumField animal_status = PBField.initEnum(0);
        public final PBEnumField fish_status = PBField.initEnum(0);
        public final PBEnumField machine_status = PBField.initEnum(0);
        public final PBStringField crop_icon = PBField.initString("");
        public final PBStringField animal_icon = PBField.initString("");
        public final PBStringField fish_icon = PBField.initString("");
        public final PBStringField machine_icon = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class FarmStatus extends MessageMicro<FarmStatus> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{ProfileCardDtReportUtil.STATUS_ID, "icon", "desc"}, new Object[]{0, "", ""}, FarmStatus.class);
        public final PBUInt32Field status_id = PBField.initUInt32(0);
        public final PBStringField icon = PBField.initString("");
        public final PBStringField desc = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class GetFarmCardReq extends MessageMicro<GetFarmCardReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "plat"}, new Object[]{0L, 0}, GetFarmCardReq.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBEnumField plat = PBField.initEnum(0);
    }

    /* loaded from: classes15.dex */
    public static final class GetFarmCardRsp extends MessageMicro<GetFarmCardRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{IndividuationUrlHelper.UrlId.CARD_HOME}, new Object[]{null}, GetFarmCardRsp.class);
        public FarmCard card = new FarmCard();
    }

    /* loaded from: classes15.dex */
    public static final class GetPredefinedFarmStatusReq extends MessageMicro<GetPredefinedFarmStatusReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GetPredefinedFarmStatusReq.class);
    }

    /* loaded from: classes15.dex */
    public static final class GetPredefinedFarmStatusRsp extends MessageMicro<GetPredefinedFarmStatusRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"statuses"}, new Object[]{null}, GetPredefinedFarmStatusRsp.class);
        public final PBRepeatMessageField<FarmStatus> statuses = PBField.initRepeatMessage(FarmStatus.class);
    }

    /* loaded from: classes15.dex */
    public static final class IsFarmUserReq extends MessageMicro<IsFarmUserReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"plat"}, new Object[]{0}, IsFarmUserReq.class);
        public final PBEnumField plat = PBField.initEnum(0);
    }

    /* loaded from: classes15.dex */
    public static final class IsFarmUserRsp extends MessageMicro<IsFarmUserRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_farm_user"}, new Object[]{Boolean.FALSE}, IsFarmUserRsp.class);
        public final PBBoolField is_farm_user = PBField.initBool(false);
    }

    /* loaded from: classes15.dex */
    public static final class SetFarmStatusReq extends MessageMicro<SetFarmStatusReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"status"}, new Object[]{0}, SetFarmStatusReq.class);
        public final PBUInt32Field status = PBField.initUInt32(0);
    }

    /* loaded from: classes15.dex */
    public static final class SetFarmStatusRsp extends MessageMicro<SetFarmStatusRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"status"}, new Object[]{0}, SetFarmStatusRsp.class);
        public final PBUInt32Field status = PBField.initUInt32(0);
    }

    MiniGameMetaFarmProfile() {
    }
}
