package com.tencent.pb.now;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class WordsSecurity$SecurityReq extends MessageMicro<WordsSecurity$SecurityReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField biz_id;
    public final PBUInt32Field check_mask;
    public final PBBytesField check_word;
    public final PBUInt32Field client_ip;
    public final PBBytesField from_nick_name;
    public final PBEnumField from_user_type;
    public final PBBytesField imei;
    public final PBUInt64Field room_id;
    public final PBUInt32Field svr_type;
    public final PBUInt64Field to_uin;
    public final PBEnumField to_user_type;
    public final PBUInt32Field use_white_list;

    static {
        String[] strArr = {"check_word", "check_mask", "svr_type", "from_user_type", "to_user_type", "to_uin", "from_nick_name", "client_ip", "use_white_list", AudienceReportConst.ROOM_ID, QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, "imei"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 58, 64, 72, 80, 90, 98}, strArr, new Object[]{byteStringMicro, 0, 0, 0, 0, 0L, byteStringMicro, 0, 0, 0L, byteStringMicro, byteStringMicro}, WordsSecurity$SecurityReq.class);
    }

    public WordsSecurity$SecurityReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.check_word = PBField.initBytes(byteStringMicro);
        this.check_mask = PBField.initUInt32(0);
        this.svr_type = PBField.initUInt32(0);
        this.from_user_type = PBField.initEnum(0);
        this.to_user_type = PBField.initEnum(0);
        this.to_uin = PBField.initUInt64(0L);
        this.from_nick_name = PBField.initBytes(byteStringMicro);
        this.client_ip = PBField.initUInt32(0);
        this.use_white_list = PBField.initUInt32(0);
        this.room_id = PBField.initUInt64(0L);
        this.biz_id = PBField.initBytes(byteStringMicro);
        this.imei = PBField.initBytes(byteStringMicro);
    }
}
