package com.tencent.creatorad.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class CreatorReader$GetCreatorADRsp extends MessageMicro<CreatorReader$GetCreatorADRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"creator_ads"}, new Object[]{null}, CreatorReader$GetCreatorADRsp.class);
    public final PBRepeatMessageField<CreatorReader$CreatorAD> creator_ads = PBField.initRepeatMessage(CreatorReader$CreatorAD.class);
}
