package com.tencent.av.business.handler;

import android.text.TextUtils;
import com.tencent.av.business.servlet.f;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import trpc.qq_av.av_appsvr.QavAppSvr$PopupsReject;
import trpc.qq_av.av_appsvr.QavAppSvr$PopupsWarning;
import trpc.qq_av.av_appsvr.QavAppSvr$SafeCheckReq;
import trpc.qq_av.av_appsvr.QavAppSvr$SafeCheckRsp;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SafetyHandler extends BusinessHandler {

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f73273e = {"trpc.qqrtc.av_appsvr.SafeCheck.SsoSafeCheck"};

    /* renamed from: d, reason: collision with root package name */
    private final f f73274d;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f73275a = null;

        /* renamed from: b, reason: collision with root package name */
        public String f73276b = null;

        public a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public String f73278a = null;

        /* renamed from: b, reason: collision with root package name */
        public String f73279b = null;

        /* renamed from: c, reason: collision with root package name */
        public String f73280c = null;

        /* renamed from: d, reason: collision with root package name */
        public String f73281d = null;

        /* renamed from: e, reason: collision with root package name */
        public String f73282e = null;

        /* renamed from: f, reason: collision with root package name */
        public String f73283f = null;

        /* renamed from: g, reason: collision with root package name */
        public int f73284g = 0;

        public b() {
        }
    }

    protected SafetyHandler(AppInterface appInterface) {
        super(appInterface);
        this.f73274d = new f(appInterface);
    }

    public f D2() {
        return this.f73274d;
    }

    public void E2(String str, String str2, boolean z16) {
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.i("SafetyHandler", 2, "getSafetyTips: uin is " + str + " peerUin is " + str2);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(str));
            arrayList.add(Long.valueOf(str2));
            QavAppSvr$SafeCheckReq qavAppSvr$SafeCheckReq = new QavAppSvr$SafeCheckReq();
            qavAppSvr$SafeCheckReq.uin_list.addAll(arrayList);
            qavAppSvr$SafeCheckReq.auth_mode.set(3);
            PBEnumField pBEnumField = qavAppSvr$SafeCheckReq.action;
            if (!z16) {
                i3 = 1;
            }
            pBEnumField.set(i3);
            ToServiceMsg createToServiceMsg = createToServiceMsg("trpc.qqrtc.av_appsvr.SafeCheck.SsoSafeCheck");
            createToServiceMsg.putWupBuffer(qavAppSvr$SafeCheckReq.toByteArray());
            this.f73274d.d(createToServiceMsg);
            return;
        }
        QLog.i("SafetyHandler", 2, "getSafetyTips invalid uin");
    }

    public void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (fromServiceMsg.getResultCode() != 1000) {
            QLog.i("SafetyHandler", 2, "handleSafetyCheck res.resultCode = " + fromServiceMsg.getResultCode());
            return;
        }
        QavAppSvr$SafeCheckRsp qavAppSvr$SafeCheckRsp = new QavAppSvr$SafeCheckRsp();
        try {
            qavAppSvr$SafeCheckRsp.mergeFrom((byte[]) obj);
            if (!qavAppSvr$SafeCheckRsp.alert_type.has()) {
                QLog.i("SafetyHandler", 2, "handleSafetyCheck, alert_type empty!");
                return;
            }
            int i3 = qavAppSvr$SafeCheckRsp.alert_type.get();
            String str7 = "";
            if (i3 == 2) {
                if (qavAppSvr$SafeCheckRsp.hover_tips_text.has()) {
                    str7 = qavAppSvr$SafeCheckRsp.hover_tips_text.get();
                }
                notifyUI(1, !TextUtils.isEmpty(str7), str7);
                QLog.d("SafetyHandler", 1, "handleSafetyCheck:ALERT_TYPE_HOVER_TIPS: " + str7);
                return;
            }
            int i16 = 0;
            if (i3 == 3) {
                if (qavAppSvr$SafeCheckRsp.popups_waring.has()) {
                    QavAppSvr$PopupsWarning qavAppSvr$PopupsWarning = qavAppSvr$SafeCheckRsp.popups_waring.get();
                    b bVar = new b();
                    if (!qavAppSvr$PopupsWarning.title.has()) {
                        str2 = "";
                    } else {
                        str2 = qavAppSvr$PopupsWarning.title.get();
                    }
                    bVar.f73278a = str2;
                    if (!qavAppSvr$PopupsWarning.text.has()) {
                        str3 = "";
                    } else {
                        str3 = qavAppSvr$PopupsWarning.text.get();
                    }
                    bVar.f73279b = str3;
                    if (!qavAppSvr$PopupsWarning.highlight.has()) {
                        str4 = "";
                    } else {
                        str4 = qavAppSvr$PopupsWarning.highlight.get();
                    }
                    bVar.f73280c = str4;
                    if (!qavAppSvr$PopupsWarning.url.has()) {
                        str5 = "";
                    } else {
                        str5 = qavAppSvr$PopupsWarning.url.get();
                    }
                    bVar.f73281d = str5;
                    if (!qavAppSvr$PopupsWarning.cancel_button.has()) {
                        str6 = "";
                    } else {
                        str6 = qavAppSvr$PopupsWarning.cancel_button.get();
                    }
                    bVar.f73282e = str6;
                    if (qavAppSvr$PopupsWarning.continue_button.has()) {
                        str7 = qavAppSvr$PopupsWarning.continue_button.get();
                    }
                    bVar.f73283f = str7;
                    if (qavAppSvr$PopupsWarning.stay_sec.has()) {
                        i16 = qavAppSvr$PopupsWarning.stay_sec.get();
                    }
                    bVar.f73284g = i16;
                    notifyUI(2, true, bVar);
                    QLog.d("SafetyHandler", 1, "handleSafetyCheck:ALERT_TYPE_POPUPS_WARNING: mContent: " + bVar.f73279b + " mStayTimeInterval: " + bVar.f73284g);
                    return;
                }
                notifyUI(2, false, null);
                QLog.i("SafetyHandler", 2, "handleSafetyCheck:ALERT_TYPE_POPUPS_WARNING: popupsWarning null");
                return;
            }
            if (i3 == 4) {
                if (qavAppSvr$SafeCheckRsp.popups_reject.has()) {
                    QavAppSvr$PopupsReject qavAppSvr$PopupsReject = qavAppSvr$SafeCheckRsp.popups_reject.get();
                    a aVar = new a();
                    if (!qavAppSvr$PopupsReject.text.has()) {
                        str = "";
                    } else {
                        str = qavAppSvr$PopupsReject.text.get();
                    }
                    aVar.f73275a = str;
                    if (qavAppSvr$PopupsReject.confirm_button.has()) {
                        str7 = qavAppSvr$PopupsReject.confirm_button.get();
                    }
                    aVar.f73276b = str7;
                    notifyUI(3, true, aVar);
                    QLog.d("SafetyHandler", 1, "handleSafetyCheck:ALERT_TYPE_POPUPS_REJECT: mContent\uff1a" + aVar.f73275a);
                    return;
                }
                notifyUI(3, false, null);
                QLog.i("SafetyHandler", 2, "handleSafetyCheck:ALERT_TYPE_POPUPS_REJECT: popupsReject null");
                return;
            }
            if (i3 == 1) {
                notifyUI(4, true, null);
                QLog.d("SafetyHandler", 1, "handleSafetyCheck:ALERT_TYPE_ALLOW");
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("SafetyHandler", 2, "handleSafetyCheck, error ", e16);
        }
    }

    public void G2(String str, int i3, String str2, boolean z16) {
        QLog.i("SafetyHandler", 2, "sendScreenShareSafeCheck: uin is " + str + " relationType is " + i3 + " relationId is " + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            QavAppSvr$SafeCheckReq qavAppSvr$SafeCheckReq = new QavAppSvr$SafeCheckReq();
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(str));
            if (i3 == 3) {
                arrayList.add(Long.valueOf(str2));
                qavAppSvr$SafeCheckReq.auth_mode.set(3);
            } else if (i3 == 1) {
                qavAppSvr$SafeCheckReq.auth_mode.set(1);
                qavAppSvr$SafeCheckReq.group_num.set(Long.valueOf(str2).longValue());
            }
            qavAppSvr$SafeCheckReq.uin_list.addAll(arrayList);
            qavAppSvr$SafeCheckReq.action.set(3);
            qavAppSvr$SafeCheckReq.need_first_warning.set(z16);
            ToServiceMsg createToServiceMsg = createToServiceMsg("trpc.qqrtc.av_appsvr.SafeCheck.SsoSafeCheck");
            createToServiceMsg.putWupBuffer(qavAppSvr$SafeCheckReq.toByteArray());
            this.f73274d.d(createToServiceMsg);
            return;
        }
        QLog.i("SafetyHandler", 2, "sendScreenShareSafeCheck invalid param");
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.addAll(Arrays.asList(f73273e));
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return lu.b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.i("SafetyHandler", 2, "onReceive, cmd[" + serviceCmd + "]");
        }
        if ("trpc.qqrtc.av_appsvr.SafeCheck.SsoSafeCheck".equals(serviceCmd)) {
            F2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
