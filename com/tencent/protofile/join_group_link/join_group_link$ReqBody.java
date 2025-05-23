package com.tencent.protofile.join_group_link;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class join_group_link$ReqBody extends MessageMicro<join_group_link$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField context;
    public final PBBoolField get_ark;
    public final PBBoolField get_token;
    public join_group_link$GroupInfo group_info;
    public final PBBytesField url_param;
    public final PBEnumField msg_type = PBField.initEnum(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0);

    static {
        String[] strArr = {QQHealthReportApiImpl.MSG_TYPE_KEY, "group_code", "context", "url_param", "get_ark", "group_info", "get_token"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 56}, strArr, new Object[]{0, 0L, byteStringMicro, byteStringMicro, bool, null, bool}, join_group_link$ReqBody.class);
    }

    public join_group_link$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.context = PBField.initBytes(byteStringMicro);
        this.url_param = PBField.initBytes(byteStringMicro);
        this.get_ark = PBField.initBool(false);
        this.group_info = new join_group_link$GroupInfo();
        this.get_token = PBField.initBool(false);
    }
}
