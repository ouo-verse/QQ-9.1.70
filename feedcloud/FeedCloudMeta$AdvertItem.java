package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$AdvertItem extends MessageMicro<FeedCloudMeta$AdvertItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"id", "feed_id", TransactionActivity.PREF_NAME_TRANSFER}, new Object[]{0L, "", ByteStringMicro.EMPTY}, FeedCloudMeta$AdvertItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt64Field f398437id = PBField.initInt64(0);
    public final PBStringField feed_id = PBField.initString("");
    public final PBBytesField transfer = PBField.initBytes(ByteStringMicro.EMPTY);
}
