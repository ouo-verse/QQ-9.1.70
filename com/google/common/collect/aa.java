package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.u;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
final class aa {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class b<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Field f35008a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(T t16, int i3) {
            try {
                this.f35008a.set(t16, Integer.valueOf(i3));
            } catch (IllegalAccessException e16) {
                throw new AssertionError(e16);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(T t16, Object obj) {
            try {
                this.f35008a.set(t16, obj);
            } catch (IllegalAccessException e16) {
                throw new AssertionError(e16);
            }
        }

        b(Field field) {
            this.f35008a = field;
            field.setAccessible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> b<T> a(Class<T> cls, String str) {
        try {
            return new b<>(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e16) {
            throw new AssertionError(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void b(u<E> uVar, ObjectInputStream objectInputStream, int i3) throws IOException, ClassNotFoundException {
        for (int i16 = 0; i16 < i3; i16++) {
            uVar.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(ObjectInputStream objectInputStream) throws IOException {
        return objectInputStream.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void d(s<K, V> sVar, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(sVar.asMap().size());
        for (Map.Entry<K, Collection<V>> entry : sVar.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> void e(u<E> uVar, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(uVar.entrySet().size());
        for (u.a<E> aVar : uVar.entrySet()) {
            objectOutputStream.writeObject(aVar.getElement());
            objectOutputStream.writeInt(aVar.getCount());
        }
    }
}
