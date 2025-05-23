package com.xingin.xhssharesdk.a;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.xingin.xhssharesdk.a.h;
import com.xingin.xhssharesdk.a.k;
import com.xingin.xhssharesdk.a.p;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class n {
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0163, code lost:
    
        if (((java.lang.Integer) r10).intValue() == 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01b8, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0174, code lost:
    
        if (((java.lang.Float) r10).floatValue() == 0.0f) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0186, code lost:
    
        if (((java.lang.Double) r10).doubleValue() == 0.0d) goto L73;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(l lVar, StringBuilder sb5, int i3) {
        Iterator it;
        boolean equals;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        for (Method method : lVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        Iterator it5 = treeSet.iterator();
        while (it5.hasNext()) {
            String replaceFirst = ((String) it5.next()).replaceFirst("get", "");
            boolean z16 = true;
            if (replaceFirst.endsWith("List") && !replaceFirst.endsWith("OrBuilderList")) {
                String str = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1, replaceFirst.length() - 4);
                Method method2 = (Method) hashMap.get("get".concat(replaceFirst));
                if (method2 != null) {
                    StringBuilder sb6 = new StringBuilder();
                    for (int i16 = 0; i16 < str.length(); i16++) {
                        char charAt = str.charAt(i16);
                        if (Character.isUpperCase(charAt)) {
                            sb6.append("_");
                        }
                        sb6.append(Character.toLowerCase(charAt));
                    }
                    b(sb5, i3, sb6.toString(), k.d(method2, lVar, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set".concat(replaceFirst))) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    if (hashMap.containsKey("get" + replaceFirst.substring(0, replaceFirst.length() - 5))) {
                    }
                }
                String str2 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1);
                Method method3 = (Method) hashMap.get("get".concat(replaceFirst));
                Method method4 = (Method) hashMap.get("has".concat(replaceFirst));
                if (method3 != null) {
                    Object d16 = k.d(method3, lVar, new Object[0]);
                    if (method4 == null) {
                        if (d16 instanceof Boolean) {
                            equals = !((Boolean) d16).booleanValue();
                        } else if (!(d16 instanceof Integer)) {
                            if (!(d16 instanceof Float)) {
                                if (!(d16 instanceof Double)) {
                                    if (d16 instanceof String) {
                                        equals = d16.equals("");
                                    } else if (d16 instanceof e) {
                                        equals = d16.equals(e.f389907b);
                                    } else {
                                        equals = !(d16 instanceof l) ? false : false;
                                    }
                                }
                            }
                        }
                        if (equals) {
                            z16 = false;
                        }
                    } else {
                        z16 = ((Boolean) k.d(method4, lVar, new Object[0])).booleanValue();
                    }
                    if (z16) {
                        StringBuilder sb7 = new StringBuilder();
                        for (int i17 = 0; i17 < str2.length(); i17++) {
                            char charAt2 = str2.charAt(i17);
                            if (Character.isUpperCase(charAt2)) {
                                sb7.append("_");
                            }
                            sb7.append(Character.toLowerCase(charAt2));
                        }
                        b(sb5, i3, sb7.toString(), d16);
                    }
                }
            }
        }
        if (lVar instanceof k.d) {
            d<k.e> dVar = ((k.d) lVar).f389942h;
            if (dVar.f389906c) {
                it = new h.b(((p.d) dVar.f389904a.entrySet()).iterator());
            } else {
                it = ((p.d) dVar.f389904a.entrySet()).iterator();
            }
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                ((k.e) entry.getKey()).getClass();
                b(sb5, i3, "[0]", entry.getValue());
            }
        }
        nz4.i iVar = ((k) lVar).f389934e;
        if (iVar != null) {
            for (int i18 = 0; i18 < iVar.f421650a; i18++) {
                b(sb5, i3, String.valueOf(iVar.f421651b[i18] >>> 3), iVar.f421652c[i18]);
            }
        }
    }

    public static final void b(StringBuilder sb5, int i3, String str, Object obj) {
        String obj2;
        String a16;
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                b(sb5, i3, str, it.next());
            }
            return;
        }
        sb5.append('\n');
        for (int i16 = 0; i16 < i3; i16++) {
            sb5.append(TokenParser.SP);
        }
        sb5.append(str);
        if (obj instanceof String) {
            sb5.append(": \"");
            a16 = nz4.h.a(e.a((String) obj));
        } else if (obj instanceof e) {
            sb5.append(": \"");
            a16 = nz4.h.a((e) obj);
        } else {
            if (obj instanceof k) {
                sb5.append(" {");
                a((k) obj, sb5, i3 + 2);
                sb5.append("\n");
                for (int i17 = 0; i17 < i3; i17++) {
                    sb5.append(TokenParser.SP);
                }
                obj2 = "}";
            } else {
                sb5.append(MsgSummary.STR_COLON);
                obj2 = obj.toString();
            }
            sb5.append(obj2);
            return;
        }
        sb5.append(a16);
        sb5.append('\"');
    }
}
