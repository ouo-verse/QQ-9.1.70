package com.tencent.mobileqq.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.AppRuntime;
import mqq.app.WtloginPrivacyListenerImpl;
import mqq.app.WtloginReportListenerImpl;
import mqq.app.WtloginSwitchListenerImpl;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DataMigrationService extends Service {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Handler f194589d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataMigrationService.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.arg1;
            Intent intent = (Intent) message.obj;
            if (intent == null) {
                DataMigrationService.this.stopSelf(i3);
            } else if ("com.tencent.mobileqq.action.MIGRATION_DATA".equals(intent.getAction())) {
                DataMigrationService.this.c(intent, i3);
            } else {
                DataMigrationService.this.stopSelf(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b extends WtloginListener {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f194591b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f194592c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f194593d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f194594e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f194595f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ WtloginHelper f194596g;

        b(String str, String str2, String str3, int i3, int i16, WtloginHelper wtloginHelper) {
            this.f194591b = str;
            this.f194592c = str2;
            this.f194593d = str3;
            this.f194594e = i3;
            this.f194595f = i16;
            this.f194596g = wtloginHelper;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DataMigrationService.this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), wtloginHelper);
            }
        }

        @Override // oicq.wlogin_sdk.request.WtloginListener
        public void OnException(ErrMsg errMsg, int i3, WUserSigInfo wUserSigInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, errMsg, Integer.valueOf(i3), wUserSigInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DataMigrationService", 2, "sendActionAfterGetTicket| OnException=" + errMsg + ", cmd=" + i3);
            }
            DataMigrationService.this.d(this.f194591b, this.f194592c, this.f194593d, this.f194594e, null, this.f194595f);
        }

        @Override // oicq.wlogin_sdk.request.WtloginListener
        public void onGetA1WithA1(String str, long j3, int i3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, int i16, ErrMsg errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), bArr, Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), bArr2, bArr3, wUserSigInfo, wFastLoginInfo, Integer.valueOf(i16), errMsg);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DataMigrationService", 2, "sendActionAfterGetTicket| onGetA1WithA1 ret=" + i16);
            }
            if (i16 != 0) {
                DataMigrationService.this.d(this.f194591b, this.f194592c, this.f194593d, this.f194594e, null, this.f194595f);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DataMigrationService", 2, "sendActionAfterGetTicket| send action");
            }
            DataMigrationService.this.d(this.f194591b, this.f194592c, this.f194593d, this.f194594e, this.f194596g.PrepareQloginResult(str, j18, j19, i16, wFastLoginInfo), this.f194595f);
        }
    }

    public DataMigrationService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f194589d = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Intent intent, int i3) {
        boolean z16;
        String stringExtra = intent.getStringExtra("com.tencent.mobileqq.extra.PACKAGE_NAME");
        String stringExtra2 = intent.getStringExtra("com.tencent.mobileqq.extra.ACTIVITY_NAME");
        String stringExtra3 = intent.getStringExtra("com.tencent.mobileqq.extra.SERVICE_NAME");
        int intExtra = intent.getIntExtra("com.tencent.mobileqq.extra_TASK_ID", 0);
        boolean booleanExtra = intent.getBooleanExtra("com.tencent.mobileqq.extra.CHECK_WHITELIST", true);
        if (TextUtils.isEmpty(stringExtra2) && TextUtils.isEmpty(stringExtra3)) {
            QLog.e("DataMigrationService", 2, "handleActionMigrationData| no valid component...");
            stopSelf(i3);
            return;
        }
        if (booleanExtra && TextUtils.isEmpty(getApplication().getSharedPreferences("data_migration_tim", 0).getString("data_migration_tim_uins", ""))) {
            if (QLog.isColorLevel()) {
                QLog.d("DataMigrationService", 2, "handleActionMigrationData| not in whitelist");
            }
            stopSelf(i3);
            return;
        }
        if (AppConstants.TIM_PACKAGE_NAME.equals(stringExtra) && PackageUtil.verifyInstalledApp(this, AppConstants.TIM_PACKAGE_NAME, AppConstants.TIM_SIG_MD5)) {
            e(AppConstants.TIM_PACKAGE_NAME, stringExtra2, stringExtra3, intExtra, i3);
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DataMigrationService", 2, stringExtra, " verify success: ", Boolean.valueOf(z16));
        }
        if (!z16) {
            stopSelf(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, String str3, int i3, Intent intent, int i16) {
        String str4;
        int i17;
        String str5 = "com.tencent.mobileqq.fileprovider";
        if (QLog.isColorLevel()) {
            QLog.d("DataMigrationService", 2, "sendAction");
        }
        List<SimpleAccount> loginedAccountList = MsfSdkUtils.getLoginedAccountList();
        if (loginedAccountList != null && !loginedAccountList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<SimpleAccount> it = loginedAccountList.iterator();
            while (it.hasNext()) {
                String uin = it.next().getUin();
                File databasePath = getDatabasePath(uin + DBBackupServiceImpl.DB_FILE_SUFFIX);
                if (QLog.isDevelopLevel()) {
                    QLog.d("DataMigrationService", 4, "db path=", databasePath.getPath(), ", exist=", Boolean.valueOf(databasePath.exists()));
                }
                if (databasePath.exists()) {
                    arrayList.add(uin);
                    arrayList2.add(databasePath);
                }
            }
            if (arrayList.isEmpty()) {
                stopSelf(i16);
                return;
            }
            SharedPreferences sharedPreferences = getApplication().getSharedPreferences("data_migration_tim", 0);
            boolean z16 = sharedPreferences.getBoolean("data_migration_tim_uninstall_flag", false);
            String string = sharedPreferences.getString("data_migration_tim_title", "");
            String string2 = sharedPreferences.getString("data_migration_tim_content", "");
            boolean z17 = sharedPreferences.getBoolean("data_migration_tim_uninstall_notify", false);
            String string3 = sharedPreferences.getString("data_migration_tim_uninstall_title", "");
            String str6 = "DataMigrationService";
            String string4 = sharedPreferences.getString("data_migration_tim_uninstall_content", "");
            int size = arrayList.size();
            Intent intent2 = new Intent();
            intent2.putExtra("com.tencent.mobileqq.extra_TASK_ID", i3);
            intent2.putExtra("com.tencent.mobileqq.UNINSTALL_FLAG", z16);
            intent2.putExtra("com.tencent.mobileqq.MIGRATION_TITLE", string);
            intent2.putExtra("com.tencent.mobileqq.MIGRATION_CONTENT", string2);
            intent2.putExtra("com.tencent.mobileqq.UNINSTALL_FLAG", z17);
            intent2.putExtra("com.tencent.mobileqq.UNINSTALL_TITLE", string3);
            intent2.putExtra("com.tencent.mobileqq.UNINSTALL_CONTENT", string4);
            intent2.putExtra("com.tencent.mobileqq.FILE_NUMBER", size);
            if (intent != null) {
                intent2.putExtras(intent);
            }
            StringBuilder sb5 = new StringBuilder();
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                sb5.append((String) it5.next());
            }
            String str7 = new String(SecurityUtile.getKey());
            String md5 = MD5.toMD5(MD5.toMD5(sb5.toString()) + "datamigration" + i3);
            String substring = md5.substring(0, 16);
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(md5.substring(md5.length() - 16, md5.length()).getBytes());
                SecretKeySpec secretKeySpec = new SecretKeySpec(substring.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                intent2.putExtra("com.tencent.mobileqq.CODE_KEY", Base64.encodeToString(cipher.doFinal(str7.getBytes()), 2));
                ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>();
                int i18 = 0;
                while (i18 < size) {
                    String str8 = (String) arrayList.get(i18);
                    File file = (File) arrayList2.get(i18);
                    String parent = file.getParent();
                    File file2 = new File(parent, file.getName() + "-journal");
                    File file3 = new File(parent, "slowtable_" + str8 + DBBackupServiceImpl.DB_FILE_SUFFIX);
                    Uri uriForFile = FileProvider.getUriForFile(this, str5, file);
                    Uri uriForFile2 = FileProvider.getUriForFile(this, str5, file2);
                    Uri uriForFile3 = FileProvider.getUriForFile(this, str5, file3);
                    grantUriPermission(str, uriForFile, 1);
                    grantUriPermission(str, uriForFile2, 1);
                    grantUriPermission(str, uriForFile3, 1);
                    String str9 = str5;
                    if (QLog.isDevelopLevel()) {
                        i17 = size;
                        str4 = str6;
                        try {
                            QLog.d(str4, 4, "db uri: ", uriForFile, ", journal: ", uriForFile2);
                        } catch (Exception e16) {
                            e = e16;
                            e.printStackTrace();
                            QLog.e(str4, 2, "Encrypt or start activity fail: " + e.getMessage());
                            stopSelf(i16);
                            return;
                        }
                    } else {
                        i17 = size;
                        str4 = str6;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("com.tencent.mobileqq.UIN", str8);
                    bundle.putInt("com.tencent.mobileqq.CURRENT_NUMBER", i18);
                    bundle.putLong("com.tencent.mobileqq.FILE_LENGTH", file.length());
                    bundle.putParcelable("com.tencent.mobileqq.URI", uriForFile);
                    bundle.putParcelable("com.tencent.mobileqq.JOURNAL_URI", uriForFile2);
                    bundle.putParcelable("com.tencent.mobileqq.SLOW_URI", uriForFile3);
                    arrayList3.add(bundle);
                    i18++;
                    arrayList = arrayList;
                    str6 = str4;
                    arrayList2 = arrayList2;
                    size = i17;
                    str5 = str9;
                }
                intent2.putParcelableArrayListExtra("com.tencent.mobileqq.DATA_BOX", arrayList3);
                if (!TextUtils.isEmpty(str2)) {
                    intent2.setComponent(new ComponentName(str, str2));
                    intent2.addFlags(268435456);
                    startActivity(intent2);
                } else {
                    intent2.setComponent(new ComponentName(str, str3));
                    startService(intent2);
                }
            } catch (Exception e17) {
                e = e17;
                str4 = str6;
            }
            stopSelf(i16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DataMigrationService", 2, "no login account available");
        }
        stopSelf(i16);
    }

    public void e(String str, String str2, String str3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DataMigrationService", 2, "sendActionAfterGetTicket");
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && !TextUtils.isEmpty(runtime.getAccount())) {
            WtloginHelper.setReportListener(WtloginReportListenerImpl.getSingleton());
            WtloginHelper.setSwitchListener(WtloginSwitchListenerImpl.getSingleton());
            WtloginHelper wtloginHelper = new WtloginHelper((Context) this, (PrivacyListener) WtloginPrivacyListenerImpl.getSingleton());
            wtloginHelper.SetTimeOut(20);
            wtloginHelper.SetMsfTransportFlag(1);
            wtloginHelper.SetListener(new b(str, str2, str3, i3, i16, wtloginHelper));
            int GetA1WithA1 = wtloginHelper.GetA1WithA1(runtime.getAccount(), 16L, 16L, AppConstants.TIM_PACKAGE_NAME.getBytes(), 1L, 16L, 16L, AppSetting.f99551k.getBytes(), util.getPkgSigFromApkName(this, AppConstants.TIM_PACKAGE_NAME), new WUserSigInfo(), new WFastLoginInfo());
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("source", "DataMigrationService");
                QQBeaconReport.report(runtime.getAccount(), "wtlogin_invalid_init", hashMap);
            } catch (Exception e16) {
                QLog.e("DataMigrationService", 1, e16, new Object[0]);
            }
            if (QLog.isColorLevel()) {
                QLog.d("DataMigrationService", 2, "sendActionAfterGetTicket| retCode=", Integer.valueOf(GetA1WithA1), ", account=", runtime.getAccount());
            }
            if (GetA1WithA1 != -1001) {
                d(str, str2, str3, i3, null, i16);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DataMigrationService", 2, "sendActionAfterGetTicket| app null or no account");
        }
        d(str, str2, str3, i3, null, i16);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        }
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, intent, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        Message obtainMessage = this.f194589d.obtainMessage();
        obtainMessage.arg1 = i16;
        obtainMessage.obj = intent;
        this.f194589d.sendMessage(obtainMessage);
        return 2;
    }
}
