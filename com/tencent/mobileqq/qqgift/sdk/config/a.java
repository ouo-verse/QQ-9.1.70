package com.tencent.mobileqq.qqgift.sdk.config;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f264972a;

    /* renamed from: b, reason: collision with root package name */
    public String f264973b;

    /* renamed from: c, reason: collision with root package name */
    public String f264974c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f264975d;

    /* renamed from: e, reason: collision with root package name */
    public String f264976e;

    /* renamed from: f, reason: collision with root package name */
    public String f264977f;

    /* renamed from: g, reason: collision with root package name */
    public String f264978g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f264979h;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, String> f264980i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f264981j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f264982k;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private a f264983a;

        /* synthetic */ b(C8339a c8339a) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                return;
            }
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) c8339a);
        }

        private boolean c() {
            return true;
        }

        public b a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f264983a.f264973b = str;
            return this;
        }

        public a b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (a) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            if (this.f264983a.f264975d && !c()) {
                throw new RuntimeException("config params error");
            }
            return this.f264983a;
        }

        public b d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            this.f264983a.f264972a = i3;
            return this;
        }

        public b e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (b) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            }
            this.f264983a.f264976e = str;
            return this;
        }

        public b f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (b) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            }
            this.f264983a.f264978g = str;
            return this;
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f264983a = new a(null);
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ a(C8339a c8339a) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) c8339a);
    }

    public static b a() {
        return new b(null);
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getClass().getName());
        sb5.append('{');
        sb5.append("sceneId=");
        sb5.append(this.f264972a);
        if (!TextUtils.isEmpty(this.f264974c)) {
            sb5.append(MttLoader.QQBROWSER_PARAMS_VERSION);
            sb5.append(this.f264974c);
        }
        if (!TextUtils.isEmpty(this.f264976e)) {
            sb5.append(",vasBusinessId=");
            sb5.append(this.f264976e);
        }
        if (!TextUtils.isEmpty(this.f264977f)) {
            sb5.append(",vasSceneId=");
            sb5.append(this.f264977f);
        }
        if (!TextUtils.isEmpty(this.f264978g)) {
            sb5.append(",vasPayId=");
            sb5.append(this.f264978g);
        }
        sb5.append(",disableCombo=");
        sb5.append(this.f264979h);
        Map<String, String> map = this.f264980i;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : this.f264980i.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    sb5.append(",ext.key=");
                    sb5.append(entry.getKey());
                }
                if (!TextUtils.isEmpty(entry.getValue())) {
                    sb5.append(",ext.value=");
                    sb5.append(entry.getValue());
                }
            }
        }
        sb5.append("}");
        return sb5.toString();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f264974c = BaseApplication.reportVersionName;
        this.f264976e = "";
        this.f264977f = "";
        this.f264978g = "";
        this.f264981j = true;
        this.f264982k = false;
    }
}
