package com.google.protobuf;

import com.tencent.thumbplayer.api.common.TPErrorType;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ad {

    /* renamed from: a, reason: collision with root package name */
    static final Charset f35640a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    static final Charset f35641b = Charset.forName("ISO-8859-1");

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f35642c;

    /* renamed from: d, reason: collision with root package name */
    public static final ByteBuffer f35643d;

    /* renamed from: e, reason: collision with root package name */
    public static final k f35644e;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a extends j<Boolean> {
        @Override // com.google.protobuf.ad.j, com.google.protobuf.ad.f
        j<Boolean> b(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface b extends j<Double> {
        @Override // com.google.protobuf.ad.j, com.google.protobuf.ad.f
        j<Double> b(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface c {
        int getNumber();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface d<T extends c> {
        T findValueByNumber(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface e {
        boolean isInRange(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface f extends j<Float> {
        @Override // 
        j<Float> b(int i3);

        float getFloat(int i3);

        void j(float f16);

        float l(int i3, float f16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface g extends j<Integer> {
        @Override // com.google.protobuf.ad.j, com.google.protobuf.ad.f
        j<Integer> b(int i3);

        void e(int i3);

        int getInt(int i3);

        int k(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class h<F, T> extends AbstractList<T> {

        /* renamed from: d, reason: collision with root package name */
        private final List<F> f35645d;

        /* renamed from: e, reason: collision with root package name */
        private final a<F, T> f35646e;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public interface a<F, T> {
            T convert(F f16);
        }

        public h(List<F> list, a<F, T> aVar) {
            this.f35645d = list;
            this.f35646e = aVar;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i3) {
            return (T) this.f35646e.convert(this.f35645d.get(i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f35645d.size();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface i extends j<Long> {
        @Override // com.google.protobuf.ad.j, com.google.protobuf.ad.f
        j<Long> b(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface j<E> extends List<E>, RandomAccess {
        j<E> b(int i3);

        void y();

        boolean z();
    }

    static {
        byte[] bArr = new byte[0];
        f35642c = bArr;
        f35643d = ByteBuffer.wrap(bArr);
        f35644e = k.k(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t16) {
        t16.getClass();
        return t16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T b(T t16, String str) {
        if (t16 != null) {
            return t16;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z16) {
        if (z16) {
            return TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_SUBTITLE_STREAM;
        }
        return 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    static int e(byte[] bArr, int i3, int i16) {
        int k3 = k(i16, bArr, i3, i16);
        if (k3 == 0) {
            return 1;
        }
        return k3;
    }

    public static int f(c cVar) {
        return cVar.getNumber();
    }

    public static int g(List<? extends c> list) {
        Iterator<? extends c> it = list.iterator();
        int i3 = 1;
        while (it.hasNext()) {
            i3 = (i3 * 31) + f(it.next());
        }
        return i3;
    }

    public static int h(long j3) {
        return (int) (j3 ^ (j3 >>> 32));
    }

    public static boolean i(byte[] bArr) {
        return Utf8.s(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object j(Object obj, Object obj2) {
        return ((au) obj).toBuilder().mergeFrom((au) obj2).buildPartial();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(int i3, byte[] bArr, int i16, int i17) {
        for (int i18 = i16; i18 < i16 + i17; i18++) {
            i3 = (i3 * 31) + bArr[i18];
        }
        return i3;
    }

    public static String l(byte[] bArr) {
        return new String(bArr, f35640a);
    }
}
