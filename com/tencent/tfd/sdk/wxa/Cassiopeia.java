package com.tencent.tfd.sdk.wxa;

import android.security.keystore.KeyGenParameterSpec;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import javax.security.auth.x500.X500Principal;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class Cassiopeia {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Cassiopeia$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static class Cdo extends Cassiopeia {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public KeyGenParameterSpec.Builder f375520a;

        public Cdo(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            } else {
                this.f375520a = null;
                this.f375520a = new KeyGenParameterSpec.Builder(str, i3);
            }
        }

        @Override // com.tencent.tfd.sdk.wxa.Cassiopeia
        public final AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f375520a.build() : (AlgorithmParameterSpec) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.tfd.sdk.wxa.Cassiopeia
        public final Cassiopeia b(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Cassiopeia) iPatchRedirector.redirect((short) 4, (Object) this, (Object) strArr);
            }
            this.f375520a.setSignaturePaddings(strArr);
            return this;
        }

        @Override // com.tencent.tfd.sdk.wxa.Cassiopeia
        public final Cassiopeia a(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Cassiopeia) iPatchRedirector.redirect((short) 3, (Object) this, (Object) strArr);
            }
            this.f375520a.setDigests(strArr);
            return this;
        }
    }

    public Cassiopeia() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Cassiopeia a(String str, int i3) {
        return new Cdo(str, i3);
    }

    public abstract Cassiopeia a(String... strArr);

    public abstract AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    public abstract Cassiopeia b(String... strArr);

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Cassiopeia$if, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static class Cif extends Cassiopeia {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f375521a;

        /* renamed from: b, reason: collision with root package name */
        public int f375522b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f375523c;

        /* renamed from: d, reason: collision with root package name */
        public String[] f375524d;

        public Cif(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            } else {
                if (str != null) {
                    if (!str.isEmpty()) {
                        this.f375521a = str;
                        this.f375522b = i3;
                        return;
                    }
                    throw new IllegalArgumentException("keystoreAlias must not be empty");
                }
                throw new NullPointerException("keystoreAlias == null");
            }
        }

        @Override // com.tencent.tfd.sdk.wxa.Cassiopeia
        public final AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (AlgorithmParameterSpec) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            Class<?> cls = Class.forName("android.security.keystore.KeyGenParameterSpec");
            Class<?> cls2 = Integer.TYPE;
            Class<?> cls3 = Boolean.TYPE;
            return (AlgorithmParameterSpec) cls.getConstructor(String.class, cls2, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, java.util.Date.class, java.util.Date.class, java.util.Date.class, java.util.Date.class, java.util.Date.class, cls2, String[].class, String[].class, String[].class, String[].class, cls3, cls3, cls2).newInstance(this.f375521a, -1, null, null, null, null, null, null, null, null, Integer.valueOf(this.f375522b), this.f375523c, null, this.f375524d, null, Boolean.TRUE, Boolean.FALSE, -1);
        }

        @Override // com.tencent.tfd.sdk.wxa.Cassiopeia
        public final Cassiopeia b(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Cassiopeia) iPatchRedirector.redirect((short) 3, (Object) this, (Object) strArr);
            }
            if (strArr.length > 0) {
                strArr = (String[]) strArr.clone();
            }
            this.f375524d = strArr;
            return this;
        }

        @Override // com.tencent.tfd.sdk.wxa.Cassiopeia
        public final Cassiopeia a(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Cassiopeia) iPatchRedirector.redirect((short) 2, (Object) this, (Object) strArr);
            }
            if (strArr.length > 0) {
                strArr = (String[]) strArr.clone();
            }
            this.f375523c = strArr;
            return this;
        }
    }
}
