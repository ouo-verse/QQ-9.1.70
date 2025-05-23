package com.tencent.mobileqq.ptt;

import android.content.SharedPreferences;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.voicechange.IVoiceTuneUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import okhttp3.HttpUrl;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes16.dex */
public class l implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    public static final int f261242n;

    /* renamed from: a, reason: collision with root package name */
    public int[] f261243a;

    /* renamed from: b, reason: collision with root package name */
    int f261244b;

    /* renamed from: c, reason: collision with root package name */
    int f261245c;

    /* renamed from: d, reason: collision with root package name */
    int f261246d;

    /* renamed from: e, reason: collision with root package name */
    int f261247e;

    /* renamed from: f, reason: collision with root package name */
    public int f261248f;

    /* renamed from: g, reason: collision with root package name */
    public int f261249g;

    /* renamed from: h, reason: collision with root package name */
    public float f261250h;

    /* renamed from: i, reason: collision with root package name */
    float f261251i;

    /* renamed from: j, reason: collision with root package name */
    private int f261252j;

    /* renamed from: k, reason: collision with root package name */
    int f261253k;

    /* renamed from: l, reason: collision with root package name */
    int f261254l;

    /* renamed from: m, reason: collision with root package name */
    private WeakReference<AppRuntime> f261255m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21638);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f261242n = IVoiceTuneUtil.VOICE_TYPES.length;
        }
    }

    public l(AppRuntime appRuntime) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        int i16 = f261242n;
        this.f261243a = new int[i16];
        this.f261244b = 1;
        this.f261245c = -1;
        this.f261246d = -1;
        this.f261247e = -1;
        this.f261248f = 0;
        this.f261249g = 0;
        this.f261250h = 0.75f;
        this.f261251i = 0.05f;
        this.f261252j = 0;
        this.f261253k = 0;
        this.f261254l = 0;
        if (appRuntime == null) {
            return;
        }
        this.f261255m = new WeakReference<>(appRuntime);
        try {
            String string = appRuntime.getPreferences().getString("PttVoiceChangePreSender", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() == i16 + 2) {
                int i17 = 0;
                while (true) {
                    i3 = f261242n;
                    if (i17 >= i3) {
                        break;
                    }
                    this.f261243a[i17] = jSONArray.getInt(i17);
                    i17++;
                }
                this.f261248f = jSONArray.getInt(i3);
                this.f261249g = jSONArray.getInt(i3 + 1);
            }
            if (QLog.isColorLevel()) {
                QLog.d("PttVoiceChangePreSender", 2, "get send record " + string);
            }
        } catch (Exception e16) {
            this.f261243a = new int[f261242n];
            this.f261248f = 0;
            this.f261249g = 0;
            e16.printStackTrace();
        }
    }

    private int b() {
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < f261242n; i17++) {
            int i18 = this.f261243a[i17];
            if (i16 < i18) {
                i3 = i17;
                i16 = i18;
            }
        }
        return i3;
    }

    private float c(int i3) {
        return this.f261243a[i3] / this.f261248f;
    }

    private void f() {
        AppRuntime appRuntime = this.f261255m.get();
        if (appRuntime == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i3 : this.f261243a) {
            jSONArray.put(i3);
        }
        jSONArray.put(this.f261248f);
        jSONArray.put(this.f261249g);
        SharedPreferences.Editor edit = appRuntime.getPreferences().edit();
        String jSONArray2 = jSONArray.toString();
        edit.putString("PttVoiceChangePreSender", jSONArray2);
        edit.commit();
        if (QLog.isColorLevel()) {
            QLog.d("PttVoiceChangePreSender", 2, "save send record " + jSONArray2);
        }
    }

    @Override // com.tencent.mobileqq.ptt.b
    public void a(AppRuntime appRuntime, int i3) {
        String str;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, i3);
            return;
        }
        d();
        if (this.f261246d == -1) {
            str = "";
            i16 = -1;
        } else {
            str = "";
            i16 = -1;
            ReportController.o(appRuntime, "CliOper", "", "", "0X800608D", "0X800608D", this.f261253k + 10, 0, this.f261246d + "", i3 + "", "", AppSetting.f99551k);
            if (this.f261253k == 2) {
                if (this.f261246d == i3) {
                    float f16 = this.f261250h;
                    this.f261250h = f16 - (this.f261251i * f16);
                } else {
                    float f17 = this.f261250h;
                    this.f261250h = f17 + ((1.0f - f17) * this.f261251i);
                }
                float f18 = this.f261250h;
                if (f18 < 0.55f) {
                    f18 = 0.55f;
                }
                this.f261250h = f18;
                if (f18 > 0.9f) {
                    f18 = 0.9f;
                }
                this.f261250h = f18;
            }
        }
        e();
        if (this.f261247e != i16) {
            int i17 = this.f261254l + 20;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f261247e);
            String str2 = str;
            sb5.append(str2);
            ReportController.o(appRuntime, "CliOper", "", "", "0X800608D", "0X800608D", i17, 0, sb5.toString(), i3 + str2, "", AppSetting.f99551k);
        }
        if (i3 < 0) {
            return;
        }
        if (i3 == this.f261245c) {
            this.f261244b++;
            this.f261249g++;
        } else {
            this.f261244b = 1;
        }
        this.f261245c = i3;
        int[] iArr = this.f261243a;
        iArr[i3] = iArr[i3] + 1;
        this.f261248f++;
        int i18 = this.f261252j + 1;
        this.f261252j = i18;
        if (i18 % 5 == 0) {
            f();
        }
        if (QLog.isColorLevel()) {
            QLog.d("PttVoiceChangePreSender", 2, "real send type " + i3);
        }
    }

    public int d() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (this.f261248f < 5) {
            this.f261246d = -1;
            return -1;
        }
        if (this.f261244b >= 2 && (i3 = this.f261245c) >= 0) {
            this.f261246d = i3;
            this.f261253k = 1;
        } else {
            int b16 = b();
            if (c(b16) >= this.f261250h) {
                this.f261246d = b16;
                this.f261253k = 2;
            } else {
                int i16 = this.f261245c;
                if (i16 >= 0 && this.f261249g / this.f261248f > 0.8d) {
                    this.f261246d = i16;
                    this.f261253k = 3;
                } else {
                    this.f261246d = -1;
                    this.f261253k = -1;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("PttVoiceChangePreSender", 2, "pre-send type " + this.f261246d);
        }
        return this.f261246d;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        int i3 = this.f261245c;
        if (i3 != -1 && this.f261248f >= 5) {
            if (this.f261244b >= 2) {
                this.f261247e = i3;
                this.f261254l = 1;
            } else {
                int b16 = b();
                int i16 = this.f261245c;
                if (i16 == b16) {
                    this.f261247e = i16;
                    this.f261254l = 2;
                } else if (this.f261249g / this.f261248f > 0.85d) {
                    this.f261247e = i16;
                    this.f261254l = 3;
                } else {
                    this.f261247e = -1;
                    this.f261254l = -1;
                }
            }
            return this.f261247e;
        }
        this.f261247e = -1;
        return -1;
    }
}
