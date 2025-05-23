package com.tencent.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qmethod.pandoraex.monitor.PermissionMonitor;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

/* loaded from: classes27.dex */
public class PermissionUtil {
    static IPatchRedirector $redirector_;
    public static final String[] PERMS;
    public static final String[] PERMS_STORAGE;
    private static boolean sHasPhonePermission;
    private static boolean sHasStoragePermission;
    private static boolean sHasStorageReadAndWritePermission;

    /* loaded from: classes27.dex */
    public interface SDCardPermissionCallback {
        void allow();

        void reject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppActivity f383949d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SDCardPermissionCallback f383950e;

        a(AppActivity appActivity, SDCardPermissionCallback sDCardPermissionCallback) {
            this.f383949d = appActivity;
            this.f383950e = sDCardPermissionCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) appActivity, (Object) sDCardPermissionCallback);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 == 1) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", this.f383949d.getPackageName(), null));
                this.f383949d.startActivity(intent);
            } else {
                SDCardPermissionCallback sDCardPermissionCallback = this.f383950e;
                if (sDCardPermissionCallback != null) {
                    sDCardPermissionCallback.reject();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public class b implements QQPermissionCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SDCardPermissionCallback f383951d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppActivity f383952e;

        b(SDCardPermissionCallback sDCardPermissionCallback, AppActivity appActivity) {
            this.f383951d = sDCardPermissionCallback;
            this.f383952e = appActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sDCardPermissionCallback, (Object) appActivity);
            }
        }

        @Override // mqq.app.QQPermissionCallback
        public void deny(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), strArr, iArr);
            } else {
                PermissionUtil.showSDCardExplainDialog(this.f383952e, this.f383951d);
            }
        }

        @Override // mqq.app.QQPermissionCallback
        public void grant(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), strArr, iArr);
                return;
            }
            SDCardPermissionCallback sDCardPermissionCallback = this.f383951d;
            if (sDCardPermissionCallback != null) {
                sDCardPermissionCallback.allow();
            }
        }
    }

    /* loaded from: classes27.dex */
    class c implements QQPermissionCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SDCardPermissionCallback f383953d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f383954e;

        c(SDCardPermissionCallback sDCardPermissionCallback, Activity activity) {
            this.f383953d = sDCardPermissionCallback;
            this.f383954e = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sDCardPermissionCallback, (Object) activity);
            }
        }

        @Override // mqq.app.QQPermissionCallback
        public void deny(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), strArr, iArr);
                return;
            }
            SDCardPermissionCallback sDCardPermissionCallback = this.f383953d;
            if (sDCardPermissionCallback != null) {
                sDCardPermissionCallback.reject();
            }
            DialogUtil.showPermissionDialogForStorage(this.f383954e);
        }

        @Override // mqq.app.QQPermissionCallback
        public void grant(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), strArr, iArr);
                return;
            }
            SDCardPermissionCallback sDCardPermissionCallback = this.f383953d;
            if (sDCardPermissionCallback != null) {
                sDCardPermissionCallback.allow();
            }
        }
    }

    /* loaded from: classes27.dex */
    class d implements QQPermissionCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SDCardPermissionCallback f383955d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f383956e;

        d(SDCardPermissionCallback sDCardPermissionCallback, Activity activity) {
            this.f383955d = sDCardPermissionCallback;
            this.f383956e = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sDCardPermissionCallback, (Object) activity);
            }
        }

        @Override // mqq.app.QQPermissionCallback
        public void deny(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), strArr, iArr);
            } else {
                DialogUtil.showPermissionDialogForStorageWithCallback(this.f383956e, this.f383955d);
            }
        }

        @Override // mqq.app.QQPermissionCallback
        public void grant(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), strArr, iArr);
                return;
            }
            SDCardPermissionCallback sDCardPermissionCallback = this.f383955d;
            if (sDCardPermissionCallback != null) {
                sDCardPermissionCallback.allow();
            }
        }
    }

    /* loaded from: classes27.dex */
    class e implements QQPermissionCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SDCardPermissionCallback f383957d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppActivity f383958e;

        e(SDCardPermissionCallback sDCardPermissionCallback, AppActivity appActivity) {
            this.f383957d = sDCardPermissionCallback;
            this.f383958e = appActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sDCardPermissionCallback, (Object) appActivity);
            }
        }

        @Override // mqq.app.QQPermissionCallback
        public void deny(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), strArr, iArr);
            } else {
                PermissionUtil.showSDCardExplainDialog(this.f383958e, this.f383957d);
            }
        }

        @Override // mqq.app.QQPermissionCallback
        public void grant(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), strArr, iArr);
                return;
            }
            SDCardPermissionCallback sDCardPermissionCallback = this.f383957d;
            if (sDCardPermissionCallback != null) {
                sDCardPermissionCallback.allow();
            }
        }
    }

    /* loaded from: classes27.dex */
    class f implements QQPermissionCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SDCardPermissionCallback f383959d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f383960e;

        f(SDCardPermissionCallback sDCardPermissionCallback, Activity activity) {
            this.f383959d = sDCardPermissionCallback;
            this.f383960e = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sDCardPermissionCallback, (Object) activity);
            }
        }

        @Override // mqq.app.QQPermissionCallback
        public void deny(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), strArr, iArr);
                return;
            }
            SDCardPermissionCallback sDCardPermissionCallback = this.f383959d;
            if (sDCardPermissionCallback != null) {
                sDCardPermissionCallback.reject();
            }
            DialogUtil.showPermissionDialogForStorage(this.f383960e);
        }

        @Override // mqq.app.QQPermissionCallback
        public void grant(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), strArr, iArr);
                return;
            }
            SDCardPermissionCallback sDCardPermissionCallback = this.f383959d;
            if (sDCardPermissionCallback != null) {
                sDCardPermissionCallback.allow();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53768);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            PERMS = new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, DeviceInfoUtil.PERMISSION_READ_PHONE};
            PERMS_STORAGE = new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE};
        }
    }

    public PermissionUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isHasPhonePermission(Context context) {
        boolean z16 = sHasPhonePermission;
        if (!z16 && context != null && context.checkSelfPermission(PERMS[1]) == 0) {
            sHasPhonePermission = true;
            return true;
        }
        return z16;
    }

    public static boolean isHasStoragePermission(Context context) {
        boolean z16 = sHasStoragePermission;
        if (!z16 && context != null && context.checkSelfPermission(PERMS[0]) == 0) {
            sHasStoragePermission = true;
            return true;
        }
        return z16;
    }

    public static boolean isHasStorageReadAndWritePermission(Context context) {
        boolean z16 = sHasStorageReadAndWritePermission;
        if (!z16 && context != null) {
            String[] strArr = PERMS_STORAGE;
            if (context.checkSelfPermission(strArr[0]) == 0 && context.checkSelfPermission(strArr[1]) == 0) {
                sHasStorageReadAndWritePermission = true;
                return true;
            }
            return z16;
        }
        return z16;
    }

    public static void requestPhonePermission(AppActivity appActivity, int i3, QQPermissionCallback qQPermissionCallback) {
        appActivity.requestPermissions(qQPermissionCallback, i3, PERMS[1]);
    }

    public static void requestSDCardPermission(AppActivity appActivity, SDCardPermissionCallback sDCardPermissionCallback) {
        appActivity.requestPermissions(new b(sDCardPermissionCallback, appActivity), 1, PERMS[0]);
    }

    public static void requestStoragePermission(AppActivity appActivity, int i3, QQPermissionCallback qQPermissionCallback) {
        appActivity.requestPermissions(qQPermissionCallback, i3, PERMS[0]);
    }

    @TargetApi(23)
    public static void requestStorePermission(Activity activity, SDCardPermissionCallback sDCardPermissionCallback) {
        if (activity instanceof AppActivity) {
            requestSDCardPermission((AppActivity) activity, sDCardPermissionCallback);
        } else if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).requestPermissions(new c(sDCardPermissionCallback, activity), 1, PERMS[0]);
        } else {
            PermissionMonitor.requestPermissions(activity, new String[]{PERMS[0]}, 1);
        }
    }

    public static void requestStorePermissionWithWarning(Activity activity, SDCardPermissionCallback sDCardPermissionCallback) {
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).requestPermissions(new d(sDCardPermissionCallback, activity), 1, PERMS[0]);
        }
    }

    @TargetApi(23)
    public static void requestStoreReadAndWritePermission(Activity activity, SDCardPermissionCallback sDCardPermissionCallback) {
        if (activity instanceof AppActivity) {
            AppActivity appActivity = (AppActivity) activity;
            appActivity.requestPermissions(new e(sDCardPermissionCallback, appActivity), 1, PERMS_STORAGE);
        } else if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).requestPermissions(new f(sDCardPermissionCallback, activity), 1, PERMS_STORAGE);
        } else if (activity != null) {
            PermissionMonitor.requestPermissions(activity, PERMS_STORAGE, 1);
        }
    }

    public static void showSDCardExplainDialog(AppActivity appActivity, SDCardPermissionCallback sDCardPermissionCallback) {
        try {
            String qqStr = HardCodeUtil.qqStr(R.string.f214885u4);
            String qqStr2 = HardCodeUtil.qqStr(R.string.f214855u1);
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(appActivity, 230);
            createCustomDialog.setTitle(qqStr2);
            createCustomDialog.setMessage(qqStr);
            a aVar = new a(appActivity, sDCardPermissionCallback);
            createCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), aVar);
            createCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.f214865u2), aVar);
            createCustomDialog.setOnDismissListener(null);
            createCustomDialog.show();
        } catch (Throwable unused) {
        }
    }
}
