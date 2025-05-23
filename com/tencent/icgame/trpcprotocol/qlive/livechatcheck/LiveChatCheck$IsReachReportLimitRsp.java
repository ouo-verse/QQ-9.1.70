package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$IsReachReportLimitRsp extends MessageMicro<LiveChatCheck$IsReachReportLimitRsp> {
    public static final int RET_CODE_FIELD_NUMBER = 1;
    public static final int STATE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"ret_code", "state"}, new Object[]{0, 0}, LiveChatCheck$IsReachReportLimitRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBUInt32Field state = PBField.initUInt32(0);
}
