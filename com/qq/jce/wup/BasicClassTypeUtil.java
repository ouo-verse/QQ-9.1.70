package com.qq.jce.wup;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BasicClassTypeUtil {
    private static ClassLoader classLoader = null;
    private static boolean classLoaderInitialize = true;

    private static void addType(ArrayList<String> arrayList, String str) {
        int length = str.length();
        while (str.charAt(length - 1) == '>' && length - 1 != 0) {
        }
        arrayList.add(0, uni2JavaType(str.substring(0, length)));
    }

    public static Object createClassByName(String str) throws ObjectCreateException {
        Class<?> cls;
        if (str.equals("java.lang.Integer")) {
            return 0;
        }
        if (str.equals("java.lang.Boolean")) {
            return Boolean.FALSE;
        }
        if (str.equals("java.lang.Byte")) {
            return (byte) 0;
        }
        if (str.equals("java.lang.Double")) {
            return Double.valueOf(0.0d);
        }
        if (str.equals("java.lang.Float")) {
            return Float.valueOf(0.0f);
        }
        if (str.equals("java.lang.Long")) {
            return 0L;
        }
        if (str.equals("java.lang.Short")) {
            return (short) 0;
        }
        if (!str.equals("java.lang.Character")) {
            if (str.equals("java.lang.String")) {
                return "";
            }
            if (str.equals("java.util.List")) {
                return new ArrayList();
            }
            if (str.equals("java.util.Map")) {
                return new HashMap();
            }
            if (str.equals(Entry.DATA_TYPE_Array)) {
                return Entry.DATA_TYPE_Array;
            }
            if (str.equals(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                return str;
            }
            try {
                ClassLoader classLoader2 = classLoader;
                if (classLoader2 != null) {
                    cls = Class.forName(str, classLoaderInitialize, classLoader2);
                } else {
                    cls = Class.forName(str);
                }
                return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e16) {
                e16.printStackTrace();
                throw new ObjectCreateException(e16);
            }
        }
        throw new IllegalArgumentException("can not support java.lang.Character");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
    
        if (r2 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
    
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
    
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0040, code lost:
    
        if (r2 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object createClassByUni(String str) throws ObjectCreateException {
        boolean z16;
        Iterator<String> it = getTypeList(str).iterator();
        Object obj = null;
        Object obj2 = null;
        while (true) {
            Object obj3 = obj2;
            while (it.hasNext()) {
                obj = createClassByName(it.next());
                boolean z17 = false;
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (Entry.DATA_TYPE_Array.equals(str2)) {
                        if (obj2 == null) {
                            obj = Array.newInstance((Class<?>) Byte.class, 0);
                        }
                    } else if (!QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER.equals(str2)) {
                    }
                } else if (obj instanceof List) {
                    if (obj2 != null && (obj2 instanceof Byte)) {
                        obj = Array.newInstance((Class<?>) Byte.class, 1);
                        Array.set(obj, 0, obj2);
                    } else {
                        if (obj2 != null) {
                            ((List) obj).add(obj2);
                        }
                        obj2 = null;
                    }
                } else if (obj instanceof Map) {
                    if (obj2 != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (obj3 != null) {
                        z17 = true;
                    }
                    if (z16 & z17) {
                        ((Map) obj).put(obj2, obj3);
                    }
                    obj2 = null;
                }
            }
            return obj;
        }
    }

    public static String getClassTransName(String str) {
        if (str.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
            return "Integer";
        }
        if (str.equals(HippyControllerProps.BOOLEAN)) {
            return "Boolean";
        }
        if (str.equals("byte")) {
            return "Byte";
        }
        if (str.equals("double")) {
            return "Double";
        }
        if (str.equals("float")) {
            return "Float";
        }
        if (str.equals(PoiListCacheRecord.TIMESTAMP_TYPE)) {
            return "Long";
        }
        if (str.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
            return "Short";
        }
        if (str.equals(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR)) {
            return "Character";
        }
        return str;
    }

    public static ArrayList<String> getTypeList(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        int indexOf = str.indexOf("<");
        int i3 = 0;
        while (i3 < indexOf) {
            addType(arrayList, str.substring(i3, indexOf));
            i3 = indexOf + 1;
            indexOf = str.indexOf("<", i3);
            int indexOf2 = str.indexOf(",", i3);
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            if (indexOf2 != -1 && indexOf2 < indexOf) {
                indexOf = indexOf2;
            }
        }
        addType(arrayList, str.substring(i3, str.length()));
        return arrayList;
    }

    public static String getVariableInit(String str, String str2) {
        if (str2.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
            return str2 + " " + str + "=0 ;\n";
        }
        if (str2.equals(HippyControllerProps.BOOLEAN)) {
            return str2 + " " + str + "=false ;\n";
        }
        if (str2.equals("byte")) {
            return str2 + " " + str + " ;\n";
        }
        if (str2.equals("double")) {
            return str2 + " " + str + "=0 ;\n";
        }
        if (str2.equals("float")) {
            return str2 + " " + str + "=0 ;\n";
        }
        if (str2.equals(PoiListCacheRecord.TIMESTAMP_TYPE)) {
            return str2 + " " + str + "=0 ;\n";
        }
        if (str2.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
            return str2 + " " + str + "=0 ;\n";
        }
        if (str2.equals(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR)) {
            return str2 + " " + str + " ;\n";
        }
        return str2 + " " + str + " = null ;\n";
    }

    public static boolean isBasicType(String str) {
        if (str.equals(PoiListCacheRecord.WEIGHT_TYPE) || str.equals(HippyControllerProps.BOOLEAN) || str.equals("byte") || str.equals("double") || str.equals("float") || str.equals(PoiListCacheRecord.TIMESTAMP_TYPE) || str.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT) || str.equals(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR) || str.equals("Integer") || str.equals("Boolean") || str.equals("Byte") || str.equals("Double") || str.equals("Float") || str.equals("Long") || str.equals("Short") || str.equals("Char")) {
            return true;
        }
        return false;
    }

    public static String java2UniType(String str) {
        if (!str.equals("java.lang.Integer") && !str.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
            if (!str.equals("java.lang.Boolean") && !str.equals(HippyControllerProps.BOOLEAN)) {
                if (!str.equals("java.lang.Byte") && !str.equals("byte")) {
                    String str2 = "double";
                    if (!str.equals("java.lang.Double") && !str.equals("double")) {
                        str2 = "float";
                        if (!str.equals("java.lang.Float") && !str.equals("float")) {
                            if (!str.equals("java.lang.Long") && !str.equals(PoiListCacheRecord.TIMESTAMP_TYPE)) {
                                if (str.equals("java.lang.Short") || str.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
                                    return Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT;
                                }
                                if (!str.equals("java.lang.Character")) {
                                    if (str.equals("java.lang.String")) {
                                        return HippyControllerProps.STRING;
                                    }
                                    if (str.equals("java.util.List")) {
                                        return "list";
                                    }
                                    if (str.equals("java.util.Map")) {
                                        return "map";
                                    }
                                    return str;
                                }
                                throw new IllegalArgumentException("can not support java.lang.Character");
                            }
                            return "int64";
                        }
                    }
                    return str2;
                }
                return WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR;
            }
            return "bool";
        }
        return "int32";
    }

    public static void main(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR);
        arrayList.add("list<char>");
        arrayList.add("list<list<char>>");
        arrayList.add("map<short,string>");
        arrayList.add("map<double,map<float,list<bool>>>");
        arrayList.add("map<int64,list<Test.UserInfo>>");
        arrayList.add("map<short,Test.FriendInfo>");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ArrayList<String> typeList = getTypeList((String) it.next());
            Iterator<String> it5 = typeList.iterator();
            while (it5.hasNext()) {
                System.out.println(it5.next());
            }
            Collections.reverse(typeList);
            System.out.println("-------------finished " + transTypeList(typeList));
        }
    }

    public static void setClassLoader(boolean z16, ClassLoader classLoader2) {
        classLoaderInitialize = z16;
        classLoader = classLoader2;
    }

    public static String transTypeList(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList.set(i3, java2UniType(arrayList.get(i3)));
        }
        Collections.reverse(arrayList);
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            String str = arrayList.get(i16);
            if (str.equals("list")) {
                int i17 = i16 - 1;
                arrayList.set(i17, "<" + arrayList.get(i17));
                arrayList.set(0, arrayList.get(0) + ">");
            } else if (str.equals("map")) {
                int i18 = i16 - 1;
                arrayList.set(i18, "<" + arrayList.get(i18) + ",");
                StringBuilder sb5 = new StringBuilder();
                sb5.append(arrayList.get(0));
                sb5.append(">");
                arrayList.set(0, sb5.toString());
            } else if (str.equals(Entry.DATA_TYPE_Array)) {
                int i19 = i16 - 1;
                arrayList.set(i19, "<" + arrayList.get(i19));
                arrayList.set(0, arrayList.get(0) + ">");
            }
        }
        Collections.reverse(arrayList);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
        }
        return stringBuffer.toString();
    }

    public static String uni2JavaType(String str) {
        if (str.equals("int32")) {
            return "java.lang.Integer";
        }
        if (str.equals("bool")) {
            return "java.lang.Boolean";
        }
        if (str.equals(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR)) {
            return "java.lang.Byte";
        }
        if (str.equals("double")) {
            return "java.lang.Double";
        }
        if (str.equals("float")) {
            return "java.lang.Float";
        }
        if (str.equals("int64")) {
            return "java.lang.Long";
        }
        if (str.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
            return "java.lang.Short";
        }
        if (str.equals(HippyControllerProps.STRING)) {
            return "java.lang.String";
        }
        if (str.equals("list")) {
            return "java.util.List";
        }
        if (str.equals("map")) {
            return "java.util.Map";
        }
        return str;
    }
}
