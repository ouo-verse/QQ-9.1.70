package com.tencent.trpcprotocol.qqstranger.common.common_gray_tips;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class CommonGrayTipsPB$GrayTipMsgBody extends MessageMicro<CommonGrayTipsPB$GrayTipMsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"appid", "peer_tinyid", "gray_tip_content", "gray_tip_type", "marker_ext"}, new Object[]{0, 0L, "", 0, null}, CommonGrayTipsPB$GrayTipMsgBody.class);
    public final PBEnumField appid = PBField.initEnum(0);
    public final PBUInt64Field peer_tinyid = PBField.initUInt64(0);
    public final PBStringField gray_tip_content = PBField.initString("");
    public final PBEnumField gray_tip_type = PBField.initEnum(0);
    public CommonGrayTipsPB$MarkerExtend marker_ext = new CommonGrayTipsPB$MarkerExtend();
}
