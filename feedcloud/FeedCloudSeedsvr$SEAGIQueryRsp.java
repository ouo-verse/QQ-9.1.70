package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudSeedsvr$SEAGIQueryRsp extends MessageMicro<FeedCloudSeedsvr$SEAGIQueryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 21, 26, 34}, new String[]{"taskStatus", "queryInterval", "memeOutput", "comfyOutput"}, new Object[]{0, Float.valueOf(0.0f), null, null}, FeedCloudSeedsvr$SEAGIQueryRsp.class);
    public final PBEnumField taskStatus = PBField.initEnum(0);
    public final PBFloatField queryInterval = PBField.initFloat(0.0f);
    public FeedCloudSeedsvr$SEAGIMemeOutput memeOutput = new FeedCloudSeedsvr$SEAGIMemeOutput();
    public FeedCloudSeedsvr$SEAGIComfyOutput comfyOutput = new MessageMicro<FeedCloudSeedsvr$SEAGIComfyOutput>() { // from class: feedcloud.FeedCloudSeedsvr$SEAGIComfyOutput
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{QAdVrReportParams.ParamKey.MEDIA}, new Object[]{null}, FeedCloudSeedsvr$SEAGIComfyOutput.class);
        public FeedCloudSeedsvr$SEAGIComfyMedia media = new FeedCloudSeedsvr$SEAGIComfyMedia();
    };
}
