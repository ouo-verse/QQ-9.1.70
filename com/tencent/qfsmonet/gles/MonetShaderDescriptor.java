package com.tencent.qfsmonet.gles;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MonetShaderDescriptor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f342477a;

    /* renamed from: b, reason: collision with root package name */
    private String f342478b;

    /* renamed from: c, reason: collision with root package name */
    private String f342479c;

    /* renamed from: d, reason: collision with root package name */
    private String f342480d;

    /* renamed from: e, reason: collision with root package name */
    private String f342481e;

    /* renamed from: f, reason: collision with root package name */
    private String f342482f;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface OpenGLSamplerType {
        public static final int SAMPLER_2D = 35678;
        public static final int SAMPLER_OES = 36198;
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f342483a;

        /* renamed from: b, reason: collision with root package name */
        private String f342484b;

        /* renamed from: c, reason: collision with root package name */
        private String f342485c;

        /* renamed from: d, reason: collision with root package name */
        private String f342486d;

        /* renamed from: e, reason: collision with root package name */
        private String f342487e;

        /* renamed from: f, reason: collision with root package name */
        private String f342488f;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public MonetShaderDescriptor a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (MonetShaderDescriptor) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            MonetShaderDescriptor monetShaderDescriptor = new MonetShaderDescriptor(null);
            monetShaderDescriptor.f342478b = this.f342484b;
            monetShaderDescriptor.f342477a = this.f342483a;
            monetShaderDescriptor.f342480d = this.f342486d;
            monetShaderDescriptor.f342479c = this.f342485c;
            monetShaderDescriptor.f342482f = this.f342488f;
            monetShaderDescriptor.f342481e = this.f342487e;
            return monetShaderDescriptor;
        }

        public b b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.f342485c = str;
            return this;
        }

        public b c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            this.f342483a = i3;
            return this;
        }

        public b d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (b) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            this.f342488f = str;
            return this;
        }

        public b e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.f342486d = str;
            return this;
        }

        public b f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.f342487e = str;
            return this;
        }

        public b g(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f342484b = str;
            return this;
        }
    }

    /* synthetic */ MonetShaderDescriptor(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f342479c;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f342477a;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f342482f;
    }

    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f342480d;
    }

    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f342481e;
    }

    public String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f342478b;
    }

    MonetShaderDescriptor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
