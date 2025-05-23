package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserInfo$Idols extends MessageMicro<UserInfo$Idols> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 58, 64, 72}, new String[]{"name", NotificationActivity.KEY_ALIAS, "avatar", "desc", "gender", "idol_id", "pic", LocalPhotoFaceInfo.SCORE, "rank"}, new Object[]{"", "", "", "", 0, 0, "", 0L, 0}, UserInfo$Idols.class);
    public final PBStringField name = PBField.initString("");
    public final PBRepeatField<String> alias = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBUInt32Field idol_id = PBField.initUInt32(0);
    public final PBStringField pic = PBField.initString("");
    public final PBUInt64Field score = PBField.initUInt64(0);
    public final PBUInt32Field rank = PBField.initUInt32(0);
}
