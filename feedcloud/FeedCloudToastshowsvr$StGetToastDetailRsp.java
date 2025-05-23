package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudToastshowsvr$StGetToastDetailRsp extends MessageMicro<FeedCloudToastshowsvr$StGetToastDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "toastInfo"}, new Object[]{null, null}, FeedCloudToastshowsvr$StGetToastDetailRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudToastshowsvr$StToast toastInfo = new FeedCloudToastshowsvr$StToast();
}
