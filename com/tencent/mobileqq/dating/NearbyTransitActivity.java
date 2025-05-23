package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ad;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ap;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import mqq.os.MqqHandler;
import tencent.im.oidb.hotchat.Common$WifiPOIInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NearbyTransitActivity extends BaseActivity implements Handler.Callback, DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    static IPatchRedirector $redirector_;

    /* renamed from: n0, reason: collision with root package name */
    public static final String f203366n0;

    /* renamed from: o0, reason: collision with root package name */
    private static long f203367o0;

    /* renamed from: p0, reason: collision with root package name */
    public static long f203368p0;

    /* renamed from: q0, reason: collision with root package name */
    public static long f203369q0;

    /* renamed from: a0, reason: collision with root package name */
    private int f203370a0;

    /* renamed from: b0, reason: collision with root package name */
    private MqqHandler f203371b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f203372c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f203373d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f203374e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f203375f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f203376g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f203377h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f203378i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f203379j0;

    /* renamed from: k0, reason: collision with root package name */
    protected ap f203380k0;

    /* renamed from: l0, reason: collision with root package name */
    protected int f203381l0;

    /* renamed from: m0, reason: collision with root package name */
    long f203382m0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71483);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f203366n0 = HardCodeUtil.qqStr(R.string.n_n);
        f203367o0 = 0L;
        f203368p0 = 0L;
        f203369q0 = 0L;
    }

    public NearbyTransitActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f203377h0 = true;
        this.f203378i0 = 0;
        this.f203379j0 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G2() {
        I2("doAction", 1);
        f.j("NearbyTransitActivity", "doAction", Boolean.valueOf(this.f203372c0));
    }

    private void H2(String str, String str2, String str3) {
        Intent intent;
        boolean z16;
        I2("enterAIO", 1);
        if (this.f203370a0 > 0) {
            intent = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
            intent.putExtra("uin", str);
            intent.putExtra("uintype", 1);
            intent.putExtra("troop_uin", str2);
            intent.putExtra("uinname", str3);
        } else {
            intent = new Intent(this, (Class<?>) ChatActivity.class);
            intent.putExtra("uin", str);
            intent.putExtra("uintype", 1);
            intent.putExtra("troop_uin", str2);
            intent.putExtra("uinname", str3);
            intent.addFlags(67108864);
            intent.putExtra("is_from_web", true);
            intent.putExtra("is_new_add", true);
            String stringExtra = getIntent().getStringExtra("newly_created");
            if (stringExtra != null && "1".equals(stringExtra)) {
                z16 = true;
            } else {
                z16 = false;
            }
            intent.putExtra("param_newly_created_hot_chat", z16);
            intent.putExtra("hotnamecode", getIntent().getStringExtra("hotnamecode"));
            intent.putExtra("HOTCHAT_EXTRA_FLAG", this.f203378i0);
            if ("10002".equals(this.f203373d0)) {
                intent.putExtra("abp_flag", true);
                intent.addFlags(268435456);
            }
        }
        startActivity(intent);
        long currentTimeMillis = System.currentTimeMillis() - this.f203382m0;
        if (currentTimeMillis > 0) {
            L2(this.app.getCurrentAccountUin(), true, currentTimeMillis, 0);
        }
        finish();
    }

    public static void J2(Context context, String str, int i3, HashMap<String, String> hashMap) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        I2("openNearbyTransitActivity", 0);
        long abs = Math.abs(System.currentTimeMillis() - f203367o0);
        if (context != null) {
            if ((abs < 0 || abs >= 800) && hashMap != null) {
                f203367o0 = System.currentTimeMillis();
                if (!hashMap.containsKey(ISchemeApi.KEY_IOS_SRC_TYPE)) {
                    str2 = "";
                } else {
                    str2 = hashMap.get(ISchemeApi.KEY_IOS_SRC_TYPE);
                }
                if (!hashMap.containsKey("from_type")) {
                    str3 = "";
                } else {
                    str3 = hashMap.get("from_type");
                }
                if (!hashMap.containsKey("from")) {
                    str4 = "";
                } else {
                    str4 = hashMap.get("from");
                }
                if (!hashMap.containsKey("version")) {
                    str5 = "";
                } else {
                    str5 = hashMap.get("version");
                }
                if (!hashMap.containsKey("onwall")) {
                    str6 = "";
                } else {
                    str6 = hashMap.get("onwall");
                }
                if (!hashMap.containsKey("nonelbs")) {
                    str7 = "";
                } else {
                    str7 = hashMap.get("nonelbs");
                }
                if (!hashMap.containsKey("fissile")) {
                    str8 = "";
                    str9 = str8;
                } else {
                    str9 = hashMap.get("fissile");
                    str8 = "";
                }
                if (hashMap.containsKey("newly_created")) {
                    str10 = hashMap.get("newly_created");
                } else {
                    str10 = str8;
                }
                Intent intent = new Intent(context, (Class<?>) NearbyTransitActivity.class);
                intent.putExtra(ISchemeApi.KEY_IOS_SRC_TYPE, str2);
                intent.putExtra("from_type", str3);
                intent.putExtra("from", str4);
                intent.putExtra("version", str5);
                intent.putExtra("action", i3);
                intent.putExtra("hotnamecode", str);
                intent.putExtra("newly_created", str10);
                intent.putExtra("onwall", str6);
                intent.putExtra("nonelbs", str7);
                intent.putExtra("fissile", str9);
                intent.putExtra("enter_time", System.currentTimeMillis());
                context.startActivity(intent);
            }
        }
    }

    private void K2() {
        f.j("NearbyTransitActivity", "parseParams");
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        this.f203373d0 = extras.getString("from");
        this.f203374e0 = extras.getInt("action");
        this.f203376g0 = extras.getString("params");
        if (this.f203374e0 == 1) {
            this.f203375f0 = intent.getExtras().getString("hotnamecode");
        }
        if ("1".equals(extras.getString("onwall"))) {
            this.f203378i0 |= 2;
        }
        if ("1".equals(extras.getString("nonelbs"))) {
            this.f203377h0 = false;
        }
        if ("1".equals(extras.getString("fissile"))) {
            this.f203379j0 = 1;
        }
        this.f203382m0 = intent.getLongExtra("enter_time", System.currentTimeMillis());
        this.f203380k0 = new ap(this, R.layout.f168851b15);
        this.f203381l0 = getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        this.f203372c0 = false;
        this.f203371b0 = new ad(Looper.getMainLooper(), this);
    }

    public static void L2(String str, boolean z16, long j3, int i3) {
        if (QLog.isDevelopLevel()) {
            l.c("NearbyTransitActivity", "reportResult", Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
        }
        ThreadManager.getSubThreadHandler().post(new Runnable(i3, str, z16, j3) { // from class: com.tencent.mobileqq.dating.NearbyTransitActivity.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f203383d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f203384e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f203385f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ long f203386h;

            {
                this.f203383d = i3;
                this.f203384e = str;
                this.f203385f = z16;
                this.f203386h = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Boolean.valueOf(z16), Long.valueOf(j3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_FailCode", String.valueOf(this.f203383d));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f203384e, "actEnterHotChatAIO", this.f203385f, this.f203386h, this.f203383d, hashMap, "");
                if (QLog.isDevelopLevel()) {
                    l.c("NearbyTransitActivity", "reportResult", "end of report");
                }
            }
        });
    }

    protected void M2(Common$WifiPOIInfo common$WifiPOIInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) common$WifiPOIInfo);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        I2("doOnCreate", 1);
        super.doOnCreate(bundle);
        K2();
        if (this.f203374e0 == 1) {
            this.f203371b0.sendEmptyMessageDelayed(5, 800L);
            this.f203371b0.sendEmptyMessageDelayed(2, 30000L);
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.dating.NearbyTransitActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NearbyTransitActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    NearbyTransitActivity.this.G2();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        f.j("NearbyTransitActivity", "doOnDestroy");
        this.f203372c0 = true;
        this.f203371b0.removeCallbacksAndMessages(null);
        super.doOnDestroy();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) message)).booleanValue();
        }
        f.j("NearbyTransitActivity", "handleMessage", Integer.valueOf(message.what));
        int i16 = message.what;
        int i17 = 4;
        if (i16 != 1 && i16 != 2) {
            if (i16 != 3) {
                if (i16 != 4) {
                    if (i16 == 5 && this.f203380k0 != null) {
                        if (this.f203379j0 == 1) {
                            i3 = R.string.f171023bq4;
                        } else {
                            i3 = R.string.f171022bq3;
                        }
                        String string = getString(i3);
                        Object obj = message.obj;
                        if (obj != null && (obj instanceof String)) {
                            string = (String) obj;
                            l.b("NearbyTransitActivity", "handleMessage MSG_SHOW_LOADING ", string);
                        }
                        this.f203380k0.f(0, string, 0, this);
                    }
                } else {
                    M2((Common$WifiPOIInfo) message.obj);
                }
            } else {
                ap apVar = this.f203380k0;
                if (apVar != null) {
                    apVar.b();
                }
                Object[] objArr = (Object[]) message.obj;
                H2((String) objArr[0], (String) objArr[1], (String) objArr[2]);
                this.f203371b0.removeCallbacksAndMessages(null);
                finish();
            }
        } else {
            ap apVar2 = this.f203380k0;
            if (apVar2 != null) {
                apVar2.b();
            }
            int i18 = message.what;
            if (i18 == 2 || (message.obj instanceof String)) {
                if (i18 == 2) {
                    str = getString(R.string.bqf);
                } else {
                    str = f203366n0;
                }
                Object obj2 = message.obj;
                if (obj2 instanceof String) {
                    str = (String) obj2;
                }
                QQToast.makeText(BaseApplication.getContext(), str, 0).show(this.f203381l0);
            }
            this.f203371b0.removeCallbacksAndMessages(null);
            long currentTimeMillis = System.currentTimeMillis() - this.f203382m0;
            if (currentTimeMillis > 0) {
                String currentAccountUin = this.app.getCurrentAccountUin();
                if (message.what != 2) {
                    i17 = message.arg1;
                }
                L2(currentAccountUin, false, currentTimeMillis, i17);
            }
            finish();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = 3;
        this.f203371b0.sendMessage(obtain);
        return true;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) dialogInterface);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = 3;
        this.f203371b0.sendMessage(obtain);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) dialogInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }

    public static void I2(String str, int i3) {
    }
}
