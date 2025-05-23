package com.heytap.databaseengine.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class SafeParcelReader {

    /* loaded from: classes2.dex */
    public static class ReadException extends RuntimeException {
        public ReadException(String str, Parcel parcel) {
            super(str);
        }
    }

    SafeParcelReader() {
    }

    public static int getFieldId(int i3) {
        return i3 & 65535;
    }

    @Deprecated
    public static int halfOf(int i3) {
        return i3 & 65535;
    }

    public static IBinder readBinder(Parcel parcel, int i3) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + readSize);
        return readStrongBinder;
    }

    public static boolean readBool(Parcel parcel, int i3) {
        readExpectedSize(parcel, i3, 4);
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<Boolean> readBooleanList(Parcel parcel, int i3) {
        boolean z16;
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        int readInt = parcel.readInt();
        ArrayList<Boolean> arrayList = new ArrayList<>(readInt);
        for (int i16 = 0; i16 < readInt; i16++) {
            if (parcel.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            arrayList.add(Boolean.valueOf(z16));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static Bundle readBundle(Parcel parcel, int i3, ClassLoader classLoader) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        Bundle readBundle = parcel.readBundle(classLoader);
        parcel.setDataPosition(dataPosition + readSize);
        return readBundle;
    }

    public static byte readByte(Parcel parcel, int i3) {
        readExpectedSize(parcel, i3, 4);
        return (byte) parcel.readInt();
    }

    public static byte[] readByteArray(Parcel parcel, int i3) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createByteArray;
    }

    public static double readDouble(Parcel parcel, int i3) {
        readExpectedSize(parcel, i3, 8);
        return parcel.readDouble();
    }

    public static ArrayList<Double> readDoubleList(Parcel parcel, int i3) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        int readInt = parcel.readInt();
        ArrayList<Double> arrayList = new ArrayList<>(readInt);
        for (int i16 = 0; i16 < readInt; i16++) {
            arrayList.add(Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    private static void readExpectedSize(Parcel parcel, int i3, int i16) {
        int readSize = readSize(parcel, i3);
        if (readSize == i16) {
            return;
        }
        throw new ReadException("Expected size " + i16 + " got " + readSize + " (0x" + Integer.toHexString(readSize) + ")", parcel);
    }

    public static float readFloat(Parcel parcel, int i3) {
        readExpectedSize(parcel, i3, 4);
        return parcel.readFloat();
    }

    public static float[] readFloatArray(Parcel parcel, int i3) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createFloatArray;
    }

    public static ArrayList<Float> readFloatList(Parcel parcel, int i3) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        int readInt = parcel.readInt();
        ArrayList<Float> arrayList = new ArrayList<>(readInt);
        for (int i16 = 0; i16 < readInt; i16++) {
            arrayList.add(Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static int readHeader(Parcel parcel) {
        return parcel.readInt();
    }

    public static int readInt(Parcel parcel, int i3) {
        readExpectedSize(parcel, i3, 4);
        return parcel.readInt();
    }

    public static int[] readIntArray(Parcel parcel, int i3) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createIntArray;
    }

    public static ArrayList<Integer> readIntegerList(Parcel parcel, int i3) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        int readInt = parcel.readInt();
        ArrayList<Integer> arrayList = new ArrayList<>(readInt);
        for (int i16 = 0; i16 < readInt; i16++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static ArrayList readList(Parcel parcel, int i3, ClassLoader classLoader) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        ArrayList readArrayList = parcel.readArrayList(classLoader);
        parcel.setDataPosition(dataPosition + readSize);
        return readArrayList;
    }

    public static long readLong(Parcel parcel, int i3) {
        readExpectedSize(parcel, i3, 8);
        return parcel.readLong();
    }

    public static ArrayList<Long> readLongList(Parcel parcel, int i3) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        int readInt = parcel.readInt();
        ArrayList<Long> arrayList = new ArrayList<>(readInt);
        for (int i16 = 0; i16 < readInt; i16++) {
            arrayList.add(Long.valueOf(parcel.readLong()));
        }
        parcel.setDataPosition(dataPosition + readSize);
        return arrayList;
    }

    public static HashMap readMap(Parcel parcel, int i3, ClassLoader classLoader) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        HashMap readHashMap = parcel.readHashMap(classLoader);
        parcel.setDataPosition(dataPosition + readSize);
        return readHashMap;
    }

    public static int readObjectHeader(Parcel parcel) {
        int readHeader = readHeader(parcel);
        int readSize = readSize(parcel, readHeader);
        int dataPosition = parcel.dataPosition();
        if (getFieldId(readHeader) == 20293) {
            int i3 = readSize + dataPosition;
            if (i3 >= dataPosition && i3 <= parcel.dataSize()) {
                return i3;
            }
            throw new ReadException("Size read is invalid start=" + dataPosition + " end=" + i3, parcel);
        }
        throw new ReadException("Expected object header. Got 0x" + Integer.toHexString(readHeader), parcel);
    }

    public static <T extends Parcelable> T readParcelable(Parcel parcel, int i3, Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + readSize);
        return createFromParcel;
    }

    public static <T extends Parcelable> T[] readParcelableArray(Parcel parcel, int i3, Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        T[] tArr = (T[]) ((Parcelable[]) parcel.createTypedArray(creator));
        parcel.setDataPosition(dataPosition + readSize);
        return tArr;
    }

    public static <T extends Parcelable> ArrayList<T> readParcelableList(Parcel parcel, int i3, Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + readSize);
        return createTypedArrayList;
    }

    public static short readShort(Parcel parcel, int i3) {
        readExpectedSize(parcel, i3, 4);
        return (short) parcel.readInt();
    }

    @Deprecated
    public static int readSingleInt(Parcel parcel) {
        return parcel.readInt();
    }

    private static int readSize(Parcel parcel, int i3) {
        if ((i3 & SupportMenu.CATEGORY_MASK) != -65536) {
            return (i3 >> 16) & 65535;
        }
        return parcel.readInt();
    }

    @Deprecated
    public static int readStart(Parcel parcel) {
        return readObjectHeader(parcel);
    }

    public static String readString(Parcel parcel, int i3) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + readSize);
        return readString;
    }

    public static String[] readStringArray(Parcel parcel, int i3) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createStringArray;
    }

    public static ArrayList<String> readStringList(Parcel parcel, int i3) {
        int readSize = readSize(parcel, i3);
        if (readSize == 0) {
            return null;
        }
        int dataPosition = parcel.dataPosition();
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + readSize);
        return createStringArrayList;
    }

    public static void skip(Parcel parcel, int i3) {
        parcel.setDataPosition(parcel.dataPosition() + readSize(parcel, i3));
    }
}
