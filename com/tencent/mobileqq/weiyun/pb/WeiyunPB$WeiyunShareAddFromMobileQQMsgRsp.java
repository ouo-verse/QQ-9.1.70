package com.tencent.mobileqq.weiyun.pb;

import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;

/* loaded from: classes20.dex */
public final class WeiyunPB$WeiyunShareAddFromMobileQQMsgRsp extends MessageMicro<WeiyunPB$WeiyunShareAddFromMobileQQMsgRsp> {
    public static final int ICON_FIELD_NUMBER = 91;
    public static final int RAW_URL_FIELD_NUMBER = 10;
    public static final int SHARE_CNT_FIELD_NUMBER = 40;
    public static final int SHARE_KEY_FIELD_NUMBER = 60;
    public static final int SHARE_NAME_FIELD_NUMBER = 30;
    public static final int SHARE_PWD_FIELD_NUMBER = 50;
    public static final int SHORT_URL_FIELD_NUMBER = 20;
    public static final int THUMB_URL_FIELD_NUMBER = 90;
    public static final int WEIYUN_SHARE_AUTH_INFO_FIELD_NUMBER = 80;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 162, 242, 320, 402, 482, 642, QVipServiceAccountFolderProcessor.CMD, TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH}, new String[]{"raw_url", "short_url", "share_name", "share_cnt", "share_pwd", "share_key", "weiyun_share_auth_info", FacadeCacheData.THUMB_URL, "icon"}, new Object[]{"", "", "", 0, "", "", null, "", ""}, WeiyunPB$WeiyunShareAddFromMobileQQMsgRsp.class);
    public final PBStringField raw_url = PBField.initString("");
    public final PBStringField short_url = PBField.initString("");
    public final PBStringField share_name = PBField.initString("");
    public final PBInt32Field share_cnt = PBField.initInt32(0);
    public final PBStringField share_pwd = PBField.initString("");
    public final PBStringField share_key = PBField.initString("");
    public WeiyunPB$WeiyunShareAuthInfo weiyun_share_auth_info = new WeiyunPB$WeiyunShareAuthInfo();
    public final PBStringField thumb_url = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
}
