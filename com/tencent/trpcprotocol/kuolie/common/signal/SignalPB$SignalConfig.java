package com.tencent.trpcprotocol.kuolie.common.signal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class SignalPB$SignalConfig extends MessageMicro<SignalPB$SignalConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"partner_id", "partner_name", "partner_adjs", "icon", "button_bg_color", "card_bg_colors", "publisher_signal_bg_colors", "button_bg_color_night", "card_bg_colors_night", "publisher_signal_bg_colors_night"}, new Object[]{0L, "", null, "", "", "", "", "", "", ""}, SignalPB$SignalConfig.class);
    public final PBStringField button_bg_color_night;
    public final PBRepeatField<String> card_bg_colors;
    public final PBRepeatField<String> card_bg_colors_night;
    public final PBRepeatField<String> publisher_signal_bg_colors;
    public final PBRepeatField<String> publisher_signal_bg_colors_night;
    public final PBUInt64Field partner_id = PBField.initUInt64(0);
    public final PBStringField partner_name = PBField.initString("");
    public final PBRepeatMessageField<SignalPB$PartnerAdjective> partner_adjs = PBField.initRepeatMessage(SignalPB$PartnerAdjective.class);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField button_bg_color = PBField.initString("");

    public SignalPB$SignalConfig() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.card_bg_colors = PBField.initRepeat(pBStringField);
        this.publisher_signal_bg_colors = PBField.initRepeat(pBStringField);
        this.button_bg_color_night = PBField.initString("");
        this.card_bg_colors_night = PBField.initRepeat(pBStringField);
        this.publisher_signal_bg_colors_night = PBField.initRepeat(pBStringField);
    }
}
