package com.google.protobuf.nano;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import oicq.wlogin_sdk.tools.util;

/* loaded from: classes2.dex */
public final class MessageNanoPrinter {
    private static final String INDENT = "  ";
    private static final int MAX_STRING_LEN = 200;

    MessageNanoPrinter() {
    }

    private static void appendQuotedBytes(byte[] bArr, StringBuffer stringBuffer) {
        if (bArr == null) {
            stringBuffer.append("\"\"");
            return;
        }
        stringBuffer.append('\"');
        for (byte b16 : bArr) {
            int i3 = b16 & 255;
            if (i3 != 92 && i3 != 34) {
                if (i3 >= 32 && i3 < 127) {
                    stringBuffer.append((char) i3);
                } else {
                    stringBuffer.append(String.format("\\%03o", Integer.valueOf(i3)));
                }
            } else {
                stringBuffer.append('\\');
                stringBuffer.append((char) i3);
            }
        }
        stringBuffer.append('\"');
    }

    private static String deCamelCaseify(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (i3 == 0) {
                stringBuffer.append(Character.toLowerCase(charAt));
            } else if (Character.isUpperCase(charAt)) {
                stringBuffer.append(util.base64_pad_url);
                stringBuffer.append(Character.toLowerCase(charAt));
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    private static String escapeString(String str) {
        int length = str.length();
        StringBuilder sb5 = new StringBuilder(length);
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt >= ' ' && charAt <= '~' && charAt != '\"' && charAt != '\'') {
                sb5.append(charAt);
            } else {
                sb5.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            }
        }
        return sb5.toString();
    }

    public static <T extends MessageNano> String print(T t16) {
        if (t16 == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            print(null, t16, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e16) {
            return "Error printing proto: " + e16.getMessage();
        } catch (InvocationTargetException e17) {
            return "Error printing proto: " + e17.getMessage();
        }
    }

    private static String sanitizeString(String str) {
        if (!str.startsWith("http") && str.length() > 200) {
            str = str.substring(0, 200) + "[...]";
        }
        return escapeString(str);
    }

    private static void print(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException, InvocationTargetException {
        if (obj == null) {
            return;
        }
        if (obj instanceof MessageNano) {
            int length = stringBuffer.length();
            if (str != null) {
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(deCamelCaseify(str));
                stringBuffer2.append(" <\n");
                stringBuffer.append(INDENT);
            }
            Class<?> cls = obj.getClass();
            for (Field field : cls.getFields()) {
                int modifiers = field.getModifiers();
                String name = field.getName();
                if (!"cachedSize".equals(name) && (modifiers & 1) == 1 && (modifiers & 8) != 8 && !name.startsWith("_") && !name.endsWith("_")) {
                    Class<?> type = field.getType();
                    Object obj2 = field.get(obj);
                    if (type.isArray()) {
                        if (type.getComponentType() == Byte.TYPE) {
                            print(name, obj2, stringBuffer, stringBuffer2);
                        } else {
                            int length2 = obj2 == null ? 0 : Array.getLength(obj2);
                            for (int i3 = 0; i3 < length2; i3++) {
                                print(name, Array.get(obj2, i3), stringBuffer, stringBuffer2);
                            }
                        }
                    } else {
                        print(name, obj2, stringBuffer, stringBuffer2);
                    }
                }
            }
            for (Method method : cls.getMethods()) {
                String name2 = method.getName();
                if (name2.startsWith("set")) {
                    String substring = name2.substring(3);
                    try {
                        if (((Boolean) cls.getMethod("has" + substring, new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                            print(substring, cls.getMethod("get" + substring, new Class[0]).invoke(obj, new Object[0]), stringBuffer, stringBuffer2);
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                }
            }
            if (str != null) {
                stringBuffer.setLength(length);
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(">\n");
                return;
            }
            return;
        }
        if (obj instanceof Map) {
            String deCamelCaseify = deCamelCaseify(str);
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(deCamelCaseify);
                stringBuffer2.append(" <\n");
                int length3 = stringBuffer.length();
                stringBuffer.append(INDENT);
                print("key", entry.getKey(), stringBuffer, stringBuffer2);
                print("value", entry.getValue(), stringBuffer, stringBuffer2);
                stringBuffer.setLength(length3);
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(">\n");
            }
            return;
        }
        String deCamelCaseify2 = deCamelCaseify(str);
        stringBuffer2.append(stringBuffer);
        stringBuffer2.append(deCamelCaseify2);
        stringBuffer2.append(MsgSummary.STR_COLON);
        if (obj instanceof String) {
            String sanitizeString = sanitizeString((String) obj);
            stringBuffer2.append("\"");
            stringBuffer2.append(sanitizeString);
            stringBuffer2.append("\"");
        } else if (obj instanceof byte[]) {
            appendQuotedBytes((byte[]) obj, stringBuffer2);
        } else {
            stringBuffer2.append(obj);
        }
        stringBuffer2.append("\n");
    }
}
