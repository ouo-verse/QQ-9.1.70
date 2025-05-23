package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$FriendSysMsg extends MessageMicro<FeedCloudWrite$FriendSysMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{402}, new String[]{"bytes_paster_info"}, new Object[]{ByteStringMicro.EMPTY}, FeedCloudWrite$FriendSysMsg.class);
    public final PBBytesField bytes_paster_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
