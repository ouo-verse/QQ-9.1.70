package com.tencent.trpcprotocol.qqstranger.channel_share_svr.channel_share_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ChannelShareSvr$ArkShareCheckRsp extends MessageMicro<ChannelShareSvr$ArkShareCheckRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40}, new String[]{"ret_code", "err_msg", "beat", "toast", "style"}, new Object[]{0, "", Boolean.FALSE, "", 0}, ChannelShareSvr$ArkShareCheckRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBBoolField beat = PBField.initBool(false);
    public final PBStringField toast = PBField.initString("");
    public final PBEnumField style = PBField.initEnum(0);
}
