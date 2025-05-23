package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetPublishPageRecomTagListReq extends MessageMicro<FeedCloudRead$StGetPublishPageRecomTagListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48}, new String[]{"from", "word", "matchTagNameList", "attachInfo", "picRecomMap", "sceneType"}, new Object[]{0, "", "", "", null, 0}, FeedCloudRead$StGetPublishPageRecomTagListReq.class);
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBStringField word = PBField.initString("");
    public final PBRepeatField<String> matchTagNameList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudRead$PicRecomEntry> picRecomMap = PBField.initRepeatMessage(FeedCloudRead$PicRecomEntry.class);
    public final PBInt32Field sceneType = PBField.initInt32(0);
}
