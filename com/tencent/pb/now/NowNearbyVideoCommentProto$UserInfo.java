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
public final class NowNearbyVideoCommentProto$UserInfo extends MessageMicro<NowNearbyVideoCommentProto$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField anchor_name;
    public final PBBytesField head_img_url;
    public final PBUInt64Field now_id;
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public ilive_user_basic_info$UserExtraInfo userExtraInfo;
    public final PBUInt32Field user_type;

    static {
        String[] strArr = {"uid", "head_img_url", AudienceReportConst.ANCHOR_NAME, "userExtraInfo", "user_type", "now_id"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48}, strArr, new Object[]{0L, byteStringMicro, byteStringMicro, null, 0, 0L}, NowNearbyVideoCommentProto$UserInfo.class);
    }

    public NowNearbyVideoCommentProto$UserInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.head_img_url = PBField.initBytes(byteStringMicro);
        this.anchor_name = PBField.initBytes(byteStringMicro);
        this.userExtraInfo = new ilive_user_basic_info$UserExtraInfo();
        this.user_type = PBField.initUInt32(0);
        this.now_id = PBField.initUInt64(0L);
    }
}
