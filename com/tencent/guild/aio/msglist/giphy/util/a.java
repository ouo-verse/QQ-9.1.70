package com.tencent.guild.aio.msglist.giphy.util;

import com.tencent.rfix.loader.utils.RFixConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static a f111300e = new a(RFixConstants.MD5_FILE_BUF_LENGTH);

    /* renamed from: f, reason: collision with root package name */
    protected static final Comparator<byte[]> f111301f = new C1195a();

    /* renamed from: a, reason: collision with root package name */
    private List<byte[]> f111302a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    private List<byte[]> f111303b = new ArrayList(64);

    /* renamed from: c, reason: collision with root package name */
    private int f111304c = 0;

    /* renamed from: d, reason: collision with root package name */
    private final int f111305d;

    /* compiled from: P */
    /* renamed from: com.tencent.guild.aio.msglist.giphy.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C1195a implements Comparator<byte[]> {
        C1195a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public a(int i3) {
        this.f111305d = i3;
    }

    public static a b() {
        return f111300e;
    }

    private synchronized void d() {
        while (this.f111304c > this.f111305d) {
            byte[] remove = this.f111302a.remove(0);
            this.f111303b.remove(remove);
            this.f111304c -= remove.length;
        }
    }

    public synchronized byte[] a(int i3) {
        for (int i16 = 0; i16 < this.f111303b.size(); i16++) {
            byte[] bArr = this.f111303b.get(i16);
            if (bArr.length >= i3) {
                this.f111304c -= bArr.length;
                this.f111303b.remove(i16);
                this.f111302a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i3];
    }

    public synchronized void c(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f111305d) {
                this.f111302a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f111303b, bArr, f111301f);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f111303b.add(binarySearch, bArr);
                this.f111304c += bArr.length;
                d();
            }
        }
    }
}
