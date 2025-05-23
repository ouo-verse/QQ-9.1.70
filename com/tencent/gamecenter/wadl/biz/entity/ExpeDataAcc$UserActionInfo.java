package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class ExpeDataAcc$UserActionInfo extends MessageMicro<ExpeDataAcc$UserActionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"accountInfo", "eventInfo", "deviceInfo", "appInfo", "networkInfo", "expeInfo", "taskInfo", "algorithmInfo"}, new Object[]{null, null, null, null, null, null, null, null}, ExpeDataAcc$UserActionInfo.class);
    public ExpeDataAcc$AccountInfo accountInfo = new ExpeDataAcc$AccountInfo();
    public ExpeDataAcc$EventInfo eventInfo = new ExpeDataAcc$EventInfo();
    public ExpeDataAcc$DeviceInfo deviceInfo = new MessageMicro<ExpeDataAcc$DeviceInfo>() { // from class: com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc$DeviceInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"platform", "brand", "model", "version", "deviceInfo", "mac", "idfa", "idfv", "imei"}, new Object[]{"", "", "", "", "", "", "", "", ""}, ExpeDataAcc$DeviceInfo.class);
        public final PBStringField platform = PBField.initString("");
        public final PBStringField brand = PBField.initString("");
        public final PBStringField model = PBField.initString("");
        public final PBStringField version = PBField.initString("");
        public final PBStringField deviceInfo = PBField.initString("");
        public final PBStringField mac = PBField.initString("");
        public final PBStringField idfa = PBField.initString("");
        public final PBStringField idfv = PBField.initString("");
        public final PBStringField imei = PBField.initString("");
    };
    public ExpeDataAcc$AppInfo appInfo = new ExpeDataAcc$AppInfo();
    public ExpeDataAcc$NetworkInfo networkInfo = new MessageMicro<ExpeDataAcc$NetworkInfo>() { // from class: com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc$NetworkInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{DKEngine.GlobalKey.NET_WORK_TYPE, "userClientIp", "gatewayIp"}, new Object[]{0L, "", ""}, ExpeDataAcc$NetworkInfo.class);
        public final PBInt64Field networkType = PBField.initInt64(0);
        public final PBStringField userClientIp = PBField.initString("");
        public final PBStringField gatewayIp = PBField.initString("");
    };
    public ExpeDataAcc$ExpeInfo expeInfo = new ExpeDataAcc$ExpeInfo();
    public ExpeDataAcc$PushTaskInfo taskInfo = new MessageMicro<ExpeDataAcc$PushTaskInfo>() { // from class: com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc$PushTaskInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"taskSysTransfer", "channelType"}, new Object[]{"", 0L}, ExpeDataAcc$PushTaskInfo.class);
        public final PBStringField taskSysTransfer = PBField.initString("");
        public final PBInt64Field channelType = PBField.initInt64(0);
    };
    public ExpeDataAcc$SvrAlgorithmInfo algorithmInfo = new MessageMicro<ExpeDataAcc$SvrAlgorithmInfo>() { // from class: com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc$SvrAlgorithmInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"algoritymId", "algorithmType", "traceId", "itemType"}, new Object[]{"", "", "", ""}, ExpeDataAcc$SvrAlgorithmInfo.class);
        public final PBStringField algoritymId = PBField.initString("");
        public final PBStringField algorithmType = PBField.initString("");
        public final PBStringField traceId = PBField.initString("");
        public final PBStringField itemType = PBField.initString("");
    };
}
