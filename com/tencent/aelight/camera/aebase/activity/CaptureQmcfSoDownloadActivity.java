package com.tencent.aelight.camera.aebase.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aelight.camera.aebase.fragment.CaptureQmcfSoDownloadFragment;
import com.tencent.aelight.camera.api.IQIMCameraCapture;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import gq.c;
import hs.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CaptureQmcfSoDownloadActivity extends BaseActivity implements a {

    /* renamed from: g0, reason: collision with root package name */
    public static final String f66019g0 = "CaptureQmcfSoDownloadActivity";

    /* renamed from: a0, reason: collision with root package name */
    private String f66020a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f66021b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f66022c0;

    /* renamed from: d0, reason: collision with root package name */
    private BaseFragment f66023d0;

    /* renamed from: e0, reason: collision with root package name */
    private Bundle f66024e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f66025f0 = js.a.f410904d.b();

    public static void launch(Context context, String str, Bundle bundle) {
        Intent intent = new Intent(context, (Class<?>) CaptureQmcfSoDownloadActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("pendingIntentClass", str);
        K2(intent);
        context.startActivity(intent);
    }

    public static void launchForResult(Activity activity, String str, Bundle bundle, int i3) {
        Intent intent = new Intent(activity, (Class<?>) CaptureQmcfSoDownloadActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("pendingIntentClass", str);
        intent.putExtra("pendingIntentRequest", i3);
        K2(intent);
        activity.startActivityForResult(intent, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        if (this.f66022c0) {
            setResult(i16, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.getWindow().addFlags(128);
        super.getWindow().addFlags(256);
        super.getWindow().addFlags(512);
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        this.isClearCoverLayer = false;
        super.doOnCreate(bundle);
        super.setContentView(R.layout.asj);
        this.f66023d0 = new CaptureQmcfSoDownloadFragment();
        this.f66020a0 = getIntent().getStringExtra("pendingIntentClass");
        FragmentTransaction beginTransaction = super.getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.f163958dp, this.f66023d0);
        beginTransaction.commit();
        boolean hasExtra = getIntent().hasExtra("pendingIntentRequest");
        this.f66022c0 = hasExtra;
        if (hasExtra) {
            this.f66021b0 = getIntent().getIntExtra("pendingIntentRequest", 0);
        }
        Bundle extras = getIntent().getExtras();
        this.f66024e0 = extras;
        if (extras != null) {
            this.f66025f0 = extras.getInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, this.f66025f0);
        }
        ms.a.f(f66019g0, "\u3010Activity doOnCreate\u3011");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        ms.a.f(f66019g0, "\u3010Activity doOnDestroy\u3011");
    }

    @Override // hs.a
    public void onFinish() {
        if (!getIntent().getBooleanExtra("key_wait_download_result", false)) {
            QLog.d("qqBaseActivity", 4, "in launch.");
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aebase.activity.CaptureQmcfSoDownloadActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BaseActivity.sTopActivity instanceof CaptureQmcfSoDownloadActivity) {
                        QLog.d("qqBaseActivity", 4, "is top activity, hasRequest: " + CaptureQmcfSoDownloadActivity.this.f66022c0);
                        CaptureQmcfSoDownloadActivity.this.f66024e0.putString("KEY_ISENTER_SO_DOWNLOAD", "true");
                        if (CaptureQmcfSoDownloadActivity.this.f66025f0 != js.a.O.b()) {
                            if (CaptureQmcfSoDownloadActivity.this.f66022c0) {
                                if (CaptureQmcfSoDownloadActivity.this.f66023d0 instanceof CaptureQmcfSoDownloadFragment) {
                                    ((CaptureQmcfSoDownloadFragment) CaptureQmcfSoDownloadActivity.this.f66023d0).Eh();
                                } else {
                                    ms.a.c(CaptureQmcfSoDownloadActivity.f66019g0, "[onFinish]soDownloadFragment not instanceof CaptureQmcfSoDownloadFragment");
                                }
                                IQIMCameraCapture iQIMCameraCapture = (IQIMCameraCapture) QRoute.api(IQIMCameraCapture.class);
                                CaptureQmcfSoDownloadActivity captureQmcfSoDownloadActivity = CaptureQmcfSoDownloadActivity.this;
                                iQIMCameraCapture.launchForResult(captureQmcfSoDownloadActivity, captureQmcfSoDownloadActivity.f66024e0, CaptureQmcfSoDownloadActivity.this.f66021b0);
                                return;
                            }
                            ms.a.c(CaptureQmcfSoDownloadActivity.f66019g0, "[onFinish]hasRequest false");
                            IQIMCameraCapture iQIMCameraCapture2 = (IQIMCameraCapture) QRoute.api(IQIMCameraCapture.class);
                            CaptureQmcfSoDownloadActivity captureQmcfSoDownloadActivity2 = CaptureQmcfSoDownloadActivity.this;
                            iQIMCameraCapture2.launch(captureQmcfSoDownloadActivity2, captureQmcfSoDownloadActivity2.f66024e0);
                            CaptureQmcfSoDownloadActivity.this.finish();
                            return;
                        }
                        IAECameraLauncher iAECameraLauncher = (IAECameraLauncher) QRoute.api(IAECameraLauncher.class);
                        CaptureQmcfSoDownloadActivity captureQmcfSoDownloadActivity3 = CaptureQmcfSoDownloadActivity.this;
                        iAECameraLauncher.launchAEMultiCamera(captureQmcfSoDownloadActivity3, captureQmcfSoDownloadActivity3.f66024e0);
                        CaptureQmcfSoDownloadActivity.this.finish();
                        return;
                    }
                    ms.a.c(CaptureQmcfSoDownloadActivity.f66019g0, "[onFinish]BaseActivity.sTopActivity not instanceof CaptureQmcfSoDownloadActivity");
                }
            }, 5L);
        } else {
            ms.a.c(f66019g0, "[onFinish] getBooleanExtra(KEY_JUST_WAIT_DOWNLOAD_RESULT");
            setResult(-1, null);
            finish();
        }
    }

    private static void K2(Intent intent) {
        if (intent == null) {
            return;
        }
        intent.putExtra("downloadSDKSourceTime", System.currentTimeMillis());
    }

    public static void launch(Context context, String str, Bundle bundle, boolean z16) {
        Intent intent = new Intent(context, (Class<?>) CaptureQmcfSoDownloadActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("pendingIntentClass", str);
        intent.putExtra("pendingIntentAllWait", z16);
        K2(intent);
        int i3 = bundle.getInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
        if (i3 == js.a.f410915o.b() || i3 == js.a.f410914n.b()) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void launchForResult(Activity activity, String str, Bundle bundle, int i3, boolean z16) {
        Intent intent = new Intent(activity, (Class<?>) CaptureQmcfSoDownloadActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("pendingIntentClass", str);
        intent.putExtra("pendingIntentRequest", i3);
        intent.putExtra("pendingIntentAllWait", z16);
        if (c.k(bundle)) {
            intent.addFlags(603979776);
        }
        K2(intent);
        activity.startActivityForResult(intent, i3);
    }

    public static void launchForResult(Context context, String str, Bundle bundle, int i3, boolean z16) {
        Intent intent = new Intent(context, (Class<?>) CaptureQmcfSoDownloadActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("pendingIntentClass", str);
        intent.putExtra("pendingIntentRequest", i3);
        intent.putExtra("pendingIntentAllWait", z16);
        if (c.k(bundle)) {
            intent.addFlags(603979776);
        }
        if (!(context instanceof Activity) && Build.VERSION.SDK_INT < 24) {
            intent.addFlags(268435456);
        }
        K2(intent);
        context.startActivity(intent);
    }

    public static void launchForResult(Activity activity, String str, Bundle bundle, int i3, boolean z16, boolean z17) {
        Intent intent = new Intent(activity, (Class<?>) CaptureQmcfSoDownloadActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("pendingIntentClass", str);
        intent.putExtra("pendingIntentRequest", i3);
        intent.putExtra("pendingIntentAllWait", z16);
        intent.putExtra("key_wait_download_result", z17);
        K2(intent);
        activity.startActivityForResult(intent, i3);
    }
}
