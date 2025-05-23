package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class QQGameAioLittleTail$ShareTail extends MessageMicro<QQGameAioLittleTail$ShareTail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58, 64, 72}, new String[]{"appid", "game_icon", CrashRtInfoHolder.BeaconKey.GAME_NAME, "title", "tail_style", "android_url", "ios_url", "start_time", "end_time"}, new Object[]{0, "", "", "", 0, null, null, 0L, 0L}, QQGameAioLittleTail$ShareTail.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBStringField game_icon = PBField.initString("");
    public final PBStringField game_name = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBEnumField tail_style = PBField.initEnum(0);
    public QQGameAioLittleTail$ShareUrl android_url = new QQGameAioLittleTail$ShareUrl();
    public QQGameAioLittleTail$ShareUrl ios_url = new QQGameAioLittleTail$ShareUrl();
    public final PBInt64Field start_time = PBField.initInt64(0);
    public final PBInt64Field end_time = PBField.initInt64(0);
}
