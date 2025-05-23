package NS_CERTIFIED_ACCOUNT;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StShareQzoneInfo extends MessageMicro<CertifiedAccountMeta$StShareQzoneInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"entrys"}, new Object[]{null}, CertifiedAccountMeta$StShareQzoneInfo.class);
    public final PBRepeatMessageField<COMM.Entry> entrys = PBField.initRepeatMessage(COMM.Entry.class);
}
