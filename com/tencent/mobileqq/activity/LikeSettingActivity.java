package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LikeSettingActivity extends IphoneTitleBarActivity implements PraiseManager.a, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    com.tencent.mobileqq.app.bk f176433a0;

    /* renamed from: b0, reason: collision with root package name */
    PraiseManager f176434b0;

    /* renamed from: c0, reason: collision with root package name */
    FormSwitchItem f176435c0;

    /* renamed from: d0, reason: collision with root package name */
    FormSwitchItem f176436d0;

    /* renamed from: e0, reason: collision with root package name */
    FormSwitchItem f176437e0;

    /* renamed from: f0, reason: collision with root package name */
    FormSimpleItem f176438f0;

    /* renamed from: g0, reason: collision with root package name */
    FormSimpleItem f176439g0;

    /* renamed from: h0, reason: collision with root package name */
    TextView f176440h0;

    /* renamed from: i0, reason: collision with root package name */
    CardHandler f176441i0;

    /* renamed from: j0, reason: collision with root package name */
    CardObserver f176442j0;

    /* renamed from: k0, reason: collision with root package name */
    CompoundButton.OnCheckedChangeListener f176443k0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends CardObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LikeSettingActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetCardSwitch(boolean z16, String str, boolean z17, boolean z18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17), Boolean.valueOf(z18));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("LikeSettingActivity", 2, "onGetCardSwitch.isSuccess=" + z16 + ",uin=" + str + ",voteAllowed=" + z17 + ",praiseStatusAllowed=" + z18);
            }
            if (LikeSettingActivity.this.app.getCurrentAccountUin().equals(str) && z16) {
                LikeSettingActivity likeSettingActivity = LikeSettingActivity.this;
                likeSettingActivity.H2(likeSettingActivity.f176436d0.getSwitch(), z17);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetNotifyOnLikeRankingList(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("LikeSettingActivity", 2, "onGetNotifyOnLikeRankingList.isSuccess=" + z16 + ",open=" + z17);
            }
            if (z16) {
                LikeSettingActivity likeSettingActivity = LikeSettingActivity.this;
                likeSettingActivity.H2(likeSettingActivity.f176435c0.getSwitch(), z17);
                LikeSettingActivity.this.f176433a0.f(z17);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetPartakeLikeRankingList(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("LikeSettingActivity", 2, "onGetPartakeLikeRankingList.isSuccess=" + z16 + ",open=" + z17);
            }
            if (z16) {
                LikeSettingActivity likeSettingActivity = LikeSettingActivity.this;
                likeSettingActivity.H2(likeSettingActivity.f176437e0.getSwitch(), z17);
                LikeSettingActivity.this.f176433a0.g(z17);
                if (!z17) {
                    LikeSettingActivity.this.f176435c0.setVisibility(8);
                } else {
                    LikeSettingActivity.this.f176435c0.setVisibility(0);
                }
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetCardSwitch(boolean z16, String str, boolean z17, boolean z18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17), Boolean.valueOf(z18));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("LikeSettingActivity", 2, "onSetCardSwitch.isSuccess=" + z16 + ",uin=" + str + ",forNearPeople=" + z17 + ",allowed=" + z18);
            }
            if (LikeSettingActivity.this.app.getCurrentAccountUin().equals(str) && z17 && !z16) {
                QQToast.makeText(LikeSettingActivity.this, 1, R.string.hhc, 0).show(LikeSettingActivity.this.getTitleBarHeight());
                LikeSettingActivity likeSettingActivity = LikeSettingActivity.this;
                likeSettingActivity.H2(likeSettingActivity.f176436d0.getSwitch(), z18);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetNotifyOnLikeRankingList(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("LikeSettingActivity", 2, "onSetNotifyOnLikeRankingList.isSuccess=" + z16 + ",open=" + z17);
            }
            if (!z16) {
                QQToast.makeText(LikeSettingActivity.this, 1, R.string.hhc, 0).show(LikeSettingActivity.this.getTitleBarHeight());
                LikeSettingActivity likeSettingActivity = LikeSettingActivity.this;
                likeSettingActivity.H2(likeSettingActivity.f176437e0.getSwitch(), LikeSettingActivity.this.f176433a0.b());
                return;
            }
            LikeSettingActivity.this.f176433a0.f(z17);
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetPartakeLikeRankingList(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("LikeSettingActivity", 2, "onSetPartakeLikeRankingList.isSuccess=" + z16 + ",open=" + z17);
            }
            if (!z16) {
                QQToast.makeText(LikeSettingActivity.this, 1, R.string.hhc, 0).show(LikeSettingActivity.this.getTitleBarHeight());
                LikeSettingActivity likeSettingActivity = LikeSettingActivity.this;
                likeSettingActivity.H2(likeSettingActivity.f176437e0.getSwitch(), LikeSettingActivity.this.f176433a0.c());
            } else {
                LikeSettingActivity.this.f176433a0.g(z17);
                if (!z17) {
                    LikeSettingActivity.this.f176435c0.setVisibility(8);
                } else {
                    LikeSettingActivity.this.f176435c0.setVisibility(0);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LikeSettingActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else if (compoundButton == LikeSettingActivity.this.f176436d0.getSwitch()) {
                LikeSettingActivity.this.app.setZanAllowed(true, z16);
            } else {
                String str = "1";
                if (compoundButton == LikeSettingActivity.this.f176435c0.getSwitch()) {
                    QQAppInterface qQAppInterface = LikeSettingActivity.this.app;
                    if (!z16) {
                        str = "0";
                    }
                    ReportController.o(qQAppInterface, "dc00898", "", "", "0X8007614", "0X8007614", 0, 0, str, "", "", "");
                    LikeSettingActivity.this.f176441i0.l5(z16);
                } else if (compoundButton == LikeSettingActivity.this.f176437e0.getSwitch()) {
                    QQAppInterface qQAppInterface2 = LikeSettingActivity.this.app;
                    if (!z16) {
                        str = "2";
                    }
                    ReportController.o(qQAppInterface2, "dc00898", "", "", "0X800791B", "0X800791B", 0, 0, str, "", "", "");
                    LikeSettingActivity.this.f176441i0.n5(z16);
                    if (!z16) {
                        LikeSettingActivity.this.f176435c0.setVisibility(8);
                    } else {
                        LikeSettingActivity.this.f176435c0.setVisibility(0);
                    }
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    public LikeSettingActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f176442j0 = new a();
            this.f176443k0 = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H2(CompoundButton compoundButton, boolean z16) {
        compoundButton.setOnCheckedChangeListener(null);
        compoundButton.setChecked(z16);
        compoundButton.setOnCheckedChangeListener(this.f176443k0);
    }

    @Override // com.tencent.mobileqq.profile.like.PraiseManager.a
    public void M0(int i3, com.tencent.mobileqq.profile.like.d dVar, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), dVar, Integer.valueOf(i16), str);
        } else if (i3 == PraiseManager.f(this.app) && dVar != null) {
            int f16 = BaseAIOUtils.f(34.0f, super.getResources());
            this.f176438f0.setRightIcon(new BitmapDrawable(super.getResources(), dVar.f260240h), f16, f16);
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
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        setContentView(R.layout.ax6);
        setTitle(HardCodeUtil.qqStr(R.string.noc));
        setLeftViewName(R.string.button_back);
        this.f176433a0 = (com.tencent.mobileqq.app.bk) this.app.getManager(QQManagerFactory.LIKE_RANKING_LIST_MANAGER);
        this.f176434b0 = (PraiseManager) this.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
        this.f176441i0 = (CardHandler) this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        this.f176435c0 = (FormSwitchItem) super.findViewById(R.id.fbi);
        this.f176436d0 = (FormSwitchItem) super.findViewById(R.id.e9o);
        this.f176437e0 = (FormSwitchItem) super.findViewById(R.id.fbj);
        this.f176438f0 = (FormSimpleItem) super.findViewById(R.id.flu);
        this.f176439g0 = (FormSimpleItem) super.findViewById(R.id.f242108i);
        this.f176440h0 = (TextView) super.findViewById(R.id.f242208j);
        if (VasToggle.VAS_LIKE_AREA_ENTRY.isEnable(true)) {
            HashMap hashMap = new HashMap();
            hashMap.put("dt_pgid", "pg_user_profile_likeplace_setting");
            hashMap.put("dt_eid", "em_likeplace_set");
            VideoReport.reportEvent("imp", hashMap);
        } else {
            this.f176439g0.setVisibility(8);
            this.f176440h0.setVisibility(8);
        }
        refreshUI();
        this.app.addObserver(this.f176442j0);
        this.app.getZanSwitches();
        this.f176441i0.c3();
        this.f176441i0.d3();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnDestroy();
        this.app.removeObserver(this.f176442j0);
        this.f176434b0.j(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else if (!com.tencent.mobileqq.utils.u.a().b()) {
            if (view.getId() == R.id.flu) {
                Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
                String addEntryParamToUrl = VasWebviewUtil.addEntryParamToUrl(IndividuationUrlHelper.getMarketUrl(this, "praise", ""), 51);
                if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                    ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(this, addEntryParamToUrl);
                } else {
                    VasWebviewUtil.openQQBrowserWithoutAD(this, addEntryParamToUrl, 536870912L, intent, false, -1);
                }
                ReportController.o(this.app, "CliOper", "", "", "like_mall", "like_enter", 1, 0, "", "", "", "");
            } else if (view.getId() == R.id.f242108i) {
                String stringDataSet = VasToggle.VAS_LIKE_AREA_ENTRY.getStringDataSet("url", "");
                if (!TextUtils.isEmpty(stringDataSet)) {
                    String buildTraceDetailUrl = com.tencent.mobileqq.vip.api.e.a().buildTraceDetailUrl(stringDataSet, IVipTraceDetailReport.FROM.PROFILECARD_LIKEAREA_SETTING);
                    if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(this, buildTraceDetailUrl);
                    } else {
                        Intent intent2 = new Intent(this, (Class<?>) QQBrowserActivity.class);
                        intent2.putExtra("url", buildTraceDetailUrl + buildTraceDetailUrl);
                        startActivity(intent2);
                    }
                }
                HashMap hashMap = new HashMap();
                hashMap.put("dt_pgid", "pg_user_profile_likeplace_setting");
                hashMap.put("dt_eid", "em_likeplace_set");
                VideoReport.reportEvent("clck", hashMap);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    void refreshUI() {
        H2(this.f176436d0.getSwitch(), this.app.getLocZanAllowedForPeople());
        this.f176436d0.setOnCheckedChangeListener(this.f176443k0);
        int i3 = 0;
        this.f176436d0.setBgType(0);
        this.f176435c0.setOnCheckedChangeListener(null);
        FormSwitchItem formSwitchItem = this.f176435c0;
        if (!this.f176433a0.c()) {
            i3 = 8;
        }
        formSwitchItem.setVisibility(i3);
        this.f176435c0.setChecked(this.f176433a0.b());
        this.f176435c0.setOnCheckedChangeListener(this.f176443k0);
        this.f176437e0.setOnCheckedChangeListener(null);
        this.f176437e0.setChecked(this.f176433a0.c());
        this.f176437e0.setOnCheckedChangeListener(this.f176443k0);
        int f16 = PraiseManager.f(this.app);
        if (f16 > 0) {
            this.f176434b0.h(this);
            com.tencent.mobileqq.profile.like.d g16 = this.f176434b0.g(f16, true, "from_like_setting");
            if (g16 != null) {
                int f17 = BaseAIOUtils.f(34.0f, super.getResources());
                this.f176438f0.setRightIcon(new BitmapDrawable(super.getResources(), g16.f260240h), f17, f17);
            }
        }
        this.f176438f0.setOnClickListener(this);
        this.f176439g0.setOnClickListener(this);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.LikeSettingActivity.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LikeSettingActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    LikeSettingActivity.this.runOnUiThread(new Runnable(LikeSettingActivity.this.app.getLocZanAllowedForPeople()) { // from class: com.tencent.mobileqq.activity.LikeSettingActivity.3.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f176444d;

                        {
                            this.f176444d = r6;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass3.this, Boolean.valueOf(r6));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            LikeSettingActivity.this.f176436d0.setOnCheckedChangeListener(null);
                            LikeSettingActivity.this.f176436d0.setChecked(this.f176444d);
                            LikeSettingActivity likeSettingActivity = LikeSettingActivity.this;
                            likeSettingActivity.f176436d0.setOnCheckedChangeListener(likeSettingActivity.f176443k0);
                        }
                    });
                }
            }
        }, 5, null, true);
    }
}
