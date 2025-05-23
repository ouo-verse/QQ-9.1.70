package com.tencent.mobileqq.openapi;

import android.content.Context;
import android.content.pm.Signature;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Random;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, C8192a> f256896a;

    /* renamed from: b, reason: collision with root package name */
    static final String[] f256897b;

    /* renamed from: c, reason: collision with root package name */
    static final String[] f256898c;

    /* renamed from: d, reason: collision with root package name */
    static final String[] f256899d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.openapi.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8192a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f256900a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f256901b;

        /* renamed from: c, reason: collision with root package name */
        public String f256902c;

        /* renamed from: d, reason: collision with root package name */
        public String f256903d;

        /* renamed from: e, reason: collision with root package name */
        public int f256904e;

        /* renamed from: f, reason: collision with root package name */
        public int f256905f;

        /* renamed from: g, reason: collision with root package name */
        public int f256906g;

        /* renamed from: h, reason: collision with root package name */
        public long f256907h;

        /* renamed from: i, reason: collision with root package name */
        public long f256908i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f256909j;

        /* renamed from: k, reason: collision with root package name */
        public long f256910k;

        /* renamed from: l, reason: collision with root package name */
        public long f256911l;

        public C8192a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f256909j = false;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73460);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f256896a = new HashMap<>();
        f256897b = new String[]{"1234567890twstest", "123AppShadowQQ", "gwatchdm2016"};
        f256898c = new String[]{"com.tencent.tws.devicemanager", "com.tencent.shadowqq", "com.tencent.tws.gdevicemanager"};
        f256899d = new String[]{"E63D0E11EF7837C5A1BEB948742B0CB6", "CCD4AD38DC6669F875BC37E3F8840648", "E63D0E11EF7837C5A1BEB948742B0CB6"};
    }

    private static C8192a a(Context context, String str) {
        int length = f256897b.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (f256897b[i3].equals(str)) {
                C8192a c8192a = new C8192a();
                c8192a.f256900a = str;
                c8192a.f256901b = true;
                c8192a.f256902c = f256898c[i3];
                c8192a.f256903d = f256899d[i3];
                c8192a.f256908i = NetConnInfoCenter.getServerTimeMillis();
                c8192a.f256907h = new Random().nextLong();
                c8192a.f256904e = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                c8192a.f256905f = Integer.MAX_VALUE;
                c8192a.f256906g = 7;
                c(context, c8192a);
                return c8192a;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final C8192a b(Context context, String str) {
        C8192a a16;
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        synchronized (f256896a) {
            if (f256896a.containsKey(str)) {
                return f256896a.get(str);
            }
            File file = new File(context.getFilesDir(), str + "_config");
            if (file.exists() && file.length() != 0) {
                a16 = new C8192a();
                ObjectInputStream objectInputStream2 = null;
                try {
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(FileUtils.fileToBytes(file));
                        try {
                            objectInputStream = new ObjectInputStream(byteArrayInputStream);
                        } catch (Exception e16) {
                            e = e16;
                            objectInputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            if (objectInputStream2 != null) {
                                try {
                                    objectInputStream2.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (byteArrayInputStream != null) {
                                try {
                                    byteArrayInputStream.close();
                                    throw th;
                                } catch (Exception unused2) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        objectInputStream = null;
                        byteArrayInputStream = null;
                    } catch (Throwable th6) {
                        th = th6;
                        byteArrayInputStream = null;
                    }
                    try {
                        a16.f256900a = (String) objectInputStream.readObject();
                        boolean readBoolean = objectInputStream.readBoolean();
                        a16.f256901b = readBoolean;
                        if (readBoolean) {
                            a16.f256902c = (String) objectInputStream.readObject();
                            a16.f256903d = (String) objectInputStream.readObject();
                            a16.f256904e = objectInputStream.readInt();
                            a16.f256905f = objectInputStream.readInt();
                            a16.f256906g = objectInputStream.readInt();
                            a16.f256908i = objectInputStream.readLong();
                            a16.f256907h = objectInputStream.readLong();
                            if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - a16.f256908i) > 1728000000) {
                                a16.f256909j = true;
                                a16.f256911l = NetConnInfoCenter.getServerTimeMillis();
                                a16.f256910k = new Random().nextLong();
                                if (QLog.isColorLevel()) {
                                    QLog.d("OpenApi.Config", 2, "on key expired, " + a16.f256908i + " to " + a16.f256911l);
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("OpenApi.Config", 2, "AppConfig: " + a16.f256902c + ", " + a16.f256905f + ", " + a16.f256906g);
                            }
                        }
                        try {
                            objectInputStream.close();
                        } catch (Exception unused3) {
                        }
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused4) {
                        }
                    } catch (Exception e18) {
                        e = e18;
                        QLog.d("OpenApi.Config", 1, "", e);
                        try {
                            file.delete();
                        } catch (Exception unused5) {
                        }
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (Exception unused6) {
                            }
                        }
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception unused7) {
                            }
                        }
                        a16 = null;
                        if (a16 != null) {
                        }
                        return a16;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    objectInputStream2 = null;
                }
            } else {
                a16 = a(context, str);
            }
            if (a16 != null) {
                synchronized (f256896a) {
                    f256896a.put(str, a16);
                }
            }
            return a16;
        }
    }

    public static final synchronized void c(Context context, C8192a c8192a) {
        synchronized (a.class) {
            synchronized (f256896a) {
                f256896a.put(c8192a.f256900a, c8192a);
            }
            ObjectOutputStream objectOutputStream = null;
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream2.writeObject(c8192a.f256900a);
                        objectOutputStream2.writeBoolean(c8192a.f256901b);
                        if (c8192a.f256901b) {
                            objectOutputStream2.writeObject(c8192a.f256902c);
                            objectOutputStream2.writeObject(c8192a.f256903d);
                            objectOutputStream2.writeInt(c8192a.f256904e);
                            objectOutputStream2.writeInt(c8192a.f256905f);
                            objectOutputStream2.writeInt(c8192a.f256906g);
                            objectOutputStream2.writeLong(c8192a.f256908i);
                            objectOutputStream2.writeLong(c8192a.f256907h);
                        }
                        objectOutputStream2.flush();
                        FileUtils.pushData2File(new File(context.getFilesDir(), c8192a.f256900a + "_config").getAbsolutePath(), byteArrayOutputStream.toByteArray(), false);
                        objectOutputStream2.close();
                    } catch (Exception e16) {
                        e = e16;
                        objectOutputStream = objectOutputStream2;
                        if (QLog.isColorLevel()) {
                            QLog.d("OpenApi.Config", 2, "saveAppConfig | Exception:", e);
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    public static final void d(Context context, C8192a c8192a) {
        if (QLog.isColorLevel()) {
            QLog.d("OpenApi.Config", 2, "saveNewKey, " + c8192a.f256908i + " to " + c8192a.f256911l);
        }
        if (c8192a.f256909j) {
            c8192a.f256908i = c8192a.f256911l;
            c8192a.f256907h = c8192a.f256910k;
            c8192a.f256909j = false;
            c(context, c8192a);
        }
    }

    public static final boolean e(Context context, String str, String str2) {
        try {
            Signature[] signatureArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(signatureArr[0].toByteArray());
            String upperCase = HexUtil.bytes2HexStr(messageDigest.digest()).toUpperCase();
            boolean equals = str2.equals(upperCase);
            if (!equals && QLog.isColorLevel()) {
                QLog.d("OpenApi.Config", 2, "verifysig fail, pkg = " + str + ", sign = " + upperCase);
            }
            return equals;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("OpenApi.Config", 2, "verifysig", e16);
            }
            return false;
        }
    }
}
