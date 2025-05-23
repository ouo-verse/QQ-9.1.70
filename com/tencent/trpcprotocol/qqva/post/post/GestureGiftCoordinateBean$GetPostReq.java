package com.tencent.trpcprotocol.qqva.post.post;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class GestureGiftCoordinateBean$GetPostReq extends MessageMicro<GestureGiftCoordinateBean$GetPostReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"orderNum"}, new Object[]{""}, GestureGiftCoordinateBean$GetPostReq.class);
    public final PBStringField orderNum = PBField.initString("");
}
