package cooperation.qzone.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qzonehub.api.IQzoneEventApi;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes38.dex */
public class ExoticEvent implements IQzoneEventApi.ExoticEventInterface {
    public static final Parcelable.Creator<ExoticEvent> CREATOR = new Parcelable.Creator<ExoticEvent>() { // from class: cooperation.qzone.event.ExoticEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ExoticEvent createFromParcel(Parcel parcel) {
            return new ExoticEvent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ExoticEvent[] newArray(int i3) {
            return new ExoticEvent[i3];
        }
    };
    private static final String TAG = "ExoticEvent";
    private static final int TYPE_BYTE_ARRAY = 5;
    private static final int TYPE_CHAR_ARRAY = 6;
    private static final int TYPE_DOUBLE_ARRAY = 11;
    private static final int TYPE_FLOAT_ARRAY = 9;
    private static final int TYPE_INT_ARRAY = 8;
    private static final int TYPE_LIST = 13;
    private static final int TYPE_LONG_ARRAY = 10;
    private static final int TYPE_MAP = 15;
    private static final int TYPE_NULL = 0;
    private static final int TYPE_OBJECT_ARRAY = -1;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 4;
    private static final int TYPE_SET = 14;
    private static final int TYPE_SHORT_ARRAY = 7;
    private static final int TYPE_SMART_PARCELABLE = 3;
    private static final int TYPE_STRING = 1;
    private static final int TYPE_STRING_ARRAY = 12;
    private static final int TYPE_UNKNOWN = -2;
    private static final int VERSION = 1;
    private final List<Integer> mTypes;
    public final Object param;
    public final String sourceName;
    public final int what;

    ExoticEvent(TypeCheckDoc typeCheckDoc, int i3, String str) {
        this.mTypes = typeCheckDoc.types;
        this.what = i3;
        this.sourceName = str;
        this.param = typeCheckDoc.copyParam;
    }

