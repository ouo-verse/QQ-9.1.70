package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes16.dex */
public final class QQGamePubSubscribe$AppSubscribeInfo extends MessageMicro<QQGamePubSubscribe$AppSubscribeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48}, new String[]{"appid", "subscribe", "appName", "appIcon", "subscribeCount", "subscribeTime"}, new Object[]{0, 0, "", "", 0L, 0L}, QQGamePubSubscribe$AppSubscribeInfo.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBEnumField subscribe = PBField.initEnum(0);
    public final PBStringField appName = PBField.initString("");
    public final PBStringField appIcon = PBField.initString("");
    public final PBInt64Field subscribeCount = PBField.initInt64(0);
    public final PBInt64Field subscribeTime = PBField.initInt64(0);
}
