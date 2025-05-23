package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$Config extends MessageMicro<weather$Config> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"headBackgroundPicPath", "navigationPicPath", "pulldownRefreshPicPath", "jumpWeatherWebStyle"}, new Object[]{"", "", "", 1}, weather$Config.class);
    public final PBStringField headBackgroundPicPath = PBField.initString("");
    public final PBStringField navigationPicPath = PBField.initString("");
    public final PBStringField pulldownRefreshPicPath = PBField.initString("");
    public final PBEnumField jumpWeatherWebStyle = PBField.initEnum(1);
}
