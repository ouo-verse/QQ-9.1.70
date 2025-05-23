package com.tencent.mobileqq.vas.adv.common.pb;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tenpay.sdk.util.QWSoterConstans;

/* loaded from: classes20.dex */
public final class AdvPush {
    public static final int BACKEND = 3;
    public static final int ENUM_SHOP = 3;
    public static final int ENUM_SHOUYOU = 2;
    public static final int ENUM_SPORT = 5;
    public static final int ENUM_UNDEFINE_TYPE = 0;
    public static final int ENUM_VIP = 1;
    public static final int ENUM_WEATHER = 4;
    public static final int FRONTEND = 2;
    public static final int LOGIN = 1;
    public static final int PARAM_CHECK = 2000;
    public static final int SUCCESS = 0;
    public static final int UNKNOWN_REQ_SCENE_TYPE = 0;

    /* loaded from: classes20.dex */
    public static final class AdvPushReq extends MessageMicro<AdvPushReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"user_info", "busi_type_args_list", "gdt_args", "req_scene_type", "source_from"}, new Object[]{null, null, "", 0, ""}, AdvPushReq.class);
        public UserInfo user_info = new UserInfo();
        public final PBRepeatMessageField<BusiTypeArgs> busi_type_args_list = PBField.initRepeatMessage(BusiTypeArgs.class);
        public final PBStringField gdt_args = PBField.initString("");
        public final PBEnumField req_scene_type = PBField.initEnum(0);
        public final PBStringField source_from = PBField.initString("");
    }

    /* loaded from: classes20.dex */
    public static final class AdvPushRsp extends MessageMicro<AdvPushRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"next_req_gap", "next_loc_gap_in_second"}, new Object[]{0L, 0L}, AdvPushRsp.class);
        public final PBInt64Field next_req_gap = PBField.initInt64(0);
        public final PBInt64Field next_loc_gap_in_second = PBField.initInt64(0);
    }

    /* loaded from: classes20.dex */
    public static final class BusiTypeArgs extends MessageMicro<BusiTypeArgs> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{QWSoterConstans.CGI_KEY_BUSI_TYPE, "busi_args", "is_subscribed"}, new Object[]{0, "", Boolean.FALSE}, BusiTypeArgs.class);
        public final PBEnumField busi_type = PBField.initEnum(0);
        public final PBStringField busi_args = PBField.initString("");
        public final PBBoolField is_subscribed = PBField.initBool(false);
    }

    /* loaded from: classes20.dex */
    public static final class Location extends MessageMicro<Location> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"has_auth", "adcode", QCircleSchemeAttr.Polymerize.LAT, "lon", "accuracy"}, new Object[]{Boolean.FALSE, 0, 0, 0, 0}, Location.class);
        public final PBBoolField has_auth = PBField.initBool(false);
        public final PBUInt32Field adcode = PBField.initUInt32(0);
        public final PBInt32Field lat = PBField.initInt32(0);
        public final PBInt32Field lon = PBField.initInt32(0);
        public final PBInt32Field accuracy = PBField.initInt32(0);
    }

    /* loaded from: classes20.dex */
    public static final class UserInfo extends MessageMicro<UserInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58}, new String[]{"uin", "app", "os", "version", "qua", "loc", "client_mod"}, new Object[]{0L, "", "", "", "", null, ""}, UserInfo.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBStringField app = PBField.initString("");

        /* renamed from: os, reason: collision with root package name */
        public final PBStringField f308015os = PBField.initString("");
        public final PBStringField version = PBField.initString("");
        public final PBStringField qua = PBField.initString("");
        public Location loc = new Location();
        public final PBStringField client_mod = PBField.initString("");
    }

    AdvPush() {
    }
}
