package com.tencent.turingcam;

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
import com.tencent.turingcam.Gc2mM;
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
/* loaded from: classes27.dex */
public class k7FCJ {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f382282a;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ShGzN {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f382283a;

        /* renamed from: b, reason: collision with root package name */
        public d3EI1 f382284b;

        public ShGzN(int i3, d3EI1 d3ei1) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) d3ei1);
            } else {
                this.f382283a = i3;
                this.f382284b = d3ei1;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class spXPg implements ServiceConnection {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f382285a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f382286b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f382287c;

        /* compiled from: P */
        /* renamed from: com.tencent.turingcam.k7FCJ$spXPg$spXPg, reason: collision with other inner class name */
        /* loaded from: classes27.dex */
        public class C10027spXPg extends BaseThread {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IBinder f382288a;

            public C10027spXPg(IBinder iBinder) {
                this.f382288a = iBinder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) spXPg.this, (Object) iBinder);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Gc2mM c10025spXPg;
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                IBinder iBinder = this.f382288a;
                String str = Gc2mM.spXPg.f381831a;
                if (iBinder == null) {
                    c10025spXPg = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface(str);
                    if (queryLocalInterface != null && (queryLocalInterface instanceof Gc2mM)) {
                        c10025spXPg = (Gc2mM) queryLocalInterface;
                    } else {
                        c10025spXPg = new Gc2mM.spXPg.C10025spXPg(iBinder);
                    }
                }
                try {
                    if (!c10025spXPg.c(2000)) {
                        c10025spXPg.d(2000);
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    try {
                        ShGzN a16 = k7FCJ.a(c10025spXPg.b(2000).f382111b);
                        int i16 = a16.f382283a;
                        if (i16 != 0) {
                            spXPg.this.f382285a.set(e7l68.a(i16, i3));
                        } else {
                            d3EI1 d3ei1 = a16.f382284b;
                            spXPg.this.f382285a.set(new e7l68(0, 200, System.currentTimeMillis() - spXPg.this.f382286b, d3ei1.f382187c, c10025spXPg.a(), i3));
                        }
                    } catch (Throwable unused) {
                        spXPg.this.f382285a.set(e7l68.a(-2003, i3));
                        synchronized (spXPg.this.f382287c) {
                        }
                    }
                } catch (Throwable unused2) {
                    i3 = -1;
                }
                synchronized (spXPg.this.f382287c) {
                    spXPg.this.f382287c.notify();
                }
                if (ZY08E.f382121f.a("s_t_d_ask", false)) {
                    try {
                        c10025spXPg.a(2000);
                    } catch (RemoteException e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }

        public spXPg(AtomicReference atomicReference, long j3, Object obj) {
            this.f382285a = atomicReference;
            this.f382286b = j3;
            this.f382287c = obj;
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
                new C10027spXPg(iBinder).start();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
                return;
            }
            this.f382285a.set(e7l68.a(-2004, -3));
            synchronized (this.f382287c) {
                this.f382287c.notify();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13781);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f382282a = LwgsO.a(LwgsO.H0);
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
    public static e7l68 a() {
        String str;
        boolean z16;
        KeyStore keyStore;
        int myUid;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Method method = Class.forName(LwgsO.a(LwgsO.I0)).getMethod(LwgsO.a(LwgsO.J0), new Class[0]);
            boolean z17 = true;
            method.setAccessible(true);
            method.invoke(null, new Object[0]);
            Provider[] providers = Security.getProviders();
            if (providers == null) {
                return e7l68.a(-1201);
            }
            int length = providers.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    str = providers[i3].getName();
                    if (str != null && str.startsWith(f382282a)) {
                        break;
                    }
                    i3++;
                } else {
                    str = null;
                    break;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return e7l68.a(-1202);
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
                return e7l68.a(-1303);
            } catch (KeyStoreException unused3) {
                return e7l68.a(-1301);
            } catch (NoSuchAlgorithmException unused4) {
                return e7l68.a(-1304);
            } catch (CertificateException unused5) {
                return e7l68.a(-1302);
            }
            z17 = false;
            if (!z17) {
                try {
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", str);
                    try {
                        try {
                            keyPairGenerator.initialize(wiSNn.a("dddd" + myUid + LwgsO.a(LwgsO.K0), z16 ? 16 : 4).a(KeyPropertiesCompact.DIGEST_SHA256).b(KeyPropertiesCompact.SIGNATURE_PADDING_RSA_PSS).a());
                            try {
                                keyPairGenerator.generateKeyPair();
                            } catch (Throwable unused6) {
                            }
                        } catch (InvalidAlgorithmParameterException unused7) {
                            return e7l68.a(-1701);
                        }
                    } catch (ClassNotFoundException unused8) {
                        return e7l68.a(-1601);
                    } catch (IllegalAccessException unused9) {
                        return e7l68.a(-1603);
                    } catch (InstantiationException unused10) {
                        return e7l68.a(-1605);
                    } catch (NoSuchMethodException unused11) {
                        return e7l68.a(-1602);
                    } catch (InvocationTargetException unused12) {
                        return e7l68.a(-1604);
                    }
                } catch (NoSuchAlgorithmException unused13) {
                    return e7l68.a(-1501);
                } catch (NoSuchProviderException unused14) {
                    return e7l68.a(-1502);
                }
            }
            if (!z16) {
                try {
                    return new e7l68(0, 100, System.currentTimeMillis() - currentTimeMillis, new d3EI1(keyStore.getCertificateChain("dddd" + myUid)).f382187c, -1, -2);
                } catch (KeyStoreException e16) {
                    e16.printStackTrace();
                    return e7l68.a(-1901);
                }
            }
            try {
                Key key = keyStore.getKey("dddd" + myUid, LwgsO.a(LwgsO.L0).toCharArray());
                if (key != null) {
                    ShGzN a16 = a(key.getEncoded());
                    int i16 = a16.f382283a;
                    if (i16 != 0) {
                        return e7l68.a(i16);
                    }
                    d3EI1 d3ei1 = a16.f382284b;
                    if (ZY08E.f382121f.a("s_t_d_entry", false)) {
                        try {
                            keyStore.deleteEntry("dddd" + myUid);
                        } catch (Throwable unused15) {
                        }
                    }
                    return new e7l68(0, 100, System.currentTimeMillis() - currentTimeMillis, d3ei1.f382187c, -1, -2);
                }
            } catch (KeyStoreException unused16) {
                return e7l68.a(-1801);
            } catch (NoSuchAlgorithmException unused17) {
                return e7l68.a(-1802);
            } catch (UnrecoverableKeyException unused18) {
                return e7l68.a(-1803);
            }
            return e7l68.a(-1901);
            if (!z16) {
            }
            return e7l68.a(-1901);
            return new e7l68(0, 100, System.currentTimeMillis() - currentTimeMillis, d3ei1.f382187c, -1, -2);
        } catch (ClassNotFoundException unused19) {
            return e7l68.a(-1104);
        } catch (IllegalAccessException unused20) {
            return e7l68.a(-1103);
        } catch (NoSuchMethodException unused21) {
            return e7l68.a(WeakNetLearner.PROBE_REASON.TRANSACTION_FAIL);
        } catch (InvocationTargetException unused22) {
            return e7l68.a(WeakNetLearner.PROBE_REASON.INVALID_DATA);
        }
    }

    public static e7l68 a(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent();
        intent.setAction(LwgsO.a(LwgsO.M0));
        intent.setPackage(LwgsO.a(LwgsO.N0));
        Object obj = new Object();
        AtomicReference atomicReference = new AtomicReference();
        atomicReference.set(e7l68.a(-2001, -1));
        if (context.getApplicationContext().bindService(intent, new spXPg(atomicReference, currentTimeMillis, obj), 1)) {
            synchronized (obj) {
                try {
                    obj.wait(5000L);
                } catch (InterruptedException unused) {
                }
            }
        } else {
            atomicReference.set(e7l68.a(-2002, -1));
        }
        return (e7l68) atomicReference.get();
    }

    public static ShGzN a(byte[] bArr) {
        if (bArr == null) {
            return new ShGzN(-3001, null);
        }
        if (bArr.length < 4) {
            return new ShGzN(-3001, null);
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        int i3 = 0;
        for (int i16 = 0; i16 < 4; i16++) {
            i3 += (bArr2[i16] & 255) << (i16 * 8);
        }
        if (i3 > 1048576) {
            return new ShGzN(-3003, null);
        }
        byte[] bArr3 = new byte[i3];
        int i17 = i3 + 4;
        if (bArr.length < i17) {
            return new ShGzN(MessageRecord.MSG_TYPE_GAME_INVITE, null);
        }
        System.arraycopy(bArr, 4, bArr3, 0, i3);
        d3EI1 d3ei1 = new d3EI1(new String(bArr3), "");
        int length = bArr.length - i17;
        if (length != 0) {
            byte[] bArr4 = new byte[length];
            System.arraycopy(bArr, i17, bArr4, 0, length);
            Base64.encodeToString(bArr4, 2);
            return new ShGzN(0, d3ei1);
        }
        return new ShGzN(MessageRecord.MSG_TYPE_GAME_SHARE, null);
    }
}
