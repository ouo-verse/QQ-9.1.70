package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class TimDocSSOMsg$PadInfo extends MessageMicro<TimDocSSOMsg$PadInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_delete_flag;
    public final PBBoolField bool_pinned_flag;
    public final PBBytesField bytes_creator_nick;
    public final PBBytesField bytes_hostuser_nick;
    public final PBBytesField bytes_last_editor_nick;
    public final PBBytesField bytes_last_viewer_nick;
    public final PBBytesField bytes_localpadid;
    public final PBBytesField bytes_pad_url;
    public final PBBytesField bytes_thumb_url;
    public final PBBytesField bytes_title;
    public final PBUInt32Field uint32_domainid;
    public final PBUInt32Field uint32_policy;
    public final PBUInt32Field uint32_right_flag;
    public final PBUInt32Field uint32_type;
    public final PBUInt64Field uint64_create_time;
    public final PBUInt64Field uint64_creator_uin;
    public final PBUInt64Field uint64_current_user_browse_time;
    public final PBUInt64Field uint64_hostuser_uin;
    public final PBUInt64Field uint64_last_auth_time;
    public final PBUInt64Field uint64_last_delete_time;
    public final PBUInt64Field uint64_last_edit_time;
    public final PBUInt64Field uint64_last_editor_uin;
    public final PBUInt64Field uint64_last_pinned_time;
    public final PBUInt64Field uint64_last_unpinned_time;
    public final PBUInt64Field uint64_last_view_time;
    public final PBUInt64Field uint64_last_viewer_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50, 56, 66, 72, 80, 88, 98, 104, 112, 120, 128, 138, 144, 152, 160, 168, 178, 184, 192, 200, 210}, new String[]{"bytes_pad_url", "uint32_type", "bytes_title", "uint64_create_time", "uint64_creator_uin", "bytes_creator_nick", "uint64_last_editor_uin", "bytes_last_editor_nick", "uint64_last_edit_time", "bool_pinned_flag", "uint64_last_viewer_uin", "bytes_last_viewer_nick", "uint64_last_view_time", "uint64_last_pinned_time", "uint64_current_user_browse_time", "uint64_hostuser_uin", "bytes_hostuser_nick", "uint64_last_auth_time", "uint32_policy", "uint32_right_flag", "uint32_domainid", "bytes_localpadid", "uint64_last_unpinned_time", "bool_delete_flag", "uint64_last_delete_time", "bytes_thumb_url"}, new Object[]{byteStringMicro, 0, byteStringMicro, 0L, 0L, byteStringMicro, 0L, byteStringMicro, 0L, bool, 0L, byteStringMicro, 0L, 0L, 0L, 0L, byteStringMicro, 0L, 0, 0, 0, byteStringMicro, 0L, bool, 0L, byteStringMicro}, TimDocSSOMsg$PadInfo.class);
    }

    public TimDocSSOMsg$PadInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_pad_url = PBField.initBytes(byteStringMicro);
        this.uint32_type = PBField.initUInt32(0);
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.uint64_create_time = PBField.initUInt64(0L);
        this.uint64_creator_uin = PBField.initUInt64(0L);
        this.bytes_creator_nick = PBField.initBytes(byteStringMicro);
        this.uint64_last_editor_uin = PBField.initUInt64(0L);
        this.bytes_last_editor_nick = PBField.initBytes(byteStringMicro);
        this.uint64_last_edit_time = PBField.initUInt64(0L);
        this.bool_pinned_flag = PBField.initBool(false);
        this.uint64_last_viewer_uin = PBField.initUInt64(0L);
        this.bytes_last_viewer_nick = PBField.initBytes(byteStringMicro);
        this.uint64_last_view_time = PBField.initUInt64(0L);
        this.uint64_last_pinned_time = PBField.initUInt64(0L);
        this.uint64_current_user_browse_time = PBField.initUInt64(0L);
        this.uint64_hostuser_uin = PBField.initUInt64(0L);
        this.bytes_hostuser_nick = PBField.initBytes(byteStringMicro);
        this.uint64_last_auth_time = PBField.initUInt64(0L);
        this.uint32_policy = PBField.initUInt32(0);
        this.uint32_right_flag = PBField.initUInt32(0);
        this.uint32_domainid = PBField.initUInt32(0);
        this.bytes_localpadid = PBField.initBytes(byteStringMicro);
        this.uint64_last_unpinned_time = PBField.initUInt64(0L);
        this.bool_delete_flag = PBField.initBool(false);
        this.uint64_last_delete_time = PBField.initUInt64(0L);
        this.bytes_thumb_url = PBField.initBytes(byteStringMicro);
    }
}
