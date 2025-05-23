package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class CmShowContentUpdate$STVerInfo extends MessageMicro<CmShowContentUpdate$STVerInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field domain_id;
    public final PBBytesField down_file;
    public final PBUInt32Field is_patch;
    public final PBBytesField md5;
    public final PBBytesField name;
    public CmShowContentUpdate$STPatchInfo patch_info;
    public final PBInt32Field ver;
    public final PBInt32Field biz_id = PBField.initInt32(0);
    public final PBInt64Field item_id = PBField.initInt64(0);

    static {
        String[] strArr = {QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, "item_id", "name", "ver", "down_file", "md5", "is_patch", "patch_info", "domain_id"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 56, 66, 72}, strArr, new Object[]{0, 0L, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, null, 0}, CmShowContentUpdate$STVerInfo.class);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.tencent.pb.clubcontent.CmShowContentUpdate$STPatchInfo] */
    public CmShowContentUpdate$STVerInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.name = PBField.initBytes(byteStringMicro);
        this.ver = PBField.initInt32(0);
        this.down_file = PBField.initBytes(byteStringMicro);
        this.md5 = PBField.initBytes(byteStringMicro);
        this.is_patch = PBField.initUInt32(0);
        this.patch_info = new MessageMicro<CmShowContentUpdate$STPatchInfo>() { // from class: com.tencent.pb.clubcontent.CmShowContentUpdate$STPatchInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBInt32Field base_ver = PBField.initInt32(0);
            public final PBBytesField down_patch_file;
            public final PBBytesField patch_data;
            public final PBUInt64Field patch_size;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"base_ver", "patch_data", "patch_size", "down_patch_file"}, new Object[]{0, byteStringMicro2, 0L, byteStringMicro2}, CmShowContentUpdate$STPatchInfo.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.patch_data = PBField.initBytes(byteStringMicro2);
                this.patch_size = PBField.initUInt64(0L);
                this.down_patch_file = PBField.initBytes(byteStringMicro2);
            }
        };
        this.domain_id = PBField.initInt32(0);
    }
}
