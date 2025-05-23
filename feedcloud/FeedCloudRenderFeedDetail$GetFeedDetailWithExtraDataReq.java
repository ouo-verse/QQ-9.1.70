package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataReq extends MessageMicro<FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"id", "entry_schema", "source", "force_detail", "red_trans_info"}, new Object[]{"", "", 1, Boolean.FALSE, ByteStringMicro.EMPTY}, FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataReq.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398472id = PBField.initString("");
    public final PBStringField entry_schema = PBField.initString("");
    public final PBEnumField source = PBField.initEnum(1);
    public final PBBoolField force_detail = PBField.initBool(false);
    public final PBBytesField red_trans_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
