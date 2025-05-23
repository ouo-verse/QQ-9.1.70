package c.t.m.g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class j0 {

    /* renamed from: e, reason: collision with root package name */
    public static j0 f29780e = new j0();

    /* renamed from: f, reason: collision with root package name */
    public static final Comparator<byte[]> f29781f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final List<byte[]> f29782a = new ArrayList(32);

    /* renamed from: b, reason: collision with root package name */
    public final List<byte[]> f29783b = new ArrayList(32);

    /* renamed from: c, reason: collision with root package name */
    public int f29784c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f29785d = 10240;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements Comparator<byte[]> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public static j0 a() {
        return f29780e;
    }

    public final synchronized void b() {
        while (this.f29784c > this.f29785d) {
            byte[] remove = this.f29782a.remove(0);
            this.f29783b.remove(remove);
            this.f29784c -= remove.length;
        }
    }

    public synchronized byte[] a(int i3) {
        for (int i16 = 0; i16 < this.f29783b.size(); i16++) {
            byte[] bArr = this.f29783b.get(i16);
            if (bArr.length == i3) {
                this.f29784c -= bArr.length;
                this.f29783b.remove(i16);
                this.f29782a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i3];
    }

    public synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f29785d) {
                Arrays.fill(bArr, (byte) 0);
                this.f29782a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f29783b, bArr, f29781f);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f29783b.add(binarySearch, bArr);
                this.f29784c += bArr.length;
                b();
            }
        }
    }
}
