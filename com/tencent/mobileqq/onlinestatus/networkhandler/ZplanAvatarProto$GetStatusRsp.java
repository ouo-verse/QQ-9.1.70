package com.tencent.mobileqq.onlinestatus.networkhandler;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class ZplanAvatarProto$GetStatusRsp extends MessageMicro<ZplanAvatarProto$GetStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"key", "check_md5_sha1", "md5", "sha1", "download_url"}, new Object[]{"", Boolean.FALSE, "", "", ""}, ZplanAvatarProto$GetStatusRsp.class);
    public final PBStringField key = PBField.initString("");
    public final PBBoolField check_md5_sha1 = PBField.initBool(false);
    public final PBStringField md5 = PBField.initString("");
    public final PBStringField sha1 = PBField.initString("");
    public final PBStringField download_url = PBField.initString("");
}
