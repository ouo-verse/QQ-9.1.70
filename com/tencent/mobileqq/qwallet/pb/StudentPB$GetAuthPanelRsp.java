package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class StudentPB$GetAuthPanelRsp extends MessageMicro<StudentPB$GetAuthPanelRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50}, new String[]{"app_name", MiniConst.WxMiniAppInfoConst.EXTRA_ICON, "title", "content", "is_student", "refuse_result"}, new Object[]{"", "", "", "", Boolean.FALSE, ""}, StudentPB$GetAuthPanelRsp.class);
    public final PBStringField app_name = PBField.initString("");
    public final PBStringField app_icon = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBBoolField is_student = PBField.initBool(false);
    public final PBStringField refuse_result = PBField.initString("");
}
