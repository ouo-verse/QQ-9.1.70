package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StRecomInfo extends MessageMicro<FeedCloudMeta$StRecomInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField clientSealData;
    public final PBStringField iconUrl;
    public final PBBytesField recomAttachInfo;
    public final PBStringField recomDebugInfo;
    public final PBStringField recomReason = PBField.initString("");
    public final PBInt32Field recomReasonType;
    public final PBInt32Field recomReasonTypeForClinet;
    public FeedCloudMeta$RecomReasonV2 recomReasonV2;
    public final PBBytesField recomSoftADTrans;
    public final PBStringField recomTrace;
    public final PBEnumField reorderType;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 66, 72, 82, 88}, new String[]{"recomReason", "recomAttachInfo", "recomTrace", "clientSealData", "iconUrl", "recomReasonType", "recomDebugInfo", "recomReasonV2", "recomReasonTypeForClinet", "recomSoftADTrans", "reorderType"}, new Object[]{"", byteStringMicro, "", byteStringMicro, "", 0, "", null, 0, byteStringMicro, 0}, FeedCloudMeta$StRecomInfo.class);
    }

    public FeedCloudMeta$StRecomInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.recomAttachInfo = PBField.initBytes(byteStringMicro);
        this.recomTrace = PBField.initString("");
        this.clientSealData = PBField.initBytes(byteStringMicro);
        this.iconUrl = PBField.initString("");
        this.recomReasonType = PBField.initInt32(0);
        this.recomDebugInfo = PBField.initString("");
        this.recomReasonV2 = new FeedCloudMeta$RecomReasonV2();
        this.recomReasonTypeForClinet = PBField.initInt32(0);
        this.recomSoftADTrans = PBField.initBytes(byteStringMicro);
        this.reorderType = PBField.initEnum(0);
    }
}
