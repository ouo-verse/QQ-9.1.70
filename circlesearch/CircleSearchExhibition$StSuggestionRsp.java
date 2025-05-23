package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StSuggestionRsp extends MessageMicro<CircleSearchExhibition$StSuggestionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ext_info", "infos"}, new Object[]{null, null}, CircleSearchExhibition$StSuggestionRsp.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<CircleSearchExhibition$StSuggestionInfo> infos = PBField.initRepeatMessage(CircleSearchExhibition$StSuggestionInfo.class);
}
