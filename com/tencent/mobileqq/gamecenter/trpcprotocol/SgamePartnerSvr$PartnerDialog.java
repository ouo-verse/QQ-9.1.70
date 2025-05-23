package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes12.dex */
public final class SgamePartnerSvr$PartnerDialog extends MessageMicro<SgamePartnerSvr$PartnerDialog> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 72, 82, 90, 96}, new String[]{"appid", "from_role_id", "to_role_id", "from_openaio_id", "to_openaio_id", "from_role_info", "to_role_info", "status", "last_msg_time", "to_nick", "to_icon_url", "to_online_state"}, new Object[]{"", "", "", "", "", null, null, 0, 0L, "", "", 0}, SgamePartnerSvr$PartnerDialog.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField from_role_id = PBField.initString("");
    public final PBStringField to_role_id = PBField.initString("");
    public final PBStringField from_openaio_id = PBField.initString("");
    public final PBStringField to_openaio_id = PBField.initString("");
    public SgamePartnerSvr$GameAreaRole from_role_info = new MessageMicro<SgamePartnerSvr$GameAreaRole>() { // from class: com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$GameAreaRole
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 64, 74, 82}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "plat_id", "partition", "role_id", "role_name", "openid", "partition_name", "uin", "appid", "wxopenid"}, new Object[]{0, 0, 0, "", "", "", "", 0L, "", ""}, SgamePartnerSvr$GameAreaRole.class);
        public final PBInt32Field area = PBField.initInt32(0);
        public final PBInt32Field plat_id = PBField.initInt32(0);
        public final PBInt32Field partition = PBField.initInt32(0);
        public final PBStringField role_id = PBField.initString("");
        public final PBStringField role_name = PBField.initString("");
        public final PBStringField openid = PBField.initString("");
        public final PBStringField partition_name = PBField.initString("");
        public final PBInt64Field uin = PBField.initInt64(0);
        public final PBStringField appid = PBField.initString("");
        public final PBStringField wxopenid = PBField.initString("");
    };
    public SgamePartnerSvr$GameAreaRole to_role_info = new MessageMicro<SgamePartnerSvr$GameAreaRole>() { // from class: com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$GameAreaRole
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 64, 74, 82}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "plat_id", "partition", "role_id", "role_name", "openid", "partition_name", "uin", "appid", "wxopenid"}, new Object[]{0, 0, 0, "", "", "", "", 0L, "", ""}, SgamePartnerSvr$GameAreaRole.class);
        public final PBInt32Field area = PBField.initInt32(0);
        public final PBInt32Field plat_id = PBField.initInt32(0);
        public final PBInt32Field partition = PBField.initInt32(0);
        public final PBStringField role_id = PBField.initString("");
        public final PBStringField role_name = PBField.initString("");
        public final PBStringField openid = PBField.initString("");
        public final PBStringField partition_name = PBField.initString("");
        public final PBInt64Field uin = PBField.initInt64(0);
        public final PBStringField appid = PBField.initString("");
        public final PBStringField wxopenid = PBField.initString("");
    };
    public final PBEnumField status = PBField.initEnum(0);
    public final PBInt64Field last_msg_time = PBField.initInt64(0);
    public final PBStringField to_nick = PBField.initString("");
    public final PBStringField to_icon_url = PBField.initString("");
    public final PBInt32Field to_online_state = PBField.initInt32(0);
}
