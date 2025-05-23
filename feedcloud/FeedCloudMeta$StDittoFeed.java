package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StDittoFeed extends MessageMicro<FeedCloudMeta$StDittoFeed> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dittoData;
    public final PBBytesField dittoDataNew;
    public final PBUInt32Field dittoId = PBField.initUInt32(0);
    public final PBUInt32Field dittoPatternId = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"dittoId", "dittoPatternId", "dittoData", "dittoDataNew"}, new Object[]{0, 0, byteStringMicro, byteStringMicro}, FeedCloudMeta$StDittoFeed.class);
    }

    public FeedCloudMeta$StDittoFeed() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.dittoData = PBField.initBytes(byteStringMicro);
        this.dittoDataNew = PBField.initBytes(byteStringMicro);
    }
}
