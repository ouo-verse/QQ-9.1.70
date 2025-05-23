package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$ImageTranslateReqInfo extends MessageMicro<ARCloudRecogCustomPb$ImageTranslateReqInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField plateform;
    public final PBBytesField session_uuid;
    public final PBBytesField source_lang;
    public final PBBytesField target_lang;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"session_uuid", "source_lang", "target_lang", "plateform"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, ARCloudRecogCustomPb$ImageTranslateReqInfo.class);
    }

    public ARCloudRecogCustomPb$ImageTranslateReqInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.session_uuid = PBField.initBytes(byteStringMicro);
        this.source_lang = PBField.initBytes(byteStringMicro);
        this.target_lang = PBField.initBytes(byteStringMicro);
        this.plateform = PBField.initBytes(byteStringMicro);
    }
}
