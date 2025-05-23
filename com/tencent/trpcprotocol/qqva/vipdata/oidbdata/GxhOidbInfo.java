package com.tencent.trpcprotocol.qqva.vipdata.oidbdata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class GxhOidbInfo extends MessageMicro<GxhOidbInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"np", "qqvadata_changerand"}, new Object[]{null, 0}, GxhOidbInfo.class);

    /* renamed from: np, reason: collision with root package name */
    public NameplateOidbInfo f381645np = new NameplateOidbInfo();
    public final PBInt32Field qqvadata_changerand = PBField.initInt32(0);
}
