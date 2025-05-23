package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes16.dex */
public final class QQGamePaAdInfo$LoginReportRsp extends MessageMicro<QQGamePaAdInfo$LoginReportRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"cacheTime"}, new Object[]{0}, QQGamePaAdInfo$LoginReportRsp.class);
    public final PBUInt32Field cacheTime = PBField.initUInt32(0);
}
