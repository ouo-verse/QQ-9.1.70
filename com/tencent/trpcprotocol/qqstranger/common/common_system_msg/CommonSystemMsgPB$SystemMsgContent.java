package com.tencent.trpcprotocol.qqstranger.common.common_system_msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* loaded from: classes38.dex */
public final class CommonSystemMsgPB$SystemMsgContent extends MessageMicro<CommonSystemMsgPB$SystemMsgContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 82, 90}, new String[]{"appid", QQHealthReportApiImpl.MSG_TYPE_KEY, "interactive_marker_msg", "interactive_notice_msg"}, new Object[]{0, 0, null, null}, CommonSystemMsgPB$SystemMsgContent.class);
    public final PBEnumField appid = PBField.initEnum(0);
    public final PBEnumField msg_type = PBField.initEnum(0);
    public CommonSystemMsgPB$InteractiveMarkerMsg interactive_marker_msg = new CommonSystemMsgPB$InteractiveMarkerMsg();
    public CommonSystemMsgPB$InterativeNoticeMsg interactive_notice_msg = new CommonSystemMsgPB$InterativeNoticeMsg();
}
