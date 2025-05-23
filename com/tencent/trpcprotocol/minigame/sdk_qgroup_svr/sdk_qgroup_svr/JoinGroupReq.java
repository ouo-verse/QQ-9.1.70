package com.tencent.trpcprotocol.minigame.sdk_qgroup_svr.sdk_qgroup_svr;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class JoinGroupReq extends MessageMicro<JoinGroupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"appid", ComicCancelRedPointPopItemData.JSON_KEY_TAGS}, new Object[]{"", ""}, JoinGroupReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBRepeatField<String> tags = PBField.initRepeat(PBStringField.__repeatHelper__);
}
