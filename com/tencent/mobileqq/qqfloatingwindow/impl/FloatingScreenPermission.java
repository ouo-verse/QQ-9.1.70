package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

/* loaded from: classes16.dex */
public class FloatingScreenPermission {
    static IPatchRedirector $redirector_ = null;
    private static final int OP_SYSTEM_ALERT_WINDOW = 24;
    private static final String TAG = "FloatingScreenPermission";

    /* loaded from: classes16.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f264344d;

        a(Context context) {
            this.f264344d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                com.tencent.mobileqq.qqfloatingwindow.b.b();
                FloatingScreenPermission.requestPermission(this.f264344d);
            }
        }
    }

    /* loaded from: classes16.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f264345d;

        b(Context context) {
            this.f264345d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                com.tencent.mobileqq.qqfloatingwindow.b.b();
                FloatingScreenPermission.requestPermission(this.f264345d);
            }
        }
    }

    /* loaded from: classes16.dex */
    class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f264346d;

        c(Context context) {
            this.f264346d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                com.tencent.mobileqq.qqfloatingwindow.b.b();
                FloatingScreenPermission.requestPermission(this.f264346d);
            }
        }
    }

    /* loaded from: classes16.dex */
    class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* loaded from: classes16.dex */
    class e implements DialogInterface.OnShowListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f264347d;

        e(Context context) {
            this.f264347d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else if (((Activity) this.f264347d).isFinishing() || ((Activity) this.f264347d).isDestroyed()) {
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes16.dex */
    class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f264348d;

        f(Context context) {
            this.f264348d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                FloatingScreenPermission.requestPermission(this.f264348d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class g implements com.tencent.mobileqq.bigbrother.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f264349a;

        g(Runnable runnable) {
            this.f264349a = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable);
            }
        }

        @Override // com.tencent.mobileqq.bigbrother.b
        public void onJump(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            QLog.d(FloatingScreenPermission.TAG, 1, "startVivoPmActivity2 onJump - callbackId= " + i3 + ", action = " + i16);
            if (i16 == -1) {
                this.f264349a.run();
            }
            com.tencent.mobileqq.bigbrother.d.b().d(i3);
        }
    }

    public FloatingScreenPermission() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean canUseCheckOpForVivo() {
        return Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO);
    }

    @RequiresApi(19)
    private static boolean checkOp(Context context, int i3) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            Class<?> cls = appOpsManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            Integer num = (Integer) cls.getDeclaredMethod("checkOp", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(i3), Integer.valueOf(Binder.getCallingUid()), context.getApplicationContext().getPackageName());
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "0 invoke " + num);
            }
            if (num != null) {
                if (num.intValue() == 0) {
                    return true;
                }
            }
            return false;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "checkOp failed.", e16);
            return true;
        }
    }

    public static boolean checkOpForCommon(Context context) {
        return Settings.canDrawOverlays(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0099, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0096, code lost:
    
        if (0 == 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkOpForVivo(Context context) {
        boolean checkOpForCommon;
        Cursor cursor = null;
        try {
            cursor = ContactsMonitor.query(context.getContentResolver(), Uri.parse("content://com.vivo.permissionmanager.provider.permission/float_window_apps"), new String[]{"currentmode"}, "pkgname='" + context.getPackageName() + "'", null, null);
            if (cursor != null && cursor.moveToFirst()) {
                int i3 = cursor.getInt(0);
                if (i3 == 0) {
                    checkOpForCommon = true;
                } else {
                    checkOpForCommon = false;
                }
                QLog.d(TAG, 1, "checkOpForVivo success, mode:", Integer.valueOf(i3), ", result:", Boolean.valueOf(checkOpForCommon));
            } else {
                checkOpForCommon = checkOpForCommon(context);
                QLog.d(TAG, 1, "checkOpForCommon query failed, result:", Boolean.valueOf(checkOpForCommon), " ,cursor:", cursor);
            }
        } catch (Throwable th5) {
            try {
                QLog.w(TAG, 1, "checkOpForVivo, Exception", th5);
                checkOpForCommon = checkOpForCommon(context);
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
    }

    @TargetApi(19)
    private static boolean checkOps(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Object systemService = context.getSystemService("appops");
            if (systemService == null) {
                return false;
            }
            Class<?> cls = systemService.getClass();
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOp", cls2, cls2, String.class);
            if (method == null) {
                return false;
            }
            Integer num = (Integer) method.invoke(systemService, 24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName());
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkOps ", num);
            }
            if (num == null) {
                return false;
            }
            if (num.intValue() != 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean checkPermission(Context context) {
        if (context == null) {
            return false;
        }
        if (canUseCheckOpForVivo()) {
            return checkOpForVivo(context);
        }
        return checkOpForCommon(context);
    }

    public static void enterPermissionRequestDialog(Context context) {
        if (context == null) {
            return;
        }
        com.tencent.mobileqq.qqfloatingwindow.b.c();
        DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f209735g8), context.getString(R.string.f209715g6), context.getString(R.string.f209705g5), context.getString(R.string.f209725g7), new a(context), (DialogInterface.OnClickListener) null).show();
    }

    public static void enterPermissionRequestDialogCustom(Context context, int i3, int i16) {
        if (context == null) {
            return;
        }
        com.tencent.mobileqq.qqfloatingwindow.b.c();
        DialogUtil.createCustomDialog(context, 230, context.getString(i3), context.getString(i16), context.getString(R.string.f209705g5), context.getString(R.string.f209725g7), new b(context), (DialogInterface.OnClickListener) null).show();
    }

    private static boolean handleVivoPermissionDialog(Context context) {
        if (canUseCheckOpForVivo()) {
            DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f209735g8), context.getString(R.string.f209815gf), context.getString(R.string.f209705g5), context.getString(R.string.cpy), new f(context), (DialogInterface.OnClickListener) null).show();
            return true;
        }
        return false;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        ActivityInfo resolveActivityInfo;
        if (context == null || intent == null || (resolveActivityInfo = intent.resolveActivityInfo(context.getPackageManager(), 65536)) == null || !resolveActivityInfo.exported) {
            return false;
        }
        return true;
    }

    public static boolean requestPermission(Context context) {
        return requestPermission(context, null);
    }

    @RequiresApi(api = 23)
    private static boolean startCommonPmActivity(Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getPackageName()));
        intent.addFlags(268435456);
        if (isIntentAvailable(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static boolean startHuaWeiPmActivity(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
        intent.putExtra("packageName", context.getPackageName());
        intent.addFlags(268435456);
        intent.putExtra("big_brother_source_key", "biz_src_fs");
        if (isIntentAvailable(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static boolean startHuaWeiPmActivity2(Context context) {
        Intent intent = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
        intent.addFlags(268435456);
        intent.putExtra("big_brother_source_key", "biz_src_fs");
        if (isIntentAvailable(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static boolean startMeizuPmActivity(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        intent.addFlags(268435456);
        intent.putExtra("big_brother_source_key", "biz_src_fs");
        if (isIntentAvailable(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static boolean startMiuiPmActivity(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        intent.putExtra("big_brother_source_key", "biz_src_fs");
        intent.addFlags(268435456);
        if (isIntentAvailable(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static boolean startMiuiPmActivity8(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.RealAppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        intent.addFlags(268435456);
        intent.putExtra("big_brother_source_key", "biz_src_fs");
        if (isIntentAvailable(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static boolean startMiuiPmActivity8DEV(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        intent.addFlags(268435456);
        intent.putExtra("big_brother_source_key", "biz_src_fs");
        if (isIntentAvailable(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static boolean startVivoPmActivity(Context context) {
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT < 25 && (DeviceInfoMonitor.getModel().contains("X9") || DeviceInfoMonitor.getModel().contains("x9"))) {
            intent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.PurviewTabActivity");
        } else {
            intent.setClassName("com.iqoo.secure", "com.iqoo.secure.MainActivity");
        }
        intent.addFlags(268435456);
        if (isIntentAvailable(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static boolean startVivoPmActivity2(Context context, Runnable runnable) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.putExtra("big_brother_source_key", "biz_src_fs");
        intent.putExtra("packagename", context.getPackageName());
        if ((!DeviceInfoMonitor.getModel().contains("Y85") || DeviceInfoMonitor.getModel().contains("Y85A")) && !DeviceInfoMonitor.getModel().contains("vivo Y53L") && !DeviceInfoMonitor.getModel().contains("Y66i A") && !DeviceInfoMonitor.getModel().contains("vivo S10")) {
            intent.setAction("permission.intent.action.softPermissionDetail");
        } else {
            intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.PurviewTabActivity");
            intent.putExtra("tabId", "1");
        }
        if (runnable != null) {
            intent.putExtra("key_callback_id", com.tencent.mobileqq.bigbrother.d.b().a(new g(runnable)));
        }
        if (isIntentAvailable(context, intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public static boolean requestPermission(Context context, Runnable runnable) {
        boolean z16;
        if (canUseCheckOpForVivo()) {
            z16 = startVivoPmActivity2(context, runnable);
            if (!z16) {
                z16 = startVivoPmActivity(context);
            }
        } else {
            z16 = false;
        }
        if (!z16) {
            z16 = startCommonPmActivity(context);
        }
        if (!z16) {
            z16 = startMiuiPmActivity(context);
        }
        if (!z16) {
            z16 = startMiuiPmActivity8(context);
        }
        if (!z16) {
            z16 = startMiuiPmActivity8DEV(context);
        }
        if (!z16) {
            z16 = startMeizuPmActivity(context);
        }
        if (!z16) {
            z16 = startHuaWeiPmActivity(context);
        }
        return !z16 ? startHuaWeiPmActivity2(context) : z16;
    }

    public static void enterPermissionRequestDialogCustom(Context context, int i3, int i16, int i17, int i18) {
        if (context == null) {
            return;
        }
        com.tencent.mobileqq.qqfloatingwindow.b.c();
        DialogUtil.createCustomDialog(context, 230, context.getString(i3), context.getString(i16), context.getString(i17), context.getString(i18), new c(context), new d()).show();
    }

    public static void enterPermissionRequestDialogCustom(Context context, int i3, int i16, int i17, int i18, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener, com.tencent.mobileqq.qqfloatingwindow.c cVar) {
        if (context == null) {
            return;
        }
        com.tencent.mobileqq.qqfloatingwindow.b.c();
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, context.getString(i3), context.getString(i16), context.getString(i17 <= 0 ? R.string.f209705g5 : i17), context.getString(i18 <= 0 ? R.string.f209725g7 : i18), new DialogInterface.OnClickListener(onClickListener2, context, onDismissListener) { // from class: com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenPermission.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ DialogInterface.OnClickListener f264340d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Context f264341e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ DialogInterface.OnDismissListener f264342f;

            {
                this.f264340d = onClickListener2;
                this.f264341e = context;
                this.f264342f = onDismissListener;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, onClickListener2, context, onDismissListener);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i19) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i19);
                    return;
                }
                DialogInterface.OnClickListener onClickListener3 = this.f264340d;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(dialogInterface, i19);
                }
                com.tencent.mobileqq.qqfloatingwindow.b.b();
                FloatingScreenPermission.requestPermission(this.f264341e, new Runnable(dialogInterface) { // from class: com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenPermission.5.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ DialogInterface f264343d;

                    {
                        this.f264343d = dialogInterface;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, (Object) dialogInterface);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        DialogInterface.OnDismissListener onDismissListener2 = AnonymousClass5.this.f264342f;
                        if (onDismissListener2 != null) {
                            onDismissListener2.onDismiss(this.f264343d);
                        }
                    }
                });
            }
        }, onClickListener);
        if (cVar != null) {
            cVar.a(context, createCustomDialog);
        }
        if (onDismissListener != null) {
            createCustomDialog.setOnDismissListener(onDismissListener);
        }
        createCustomDialog.setOnShowListener(new e(context));
        createCustomDialog.show();
    }
}
