package com.tencent.trpcprotocol.zplan;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class CheckZplanAccessableAction$CheckAccessableRequest extends MessageMicro<CheckZplanAccessableAction$CheckAccessableRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 802}, new String[]{"uins", "appids", "phone_type", "client_version", "hardware_info"}, new Object[]{0L, 0L, "", "", ByteStringMicro.EMPTY}, CheckZplanAccessableAction$CheckAccessableRequest.class);
    public final PBRepeatField<Long> appids;
    public final PBStringField client_version;
    public final PBBytesField hardware_info;
    public final PBStringField phone_type;
    public final PBRepeatField<Long> uins;

    public CheckZplanAccessableAction$CheckAccessableRequest() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.uins = PBField.initRepeat(pBUInt64Field);
        this.appids = PBField.initRepeat(pBUInt64Field);
        this.phone_type = PBField.initString("");
        this.client_version = PBField.initString("");
        this.hardware_info = PBField.initBytes(ByteStringMicro.EMPTY);
    }
}
