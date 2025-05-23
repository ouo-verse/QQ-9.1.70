package com.tencent.creatorad.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class CreatorReader$GetShareADRsp extends MessageMicro<CreatorReader$GetShareADRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ads"}, new Object[]{null}, CreatorReader$GetShareADRsp.class);
    public final PBRepeatMessageField<CreatorReader$ShareAD> ads = PBField.initRepeatMessage(CreatorReader$ShareAD.class);
}
