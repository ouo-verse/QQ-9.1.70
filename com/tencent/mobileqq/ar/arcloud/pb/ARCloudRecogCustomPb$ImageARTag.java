package com.tencent.mobileqq.ar.arcloud.pb;

import com.qzone.component.cache.database.table.photo.LocalPhotoTagClassifyInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$ImageARTag extends MessageMicro<ARCloudRecogCustomPb$ImageARTag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 37, 40, 808, 818, 824}, new String[]{"image_id", "tag_name", LocalPhotoTagClassifyInfo.TAG_CONFIDENCE, "tag_confidence_f", "need_check_lbs", "cdb_errorcode", "cdb_res", "conf_id"}, new Object[]{"", "", 0, Float.valueOf(0.0f), 0, 0, ByteStringMicro.EMPTY, 0}, ARCloudRecogCustomPb$ImageARTag.class);
    public final PBStringField image_id = PBField.initString("");
    public final PBStringField tag_name = PBField.initString("");
    public final PBInt32Field tag_confidence = PBField.initInt32(0);
    public final PBFloatField tag_confidence_f = PBField.initFloat(0.0f);
    public final PBUInt32Field need_check_lbs = PBField.initUInt32(0);
    public final PBInt32Field cdb_errorcode = PBField.initInt32(0);
    public final PBBytesField cdb_res = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field conf_id = PBField.initInt32(0);
}
