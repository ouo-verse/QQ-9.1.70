package com.tencent.luggage.wxa.lp;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.luggage.wxa.np.e;
import com.tencent.luggage.wxa.np.i;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends FingerprintManager.AuthenticationCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC6452b f133774a;

        public a(AbstractC6452b abstractC6452b) {
            this.f133774a = abstractC6452b;
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationError(int i3, CharSequence charSequence) {
            e.a("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationError", new Object[0]);
            this.f133774a.a(i3, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationFailed() {
            e.a("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationFailed", new Object[0]);
            this.f133774a.a();
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationHelp(int i3, CharSequence charSequence) {
            e.a("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationHelp", new Object[0]);
            this.f133774a.b(i3, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            e.a("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
            this.f133774a.a(new c(b.b(authenticationResult.getCryptoObject())));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.lp.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static abstract class AbstractC6452b {
        public abstract void a();

        public abstract void a(int i3, CharSequence charSequence);

        public abstract void a(c cVar);

        public abstract void b(int i3, CharSequence charSequence);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public d f133775a;

        public c(d dVar) {
            this.f133775a = dVar;
        }

        public d a() {
            return this.f133775a;
        }
    }

    public static boolean b(Context context) {
        if (a(context, "android.permission.USE_FINGERPRINT") != 0) {
            e.b("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: hasEnrolledFingerprints", new Object[0]);
            return false;
        }
        try {
            FingerprintManager a16 = a(context);
            if (a16 != null) {
                return a16.hasEnrolledFingerprints();
            }
            e.b("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in hasEnrolledFingerprints! Should never happen", new Object[0]);
            return false;
        } catch (SecurityException unused) {
            e.b("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in hasEnrolledFingerprints! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }

    public static FingerprintManager a(Context context) {
        return (FingerprintManager) context.getSystemService("fingerprint");
    }

    public static int a(Context context, String str) {
        if (context == null) {
            e.b("Soter.FingerprintManagerCompatApi23", "soter: check self permission: context is null", new Object[0]);
            return -1;
        }
        if (i.a(str)) {
            e.b("Soter.FingerprintManagerCompatApi23", "soter: requested permission is null or nil", new Object[0]);
            return -1;
        }
        return context.checkSelfPermission(str);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final Signature f133776a;

        /* renamed from: b, reason: collision with root package name */
        public final Cipher f133777b;

        /* renamed from: c, reason: collision with root package name */
        public final Mac f133778c;

        public d(Signature signature) {
            this.f133776a = signature;
            this.f133777b = null;
            this.f133778c = null;
        }

        public Cipher a() {
            return this.f133777b;
        }

        public Mac b() {
            return this.f133778c;
        }

        public Signature c() {
            return this.f133776a;
        }

        public d(Cipher cipher) {
            this.f133777b = cipher;
            this.f133776a = null;
            this.f133778c = null;
        }

        public d(Mac mac) {
            this.f133778c = mac;
            this.f133777b = null;
            this.f133776a = null;
        }
    }

    public static void a(Context context, d dVar, int i3, Object obj, AbstractC6452b abstractC6452b, Handler handler) {
        if (a(context, "android.permission.USE_FINGERPRINT") != 0) {
            e.b("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: authenticate", new Object[0]);
            return;
        }
        try {
            FingerprintManager a16 = a(context);
            if (a16 != null) {
                a16.authenticate(a(dVar), (CancellationSignal) obj, i3, a(abstractC6452b), handler);
            } else {
                e.b("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
            }
        } catch (SecurityException unused) {
            e.b("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
        }
    }

    public static d b(FingerprintManager.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new d(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new d(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new d(cryptoObject.getMac());
        }
        return null;
    }

    public static FingerprintManager.CryptoObject a(d dVar) {
        if (dVar == null) {
            return null;
        }
        if (dVar.a() != null) {
            return new FingerprintManager.CryptoObject(dVar.a());
        }
        if (dVar.c() != null) {
            return new FingerprintManager.CryptoObject(dVar.c());
        }
        if (dVar.b() != null) {
            return new FingerprintManager.CryptoObject(dVar.b());
        }
        return null;
    }

    public static FingerprintManager.AuthenticationCallback a(AbstractC6452b abstractC6452b) {
        return new a(abstractC6452b);
    }
}
