package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameFriendSelectorSvr$SendMsgReq extends MessageMicro<GameFriendSelectorSvr$SendMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField sender_id = PBField.initString("");
    public final PBStringField receiver_id = PBField.initString("");
    public final PBStringField token = PBField.initString("");
    public final PBEnumField send_type = PBField.initEnum(0);
    public final PBEnumField msg_type = PBField.initEnum(0);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBStringField msg_content = PBField.initString("");
    public final PBRepeatMessageField<GameFriendSelectorSvr$RichMsg> rich_msgs = PBField.initRepeatMessage(GameFriendSelectorSvr$RichMsg.class);
    public GameFriendSelectorSvr$ArkData ark_info = new MessageMicro<GameFriendSelectorSvr$ArkData>() { // from class: com.tencent.mobileqq.gamecenter.trpcprotocol.GameFriendSelectorSvr$ArkData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "data"}, new Object[]{0, ""}, GameFriendSelectorSvr$ArkData.class);
        public final PBEnumField type = PBField.initEnum(0);
        public final PBStringField data = PBField.initString("");
    };
    public final PBBoolField need_notice = PBField.initBool(false);
    public final PBBoolField need_read_count = PBField.initBool(false);
    public final PBStringField ext = PBField.initString("");
    public final PBStringField appid = PBField.initString("");

    static {
        String[] strArr = {"sender_id", "receiver_id", "token", "send_type", QQHealthReportApiImpl.MSG_TYPE_KEY, "scene", "msg_content", "rich_msgs", "ark_info", "need_notice", "need_read_count", "ext", "appid"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 58, 66, 74, 80, 88, 98, 106}, strArr, new Object[]{"", "", "", 0, 0, 0, "", null, null, bool, bool, "", ""}, GameFriendSelectorSvr$SendMsgReq.class);
    }
}
