package com.tencent.mobileqq.loginwelcome;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LoginUserGuideHelper {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class GuideRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<Activity> f243066d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<QQAppInterface> f243067e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f243068f;

        /* renamed from: h, reason: collision with root package name */
        private final a f243069h;

        public GuideRunnable(Activity activity, QQAppInterface qQAppInterface, boolean z16, a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, activity, qQAppInterface, Boolean.valueOf(z16), aVar);
                return;
            }
            this.f243066d = new WeakReference<>(activity);
            this.f243067e = new WeakReference<>(qQAppInterface);
            this.f243068f = z16;
            this.f243069h = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QQAppInterface qQAppInterface = this.f243067e.get();
            Activity activity = this.f243066d.get();
            if (qQAppInterface != null && activity != null) {
                if (QLog.isColorLevel()) {
                    QLog.i("LoginUserGuideHelper", 2, "GuideRunnable : " + this.f243068f);
                }
                if (this.f243068f) {
                    ThreadManagerV2.excute(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper.GuideRunnable.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ QQAppInterface f243070d;

                        {
                            this.f243070d = qQAppInterface;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuideRunnable.this, (Object) qQAppInterface);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f243070d.getRuntimeService(IPhoneContactService.class, "");
                            if (iPhoneContactService != null) {
                                iPhoneContactService.markAndUploadForNewGuide();
                            }
                        }
                    }, 16, null, false);
                }
                LoginUserGuideHelper.d(activity, qQAppInterface, this.f243068f, this.f243069h);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a extends LbsManagerServiceOnLocationChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f243071a;

        /* renamed from: b, reason: collision with root package name */
        public int f243072b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f243073c;

        public a(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                return;
            }
            this.f243071a = 0;
            this.f243072b = 0;
            this.f243073c = false;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            SosoLocation sosoLocation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) sosoLbsInfo);
                return;
            }
            if (i3 == 0 && sosoLbsInfo != null && (sosoLocation = sosoLbsInfo.mLocation) != null) {
                this.f243073c = true;
                this.f243071a = (int) (sosoLocation.mLon02 * 1000000.0d);
                this.f243072b = (int) (sosoLocation.mLat02 * 1000000.0d);
            }
            if (QLog.isColorLevel()) {
                QLog.i("LoginUserGuideHelper", 2, String.format("onLocationFinish [%s, %s, %s]", Integer.valueOf(i3), Integer.valueOf(this.f243071a), Integer.valueOf(this.f243072b)));
            }
        }
    }

    public static void a(Activity activity, QQAppInterface qQAppInterface, a aVar) {
        PermissionChecker.e(activity, new GuideRunnable(activity, qQAppInterface, true, aVar), new GuideRunnable(activity, qQAppInterface, false, aVar));
    }

    public static void b(Activity activity, QQAppInterface qQAppInterface, a aVar) {
        if (activity != null && qQAppInterface != null) {
            if (QLog.isColorLevel()) {
                QLog.i("LoginUserGuideHelper", 2, "goWithoutFindFriend");
            }
            d(activity, qQAppInterface, false, aVar);
        }
    }

    private static String c(boolean z16, LoginWelcomeManager.k kVar, a aVar) {
        String str;
        int i3;
        int i16;
        SosoLocation sosoLocation;
        StringBuilder sb5 = new StringBuilder(200);
        sb5.append(kVar.f243097c);
        sb5.append("&ab_auth=");
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        sb5.append(str);
        if (kVar.f243098d != -1) {
            sb5.append("&friends_recommend_flag=");
            sb5.append(kVar.f243098d);
        }
        if (kVar.f243099e != -1) {
            sb5.append("&groups_recommend_flag=");
            sb5.append(kVar.f243099e);
        }
        boolean z17 = true;
        if (aVar != null && aVar.f243073c) {
            i3 = aVar.f243072b;
            i16 = aVar.f243071a;
        } else {
            SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("Login.Guide");
            if (cachedLbsInfo != null && (sosoLocation = cachedLbsInfo.mLocation) != null) {
                i16 = (int) (sosoLocation.mLat02 * 1000000.0d);
                i3 = (int) (sosoLocation.mLon02 * 1000000.0d);
            } else {
                z17 = false;
                i3 = 0;
                i16 = 0;
            }
        }
        if (z17) {
            sb5.append("&lat=");
            sb5.append(i3);
            sb5.append("&lng=");
            sb5.append(i16);
        }
        if (QLog.isColorLevel()) {
            QLog.i("LoginUserGuideHelper", 2, "makeUrl: " + sb5.toString());
        }
        return sb5.toString();
    }

    public static void d(Activity activity, QQAppInterface qQAppInterface, boolean z16, a aVar) {
        if (activity != null && qQAppInterface != null) {
            if (QLog.isColorLevel()) {
                QLog.i("LoginUserGuideHelper", 2, "openWebGuide hasAuth: " + z16);
            }
            String c16 = c(z16, LoginWelcomeManager.o(qQAppInterface).q(), aVar);
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra(QQBrowserActivity.IS_WRAP_CONTENT, true);
            intent.putExtra("url", c16);
            intent.putExtra("hide_more_button", true);
            intent.putExtra("webStyle", "noBottomBar");
            intent.putExtra("isScreenOrientationPortrait", true);
            intent.addFlags(603979776);
            activity.startActivity(intent);
        }
    }

    public static void e(String str, JSONObject jSONObject) {
        ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getSharedPreferences("upload_for_new_guide", str, 4).edit().putString("upload_for_new_guide", jSONObject.toString()).commit();
    }

    public static void f(Activity activity, QQAppInterface qQAppInterface) {
        if (activity != null && qQAppInterface != null) {
            PermissionChecker.e(activity, new Runnable() { // from class: com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQAppInterface.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                IPhoneContactService iPhoneContactService = (IPhoneContactService) QQAppInterface.this.getRuntimeService(IPhoneContactService.class, "");
                                if (iPhoneContactService != null) {
                                    iPhoneContactService.uploadOrUpdateContact();
                                }
                            }
                        }, 16, null, true);
                    }
                }
            }, new DenyRunnable(activity, new DenyRunnable.a(qQAppInterface)));
        }
    }
}
