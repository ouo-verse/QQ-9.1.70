package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$RoomRichTitle extends MessageMicro<NowQQLiveHomepageProto$RoomRichTitle> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{DTParamKey.REPORT_KEY_VISUAL_ELEMENTS}, new Object[]{null}, NowQQLiveHomepageProto$RoomRichTitle.class);
    public final PBRepeatMessageField<NowQQLiveHomepageProto$RichTitleElement> elements = PBField.initRepeatMessage(NowQQLiveHomepageProto$RichTitleElement.class);
}
