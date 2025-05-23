package com.tencent.qqmini.proxyimpl;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.app.AppBrandContant;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ec;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.base.ToastUtil;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.plugins.AudioRecorderJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ShortcutUtils {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f347568d;

        a(Activity activity) {
            this.f347568d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            com.tencent.av.utils.ba.openPermissionActivity(this.f347568d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public interface c {
        void a(int i3, String str);
    }

    public static int A() {
        ToastUtil.a().e("\u5df2\u6dfb\u52a0\u684c\u9762\u5feb\u6377\u65b9\u5f0f\uff0c\u5982\u672a\u6210\u529f\uff0c\u8bf7\u5728\u8bbe\u7f6e\u4e2d\u6253\u5f00\u3010\u684c\u9762\u5feb\u6377\u65b9\u5f0f\u3011\u6743\u9650\u5e76\u91cd\u65b0\u6dfb\u52a0");
        return 0;
    }

    public static boolean h() {
        return d.P();
    }

    public static int i(Context context) {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        if (lowerCase.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI)) {
            return j(context);
        }
        if (lowerCase.contains("xiaomi")) {
            return k(context);
        }
        if (lowerCase.contains("oppo")) {
            return l(context);
        }
        if (lowerCase.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) {
            return m(context);
        }
        return (lowerCase.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) || lowerCase.contains("meizu")) ? 0 : 3;
    }

    public static int j(Context context) {
        QLog.i("ShortcutUtils", 1, "checkOnEMUI");
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        try {
            Class<?> cls = Class.forName("com.huawei.hsm.permission.PermissionManager");
            boolean booleanValue = ((Boolean) cls.getDeclaredMethod("canSendBroadcast", Context.class, Intent.class).invoke(cls, context, intent)).booleanValue();
            QLog.i("ShortcutUtils", 1, "EMUI check permission canSendBroadcast invoke result = " + booleanValue);
            return booleanValue ? 0 : 1;
        } catch (Throwable th5) {
            QLog.i("ShortcutUtils", 1, th5.getMessage(), th5);
            return 3;
        }
    }

    public static int k(Context context) {
        QLog.i("ShortcutUtils", 1, "checkOnMIUI");
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            String packageName = context.getApplicationContext().getPackageName();
            int i3 = context.getApplicationInfo().uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Object invoke = cls.getDeclaredMethod(AudioRecorderJsPlugin.AudioManager.FUNCTION_NAME_CHECK_OP_NOT_THROW, cls2, cls2, String.class).invoke(appOpsManager, 10017, Integer.valueOf(i3), packageName);
            if (invoke == null) {
                QLog.i("ShortcutUtils", 1, "MIUI check permission checkOpNoThrowMethod(AppOpsManager) invoke result is null");
                return 3;
            }
            String obj = invoke.toString();
            int intValue = Integer.valueOf(obj).intValue();
            QLog.i("ShortcutUtils", 1, "MIUI check permission checkOpNoThrowMethod(AppOpsManager) invoke result = " + obj);
            if (intValue == 0) {
                return 0;
            }
            if (intValue != 1) {
                return intValue != 5 ? 3 : 2;
            }
            return 1;
        } catch (Throwable th5) {
            QLog.i("ShortcutUtils", 1, th5.getMessage(), th5);
            return 3;
        }
    }

    public static int l(Context context) {
        QLog.i("ShortcutUtils", 1, "checkOnOPPO");
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            QLog.i("ShortcutUtils", 1, "contentResolver is null");
            return 3;
        }
        Cursor query = ContactsMonitor.query(contentResolver, Uri.parse("content://settings/secure/launcher_shortcut_permission_settings"), null, null, null, null);
        try {
            if (query == null) {
                QLog.i("ShortcutUtils", 1, "cursor is null (Uri : content://settings/secure/launcher_shortcut_permission_settings)");
                return 3;
            }
            String packageName = context.getApplicationContext().getPackageName();
            while (query.moveToNext()) {
                int columnIndex = query.getColumnIndex("value");
                if (columnIndex >= 0) {
                    String string = query.getString(columnIndex);
                    QLog.i("ShortcutUtils", 1, "permission value is " + string);
                    if (TextUtils.isEmpty(string)) {
                        continue;
                    } else {
                        if (string.contains(packageName + ", 1")) {
                            query.close();
                            return 0;
                        }
                        if (string.contains(packageName + ", 0")) {
                            return 1;
                        }
                    }
                }
            }
            return 3;
        } catch (Exception e16) {
            QLog.i("ShortcutUtils", 1, e16.getMessage(), e16);
            return 3;
        } finally {
            query.close();
        }
    }

    public static int m(Context context) {
        Cursor cursor;
        QLog.i("ShortcutUtils", 1, "checkOnVIVO");
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            QLog.i("ShortcutUtils", 1, "contentResolver is null");
            return 3;
        }
        Uri parse = Uri.parse("content://com.bbk.launcher2.settings/favorites");
        if (!(context.checkSelfPermission("com.bbk.launcher2.permission.READ_SETTINGS") == 0)) {
            QLog.i("ShortcutUtils", 1, "cannot get com.bbk.launcher2.permission.READ_SETTINGS permission");
            return A();
        }
        try {
            cursor = ContactsMonitor.query(contentResolver, parse, null, null, null, null);
        } catch (Exception e16) {
            QLog.e("ShortcutUtils", 1, "shortcutUtils query error", e16);
            cursor = null;
        }
        if (cursor == null) {
            QLog.i("ShortcutUtils", 1, "cursor is null (Uri : content://com.bbk.launcher2.settings/favorites)");
            return 3;
        }
        while (cursor.moveToNext()) {
            try {
                try {
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                    QLog.i("ShortcutUtils", 1, "title by query is " + string);
                    if (!TextUtils.isEmpty(string) && string.equals(o(context))) {
                        int i3 = cursor.getInt(cursor.getColumnIndexOrThrow("shortcutPermission"));
                        QLog.i("ShortcutUtils", 1, "permission value is " + i3);
                        if (i3 == 1 || i3 == 17) {
                            return 1;
                        }
                        if (i3 == 16) {
                            return 0;
                        }
                        if (i3 == 18) {
                            cursor.close();
                            return 2;
                        }
                    }
                } catch (Exception e17) {
                    QLog.i("ShortcutUtils", 1, e17.getMessage(), e17);
                }
            } finally {
                cursor.close();
            }
        }
        return 3;
    }

    public static void n(final Activity activity, final MiniAppInfo miniAppInfo, final c cVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.bl
            @Override // java.lang.Runnable
            public final void run() {
                ShortcutUtils.w(activity, miniAppInfo, cVar);
            }
        }, 128, null, false);
    }

    private static String o(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, context.getApplicationContext().getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap p(Activity activity, URLDrawable uRLDrawable) {
        Bitmap drawableToBitmap = BaseImageUtil.drawableToBitmap(uRLDrawable);
        int max = Math.max(((ActivityManager) activity.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getLauncherLargeIconSize(), (int) activity.getResources().getDimension(R.dimen.app_icon_size));
        return BaseImageUtil.round(q(drawableToBitmap, max, max), (int) (max * 0.15d));
    }

    public static Bitmap q(Bitmap bitmap, int i3, int i16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i3 / width, i16 / height);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        bitmap.recycle();
        return createBitmap;
    }

    public static boolean r(Context context, String str) {
        return InstalledAppListMonitor.queryIntentActivities(context.getPackageManager(), new Intent(str), 65536).size() > 0;
    }

    public static boolean s(Activity activity, MiniAppInfo miniAppInfo) {
        if (Build.VERSION.SDK_INT >= 26) {
            return u(miniAppInfo.appId, (ShortcutManager) activity.getSystemService("shortcut"));
        }
        return ec.k(AppLoaderFactory.getMiniAppInterface().getApplication(), new String[]{miniAppInfo.name});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean t(Activity activity, MiniAppInfo miniAppInfo, ShortcutInfo shortcutInfo, PendingIntent pendingIntent) throws InterruptedException {
        boolean requestPinShortcut;
        if (Build.VERSION.SDK_INT >= 26) {
            requestPinShortcut = ((ShortcutManager) activity.getSystemService("shortcut")).requestPinShortcut(shortcutInfo, pendingIntent.getIntentSender());
            if (requestPinShortcut) {
                LockMethodProxy.sleep(1000L);
                return true;
            }
        } else if (ec.k(AppLoaderFactory.getMiniAppInterface().getApplication(), new String[]{miniAppInfo.name})) {
            ToastUtil.a().e(activity.getString(com.tencent.mobileqq.R.string.f170805zp3, miniAppInfo.name));
            return true;
        }
        return false;
    }

    private static boolean v(Activity activity) {
        boolean isRequestPinShortcutSupported;
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        isRequestPinShortcutSupported = ((ShortcutManager) activity.getSystemService("shortcut")).isRequestPinShortcutSupported();
        return isRequestPinShortcutSupported;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(Activity activity, MiniAppInfo miniAppInfo, c cVar) {
        if (s(activity, miniAppInfo)) {
            QLog.i("ShortcutUtils", 1, "Shortcut has created before!");
            ToastUtil.a().e(activity.getString(com.tencent.mobileqq.R.string.f227646rl, miniAppInfo.name));
            if (cVar != null) {
                cVar.a(0, HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.tg9));
                return;
            }
            return;
        }
        e eVar = new e(activity, miniAppInfo, cVar);
        if (v(activity)) {
            URLDrawable drawable = URLDrawable.getDrawable(URLDecoder.decode(miniAppInfo.iconUrl), (URLDrawable.URLDrawableOptions) null);
            if (drawable != null && drawable.getStatus() == 1) {
                eVar.onLoadSuccessed(drawable);
            } else if (drawable != null) {
                drawable.setURLDrawableListener(eVar);
                drawable.startDownload();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent x(Activity activity, MiniAppInfo miniAppInfo) {
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setClassName(activity, JumpActivity.class.getName());
        intent.putExtra("CONFIG_APPID", miniAppInfo.appId);
        intent.putExtra("CONFIG_APPNAME", miniAppInfo.name);
        intent.putExtra("CONFIG_APPICON", miniAppInfo.iconUrl);
        intent.putExtra("CONFIG_REPORTTYPE", miniAppInfo.getReportType());
        intent.putExtra("CONFIG_ENGINETYPE", miniAppInfo.getEngineType());
        intent.putExtra("MINI_CONFIG_SCENE", 1023);
        intent.putExtra("MINI_CONFIG_DEV_DESC", miniAppInfo.developerDesc);
        intent.putExtra("CONFIG_VER_TYPE", miniAppInfo.verType);
        intent.putExtra(AppBrandContant.CONFIG_GAME_REGISTRATION_NUMBER, miniAppInfo.gameRegistrationNumber);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(final Activity activity) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ShortcutUtils.4

            /* compiled from: P */
            /* renamed from: com.tencent.qqmini.proxyimpl.ShortcutUtils$4$a */
            /* loaded from: classes34.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    QLog.e("ShortcutUtils", 2, MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
                    ShortcutUtils.z(activity);
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.qqmini.proxyimpl.ShortcutUtils$4$b */
            /* loaded from: classes34.dex */
            class b implements DialogInterface.OnClickListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    QLog.e("ShortcutUtils", 2, "cancel");
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.P()) {
                    d.Q(activity, HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.tg7), HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.j6l), HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.tfu), new a(), new b()).show();
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static void z(Activity activity) {
        boolean z16;
        ?? r26;
        String packageName = activity.getPackageName();
        if (r(activity, "miui.intent.action.APP_PERM_EDITOR")) {
            Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", packageName);
            try {
                activity.getBaseContext().startActivity(intent);
                z16 = true;
            } catch (Exception e16) {
                QLog.e("ShortcutUtils", 1, "openPermissionActivity e = " + e16);
                r26 = 1;
                z16 = false;
            }
        } else {
            z16 = false;
        }
        r26 = z16;
        if (!z16 && r(activity, "com.meizu.safe.security.SHOW_APPSEC")) {
            Intent intent2 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent2.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
            intent2.putExtra("packageName", packageName);
            r26 = 2;
            r26 = 2;
            try {
                activity.getBaseContext().startActivity(intent2);
                z16 = true;
            } catch (Exception e17) {
                QLog.e("ShortcutUtils", 1, "openPermissionActivity e = " + e17);
                z16 = false;
            }
        }
        if (!z16 && r(activity, "huawei.intent.action.NOTIFICATIONMANAGER")) {
            Intent intent3 = new Intent();
            intent3.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
            intent3.addFlags(268435456);
            try {
                activity.getBaseContext().startActivity(intent3);
                z16 = true;
            } catch (Exception e18) {
                QLog.e("ShortcutUtils", 1, "openPermissionActivity e = " + e18);
                z16 = false;
            }
            r26 = 3;
            r26 = 3;
            r26 = 3;
            if (!z16) {
                try {
                    activity.getBaseContext().startActivity(new Intent("huawei.intent.action.NOTIFICATIONMANAGER"));
                    z16 = true;
                } catch (Exception e19) {
                    QLog.e("ShortcutUtils", 1, "openPermissionActivity e = " + e19);
                    z16 = false;
                }
            }
        }
        if (!z16) {
            Intent intent4 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            r26 = 4;
            r26 = 4;
            try {
                intent4.setData(Uri.fromParts("package", packageName, null));
                activity.getBaseContext().startActivity(intent4);
                z16 = true;
            } catch (Exception e26) {
                QLog.e("ShortcutUtils", 1, "openPermissionActivity e = " + e26);
                z16 = false;
            }
        }
        if (!z16 && r(activity, "android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
            r26 = 5;
            r26 = 5;
            try {
                activity.getBaseContext().startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
                z16 = true;
            } catch (Exception e27) {
                QLog.e("ShortcutUtils", 1, "openPermissionActivity e = " + e27);
                z16 = false;
            }
        }
        if (!z16) {
            Intent intent5 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent5.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
            intent5.putExtra("show_right_close_button", false);
            intent5.putExtra("startOpenPageTime", System.currentTimeMillis());
            VasWebviewUtil.openQQBrowserWithoutAD(activity, "https://kf.qq.com/touch/sappfaq/190605Vn2EBv190605zuiEbY.html?scene_id=kf172&platform=15", 524288L, intent5, false, -1);
            r26 = 6;
        }
        QLog.w("ShortcutUtils", 1, "\u8bf7\u6c42\u6743\u9650, which[" + r26 + "], openSuccess[" + z16 + "]");
    }

    public static void f(Activity activity, MiniAppInfo miniAppInfo) {
        g(activity, miniAppInfo, null);
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class d extends QQCustomDialog {
        private ViewGroup C;
        private CheckBox D;
        private TextView E;
        private Activity F;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes34.dex */
        public class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.D.setChecked(!d.this.D.isChecked());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes34.dex */
        public class b extends ClickableSpan {
            b() {
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                String string = StorageUtil.getPreference().getString("mini_shortcut_help_url", "https://kf.qq.com/touch/sappfaq/190605Vn2EBv190605zuiEbY.html?scene_id=kf172&platform=15");
                Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
                intent.setFlags(134217728);
                intent.putExtra("url", string);
                intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
                intent.putExtra("show_right_close_button", false);
                intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                d.this.F.startActivityForResult(intent, 1001);
            }
        }

        public d(Activity activity, int i3) {
            super(activity, i3);
            this.F = activity;
            initUI();
        }

        public static boolean P() {
            boolean z16 = StorageUtil.getPreference().getBoolean("mini_shortcut_dialog_hide", false);
            QLog.i("ShortcutUtils", 1, "load dialog hide config:" + z16);
            return !z16;
        }

        public static d Q(Activity activity, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
            d dVar = new d(activity, com.tencent.mobileqq.R.style.qZoneInputDialog);
            dVar.setTitle(str);
            dVar.setNegativeButton(str2, onClickListener2);
            dVar.setPositiveButton(str3, onClickListener);
            dVar.setCanceledOnTouchOutside(false);
            return dVar;
        }

        public void S(boolean z16) {
            this.C.setVisibility(z16 ? 0 : 8);
        }

        @Override // com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            boolean isChecked = this.D.isChecked();
            QLog.i("ShortcutUtils", 1, "save dialog hide config:" + isChecked);
            if (StorageUtil.getPreference() != null) {
                StorageUtil.getPreference().edit().putBoolean("mini_shortcut_dialog_hide", isChecked).commit();
            }
            super.dismiss();
        }

        public CharSequence R() {
            String qqStr = HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.tfy);
            String qqStr2 = HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f172703tg2);
            SpannableString spannableString = new SpannableString(qqStr + qqStr2);
            spannableString.setSpan(new b(), qqStr.length(), qqStr.length() + qqStr2.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(-15505507), qqStr.length(), qqStr.length() + qqStr2.length(), 33);
            return spannableString;
        }

        public void initUI() {
            setContentView(com.tencent.mobileqq.R.layout.f167845je);
            this.text.setMovementMethod(LinkMovementMethod.getInstance());
            this.text.setText(R());
            this.C = (ViewGroup) findViewById(com.tencent.mobileqq.R.id.e2z);
            this.D = (CheckBox) findViewById(com.tencent.mobileqq.R.id.juo);
            TextView textView = (TextView) findViewById(com.tencent.mobileqq.R.id.kdc);
            this.E = textView;
            textView.setOnClickListener(new a());
        }
    }

    public static void B(Activity activity) {
        d Q = d.Q(activity, HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f172702tg1), HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.j6l), HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.tgf), new a(activity), new b());
        Q.S(false);
        Q.show();
    }

    public static boolean u(String str, ShortcutManager shortcutManager) {
        List pinnedShortcuts;
        String id5;
        if (shortcutManager == null) {
            return false;
        }
        pinnedShortcuts = shortcutManager.getPinnedShortcuts();
        Iterator it = pinnedShortcuts.iterator();
        while (it.hasNext()) {
            id5 = ((ShortcutInfo) it.next()).getId();
            if (str.equals(id5)) {
                return true;
            }
        }
        return false;
    }

    public static void g(final Activity activity, MiniAppInfo miniAppInfo, c cVar) {
        if (activity != null && miniAppInfo != null) {
            if (i(activity) == 1) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ShortcutUtils.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ShortcutUtils.B(activity);
                    }
                });
                if (cVar != null) {
                    cVar.a(2, HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.tfv));
                    return;
                }
                return;
            }
            n(activity, miniAppInfo, cVar);
            return;
        }
        QLog.e("ShortcutUtils", 1, "addShortcut params invalid!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class e implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        private final Activity f347571d;

        /* renamed from: e, reason: collision with root package name */
        private final MiniAppInfo f347572e;

        /* renamed from: f, reason: collision with root package name */
        private final c f347573f;

        public e(Activity activity, MiniAppInfo miniAppInfo, c cVar) {
            this.f347571d = activity;
            this.f347572e = miniAppInfo;
            this.f347573f = cVar;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            ShortcutUtils.y(this.f347571d);
            c cVar = this.f347573f;
            if (cVar != null) {
                cVar.a(1, HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.tg8));
            }
            QLog.e("ShortcutUtils", 1, "doAddShortcut onLoadFialed!", th5);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            ShortcutInfo shortcutInfo;
            PendingIntent pendingIntent;
            ShortcutInfo.Builder icon;
            ShortcutInfo.Builder shortLabel;
            ShortcutInfo.Builder intent;
            ShortcutInfo.Builder extras;
            QLog.d("ShortcutUtils", 1, "onLoadSuccessed url" + this.f347572e.iconUrl);
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    Intent x16 = ShortcutUtils.x(this.f347571d, this.f347572e);
                    PersistableBundle persistableBundle = new PersistableBundle();
                    icon = new ShortcutInfo.Builder(this.f347571d, this.f347572e.appId).setIcon(Icon.createWithBitmap(ShortcutUtils.p(this.f347571d, uRLDrawable)));
                    shortLabel = icon.setShortLabel(this.f347572e.name);
                    intent = shortLabel.setIntent(x16);
                    extras = intent.setExtras(persistableBundle);
                    shortcutInfo = extras.build();
                    Intent intent2 = new Intent("com.tencent.mini.CreateShortcutSucceedReceiver");
                    intent2.putExtra("CONFIG_APPNAME", this.f347572e.name);
                    pendingIntent = PendingIntent.getBroadcast(this.f347571d, 0, intent2, 201326592);
                } else {
                    Intent intent3 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                    intent3.putExtra("android.intent.extra.shortcut.NAME", this.f347572e.name);
                    intent3.putExtra("duplicate", false);
                    intent3.putExtra("android.intent.extra.shortcut.ICON", ShortcutUtils.p(this.f347571d, uRLDrawable));
                    intent3.putExtra("android.intent.extra.shortcut.INTENT", ShortcutUtils.x(this.f347571d, this.f347572e));
                    this.f347571d.sendBroadcast(intent3);
                    LockMethodProxy.sleep(1000L);
                    shortcutInfo = null;
                    pendingIntent = null;
                }
                if (!ShortcutUtils.t(this.f347571d, this.f347572e, shortcutInfo, pendingIntent)) {
                    ShortcutUtils.y(this.f347571d);
                    c cVar = this.f347573f;
                    if (cVar != null) {
                        cVar.a(1, HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.tg8));
                        return;
                    }
                    return;
                }
                c cVar2 = this.f347573f;
                if (cVar2 != null) {
                    cVar2.a(0, HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.tfz));
                }
            } catch (Throwable th5) {
                QLog.e("ShortcutUtils", 1, "doAddShortcut exception!", th5);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
