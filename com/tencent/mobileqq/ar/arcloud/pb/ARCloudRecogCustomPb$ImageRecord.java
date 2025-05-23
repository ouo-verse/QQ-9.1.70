package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$ImageRecord extends MessageMicro<ARCloudRecogCustomPb$ImageRecord> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField angle;
    public final PBInt32Field coordinate_x;
    public final PBInt32Field coordinate_y;
    public final PBInt32Field height;
    public final PBBytesField source_text;
    public final PBBytesField target_text;
    public final PBInt32Field width;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 58}, new String[]{"source_text", "target_text", "coordinate_x", "coordinate_y", "width", "height", "angle"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0, 0, 0, byteStringMicro}, ARCloudRecogCustomPb$ImageRecord.class);
    }

    public ARCloudRecogCustomPb$ImageRecord() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.source_text = PBField.initBytes(byteStringMicro);
        this.target_text = PBField.initBytes(byteStringMicro);
        this.coordinate_x = PBField.initInt32(0);
        this.coordinate_y = PBField.initInt32(0);
        this.width = PBField.initInt32(0);
        this.height = PBField.initInt32(0);
        this.angle = PBField.initBytes(byteStringMicro);
    }
}
