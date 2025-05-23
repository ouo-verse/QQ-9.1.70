package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetRecomUserListReq extends MessageMicro<FeedCloudRead$StGetRecomUserListReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBBoolField needFeeds = PBField.initBool(false);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field listType = PBField.initInt32(0);
    public final PBBoolField needStFeeds = PBField.initBool(false);
    public final PBInt32Field sceneID = PBField.initInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48, 56}, new String[]{"extInfo", "needFeeds", "attachInfo", "busiReqData", "listType", "needStFeeds", "sceneID"}, new Object[]{null, bool, "", ByteStringMicro.EMPTY, 0, bool, 0}, FeedCloudRead$StGetRecomUserListReq.class);
    }
}
