package com.tencent.soter.core.keystore;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.security.keystore.KeyGenParameterSpec;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.core.model.SLogger;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes25.dex */
public abstract class KeyGenParameterSpecCompatBuilder {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Soter.KeyGenParameterSpecCompatBuilder";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static class DummyKeyGenParameterSpecCompatBuilder extends KeyGenParameterSpecCompatBuilder {
        static IPatchRedirector $redirector_;

        public DummyKeyGenParameterSpecCompatBuilder(String str, int i3) {
            super(str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public AlgorithmParameterSpec build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AlgorithmParameterSpec) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setAlgorithmParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) algorithmParameterSpec);
            }
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setBlockModes(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) strArr);
            }
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateNotAfter(Date date) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) date);
            }
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateNotBefore(Date date) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) date);
            }
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateSerialNumber(BigInteger bigInteger) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bigInteger);
            }
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateSubject(X500Principal x500Principal) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) x500Principal);
            }
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setDigests(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) strArr);
            }
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setEncryptionPaddings(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) strArr);
            }
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeySize(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeyValidityEnd(Date date) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) date);
            }
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeyValidityStart(Date date) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) date);
            }
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setRandomizedEncryptionRequired(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 15, (Object) this, z16);
            }
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setSignaturePaddings(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) strArr);
            }
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setUserAuthenticationRequired(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 16, (Object) this, z16);
            }
            return null;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setUserAuthenticationValidityDurationSeconds(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 17, (Object) this, i3);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    /* loaded from: classes25.dex */
    public static class NormalKeyGenParameterSpecCompatBuilder extends KeyGenParameterSpecCompatBuilder {
        static IPatchRedirector $redirector_;
        private KeyGenParameterSpec.Builder builder;

        public NormalKeyGenParameterSpecCompatBuilder(String str, int i3) {
            super(str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            } else {
                this.builder = null;
                this.builder = new KeyGenParameterSpec.Builder(str, i3);
            }
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public AlgorithmParameterSpec build() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AlgorithmParameterSpec) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.builder.build();
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setAlgorithmParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) algorithmParameterSpec);
            }
            this.builder.setAlgorithmParameterSpec(algorithmParameterSpec);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        @SuppressLint({"WrongConstant"})
        public KeyGenParameterSpecCompatBuilder setBlockModes(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) strArr);
            }
            this.builder.setBlockModes(strArr);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateNotAfter(Date date) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) date);
            }
            this.builder.setCertificateNotAfter(date);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateNotBefore(Date date) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) date);
            }
            this.builder.setCertificateNotBefore(date);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateSerialNumber(BigInteger bigInteger) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bigInteger);
            }
            this.builder.setCertificateSerialNumber(bigInteger);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateSubject(X500Principal x500Principal) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) x500Principal);
            }
            this.builder.setCertificateSubject(x500Principal);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        @SuppressLint({"WrongConstant"})
        public KeyGenParameterSpecCompatBuilder setDigests(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) strArr);
            }
            this.builder.setDigests(strArr);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        @SuppressLint({"WrongConstant"})
        public KeyGenParameterSpecCompatBuilder setEncryptionPaddings(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) strArr);
            }
            this.builder.setEncryptionPaddings(strArr);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeySize(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            this.builder.setKeySize(i3);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeyValidityEnd(Date date) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) date);
            }
            this.builder.setKeyValidityEnd(date);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeyValidityStart(Date date) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) date);
            }
            this.builder.setKeyValidityStart(date);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setRandomizedEncryptionRequired(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 15, (Object) this, z16);
            }
            this.builder.setRandomizedEncryptionRequired(z16);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        @SuppressLint({"WrongConstant"})
        public KeyGenParameterSpecCompatBuilder setSignaturePaddings(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) strArr);
            }
            this.builder.setSignaturePaddings(strArr);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setUserAuthenticationRequired(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 16, (Object) this, z16);
            }
            this.builder.setUserAuthenticationRequired(z16);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setUserAuthenticationValidityDurationSeconds(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 17, (Object) this, i3);
            }
            this.builder.setUserAuthenticationValidityDurationSeconds(i3);
            return this;
        }
    }

    /* loaded from: classes25.dex */
    static class ReflectKeyGenParameterSpecCompatBuilder extends KeyGenParameterSpecCompatBuilder {
        static IPatchRedirector $redirector_ = null;
        private static final String CLASSNAME = "android.security.keystore.KeyGenParameterSpec";
        private String[] mBlockModes;
        private Date mCertificateNotAfter;
        private Date mCertificateNotBefore;
        private BigInteger mCertificateSerialNumber;
        private X500Principal mCertificateSubject;
        private String[] mDigests;
        private String[] mEncryptionPaddings;
        private int mKeySize;
        private Date mKeyValidityForConsumptionEnd;
        private Date mKeyValidityForOriginationEnd;
        private Date mKeyValidityStart;
        private final String mKeystoreAlias;
        private int mPurposes;
        private boolean mRandomizedEncryptionRequired;
        private String[] mSignaturePaddings;
        private AlgorithmParameterSpec mSpec;
        private boolean mUserAuthenticationRequired;
        private int mUserAuthenticationValidityDurationSeconds;

        public ReflectKeyGenParameterSpecCompatBuilder(String str, int i3) {
            super(str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
                return;
            }
            this.mKeySize = -1;
            this.mRandomizedEncryptionRequired = true;
            this.mUserAuthenticationValidityDurationSeconds = -1;
            if (str != null) {
                if (!str.isEmpty()) {
                    this.mKeystoreAlias = str;
                    this.mPurposes = i3;
                    return;
                }
                throw new IllegalArgumentException("keystoreAlias must not be empty");
            }
            throw new NullPointerException("keystoreAlias == null");
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public AlgorithmParameterSpec build() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (AlgorithmParameterSpec) iPatchRedirector.redirect((short) 19, (Object) this);
            }
            Class<?> cls = Class.forName(CLASSNAME);
            Class<?> cls2 = Integer.TYPE;
            Class<?> cls3 = Boolean.TYPE;
            return (AlgorithmParameterSpec) cls.getConstructor(String.class, cls2, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, cls2, String[].class, String[].class, String[].class, String[].class, cls3, cls3, cls2).newInstance(this.mKeystoreAlias, Integer.valueOf(this.mKeySize), this.mSpec, this.mCertificateSubject, this.mCertificateSerialNumber, this.mCertificateNotBefore, this.mCertificateNotAfter, this.mKeyValidityStart, this.mKeyValidityForOriginationEnd, this.mKeyValidityForConsumptionEnd, Integer.valueOf(this.mPurposes), this.mDigests, this.mEncryptionPaddings, this.mSignaturePaddings, this.mBlockModes, Boolean.valueOf(this.mRandomizedEncryptionRequired), Boolean.valueOf(this.mUserAuthenticationRequired), Integer.valueOf(this.mUserAuthenticationValidityDurationSeconds));
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setAlgorithmParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) algorithmParameterSpec);
            }
            if (algorithmParameterSpec != null) {
                this.mSpec = algorithmParameterSpec;
                return this;
            }
            throw new NullPointerException("spec == null");
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setBlockModes(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 15, (Object) this, (Object) strArr);
            }
            this.mBlockModes = KeyGenParameterSpecCompatBuilder.cloneIfNotEmpty(strArr);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateNotAfter(Date date) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) date);
            }
            if (date != null) {
                this.mCertificateNotAfter = KeyGenParameterSpecCompatBuilder.cloneIfNotNull(date);
                return this;
            }
            throw new NullPointerException("date == null");
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateNotBefore(Date date) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) date);
            }
            if (date != null) {
                this.mCertificateNotBefore = KeyGenParameterSpecCompatBuilder.cloneIfNotNull(date);
                return this;
            }
            throw new NullPointerException("date == null");
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateSerialNumber(BigInteger bigInteger) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bigInteger);
            }
            if (bigInteger != null) {
                this.mCertificateSerialNumber = bigInteger;
                return this;
            }
            throw new NullPointerException("serialNumber == null");
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setCertificateSubject(X500Principal x500Principal) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) x500Principal);
            }
            if (x500Principal != null) {
                this.mCertificateSubject = x500Principal;
                return this;
            }
            throw new NullPointerException("subject == null");
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setDigests(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) strArr);
            }
            this.mDigests = KeyGenParameterSpecCompatBuilder.cloneIfNotEmpty(strArr);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setEncryptionPaddings(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) strArr);
            }
            this.mEncryptionPaddings = KeyGenParameterSpecCompatBuilder.cloneIfNotEmpty(strArr);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeySize(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            if (i3 >= 0) {
                this.mKeySize = i3;
                return this;
            }
            throw new IllegalArgumentException("keySize < 0");
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeyValidityEnd(Date date) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) date);
            }
            setKeyValidityForOriginationEnd(date);
            setKeyValidityForConsumptionEnd(date);
            return this;
        }

        public KeyGenParameterSpecCompatBuilder setKeyValidityForConsumptionEnd(Date date) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) date);
            }
            this.mKeyValidityForConsumptionEnd = KeyGenParameterSpecCompatBuilder.cloneIfNotNull(date);
            return this;
        }

        public KeyGenParameterSpecCompatBuilder setKeyValidityForOriginationEnd(Date date) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) date);
            }
            this.mKeyValidityForOriginationEnd = KeyGenParameterSpecCompatBuilder.cloneIfNotNull(date);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setKeyValidityStart(Date date) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) date);
            }
            this.mKeyValidityStart = KeyGenParameterSpecCompatBuilder.cloneIfNotNull(date);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setRandomizedEncryptionRequired(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 16, (Object) this, z16);
            }
            this.mRandomizedEncryptionRequired = z16;
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setSignaturePaddings(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) strArr);
            }
            this.mSignaturePaddings = KeyGenParameterSpecCompatBuilder.cloneIfNotEmpty(strArr);
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setUserAuthenticationRequired(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 17, (Object) this, z16);
            }
            this.mUserAuthenticationRequired = z16;
            return this;
        }

        @Override // com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder
        public KeyGenParameterSpecCompatBuilder setUserAuthenticationValidityDurationSeconds(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (KeyGenParameterSpecCompatBuilder) iPatchRedirector.redirect((short) 18, (Object) this, i3);
            }
            if (i3 >= -1) {
                this.mUserAuthenticationValidityDurationSeconds = i3;
                return this;
            }
            throw new IllegalArgumentException("seconds must be -1 or larger");
        }
    }

    public KeyGenParameterSpecCompatBuilder(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static String[] cloneIfNotEmpty(String[] strArr) {
        return (strArr == null || strArr.length <= 0) ? strArr : (String[]) strArr.clone();
    }

    static Date cloneIfNotNull(Date date) {
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public static KeyGenParameterSpecCompatBuilder newInstance(String str, int i3) {
        if (SoterCore.isNativeSupportSoter()) {
            return new NormalKeyGenParameterSpecCompatBuilder(str, i3);
        }
        SLogger.e(TAG, "soter: not support soter. return dummy", new Object[0]);
        return new DummyKeyGenParameterSpecCompatBuilder(str, i3);
    }

    public abstract AlgorithmParameterSpec build() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    public abstract KeyGenParameterSpecCompatBuilder setAlgorithmParameterSpec(AlgorithmParameterSpec algorithmParameterSpec);

    public abstract KeyGenParameterSpecCompatBuilder setBlockModes(String... strArr);

    public abstract KeyGenParameterSpecCompatBuilder setCertificateNotAfter(Date date);

    public abstract KeyGenParameterSpecCompatBuilder setCertificateNotBefore(Date date);

    public abstract KeyGenParameterSpecCompatBuilder setCertificateSerialNumber(BigInteger bigInteger);

    public abstract KeyGenParameterSpecCompatBuilder setCertificateSubject(X500Principal x500Principal);

    public abstract KeyGenParameterSpecCompatBuilder setDigests(String... strArr);

    public abstract KeyGenParameterSpecCompatBuilder setEncryptionPaddings(String... strArr);

    public abstract KeyGenParameterSpecCompatBuilder setKeySize(int i3);

    public abstract KeyGenParameterSpecCompatBuilder setKeyValidityEnd(Date date);

    public abstract KeyGenParameterSpecCompatBuilder setKeyValidityStart(Date date);

    public abstract KeyGenParameterSpecCompatBuilder setRandomizedEncryptionRequired(boolean z16);

    public abstract KeyGenParameterSpecCompatBuilder setSignaturePaddings(String... strArr);

    public abstract KeyGenParameterSpecCompatBuilder setUserAuthenticationRequired(boolean z16);

    public abstract KeyGenParameterSpecCompatBuilder setUserAuthenticationValidityDurationSeconds(int i3);

    public static byte[] cloneIfNotEmpty(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? bArr : (byte[]) bArr.clone();
    }
}
