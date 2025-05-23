package com.tencent.mobileqq.activity.contact.phonecontact;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MobileUnityBannerProcessor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.manager.Manager;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes10.dex */
public class PhoneUnityManager implements Manager {
    static IPatchRedirector $redirector_;
    public boolean C;
    public Bundle D;
    Runnable E;
    Runnable F;
    public long G;

    /* renamed from: d, reason: collision with root package name */
    public boolean f181279d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.mobileqq.activity.contact.phonecontact.a f181280e;

    /* renamed from: f, reason: collision with root package name */
    public b f181281f;

    /* renamed from: h, reason: collision with root package name */
    public QQAppInterface f181282h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f181283i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f181284m;

    /* loaded from: classes10.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f181285a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f181286b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f181287c;

        /* renamed from: d, reason: collision with root package name */
        public int f181288d;

        /* renamed from: e, reason: collision with root package name */
        public String f181289e;

        /* renamed from: f, reason: collision with root package name */
        public String f181290f;

        /* renamed from: g, reason: collision with root package name */
        public String f181291g;

        /* renamed from: h, reason: collision with root package name */
        public String f181292h;

        /* renamed from: i, reason: collision with root package name */
        public SparseArray<byte[]> f181293i;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f181285a = false;
            this.f181286b = false;
            this.f181287c = false;
            this.f181288d = 0;
            this.f181289e = null;
            this.f181290f = null;
            this.f181291g = null;
            this.f181292h = null;
            this.f181293i = new SparseArray<>();
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f181285a = false;
            this.f181287c = false;
            this.f181286b = false;
            this.f181289e = null;
            this.f181288d = 2;
            this.f181290f = null;
            this.f181291g = null;
            this.f181292h = null;
            this.f181293i.clear();
        }
    }

    public PhoneUnityManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f181279d = false;
        this.f181284m = false;
        this.C = false;
        this.E = new Runnable() { // from class: com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhoneUnityManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    PhoneUnityManager.this.o();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        this.F = new Runnable() { // from class: com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhoneUnityManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("MobileUnityManager", 4, "load phone local data");
                }
                ((SecSvcHandler) PhoneUnityManager.this.f181282h.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER)).notifyUI(9, true, PhoneUnityManager.this.h());
            }
        };
        this.f181282h = qQAppInterface;
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 7) {
            int length = str.length();
            return str.substring(0, length - 8) + "******" + str.substring(length - 2);
        }
        return "";
    }

    public static void k(QQAppInterface qQAppInterface, String str, Bundle bundle) {
        int i3;
        if (bundle != null && str != null) {
            boolean z16 = false;
            int i16 = 4;
            if (bundle.getInt("status", 0) != 4) {
                String string = bundle.getString("phone");
                boolean z17 = !bundle.getBoolean("phone_verified", true);
                boolean z18 = bundle.getBoolean("bool_is_IOT", false);
                int i17 = bundle.getInt("status", 0);
                if (z18) {
                    i16 = 6;
                } else if (z17) {
                    i16 = 5;
                } else if (i17 != 3) {
                    if (!TextUtils.isEmpty(string)) {
                        i16 = 1;
                    } else {
                        i16 = 3;
                    }
                }
                if (bundle.getInt("need_unify", 0) == 1 && !TextUtils.isEmpty(string)) {
                    z16 = true;
                }
                if (z16) {
                    i3 = 2;
                } else {
                    i3 = i16;
                }
                ReportController.o(qQAppInterface, "dc00898", "", "", str, str, i3, 0, "", "", "", "");
            }
        }
    }

    public static void m(Activity activity, QQAppInterface qQAppInterface, String str, int i3) {
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("uin", qQAppInterface.getCurrentAccountUin());
        intent.putExtra("url", str);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("portraitOnly", true);
        intent.putExtra("isShowAd", false);
        intent.putExtra("needResult", true);
        intent.putExtra("business", 16384L);
        activity.startActivityForResult(intent, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        int i3;
        b i16 = i();
        if (QLog.isColorLevel()) {
            QLog.d("MobileUnityManager", 2, "tryShowBannerInner ve" + this.f181281f);
        }
        long j3 = i16.f181307e;
        if (j3 > 0) {
            i16.f181307e = j3 - 1;
            p(i16);
            return;
        }
        if (i16.f181303a == -1) {
            return;
        }
        com.tencent.mobileqq.activity.contact.phonecontact.a h16 = h();
        if (QLog.isColorLevel()) {
            QLog.d("MobileUnityManager", 2, "tryShowBannerInner bd " + h16);
        }
        if (h16 != null && h16.f181300g > 0 && h16.f181296c > 0 && h16.f181301h && i16.f181306d > 0) {
            long j16 = i16.f181304b;
            boolean z16 = true;
            long j17 = (h16.f181297d + 1) * 24 * 60 * 60 * 1000;
            long currentTimeMillis = System.currentTimeMillis();
            long j18 = currentTimeMillis - j16;
            if (j18 > j17) {
                i16.f181304b = currentTimeMillis;
                i16.f181306d--;
                i16.f181305c = h16.f181296c - 1;
                p(i16);
            } else if (j18 < 86400000 && (i3 = i16.f181305c) > 0) {
                i16.f181306d--;
                i16.f181305c = i3 - 1;
                p(i16);
            } else {
                z16 = false;
            }
            if (z16) {
                if (((IPhoneContactService) this.f181282h.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MobileUnityManager", 2, "tryShowBannerInner already binded");
                    }
                } else {
                    Message obtain = Message.obtain();
                    obtain.obj = h16;
                    BannerManager.l().O(MobileUnityBannerProcessor.f185231d, 2, obtain);
                }
            }
        }
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        BaseApplication context = BaseApplication.getContext();
        String str = context.getFilesDir().getAbsolutePath() + File.separator + this.f181282h.getCurrentAccountUin() + ".mobileunity";
        if (QLog.isColorLevel()) {
            QLog.d("MobileUnityManager", 2, "getBannerConfigFilePath path = " + str);
        }
        return str;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return i().f181303a;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ThreadManagerV2.post(this.F, 5, null, false);
        }
    }

    public SharedPreferences f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return BaseApplicationImpl.sApplication.getSharedPreferences("PhoneUnityManager_" + this.f181282h.getCurrentAccountUin(), 0);
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f181284m;
    }

    public com.tencent.mobileqq.activity.contact.phonecontact.a h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.mobileqq.activity.contact.phonecontact.a) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        com.tencent.mobileqq.activity.contact.phonecontact.a aVar = this.f181280e;
        if (aVar != null) {
            return aVar;
        }
        String c16 = c();
        if (TextUtils.isEmpty(c16)) {
            this.f181280e = null;
            return null;
        }
        BaseApplication.getContext();
        File file = new File(c16);
        try {
            if (file.exists()) {
                this.f181280e = com.tencent.mobileqq.activity.contact.phonecontact.a.a(FileUtils.readFileContent(file));
            }
            return this.f181280e;
        } catch (IOException | XmlPullParserException | Exception unused) {
            return this.f181280e;
        }
    }

    public b i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        b bVar = this.f181281f;
        if (bVar != null) {
            return bVar;
        }
        b a16 = b.a(f().getString("mobileunityversion", ""));
        this.f181281f = a16;
        return a16;
    }

    public void j(Bundle bundle) {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        this.D = bundle;
        this.f181283i = false;
        String str = null;
        if (bundle != null) {
            if (bundle.getInt("need_unify") == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f181283i = z17;
            Bundle[] bundleArr = (Bundle[]) bundle.getParcelableArray("phone_info");
            if (bundleArr != null) {
                for (Bundle bundle2 : bundleArr) {
                    int i3 = bundle2.getInt("phone_type");
                    if (i3 != 2) {
                        if (i3 == 3) {
                            str = bundle2.getString("phone");
                        }
                    } else {
                        String string = bundle2.getString("phone");
                        if (bundle2.getInt("status") == 1 && !TextUtils.isEmpty(string)) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        this.f181284m = z18;
                    }
                }
            }
        }
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f181282h.getRuntimeService(IPhoneContactService.class, "");
        int selfBindState = iPhoneContactService.getSelfBindState();
        if ((!TextUtils.isEmpty(str) && selfBindState <= 5) || ((TextUtils.isEmpty(str) && selfBindState > 5) || ((TextUtils.isEmpty(str) && selfBindState >= 8) || (!TextUtils.isEmpty(str) && selfBindState == 7)))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            iPhoneContactService.checkUpdateBindStateAndListIgnoreBindState(true, false, 13);
        }
        if (QLog.isColorLevel()) {
            QLog.i("MobileUnityManager", 2, String.format("onGetBindInfo [%s, %s, %s, %s]", Integer.valueOf(selfBindState), Boolean.valueOf(z16), str, bundle));
        }
    }

    public void l(int i3, String str, com.tencent.mobileqq.activity.contact.phonecontact.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), str, aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MobileUnityManager", 2, "saveBannerConfig");
        }
        QQAppInterface qQAppInterface = this.f181282h;
        if (qQAppInterface == null || TextUtils.isEmpty(qQAppInterface.getCurrentAccountUin())) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MobileUnityManager", 2, "saveBannerConfig " + str);
        }
        String c16 = c();
        try {
            if (TextUtils.isEmpty(str)) {
                FileUtils.deleteFile(c16);
                p(null);
                this.f181280e = null;
                return;
            }
            if (aVar != null) {
                FileUtils.createFile(c16);
                FileUtils.writeFile(c16, str);
                this.f181280e = aVar;
                if (QLog.isColorLevel()) {
                    QLog.d("MobileUnityManager", 2, "saveBannerConfig date = " + this.f181280e);
                }
                ReportController.o(this.f181282h, "CliOper", "", "", "0X8005B71 ", "0X8005B71 ", 0, 0, "", "", "", "");
                b i16 = i();
                if (i16 != null) {
                    i16.f181304b = 0L;
                    i16.f181303a = i3;
                    i16.f181306d = aVar.f181298e;
                    i16.f181305c = aVar.f181296c;
                    i16.f181307e = aVar.f181300g;
                    p(i16);
                    n();
                }
            }
        } catch (Throwable th5) {
            FileUtils.delete(c16, true);
            QLog.e("MobileUnityManager", 1, "", th5);
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MobileUnityManager", 2, "tryShowBanner");
        }
        ThreadManager.getSubThreadHandler().postDelayed(this.E, 5000L);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public void p(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
        } else if (bVar == null) {
            this.f181281f = null;
            f().edit().remove("mobileunityversion").commit();
        } else {
            this.f181281f = bVar;
            f().edit().putString("mobileunityversion", bVar.b()).commit();
        }
    }
}
