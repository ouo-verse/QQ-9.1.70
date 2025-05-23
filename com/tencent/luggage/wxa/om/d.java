package com.tencent.luggage.wxa.om;

import android.text.TextUtils;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.luggage.wxa.tn.w;
import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public BitSet f137023a = new BitSet();

    /* renamed from: b, reason: collision with root package name */
    public long f137024b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f137025c = 0;

    /* renamed from: d, reason: collision with root package name */
    public String f137026d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f137027e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {
        public static byte[] a(BitSet bitSet) {
            byte[] bArr = new byte[bitSet.size() / 8];
            for (int i3 = 0; i3 < bitSet.size(); i3++) {
                int i16 = i3 / 8;
                bArr[i16] = (byte) (((bitSet.get(i3) ? 1 : 0) << (7 - (i3 % 8))) | bArr[i16]);
            }
            return bArr;
        }
    }

    public d(String str) {
        this.f137027e = str;
    }

    public void a() {
        w.d("MicroMsg.Music.IndexBitMgr", HippyReporter.RemoveEngineReason.CLEAR_CACHE);
        this.f137023a = new BitSet(this.f137025c);
        f(0);
        if (TextUtils.isEmpty(this.f137026d)) {
            return;
        }
        e.a(this.f137026d, (byte[]) null);
    }

    public void b() {
        w.d("MicroMsg.Music.IndexBitMgr", "initData");
        long j3 = this.f137024b;
        if (j3 <= 0) {
            w.b("MicroMsg.Music.IndexBitMgr", "fileLength is invalid!");
            return;
        }
        if (j3 % 8192 != 0 && j3 >= 8192) {
            this.f137025c = ((int) (j3 / 8192)) + 1;
        } else {
            this.f137025c = (int) (j3 / 8192);
        }
        if (j3 <= 8192) {
            w.d("MicroMsg.Music.IndexBitMgr", "fileLength < PIECE_SIZE, count should be 1");
            this.f137025c = 1;
        }
        w.d("MicroMsg.Music.IndexBitMgr", "fileLength:%d, count:%d", Long.valueOf(this.f137024b), Integer.valueOf(this.f137025c));
        this.f137023a = new BitSet(this.f137025c);
        String e16 = g.e(this.f137027e);
        this.f137026d = e16;
        if (TextUtils.isEmpty(e16)) {
            w.b("MicroMsg.Music.IndexBitMgr", "initData musicId is null!'");
            return;
        }
        w.d("MicroMsg.Music.IndexBitMgr", "musicId:%s", this.f137026d);
        e.d(this.f137026d);
        w.b("MicroMsg.Music.IndexBitMgr", "initData pMusic is null!'");
    }

    public int c(int i3) {
        return (i3 + 1) * 8192;
    }

    public int d(int i3) {
        return i3 * 8192;
    }

    public void e(int i3) {
        this.f137023a.set(i3);
    }

    public void f(int i3) {
        w.d("MicroMsg.Music.IndexBitMgr", "setFileCacheComplete %d", Integer.valueOf(i3));
        if (!TextUtils.isEmpty(this.f137026d)) {
            e.a(this.f137026d, i3);
        }
    }

    public boolean c() {
        w.d("MicroMsg.Music.IndexBitMgr", "isCacheComplete, count:%d, cardinality:%d", Integer.valueOf(this.f137025c), Integer.valueOf(this.f137023a.cardinality()));
        int i3 = this.f137025c;
        return i3 > 0 && i3 == this.f137023a.cardinality();
    }

    public void d() {
        if (!TextUtils.isEmpty(this.f137026d)) {
            e.a(this.f137026d, a.a(this.f137023a));
        }
        w.a("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet:%s", this.f137023a.toString());
        w.d("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet count %d, cardinality:" + this.f137025c + "," + this.f137023a.cardinality());
        if (c()) {
            f(1);
        }
    }

    public void a(long j3) {
        this.f137024b = j3;
    }

    public boolean a(int i3) {
        return this.f137023a.get(i3);
    }

    public boolean a(int i3, int i16) {
        if (i3 >= 0 && i16 >= 0) {
            long j3 = i3;
            long j16 = this.f137024b;
            if (j3 <= j16) {
                int i17 = i3 + i16;
                if (i17 <= j16) {
                    int b16 = b(i3);
                    int b17 = b(i17);
                    for (int i18 = b16; i18 <= b17; i18++) {
                        if (!a(b16)) {
                            w.a("MicroMsg.Music.IndexBitMgr", "index %d, indexBit 0", Integer.valueOf(i18));
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        w.b("MicroMsg.Music.IndexBitMgr", "canReadFromCache offset %d, size %d, fileLength %d", Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(this.f137024b));
        w.b("MicroMsg.Music.IndexBitMgr", "canReadFromCache invalid parameter!");
        return false;
    }

    public int b(int i3) {
        if (i3 <= this.f137024b) {
            return i3 / 8192;
        }
        w.b("MicroMsg.Music.IndexBitMgr", "getIndex, offset is invalid, offset:%d, fileLength:%d", Integer.valueOf(i3), Long.valueOf(this.f137024b));
        return 0;
    }

    public int[] b(int i3, int i16) {
        if (i3 >= 0 && i16 >= 0) {
            long j3 = i3;
            long j16 = this.f137024b;
            if (j3 <= j16) {
                int i17 = i3 + i16;
                long j17 = i17;
                if (j17 <= j16) {
                    int[] iArr = {-1, -1};
                    int b16 = b(i3);
                    int b17 = b(i17);
                    for (int i18 = b16; i18 <= b17; i18++) {
                        int d16 = d(i18);
                        int c16 = c(i18);
                        if (d16 >= i3 && c16 <= i17) {
                            if (iArr[0] == -1) {
                                iArr[0] = i18;
                            }
                            if (iArr[0] > i18) {
                                iArr[0] = i18;
                            }
                            if (iArr[1] == -1) {
                                iArr[1] = i18;
                            }
                            if (iArr[1] < i18) {
                                iArr[1] = i18;
                            }
                        }
                    }
                    if (j17 == this.f137024b && ((b17 == 0 && i3 == 0) || (b17 > 0 && i3 <= b17 * 8192))) {
                        w.d("MicroMsg.Music.IndexBitMgr", "write to file end!");
                        iArr[0] = b16;
                        iArr[1] = b17;
                    }
                    return iArr;
                }
            }
        }
        w.d("MicroMsg.Music.IndexBitMgr", "getWriteBuffIndexRange offset %d, size %d, fileLength %d", Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(this.f137024b));
        w.b("MicroMsg.Music.IndexBitMgr", "getWriteBuffRange invalid parameter!");
        return null;
    }
}
