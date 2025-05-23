package com.tencent.trpcprotocol.qqva.vipdata.userdata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class userdata$NameplateInfo extends MessageMicro<userdata$NameplateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"itemid", "viptypeid", "isgray", "graysetts", IndividuationUrlHelper.UrlId.PENDANT_HOME, "type", "content", "fgid"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0}, userdata$NameplateInfo.class);
    public final PBInt32Field itemid = PBField.initInt32(0);
    public final PBInt32Field viptypeid = PBField.initInt32(0);
    public final PBInt32Field isgray = PBField.initInt32(0);
    public final PBInt32Field graysetts = PBField.initInt32(0);
    public final PBInt32Field pendant = PBField.initInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBRepeatField<Integer> content = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBInt32Field fgid = PBField.initInt32(0);
}
