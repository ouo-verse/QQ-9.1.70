package com.tencent.pb.now;

import com.tencent.ilive_user_basic_info.ilive_user_basic_info$UserExtraInfo;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$UserInfo extends MessageMicro<FeedsProtocol$UserInfo> {
    public static final int APP_FRIEND = 1;
    public static final int QQ_FRIEND = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field age;
    public final PBBytesField anchor_name;
    public final PBUInt64Field explicit_uid;
    public final PBUInt32Field friend_type;
    public final PBBytesField head_img_url;
    public final PBUInt32Field id_type;
    public final PBUInt32Field is_qq_user;
    public final PBUInt64Field tinyid;
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt64Field uin;
    public ilive_user_basic_info$UserExtraInfo userExtraInfo;
    public final PBUInt32Field user_gender;
    public final PBBytesField user_logo_url;

    static {
        String[] strArr = {"uid", "head_img_url", AudienceReportConst.ANCHOR_NAME, "userExtraInfo", "friend_type", "user_logo_url", "is_qq_user", "uin", "user_gender", "age", "tinyid", "explicit_uid", "id_type"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 56, 64, 72, 80, 88, 96, 104}, strArr, new Object[]{0L, byteStringMicro, byteStringMicro, null, 0, byteStringMicro, 0, 0L, 0, 0, 0L, 0L, 0}, FeedsProtocol$UserInfo.class);
    }

    public FeedsProtocol$UserInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.head_img_url = PBField.initBytes(byteStringMicro);
        this.anchor_name = PBField.initBytes(byteStringMicro);
        this.userExtraInfo = new ilive_user_basic_info$UserExtraInfo();
        this.friend_type = PBField.initUInt32(0);
        this.user_logo_url = PBField.initBytes(byteStringMicro);
        this.is_qq_user = PBField.initUInt32(0);
        this.uin = PBField.initUInt64(0L);
        this.user_gender = PBField.initUInt32(0);
        this.age = PBField.initUInt32(0);
        this.tinyid = PBField.initUInt64(0L);
        this.explicit_uid = PBField.initUInt64(0L);
        this.id_type = PBField.initUInt32(0);
    }
}
