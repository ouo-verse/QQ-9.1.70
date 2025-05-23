package com.tencent.mobileqq.kandian.base.image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    protected static final Comparator<byte[]> f238966d = new C7955a();

    /* renamed from: a, reason: collision with root package name */
    private List<byte[]> f238967a = new ArrayList(64);

    /* renamed from: b, reason: collision with root package name */
    private int f238968b = 0;

    /* renamed from: c, reason: collision with root package name */
    private final int f238969c;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.kandian.base.image.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C7955a implements Comparator<byte[]> {
        C7955a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public a(int i3) {
        this.f238969c = i3;
    }

    private synchronized void d() {
        while (this.f238968b > this.f238969c) {
            byte[] bArr = this.f238967a.get(0);
            this.f238967a.remove(bArr);
            this.f238968b -= bArr.length;
        }
    }

    public synchronized void a() {
        this.f238967a.clear();
    }

    public synchronized byte[] b(int i3) {
        for (int i16 = 0; i16 < this.f238967a.size(); i16++) {
            byte[] bArr = this.f238967a.get(i16);
            if (bArr.length >= i3) {
                this.f238968b -= bArr.length;
                this.f238967a.remove(i16);
                return bArr;
            }
        }
        return new byte[i3];
    }

    public synchronized void c(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f238969c) {
                int binarySearch = Collections.binarySearch(this.f238967a, bArr, f238966d);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f238967a.add(binarySearch, bArr);
                this.f238968b += bArr.length;
                d();
            }
        }
    }
}
