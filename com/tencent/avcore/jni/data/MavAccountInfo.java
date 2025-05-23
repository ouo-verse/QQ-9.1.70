package com.tencent.avcore.jni.data;

import com.heytap.databaseengine.type.DeviceType;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class MavAccountInfo {
    static IPatchRedirector $redirector_ = null;
    public static final int kAccept = 3;
    public static final int kCalling = 1;
    public static final int kClosed = 6;
    public static final int kLowTrust = 2;
    public static final int kMissed = 5;
    public static final int kNewFriend = 1;
    public static final int kNone = 2;
    public static final int kNormal = 0;
    public static final int kOff = 1;
    public static final int kOn = 0;
    public static final int kPSTN = 1;
    public static final int kQQ = 0;
    public static final int kRefuse = 4;
    public static final int kRinging = 2;
    public static final int kUnknown = 0;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class AccountList extends MessageMicro<AccountList> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"account"}, new Object[]{""}, AccountList.class);
        public final PBRepeatField<String> account = PBField.initRepeat(PBStringField.__repeatHelper__);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class MAVCommonChannelMsg extends MessageMicro<MAVCommonChannelMsg> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48}, new String[]{"from_account", "cmd_type", "relation_type", "business_type", AudienceReportConst.ROOM_ID, "group_id"}, new Object[]{"", 0, 0, 0, 0L, 0L}, MAVCommonChannelMsg.class);
        public final PBStringField from_account = PBField.initString("");
        public final PBUInt32Field cmd_type = PBField.initUInt32(0);
        public final PBUInt32Field relation_type = PBField.initUInt32(0);
        public final PBUInt32Field business_type = PBField.initUInt32(0);
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public final PBUInt64Field group_id = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class MavGetSignResponse extends MessageMicro<MavGetSignResponse> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret", "msg", "sign"}, new Object[]{0L, "", ""}, MavGetSignResponse.class);
        public final PBUInt64Field ret = PBField.initUInt64(0);

        /* renamed from: msg, reason: collision with root package name */
        public final PBStringField f77479msg = PBField.initString("");
        public final PBStringField sign = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class MavInviteAccount extends MessageMicro<MavInviteAccount> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"account_type", "account", "tel_info", "result", AskAnonymouslyApiPlugin.KEY_INVITE_TYPE}, new Object[]{0, "", null, 0, 0}, MavInviteAccount.class);
        public final PBUInt32Field account_type = PBField.initUInt32(0);
        public final PBStringField account = PBField.initString("");
        public TelInfo tel_info = new TelInfo();
        public final PBUInt32Field result = PBField.initUInt32(0);
        public final PBUInt32Field invite_type = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class MavInviteData extends MessageMicro<MavInviteData> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"account_list", "friend_type", "safe_tip"}, new Object[]{null, 0, ""}, MavInviteData.class);
        public final PBRepeatMessageField<MavInviteAccount> account_list = PBField.initRepeatMessage(MavInviteAccount.class);
        public final PBEnumField friend_type = PBField.initEnum(0);
        public final PBStringField safe_tip = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class MavUinOpenIdPair extends MessageMicro<MavUinOpenIdPair> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"account", "open_id"}, new Object[]{0L, ""}, MavUinOpenIdPair.class);
        public final PBUInt64Field account = PBField.initUInt64(0);
        public final PBStringField open_id = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class MavUinOpenIdResponse extends MessageMicro<MavUinOpenIdResponse> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret", "msg", "pairs"}, new Object[]{0L, "", null}, MavUinOpenIdResponse.class);
        public final PBUInt64Field ret = PBField.initUInt64(0);

        /* renamed from: msg, reason: collision with root package name */
        public final PBStringField f77480msg = PBField.initString("");
        public final PBRepeatMessageField<MavUinOpenIdPair> pairs = PBField.initRepeatMessage(MavUinOpenIdPair.class);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class MavUserInfo extends MessageMicro<MavUserInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 58, 64, 74}, new String[]{"account", "open_id", "account_type", "pstn_status", "mic_auth", "ext_business_type", "ext_business_info", "net_level", "common_tips_info"}, new Object[]{"", "", 0, 0, 0, 0, "", 0, ""}, MavUserInfo.class);
        public final PBStringField account = PBField.initString("");
        public final PBStringField open_id = PBField.initString("");
        public final PBEnumField account_type = PBField.initEnum(0);
        public final PBEnumField pstn_status = PBField.initEnum(0);
        public final PBEnumField mic_auth = PBField.initEnum(0);
        public final PBUInt32Field ext_business_type = PBField.initUInt32(0);
        public final PBStringField ext_business_info = PBField.initString("");
        public final PBUInt32Field net_level = PBField.initUInt32(0);
        public final PBStringField common_tips_info = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class MavUserInfoList extends MessageMicro<MavUserInfoList> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"mav_user_infos"}, new Object[]{null}, MavUserInfoList.class);
        public final PBRepeatMessageField<MavUserInfo> mav_user_infos = PBField.initRepeatMessage(MavUserInfo.class);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class TelInfo extends MessageMicro<TelInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"nation", "prefix", DeviceType.DeviceCategory.MOBILE}, new Object[]{"", "", ""}, TelInfo.class);
        public final PBStringField nation = PBField.initString("");
        public final PBStringField prefix = PBField.initString("");
        public final PBStringField mobile = PBField.initString("");
    }

    MavAccountInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
