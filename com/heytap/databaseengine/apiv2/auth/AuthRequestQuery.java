package com.heytap.databaseengine.apiv2.auth;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.apiv2._HeytapHealth;
import com.heytap.databaseengine.apiv2.common.util.InstallUtils;
import com.heytap.databaseengine.constant.AppType;
import com.heytap.databaseengine.utils.HLog;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AuthRequestQuery {
    public static final String EXTRA_AUTH_CODE = "extra_auth_code";
    public static final String EXTRA_LAUNCH_TYPE = "extra_launch_type";
    public static final String EXTRA_OPEN_ID = "extra_open_id";
    public static final String EXTRA_SSOID = "extra_ssoid";
    public static final String EXTRA_THIRD_PACKAGE_NAME = "extra_third_package_name";
    public static final String EXTRA_THIRD_REDIRECT_URL = "extra_third_redirect_url";
    private static final String TAG = "AuthRequestQuery";
    public static final int THIRD_AUTH = 10;
    private final HResponse<AuthResult> mCallback;
    private final Context mContext;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.heytap.databaseengine.apiv2.auth.AuthRequestQuery.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AuthRequestQuery.this.mCallback != null) {
                try {
                    int intExtra = intent.getIntExtra("status", 100012);
                    String stringExtra = intent.getStringExtra(AuthRequestQuery.EXTRA_AUTH_CODE);
                    String stringExtra2 = intent.getStringExtra(AuthRequestQuery.EXTRA_OPEN_ID);
                    String stringExtra3 = intent.getStringExtra(AuthRequestQuery.EXTRA_SSOID);
                    HLog.i(AuthRequestQuery.TAG, "status is " + intExtra);
                    if (intExtra != 0) {
                        AuthRequestQuery.this.mCallback.onFailure(intExtra);
                    } else {
                        AuthRequestQuery.this.mCallback.onSuccess(new AuthResult(intExtra, stringExtra2, stringExtra, stringExtra3));
                    }
                } catch (Exception e16) {
                    HLog.e(AuthRequestQuery.TAG, e16.toString());
                }
            }
            AuthRequestQuery.this.mContext.unregisterReceiver(this);
        }
    };
    private final String mRedirectUrl;

    public AuthRequestQuery(Activity activity, String str, HResponse<AuthResult> hResponse) {
        this.mContext = activity.getApplicationContext();
        this.mRedirectUrl = str;
        this.mCallback = hResponse;
    }

    private boolean isLogin() {
        try {
            Cursor query = ContactsMonitor.query(this.mContext.getContentResolver(), Uri.parse("content://com.heytap.health.sporthealthprovider/open/loginStatus"), new String[0], null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i3 = query.getInt(0);
                        query.close();
                        boolean z16 = true;
                        if (i3 != 1) {
                            z16 = false;
                        }
                        query.close();
                        return z16;
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e16) {
            HLog.e(TAG, e16.toString());
        }
        return false;
    }

    @SuppressLint({"HealthLint_AndroidReceiverDetector"})
    private void registerReceive() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.heytap.health.auth.broadcast");
        if (Build.VERSION.SDK_INT >= 33) {
            this.mContext.registerReceiver(this.mReceiver, intentFilter, 4);
        } else {
            this.mContext.registerReceiver(this.mReceiver, intentFilter);
        }
    }

    public void realRun() {
        String str;
        registerReceive();
        try {
            if (!InstallUtils.isAppInstalled(this.mContext, AppType.HEALTH_PACKAGE_NAME)) {
                this.mCallback.onFailure(100007);
                return;
            }
            if (InstalledAppListMonitor.getPackageInfo(_HeytapHealth.getContext().getPackageManager(), AppType.HEALTH_PACKAGE_NAME, 0).versionCode < 3180000) {
                this.mCallback.onFailure(100008);
                return;
            }
            if (!isLogin()) {
                this.mCallback.onFailure(100004);
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(AppType.HEALTH_PACKAGE_NAME, "com.heytap.health.router.RouterActivity");
            intent.putExtra(EXTRA_LAUNCH_TYPE, 10);
            HLog.i(TAG, "third app info send");
            String packageName = this.mContext.getPackageName();
            if (TextUtils.isEmpty(this.mRedirectUrl)) {
                str = "";
            } else {
                str = this.mRedirectUrl;
            }
            intent.putExtra(EXTRA_THIRD_REDIRECT_URL, str);
            intent.putExtra(EXTRA_THIRD_PACKAGE_NAME, packageName);
            intent.setFlags(268435456);
            this.mContext.getApplicationContext().startActivity(intent);
            HLog.i(TAG, "call health app finish.");
        } catch (PackageManager.NameNotFoundException e16) {
            this.mCallback.onFailure(100007);
            HLog.e(TAG, e16.getMessage());
        } catch (IllegalStateException e17) {
            this.mCallback.onFailure(100003);
            HLog.e(TAG, e17.getMessage());
        }
    }
}
