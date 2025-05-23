package com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes38.dex */
public final class QqstrangerUserInfoPB$TacitOption extends MessageMicro<QqstrangerUserInfoPB$TacitOption> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{QCircleAlphaUserReporter.KEY_USER, "faq_option"}, new Object[]{0, ""}, QqstrangerUserInfoPB$TacitOption.class);
    public final PBEnumField user = PBField.initEnum(0);
    public final PBStringField faq_option = PBField.initString("");
}
