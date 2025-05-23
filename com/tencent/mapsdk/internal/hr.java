package com.tencent.mapsdk.internal;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class hr {

    /* renamed from: a, reason: collision with root package name */
    private static final int f148729a = 4096;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a<T> {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class b<T> implements i<Boolean, T> {
        private Boolean c() {
            return Boolean.valueOf(a());
        }

        public abstract boolean a();

        @Override // com.tencent.mapsdk.internal.hr.i
        public final /* synthetic */ Boolean b() {
            return Boolean.valueOf(a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    interface c<I, O> {
        O a();

        boolean b(I i3);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class e<I, O> extends g<I, O> {

        /* renamed from: a, reason: collision with root package name */
        O f148733a;

        public e() {
        }

        @Override // com.tencent.mapsdk.internal.hr.c
        public final O a() {
            return this.f148733a;
        }

        public abstract O a(O o16, I i3);

        @Override // com.tencent.mapsdk.internal.hr.g, com.tencent.mapsdk.internal.hr.c
        public final boolean b(I i3) {
            super.b(i3);
            this.f148733a = a(this.f148733a, i3);
            return true;
        }

        public e(O o16) {
            this.f148733a = o16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface f<T> {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class g<I, O> implements c<I, O> {

        /* renamed from: c, reason: collision with root package name */
        int f148734c;

        @Override // com.tencent.mapsdk.internal.hr.c
        public boolean b(I i3) {
            this.f148734c++;
            return true;
        }

        private int b() {
            return this.f148734c - 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface i<R, C> {
        R b();
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (inputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr, 0, 4096);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a((Closeable) byteArrayOutputStream);
                    return byteArray;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream2 = byteArrayOutputStream;
            a((Closeable) byteArrayOutputStream2);
            throw th;
        }
    }

    private static <I> void c(Iterable<I> iterable, d<I> dVar) {
        Iterator<I> it = iterable.iterator();
        while (it.hasNext()) {
            dVar.b(it.next());
        }
    }

    private static <I> List<I> d(Iterable<I> iterable, d<I> dVar) {
        Iterator<I> it = iterable.iterator();
        while (it.hasNext()) {
            dVar.b(it.next());
        }
        return dVar.f148732b;
    }

    private static <I> I e(Iterable<I> iterable, d<I> dVar) {
        for (I i3 : iterable) {
            if (dVar.b(i3)) {
                return i3;
            }
        }
        return null;
    }

    private static <I> List<I> f(Iterable<I> iterable, d<I> dVar) {
        Iterator<I> it = iterable.iterator();
        while (it.hasNext()) {
            dVar.b(it.next());
        }
        return dVar.f148732b;
    }

    private static byte[] a(InputStream inputStream, int i3) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[i3];
            do {
                int read = inputStream.read(bArr, 0, i3);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } while (byteArrayOutputStream.size() < i3);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th6) {
            th = th6;
            try {
                th.printStackTrace();
                return null;
            } finally {
                a((Closeable) byteArrayOutputStream);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class d<I> extends g<I, List<I>> {

        /* renamed from: b, reason: collision with root package name */
        final List<I> f148732b = new ArrayList();

        @Override // com.tencent.mapsdk.internal.hr.c
        public final /* bridge */ /* synthetic */ Object a() {
            return this.f148732b;
        }

        public abstract boolean a(I i3);

        @Override // com.tencent.mapsdk.internal.hr.g, com.tencent.mapsdk.internal.hr.c
        public final boolean b(I i3) {
            super.b(i3);
            if (!a(i3)) {
                return false;
            }
            this.f148732b.add(i3);
            return true;
        }

        private List<I> b() {
            return this.f148732b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class h<I, O> extends g<I, List<O>> {

        /* renamed from: a, reason: collision with root package name */
        final List<O> f148735a = new ArrayList();

        @Override // com.tencent.mapsdk.internal.hr.c
        public final /* bridge */ /* synthetic */ Object a() {
            return this.f148735a;
        }

        public abstract O a(I i3);

        @Override // com.tencent.mapsdk.internal.hr.g, com.tencent.mapsdk.internal.hr.c
        public final boolean b(I i3) {
            super.b(i3);
            O a16 = a(i3);
            if (a16 == null) {
                return true;
            }
            this.f148735a.add(a16);
            return true;
        }

        private List<O> b() {
            return this.f148735a;
        }
    }

    private static <I> int b(Iterable<I> iterable, d<I> dVar) {
        Iterator<I> it = iterable.iterator();
        while (it.hasNext()) {
            if (dVar.b(it.next())) {
                return dVar.f148734c - 1;
            }
        }
        return -1;
    }

    private static <I> int b(Iterable<I> iterable, final I i3) {
        d<I> dVar = new d<I>() { // from class: com.tencent.mapsdk.internal.hr.4
            @Override // com.tencent.mapsdk.internal.hr.d
            public final boolean a(I i16) {
                if (i3 == i16) {
                    return true;
                }
                return false;
            }
        };
        Iterator<I> it = iterable.iterator();
        while (it.hasNext()) {
            if (dVar.b(it.next())) {
                return dVar.f148734c - 1;
            }
        }
        return -1;
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr, 0, 4096);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Throwable th6) {
            th = th6;
            try {
                th.printStackTrace();
                return null;
            } finally {
                a((Closeable) byteArrayOutputStream);
            }
        }
    }

    private static byte[] a(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        if (obj == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(obj);
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        th.printStackTrace();
                        return null;
                    } finally {
                        a((Closeable) objectOutputStream);
                        a((Closeable) byteArrayOutputStream);
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                objectOutputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
            byteArrayOutputStream = null;
            objectOutputStream = null;
        }
    }

    private static long a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null && outputStream != null) {
            try {
                byte[] bArr = new byte[4096];
                long j3 = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        return j3;
                    }
                    outputStream.write(bArr, 0, read);
                    j3 += read;
                }
            } catch (IOException unused) {
            }
        }
        return -1L;
    }

    private static long a(byte[] bArr, OutputStream outputStream) {
        if (bArr != null && outputStream != null) {
            try {
                outputStream.write(bArr, 0, bArr.length);
                return bArr.length;
            } catch (IOException unused) {
            }
        }
        return -1L;
    }

    private static <I> List<I> a(I[] iArr) {
        ArrayList arrayList = new ArrayList();
        if (iArr.getClass().isArray()) {
            for (int i3 = 0; i3 < Array.getLength(iArr); i3++) {
                arrayList.add(Array.get(iArr, i3));
            }
        }
        return arrayList;
    }

    private static <T> T[] a(T[] tArr, int i3, T t16) {
        if (i3 <= 0) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + 1));
            Array.set(tArr2, 0, t16);
            System.arraycopy(tArr, 0, tArr2, 1, tArr.length);
            return tArr2;
        }
        if (i3 >= tArr.length) {
            T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + 1));
            System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
            Array.set(tArr3, Math.min(i3, tArr.length), t16);
            return tArr3;
        }
        T[] tArr4 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + 1));
        System.arraycopy(tArr, 0, tArr4, 0, i3);
        Array.set(tArr4, i3, t16);
        System.arraycopy(tArr, i3, tArr4, i3 + 1, tArr.length - i3);
        return tArr4;
    }

    private static Object a(Object obj, Object obj2) {
        Object obj3;
        if (obj == null || obj2 == null) {
            return obj != null ? obj : obj2;
        }
        if (!obj.getClass().isArray() || !obj2.getClass().isArray()) {
            return obj.getClass().isArray() ? obj : obj2;
        }
        if (obj.getClass() != obj2.getClass() || obj.equals(obj2)) {
            return obj;
        }
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2);
        if (length > 0) {
            obj3 = Array.get(obj, 0);
        } else {
            obj3 = length2 > 0 ? Array.get(obj2, 0) : null;
        }
        if (obj3 == null) {
            return obj;
        }
        Object newInstance = Array.newInstance(obj3.getClass(), length + length2);
        System.arraycopy(obj, 0, newInstance, 0, length);
        System.arraycopy(obj2, 0, newInstance, length, length2);
        return newInstance;
    }

    public static <T extends Comparable<T>> List<T>[] a(List<T> list, List<T> list2) {
        int i3;
        T t16;
        int i16;
        T t17;
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list2 == null) {
            list2 = new ArrayList<>();
        }
        Collections.sort(list, new Comparator<T>() { // from class: com.tencent.mapsdk.internal.hr.1
            /* JADX WARN: Incorrect types in method signature: (TT;TT;)I */
            private static int a(Comparable comparable, Comparable comparable2) {
                return comparable.compareTo(comparable2);
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return ((Comparable) obj).compareTo((Comparable) obj2);
            }
        });
        Collections.sort(list2, new Comparator<T>() { // from class: com.tencent.mapsdk.internal.hr.2
            /* JADX WARN: Incorrect types in method signature: (TT;TT;)I */
            private static int a(Comparable comparable, Comparable comparable2) {
                return comparable.compareTo(comparable2);
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return ((Comparable) obj).compareTo((Comparable) obj2);
            }
        });
        int size = list.size();
        int size2 = list2.size();
        int i17 = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList[] arrayListArr = {new ArrayList(), new ArrayList(), new ArrayList(), arrayList};
        ArrayList arrayList2 = arrayListArr[0];
        ArrayList arrayList3 = arrayListArr[1];
        ArrayList arrayList4 = arrayListArr[2];
        int i18 = 0;
        while (true) {
            if (i17 >= size && i18 >= size2) {
                return arrayListArr;
            }
            if (i17 == size) {
                i3 = i18 + 1;
                t16 = list2.get(i18);
                arrayList4.add(t16);
            } else {
                if (i18 == size2) {
                    i16 = i17 + 1;
                    t17 = list.get(i17);
                    arrayList2.add(t17);
                } else if (list.get(i17).compareTo(list2.get(i18)) < 0) {
                    i16 = i17 + 1;
                    t17 = list.get(i17);
                    arrayList2.add(t17);
                } else if (list.get(i17).compareTo(list2.get(i18)) == 0) {
                    i3 = i18 + 1;
                    t16 = list2.get(i18);
                    arrayList3.add(t16);
                    i17++;
                } else {
                    i3 = i18 + 1;
                    t16 = list2.get(i18);
                    arrayList4.add(t16);
                }
                int i19 = i18;
                t16 = t17;
                i17 = i16;
                i3 = i19;
            }
            arrayList.add(t16);
            i18 = i3;
        }
    }

    private static Integer[] a(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            numArr[i3] = Integer.valueOf(iArr[i3]);
        }
        return numArr;
    }

    private static int[] a(Integer[] numArr) {
        int[] iArr = new int[numArr.length];
        for (int i3 = 0; i3 < numArr.length; i3++) {
            iArr[i3] = numArr[i3].intValue();
        }
        return iArr;
    }

    private static <I> boolean a(Iterable<I> iterable, d<I> dVar) {
        Iterator<I> it = iterable.iterator();
        while (it.hasNext()) {
            if (dVar.b(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static <I> boolean a(Iterable<I> iterable, final I i3) {
        d<I> dVar = new d<I>() { // from class: com.tencent.mapsdk.internal.hr.3
            @Override // com.tencent.mapsdk.internal.hr.d
            public final boolean a(I i16) {
                return Objects.equals(i3, i16);
            }
        };
        Iterator<I> it = iterable.iterator();
        while (it.hasNext()) {
            if (dVar.b(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static <I, O> List<O> a(Iterable<I> iterable, h<I, O> hVar) {
        Iterator<I> it = iterable.iterator();
        while (it.hasNext()) {
            hVar.b(it.next());
        }
        return hVar.f148735a;
    }

    public static <I, O> O a(Iterable<I> iterable, e<I, O> eVar) {
        Iterator<I> it = iterable.iterator();
        while (it.hasNext()) {
            eVar.b(it.next());
        }
        return eVar.f148733a;
    }
}
