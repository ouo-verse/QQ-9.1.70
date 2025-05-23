package com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes11.dex */
public final class oidb_0xe9b$SelectedPicInfo extends MessageMicro<oidb_0xe9b$SelectedPicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"str_ori_pic_url", "str_medium_pic_url", "str_small_pic_url", "str_big_pic_url"}, new Object[]{"", "", "", ""}, oidb_0xe9b$SelectedPicInfo.class);
    public final PBStringField str_ori_pic_url = PBField.initString("");
    public final PBStringField str_medium_pic_url = PBField.initString("");
    public final PBStringField str_small_pic_url = PBField.initString("");
    public final PBStringField str_big_pic_url = PBField.initString("");
}
