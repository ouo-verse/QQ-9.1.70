package com.tencent.biz.pubaccount.pb;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes32.dex */
public final class PublicAccountSettingPB$AppSetReq extends MessageMicro<PublicAccountSettingPB$AppSetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{40, 48, 56, 106}, new String[]{"app_type", "appid", IPublicAccountBrowser.KEY_PUB_UIN, "app_settings"}, new Object[]{0, 0L, 0L, null}, PublicAccountSettingPB$AppSetReq.class);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public PublicAccountSettingPB$AppSetting app_settings = new PublicAccountSettingPB$AppSetting();
}
