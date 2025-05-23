package com.tencent.luggage.wxa.t9;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public RandomAccessFile f141064a;

    /* renamed from: b, reason: collision with root package name */
    public RandomAccessFile f141065b;

    /* renamed from: c, reason: collision with root package name */
    public a f141066c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f141067d;

    /* renamed from: e, reason: collision with root package name */
    public long f141068e = 0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f141069a;

        /* renamed from: b, reason: collision with root package name */
        public long f141070b;

        /* renamed from: c, reason: collision with root package name */
        public long f141071c;

        /* renamed from: d, reason: collision with root package name */
        public long f141072d;

        /* renamed from: e, reason: collision with root package name */
        public long f141073e;

        /* renamed from: f, reason: collision with root package name */
        public int f141074f;

        public a() {
            this.f141069a = 0;
            this.f141070b = 0L;
            this.f141071c = 0L;
            this.f141072d = 0L;
            this.f141073e = 0L;
            this.f141074f = 0;
        }

        public final int a() {
            return this.f141074f;
        }

        public final int b() {
            return this.f141069a;
        }

        public void a(String[] strArr, String str) {
            String[] split;
            String str2;
            long j3;
            int i3;
            String[] strArr2 = strArr;
            if (this.f141072d <= 0) {
                a(strArr);
                return;
            }
            if (str == null || str.length() <= 0 || (split = str.split("[ ]+")) == null || split.length <= 0 || (str2 = split[0]) == null || Long.parseLong(str2, 10) != this.f141072d) {
                com.tencent.luggage.wxa.tn.w.b(" MicroMsg.CpuUsage", "update but pid not match[%d, %s] update nothing", Long.valueOf(this.f141072d), str);
                return;
            }
            long parseLong = Long.parseLong(split[13], 10);
            long parseLong2 = Long.parseLong(split[14], 10);
            long parseLong3 = Long.parseLong(split[15], 10);
            long parseLong4 = Long.parseLong(split[16], 10);
            long j16 = parseLong + parseLong2 + parseLong3 + parseLong4;
            long parseLong5 = Long.parseLong(strArr2[4], 10);
            int length = strArr2.length;
            int i16 = 0;
            boolean z16 = true;
            long j17 = 0;
            while (i16 < length) {
                String str3 = strArr2[i16];
                if (z16) {
                    j3 = parseLong3;
                    z16 = false;
                    i3 = length;
                } else {
                    j3 = parseLong3;
                    i3 = length;
                    j17 += Long.parseLong(str3, 10);
                }
                i16++;
                strArr2 = strArr;
                length = i3;
                parseLong3 = j3;
            }
            long j18 = j17;
            long j19 = parseLong5 - this.f141071c;
            long j26 = j18 - this.f141070b;
            long j27 = j16 - this.f141073e;
            float f16 = (float) j26;
            this.f141069a = (int) ((((float) (j26 - j19)) / f16) * 100.0f);
            this.f141074f = (int) ((((float) j27) / f16) * 100.0f);
            this.f141070b = j18;
            this.f141071c = parseLong5;
            this.f141073e = j16;
            com.tencent.luggage.wxa.tn.w.d(" MicroMsg.CpuUsage", "CpuUsageInfo(%d) CPU total=%d idle=%d usage=%d pid=%d pidTotal=%d mPidUsage=%d [%d, %d, %d, %d], [%d, %d, %d]", Integer.valueOf(hashCode()), Long.valueOf(j18), Long.valueOf(parseLong5), Integer.valueOf(this.f141069a), Long.valueOf(this.f141072d), Long.valueOf(j16), Integer.valueOf(this.f141074f), Long.valueOf(parseLong), Long.valueOf(parseLong2), Long.valueOf(parseLong3), Long.valueOf(parseLong4), Long.valueOf(j26), Long.valueOf(j19), Long.valueOf(j27));
        }

        public a(long j3) {
            this.f141072d = j3;
        }

        public void a(String[] strArr) {
            long parseLong = Long.parseLong(strArr[4], 10);
            long j3 = 0;
            boolean z16 = true;
            for (String str : strArr) {
                if (z16) {
                    z16 = false;
                } else {
                    j3 += Long.parseLong(str, 10);
                }
            }
            long j16 = parseLong - this.f141071c;
            long j17 = j3 - this.f141070b;
            this.f141069a = (int) ((((float) (j17 - j16)) / ((float) j17)) * 100.0f);
            this.f141070b = j3;
            this.f141071c = parseLong;
            com.tencent.luggage.wxa.tn.w.d(" MicroMsg.CpuUsage", "CpuUsageInfo(" + hashCode() + ") CPU total=" + j3 + "; idle=" + parseLong + "; usage=" + this.f141069a);
        }
    }

    public void a() {
        RandomAccessFile randomAccessFile = this.f141064a;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        RandomAccessFile randomAccessFile2 = this.f141065b;
        if (randomAccessFile2 != null) {
            randomAccessFile2.close();
        }
    }

    public final void b() {
        this.f141064a = new RandomAccessFile("/proc/stat", "r");
        if (this.f141068e > 0) {
            this.f141065b = new RandomAccessFile("/proc/" + this.f141068e + "/stat", "r");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c() {
        String readLine;
        RandomAccessFile randomAccessFile;
        String readLine2;
        RandomAccessFile randomAccessFile2 = this.f141065b;
        if (randomAccessFile2 != null) {
            try {
                randomAccessFile2.seek(0L);
                readLine = this.f141065b.readLine();
            } catch (IOException e16) {
                com.tencent.luggage.wxa.tn.w.b(" MicroMsg.CpuUsage", "Ops pidStatFile: " + e16);
            }
            randomAccessFile = this.f141064a;
            if (randomAccessFile == null) {
                try {
                    randomAccessFile.seek(0L);
                    int i3 = -1;
                    do {
                        readLine2 = this.f141064a.readLine();
                        a(i3, readLine2, readLine);
                        i3++;
                    } while (readLine2 != null);
                    return;
                } catch (IOException e17) {
                    com.tencent.luggage.wxa.tn.w.b(" MicroMsg.CpuUsage", "Ops statFile: " + e17);
                    return;
                }
            }
            return;
        }
        readLine = null;
        randomAccessFile = this.f141064a;
        if (randomAccessFile == null) {
        }
    }

    public void d() {
        try {
            b();
            c();
            a();
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a(" MicroMsg.CpuUsage", e16, "update e:", new Object[0]);
            RandomAccessFile randomAccessFile = this.f141064a;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception unused) {
                }
                this.f141064a = null;
            }
            RandomAccessFile randomAccessFile2 = this.f141065b;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (Exception unused2) {
                }
                this.f141065b = null;
            }
        }
    }

    public String toString() {
        d();
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f141066c != null) {
            stringBuffer.append("Cpu Total : ");
            stringBuffer.append(this.f141066c.b());
            stringBuffer.append("%");
            if (this.f141068e > 0) {
                stringBuffer.append("pid(");
                stringBuffer.append(this.f141068e + ") :");
                stringBuffer.append(this.f141066c.a());
                stringBuffer.append("%");
            }
        }
        if (this.f141067d != null) {
            for (int i3 = 0; i3 < this.f141067d.size(); i3++) {
                a aVar = (a) this.f141067d.get(i3);
                stringBuffer.append(" Cpu Core(" + i3 + ") : ");
                stringBuffer.append(aVar.b());
                stringBuffer.append("%");
                aVar.b();
            }
        }
        return stringBuffer.toString();
    }

    public final void a(int i3, String str, String str2) {
        if (str == null || str.length() <= 0) {
            com.tencent.luggage.wxa.tn.w.b(" MicroMsg.CpuUsage", "unable to get cpu line cpuId[%d]", Integer.valueOf(i3));
            return;
        }
        String[] split = str.split("[ ]+");
        if (split[0].indexOf("cpu") != -1) {
            a(i3, split, str2);
        }
    }

    public final void a(int i3, String[] strArr, String str) {
        if (i3 == -1) {
            if (this.f141066c == null) {
                this.f141066c = new a(this.f141068e);
            }
            this.f141066c.a(strArr, str);
            return;
        }
        if (this.f141067d == null) {
            this.f141067d = new ArrayList();
        }
        if (i3 < this.f141067d.size()) {
            ((a) this.f141067d.get(i3)).a(strArr);
            return;
        }
        a aVar = new a();
        aVar.a(strArr);
        this.f141067d.add(aVar);
    }
}
