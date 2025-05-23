package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class richstatus_sticker$RichStatus_Sticker extends MessageMicro<richstatus_sticker$RichStatus_Sticker> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"sticker_info"}, new Object[]{null}, richstatus_sticker$RichStatus_Sticker.class);
    public final PBRepeatMessageField<richstatus_sticker$StickerInfo> sticker_info = PBField.initRepeatMessage(richstatus_sticker$StickerInfo.class);
}
