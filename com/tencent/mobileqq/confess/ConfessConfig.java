package com.tencent.mobileqq.confess;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.core.EventListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ConfessConfig {
    static IPatchRedirector $redirector_;
    public static final String K;
    public static final String L;
    public static final String M;
    public static final String N;
    public static final String O;
    public static final String P;
    public static final String Q;
    public static final String R;
    private static File S;
    private int A;
    private String B;
    private long C;
    private boolean D;
    private String E;
    private long F;
    private final Random G;
    private int H;
    private Object I;
    boolean J;

    /* renamed from: a, reason: collision with root package name */
    public int f202057a;

    /* renamed from: b, reason: collision with root package name */
    public int f202058b;

    /* renamed from: c, reason: collision with root package name */
    public int f202059c;

    /* renamed from: d, reason: collision with root package name */
    public int f202060d;

    /* renamed from: e, reason: collision with root package name */
    public int f202061e;

    /* renamed from: f, reason: collision with root package name */
    public int f202062f;

    /* renamed from: g, reason: collision with root package name */
    public float f202063g;

    /* renamed from: h, reason: collision with root package name */
    public String f202064h;

    /* renamed from: i, reason: collision with root package name */
    public String f202065i;

    /* renamed from: j, reason: collision with root package name */
    public String f202066j;

    /* renamed from: k, reason: collision with root package name */
    public String f202067k;

    /* renamed from: l, reason: collision with root package name */
    public String f202068l;

    /* renamed from: m, reason: collision with root package name */
    public String f202069m;

    /* renamed from: n, reason: collision with root package name */
    public String f202070n;

    /* renamed from: o, reason: collision with root package name */
    public String f202071o;

    /* renamed from: p, reason: collision with root package name */
    public String f202072p;

    /* renamed from: q, reason: collision with root package name */
    public int f202073q;

    /* renamed from: r, reason: collision with root package name */
    public int f202074r;

    /* renamed from: s, reason: collision with root package name */
    public int f202075s;

    /* renamed from: t, reason: collision with root package name */
    public String f202076t;

    /* renamed from: u, reason: collision with root package name */
    public int f202077u;

    /* renamed from: v, reason: collision with root package name */
    public String f202078v;

    /* renamed from: w, reason: collision with root package name */
    public int f202079w;

    /* renamed from: x, reason: collision with root package name */
    public long f202080x;

    /* renamed from: y, reason: collision with root package name */
    public int f202081y;

    /* renamed from: z, reason: collision with root package name */
    private long f202082z;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71309);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        K = HardCodeUtil.qqStr(R.string.kyv);
        L = HardCodeUtil.qqStr(R.string.kyt);
        M = HardCodeUtil.qqStr(R.string.kyy);
        N = HardCodeUtil.qqStr(R.string.kyz);
        O = HardCodeUtil.qqStr(R.string.kyu);
        P = HardCodeUtil.qqStr(R.string.kyw);
        Q = HardCodeUtil.qqStr(R.string.f171783kz1);
        R = HardCodeUtil.qqStr(R.string.kyx);
        S = new File(BaseApplicationImpl.getApplication().getFilesDir(), "confess_talk");
    }

    public ConfessConfig(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f202077u = 24;
        this.I = new Object();
        this.J = false;
        this.B = str;
        SharedPreferences E = ea.E(str, AppConstants.Preferences.CONFESS_CONFIG_SP);
        this.G = new Random(SystemClock.elapsedRealtime());
        this.f202082z = E.getLong("lLastVanishTime", 0L);
        this.A = E.getInt("nContinuousVanishCount", 0);
        j(null, true);
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.confess.ConfessConfig.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ConfessConfig.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ConfessConfig.this.f();
                }
            }
        }, null, true);
    }

    private String b() {
        String str;
        try {
            str = FileUtils.readFileToString(new File(S, "confess_talk.cfg"));
        } catch (IOException e16) {
            QLog.i("ConfessConfig", 1, "getConfigFromFile exception : " + QLog.getStackTraceString(e16));
            str = "";
        }
        if (QLog.isColorLevel()) {
            QLog.i("ConfessConfig", 2, "getConfigFromFile config is: " + str);
        }
        return str;
    }

    public static int c(long j3, long j16) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        int i3 = calendar.get(6);
        int i16 = calendar.get(1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j16);
        int i17 = calendar2.get(6);
        int i18 = calendar.get(1);
        int i19 = i3 - i17;
        if (i18 != i16) {
            while (i18 < i16) {
                if ((i18 % 4 == 0 && i18 % 100 != 0) || i18 % 400 == 0) {
                    i19 += 366;
                } else {
                    i19 += 365;
                }
                i18++;
            }
        }
        return i19;
    }

    public static long d(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface == null) {
            return 0L;
        }
        return ea.E(qQAppInterface.getAccount(), AppConstants.Preferences.CONFESS_CONFIG_SP).getLong(str, 0L);
    }

    public static boolean h(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface == null || ea.E(qQAppInterface.getAccount(), AppConstants.Preferences.CONFESS_CONFIG_SP).getLong(str, 0L) <= 0) {
            return false;
        }
        return true;
    }

    private void j(String str, boolean z16) {
        String str2;
        this.D = false;
        this.C = 0L;
        this.F = 0L;
        this.E = "";
        this.H = 0;
        this.f202074r = 1;
        this.f202075s = 0;
        this.f202076t = "";
        this.f202077u = 24;
        this.f202079w = 5;
        this.f202081y = 0;
        if (TextUtils.isEmpty(str)) {
            this.f202057a = 0;
            this.f202058b = 0;
            this.f202059c = 0;
            this.f202060d = 0;
            this.f202061e = 0;
            this.f202062f = 0;
            this.f202063g = 5.0f;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(Element.ELEMENT_NAME_MIN)) {
                    this.f202058b = jSONObject.getInt(Element.ELEMENT_NAME_MIN);
                }
                if (jSONObject.has("max")) {
                    this.f202059c = jSONObject.getInt("max");
                }
                if (jSONObject.has(EventListener.KEY_DELTA)) {
                    this.f202060d = jSONObject.getInt(EventListener.KEY_DELTA);
                }
                if (jSONObject.has("X")) {
                    this.f202061e = jSONObject.getInt("X");
                }
                if (jSONObject.has("Y")) {
                    this.f202062f = jSONObject.getInt("Y");
                }
                if (jSONObject.has("contactEntryUrl")) {
                    this.f202067k = jSONObject.getString("contactEntryUrl");
                }
                if (jSONObject.has("boxEntryUrl")) {
                    this.f202066j = jSONObject.getString("boxEntryUrl");
                }
                if (jSONObject.has("title")) {
                    this.f202064h = jSONObject.getString("title");
                }
                if (jSONObject.has("subtitle")) {
                    this.f202065i = jSONObject.getString("subtitle");
                }
                if (jSONObject.has("changeInterval")) {
                    this.f202063g = (float) jSONObject.getDouble("changeInterval");
                }
                if (jSONObject.has("frdRecUrl")) {
                    this.f202068l = jSONObject.getString("frdRecUrl");
                }
                if (jSONObject.has("frdRecMsgSwitch")) {
                    this.H = jSONObject.getInt("frdRecMsgSwitch");
                }
                if (jSONObject.has("detailUrl")) {
                    this.f202069m = jSONObject.getString("detailUrl");
                }
                if (jSONObject.has("settingUrl")) {
                    this.f202071o = jSONObject.getString("settingUrl");
                }
                if (jSONObject.has("entryBoxSwitch")) {
                    this.f202074r = jSONObject.getInt("entryBoxSwitch");
                }
                if (jSONObject.has("entryContactSwitch")) {
                    this.f202075s = jSONObject.getInt("entryContactSwitch");
                }
                if (jSONObject.has("redPointText")) {
                    this.f202076t = jSONObject.getString("redPointText");
                }
                if (jSONObject.has("blockTime")) {
                    this.f202077u = jSONObject.getInt("blockTime");
                }
                if (jSONObject.has("groupCfsListUrl")) {
                    this.f202070n = jSONObject.getString("groupCfsListUrl");
                }
                if (jSONObject.has("rankingSwitch")) {
                    this.f202073q = jSONObject.getInt("rankingSwitch");
                }
                if (jSONObject.has("rankingUrl")) {
                    this.f202072p = jSONObject.getString("rankingUrl");
                }
                if (jSONObject.has("holmesCount")) {
                    this.f202079w = jSONObject.optInt("holmesCount", 5);
                }
                if (jSONObject.has("holmesUrl")) {
                    this.f202078v = jSONObject.optString("holmesUrl");
                }
                if (jSONObject.has("holmesSwitch")) {
                    this.f202081y = jSONObject.optInt("holmesSwitch", 0);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(this.f202067k)) {
            this.f202067k = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=contact_tab";
        }
        if (TextUtils.isEmpty(this.f202066j)) {
            this.f202066j = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        }
        if (TextUtils.isEmpty(this.f202064h)) {
            this.f202064h = K;
        }
        if (TextUtils.isEmpty(this.f202065i)) {
            this.f202065i = L;
        }
        if (TextUtils.isEmpty(this.f202068l)) {
            this.f202068l = "https://ti.qq.com/honest-say/friends-received.html?_bid=3104&_wv=9191&_qStyle=1&adtag=message_box";
        }
        if (TextUtils.isEmpty(this.f202069m)) {
            this.f202069m = "https://ti.qq.com/honest-say/confess-detail.html?_bid=3104&_wv=9191&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&ADTAG=aio_card";
        }
        if (TextUtils.isEmpty(this.f202071o)) {
            this.f202071o = "https://ti.qq.com/honest-say/setting.html?_wv=9191&_wwv=4&_qStyle=1&adtag=message_box";
        }
        if (TextUtils.isEmpty(this.f202076t)) {
            this.f202076t = M;
        }
        if (TextUtils.isEmpty(this.f202070n)) {
            this.f202070n = "https://ti.qq.com/honest-say/group-received.html?_bid=3104&_wv=9191&_qStyle=1";
        }
        if (TextUtils.isEmpty(this.f202072p)) {
            this.f202072p = "https://ti.qq.com/honest-say/rank.html?_wv=9191&_wwv=4&_qStyle=1";
        }
        if (TextUtils.isEmpty(this.f202078v)) {
            this.f202078v = "https://ti.qq.com/honest-say/holmes.html?_nav_alpha=0&_wwv=4&_qStyle=1";
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (!z16) {
            long K0 = com.tencent.mobileqq.service.message.e.K0();
            this.f202080x = K0;
            l(qQAppInterface, "rec_config_time", K0);
        } else {
            this.f202080x = d(qQAppInterface, "rec_config_time");
        }
        if (QLog.isDevelopLevel()) {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[2];
            if (z16) {
                str2 = "local";
            } else {
                str2 = "server";
            }
            objArr[0] = str2;
            objArr[1] = str;
            QLog.i("ConfessConfig", 4, String.format(locale, "parse %s config: %s", objArr));
        }
    }

    public static boolean k(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("ConfessConfig", 2, "saveConfig2File config is: " + str);
        }
        String str2 = S.getPath() + File.separator;
        if (str == null) {
            str = "";
        }
        boolean writeFile = FileUtils.writeFile(str2, "confess_talk.cfg", str);
        QLog.i("ConfessConfig", 1, "saveConfig2File result : " + writeFile);
        return writeFile;
    }

    public static void l(QQAppInterface qQAppInterface, String str, long j3) {
        if (qQAppInterface == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ConfessConfig", 2, String.format("saveRedPointShow key:%s value:%d", str, Long.valueOf(j3)));
        }
        ea.E(qQAppInterface.getAccount(), AppConstants.Preferences.CONFESS_CONFIG_SP).edit().putLong(str, j3).apply();
    }

    public boolean a() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (Math.abs(elapsedRealtime - this.C) < 60000) {
            return this.D;
        }
        boolean z17 = false;
        if (this.f202075s >= 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && TextUtils.isEmpty(this.f202067k)) {
            z16 = false;
        }
        if (z16) {
            if (c(NetConnInfoCenter.getServerTimeMillis(), this.f202082z) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        if (z16 && this.A >= this.f202061e) {
            if (c(NetConnInfoCenter.getServerTimeMillis(), this.f202082z) > this.f202062f) {
                z17 = true;
            }
            z16 = z17;
        }
        this.C = elapsedRealtime;
        this.D = z16;
        return z16;
    }

    public String e(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQAppInterface);
        }
        if (h(qQAppInterface, "redpoint_leba_show")) {
            String str = this.f202076t;
            if (str == null) {
                return M;
            }
            return str;
        }
        String str2 = this.f202064h;
        if (str2 == null) {
            return K;
        }
        return str2;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.J) {
            return;
        }
        String b16 = b();
        synchronized (this.I) {
            if (!this.J) {
                j(b16, true);
                this.J = true;
            }
        }
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.H == 1) {
            return true;
        }
        return false;
    }

    public boolean i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i("ConfessConfig", 2, "onGetConfigFromServer config :" + str);
        }
        synchronized (this.I) {
            j(str, false);
        }
        return k(str);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(140);
        sb5.append("HonestSayConfig{");
        sb5.append("nSwitch: ");
        sb5.append(this.f202057a);
        sb5.append(", frdRecMsgSwitch: ");
        sb5.append(this.H);
        sb5.append(", nMin: ");
        sb5.append(this.f202058b);
        sb5.append(", nMax: ");
        sb5.append(this.f202059c);
        sb5.append(", nDelta: ");
        sb5.append(this.f202060d);
        sb5.append(", nX: ");
        sb5.append(this.f202061e);
        sb5.append(", nY: ");
        sb5.append(this.f202062f);
        sb5.append(", fChangeInterval: ");
        sb5.append(this.f202063g);
        sb5.append(", title: ");
        sb5.append(this.f202064h);
        sb5.append(", subtitle: ");
        sb5.append(this.f202065i);
        sb5.append(", contactEntryUrl: ");
        sb5.append(this.f202067k);
        sb5.append(", boxEntryUrl: ");
        sb5.append(this.f202066j);
        sb5.append(", detailUrl: ");
        sb5.append(this.f202069m);
        sb5.append(", settingUrl: ");
        sb5.append(this.f202071o);
        sb5.append(", lLastVanishTime: ");
        sb5.append(this.f202082z);
        sb5.append(", nContinuousVanishCount: ");
        sb5.append(this.A);
        sb5.append(", rankingUrl: ");
        sb5.append(this.f202072p);
        sb5.append(", rankSwitch: ");
        sb5.append(this.f202073q);
        sb5.append("}");
        return sb5.toString();
    }
}
