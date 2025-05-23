package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StVideo extends MessageMicro<CertifiedAccountMeta$StVideo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 56, 64, 72, 82}, new String[]{"fileId", "fileSize", "duration", "width", "height", "playUrl", "transStatus", "videoPrior", "videoRate", "vecVideoUrl"}, new Object[]{"", 0, 0, 0, 0, "", 0, 0, 0, null}, CertifiedAccountMeta$StVideo.class);
    public final PBStringField fileId = PBField.initString("");
    public final PBUInt32Field fileSize = PBField.initUInt32(0);
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField playUrl = PBField.initString("");
    public final PBUInt32Field transStatus = PBField.initUInt32(0);
    public final PBUInt32Field videoPrior = PBField.initUInt32(0);
    public final PBUInt32Field videoRate = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta$StVideoUrl> vecVideoUrl = PBField.initRepeatMessage(CertifiedAccountMeta$StVideoUrl.class);
}
