package com.tencent.bugly.proguard;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class a {
    public static String a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = 0;
        while (true) {
            String str = "map";
            if (i3 < arrayList.size()) {
                String str2 = arrayList.get(i3);
                if (!str2.equals("java.lang.Integer") && !str2.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
                    if (!str2.equals("java.lang.Boolean") && !str2.equals(HippyControllerProps.BOOLEAN)) {
                        if (!str2.equals("java.lang.Byte") && !str2.equals("byte")) {
                            String str3 = "double";
                            if (!str2.equals("java.lang.Double") && !str2.equals("double")) {
                                str3 = "float";
                                if (!str2.equals("java.lang.Float") && !str2.equals("float")) {
                                    if (!str2.equals("java.lang.Long") && !str2.equals(PoiListCacheRecord.TIMESTAMP_TYPE)) {
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
                                    } else {
                                        str = "int64";
                                    }
                                }
                            }
                            str = str3;
                        } else {
                            str = WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR;
                        }
                    } else {
                        str = "bool";
                    }
                } else {
                    str = "int32";
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
}
