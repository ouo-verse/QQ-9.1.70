package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoAddFriendReq extends MessageMicro<FeedCloudWrite$StDoAddFriendReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 74, 82, 88, 96, 104, 112}, new String[]{"uint64_friend", "uint32_source", "uint32_subsource", "uint32_from_cmd", "uint32_from_service", "uint32_from_version", "uint32_locale_id", "uint32_req_type", "rpt_tag_list", "bytes_msg", "uint32_verifyed", "uint32_common_friend", "uint32_common_group", "uint32_contact_relaton"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, 0, null, ByteStringMicro.EMPTY, 0, 0, 0, 0}, FeedCloudWrite$StDoAddFriendReq.class);
    public final PBUInt64Field uint64_friend = PBField.initUInt64(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subsource = PBField.initUInt32(0);
    public final PBUInt32Field uint32_from_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_from_service = PBField.initUInt32(0);
    public final PBUInt32Field uint32_from_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_locale_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudWrite$AddFriendTagValue> rpt_tag_list = PBField.initRepeatMessage(FeedCloudWrite$AddFriendTagValue.class);
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_verifyed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_common_friend = PBField.initUInt32(0);
    public final PBUInt32Field uint32_common_group = PBField.initUInt32(0);
    public final PBUInt32Field uint32_contact_relaton = PBField.initUInt32(0);
}
