package ktvchannel;

import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvImSvr$KTVChannelMsg extends MessageMicro<KtvImSvr$KTVChannelMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"event_sub_type", AECameraConstants.REQ_FIELD_FONT_CONTENT}, new Object[]{0L, ByteStringMicro.EMPTY}, KtvImSvr$KTVChannelMsg.class);
    public final PBUInt64Field event_sub_type = PBField.initUInt64(0);
    public final PBBytesField Content = PBField.initBytes(ByteStringMicro.EMPTY);
}
