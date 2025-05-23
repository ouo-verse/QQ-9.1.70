package com.tencent.protofile.discuss;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class FlyTicket$DiscussSigDecodeResponse extends MessageMicro<FlyTicket$DiscussSigDecodeResponse> {
    public static final int RET_INFO_FIELD_NUMBER = 1;
    public static final int SIG_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ret_info", PreloadTRTCPlayerParams.KEY_SIG}, new Object[]{null, ""}, FlyTicket$DiscussSigDecodeResponse.class);
    public FlyTicket$RetInfo ret_info = new FlyTicket$RetInfo();
    public final PBStringField sig = PBField.initString("");
}
