package com.tencent.qqmini.sdk.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
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
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class GdtJsonPbUtil {
    private static final String TAG = "GdtJsonPbUtil";

    private static void addOfPB(Object obj, Object obj2) {
        Method method;
        if (obj != null && obj2 != null) {
            try {
                if (obj instanceof PBRepeatMessageField) {
                    method = PBRepeatMessageField.class.getDeclaredMethod("add", MessageMicro.class);
                } else if (obj instanceof PBRepeatField) {
                    method = PBRepeatField.class.getDeclaredMethod("add", Object.class);
                } else {
                    method = null;
                }
                if (method == null) {
                    QMLog.e(TAG, "addOfPB error");
                    return;
                } else {
                    method.invoke(obj, obj2);
                    return;
                }
            } catch (Throwable th5) {
                QMLog.e(TAG, "addOfPB", th5);
                return;
            }
        }
        QMLog.e(TAG, "addOfPB error");
    }

    private static Object getOfPB(Object obj) {
        if (obj == null) {
            QMLog.e(TAG, "getOfPB error");
            return null;
        }
        try {
            return obj.getClass().getMethod("get", Void.class).invoke(obj, new Object[0]);
        } catch (Throwable th5) {
            QMLog.e(TAG, "getOfPB", th5);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static PBField getPbArrayField(PBField pBField) {
        Object obj;
        Object obj2;
        try {
            Field declaredField = pBField.getClass().getDeclaredField("helper");
            boolean isAccessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            obj = declaredField.get(pBField);
            try {
                declaredField.setAccessible(isAccessible);
            } catch (IllegalAccessException e16) {
                e = e16;
                QMLog.e(TAG, "getClassOfPBArray", e);
                if (obj instanceof PBField) {
                }
            } catch (NoSuchFieldException e17) {
                e = e17;
                QMLog.e(TAG, "getClassOfPBArray", e);
                if (obj instanceof PBField) {
                }
            }
        } catch (IllegalAccessException e18) {
            e = e18;
            obj = null;
        } catch (NoSuchFieldException e19) {
            e = e19;
            obj = null;
        }
        if (obj instanceof PBField) {
            return (PBField) PBField.class.cast(obj);
        }
        if (!(obj instanceof Class) || ((Class) obj).getSuperclass() != MessageMicro.class) {
            return null;
        }
        try {
            obj2 = ((Class) Class.class.cast(obj)).newInstance();
        } catch (Exception e26) {
            QMLog.e(TAG, "getClassOfPBArray", e26);
            obj2 = null;
        }
        if (!(obj2 instanceof MessageMicro)) {
            return null;
        }
        return (PBField) MessageMicro.class.cast(obj2);
    }

    private static PBPrimitiveField getPbPrimitiveFromJsonPrimitive(PBPrimitiveField pBPrimitiveField, Object obj) {
        PBPrimitiveField initUInt64;
        try {
            if (pBPrimitiveField instanceof PBBoolField) {
                initUInt64 = PBField.initBool(Boolean.parseBoolean(obj.toString()));
            } else if (pBPrimitiveField instanceof PBDoubleField) {
                initUInt64 = PBField.initDouble(Double.parseDouble(obj.toString()));
            } else if (pBPrimitiveField instanceof PBEnumField) {
                initUInt64 = PBField.initEnum(Integer.parseInt(obj.toString()));
            } else if (pBPrimitiveField instanceof PBFixed32Field) {
                initUInt64 = PBField.initFixed32(Integer.parseInt(obj.toString()));
            } else if (pBPrimitiveField instanceof PBFixed64Field) {
                initUInt64 = PBField.initFixed64(Long.parseLong(obj.toString()));
            } else if (pBPrimitiveField instanceof PBFloatField) {
                initUInt64 = PBField.initFloat(Float.parseFloat(obj.toString()));
            } else if (pBPrimitiveField instanceof PBInt32Field) {
                initUInt64 = PBField.initInt32(Integer.parseInt(obj.toString()));
            } else if (pBPrimitiveField instanceof PBInt64Field) {
                initUInt64 = PBField.initInt64(Long.parseLong(obj.toString()));
            } else if (pBPrimitiveField instanceof PBSFixed32Field) {
                initUInt64 = PBField.initSFixed32(Integer.parseInt(obj.toString()));
            } else if (pBPrimitiveField instanceof PBSFixed64Field) {
                initUInt64 = PBField.initSFixed64(Long.parseLong(obj.toString()));
            } else if (pBPrimitiveField instanceof PBSInt32Field) {
                initUInt64 = PBField.initSInt32(Integer.parseInt(obj.toString()));
            } else if (pBPrimitiveField instanceof PBSInt64Field) {
                initUInt64 = PBField.initSInt64(Long.parseLong(obj.toString()));
            } else if ((pBPrimitiveField instanceof PBStringField) && obj.getClass() == String.class) {
                initUInt64 = PBField.initString((String) String.class.cast(obj));
            } else if (pBPrimitiveField instanceof PBUInt32Field) {
                initUInt64 = PBField.initUInt32(Integer.parseInt(obj.toString()));
            } else {
                if (!(pBPrimitiveField instanceof PBUInt64Field)) {
                    return null;
                }
                initUInt64 = PBField.initUInt64(Long.parseLong(obj.toString()));
            }
            return initUInt64;
        } catch (Throwable th5) {
            QMLog.e(TAG, "pbFromJsonPrimitive", th5);
            return null;
        }
    }

    private static Class getValueClassOfPBField(Class cls) {
        if (cls == null) {
            QMLog.e(TAG, "getValueClassOfPBField error");
            return null;
        }
        try {
            return cls.getMethod("get", new Class[0]).getReturnType();
        } catch (NoSuchMethodException e16) {
            QMLog.e(TAG, "getValueClassOfPBField", e16);
            return null;
        }
    }

    private static boolean isPBMessage(Class cls) {
        if (cls != null && cls.getSuperclass() == MessageMicro.class && !isPBRepeat(cls)) {
            return true;
        }
        return false;
    }

    private static boolean isPBPrimitive(Class cls) {
        if (cls != PBBoolField.class && cls != PBDoubleField.class && cls != PBEnumField.class && cls != PBFixed32Field.class && cls != PBFixed64Field.class && cls != PBFloatField.class && cls != PBInt32Field.class && cls != PBInt64Field.class && cls != PBSFixed32Field.class && cls != PBSFixed64Field.class && cls != PBSInt32Field.class && cls != PBSInt64Field.class && cls != PBStringField.class && cls != PBUInt32Field.class && cls != PBUInt64Field.class) {
            return false;
        }
        return true;
    }

    private static boolean isPBRepeat(Class cls) {
        if (cls != PBRepeatField.class && cls != PBRepeatMessageField.class) {
            return false;
        }
        return true;
    }

    private static void parsePbMsgField(MessageMicro messageMicro, JSONObject jSONObject, Field field) {
        if (!Modifier.isPublic(field.getModifiers())) {
            return;
        }
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        String name = field.getName();
        try {
            Object obj = field.get(messageMicro);
            field.setAccessible(isAccessible);
            if ((Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) && obj != null && (obj.getClass() == Integer.TYPE || obj.getClass() == Integer.class)) {
                return;
            }
            if (!(obj instanceof PBField)) {
                QMLog.e(TAG, "pbMessagebToJson error");
                return;
            }
            Object pbToJson = pbToJson((PBField) PBField.class.cast(obj));
            if (pbToJson != null && pbToJson != JSONObject.NULL) {
                try {
                    jSONObject.put(name, pbToJson);
                } catch (JSONException e16) {
                    QMLog.e(TAG, "pbMessagebToJson", e16);
                }
            }
        } catch (IllegalAccessException e17) {
            QMLog.e(TAG, "pbMessagebToJson", e17);
        }
    }

    public static PBField pbFromJson(PBField pBField, Object obj) {
        if (pBField != null && pBField.getClass() != PBBytesField.class && obj != null && obj != JSONObject.NULL) {
            if (isPBPrimitive(pBField.getClass())) {
                return pbPrimitiveFromJsonPrimitive((PBPrimitiveField) PBPrimitiveField.class.cast(pBField), obj);
            }
            if (isPBRepeat(pBField.getClass()) && (obj instanceof JSONArray)) {
                return pbRepeatFromJsonArray(pBField, (JSONArray) JSONArray.class.cast(obj));
            }
            if (isPBMessage(pBField.getClass()) && (obj instanceof JSONObject)) {
                return pbMessageFromJsonObject((MessageMicro) MessageMicro.class.cast(pBField), (JSONObject) JSONObject.class.cast(obj));
            }
            QMLog.e(TAG, "pbFromJson error");
            return null;
        }
        QMLog.e(TAG, "pbFromJson error");
        return null;
    }

    private static MessageMicro pbMessageFromJsonObject(MessageMicro messageMicro, JSONObject jSONObject) {
        if (messageMicro != null && isPBMessage(messageMicro.getClass()) && jSONObject != null && jSONObject != JSONObject.NULL) {
            try {
                Object newInstance = messageMicro.getClass().newInstance();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) String.class.cast(keys.next());
                    if (TextUtils.isEmpty(str)) {
                        QMLog.e(TAG, "pbMessageFromJsonObject error");
                    } else {
                        try {
                            Object obj = jSONObject.get(str);
                            if (obj != null && obj != JSONObject.NULL) {
                                try {
                                    Field declaredField = newInstance.getClass().getDeclaredField(str);
                                    boolean isAccessible = declaredField.isAccessible();
                                    declaredField.setAccessible(true);
                                    Object obj2 = declaredField.get(newInstance);
                                    declaredField.setAccessible(isAccessible);
                                    if (!(obj2 instanceof PBField)) {
                                        QMLog.e(TAG, "pbMessageFromJsonObject error");
                                    } else {
                                        PBField pbFromJson = pbFromJson((PBField) PBField.class.cast(obj2), obj);
                                        if (pbFromJson == null) {
                                            QMLog.e(TAG, "pbMessageFromJsonObject error");
                                        } else {
                                            setOfPB(obj2, getOfPB(pbFromJson), getValueClassOfPBField(obj2.getClass()));
                                        }
                                    }
                                } catch (IllegalAccessException e16) {
                                    QMLog.e(TAG, "pbMessageFromJsonObject", e16);
                                } catch (NoSuchFieldException e17) {
                                    QMLog.e(TAG, "pbMessageFromJsonObject", e17);
                                }
                            }
                        } catch (JSONException e18) {
                            QMLog.e(TAG, "pbMessageFromJsonObject", e18);
                        }
                    }
                }
                if (newInstance instanceof MessageMicro) {
                    return (MessageMicro) MessageMicro.class.cast(newInstance);
                }
                QMLog.e(TAG, "pbMessageFromJsonObject error");
                return null;
            } catch (IllegalAccessException e19) {
                QMLog.e(TAG, "pbMessageFromJsonObject", e19);
                return null;
            } catch (InstantiationException e26) {
                QMLog.e(TAG, "pbMessageFromJsonObject", e26);
                return null;
            }
        }
        QMLog.e(TAG, "pbFromJsonPrimitive error");
        return null;
    }

    private static JSONObject pbMessageToJson(MessageMicro messageMicro) {
        Field[] declaredFields;
        if (messageMicro == null || (declaredFields = messageMicro.getClass().getDeclaredFields()) == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Field field : declaredFields) {
            parsePbMsgField(messageMicro, jSONObject, field);
        }
        return jSONObject;
    }

    private static Object pbPrimitiveFieldToJson(PBPrimitiveField<?> pBPrimitiveField) {
        if (pBPrimitiveField != null && !(pBPrimitiveField instanceof PBBytesField) && pBPrimitiveField.has()) {
            Object ofPB = getOfPB(pBPrimitiveField);
            if (!(pBPrimitiveField instanceof PBFixed64Field) && !(pBPrimitiveField instanceof PBInt64Field) && !(pBPrimitiveField instanceof PBSFixed64Field) && !(pBPrimitiveField instanceof PBSInt64Field) && !(pBPrimitiveField instanceof PBUInt64Field)) {
                return ofPB;
            }
            if (ofPB == null) {
                return "";
            }
            try {
                return String.valueOf(ofPB);
            } catch (Throwable th5) {
                QMLog.e(TAG, "pbPrimitiveFieldToJson", th5);
                return "";
            }
        }
        return null;
    }

    private static PBPrimitiveField pbPrimitiveFromJsonPrimitive(PBPrimitiveField pBPrimitiveField, Object obj) {
        if (pBPrimitiveField != null && isPBPrimitive(pBPrimitiveField.getClass()) && obj != null && obj != JSONObject.NULL) {
            PBPrimitiveField pbPrimitiveFromJsonPrimitive = getPbPrimitiveFromJsonPrimitive(pBPrimitiveField, obj);
            if (pbPrimitiveFromJsonPrimitive != null && pbPrimitiveFromJsonPrimitive.getClass() == pBPrimitiveField.getClass()) {
                return pbPrimitiveFromJsonPrimitive;
            }
            QMLog.e(TAG, "pbFromJsonPrimitive error");
            return null;
        }
        QMLog.e(TAG, "pbFromJsonPrimitive error");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static PBField pbRepeatFromJsonArray(PBField pBField, JSONArray jSONArray) {
        Object obj;
        PBField initRepeat;
        if (pBField != null && jSONArray != null && jSONArray != JSONObject.NULL) {
            PBField pbArrayField = getPbArrayField(pBField);
            if (pbArrayField == null) {
                QMLog.e(TAG, "pbRepeatFromJsonArray error");
                return null;
            }
            if (isPBPrimitive(pbArrayField.getClass())) {
                try {
                    obj = pbArrayField.getClass().getField("__repeatHelper__").get(pbArrayField);
                } catch (IllegalAccessException e16) {
                    QMLog.e(TAG, "pbRepeatFromJsonArray", e16);
                    obj = null;
                    if (obj instanceof PBField) {
                    }
                    initRepeat = null;
                    if (initRepeat == null) {
                    }
                } catch (NoSuchFieldException e17) {
                    QMLog.e(TAG, "pbRepeatFromJsonArray", e17);
                    obj = null;
                    if (obj instanceof PBField) {
                    }
                    initRepeat = null;
                    if (initRepeat == null) {
                    }
                }
                if (obj instanceof PBField) {
                    initRepeat = PBField.initRepeat((PBField) PBField.class.cast(obj));
                }
                initRepeat = null;
            } else {
                if (isPBMessage(pbArrayField.getClass())) {
                    initRepeat = PBField.initRepeatMessage(((MessageMicro) MessageMicro.class.cast(pbArrayField)).getClass());
                }
                initRepeat = null;
            }
            if (initRepeat == null) {
                QMLog.e(TAG, "pbRepeatFromJsonArray error");
                return null;
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    Object obj2 = jSONArray.get(i3);
                    if (obj2 != null && obj2 != JSONObject.NULL) {
                        addOfPB(initRepeat, getOfPB(pbFromJson(pbArrayField, obj2)));
                    }
                } catch (JSONException e18) {
                    QMLog.e(TAG, "pbRepeatFromJsonArray", e18);
                }
            }
            return initRepeat;
        }
        QMLog.e(TAG, "pbRepeatFromJsonArray error");
        return null;
    }

    private static JSONArray pbRepeatToJson(PBField pBField) {
        JSONArray jSONArray = null;
        if (pBField != null && isPBRepeat(pBField.getClass())) {
            Object ofPB = getOfPB(pBField);
            if (ofPB == null) {
                return null;
            }
            if (!(ofPB instanceof List)) {
                QMLog.e(TAG, "pbRepeatToJson error");
                return null;
            }
            List list = (List) List.class.cast(ofPB);
            if (list == null) {
                QMLog.e(TAG, "pbRepeatToJson error");
                return null;
            }
            jSONArray = new JSONArray();
            for (Object obj : list) {
                if (obj instanceof PBField) {
                    obj = pbToJson((PBField) PBField.class.cast(obj));
                }
                if (obj != null && obj != JSONObject.NULL) {
                    jSONArray.mo162put(obj);
                }
            }
        }
        return jSONArray;
    }

    public static Object pbToJson(PBField pBField) {
        if (pBField == null) {
            QMLog.e(TAG, "pbToJson error");
            return null;
        }
        if (isPBPrimitive(pBField.getClass())) {
            return pbPrimitiveFieldToJson((PBPrimitiveField) PBPrimitiveField.class.cast(pBField));
        }
        if (isPBRepeat(pBField.getClass())) {
            return pbRepeatToJson(pBField);
        }
        if (isPBMessage(pBField.getClass())) {
            return pbMessageToJson((MessageMicro) MessageMicro.class.cast(pBField));
        }
        QMLog.e(TAG, "pbToJson error, " + pBField.getClass().getName() + " is not supported");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void setOfPB(Object obj, Object obj2, Class cls) {
        if (obj != null && obj2 != null && cls != null) {
            try {
                obj.getClass().getMethod("set", cls).invoke(obj, obj2);
                return;
            } catch (Throwable th5) {
                QMLog.e(TAG, "setOfPB", th5);
                return;
            }
        }
        QMLog.e(TAG, "setOfPB error");
    }
}
