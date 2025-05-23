package feedcloud;

import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudSeedsvr$SEGetComfyModelsRsp extends MessageMicro<FeedCloudSeedsvr$SEGetComfyModelsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{IQQGameCommApi.K_ABTEST_MODELS}, new Object[]{null}, FeedCloudSeedsvr$SEGetComfyModelsRsp.class);
    public final PBRepeatMessageField<FeedCloudSeedsvr$SEComfyModel> models = PBField.initRepeatMessage(FeedCloudSeedsvr$SEComfyModel.class);
}
