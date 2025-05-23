package com.tencent.common.config.pad;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static int f99570c;

    /* renamed from: d, reason: collision with root package name */
    private static f f99571d;

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f99572e;

    /* renamed from: f, reason: collision with root package name */
    private static Boolean f99573f;

    /* renamed from: g, reason: collision with root package name */
    private static Boolean f99574g;

    /* renamed from: h, reason: collision with root package name */
    private static Integer f99575h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f99576i;

    /* renamed from: j, reason: collision with root package name */
    private static final MMKVOptionEntityV2 f99577j;

    /* renamed from: k, reason: collision with root package name */
    private static long f99578k;

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, e> f99579a;

    /* renamed from: b, reason: collision with root package name */
    private Integer f99580b;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f99581a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Looper looper, d dVar) {
            super(looper);
            this.f99581a = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper, (Object) dVar);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            super.handleMessage(message);
            Bundle data = message.getData();
            int i3 = data.getInt("key_authentication_type");
            int i16 = data.getInt("key_authentication_result_code");
            if (i16 != 102 && i16 != 103) {
                string = "";
            } else {
                string = data.getString("key_authentication_message");
            }
            QLog.i("NubiaDeviceUtil", 1, "CredentialConfirm msg type " + i3 + " resultCode " + i16 + " resultMsg " + string);
            if (i16 == 100 && f.a()) {
                QLog.i("NubiaDeviceUtil", 1, "success too fast, ignore");
                return;
            }
            d dVar = this.f99581a;
            if (dVar != null) {
                dVar.a(i3, i16, string);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends ContentObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f99582a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Handler handler, Uri uri) {
            super(handler);
            this.f99582a = uri;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) handler, (Object) uri);
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16, @Nullable Uri uri) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), uri);
                return;
            }
            super.onChange(z16, uri);
            int e16 = f.e();
            int i3 = f.i(BaseApplication.getContext());
            boolean equals = this.f99582a.equals(uri);
            QLog.i("NubiaDeviceUtil", 1, "onChange minors_mode_age_range? " + equals + " currentAge " + e16 + " systemAge " + i3);
            if (equals && e16 != i3) {
                QLog.i("NubiaDeviceUtil", 1, "onChange minors_mode_age_range isSelf " + z16);
                f.x(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c extends ContentObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f99583a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Handler handler, Uri uri) {
            super(handler);
            this.f99583a = uri;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) handler, (Object) uri);
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16, @Nullable Uri uri) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), uri);
                return;
            }
            super.onChange(z16);
            boolean k3 = f.k(BaseApplication.getContext());
            boolean f16 = f.f();
            boolean equals = this.f99583a.equals(uri);
            QLog.i("NubiaDeviceUtil", 1, "onChange minors_mode_enabled? " + equals + " sysState " + k3 + " appDeviceState " + f16);
            if (equals && k3 != f16) {
                QLog.i("NubiaDeviceUtil", 1, "onChange minors_mode_enabled isSelf " + z16);
                f.x(2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
        void a(int i3, int i16, String str);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface e {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36834);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f99570c = -1;
        f99572e = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("device_linkage_switch", true);
        f99573f = null;
        f99574g = null;
        f99575h = null;
        f99576i = false;
        f99577j = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        f99578k = 0L;
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f99579a = new HashMap();
            this.f99580b = 0;
        }
    }

    static /* bridge */ /* synthetic */ boolean a() {
        return n();
    }

    public static int d() {
        int i3 = f99570c;
        f99570c = -1;
        return i3;
    }

    public static int e() {
        Integer num = f99575h;
        if (num == null) {
            num = Integer.valueOf(f99577j.getInt(h("STUDY_MODE_DEVICE_AGE"), 0));
            if (num == null) {
                num = 0;
            }
            f99575h = num;
        }
        return num.intValue();
    }

    public static boolean f() {
        if (!MobileQQ.PACKAGE_NAME.equals(MobileQQ.processName)) {
            return f99577j.getBoolean(h("STUDY_MODE_DEVICE_SWITCH"), false);
        }
        Boolean bool = f99574g;
        if (bool == null) {
            bool = Boolean.valueOf(f99577j.getBoolean(h("STUDY_MODE_DEVICE_SWITCH"), false));
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            f99574g = bool;
        }
        return bool.booleanValue();
    }

    public static f g() {
        if (f99571d == null) {
            synchronized (f.class) {
                if (f99571d == null) {
                    f99571d = new f();
                }
            }
        }
        return f99571d;
    }

    private static String h(String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return str;
        }
        String str2 = str + "_" + peekAppRuntime.getCurrentUin();
        QLog.i("NubiaDeviceUtil", 1, "getKeyWithUin " + str2);
        return str2;
    }

    public static int i(Context context) {
        if (context == null) {
            return 0;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "minors_mode_age_range", 0);
    }

    public static String j(Context context) {
        int i3 = i(context);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return "";
                        }
                        return "16-18\u5c81";
                    }
                    return "12-15\u5c81";
                }
                return "8-11\u5c81";
            }
            return "3-7\u5c81";
        }
        return "0-2\u5c81";
    }

    public static boolean k(Context context) {
        if (Settings.Secure.getInt(context.getContentResolver(), "minors_mode_enabled", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean l() {
        if (!MobileQQ.PACKAGE_NAME.equals(MobileQQ.processName)) {
            return f99577j.getBoolean(h("STUDY_MODE_USER_SET_DEVICE_SWITCH"), true);
        }
        Boolean bool = f99573f;
        if (bool == null) {
            bool = Boolean.valueOf(f99577j.getBoolean(h("STUDY_MODE_USER_SET_DEVICE_SWITCH"), true));
            if (bool == null) {
                bool = Boolean.TRUE;
            }
            f99573f = bool;
        }
        return bool.booleanValue();
    }

    public static boolean m() {
        return f99572e;
    }

    private static boolean n() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f99578k >= 500) {
            f99578k = currentTimeMillis;
            return false;
        }
        QLog.i("NubiaDeviceUtil", 1, "isFastClick");
        f99578k = currentTimeMillis;
        return true;
    }

    public static boolean o() {
        boolean l3 = l();
        boolean f16 = f();
        boolean m3 = m();
        if (l3 && f16 && m3) {
            return true;
        }
        return false;
    }

    public static void p(Context context, d dVar) {
        Intent intent = new Intent();
        intent.setAction("com.android.action.PARENTAL_CREDENTIAL_AUTHENTICATE");
        intent.addFlags(268435456);
        intent.putExtra("key_authentication_messenger", new Messenger(new a(Looper.getMainLooper(), dVar)));
        context.startActivity(intent);
    }

    public static void r(int i3) {
        QLog.i("NubiaDeviceUtil", 1, "setCurrentMinosDeviceAge " + i3);
        f99575h = Integer.valueOf(i3);
        f99577j.putInt(h("STUDY_MODE_DEVICE_AGE"), i3);
    }

    public static void s(Boolean bool) {
        QLog.i("NubiaDeviceUtil", 1, "setCurrentMinosDeviceSwitch " + bool);
        f99574g = bool;
        f99577j.putBoolean(h("STUDY_MODE_DEVICE_SWITCH"), bool.booleanValue());
    }

    public static void t(Boolean bool) {
        QLog.i("NubiaDeviceUtil", 1, "setUserSetMinosDeviceSwitch " + bool);
        f99573f = bool;
        f99577j.putBoolean(h("STUDY_MODE_USER_SET_DEVICE_SWITCH"), bool.booleanValue());
    }

    public static void u(Context context, Handler handler) {
        if (context != null && handler != null) {
            Uri uriFor = Settings.Secure.getUriFor("minors_mode_age_range");
            context.getContentResolver().registerContentObserver(uriFor, false, new b(handler, uriFor));
        } else {
            QLog.i("NubiaDeviceUtil", 1, "startWatchingMinorsModeAgeRange context or handler is null");
        }
    }

    private static void v(Context context, Handler handler) {
        if (context != null && handler != null) {
            Uri uriFor = Settings.Secure.getUriFor("minors_mode_enabled");
            context.getContentResolver().registerContentObserver(uriFor, false, new c(handler, uriFor));
        } else {
            QLog.i("NubiaDeviceUtil", 1, "startWatchingMinorsModeState context or handler is null");
        }
    }

    public static boolean w(Context context) {
        if (Settings.Secure.getInt(context.getContentResolver(), "minors_mode", 0) != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x(int i3) {
        if (f99570c > i3) {
            return;
        }
        f99570c = i3;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        f99573f = null;
        f99574g = null;
        f99575h = null;
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("NubiaDeviceUtil", 1, "onAccountChange deviceLinkageSwitch " + f99572e);
        c();
        if (f99576i) {
            return;
        }
        f99576i = true;
        v(BaseApplication.getContext(), new Handler(Looper.getMainLooper()));
        u(BaseApplication.getContext(), new Handler(Looper.getMainLooper()));
    }
}
