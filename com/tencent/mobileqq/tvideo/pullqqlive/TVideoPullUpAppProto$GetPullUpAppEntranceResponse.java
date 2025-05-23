package com.tencent.mobileqq.tvideo.pullqqlive;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes19.dex */
public final class TVideoPullUpAppProto$GetPullUpAppEntranceResponse extends MessageMicro<TVideoPullUpAppProto$GetPullUpAppEntranceResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"errCode", "errMsg", "data"}, new Object[]{0, "", null}, TVideoPullUpAppProto$GetPullUpAppEntranceResponse.class);
    public final PBInt32Field errCode = PBField.initInt32(0);
    public final PBStringField errMsg = PBField.initString("");
    public TVideoPullUpAppProto$PullUpAppEntrance data = new TVideoPullUpAppProto$PullUpAppEntrance();
}
