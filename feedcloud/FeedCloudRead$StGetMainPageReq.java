package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetMainPageReq extends MessageMicro<FeedCloudRead$StGetMainPageReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField adres;
    public final PBBytesField busiReqData;
    public final PBInt32Field clientFrom;
    public final PBUInt32Field draftBoxNum;
    public final PBUInt32Field feed_list_type;
    public final PBBoolField isFetchPrimaryMod;
    public final PBBoolField isMiddlePage;
    public final PBUInt64Field lastEnterMainpageTime;
    public final PBBoolField needFeed;
    public final PBBoolField needTaskEntry;
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField userId = PBField.initString("");
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBStringField feedAttchInfo = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48, 56, 64, 72, 80, 88, 98, 104, 112}, new String[]{"extInfo", "userId", "from", "feedAttchInfo", "busiReqData", "needFeed", "isMiddlePage", "lastEnterMainpageTime", "draftBoxNum", "needTaskEntry", "isFetchPrimaryMod", "adres", "clientFrom", "feed_list_type"}, new Object[]{null, "", 0, "", byteStringMicro, bool, bool, 0L, 0, bool, bool, byteStringMicro, 0, 0}, FeedCloudRead$StGetMainPageReq.class);
    }

    public FeedCloudRead$StGetMainPageReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.busiReqData = PBField.initBytes(byteStringMicro);
        this.needFeed = PBField.initBool(false);
        this.isMiddlePage = PBField.initBool(false);
        this.lastEnterMainpageTime = PBField.initUInt64(0L);
        this.draftBoxNum = PBField.initUInt32(0);
        this.needTaskEntry = PBField.initBool(false);
        this.isFetchPrimaryMod = PBField.initBool(false);
        this.adres = PBField.initBytes(byteStringMicro);
        this.clientFrom = PBField.initInt32(0);
        this.feed_list_type = PBField.initUInt32(0);
    }
}
