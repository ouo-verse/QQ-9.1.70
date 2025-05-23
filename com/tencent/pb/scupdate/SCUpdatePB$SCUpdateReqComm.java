package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.xweb.FileReaderHelper;

/* loaded from: classes22.dex */
public final class SCUpdatePB$SCUpdateReqComm extends MessageMicro<SCUpdatePB$SCUpdateReqComm> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field appid;
    public final PBStringField appver;
    public final PBInt64Field cookie;
    public final PBUInt32Field force;
    public final PBBytesField from;
    public final PBInt32Field network;
    public final PBBytesField osrelease;
    public final PBUInt32Field plat = PBField.initUInt32(0);
    public final PBBytesField qver;
    public final PBStringField sceneinfo;
    public final PBUInt64Field uid;

    static {
        String[] strArr = {"plat", "qver", "osrelease", "network", "from", "cookie", "appid", "uid", FileReaderHelper.OPEN_FILE_FROM_FORCE, "appver", "sceneinfo"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48, 56, 64, 72, 82, 90}, strArr, new Object[]{0, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0L, 0, 0L, 0, "", ""}, SCUpdatePB$SCUpdateReqComm.class);
    }

    public SCUpdatePB$SCUpdateReqComm() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.qver = PBField.initBytes(byteStringMicro);
        this.osrelease = PBField.initBytes(byteStringMicro);
        this.network = PBField.initInt32(0);
        this.from = PBField.initBytes(byteStringMicro);
        this.cookie = PBField.initInt64(0L);
        this.appid = PBField.initUInt32(0);
        this.uid = PBField.initUInt64(0L);
        this.force = PBField.initUInt32(0);
        this.appver = PBField.initString("");
        this.sceneinfo = PBField.initString("");
    }
}
