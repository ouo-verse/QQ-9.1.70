package jq3;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.j;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.structmsg.view.y;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.Iterator;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* compiled from: P */
    /* renamed from: jq3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C10608a {

        /* renamed from: a, reason: collision with root package name */
        public String f410854a;

        /* renamed from: b, reason: collision with root package name */
        public String f410855b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f410856c;

        /* renamed from: d, reason: collision with root package name */
        public String f410857d;

        /* renamed from: e, reason: collision with root package name */
        public int f410858e;
    }

    public static C10608a a(com.tencent.qqnt.msg.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        String d16 = aVar.d();
        String e16 = aVar.e();
        String m3 = aVar.m();
        C10608a c10608a = new C10608a();
        if ("com.tencent.structmsg".equals(d16)) {
            if ("music".equals(e16)) {
                c10608a.f410854a = "2";
                c10608a.f410855b = ArkMsgUtils.getMusicTitle(m3);
                c10608a.f410857d = ArkMsgUtils.getMusicAppId(m3);
                c10608a.f410858e = 2;
            } else if ("news".equals(e16)) {
                c10608a.f410854a = "1";
                c10608a.f410855b = ArkMsgUtils.getNewsTitle(m3);
                c10608a.f410857d = ArkMsgUtils.getNewsAppId(m3);
                c10608a.f410858e = 2;
            }
            c10608a.f410856c = ArkMsgUtils.isFromSdkShare(aVar);
        } else {
            c10608a.f410854a = "4";
            c10608a.f410855b = aVar.n();
            c10608a.f410856c = false;
            c10608a.f410857d = aVar.b();
        }
        if (TextUtils.isEmpty(c10608a.f410855b)) {
            c10608a.f410855b = "";
        }
        return c10608a;
    }

    public static void b(com.tencent.qqnt.msg.data.a aVar, MsgRecord msgRecord) {
        String str;
        String str2;
        String peerUid;
        if (aVar != null && msgRecord != null) {
            C10608a a16 = a(aVar);
            if (!a16.f410856c) {
                return;
            }
            ReportController.o(null, "dc00898", "", "", "0X800A630", "0X800A630", 0, a16.f410858e, a16.f410854a, t(msgRecord), a16.f410855b, a16.f410857d);
            if (QLog.isColorLevel()) {
                QLog.d("SdkShareReport", 2, "ARK\u70b9\u51fb=0X800A630, type=", a16.f410854a, ", uinType=", t(msgRecord), ", title=", a16.f410855b);
            }
            if (a16.f410854a.equals("2")) {
                if (msgRecord.getChatType() == 1) {
                    str2 = "c2c_AIO";
                } else {
                    str2 = "Grp_AIO";
                }
                if (msgRecord.getChatType() == 1) {
                    peerUid = "";
                } else {
                    peerUid = msgRecord.getPeerUid();
                }
                ReportController.o(null, "dc00899", str2, "", "music_tab", "clk_musicark_share", 0, 0, peerUid, "", "", "");
            }
            String m3 = aVar.m();
            if (a16.f410854a.equals("1") && "101492711".equals(ArkMsgUtils.getNewsAppId(m3))) {
                if (msgRecord.getChatType() == 1) {
                    str = "c2c_AIO";
                } else {
                    str = "Grp_AIO";
                }
                ReportController.o(null, "dc00899", str, "", "video_tab", "clk_videoark_share", 0, 0, msgRecord.getPeerUid(), aVar.b(), "", "");
            }
        }
    }

    public static void c(String str, int i3, String str2, long j3) {
        ReportController.o(null, "dc00898", "", "", "0X800A630", "0X800A630", 0, 1, str, s(i3), str2, String.valueOf(j3));
        if (QLog.isColorLevel()) {
            QLog.d("SdkShareReport", 2, "\u5206\u4eab\u5185\u5bb9\u70b9\u51fb=", "0X800A630, type=", str, ", title=" + str2, ", uinType=", s(i3));
        }
    }

    public static void d(int i3, long j3, String str) {
        ReportController.o(null, "dc00898", "", "", "0X800A428", "0X800A428", 0, 1, "", s(i3), Long.toString(j3), str);
        if (QLog.isColorLevel()) {
            QLog.d("SdkShareReport", 2, "\u5927\u56fe\u70b9\u51fb=0X800A428, appid=" + j3 + ", fileType=4, briefTitle=", str);
        }
    }

    public static void e(Bundle bundle, long j3) {
        int i3 = bundle.getInt("uintype");
        String string = bundle.getString(AppConstants.Key.FORWARD_ARK_APP_REPORT_TYPE);
        String string2 = bundle.getString(AppConstants.Key.FORWARD_ARK_APP_REPORT_TITLE);
        int i16 = bundle.getInt(AppConstants.Key.FORWARD_ARK_APP_REPORT_RESULT);
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A631", "0X800A631", 0, i16, string, s(i3), string2, String.valueOf(j3));
        if (QLog.isColorLevel()) {
            QLog.d("SdkShareReport", 2, "ARK\u8f6c\u53d1=0X800A631, type=", string, ", uinType=", s(i3), ", title=", string2);
        }
    }

    public static void f(QQAppInterface qQAppInterface, long j3, Intent intent, AbsShareMsg absShareMsg) {
        String[] f16;
        String str;
        if (absShareMsg instanceof StructMsgForGeneralShare) {
            StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) absShareMsg;
            Iterator<AbsStructMsgElement> it = structMsgForGeneralShare.iterator();
            while (it.hasNext()) {
                AbsStructMsgElement next = it.next();
                if (next instanceof y) {
                    Iterator<AbsStructMsgElement> it5 = ((y) next).U0.iterator();
                    while (it5.hasNext()) {
                        AbsStructMsgElement next2 = it5.next();
                        if (next2 instanceof StructMsgItemVideo) {
                            StructMsgItemVideo structMsgItemVideo = (StructMsgItemVideo) next2;
                            if (structMsgItemVideo.v()) {
                                ((IVideoReporter) QRoute.api(IVideoReporter.class)).reportClickEvent("0X80065FF", structMsgForGeneralShare.uinType, ((IVideoReporter) QRoute.api(IVideoReporter.class)).getReportVideoType(structMsgItemVideo.f290495j1, structMsgForGeneralShare.mSourceName), structMsgItemVideo.W0, "");
                            }
                        }
                    }
                }
            }
            h(intent, j3, "1");
            return;
        }
        if (absShareMsg instanceof StructMsgForImageShare) {
            if (j.e(absShareMsg.mMsgActionData) && (f16 = j.f(absShareMsg.mMsgActionData)) != null && f16.length > 3 && (str = f16[3]) != null && str.equals("1")) {
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(qQAppInterface, "", "0X80072A5", "0X80072A5", 0, 0, "", "", "", "");
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80072A5", "", "", "", "", "");
            }
            g(intent);
            return;
        }
        if (absShareMsg instanceof StructMsgForAudioShare) {
            h(intent, j3, "2");
        }
    }

    public static void g(Intent intent) {
        if (!intent.getBooleanExtra(ForwardRecentActivity.KEY_FORWARD_IMAGE_SHARE, false)) {
            return;
        }
        String stringExtra = intent.getStringExtra(ForwardRecentActivity.KEY_FORWARD_IMAGE_SHARE_APPID);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        int intExtra = intent.getIntExtra(ForwardRecentActivity.KEY_FORWARD_IMAGE_SHARE_UIN_TYPE, 0);
        String stringExtra2 = intent.getStringExtra(ForwardRecentActivity.KEY_FORWARD_IMAGE_SHARE_TITLE);
        ReportController.o(null, "dc00898", "", "", "0X800A427", "0X800A427", 0, 1, "", s(intExtra), stringExtra, stringExtra2);
        if (QLog.isColorLevel()) {
            QLog.d(ForwardBaseOption.TAG, 2, "\u5927\u56fe\u8f6c\u53d1=", "0X800A427", ", appid", stringExtra, ", title=", stringExtra2);
        }
    }

    public static void h(Intent intent, long j3, String str) {
        if (!intent.getBooleanExtra(ForwardRecentActivity.KEY_FORWARD_SHARE, false)) {
            return;
        }
        String stringExtra = intent.getStringExtra(ForwardRecentActivity.KEY_FORWARD_SHARE_TITLE);
        int intExtra = intent.getIntExtra(ForwardRecentActivity.KEY_FORWARD_IMAGE_SHARE_UIN_TYPE, 0);
        ReportController.o(null, "dc00898", "", "", "0X800A631", "0X800A631", 0, 1, str, s(intExtra), stringExtra, String.valueOf(j3));
        if (QLog.isColorLevel()) {
            QLog.d(ForwardBaseOption.TAG, 2, "\u56fe\u6587\u6216\u8005\u97f3\u4e50\u8f6c\u53d1=0X800A631, type=", str, ", title=", stringExtra, ", uinType=", s(intExtra));
        }
    }

    public static void i(AppRuntime appRuntime) {
        ReportController.y(appRuntime, "0X800BA85");
    }

    public static void j(Bundle bundle) {
        ReportController.o(null, "dc00898", "", "", "0X8009C93", "0X8009C93", 0, p(bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE)), String.valueOf(bundle.getLong("req_share_id")), q(bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE)), r(bundle.getInt("uintype")), bundle.getString("title"));
    }

    public static void k(AbsStructMsg absStructMsg, int i3, long j3) {
        ReportController.o(null, "dc00898", "", "", "0X8009C93", "0X8009C93", 0, 1, String.valueOf(j3), "4", r(i3), ((AbsShareMsg) absStructMsg).mContentTitle);
    }

    public static void l(AbsStructMsg absStructMsg, Bundle bundle) {
        String str;
        String q16 = q(bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE));
        String r16 = r(bundle.getInt("uintype"));
        if (absStructMsg instanceof AbsShareMsg) {
            str = ((AbsShareMsg) absStructMsg).mContentTitle;
        } else {
            str = "";
        }
        ReportController.o(null, "dc00898", "", "", "0X8009C93", "0X8009C93", 0, p(bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE)), String.valueOf(bundle.getLong("req_share_id")), q16, r16, str);
    }

    public static void m(Bundle bundle, int i3, long j3) {
        ReportController.o(null, "dc00898", "", "", "0X800B2DB", "0X800B2DB", 0, p(i3), String.valueOf(j3), q(i3), r(bundle.getInt("uintype")), bundle.getString("title"));
    }

    public static void n(String str, int i3, String str2, long j3) {
        ReportController.o(null, "dc00898", "", "", "0X800A62F", "0X800A62F", 0, 1, str, s(i3), str2, String.valueOf(j3));
        if (QLog.isColorLevel()) {
            QLog.d("SdkShareReport", 2, "\u66dd\u5149=0X800A62F, type=", str, ", title=", str2, ", uinType=", s(i3));
        }
    }

    public static void o(int i3, long j3, String str) {
        ReportController.o(null, "dc00898", "", "", "0X800A426", "0X800A426", 0, 1, "", s(i3), String.valueOf(j3), str);
        if (QLog.isColorLevel()) {
            QLog.d("SdkShareReport", 2, "\u5927\u56fe\u66dd\u5149=", "0X800A426", ", appid=", Long.valueOf(j3), ", getTitleFromBrief=", str);
        }
    }

    public static int p(int i3) {
        if (i3 != 5) {
            if (i3 != 2147483646) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public static String q(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            return "0";
                        }
                        return "5";
                    }
                    return "4";
                }
                return "3";
            }
            return "2";
        }
        return "1";
    }

    public static String r(int i3) {
        if (i3 == 0) {
            return "1";
        }
        if (1 == i3) {
            return "2";
        }
        if (3000 == i3) {
            return "3";
        }
        return "0";
    }

    public static String s(int i3) {
        if (i3 == 0) {
            return "1";
        }
        if (1 != i3 && 3000 != i3) {
            return "0";
        }
        return "2";
    }

    public static String t(MsgRecord msgRecord) {
        int chatType = msgRecord.getChatType();
        if (1 == chatType) {
            return "1";
        }
        if (2 != chatType && 3 != chatType) {
            return "0";
        }
        return "2";
    }
}
