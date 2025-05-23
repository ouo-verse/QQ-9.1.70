package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.an;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class AbsStructMsgElement implements View.OnClickListener, g {
    static IPatchRedirector $redirector_;
    public int A0;
    public String B0;
    public String C;
    public String C0;
    public String D;
    public String D0;
    public String E;
    public String E0;
    public String F;
    public String F0;
    public String G;
    public String G0;
    public String H;
    public String H0;
    public String I;
    public int I0;
    public String J;
    public String J0;
    public String K;
    public String K0;
    public String L;
    public long L0;
    public String M;
    public String M0;
    public String N;
    public int N0;
    public WeakReference<an> O0;
    public String P;
    public AbsStructMsg P0;
    public int Q;
    long Q0;
    public String R;
    public String S;
    public String T;
    public String U;
    public String V;
    public int W;
    public String X;
    public String Y;
    public String Z;

    /* renamed from: a0, reason: collision with root package name */
    public String f290317a0;

    /* renamed from: b0, reason: collision with root package name */
    public String f290318b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f290319c0;

    /* renamed from: d, reason: collision with root package name */
    public int f290320d;

    /* renamed from: d0, reason: collision with root package name */
    public String f290321d0;

    /* renamed from: e, reason: collision with root package name */
    public String f290322e;

    /* renamed from: e0, reason: collision with root package name */
    public String f290323e0;

    /* renamed from: f, reason: collision with root package name */
    int f290324f;

    /* renamed from: f0, reason: collision with root package name */
    public String f290325f0;

    /* renamed from: g0, reason: collision with root package name */
    public String f290326g0;

    /* renamed from: h, reason: collision with root package name */
    public String f290327h;

    /* renamed from: h0, reason: collision with root package name */
    public String f290328h0;

    /* renamed from: i, reason: collision with root package name */
    public String f290329i;

    /* renamed from: i0, reason: collision with root package name */
    public String f290330i0;

    /* renamed from: j0, reason: collision with root package name */
    public String f290331j0;

    /* renamed from: k0, reason: collision with root package name */
    public String f290332k0;

    /* renamed from: l0, reason: collision with root package name */
    public String f290333l0;

    /* renamed from: m, reason: collision with root package name */
    public String f290334m;

    /* renamed from: m0, reason: collision with root package name */
    public int f290335m0;

    /* renamed from: n0, reason: collision with root package name */
    public String f290336n0;

    /* renamed from: o0, reason: collision with root package name */
    public String f290337o0;

    /* renamed from: p0, reason: collision with root package name */
    public String f290338p0;

    /* renamed from: q0, reason: collision with root package name */
    public String f290339q0;

    /* renamed from: r0, reason: collision with root package name */
    public String f290340r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f290341s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f290342t0;

    /* renamed from: u0, reason: collision with root package name */
    public String f290343u0;

    /* renamed from: v0, reason: collision with root package name */
    public String f290344v0;

    /* renamed from: w0, reason: collision with root package name */
    public String f290345w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f290346x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f290347y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f290348z0;

    public AbsStructMsgElement() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f290320d = 18;
        this.f290329i = null;
        this.f290334m = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.J0 = "";
        this.K0 = null;
        this.L0 = 0L;
        this.N0 = -1;
        this.O0 = null;
        this.P0 = null;
        this.Q0 = -1L;
    }

    public static String e(String str) {
        if (str == null) {
            return "";
        }
        if (!URLUtil.isValidUrl(str)) {
            str = "https://" + str;
        }
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException unused) {
            return "";
        }
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        int i16 = this.f290324f;
        if ((i16 & i3) == 0) {
            this.f290324f = i3 | i16;
        }
    }

    public void b(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        }
    }

    public abstract View c(Context context, View view, Bundle bundle);

    public abstract boolean d(j jVar);

    public abstract String f();

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f290324f;
    }

    public boolean h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        if ((this.f290324f & i3) == i3) {
            return true;
        }
        return false;
    }

    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) objectInput);
        } else {
            this.f290320d = objectInput.readInt();
        }
    }

    public void j(AbsShareMsg absShareMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) absShareMsg);
        }
    }

    public abstract void k(XmlSerializer xmlSerializer) throws IOException;

    public void l(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) objectOutput);
        } else {
            objectOutput.writeUTF(this.f290322e);
            objectOutput.writeInt(this.f290320d);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ea A[Catch: Exception -> 0x027a, TryCatch #3 {Exception -> 0x027a, blocks: (B:62:0x01e4, B:64:0x01ea, B:66:0x01f8, B:68:0x0214), top: B:61:0x01e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0329  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        long j3;
        String str;
        ChatMessage chatMessage;
        Object obj;
        String str2;
        String str3;
        AbsStructMsg absStructMsg;
        int i3;
        int i16;
        EcShopAssistantManager ecShopAssistantManager;
        EcshopReportHandler ecshopReportHandler;
        String extInfoFromExtStr;
        String extInfoFromExtStr2;
        JSONObject jSONObject;
        IPAReportUtil iPAReportUtil;
        String str4;
        String jSONObject2;
        StringBuilder sb5;
        AbsStructMsg absStructMsg2;
        int parseInt;
        AbsStructMsg absStructMsg3;
        String str5;
        MessageRecord messageRecord;
        JSONObject jSONObject3;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else if (SystemClock.uptimeMillis() - this.Q0 >= 1000) {
            this.Q0 = SystemClock.uptimeMillis();
            Object tag = view.getTag();
            if (getClass().isInstance(tag)) {
                AbsStructMsgElement absStructMsgElement = (AbsStructMsgElement) tag;
                Context context = view.getContext();
                if (SplashActivity.class.isInstance(context) || ChatActivity.class.isInstance(context)) {
                    BaseActivity baseActivity = (BaseActivity) context;
                    if (baseActivity.getChatFragment() != null) {
                        QQAppInterface ph5 = baseActivity.getChatFragment().ph();
                        if (absStructMsgElement.L0 > 0 && !TextUtils.isEmpty(absStructMsgElement.K0)) {
                            j3 = 0;
                            ReportController.o(ph5, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, absStructMsgElement.M0, "mp_msg_msgpic_click", "aio_morpic_click", Integer.parseInt(this.K0), 0, "", "", Long.toString(absStructMsgElement.L0), "");
                        } else {
                            j3 = 0;
                        }
                        ((IReadInJoySPEventReport) QRoute.api(IReadInJoySPEventReport.class)).reportPubAioItemClick(absStructMsgElement.M0, absStructMsgElement);
                        if (!(baseActivity.getChatFragment().qh() instanceof com.tencent.mobileqq.activity.aio.rebuild.c)) {
                            str = "";
                        } else {
                            if (!TextUtils.isEmpty(absStructMsgElement.K0)) {
                                try {
                                    parseInt = Integer.parseInt(this.K0);
                                } catch (NumberFormatException unused) {
                                }
                                absStructMsg3 = absStructMsgElement.P0;
                                if (absStructMsg3 != null || (messageRecord = absStructMsg3.message) == null || (jSONObject3 = messageRecord.mExJsonObject) == null) {
                                    str5 = "";
                                } else {
                                    str5 = jSONObject3.optString(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND);
                                }
                                str = "";
                                String str6 = str5;
                                PublicAccountEventReport.m(ph5, absStructMsgElement.M0, 0, 4, absStructMsgElement.L0 + parseInt, str6);
                                xx.b.INSTANCE.A(absStructMsgElement, str6);
                            }
                            parseInt = -1;
                            absStructMsg3 = absStructMsgElement.P0;
                            if (absStructMsg3 != null) {
                            }
                            str5 = "";
                            str = "";
                            String str62 = str5;
                            PublicAccountEventReport.m(ph5, absStructMsgElement.M0, 0, 4, absStructMsgElement.L0 + parseInt, str62);
                            xx.b.INSTANCE.A(absStructMsgElement, str62);
                        }
                        if (absStructMsgElement.L0 > j3) {
                            ThreadManager.getSubThreadHandler().postDelayed(new Runnable(absStructMsgElement, ph5) { // from class: com.tencent.mobileqq.structmsg.AbsStructMsgElement.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ AbsStructMsgElement f290349d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ QQAppInterface f290350e;

                                {
                                    this.f290349d = absStructMsgElement;
                                    this.f290350e = ph5;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, this, AbsStructMsgElement.this, absStructMsgElement, ph5);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    int parseInt2;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    long serverTime = NetConnInfoCenter.getServerTime();
                                    if (!TextUtils.isEmpty(this.f290349d.K0)) {
                                        try {
                                            parseInt2 = Integer.parseInt(AbsStructMsgElement.this.K0);
                                        } catch (NumberFormatException unused2) {
                                        }
                                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.f290350e, "CliOper", "", this.f290349d.M0, "0X80055C7", "0X80055C7", parseInt2, 0, Long.toString(serverTime), Long.toString(this.f290349d.L0), this.f290349d.f290329i, Integer.toString(com.tencent.mobileqq.activity.aio.rebuild.c.y(this.f290349d.M0, this.f290350e) ? 1 : 0), false);
                                    }
                                    parseInt2 = -1;
                                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.f290350e, "CliOper", "", this.f290349d.M0, "0X80055C7", "0X80055C7", parseInt2, 0, Long.toString(serverTime), Long.toString(this.f290349d.L0), this.f290349d.f290329i, Integer.toString(com.tencent.mobileqq.activity.aio.rebuild.c.y(this.f290349d.M0, this.f290350e) ? 1 : 0), false);
                                }
                            }, j3);
                        }
                        try {
                            chatMessage = l.C(view);
                        } catch (ClassCastException unused2) {
                            chatMessage = null;
                        }
                        ChatMessage chatMessage2 = chatMessage;
                        if (chatMessage2 == null || absStructMsgElement.P0 == null || !"1".equals(chatMessage2.getExtInfoFromExtStr("is_AdArrive_Msg"))) {
                            obj = "1";
                            str2 = str;
                            str3 = IPublicAccountBrowser.KEY_PUB_UIN;
                        } else {
                            try {
                                jSONObject = new JSONObject();
                                jSONObject.put(IPublicAccountBrowser.KEY_PUB_UIN, chatMessage2.frienduin);
                                jSONObject.put("type", absStructMsgElement.J);
                                jSONObject.put("index", absStructMsgElement.H);
                                jSONObject.put("name", absStructMsgElement.I);
                                jSONObject.put("net", String.valueOf(HttpUtil.getNetWorkType()));
                                jSONObject.put("mobile_imei", ah.z());
                                str2 = str;
                            } catch (JSONException e16) {
                                e = e16;
                                obj = "1";
                                str2 = str;
                            }
                            try {
                                jSONObject.put("obj", str2);
                                jSONObject.put("gdt_cli_data", chatMessage2.getExtInfoFromExtStr("gdt_msgClick"));
                                jSONObject.put("view_id", chatMessage2.getExtInfoFromExtStr("gdt_view_id"));
                                iPAReportUtil = (IPAReportUtil) QRoute.api(IPAReportUtil.class);
                                str4 = chatMessage2.selfuin;
                                jSONObject2 = jSONObject.toString();
                                sb5 = new StringBuilder();
                                sb5.append(str2);
                                absStructMsg2 = absStructMsgElement.P0;
                                obj = "1";
                                str3 = IPublicAccountBrowser.KEY_PUB_UIN;
                            } catch (JSONException e17) {
                                e = e17;
                                obj = "1";
                                str3 = IPublicAccountBrowser.KEY_PUB_UIN;
                                e.printStackTrace();
                                absStructMsg = absStructMsgElement.P0;
                                if (absStructMsg != null) {
                                }
                                i3 = Integer.parseInt(absStructMsgElement.K0);
                                int i17 = i3;
                                Object obj2 = obj;
                                String str7 = str3;
                                ReportController.o(ph5, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, absStructMsgElement.M0, "0X80055C7", "0X80055C7", i17, 0, str2 + absStructMsgElement.L0, absStructMsgElement.J0, "", absStructMsgElement.f290327h);
                                ReportController.o(ph5, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, absStructMsgElement.M0, "0X8005D49", "0X8005D49", i17, 0, "MSGID=" + Long.toString(absStructMsgElement.L0) + ";TEPLATEID=" + absStructMsgElement.J0 + ";ARTICALID=" + str2 + ";REFERRER=" + e(absStructMsgElement.f290327h), "", "", "");
                                if (chatMessage2 != null) {
                                }
                                EventCollector.getInstance().onViewClicked(view);
                            }
                            try {
                                sb5.append(absStructMsg2.msgId);
                                iPAReportUtil.reportClickEventForAdver(ph5, str4, jSONObject2, sb5.toString());
                            } catch (JSONException e18) {
                                e = e18;
                                e.printStackTrace();
                                absStructMsg = absStructMsgElement.P0;
                                if (absStructMsg != null) {
                                    try {
                                        if (absStructMsg.mMsgServiceID == 92) {
                                        }
                                    } catch (Exception unused3) {
                                    }
                                }
                                i3 = Integer.parseInt(absStructMsgElement.K0);
                                int i172 = i3;
                                Object obj22 = obj;
                                String str72 = str3;
                                ReportController.o(ph5, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, absStructMsgElement.M0, "0X80055C7", "0X80055C7", i172, 0, str2 + absStructMsgElement.L0, absStructMsgElement.J0, "", absStructMsgElement.f290327h);
                                ReportController.o(ph5, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, absStructMsgElement.M0, "0X8005D49", "0X8005D49", i172, 0, "MSGID=" + Long.toString(absStructMsgElement.L0) + ";TEPLATEID=" + absStructMsgElement.J0 + ";ARTICALID=" + str2 + ";REFERRER=" + e(absStructMsgElement.f290327h), "", "", "");
                                if (chatMessage2 != null) {
                                }
                                EventCollector.getInstance().onViewClicked(view);
                            }
                        }
                        absStructMsg = absStructMsgElement.P0;
                        if (absStructMsg != null && absStructMsg.message != null) {
                            if (absStructMsg.mMsgServiceID == 92) {
                                int parseInt2 = Integer.parseInt(absStructMsg.mQidianBulkTaskId);
                                String str8 = absStructMsgElement.f290327h;
                                if (QLog.isColorLevel()) {
                                    QLog.d("StructMsg", 2, String.format("click qidian bulk message, taskId: %d, actionUrl: %s", Integer.valueOf(parseInt2), str8));
                                }
                                if (parseInt2 != 0) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("action", "click");
                                    jSONObject4.put("fromUin", absStructMsgElement.P0.message.frienduin);
                                    jSONObject4.put("toUin", ph5.getCurrentAccountUin());
                                    jSONObject4.put(com.heytap.mcssdk.a.a.f36094d, absStructMsgElement.P0.mQidianBulkTaskId);
                                    jSONObject4.put("clickURL", str8);
                                    jSONObject4.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                                    ((QidianHandler) ph5.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).q3(jSONObject4.toString(), absStructMsgElement.P0.message.frienduin, "", 10009, 0);
                                }
                            }
                        }
                        try {
                            i3 = Integer.parseInt(absStructMsgElement.K0);
                        } catch (Exception unused4) {
                            i3 = -1;
                        }
                        int i1722 = i3;
                        Object obj222 = obj;
                        String str722 = str3;
                        ReportController.o(ph5, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, absStructMsgElement.M0, "0X80055C7", "0X80055C7", i1722, 0, str2 + absStructMsgElement.L0, absStructMsgElement.J0, "", absStructMsgElement.f290327h);
                        ReportController.o(ph5, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, absStructMsgElement.M0, "0X8005D49", "0X8005D49", i1722, 0, "MSGID=" + Long.toString(absStructMsgElement.L0) + ";TEPLATEID=" + absStructMsgElement.J0 + ";ARTICALID=" + str2 + ";REFERRER=" + e(absStructMsgElement.f290327h), "", "", "");
                        if (chatMessage2 != null) {
                            String extInfoFromExtStr3 = chatMessage2.getExtInfoFromExtStr("gdt_msgClick");
                            if (!TextUtils.isEmpty(extInfoFromExtStr3)) {
                                JSONObject jSONObject5 = new JSONObject();
                                try {
                                    if (!TextUtils.isEmpty(absStructMsgElement.M0)) {
                                        jSONObject5.put(str722, absStructMsgElement.M0);
                                    } else {
                                        jSONObject5.put(str722, chatMessage2.frienduin);
                                    }
                                    i16 = i1722;
                                } catch (JSONException e19) {
                                    e = e19;
                                    i16 = i1722;
                                }
                                try {
                                    jSONObject5.put("index", Long.toString(i16));
                                    jSONObject5.put("gdt_cli_data", extInfoFromExtStr3);
                                } catch (JSONException e26) {
                                    e = e26;
                                    e.printStackTrace();
                                    new ArrayList().add(String.valueOf(absStructMsgElement.L0));
                                    extInfoFromExtStr = chatMessage2.getExtInfoFromExtStr("gdt_singleAd");
                                    String extInfoFromExtStr4 = chatMessage2.getExtInfoFromExtStr("gdt_mulAd");
                                    extInfoFromExtStr2 = chatMessage2.getExtInfoFromExtStr("gdt_followAd");
                                    if (!extInfoFromExtStr.equals(obj222)) {
                                        extInfoFromExtStr2.equals(obj222);
                                    }
                                    ecShopAssistantManager = (EcShopAssistantManager) ph5.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
                                    ecshopReportHandler = (EcshopReportHandler) ph5.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
                                    if (ecShopAssistantManager != null) {
                                        ecshopReportHandler.G2(false, chatMessage2, i16, absStructMsgElement.f290327h);
                                    }
                                    EventCollector.getInstance().onViewClicked(view);
                                }
                                new ArrayList().add(String.valueOf(absStructMsgElement.L0));
                                extInfoFromExtStr = chatMessage2.getExtInfoFromExtStr("gdt_singleAd");
                                String extInfoFromExtStr42 = chatMessage2.getExtInfoFromExtStr("gdt_mulAd");
                                extInfoFromExtStr2 = chatMessage2.getExtInfoFromExtStr("gdt_followAd");
                                if (!extInfoFromExtStr.equals(obj222) && !extInfoFromExtStr42.equals(obj222)) {
                                    extInfoFromExtStr2.equals(obj222);
                                }
                            } else {
                                i16 = i1722;
                            }
                            ecShopAssistantManager = (EcShopAssistantManager) ph5.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
                            ecshopReportHandler = (EcshopReportHandler) ph5.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
                            if (ecShopAssistantManager != null && ecshopReportHandler != null && ecShopAssistantManager.o(chatMessage2.senderuin)) {
                                ecshopReportHandler.G2(false, chatMessage2, i16, absStructMsgElement.f290327h);
                            }
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
