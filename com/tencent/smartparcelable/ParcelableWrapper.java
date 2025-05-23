package com.tencent.smartparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes25.dex */
public class ParcelableWrapper implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<ParcelableWrapper> CREATOR;

    /* renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<String, b> f368890e;

    /* renamed from: f, reason: collision with root package name */
    private static ParcelableWrapper[] f368891f;

    /* renamed from: h, reason: collision with root package name */
    private static ClassLoader f368892h;

    /* renamed from: i, reason: collision with root package name */
    private static final Set<ClassLoader> f368893i;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.smartparcelable.a f368894d;

    /* loaded from: classes25.dex */
    class a implements Parcelable.Creator<ParcelableWrapper> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableWrapper createFromParcel(Parcel parcel) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ParcelableWrapper) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            ParcelableWrapper parcelableWrapper = new ParcelableWrapper((a) null);
            String readString = parcel.readString();
            if (!TextUtils.isEmpty(readString)) {
                b k3 = ParcelableWrapper.k(readString, null);
                List<Field> list = k3.f368896b;
                List list2 = k3.f368897c;
                try {
                    com.tencent.smartparcelable.a aVar = (com.tencent.smartparcelable.a) k3.f368895a.newInstance();
                    parcelableWrapper.f368894d = aVar;
                    int i3 = 0;
                    for (Field field : list) {
                        int i16 = i3 + 1;
                        switch (((Integer) list2.get(i3)).intValue()) {
                            case 0:
                                field.set(aVar, parcel.readValue(ParcelableWrapper.e()));
                                break;
                            case 1:
                                field.setInt(aVar, parcel.readInt());
                                break;
                            case 2:
                                field.setLong(aVar, parcel.readLong());
                                break;
                            case 3:
                                if (parcel.readByte() > 0) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                field.setBoolean(aVar, z16);
                                break;
                            case 4:
                                field.set(aVar, parcel.readParcelable(ParcelableWrapper.e()));
                                break;
                            case 5:
                                field.set(aVar, parcel.readString());
                                break;
                            case 6:
                                field.set(aVar, ((ParcelableWrapper) parcel.readParcelable(ParcelableWrapper.e())).f368894d);
                                break;
                            case 7:
                                field.setDouble(aVar, parcel.readDouble());
                                break;
                            case 8:
                                field.setFloat(aVar, parcel.readFloat());
                                break;
                            case 9:
                                field.setByte(aVar, parcel.readByte());
                                break;
                            case 10:
                                field.set(aVar, ParcelableWrapper.o(parcel, ParcelableWrapper.e()));
                                break;
                            case 11:
                                field.set(aVar, ParcelableWrapper.p(parcel, ParcelableWrapper.e()));
                                break;
                            case 12:
                                field.set(aVar, parcel.readSerializable());
                                break;
                            case 13:
                                field.set(aVar, parcel.createStringArray());
                                break;
                            case 14:
                                field.set(aVar, parcel.createByteArray());
                                break;
                        }
                        i3 = i16;
                    }
                } catch (Exception e16) {
                    QLog.e("ParcelableWrapper", 1, "ParcelableWrapper.createFromParcel:", e16);
                }
                return parcelableWrapper;
            }
            return parcelableWrapper;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableWrapper[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ParcelableWrapper[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return null;
        }
    }

    /* loaded from: classes25.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private Class f368895a;

        /* renamed from: b, reason: collision with root package name */
        private List<Field> f368896b;

        /* renamed from: c, reason: collision with root package name */
        private List<Integer> f368897c;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f368896b = new ArrayList();
                this.f368897c = new ArrayList();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41551);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f368890e = new ConcurrentHashMap<>(32, 0.75f, 4);
        CREATOR = new a();
        f368891f = new ParcelableWrapper[6];
        f368893i = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    /* synthetic */ ParcelableWrapper(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
    }

    static /* synthetic */ ClassLoader e() {
        return g();
    }

    public static <T extends com.tencent.smartparcelable.a> T f(Parcel parcel) {
        return (T) CREATOR.createFromParcel(parcel).j();
    }

    private static ClassLoader g() {
        ClassLoader classLoader = f368892h;
        if (classLoader != null) {
            return classLoader;
        }
        if (classLoader == null) {
            f368892h = ParcelableWrapper.class.getClassLoader();
        }
        return f368892h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static b k(String str, Class cls) {
        if (str != null) {
            b bVar = f368890e.get(str);
            if (bVar == null) {
                if (cls == null) {
                    try {
                        cls = l(g(), str);
                    } catch (ClassNotFoundException e16) {
                        QLog.e("ParcelableWrapper", 1, "getParcableInfo.forName:" + str, e16);
                        throw new RuntimeException("class forname:" + str);
                    }
                }
                synchronized (cls) {
                    bVar = f368890e.get(str);
                    if (bVar == null) {
                        bVar = n(cls);
                        f368890e.put(str, bVar);
                    }
                }
            }
            return bVar;
        }
        throw new NullPointerException("getParcableInfo.clsName can not be null!");
    }

    public static Class<?> l(ClassLoader classLoader, String str) throws ClassNotFoundException {
        Class<?> cls;
        try {
            cls = classLoader.loadClass(str);
        } catch (ClassNotFoundException e16) {
            if (!f368893i.isEmpty()) {
                cls = null;
            } else {
                throw e16;
            }
        }
        if (cls != null) {
            return cls;
        }
        Iterator<ClassLoader> it = f368893i.iterator();
        while (it.hasNext()) {
            try {
                cls = it.next().loadClass(str);
                break;
            } catch (ClassNotFoundException e17) {
                if (!it.hasNext()) {
                    throw e17;
                }
            }
        }
        return cls;
    }

    public static ParcelableWrapper m(com.tencent.smartparcelable.a aVar) {
        ParcelableWrapper[] parcelableWrapperArr = f368891f;
        synchronized (parcelableWrapperArr) {
            for (int i3 = 0; i3 < 6; i3++) {
                ParcelableWrapper parcelableWrapper = parcelableWrapperArr[i3];
                if (parcelableWrapper != null) {
                    parcelableWrapperArr[i3] = null;
                    parcelableWrapper.f368894d = aVar;
                    return parcelableWrapper;
                }
            }
            return new ParcelableWrapper(aVar);
        }
    }

    private static b n(Class cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        b bVar = new b();
        bVar.f368895a = cls;
        List list = bVar.f368896b;
        List list2 = bVar.f368897c;
        Class superclass = cls.getSuperclass();
        if (com.tencent.smartparcelable.a.class.isAssignableFrom(superclass)) {
            b k3 = k(superclass.getName(), superclass);
            list.addAll(k3.f368896b);
            list2.addAll(k3.f368897c);
        }
        if ((declaredFields == null || declaredFields.length <= 0) && list2.size() <= 0) {
            QLog.e("ParcelableWrapper", 1, "SmartParcelable must have filed to Parcel:" + cls);
            return bVar;
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
                } else if (com.tencent.smartparcelable.a.class.isAssignableFrom(type)) {
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
        return bVar;
    }

    protected static ArrayList o(Parcel parcel, ClassLoader classLoader) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readInt);
        q(parcel, arrayList, readInt, classLoader);
        return arrayList;
    }

    public static HashMap p(Parcel parcel, ClassLoader classLoader) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap(readInt);
        r(parcel, hashMap, readInt, classLoader);
        return hashMap;
    }

    private static void q(Parcel parcel, List list, int i3, ClassLoader classLoader) {
        while (i3 > 0) {
            Object readValue = parcel.readValue(classLoader);
            if (readValue instanceof ParcelableWrapper) {
                list.add(((ParcelableWrapper) readValue).j());
            } else {
                list.add(readValue);
            }
            i3--;
        }
    }

    static void r(Parcel parcel, Map map, int i3, ClassLoader classLoader) {
        while (i3 > 0) {
            Object readValue = parcel.readValue(classLoader);
            Object readValue2 = parcel.readValue(classLoader);
            if (readValue2 instanceof ParcelableWrapper) {
                map.put(readValue, ((ParcelableWrapper) readValue2).j());
            } else {
                map.put(readValue, readValue2);
            }
            i3--;
        }
    }

    public static void s(ParcelableWrapper parcelableWrapper) {
        ParcelableWrapper[] parcelableWrapperArr = f368891f;
        synchronized (parcelableWrapperArr) {
            for (int i3 = 0; i3 < 6; i3++) {
                if (parcelableWrapperArr[i3] == null) {
                    parcelableWrapperArr[i3] = parcelableWrapper;
                    return;
                }
            }
        }
    }

    public static void t(Parcel parcel, int i3, com.tencent.smartparcelable.a aVar) {
        if (aVar == null) {
            parcel.writeString(null);
            return;
        }
        ParcelableWrapper m3 = m(aVar);
        m3.writeToParcel(parcel, i3);
        s(m3);
    }

    public static void u(Parcel parcel, List list) {
        if (list == null) {
            parcel.writeInt(-1);
            return;
        }
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof com.tencent.smartparcelable.a) {
                ParcelableWrapper m3 = m((com.tencent.smartparcelable.a) obj);
                parcel.writeValue(m3);
                s(m3);
            } else {
                parcel.writeValue(obj);
            }
        }
    }

    public static void v(Parcel parcel, Map<String, Object> map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        parcel.writeInt(entrySet.size());
        for (Map.Entry<String, Object> entry : entrySet) {
            parcel.writeValue(entry.getKey());
            Object value = entry.getValue();
            if (value instanceof com.tencent.smartparcelable.a) {
                ParcelableWrapper m3 = m((com.tencent.smartparcelable.a) value);
                parcel.writeValue(m3);
                s(m3);
            } else {
                parcel.writeValue(value);
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public com.tencent.smartparcelable.a j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.smartparcelable.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f368894d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        byte b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        com.tencent.smartparcelable.a aVar = this.f368894d;
        if (aVar == null) {
            parcel.writeString(null);
            return;
        }
        Class<?> cls = aVar.getClass();
        b k3 = k(cls.getName(), cls);
        List<Field> list = k3.f368896b;
        List list2 = k3.f368897c;
        try {
            parcel.writeString(cls.getName());
            int i16 = 0;
            for (Field field : list) {
                int i17 = i16 + 1;
                switch (((Integer) list2.get(i16)).intValue()) {
                    case 0:
                        parcel.writeValue(field.get(this.f368894d));
                        break;
                    case 1:
                        parcel.writeInt(field.getInt(this.f368894d));
                        break;
                    case 2:
                        parcel.writeLong(field.getLong(this.f368894d));
                        break;
                    case 3:
                        if (field.getBoolean(this.f368894d)) {
                            b16 = 1;
                        } else {
                            b16 = 0;
                        }
                        parcel.writeByte(b16);
                        break;
                    case 4:
                        parcel.writeParcelable((Parcelable) field.get(this.f368894d), i3);
                        break;
                    case 5:
                        parcel.writeString((String) field.get(this.f368894d));
                        break;
                    case 6:
                        ParcelableWrapper m3 = m((com.tencent.smartparcelable.a) field.get(this.f368894d));
                        parcel.writeParcelable(m3, i3);
                        s(m3);
                        break;
                    case 7:
                        parcel.writeDouble(field.getDouble(this.f368894d));
                        break;
                    case 8:
                        parcel.writeFloat(field.getFloat(this.f368894d));
                        break;
                    case 9:
                        parcel.writeByte(field.getByte(this.f368894d));
                        break;
                    case 10:
                        u(parcel, (List) field.get(this.f368894d));
                        break;
                    case 11:
                        v(parcel, (Map) field.get(this.f368894d));
                        break;
                    case 12:
                        parcel.writeSerializable((Serializable) field.get(this.f368894d));
                        break;
                    case 13:
                        parcel.writeStringArray((String[]) field.get(this.f368894d));
                        break;
                    case 14:
                        parcel.writeByteArray((byte[]) field.get(this.f368894d));
                        break;
                }
                i16 = i17;
            }
        } catch (Throwable th5) {
            QLog.e("ParcelableWrapper", 1, "ParcelableWrapper.writeToParcel:", th5);
        }
    }

    ParcelableWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    protected ParcelableWrapper(com.tencent.smartparcelable.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f368894d = aVar;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }
}
