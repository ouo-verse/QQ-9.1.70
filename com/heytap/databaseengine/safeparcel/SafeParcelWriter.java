package com.heytap.databaseengine.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class SafeParcelWriter {
    SafeParcelWriter() {
    }

    public static void finishObjectHeader(Parcel parcel, int i3) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i3 - 4);
        parcel.writeInt(dataPosition - i3);
        parcel.setDataPosition(dataPosition);
    }

    public static void write(Parcel parcel, int i3, Boolean bool) {
        if (bool == null) {
            return;
        }
        writeHeader(parcel, i3, 4);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    private static <T extends Parcelable> void writeArrayPart(Parcel parcel, T t16, int i3) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t16.writeToParcel(parcel, i3);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static void writeBooleanList(Parcel parcel, int i3, List<Boolean> list, boolean z16) {
        if (list == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcel.writeInt(list.size());
            Iterator<Boolean> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeInt(it.next().booleanValue() ? 1 : 0);
            }
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }

    public static void writeDoubleList(Parcel parcel, int i3, List<Double> list, boolean z16) {
        if (list == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcel.writeInt(list.size());
            Iterator<Double> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeDouble(it.next().doubleValue());
            }
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }

    @Deprecated
    public static void writeEnd(Parcel parcel, int i3) {
        finishObjectHeader(parcel, i3);
    }

    public static void writeFloatList(Parcel parcel, int i3, List<Float> list, boolean z16) {
        if (list == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcel.writeInt(list.size());
            Iterator<Float> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeFloat(it.next().floatValue());
            }
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }

    private static void writeHeader(Parcel parcel, int i3, int i16) {
        if (i16 >= 65535) {
            parcel.writeInt(i3 | SupportMenu.CATEGORY_MASK);
            parcel.writeInt(i16);
        } else {
            parcel.writeInt(i3 | (i16 << 16));
        }
    }

    public static void writeIntegerList(Parcel parcel, int i3, List<Integer> list, boolean z16) {
        if (list == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcel.writeInt(list.size());
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeInt(it.next().intValue());
            }
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }

    public static void writeLongList(Parcel parcel, int i3, List<Long> list, boolean z16) {
        if (list == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcel.writeInt(list.size());
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeLong(it.next().longValue());
            }
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }

    public static int writeObjectHeader(Parcel parcel) {
        writeHeader(parcel, SafeParcelable.SAFE_PARCEL_OBJECT_MAGIC, 65535);
        return parcel.dataPosition();
    }

    @Deprecated
    public static int writeStart(Parcel parcel) {
        return writeObjectHeader(parcel);
    }

    public static void writeStringList(Parcel parcel, int i3, List<String> list, boolean z16) {
        if (list == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcel.writeStringList(list);
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }

    public static void write(Parcel parcel, int i3, Byte b16) {
        if (b16 == null) {
            return;
        }
        writeHeader(parcel, i3, 4);
        parcel.writeInt(b16.byteValue());
    }

    private static int writeObjectHeader(Parcel parcel, int i3) {
        writeHeader(parcel, i3, 65535);
        return parcel.dataPosition();
    }

    public static void write(Parcel parcel, int i3, Short sh5) {
        if (sh5 == null) {
            return;
        }
        writeHeader(parcel, i3, 4);
        parcel.writeInt(sh5.shortValue());
    }

    public static void write(Parcel parcel, int i3, Integer num) {
        if (num == null) {
            return;
        }
        writeHeader(parcel, i3, 4);
        parcel.writeInt(num.intValue());
    }

    public static void write(Parcel parcel, int i3, Long l3) {
        if (l3 == null) {
            return;
        }
        writeHeader(parcel, i3, 8);
        parcel.writeLong(l3.longValue());
    }

    public static void write(Parcel parcel, int i3, Float f16) {
        if (f16 == null) {
            return;
        }
        writeHeader(parcel, i3, 4);
        parcel.writeFloat(f16.floatValue());
    }

    public static void write(Parcel parcel, int i3, Double d16) {
        if (d16 == null) {
            return;
        }
        writeHeader(parcel, i3, 8);
        parcel.writeDouble(d16.doubleValue());
    }

    public static void write(Parcel parcel, int i3, String str, boolean z16) {
        if (str == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcel.writeString(str);
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }

    public static void write(Parcel parcel, int i3, Parcelable parcelable, int i16, boolean z16) {
        if (parcelable == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcelable.writeToParcel(parcel, i16);
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }

    public static void write(Parcel parcel, int i3, Bundle bundle, boolean z16) {
        if (bundle == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcel.writeBundle(bundle);
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }

    public static void write(Parcel parcel, int i3, byte[] bArr, boolean z16) {
        if (bArr == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcel.writeByteArray(bArr);
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }

    public static void write(Parcel parcel, int i3, int[] iArr, boolean z16) {
        if (iArr == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcel.writeIntArray(iArr);
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }

    public static void write(Parcel parcel, int i3, float[] fArr, boolean z16) {
        if (fArr == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcel.writeFloatArray(fArr);
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }

    public static void write(Parcel parcel, int i3, String[] strArr, boolean z16) {
        if (strArr == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcel.writeStringArray(strArr);
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }

    public static <T extends Parcelable> void write(Parcel parcel, int i3, T[] tArr, int i16, boolean z16) {
        if (tArr == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
                return;
            }
            return;
        }
        int writeObjectHeader = writeObjectHeader(parcel, i3);
        parcel.writeInt(tArr.length);
        for (T t16 : tArr) {
            if (t16 == null) {
                parcel.writeInt(0);
            } else {
                writeArrayPart(parcel, t16, i16);
            }
        }
        finishObjectHeader(parcel, writeObjectHeader);
    }

    public static <T extends Parcelable> void write(Parcel parcel, int i3, List<T> list, int i16, boolean z16) {
        if (list == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
                return;
            }
            return;
        }
        int writeObjectHeader = writeObjectHeader(parcel, i3);
        parcel.writeInt(list.size());
        for (T t16 : list) {
            if (t16 == null) {
                parcel.writeInt(0);
            } else {
                writeArrayPart(parcel, t16, i16);
            }
        }
        finishObjectHeader(parcel, writeObjectHeader);
    }

    public static void write(Parcel parcel, int i3, Parcel parcel2, boolean z16) {
        if (parcel2 == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }

    public static void write(Parcel parcel, int i3, List list, boolean z16) {
        if (list == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcel.writeList(list);
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }

    public static void write(Parcel parcel, int i3, Map map, boolean z16) {
        if (map == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcel.writeMap(map);
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }

    public static void write(Parcel parcel, int i3, IBinder iBinder, boolean z16) {
        if (iBinder == null) {
            if (z16) {
                writeHeader(parcel, i3, 0);
            }
        } else {
            int writeObjectHeader = writeObjectHeader(parcel, i3);
            parcel.writeStrongBinder(iBinder);
            finishObjectHeader(parcel, writeObjectHeader);
        }
    }
}
