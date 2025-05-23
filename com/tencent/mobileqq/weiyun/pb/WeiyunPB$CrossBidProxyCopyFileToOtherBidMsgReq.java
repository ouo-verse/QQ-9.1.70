package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;

/* loaded from: classes20.dex */
public final class WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq extends MessageMicro<WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq> {
    public static final int DST_BID_FIELD_NUMBER = 200;
    public static final int DST_UIN_FIELD_NUMBER = 201;
    public static final int EXTENSION_REQ_FIELD_NUMBER = 300;
    public static final int FILE_MD5_FIELD_NUMBER = 101;
    public static final int FILE_NAME_FIELD_NUMBER = 102;
    public static final int FILE_SHA_FIELD_NUMBER = 103;
    public static final int FILE_SIZE_FIELD_NUMBER = 100;
    public static final int GROUP_USER = 1;
    public static final int NORMAL_USER = 0;
    public static final int SRC_BID_FIELD_NUMBER = 20;
    public static final int SRC_FILE_ID_FIELD_NUMBER = 31;
    public static final int SRC_GROUP_FIELD_NUMBER = 22;
    public static final int SRC_PDIR_KEY_FIELD_NUMBER = 30;
    public static final int SRC_UIN_FIELD_NUMBER = 21;
    public static final int USER_TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field dst_bid;
    public final PBUInt64Field dst_uin;
    public WeiyunPB$ExtensionReq extension_req;
    public final PBBytesField file_md5;
    public final PBStringField file_name;
    public final PBBytesField file_sha;
    public final PBUInt64Field file_size;
    public final PBStringField src_file_id;
    public final PBBytesField src_pdir_key;
    public final PBEnumField user_type = PBField.initEnum(0);
    public final PBUInt32Field src_bid = PBField.initUInt32(0);
    public final PBUInt64Field src_uin = PBField.initUInt64(0);
    public final PBUInt64Field src_group = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 160, 168, 176, 242, 250, 800, 810, 818, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO, 1600, 1608, 2402}, new String[]{"user_type", "src_bid", "src_uin", "src_group", "src_pdir_key", "src_file_id", "file_size", "file_md5", "file_name", "file_sha", "dst_bid", "dst_uin", "extension_req"}, new Object[]{0, 0, 0L, 0L, byteStringMicro, "", 0L, byteStringMicro, "", byteStringMicro, 0, 0L, null}, WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq.class);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mobileqq.weiyun.pb.WeiyunPB$ExtensionReq] */
    public WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.src_pdir_key = PBField.initBytes(byteStringMicro);
        this.src_file_id = PBField.initString("");
        this.file_size = PBField.initUInt64(0L);
        this.file_md5 = PBField.initBytes(byteStringMicro);
        this.file_name = PBField.initString("");
        this.file_sha = PBField.initBytes(byteStringMicro);
        this.dst_bid = PBField.initUInt32(0);
        this.dst_uin = PBField.initUInt64(0L);
        this.extension_req = new MessageMicro<WeiyunPB$ExtensionReq>() { // from class: com.tencent.mobileqq.weiyun.pb.WeiyunPB$ExtensionReq
            public static final int BYTES_SIG_FIELD_NUMBER = 20;
            public static final int INT32_PHONE_CONVERT_TYPE_FIELD_NUMBER = 4;
            public static final int STR_DST_PHONENUM_FIELD_NUMBER = 3;
            public static final int UINT64_ID_FIELD_NUMBER = 1;
            public static final int UINT64_ROUTE_ID_FIELD_NUMBER = 100;
            public static final int UINT64_TYPE_FIELD_NUMBER = 2;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 162, 800}, new String[]{"uint64_id", "uint64_type", "str_dst_phonenum", "int32_phone_convert_type", "bytes_sig", "uint64_route_id"}, new Object[]{0L, 0L, "", 0, ByteStringMicro.EMPTY, 0L}, WeiyunPB$ExtensionReq.class);
            public final PBUInt64Field uint64_id = PBField.initUInt64(0);
            public final PBUInt64Field uint64_type = PBField.initUInt64(0);
            public final PBStringField str_dst_phonenum = PBField.initString("");
            public final PBInt32Field int32_phone_convert_type = PBField.initInt32(0);
            public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt64Field uint64_route_id = PBField.initUInt64(0);
        };
    }
}
