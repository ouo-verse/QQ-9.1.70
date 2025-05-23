package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.tencent.mobileqq.msf.core.auth.k;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap<String, Class> mParcelizerCache;
    protected final ArrayMap<String, Method> mReadCache;
    protected final ArrayMap<String, Method> mWriteCache;

    /* loaded from: classes.dex */
    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th5) {
            super(th5);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    private Exception createException(int i3, String str) {
        switch (i3) {
            case -9:
                return (Exception) readParcelable();
            case -8:
            default:
                return new RuntimeException("Unknown exception code: " + i3 + " msg " + str);
            case -7:
                return new UnsupportedOperationException(str);
            case -6:
                return new NetworkOnMainThreadException();
            case -5:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
        }
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = this.mParcelizerCache.get(cls.getName());
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
            this.mParcelizerCache.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }

    private Method getReadMethod(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.mReadCache.get(str);
        if (method == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod(k.f247491e, VersionedParcel.class);
            this.mReadCache.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    @NonNull
    protected static Throwable getRootCause(@NonNull Throwable th5) {
        while (th5.getCause() != null) {
            th5 = th5.getCause();
        }
        return th5;
    }

    private <T> int getType(T t16) {
        if (t16 instanceof String) {
            return 4;
        }
        if (t16 instanceof Parcelable) {
            return 2;
        }
        if (t16 instanceof VersionedParcelable) {
            return 1;
        }
        if (t16 instanceof Serializable) {
            return 3;
        }
        if (t16 instanceof IBinder) {
            return 5;
        }
        if (t16 instanceof Integer) {
            return 7;
        }
        if (t16 instanceof Float) {
            return 8;
        }
        throw new IllegalArgumentException(t16.getClass().getName() + " cannot be VersionedParcelled");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method getWriteMethod(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.mWriteCache.get(cls.getName());
        if (method == null) {
            Class findParcelClass = findParcelClass(cls);
            System.currentTimeMillis();
            Method declaredMethod = findParcelClass.getDeclaredMethod(k.f247492f, cls, VersionedParcel.class);
            this.mWriteCache.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    private <T, S extends Collection<T>> S readCollection(S s16) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 != 1) {
                if (readInt2 != 2) {
                    if (readInt2 != 3) {
                        if (readInt2 != 4) {
                            if (readInt2 == 5) {
                                while (readInt > 0) {
                                    s16.add(readStrongBinder());
                                    readInt--;
                                }
                            }
                        } else {
                            while (readInt > 0) {
                                s16.add(readString());
                                readInt--;
                            }
                        }
                    } else {
                        while (readInt > 0) {
                            s16.add(readSerializable());
                            readInt--;
                        }
                    }
                } else {
                    while (readInt > 0) {
                        s16.add(readParcelable());
                        readInt--;
                    }
                }
            } else {
                while (readInt > 0) {
                    s16.add(readVersionedParcelable());
                    readInt--;
                }
            }
        }
        return s16;
    }

    private int readExceptionCode() {
        return readInt();
    }

    private <T> void writeCollection(Collection<T> collection, int i3) {
        setOutputField(i3);
        writeCollection(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeVersionedParcelableCreator(VersionedParcelable versionedParcelable) {
        try {
            writeString(findParcelClass(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e16) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e16);
        }
    }

    protected abstract void closeField();

    protected abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    public <T> T[] readArray(T[] tArr, int i3) {
        return !readField(i3) ? tArr : (T[]) readArray(tArr);
    }

    protected abstract boolean readBoolean();

    public boolean readBoolean(boolean z16, int i3) {
        if (!readField(i3)) {
            return z16;
        }
        return readBoolean();
    }

    public boolean[] readBooleanArray(boolean[] zArr, int i3) {
        return !readField(i3) ? zArr : readBooleanArray();
    }

    protected abstract Bundle readBundle();

    public Bundle readBundle(Bundle bundle, int i3) {
        if (!readField(i3)) {
            return bundle;
        }
        return readBundle();
    }

    public byte readByte(byte b16, int i3) {
        if (!readField(i3)) {
            return b16;
        }
        return (byte) (readInt() & 255);
    }

    protected abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] bArr, int i3) {
        if (!readField(i3)) {
            return bArr;
        }
        return readByteArray();
    }

    public char[] readCharArray(char[] cArr, int i3) {
        if (!readField(i3)) {
            return cArr;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        char[] cArr2 = new char[readInt];
        for (int i16 = 0; i16 < readInt; i16++) {
            cArr2[i16] = (char) readInt();
        }
        return cArr2;
    }

    protected abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence charSequence, int i3) {
        if (!readField(i3)) {
            return charSequence;
        }
        return readCharSequence();
    }

    protected abstract double readDouble();

    public double readDouble(double d16, int i3) {
        if (!readField(i3)) {
            return d16;
        }
        return readDouble();
    }

    public double[] readDoubleArray(double[] dArr, int i3) {
        return !readField(i3) ? dArr : readDoubleArray();
    }

    public Exception readException(Exception exc, int i3) {
        int readExceptionCode;
        return (readField(i3) && (readExceptionCode = readExceptionCode()) != 0) ? readException(readExceptionCode, readString()) : exc;
    }

    protected abstract boolean readField(int i3);

    protected abstract float readFloat();

    public float readFloat(float f16, int i3) {
        if (!readField(i3)) {
            return f16;
        }
        return readFloat();
    }

    public float[] readFloatArray(float[] fArr, int i3) {
        return !readField(i3) ? fArr : readFloatArray();
    }

    protected <T extends VersionedParcelable> T readFromParcel(String str, VersionedParcel versionedParcel) {
        try {
            return (T) getReadMethod(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e16) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e16);
        } catch (IllegalAccessException e17) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e17);
        } catch (NoSuchMethodException e18) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e18);
        } catch (InvocationTargetException e19) {
            if (e19.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e19.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e19);
        }
    }

    protected abstract int readInt();

    public int readInt(int i3, int i16) {
        if (!readField(i16)) {
            return i3;
        }
        return readInt();
    }

    public int[] readIntArray(int[] iArr, int i3) {
        return !readField(i3) ? iArr : readIntArray();
    }

    public <T> List<T> readList(List<T> list, int i3) {
        if (!readField(i3)) {
            return list;
        }
        return (List) readCollection(new ArrayList());
    }

    protected abstract long readLong();

    public long readLong(long j3, int i3) {
        if (!readField(i3)) {
            return j3;
        }
        return readLong();
    }

    public long[] readLongArray(long[] jArr, int i3) {
        return !readField(i3) ? jArr : readLongArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> readMap(Map<K, V> map, int i3) {
        if (!readField(i3)) {
            return map;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap();
        if (readInt == 0) {
            return arrayMap;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        readCollection(arrayList);
        readCollection(arrayList2);
        for (int i16 = 0; i16 < readInt; i16++) {
            arrayMap.put(arrayList.get(i16), arrayList2.get(i16));
        }
        return arrayMap;
    }

    protected abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T t16, int i3) {
        if (!readField(i3)) {
            return t16;
        }
        return (T) readParcelable();
    }

    protected Serializable readSerializable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        try {
            return (Serializable) new ObjectInputStream(new ByteArrayInputStream(readByteArray())) { // from class: androidx.versionedparcelable.VersionedParcel.1
                @Override // java.io.ObjectInputStream
                protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
                    Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
                    if (cls != null) {
                        return cls;
                    }
                    return super.resolveClass(objectStreamClass);
                }
            }.readObject();
        } catch (IOException e16) {
            throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + readString + ")", e16);
        } catch (ClassNotFoundException e17) {
            throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + readString + ")", e17);
        }
    }

    public <T> Set<T> readSet(Set<T> set, int i3) {
        if (!readField(i3)) {
            return set;
        }
        return (Set) readCollection(new ArraySet());
    }

    @RequiresApi(api = 21)
    public Size readSize(Size size, int i3) {
        if (!readField(i3)) {
            return size;
        }
        if (readBoolean()) {
            return new Size(readInt(), readInt());
        }
        return null;
    }

    @RequiresApi(api = 21)
    public SizeF readSizeF(SizeF sizeF, int i3) {
        if (!readField(i3)) {
            return sizeF;
        }
        if (readBoolean()) {
            return new SizeF(readFloat(), readFloat());
        }
        return null;
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i3) {
        if (!readField(i3)) {
            return sparseBooleanArray;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(readInt);
        for (int i16 = 0; i16 < readInt; i16++) {
            sparseBooleanArray2.put(readInt(), readBoolean());
        }
        return sparseBooleanArray2;
    }

    protected abstract String readString();

    public String readString(String str, int i3) {
        if (!readField(i3)) {
            return str;
        }
        return readString();
    }

    protected abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder iBinder, int i3) {
        if (!readField(i3)) {
            return iBinder;
        }
        return readStrongBinder();
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T t16, int i3) {
        return !readField(i3) ? t16 : (T) readVersionedParcelable();
    }

    protected abstract void setOutputField(int i3);

    public <T> void writeArray(T[] tArr, int i3) {
        setOutputField(i3);
        writeArray(tArr);
    }

    protected abstract void writeBoolean(boolean z16);

    public void writeBoolean(boolean z16, int i3) {
        setOutputField(i3);
        writeBoolean(z16);
    }

    public void writeBooleanArray(boolean[] zArr, int i3) {
        setOutputField(i3);
        writeBooleanArray(zArr);
    }

    protected abstract void writeBundle(Bundle bundle);

    public void writeBundle(Bundle bundle, int i3) {
        setOutputField(i3);
        writeBundle(bundle);
    }

    public void writeByte(byte b16, int i3) {
        setOutputField(i3);
        writeInt(b16);
    }

    protected abstract void writeByteArray(byte[] bArr);

    public void writeByteArray(byte[] bArr, int i3) {
        setOutputField(i3);
        writeByteArray(bArr);
    }

    protected abstract void writeByteArray(byte[] bArr, int i3, int i16);

    public void writeCharArray(char[] cArr, int i3) {
        setOutputField(i3);
        if (cArr != null) {
            writeInt(cArr.length);
            for (char c16 : cArr) {
                writeInt(c16);
            }
            return;
        }
        writeInt(-1);
    }

    protected abstract void writeCharSequence(CharSequence charSequence);

    public void writeCharSequence(CharSequence charSequence, int i3) {
        setOutputField(i3);
        writeCharSequence(charSequence);
    }

    protected abstract void writeDouble(double d16);

    public void writeDouble(double d16, int i3) {
        setOutputField(i3);
        writeDouble(d16);
    }

    public void writeDoubleArray(double[] dArr, int i3) {
        setOutputField(i3);
        writeDoubleArray(dArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeException(Exception exc, int i3) {
        int i16;
        setOutputField(i3);
        if (exc == 0) {
            writeNoException();
            return;
        }
        if ((exc instanceof Parcelable) && exc.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            i16 = -9;
        } else if (exc instanceof SecurityException) {
            i16 = -1;
        } else if (exc instanceof BadParcelableException) {
            i16 = -2;
        } else if (exc instanceof IllegalArgumentException) {
            i16 = -3;
        } else if (exc instanceof NullPointerException) {
            i16 = -4;
        } else if (exc instanceof IllegalStateException) {
            i16 = -5;
        } else if (exc instanceof NetworkOnMainThreadException) {
            i16 = -6;
        } else if (exc instanceof UnsupportedOperationException) {
            i16 = -7;
        } else {
            i16 = 0;
        }
        writeInt(i16);
        if (i16 == 0) {
            if (exc instanceof RuntimeException) {
                throw ((RuntimeException) exc);
            }
            throw new RuntimeException(exc);
        }
        writeString(exc.getMessage());
        if (i16 == -9) {
            writeParcelable((Parcelable) exc);
        }
    }

    protected abstract void writeFloat(float f16);

    public void writeFloat(float f16, int i3) {
        setOutputField(i3);
        writeFloat(f16);
    }

    public void writeFloatArray(float[] fArr, int i3) {
        setOutputField(i3);
        writeFloatArray(fArr);
    }

    protected abstract void writeInt(int i3);

    public void writeInt(int i3, int i16) {
        setOutputField(i16);
        writeInt(i3);
    }

    public void writeIntArray(int[] iArr, int i3) {
        setOutputField(i3);
        writeIntArray(iArr);
    }

    public <T> void writeList(List<T> list, int i3) {
        writeCollection(list, i3);
    }

    protected abstract void writeLong(long j3);

    public void writeLong(long j3, int i3) {
        setOutputField(i3);
        writeLong(j3);
    }

    public void writeLongArray(long[] jArr, int i3) {
        setOutputField(i3);
        writeLongArray(jArr);
    }

    public <K, V> void writeMap(Map<K, V> map, int i3) {
        setOutputField(i3);
        if (map == null) {
            writeInt(-1);
            return;
        }
        int size = map.size();
        writeInt(size);
        if (size == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        writeCollection(arrayList);
        writeCollection(arrayList2);
    }

    protected void writeNoException() {
        writeInt(0);
    }

    protected abstract void writeParcelable(Parcelable parcelable);

    public void writeParcelable(Parcelable parcelable, int i3) {
        setOutputField(i3);
        writeParcelable(parcelable);
    }

    public void writeSerializable(Serializable serializable, int i3) {
        setOutputField(i3);
        writeSerializable(serializable);
    }

    public <T> void writeSet(Set<T> set, int i3) {
        writeCollection(set, i3);
    }

    @RequiresApi(api = 21)
    public void writeSize(Size size, int i3) {
        boolean z16;
        setOutputField(i3);
        if (size != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        writeBoolean(z16);
        if (size != null) {
            writeInt(size.getWidth());
            writeInt(size.getHeight());
        }
    }

    @RequiresApi(api = 21)
    public void writeSizeF(SizeF sizeF, int i3) {
        boolean z16;
        setOutputField(i3);
        if (sizeF != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        writeBoolean(z16);
        if (sizeF != null) {
            writeFloat(sizeF.getWidth());
            writeFloat(sizeF.getHeight());
        }
    }

    public void writeSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i3) {
        setOutputField(i3);
        if (sparseBooleanArray == null) {
            writeInt(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        writeInt(size);
        for (int i16 = 0; i16 < size; i16++) {
            writeInt(sparseBooleanArray.keyAt(i16));
            writeBoolean(sparseBooleanArray.valueAt(i16));
        }
    }

    protected abstract void writeString(String str);

    public void writeString(String str, int i3) {
        setOutputField(i3);
        writeString(str);
    }

    protected abstract void writeStrongBinder(IBinder iBinder);

    public void writeStrongBinder(IBinder iBinder, int i3) {
        setOutputField(i3);
        writeStrongBinder(iBinder);
    }

    protected abstract void writeStrongInterface(IInterface iInterface);

    public void writeStrongInterface(IInterface iInterface, int i3) {
        setOutputField(i3);
        writeStrongInterface(iInterface);
    }

    protected <T extends VersionedParcelable> void writeToParcel(T t16, VersionedParcel versionedParcel) {
        try {
            getWriteMethod(t16.getClass()).invoke(null, t16, versionedParcel);
        } catch (ClassNotFoundException e16) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e16);
        } catch (IllegalAccessException e17) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e17);
        } catch (NoSuchMethodException e18) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e18);
        } catch (InvocationTargetException e19) {
            if (e19.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e19.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e19);
        }
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable, int i3) {
        setOutputField(i3);
        writeVersionedParcelable(versionedParcelable);
    }

    private <T> void writeCollection(Collection<T> collection) {
        if (collection == null) {
            writeInt(-1);
            return;
        }
        int size = collection.size();
        writeInt(size);
        if (size > 0) {
            int type = getType(collection.iterator().next());
            writeInt(type);
            switch (type) {
                case 1:
                    Iterator<T> it = collection.iterator();
                    while (it.hasNext()) {
                        writeVersionedParcelable((VersionedParcelable) it.next());
                    }
                    return;
                case 2:
                    Iterator<T> it5 = collection.iterator();
                    while (it5.hasNext()) {
                        writeParcelable((Parcelable) it5.next());
                    }
                    return;
                case 3:
                    Iterator<T> it6 = collection.iterator();
                    while (it6.hasNext()) {
                        writeSerializable((Serializable) it6.next());
                    }
                    return;
                case 4:
                    Iterator<T> it7 = collection.iterator();
                    while (it7.hasNext()) {
                        writeString((String) it7.next());
                    }
                    return;
                case 5:
                    Iterator<T> it8 = collection.iterator();
                    while (it8.hasNext()) {
                        writeStrongBinder((IBinder) it8.next());
                    }
                    return;
                case 6:
                default:
                    return;
                case 7:
                    Iterator<T> it9 = collection.iterator();
                    while (it9.hasNext()) {
                        writeInt(((Integer) it9.next()).intValue());
                    }
                    return;
                case 8:
                    Iterator<T> it10 = collection.iterator();
                    while (it10.hasNext()) {
                        writeFloat(((Float) it10.next()).floatValue());
                    }
                    return;
            }
        }
    }

    private void writeSerializable(Serializable serializable) {
        if (serializable == null) {
            writeString(null);
            return;
        }
        String name = serializable.getClass().getName();
        writeString(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            writeByteArray(byteArrayOutputStream.toByteArray());
        } catch (IOException e16) {
            throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + name + ")", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T[] readArray(T[] tArr) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readInt);
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    arrayList.add(readVersionedParcelable());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    arrayList.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    arrayList.add(readSerializable());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    arrayList.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    arrayList.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return (T[]) arrayList.toArray(tArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean[] readBooleanArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        boolean[] zArr = new boolean[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            zArr[i3] = readInt() != 0;
        }
        return zArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double[] readDoubleArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        double[] dArr = new double[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            dArr[i3] = readDouble();
        }
        return dArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float[] readFloatArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        float[] fArr = new float[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            fArr[i3] = readFloat();
        }
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] readIntArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        int[] iArr = new int[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            iArr[i3] = readInt();
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long[] readLongArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        long[] jArr = new long[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            jArr[i3] = readLong();
        }
        return jArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends VersionedParcelable> T readVersionedParcelable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        return (T) readFromParcel(readString, createSubParcel());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> void writeArray(T[] tArr) {
        if (tArr == 0) {
            writeInt(-1);
            return;
        }
        int length = tArr.length;
        writeInt(length);
        if (length > 0) {
            int i3 = 0;
            int type = getType(tArr[0]);
            writeInt(type);
            if (type == 1) {
                while (i3 < length) {
                    writeVersionedParcelable((VersionedParcelable) tArr[i3]);
                    i3++;
                }
                return;
            }
            if (type == 2) {
                while (i3 < length) {
                    writeParcelable((Parcelable) tArr[i3]);
                    i3++;
                }
                return;
            }
            if (type == 3) {
                while (i3 < length) {
                    writeSerializable((Serializable) tArr[i3]);
                    i3++;
                }
            } else if (type == 4) {
                while (i3 < length) {
                    writeString((String) tArr[i3]);
                    i3++;
                }
            } else {
                if (type != 5) {
                    return;
                }
                while (i3 < length) {
                    writeStrongBinder((IBinder) tArr[i3]);
                    i3++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeBooleanArray(boolean[] zArr) {
        if (zArr != null) {
            writeInt(zArr.length);
            for (boolean z16 : zArr) {
                writeInt(z16 ? 1 : 0);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeByteArray(byte[] bArr, int i3, int i16, int i17) {
        setOutputField(i17);
        writeByteArray(bArr, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeDoubleArray(double[] dArr) {
        if (dArr != null) {
            writeInt(dArr.length);
            for (double d16 : dArr) {
                writeDouble(d16);
            }
            return;
        }
        writeInt(-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeFloatArray(float[] fArr) {
        if (fArr != null) {
            writeInt(fArr.length);
            for (float f16 : fArr) {
                writeFloat(f16);
            }
            return;
        }
        writeInt(-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeIntArray(int[] iArr) {
        if (iArr != null) {
            writeInt(iArr.length);
            for (int i3 : iArr) {
                writeInt(i3);
            }
            return;
        }
        writeInt(-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeLongArray(long[] jArr) {
        if (jArr != null) {
            writeInt(jArr.length);
            for (long j3 : jArr) {
                writeLong(j3);
            }
            return;
        }
        writeInt(-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeVersionedParcelable(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            writeString(null);
            return;
        }
        writeVersionedParcelableCreator(versionedParcelable);
        VersionedParcel createSubParcel = createSubParcel();
        writeToParcel(versionedParcelable, createSubParcel);
        createSubParcel.closeField();
    }

    private Exception readException(int i3, String str) {
        return createException(i3, str);
    }

    public void setSerializationFlags(boolean z16, boolean z17) {
    }
}
