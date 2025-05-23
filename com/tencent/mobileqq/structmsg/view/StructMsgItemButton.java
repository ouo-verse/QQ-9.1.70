package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IPublicQuickPayService;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StructMsgItemButton extends com.tencent.mobileqq.structmsg.b {
    static IPatchRedirector $redirector_;

    /* renamed from: g1, reason: collision with root package name */
    public String f290433g1;

    /* renamed from: h1, reason: collision with root package name */
    public String f290434h1;

    /* renamed from: i1, reason: collision with root package name */
    public String f290435i1;

    /* renamed from: j1, reason: collision with root package name */
    public String f290436j1;

    /* renamed from: k1, reason: collision with root package name */
    public int f290437k1;

    /* renamed from: l1, reason: collision with root package name */
    long f290438l1;

    /* renamed from: m1, reason: collision with root package name */
    View.OnClickListener f290439m1;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StructMsgItemButton.this);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            com.tencent.mobileqq.activity.aio.an anVar;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                WeakReference<com.tencent.mobileqq.activity.aio.an> weakReference = StructMsgItemButton.this.O0;
                if (weakReference != null && (anVar = weakReference.get()) != null) {
                    z16 = anVar.onLongClick(view);
                } else {
                    z16 = false;
                }
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StructMsgItemButton.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.tencent.mobileqq.activity.aio.an anVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            WeakReference<com.tencent.mobileqq.activity.aio.an> weakReference = StructMsgItemButton.this.O0;
            if (weakReference != null && (anVar = weakReference.get()) != null) {
                return anVar.onTouch(view, motionEvent);
            }
            return false;
        }
    }

    public StructMsgItemButton() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f290433g1 = null;
        this.f290434h1 = null;
        this.f290435i1 = null;
        this.f290436j1 = null;
        this.f290437k1 = 999;
        this.f290438l1 = -1L;
        this.f290439m1 = new View.OnClickListener() { // from class: com.tencent.mobileqq.structmsg.view.StructMsgItemButton.3
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.structmsg.view.StructMsgItemButton$3$a */
            /* loaded from: classes18.dex */
            class a implements IPublicQuickPayService.a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ StructMsgForGeneralShare f290446a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ Context f290447b;

                a(StructMsgForGeneralShare structMsgForGeneralShare, Context context) {
                    this.f290446a = structMsgForGeneralShare;
                    this.f290447b = context;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AnonymousClass3.this, structMsgForGeneralShare, context);
                    }
                }

                @Override // com.tencent.mobileqq.qwallet.IPublicQuickPayService.a
                public void a(Bundle bundle) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                        return;
                    }
                    int i3 = bundle.getInt("retCode");
                    String string = bundle.getString("retMsg");
                    int i16 = bundle.getInt("payTime");
                    String string2 = bundle.getString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID);
                    StructMsgItemButton.this.Q(i3);
                    this.f290446a.savePayInfo(this.f290447b, StructMsgItemButton.this.f290434h1, i3);
                    VACDReportUtil.a(APMidasPayAPI.PAY_CHANNEL_QQWALLET, "publicpaymsg.pay.result", null, "ret_code=" + i3 + "|ret_str=" + string + "|pay_time=" + i16 + "|order_id=" + string2, 0, null);
                }
            }

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StructMsgItemButton.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag;
                QQAppInterface qQAppInterface;
                String str;
                String str2;
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    StructMsgItemButton structMsgItemButton = StructMsgItemButton.this;
                    if (uptimeMillis - structMsgItemButton.f290438l1 >= 1000) {
                        structMsgItemButton.f290438l1 = SystemClock.uptimeMillis();
                        Object tag2 = view.getTag();
                        if (tag2 != null && StructMsgItemButton.class.isInstance(tag2) && (tag = ((ViewGroup) view.getParent().getParent()).getTag(R.id.j59)) != null && StructMsgForGeneralShare.class.isInstance(tag)) {
                            StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) tag;
                            StructMsgItemButton structMsgItemButton2 = (StructMsgItemButton) tag2;
                            Context context = view.getContext();
                            if (context instanceof BaseActivity) {
                                ChatFragment chatFragment = ((BaseActivity) context).getChatFragment();
                                if (chatFragment != null) {
                                    qQAppInterface = chatFragment.ph();
                                } else {
                                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                                    if (runtime instanceof QQAppInterface) {
                                        qQAppInterface = (QQAppInterface) runtime;
                                    } else {
                                        qQAppInterface = null;
                                    }
                                }
                                if (qQAppInterface != null) {
                                    MessageRecord messageRecord = structMsgForGeneralShare.message;
                                    if (messageRecord != null) {
                                        str = messageRecord.getExtInfoFromExtStr("is_AdArrive_Msg");
                                    } else {
                                        str = "0";
                                    }
                                    if ("1".equals(str) && structMsgForGeneralShare.message != null) {
                                        try {
                                            JSONObject jSONObject = new JSONObject();
                                            jSONObject.put(IPublicAccountBrowser.KEY_PUB_UIN, structMsgForGeneralShare.message.frienduin);
                                            jSONObject.put("type", structMsgItemButton2.J);
                                            jSONObject.put("index", structMsgItemButton2.H);
                                            jSONObject.put("name", structMsgItemButton2.I);
                                            jSONObject.put("net", String.valueOf(HttpUtil.getNetWorkType()));
                                            jSONObject.put("mobile_imei", com.tencent.mobileqq.utils.ah.z());
                                            jSONObject.put("obj", "");
                                            jSONObject.put("gdt_cli_data", structMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_msgClick"));
                                            jSONObject.put("view_id", structMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_view_id"));
                                            ((IPAReportUtil) QRoute.api(IPAReportUtil.class)).reportClickEventForAdver(qQAppInterface, structMsgForGeneralShare.message.selfuin, jSONObject.toString(), "" + structMsgForGeneralShare.msgId);
                                        } catch (JSONException e16) {
                                            e16.printStackTrace();
                                        }
                                    }
                                    if (structMsgItemButton2.O()) {
                                        if (structMsgItemButton2.M()) {
                                            ReportController.n(qQAppInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, structMsgForGeneralShare.uin, "0X80061FE", "0X80061FE", 0, 1, 0, "", "", "", "");
                                            ReportController.o(null, "P_CliOper", "Vip_pay_mywallet", qQAppInterface.getAccount(), QCircleDaTongConstant.ElementParamValue.WALLET, "publicpaymsg.btn.click", 1, 0, structMsgForGeneralShare.uin, "", String.valueOf(structMsgForGeneralShare.msgId), "");
                                            if (TextUtils.isEmpty(StructMsgItemButton.this.C)) {
                                                str2 = StructMsgItemButton.this.f290334m;
                                            } else {
                                                str2 = StructMsgItemButton.this.C;
                                            }
                                            try {
                                                JSONObject jSONObject2 = new JSONObject(str2);
                                                VACDReportUtil.a(APMidasPayAPI.PAY_CHANNEL_QQWALLET, "publicpaymsg.pay.click", null, "orderId=" + jSONObject2.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID), 0, null);
                                                ((IPublicQuickPayService) qQAppInterface.getRuntimeService(IPublicQuickPayService.class)).publicQuickPay(structMsgForGeneralShare.message.frienduin, jSONObject2, context, new a(structMsgForGeneralShare, context));
                                            } catch (Exception e17) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.e("StructMsgItemButton", 2, "pay error:" + e17.getMessage());
                                                }
                                            }
                                        } else {
                                            view.setClickable(false);
                                            view.setOnClickListener(null);
                                            view.setOnTouchListener(null);
                                            view.setOnLongClickListener(null);
                                        }
                                    }
                                    QidianManager qidianManager = (QidianManager) qQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
                                    if (QidianManager.I(structMsgItemButton2.C, structMsgItemButton2.f290334m, structMsgItemButton2.f290327h)) {
                                        qidianManager.g0(structMsgItemButton2.f290329i, structMsgItemButton2.C, structMsgItemButton2.f290334m, structMsgItemButton2.f290327h, 2, "");
                                    }
                                    MessageRecord messageRecord2 = structMsgForGeneralShare.message;
                                    if (messageRecord2 != null && QidianManager.H(qQAppInterface, messageRecord2)) {
                                        qidianManager.f0(structMsgItemButton2.f290334m);
                                    }
                                    if (structMsgForGeneralShare.msgId > 0) {
                                        ThreadManager.getSubThreadHandler().postDelayed(new Runnable(structMsgItemButton2, structMsgForGeneralShare, qQAppInterface, false) { // from class: com.tencent.mobileqq.structmsg.view.StructMsgItemButton.3.2
                                            static IPatchRedirector $redirector_;

                                            /* renamed from: d, reason: collision with root package name */
                                            final /* synthetic */ StructMsgItemButton f290441d;

                                            /* renamed from: e, reason: collision with root package name */
                                            final /* synthetic */ StructMsgForGeneralShare f290442e;

                                            /* renamed from: f, reason: collision with root package name */
                                            final /* synthetic */ QQAppInterface f290443f;

                                            /* renamed from: h, reason: collision with root package name */
                                            final /* synthetic */ boolean f290444h;

                                            {
                                                this.f290441d = structMsgItemButton2;
                                                this.f290442e = structMsgForGeneralShare;
                                                this.f290443f = qQAppInterface;
                                                this.f290444h = r9;
                                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                    iPatchRedirector3.redirect((short) 1, this, AnonymousClass3.this, structMsgItemButton2, structMsgForGeneralShare, qQAppInterface, Boolean.valueOf(r9));
                                                }
                                            }

                                            /* JADX WARN: Removed duplicated region for block: B:13:0x00dc A[RETURN] */
                                            /* JADX WARN: Removed duplicated region for block: B:14:0x00dd  */
                                            @Override // java.lang.Runnable
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public void run() {
                                                int parseInt;
                                                MessageRecord messageRecord3;
                                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                                    return;
                                                }
                                                long serverTime = NetConnInfoCenter.getServerTime();
                                                if (!TextUtils.isEmpty(this.f290441d.K0)) {
                                                    try {
                                                        parseInt = Integer.parseInt(StructMsgItemButton.this.K0);
                                                    } catch (NumberFormatException unused) {
                                                    }
                                                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.f290443f, "CliOper", "", this.f290442e.uin, "0X80055C8", "0X80055C8", parseInt, 0, Long.toString(serverTime), Long.toString(this.f290442e.msgId), this.f290441d.f290329i, Integer.toString(com.tencent.mobileqq.activity.aio.rebuild.c.y(this.f290442e.uin, this.f290443f) ? 1 : 0), false);
                                                    ReportController.o(this.f290443f, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, this.f290442e.uin, "0X8005D4A", "0X8005D4A", parseInt, this.f290444h ? 1 : 0, "MSGID=" + Long.toString(this.f290442e.msgId) + ";TEPLATEID=" + this.f290442e.templateIDForPortal + ";ARTICALID=;REFERRER=" + AbsStructMsgElement.e(this.f290441d.f290327h), "", "", "");
                                                    messageRecord3 = this.f290442e.message;
                                                    if (messageRecord3 != null) {
                                                        return;
                                                    }
                                                    String extInfoFromExtStr = messageRecord3.getExtInfoFromExtStr("gdt_msgClick");
                                                    if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                                                        JSONObject jSONObject3 = new JSONObject();
                                                        try {
                                                            jSONObject3.put(IPublicAccountBrowser.KEY_PUB_UIN, this.f290442e.uin);
                                                            jSONObject3.put("index", Long.toString(parseInt));
                                                            jSONObject3.put("gdt_cli_data", extInfoFromExtStr);
                                                        } catch (JSONException e18) {
                                                            e18.printStackTrace();
                                                        }
                                                        new ArrayList().add(String.valueOf(this.f290442e.msgId));
                                                        String extInfoFromExtStr2 = this.f290442e.message.getExtInfoFromExtStr("gdt_singleAd");
                                                        String extInfoFromExtStr3 = this.f290442e.message.getExtInfoFromExtStr("gdt_mulAd");
                                                        String extInfoFromExtStr4 = this.f290442e.message.getExtInfoFromExtStr("gdt_followAd");
                                                        if (!extInfoFromExtStr2.equals("1") && !extInfoFromExtStr3.equals("1")) {
                                                            extInfoFromExtStr4.equals("1");
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                parseInt = -1;
                                                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.f290443f, "CliOper", "", this.f290442e.uin, "0X80055C8", "0X80055C8", parseInt, 0, Long.toString(serverTime), Long.toString(this.f290442e.msgId), this.f290441d.f290329i, Integer.toString(com.tencent.mobileqq.activity.aio.rebuild.c.y(this.f290442e.uin, this.f290443f) ? 1 : 0), false);
                                                ReportController.o(this.f290443f, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, this.f290442e.uin, "0X8005D4A", "0X8005D4A", parseInt, this.f290444h ? 1 : 0, "MSGID=" + Long.toString(this.f290442e.msgId) + ";TEPLATEID=" + this.f290442e.templateIDForPortal + ";ARTICALID=;REFERRER=" + AbsStructMsgElement.e(this.f290441d.f290327h), "", "", "");
                                                messageRecord3 = this.f290442e.message;
                                                if (messageRecord3 != null) {
                                                }
                                            }
                                        }, 0L);
                                    }
                                }
                            }
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.f290322e = "button";
    }

    private void P() {
        String str;
        if (!TextUtils.isEmpty(this.f290329i) && this.f290329i.equals(OpenConstants.ApiName.PAY)) {
            if (TextUtils.isEmpty(this.C)) {
                str = this.f290334m;
            } else {
                str = this.C;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("appId")) {
                        this.f290433g1 = jSONObject.getString("appId");
                    }
                    if (jSONObject.has(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID)) {
                        this.f290434h1 = jSONObject.getString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID);
                    }
                    if (jSONObject.has("package")) {
                        this.f290436j1 = jSONObject.getString("package");
                    }
                    if (jSONObject.has("expireTime")) {
                        this.f290435i1 = jSONObject.getString("expireTime");
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("StructMsgItemButton", 2, "read msg=" + e16.getMessage());
                    }
                }
            }
        }
    }

    public boolean M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        int i3 = this.f290437k1;
        if (i3 != -6 && i3 != -4 && i3 != 0 && i3 != 23001027) {
            return true;
        }
        return false;
    }

    public void N(String str, MessageRecord messageRecord, StructMsgForGeneralShare structMsgForGeneralShare) {
        int intValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, messageRecord, structMsgForGeneralShare);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                intValue = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
            if (intValue != 23001027 && intValue != 0 && intValue != -4 && intValue != -6) {
                structMsgForGeneralShare.savePayInfo(((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getApplication(), this.f290434h1, -4);
                intValue = -4;
            }
            Q(intValue);
        }
        intValue = 999;
        if (intValue != 23001027) {
            structMsgForGeneralShare.savePayInfo(((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getApplication(), this.f290434h1, -4);
            intValue = -4;
        }
        Q(intValue);
    }

    public boolean O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.f290433g1) && !TextUtils.isEmpty(this.f290435i1) && !TextUtils.isEmpty(this.f290434h1) && OpenConstants.ApiName.PAY.equals(this.f290329i)) {
            return true;
        }
        return false;
    }

    public void Q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        this.f290437k1 = i3;
        if (i3 != -6) {
            if (i3 != -4) {
                if (i3 != 0) {
                    if (i3 == 23001027) {
                        this.f290437k1 = 0;
                    } else {
                        return;
                    }
                }
                E(HardCodeUtil.qqStr(R.string.twc));
                F("#ff777777");
                return;
            }
            E(HardCodeUtil.qqStr(R.string.twj));
            F("#ff777777");
            return;
        }
        E(HardCodeUtil.qqStr(R.string.twa));
        F("#ff777777");
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void b(View view) {
        int g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
        } else if (view instanceof TextView) {
            if (TextUtils.isEmpty(this.R0)) {
                g16 = m();
            } else {
                g16 = com.tencent.mobileqq.structmsg.k.g(this.R0);
            }
            ((TextView) view).setTextColor(g16);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public View c(Context context, View view, Bundle bundle) {
        int i3;
        TextView textView;
        boolean z16;
        boolean z17;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, this, context, view, bundle);
        }
        int i27 = -1;
        if (bundle == null) {
            textView = A(context);
            z16 = false;
            i3 = 0;
        } else {
            i3 = bundle.getInt("Layout3ButtonCount", 0);
            i27 = bundle.getInt("Layout3ButtonIndex", -1);
            textView = (TextView) super.c(context, view, bundle);
            z16 = bundle.getBoolean("key_support_night_mode", false);
        }
        if (QQTheme.isNowThemeIsNight() && z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            i16 = R.drawable.f160242j92;
        } else {
            i16 = R.drawable.f160241dz;
        }
        if (i3 > 1) {
            if (i27 == 0) {
                if (z17) {
                    i26 = R.drawable.j8w;
                } else {
                    i26 = R.drawable.f160232ds;
                }
                i16 = i26;
            } else {
                if (i27 == i3 - 1) {
                    if (z17) {
                        i19 = R.drawable.f160238j90;
                    } else {
                        i19 = R.drawable.f160236dw;
                    }
                    i16 = i19;
                    i17 = 2;
                } else {
                    if (z17) {
                        i18 = R.drawable.j8y;
                    } else {
                        i18 = R.drawable.f160234du;
                    }
                    i16 = i18;
                    i17 = 1;
                }
                textView.setBackgroundResource(i16);
                textView.setTag(R.id.j4h, Integer.valueOf(i17));
                textView.setTag(R.id.f89264za, Boolean.valueOf(z16));
                textView.setGravity(17);
                textView.setSingleLine();
                textView.setEllipsize(null);
                if (!O() && (!O() || !M())) {
                    textView.setClickable(false);
                    textView.setOnClickListener(null);
                    textView.setOnTouchListener(null);
                    textView.setOnLongClickListener(null);
                } else {
                    textView.setClickable(true);
                    textView.setOnClickListener(this.f290439m1);
                    textView.setOnLongClickListener(new a());
                    textView.setOnTouchListener(new b());
                }
                return textView;
            }
        }
        i17 = 0;
        textView.setBackgroundResource(i16);
        textView.setTag(R.id.j4h, Integer.valueOf(i17));
        textView.setTag(R.id.f89264za, Boolean.valueOf(z16));
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setEllipsize(null);
        if (!O()) {
        }
        textView.setClickable(true);
        textView.setOnClickListener(this.f290439m1);
        textView.setOnLongClickListener(new a());
        textView.setOnTouchListener(new b());
        return textView;
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) jVar)).booleanValue();
        }
        super.d(jVar);
        this.f290329i = jVar.a("action");
        this.f290334m = jVar.a(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA);
        this.C = jVar.a(PublicAccountMessageUtilImpl.ITEM_A_ACTION_DATA);
        this.D = jVar.a(PublicAccountMessageUtilImpl.ITEM_I_ACTION_DATA);
        this.f290327h = jVar.a("url");
        this.H = jVar.a("index");
        this.I = jVar.a("index_name");
        this.J = jVar.a("index_type");
        P();
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "Confirm";
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) objectInput);
            return;
        }
        super.i(objectInput);
        this.f290327h = objectInput.readUTF();
        this.f290329i = objectInput.readUTF();
        this.f290334m = objectInput.readUTF();
        this.C = objectInput.readUTF();
        this.D = objectInput.readUTF();
        if (this.f290320d > 5) {
            this.H = objectInput.readUTF();
            this.I = objectInput.readUTF();
            this.J = objectInput.readUTF();
        }
        P();
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) xmlSerializer);
            return;
        }
        super.k(xmlSerializer);
        xmlSerializer.startTag(null, "button");
        if (!TextUtils.isEmpty(this.f290329i)) {
            xmlSerializer.attribute(null, "action", this.f290329i);
        }
        if (!TextUtils.isEmpty(this.f290334m)) {
            xmlSerializer.attribute(null, PublicAccountMessageUtilImpl.ITEM_ACTION_DATA, this.f290334m);
        }
        if (!TextUtils.isEmpty(this.C)) {
            xmlSerializer.attribute(null, PublicAccountMessageUtilImpl.ITEM_A_ACTION_DATA, this.C);
        }
        if (!TextUtils.isEmpty(this.D)) {
            xmlSerializer.attribute(null, PublicAccountMessageUtilImpl.ITEM_I_ACTION_DATA, this.D);
        }
        if (!TextUtils.isEmpty(this.f290327h)) {
            xmlSerializer.attribute(null, "url", this.f290327h);
        }
        if (!TextUtils.isEmpty(this.H)) {
            xmlSerializer.attribute(null, "index", this.H);
        }
        if (!TextUtils.isEmpty(this.I)) {
            xmlSerializer.attribute(null, "index_name", this.I);
        }
        if (!TextUtils.isEmpty(this.J)) {
            xmlSerializer.attribute(null, "index_type", this.J);
        }
        xmlSerializer.endTag(null, "button");
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) objectOutput);
            return;
        }
        super.l(objectOutput);
        String str = this.f290327h;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        objectOutput.writeUTF(str);
        String str3 = this.f290329i;
        if (str3 == null) {
            str3 = "";
        }
        objectOutput.writeUTF(str3);
        String str4 = this.f290334m;
        if (str4 == null) {
            str4 = "";
        }
        objectOutput.writeUTF(str4);
        String str5 = this.C;
        if (str5 == null) {
            str5 = "";
        }
        objectOutput.writeUTF(str5);
        String str6 = this.D;
        if (str6 == null) {
            str6 = "";
        }
        objectOutput.writeUTF(str6);
        if (this.f290320d > 5) {
            String str7 = this.H;
            if (str7 == null) {
                str7 = "";
            }
            objectOutput.writeUTF(str7);
            String str8 = this.I;
            if (str8 == null) {
                str8 = "";
            }
            objectOutput.writeUTF(str8);
            String str9 = this.J;
            if (str9 != null) {
                str2 = str9;
            }
            objectOutput.writeUTF(str2);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.b
    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return -16734752;
    }

    @Override // com.tencent.mobileqq.structmsg.b
    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 32;
    }

    @Override // com.tencent.mobileqq.structmsg.b
    protected int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.id.agg;
    }
}
