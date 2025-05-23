package com.tencent.tfd.sdk.wxa;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.tfd.sdk.wxa.Cprotected;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Banana {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f375420a;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Banana$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cdo implements ServiceConnection {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f375421a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f375422b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f375423c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f375424d;

        /* compiled from: P */
        /* renamed from: com.tencent.tfd.sdk.wxa.Banana$do$do, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes26.dex */
        public class C9903do extends BaseThread {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IBinder f375425a;

            public C9903do(IBinder iBinder) {
                this.f375425a = iBinder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) Cdo.this, (Object) iBinder);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                Cprotected c9904do;
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                IBinder iBinder = this.f375425a;
                String str = Cprotected.Cdo.f375767a;
                if (iBinder == null) {
                    c9904do = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface(Cprotected.Cdo.f375767a);
                    if (queryLocalInterface != null && (queryLocalInterface instanceof Cprotected)) {
                        c9904do = (Cprotected) queryLocalInterface;
                    } else {
                        c9904do = new Cprotected.Cdo.C9904do(iBinder);
                    }
                }
                try {
                    if (!c9904do.b()) {
                        c9904do.c();
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    try {
                        Cif a16 = Banana.a(c9904do.d().f375407b);
                        int i16 = a16.f375427a;
                        if (i16 != 0) {
                            Cdo.this.f375421a.set(Apricot.a(i16, i3));
                        } else {
                            Cdo.this.f375421a.set(new Apricot(0, 200, System.currentTimeMillis() - Cdo.this.f375422b, a16.f375428b.f375418c, c9904do.a(), i3));
                        }
                    } catch (Throwable unused) {
                        Cdo.this.f375421a.set(Apricot.a(-2003, i3));
                        synchronized (Cdo.this.f375423c) {
                        }
                    }
                } catch (Throwable unused2) {
                    i3 = -1;
                }
                synchronized (Cdo.this.f375423c) {
                    Cdo.this.f375423c.notify();
                }
                if (Coconut.f375544e.a(Cdo.this.f375424d, "s_t_d_ask", false)) {
                    try {
                        c9904do.e();
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }

        public Cdo(AtomicReference atomicReference, long j3, Object obj, Context context) {
            this.f375421a = atomicReference;
            this.f375422b = j3;
            this.f375423c = obj;
            this.f375424d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, atomicReference, Long.valueOf(j3), obj, context);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
            } else {
                new C9903do(iBinder).start();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
                return;
            }
            this.f375421a.set(Apricot.a(-2004, -3));
            synchronized (this.f375423c) {
                this.f375423c.notify();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Banana$if, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static class Cif {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f375427a;

        /* renamed from: b, reason: collision with root package name */
        public Bagasse f375428b;

        public Cif(int i3, Bagasse bagasse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) bagasse);
            } else {
                this.f375427a = i3;
                this.f375428b = bagasse;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62394);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f375420a = Cswitch.a(Cswitch.G0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0086, code lost:
    
        if (r6.getCertificate("dddd" + r7) != null) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0140 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Apricot a(Context context) {
        String str;
        boolean z16;
        KeyStore keyStore;
        int myUid;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Method method = Class.forName(Cswitch.a(Cswitch.H0)).getMethod(Cswitch.a(Cswitch.I0), new Class[0]);
            boolean z17 = true;
            method.setAccessible(true);
            method.invoke(null, new Object[0]);
            Provider[] providers = Security.getProviders();
            if (providers == null) {
                return Apricot.a(-1201);
            }
            int length = providers.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    str = providers[i3].getName();
                    if (str != null && str.startsWith(f375420a)) {
                        break;
                    }
                    i3++;
                } else {
                    str = null;
                    break;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return Apricot.a(-1202);
            }
            z16 = str.split("\\.").length > 1;
            try {
                keyStore = KeyStore.getInstance(str);
                keyStore.load(null);
                myUid = Process.myUid();
                try {
                } catch (Throwable unused) {
                }
            } catch (IOException unused2) {
                return Apricot.a(-1303);
            } catch (KeyStoreException unused3) {
                return Apricot.a(-1301);
            } catch (NoSuchAlgorithmException unused4) {
                return Apricot.a(-1304);
            } catch (CertificateException unused5) {
                return Apricot.a(-1302);
            }
            z17 = false;
            if (!z17) {
                try {
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", str);
                    try {
                        try {
                            keyPairGenerator.initialize(Cassiopeia.a("dddd" + myUid + Cswitch.a(Cswitch.J0), z16 ? 16 : 4).a(KeyPropertiesCompact.DIGEST_SHA256).b(KeyPropertiesCompact.SIGNATURE_PADDING_RSA_PSS).a());
                            try {
                                keyPairGenerator.generateKeyPair();
                            } catch (Throwable unused6) {
                            }
                        } catch (InvalidAlgorithmParameterException unused7) {
                            return Apricot.a(-1701);
                        }
                    } catch (ClassNotFoundException unused8) {
                        return Apricot.a(-1601);
                    } catch (IllegalAccessException unused9) {
                        return Apricot.a(-1603);
                    } catch (InstantiationException unused10) {
                        return Apricot.a(-1605);
                    } catch (NoSuchMethodException unused11) {
                        return Apricot.a(-1602);
                    } catch (InvocationTargetException unused12) {
                        return Apricot.a(-1604);
                    }
                } catch (NoSuchAlgorithmException unused13) {
                    return Apricot.a(-1501);
                } catch (NoSuchProviderException unused14) {
                    return Apricot.a(-1502);
                }
            }
            if (!z16) {
                try {
                    return new Apricot(0, 100, System.currentTimeMillis() - currentTimeMillis, new Bagasse(keyStore.getCertificateChain("dddd" + myUid)).f375418c, -1, -2);
                } catch (KeyStoreException e16) {
                    e16.printStackTrace();
                    return Apricot.a(-1901);
                }
            }
            try {
                Key key = keyStore.getKey("dddd" + myUid, Cswitch.a(Cswitch.K0).toCharArray());
                if (key != null) {
                    Cif a16 = a(key.getEncoded());
                    int i16 = a16.f375427a;
                    if (i16 != 0) {
                        return Apricot.a(i16);
                    }
                    Bagasse bagasse = a16.f375428b;
                    if (Coconut.f375544e.a(context, "s_t_d_entry", false)) {
                        try {
                            keyStore.deleteEntry("dddd" + myUid);
                        } catch (Throwable unused15) {
                        }
                    }
                    return new Apricot(0, 100, System.currentTimeMillis() - currentTimeMillis, bagasse.f375418c, -1, -2);
                }
            } catch (KeyStoreException unused16) {
                return Apricot.a(-1801);
            } catch (NoSuchAlgorithmException unused17) {
                return Apricot.a(-1802);
            } catch (UnrecoverableKeyException unused18) {
                return Apricot.a(-1803);
            }
            return Apricot.a(-1901);
            if (!z16) {
            }
            return Apricot.a(-1901);
            return new Apricot(0, 100, System.currentTimeMillis() - currentTimeMillis, bagasse.f375418c, -1, -2);
        } catch (ClassNotFoundException unused19) {
            return Apricot.a(-1104);
        } catch (IllegalAccessException unused20) {
            return Apricot.a(-1103);
        } catch (NoSuchMethodException unused21) {
            return Apricot.a(WeakNetLearner.PROBE_REASON.TRANSACTION_FAIL);
        } catch (InvocationTargetException unused22) {
            return Apricot.a(WeakNetLearner.PROBE_REASON.INVALID_DATA);
        }
    }

    public static Apricot b(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent();
        intent.setAction(Cswitch.a(Cswitch.L0));
        intent.setPackage(Cswitch.a(Cswitch.M0));
        Object obj = new Object();
        AtomicReference atomicReference = new AtomicReference();
        atomicReference.set(Apricot.a(-2001, -1));
        if (context.getApplicationContext().bindService(intent, new Cdo(atomicReference, currentTimeMillis, obj, context), 1)) {
            synchronized (obj) {
                try {
                    obj.wait(5000L);
                } catch (InterruptedException unused) {
                }
            }
        } else {
            atomicReference.set(Apricot.a(-2002, -1));
        }
        return (Apricot) atomicReference.get();
    }

    public static Cif a(byte[] bArr) {
        if (bArr == null) {
            return new Cif(-3001, null);
        }
        if (bArr.length < 4) {
            return new Cif(-3001, null);
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        int i3 = 0;
        for (int i16 = 0; i16 < 4; i16++) {
            i3 += (bArr2[i16] & 255) << (i16 * 8);
        }
        if (i3 > 1048576) {
            return new Cif(-3003, null);
        }
        byte[] bArr3 = new byte[i3];
        int i17 = i3 + 4;
        if (bArr.length < i17) {
            return new Cif(MessageRecord.MSG_TYPE_GAME_INVITE, null);
        }
        System.arraycopy(bArr, 4, bArr3, 0, i3);
        Bagasse bagasse = new Bagasse(new String(bArr3));
        int length = bArr.length - i17;
        if (length != 0) {
            byte[] bArr4 = new byte[length];
            System.arraycopy(bArr, i17, bArr4, 0, length);
            Base64.encodeToString(bArr4, 2);
            return new Cif(0, bagasse);
        }
        return new Cif(MessageRecord.MSG_TYPE_GAME_SHARE, null);
    }
}
