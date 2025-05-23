package com.tencent.mobileqq.aio.input.sendmsg.robot;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ToBotData extends MessageMicro<ToBotData> {
    public static final int AIO = 0;
    public static final int AI_DRAW = 2;
    public static final int AI_PROMPT = 4;
    public static final int AI_SEARCH = 1;
    public static final int AI_WRITE = 3;
    public static final int DASOU_SEARCH = 99;
    public static final int STORY_AIO = 100;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"realtimeSpeechMsg", "msgScene", "callbackData", "extDatas"}, new Object[]{0, 0, "", ""}, ToBotData.class);
    public final PBInt32Field realtimeSpeechMsg = PBField.initInt32(0);
    public final PBEnumField msgScene = PBField.initEnum(0);
    public final PBStringField callbackData = PBField.initString("");
    public final PBRepeatField<String> extDatas = PBField.initRepeat(PBStringField.__repeatHelper__);
}
