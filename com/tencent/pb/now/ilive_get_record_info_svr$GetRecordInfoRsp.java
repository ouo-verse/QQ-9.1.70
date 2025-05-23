package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_get_record_info_svr$GetRecordInfoRsp extends MessageMicro<ilive_get_record_info_svr$GetRecordInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"result", "record_info"}, new Object[]{0, null}, ilive_get_record_info_svr$GetRecordInfoRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public ilive_get_record_info_svr$RecordInfo record_info = new MessageMicro<ilive_get_record_info_svr$RecordInfo>() { // from class: com.tencent.pb.now.ilive_get_record_info_svr$RecordInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"record_video_url", "cmd5", "record_duration", ShortVideoConstants.FILE_FORMAT, "vid_state"}, new Object[]{"", "", 0, 0, 0}, ilive_get_record_info_svr$RecordInfo.class);
        public final PBStringField record_video_url = PBField.initString("");
        public final PBStringField cmd5 = PBField.initString("");
        public final PBUInt32Field record_duration = PBField.initUInt32(0);
        public final PBUInt32Field file_format = PBField.initUInt32(0);
        public final PBUInt32Field vid_state = PBField.initUInt32(0);
    };
}
