package fudai;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.rmonitor.custom.ICustomDataEditor;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class fd_comm$AuthInfo extends MessageMicro<fd_comm$AuthInfo> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: a8, reason: collision with root package name */
    public final PBBytesField f400838a8;
    public final PBUInt32Field appid;
    public final PBUInt32Field city_code;
    public final PBStringField imei;
    public final PBStringField latitude;
    public final PBStringField longitude;
    public final PBUInt32Field net_type;
    public final PBBytesField skey;
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field ctime = PBField.initUInt32(0);

    static {
        String[] strArr = {"uin", "ctime", "skey", ICustomDataEditor.STRING_ARRAY_PARAM_8, "appid", "net_type", "imei", "longitude", "latitude", "city_code"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 88, 98, 170, 178, 184}, strArr, new Object[]{0L, 0, byteStringMicro, byteStringMicro, 0, 0, "", "", "", 0}, fd_comm$AuthInfo.class);
    }

    public fd_comm$AuthInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.skey = PBField.initBytes(byteStringMicro);
        this.f400838a8 = PBField.initBytes(byteStringMicro);
        this.appid = PBField.initUInt32(0);
        this.net_type = PBField.initUInt32(0);
        this.imei = PBField.initString("");
        this.longitude = PBField.initString("");
        this.latitude = PBField.initString("");
        this.city_code = PBField.initUInt32(0);
    }
}
