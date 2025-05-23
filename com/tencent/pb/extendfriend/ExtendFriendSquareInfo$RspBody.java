package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ExtendFriendSquareInfo$RspBody extends MessageMicro<ExtendFriendSquareInfo$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cover_url;
    public final PBBytesField bytes_feedback_context;
    public final PBBytesField bytes_rsp_page_cookies;
    public final PBRepeatMessageField<ExtendFriendSquareInfo$StrangerInfo> rpt_msg_stranger_info;
    public final PBUInt32Field uint32_friend_max_votes;
    public final PBUInt32Field uint32_gender;
    public final PBUInt32Field uint32_is_profile_complete;
    public final PBUInt32Field uint32_is_show_card;
    public final PBUInt32Field uint32_match_count;
    public final PBUInt32Field uint32_match_time;
    public final PBUInt32Field uint32_online_num;
    public final PBUInt32Field uint32_total_count;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_over = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 48, 56, 66, 72, 80, 106, 112, 120, 128}, new String[]{"uint64_uin", "uint32_over", "bytes_rsp_page_cookies", "uint32_total_count", "rpt_msg_stranger_info", "uint32_is_profile_complete", "uint32_is_show_card", "bytes_cover_url", "uint32_gender", "uint32_friend_max_votes", "bytes_feedback_context", "uint32_match_count", "uint32_match_time", "uint32_online_num"}, new Object[]{0L, 0, byteStringMicro, 0, null, 0, 0, byteStringMicro, 0, 0, byteStringMicro, 0, 0, 0}, ExtendFriendSquareInfo$RspBody.class);
    }

    public ExtendFriendSquareInfo$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_rsp_page_cookies = PBField.initBytes(byteStringMicro);
        this.uint32_total_count = PBField.initUInt32(0);
        this.rpt_msg_stranger_info = PBField.initRepeatMessage(ExtendFriendSquareInfo$StrangerInfo.class);
        this.uint32_is_profile_complete = PBField.initUInt32(0);
        this.uint32_is_show_card = PBField.initUInt32(0);
        this.bytes_cover_url = PBField.initBytes(byteStringMicro);
        this.uint32_gender = PBField.initUInt32(0);
        this.uint32_friend_max_votes = PBField.initUInt32(0);
        this.bytes_feedback_context = PBField.initBytes(byteStringMicro);
        this.uint32_match_count = PBField.initUInt32(0);
        this.uint32_match_time = PBField.initUInt32(0);
        this.uint32_online_num = PBField.initUInt32(0);
    }
}
