package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class faceproto$Media extends MessageMicro<faceproto$Media> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"Tag", "Type", "Size", Action.TAG}, new Object[]{0, 0, 0, ""}, faceproto$Media.class);
    public final PBEnumField Tag = PBField.initEnum(0);
    public final PBEnumField Type = PBField.initEnum(0);
    public final PBUInt32Field Size = PBField.initUInt32(0);
    public final PBStringField Action = PBField.initString("");
}
