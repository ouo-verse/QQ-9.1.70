package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$RcmdFollowList extends MessageMicro<NowQQLiveHomepageProto$RcmdFollowList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_rcmd_follow"}, new Object[]{null}, NowQQLiveHomepageProto$RcmdFollowList.class);
    public final PBRepeatMessageField<NowQQLiveHomepageProto$RcmdFollowItem> rpt_rcmd_follow = PBField.initRepeatMessage(NowQQLiveHomepageProto$RcmdFollowItem.class);
}
