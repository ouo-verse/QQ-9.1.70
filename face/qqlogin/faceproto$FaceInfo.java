package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class faceproto$FaceInfo extends MessageMicro<faceproto$FaceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"Medias", "RecMode"}, new Object[]{null, 0}, faceproto$FaceInfo.class);
    public final PBRepeatMessageField<faceproto$Media> Medias = PBField.initRepeatMessage(faceproto$Media.class);
    public final PBEnumField RecMode = PBField.initEnum(0);
}
