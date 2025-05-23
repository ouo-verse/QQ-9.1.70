package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StEveryoneSearchRsp extends MessageMicro<CircleSearchExhibition$StEveryoneSearchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ext_info", "everyone_search_infos"}, new Object[]{null, null}, CircleSearchExhibition$StEveryoneSearchRsp.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<CircleSearchExhibition$StEveryoneSearchInfo> everyone_search_infos = PBField.initRepeatMessage(CircleSearchExhibition$StEveryoneSearchInfo.class);
}
