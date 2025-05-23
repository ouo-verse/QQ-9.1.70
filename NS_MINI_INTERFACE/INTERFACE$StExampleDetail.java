package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StExampleDetail extends MessageMicro<INTERFACE$StExampleDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title", "contents"}, new Object[]{"", null}, INTERFACE$StExampleDetail.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<COMM.Entry> contents = PBField.initRepeatMessage(COMM.Entry.class);
}
