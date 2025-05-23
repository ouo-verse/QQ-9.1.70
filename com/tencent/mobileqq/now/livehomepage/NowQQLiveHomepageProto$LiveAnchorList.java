package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$LiveAnchorList extends MessageMicro<NowQQLiveHomepageProto$LiveAnchorList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_live_anchor"}, new Object[]{null}, NowQQLiveHomepageProto$LiveAnchorList.class);
    public final PBRepeatMessageField<NowQQLiveHomepageProto$LiveAnchorItem> rpt_live_anchor = PBField.initRepeatMessage(NowQQLiveHomepageProto$LiveAnchorItem.class);
}
