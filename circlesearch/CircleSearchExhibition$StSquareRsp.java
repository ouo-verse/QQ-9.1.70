package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StSquareRsp extends MessageMicro<CircleSearchExhibition$StSquareRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 82, 90}, new String[]{"bubble_info", "relevant_info", "attach_info", "ext_info"}, new Object[]{null, null, null, null}, CircleSearchExhibition$StSquareRsp.class);
    public CircleSearchExhibition$SquareBubbleInfo bubble_info = new CircleSearchExhibition$SquareBubbleInfo();
    public CircleSearchExhibition$SquareRelevantInfo relevant_info = new CircleSearchExhibition$SquareRelevantInfo();
    public FeedCloudCommon$StCommonExt attach_info = new FeedCloudCommon$StCommonExt();
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
