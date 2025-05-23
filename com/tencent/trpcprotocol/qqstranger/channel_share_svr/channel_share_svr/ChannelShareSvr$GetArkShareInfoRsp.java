package com.tencent.trpcprotocol.qqstranger.channel_share_svr.channel_share_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ChannelShareSvr$GetArkShareInfoRsp extends MessageMicro<ChannelShareSvr$GetArkShareInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"ret_code", "err_msg", "ark_message", "beat", "toast"}, new Object[]{0, "", "", Boolean.FALSE, ""}, ChannelShareSvr$GetArkShareInfoRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBStringField ark_message = PBField.initString("");
    public final PBBoolField beat = PBField.initBool(false);
    public final PBStringField toast = PBField.initString("");
}
