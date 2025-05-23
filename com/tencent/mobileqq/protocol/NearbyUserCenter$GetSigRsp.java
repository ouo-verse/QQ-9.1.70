package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyUserCenter$GetSigRsp extends MessageMicro<NearbyUserCenter$GetSigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{PreloadTRTCPlayerParams.KEY_SIG}, new Object[]{""}, NearbyUserCenter$GetSigRsp.class);
    public final PBStringField sig = PBField.initString("");
}
