package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class MobileQQDetect {
    static IPatchRedirector $redirector_ = null;
    public static final int BASELINE_BACKTOFRONT = 4;
    public static final int BASELINE_LOGIN = 2;
    public static final int BASELINE_NOW = 1;
    public static final int BUSINESS_LUCKYMONEY = 1;
    public static final int NETWORK_2G = 2;
    public static final int NETWORK_3G = 3;
    public static final int NETWORK_4G = 4;
    public static final int NETWORK_UNKNOWN = 0;
    public static final int NETWORK_WIFI = 1;
    public static final int PLATFORM_ALL = 3;
    public static final int PLATFORM_ANDROID = 1;
    public static final int PLATFORM_IOS = 2;
    public static final int TYPE_INSTALLED_APPINFO = 48;
    public static final int TYPE_MANIFESTINFO = 80;
    public static final int TYPE_RUNNING_APPINFO = 64;
    public static final int TYPE_SELF_MODULEINFO = 32;
    public static final int TYPE_SIGNATURE = 16;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class DetectConditionPacket extends MessageMicro<DetectConditionPacket> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"u32_iOSVersion", "u32_androidVersion"}, new Object[]{0, 0}, DetectConditionPacket.class);
        public final PBUInt32Field u32_iOSVersion = PBField.initUInt32(0);
        public final PBUInt32Field u32_androidVersion = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class DetectItemPacket extends MessageMicro<DetectItemPacket> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"u32_type", "u32_platform", "str_targetJson"}, new Object[]{0, 0, ""}, DetectItemPacket.class);
        public final PBUInt32Field u32_type = PBField.initUInt32(0);
        public final PBUInt32Field u32_platform = PBField.initUInt32(0);
        public final PBStringField str_targetJson = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class DetectItemResultPacket extends MessageMicro<DetectItemResultPacket> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"u32_type", "str_result"}, new Object[]{0, ""}, DetectItemResultPacket.class);
        public final PBUInt32Field u32_type = PBField.initUInt32(0);
        public final PBStringField str_result = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class DetectProjectPacket extends MessageMicro<DetectProjectPacket> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50}, new String[]{"u32_id", "u32_ttl", "u32_business", "condition", "time", "arr_items"}, new Object[]{0, 0, 0, null, null, null}, DetectProjectPacket.class);
        public final PBUInt32Field u32_id = PBField.initUInt32(0);
        public final PBUInt32Field u32_ttl = PBField.initUInt32(0);
        public final PBUInt32Field u32_business = PBField.initUInt32(0);
        public DetectConditionPacket condition = new DetectConditionPacket();
        public DetectTimePacket time = new DetectTimePacket();
        public final PBRepeatMessageField<DetectItemPacket> arr_items = PBField.initRepeatMessage(DetectItemPacket.class);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class DetectProjectResultPacket extends MessageMicro<DetectProjectResultPacket> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 58}, new String[]{"envParam", "u32_version", "u32_id", "u32_business", "result", "str_trunk", "str_extra"}, new Object[]{null, 0, 0, 0, null, "", ""}, DetectProjectResultPacket.class);
        public EnvParamPacket envParam = new EnvParamPacket();
        public final PBUInt32Field u32_version = PBField.initUInt32(0);
        public final PBUInt32Field u32_id = PBField.initUInt32(0);
        public final PBUInt32Field u32_business = PBField.initUInt32(0);
        public final PBRepeatMessageField<DetectItemResultPacket> result = PBField.initRepeatMessage(DetectItemResultPacket.class);
        public final PBStringField str_trunk = PBField.initString("");
        public final PBStringField str_extra = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class DetectStrategyPacket extends MessageMicro<DetectStrategyPacket> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"u32_uid", "u32_frequency", "u32_platform", "arr_projects"}, new Object[]{0, 0, 0, null}, DetectStrategyPacket.class);
        public final PBUInt32Field u32_uid = PBField.initUInt32(0);
        public final PBUInt32Field u32_frequency = PBField.initUInt32(0);
        public final PBUInt32Field u32_platform = PBField.initUInt32(0);
        public final PBRepeatMessageField<DetectProjectPacket> arr_projects = PBField.initRepeatMessage(DetectProjectPacket.class);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class DetectTimePacket extends MessageMicro<DetectTimePacket> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"u32_baseline", "u32_delay"}, new Object[]{0, 0}, DetectTimePacket.class);
        public final PBUInt32Field u32_baseline = PBField.initUInt32(0);
        public final PBUInt32Field u32_delay = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class EnvParamPacket extends MessageMicro<EnvParamPacket> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_androidid;
        public final PBBytesField bytes_guid;
        public final PBBytesField bytes_imei;
        public final PBBytesField bytes_imsi;
        public final PBStringField str_cpuarch;
        public final PBStringField str_rominfo;
        public final PBStringField str_wifimac;
        public final PBUInt32Field u32_network;
        public final PBUInt32Field u32_root;
        public final PBUInt32Field u32_platform = PBField.initUInt32(0);
        public final PBStringField str_sysversion = PBField.initString("");
        public final PBUInt32Field u32_appid = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 56, 64, 74, 82, 90, 98}, new String[]{"u32_platform", "str_sysversion", "u32_appid", "bytes_guid", "bytes_imei", "bytes_androidid", "u32_network", "u32_root", "bytes_imsi", "str_wifimac", "str_cpuarch", "str_rominfo"}, new Object[]{0, "", 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, "", "", ""}, EnvParamPacket.class);
        }

        public EnvParamPacket() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_guid = PBField.initBytes(byteStringMicro);
            this.bytes_imei = PBField.initBytes(byteStringMicro);
            this.bytes_androidid = PBField.initBytes(byteStringMicro);
            this.u32_network = PBField.initUInt32(0);
            this.u32_root = PBField.initUInt32(0);
            this.bytes_imsi = PBField.initBytes(byteStringMicro);
            this.str_wifimac = PBField.initString("");
            this.str_cpuarch = PBField.initString("");
            this.str_rominfo = PBField.initString("");
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class PushDetectSrategyPacket extends MessageMicro<PushDetectSrategyPacket> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_buffer"}, new Object[]{ByteStringMicro.EMPTY}, PushDetectSrategyPacket.class);
        public final PBBytesField bytes_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class ReportDetectResultPacket extends MessageMicro<ReportDetectResultPacket> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_buffer", "ret"}, new Object[]{ByteStringMicro.EMPTY, 0}, ReportDetectResultPacket.class);
        public final PBBytesField bytes_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field ret = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class ReqDetectSrategyPacket extends MessageMicro<ReqDetectSrategyPacket> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"u32_version", "u32_lastTime", "u32_lastUid", "envParam"}, new Object[]{0, 0, 0, null}, ReqDetectSrategyPacket.class);
        public final PBUInt32Field u32_version = PBField.initUInt32(0);
        public final PBUInt32Field u32_lastTime = PBField.initUInt32(0);
        public final PBUInt32Field u32_lastUid = PBField.initUInt32(0);
        public EnvParamPacket envParam = new EnvParamPacket();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class RspDetectSrategyPacket extends MessageMicro<RspDetectSrategyPacket> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"i32_ret", "bytes_buffer"}, new Object[]{0, ByteStringMicro.EMPTY}, RspDetectSrategyPacket.class);
        public final PBInt32Field i32_ret = PBField.initInt32(0);
        public final PBBytesField bytes_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    MobileQQDetect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
