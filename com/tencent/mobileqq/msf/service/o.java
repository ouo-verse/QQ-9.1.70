package com.tencent.mobileqq.msf.service;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class o implements IBinder.DeathRecipient {
    static IPatchRedirector $redirector_ = null;
    private static final CopyOnWriteArrayList<a> A;
    public static final int B = 2;
    public static final int C = 1;
    public static final int D = 0;
    public static final int E = 3;
    public static final boolean F = true;

    /* renamed from: j, reason: collision with root package name */
    private static final int f250972j = 90000;

    /* renamed from: k, reason: collision with root package name */
    private static final int f250973k = 500;

    /* renamed from: l, reason: collision with root package name */
    private static final String f250974l = "GuardManager";

    /* renamed from: m, reason: collision with root package name */
    private static final String f250975m = "gm_history";

    /* renamed from: n, reason: collision with root package name */
    private static final int f250976n = 1;

    /* renamed from: o, reason: collision with root package name */
    private static final int f250977o = 2;

    /* renamed from: p, reason: collision with root package name */
    private static final int f250978p = 3;

    /* renamed from: q, reason: collision with root package name */
    private static final int f250979q = 4;

    /* renamed from: r, reason: collision with root package name */
    private static final int f250980r = 5;

    /* renamed from: s, reason: collision with root package name */
    private static long f250981s = 720000;

    /* renamed from: t, reason: collision with root package name */
    private static long f250982t = 0;

    /* renamed from: u, reason: collision with root package name */
    private static long f250983u = 0;

    /* renamed from: v, reason: collision with root package name */
    private static final int f250984v = 2;

    /* renamed from: w, reason: collision with root package name */
    private static final int f250985w = 1;

    /* renamed from: x, reason: collision with root package name */
    private static final int f250986x = 0;

    /* renamed from: y, reason: collision with root package name */
    private static int f250987y = 0;

    /* renamed from: z, reason: collision with root package name */
    private static int f250988z = 3;

    /* renamed from: a, reason: collision with root package name */
    private IBinder f250989a;

    /* renamed from: b, reason: collision with root package name */
    private int f250990b;

    /* renamed from: c, reason: collision with root package name */
    private long f250991c;

    /* renamed from: d, reason: collision with root package name */
    private b f250992d;

    /* renamed from: e, reason: collision with root package name */
    private b f250993e;

    /* renamed from: f, reason: collision with root package name */
    private b f250994f;

    /* renamed from: g, reason: collision with root package name */
    private MsfCore f250995g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f250996h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f250997i;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19487);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            A = new CopyOnWriteArrayList<>();
        }
    }

    public o(MsfCore msfCore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore);
            return;
        }
        this.f250990b = 1;
        this.f250991c = 0L;
        this.f250996h = false;
        this.f250997i = false;
        this.f250995g = msfCore;
    }

    private boolean c() {
        IBinder iBinder = this.f250989a;
        if (iBinder != null && iBinder.isBinderAlive()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b6, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00da, code lost:
    
        com.tencent.qphone.base.util.QLog.d("GuardManager", 2, "restoreStartHistory", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00d8, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e7 A[Catch: all -> 0x0137, TryCatch #2 {, blocks: (B:38:0x00ad, B:57:0x00b2, B:59:0x00da, B:39:0x00e3, B:41:0x00e7, B:43:0x00eb, B:44:0x0100, B:46:0x0107, B:48:0x010b, B:49:0x0112, B:51:0x0116, B:68:0x00cf, B:71:0x00d4, B:77:0x0122, B:75:0x0136, B:80:0x0127, B:82:0x012d, B:62:0x00be, B:64:0x00c4), top: B:3:0x0003, inners: #0, #1, #3, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010b A[Catch: all -> 0x0137, TryCatch #2 {, blocks: (B:38:0x00ad, B:57:0x00b2, B:59:0x00da, B:39:0x00e3, B:41:0x00e7, B:43:0x00eb, B:44:0x0100, B:46:0x0107, B:48:0x010b, B:49:0x0112, B:51:0x0116, B:68:0x00cf, B:71:0x00d4, B:77:0x0122, B:75:0x0136, B:80:0x0127, B:82:0x012d, B:62:0x00be, B:64:0x00c4), top: B:3:0x0003, inners: #0, #1, #3, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0116 A[Catch: all -> 0x0137, TRY_LEAVE, TryCatch #2 {, blocks: (B:38:0x00ad, B:57:0x00b2, B:59:0x00da, B:39:0x00e3, B:41:0x00e7, B:43:0x00eb, B:44:0x0100, B:46:0x0107, B:48:0x010b, B:49:0x0112, B:51:0x0116, B:68:0x00cf, B:71:0x00d4, B:77:0x0122, B:75:0x0136, B:80:0x0127, B:82:0x012d, B:62:0x00be, B:64:0x00c4), top: B:3:0x0003, inners: #0, #1, #3, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void e() {
        Throwable th5;
        ObjectInputStream objectInputStream;
        long[] jArr;
        long[] jArr2;
        try {
            objectInputStream = new ObjectInputStream(BaseApplication.getContext().openFileInput(f250975m));
        } catch (Throwable th6) {
            th5 = th6;
            objectInputStream = null;
        }
        try {
            int readByte = objectInputStream.readByte();
            if (readByte != 0 && 24 % readByte == 0) {
                long[] jArr3 = new long[readByte];
                long[] jArr4 = new long[readByte];
                for (int i3 = 0; i3 < readByte; i3++) {
                    jArr4[i3] = objectInputStream.readLong();
                    jArr3[i3] = objectInputStream.readLong();
                }
                this.f250992d = new b(jArr4, jArr3);
            }
            f250988z = objectInputStream.readInt();
            f250987y = objectInputStream.readInt();
            long readLong = objectInputStream.readLong();
            if (readLong <= 24) {
                readByte = (int) readLong;
            }
            if (readByte != 0 && 24 % readByte == 0) {
                long[] jArr5 = new long[readByte];
                long[] jArr6 = new long[readByte];
                jArr6[0] = readLong;
                jArr5[0] = objectInputStream.readLong();
                for (int i16 = 1; i16 < readByte; i16++) {
                    jArr6[i16] = objectInputStream.readLong();
                    jArr5[i16] = objectInputStream.readLong();
                }
                this.f250993e = new b(jArr6, jArr5);
            }
            int readInt = objectInputStream.readInt();
            if (readInt != 0 && 24 % readInt == 0) {
                long[] jArr7 = new long[readInt];
                long[] jArr8 = new long[readInt];
                jArr8[0] = readLong;
                jArr7[0] = objectInputStream.readLong();
                for (int i17 = 1; i17 < readInt; i17++) {
                    jArr8[i17] = objectInputStream.readLong();
                    jArr7[i17] = objectInputStream.readLong();
                }
                this.f250994f = new b(jArr8, jArr7);
            }
            try {
                objectInputStream.close();
            } catch (IOException e16) {
                e = e16;
            }
        } catch (Throwable th7) {
            th5 = th7;
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("GuardManager", 2, "storeStartHistory", th5);
                }
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e17) {
                        e = e17;
                    }
                }
                if (this.f250994f == null) {
                }
                if (this.f250992d == null) {
                }
                if (this.f250993e == null) {
                }
            } finally {
            }
        }
        if (this.f250994f == null) {
            b bVar = this.f250992d;
            if (bVar != null) {
                jArr = (long[]) bVar.f250998a.clone();
                jArr2 = (long[]) this.f250992d.f250999b.clone();
            } else {
                jArr = null;
                jArr2 = null;
            }
            this.f250994f = new b(jArr, jArr2);
        }
        if (this.f250992d == null) {
            this.f250992d = new b(null, null);
        }
        if (this.f250993e == null) {
            this.f250993e = new b(null, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005a, code lost:
    
        com.tencent.qphone.base.util.QLog.d("GuardManager", 2, "restoreStartHistory", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void f() {
        Throwable th5;
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(BaseApplication.getContext().openFileOutput(f250975m, 0));
        } catch (Throwable th6) {
            th5 = th6;
            objectOutputStream = null;
        }
        try {
            this.f250992d.a(objectOutputStream, false);
            objectOutputStream.writeInt(f250988z);
            objectOutputStream.writeInt(f250987y);
            this.f250993e.a(objectOutputStream, true);
            this.f250994f.a(objectOutputStream, false);
            try {
                objectOutputStream.close();
            } catch (IOException e16) {
                e = e16;
            }
        } catch (Throwable th7) {
            th5 = th7;
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("GuardManager", 2, "restoreStartHistory", th5);
                }
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e17) {
                        e = e17;
                    }
                }
            } finally {
            }
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.d("GuardManager", 1, "binderDied");
        IBinder iBinder = this.f250989a;
        if (iBinder != null) {
            iBinder.unlinkToDeath(this, 0);
            this.f250989a = null;
            f250982t = System.currentTimeMillis();
            f250983u = 0L;
            this.f250997i = false;
            long j3 = f250982t - this.f250991c;
            if (j3 > 0 && j3 < 86400000) {
                a("GM_AliveTime" + this.f250990b, j3, (String) null);
            }
        }
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.f250997i && c()) {
            return true;
        }
        return false;
    }

    public static void a(a aVar) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("registerGuardEventListener ");
        sb5.append(aVar == null ? "null" : Integer.toHexString(aVar.hashCode()));
        QLog.d("GuardManager", 1, sb5.toString());
        if (aVar != null) {
            A.add(aVar);
        }
    }

    public static boolean b(a aVar) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("unRegisterGuardEventListener ");
        sb5.append(aVar == null ? "null" : Integer.toHexString(aVar.hashCode()));
        QLog.d("GuardManager", 1, sb5.toString());
        if (aVar == null) {
            return false;
        }
        return A.remove(aVar);
    }

    public void a(IInterface iInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iInterface);
            return;
        }
        IBinder asBinder = iInterface != null ? iInterface.asBinder() : null;
        QLog.d("GuardManager", 1, "onAppBind with " + iInterface);
        IBinder iBinder = this.f250989a;
        if (iBinder != asBinder) {
            long currentTimeMillis = System.currentTimeMillis();
            if (iBinder != null) {
                iBinder.unlinkToDeath(this, 0);
                this.f250989a = null;
                f250982t = currentTimeMillis;
                this.f250991c = currentTimeMillis;
            }
            if (asBinder == null || !asBinder.isBinderAlive()) {
                return;
            }
            try {
                asBinder.linkToDeath(this, 0);
                this.f250989a = asBinder;
                f250982t = currentTimeMillis;
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuardManager", 2, "onAppBind ", e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long[] f250998a;

        /* renamed from: b, reason: collision with root package name */
        public long[] f250999b;

        public b(long[] jArr, long[] jArr2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) jArr, (Object) jArr2);
            } else {
                this.f250998a = jArr;
                this.f250999b = jArr2;
            }
        }

        public boolean a(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, j3)).booleanValue();
            }
            long[] jArr = this.f250998a;
            if (jArr != null) {
                int binarySearch = Arrays.binarySearch(jArr, j3);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                    QLog.d("GuardManager", 2, j3 + " is the " + binarySearch + "th of " + Arrays.toString(this.f250998a) + ", range reaches [" + (j3 - o.f250981s) + ", " + (o.f250981s + j3) + "]");
                    if (binarySearch <= 0 || j3 - this.f250998a[binarySearch - 1] > o.f250981s) {
                        long[] jArr2 = this.f250998a;
                        if (binarySearch >= jArr2.length || jArr2[binarySearch] - j3 > o.f250981s) {
                            binarySearch = -1;
                        }
                    } else {
                        binarySearch--;
                    }
                }
                if (binarySearch >= 0) {
                    int length = this.f250998a.length;
                    long j16 = this.f250999b[binarySearch];
                    int i3 = 0;
                    for (int i16 = 0; i16 < length; i16++) {
                        if (this.f250999b[i16] > j16) {
                            i3++;
                        }
                    }
                    QLog.d("GuardManager", 2, "order: " + i3 + ", limit: " + o.f250988z + ", in " + Arrays.toString(this.f250999b));
                    if (i3 < o.f250988z) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void a(ObjectOutputStream objectOutputStream, boolean z16) throws Throwable {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, objectOutputStream, Boolean.valueOf(z16));
                return;
            }
            long[] jArr = this.f250998a;
            int length = jArr != null ? jArr.length : 0;
            if (z16) {
                objectOutputStream.writeLong(length);
            } else {
                objectOutputStream.writeByte(length);
            }
            for (int i3 = 0; i3 < length; i3++) {
                objectOutputStream.writeLong(this.f250998a[i3]);
                objectOutputStream.writeLong(this.f250999b[i3]);
            }
        }

        public void a(long j3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Boolean.valueOf(z16));
                return;
            }
            if (this.f250998a == null) {
                this.f250998a = r3;
                long[] jArr = {j3};
                this.f250999b = new long[1];
            }
            long j16 = z16 ? 2L : 1L;
            int binarySearch = Arrays.binarySearch(this.f250998a, j3);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(j3);
            sb5.append(" is the ");
            sb5.append(binarySearch < 0 ? (-binarySearch) - 1 : binarySearch);
            sb5.append("th of ");
            sb5.append(Arrays.toString(this.f250998a));
            QLog.d("GuardManager", 2, sb5.toString());
            if (binarySearch < 0) {
                int i16 = (-binarySearch) - 1;
                long j17 = i16 > 0 ? j3 - this.f250998a[i16 - 1] : Long.MAX_VALUE;
                long[] jArr2 = this.f250998a;
                long j18 = i16 < jArr2.length ? jArr2[i16] - j3 : Long.MAX_VALUE;
                if (j17 > o.f250981s * 2 && j18 > o.f250981s * 2) {
                    int length = this.f250998a.length;
                    ArrayList arrayList = new ArrayList(length * 2);
                    for (int i17 = 0; i17 < i16; i17++) {
                        arrayList.add(Long.valueOf(this.f250998a[i17]));
                        arrayList.add(Long.valueOf(this.f250999b[i17]));
                    }
                    arrayList.add(Long.valueOf(j3));
                    arrayList.add(Long.valueOf(j16));
                    while (i16 < length) {
                        arrayList.add(Long.valueOf(this.f250998a[i16]));
                        arrayList.add(Long.valueOf(this.f250999b[i16]));
                        i16++;
                    }
                    if (arrayList.size() > 56) {
                        long longValue = ((Long) arrayList.get(0)).longValue();
                        long longValue2 = ((Long) arrayList.get(1)).longValue();
                        int size = arrayList.size() / 2;
                        int i18 = 0;
                        for (int i19 = 1; i19 < size; i19++) {
                            int i26 = i19 * 2;
                            long longValue3 = ((Long) arrayList.get(i26)).longValue();
                            long longValue4 = ((Long) arrayList.get(i26 + 1)).longValue();
                            if (longValue3 - longValue < o.f250981s * 3) {
                                long j19 = (longValue * longValue2) + (longValue3 * longValue4);
                                longValue2 += longValue4;
                                longValue = j19 / longValue2;
                            } else {
                                int i27 = i18 * 2;
                                arrayList.set(i27, Long.valueOf(longValue));
                                arrayList.set(i27 + 1, Long.valueOf(longValue2));
                                i18++;
                                longValue = longValue3;
                                longValue2 = longValue4;
                            }
                        }
                        int i28 = i18 * 2;
                        arrayList.set(i28, Long.valueOf(longValue));
                        arrayList.set(i28 + 1, Long.valueOf(longValue2));
                        int i29 = i18 + 1;
                        this.f250998a = new long[i29];
                        this.f250999b = new long[i29];
                        while (i3 < i29) {
                            int i36 = i3 * 2;
                            this.f250998a[i3] = ((Long) arrayList.get(i36)).longValue();
                            this.f250999b[i3] = ((Long) arrayList.get(i36 + 1)).longValue();
                            i3++;
                        }
                    } else {
                        int size2 = arrayList.size() / 2;
                        this.f250998a = new long[size2];
                        this.f250999b = new long[size2];
                        while (i3 < size2) {
                            int i37 = i3 * 2;
                            this.f250998a[i3] = ((Long) arrayList.get(i37)).longValue();
                            this.f250999b[i3] = ((Long) arrayList.get(i37 + 1)).longValue();
                            i3++;
                        }
                    }
                } else {
                    if (j17 < j18) {
                        i16--;
                    }
                    long[] jArr3 = this.f250998a;
                    long j26 = jArr3[i16];
                    long[] jArr4 = this.f250999b;
                    jArr3[i16] = (j26 * jArr4[i16]) + (j3 * j16);
                    long j27 = jArr4[i16] + j16;
                    jArr4[i16] = j27;
                    jArr3[i16] = jArr3[i16] / j27;
                }
            } else {
                long[] jArr5 = this.f250998a;
                long j28 = jArr5[binarySearch];
                long[] jArr6 = this.f250999b;
                jArr5[binarySearch] = (j28 * jArr6[binarySearch]) + (j3 * j16);
                long j29 = jArr6[binarySearch] + j16;
                jArr6[binarySearch] = j29;
                jArr5[binarySearch] = jArr5[binarySearch] / j29;
            }
            QLog.d("GuardManager", 2, Arrays.toString(this.f250998a));
        }
    }

    public void a(int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        QLog.d("GuardManager", 1, "onEvent:" + i3 + ", " + j3 + ", " + j16);
        long currentTimeMillis = System.currentTimeMillis();
        this.f250991c = currentTimeMillis;
        this.f250997i = true;
        if (i3 != 100) {
            switch (i3) {
                case 1:
                    this.f250990b = 2;
                    Iterator<a> it = A.iterator();
                    while (it.hasNext()) {
                        a next = it.next();
                        if (next != null) {
                            next.b();
                        }
                    }
                    return;
                case 2:
                    this.f250990b = 3;
                    f250981s = j3;
                    return;
                case 3:
                    this.f250990b = 4;
                    return;
                case 4:
                    this.f250990b = 5;
                    f250981s = j3;
                    return;
                case 5:
                    a(currentTimeMillis, (int) (j3 >> 8), (int) (j3 & 255), (j16 & 255) == 1, (int) (j16 >> 8));
                    return;
                case 6:
                    MsfService.getCore().pushManager.d();
                    MsfService.getCore().pushManager.e();
                    Iterator<a> it5 = A.iterator();
                    while (it5.hasNext()) {
                        a next2 = it5.next();
                        if (next2 != null) {
                            next2.a();
                        }
                    }
                    return;
                case 7:
                    a(currentTimeMillis, 0L, 0);
                    Iterator<a> it6 = A.iterator();
                    while (it6.hasNext()) {
                        a next3 = it6.next();
                        if (next3 != null) {
                            next3.c();
                        }
                    }
                    return;
                default:
                    return;
            }
        }
        f250982t = currentTimeMillis;
        f250983u = 0L;
        this.f250990b = 1;
        this.f250997i = false;
        j.f();
    }

    private void a(long j3, int i3, int i16, boolean z16, int i17) {
        if (i17 != 0) {
            f250987y = i17 == 2 ? 2 : 1;
        } else if (f250987y == 0) {
            f250987y = new Random().nextInt(2) == 0 ? 2 : 1;
        }
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(j3 - 15000);
        int i18 = calendar.get(7);
        long j16 = (calendar.get(11) * 60 * 60 * 1000) + (j3 % 3600000);
        a("GM_StartTime", j16, f250987y == 2 ? z16 ? "11" : "10" : z16 ? HiAnalyticsConstant.KeyAndValue.NUMBER_01 : "00");
        f250988z = i16;
        a(0L, j16, i18);
    }

    private void a(long j3, long j16, int i3) {
        if (j3 != 0) {
            Calendar calendar = Calendar.getInstance(Locale.getDefault());
            calendar.setTimeInMillis(j3 - 15000);
            i3 = calendar.get(7);
            j16 = (calendar.get(11) * 60 * 60 * 1000) + (j3 % 3600000);
        }
        if (this.f250994f == null) {
            e();
        }
        this.f250994f.a(j16, j3 == 0);
        if (i3 != 1 && i3 != 7) {
            this.f250992d.a(j16, j3 == 0);
        } else {
            this.f250993e.a(j16, j3 == 0);
        }
        f();
    }

    public boolean a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        if (this.f250996h) {
            return true;
        }
        this.f250996h = true;
        long currentTimeMillis = System.currentTimeMillis();
        long abs = Math.abs(currentTimeMillis - f250983u);
        if ((i3 == 3 && abs > 90000) || ((i3 == 1 && abs > f250981s) || (i3 == 0 && abs > 500))) {
            QLog.d("GuardManager", 1, "prestart " + i3 + ", " + currentTimeMillis + ", " + f250982t + ", " + f250981s + ", " + this.f250997i + ", " + c() + ", " + f250983u);
            Intent intent = new Intent(BaseApplicationImpl.bootBroadcastName);
            intent.putExtra(CoreService.KEY_START_MODE, i3);
            intent.setPackage(BaseApplication.getContext().getPackageName());
            BaseApplication.getContext().sendBroadcast(intent);
            f250982t = currentTimeMillis;
            f250983u = currentTimeMillis;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            sb5.append(i3);
            a("GM_LiteStart", 0L, sb5.toString());
        }
        return true;
    }

    private void a(String str, long j3, String str2) {
        HashMap hashMap;
        if (str2 != null) {
            hashMap = new HashMap();
            hashMap.put("Tag", str2);
        } else {
            hashMap = null;
        }
        HashMap hashMap2 = hashMap;
        if (this.f250995g.getStatReporter() != null) {
            this.f250995g.getStatReporter().a(str, true, j3, 0L, (Map<String, String>) hashMap2, false, false);
        }
    }
}
