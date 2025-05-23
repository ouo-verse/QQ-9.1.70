package com.tencent.mapsdk.internal;

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
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static ClassLoader f147665a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f147666b = true;

    private static void a(boolean z16, ClassLoader classLoader) {
        f147666b = z16;
        f147665a = classLoader;
    }

    private static Object b(String str, boolean z16, ClassLoader classLoader) throws b {
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
                if (classLoader != null) {
                    cls = Class.forName(str, z16, classLoader);
                } else {
                    ClassLoader classLoader2 = f147665a;
                    if (classLoader2 != null) {
                        cls = Class.forName(str, f147666b, classLoader2);
                    } else {
                        cls = Class.forName(str);
                    }
                }
                return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e16) {
                e16.printStackTrace();
                throw new b(e16);
            }
        }
        throw new IllegalArgumentException("can not support java.lang.Character");
    }

    private static String c(String str) {
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

    private static boolean d(String str) {
        if (str.equals(PoiListCacheRecord.WEIGHT_TYPE) || str.equals(HippyControllerProps.BOOLEAN) || str.equals("byte") || str.equals("double") || str.equals("float") || str.equals(PoiListCacheRecord.TIMESTAMP_TYPE) || str.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT) || str.equals(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR) || str.equals("Integer") || str.equals("Boolean") || str.equals("Byte") || str.equals("Double") || str.equals("Float") || str.equals("Long") || str.equals("Short") || str.equals("Char")) {
            return true;
        }
        return false;
    }

    private static String e(String str) {
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

    private static void a(ArrayList<String> arrayList, String str) {
        int length = str.length();
        while (str.charAt(length - 1) == '>' && length - 1 != 0) {
        }
        String substring = str.substring(0, length);
        if (substring.equals("int32")) {
            substring = "java.lang.Integer";
        } else if (substring.equals("bool")) {
            substring = "java.lang.Boolean";
        } else if (substring.equals(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR)) {
            substring = "java.lang.Byte";
        } else if (substring.equals("double")) {
            substring = "java.lang.Double";
        } else if (substring.equals("float")) {
            substring = "java.lang.Float";
        } else if (substring.equals("int64")) {
            substring = "java.lang.Long";
        } else if (substring.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
            substring = "java.lang.Short";
        } else if (substring.equals(HippyControllerProps.STRING)) {
            substring = "java.lang.String";
        } else if (substring.equals("list")) {
            substring = "java.util.List";
        } else if (substring.equals("map")) {
            substring = "java.util.Map";
        }
        arrayList.add(0, substring);
    }

    private static ArrayList<String> a(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        int indexOf = str.indexOf("<");
        int i3 = 0;
        while (i3 < indexOf) {
            a(arrayList, str.substring(i3, indexOf));
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
        a(arrayList, str.substring(i3, str.length()));
        return arrayList;
    }

    public static String a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = 0;
        while (true) {
            String str = "map";
            if (i3 < arrayList.size()) {
                String str2 = arrayList.get(i3);
                if (str2.equals("java.lang.Integer") || str2.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
                    str = "int32";
                } else if (str2.equals("java.lang.Boolean") || str2.equals(HippyControllerProps.BOOLEAN)) {
                    str = "bool";
                } else if (str2.equals("java.lang.Byte") || str2.equals("byte")) {
                    str = WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR;
                } else {
                    String str3 = "double";
                    if (!str2.equals("java.lang.Double") && !str2.equals("double")) {
                        str3 = "float";
                        if (!str2.equals("java.lang.Float") && !str2.equals("float")) {
                            if (str2.equals("java.lang.Long") || str2.equals(PoiListCacheRecord.TIMESTAMP_TYPE)) {
                                str = "int64";
                            } else {
                                boolean equals = str2.equals("java.lang.Short");
                                str3 = Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT;
                                if (!equals && !str2.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
                                    if (!str2.equals("java.lang.Character")) {
                                        if (str2.equals("java.lang.String")) {
                                            str = HippyControllerProps.STRING;
                                        } else if (str2.equals("java.util.List")) {
                                            str = "list";
                                        } else if (!str2.equals("java.util.Map")) {
                                            str = str2;
                                        }
                                    } else {
                                        throw new IllegalArgumentException("can not support java.lang.Character");
                                    }
                                }
                            }
                        }
                    }
                    str = str3;
                }
                arrayList.set(i3, str);
                i3++;
            } else {
                Collections.reverse(arrayList);
                for (int i16 = 0; i16 < arrayList.size(); i16++) {
                    String str4 = arrayList.get(i16);
                    if (str4.equals("list")) {
                        int i17 = i16 - 1;
                        arrayList.set(i17, "<" + arrayList.get(i17));
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str4.equals("map")) {
                        int i18 = i16 - 1;
                        arrayList.set(i18, "<" + arrayList.get(i18) + ",");
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str4.equals(Entry.DATA_TYPE_Array)) {
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
        }
    }

    private static String b(String str) {
        if (str.equals("java.lang.Integer") || str.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
            return "int32";
        }
        if (str.equals("java.lang.Boolean") || str.equals(HippyControllerProps.BOOLEAN)) {
            return "bool";
        }
        if (str.equals("java.lang.Byte") || str.equals("byte")) {
            return WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR;
        }
        String str2 = "double";
        if (!str.equals("java.lang.Double") && !str.equals("double")) {
            str2 = "float";
            if (!str.equals("java.lang.Float") && !str.equals("float")) {
                if (str.equals("java.lang.Long") || str.equals(PoiListCacheRecord.TIMESTAMP_TYPE)) {
                    return "int64";
                }
                if (str.equals("java.lang.Short") || str.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
                    return Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT;
                }
                if (str.equals("java.lang.Character")) {
                    throw new IllegalArgumentException("can not support java.lang.Character");
                }
                return str.equals("java.lang.String") ? HippyControllerProps.STRING : str.equals("java.util.List") ? "list" : str.equals("java.util.Map") ? "map" : str;
            }
        }
        return str2;
    }

    private static String a(String str, String str2) {
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

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ad, code lost:
    
        if (r2 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0076, code lost:
    
        r4 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00af, code lost:
    
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0073, code lost:
    
        if (r2 == null) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object a(String str, boolean z16, ClassLoader classLoader) throws b {
        ArrayList arrayList = new ArrayList();
        int indexOf = str.indexOf("<");
        int i3 = 0;
        while (i3 < indexOf) {
            a((ArrayList<String>) arrayList, str.substring(i3, indexOf));
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
        a((ArrayList<String>) arrayList, str.substring(i3, str.length()));
        Iterator it = arrayList.iterator();
        Object obj = null;
        Object obj2 = null;
        while (true) {
            Object obj3 = obj2;
            while (it.hasNext()) {
                obj = b((String) it.next(), z16, classLoader);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (Entry.DATA_TYPE_Array.equals(str2)) {
                        if (obj2 == null) {
                            obj = Array.newInstance((Class<?>) Byte.class, 0);
                        }
                    } else if (QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER.equals(str2)) {
                    }
                } else {
                    if (obj instanceof List) {
                        if (obj2 == null || !(obj2 instanceof Byte)) {
                            if (obj2 != null) {
                                ((List) obj).add(obj2);
                            }
                            obj2 = null;
                        } else {
                            obj = Array.newInstance((Class<?>) Byte.class, 1);
                            Array.set(obj, 0, obj2);
                        }
                    } else if (obj instanceof Map) {
                        if ((obj2 != null) & (obj3 != null)) {
                            ((Map) obj).put(obj2, obj3);
                        }
                        obj2 = null;
                    }
                }
            }
            return obj;
        }
    }
}
