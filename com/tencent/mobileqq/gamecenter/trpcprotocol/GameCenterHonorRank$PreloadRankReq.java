package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes12.dex */
public final class GameCenterHonorRank$PreloadRankReq extends MessageMicro<GameCenterHonorRank$PreloadRankReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"group_code"}, new Object[]{0L}, GameCenterHonorRank$PreloadRankReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
}
