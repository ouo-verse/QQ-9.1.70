package com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes27.dex */
public final class ExperienceSvipServerPB$GetExperienceSvipInfoRsp extends MessageMicro<ExperienceSvipServerPB$GetExperienceSvipInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"experience_svip_info", "receive_info", "text_info", "pay_info"}, new Object[]{null, null, null, null}, ExperienceSvipServerPB$GetExperienceSvipInfoRsp.class);
    public ExperienceSvipServerPB$SvipInfo experience_svip_info = new ExperienceSvipServerPB$SvipInfo();
    public ExperienceSvipServerPB$ReceiveInfo receive_info = new ExperienceSvipServerPB$ReceiveInfo();
    public ExperienceSvipServerPB$TextInfo text_info = new ExperienceSvipServerPB$TextInfo();
    public ExperienceSvipServerPB$PayInfo pay_info = new ExperienceSvipServerPB$PayInfo();
}
