package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetFeedListReq extends MessageMicro<FeedCloudRead$StGetFeedListReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField adAttchInfo;
    public final PBBytesField adres;
    public final PBBytesField busiReqData;
    public final PBStringField dstUserId;
    public final PBStringField feedAttchInfo;
    public final PBBoolField isFetchFullScreenFeed;
    public final PBBoolField isFetchPrimaryMod;
    public final PBBoolField isMiddlePage;
    public FeedCloudRead$LoadMoreFeedInfo load_more_info;
    public final PBInt32Field source;
    public final PBInt32Field subSource;
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public final PBInt32Field from = PBField.initInt32(0);
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 58, 80, 90, 98, 104, 112, 122, 128, 136}, new String[]{"extInfo", "listNum", "from", "feed", "adres", "adAttchInfo", "feedAttchInfo", "source", "busiReqData", "dstUserId", "isMiddlePage", "subSource", "load_more_info", "isFetchPrimaryMod", "isFetchFullScreenFeed"}, new Object[]{null, 0, 0, null, byteStringMicro, "", "", 0, byteStringMicro, "", bool, 0, null, bool, bool}, FeedCloudRead$StGetFeedListReq.class);
    }

    public FeedCloudRead$StGetFeedListReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.adres = PBField.initBytes(byteStringMicro);
        this.adAttchInfo = PBField.initString("");
        this.feedAttchInfo = PBField.initString("");
        this.source = PBField.initInt32(0);
        this.busiReqData = PBField.initBytes(byteStringMicro);
        this.dstUserId = PBField.initString("");
        this.isMiddlePage = PBField.initBool(false);
        this.subSource = PBField.initInt32(0);
        this.load_more_info = new FeedCloudRead$LoadMoreFeedInfo();
        this.isFetchPrimaryMod = PBField.initBool(false);
        this.isFetchFullScreenFeed = PBField.initBool(false);
    }
}
