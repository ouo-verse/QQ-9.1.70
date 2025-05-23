package com.tencent.mobileqq.screendetect;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

/* compiled from: P */
@Deprecated
/* loaded from: classes18.dex */
public class ScreenShotDetector extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f282437d;

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f282438e;

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f282439f;

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f282440g;

    /* renamed from: h, reason: collision with root package name */
    private static String f282441h;

    /* renamed from: i, reason: collision with root package name */
    private static ScreenShotDetector f282442i;

    /* renamed from: j, reason: collision with root package name */
    private static SharedPreferences f282443j;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f282444k;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f282445b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f282446c;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.screendetect.ScreenShotDetector$1, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f282447d;
        final /* synthetic */ ScreenShotDetector this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            boolean j3 = ScreenShotDetector.j();
            if (QLog.isColorLevel()) {
                QLog.d("ScreenShotDetector", 2, "start screenshots, " + j3);
            }
            if (j3) {
                ScreenShotHelper.p((Context) this.this$0.f282445b.get(), this.f282447d, this.this$0.f282446c);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.screendetect.ScreenShotDetector$2, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f282448d;
        final /* synthetic */ ScreenShotDetector this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Context context = this.f282448d;
            ScreenShotDetector.c(this.this$0);
            ScreenShotDetector.b(this.this$0);
            ScreenShotDetector.g(context, null, null);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.screendetect.ScreenShotDetector$3, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f282449d;
        final /* synthetic */ ScreenShotDetector this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Context context = this.f282449d;
            ScreenShotDetector.c(this.this$0);
            ScreenShotDetector.b(this.this$0);
            ScreenShotDetector.h(context, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends ContentObserver {
        static IPatchRedirector $redirector_;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74839);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f282437d = new String[]{"_data", "datetaken"};
        f282438e = new String[]{"_data", "datetaken", "width", "height"};
        f282439f = new String[]{"screenshot", AppConstants.PREF_SCREEN_SHOT, "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
        f282440g = new String[]{"\u4e09\u661fF9000", "\u4e09\u661fA8S", "\u4e09\u661fS8+", "\u534e\u4e3aMHA-AL00", "\u534e\u4e3aP30", "vivoX27", "\u5c0f\u7c739", "OPPOA59S", "\u9b45\u65cfPro7-H", HardCodeUtil.qqStr(R.string.t5k), HardCodeUtil.qqStr(R.string.t5l)};
        f282441h = "";
        f282442i = new ScreenShotDetector();
        f282443j = BaseApplicationImpl.getApplication().getSharedPreferences("screenshots_quick_share_switch", 4);
        f282444k = true;
    }

    ScreenShotDetector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f282446c = new Handler(Looper.getMainLooper());
        }
    }

    static /* bridge */ /* synthetic */ a b(ScreenShotDetector screenShotDetector) {
        screenShotDetector.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ a c(ScreenShotDetector screenShotDetector) {
        screenShotDetector.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context, a aVar, a aVar2) {
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotDetector", 2, "doOnRegisterObservers() called with: context = [" + context + "], internalObserver = [" + aVar + "], externalObserver = [" + aVar2 + "]");
        }
        try {
            context.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, aVar);
            context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, aVar2);
        } catch (Exception e16) {
            QLog.e("ScreenShotDetector", 1, "ScreenShot: doOnRegisterObservers error", e16);
        }
    }

    public static ScreenShotDetector getInstance() {
        return f282442i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Context context, a aVar, a aVar2) {
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotDetector", 2, "doOnUnRegisterObservers() called with: context = [" + context + "], internalObserver = [" + aVar + "], externalObserver = [" + aVar2 + "]");
        }
        try {
            k(context, aVar);
            k(context, aVar2);
        } catch (Exception e16) {
            QLog.e("ScreenShotDetector", 1, "ScreenShot: doOnUnRegisterObservers error", e16);
        }
    }

    public static AppRuntime i() {
        return BaseApplicationImpl.getApplication().getRuntime();
    }

    public static boolean j() {
        String account = i().getAccount();
        if (account == null) {
            return f282444k;
        }
        boolean z16 = f282443j.getBoolean(account, true);
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotDetector", 2, "getAccount in getSwitchStatus: ", Boolean.valueOf(z16));
        }
        return z16;
    }

    @Override // mqq.app.IActivityDispatchCallback
    public void disaptchTouchEventCallback(Activity activity, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) motionEvent);
        } else {
            ScreenShotHelper.b(activity, motionEvent);
        }
    }

    @Override // mqq.app.IActivityDispatchCallback
    public void onWindowFocusChanged(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, activity, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotHelper-ScreenShotDetector", 2, "ScreenShot: onWindowFocusChanged " + z16);
        }
        this.f282446c.removeCallbacksAndMessages(null);
        if (z16) {
            ScreenShotHelper.j(activity, this.f282446c);
        } else if ("XIAOMI".equalsIgnoreCase(Build.MANUFACTURER)) {
            ScreenShotHelper.h(activity);
        }
    }

    private static void k(Context context, a aVar) {
    }
}
