package com.tencent.qconn.protofile;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class appType$AndroidInfo extends MessageMicro<appType$AndroidInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"apk_download_url", "pack_name", PictureConst.KEY_CLASSNAME, AppConstants.Key.SHARE_SOURCE_URL, "offical_website", "message_tail", "bundleid"}, new Object[]{"", "", "", "", "", "", ""}, appType$AndroidInfo.class);
    public final PBStringField apk_download_url = PBField.initString("");
    public final PBStringField pack_name = PBField.initString("");
    public final PBStringField class_name = PBField.initString("");
    public final PBStringField source_url = PBField.initString("");
    public final PBStringField offical_website = PBField.initString("");
    public final PBStringField message_tail = PBField.initString("");
    public final PBStringField bundleid = PBField.initString("");
}
