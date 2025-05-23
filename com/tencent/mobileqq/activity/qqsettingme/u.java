package com.tencent.mobileqq.activity.qqsettingme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.vaswebviewplugin.DailySignInWebviewPlugin;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;
import java.util.Calendar;
import java.util.Date;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class u extends com.tencent.mobileqq.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.a> f185021h;

    /* renamed from: i, reason: collision with root package name */
    private int f185022i;

    /* renamed from: j, reason: collision with root package name */
    private String f185023j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f185024k;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Observer<com.tencent.mobileqq.activity.qqsettingme.bean.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f185025d;

        a(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f185025d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) u.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.activity.qqsettingme.bean.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                return;
            }
            this.f185025d.x(aVar);
            QQSettingMeViewModel k3 = this.f185025d.k();
            if (k3 != null) {
                k3.f312705m.postValue(aVar);
            }
        }
    }

    public u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f185021h = new MutableLiveData<>();
        this.f185022i = -1;
        this.f185023j = null;
    }

    private void o(boolean z16) {
        String str;
        int i3;
        if (p().f184869a == 1 && this.f185022i != -1 && this.f185023j != null) {
            TianShuReportData tianShuReportData = new TianShuReportData();
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime != null) {
                str = runtime.getAccount();
            } else {
                str = "";
            }
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
            tianShuReportData.mTraceId = str + "_" + serverTimeMillis;
            tianShuReportData.mTraceNum = 1;
            if (z16) {
                i3 = 102;
            } else {
                i3 = 101;
            }
            tianShuReportData.mActionId = i3;
            tianShuReportData.mAppId = "tianshu.103";
            tianShuReportData.mPageId = "tianshu.103";
            tianShuReportData.mItemId = String.valueOf(this.f185022i);
            tianShuReportData.mActionValue = 1;
            tianShuReportData.mTriggerInfo = this.f185023j;
            tianShuReportData.mOperTime = serverTimeMillis;
            TianShuManager.getInstance().report(tianShuReportData);
        }
    }

    @NonNull
    private com.tencent.mobileqq.activity.qqsettingme.bean.a p() {
        if (this.f185021h.getValue() == null) {
            return new com.tencent.mobileqq.activity.qqsettingme.bean.a();
        }
        return this.f185021h.getValue();
    }

    private boolean q(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(j3));
        if (calendar2.get(1) == calendar.get(1) && calendar2.get(6) - calendar.get(6) == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(com.tencent.mobileqq.activity.qqsettingme.bean.a aVar) {
        this.f185021h.setValue(aVar);
        o(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s() {
        String str;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject;
        boolean z16;
        String str5;
        JSONObject jSONObject2;
        String str6 = DailySignInWebviewPlugin.TAG;
        final com.tencent.mobileqq.activity.qqsettingme.bean.a p16 = p();
        p16.f184873e = HardCodeUtil.qqStr(R.string.vvw);
        p16.f184874f = 0;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        SharedPreferences preferences = peekAppRuntime.getPreferences();
        long j3 = preferences.getLong("sign_in_time_stamp", 0L);
        String string = preferences.getString(peekAppRuntime.getCurrentUin() + "sign_in_info", "");
        try {
            JSONObject jSONObject3 = new JSONObject(string);
            p16.f184869a = jSONObject3.optInt("type");
            p16.f184874f = jSONObject3.optInt("day");
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.i(DailySignInWebviewPlugin.TAG, 2, "doUpdateDailySignInItemView JSONException, json = " + string);
            }
            e16.printStackTrace();
        }
        if (!q(j3 * 1000)) {
            p16.f184869a = 1;
            p16.f184874f = 0;
        }
        if (LocaleManager.getLocaleId() != 1033) {
            try {
                this.f185022i = -1;
                this.f185023j = null;
            } catch (JSONException e17) {
                e = e17;
                str = "doUpdateDailySignInItemView JSONException, json = ";
                str2 = DailySignInWebviewPlugin.TAG;
            }
            try {
                if (p16.f184869a != 1) {
                    str = "doUpdateDailySignInItemView JSONException, json = ";
                    str2 = DailySignInWebviewPlugin.TAG;
                    str3 = string;
                    p16.f184873e = HardCodeUtil.qqStr(R.string.f172477r32);
                    String string2 = preferences.getString(peekAppRuntime.getCurrentUin() + "sign_in_operation41", "");
                    if (TextUtils.isEmpty(string2)) {
                        str4 = "start_time";
                        String string3 = preferences.getString(peekAppRuntime.getCurrentUin() + "sign_in_operation40", "");
                        if (!TextUtils.isEmpty(string3)) {
                            jSONObject = new JSONObject(string3);
                            z16 = false;
                        }
                        z16 = false;
                        jSONObject = null;
                    } else {
                        JSONObject jSONObject4 = new JSONObject(string2);
                        str4 = "start_time";
                        long optInt = jSONObject4.optInt("end_time") * 1000;
                        if (System.currentTimeMillis() > jSONObject4.optInt(str4) * 1000 && System.currentTimeMillis() < optInt) {
                            jSONObject = jSONObject4;
                            z16 = true;
                        }
                        String string4 = preferences.getString(peekAppRuntime.getCurrentUin() + "sign_in_operation40", "");
                        if (!TextUtils.isEmpty(string4)) {
                            jSONObject = new JSONObject(string4);
                            z16 = false;
                        }
                        z16 = false;
                        jSONObject = null;
                    }
                } else {
                    String string5 = preferences.getString(peekAppRuntime.getCurrentUin() + "sign_in_operation11", "");
                    if (TextUtils.isEmpty(string5)) {
                        str = "doUpdateDailySignInItemView JSONException, json = ";
                        str2 = DailySignInWebviewPlugin.TAG;
                        str3 = string;
                        str5 = "start_time";
                        jSONObject2 = null;
                        String string6 = preferences.getString(peekAppRuntime.getCurrentUin() + "sign_in_operation10", "");
                        if (!TextUtils.isEmpty(string6)) {
                            jSONObject = new JSONObject(string6);
                            str4 = str5;
                            z16 = false;
                        }
                        jSONObject = jSONObject2;
                        str4 = str5;
                        z16 = false;
                    } else {
                        JSONObject jSONObject5 = new JSONObject(string5);
                        int optInt2 = jSONObject5.optInt("start_time");
                        str = "doUpdateDailySignInItemView JSONException, json = ";
                        str2 = DailySignInWebviewPlugin.TAG;
                        try {
                            str3 = string;
                            str5 = "start_time";
                            long optInt3 = jSONObject5.optInt("end_time") * 1000;
                            if (System.currentTimeMillis() > optInt2 * 1000 && System.currentTimeMillis() < optInt3) {
                                this.f185022i = jSONObject5.optInt("id", -1);
                                this.f185023j = jSONObject5.optString("trace_info", null);
                                jSONObject = jSONObject5;
                                str4 = str5;
                                z16 = true;
                            } else {
                                jSONObject2 = null;
                                String string7 = preferences.getString(peekAppRuntime.getCurrentUin() + "sign_in_operation10", "");
                                if (!TextUtils.isEmpty(string7)) {
                                    jSONObject = new JSONObject(string7);
                                    str4 = str5;
                                    z16 = false;
                                }
                                jSONObject = jSONObject2;
                                str4 = str5;
                                z16 = false;
                            }
                        } catch (JSONException e18) {
                            e = e18;
                            str3 = string;
                            if (!QLog.isColorLevel()) {
                            }
                            e.printStackTrace();
                            if (QLog.isColorLevel()) {
                            }
                            p16.f184870b = true;
                            if (p16.f184869a == 4) {
                            }
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.t
                                @Override // java.lang.Runnable
                                public final void run() {
                                    u.this.r(p16);
                                }
                            });
                        }
                    }
                }
                if (jSONObject != null) {
                    long optInt4 = jSONObject.optInt("end_time") * 1000;
                    if (System.currentTimeMillis() > jSONObject.optInt(str4) * 1000 && System.currentTimeMillis() < optInt4) {
                        p16.f184873e = jSONObject.optString("template_text");
                        String optString = jSONObject.optString("bytes_url");
                        if (z16) {
                            p16.f184871c = jSONObject.optString("bytes_icon_url");
                            p16.f184872d = jSONObject.optString("bytes_icon_custom_url");
                        } else {
                            p16.f184871c = "";
                            p16.f184872d = "";
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            preferences.edit().putString(peekAppRuntime.getCurrentUin() + "sign_in_jump_url", optString).commit();
                        }
                    }
                }
                str6 = str2;
            } catch (JSONException e19) {
                e = e19;
                if (!QLog.isColorLevel()) {
                    str6 = str2;
                    QLog.i(str6, 2, str + str3);
                } else {
                    str6 = str2;
                }
                e.printStackTrace();
                if (QLog.isColorLevel()) {
                }
                p16.f184870b = true;
                if (p16.f184869a == 4) {
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.this.r(p16);
                    }
                });
            }
        } else {
            int i3 = p16.f184869a;
            if (i3 == 1) {
                p16.f184873e = HardCodeUtil.qqStr(R.string.vvw);
            } else if (i3 == 4) {
                p16.f184873e = HardCodeUtil.qqStr(R.string.f172477r32);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(str6, 2, "doUpdateDailySignInItemView type=" + p16.f184869a + " iconUrl=" + p16.f184871c + " wording=" + p16.f184873e + " day=" + p16.f184874f + "coverIconUrl" + p16.f184872d);
        }
        p16.f184870b = true;
        if (p16.f184869a == 4) {
            if (QLog.isColorLevel()) {
                QLog.i(str6, 2, "use signed wording:" + p16.f184873e);
            }
            int i16 = p16.f184874f;
            if (i16 > 0) {
                p16.f184873e = String.format(p16.f184873e, Integer.valueOf(i16));
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.t
            @Override // java.lang.Runnable
            public final void run() {
                u.this.r(p16);
            }
        });
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ((QQAppInterface) peekAppRuntime).getSignInInfo(0);
        if (p().f184870b && !this.f185024k) {
            ReportController.y(peekAppRuntime, "0X800C4A1");
            this.f185024k = true;
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.f185021h.observe(this.f259743d, new a(aVar));
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.s
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.s();
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        if (p().f184870b) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String string = peekAppRuntime.getPreferences().getString(peekAppRuntime.getCurrentUin() + "sign_in_jump_url", "https://ti.qq.com/signin/public/index.html?_wv=1090528161&_wwv=13");
            Intent intent = new Intent(qBaseActivity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("portraitOnly", true);
            intent.putExtra("uin", peekAppRuntime.getCurrentAccountUin());
            intent.putExtra("hide_operation_bar", true);
            intent.putExtra("hide_more_button", true);
            intent.putExtra("big_brother_source_key", "biz_src_ad_daka");
            intent.putExtra("url", string);
            qBaseActivity.startActivity(intent);
            ReportController.y(peekAppRuntime, "0X800C4A2");
            o(true);
        } else {
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            String string2 = peekAppRuntime2.getApp().getSharedPreferences(AppConstants.Preferences.TASK_ENTRY_CONFIG + peekAppRuntime2.getCurrentAccountUin(), 0).getString("jump_url", "");
            Intent intent2 = new Intent(qBaseActivity, (Class<?>) QQBrowserActivity.class);
            intent2.putExtra("portraitOnly", true);
            intent2.putExtra("uin", peekAppRuntime2.getCurrentAccountUin());
            intent2.putExtra("hide_operation_bar", true);
            intent2.putExtra("hide_more_button", true);
            intent2.putExtra("big_brother_source_key", "biz_src_ad_daka");
            intent2.putExtra("url", string2);
            qBaseActivity.startActivity(intent2);
            ReportController.o(peekAppRuntime2, "dc00899", "Grp_duty", "", "locker", "clk", 0, 0, "", "", "", "");
        }
        if (QLog.isColorLevel()) {
            QLog.i(DailySignInWebviewPlugin.TAG, 2, "myDaily onClick mDailySignMode = " + p().f184870b);
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            e();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        e();
        TianShuManager.setLastClickAdTraceInfo("", "");
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_daily";
    }
}
