package feedcloud;

import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetRelationGroupListRsp extends MessageMicro<FeedCloudRead$StGetRelationGroupListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "groupList", MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL}, new Object[]{null, null, 0L}, FeedCloudRead$StGetRelationGroupListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudRead$RelationGroup> groupList = PBField.initRepeatMessage(FeedCloudRead$RelationGroup.class);
    public final PBInt64Field timeInterval = PBField.initInt64(0);
}
