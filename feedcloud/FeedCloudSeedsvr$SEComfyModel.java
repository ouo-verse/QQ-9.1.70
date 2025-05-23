package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudSeedsvr$SEComfyModel extends MessageMicro<FeedCloudSeedsvr$SEComfyModel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"model", "iconUrl", "description", QZoneDTLoginReporter.SCHEMA}, new Object[]{"", "", "", ""}, FeedCloudSeedsvr$SEComfyModel.class);
    public final PBStringField model = PBField.initString("");
    public final PBStringField iconUrl = PBField.initString("");
    public final PBStringField description = PBField.initString("");
    public final PBStringField schema = PBField.initString("");
}
