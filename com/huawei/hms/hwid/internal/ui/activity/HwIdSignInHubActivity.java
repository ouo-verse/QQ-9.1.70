package com.huawei.hms.hwid.internal.ui.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.hwid.ao;
import com.huawei.hms.hwid.ar;
import com.huawei.hms.hwid.as;
import com.huawei.hms.hwid.f;
import com.huawei.hms.hwid.q;
import com.huawei.hms.hwid.s;
import com.huawei.hms.hwid.y;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.api.entity.hwid.HuaweiIdSignInRequest;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService;
import com.huawei.hms.ui.SafeIntent;
import com.huawei.hms.utils.HMSPackageManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HwIdSignInHubActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private String f37323a = null;

    /* renamed from: b, reason: collision with root package name */
    private boolean f37324b = false;

    /* renamed from: c, reason: collision with root package name */
    private HuaweiIdSignInRequest f37325c = null;

    /* renamed from: d, reason: collision with root package name */
    private HuaweiIdAuthResult f37326d = null;

    /* renamed from: e, reason: collision with root package name */
    private s f37327e;

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "startSignInActivity", true);
        try {
            startActivityForResult(c(), 16587);
        } catch (ActivityNotFoundException e16) {
            this.f37324b = true;
            as.d("[HUAWEIIDSDK]HwIdSignInClientHub", "Launch sign in Intent failed. hms is probably being updated\uff1a" + e16.getClass().getSimpleName(), true);
            a(17);
        }
    }

    private Intent c() {
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "getJosSignInIntent", true);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("HUAWEIID_CP_CLIENTINFO");
        String stringExtra2 = intent.getStringExtra("HUAWEIID_SIGNIN_REQUEST");
        String action = intent.getAction();
        try {
            s a16 = s.a(stringExtra);
            ForegroundIntentBuilder kitSdkVersion = new ForegroundIntentBuilder(this).setAction(action).setRequestBody(stringExtra2).setKitSdkVersion(60400300);
            if (a16.c() != null) {
                kitSdkVersion.setSubAppId(a16.c());
            }
            Intent build = kitSdkVersion.build();
            as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "get package name of hms is " + HMSPackageManager.getInstance(this).getHMSPackageName(), true);
            as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "Current package name is " + getPackageName(), true);
            build.setPackage(getPackageName());
            return build;
        } catch (Exception e16) {
            as.d("[HUAWEIIDSDK]HwIdSignInClientHub", "getSignInIntent failed because:" + e16.getClass().getSimpleName(), true);
            return new Intent();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i16, Intent intent) {
        SafeIntent safeIntent;
        String stringExtra;
        s sVar;
        super.onActivityResult(i3, i16, intent);
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "onActivityResult: requestCode\uff1a" + i3 + " , resultCode\uff1a" + i16, true);
        if (intent != null) {
            safeIntent = new SafeIntent(intent);
        } else {
            safeIntent = null;
        }
        if (!this.f37324b && i3 == 16587) {
            int i17 = 8;
            if (safeIntent != null && (stringExtra = intent.getStringExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID)) != null) {
                try {
                    this.f37326d = new HuaweiIdAuthResult().fromJson(stringExtra);
                    y.a().a(this.f37326d.getHuaweiId(), this.f37325c.getHuaweiIdAuthParams());
                    i17 = this.f37326d.getStatus().getStatusCode();
                } catch (JSONException unused) {
                    this.f37326d = null;
                    as.d("[HUAWEIIDSDK]HwIdSignInClientHub", "onActivityResult: JsonException", true);
                }
                int i18 = i17;
                String str = this.f37323a;
                if (str != null && (sVar = this.f37327e) != null) {
                    HiAnalyticsClient.reportExit(this, CommonNaming.signinIntent, str, sVar.a(), ar.a(i18), i18, (int) this.f37327e.b());
                    as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "report: api=hwid.signinintentversion=" + this.f37327e.b(), true);
                }
                setResult(i16, safeIntent);
                finish();
                return;
            }
            if (i16 <= 0) {
                i16 = 8;
            }
            a(i16);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "onCreate", true);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (a(intent)) {
            a(0, "invalid intent");
        }
        boolean booleanExtra = intent.getBooleanExtra("intent.extra.isfullscreen", false);
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "isActivityFullScreen is :" + booleanExtra, true);
        if (booleanExtra) {
            f.a(getWindow());
            getWindow().setFlags(1024, 1024);
        } else {
            f.a(this);
        }
        String action = intent.getAction();
        if (!TextUtils.equals("com.huawei.hms.jos.signIn", action)) {
            String str = "unknow Action:";
            if (action != null) {
                str = "unknow Action:" + action;
            }
            a(0, str);
        }
        String stringExtra = intent.getStringExtra("HUAWEIID_CP_CLIENTINFO");
        try {
            this.f37325c = HuaweiIdSignInRequest.fromJson(intent.getStringExtra("HUAWEIID_SIGNIN_REQUEST"));
        } catch (JSONException unused) {
            this.f37325c = null;
            as.d("[HUAWEIIDSDK]HwIdSignInClientHub", "onCreate: JsonException", true);
        }
        if (TextUtils.isEmpty(stringExtra)) {
            a(0, "Activity started with invalid cp client info");
            return;
        }
        try {
            this.f37327e = s.a(stringExtra);
        } catch (JSONException unused2) {
            this.f37327e = null;
            as.d("[HUAWEIIDSDK]HwIdSignInClientHub", "onCreate: JsonException", true);
        }
        if (this.f37325c != null && this.f37327e != null) {
            ao.a(this);
            if (bundle != null) {
                restoreInstanceState(bundle);
                return;
            } else {
                this.f37323a = HiAnalyticsClient.reportEntry(this, CommonNaming.signinIntent, 60400300);
                a();
                return;
            }
        }
        a(0, "Activity started with invalid sign in request info");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String str = this.f37323a;
        if (str != null && bundle != null) {
            bundle.putString("HiAnalyticsTransId", str);
        }
    }

    protected void restoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.f37323a = bundle.getString("HiAnalyticsTransId");
        }
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:759)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:838)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:711)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    private boolean a(android.content.Intent r3) {
        /*
            r2 = this;
            r0 = 1
            if (r3 != 0) goto L4
            goto Lb
        L4:
            java.lang.String r1 = "ANYTHING"
            r3.getStringExtra(r1)     // Catch: java.lang.Exception -> Lb
            r0 = 0
        Lb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hwid.internal.ui.activity.HwIdSignInHubActivity.a(android.content.Intent):boolean");
    }

    private void a(int i3, String str) {
        as.d("[HUAWEIIDSDK]HwIdSignInClientHub", str, true);
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3) {
        s sVar;
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "onSignInAccountFailed: retCode\uff1a" + i3, true);
        String str = this.f37323a;
        if (str != null && (sVar = this.f37327e) != null) {
            HiAnalyticsClient.reportExit(this, CommonNaming.signinIntent, str, sVar.a(), ar.a(i3), i3, (int) this.f37327e.b());
            as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "report: api=hwid.signinintentversion=" + this.f37327e.b(), true);
        }
        Status status = new Status(i3);
        HuaweiIdAuthResult huaweiIdAuthResult = new HuaweiIdAuthResult();
        huaweiIdAuthResult.setStatus(status);
        Intent intent = new Intent();
        try {
            intent.putExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID, huaweiIdAuthResult.toJson());
        } catch (JSONException unused) {
            as.d("[HUAWEIIDSDK]HwIdSignInClientHub", "convert result to json failed", true);
        }
        setResult(0, intent);
        finish();
    }

    private void a() {
        as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "checkMinVersion start.", true);
        q.a(this, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.hwid.internal.ui.activity.HwIdSignInHubActivity.1
            @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
            public void onComplete(int i3) {
                if (i3 == 0) {
                    as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "version check ok", true);
                    HwIdSignInHubActivity.this.b();
                } else {
                    as.b("[HUAWEIIDSDK]HwIdSignInClientHub", "version check failed", true);
                    HwIdSignInHubActivity.this.a(i3);
                }
            }
        });
    }
}
