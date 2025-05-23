package ktvchannel;

import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvImSvr$SendKTVEventReq extends MessageMicro<KtvImSvr$SendKTVEventReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"event"}, new Object[]{null}, KtvImSvr$SendKTVEventReq.class);
    public KtvImSvr$KTVEvent event = new MessageMicro<KtvImSvr$KTVEvent>() { // from class: ktvchannel.KtvImSvr$KTVEvent
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50}, new String[]{AudienceReportConst.ROOM_ID, ShortVideoConstants.FROM_UIN, "to_uin_list", "main_type", "sub_type", AECameraConstants.REQ_FIELD_FONT_CONTENT}, new Object[]{"", 0L, 0L, 0, 0, ByteStringMicro.EMPTY}, KtvImSvr$KTVEvent.class);
        public final PBStringField room_id = PBField.initString("");
        public final PBUInt64Field from_uin = PBField.initUInt64(0);
        public final PBRepeatField<Long> to_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBEnumField main_type = PBField.initEnum(0);
        public final PBEnumField sub_type = PBField.initEnum(0);
        public final PBBytesField Content = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
