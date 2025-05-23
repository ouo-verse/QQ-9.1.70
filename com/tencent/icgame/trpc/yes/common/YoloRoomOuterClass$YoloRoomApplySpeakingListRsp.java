package com.tencent.icgame.trpc.yes.common;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloRoomApplySpeakingListRsp extends MessageMicro<YoloRoomOuterClass$YoloRoomApplySpeakingListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"apply_users", "next_score", PictureConst.KEY_HAS_MORE}, new Object[]{null, 0L, Boolean.FALSE}, YoloRoomOuterClass$YoloRoomApplySpeakingListRsp.class);
    public final PBRepeatMessageField<YoloRoomOuterClass$ApplyUser> apply_users = PBField.initRepeatMessage(YoloRoomOuterClass$ApplyUser.class);
    public final PBUInt64Field next_score = PBField.initUInt64(0);
    public final PBBoolField has_more = PBField.initBool(false);
}
