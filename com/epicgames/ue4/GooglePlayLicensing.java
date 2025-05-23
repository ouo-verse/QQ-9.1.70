package com.epicgames.ue4;

import com.google.android.vending.licensing.LicenseChecker;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* loaded from: classes2.dex */
public class GooglePlayLicensing {
    public static GooglePlayLicensing GoogleLicensing;
    private static final byte[] SALT = {-46, 65, 30, Byte.MIN_VALUE, -103, -57, 74, -64, 51, 88, -95, -45, 77, -117, -36, -113, -11, 32, -64, 89};
    private Logger Log;
    private GameActivity gameActivity;
    private LicenseChecker mChecker;
    private com.google.android.vending.licensing.d mLicenseCheckerCallback;

    /* loaded from: classes2.dex */
    private class MyLicenseCheckerCallback implements com.google.android.vending.licensing.d {
        MyLicenseCheckerCallback() {
        }

        @Override // com.google.android.vending.licensing.d
        public void allow(int i3) {
            if (!GooglePlayLicensing.this.gameActivity.isFinishing()) {
                GooglePlayLicensing.this.Log.debug("Game is Licensed version. Allowing access.");
            }
        }

        @Override // com.google.android.vending.licensing.d
        public void applicationError(int i3) {
            if (!GooglePlayLicensing.this.gameActivity.isFinishing()) {
                String num = Integer.toString(i3);
                GooglePlayLicensing.this.Log.debug("ERROR: " + num);
            }
        }

        @Override // com.google.android.vending.licensing.d
        public void dontAllow(int i3) {
            if (!GooglePlayLicensing.this.gameActivity.isFinishing()) {
                GooglePlayLicensing.this.Log.debug("***************Game is not licensed!");
            }
        }
    }

    public void CheckLicense(String str) {
        this.Log.debug("Attempting to validate Google Play License.");
        String string = DeviceInfoMonitor.getString(this.gameActivity.getApplicationContext().getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
        this.mLicenseCheckerCallback = new MyLicenseCheckerCallback();
        LicenseChecker licenseChecker = new LicenseChecker(this.gameActivity.getApplicationContext(), new com.google.android.vending.licensing.k(this.gameActivity.getApplicationContext(), new com.google.android.vending.licensing.a(SALT, this.gameActivity.getApplicationContext().getPackageName(), string)), str);
        this.mChecker = licenseChecker;
        licenseChecker.f(this.mLicenseCheckerCallback);
    }

    public void Init(GameActivity gameActivity, Logger logger) {
        this.gameActivity = gameActivity;
        this.Log = logger;
    }

    public void onDestroy() {
        LicenseChecker licenseChecker = this.mChecker;
        if (licenseChecker != null) {
            licenseChecker.m();
        }
    }
}
