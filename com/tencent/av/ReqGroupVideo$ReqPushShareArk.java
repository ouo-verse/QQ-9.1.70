package com.tencent.av;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes3.dex */
public final class ReqGroupVideo$ReqPushShareArk extends MessageMicro<ReqGroupVideo$ReqPushShareArk> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField ark_desc;
    public final PBBytesField ark_jump_url;
    public final PBUInt64Field group_code;
    public final PBBytesField group_name;
    public final PBEnumField req_source;
    public final PBUInt32Field role;
    public final PBBytesField share_name;
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBUInt32Field room_create_time = PBField.initUInt32(0);
    public final PBUInt64Field send_type = PBField.initUInt64(0);
    public final PBUInt64Field recv_uin = PBField.initUInt64(0);

    static {
        String[] strArr = {"uin", AudienceReportConst.ROOM_ID, "room_create_time", "send_type", "recv_uin", "group_name", "share_name", "role", "group_code", "ark_jump_url", "ark_desc", "req_source"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 64, 72, 82, 90, 96}, strArr, new Object[]{0L, 0L, 0, 0L, 0L, byteStringMicro, byteStringMicro, 0, 0L, byteStringMicro, byteStringMicro, 0}, ReqGroupVideo$ReqPushShareArk.class);
    }

    public ReqGroupVideo$ReqPushShareArk() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.group_name = PBField.initBytes(byteStringMicro);
        this.share_name = PBField.initBytes(byteStringMicro);
        this.role = PBField.initUInt32(0);
        this.group_code = PBField.initUInt64(0L);
        this.ark_jump_url = PBField.initBytes(byteStringMicro);
        this.ark_desc = PBField.initBytes(byteStringMicro);
        this.req_source = PBField.initEnum(0);
    }
}
