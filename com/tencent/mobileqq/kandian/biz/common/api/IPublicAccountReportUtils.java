package com.tencent.mobileqq.kandian.biz.common.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.annotation.IgnoreDenyDependencyToSelf;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@IgnoreDenyDependencyToSelf(reason = "\u6682\u4e0d\u5904\u7406\u5916\u90e8\u4f9d\u8d56\u4e8e\u6b64\u7c7b\u7684\u4f9d\u8d56\uff0c\u8fd9\u91cc\u540e\u7eed\u5e94\u8be5\u5904\u7406\u6389 repo \u5c42\u4f9d\u8d56\u6b64\u7c7b\u7684\u4f9d\u8d56")
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IPublicAccountReportUtils extends QRouteApi {
    public static final String VIDEO_REPORT_ACTION_NAME = "VIDEO_REPORT_ACTION_NAME";
    public static final String VIDEO_REPORT_FROM_TYPE = "VIDEO_REPORT_FROM_TYPE";
    public static final String VIDEO_REPORT_R2 = "VIDEO_REPORT_R2";
    public static final String VIDEO_REPORT_R3 = "VIDEO_REPORT_R3";
    public static final String VIDEO_REPORT_R4 = "VIDEO_REPORT_R4";
    public static final String VIDEO_REPORT_R5 = "VIDEO_REPORT_R5";
    public static final String VIDEO_REPORT_RESULT = "VIDEO_REPORT_RESULT";
    public static final String VIDEO_REPORT_SHOULD_ENCODE = "VIDEO_REPORT_SHOULD_ENCODE";
    public static final String VIDEO_REPORT_SUBACTION = "VIDEO_REPORT_SUBACTION";
    public static final String VIDEO_REPORT_TOUIN = "VIDEO_REPORT_TOUIN";

    String changeToUTF8(String str);

    void publicAccountReportClickEvent(AppInterface appInterface, String str, String str2, String str3, int i3, int i16, String str4, String str5, String str6, String str7);

    void publicAccountReportClickEvent(AppInterface appInterface, String str, String str2, String str3, int i3, int i16, String str4, String str5, String str6, String str7, boolean z16);

    void publicAccountReportClickEventForMigrate(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9);

    void publicAccountReportClickEventForMigrate(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9, boolean z16);

    void reportFollowEvent(AppInterface appInterface, String str, int i3);

    void reportPAinfoToLighthouse(String str, String str2, String str3, String str4, String str5, String str6);

    void reportPubAccMsg(List<MessageRecord> list);
}
