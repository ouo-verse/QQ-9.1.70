package com.tencent.mobileqq.ar.arcloud.pb;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$ImageARSearchRes extends MessageMicro<ARCloudRecogCustomPb$ImageARSearchRes> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56, 66}, new String[]{"errorcode", "errormsg", ServiceConst.PARA_SESSION_ID, ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "time_ms", LocalPhotoFaceInfo.SCORE, "kpt_num", "coordinate"}, new Object[]{0, "", "", null, 0, 0, 0, null}, ARCloudRecogCustomPb$ImageARSearchRes.class);
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBStringField session_id = PBField.initString("");
    public final PBRepeatMessageField<ARCloudRecogCustomPb$ImageARTag> tags = PBField.initRepeatMessage(ARCloudRecogCustomPb$ImageARTag.class);
    public final PBInt32Field time_ms = PBField.initInt32(0);
    public final PBInt32Field score = PBField.initInt32(0);
    public final PBInt32Field kpt_num = PBField.initInt32(0);
    public ARCloudRecogCustomPb$Coordinate coordinate = new MessageMicro<ARCloudRecogCustomPb$Coordinate>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb$Coordinate
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"int32_x", "int32_y", "int32_width", "int32_height"}, new Object[]{0, 0, 0, 0}, ARCloudRecogCustomPb$Coordinate.class);
        public final PBInt32Field int32_x = PBField.initInt32(0);
        public final PBInt32Field int32_y = PBField.initInt32(0);
        public final PBInt32Field int32_width = PBField.initInt32(0);
        public final PBInt32Field int32_height = PBField.initInt32(0);
    };
}
