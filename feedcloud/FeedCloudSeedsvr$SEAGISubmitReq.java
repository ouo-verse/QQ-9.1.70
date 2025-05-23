package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudSeedsvr$SEAGISubmitReq extends MessageMicro<FeedCloudSeedsvr$SEAGISubmitReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"taskType", "memeInput", "comfyInput"}, new Object[]{0, null, null}, FeedCloudSeedsvr$SEAGISubmitReq.class);
    public final PBEnumField taskType = PBField.initEnum(0);
    public FeedCloudSeedsvr$SEAGIMemeInput memeInput = new FeedCloudSeedsvr$SEAGIMemeInput();
    public FeedCloudSeedsvr$SEAGIComfyInput comfyInput = new MessageMicro<FeedCloudSeedsvr$SEAGIComfyInput>() { // from class: feedcloud.FeedCloudSeedsvr$SEAGIComfyInput
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"model", QAdVrReportParams.ParamKey.MEDIA}, new Object[]{"", null}, FeedCloudSeedsvr$SEAGIComfyInput.class);
        public final PBStringField model = PBField.initString("");
        public FeedCloudSeedsvr$SEAGIComfyMedia media = new FeedCloudSeedsvr$SEAGIComfyMedia();
    };
}
