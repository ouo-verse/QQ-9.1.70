package com.tencent.mobileqq.qui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.delegate.impl.RFWReporter;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QUICompatDialog extends Dialog {
    static IPatchRedirector $redirector_ = null;
    private static final String ANDROID_O_EXCEPTION = "Could not read input channel file descriptors from parcel";
    private static final String DEAD_OBJ_EXCEPTION = "remote process probably died";
    private static final String EVENT_NAME_DIALOG_INIT = "dialog_init";
    private static final String EVENT_NAME_DIALOG_SHOW = "dialog_show";
    private static final String EVENT_NAME_DISMISS_ON_ACTIVITY_DESTROY = "dismiss_on_activity_destroy";
    private static final String EVENT_NAME_DISMISS_ON_ERROR_THREAD = "show_on_error_thread";
    private static final String EVENT_NAME_SHOW_ON_ACTIVITY_DESTROY = "show_on_activity_destroy";
    private static final String EVENT_NAME_SHOW_ON_ERROR_THREAD = "show_on_error_thread";
    private static final String KEY_CHECK_DIALOG_SHOW = "check_dialog_show";
    private static final String KEY_IS_PUBLIC = "is_public";
    private static final String KEY_OPEN_LOOPER_CHECK = "open_looper_check_and_change";
    private static final String KEY_STACK = "stack";
    private static final String TAG = "QUICompatDialog";
    private static final String kEY_CHECK_DIALOG_DISMISS = "check_dialog_dismiss";
    private static final List<b> sDialogLifecycleCallbacks;
    private static Boolean sIsOpenCheckDialogDismiss;
    private static Boolean sIsOpenCheckDialogShow;
    private static boolean sNeedInitOpenAutoAdjustDialog;
    private static boolean sOpenAutoAdjustDialog;
    private Looper mCreateLooper;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUICompatDialog.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            QUICompatDialog.this.getWindow().getDecorView().getViewTreeObserver().removeOnPreDrawListener(this);
            QUICompatDialog.this.updateNavigatorBarColor();
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface b {
        void a(@NonNull Dialog dialog);

        void b(@NonNull Dialog dialog);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50586);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        sOpenAutoAdjustDialog = false;
        sNeedInitOpenAutoAdjustDialog = true;
        sIsOpenCheckDialogShow = null;
        sIsOpenCheckDialogDismiss = null;
        sDialogLifecycleCallbacks = new CopyOnWriteArrayList();
    }

    public QUICompatDialog(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            init();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private static boolean canAutoAdjustDialog() {
        if (sNeedInitOpenAutoAdjustDialog) {
            sOpenAutoAdjustDialog = com.tencent.mobileqq.immersive.a.b();
            sNeedInitOpenAutoAdjustDialog = false;
        }
        return sOpenAutoAdjustDialog;
    }

    private void checkInUIThread(String str) {
        String str2;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HashMap hashMap = new HashMap();
            if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion()) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            hashMap.put(KEY_IS_PUBLIC, str2);
            hashMap.put("stack", QLog.getStackTraceString(new Exception("in error thread")));
            RFWReporter.reportCommonEvent(str, hashMap);
        }
    }

    private Activity getHostActivity() {
        if (getContext() instanceof Activity) {
            return (Activity) getContext();
        }
        if (getContext() instanceof ContextWrapper) {
            ContextWrapper contextWrapper = (ContextWrapper) getContext();
            if (contextWrapper.getBaseContext() instanceof Activity) {
                return (Activity) contextWrapper.getBaseContext();
            }
        }
        return null;
    }

    private void init() {
        this.mCreateLooper = Looper.myLooper();
        checkInUIThread(EVENT_NAME_DIALOG_INIT);
    }

    private static boolean isAndroidOFdException(Exception exc) {
        int i3 = Build.VERSION.SDK_INT;
        if ((i3 != 26 && i3 != 27) || !(exc instanceof RuntimeException)) {
            return false;
        }
        String message = ((RuntimeException) exc).getMessage();
        if (TextUtils.isEmpty(message) || !message.contains(ANDROID_O_EXCEPTION)) {
            return false;
        }
        return true;
    }

    private static boolean isDeadObjectException(Exception exc) {
        if (!(exc instanceof DeadObjectException)) {
            return false;
        }
        String message = ((DeadObjectException) exc).getMessage();
        if (TextUtils.isEmpty(message) || !message.contains(DEAD_OBJ_EXCEPTION)) {
            return false;
        }
        return true;
    }

    public static boolean isOpenCheckDialogDismiss() {
        if (sIsOpenCheckDialogDismiss == null) {
            sIsOpenCheckDialogDismiss = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(kEY_CHECK_DIALOG_DISMISS, true));
        }
        return sIsOpenCheckDialogDismiss.booleanValue();
    }

    public static boolean isOpenCheckDialogShow() {
        if (sIsOpenCheckDialogShow == null) {
            sIsOpenCheckDialogShow = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(KEY_CHECK_DIALOG_SHOW, true));
        }
        return sIsOpenCheckDialogShow.booleanValue();
    }

    public static boolean isOpenLooperCheck() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(KEY_OPEN_LOOPER_CHECK, false);
    }

    public static void registerDialogLifecycle(b bVar) {
        sDialogLifecycleCallbacks.add(bVar);
    }

    private void startPreDrawCheck() {
        View peekDecorView = getWindow().peekDecorView();
        if (peekDecorView == null) {
            RFWLog.i(TAG, RFWLog.USR, " startPreDrawCheck but decorView is null");
        } else if (canAutoAdjustDialog()) {
            peekDecorView.getViewTreeObserver().addOnPreDrawListener(new a());
        }
    }

    public static void unregisterDialogLifecycle(b bVar) {
        sDialogLifecycleCallbacks.remove(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNavigatorBarColor() {
        if (getWindow().isFloating()) {
            QLog.e(TAG, 1, "this dialog's window is floating " + this);
            return;
        }
        if (!QUIImmersiveHelper.n(getWindow())) {
            QLog.e(TAG, 1, "The window that this dialog is attached to doesn't have a navigation bar " + this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "updateNavigatorBarColor");
        }
        QUIImmersiveHelper.g(getWindow(), null);
    }

    public void checkActivityStateAndDismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (isActivityDestroyed() && isOpenCheckDialogDismiss()) {
            RFWReporter.report(EVENT_NAME_DISMISS_ON_ACTIVITY_DESTROY, new HashMap());
            return;
        }
        super.dismiss();
        Iterator<b> it = sDialogLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    public void checkActivityStateAndShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (isActivityFinishingOrDestroyed() && isOpenCheckDialogShow()) {
            RFWReporter.report(EVENT_NAME_SHOW_ON_ACTIVITY_DESTROY, new HashMap());
            return;
        }
        try {
            super.show();
            startPreDrawCheck();
            Iterator<b> it = sDialogLifecycleCallbacks.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        } catch (Exception e16) {
            if (isAndroidOFdException(e16)) {
                RFWLog.fatal(TAG, RFWLog.USR, e16);
            } else {
                if (isDeadObjectException(e16)) {
                    RFWLog.fatal(TAG, RFWLog.USR, e16);
                    return;
                }
                throw e16;
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            checkActivityStateAndDismiss();
        }
    }

    public boolean isActivityDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        Activity hostActivity = getHostActivity();
        if (hostActivity != null && hostActivity.isDestroyed()) {
            return true;
        }
        return false;
    }

    public boolean isActivityFinishingOrDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        Activity hostActivity = getHostActivity();
        if (hostActivity != null && (hostActivity.isFinishing() || hostActivity.isDestroyed())) {
            return true;
        }
        return false;
    }

    @Override // android.app.Dialog
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Looper myLooper = Looper.myLooper();
        Looper looper = this.mCreateLooper;
        if (looper != myLooper && looper != null) {
            if (isOpenLooperCheck()) {
                new Handler(this.mCreateLooper).post(new Runnable() { // from class: com.tencent.mobileqq.qui.dialog.QUICompatDialog.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUICompatDialog.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            QUICompatDialog.this.checkActivityStateAndShow();
                        }
                    }
                });
            } else {
                RFWReporter.report("show_on_error_thread", new HashMap());
                checkActivityStateAndShow();
            }
        } else {
            checkActivityStateAndShow();
        }
        checkInUIThread(EVENT_NAME_DIALOG_SHOW);
    }

    public QUICompatDialog(@NonNull Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            init();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
        }
    }

    protected QUICompatDialog(@NonNull Context context, boolean z16, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context, z16, onCancelListener);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            init();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, Boolean.valueOf(z16), onCancelListener);
        }
    }
}
