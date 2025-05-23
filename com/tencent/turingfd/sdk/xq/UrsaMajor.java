package com.tencent.turingfd.sdk.xq;

import android.security.keystore.KeyGenParameterSpec;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import javax.security.auth.x500.X500Principal;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class UrsaMajor {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.UrsaMajor$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cdo extends UrsaMajor {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public KeyGenParameterSpec.Builder f383170a;

        public Cdo(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            } else {
                this.f383170a = null;
                this.f383170a = new KeyGenParameterSpec.Builder(str, i3);
            }
        }

        @Override // com.tencent.turingfd.sdk.xq.UrsaMajor
        public AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f383170a.build() : (AlgorithmParameterSpec) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.turingfd.sdk.xq.UrsaMajor
        public UrsaMajor b(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (UrsaMajor) iPatchRedirector.redirect((short) 4, (Object) this, (Object) strArr);
            }
            this.f383170a.setSignaturePaddings(strArr);
            return this;
        }

        @Override // com.tencent.turingfd.sdk.xq.UrsaMajor
        public UrsaMajor a(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (UrsaMajor) iPatchRedirector.redirect((short) 3, (Object) this, (Object) strArr);
            }
            this.f383170a.setDigests(strArr);
            return this;
        }
    }

    public UrsaMajor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static UrsaMajor a(String str, int i3) {
        return new Cdo(str, i3);
    }

    public abstract UrsaMajor a(String... strArr);

    public abstract AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    public abstract UrsaMajor b(String... strArr);

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.UrsaMajor$if, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cif extends UrsaMajor {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f383171a;

        /* renamed from: b, reason: collision with root package name */
        public int f383172b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f383173c;

        /* renamed from: d, reason: collision with root package name */
        public String[] f383174d;

        public Cif(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            } else {
                if (str != null) {
                    if (!str.isEmpty()) {
                        this.f383171a = str;
                        this.f383172b = i3;
                        return;
                    }
                    throw new IllegalArgumentException("keystoreAlias must not be empty");
                }
                throw new NullPointerException("keystoreAlias == null");
            }
        }

        @Override // com.tencent.turingfd.sdk.xq.UrsaMajor
        public AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (AlgorithmParameterSpec) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            Class<?> cls = Class.forName("android.security.keystore.KeyGenParameterSpec");
            Class<?> cls2 = Integer.TYPE;
            Class<?> cls3 = Boolean.TYPE;
            return (AlgorithmParameterSpec) cls.getConstructor(String.class, cls2, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, java.util.Date.class, java.util.Date.class, java.util.Date.class, java.util.Date.class, java.util.Date.class, cls2, String[].class, String[].class, String[].class, String[].class, cls3, cls3, cls2).newInstance(this.f383171a, -1, null, null, null, null, null, null, null, null, Integer.valueOf(this.f383172b), this.f383173c, null, this.f383174d, null, Boolean.TRUE, Boolean.FALSE, -1);
        }

        @Override // com.tencent.turingfd.sdk.xq.UrsaMajor
        public UrsaMajor b(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (UrsaMajor) iPatchRedirector.redirect((short) 3, (Object) this, (Object) strArr);
            }
            if (strArr.length > 0) {
                strArr = (String[]) strArr.clone();
            }
            this.f383174d = strArr;
            return this;
        }

        @Override // com.tencent.turingfd.sdk.xq.UrsaMajor
        public UrsaMajor a(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (UrsaMajor) iPatchRedirector.redirect((short) 2, (Object) this, (Object) strArr);
            }
            if (strArr.length > 0) {
                strArr = (String[]) strArr.clone();
            }
            this.f383173c = strArr;
            return this;
        }
    }
}
