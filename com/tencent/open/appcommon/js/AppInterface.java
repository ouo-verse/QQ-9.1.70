package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.base.j;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.downloadnew.MyAppDialog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AppInterface extends BaseInterface {
    protected static final String APP_UPDATE_TAG = "AppUpdate";
    public static final String PLUGIN_NAMESPACE = "qzone_app";
    private static final String TAG = "AppInterface";
    protected Activity activity;
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    protected MyAppDialog tipDialog;
    protected WebView webView;

    public AppInterface(Activity activity, WebView webView) {
        this.activity = activity;
        this.webView = webView;
    }

    public static String getImei() {
        return MobileInfoUtil.getImei();
    }

    public static String getImsi() {
        return MobileInfoUtil.getImsi();
    }

    public String gSetPackageScanSetting(String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals("2")) {
            if (!com.tencent.open.business.base.a.s(this.activity)) {
                return "0";
            }
            return "1";
        }
        if (str.equals("0")) {
            com.tencent.open.business.base.e.d("100", "ANDROIDQQ.STORE.UPDATECHECKBOX", "");
            final DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.open.appcommon.js.AppInterface.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    final String str3 = "";
                    if (i3 == R.string.ao5) {
                        com.tencent.open.business.base.e.d("200", "ANDROIDQQ.STORE.UPDATECHECKBOX", "");
                        SharedPreferences.Editor edit = com.tencent.open.adapter.a.f().e().getSharedPreferences("package_scan", 0).edit();
                        edit.putBoolean(AppConstants.Preferences.QQSETTING_PACKAGE_SCAN_FLAG, false);
                        edit.commit();
                        MyAppDialog myAppDialog = AppInterface.this.tipDialog;
                        if (myAppDialog != null && myAppDialog.isShowing()) {
                            AppInterface.this.tipDialog.dismiss();
                        }
                        str3 = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.gSetPackageScanSetting',{'guid':'" + str2 + "','r':'0','data':'0'});}void(0);";
                    } else if (i3 == R.string.f170843ao4) {
                        MyAppDialog myAppDialog2 = AppInterface.this.tipDialog;
                        if (myAppDialog2 != null && myAppDialog2.isShowing()) {
                            AppInterface.this.tipDialog.dismiss();
                        }
                        str3 = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.gSetPackageScanSetting',{'guid':'" + str2 + "','r':'0','data':'1'});}void(0);";
                    }
                    AppInterface.this.mHandler.post(new Runnable() { // from class: com.tencent.open.appcommon.js.AppInterface.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (AppInterface.this.webView != null && !TextUtils.isEmpty(str3)) {
                                    AppInterface.this.webView.loadUrl(str3);
                                }
                            } catch (Exception e16) {
                                com.tencent.open.base.f.b(AppInterface.TAG, "webview loadUrl>>> ", e16);
                            }
                        }
                    });
                }
            };
            this.mHandler.post(new Runnable() { // from class: com.tencent.open.appcommon.js.AppInterface.2

                /* compiled from: P */
                /* renamed from: com.tencent.open.appcommon.js.AppInterface$2$a */
                /* loaded from: classes22.dex */
                class a implements DialogInterface.OnDismissListener {
                    a() {
                    }

                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        AppInterface.this.tipDialog = null;
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Activity activity = AppInterface.this.activity;
                    if (activity != null) {
                        Resources resources = activity.getResources();
                        MyAppDialog myAppDialog = new MyAppDialog(AppInterface.this.activity);
                        myAppDialog.P(R.string.f170843ao4, onClickListener, true);
                        myAppDialog.W(R.string.ao5, onClickListener, true);
                        myAppDialog.X(resources.getString(R.string.ao8));
                        myAppDialog.Q(resources.getString(R.string.f170840ao1));
                        myAppDialog.setCancelable(false);
                        myAppDialog.setOnDismissListener(new a());
                        Activity activity2 = AppInterface.this.activity;
                        if (activity2 != null && !activity2.isFinishing()) {
                            myAppDialog.show();
                        }
                        AppInterface.this.tipDialog = myAppDialog;
                    }
                }
            });
        } else if (str.equals("1")) {
            SharedPreferences.Editor edit = com.tencent.open.adapter.a.f().e().getSharedPreferences("package_scan", 0).edit();
            edit.putBoolean(AppConstants.Preferences.QQSETTING_PACKAGE_SCAN_FLAG, true);
            edit.commit();
            return "1";
        }
        return null;
    }

    public String getAllDownAppInfo(String str, String str2, String str3) {
        if (!hasRight()) {
            return "baby,you don't have permission";
        }
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            PackageInfo packageInfo = (PackageInfo) arrayList.get(i3);
            if ((packageInfo.applicationInfo.flags & 1) == 0) {
                jSONArray.mo162put(getAppInfo(packageInfo, str, str2, str3));
            }
        }
        return jSONArray.toString();
    }

    public String getAppInfo(String str) {
        return !hasRight() ? "baby,you don't have permission" : getAppInfo(str, "true", "true", "true");
    }

    public String getAppInfoBatch(String str, String str2, String str3, String str4, String str5) {
        String[] f16;
        if (!hasRight()) {
            return "baby,you don't have permission";
        }
        if (j.d(str) || (f16 = j.f(str, str2)) == null || f16.length == 0) {
            return "{}";
        }
        JSONArray jSONArray = new JSONArray();
        PackageManager packageManager = this.activity.getPackageManager();
        for (String str6 : f16) {
            if (!TextUtils.isEmpty(str6) && PackageUtil.isAppInstalled(this.activity, str6)) {
                try {
                    jSONArray.mo162put(getAppInfo(InstalledAppListMonitor.getPackageInfo(packageManager, str6, 0), str3, str4, str5));
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        }
        return jSONArray.toString();
    }

    @Override // com.tencent.open.appcommon.js.BaseInterface
    public String getInterfaceName() {
        return PLUGIN_NAMESPACE;
    }

    protected String getRecentApp(int i3) {
        Intent intent;
        ComponentName componentName;
        String str;
        int i16;
        ActivityManager activityManager = (ActivityManager) this.activity.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        PackageManager packageManager = this.activity.getPackageManager();
        if (i3 <= 0) {
            i3 = 5;
        }
        List<ActivityManager.RecentTaskInfo> recentTasks = activityManager.getRecentTasks(64, 1);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{");
        if (recentTasks != null) {
            int size = recentTasks.size();
            int i17 = 0;
            for (int i18 = 0; i18 < size && i17 < i3; i18++) {
                ActivityManager.RecentTaskInfo recentTaskInfo = recentTasks.get(i18);
                intent = recentTaskInfo.baseIntent;
                componentName = recentTaskInfo.origActivity;
                if (componentName != null) {
                    str = componentName.getPackageName();
                } else if (intent != null) {
                    str = intent.getComponent().getPackageName();
                } else {
                    str = null;
                }
                if (str != null && !arrayList.contains(str)) {
                    arrayList.add(str);
                    try {
                        PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, str, 0);
                        if (packageInfo != null) {
                            int i19 = packageInfo.versionCode;
                            if ((packageInfo.applicationInfo.flags & 1) != 0) {
                                i16 = 1;
                            } else {
                                i16 = 0;
                            }
                            i17++;
                            sb5.append("\"");
                            sb5.append(str);
                            sb5.append("\"");
                            sb5.append(":");
                            sb5.append("\"");
                            sb5.append(i19);
                            sb5.append(",");
                            sb5.append(i16);
                            sb5.append("\"");
                            if (i18 < size - 1) {
                                sb5.append(",");
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }
        int length = sb5.length() - 1;
        if (sb5.charAt(length) == ',') {
            sb5.deleteCharAt(length);
        }
        sb5.append("}");
        return sb5.toString();
    }

    public int uninstallApp(String str) {
        if (!hasRight() || !com.tencent.open.business.base.a.z(this.activity, str)) {
            return -1;
        }
        return 0;
    }

    public String getAppInfo(String str, String str2, String str3, String str4) {
        PackageInfo packageInfo;
        try {
            return !hasRight() ? "baby,you don't have permission" : (j.d(str) || (packageInfo = InstalledAppListMonitor.getPackageInfo(this.activity.getPackageManager(), str, 0)) == null) ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : getAppInfo(packageInfo, str2, str3, str4).toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    protected JSONArray getAppInfo(PackageInfo packageInfo, String str, String str2, String str3) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (!"true".equals(str)) {
            if ("false".equals(str)) {
                z16 = false;
            }
            return null;
        }
        z16 = true;
        if (!"true".equals(str2)) {
            if ("false".equals(str2)) {
                z17 = false;
            }
            return null;
        }
        z17 = true;
        if (!"true".equals(str3)) {
            if ("false".equals(str3)) {
                z18 = false;
            }
            return null;
        }
        z18 = true;
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put(packageInfo.packageName);
        jSONArray.put(packageInfo.versionCode);
        jSONArray.mo162put(packageInfo.versionName);
        if (z16) {
            jSONArray.mo162put(packageInfo.applicationInfo.loadLabel(this.activity.getPackageManager()).toString());
        } else {
            jSONArray.mo162put("");
        }
        if (z17) {
            jSONArray.mo162put(com.tencent.open.base.d.a(packageInfo.applicationInfo.loadIcon(this.activity.getPackageManager())));
        } else {
            jSONArray.mo162put("");
        }
        if (z18) {
            if ((packageInfo.applicationInfo.flags & 262144) != 0) {
                jSONArray.put(1);
            } else {
                jSONArray.put(0);
            }
        } else {
            jSONArray.put(-1);
        }
        return jSONArray;
    }
}
