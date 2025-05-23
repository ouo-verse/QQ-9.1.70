package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.j;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.profilecard.api.IProfileEditApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AgeSelectionActivity extends IphoneTitleBarActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private Calendar f174855a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f174856b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f174857c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f174858d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f174859e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f174860f0;

    /* renamed from: g0, reason: collision with root package name */
    private TextView f174861g0;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f174862h0;

    /* renamed from: i0, reason: collision with root package name */
    private TextView f174863i0;

    /* renamed from: j0, reason: collision with root package name */
    private ActionSheet f174864j0;

    /* renamed from: k0, reason: collision with root package name */
    j f174865k0;

    /* renamed from: l0, reason: collision with root package name */
    int f174866l0;

    /* renamed from: m0, reason: collision with root package name */
    int f174867m0;

    /* renamed from: n0, reason: collision with root package name */
    int f174868n0;

    /* renamed from: o0, reason: collision with root package name */
    int f174869o0;

    /* renamed from: p0, reason: collision with root package name */
    @Nullable
    private String f174870p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f174871q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f174872r0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AgeSelectionActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AgeSelectionActivity.this.V2();
                AgeSelectionActivity.this.finish();
                if ("VAL_FROM_STATUS_MSG_TAB".equals(AgeSelectionActivity.this.f174870p0)) {
                    com.tencent.mobileqq.onlinestatus.bv.a("0X800AF47");
                }
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements j.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AgeSelectionActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.j.a
        public void a(int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            if (!((IProfileEditApi) QRoute.api(IProfileEditApi.class)).checkoutBirthDayValid(i3, i16, i17)) {
                QQToastUtil.showQQToastInUiThread(1, "\u751f\u65e5\u5e94\u65e9\u4e8e\u5f53\u524d\u65e5\u671f");
                return;
            }
            AgeSelectionActivity ageSelectionActivity = AgeSelectionActivity.this;
            ageSelectionActivity.f174867m0 = i3;
            ageSelectionActivity.f174868n0 = i16;
            ageSelectionActivity.f174869o0 = i17;
            if (QLog.isColorLevel()) {
                QLog.d("AgeSelectionActivity", 2, String.format("onBirthdayChange newBirthdayYear:%s,newBirthdayMonth:%s,newBirthdayDay:%s", Integer.valueOf(AgeSelectionActivity.this.f174867m0), Integer.valueOf(AgeSelectionActivity.this.f174868n0), Integer.valueOf(AgeSelectionActivity.this.f174869o0)));
            }
            AgeSelectionActivity ageSelectionActivity2 = AgeSelectionActivity.this;
            ageSelectionActivity2.Q2(ageSelectionActivity2.f174867m0, ageSelectionActivity2.f174868n0, ageSelectionActivity2.f174869o0);
        }

        @Override // com.tencent.mobileqq.activity.j.a
        public void onConfirmBtClicked() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (AgeSelectionActivity.this.f174864j0 != null && AgeSelectionActivity.this.f174864j0.isShowing()) {
                AgeSelectionActivity.this.f174864j0.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements IProfileEditApi.BirthdayEditListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f174875a;

        c(int i3) {
            this.f174875a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AgeSelectionActivity.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi.BirthdayEditListener
        public void onConfirm(int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            if (i3 == this.f174875a) {
                return;
            }
            AgeSelectionActivity.this.f174866l0 = i3;
            if (i3 != 0) {
                int i18 = ((-65536) & i3) >>> 16;
                int i19 = (65280 & i3) >>> 8;
                int i26 = i3 & 255;
                if (!((IProfileEditApi) QRoute.api(IProfileEditApi.class)).checkoutBirthDayValid(i18, i19, i26)) {
                    QQToastUtil.showQQToastInUiThread(1, "\u751f\u65e5\u5e94\u65e9\u4e8e\u5f53\u524d\u65e5\u671f");
                    return;
                }
                AgeSelectionActivity ageSelectionActivity = AgeSelectionActivity.this;
                ageSelectionActivity.f174867m0 = i18;
                ageSelectionActivity.f174868n0 = i19;
                ageSelectionActivity.f174869o0 = i26;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AgeSelectionActivity", 2, String.format("onBirthdayChange newBirthdayYear:%s,newBirthdayMonth:%s,newBirthdayDay:%s", Integer.valueOf(AgeSelectionActivity.this.f174867m0), Integer.valueOf(AgeSelectionActivity.this.f174868n0), Integer.valueOf(AgeSelectionActivity.this.f174869o0)));
            }
            AgeSelectionActivity ageSelectionActivity2 = AgeSelectionActivity.this;
            ageSelectionActivity2.Q2(ageSelectionActivity2.f174867m0, ageSelectionActivity2.f174868n0, ageSelectionActivity2.f174869o0);
        }

        @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi.BirthdayEditListener
        public void onPrivacyUpdate(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                AgeSelectionActivity.this.f174871q0 = i3;
                if (i3 != 2) {
                    AgeSelectionActivity.this.f174861g0.setText(AgeSelectionActivity.this.f174859e0 + HardCodeUtil.qqStr(R.string.j8k));
                    AgeSelectionActivity.this.f174861g0.setTextColor(AgeSelectionActivity.this.getResources().getColor(R.color.qui_common_text_primary));
                    return;
                }
                AgeSelectionActivity.this.f174861g0.setText(AgeSelectionActivity.this.getResources().getString(R.string.f175922zv));
                AgeSelectionActivity.this.f174861g0.setTextColor(AgeSelectionActivity.this.getResources().getColor(R.color.qui_common_text_secondary));
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements IProfileEditApi.BirthdayEditListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f174877a;

        d(int i3) {
            this.f174877a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AgeSelectionActivity.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi.BirthdayEditListener
        public void onConfirm(int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            if (i3 == this.f174877a) {
                return;
            }
            AgeSelectionActivity.this.f174866l0 = i3;
            if (i3 != 0) {
                int i18 = ((-65536) & i3) >>> 16;
                int i19 = (65280 & i3) >>> 8;
                int i26 = i3 & 255;
                if (!((IProfileEditApi) QRoute.api(IProfileEditApi.class)).checkoutBirthDayValid(i18, i19, i26)) {
                    QQToastUtil.showQQToastInUiThread(1, "\u751f\u65e5\u5e94\u65e9\u4e8e\u5f53\u524d\u65e5\u671f");
                    return;
                }
                AgeSelectionActivity ageSelectionActivity = AgeSelectionActivity.this;
                ageSelectionActivity.f174867m0 = i18;
                ageSelectionActivity.f174868n0 = i19;
                ageSelectionActivity.f174869o0 = i26;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AgeSelectionActivity", 2, String.format("onBirthdayChange newBirthdayYear:%s,newBirthdayMonth:%s,newBirthdayDay:%s", Integer.valueOf(AgeSelectionActivity.this.f174867m0), Integer.valueOf(AgeSelectionActivity.this.f174868n0), Integer.valueOf(AgeSelectionActivity.this.f174869o0)));
            }
            AgeSelectionActivity ageSelectionActivity2 = AgeSelectionActivity.this;
            ageSelectionActivity2.Q2(ageSelectionActivity2.f174867m0, ageSelectionActivity2.f174868n0, ageSelectionActivity2.f174869o0);
        }

        @Override // com.tencent.mobileqq.profilecard.api.IProfileEditApi.BirthdayEditListener
        public void onPrivacyUpdate(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                AgeSelectionActivity.this.f174872r0 = i3;
                if (i3 == 2) {
                    AgeSelectionActivity.this.f174862h0.setText(AgeSelectionActivity.this.getResources().getString(R.string.f175922zv));
                    AgeSelectionActivity.this.f174862h0.setTextColor(AgeSelectionActivity.this.getResources().getColor(R.color.qui_common_text_secondary));
                    return;
                } else {
                    AgeSelectionActivity.this.f174862h0.setText(String.format(Locale.getDefault(), "%d\u6708%d\u65e5", Integer.valueOf(AgeSelectionActivity.this.f174868n0), Integer.valueOf(AgeSelectionActivity.this.f174869o0)));
                    AgeSelectionActivity.this.f174862h0.setTextColor(AgeSelectionActivity.this.getResources().getColor(R.color.qui_common_text_primary));
                    return;
                }
            }
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
    }

    public AgeSelectionActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f174871q0 = 0;
            this.f174872r0 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q2(int i3, int i16, int i17) {
        this.f174859e0 = this.f174856b0 - i3;
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i16, i17);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(1, this.f174857c0, this.f174858d0);
        if (calendar.after(calendar2)) {
            this.f174859e0--;
        }
        if (this.f174859e0 < 0) {
            this.f174859e0 = 0;
        }
        if (this.f174871q0 == 2) {
            this.f174861g0.setText(getResources().getString(R.string.f175922zv));
            this.f174861g0.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        } else {
            this.f174861g0.setText(this.f174859e0 + HardCodeUtil.qqStr(R.string.j8k));
            this.f174861g0.setTextColor(getResources().getColor(R.color.qui_common_text_primary));
        }
        if (this.f174872r0 == 2) {
            this.f174862h0.setText(getResources().getString(R.string.f175922zv));
            this.f174862h0.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        } else {
            this.f174862h0.setText(this.f174868n0 + "\u6708" + this.f174869o0 + "\u65e5");
            this.f174862h0.setTextColor(getResources().getColor(R.color.qui_common_text_primary));
        }
        String t16 = Utils.t(i16, i17);
        this.f174860f0 = t16;
        this.f174863i0.setText(t16);
    }

    private boolean R2() {
        if (!"VAL_FROM_STATUS_MSG_TAB".equals(this.f174870p0) && !"VAL_FROM_STATUS_SETTING".equals(this.f174870p0)) {
            return false;
        }
        return true;
    }

    public static int S2(String str) {
        return Arrays.asList(NearbyProfileUtil.f306395d).indexOf(str);
    }

    private void T2(int i3, int i16) {
        ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).openProfileAgeSelector(this, i3, i16, new c(i3));
    }

    private void U2(int i3, int i16) {
        ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).openProfileBirthdaySelector(this, i3, i16, new d(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V2() {
        Q2(this.f174867m0, this.f174868n0, this.f174869o0);
        Intent intent = new Intent();
        intent.putExtra("param_age", this.f174859e0);
        intent.putExtra("param_constellation_id", S2(this.f174860f0));
        intent.putExtra("param_constellation", this.f174860f0);
        intent.putExtra("param_year", (short) this.f174867m0);
        intent.putExtra("param_month", (byte) this.f174868n0);
        intent.putExtra("param_day", (byte) this.f174869o0);
        intent.putExtra("param_age_privacy", this.f174871q0);
        intent.putExtra("param_birth_privacy", this.f174872r0);
        setResult(-1, intent);
    }

    private void W2() {
        if ("VAL_FROM_PROFILE_EDIT".equals(this.f174870p0)) {
            T2(this.f174866l0, this.f174871q0);
            return;
        }
        if (this.f174864j0 == null) {
            this.f174865k0 = new j(getBaseContext(), this.f174866l0, false);
            ActionSheet createMenuSheet = ActionSheet.createMenuSheet(this);
            this.f174864j0 = createMenuSheet;
            createMenuSheet.setCloseAutoRead(true);
            this.f174864j0.setActionContentView(this.f174865k0.n(), null);
            DispatchActionMoveScrollView dispatchActionMoveScrollView = (DispatchActionMoveScrollView) this.f174864j0.findViewById(R.id.f163936cz);
            dispatchActionMoveScrollView.dispatchActionMove = true;
            dispatchActionMoveScrollView.setBackgroundResource(17170445);
            Window window = this.f174864j0.getWindow();
            if (window != null) {
                window.setFlags(16777216, 16777216);
            }
            this.f174865k0.r(new b());
        }
        if (!this.f174864j0.isShowing()) {
            try {
                this.f174864j0.show();
            } catch (Exception unused) {
            }
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.aqp);
        this.f174870p0 = getIntent().getStringExtra("param_launch_from");
        this.f174871q0 = getIntent().getIntExtra("param_age_privacy", 0);
        this.f174872r0 = getIntent().getIntExtra("param_birth_privacy", 0);
        this.f174861g0 = (TextView) findViewById(R.id.f164061is);
        this.f174862h0 = (TextView) findViewById(R.id.t7x);
        this.f174863i0 = (TextView) findViewById(R.id.b7w);
        findViewById(R.id.f164063ix).setOnClickListener(this);
        if ("VAL_FROM_PROFILE_EDIT".equals(this.f174870p0)) {
            View findViewById = findViewById(R.id.t89);
            findViewById.setOnClickListener(this);
            findViewById.setVisibility(0);
        }
        findViewById(R.id.b7x).setOnClickListener(this);
        setTitle(HardCodeUtil.qqStr(R.string.j8h));
        setLeftViewName(R.string.f170549u3);
        if (R2()) {
            setRightButton(R.string.b9f, new a());
        }
        Calendar calendar = Calendar.getInstance();
        this.f174855a0 = calendar;
        calendar.setTimeInMillis(System.currentTimeMillis());
        this.f174856b0 = this.f174855a0.get(1);
        this.f174857c0 = this.f174855a0.get(2) + 1;
        this.f174858d0 = this.f174855a0.get(5);
        if (QLog.isColorLevel()) {
            QLog.d("AgeSelectionActivity", 2, String.format("doOnCreate date : %s-%s-%s ", Integer.valueOf(this.f174856b0), Integer.valueOf(this.f174857c0), Integer.valueOf(this.f174858d0)));
        }
        int intExtra = getIntent().getIntExtra("param_birthday", 0);
        this.f174866l0 = intExtra;
        this.f174867m0 = 2000;
        this.f174868n0 = 1;
        this.f174869o0 = 1;
        if (intExtra > 0) {
            this.f174867m0 = ((-65536) & intExtra) >>> 16;
            this.f174868n0 = (65280 & intExtra) >>> 8;
            this.f174869o0 = intExtra & 255;
        }
        Q2(this.f174867m0, this.f174868n0, this.f174869o0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!R2()) {
            V2();
        } else if ("VAL_FROM_STATUS_MSG_TAB".equals(this.f174870p0)) {
            com.tencent.mobileqq.onlinestatus.bv.a("0X800AF46");
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.f164063ix) {
                W2();
            } else if (id5 == R.id.b7x || id5 == R.id.t89) {
                U2(this.f174866l0, this.f174872r0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
