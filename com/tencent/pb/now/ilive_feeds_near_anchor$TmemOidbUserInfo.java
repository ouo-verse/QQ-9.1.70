package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_near_anchor$TmemOidbUserInfo extends MessageMicro<ilive_feeds_near_anchor$TmemOidbUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"interest_bit", LpReport_UserInfo_dc02148.CONSTELLATION, "home_town", IProfileProtocolConst.KEY_PROFESSION, "update_time"}, new Object[]{0, 0, 0, 0, 0}, ilive_feeds_near_anchor$TmemOidbUserInfo.class);
    public final PBUInt32Field interest_bit = PBField.initUInt32(0);
    public final PBUInt32Field constellation = PBField.initUInt32(0);
    public final PBUInt32Field home_town = PBField.initUInt32(0);
    public final PBUInt32Field profession = PBField.initUInt32(0);
    public final PBUInt32Field update_time = PBField.initUInt32(0);
}
