package com.tencent.trpcprotocol.kuolie.gray_ctrl.gray_ctrl;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class GrayCtrl$EntranceCtrlReq extends MessageMicro<GrayCtrl$EntranceCtrlReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{QCircleDaTongConstant.ElementParamKey.XSJ_QQ_MODE}, new Object[]{0}, GrayCtrl$EntranceCtrlReq.class);
    public final PBEnumField qq_mode = PBField.initEnum(0);
}
