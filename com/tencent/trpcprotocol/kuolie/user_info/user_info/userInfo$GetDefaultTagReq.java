package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$GetDefaultTagReq extends MessageMicro<userInfo$GetDefaultTagReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{QCircleSchemeAttr.CoverFeed.SOURCE_TYPE}, new Object[]{0}, userInfo$GetDefaultTagReq.class);
    public final PBEnumField source_type = PBField.initEnum(0);
}
