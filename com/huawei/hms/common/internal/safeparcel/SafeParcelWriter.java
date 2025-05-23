package com.huawei.hms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* loaded from: classes2.dex */
public class SafeParcelWriter {
    SafeParcelWriter() {
    }

    private static void a(Parcel parcel, int i3, int i16) {
        if (i16 >= 65535) {
            parcel.writeInt(i3 | SupportMenu.CATEGORY_MASK);
            parcel.writeInt(i16);
        } else {
            parcel.writeInt(i3 | (i16 << 16));
        }
    }

    private static void b(Parcel parcel, int i3) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i3 - 4);
        parcel.writeInt(dataPosition - i3);
        parcel.setDataPosition(dataPosition);
    }

    public static int beginObjectHeader(Parcel parcel) {
        return a(parcel, com.heytap.databaseengine.safeparcel.SafeParcelable.SAFE_PARCEL_OBJECT_MAGIC);
    }

    public static void finishObjectHeader(Parcel parcel, int i3) {
        b(parcel, i3);
    }

    public static void writeBigDecimal(Parcel parcel, int i3, BigDecimal bigDecimal, boolean z16) {
        if (bigDecimal != null) {
            int a16 = a(parcel, i3);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeBigDecimalArray(Parcel parcel, int i3, BigDecimal[] bigDecimalArr, boolean z16) {
        if (bigDecimalArr != null) {
            int a16 = a(parcel, i3);
            int length = bigDecimalArr.length;
            parcel.writeInt(length);
            for (int i16 = 0; i16 < length; i16++) {
                parcel.writeByteArray(bigDecimalArr[i16].unscaledValue().toByteArray());
                parcel.writeInt(bigDecimalArr[i16].scale());
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeBigInteger(Parcel parcel, int i3, BigInteger bigInteger, boolean z16) {
        if (bigInteger != null) {
            int a16 = a(parcel, i3);
            parcel.writeByteArray(bigInteger.toByteArray());
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeBigIntegerArray(Parcel parcel, int i3, BigInteger[] bigIntegerArr, boolean z16) {
        if (bigIntegerArr != null) {
            int a16 = a(parcel, i3);
            parcel.writeInt(bigIntegerArr.length);
            for (BigInteger bigInteger : bigIntegerArr) {
                parcel.writeByteArray(bigInteger.toByteArray());
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeBoolean(Parcel parcel, int i3, boolean z16) {
        a(parcel, i3, 4);
        if (z16) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
    }

    public static void writeBooleanArray(Parcel parcel, int i3, boolean[] zArr, boolean z16) {
        if (zArr != null) {
            int a16 = a(parcel, i3);
            parcel.writeBooleanArray(zArr);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeBooleanList(Parcel parcel, int i3, List<Boolean> list, boolean z16) {
        if (list != null) {
            int a16 = a(parcel, i3);
            int size = list.size();
            parcel.writeInt(size);
            for (int i16 = 0; i16 < size; i16++) {
                parcel.writeInt(list.get(i16).booleanValue() ? 1 : 0);
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeBooleanObject(Parcel parcel, int i3, Boolean bool, boolean z16) {
        if (bool != null) {
            a(parcel, i3, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeBundle(Parcel parcel, int i3, Bundle bundle, boolean z16) {
        if (bundle != null) {
            int a16 = a(parcel, i3);
            parcel.writeBundle(bundle);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeByte(Parcel parcel, int i3, byte b16) {
        a(parcel, i3, 4);
        parcel.writeInt(b16);
    }

    public static void writeByteArray(Parcel parcel, int i3, byte[] bArr, boolean z16) {
        if (bArr != null) {
            int a16 = a(parcel, i3);
            parcel.writeByteArray(bArr);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeByteArrayArray(Parcel parcel, int i3, byte[][] bArr, boolean z16) {
        if (bArr != null) {
            int a16 = a(parcel, i3);
            parcel.writeInt(bArr.length);
            for (byte[] bArr2 : bArr) {
                parcel.writeByteArray(bArr2);
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeByteArraySparseArray(Parcel parcel, int i3, SparseArray<byte[]> sparseArray, boolean z16) {
        if (sparseArray != null) {
            int a16 = a(parcel, i3);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i16 = 0; i16 < size; i16++) {
                parcel.writeInt(sparseArray.keyAt(i16));
                parcel.writeByteArray(sparseArray.valueAt(i16));
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeChar(Parcel parcel, int i3, char c16) {
        a(parcel, i3, 4);
        parcel.writeInt(c16);
    }

    public static void writeCharArray(Parcel parcel, int i3, char[] cArr, boolean z16) {
        if (cArr != null) {
            int a16 = a(parcel, i3);
            parcel.writeCharArray(cArr);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeDouble(Parcel parcel, int i3, double d16) {
        a(parcel, i3, 8);
        parcel.writeDouble(d16);
    }

    public static void writeDoubleArray(Parcel parcel, int i3, double[] dArr, boolean z16) {
        if (dArr != null) {
            int a16 = a(parcel, i3);
            parcel.writeDoubleArray(dArr);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeDoubleList(Parcel parcel, int i3, List<Double> list, boolean z16) {
        if (list != null) {
            int a16 = a(parcel, i3);
            int size = list.size();
            parcel.writeInt(size);
            for (int i16 = 0; i16 < size; i16++) {
                parcel.writeDouble(list.get(i16).doubleValue());
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeDoubleObject(Parcel parcel, int i3, Double d16, boolean z16) {
        if (d16 != null) {
            a(parcel, i3, 8);
            parcel.writeDouble(d16.doubleValue());
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeDoubleSparseArray(Parcel parcel, int i3, SparseArray<Double> sparseArray, boolean z16) {
        if (sparseArray != null) {
            int a16 = a(parcel, i3);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i16 = 0; i16 < size; i16++) {
                parcel.writeInt(sparseArray.keyAt(i16));
                parcel.writeDouble(sparseArray.valueAt(i16).doubleValue());
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeFloat(Parcel parcel, int i3, float f16) {
        a(parcel, i3, 4);
        parcel.writeFloat(f16);
    }

    public static void writeFloatArray(Parcel parcel, int i3, float[] fArr, boolean z16) {
        if (fArr != null) {
            int a16 = a(parcel, i3);
            parcel.writeFloatArray(fArr);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeFloatList(Parcel parcel, int i3, List<Float> list, boolean z16) {
        if (list != null) {
            int a16 = a(parcel, i3);
            int size = list.size();
            parcel.writeInt(size);
            for (int i16 = 0; i16 < size; i16++) {
                parcel.writeFloat(list.get(i16).floatValue());
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeFloatObject(Parcel parcel, int i3, Float f16, boolean z16) {
        if (f16 != null) {
            a(parcel, i3, 4);
            parcel.writeFloat(f16.floatValue());
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeFloatSparseArray(Parcel parcel, int i3, SparseArray<Float> sparseArray, boolean z16) {
        if (sparseArray != null) {
            int a16 = a(parcel, i3);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i16 = 0; i16 < size; i16++) {
                parcel.writeInt(sparseArray.keyAt(i16));
                parcel.writeFloat(sparseArray.valueAt(i16).floatValue());
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeIBinder(Parcel parcel, int i3, IBinder iBinder, boolean z16) {
        if (iBinder != null) {
            int a16 = a(parcel, i3);
            parcel.writeStrongBinder(iBinder);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeIBinderArray(Parcel parcel, int i3, IBinder[] iBinderArr, boolean z16) {
        if (iBinderArr != null) {
            int a16 = a(parcel, i3);
            parcel.writeBinderArray(iBinderArr);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeIBinderList(Parcel parcel, int i3, List<IBinder> list, boolean z16) {
        if (list != null) {
            int a16 = a(parcel, i3);
            parcel.writeBinderList(list);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeIBinderSparseArray(Parcel parcel, int i3, SparseArray<IBinder> sparseArray, boolean z16) {
        if (sparseArray != null) {
            int a16 = a(parcel, i3);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i16 = 0; i16 < size; i16++) {
                parcel.writeInt(sparseArray.keyAt(i16));
                parcel.writeStrongBinder(sparseArray.valueAt(i16));
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeInt(Parcel parcel, int i3, int i16) {
        a(parcel, i3, 4);
        parcel.writeInt(i16);
    }

    public static void writeIntArray(Parcel parcel, int i3, int[] iArr, boolean z16) {
        if (iArr != null) {
            int a16 = a(parcel, i3);
            parcel.writeIntArray(iArr);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeIntegerList(Parcel parcel, int i3, List<Integer> list, boolean z16) {
        if (list != null) {
            int a16 = a(parcel, i3);
            int size = list.size();
            parcel.writeInt(size);
            for (int i16 = 0; i16 < size; i16++) {
                parcel.writeInt(list.get(i16).intValue());
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeIntegerObject(Parcel parcel, int i3, Integer num, boolean z16) {
        if (num != null) {
            a(parcel, i3, 4);
            parcel.writeInt(num.intValue());
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeList(Parcel parcel, int i3, List list, boolean z16) {
        if (list != null) {
            int a16 = a(parcel, i3);
            parcel.writeList(list);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeLong(Parcel parcel, int i3, long j3) {
        a(parcel, i3, 8);
        parcel.writeLong(j3);
    }

    public static void writeLongArray(Parcel parcel, int i3, long[] jArr, boolean z16) {
        if (jArr != null) {
            int a16 = a(parcel, i3);
            parcel.writeLongArray(jArr);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeLongList(Parcel parcel, int i3, List<Long> list, boolean z16) {
        if (list != null) {
            int a16 = a(parcel, i3);
            int size = list.size();
            parcel.writeInt(size);
            for (int i16 = 0; i16 < size; i16++) {
                parcel.writeLong(list.get(i16).longValue());
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeLongObject(Parcel parcel, int i3, Long l3, boolean z16) {
        if (l3 != null) {
            a(parcel, i3, 8);
            parcel.writeLong(l3.longValue());
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeParcel(Parcel parcel, int i3, Parcel parcel2, boolean z16) {
        if (parcel2 != null) {
            int a16 = a(parcel, i3);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeParcelArray(Parcel parcel, int i3, Parcel[] parcelArr, boolean z16) {
        if (parcelArr != null) {
            int a16 = a(parcel, i3);
            int length = parcelArr.length;
            parcel.writeInt(length);
            for (int i16 = 0; i16 < length; i16++) {
                Parcel parcel2 = parcelArr[i16];
                if (parcel2 == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(parcel2.dataSize());
                    Parcel parcel3 = parcelArr[i16];
                    parcel.appendFrom(parcel3, 0, parcel3.dataSize());
                }
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeParcelList(Parcel parcel, int i3, List<Parcel> list, boolean z16) {
        if (list != null) {
            int a16 = a(parcel, i3);
            int size = list.size();
            parcel.writeInt(size);
            for (int i16 = 0; i16 < size; i16++) {
                Parcel parcel2 = list.get(i16);
                if (parcel2 == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                }
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeParcelSparseArray(Parcel parcel, int i3, SparseArray<Parcel> sparseArray, boolean z16) {
        if (sparseArray != null) {
            int a16 = a(parcel, i3);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i16 = 0; i16 < size; i16++) {
                parcel.writeInt(sparseArray.keyAt(i16));
                Parcel valueAt = sparseArray.valueAt(i16);
                if (valueAt == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(valueAt.dataSize());
                    parcel.appendFrom(valueAt, 0, valueAt.dataSize());
                }
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeParcelable(Parcel parcel, int i3, Parcelable parcelable, int i16, boolean z16) {
        if (parcelable != null) {
            int a16 = a(parcel, i3);
            parcelable.writeToParcel(parcel, i16);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeShort(Parcel parcel, int i3, short s16) {
        a(parcel, i3, 4);
        parcel.writeInt(s16);
    }

    public static void writeSparseBooleanArray(Parcel parcel, int i3, SparseBooleanArray sparseBooleanArray, boolean z16) {
        if (sparseBooleanArray != null) {
            int a16 = a(parcel, i3);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeSparseIntArray(Parcel parcel, int i3, SparseIntArray sparseIntArray, boolean z16) {
        if (sparseIntArray != null) {
            int a16 = a(parcel, i3);
            int size = sparseIntArray.size();
            parcel.writeInt(size);
            for (int i16 = 0; i16 < size; i16++) {
                parcel.writeInt(sparseIntArray.keyAt(i16));
                parcel.writeInt(sparseIntArray.valueAt(i16));
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeSparseLongArray(Parcel parcel, int i3, SparseLongArray sparseLongArray, boolean z16) {
        if (sparseLongArray != null) {
            int a16 = a(parcel, i3);
            int size = sparseLongArray.size();
            parcel.writeInt(size);
            for (int i16 = 0; i16 < size; i16++) {
                parcel.writeInt(sparseLongArray.keyAt(i16));
                parcel.writeLong(sparseLongArray.valueAt(i16));
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeString(Parcel parcel, int i3, String str, boolean z16) {
        if (str != null) {
            int a16 = a(parcel, i3);
            parcel.writeString(str);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeStringArray(Parcel parcel, int i3, String[] strArr, boolean z16) {
        if (strArr != null) {
            int a16 = a(parcel, i3);
            parcel.writeStringArray(strArr);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeStringList(Parcel parcel, int i3, List<String> list, boolean z16) {
        if (list != null) {
            int a16 = a(parcel, i3);
            parcel.writeStringList(list);
            b(parcel, a16);
        } else if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static void writeStringSparseArray(Parcel parcel, int i3, SparseArray<String> sparseArray, boolean z16) {
        if (sparseArray != null) {
            int a16 = a(parcel, i3);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i16 = 0; i16 < size; i16++) {
                parcel.writeInt(sparseArray.keyAt(i16));
                parcel.writeString(sparseArray.valueAt(i16));
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static <P extends Parcelable> void writeTypedArray(Parcel parcel, int i3, P[] pArr, int i16, boolean z16) {
        if (pArr != null) {
            int a16 = a(parcel, i3);
            parcel.writeInt(a16);
            for (P p16 : pArr) {
                if (p16 != null) {
                    a(parcel, p16, i16);
                } else {
                    parcel.writeInt(0);
                }
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int i3, List<T> list, boolean z16) {
        if (list != null) {
            int a16 = a(parcel, i3);
            int size = list.size();
            parcel.writeInt(size);
            for (int i16 = 0; i16 < size; i16++) {
                T t16 = list.get(i16);
                if (t16 != null) {
                    a(parcel, t16, 0);
                } else {
                    parcel.writeInt(0);
                }
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel parcel, int i3, SparseArray<T> sparseArray, boolean z16) {
        if (sparseArray != null) {
            int a16 = a(parcel, i3);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i16 = 0; i16 < size; i16++) {
                parcel.writeInt(sparseArray.keyAt(i16));
                T valueAt = sparseArray.valueAt(i16);
                if (valueAt != null) {
                    a(parcel, valueAt, 0);
                } else {
                    parcel.writeInt(0);
                }
            }
            b(parcel, a16);
            return;
        }
        if (z16) {
            a(parcel, i3, 0);
        }
    }

    private static int a(Parcel parcel, int i3) {
        parcel.writeInt(i3 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static <P extends Parcelable> void a(Parcel parcel, P p16, int i3) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        p16.writeToParcel(parcel, i3);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
