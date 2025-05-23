package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class YoloBattlePartnerOuterClass$YoloBattlePartnerReq extends MessageMicro<YoloBattlePartnerOuterClass$YoloBattlePartnerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 802}, new String[]{"cmd", AudienceReportConst.ROOM_ID, "req_message"}, new Object[]{1, 0L, null}, YoloBattlePartnerOuterClass$YoloBattlePartnerReq.class);
    public final PBEnumField cmd = PBField.initEnum(1);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public YoloBattlePartnerOuterClass$YoloBattlePartnerReqMessage req_message = new MessageMicro<YoloBattlePartnerOuterClass$YoloBattlePartnerReqMessage>() { // from class: com.tencent.icgame.trpc.yes.common.YoloBattlePartnerOuterClass$YoloBattlePartnerReqMessage
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], YoloBattlePartnerOuterClass$YoloBattlePartnerReqMessage.class);
    };
}
