package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetGoodsDetailRsp extends MessageMicro<FeedCloudRead$StGetGoodsDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"EGoodsRsp", "extInfo"}, new Object[]{"", null}, FeedCloudRead$StGetGoodsDetailRsp.class);
    public final PBStringField EGoodsRsp = PBField.initString("");
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
}
