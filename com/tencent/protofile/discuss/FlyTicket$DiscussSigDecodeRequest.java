package com.tencent.protofile.discuss;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class FlyTicket$DiscussSigDecodeRequest extends MessageMicro<FlyTicket$DiscussSigDecodeRequest> {
    public static final int SIG_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{PreloadTRTCPlayerParams.KEY_SIG}, new Object[]{""}, FlyTicket$DiscussSigDecodeRequest.class);
    public final PBStringField sig = PBField.initString("");
}
