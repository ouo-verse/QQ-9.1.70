package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.transfile.dns.DomainData;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_qgroup_datacard$NotifyUpdateRsp extends MessageMicro<sgame_qgroup_datacard$NotifyUpdateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{DomainData.DOMAIN_NAME}, new Object[]{0L}, sgame_qgroup_datacard$NotifyUpdateRsp.class);

    /* renamed from: n, reason: collision with root package name */
    public final PBInt64Field f381300n = PBField.initInt64(0);
}
