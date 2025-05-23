package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetFeedDetailReq extends MessageMicro<FeedCloudRead$StGetFeedDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField adAttchInfo;
    public final PBBytesField adres;
    public final PBBytesField bizReqData;
    public FeedCloudMeta$StFeed entryFeed;
    public final PBStringField entrySchema;
    public final PBBoolField isFetchPrimaryMod;
    public final PBBoolField isMiddlePage;
    public final PBBoolField useUGCStore;
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBStringField userId = PBField.initString("");
    public final PBStringField feedId = PBField.initString("");
    public final PBUInt64Field createTime = PBField.initUInt64(0);

    static {
        String[] strArr = {"extInfo", "from", "userId", "feedId", WadlProxyConsts.CREATE_TIME, "adres", "adAttchInfo", "bizReqData", "useUGCStore", "entryFeed", "isMiddlePage", "entrySchema", "isFetchPrimaryMod"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50, 58, 66, 72, 82, 88, 98, 104}, strArr, new Object[]{null, 0, "", "", 0L, byteStringMicro, "", byteStringMicro, bool, null, bool, "", bool}, FeedCloudRead$StGetFeedDetailReq.class);
    }

    public FeedCloudRead$StGetFeedDetailReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.adres = PBField.initBytes(byteStringMicro);
        this.adAttchInfo = PBField.initString("");
        this.bizReqData = PBField.initBytes(byteStringMicro);
        this.useUGCStore = PBField.initBool(false);
        this.entryFeed = new FeedCloudMeta$StFeed();
        this.isMiddlePage = PBField.initBool(false);
        this.entrySchema = PBField.initString("");
        this.isFetchPrimaryMod = PBField.initBool(false);
    }
}
