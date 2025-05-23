package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$GetFollowStatusReply extends MessageMicro<weather$GetFollowStatusReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{QCircleDaTongConstant.ElementParamValue.FOLLOWED}, new Object[]{Boolean.FALSE}, weather$GetFollowStatusReply.class);
    public final PBBoolField followed = PBField.initBool(false);
}
