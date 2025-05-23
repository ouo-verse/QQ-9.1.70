package com.tencent.qqavopensdk.IntrenalLogic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class qqavopensdkSsoTunnel$STAVCtrlParamReq extends MessageMicro<qqavopensdkSsoTunnel$STAVCtrlParamReq> {
    public static final int LOCALVER_FIELD_NUMBER = 2;
    public static final int SDKAPPID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"sdkAppId", "localVer"}, new Object[]{0, 0}, qqavopensdkSsoTunnel$STAVCtrlParamReq.class);
    public final PBUInt32Field sdkAppId = PBField.initUInt32(0);
    public final PBUInt32Field localVer = PBField.initUInt32(0);
}
