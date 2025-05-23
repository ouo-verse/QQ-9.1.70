package com.tencent.mobileqq.app.identity;

import android.text.TextUtils;
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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class Proto2JsonUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Proto2JsonUtil";

    public Proto2JsonUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void fillBasicField(JSONObject jSONObject, Object obj, String str) {
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
            QLog.d(TAG, 1, "fillBasicField IllegalAccessException ", e16);
        } catch (NoSuchMethodException e17) {
            QLog.d(TAG, 1, "fillBasicField NoSuchMethodException ", e17);
        } catch (InvocationTargetException e18) {
            QLog.d(TAG, 1, "fillBasicField InvocationTargetException ", e18);
        }
    }

    private static void fillField(JSONObject jSONObject, Field field, Object obj) {
        try {
            Object obj2 = field.get(obj);
            String name = field.getName();
            if (isMessageMicro(obj2)) {
                fillMessageMicro(jSONObject, obj2, name);
                return;
            }
            if (isPBRepeatField(obj2)) {
                fillPBRepeatField(jSONObject, obj2, name);
                return;
            }
            if (isPBRepeatMessageField(obj2)) {
                fillPBRepeatMessage(jSONObject, obj2, name);
            } else if (isBasicType(obj2)) {
                fillBasicField(jSONObject, obj2, name);
            } else if (isPBByteField(obj2)) {
                ((PBBytesField) obj2).set(ByteStringMicro.copyFrom(jSONObject.optString(name).getBytes(StandardCharsets.ISO_8859_1)));
            }
        } catch (IllegalAccessException e16) {
            QLog.e(TAG, 1, "fillField error : ", e16);
        }
    }

    private static void fillMessageMicro(JSONObject jSONObject, Object obj, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return;
        }
        jsonObj2Pb(optJSONObject, (MessageMicro) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void fillPBRepeatField(JSONObject jSONObject, Object obj, String str) {
        Object opt;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null && optJSONArray.length() != 0) {
            PBRepeatField pBRepeatField = (PBRepeatField) obj;
            for (int i3 = 0; i3 < optJSONArray.length() && (opt = optJSONArray.opt(i3)) != null; i3++) {
                pBRepeatField.add(opt);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T extends MessageMicro<T>> void fillPBRepeatMessage(JSONObject jSONObject, Object obj, String str) {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null && optJSONArray.length() != 0) {
            PBRepeatMessageField pBRepeatMessageField = (PBRepeatMessageField) obj;
            Field privateField = getPrivateField(PBRepeatMessageField.class, "helper");
            if (privateField == null) {
                return;
            }
            try {
                Class cls = (Class) privateField.get(pBRepeatMessageField);
                for (int i3 = 0; i3 < optJSONArray.length() && (optJSONObject = optJSONArray.optJSONObject(i3)) != null && cls != null; i3++) {
                    MessageMicro messageMicro = (MessageMicro) cls.newInstance();
                    jsonObj2Pb(optJSONObject, messageMicro);
                    pBRepeatMessageField.add(messageMicro);
                }
            } catch (IllegalAccessException e16) {
                QLog.d(TAG, 1, "fillPBRepeatMessage IllegalAccessException : ", e16);
            } catch (InstantiationException e17) {
                QLog.d(TAG, 1, "fillPBRepeatMessage InstantiationException : ", e17);
            }
        }
    }

    private static Object formatObj2JsonData(Object obj) {
        if (isBasicType(obj)) {
            return getBasicPbValue(obj);
        }
        if (isMessageMicro(obj)) {
            return proto2JsonObj((MessageMicro) obj);
        }
        if (isPBByteField(obj)) {
            return new String(((PBBytesField) obj).get().toByteArray(), StandardCharsets.ISO_8859_1);
        }
        if (isByteStringMicro(obj)) {
            return ((ByteStringMicro) obj).toStringUtf8();
        }
        if (isPBRepeatMessageField(obj)) {
            return protoList2String(((PBRepeatMessageField) obj).get());
        }
        if (isPBRepeatField(obj)) {
            return objList2String(((PBRepeatField) obj).get());
        }
        if (isBasicValue(obj)) {
            return obj;
        }
        return null;
    }

    private static Object getBasicPbValue(Object obj) {
        try {
            return obj.getClass().getMethod("get", new Class[0]).invoke(obj, new Object[0]);
        } catch (IllegalAccessException e16) {
            QLog.e(TAG, 1, "fValue ", obj, " getBasicPbValue IllegalAccessException ", e16);
            return null;
        } catch (NoSuchMethodException e17) {
            QLog.e(TAG, 1, "fValue ", obj, " getBasicPbValue NoSuchMethodException ", e17);
            return null;
        } catch (InvocationTargetException e18) {
            QLog.e(TAG, 1, "fValue ", obj, " getBasicPbValue InvocationTargetException ", e18);
            return null;
        }
    }

    private static Field getPrivateField(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Object getValueFromField(Field field, Object obj) {
        try {
            if (field == null) {
                QLog.e(TAG, 1, "getValueFromField f is null");
                return null;
            }
            Object obj2 = field.get(obj);
            if (obj2 == null) {
                QLog.e(TAG, 1, "getValueFromField fValue is null");
                return null;
            }
            return formatObj2JsonData(obj2);
        } catch (IllegalAccessException e16) {
            QLog.e(TAG, 1, "getValueFromField IllegalAccessException, ", e16);
            return null;
        }
    }

    private static boolean isBasicType(Object obj) {
        if (!(obj instanceof PBPrimitiveField) || (obj instanceof MessageMicro) || (obj instanceof PBBytesField)) {
            return false;
        }
        return true;
    }

    private static boolean isBasicValue(Object obj) {
        if (!(obj instanceof String) && !(obj instanceof Integer) && !(obj instanceof Short) && !(obj instanceof Byte) && !(obj instanceof Boolean) && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Character)) {
            return false;
        }
        return true;
    }

    private static boolean isByteStringMicro(Object obj) {
        return obj instanceof ByteStringMicro;
    }

    private static boolean isMessageMicro(Object obj) {
        return obj instanceof MessageMicro;
    }

    private static boolean isPBByteField(Object obj) {
        return obj instanceof PBBytesField;
    }

    private static boolean isPBRepeatField(Object obj) {
        return obj instanceof PBRepeatField;
    }

    private static boolean isPBRepeatMessageField(Object obj) {
        return obj instanceof PBRepeatMessageField;
    }

    public static boolean json2Pb(String str, MessageMicro<?> messageMicro) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return jsonObj2Pb(new JSONObject(str), messageMicro);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "json2Pb JSONException : ", e16);
            return false;
        }
    }

    public static boolean jsonObj2Pb(JSONObject jSONObject, MessageMicro<?> messageMicro) {
        if (jSONObject == null) {
            QLog.e(TAG, 1, "jsonObj2Pb json obj is null");
            return false;
        }
        try {
            Field[] fields = messageMicro.getClass().getFields();
            if (fields.length == 0) {
                QLog.d(TAG, 1, "proto2Json, pb fields length is 0");
                return false;
            }
            for (Field field : fields) {
                fillField(jSONObject, field, messageMicro);
            }
            return true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "json2Pb JSONException : ", e16);
            return false;
        }
    }

    private static JSONArray objList2String(List<?> list) {
        if (list == null) {
            QLog.e(TAG, 1, "protoList2String, list is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (list.size() == 0) {
            return jSONArray;
        }
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(formatObj2JsonData(it.next()));
        }
        return jSONArray;
    }

    public static String proto2Json(MessageMicro<?> messageMicro) {
        JSONObject proto2JsonObj = proto2JsonObj(messageMicro);
        if (proto2JsonObj == null) {
            return null;
        }
        return proto2JsonObj.toString();
    }

    public static JSONObject proto2JsonObj(MessageMicro<?> messageMicro) {
        Field[] fields = messageMicro.getClass().getFields();
        if (fields.length == 0) {
            QLog.d(TAG, 1, "proto2Json, pb fields length is 0");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Field field : fields) {
                jSONObject.put(field.getName(), getValueFromField(field, messageMicro));
            }
            return jSONObject;
        } catch (JSONException e16) {
            QLog.d(TAG, 1, "proto2Json error : ", e16);
            return null;
        }
    }

    private static JSONArray protoList2String(List<? extends MessageMicro<?>> list) {
        if (list == null) {
            QLog.e(TAG, 1, "protoList2String, list is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (list.size() == 0) {
            return jSONArray;
        }
        Iterator<? extends MessageMicro<?>> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(proto2JsonObj(it.next()));
        }
        return jSONArray;
    }
}
