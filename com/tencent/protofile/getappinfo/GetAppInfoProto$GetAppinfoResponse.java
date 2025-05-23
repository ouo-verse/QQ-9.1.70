package com.tencent.protofile.getappinfo;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.xweb.FileReaderHelper;

/* loaded from: classes22.dex */
public final class GetAppInfoProto$GetAppinfoResponse extends MessageMicro<GetAppInfoProto$GetAppinfoResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 80, 90}, new String[]{"ret", "msg", "appName", "appComment", "providerName", "appClass", "iconsURL", "androidInfo", "iosInfo", CommonConstant.ReqAccessTokenParam.CLIENT_ID, "ads"}, new Object[]{0, "", "", "", "", "", null, null, null, 0L, null}, GetAppInfoProto$GetAppinfoResponse.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f342197msg = PBField.initString("");
    public final PBStringField appName = PBField.initString("");
    public final PBStringField appComment = PBField.initString("");
    public final PBStringField providerName = PBField.initString("");
    public final PBStringField appClass = PBField.initString("");
    public final PBRepeatMessageField<GetAppInfoProto$MsgIconsurl> iconsURL = PBField.initRepeatMessage(GetAppInfoProto$MsgIconsurl.class);
    public GetAppInfoProto$AndroidInfo androidInfo = new GetAppInfoProto$AndroidInfo();
    public GetAppInfoProto$IOSInfo iosInfo = new MessageMicro<GetAppInfoProto$IOSInfo>() { // from class: com.tencent.protofile.getappinfo.GetAppInfoProto$IOSInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"urlSchema", "boundleID", "appstoreID", "sourceUrl", "officalwebsite", "messagetail", "a_bundleid"}, new Object[]{"", "", "", "", "", "", ""}, GetAppInfoProto$IOSInfo.class);
        public final PBStringField urlSchema = PBField.initString("");
        public final PBStringField boundleID = PBField.initString("");
        public final PBStringField appstoreID = PBField.initString("");
        public final PBStringField sourceUrl = PBField.initString("");
        public final PBStringField officalwebsite = PBField.initString("");
        public final PBStringField messagetail = PBField.initString("");
        public final PBStringField a_bundleid = PBField.initString("");
    };
    public final PBInt64Field client_id = PBField.initInt64(0);
    public GetAppInfoProto$Ads ads = new MessageMicro<GetAppInfoProto$Ads>() { // from class: com.tencent.protofile.getappinfo.GetAppInfoProto$Ads
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"imgURL", FileReaderHelper.TXT_EXT, "beginTime", "endTime", "serverTime"}, new Object[]{"", "", 0L, 0L, 0L}, GetAppInfoProto$Ads.class);
        public final PBStringField imgURL = PBField.initString("");
        public final PBStringField txt = PBField.initString("");
        public final PBInt64Field beginTime = PBField.initInt64(0);
        public final PBInt64Field endTime = PBField.initInt64(0);
        public final PBInt64Field serverTime = PBField.initInt64(0);
    };
}
