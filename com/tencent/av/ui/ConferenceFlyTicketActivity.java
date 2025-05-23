package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.download.BaseDownloadAsyncTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ConferenceFlyTicketActivity extends BaseActivity {

    /* renamed from: m0, reason: collision with root package name */
    a f74753m0;

    /* renamed from: n0, reason: collision with root package name */
    DiscussionHandler f74754n0;

    /* renamed from: o0, reason: collision with root package name */
    b f74755o0;

    /* renamed from: p0, reason: collision with root package name */
    d f74756p0;

    /* renamed from: q0, reason: collision with root package name */
    c f74757q0;

    /* renamed from: b0, reason: collision with root package name */
    String f74742b0 = null;

    /* renamed from: c0, reason: collision with root package name */
    String f74743c0 = null;

    /* renamed from: d0, reason: collision with root package name */
    String f74744d0 = null;

    /* renamed from: e0, reason: collision with root package name */
    String f74745e0 = null;

    /* renamed from: f0, reason: collision with root package name */
    String f74746f0 = null;

    /* renamed from: g0, reason: collision with root package name */
    String f74747g0 = null;

    /* renamed from: h0, reason: collision with root package name */
    String f74748h0 = null;

    /* renamed from: i0, reason: collision with root package name */
    int f74749i0 = -1;

    /* renamed from: j0, reason: collision with root package name */
    String f74750j0 = null;

    /* renamed from: k0, reason: collision with root package name */
    String f74751k0 = null;

    /* renamed from: l0, reason: collision with root package name */
    boolean f74752l0 = false;

    /* renamed from: r0, reason: collision with root package name */
    Handler f74758r0 = null;

    /* renamed from: s0, reason: collision with root package name */
    boolean f74759s0 = false;

    /* renamed from: a0, reason: collision with root package name */
    final String f74741a0 = "ConferenceFlyTicketActivity." + com.tencent.av.utils.e.d();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends com.tencent.mobileqq.discussion.observer.a {
        a() {
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void n(boolean z16, int i3, long j3, String str, String str2, long j16) {
            QLog.w(ConferenceFlyTicketActivity.this.f74741a0, 1, "onGetFlyTicket, isSuccess[" + z16 + "], errorCode[" + i3 + "], validTime[" + j3 + "], sigUrl[" + str + "], shortUrl[" + str2 + "], discussionUin[" + j16 + "], mDiscID[" + ConferenceFlyTicketActivity.this.f74748h0 + "]");
            if (z16) {
                if (!TextUtils.isEmpty(ConferenceFlyTicketActivity.this.f74748h0)) {
                    ConferenceFlyTicketActivity.this.f74755o0 = new b();
                    ArrayList arrayList = new ArrayList();
                    com.tencent.av.utils.download.a aVar = new com.tencent.av.utils.download.a();
                    aVar.f77096a = "https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/createConfCallback?feedkey=" + ConferenceFlyTicketActivity.this.f74742b0;
                    ConferenceFlyTicketActivity.this.f74744d0 = str2.substring(15, str2.length() - 10);
                    QLog.w(ConferenceFlyTicketActivity.this.f74741a0, 1, "onGetFlyTicket, mTicket[" + ConferenceFlyTicketActivity.this.f74744d0 + "]");
                    aVar.f77096a += "&ret=0&ticket=" + ConferenceFlyTicketActivity.this.f74744d0;
                    arrayList.add(aVar);
                    ConferenceFlyTicketActivity.this.f74755o0.execute(arrayList);
                    return;
                }
                return;
            }
            ConferenceFlyTicketActivity.this.f74754n0.g4(j16);
            ConferenceFlyTicketActivity.this.P2(1, i3);
        }

        @Override // com.tencent.mobileqq.discussion.observer.a, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            Object[] objArr;
            QLog.w(ConferenceFlyTicketActivity.this.f74741a0, 1, "DiscussObserver.onUpdate, type[" + i3 + "], isSuccess[" + z16 + "], mDiscID[" + ConferenceFlyTicketActivity.this.f74748h0 + "]");
            if (i3 == 1001) {
                com.tencent.av.utils.e.p("\u83b7\u53d6\u8ba8\u8bba\u7ec4\u8d44\u6599_rsp");
                if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    objArr = new Object[]{String.valueOf(arrayList.get(0)), arrayList.get(1)};
                } else {
                    objArr = (Object[]) obj;
                }
                String str = (String) objArr[0];
                ((Boolean) objArr[1]).booleanValue();
                if (ConferenceFlyTicketActivity.this.f74748h0.equals(str) && z16) {
                    ConferenceFlyTicketActivity.this.K2();
                    ConferenceFlyTicketActivity conferenceFlyTicketActivity = ConferenceFlyTicketActivity.this;
                    conferenceFlyTicketActivity.R2(conferenceFlyTicketActivity.f74748h0, conferenceFlyTicketActivity.f74743c0);
                }
                ConferenceFlyTicketActivity.this.finish();
                return;
            }
            if (1014 == i3) {
                com.tencent.av.utils.e.p("\u901a\u8fc7\u7b7e\u540d\u52a0\u5165\u8ba8\u8bba\u7ec4_rsp");
                Long[] lArr = (Long[]) obj;
                long longValue = lArr[1].longValue();
                int intValue = lArr[0].intValue();
                QLog.w(ConferenceFlyTicketActivity.this.f74741a0, 1, "NOTIFY_TYPE_JOIN_DISCUSSION_BY_FLYY_TICKET, discussUin[" + longValue + "], errCode[" + intValue + "], mDiscID[" + ConferenceFlyTicketActivity.this.f74748h0 + "]");
                if (intValue == 0) {
                    if (TextUtils.equals(String.valueOf(longValue), ConferenceFlyTicketActivity.this.f74748h0)) {
                        ConferenceFlyTicketActivity.this.K2();
                        com.tencent.av.utils.e.p(HardCodeUtil.qqStr(R.string.kyk));
                        ((DiscussionHandler) ConferenceFlyTicketActivity.this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).S2(longValue);
                        return;
                    }
                    ConferenceFlyTicketActivity.this.finish();
                    return;
                }
                ConferenceFlyTicketActivity.this.finish();
                ConferenceFlyTicketActivity.this.P2(1, intValue);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void p(boolean z16, long j3, int i3) {
            QLog.w(ConferenceFlyTicketActivity.this.f74741a0, 1, "onJoinDiscussionByFlyTicket, isSuccess[" + z16 + "], discussUin[" + j3 + "], errorCode[" + i3 + "], mDiscID[" + ConferenceFlyTicketActivity.this.f74748h0 + "]");
            if (z16) {
                ConferenceFlyTicketActivity.this.f74748h0 = String.valueOf(j3);
                if (!TextUtils.isEmpty(ConferenceFlyTicketActivity.this.f74748h0)) {
                    ((DiscussionHandler) ConferenceFlyTicketActivity.this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).S2(j3);
                    return;
                }
                return;
            }
            ConferenceFlyTicketActivity.this.P2(1, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b extends BaseDownloadAsyncTask {
        public b() {
            SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        }

        @Override // com.tencent.av.utils.download.BaseDownloadAsyncTask
        public void e(com.tencent.av.utils.download.a aVar) {
            int i3;
            String str;
            com.tencent.av.utils.download.b bVar = aVar.f77101f;
            String str2 = "";
            if (bVar.f77107f) {
                try {
                    str = new String(bVar.f77102a, StandardCharsets.UTF_8);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(ConferenceFlyTicketActivity.this.f74741a0, 2, "onPostDownloadComplete :" + e16.toString());
                    }
                    str = null;
                }
                if (str != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        i3 = jSONObject.getInt("retcode");
                        if (QLog.isColorLevel()) {
                            QLog.d(ConferenceFlyTicketActivity.this.f74741a0, 2, "OnAfterCreateDiscussionAsyncTask.onPostDownloadComplete : retcode = " + i3);
                        }
                        if (jSONObject.has("result")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                            if (jSONObject2.has("result_code")) {
                                str2 = jSONObject2.getString("result_code");
                            }
                        }
                    } catch (JSONException unused) {
                        i3 = -2;
                        if (QLog.isColorLevel()) {
                            QLog.i(ConferenceFlyTicketActivity.this.f74741a0, 2, "onPostDownloadComplete : result_code = ,retcode = -2");
                        }
                    }
                    QLog.w(ConferenceFlyTicketActivity.this.f74741a0, 1, "OnAfterCreateDiscussionAsyncTask, IsSucc[" + aVar.f77101f.f77107f + "], retcode[" + i3 + "], result_code[" + str2 + "], mDiscID[" + ConferenceFlyTicketActivity.this.f74748h0 + "]");
                    if (i3 != 0 && str2.equals("0")) {
                        ConferenceFlyTicketActivity conferenceFlyTicketActivity = ConferenceFlyTicketActivity.this;
                        conferenceFlyTicketActivity.f74754n0.I2(Long.parseLong(conferenceFlyTicketActivity.f74748h0), ConferenceFlyTicketActivity.this.f74743c0);
                        ConferenceFlyTicketActivity conferenceFlyTicketActivity2 = ConferenceFlyTicketActivity.this;
                        conferenceFlyTicketActivity2.R2(conferenceFlyTicketActivity2.f74748h0, conferenceFlyTicketActivity2.f74743c0);
                        ConferenceFlyTicketActivity.this.finish();
                        return;
                    }
                    ConferenceFlyTicketActivity conferenceFlyTicketActivity3 = ConferenceFlyTicketActivity.this;
                    conferenceFlyTicketActivity3.f74754n0.g4(Long.parseLong(conferenceFlyTicketActivity3.f74748h0));
                    ConferenceFlyTicketActivity.this.P2(1, 0);
                }
            }
            i3 = 1;
            QLog.w(ConferenceFlyTicketActivity.this.f74741a0, 1, "OnAfterCreateDiscussionAsyncTask, IsSucc[" + aVar.f77101f.f77107f + "], retcode[" + i3 + "], result_code[" + str2 + "], mDiscID[" + ConferenceFlyTicketActivity.this.f74748h0 + "]");
            if (i3 != 0) {
            }
            ConferenceFlyTicketActivity conferenceFlyTicketActivity32 = ConferenceFlyTicketActivity.this;
            conferenceFlyTicketActivity32.f74754n0.g4(Long.parseLong(conferenceFlyTicketActivity32.f74748h0));
            ConferenceFlyTicketActivity.this.P2(1, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c extends BaseDownloadAsyncTask {

        /* renamed from: e, reason: collision with root package name */
        String f74764e;

        public c(String str) {
            this.f74764e = str;
            SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0126  */
        /* JADX WARN: Removed duplicated region for block: B:40:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        @Override // com.tencent.av.utils.download.BaseDownloadAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void e(com.tencent.av.utils.download.a aVar) {
            int i3;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            com.tencent.av.utils.download.b bVar = aVar.f77101f;
            String str8 = null;
            String str9 = "";
            if (bVar.f77107f) {
                try {
                    str4 = new String(bVar.f77102a, StandardCharsets.UTF_8);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ConferenceFlyTicketActivity.this.f74741a0, 2, "OnGetDiscNameCardTask.onPostDownloadComplete e = " + e16.toString());
                    }
                    str4 = null;
                }
                if (str4 != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(str4);
                        i3 = jSONObject.getInt("retcode");
                        if (!jSONObject.has("result")) {
                            str7 = "";
                            str5 = str7;
                        } else {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                            if (jSONObject2.has("result_code")) {
                                str8 = jSONObject2.getString("result_code");
                            }
                            if (!jSONObject2.has("disc_name_card")) {
                                str6 = "";
                            } else {
                                str6 = jSONObject2.getString("disc_name_card");
                            }
                            try {
                                if (!jSONObject2.has("name_card_sender_uin")) {
                                    str5 = "";
                                } else {
                                    str5 = jSONObject2.getString("name_card_sender_uin");
                                }
                            } catch (JSONException e17) {
                                e = e17;
                                str5 = "";
                            }
                            try {
                                if (!jSONObject2.has("name_card_sender_name")) {
                                    str7 = "";
                                } else {
                                    str7 = jSONObject2.getString("name_card_sender_name");
                                }
                                str9 = str6;
                            } catch (JSONException e18) {
                                e = e18;
                                if (QLog.isColorLevel()) {
                                    QLog.d(ConferenceFlyTicketActivity.this.f74741a0, 2, "OnGetDiscNameCardTask.onPostDownloadComplete e = " + e.toString());
                                }
                                i3 = -2;
                                str2 = str5;
                                str = str6;
                                str3 = "";
                                QLog.w(ConferenceFlyTicketActivity.this.f74741a0, 1, "OnGetDiscNameCardTask.onPostDownloadComplete, result_code[" + str8 + "], disc_name_card[" + str + "], name_card_sender_uin[" + str2 + "], name_card_sender_name[" + str3 + "], retcode[" + i3 + "], mDiscID[" + this.f74764e + "]");
                                ConferenceFlyTicketActivity conferenceFlyTicketActivity = ConferenceFlyTicketActivity.this;
                                conferenceFlyTicketActivity.Q2(this.f74764e, conferenceFlyTicketActivity.app.getCurrentUin(), str2, str3);
                                if (i3 == 0) {
                                }
                            }
                        }
                        str3 = str7;
                        str2 = str5;
                        str = str9;
                    } catch (JSONException e19) {
                        e = e19;
                        str5 = "";
                        str6 = str5;
                    }
                    QLog.w(ConferenceFlyTicketActivity.this.f74741a0, 1, "OnGetDiscNameCardTask.onPostDownloadComplete, result_code[" + str8 + "], disc_name_card[" + str + "], name_card_sender_uin[" + str2 + "], name_card_sender_name[" + str3 + "], retcode[" + i3 + "], mDiscID[" + this.f74764e + "]");
                    ConferenceFlyTicketActivity conferenceFlyTicketActivity2 = ConferenceFlyTicketActivity.this;
                    conferenceFlyTicketActivity2.Q2(this.f74764e, conferenceFlyTicketActivity2.app.getCurrentUin(), str2, str3);
                    if (i3 == 0 && TextUtils.equals(str8, "0") && !TextUtils.isEmpty(str) && !str.equals("null")) {
                        ConferenceFlyTicketActivity conferenceFlyTicketActivity3 = ConferenceFlyTicketActivity.this;
                        conferenceFlyTicketActivity3.I2(str, this.f74764e, conferenceFlyTicketActivity3.app.getCurrentUin(), str2, str3);
                        return;
                    }
                    return;
                }
            }
            i3 = -1;
            str = "";
            str2 = str;
            str3 = str2;
            QLog.w(ConferenceFlyTicketActivity.this.f74741a0, 1, "OnGetDiscNameCardTask.onPostDownloadComplete, result_code[" + str8 + "], disc_name_card[" + str + "], name_card_sender_uin[" + str2 + "], name_card_sender_name[" + str3 + "], retcode[" + i3 + "], mDiscID[" + this.f74764e + "]");
            ConferenceFlyTicketActivity conferenceFlyTicketActivity22 = ConferenceFlyTicketActivity.this;
            conferenceFlyTicketActivity22.Q2(this.f74764e, conferenceFlyTicketActivity22.app.getCurrentUin(), str2, str3);
            if (i3 == 0) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d extends BaseDownloadAsyncTask {
        public d() {
            SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        }

        @Override // com.tencent.av.utils.download.BaseDownloadAsyncTask
        public void e(com.tencent.av.utils.download.a aVar) {
            int i3;
            String str;
            com.tencent.av.utils.e.p("\u4e0a\u4f20SelfNickName_rsp");
            com.tencent.av.utils.download.b bVar = aVar.f77101f;
            String str2 = "";
            if (bVar.f77107f) {
                try {
                    str = new String(bVar.f77102a, StandardCharsets.UTF_8);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(ConferenceFlyTicketActivity.this.f74741a0, 2, "onPostDownloadComplete :" + e16.toString());
                    }
                    str = null;
                }
                if (str != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        i3 = jSONObject.getInt("retcode");
                        if (QLog.isColorLevel()) {
                            QLog.d(ConferenceFlyTicketActivity.this.f74741a0, 2, "OnReportHrSelfNickNameTask.onPostDownloadComplete : retcode = " + i3);
                        }
                        if (jSONObject.has("result")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                            if (jSONObject2.has("result_code")) {
                                str2 = jSONObject2.getString("result_code");
                            }
                        }
                    } catch (JSONException unused) {
                        i3 = -2;
                        if (QLog.isColorLevel()) {
                            QLog.i(ConferenceFlyTicketActivity.this.f74741a0, 2, "onPostDownloadComplete : result_code = ,retcode = -2");
                        }
                    }
                    if (i3 != 0 && str2.equals("0")) {
                        ConferenceFlyTicketActivity.this.M2();
                        return;
                    } else {
                        ConferenceFlyTicketActivity.this.P2(1, 0);
                        ConferenceFlyTicketActivity.this.finish();
                    }
                }
            }
            i3 = 1;
            if (i3 != 0) {
            }
            ConferenceFlyTicketActivity.this.P2(1, 0);
            ConferenceFlyTicketActivity.this.finish();
        }
    }

    @TargetApi(9)
    private boolean G2() {
        com.tencent.av.utils.e.p("\u4e0a\u4f20SelfNickName");
        this.f74756p0 = new d();
        ArrayList arrayList = new ArrayList();
        com.tencent.av.utils.download.a aVar = new com.tencent.av.utils.download.a();
        String currentAccountUin = this.app.getCurrentAccountUin();
        aVar.f77096a = "https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/report_nickname_video_meeting_for_hr?discid=" + this.f74748h0 + "&uin=" + currentAccountUin + "&name=" + URLEncoder.encode(this.f74751k0);
        HashMap<String, String> hashMap = new HashMap<>();
        aVar.f77097b = hashMap;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("uin=o");
        sb5.append(currentAccountUin);
        hashMap.put("Cookie", sb5.toString());
        arrayList.add(aVar);
        this.f74756p0.execute(arrayList);
        return true;
    }

    static boolean L2(String str) {
        if (!str.startsWith("https:") && !str.startsWith("http:")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q2(String str, String str2, String str3, String str4) {
        String string;
        long K0 = com.tencent.mobileqq.service.message.e.K0();
        ArrayList arrayList = new ArrayList();
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_HR_INFO);
        if (QAVHrMeeting.m(this.f74749i0)) {
            string = this.app.getApp().getString(R.string.f170849au2);
        } else {
            string = this.app.getApp().getString(R.string.f170848au1);
        }
        d16.init(str2, str, str3, string, K0, MessageRecord.MSG_TYPE_HR_INFO, 3000, K0);
        d16.isread = true;
        d16.saveExtInfoToExtStr("troop_msg_nickname", str4);
        boolean z16 = d16 instanceof MessageForNewGrayTips;
        if (z16) {
            ((MessageForNewGrayTips) d16).updateMsgData();
        }
        boolean msgFilter = MessageHandlerUtils.msgFilter(this.app, d16, false);
        if (!msgFilter) {
            arrayList.add(d16);
        }
        QLog.w(this.f74741a0, 1, "showHRMeetingTip, friendUin[" + d16.frienduin + "], msgType[" + MessageRecord.MSG_TYPE_HR_INFO + "], friendType[3000], bMessageForNewGrayTips[" + z16 + "], msgFilter[" + msgFilter + "], msgContent[" + d16.getLogColorContent() + "]");
        if (arrayList.size() > 0) {
            this.app.getMessageFacade().h(arrayList, String.valueOf(str2));
        }
    }

    @TargetApi(9)
    void H2(String str) {
        this.f74757q0 = new c(str);
        ArrayList arrayList = new ArrayList();
        com.tencent.av.utils.download.a aVar = new com.tencent.av.utils.download.a();
        String currentAccountUin = this.app.getCurrentAccountUin();
        aVar.f77096a = "https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/get_namecard_by_discid?discid=" + this.f74748h0;
        HashMap<String, String> hashMap = new HashMap<>();
        aVar.f77097b = hashMap;
        hashMap.put("Cookie", "uin=o" + currentAccountUin);
        arrayList.add(aVar);
        this.f74757q0.execute(arrayList);
    }

    public void I2(String str, String str2, String str3, String str4, String str5) {
        AbsStructMsg g16;
        if (TextUtils.isEmpty(str) || (g16 = com.tencent.mobileqq.structmsg.i.g(str.getBytes(), 0)) == null) {
            return;
        }
        MessageForStructing messageForStructing = (MessageForStructing) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_STRUCT_MSG);
        messageForStructing.msgtype = MessageRecord.MSG_TYPE_STRUCT_MSG;
        messageForStructing.istroop = 3000;
        messageForStructing.issend = 0;
        messageForStructing.isread = true;
        messageForStructing.selfuin = this.app.getCurrentAccountUin();
        messageForStructing.senderuin = str4;
        messageForStructing.frienduin = str2;
        messageForStructing.mIsParsed = true;
        messageForStructing.structingMsg = g16;
        messageForStructing.msgData = g16.getBytes();
        messageForStructing.saveExtInfoToExtStr("troop_msg_nickname", str5);
        ArrayList arrayList = new ArrayList();
        if (!MessageHandlerUtils.msgFilter(this.app, messageForStructing, false)) {
            arrayList.add(messageForStructing);
        }
        if (arrayList.size() > 0) {
            this.app.getMessageFacade().h(arrayList, String.valueOf(str3));
        }
    }

    void J2(final String str) {
        com.tencent.av.utils.e.p("\u52a0\u5165\u8ba8\u8bba\u7ec4_delay_\u83b7\u53d6\u8ba8\u8bba\u7ec4\u7b7e\u540d");
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.av.ui.ConferenceFlyTicketActivity.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.w(ConferenceFlyTicketActivity.this.f74741a0, 1, "getRedirectInfo, url[" + str + "]");
                com.tencent.av.utils.e.p("\u52a0\u5165\u8ba8\u8bba\u7ec4_\u83b7\u53d6\u8ba8\u8bba\u7ec4\u7b7e\u540d");
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                BasicHttpContext basicHttpContext = new BasicHttpContext();
                String str2 = null;
                try {
                    try {
                        defaultHttpClient.execute(new HttpGet(str), basicHttpContext);
                        Object attribute = basicHttpContext.getAttribute("http.request");
                        if (attribute != null) {
                            HttpUriRequest httpUriRequest = (HttpUriRequest) attribute;
                            if (httpUriRequest.getURI() != null) {
                                str2 = httpUriRequest.getURI().toString();
                            }
                        }
                        QLog.w(ConferenceFlyTicketActivity.this.f74741a0, 1, "getRedirectInfo.run, redirectUrl[" + str2 + "]");
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(ConferenceFlyTicketActivity.this.f74741a0, 2, "getRedirectInfo.run e = " + e16);
                        }
                    }
                    defaultHttpClient.getConnectionManager().shutdown();
                    com.tencent.av.utils.e.p("\u52a0\u5165\u8ba8\u8bba\u7ec4_\u83b7\u53d6\u8ba8\u8bba\u7ec4\u7b7e\u540d_rsp");
                    com.tencent.av.utils.e.p(HardCodeUtil.qqStr(R.string.kym));
                    if (str2 != null && str2.startsWith("/cgi-bin/dc/ft?k=")) {
                        String substring = str2.substring(17);
                        QLog.w(ConferenceFlyTicketActivity.this.f74741a0, 1, "getRedirectInfo.run, sig[" + substring + "]");
                        ConferenceFlyTicketActivity.this.f74754n0.d4(substring, 0);
                        return;
                    }
                    if (str2 != null && str2.startsWith("https://qm.qq.com/cgi-bin/dc/ft?k=")) {
                        String substring2 = str2.substring(34);
                        QLog.w(ConferenceFlyTicketActivity.this.f74741a0, 1, "getRedirectInfo.run, sig[" + substring2 + "]");
                        ConferenceFlyTicketActivity.this.f74754n0.d4(substring2, 0);
                        return;
                    }
                    ConferenceFlyTicketActivity.this.P2(0, -161);
                    ConferenceFlyTicketActivity.this.finish();
                } catch (Throwable th5) {
                    defaultHttpClient.getConnectionManager().shutdown();
                    throw th5;
                }
            }
        }, 5, null, false);
    }

    void K2() {
        com.tencent.mobileqq.app.n nVar;
        DiscussionInfo h16;
        if (!this.f74759s0 && (h16 = (nVar = (com.tencent.mobileqq.app.n) this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(this.f74748h0)) != null) {
            int i3 = h16.mSelfRight;
            int i16 = this.f74749i0;
            if (i3 != i16) {
                h16.mSelfRight = i16;
                nVar.D(h16);
            }
            QLog.w(this.f74741a0, 1, "gotoAIO, DiscussionInfo_" + h16);
            if (!h16.isHidden()) {
                Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(BaseApplicationImpl.getApplication()), new int[]{2});
                m3.putExtra("uin", this.f74748h0);
                m3.putExtra("uintype", 3000);
                m3.putExtra("uinname", h16.discussionName);
                m3.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 8);
                BaseApplicationImpl.getApplication().startActivity(m3);
                this.f74759s0 = true;
            }
        }
    }

    @TargetApi(9)
    void M2() {
        com.tencent.av.utils.e.p(HardCodeUtil.qqStr(R.string.kyf));
        if (NetworkUtil.isNetSupport(this)) {
            if (!TextUtils.isEmpty(this.f74745e0)) {
                if (L2(this.f74745e0)) {
                    J2(this.f74745e0);
                    return;
                }
                J2("https://q.url.cn/s/" + this.f74745e0);
                return;
            }
            if (!TextUtils.isEmpty(this.f74744d0)) {
                if (L2(this.f74744d0)) {
                    J2(this.f74744d0);
                    return;
                }
                J2("https://url.cn/" + this.f74744d0);
                return;
            }
            finish();
            P2(0, -162);
            return;
        }
        finish();
        P2(0, -160);
    }

    void N2() {
        Intent intent = super.getIntent();
        this.f74742b0 = intent.getStringExtra("confid");
        this.f74743c0 = intent.getStringExtra("subject");
        this.f74744d0 = intent.getStringExtra("ticket");
        this.f74745e0 = intent.getStringExtra("ticket_f");
        String stringExtra = intent.getStringExtra("stask");
        if (stringExtra != null) {
            this.f74749i0 = Integer.valueOf(stringExtra).intValue();
        } else {
            this.f74749i0 = 0;
        }
        this.f74746f0 = intent.getStringExtra("confidshort");
        this.f74747g0 = intent.getStringExtra("callphonenum");
        this.f74748h0 = intent.getStringExtra("discid");
        this.f74751k0 = intent.getStringExtra(QCircleAlphaUserReporter.KEY_USER);
        this.f74750j0 = intent.getStringExtra("businesstype");
        if (QLog.isColorLevel()) {
            QLog.w(this.f74741a0, 1, "processExtraData, mConfid[" + this.f74742b0 + "], mSubject[" + this.f74743c0 + "], mTicket[" + this.f74744d0 + "], mTicketFull[" + this.f74745e0 + "], mConfIDShort[" + this.f74746f0 + "], mCallbackPhone[" + this.f74747g0 + "], mDiscID[" + this.f74748h0 + "], mStasks[" + this.f74749i0 + "], mHrMeetingNickName[" + this.f74751k0 + "], mBusinessType[" + this.f74750j0 + "]");
        }
    }

    void P2(int i3, int i16) {
        final String qqStr;
        QLog.w(this.f74741a0, 1, "showFailMessage, type[" + i3 + "], errorCode[" + i16 + "]");
        if (i16 != -162) {
            if (i16 != -160) {
                if (i16 != 1) {
                    if (i16 != 4) {
                        if (i16 != 7) {
                            if (i16 != 8) {
                                if (i3 == 1) {
                                    qqStr = HardCodeUtil.qqStr(R.string.kyp);
                                } else if (i3 == 0) {
                                    qqStr = HardCodeUtil.qqStr(R.string.kyi);
                                } else {
                                    qqStr = "";
                                }
                            } else {
                                qqStr = HardCodeUtil.qqStr(R.string.kyo);
                            }
                        } else {
                            qqStr = HardCodeUtil.qqStr(R.string.kyl);
                        }
                    } else {
                        qqStr = HardCodeUtil.qqStr(R.string.kyg);
                    }
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.kye);
                }
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.kyn);
            }
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.kyj);
        }
        this.f74758r0.post(new Runnable() { // from class: com.tencent.av.ui.ConferenceFlyTicketActivity.1
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(ConferenceFlyTicketActivity.this, qqStr, 0).show(ConferenceFlyTicketActivity.this.getTitleBarHeight());
                ConferenceFlyTicketActivity.this.finish();
            }
        });
    }

    void R2(String str, String str2) {
        if (this.f74752l0) {
            return;
        }
        boolean V = AVNotifyCenter.V();
        QLog.w(this.f74741a0, 1, "startGAudioOnCreateDiscussion, discID[" + str + "], discussName[" + str2 + "], isBeInvitingOnDoubleVideo[" + V + "]");
        if (V) {
            QQToast.makeText(getApplicationContext(), R.string.dkm, 1).show(getApplicationContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        this.f74752l0 = true;
        Bundle bundle = new Bundle();
        bundle.putInt("MultiAVType", 1);
        bundle.putBoolean("disableInvite", true);
        if (this.f74750j0.equals("video_hr") || (this.f74749i0 & 4) != 0) {
            bundle.putBoolean(BaseProfileQZoneComponent.KEY_IS_VIDEO, true);
            bundle.putInt("MeetingStasks", this.f74749i0);
            QLog.w(this.f74741a0, 1, "ShowNameCard, mBusinessType[" + this.f74750j0 + "], mStasks[" + this.f74749i0 + "]");
            H2(str);
        }
        com.tencent.av.utils.e.p(HardCodeUtil.qqStr(R.string.kyh));
        QQAppInterface qQAppInterface = this.app;
        ChatActivityUtils.f0(qQAppInterface, qQAppInterface.getApp(), 3000, str, true, true, null, bundle);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        com.tencent.av.utils.e.p("ConferenceFlyTicketActivity.doOnCreate.begin");
        boolean doOnCreate = super.doOnCreate(bundle);
        N2();
        this.f74754n0 = (DiscussionHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        a aVar = new a();
        this.f74753m0 = aVar;
        addObserver(aVar);
        if (this.f74750j0.equals("video_hr")) {
            if (!G2()) {
                return false;
            }
        } else {
            M2();
        }
        this.f74758r0 = new Handler();
        com.tencent.av.utils.e.p("ConferenceFlyTicketActivity.doOnCreate.end");
        return doOnCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        removeObserver(this.f74753m0);
        this.f74758r0 = null;
        super.doOnDestroy();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }
}
