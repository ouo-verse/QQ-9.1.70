package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$JuBaoGetUserInfoRsp extends MessageMicro<userInfo$JuBaoGetUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 56, 66, 74}, new String[]{"pictures_wall_pic", "expand_declaration", "avatar", "nick", "gender", "city", "age", "tag_names", TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE}, new Object[]{"", "", "", "", 0, "", 0, "", ByteStringMicro.EMPTY}, userInfo$JuBaoGetUserInfoRsp.class);
    public final PBUInt32Field age;
    public final PBStringField avatar;
    public final PBStringField city;
    public final PBStringField expand_declaration;
    public final PBUInt32Field gender;
    public final PBStringField nick;
    public final PBBytesField opaque;
    public final PBRepeatField<String> pictures_wall_pic;
    public final PBRepeatField<String> tag_names;

    public userInfo$JuBaoGetUserInfoRsp() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.pictures_wall_pic = PBField.initRepeat(pBStringField);
        this.expand_declaration = PBField.initString("");
        this.avatar = PBField.initString("");
        this.nick = PBField.initString("");
        this.gender = PBField.initUInt32(0);
        this.city = PBField.initString("");
        this.age = PBField.initUInt32(0);
        this.tag_names = PBField.initRepeat(pBStringField);
        this.opaque = PBField.initBytes(ByteStringMicro.EMPTY);
    }
}