    private static Object foreachReadFromParcel(Parcel parcel, List<Integer> list, ClassLoader classLoader) {
        int readInt = parcel.readInt();
        list.add(Integer.valueOf(readInt));
        int i3 = 0;
        switch (readInt) {
            case -1:
                int readInt2 = parcel.readInt();
                Object[] objArr = new Object[readInt2];
                while (i3 < readInt2) {
                    objArr[i3] = foreachReadFromParcel(parcel, list, classLoader);
                    i3++;
                }
                return objArr;
            case 0:
            default:
                return null;
            case 1:
                return parcel.readString();
            case 2:
                return parcel.readParcelable(classLoader);
            case 3:
                return ParcelableWrapper.createDataFromParcel(parcel);
            case 4:
                return parcel.readValue(classLoader);
            case 5:
                int readInt3 = parcel.readInt();
                byte[] bArr = new byte[readInt3];
                while (i3 < readInt3) {
                    bArr[i3] = parcel.readByte();
                    i3++;
                }
                return bArr;
            case 6:
                String readString = parcel.readString();
                if (readString == null) {
                    return new char[0];
                }
                return readString.toCharArray();
            case 7:
                int readInt4 = parcel.readInt();
                short[] sArr = new short[readInt4];
                while (i3 < readInt4) {
                    sArr[i3] = (short) parcel.readInt();
                    i3++;
                }
                return sArr;
            case 8:
                int readInt5 = parcel.readInt();
                int[] iArr = new int[readInt5];
                while (i3 < readInt5) {
                    iArr[i3] = parcel.readInt();
                    i3++;
                }
                return iArr;
            case 9:
                int readInt6 = parcel.readInt();
                float[] fArr = new float[readInt6];
                while (i3 < readInt6) {
                    fArr[i3] = parcel.readFloat();
                    i3++;
                }
                return fArr;
            case 10:
                int readInt7 = parcel.readInt();
                long[] jArr = new long[readInt7];
                while (i3 < readInt7) {
                    jArr[i3] = parcel.readLong();
                    i3++;
                }
                return jArr;
            case 11:
                int readInt8 = parcel.readInt();
                double[] dArr = new double[readInt8];
                while (i3 < readInt8) {
                    dArr[i3] = parcel.readDouble();
                    i3++;
                }
                return dArr;
            case 12:
                int readInt9 = parcel.readInt();
                String[] strArr = new String[readInt9];
                while (i3 < readInt9) {
                    strArr[i3] = parcel.readString();
                    i3++;
                }
                return strArr;
            case 13:
                int readInt10 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt10);
                while (i3 < readInt10) {
                    arrayList.add(foreachReadFromParcel(parcel, list, classLoader));
                    i3++;
                }
                return arrayList;
            case 14:
                int readInt11 = parcel.readInt();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                while (i3 < readInt11) {
                    linkedHashSet.add(foreachReadFromParcel(parcel, list, classLoader));
                    i3++;
                }
                return linkedHashSet;
            case 15:
                int readInt12 = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (int i16 = 0; i16 < readInt12; i16++) {
                    Object foreachReadFromParcel = foreachReadFromParcel(parcel, list, classLoader);
                    Object foreachReadFromParcel2 = foreachReadFromParcel(parcel, list, classLoader);
                    if (foreachReadFromParcel != null && foreachReadFromParcel2 != null) {
                        linkedHashMap.put(foreachReadFromParcel, foreachReadFromParcel2);
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("foreachReadFromParcel: null key or value in parsing map ");
                        sb5.append(foreachReadFromParcel == null);
                        sb5.append(" ");
                        sb5.append(foreachReadFromParcel2 == null);
                        QZLog.w(TAG, sb5.toString(), new Throwable());
                    }
                }
                return linkedHashMap;
        }
    }

    private static boolean foreachType(TypeCheckDoc typeCheckDoc) {
        int type = getType(typeCheckDoc.originParam);
        typeCheckDoc.types.add(Integer.valueOf(type));
        if (type == -2) {
            typeCheckDoc.pass = false;
        } else if (type != -1) {
            switch (type) {
                case 13:
                    List list = (List) typeCheckDoc.originParam;
                    ArrayList arrayList = new ArrayList(list.size());
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            typeCheckDoc.copyParam = arrayList;
                            break;
                        } else {
                            TypeCheckDoc typeCheckDoc2 = new TypeCheckDoc(typeCheckDoc, it.next());
                            if (!foreachType(typeCheckDoc2)) {
                                typeCheckDoc.pass = false;
                                break;
                            } else {
                                arrayList.add(typeCheckDoc2.copyParam);
                            }
                        }
                    }
                case 14:
                    Set set = (Set) typeCheckDoc.originParam;
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    Iterator it5 = set.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            typeCheckDoc.copyParam = linkedHashSet;
                            break;
                        } else {
                            TypeCheckDoc typeCheckDoc3 = new TypeCheckDoc(typeCheckDoc, it5.next());
                            if (!foreachType(typeCheckDoc3)) {
                                typeCheckDoc.pass = false;
                                break;
                            } else {
                                linkedHashSet.add(typeCheckDoc3.copyParam);
                            }
                        }
                    }
                case 15:
                    Map map = (Map) typeCheckDoc.originParam;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry entry : map.entrySet()) {
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        if (key != null && value != null) {
                            TypeCheckDoc typeCheckDoc4 = new TypeCheckDoc(typeCheckDoc, key);
                            TypeCheckDoc typeCheckDoc5 = new TypeCheckDoc(typeCheckDoc, value);
                            if (!foreachType(typeCheckDoc4) || !foreachType(typeCheckDoc5)) {
                                typeCheckDoc.pass = false;
                                break;
                            } else {
                                linkedHashMap.put(typeCheckDoc4.copyParam, typeCheckDoc5.copyParam);
                            }
                        }
                    }
                    typeCheckDoc.copyParam = linkedHashMap;
                    break;
            }
        } else {
            Object[] objArr = (Object[]) typeCheckDoc.originParam;
            Object[] objArr2 = new Object[objArr.length];
            int i3 = 0;
            while (true) {
                if (i3 >= objArr.length) {
                    typeCheckDoc.copyParam = objArr2;
                    break;
                }
                TypeCheckDoc typeCheckDoc6 = new TypeCheckDoc(typeCheckDoc, objArr[i3]);
                if (!foreachType(typeCheckDoc6)) {
                    typeCheckDoc.pass = false;
                    break;
                }
                objArr2[i3] = typeCheckDoc6.copyParam;
                i3++;
            }
        }
        return typeCheckDoc.pass;
    }

    private static void foreachWriteToParcel(Parcel parcel, int i3, Iterator<Integer> it, Object obj) {
        if (it.hasNext()) {
            int intValue = it.next().intValue();
            parcel.writeInt(intValue);
            int i16 = 0;
            switch (intValue) {
                case -1:
                    Object[] objArr = (Object[]) obj;
                    parcel.writeInt(objArr.length);
                    int length = objArr.length;
                    while (i16 < length) {
                        foreachWriteToParcel(parcel, i3, it, objArr[i16]);
                        i16++;
                    }
                    return;
                case 0:
                default:
                    return;
                case 1:
                    parcel.writeString((String) obj);
                    return;
                case 2:
                    parcel.writeParcelable((Parcelable) obj, i3);
                    return;
                case 3:
                    ParcelableWrapper.writeDataToParcel(parcel, i3, (SmartParcelable) obj);
                    return;
                case 4:
                    parcel.writeValue(obj);
                    return;
                case 5:
                    byte[] bArr = (byte[]) obj;
                    parcel.writeInt(bArr.length);
                    int length2 = bArr.length;
                    while (i16 < length2) {
                        parcel.writeByte(bArr[i16]);
                        i16++;
                    }
                    return;
                case 6:
                    parcel.writeString(String.valueOf((char[]) obj));
                    return;
                case 7:
                    short[] sArr = (short[]) obj;
                    parcel.writeInt(sArr.length);
                    int length3 = sArr.length;
                    while (i16 < length3) {
                        parcel.writeInt(sArr[i16]);
                        i16++;
                    }
                    return;
                case 8:
                    int[] iArr = (int[]) obj;
                    parcel.writeInt(iArr.length);
                    int length4 = iArr.length;
                    while (i16 < length4) {
                        parcel.writeInt(iArr[i16]);
                        i16++;
                    }
                    return;
                case 9:
                    float[] fArr = (float[]) obj;
                    parcel.writeInt(fArr.length);
                    int length5 = fArr.length;
                    while (i16 < length5) {
                        parcel.writeFloat(fArr[i16]);
                        i16++;
                    }
                    return;
                case 10:
                    long[] jArr = (long[]) obj;
                    parcel.writeInt(jArr.length);
                    int length6 = jArr.length;
                    while (i16 < length6) {
                        parcel.writeLong(jArr[i16]);
                        i16++;
                    }
                    return;
                case 11:
                    double[] dArr = (double[]) obj;
                    parcel.writeInt(dArr.length);
                    int length7 = dArr.length;
                    while (i16 < length7) {
                        parcel.writeDouble(dArr[i16]);
                        i16++;
                    }
                    return;
                case 12:
                    String[] strArr = (String[]) obj;
                    parcel.writeInt(strArr.length);
                    int length8 = strArr.length;
                    while (i16 < length8) {
                        parcel.writeString(strArr[i16]);
                        i16++;
                    }
                    return;
                case 13:
                    List list = (List) obj;
                    parcel.writeInt(list.size());
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        foreachWriteToParcel(parcel, i3, it, it5.next());
                    }
                    return;
                case 14:
                    Set set = (Set) obj;
                    parcel.writeInt(set.size());
                    Iterator it6 = set.iterator();
                    while (it6.hasNext()) {
                        foreachWriteToParcel(parcel, i3, it, it6.next());
                    }
                    return;
                case 15:
                    Map map = (Map) obj;
                    parcel.writeInt(map.size());
                    for (Map.Entry entry : map.entrySet()) {
                        foreachWriteToParcel(parcel, i3, it, entry.getKey());
                        foreachWriteToParcel(parcel, i3, it, entry.getValue());
                    }
                    return;
            }
        }
    }

    public static ClassLoader getLoader() {
        return ExoticEvent.class.getClassLoader();
    }

    public static ExoticEvent obtain(int i3, String str, Object obj) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        TypeCheckDoc typeCheckDoc = new TypeCheckDoc(obj);
        try {
            z16 = foreachType(typeCheckDoc);
        } catch (Throwable th5) {
            QZLog.w(TAG, "obtain: failed to foreach type " + i3 + " " + str, th5);
            z16 = false;
        }
        if (z16) {
            return new ExoticEvent(typeCheckDoc, i3, str);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.qzonehub.api.IQzoneEventApi.ExoticEventInterface
    public Object getParam() {
        return this.param;
    }

    @Override // com.tencent.qzonehub.api.IQzoneEventApi.ExoticEventInterface
    public String getSourceName() {
        return this.sourceName;
    }

    @Override // com.tencent.qzonehub.api.IQzoneEventApi.ExoticEventInterface
    public int getWhat() {
        return this.what;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(1);
        parcel.writeInt(this.what);
        parcel.writeString(this.sourceName);
        foreachWriteToParcel(parcel, i3, this.mTypes.iterator(), this.param);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class TypeCheckDoc {
        private Object copyParam;
        private final Object originParam;
        private boolean pass;
        private final List<Integer> types;

        TypeCheckDoc(Object obj) {
            this.types = new LinkedList();
            this.originParam = obj;
            this.pass = true;
            this.copyParam = obj;
        }

        public TypeCheckDoc(TypeCheckDoc typeCheckDoc, Object obj) {
            this.types = typeCheckDoc.types;
            this.originParam = obj;
            this.pass = typeCheckDoc.pass;
            this.copyParam = obj;
        }
    }

    private static int getType(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof String) {
            return 1;
        }
        if (obj instanceof byte[]) {
            return 5;
        }
        if (obj instanceof char[]) {
            return 6;
        }
        if (obj instanceof short[]) {
            return 7;
        }
        if (obj instanceof int[]) {
            return 8;
        }
        if (obj instanceof float[]) {
            return 9;
        }
        if (obj instanceof long[]) {
            return 10;
        }
        if (obj instanceof double[]) {
            return 11;
        }
        if (obj instanceof String[]) {
            return 12;
        }
        if (obj instanceof Object[]) {
            return -1;
        }
        if (obj instanceof List) {
            return 13;
        }
        if (obj instanceof Set) {
            return 14;
        }
        if (obj instanceof Map) {
            return 15;
        }
        if (obj instanceof Parcelable) {
            return 2;
        }
        if (obj instanceof SmartParcelable) {
            return 3;
        }
        return obj instanceof Serializable ? 4 : -2;
    }

    ExoticEvent(Parcel parcel) {
        LinkedList linkedList = new LinkedList();
        this.mTypes = linkedList;
        int readInt = parcel.readInt();
        int i3 = -1;
        String str = "";
        Object obj = null;
        if (readInt == 1) {
            try {
                int readInt2 = parcel.readInt();
                String readString = parcel.readString();
                obj = foreachReadFromParcel(parcel, linkedList, getLoader());
                i3 = readInt2;
                str = readString;
            } catch (Throwable th5) {
                QZLog.w(TAG, "ExoticEvent: failed to parse event", th5);
                this.mTypes.clear();
                this.mTypes.add(0);
            }
        } else {
            QZLog.w(TAG, "ExoticEvent: wrong version " + readInt, new Throwable());
            linkedList.add(0);
        }
        this.what = i3;
        this.sourceName = str;
        this.param = obj;
    }
}
