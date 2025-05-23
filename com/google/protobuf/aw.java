package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.httpcore.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class aw {
    private static final String a(String str) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (Character.isUpperCase(charAt)) {
                sb5.append("_");
            }
            sb5.append(Character.toLowerCase(charAt));
        }
        return sb5.toString();
    }

    private static boolean b(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return true;
            }
            return false;
        }
        if (obj instanceof Float) {
            if (((Float) obj).floatValue() == 0.0f) {
                return true;
            }
            return false;
        }
        if (obj instanceof Double) {
            if (((Double) obj).doubleValue() == 0.0d) {
                return true;
            }
            return false;
        }
        if (obj instanceof String) {
            return obj.equals("");
        }
        if (obj instanceof ByteString) {
            return obj.equals(ByteString.EMPTY);
        }
        if (obj instanceof au) {
            if (obj == ((au) obj).getDefaultInstanceForType()) {
                return true;
            }
            return false;
        }
        if ((obj instanceof Enum) && ((Enum) obj).ordinal() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void c(StringBuilder sb5, int i3, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                c(sb5, i3, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it5 = ((Map) obj).entrySet().iterator();
            while (it5.hasNext()) {
                c(sb5, i3, str, (Map.Entry) it5.next());
            }
            return;
        }
        sb5.append('\n');
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            sb5.append(TokenParser.SP);
        }
        sb5.append(str);
        if (obj instanceof String) {
            sb5.append(": \"");
            sb5.append(bx.e((String) obj));
            sb5.append('\"');
            return;
        }
        if (obj instanceof ByteString) {
            sb5.append(": \"");
            sb5.append(bx.a((ByteString) obj));
            sb5.append('\"');
            return;
        }
        if (obj instanceof GeneratedMessageLite) {
            sb5.append(" {");
            d((GeneratedMessageLite) obj, sb5, i3 + 2);
            sb5.append("\n");
            while (i16 < i3) {
                sb5.append(TokenParser.SP);
                i16++;
            }
            sb5.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb5.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i18 = i3 + 2;
            c(sb5, i18, "key", entry.getKey());
            c(sb5, i18, "value", entry.getValue());
            sb5.append("\n");
            while (i16 < i3) {
                sb5.append(TokenParser.SP);
                i16++;
            }
            sb5.append("}");
            return;
        }
        sb5.append(MsgSummary.STR_COLON);
        sb5.append(obj.toString());
    }

    private static void d(au auVar, StringBuilder sb5, int i3) {
        String str;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : auVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str2 : treeSet) {
            if (str2.startsWith("get")) {
                str = str2.substring(3);
            } else {
                str = str2;
            }
            boolean z16 = true;
            if (str.endsWith("List") && !str.endsWith("OrBuilderList") && !str.equals("List")) {
                String str3 = str.substring(0, 1).toLowerCase() + str.substring(1, str.length() - 4);
                Method method2 = (Method) hashMap.get(str2);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    c(sb5, i3, a(str3), GeneratedMessageLite.invokeOrDie(method2, auVar, new Object[0]));
                }
            }
            if (str.endsWith("Map") && !str.equals("Map")) {
                String str4 = str.substring(0, 1).toLowerCase() + str.substring(1, str.length() - 3);
                Method method3 = (Method) hashMap.get(str2);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    c(sb5, i3, a(str4), GeneratedMessageLite.invokeOrDie(method3, auVar, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + str)) != null) {
                if (str.endsWith("Bytes")) {
                    if (hashMap.containsKey("get" + str.substring(0, str.length() - 5))) {
                    }
                }
                String str5 = str.substring(0, 1).toLowerCase() + str.substring(1);
                Method method4 = (Method) hashMap.get("get" + str);
                Method method5 = (Method) hashMap.get("has" + str);
                if (method4 != null) {
                    Object invokeOrDie = GeneratedMessageLite.invokeOrDie(method4, auVar, new Object[0]);
                    if (method5 == null) {
                        if (b(invokeOrDie)) {
                            z16 = false;
                        }
                    } else {
                        z16 = ((Boolean) GeneratedMessageLite.invokeOrDie(method5, auVar, new Object[0])).booleanValue();
                    }
                    if (z16) {
                        c(sb5, i3, a(str5), invokeOrDie);
                    }
                }
            }
        }
        if (auVar instanceof GeneratedMessageLite.c) {
            Iterator<Map.Entry<GeneratedMessageLite.d, Object>> F = ((GeneratedMessageLite.c) auVar).f35494d.F();
            while (F.hasNext()) {
                Map.Entry<GeneratedMessageLite.d, Object> next = F.next();
                c(sb5, i3, "[" + next.getKey().getNumber() + "]", next.getValue());
            }
        }
        cd cdVar = ((GeneratedMessageLite) auVar).unknownFields;
        if (cdVar != null) {
            cdVar.q(sb5, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(au auVar, String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("# ");
        sb5.append(str);
        d(auVar, sb5, 0);
        return sb5.toString();
    }
}
