package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$DownImageReq extends MessageMicro<userInfo$DownImageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"image_url", "open_id"}, new Object[]{"", ""}, userInfo$DownImageReq.class);
    public final PBStringField image_url = PBField.initString("");
    public final PBStringField open_id = PBField.initString("");
}
