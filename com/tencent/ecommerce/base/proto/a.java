package com.tencent.ecommerce.base.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFixed64Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBPrimitiveField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSFixed32Field;
import com.tencent.mobileqq.pb.PBSFixed64Field;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBSInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {
    private static void a(JSONObject jSONObject, Object obj, String str) {
        try {
            if (!(obj instanceof PBUInt64Field) && !(obj instanceof PBFixed64Field) && !(obj instanceof PBSInt64Field) && !(obj instanceof PBSFixed64Field) && !(obj instanceof PBInt64Field)) {
                if (!(obj instanceof PBUInt32Field) && !(obj instanceof PBFixed32Field) && !(obj instanceof PBInt32Field) && !(obj instanceof PBSInt32Field) && !(obj instanceof PBSFixed32Field) && !(obj instanceof PBEnumField)) {
                    if (obj instanceof PBDoubleField) {
                        ((PBDoubleField) obj).set(jSONObject.optDouble(str));
                        return;
                    }
                    if (obj instanceof PBFloatField) {
                        ((PBFloatField) obj).set((float) jSONObject.optDouble(str));
                        return;
                    } else if (obj instanceof PBStringField) {
                        ((PBStringField) obj).set(jSONObject.optString(str));
                        return;
                    } else {
                        if (obj instanceof PBBoolField) {
                            ((PBBoolField) obj).set(jSONObject.optBoolean(str));
                            return;
                        }
                        return;
                    }
                }
                obj.getClass().getMethod("set", Integer.TYPE).invoke(obj, Integer.valueOf(jSONObject.optInt(str)));
                return;
            }
            obj.getClass().getMethod("set", Long.TYPE).invoke(obj, Long.valueOf(jSONObject.optLong(str)));
        } catch (IllegalAccessException e16) {
            cg0.a.b("Proto2JsonUtil", "fillBasicField IllegalAccessException " + e16);
        } catch (NoSuchMethodException e17) {
            cg0.a.b("Proto2JsonUtil", "fillBasicField NoSuchMethodException " + e17);
        } catch (InvocationTargetException e18) {
            cg0.a.b("Proto2JsonUtil", "fillBasicField InvocationTargetException " + e18);
        }
    }

    private static void b(JSONObject jSONObject, Field field, Object obj) {
        try {
            Object obj2 = field.get(obj);
            String name = field.getName();
            if (m(obj2)) {
                c(jSONObject, obj2, name);
                return;
            }
            if (o(obj2)) {
                d(jSONObject, obj2, name);
                return;
            }
            if (p(obj2)) {
                e(jSONObject, obj2, name);
            } else if (j(obj2)) {
                a(jSONObject, obj2, name);
            } else if (n(obj2)) {
                ((PBBytesField) obj2).set(ByteStringMicro.copyFrom(jSONObject.optString(name).getBytes(StandardCharsets.ISO_8859_1)));
            }
        } catch (IllegalAccessException e16) {
            cg0.a.a("Proto2JsonUtil", "fillField", "fillField error : " + e16);
        }
    }

    private static void c(JSONObject jSONObject, Object obj, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return;
        }
        q(optJSONObject, (MessageMicro) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void d(JSONObject jSONObject, Object obj, String str) {
        Object opt;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return;
        }
        PBRepeatField pBRepeatField = (PBRepeatField) obj;
        for (int i3 = 0; i3 < optJSONArray.length() && (opt = optJSONArray.opt(i3)) != null; i3++) {
            pBRepeatField.add(opt);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T extends MessageMicro<T>> void e(JSONObject jSONObject, Object obj, String str) {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return;
        }
        PBRepeatMessageField pBRepeatMessageField = (PBRepeatMessageField) obj;
        Field h16 = h(PBRepeatMessageField.class, "helper");
        if (h16 == null) {
            return;
        }
        try {
            Class cls = (Class) h16.get(pBRepeatMessageField);
            for (int i3 = 0; i3 < optJSONArray.length() && (optJSONObject = optJSONArray.optJSONObject(i3)) != null && cls != null; i3++) {
                MessageMicro messageMicro = (MessageMicro) cls.newInstance();
                q(optJSONObject, messageMicro);
                pBRepeatMessageField.add(messageMicro);
            }
        } catch (IllegalAccessException e16) {
            cg0.a.b("Proto2JsonUtil", "fillPBRepeatMessage IllegalAccessException : " + e16);
        } catch (InstantiationException e17) {
            cg0.a.b("Proto2JsonUtil", "fillPBRepeatMessage InstantiationException : " + e17);
        }
    }

    private static Object f(Object obj) {
        if (j(obj)) {
            return g(obj);
        }
        if (m(obj)) {
            return s((MessageMicro) obj);
        }
        if (n(obj)) {
            return new String(((PBBytesField) obj).get().toByteArray(), StandardCharsets.ISO_8859_1);
        }
        if (l(obj)) {
            return ((ByteStringMicro) obj).toStringUtf8();
        }
        if (p(obj)) {
            return t(((PBRepeatMessageField) obj).get());
        }
        if (o(obj)) {
            return r(((PBRepeatField) obj).get());
        }
        if (k(obj)) {
            return obj;
        }
        return null;
    }

    private static Object g(Object obj) {
        try {
            return obj.getClass().getMethod("get", new Class[0]).invoke(obj, new Object[0]);
        } catch (IllegalAccessException e16) {
            cg0.a.a("Proto2JsonUtil", "getBasicPbValue", "fValue " + obj + " getBasicPbValue IllegalAccessException " + e16);
            return null;
        } catch (NoSuchMethodException e17) {
            cg0.a.a("Proto2JsonUtil", "getBasicPbValue", "fValue " + obj + " getBasicPbValue NoSuchMethodException " + e17);
            return null;
        } catch (InvocationTargetException e18) {
            cg0.a.a("Proto2JsonUtil", "getBasicPbValue", "fValue " + obj + " getBasicPbValue InvocationTargetException " + e18);
            return null;
        }
    }

    private static Field h(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Object i(Field field, Object obj) {
        try {
            if (field == null) {
                cg0.a.a("Proto2JsonUtil", "getValueFromField", "getValueFromField f is null");
                return null;
            }
            Object obj2 = field.get(obj);
            if (obj2 == null) {
                cg0.a.a("Proto2JsonUtil", "getValueFromField", "getValueFromField fValue is null");
                return null;
            }
            if (!(obj2 instanceof PBPrimitiveField) || ((PBPrimitiveField) obj2).has()) {
                return f(obj2);
            }
            return null;
        } catch (IllegalAccessException e16) {
            cg0.a.a("Proto2JsonUtil", "getValueFromField", "getValueFromField IllegalAccessException, " + e16);
            return null;
        }
    }

    private static boolean j(Object obj) {
        return (!(obj instanceof PBPrimitiveField) || (obj instanceof MessageMicro) || (obj instanceof PBBytesField)) ? false : true;
    }

    private static boolean k(Object obj) {
        return (obj instanceof String) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte) || (obj instanceof Boolean) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Character);
    }

    private static boolean l(Object obj) {
        return obj instanceof ByteStringMicro;
    }

    private static boolean m(Object obj) {
        return obj instanceof MessageMicro;
    }

    private static boolean n(Object obj) {
        return obj instanceof PBBytesField;
    }

    private static boolean o(Object obj) {
        return obj instanceof PBRepeatField;
    }

    private static boolean p(Object obj) {
        return obj instanceof PBRepeatMessageField;
    }

    public static boolean q(JSONObject jSONObject, MessageMicro<?> messageMicro) {
        if (jSONObject == null) {
            cg0.a.a("Proto2JsonUtil", "jsonObj2Pb", "jsonObj2Pb json obj is null");
            return false;
        }
        try {
            Field[] fields = messageMicro.getClass().getFields();
            if (fields.length == 0) {
                cg0.a.b("Proto2JsonUtil", "proto2Json, pb fields length is 0");
                return false;
            }
            for (Field field : fields) {
                b(jSONObject, field, messageMicro);
            }
            return true;
        } catch (Exception e16) {
            cg0.a.a("Proto2JsonUtil", "jsonObj2Pb", "json2Pb JSONException : " + e16);
            return false;
        }
    }

    public static JSONObject s(MessageMicro<?> messageMicro) {
        Field[] fields = messageMicro.getClass().getFields();
        if (fields.length == 0) {
            cg0.a.b("Proto2JsonUtil", "proto2Json, pb fields length is 0");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Field field : fields) {
                jSONObject.put(field.getName(), i(field, messageMicro));
            }
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("Proto2JsonUtil", "proto2JsonObj", "proto2Json error : " + e16);
            return null;
        }
    }

    private static JSONArray r(List<?> list) {
        if (list == null) {
            cg0.a.a("Proto2JsonUtil", "objList2String", "protoList2String, list is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (list.size() == 0) {
            return jSONArray;
        }
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(f(it.next()));
        }
        return jSONArray;
    }

    private static JSONArray t(List<? extends MessageMicro<?>> list) {
        if (list == null) {
            cg0.a.a("Proto2JsonUtil", "protoList2String", "protoList2String, list is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (list.size() == 0) {
            return jSONArray;
        }
        Iterator<? extends MessageMicro<?>> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(s(it.next()));
        }
        return jSONArray;
    }
}
