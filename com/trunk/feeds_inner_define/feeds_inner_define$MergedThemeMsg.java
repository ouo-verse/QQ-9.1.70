package com.trunk.feeds_inner_define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class feeds_inner_define$MergedThemeMsg extends MessageMicro<feeds_inner_define$MergedThemeMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{58}, new String[]{"rpt_theme_msg"}, new Object[]{null}, feeds_inner_define$MergedThemeMsg.class);
    public final PBRepeatMessageField<feeds_inner_define$ThemeMsgInfo> rpt_theme_msg = PBField.initRepeatMessage(feeds_inner_define$ThemeMsgInfo.class);
}
