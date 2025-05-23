package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YesGameInfoOuterClass$GameConfigTeamInfo extends MessageMicro<YesGameInfoOuterClass$GameConfigTeamInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"button_text_hue", "main_hue", "bg_hue", "text_hue", "unselected_bg_hue", "selected_bg_hue", "create_big_icon", "create_small_icon", "item_list", "text_sub_hue"}, new Object[]{"", "", "", "", "", "", "", "", null, ""}, YesGameInfoOuterClass$GameConfigTeamInfo.class);
    public final PBStringField button_text_hue = PBField.initString("");
    public final PBStringField main_hue = PBField.initString("");
    public final PBStringField bg_hue = PBField.initString("");
    public final PBStringField text_hue = PBField.initString("");
    public final PBStringField unselected_bg_hue = PBField.initString("");
    public final PBStringField selected_bg_hue = PBField.initString("");
    public final PBStringField create_big_icon = PBField.initString("");
    public final PBStringField create_small_icon = PBField.initString("");
    public final PBRepeatMessageField<YesGameInfoOuterClass$GameConfigItem> item_list = PBField.initRepeatMessage(YesGameInfoOuterClass$GameConfigItem.class);
    public final PBStringField text_sub_hue = PBField.initString("");
}
