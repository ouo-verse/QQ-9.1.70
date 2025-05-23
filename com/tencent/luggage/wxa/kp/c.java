package com.tencent.luggage.wxa.kp;

import android.content.Context;
import android.os.Handler;
import com.tencent.soter.core.biometric.FaceidManagerProxy;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class a {
    }

    public static com.tencent.luggage.wxa.kp.b a(Context context) {
        try {
            com.tencent.luggage.wxa.k0.d.a(Class.forName(FaceidManagerProxy.FACEMANAGER_FACTORY_CLASS_NAME).getDeclaredMethod("getFaceManager", Context.class).invoke(null, context));
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.b("Soter.FaceidManagerProxy", "soter: FaceManager init failed, maybe not support." + e16.toString(), new Object[0]);
            e16.printStackTrace();
        }
        return null;
    }

    public static boolean b(Context context) {
        try {
            a(context);
            com.tencent.luggage.wxa.np.e.b("Soter.FaceidManagerProxy", "soter: facemanager is null in hasEnrolledBiometric! Should never happen", new Object[0]);
            return false;
        } catch (Exception unused) {
            com.tencent.luggage.wxa.np.e.b("Soter.FaceidManagerProxy", "soter: triggered SecurityException in hasEnrolledBiometric! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }

    public static boolean c(Context context) {
        try {
            a(context);
            com.tencent.luggage.wxa.np.e.b("Soter.FaceidManagerProxy", "soter: facemanager is null in isHardwareDetected! Should never happen", new Object[0]);
            return false;
        } catch (Exception unused) {
            com.tencent.luggage.wxa.np.e.b("Soter.FaceidManagerProxy", "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Signature f132690a;

        /* renamed from: b, reason: collision with root package name */
        public final Cipher f132691b;

        /* renamed from: c, reason: collision with root package name */
        public final Mac f132692c;

        public b(Signature signature) {
            this.f132690a = signature;
            this.f132691b = null;
            this.f132692c = null;
        }

        public b(Cipher cipher) {
            this.f132691b = cipher;
            this.f132690a = null;
            this.f132692c = null;
        }

        public b(Mac mac) {
            this.f132692c = mac;
            this.f132691b = null;
            this.f132690a = null;
        }
    }

    public static void a(Context context, b bVar, int i3, Object obj, a aVar, Handler handler) {
        try {
            a(context);
            com.tencent.luggage.wxa.np.e.b("Soter.FaceidManagerProxy", "soter: facemanager is null in authenticate! Should never happen", new Object[0]);
        } catch (Exception unused) {
            com.tencent.luggage.wxa.np.e.b("Soter.FaceidManagerProxy", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
        }
    }
}
