package com.tencent.mobileqq.utils;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.QQConfMeetingLogReportHelper;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import mqq.manager.TicketManager;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QAVHrMeeting {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void onComplete(String str, int i3);
    }

    static void a(QQAppInterface qQAppInterface, long j3) {
        if (qQAppInterface == null) {
            return;
        }
        com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        String str = BusinessHandlerFactory.DISCUSSION_HANDLER;
        DiscussionHandler discussionHandler = (DiscussionHandler) qQAppInterface.getBusinessHandler(str);
        QLog.d("QAVHrMeeting", 1, "HR_meeting Finish quit DiscussionId[" + j3 + "]");
        discussionHandler.g4(j3);
        nVar.d(String.valueOf(j3));
        RecentUserProxy m3 = qQAppInterface.getProxyManager().m();
        RecentUser findRecentUser = m3.findRecentUser(String.valueOf(j3), 3000);
        if (findRecentUser != null) {
            m3.delRecentUser(findRecentUser);
        }
        ((DiscussionHandler) qQAppInterface.getBusinessHandler(str)).l4();
    }

    public static void b(String str, QQAppInterface qQAppInterface, DiscussionInfo discussionInfo) {
        if ((discussionInfo.mOrigin & 2) != 2) {
            return;
        }
        boolean m3 = m(discussionInfo.mSelfRight);
        long j3 = discussionInfo.uiControlFlag;
        if (m3) {
            com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
            DiscussionHandler discussionHandler = (DiscussionHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
            if (discussionInfo.getHrExtra() == 1) {
                nVar.u(discussionInfo.uin);
                discussionHandler.notifyUI(1004, true, discussionInfo.uin);
            } else {
                nVar.A(discussionInfo.uin);
                Long.parseLong(discussionInfo.uin);
            }
        }
        QLog.w("QAVHrMeeting", 1, "checkHrConfHidden[" + str + "], mSelfRight[" + discussionInfo.mSelfRight + "][" + m3 + "], uiControlFlag[" + j3 + "->" + discussionInfo.uiControlFlag + "], getHrExtra[" + discussionInfo.getHrExtra() + "]");
    }

    public static Bundle c(QQAppInterface qQAppInterface, Bundle bundle) {
        long j3;
        int i3;
        long j16;
        String string = bundle.getString("uin");
        DiscussionInfo h16 = ((com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(string);
        if (h16 != null) {
            j3 = h16.mOrigin;
            j16 = h16.mOriginExtra;
            if (k(j3)) {
                i3 = h16.mSelfRight;
            } else {
                i3 = 0;
            }
        } else {
            j3 = 0;
            i3 = -1;
            j16 = 0;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("Origin", j3);
        bundle2.putLong("OriginExtra", j16);
        bundle2.putInt("SelfRight", i3);
        if (QQAudioHelper.j()) {
            QLog.w("QAVHrMeeting", 1, "GetDiscussOrigin, uin[" + string + "], Origin[" + j3 + "], OriginExtra[" + j16 + "], mSelfRight[" + i3 + "]");
        }
        return bundle2;
    }

    public static void d(QQAppInterface qQAppInterface, DiscussionInfo discussionInfo, DiscussionMemberInfo discussionMemberInfo) {
        if (!discussionInfo.isDiscussHrMeeting()) {
            return;
        }
        String f16 = f();
        discussionMemberInfo.memberName = f16;
        discussionMemberInfo.inteRemark = f16;
        e(qQAppInterface, discussionInfo.uin, discussionMemberInfo.memberUin, null);
    }

    public static void e(final QQAppInterface qQAppInterface, final String str, final String str2, final a aVar) {
        QQAudioHelper.p("\u83b7\u53d6hr\u4fe1\u606f_delay_");
        final String str3 = "https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/get_nickname_video_meeting_for_hr?uin=" + str2 + "&discid=" + str;
        final String str4 = "QAVHrMeeting_" + QQAudioHelper.b();
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.utils.QAVHrMeeting.1
            /* JADX WARN: Can't wrap try/catch for region: R(13:11|12|(15:45|46|48|49|(6:53|(1:55)|56|(1:58)|59|(2:61|(2:65|66)))|68|15|16|(1:18)|20|21|(1:27)|(1:33)|34|(2:36|37)(1:38))|14|15|16|(0)|20|21|(3:23|25|27)|(3:29|31|33)|34|(0)(0)) */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x0111, code lost:
            
                r1 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:40:0x0112, code lost:
            
                r4 = r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x011c, code lost:
            
                if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L45;
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x011e, code lost:
            
                com.tencent.qphone.base.util.QLog.d(r1, 2, "getRedirectInfo.run e = " + r1);
             */
            /* JADX WARN: Code restructure failed: missing block: B:44:0x0135, code lost:
            
                r5.getConnectionManager().shutdown();
                r0 = r4;
             */
            /* JADX WARN: Removed duplicated region for block: B:18:0x00f2 A[Catch: Exception -> 0x0111, all -> 0x0114, TRY_LEAVE, TryCatch #0 {all -> 0x0114, blocks: (B:6:0x004d, B:11:0x005f, B:46:0x0093, B:49:0x009b, B:51:0x00a9, B:53:0x00af, B:55:0x00b9, B:56:0x00bc, B:58:0x00c2, B:59:0x00c6, B:61:0x00cc, B:63:0x00d6, B:65:0x00df, B:16:0x00ec, B:18:0x00f2, B:41:0x0118, B:43:0x011e), top: B:5:0x004d }] */
            /* JADX WARN: Removed duplicated region for block: B:23:0x015b  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x017d  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x01b7  */
            /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str5;
                com.tencent.mobileqq.app.n nVar;
                a aVar2;
                DiscussionMemberInfo l3;
                DiscussionInfo h16;
                String str6 = "";
                if (QLog.isColorLevel()) {
                    QLog.d(str4, 2, "getRedirectInfo.run url[" + str3 + "]");
                }
                QQAudioHelper.p("\u83b7\u53d6hr\u4fe1\u606f_");
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                BasicHttpContext basicHttpContext = new BasicHttpContext();
                HttpGet httpGet = new HttpGet(str3);
                int i3 = 0;
                try {
                    try {
                    } catch (Exception e16) {
                        e = e16;
                    }
                    if (((TicketManager) qQAppInterface.getManager(2)) == null) {
                        return;
                    }
                    httpGet.addHeader("Cookie", "uin=o" + qQAppInterface.getCurrentAccountUin() + ";skey=");
                    HttpResponse execute = defaultHttpClient.execute(httpGet, basicHttpContext);
                    if (execute.getStatusLine().getStatusCode() == 200) {
                        try {
                            String entityUtils = EntityUtils.toString(execute.getEntity());
                            try {
                                JSONObject jSONObject = new JSONObject(entityUtils);
                                if (jSONObject.getInt("retcode") == 0 && jSONObject.has("result")) {
                                    JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                                    if (jSONObject2.has("result_code")) {
                                        jSONObject2.getInt("result_code");
                                    }
                                    if (jSONObject2.has("name")) {
                                        str6 = jSONObject2.getString("name");
                                    }
                                    if (jSONObject2.has("stask")) {
                                        String string = jSONObject2.getString("stask");
                                        if (!TextUtils.isEmpty(string) && string.compareToIgnoreCase("null") != 0) {
                                            i3 = Integer.valueOf(string).intValue();
                                        }
                                    }
                                }
                            } catch (Exception unused) {
                            }
                            str5 = str6;
                            str6 = entityUtils;
                        } catch (Exception unused2) {
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(str4, 2, "getRedirectInfo.run, " + str6);
                        }
                        QQAudioHelper.p("\u83b7\u53d6hr\u4fe1\u606f_rsp_");
                        nVar = (com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                        if (TextUtils.equals(str2, qQAppInterface.getCurrentAccountUin()) && (h16 = nVar.h(str)) != null && h16.mSelfRight != i3) {
                            h16.mSelfRight = i3;
                            nVar.D(h16);
                            QAVHrMeeting.b("getHrConfMemberName", qQAppInterface, h16);
                            QAVHrMeeting.o(qQAppInterface, h16.uin);
                        }
                        if (str5 != null && str5.length() > 0 && (l3 = nVar.l(str, str2)) != null) {
                            l3.memberName = str5;
                            l3.inteRemark = str5;
                            nVar.E(l3);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(str);
                            arrayList.add(1, Boolean.TRUE);
                            ((DiscussionHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).notifyUI(1001, true, arrayList);
                        }
                        aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.onComplete(str5, i3);
                            return;
                        }
                        return;
                    }
                    str5 = "";
                    if (QLog.isColorLevel()) {
                    }
                    QQAudioHelper.p("\u83b7\u53d6hr\u4fe1\u606f_rsp_");
                    nVar = (com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                    if (TextUtils.equals(str2, qQAppInterface.getCurrentAccountUin())) {
                        h16.mSelfRight = i3;
                        nVar.D(h16);
                        QAVHrMeeting.b("getHrConfMemberName", qQAppInterface, h16);
                        QAVHrMeeting.o(qQAppInterface, h16.uin);
                    }
                    if (str5 != null) {
                        l3.memberName = str5;
                        l3.inteRemark = str5;
                        nVar.E(l3);
                        ArrayList arrayList2 = new ArrayList(2);
                        arrayList2.add(str);
                        arrayList2.add(1, Boolean.TRUE);
                        ((DiscussionHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).notifyUI(1001, true, arrayList2);
                    }
                    aVar2 = aVar;
                    if (aVar2 != null) {
                    }
                } finally {
                    defaultHttpClient.getConnectionManager().shutdown();
                }
            }
        }, 5, null, false);
    }

    public static String f() {
        return BaseApplicationImpl.getApplication().getResources().getString(R.string.brx);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String g(com.tencent.mobileqq.app.n nVar, String str, String str2) {
        String str3;
        DiscussionMemberInfo discussionMemberInfo;
        Map<String, DiscussionMemberInfo> n3 = nVar.n(str);
        if (n3 != null && (discussionMemberInfo = n3.get(str2)) != null) {
            if (!TextUtils.isEmpty(discussionMemberInfo.inteRemark)) {
                str3 = discussionMemberInfo.inteRemark;
            } else if (!TextUtils.isEmpty(discussionMemberInfo.memberName)) {
                str3 = discussionMemberInfo.memberName;
            }
            if (!TextUtils.isEmpty(str3)) {
                return f();
            }
            return str3;
        }
        str3 = "";
        if (!TextUtils.isEmpty(str3)) {
        }
    }

    public static int h(long j3) {
        int i3;
        long j16;
        VideoAppInterface videoAppInterface = (VideoAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        Bundle bundle = new Bundle();
        bundle.putString("uin", String.valueOf(j3));
        Bundle s06 = videoAppInterface.s0(5, 0, 0, bundle, null);
        boolean z16 = false;
        long j17 = 0;
        if (s06 != null) {
            long j18 = s06.getLong("Origin", 0L);
            long j19 = s06.getLong("OriginExtra", 0L);
            i3 = s06.getInt("SelfRight", 0);
            j17 = j18;
            j16 = j19;
        } else {
            i3 = -1;
            j16 = 0;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getStasks, relationId[");
        sb5.append(j3);
        sb5.append("], mOrigin[");
        sb5.append(j17);
        sb5.append("], mOriginExtra[");
        sb5.append(j16);
        sb5.append("], mSelfRight[");
        sb5.append(i3);
        sb5.append("], rsp[");
        if (s06 != null) {
            z16 = true;
        }
        sb5.append(z16);
        sb5.append("]");
        QLog.w("QAVHrMeeting", 1, sb5.toString());
        return i3;
    }

    public static void i(QQAppInterface qQAppInterface, long j3, DiscussionInfo discussionInfo) {
        if (discussionInfo == null) {
            discussionInfo = ((com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(String.valueOf(j3));
        }
        if (discussionInfo == null) {
            return;
        }
        long j16 = discussionInfo.mOrigin;
        if ((j16 & 2) != 2 && (j16 & 4) == 4) {
            a(qQAppInterface, j3);
        }
    }

    public static int j(long j3) {
        return (int) (j3 & 3);
    }

    public static boolean k(long j3) {
        if ((j3 & 6) != 0) {
            return true;
        }
        return false;
    }

    public static boolean l(SessionInfo sessionInfo) {
        if (sessionInfo.S1 == -1) {
            if (sessionInfo.S0 == 2) {
                sessionInfo.S1 = h(sessionInfo.P0);
            } else {
                sessionInfo.S1 = 0;
            }
        }
        return m(sessionInfo.S1);
    }

    public static boolean m(int i3) {
        if (i3 != -1 && (i3 & 8) != 8) {
            return false;
        }
        return true;
    }

    public static boolean n(long j3) {
        if ((j3 & 1) == 1) {
            return true;
        }
        return false;
    }

    public static void o(QQAppInterface qQAppInterface, String str) {
        DiscussionHandler discussionHandler = (DiscussionHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        discussionHandler.notifyUI(1000, true, null);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(str);
        arrayList.add(1, Boolean.TRUE);
        discussionHandler.notifyUI(1001, true, arrayList);
    }

    public static void p(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        com.tencent.mobileqq.app.n nVar;
        DiscussionInfo h16;
        DiscussionInfo h17;
        int i3 = messageRecord.msgtype;
        if (i3 != -2016 && i3 != -4008 && messageRecord.istroop == 3000) {
            if (QLog.isColorLevel()) {
                QLog.w("QAVHrMeeting", 1, "onMsgUpdae, curFriendUin[" + messageRecord.frienduin + "], senderuin[" + messageRecord.senderuin + "], isSendFromLocal[" + messageRecord.isSendFromLocal() + "], isSend[" + messageRecord.isSend() + "], msgtype[" + messageRecord.msgtype + "], isread[" + messageRecord.isread + "], msgseq[" + messageRecord.msgseq + "], uniseq[" + messageRecord.uniseq + "], msg[" + QQAudioHelper.d(messageRecord.f203106msg) + "]");
            }
            if (messageRecord.isSend()) {
                if (!messageRecord.isSendFromLocal() || (h17 = ((com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(messageRecord.frienduin)) == null || !h17.isDiscussHrMeeting() || m(h17.mSelfRight) || h17.getHrExtra() != 1) {
                    return;
                }
                ((DiscussionHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).o4(Long.valueOf(messageRecord.frienduin).longValue(), 2);
                return;
            }
            if (messageRecord.msgtype == -1000 && (h16 = (nVar = (com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(messageRecord.frienduin)) != null && h16.isHidden() && h16.getHrExtra() == 1) {
                h16.mOriginExtra = 2L;
                nVar.D(h16);
                b("onMsgUpdae", qQAppInterface, h16);
                o(qQAppInterface, h16.uin);
            }
        }
    }

    public static void q(QQAppInterface qQAppInterface, Intent intent, int i3, long j3) {
        DiscussionInfo h16;
        if (i3 == 2 && (h16 = ((com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(String.valueOf(j3))) != null && h16.isDiscussHrMeeting()) {
            int intExtra = intent.getIntExtra("quitReson", -1);
            if (intExtra != 20 && intExtra != 7) {
                i(qQAppInterface, j3, h16);
            }
            if (m(h16.mSelfRight)) {
                ((DiscussionHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).S2(j3);
            }
            QLog.e("QAVHrMeeting", 1, "do Report, lFlag=" + h16.mOrigin);
            QQConfMeetingLogReportHelper.f(qQAppInterface).c(qQAppInterface.getAVNotifyCenter().K(), System.currentTimeMillis());
        }
    }

    public static void r(QQAppInterface qQAppInterface, Bundle bundle) {
        ((DiscussionHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).o4(Long.valueOf(bundle.getString("uin")).longValue(), 1);
    }
}
