package com.tencent.mobileqq.qrscan;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.PerfTracer;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private AppRuntime f276603a;

    /* renamed from: b, reason: collision with root package name */
    private final Activity f276604b;

    /* renamed from: c, reason: collision with root package name */
    private long f276605c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f276606d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f276607e;

    /* renamed from: f, reason: collision with root package name */
    private long f276608f;

    /* renamed from: g, reason: collision with root package name */
    private String f276609g;

    /* renamed from: h, reason: collision with root package name */
    private ScannerParams f276610h;

    /* renamed from: i, reason: collision with root package name */
    private JSONObject f276611i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f276612j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f276613k;

    public b(Activity activity, AppRuntime appRuntime, String str, long j3, boolean z16, boolean z17, long j16, boolean z18, boolean z19, JSONObject jSONObject, ScannerParams scannerParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, appRuntime, str, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j16), Boolean.valueOf(z18), Boolean.valueOf(z19), jSONObject, scannerParams);
            return;
        }
        this.f276604b = activity;
        this.f276603a = appRuntime;
        this.f276605c = j3;
        this.f276606d = z16;
        this.f276607e = z17;
        this.f276608f = j16;
        this.f276609g = str;
        this.f276610h = scannerParams;
        this.f276611i = jSONObject;
        this.f276613k = z18;
        this.f276612j = z19;
    }

    public void a() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.f276604b, RouterConstants.UI_ROUTE_SCAN_TORCH_ACTIVITY);
        activityURIRequest.setFlags(67174400);
        activityURIRequest.extra().putLong(PerfTracer.PARAM_CLICK_TIME, this.f276605c);
        activityURIRequest.extra().putLong(QZoneHelper.Constants.KEY_LAUNCH_TIME, System.currentTimeMillis());
        activityURIRequest.extra().putBoolean("first_click", this.f276607e);
        activityURIRequest.extra().putBoolean("proc_exist", this.f276606d);
        activityURIRequest.extra().putBoolean("preload_process", this.f276612j);
        activityURIRequest.extra().putBoolean("wait_process_load", this.f276613k);
        activityURIRequest.extra().putBoolean("software", this.f276604b.getSharedPreferences("immerse_ar", 0).getBoolean("software", false));
        activityURIRequest.extra().putBoolean(ScanTorchActivity.KEY_LOG_NO, com.tencent.mobileqq.olympic.activity.d.f255224a);
        Bundle extra = activityURIRequest.extra();
        IQRScanAbilityApi iQRScanAbilityApi = (IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class);
        AppRuntime appRuntime = this.f276603a;
        extra.putString("CurrentNickname", iQRScanAbilityApi.getFriendDisplayNameJustCache(appRuntime, appRuntime.getCurrentAccountUin()));
        activityURIRequest.extra().putBoolean("from_qr", true);
        activityURIRequest.extra().putInt("key_entrance_type", this.f276604b.getIntent().getIntExtra("key_entrance_type", 0));
        if (!"Conversation".equals(this.f276609g) && !"web-ar".equals(this.f276609g) && !ZPlanPublishSource.FROM_SCHEME.equals(this.f276609g)) {
            z16 = false;
        } else {
            z16 = true;
        }
        activityURIRequest.extra().putBoolean("ar_enabled", z16);
        activityURIRequest.extra().putBoolean("hide_album", this.f276604b.getIntent().getBooleanExtra("hide_album", false));
        activityURIRequest.extra().putString("from", this.f276609g);
        if (TextUtils.equals("web-ar", this.f276609g) && this.f276604b.getIntent() != null) {
            activityURIRequest.extra().putLong(PerfTracer.PARAM_CLICK_TIME, this.f276604b.getIntent().getLongExtra(PerfTracer.PARAM_CLICK_TIME, this.f276605c));
            activityURIRequest.extra().putInt(ScanTorchActivity.KEY_URL_FROM_WEB_SWITCH, this.f276604b.getIntent().getIntExtra(ScanTorchActivity.KEY_URL_FROM_WEB_SWITCH, 0));
            activityURIRequest.extra().putBoolean(ScanTorchActivity.KEY_JUMP_FROM_WEB, this.f276604b.getIntent().getBooleanExtra(ScanTorchActivity.KEY_JUMP_FROM_WEB, true));
            activityURIRequest.extra().putString(ScanTorchActivity.KEY_ICON_TEXT, this.f276604b.getIntent().getStringExtra(ScanTorchActivity.KEY_ICON_TEXT));
            activityURIRequest.extra().putString("icon_url", this.f276604b.getIntent().getStringExtra("icon_url"));
        }
        activityURIRequest.extra().putLong("start_time", this.f276608f);
        if (this.f276611i != null) {
            activityURIRequest.extra().putString("qr_report_param", this.f276611i.toString());
        }
        if (this.f276610h != null) {
            activityURIRequest.extra().putParcelable("scanner_param", this.f276610h);
        }
        Bundle bundleExtra = this.f276604b.getIntent().getBundleExtra("web_invoke_params");
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        activityURIRequest.extra().putBundle("web_invoke_params", bundleExtra);
        activityURIRequest.setOverridePendingTransition(0, 0);
        activityURIRequest.setRequestCode(10);
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }
}
