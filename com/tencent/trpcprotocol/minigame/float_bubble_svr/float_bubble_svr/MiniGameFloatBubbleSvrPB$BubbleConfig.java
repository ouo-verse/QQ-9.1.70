package com.tencent.trpcprotocol.minigame.float_bubble_svr.float_bubble_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* loaded from: classes38.dex */
public final class MiniGameFloatBubbleSvrPB$BubbleConfig extends MessageMicro<MiniGameFloatBubbleSvrPB$BubbleConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58}, new String[]{"bubble_type", "big_bubble_title", "big_bubble_subtitle", "small_bubble_title", "icon", QZoneDTLoginReporter.SCHEMA, "close_popup_text"}, new Object[]{0, "", "", "", "", "", ""}, MiniGameFloatBubbleSvrPB$BubbleConfig.class);
    public final PBEnumField bubble_type = PBField.initEnum(0);
    public final PBStringField big_bubble_title = PBField.initString("");
    public final PBStringField big_bubble_subtitle = PBField.initString("");
    public final PBStringField small_bubble_title = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField schema = PBField.initString("");
    public final PBStringField close_popup_text = PBField.initString("");
}
