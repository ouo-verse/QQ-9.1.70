package com.tencent.turingcam;

import android.security.keystore.KeyGenParameterSpec;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class wiSNn {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class spXPg extends wiSNn {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public KeyGenParameterSpec.Builder f382422a;

        public spXPg(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            } else {
                this.f382422a = null;
                this.f382422a = new KeyGenParameterSpec.Builder(str, i3);
            }
        }

        @Override // com.tencent.turingcam.wiSNn
        public AlgorithmParameterSpec a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f382422a.build() : (AlgorithmParameterSpec) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.turingcam.wiSNn
        public wiSNn b(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (wiSNn) iPatchRedirector.redirect((short) 4, (Object) this, (Object) strArr);
            }
            this.f382422a.setSignaturePaddings(strArr);
            return this;
        }

        @Override // com.tencent.turingcam.wiSNn
        public wiSNn a(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (wiSNn) iPatchRedirector.redirect((short) 3, (Object) this, (Object) strArr);
            }
            this.f382422a.setDigests(strArr);
            return this;
        }
    }

    public wiSNn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static wiSNn a(String str, int i3) {
        return new spXPg(str, i3);
    }

    public abstract wiSNn a(String... strArr);

    public abstract AlgorithmParameterSpec a();

    public abstract wiSNn b(String... strArr);

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ShGzN extends wiSNn {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f382418a;

        /* renamed from: b, reason: collision with root package name */
        public int f382419b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f382420c;

        /* renamed from: d, reason: collision with root package name */
        public String[] f382421d;

        public ShGzN(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            } else {
                if (str != null) {
                    if (!str.isEmpty()) {
                        this.f382418a = str;
                        this.f382419b = i3;
                        return;
                    }
                    throw new IllegalArgumentException("keystoreAlias must not be empty");
                }
                throw new NullPointerException("keystoreAlias == null");
            }
        }

        @Override // com.tencent.turingcam.wiSNn
        public AlgorithmParameterSpec a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (AlgorithmParameterSpec) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            Class<?> cls = Class.forName("android.security.keystore.KeyGenParameterSpec");
            Class<?> cls2 = Integer.TYPE;
            Class<?> cls3 = Boolean.TYPE;
            return (AlgorithmParameterSpec) cls.getConstructor(String.class, cls2, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, cls2, String[].class, String[].class, String[].class, String[].class, cls3, cls3, cls2).newInstance(this.f382418a, -1, null, null, null, null, null, null, null, null, Integer.valueOf(this.f382419b), this.f382420c, null, this.f382421d, null, Boolean.TRUE, Boolean.FALSE, -1);
        }

        @Override // com.tencent.turingcam.wiSNn
        public wiSNn b(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (wiSNn) iPatchRedirector.redirect((short) 3, (Object) this, (Object) strArr);
            }
            if (strArr.length > 0) {
                strArr = (String[]) strArr.clone();
            }
            this.f382421d = strArr;
            return this;
        }

        @Override // com.tencent.turingcam.wiSNn
        public wiSNn a(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (wiSNn) iPatchRedirector.redirect((short) 2, (Object) this, (Object) strArr);
            }
            if (strArr.length > 0) {
                strArr = (String[]) strArr.clone();
            }
            this.f382420c = strArr;
            return this;
        }
    }
}
