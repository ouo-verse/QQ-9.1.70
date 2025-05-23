package com.tencent.turingfd.sdk.xq;

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
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.turingfd.sdk.xq.Equuleus;
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

/* loaded from: classes27.dex */
public class Pistachio {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f383011a;

    /* renamed from: com.tencent.turingfd.sdk.xq.Pistachio$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cdo implements ServiceConnection {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f383012a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f383013b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f383014c;

        /* renamed from: com.tencent.turingfd.sdk.xq.Pistachio$do$do, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes27.dex */
        public class C10033do extends BaseThread {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IBinder f383015a;

            public C10033do(IBinder iBinder) {
                this.f383015a = iBinder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) Cdo.this, (Object) iBinder);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Equuleus c10031do;
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                IBinder iBinder = this.f383015a;
                String str = Equuleus.Cdo.f382737a;
                if (iBinder == null) {
                    c10031do = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface(Equuleus.Cdo.f382737a);
                    if (queryLocalInterface != null && (queryLocalInterface instanceof Equuleus)) {
                        c10031do = (Equuleus) queryLocalInterface;
                    } else {
                        c10031do = new Equuleus.Cdo.C10031do(iBinder);
                    }
                }
                try {
                    if (!c10031do.c(2000)) {
                        c10031do.b(2000);
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    try {
                        Cif a16 = Pistachio.a(c10031do.d(2000).f382991b);
                        int i16 = a16.f383017a;
                        if (i16 != 0) {
                            Cdo.this.f383012a.set(Peanut.a(i16, i3));
                        } else {
                            Pineapple pineapple = a16.f383018b;
                            Cdo.this.f383012a.set(new Peanut(0, 200, System.currentTimeMillis() - Cdo.this.f383013b, pineapple.f383009c, c10031do.a(), i3));
                        }
                    } catch (Throwable unused) {
                        Cdo.this.f383012a.set(Peanut.a(-2003, i3));
                        synchronized (Cdo.this.f383014c) {
                        }
                    }
                } catch (Throwable unused2) {
                    i3 = -1;
                }
                synchronized (Cdo.this.f383014c) {
                    Cdo.this.f383014c.notify();
                }
                if (Warden.f383204f.a("s_t_d_ask", false)) {
                    try {
                        c10031do.a(2000);
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }

        public Cdo(AtomicReference atomicReference, long j3, Object obj) {
            this.f383012a = atomicReference;
            this.f383013b = j3;
            this.f383014c = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, atomicReference, Long.valueOf(j3), obj);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
            } else {
                new C10033do(iBinder).start();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
                return;
            }
            this.f383012a.set(Peanut.a(-2004, -3));
            synchronized (this.f383014c) {
                this.f383014c.notify();
            }
        }
    }

    /* renamed from: com.tencent.turingfd.sdk.xq.Pistachio$if, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cif {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f383017a;

        /* renamed from: b, reason: collision with root package name */
        public Pineapple f383018b;

        public Cif(int i3, Pineapple pineapple) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) pineapple);
            } else {
                this.f383017a = i3;
                this.f383018b = pineapple;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12380);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f383011a = Ccontinue.a(Ccontinue.H0);
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
    public static Peanut a() {
        String str;
        boolean z16;
        KeyStore keyStore;
        int myUid;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Method method = Class.forName(Ccontinue.a(Ccontinue.I0)).getMethod(Ccontinue.a(Ccontinue.J0), new Class[0]);
            boolean z17 = true;
            method.setAccessible(true);
            method.invoke(null, new Object[0]);
            Provider[] providers = Security.getProviders();
            if (providers == null) {
                return Peanut.a(-1201);
            }
            int length = providers.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    str = providers[i3].getName();
                    if (str != null && str.startsWith(f383011a)) {
                        break;
                    }
                    i3++;
                } else {
                    str = null;
                    break;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return Peanut.a(-1202);
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
                return Peanut.a(-1303);
            } catch (KeyStoreException unused3) {
                return Peanut.a(-1301);
            } catch (NoSuchAlgorithmException unused4) {
                return Peanut.a(-1304);
            } catch (CertificateException unused5) {
                return Peanut.a(-1302);
            }
            z17 = false;
            if (!z17) {
                try {
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", str);
                    try {
                        try {
                            keyPairGenerator.initialize(UrsaMajor.a("dddd" + myUid + Ccontinue.a(Ccontinue.K0), z16 ? 16 : 4).a(KeyPropertiesCompact.DIGEST_SHA256).b(KeyPropertiesCompact.SIGNATURE_PADDING_RSA_PSS).a());
                            try {
                                keyPairGenerator.generateKeyPair();
                            } catch (Throwable unused6) {
                            }
                        } catch (InvalidAlgorithmParameterException unused7) {
                            return Peanut.a(-1701);
                        }
                    } catch (ClassNotFoundException unused8) {
                        return Peanut.a(-1601);
                    } catch (IllegalAccessException unused9) {
                        return Peanut.a(-1603);
                    } catch (InstantiationException unused10) {
                        return Peanut.a(-1605);
                    } catch (NoSuchMethodException unused11) {
                        return Peanut.a(-1602);
                    } catch (InvocationTargetException unused12) {
                        return Peanut.a(-1604);
                    }
                } catch (NoSuchAlgorithmException unused13) {
                    return Peanut.a(-1501);
                } catch (NoSuchProviderException unused14) {
                    return Peanut.a(-1502);
                }
            }
            if (!z16) {
                try {
                    return new Peanut(0, 100, System.currentTimeMillis() - currentTimeMillis, new Pineapple(keyStore.getCertificateChain("dddd" + myUid)).f383009c, -1, -2);
                } catch (KeyStoreException e16) {
                    e16.printStackTrace();
                    return Peanut.a(-1901);
                }
            }
            try {
                Key key = keyStore.getKey("dddd" + myUid, Ccontinue.a(Ccontinue.L0).toCharArray());
                if (key != null) {
                    Cif a16 = a(key.getEncoded());
                    int i16 = a16.f383017a;
                    if (i16 != 0) {
                        return Peanut.a(i16);
                    }
                    Pineapple pineapple = a16.f383018b;
                    if (Warden.f383204f.a("s_t_d_entry", false)) {
                        try {
                            keyStore.deleteEntry("dddd" + myUid);
                        } catch (Throwable unused15) {
                        }
                    }
                    return new Peanut(0, 100, System.currentTimeMillis() - currentTimeMillis, pineapple.f383009c, -1, -2);
                }
            } catch (KeyStoreException unused16) {
                return Peanut.a(-1801);
            } catch (NoSuchAlgorithmException unused17) {
                return Peanut.a(-1802);
            } catch (UnrecoverableKeyException unused18) {
                return Peanut.a(-1803);
            }
            return Peanut.a(-1901);
            if (!z16) {
            }
            return Peanut.a(-1901);
            return new Peanut(0, 100, System.currentTimeMillis() - currentTimeMillis, pineapple.f383009c, -1, -2);
        } catch (ClassNotFoundException unused19) {
            return Peanut.a(-1104);
        } catch (IllegalAccessException unused20) {
            return Peanut.a(-1103);
        } catch (NoSuchMethodException unused21) {
            return Peanut.a(WeakNetLearner.PROBE_REASON.TRANSACTION_FAIL);
        } catch (InvocationTargetException unused22) {
            return Peanut.a(WeakNetLearner.PROBE_REASON.INVALID_DATA);
        }
    }

    public static Peanut a(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent();
        intent.setAction(Ccontinue.a(Ccontinue.M0));
        intent.setPackage(Ccontinue.a(Ccontinue.N0));
        Object obj = new Object();
        AtomicReference atomicReference = new AtomicReference();
        atomicReference.set(Peanut.a(-2001, -1));
        if (context.getApplicationContext().bindService(intent, new Cdo(atomicReference, currentTimeMillis, obj), 1)) {
            synchronized (obj) {
                try {
                    obj.wait(5000L);
                } catch (InterruptedException unused) {
                }
            }
        } else {
            atomicReference.set(Peanut.a(-2002, -1));
        }
        return (Peanut) atomicReference.get();
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
        Pineapple pineapple = new Pineapple(new String(bArr3), "");
        int length = bArr.length - i17;
        if (length != 0) {
            byte[] bArr4 = new byte[length];
            System.arraycopy(bArr, i17, bArr4, 0, length);
            Base64.encodeToString(bArr4, 2);
            return new Cif(0, pineapple);
        }
        return new Cif(MessageRecord.MSG_TYPE_GAME_SHARE, null);
    }
}
