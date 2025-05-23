package com.tencent.mobileqq.qwallet.pb;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes16.dex */
public final class WxQrcodePayEncrypt$EncryptReq extends MessageMicro<WxQrcodePayEncrypt$EncryptReq> {
    public static final int FROM_ALBUM = 2;
    public static final int FROM_CHAT = 3;
    public static final int FROM_SCAN = 1;
    public static final int UNKNOWN = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{WadlProxyConsts.CHANNEL}, new Object[]{0}, WxQrcodePayEncrypt$EncryptReq.class);
    public final PBEnumField channel = PBField.initEnum(0);
}
