package com.tencent.mobileqq.profile;

import QQService.CARDSETTYPE;
import SummaryCardTaf.SSummaryCardRsp;
import SummaryCardTaf.SSummaryCardSetReq;
import SummaryCardTaf.cardDiyComplicatedInfo;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class VipProfileCardBaseActivity extends IphoneTitleBarActivity {
    static IPatchRedirector $redirector_;
    protected CardObserver A0;
    public Runnable B0;
    public DialogInterface.OnClickListener C0;
    public DialogInterface.OnClickListener D0;
    public DialogInterface.OnClickListener E0;
    public DialogInterface.OnClickListener F0;

    /* renamed from: a0, reason: collision with root package name */
    protected QQProgressDialog f260041a0;

    /* renamed from: b0, reason: collision with root package name */
    protected Context f260042b0;

    /* renamed from: c0, reason: collision with root package name */
    protected int f260043c0;

    /* renamed from: d0, reason: collision with root package name */
    protected int f260044d0;

    /* renamed from: e0, reason: collision with root package name */
    protected boolean f260045e0;

    /* renamed from: f0, reason: collision with root package name */
    protected boolean f260046f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f260047g0;

    /* renamed from: h0, reason: collision with root package name */
    protected String f260048h0;

    /* renamed from: i0, reason: collision with root package name */
    protected int f260049i0;

    /* renamed from: j0, reason: collision with root package name */
    protected int f260050j0;

    /* renamed from: k0, reason: collision with root package name */
    protected QQCustomDialog f260051k0;

    /* renamed from: l0, reason: collision with root package name */
    protected QQCustomDialog f260052l0;

    /* renamed from: m0, reason: collision with root package name */
    public CardHandler f260053m0;

    /* renamed from: n0, reason: collision with root package name */
    public long f260054n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f260055o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f260056p0;

    /* renamed from: q0, reason: collision with root package name */
    public String f260057q0;

    /* renamed from: r0, reason: collision with root package name */
    public int f260058r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f260059s0;

    /* renamed from: t0, reason: collision with root package name */
    protected int f260060t0;

    /* renamed from: u0, reason: collision with root package name */
    protected int f260061u0;

    /* renamed from: v0, reason: collision with root package name */
    protected float f260062v0;

    /* renamed from: w0, reason: collision with root package name */
    protected int f260063w0;

    /* renamed from: x0, reason: collision with root package name */
    protected ArrayList<ProfileCardTemplate> f260064x0;

    /* renamed from: y0, reason: collision with root package name */
    protected SVIPObserver f260065y0;

    /* renamed from: z0, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    public Handler f260066z0;

    /* loaded from: classes16.dex */
    class a extends SVIPObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipProfileCardBaseActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onVipStatusChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "mVipStatusObserver vip change");
            }
            VipProfileCardBaseActivity.this.L2();
        }
    }

    /* loaded from: classes16.dex */
    class b extends Handler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipProfileCardBaseActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (!VipProfileCardBaseActivity.this.R2(message)) {
                int i3 = message.what;
                if (i3 != 6) {
                    if (i3 != 7) {
                        if (i3 == 9) {
                            VipProfileCardBaseActivity.this.W2();
                            return;
                        }
                        return;
                    }
                    QQToast.makeText(VipProfileCardBaseActivity.this.f260042b0.getApplicationContext(), R.string.d2q, 0).show();
                    return;
                }
                Object obj = message.obj;
                if (obj != null && (obj instanceof String)) {
                    QQToast.makeText(VipProfileCardBaseActivity.this.f260042b0.getApplicationContext(), (String) message.obj, 0).show();
                } else {
                    QQToast.makeText(VipProfileCardBaseActivity.this.f260042b0.getApplicationContext(), R.string.d3z, 0).show();
                }
            }
        }
    }

    /* loaded from: classes16.dex */
    class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipProfileCardBaseActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                VipProfileCardBaseActivity.this.H2();
            }
        }
    }

    /* loaded from: classes16.dex */
    class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipProfileCardBaseActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            VipProfileCardBaseActivity.this.H2();
            VipProfileCardBaseActivity.this.M2();
            ReportController.o(VipProfileCardBaseActivity.this.app, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", "CLICK_VIPOPENSERVICE", 0, 0, "", "", "", "");
        }
    }

    /* loaded from: classes16.dex */
    class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipProfileCardBaseActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                VipProfileCardBaseActivity.this.G2();
            }
        }
    }

    /* loaded from: classes16.dex */
    class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipProfileCardBaseActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                VipProfileCardBaseActivity.this.G2();
            }
        }
    }

    public VipProfileCardBaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f260042b0 = null;
        this.f260043c0 = -1;
        this.f260044d0 = -1;
        this.f260045e0 = false;
        this.f260046f0 = false;
        this.f260047g0 = 0;
        this.f260048h0 = "";
        this.f260049i0 = 0;
        this.f260050j0 = 1;
        this.f260051k0 = null;
        this.f260052l0 = null;
        this.f260053m0 = null;
        this.f260054n0 = 0L;
        this.f260055o0 = 2;
        this.f260056p0 = -1;
        this.f260057q0 = null;
        this.f260058r0 = -1;
        this.f260059s0 = 30000;
        this.f260064x0 = null;
        this.f260065y0 = new a();
        this.f260066z0 = new b();
        this.A0 = new CardObserver() { // from class: com.tencent.mobileqq.profile.VipProfileCardBaseActivity.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VipProfileCardBaseActivity.this);
                }
            }

            @Override // com.tencent.mobileqq.app.CardObserver
            public void onSetCardTemplateReturn(boolean z16, Object obj) {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "CardObserver onSetCardTemplateReturn isSuccess : " + z16 + ", obj : " + obj);
                }
                String currentAccountUin = VipProfileCardBaseActivity.this.app.getCurrentAccountUin();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_BackgroundId", String.valueOf(VipProfileCardBaseActivity.this.f260056p0));
                hashMap.put("param_StyleId", String.valueOf(VipProfileCardBaseActivity.this.f260054n0));
                VipProfileCardBaseActivity vipProfileCardBaseActivity = VipProfileCardBaseActivity.this;
                vipProfileCardBaseActivity.f260066z0.removeCallbacks(vipProfileCardBaseActivity.B0);
                VipProfileCardBaseActivity.this.dismissDialog();
                if (z16 && obj != null) {
                    if (obj instanceof Card) {
                        ThreadManagerV2.post(new Runnable((Card) obj, hashMap, currentAccountUin) { // from class: com.tencent.mobileqq.profile.VipProfileCardBaseActivity.3.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ Card f260068d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ HashMap f260069e;

                            /* renamed from: f, reason: collision with root package name */
                            final /* synthetic */ String f260070f;

                            {
                                this.f260068d = r6;
                                this.f260069e = hashMap;
                                this.f260070f = currentAccountUin;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, AnonymousClass3.this, r6, hashMap, currentAccountUin);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                String str2;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                VipProfileCardBaseActivity vipProfileCardBaseActivity2 = VipProfileCardBaseActivity.this;
                                Card card = this.f260068d;
                                boolean Q2 = vipProfileCardBaseActivity2.Q2((int) card.lCurrentStyleId, (int) card.lCurrentBgId, card.backgroundUrl, (int) card.backgroundColor, card.templateRet);
                                HashMap hashMap2 = this.f260069e;
                                if (Q2) {
                                    str2 = "0";
                                } else {
                                    str2 = "-102";
                                }
                                hashMap2.put("param_FailCode", str2);
                                if (Q2) {
                                    StatisticCollector.getInstance(VipProfileCardBaseActivity.this.app.getApp()).collectPerformance(this.f260070f, "profileCardSet", true, 0L, 0L, this.f260069e, "", false);
                                    VipProfileCardBaseActivity.this.f260066z0.sendMessage(VipProfileCardBaseActivity.this.f260066z0.obtainMessage(5));
                                    return;
                                }
                                StatisticCollector.getInstance(VipProfileCardBaseActivity.this.app.getApp()).collectPerformance(this.f260070f, "profileCardSet", false, 0L, 0L, this.f260069e, "", false);
                                VipProfileCardBaseActivity.this.f260066z0.sendMessage(VipProfileCardBaseActivity.this.f260066z0.obtainMessage(6));
                                VasCommonReporter.getDiyCard().setValue1("set card success , save fail backgroundUrl:" + this.f260068d.backgroundUrl + ",styleId: " + this.f260068d.lCurrentStyleId).report(false);
                            }
                        }, 5, null, true);
                        return;
                    }
                    if (obj instanceof Pair) {
                        Pair pair = (Pair) obj;
                        if (((Integer) pair.first).intValue() == 101107) {
                            VipProfileCardBaseActivity vipProfileCardBaseActivity2 = VipProfileCardBaseActivity.this;
                            vipProfileCardBaseActivity2.f260043c0 = 1;
                            vipProfileCardBaseActivity2.f260049i0 = 2;
                            VipProfileCardBaseActivity.this.f260066z0.sendMessage(vipProfileCardBaseActivity2.f260066z0.obtainMessage(9));
                        } else if (((Integer) pair.first).intValue() == 101108) {
                            VipProfileCardBaseActivity vipProfileCardBaseActivity3 = VipProfileCardBaseActivity.this;
                            vipProfileCardBaseActivity3.f260043c0 = 2;
                            vipProfileCardBaseActivity3.f260049i0 = 5;
                            VipProfileCardBaseActivity.this.f260066z0.sendMessage(vipProfileCardBaseActivity3.f260066z0.obtainMessage(9));
                        } else {
                            Message obtainMessage = VipProfileCardBaseActivity.this.f260066z0.obtainMessage(6);
                            if (((Integer) pair.first).intValue() >= 400000 && ((Integer) pair.first).intValue() <= 499999) {
                                obtainMessage.obj = ((SSummaryCardRsp) pair.second).emsg;
                            }
                            VipProfileCardBaseActivity.this.f260066z0.sendMessage(obtainMessage);
                        }
                        VasCommonReporter.getDiyCard().setValue1("set card fail , errorCode :" + pair.first).report(false);
                        hashMap.put("param_FailCode", String.valueOf(pair.first));
                        StatisticCollector.getInstance(VipProfileCardBaseActivity.this.app.getApp()).collectPerformance(currentAccountUin, "profileCardSet", false, 0L, 0L, hashMap, "", false);
                        return;
                    }
                    VasCommonReporter.getDiyCard().setValue1("set card fail ,obj: " + obj).report(false);
                    return;
                }
                if (!z16) {
                    str = "-104";
                } else {
                    str = "-105";
                }
                hashMap.put("param_FailCode", str);
                StatisticCollector.getInstance(VipProfileCardBaseActivity.this.app.getApp()).collectPerformance(currentAccountUin, "profileCardSet", false, 0L, 0L, hashMap, "", false);
                VipProfileCardBaseActivity.this.f260066z0.sendMessage(VipProfileCardBaseActivity.this.f260066z0.obtainMessage(6));
                VasCommonReporter.getDiyCard().setValue1("set card fail, isSuccess: " + z16).report(false);
            }
        };
        this.B0 = new Runnable() { // from class: com.tencent.mobileqq.profile.VipProfileCardBaseActivity.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VipProfileCardBaseActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    VipProfileCardBaseActivity.this.dismissDialog();
                }
            }
        };
        this.C0 = new c();
        this.D0 = new d();
        this.E0 = new e();
        this.F0 = new f();
    }

    protected void G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        QQCustomDialog qQCustomDialog = this.f260052l0;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
            this.f260052l0 = null;
        }
    }

    protected void H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QQCustomDialog qQCustomDialog = this.f260051k0;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
            this.f260051k0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean I2(ProfileCardTemplate profileCardTemplate, com.tencent.mobileqq.profile.d dVar, boolean z16) {
        int i3;
        int i16;
        boolean z17;
        boolean z18;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, profileCardTemplate, dVar, Boolean.valueOf(z16))).booleanValue();
        }
        if (profileCardTemplate == null || dVar == null || profileCardTemplate.styleId == 0) {
            return true;
        }
        String str2 = profileCardTemplate.auth;
        try {
            if (TextUtils.isEmpty(str2)) {
                str = "0";
            } else {
                str = str2;
            }
            i3 = Integer.parseInt(str);
        } catch (NumberFormatException e16) {
            QLog.w("ProfileCard.VipProfileCardBaseActivity", 1, "parseInt exception, auth=" + str2, e16);
            i3 = 0;
        }
        int i17 = dVar.f260142f;
        boolean K = ProfileCardUtil.K(dVar);
        if (K) {
            i17 = profileCardTemplate.customBackgroundAuth;
        }
        if (i3 >= i17) {
            this.f260047g0 = 1;
            if (i3 == i17) {
                this.f260047g0 = 2;
            }
            i16 = i3;
        } else {
            this.f260047g0 = 0;
            i16 = i17;
        }
        this.f260044d0 = i16;
        if (i16 != 0 && i16 != 1) {
            if (i16 == 2) {
                boolean z19 = this.f260045e0;
                if (!z19 && !(z18 = this.f260046f0)) {
                    this.f260043c0 = 1;
                    if (K) {
                        this.f260048h0 = "mvip.gongneng.android.mingpian_zidingyi";
                    } else if (this.f260050j0 == 1) {
                        this.f260048h0 = ProfileCardUtil.n(z19, z18, i3, i17, 1);
                    } else {
                        this.f260048h0 = ProfileCardUtil.o(3);
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, String.format("getAid mIsQQVipOpen : %b, mIsSuperVipOpen : %b, styleAuth : %d, bgAuth : %d, mNeedVipType : %d, mAid : %s", Boolean.valueOf(this.f260045e0), Boolean.valueOf(this.f260046f0), Integer.valueOf(i3), Integer.valueOf(i17), Integer.valueOf(this.f260043c0), this.f260048h0));
                    }
                    if (z16) {
                        this.f260066z0.sendEmptyMessage(9);
                    }
                    return false;
                }
            } else if (i16 == 4 && !(z17 = this.f260046f0)) {
                this.f260043c0 = 2;
                if (K) {
                    this.f260048h0 = "mvip.gongneng.android.mingpian_zidingyi";
                } else if (this.f260050j0 == 1) {
                    this.f260048h0 = ProfileCardUtil.n(this.f260045e0, z17, i3, i17, 2);
                } else {
                    this.f260048h0 = ProfileCardUtil.o(6);
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, String.format("getAid mIsQQVipOpen : %b, mIsSuperVipOpen : %b, styleAuth : %d, bgAuth : %d, mNeedVipType : %d, mAid : %s", Boolean.valueOf(this.f260045e0), Boolean.valueOf(this.f260046f0), Integer.valueOf(i3), Integer.valueOf(i17), Integer.valueOf(this.f260043c0), this.f260048h0));
                }
                if (z16) {
                    this.f260066z0.sendEmptyMessage(9);
                }
                return false;
            }
        }
        return true;
    }

    public ArrayList<ProfileCardTemplate> J2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (ArrayList) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        ArrayList<ProfileCardTemplate> arrayList = this.f260064x0;
        if (arrayList == null || arrayList.size() == 0) {
            this.f260064x0 = ProfileCardTemplateUtil.g(false, false);
            if (VasToggle.FEATURE_BATCH_UPDATE.isEnable(true)) {
                ProfileCardTemplateUtil.b(this.app);
            } else {
                ProfileCardTemplateUtil.a(this.app);
            }
        }
        return this.f260064x0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int K2(String str, com.tencent.mobileqq.vip.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, (Object) fVar)).intValue();
        }
        if (ProfileCardUtil.M(str)) {
            return 19;
        }
        com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(str, new File(ProfileCardUtil.u(str)));
        if (fVar != null) {
            gVar.u(fVar);
        }
        gVar.S = "profileCardDownload";
        gVar.R = "VIP_profilecard";
        return DownloaderFactory.o(gVar, this.app);
    }

    protected void L2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.f260046f0 = VasUtil.getSignedService(this.app).getVipStatus().isSVip();
        this.f260045e0 = VasUtil.getSignedService(this.app).getVipStatus().isVip();
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "initQQVipStatus mIsSuperVipOpen=" + this.f260046f0 + ",mIsQQVipOpen=" + this.f260045e0);
        }
    }

    public void M2() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("ExternAid")) {
            str = intent.getStringExtra("ExternAid");
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f260048h0;
        }
        String str2 = str;
        if (this.f260043c0 == 2) {
            VasH5PayUtil.openClubPay((BaseActivity) this.f260042b0, str2, 3, "1450000516", "CJCLUBT", getString(R.string.f173184hu3), "svip");
            QQAppInterface qQAppInterface = this.app;
            ReportController.o(qQAppInterface, "P_CliOper", "Vip_SummaryCard", "", "0X80044E0", "0X80044E0", 0, 0, "", "", "", ff.h(qQAppInterface, qQAppInterface.getCurrentAccountUin()));
        } else {
            VasH5PayUtil.openClubPay((BaseActivity) this.f260042b0, str2, 3, "1450000515", "LTMCLUB", getString(R.string.d2p), "vip");
            QQAppInterface qQAppInterface2 = this.app;
            ReportController.o(qQAppInterface2, "P_CliOper", "Vip_SummaryCard", "", "0X80044DF", "0X80044DF", 0, 0, "", "", "", ff.h(qQAppInterface2, qQAppInterface2.getCurrentAccountUin()));
        }
    }

    protected void N2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public void P2() {
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        Card r16 = ((FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(this.app.getCurrentAccountUin());
        if (r16 != null) {
            if (r16.templateRet != 0) {
                this.f260054n0 = 0L;
                this.f260056p0 = -1;
                this.f260058r0 = 1;
                this.f260057q0 = null;
            } else {
                Intent intent = getIntent();
                if (intent == null) {
                    if (r16.cardType == 2) {
                        j16 = ProfileCardTemplate.PROFILE_CARD_STYLE_DIY;
                    } else {
                        j16 = (int) r16.lCurrentStyleId;
                    }
                    this.f260054n0 = j16;
                    this.f260056p0 = (int) r16.lCurrentBgId;
                    this.f260057q0 = r16.backgroundUrl;
                    this.f260058r0 = (int) r16.backgroundColor;
                } else {
                    if (!intent.hasExtra("CurrentTemplateId")) {
                        if (r16.cardType == 2) {
                            j3 = ProfileCardTemplate.PROFILE_CARD_STYLE_DIY;
                        } else {
                            j3 = (int) r16.lCurrentStyleId;
                        }
                        this.f260054n0 = j3;
                    }
                    if (!intent.hasExtra("CurrentBackgroundId")) {
                        this.f260056p0 = (int) r16.lCurrentBgId;
                    }
                    if (!intent.hasExtra("CurrentBackgroundUrl")) {
                        this.f260057q0 = r16.backgroundUrl;
                    }
                    if (!intent.hasExtra("CurrentBackgroundColor")) {
                        this.f260058r0 = (int) r16.backgroundColor;
                    }
                }
                if (this.f260054n0 == -1) {
                    this.f260054n0 = 0L;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, String.format("readInfofromDB , mCurrentStyleId : %s , mCurrentBackgroundId : %s , mCurrentBackgroundColor : %s , mCurrentBackgroundUrl : %s", Long.valueOf(this.f260054n0), Integer.valueOf(this.f260056p0), Integer.valueOf(this.f260058r0), this.f260057q0));
        }
    }

    public boolean Q2(long j3, int i3, String str, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, this, Long.valueOf(j3), Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
        }
        FriendsManager friendsManager = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Card r16 = friendsManager.r(this.app.getCurrentAccountUin());
        if (r16 == null || j3 < 0) {
            return false;
        }
        r16.lCurrentStyleId = j3;
        r16.lCurrentBgId = i3;
        r16.strCurrentBgUrl = str;
        r16.backgroundColor = i16;
        r16.templateRet = i17;
        if (friendsManager.p0(r16)) {
            return true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, "save card in db failed ");
        }
        return false;
    }

    protected boolean R2(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        return false;
    }

    public void S2(com.tencent.mobileqq.profile.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) dVar);
            return;
        }
        if (dVar == null) {
            return;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        if (dVar.f260143g == 1 && serverTime < dVar.f260145i && serverTime > dVar.f260144h) {
            dVar.f260142f = 1;
        }
    }

    public void T2(ProfileCardTemplate profileCardTemplate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) profileCardTemplate);
            return;
        }
        if (profileCardTemplate == null) {
            return;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        if (profileCardTemplate.limitefreeType == 1 && serverTime < profileCardTemplate.limitefreeEtime && serverTime > profileCardTemplate.limitefreeBtime) {
            profileCardTemplate.auth = "1";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U2(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            V2(j3, j16, null, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V2(long j3, long j16, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Long.valueOf(j3), Long.valueOf(j16), str, Integer.valueOf(i3));
            return;
        }
        VasLogReporter.getProfileCard().reportHighest("setStyleAndBg start");
        dismissDialog();
        Context context = this.f260042b0;
        QQProgressDialog qQProgressDialog = new QQProgressDialog(context, ((BaseActivity) context).getTitleBarHeight());
        this.f260041a0 = qQProgressDialog;
        qQProgressDialog.setCancelable(false);
        this.f260041a0.setMessage(R.string.d3y);
        try {
            this.f260041a0.show();
        } catch (Exception unused) {
        }
        this.app.execute(new Runnable(j3, j16, str, i3) { // from class: com.tencent.mobileqq.profile.VipProfileCardBaseActivity.9
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f260072d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f260073e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f260074f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f260075h;

            {
                this.f260072d = j3;
                this.f260073e = j16;
                this.f260074f = str;
                this.f260075h = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, VipProfileCardBaseActivity.this, Long.valueOf(j3), Long.valueOf(j16), str, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                SSummaryCardSetReq sSummaryCardSetReq = new SSummaryCardSetReq(2, Long.parseLong(VipProfileCardBaseActivity.this.app.getCurrentAccountUin()), 0L, AppSetting.f99551k, 109L, this.f260072d, this.f260073e, this.f260074f, this.f260075h, null, null, new cardDiyComplicatedInfo());
                UniPacket uniPacket = new UniPacket(true);
                uniPacket.setEncodeName("utf-8");
                uniPacket.setFuncName("set");
                uniPacket.setServantName("MCardSvc");
                uniPacket.put("req", sSummaryCardSetReq);
                byte[] encode = uniPacket.encode();
                VipProfileCardBaseActivity vipProfileCardBaseActivity = VipProfileCardBaseActivity.this;
                vipProfileCardBaseActivity.f260053m0.c5(vipProfileCardBaseActivity.app.getCurrentAccountUin(), CARDSETTYPE.TYPE_SET_TEMPLATE.value(), encode);
            }
        });
        this.f260066z0.postDelayed(this.B0, this.f260059s0);
    }

    protected void W2() {
        String string;
        String string2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        H2();
        if (this.f260043c0 == 2) {
            string = getString(R.string.d2f);
            int i3 = this.f260047g0;
            if (i3 == 2) {
                string2 = getString(R.string.d2j);
            } else if (i3 == 1) {
                string2 = getString(R.string.d2l);
            } else {
                string2 = getString(R.string.d2h);
            }
        } else {
            string = getString(R.string.d2n);
            int i16 = this.f260047g0;
            if (i16 == 2) {
                string2 = getString(R.string.d2k);
            } else if (i16 == 1) {
                string2 = getString(R.string.d2m);
            } else {
                string2 = getString(R.string.d2i);
            }
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f260042b0, 0, string, string2, R.string.d2d, R.string.d2e, this.D0, this.C0);
        this.f260051k0 = createCustomDialog;
        createCustomDialog.show();
    }

    public long[] Y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (long[]) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        ArrayList<ProfileCardTemplate> J2 = J2();
        if (J2 != null && J2.size() > 0) {
            long[] jArr = new long[J2.size()];
            for (int i3 = 0; i3 < J2.size(); i3++) {
                jArr[i3] = J2.get(i3).styleId;
            }
            return jArr;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dismissDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.f260041a0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                this.f260041a0.dismiss();
            } catch (Exception unused) {
            } catch (Throwable th5) {
                this.f260041a0 = null;
                throw th5;
            }
            this.f260041a0 = null;
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    @TargetApi(9)
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f260061u0 = displayMetrics.widthPixels;
        this.f260060t0 = displayMetrics.heightPixels;
        this.f260063w0 = displayMetrics.densityDpi;
        this.f260062v0 = displayMetrics.density;
        L2();
        this.f260053m0 = (CardHandler) this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        addObserver(this.f260065y0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnDestroy();
        removeObserver(this.A0);
        H2();
        dismissDialog();
        this.f260064x0 = null;
        removeObserver(this.f260065y0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, resultCode : " + i3 + ", resultCode : " + i16 + ", data : " + intent);
        }
        if (i3 == 4 && i16 == -1 && intent != null) {
            if (intent.hasExtra("result")) {
                String stringExtra = intent.getStringExtra("result");
                if (QLog.isColorLevel()) {
                    QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, resultStr : " + stringExtra);
                }
                if (!TextUtils.isEmpty(stringExtra)) {
                    try {
                        Object obj = new JSONObject(stringExtra).get("payState");
                        if (QLog.isColorLevel()) {
                            QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, stateObj : " + obj);
                        }
                        if (obj != null && "0".equals(String.valueOf(obj))) {
                            if (intent.hasExtra("callbackSn")) {
                                str = intent.getStringExtra("callbackSn");
                            } else {
                                str = null;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, callbackSn : " + str);
                            }
                            if ("svip".equals(str)) {
                                this.f260046f0 = true;
                            } else {
                                this.f260045e0 = true;
                            }
                            N2();
                            return;
                        }
                        return;
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, JSONException : " + e16.getMessage());
                            return;
                        }
                        return;
                    } catch (Exception e17) {
                        e17.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, Exception : " + e17.getMessage());
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, data contain no result key.");
            }
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
