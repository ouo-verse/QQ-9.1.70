package com.tencent.trpcprotocol.qqstranger.channel_share_svr.channel_share_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ChannelShareSvr$SecurityInfo extends MessageMicro<ChannelShareSvr$SecurityInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"beat", "toast"}, new Object[]{Boolean.FALSE, ""}, ChannelShareSvr$SecurityInfo.class);
    public final PBBoolField beat = PBField.initBool(false);
    public final PBStringField toast = PBField.initString("");
}
