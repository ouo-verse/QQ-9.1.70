package com.tencent.mobileqq.ptt.preop;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.voicechange.IVoiceTuneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import okhttp3.HttpUrl;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static final int f261273k;

    /* renamed from: a, reason: collision with root package name */
    public int[] f261274a;

    /* renamed from: b, reason: collision with root package name */
    int f261275b;

    /* renamed from: c, reason: collision with root package name */
    int f261276c;

    /* renamed from: d, reason: collision with root package name */
    int f261277d;

    /* renamed from: e, reason: collision with root package name */
    public int f261278e;

    /* renamed from: f, reason: collision with root package name */
    public int f261279f;

    /* renamed from: g, reason: collision with root package name */
    public float f261280g;

    /* renamed from: h, reason: collision with root package name */
    float f261281h;

    /* renamed from: i, reason: collision with root package name */
    private int f261282i;

    /* renamed from: j, reason: collision with root package name */
    int f261283j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21723);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f261273k = IVoiceTuneUtil.VOICE_TYPES.length;
        }
    }

    public b(AppRuntime appRuntime) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        int i16 = f261273k;
        this.f261274a = new int[i16];
        this.f261275b = 1;
        this.f261276c = -1;
        this.f261277d = -1;
        this.f261278e = 0;
        this.f261279f = 0;
        this.f261280g = 0.75f;
        this.f261281h = 0.05f;
        this.f261282i = 0;
        this.f261283j = 0;
        try {
            String string = BaseApplication.getContext().getSharedPreferences("PttPreSendSp_" + appRuntime.getCurrentAccountUin(), 0).getString("PttVoiceChangePreSender", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() == i16 + 2) {
                int i17 = 0;
                while (true) {
                    i3 = f261273k;
                    if (i17 >= i3) {
                        break;
                    }
                    this.f261274a[i17] = jSONArray.getInt(i17);
                    i17++;
                }
                this.f261278e = jSONArray.getInt(i3);
                this.f261279f = jSONArray.getInt(i3 + 1);
            }
            if (QLog.isColorLevel()) {
                QLog.d("PreSendTypeStrategy", 2, "init : get send record " + string);
            }
        } catch (Exception e16) {
            this.f261274a = new int[f261273k];
            this.f261278e = 0;
            this.f261279f = 0;
            e16.printStackTrace();
        }
    }

    private String a() {
        JSONArray jSONArray = new JSONArray();
        for (int i3 : this.f261274a) {
            jSONArray.put(i3);
        }
        jSONArray.put(this.f261278e);
        jSONArray.put(this.f261279f);
        return jSONArray.toString();
    }

    public void b(AppRuntime appRuntime, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime, i3);
            return;
        }
        int i16 = this.f261277d;
        if (i16 != -1 && this.f261283j == 2) {
            if (i16 == i3) {
                float f16 = this.f261280g;
                this.f261280g = f16 - (this.f261281h * f16);
            } else {
                float f17 = this.f261280g;
                this.f261280g = f17 + ((1.0f - f17) * this.f261281h);
            }
            float f18 = this.f261280g;
            if (f18 < 0.55f) {
                f18 = 0.55f;
            }
            this.f261280g = f18;
            if (f18 > 0.9f) {
                f18 = 0.9f;
            }
            this.f261280g = f18;
        }
        if (i3 < 0) {
            this.f261276c = i3;
            return;
        }
        if (i3 == this.f261276c) {
            this.f261275b++;
            this.f261279f++;
        } else {
            this.f261275b = 1;
        }
        this.f261276c = i3;
        int[] iArr = this.f261274a;
        iArr[i3] = iArr[i3] + 1;
        this.f261278e++;
        int i17 = this.f261282i + 1;
        this.f261282i = i17;
        if (i17 % 5 == 0) {
            c(appRuntime);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PreSendTypeStrategy", 2, "real send type " + i3);
        }
    }

    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        String a16 = a();
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("PttPreSendSp_" + appRuntime.getCurrentAccountUin(), 0).edit();
        edit.putString("PttVoiceChangePreSender", a16);
        edit.commit();
        if (QLog.isColorLevel()) {
            QLog.d("PreSendTypeStrategy", 2, "save send record " + a16);
        }
    }
}
