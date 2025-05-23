package com.tencent.luggage.wxa.kp;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.luggage.wxa.np.i;
import com.tencent.soter.core.model.ConstantsSoter;
import java.security.Signature;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC6406d f132693a;

        public a(AbstractC6406d abstractC6406d) {
            this.f132693a = abstractC6406d;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f132693a.a(ConstantsSoter.ERR_NEGATIVE_BUTTON, "click negative button");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends FingerprintManager.AuthenticationCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC6406d f132694a;

        public b(AbstractC6406d abstractC6406d) {
            this.f132694a = abstractC6406d;
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationError(int i3, CharSequence charSequence) {
            com.tencent.luggage.wxa.np.e.a("Soter.FingerprintManagerProxy", "hy: lowest level return onAuthenticationError", new Object[0]);
            this.f132694a.a(i3, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationFailed() {
            com.tencent.luggage.wxa.np.e.a("Soter.FingerprintManagerProxy", "hy: lowest level return onAuthenticationFailed", new Object[0]);
            this.f132694a.a();
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationHelp(int i3, CharSequence charSequence) {
            com.tencent.luggage.wxa.np.e.a("Soter.FingerprintManagerProxy", "hy: lowest level return onAuthenticationHelp", new Object[0]);
            this.f132694a.b(i3, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            com.tencent.luggage.wxa.np.e.a("Soter.FingerprintManagerProxy", "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
            this.f132694a.a(new e(d.b(authenticationResult.getCryptoObject())));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends BiometricPrompt.AuthenticationCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC6406d f132695a;

        public c(AbstractC6406d abstractC6406d) {
            this.f132695a = abstractC6406d;
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationError(int i3, CharSequence charSequence) {
            this.f132695a.a(i3, charSequence);
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationFailed() {
            this.f132695a.a();
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationHelp(int i3, CharSequence charSequence) {
            this.f132695a.b(i3, charSequence);
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
            BiometricPrompt.CryptoObject cryptoObject;
            AbstractC6406d abstractC6406d = this.f132695a;
            cryptoObject = authenticationResult.getCryptoObject();
            abstractC6406d.a(new e(d.b(cryptoObject)));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kp.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static abstract class AbstractC6406d {
        public abstract void a();

        public abstract void a(int i3, CharSequence charSequence);

        public abstract void a(e eVar);

        public abstract void b(int i3, CharSequence charSequence);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public f f132696a;

        public e(f fVar) {
            this.f132696a = fVar;
        }

        public f a() {
            return this.f132696a;
        }
    }

    public static boolean b(Context context) {
        if (a(context, "android.permission.USE_FINGERPRINT") != 0) {
            com.tencent.luggage.wxa.np.e.b("Soter.FingerprintManagerProxy", "soter: permission check failed: hasEnrolledBiometric", new Object[0]);
            return false;
        }
        try {
            FingerprintManager a16 = a(context);
            if (a16 != null) {
                return a16.hasEnrolledFingerprints();
            }
            com.tencent.luggage.wxa.np.e.b("Soter.FingerprintManagerProxy", "soter: fingerprint manager is null in hasEnrolledBiometric! Should never happen", new Object[0]);
            return false;
        } catch (SecurityException unused) {
            com.tencent.luggage.wxa.np.e.b("Soter.FingerprintManagerProxy", "soter: triggered SecurityException in hasEnrolledBiometric! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }

    public static boolean c(Context context) {
        if (a(context, "android.permission.USE_FINGERPRINT") != 0) {
            com.tencent.luggage.wxa.np.e.b("Soter.FingerprintManagerProxy", "soter: permission check failed: isHardwareDetected", new Object[0]);
            return false;
        }
        try {
            FingerprintManager a16 = a(context);
            if (a16 != null) {
                boolean isHardwareDetected = a16.isHardwareDetected();
                if (!isHardwareDetected) {
                    com.tencent.luggage.wxa.np.f.a(104, "FingerprintManager.isHardwareDetected return false");
                }
                return isHardwareDetected;
            }
            com.tencent.luggage.wxa.np.e.b("Soter.FingerprintManagerProxy", "soter: fingerprint manager is null in isHardwareDetected! Should never happen", new Object[0]);
            return false;
        } catch (SecurityException unused) {
            com.tencent.luggage.wxa.np.e.b("Soter.FingerprintManagerProxy", "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }

    public static FingerprintManager a(Context context) {
        return (FingerprintManager) context.getSystemService("fingerprint");
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final Signature f132697a;

        /* renamed from: b, reason: collision with root package name */
        public final Cipher f132698b;

        /* renamed from: c, reason: collision with root package name */
        public final Mac f132699c;

        public f(Signature signature) {
            this.f132697a = signature;
            this.f132698b = null;
            this.f132699c = null;
        }

        public Cipher a() {
            return this.f132698b;
        }

        public Mac b() {
            return this.f132699c;
        }

        public Signature c() {
            return this.f132697a;
        }

        public f(Cipher cipher) {
            this.f132698b = cipher;
            this.f132697a = null;
            this.f132699c = null;
        }

        public f(Mac mac) {
            this.f132699c = mac;
            this.f132698b = null;
            this.f132697a = null;
        }
    }

    public static int a(Context context, String str) {
        if (context == null) {
            com.tencent.luggage.wxa.np.e.b("Soter.FingerprintManagerProxy", "soter: check self permission: context is null", new Object[0]);
            return -1;
        }
        if (i.a(str)) {
            com.tencent.luggage.wxa.np.e.b("Soter.FingerprintManagerProxy", "soter: requested permission is null or nil", new Object[0]);
            return -1;
        }
        return context.checkSelfPermission(str);
    }

    public static void b(Context context, f fVar, int i3, Object obj, AbstractC6406d abstractC6406d, Handler handler, Bundle bundle) {
        Executor mainExecutor;
        BiometricPrompt build;
        Executor mainExecutor2;
        if (a(context, "android.permission.USE_BIOMETRIC") != 0) {
            com.tencent.luggage.wxa.np.e.b("Soter.FingerprintManagerProxy", "soter: permission check failed: authenticate", new Object[0]);
            return;
        }
        BiometricPrompt.Builder builder = new BiometricPrompt.Builder(context);
        builder.setDeviceCredentialAllowed(false);
        if (Build.VERSION.SDK_INT >= 30) {
            builder.setAllowedAuthenticators(15);
        }
        builder.setTitle(bundle.getString("prompt_title"));
        builder.setSubtitle(bundle.getString("prompt_subtitle"));
        builder.setDescription(bundle.getString("prompt_description"));
        String string = bundle.getString("prompt_button");
        if (TextUtils.isEmpty(string)) {
            string = context.getString(17039360);
        }
        mainExecutor = context.getMainExecutor();
        builder.setNegativeButton(string, mainExecutor, new a(abstractC6406d));
        build = builder.build();
        mainExecutor2 = context.getMainExecutor();
        build.authenticate((CancellationSignal) obj, mainExecutor2, b(abstractC6406d));
    }

    public static void a(Context context, f fVar, int i3, Object obj, AbstractC6406d abstractC6406d, Handler handler, Bundle bundle) {
        boolean z16 = bundle.getBoolean("use_biometric_prompt");
        int i16 = Build.VERSION.SDK_INT;
        com.tencent.luggage.wxa.np.e.c("Soter.FingerprintManagerProxy", "use_biometric_prompt: %s, sdk_version: %s", Boolean.valueOf(z16), Integer.valueOf(i16));
        if (z16 && i16 >= 28) {
            b(context, fVar, i3, obj, abstractC6406d, handler, bundle);
        } else {
            a(context, fVar, i3, obj, abstractC6406d, handler);
        }
    }

    public static void a(Context context, f fVar, int i3, Object obj, AbstractC6406d abstractC6406d, Handler handler) {
        if (a(context, "android.permission.USE_FINGERPRINT") != 0) {
            com.tencent.luggage.wxa.np.e.b("Soter.FingerprintManagerProxy", "soter: permission check failed: authenticate", new Object[0]);
            return;
        }
        try {
            FingerprintManager a16 = a(context);
            if (a16 != null) {
                a16.authenticate(a(fVar), (CancellationSignal) obj, i3, a(abstractC6406d), handler);
            } else {
                com.tencent.luggage.wxa.np.e.b("Soter.FingerprintManagerProxy", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
            }
        } catch (SecurityException unused) {
            com.tencent.luggage.wxa.np.e.b("Soter.FingerprintManagerProxy", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
        }
    }

    public static FingerprintManager.CryptoObject a(f fVar) {
        if (fVar == null) {
            return null;
        }
        if (fVar.a() != null) {
            return new FingerprintManager.CryptoObject(fVar.a());
        }
        if (fVar.c() != null) {
            return new FingerprintManager.CryptoObject(fVar.c());
        }
        if (fVar.b() != null) {
            return new FingerprintManager.CryptoObject(fVar.b());
        }
        return null;
    }

    public static f b(FingerprintManager.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new f(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new f(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new f(cryptoObject.getMac());
        }
        return null;
    }

    public static FingerprintManager.AuthenticationCallback a(AbstractC6406d abstractC6406d) {
        return new b(abstractC6406d);
    }

    public static f b(BiometricPrompt.CryptoObject cryptoObject) {
        Cipher cipher;
        Signature signature;
        Mac mac;
        Mac mac2;
        Signature signature2;
        Cipher cipher2;
        if (cryptoObject == null) {
            return null;
        }
        cipher = cryptoObject.getCipher();
        if (cipher != null) {
            cipher2 = cryptoObject.getCipher();
            return new f(cipher2);
        }
        signature = cryptoObject.getSignature();
        if (signature != null) {
            signature2 = cryptoObject.getSignature();
            return new f(signature2);
        }
        mac = cryptoObject.getMac();
        if (mac == null) {
            return null;
        }
        mac2 = cryptoObject.getMac();
        return new f(mac2);
    }

    public static BiometricPrompt.AuthenticationCallback b(AbstractC6406d abstractC6406d) {
        return new c(abstractC6406d);
    }
}
