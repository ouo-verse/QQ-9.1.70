package feedcloud;

import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StGetTagBaseAllCategoryRsp extends MessageMicro<FeedCloudTagbasesvr$StGetTagBaseAllCategoryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{IVideoFilterTools.CATEGORYS}, new Object[]{null}, FeedCloudTagbasesvr$StGetTagBaseAllCategoryRsp.class);
    public final PBRepeatMessageField<FeedCloudTagbasesvr$StTagBaseInfo> categorys = PBField.initRepeatMessage(FeedCloudTagbasesvr$StTagBaseInfo.class);
}
