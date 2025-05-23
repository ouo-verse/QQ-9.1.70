package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class BaseInterfaceOuterClass$CSQQAccessReply extends MessageMicro<BaseInterfaceOuterClass$CSQQAccessReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 72, 82}, new String[]{"rsp_header", "account_info", "body_type", "rsp_body"}, new Object[]{null, null, 0, ByteStringMicro.EMPTY}, BaseInterfaceOuterClass$CSQQAccessReply.class);
    public BaseInterfaceOuterClass$CSQQAccessRspHeader rsp_header = new BaseInterfaceOuterClass$CSQQAccessRspHeader();
    public BaseInterfaceOuterClass$AccountInfo account_info = new MessageMicro<BaseInterfaceOuterClass$AccountInfo>() { // from class: com.tencent.icgame.trpc.yes.common.BaseInterfaceOuterClass$AccountInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"yes_uid"}, new Object[]{0L}, BaseInterfaceOuterClass$AccountInfo.class);
        public final PBUInt64Field yes_uid = PBField.initUInt64(0);
    };
    public final PBEnumField body_type = PBField.initEnum(0);
    public final PBBytesField rsp_body = PBField.initBytes(ByteStringMicro.EMPTY);
}
