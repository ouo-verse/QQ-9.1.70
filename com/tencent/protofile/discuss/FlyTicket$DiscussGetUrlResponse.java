package com.tencent.protofile.discuss;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class FlyTicket$DiscussGetUrlResponse extends MessageMicro<FlyTicket$DiscussGetUrlResponse> {
    public static final int RET_INFO_FIELD_NUMBER = 1;
    public static final int SHORT_URL_FIELD_NUMBER = 5;
    public static final int SIG_FIELD_NUMBER = 3;
    public static final int URL_FIELD_NUMBER = 2;
    public static final int V_TIME_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"ret_info", "url", PreloadTRTCPlayerParams.KEY_SIG, "v_time", "short_url"}, new Object[]{null, "", "", 0, ""}, FlyTicket$DiscussGetUrlResponse.class);
    public FlyTicket$RetInfo ret_info = new FlyTicket$RetInfo();
    public final PBStringField url = PBField.initString("");
    public final PBStringField sig = PBField.initString("");
    public final PBUInt32Field v_time = PBField.initUInt32(0);
    public final PBStringField short_url = PBField.initString("");
}
