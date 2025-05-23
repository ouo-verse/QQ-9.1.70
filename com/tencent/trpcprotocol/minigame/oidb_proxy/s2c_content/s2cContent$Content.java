package com.tencent.trpcprotocol.minigame.oidb_proxy.s2c_content;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class s2cContent$Content extends MessageMicro<s2cContent$Content> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "spark_reward_notify"}, new Object[]{0, null}, s2cContent$Content.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public s2cContent$SparkRewardNotify spark_reward_notify = new s2cContent$SparkRewardNotify();
}
