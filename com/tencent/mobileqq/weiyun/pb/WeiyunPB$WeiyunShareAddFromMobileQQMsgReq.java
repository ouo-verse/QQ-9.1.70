package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.view.FilterEnum;

/* loaded from: classes20.dex */
public final class WeiyunPB$WeiyunShareAddFromMobileQQMsgReq extends MessageMicro<WeiyunPB$WeiyunShareAddFromMobileQQMsgReq> {
    public static final int ENABLE_QQ_ADD_FRIEND_FIELD_NUMBER = 4;
    public static final int FILE_FIELD_NUMBER = 20;
    public static final int FILE_NAME_FIELD_NUMBER = 35;
    public static final int FILE_SHA_FIELD_NUMBER = 36;
    public static final int FILE_SIZE_FIELD_NUMBER = 34;
    public static final int PASS_WORD_FIELD_NUMBER = 3;
    public static final int QR_FLAG_FIELD_NUMBER = 5;
    public static final int SHARE_NAME_FIELD_NUMBER = 1;
    public static final int SOURCE_FIELD_NUMBER = 2;
    public static final int SRC_APPID_FIELD_NUMBER = 32;
    public static final int SRC_FULL_PATH_FIELD_NUMBER = 33;
    public static final int SRC_UIN_FIELD_NUMBER = 31;
    public static final int WEIYUN_SHARE_AUTH_INFO_FIELD_NUMBER = 10;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 82, 162, 248, 256, 266, 272, FilterEnum.MIC_PTU_BAIXI, 290}, new String[]{"share_name", "source", "pass_word", "enable_qq_add_friend", "qr_flag", "weiyun_share_auth_info", "file", "src_uin", "src_appid", "src_full_path", "file_size", "file_name", "file_sha"}, new Object[]{"", 0, "", Boolean.FALSE, 0, null, null, 0L, 0, ByteStringMicro.EMPTY, 0L, "", ""}, WeiyunPB$WeiyunShareAddFromMobileQQMsgReq.class);
    public final PBStringField share_name = PBField.initString("");
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBStringField pass_word = PBField.initString("");
    public final PBBoolField enable_qq_add_friend = PBField.initBool(false);
    public final PBInt32Field qr_flag = PBField.initInt32(0);
    public WeiyunPB$WeiyunShareAuthInfo weiyun_share_auth_info = new WeiyunPB$WeiyunShareAuthInfo();
    public WeiyunPB$ShareFileItem file = new WeiyunPB$ShareFileItem();
    public final PBUInt64Field src_uin = PBField.initUInt64(0);
    public final PBUInt32Field src_appid = PBField.initUInt32(0);
    public final PBBytesField src_full_path = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field file_size = PBField.initUInt64(0);
    public final PBStringField file_name = PBField.initString("");
    public final PBStringField file_sha = PBField.initString("");
}
