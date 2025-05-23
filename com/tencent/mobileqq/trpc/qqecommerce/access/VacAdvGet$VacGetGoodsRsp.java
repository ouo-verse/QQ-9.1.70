package com.tencent.mobileqq.trpc.qqecommerce.access;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class VacAdvGet$VacGetGoodsRsp extends MessageMicro<VacAdvGet$VacGetGoodsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "total_num", "good_infos", "category_name"}, new Object[]{0, "", 0, null, ""}, VacAdvGet$VacGetGoodsRsp.class);
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBInt32Field total_num = PBField.initInt32(0);
    public final PBRepeatMessageField<VacAdvGet$GoodsInfo> good_infos = PBField.initRepeatMessage(VacAdvGet$GoodsInfo.class);
    public final PBRepeatField<String> category_name = PBField.initRepeat(PBStringField.__repeatHelper__);
}
