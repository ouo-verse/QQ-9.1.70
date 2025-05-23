package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    protected static final Comparator<byte[]> f31396e = new a();

    /* renamed from: a, reason: collision with root package name */
    private final List<byte[]> f31397a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<byte[]> f31398b = new ArrayList(64);

    /* renamed from: c, reason: collision with root package name */
    private int f31399c = 0;

    /* renamed from: d, reason: collision with root package name */
    private final int f31400d;

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements Comparator<byte[]> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public c(int i3) {
        this.f31400d = i3;
    }

    private synchronized void c() {
        while (this.f31399c > this.f31400d) {
            byte[] remove = this.f31397a.remove(0);
            this.f31398b.remove(remove);
            this.f31399c -= remove.length;
        }
    }

    public synchronized byte[] a(int i3) {
        for (int i16 = 0; i16 < this.f31398b.size(); i16++) {
            byte[] bArr = this.f31398b.get(i16);
            if (bArr.length >= i3) {
                this.f31399c -= bArr.length;
                this.f31398b.remove(i16);
                this.f31397a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i3];
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f31400d) {
                this.f31397a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f31398b, bArr, f31396e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f31398b.add(binarySearch, bArr);
                this.f31399c += bArr.length;
                c();
            }
        }
    }
}
