package com.tencent.hippy.qq.utils;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import com.tencent.hippy.qq.api.MMKVCommonFileKeys;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.HippyDebugSoUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.AbiUtil;
import java.io.File;
import java.io.IOException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyDebugSoUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.hippy.qq.utils.HippyDebugSoUtil$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass1 extends com.tencent.mobileqq.vip.f {
        final /* synthetic */ String val$downloadMessage;
        final /* synthetic */ QQProgressDialog val$progressDialog;

        AnonymousClass1(QQProgressDialog qQProgressDialog, String str) {
            this.val$progressDialog = qQProgressDialog;
            this.val$downloadMessage = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onProgress$0(QQProgressDialog qQProgressDialog, String str, com.tencent.mobileqq.vip.g gVar) {
            qQProgressDialog.setMessage(str + gVar.f313015m);
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onCancel(com.tencent.mobileqq.vip.g gVar) {
            super.onCancel(gVar);
            HippyDebugSoUtil.onDownloadHippyDebugSoResult(this.val$progressDialog, false);
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            super.onDone(gVar);
            HippyDebugSoUtil.onDownloadFinished(this.val$progressDialog);
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onProgress(final com.tencent.mobileqq.vip.g gVar) {
            super.onProgress(gVar);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final QQProgressDialog qQProgressDialog = this.val$progressDialog;
            final String str = this.val$downloadMessage;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.hippy.qq.utils.h
                @Override // java.lang.Runnable
                public final void run() {
                    HippyDebugSoUtil.AnonymousClass1.lambda$onProgress$0(QQProgressDialog.this, str, gVar);
                }
            });
        }
    }

    private static com.tencent.mobileqq.vip.g createDownloadTask(String str, QQProgressDialog qQProgressDialog, String str2) {
        com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(str, getDebugSoZipFile(BaseApplication.getContext().getApplicationContext()));
        gVar.U = true;
        gVar.Q = true;
        gVar.W = true;
        gVar.u(new AnonymousClass1(qQProgressDialog, str2));
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void downloadHippyDebugSo(Activity activity) {
        Context applicationContext = BaseApplication.getContext().getApplicationContext();
        ensureDebugDirExists(applicationContext);
        if (isDebugSoExists(applicationContext)) {
            onDownloadHippyDebugSoResult(null, true);
        }
        File debugSoZipFile = getDebugSoZipFile(applicationContext);
        if (debugSoZipFile.exists()) {
            debugSoZipFile.delete();
        }
        String string = applicationContext.getResources().getString(R.string.zte);
        final com.tencent.mobileqq.vip.g createDownloadTask = createDownloadTask(HippyQQConstants.HIPPY_DEBUG_SO_URL, showProcessDialog(activity, string), string);
        final AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.utils.f
            @Override // java.lang.Runnable
            public final void run() {
                HippyDebugSoUtil.lambda$downloadHippyDebugSo$2(com.tencent.mobileqq.vip.g.this, waitAppRuntime);
            }
        }, 128, null, false);
    }

    private static void ensureDebugDirExists(Context context) {
        File file = new File(context.getFilesDir(), "hippy");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, HippyQQConstants.HIPPY_DEBUG_SO_DIR);
        if (!file2.exists()) {
            file2.mkdirs();
        }
    }

    private static File getDebugSoDir(Context context) {
        return new File(new File(context.getFilesDir(), "hippy"), HippyQQConstants.HIPPY_DEBUG_SO_DIR);
    }

    private static File getDebugSoZipFile(Context context) {
        return new File(new File(new File(context.getFilesDir(), "hippy"), HippyQQConstants.HIPPY_DEBUG_SO_DIR), HippyQQConstants.HIPPY_DEBUG_SO_DOWNLOAD_FILE_NAME);
    }

    private static boolean isDebugSoExists(Context context) {
        String str;
        File file = new File(new File(context.getFilesDir(), "hippy"), HippyQQConstants.HIPPY_DEBUG_SO_DIR);
        if (AbiUtil.isArm64Runtime(context)) {
            str = HippyQQConstants.HIPPY_DEBUG_SO_ARM64_DIR;
        } else {
            str = HippyQQConstants.HIPPY_DEBUG_SO_ARMEABI_DIR;
        }
        File file2 = new File(file, str + HippyQQConstants.HIPPY_LIB_HIPPY_DEBUG_SO);
        File file3 = new File(file, str + HippyQQConstants.HIPPY_LIB_FLEXBOX_DEBUG_SO);
        File file4 = new File(file, "corejs/vue.android.js");
        File file5 = new File(file, "corejs/react.android.js");
        if (file2.exists() && file3.exists() && file4.exists() && file5.exists()) {
            return true;
        }
        return false;
    }

    public static boolean isUseDebugSo() {
        if (!QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(MMKVCommonFileKeys.IS_USE_INSPECTOR, false) || !isDebugSoExists(BaseApplication.getContext())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$downloadHippyDebugSo$2(com.tencent.mobileqq.vip.g gVar, AppRuntime appRuntime) {
        ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(gVar, appRuntime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onDownloadHippyDebugSoResult$4(QQProgressDialog qQProgressDialog, boolean z16) {
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
        if (!z16) {
            QQToast.makeText(BaseApplication.getContext(), BaseApplication.getContext().getResources().getString(R.string.ztb), 0).show();
        } else {
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(MMKVCommonFileKeys.IS_USE_INSPECTOR, true).commitSync();
            restartApp(BaseApplication.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onDownloadFinished(final QQProgressDialog qQProgressDialog) {
        Context applicationContext = BaseApplication.getContext().getApplicationContext();
        File debugSoZipFile = getDebugSoZipFile(applicationContext);
        if (!debugSoZipFile.exists()) {
            onDownloadHippyDebugSoResult(qQProgressDialog, false);
            return;
        }
        try {
            final String string = applicationContext.getResources().getString(R.string.f237387gx);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.hippy.qq.utils.c
                @Override // java.lang.Runnable
                public final void run() {
                    QQProgressDialog.this.setMessage(string);
                }
            });
            FileUtils.uncompressZip(debugSoZipFile.getAbsolutePath(), getDebugSoDir(applicationContext).getAbsolutePath(), false);
            if (isDebugSoExists(BaseApplication.getContext().getApplicationContext())) {
                onDownloadHippyDebugSoResult(qQProgressDialog, true);
            } else {
                onDownloadHippyDebugSoResult(qQProgressDialog, false);
            }
        } catch (IOException unused) {
            onDownloadHippyDebugSoResult(qQProgressDialog, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onDownloadHippyDebugSoResult(final QQProgressDialog qQProgressDialog, final boolean z16) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.hippy.qq.utils.g
            @Override // java.lang.Runnable
            public final void run() {
                HippyDebugSoUtil.lambda$onDownloadHippyDebugSoResult$4(QQProgressDialog.this, z16);
            }
        });
    }

    private static void restartApp(Context context) {
        Context applicationContext = context.getApplicationContext();
        PendingIntent activity = PendingIntent.getActivity(applicationContext, 2333, InstalledAppListMonitor.getLaunchIntentForPackage(applicationContext.getPackageManager(), "com.tencent.mobileqq"), 301989888);
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            alarmManager.set(1, System.currentTimeMillis() + 3000, activity);
        }
        MobileQQ.sMobileQQ.qqProcessExit(true);
    }

    private static QQProgressDialog showProcessDialog(Activity activity, String str) {
        QQProgressDialog qQProgressDialog = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        qQProgressDialog.setMessage(str);
        qQProgressDialog.show();
        return qQProgressDialog;
    }

    public static void switchToDebugSo(final Activity activity) {
        Resources resources = activity.getResources();
        DialogUtil.createCustomDialog(activity, 0, (String) null, resources.getString(R.string.f230016y0), resources.getString(R.string.cancel), resources.getString(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.hippy.qq.utils.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                HippyDebugSoUtil.downloadHippyDebugSo(activity);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.hippy.qq.utils.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }).show();
    }
}
