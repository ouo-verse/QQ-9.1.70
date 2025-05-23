package com.tencent.qqavopensdk.IntrenalLogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;

/* loaded from: classes22.dex */
public final class qqavopensdkSsoTunnel$STAVCtrlParamRsp extends MessageMicro<qqavopensdkSsoTunnel$STAVCtrlParamRsp> {
    public static final int CTRLPARAM_FIELD_NUMBER = 3;
    public static final int SVRVER_FIELD_NUMBER = 2;
    public static final int UPDATEFLAG_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{VasWebviewConstants.KEY_UPDATE_FLAG, "svrVer", "ctrlParam"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, qqavopensdkSsoTunnel$STAVCtrlParamRsp.class);
    public final PBUInt32Field updateFlag = PBField.initUInt32(0);
    public final PBUInt32Field svrVer = PBField.initUInt32(0);
    public final PBBytesField ctrlParam = PBField.initBytes(ByteStringMicro.EMPTY);
}
