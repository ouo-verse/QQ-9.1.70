package com.tencent.pb.share;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.util.QQCustomArkDialogUtil;

/* loaded from: classes22.dex */
public final class PlatPB$QQArk extends MessageMicro<PlatPB$QQArk> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"app", QQCustomArkDialogUtil.BIZ_SRC, "prompt"}, new Object[]{"", "", ""}, PlatPB$QQArk.class);
    public final PBStringField app = PBField.initString("");
    public final PBStringField bizsrc = PBField.initString("");
    public final PBStringField prompt = PBField.initString("");
}
