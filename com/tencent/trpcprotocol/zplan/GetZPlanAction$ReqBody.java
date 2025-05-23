package com.tencent.trpcprotocol.zplan;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class GetZPlanAction$ReqBody extends MessageMicro<GetZPlanAction$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"type", GetCMShowInfoServlet.EXTRA_ENGINE_VERSION, AppConstants.Key.EXTRA_TYPE, "seq"}, new Object[]{0, "", 0, ""}, GetZPlanAction$ReqBody.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField engine_version = PBField.initString("");
    public final PBRepeatField<Integer> extra_type = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBStringField seq = PBField.initString("");
}
