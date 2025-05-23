package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloRoomForbiddenSpeechConf extends MessageMicro<YoloRoomOuterClass$YoloRoomForbiddenSpeechConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "desc"}, new Object[]{0, ""}, YoloRoomOuterClass$YoloRoomForbiddenSpeechConf.class);
    public final PBInt32Field second = PBField.initInt32(0);
    public final PBStringField desc = PBField.initString("");
}
