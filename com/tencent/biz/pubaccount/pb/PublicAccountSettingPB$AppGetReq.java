package com.tencent.biz.pubaccount.pb;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes32.dex */
public final class PublicAccountSettingPB$AppGetReq extends MessageMicro<PublicAccountSettingPB$AppGetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{40, 48, 56}, new String[]{"app_type", "appid", IPublicAccountBrowser.KEY_PUB_UIN}, new Object[]{0, 0L, 0L}, PublicAccountSettingPB$AppGetReq.class);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBUInt64Field puin = PBField.initUInt64(0);
}
