package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tenpay.sdk.util.UinConfigManager;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YokoGameRoomSendNoticeAction extends MessageMicro<YoloRoomOuterClass$YokoGameRoomSendNoticeAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{UinConfigManager.KEY_ADS}, new Object[]{""}, YoloRoomOuterClass$YokoGameRoomSendNoticeAction.class);
    public final PBStringField notice = PBField.initString("");
}
