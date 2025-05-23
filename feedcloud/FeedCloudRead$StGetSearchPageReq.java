package feedcloud;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetSearchPageReq extends MessageMicro<FeedCloudRead$StGetSearchPageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 58, 66, 74, 82}, new String[]{"source", "searchReqScene", QFSSearchBaseRequest.EXTRA_KEY_SEARCH_TYPE, "word", "attachInfo", "from", "extInfo", "trans_info", "adRequest", "filters"}, new Object[]{0, 1, 1, "", "", 0, null, "", ByteStringMicro.EMPTY, ""}, FeedCloudRead$StGetSearchPageReq.class);
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBEnumField searchReqScene = PBField.initEnum(1);
    public final PBRepeatField<Integer> searchType = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBStringField word = PBField.initString("");
    public final PBStringField attachInfo = PBField.initString("");
    public final PBInt32Field from = PBField.initInt32(0);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField trans_info = PBField.initString("");
    public final PBBytesField adRequest = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<String> filters = PBField.initRepeat(PBStringField.__repeatHelper__);
}
