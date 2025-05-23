package com.tencent.qconn.protofile;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* loaded from: classes22.dex */
public final class preAuth$VirtualProfile extends MessageMicro<preAuth$VirtualProfile> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"vid", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, QCircleSchemeAttr.Detail.AVATAR_URL}, new Object[]{0L, "", ""}, preAuth$VirtualProfile.class);
    public final PBUInt64Field vid = PBField.initUInt64(0);
    public final PBStringField nick_name = PBField.initString("");
    public final PBStringField avatar_url = PBField.initString("");
}
