package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class device_report {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class DeviceReport extends MessageMicro<DeviceReport> {
        public static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_android_id;
        public final PBBytesField bytes_baseband;
        public final PBBytesField bytes_boot_id;
        public final PBBytesField bytes_bootloader;
        public final PBBytesField bytes_codename;
        public final PBBytesField bytes_fingerprint;
        public final PBBytesField bytes_incremental;
        public final PBBytesField bytes_inner_ver;
        public final PBBytesField bytes_version;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"bytes_bootloader", "bytes_version", "bytes_codename", "bytes_incremental", "bytes_fingerprint", "bytes_boot_id", "bytes_android_id", "bytes_baseband", "bytes_inner_ver"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, DeviceReport.class);
        }

        public DeviceReport() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_bootloader = PBField.initBytes(byteStringMicro);
            this.bytes_version = PBField.initBytes(byteStringMicro);
            this.bytes_codename = PBField.initBytes(byteStringMicro);
            this.bytes_incremental = PBField.initBytes(byteStringMicro);
            this.bytes_fingerprint = PBField.initBytes(byteStringMicro);
            this.bytes_boot_id = PBField.initBytes(byteStringMicro);
            this.bytes_android_id = PBField.initBytes(byteStringMicro);
            this.bytes_baseband = PBField.initBytes(byteStringMicro);
            this.bytes_inner_ver = PBField.initBytes(byteStringMicro);
        }
    }

    device_report() {
    }
}
