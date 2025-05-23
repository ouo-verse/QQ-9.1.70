package feedcloud;

import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudAigcsvr$GetModelsRsp extends MessageMicro<FeedCloudAigcsvr$GetModelsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{IQQGameCommApi.K_ABTEST_MODELS}, new Object[]{null}, FeedCloudAigcsvr$GetModelsRsp.class);
    public final PBRepeatMessageField<FeedCloudAigcsvr$Model> models = PBField.initRepeatMessage(FeedCloudAigcsvr$Model.class);
}
