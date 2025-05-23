package com.tencent.component.app.common;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.ditto.utils.ClassLoadUtils;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class ParcelableWrapper implements Parcelable {
    private static final int ARRAY_LIST_TYPE = 10;
    private static final int BOOL_TYPE = 3;
    private static final int BYTEARRAY_TYPE = 14;
    private static final int BYTE_TYPE = 9;
    private static final int DOUBLE_TYPE = 7;
    private static final int FLOAT_TYPE = 8;
    private static final int INT_TYPE = 1;
    private static final int LONG_TYPE = 2;
    private static final int MAP_TYPE = 11;
    private static final int PARCABLE_TYPE = 4;
    public static final int POOL_SIZE = 6;
    private static final int SERIALIZABLE_TYPE = 12;
    private static final int SMART_PARCEL_TYPE = 6;
    private static final int STRINGARRAY_TYPE = 13;
    private static final int STRING_TYPE = 5;
    private static final int TYPE_UNDEFINE = 0;
    private static ClassLoader sClassLoader;
    private SmartParcelable obj;
    private static ConcurrentHashMap<String, ParcableInfo> sParcableCache = new ConcurrentHashMap<>(32, 0.75f, 4);
    public static final Parcelable.Creator<ParcelableWrapper> CREATOR = new Parcelable.Creator<ParcelableWrapper>() { // from class: com.tencent.component.app.common.ParcelableWrapper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableWrapper[] newArray(int i3) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableWrapper createFromParcel(Parcel parcel) {
            ParcelableWrapper parcelableWrapper = new ParcelableWrapper();
            String readString = parcel.readString();
            if (TextUtils.isEmpty(readString)) {
                return parcelableWrapper;
            }
            ParcableInfo parcableInfo = ParcelableWrapper.getParcableInfo(readString, null);
            List<Field> list = parcableInfo.fields;
            List list2 = parcableInfo.fieldTypes;
            try {
                SmartParcelable smartParcelable = (SmartParcelable) parcableInfo.cls.newInstance();
                parcelableWrapper.obj = smartParcelable;
                int i3 = 0;
                for (Field field : list) {
                    int i16 = i3 + 1;
                    switch (((Integer) list2.get(i3)).intValue()) {
                        case 0:
                            field.set(smartParcelable, parcel.readValue(ParcelableWrapper.c()));
                            break;
                        case 1:
                            field.setInt(smartParcelable, parcel.readInt());
                            break;
                        case 2:
                            field.setLong(smartParcelable, parcel.readLong());
                            break;
                        case 3:
                            field.setBoolean(smartParcelable, parcel.readByte() > 0);
                            break;
                        case 4:
                            field.set(smartParcelable, parcel.readParcelable(ParcelableWrapper.c()));
                            break;
                        case 5:
                            field.set(smartParcelable, parcel.readString());
                            break;
                        case 6:
                            field.set(smartParcelable, ((ParcelableWrapper) parcel.readParcelable(ParcelableWrapper.c())).obj);
                            break;
                        case 7:
                            field.setDouble(smartParcelable, parcel.readDouble());
                            break;
                        case 8:
                            field.setFloat(smartParcelable, parcel.readFloat());
                            break;
                        case 9:
                            field.setByte(smartParcelable, parcel.readByte());
                            break;
                        case 10:
                            field.set(smartParcelable, ParcelableWrapper.readArrayList(parcel, ParcelableWrapper.c()));
                            break;
                        case 11:
                            field.set(smartParcelable, ParcelableWrapper.readHashMap(parcel, ParcelableWrapper.c()));
                            break;
                        case 12:
                            field.set(smartParcelable, parcel.readSerializable());
                            break;
                        case 13:
                            field.set(smartParcelable, parcel.createStringArray());
                            break;
                        case 14:
                            field.set(smartParcelable, parcel.createByteArray());
                            break;
                    }
                    i3 = i16;
                }
            } catch (Exception e16) {
                QZLog.e("ParcelableWrapper", "ParcelableWrapper.createFromParcel:", e16);
            }
            return parcelableWrapper;
        }
    };
    private static ParcelableWrapper[] sOwnedPool = new ParcelableWrapper[6];

    /* loaded from: classes5.dex */
    public static class ParcableInfo {
        private Class cls;
        private List<Field> fields = new ArrayList();
        private List<Integer> fieldTypes = new ArrayList();
    }

    ParcelableWrapper() {
    }

    static /* bridge */ /* synthetic */ ClassLoader c() {
        return getClassLoader();
    }

    public static <T extends SmartParcelable> ArrayList<T> createArrayListFromParcel(Parcel parcel) {
        ParcelableListWrapper createFromParcel = ParcelableListWrapper.CREATOR.createFromParcel(parcel);
        if (createFromParcel == null) {
            return null;
        }
        return createFromParcel.getParcelableList();
    }

    public static <T extends SmartParcelable> T createDataFromParcel(Parcel parcel) {
        return (T) CREATOR.createFromParcel(parcel).getData();
    }

    public static <T extends SmartParcelable> ArrayList<T> getArrayListFromBundle(Bundle bundle, String str) {
        ParcelableListWrapper parcelableListWrapper = (ParcelableListWrapper) bundle.getParcelable(str);
        if (parcelableListWrapper != null) {
            return parcelableListWrapper.getParcelableList();
        }
        return null;
    }

    public static <T extends SmartParcelable> ArrayList<T> getArrayListFromIntent(Intent intent, String str) {
        ParcelableListWrapper parcelableListWrapper;
        if (intent == null || (parcelableListWrapper = (ParcelableListWrapper) intent.getParcelableExtra(str)) == null) {
            return null;
        }
        return parcelableListWrapper.getParcelableList();
    }

    private static ClassLoader getClassLoader() {
        if (sClassLoader == null) {
            sClassLoader = ParcelableWrapper.class.getClassLoader();
        }
        return sClassLoader;
    }

    public static <T extends SmartParcelable> T getDataFromBudle(Bundle bundle, String str) {
        ParcelableWrapper parcelableWrapper = (ParcelableWrapper) bundle.getParcelable(str);
        if (parcelableWrapper == null) {
            return null;
        }
        return (T) parcelableWrapper.getData();
    }

    public static <T extends SmartParcelable> T getDataFromeIntent(Intent intent, String str) {
        ParcelableWrapper parcelableWrapper;
        if (intent == null || (parcelableWrapper = (ParcelableWrapper) intent.getParcelableExtra(str)) == null) {
            return null;
        }
        return (T) parcelableWrapper.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ParcableInfo getParcableInfo(String str, Class cls) {
        if (str != null) {
            ParcableInfo parcableInfo = sParcableCache.get(str);
            if (parcableInfo == null) {
                if (cls == null) {
                    try {
                        cls = ClassLoadUtils.load(getClassLoader(), str);
                    } catch (ClassNotFoundException e16) {
                        QZLog.e("ParcelableWrapper", "getParcableInfo.forName:" + str, e16);
                        throw new RuntimeException("class forname:" + str);
                    }
                }
                synchronized (cls) {
                    parcableInfo = sParcableCache.get(str);
                    if (parcableInfo == null) {
                        parcableInfo = parseParcableInfo(cls);
                        sParcableCache.put(str, parcableInfo);
                    }
                }
            }
            return parcableInfo;
        }
        throw new NullPointerException("getParcableInfo.clsName can not be null!");
    }

    public static ParcelableWrapper obtain(SmartParcelable smartParcelable) {
        ParcelableWrapper[] parcelableWrapperArr = sOwnedPool;
        synchronized (parcelableWrapperArr) {
            for (int i3 = 0; i3 < 6; i3++) {
                ParcelableWrapper parcelableWrapper = parcelableWrapperArr[i3];
                if (parcelableWrapper != null) {
                    parcelableWrapperArr[i3] = null;
                    parcelableWrapper.obj = smartParcelable;
                    return parcelableWrapper;
                }
            }
            return new ParcelableWrapper(smartParcelable);
        }
    }

    private static ParcableInfo parseParcableInfo(Class cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        ParcableInfo parcableInfo = new ParcableInfo();
        parcableInfo.cls = cls;
        List list = parcableInfo.fields;
        List list2 = parcableInfo.fieldTypes;
        Class superclass = cls.getSuperclass();
        if (SmartParcelable.class.isAssignableFrom(superclass)) {
            ParcableInfo parcableInfo2 = getParcableInfo(superclass.getName(), superclass);
            list.addAll(parcableInfo2.fields);
            list2.addAll(parcableInfo2.fieldTypes);
        }
        if ((declaredFields == null || declaredFields.length <= 0) && list2.size() <= 0) {
            QZLog.e("ParcelableWrapper", "SmartParcelable must have filed to Parcel:" + cls);
            return parcableInfo;
        }
        for (Field field : declaredFields) {
            if (field.getAnnotation(NeedParcel.class) != null) {
                field.setAccessible(true);
                list.add(field);
                Class<?> type = field.getType();
                if (type == Integer.TYPE) {
                    list2.add(1);
                } else if (type == String.class) {
                    list2.add(5);
                } else if (type == Long.TYPE) {
                    list2.add(2);
                } else if (type == Double.TYPE) {
                    list2.add(7);
                } else if (type == Float.TYPE) {
                    list2.add(8);
                } else if (type == Boolean.TYPE) {
                    list2.add(3);
                } else if (type == Byte.TYPE) {
                    list2.add(9);
                } else if (SmartParcelable.class.isAssignableFrom(type)) {
                    list2.add(6);
                } else if (Parcelable.class.isAssignableFrom(type)) {
                    list2.add(4);
                } else if (List.class.isAssignableFrom(type)) {
                    list2.add(10);
                } else if (Map.class.isAssignableFrom(type)) {
                    list2.add(11);
                } else if (Serializable.class.isAssignableFrom(type)) {
                    list2.add(12);
                } else if (String[].class.isAssignableFrom(type)) {
                    list2.add(13);
                } else if (byte[].class.isAssignableFrom(type)) {
                    list2.add(14);
                } else {
                    list2.add(0);
                }
            }
        }
        return parcableInfo;
    }

    public static void putArrayListToBundle(Bundle bundle, String str, ArrayList<? extends SmartParcelable> arrayList) {
        if (arrayList == null) {
            bundle.putParcelable(str, null);
        } else {
            bundle.putParcelable(str, new ParcelableListWrapper(arrayList));
        }
    }

    public static Intent putArrayListToIntent(Intent intent, String str, ArrayList<? extends SmartParcelable> arrayList) {
        if (intent == null) {
            return null;
        }
        if (arrayList == null) {
            intent.putExtra(str, (Parcelable) null);
        } else {
            intent.putExtra(str, new ParcelableListWrapper(arrayList));
        }
        return intent;
    }

    public static void putDataToBundle(Bundle bundle, String str, SmartParcelable smartParcelable) {
        bundle.putParcelable(str, new ParcelableWrapper(smartParcelable));
    }

    public static void putDataToIntent(Intent intent, String str, SmartParcelable smartParcelable) {
        intent.putExtra(str, new ParcelableWrapper(smartParcelable));
    }

    protected static ArrayList readArrayList(Parcel parcel, ClassLoader classLoader) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readInt);
        readListInternal(parcel, arrayList, readInt, classLoader);
        return arrayList;
    }

    public static HashMap readHashMap(Parcel parcel, ClassLoader classLoader) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap(readInt);
        readMapInternal(parcel, hashMap, readInt, classLoader);
        return hashMap;
    }

    private static void readListInternal(Parcel parcel, List list, int i3, ClassLoader classLoader) {
        while (i3 > 0) {
            Object readValue = parcel.readValue(classLoader);
            if (readValue instanceof ParcelableWrapper) {
                list.add(((ParcelableWrapper) readValue).getData());
            } else {
                list.add(readValue);
            }
            i3--;
        }
    }

    static void readMapInternal(Parcel parcel, Map map, int i3, ClassLoader classLoader) {
        while (i3 > 0) {
            Object readValue = parcel.readValue(classLoader);
            Object readValue2 = parcel.readValue(classLoader);
            if (readValue2 instanceof ParcelableWrapper) {
                map.put(readValue, ((ParcelableWrapper) readValue2).getData());
            } else {
                map.put(readValue, readValue2);
            }
            i3--;
        }
    }

    public static void recycle(ParcelableWrapper parcelableWrapper) {
        ParcelableWrapper[] parcelableWrapperArr = sOwnedPool;
        synchronized (parcelableWrapperArr) {
            for (int i3 = 0; i3 < 6; i3++) {
                if (parcelableWrapperArr[i3] == null) {
                    parcelableWrapperArr[i3] = parcelableWrapper;
                    return;
                }
            }
        }
    }

    public static void writeArrayListToParcel(Parcel parcel, int i3, ArrayList<? extends SmartParcelable> arrayList) {
        if (arrayList == null) {
            parcel.writeString(null);
            return;
        }
        ParcelableListWrapper obtain = ParcelableListWrapper.obtain(arrayList);
        obtain.writeToParcel(parcel, i3);
        ParcelableListWrapper.recycle(obtain);
    }

    public static void writeDataToParcel(Parcel parcel, int i3, SmartParcelable smartParcelable) {
        if (smartParcelable == null) {
            parcel.writeString(null);
            return;
        }
        ParcelableWrapper obtain = obtain(smartParcelable);
        obtain.writeToParcel(parcel, i3);
        recycle(obtain);
    }

    public static void writeList(Parcel parcel, List list) {
        if (list == null) {
            parcel.writeInt(-1);
            return;
        }
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof SmartParcelable) {
                ParcelableWrapper obtain = obtain((SmartParcelable) obj);
                parcel.writeValue(obtain);
                recycle(obtain);
            } else {
                parcel.writeValue(obj);
            }
        }
    }

    public static void writeMap(Parcel parcel, Map<String, Object> map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        parcel.writeInt(entrySet.size());
        for (Map.Entry<String, Object> entry : entrySet) {
            parcel.writeValue(entry.getKey());
            Object value = entry.getValue();
            if (value instanceof SmartParcelable) {
                ParcelableWrapper obtain = obtain((SmartParcelable) value);
                parcel.writeValue(obtain);
                recycle(obtain);
            } else {
                parcel.writeValue(value);
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SmartParcelable getData() {
        return this.obj;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        byte b16;
        SmartParcelable smartParcelable = this.obj;
        if (smartParcelable == null) {
            parcel.writeString(null);
            return;
        }
        Class<?> cls = smartParcelable.getClass();
        ParcableInfo parcableInfo = getParcableInfo(cls.getName(), cls);
        List<Field> list = parcableInfo.fields;
        List list2 = parcableInfo.fieldTypes;
        try {
            parcel.writeString(cls.getName());
            int i16 = 0;
            for (Field field : list) {
                int i17 = i16 + 1;
                switch (((Integer) list2.get(i16)).intValue()) {
                    case 0:
                        parcel.writeValue(field.get(this.obj));
                        break;
                    case 1:
                        parcel.writeInt(field.getInt(this.obj));
                        break;
                    case 2:
                        parcel.writeLong(field.getLong(this.obj));
                        break;
                    case 3:
                        if (field.getBoolean(this.obj)) {
                            b16 = 1;
                        } else {
                            b16 = 0;
                        }
                        parcel.writeByte(b16);
                        break;
                    case 4:
                        parcel.writeParcelable((Parcelable) field.get(this.obj), i3);
                        break;
                    case 5:
                        parcel.writeString((String) field.get(this.obj));
                        break;
                    case 6:
                        ParcelableWrapper obtain = obtain((SmartParcelable) field.get(this.obj));
                        parcel.writeParcelable(obtain, i3);
                        recycle(obtain);
                        break;
                    case 7:
                        parcel.writeDouble(field.getDouble(this.obj));
                        break;
                    case 8:
                        parcel.writeFloat(field.getFloat(this.obj));
                        break;
                    case 9:
                        parcel.writeByte(field.getByte(this.obj));
                        break;
                    case 10:
                        writeList(parcel, (List) field.get(this.obj));
                        break;
                    case 11:
                        writeMap(parcel, (Map) field.get(this.obj));
                        break;
                    case 12:
                        parcel.writeSerializable((Serializable) field.get(this.obj));
                        break;
                    case 13:
                        parcel.writeStringArray((String[]) field.get(this.obj));
                        break;
                    case 14:
                        parcel.writeByteArray((byte[]) field.get(this.obj));
                        break;
                }
                i16 = i17;
            }
        } catch (Throwable th5) {
            QZLog.e("ParcelableWrapper", "ParcelableWrapper.writeToParcel:", th5);
        }
    }

    protected ParcelableWrapper(SmartParcelable smartParcelable) {
        this.obj = smartParcelable;
    }
}
