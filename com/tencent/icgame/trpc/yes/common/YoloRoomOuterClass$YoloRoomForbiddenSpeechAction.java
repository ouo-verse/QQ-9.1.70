package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloRoomForbiddenSpeechAction extends MessageMicro<YoloRoomOuterClass$YoloRoomForbiddenSpeechAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"user_id", "end_time", "is_gm_forbidden", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND}, new Object[]{null, 0, Boolean.FALSE, 0}, YoloRoomOuterClass$YoloRoomForbiddenSpeechAction.class);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    public final PBUInt32Field end_time = PBField.initUInt32(0);
    public final PBBoolField is_gm_forbidden = PBField.initBool(false);
    public final PBInt32Field second = PBField.initInt32(0);
}
