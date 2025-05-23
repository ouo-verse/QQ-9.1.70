package com.tencent.pb.scupdate;

import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class SCUpdatePB$UpdateInfo extends MessageMicro<SCUpdatePB$UpdateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56, 66, 72, 82, 88, 98}, new String[]{"bid", "scid", "dst_version", "src_version", "delta_mode", "storage_mode", "compress_mode", "url", MediaDBValues.FILESIZE, "filecontent", "code", "extendinfo"}, new Object[]{0, "", "", "", 0, 0, 0, "", 0L, ByteStringMicro.EMPTY, 0, null}, SCUpdatePB$UpdateInfo.class);
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBStringField scid = PBField.initString("");
    public final PBStringField dst_version = PBField.initString("");
    public final PBStringField src_version = PBField.initString("");
    public final PBUInt32Field delta_mode = PBField.initUInt32(0);
    public final PBUInt32Field storage_mode = PBField.initUInt32(0);
    public final PBUInt32Field compress_mode = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBInt64Field filesize = PBField.initInt64(0);
    public final PBBytesField filecontent = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field code = PBField.initInt32(0);
    public SCUpdatePB$ItemExtend extendinfo = new SCUpdatePB$ItemExtend();
}
