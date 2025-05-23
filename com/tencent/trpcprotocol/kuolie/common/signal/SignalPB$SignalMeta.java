package com.tencent.trpcprotocol.kuolie.common.signal;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;

/* loaded from: classes27.dex */
public final class SignalPB$SignalMeta extends MessageMicro<SignalPB$SignalMeta> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50}, new String[]{"partner_id", "partner_name", "partner_adj", "created_at", RemoteMessageConst.TTL, DownloadInfo.spKey_Config}, new Object[]{0L, "", null, 0L, 0L, null}, SignalPB$SignalMeta.class);
    public final PBUInt64Field partner_id = PBField.initUInt64(0);
    public final PBStringField partner_name = PBField.initString("");
    public SignalPB$PartnerAdjective partner_adj = new SignalPB$PartnerAdjective();
    public final PBUInt64Field created_at = PBField.initUInt64(0);
    public final PBUInt64Field ttl = PBField.initUInt64(0);
    public SignalPB$SignalConfig config = new SignalPB$SignalConfig();
}
