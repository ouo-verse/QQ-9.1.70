package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameDataAuthorizeSvr$LoginGuide extends MessageMicro<GameDataAuthorizeSvr$LoginGuide> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 58, 66, 74, 82, 90}, new String[]{"show_guide", "style", "title", "reminders", "listening_time", "ads_pic", "app_name", "operator_commpany", "version_name", "privacy_guide", "download_url"}, new Object[]{Boolean.FALSE, 0, "", null, 0L, "", "", "", "", "", ""}, GameDataAuthorizeSvr$LoginGuide.class);
    public final PBBoolField show_guide = PBField.initBool(false);
    public final PBInt32Field style = PBField.initInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<GameDataAuthorizeSvr$Reminder> reminders = PBField.initRepeatMessage(GameDataAuthorizeSvr$Reminder.class);
    public final PBInt64Field listening_time = PBField.initInt64(0);
    public final PBStringField ads_pic = PBField.initString("");
    public final PBStringField app_name = PBField.initString("");
    public final PBStringField operator_commpany = PBField.initString("");
    public final PBStringField version_name = PBField.initString("");
    public final PBStringField privacy_guide = PBField.initString("");
    public final PBStringField download_url = PBField.initString("");
}
