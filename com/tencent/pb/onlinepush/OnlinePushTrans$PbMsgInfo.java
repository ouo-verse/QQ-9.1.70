package com.tencent.pb.onlinepush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* loaded from: classes22.dex */
public final class OnlinePushTrans$PbMsgInfo extends MessageMicro<OnlinePushTrans$PbMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 74, 82, 88, 98, 136}, new String[]{ShortVideoConstants.FROM_UIN, "to_uin", QQHealthReportApiImpl.MSG_TYPE_KEY, "msg_subtype", "msg_seq", "msg_uid", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "real_msg_time", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "msg_data", "svr_ip", "ext_group_key_info", "uint32_general_flag"}, new Object[]{0L, 0L, 0, 0, 0, 0L, 0, 0, "", ByteStringMicro.EMPTY, 0, null, 0}, OnlinePushTrans$PbMsgInfo.class);
    public final PBUInt64Field from_uin = PBField.initUInt64(0);
    public final PBUInt64Field to_uin = PBField.initUInt64(0);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBUInt32Field msg_subtype = PBField.initUInt32(0);
    public final PBUInt32Field msg_seq = PBField.initUInt32(0);
    public final PBUInt64Field msg_uid = PBField.initUInt64(0);
    public final PBUInt32Field msg_time = PBField.initUInt32(0);
    public final PBUInt32Field real_msg_time = PBField.initUInt32(0);
    public final PBStringField nick_name = PBField.initString("");
    public final PBBytesField msg_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field svr_ip = PBField.initUInt32(0);
    public OnlinePushTrans$ExtGroupKeyInfo ext_group_key_info = new MessageMicro<OnlinePushTrans$ExtGroupKeyInfo>() { // from class: com.tencent.pb.onlinepush.OnlinePushTrans$ExtGroupKeyInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"cur_max_seq", "cur_time"}, new Object[]{0, 0L}, OnlinePushTrans$ExtGroupKeyInfo.class);
        public final PBUInt32Field cur_max_seq = PBField.initUInt32(0);
        public final PBUInt64Field cur_time = PBField.initUInt64(0);
    };
    public final PBUInt32Field uint32_general_flag = PBField.initUInt32(0);
}
