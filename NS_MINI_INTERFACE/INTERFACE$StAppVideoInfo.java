package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import s4.c;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StAppVideoInfo extends MessageMicro<INTERFACE$StAppVideoInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"video", c.PICS}, new Object[]{null, null}, INTERFACE$StAppVideoInfo.class);
    public INTERFACE$StAppMediaInfo video = new INTERFACE$StAppMediaInfo();
    public final PBRepeatMessageField<INTERFACE$StAppMediaInfo> pics = PBField.initRepeatMessage(INTERFACE$StAppMediaInfo.class);
}
