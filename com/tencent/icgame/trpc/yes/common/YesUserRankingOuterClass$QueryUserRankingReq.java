package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YesUserRankingOuterClass$QueryUserRankingReq extends MessageMicro<YesUserRankingOuterClass$QueryUserRankingReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"RoomID", HttpHeaders.FROM, "PageSize"}, new Object[]{0L, 0, 0}, YesUserRankingOuterClass$QueryUserRankingReq.class);
    public final PBUInt64Field RoomID = PBField.initUInt64(0);
    public final PBUInt32Field From = PBField.initUInt32(0);
    public final PBUInt32Field PageSize = PBField.initUInt32(0);
}
