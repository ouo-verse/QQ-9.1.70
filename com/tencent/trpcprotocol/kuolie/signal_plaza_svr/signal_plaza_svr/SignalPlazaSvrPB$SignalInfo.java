package com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalMeta;
import com.tencent.trpcprotocol.qqstranger.common.tag.TagPB$Tag;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* loaded from: classes27.dex */
public final class SignalPlazaSvrPB$SignalInfo extends MessageMicro<SignalPlazaSvrPB$SignalInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"open_id", "signal_meta", "nick", "avatar", "user_status", "same_tags", "my_ark_tags", "recom_trace", LpReport_UserInfo_dc02148.CONSTELLATION}, new Object[]{"", null, "", "", "", null, null, "", ""}, SignalPlazaSvrPB$SignalInfo.class);
    public final PBStringField open_id = PBField.initString("");
    public SignalPB$SignalMeta signal_meta = new SignalPB$SignalMeta();
    public final PBStringField nick = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField user_status = PBField.initString("");
    public final PBRepeatMessageField<TagPB$Tag> same_tags = PBField.initRepeatMessage(TagPB$Tag.class);
    public final PBRepeatMessageField<TagPB$Tag> my_ark_tags = PBField.initRepeatMessage(TagPB$Tag.class);
    public final PBStringField recom_trace = PBField.initString("");
    public final PBStringField constellation = PBField.initString("");
}
