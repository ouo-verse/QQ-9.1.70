package com.tencent.jungle.nearby.nio.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class nearby$Cmd0x1RspBody extends MessageMicro<nearby$Cmd0x1RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public nearby$FansInfo FansInfo_fans;
    public final PBBoolField bool_follow;
    public final PBBytesField bytes_aio_grey_tips_wording;
    public final PBBytesField bytes_bars_url;
    public final PBBytesField bytes_chat_sig;
    public final PBBytesField bytes_err_msg;
    public oidb_common$DataCardConfig bytes_face_score_config;
    public final PBBytesField bytes_feed_wording;
    public final PBBytesField bytes_feed_wording_title;
    public final PBBytesField bytes_feeds_url;
    public final PBBytesField bytes_mask_gift_reason;
    public final PBBytesField bytes_mask_msg_reason;
    public final PBBytesField bytes_official_wording;
    public final PBBytesField bytes_qunlist_url;
    public nearby$NearbyJumpInfo nearby_popover_info;
    public final PBRepeatMessageField<nearby$BarInfo> rpt_BarInfo_bars;
    public final PBRepeatMessageField<nearby$FeedInfo> rpt_FeedInfo_feeds;
    public final PBStringField str_jump_app_result_msg;
    public final PBStringField str_jump_app_url;
    public final PBStringField str_plus_download_app_msg;
    public final PBUInt32Field uint32_bars_num;
    public final PBUInt32Field uint32_high_score_num;
    public final PBUInt32Field uint32_if_mask_gift;
    public final PBUInt32Field uint32_if_mask_msg;
    public final PBUInt32Field uint32_jump_app_open;
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_err_code = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 56, 66, 74, 82, 90, 96, 104, 114, 120, 130, 138, 146, 152, 162, 168, 178, 186, 194, 202, 210, 218}, new String[]{"uint32_seq", "uint32_err_code", "bytes_err_msg", "rpt_FeedInfo_feeds", "bytes_feeds_url", "rpt_BarInfo_bars", "uint32_bars_num", "bytes_bars_url", "FansInfo_fans", "bytes_qunlist_url", "bytes_chat_sig", "bool_follow", "uint32_if_mask_msg", "bytes_mask_msg_reason", "uint32_if_mask_gift", "bytes_mask_gift_reason", "bytes_feed_wording", "bytes_feed_wording_title", "uint32_high_score_num", "bytes_face_score_config", "uint32_jump_app_open", "str_jump_app_result_msg", "str_jump_app_url", "str_plus_download_app_msg", "nearby_popover_info", "bytes_official_wording", "bytes_aio_grey_tips_wording"}, new Object[]{0, 0, byteStringMicro, null, byteStringMicro, null, 0, byteStringMicro, null, byteStringMicro, byteStringMicro, Boolean.FALSE, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, null, 0, "", "", "", null, byteStringMicro, byteStringMicro}, nearby$Cmd0x1RspBody.class);
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.tencent.jungle.nearby.nio.proto.nearby$FansInfo] */
    public nearby$Cmd0x1RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_err_msg = PBField.initBytes(byteStringMicro);
        this.rpt_FeedInfo_feeds = PBField.initRepeatMessage(nearby$FeedInfo.class);
        this.bytes_feeds_url = PBField.initBytes(byteStringMicro);
        this.rpt_BarInfo_bars = PBField.initRepeatMessage(nearby$BarInfo.class);
        this.uint32_bars_num = PBField.initUInt32(0);
        this.bytes_bars_url = PBField.initBytes(byteStringMicro);
        this.FansInfo_fans = new MessageMicro<nearby$FansInfo>() { // from class: com.tencent.jungle.nearby.nio.proto.nearby$FansInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_fans_url;
            public final PBBytesField bytes_follows_url;
            public final PBUInt32Field uint32_fans_num = PBField.initUInt32(0);
            public final PBUInt32Field uint32_follows_num;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uint32_fans_num", "bytes_fans_url", "uint32_follows_num", "bytes_follows_url"}, new Object[]{0, byteStringMicro2, 0, byteStringMicro2}, nearby$FansInfo.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.bytes_fans_url = PBField.initBytes(byteStringMicro2);
                this.uint32_follows_num = PBField.initUInt32(0);
                this.bytes_follows_url = PBField.initBytes(byteStringMicro2);
            }
        };
        this.bytes_qunlist_url = PBField.initBytes(byteStringMicro);
        this.bytes_chat_sig = PBField.initBytes(byteStringMicro);
        this.bool_follow = PBField.initBool(false);
        this.uint32_if_mask_msg = PBField.initUInt32(0);
        this.bytes_mask_msg_reason = PBField.initBytes(byteStringMicro);
        this.uint32_if_mask_gift = PBField.initUInt32(0);
        this.bytes_mask_gift_reason = PBField.initBytes(byteStringMicro);
        this.bytes_feed_wording = PBField.initBytes(byteStringMicro);
        this.bytes_feed_wording_title = PBField.initBytes(byteStringMicro);
        this.uint32_high_score_num = PBField.initUInt32(0);
        this.bytes_face_score_config = new oidb_common$DataCardConfig();
        this.uint32_jump_app_open = PBField.initUInt32(0);
        this.str_jump_app_result_msg = PBField.initString("");
        this.str_jump_app_url = PBField.initString("");
        this.str_plus_download_app_msg = PBField.initString("");
        this.nearby_popover_info = new nearby$NearbyJumpInfo();
        this.bytes_official_wording = PBField.initBytes(byteStringMicro);
        this.bytes_aio_grey_tips_wording = PBField.initBytes(byteStringMicro);
    }
}
