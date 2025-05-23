package com.tencent.gdtad.json;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.gdtad.log.GdtLog;
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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class GdtJsonPbUtil {
    private static final String TAG = "GdtJsonPbUtil";

    private static void addOfPB(@Nullable Object obj, @Nullable Object obj2) {
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
                    GdtLog.e(TAG, "addOfPB error");
                    return;
                } else {
                    method.invoke(obj, obj2);
                    return;
                }
            } catch (Throwable th5) {
                GdtLog.e(TAG, "addOfPB", th5);
                return;
            }
        }
        GdtLog.e(TAG, "addOfPB error");
    }

    @Nullable
    private static Object getOfPB(@Nullable Object obj) {
        if (obj == null) {
            GdtLog.e(TAG, "getOfPB error");
            return null;
        }
        try {
            return obj.getClass().getMethod("get", new Class[0]).invoke(obj, new Object[0]);
        } catch (Throwable th5) {
            GdtLog.e(TAG, "getOfPB", th5);
            return null;
        }
    }

    @Nullable
    private static Class getValueClassOfPBField(@Nullable Class cls) {
        if (cls == null) {
            GdtLog.e(TAG, "getValueClassOfPBField error");
            return null;
        }
        try {
            return cls.getMethod("get", null).getReturnType();
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static boolean isPBMessage(@Nullable Class cls) {
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

    @Nullable
    public static PBField pbFromJson(@Nullable PBField pBField, @Nullable Object obj) {
        if (pBField != null && pBField.getClass() != PBBytesField.class && obj != null && !JSONObject.NULL.equals(obj)) {
            if (isPBPrimitive(pBField.getClass())) {
                return pbPrimitiveFromJsonPrimitive((PBPrimitiveField) PBPrimitiveField.class.cast(pBField), obj);
            }
            if (isPBRepeat(pBField.getClass()) && (obj instanceof JSONArray)) {
                return pbRepeatFromJsonArray(pBField, (JSONArray) JSONArray.class.cast(obj));
            }
            if (isPBMessage(pBField.getClass()) && (obj instanceof JSONObject)) {
                return pbMessageFromJsonObject((MessageMicro) MessageMicro.class.cast(pBField), (JSONObject) JSONObject.class.cast(obj));
            }
            GdtLog.e(TAG, "pbFromJson error");
            return null;
        }
        GdtLog.e(TAG, "pbFromJson error");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static MessageMicro pbMessageFromJsonObject(@Nullable MessageMicro messageMicro, @Nullable JSONObject jSONObject) {
        if (messageMicro != null && isPBMessage(messageMicro.getClass()) && jSONObject != null && !JSONObject.NULL.equals(jSONObject)) {
            try {
                Object newInstance = messageMicro.getClass().newInstance();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) String.class.cast(keys.next());
                    if (TextUtils.isEmpty(str)) {
                        GdtLog.e(TAG, "pbMessageFromJsonObject error");
                    } else {
                        try {
                            Object obj = jSONObject.get(str);
                            if (obj != null) {
                                if (!JSONObject.NULL.equals(obj)) {
                                    try {
                                        Field declaredField = newInstance.getClass().getDeclaredField(str);
                                        boolean isAccessible = declaredField.isAccessible();
                                        declaredField.setAccessible(true);
                                        Object obj2 = declaredField.get(newInstance);
                                        declaredField.setAccessible(isAccessible);
                                        if (!(obj2 instanceof PBField)) {
                                            GdtLog.e(TAG, "pbMessageFromJsonObject error");
                                        } else {
                                            PBField pbFromJson = pbFromJson((PBField) PBField.class.cast(obj2), obj);
                                            if (pbFromJson == null) {
                                                GdtLog.e(TAG, "pbMessageFromJsonObject error");
                                            } else {
                                                setOfPB(obj2, getOfPB(pbFromJson), getValueClassOfPBField(obj2.getClass()));
                                            }
                                        }
                                    } catch (IllegalAccessException e16) {
                                        GdtLog.e(TAG, "pbMessageFromJsonObject", e16);
                                    } catch (NoSuchFieldException unused) {
                                    }
                                }
                                while (keys.hasNext()) {
                                }
                            }
                        } catch (JSONException e17) {
                            GdtLog.e(TAG, "pbMessageFromJsonObject", e17);
                        }
                    }
                }
                if (newInstance instanceof MessageMicro) {
                    return (MessageMicro) MessageMicro.class.cast(newInstance);
                }
                GdtLog.e(TAG, "pbMessageFromJsonObject error");
                return null;
            } catch (IllegalAccessException e18) {
                GdtLog.e(TAG, "pbMessageFromJsonObject", e18);
                return null;
            } catch (InstantiationException e19) {
                GdtLog.e(TAG, "pbMessageFromJsonObject", e19);
                return null;
            }
        }
        GdtLog.e(TAG, "pbFromJsonPrimitive error");
        return null;
    }

    @Nullable
    private static JSONObject pbMessageToJson(@Nullable MessageMicro messageMicro) {
        Field[] declaredFields;
        if (messageMicro == null || (declaredFields = messageMicro.getClass().getDeclaredFields()) == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Field field : declaredFields) {
            if (Modifier.isPublic(field.getModifiers())) {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                String name = field.getName();
                try {
                    Object obj = field.get(messageMicro);
                    field.setAccessible(isAccessible);
                    if ((!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) || obj == null || (obj.getClass() != Integer.TYPE && obj.getClass() != Integer.class)) {
                        if (!(obj instanceof PBField)) {
                            GdtLog.e(TAG, "pbMessagebToJson error");
                        } else {
                            Object pbToJson = pbToJson((PBField) PBField.class.cast(obj));
                            if (pbToJson != null && !JSONObject.NULL.equals(pbToJson)) {
                                try {
                                    jSONObject.put(name, pbToJson);
                                } catch (JSONException e16) {
                                    GdtLog.e(TAG, "pbMessagebToJson", e16);
                                }
                            }
                        }
                    }
                } catch (IllegalAccessException e17) {
                    GdtLog.e(TAG, "pbMessagebToJson", e17);
                }
            }
        }
        if (jSONObject.length() <= 0) {
            return null;
        }
        return jSONObject;
    }

    @Nullable
    private static Object pbPrimitiveFieldToJson(@Nullable PBPrimitiveField<?> pBPrimitiveField) {
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
                GdtLog.e(TAG, "pbPrimitiveFieldToJson", th5);
                return "";
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0135, code lost:
    
        r6 = null;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static PBPrimitiveField pbPrimitiveFromJsonPrimitive(@Nullable PBPrimitiveField pBPrimitiveField, @Nullable Object obj) {
        PBPrimitiveField pBPrimitiveField2;
        if (pBPrimitiveField != null && isPBPrimitive(pBPrimitiveField.getClass()) && obj != null && !JSONObject.NULL.equals(obj)) {
            try {
            } catch (Throwable th5) {
                GdtLog.e(TAG, "pbFromJsonPrimitive", th5);
                pBPrimitiveField2 = null;
            }
            if (pBPrimitiveField instanceof PBBoolField) {
                pBPrimitiveField2 = PBField.initBool(Boolean.parseBoolean(obj.toString()));
            } else if (pBPrimitiveField instanceof PBDoubleField) {
                pBPrimitiveField2 = PBField.initDouble(Double.parseDouble(obj.toString()));
            } else if (pBPrimitiveField instanceof PBEnumField) {
                pBPrimitiveField2 = PBField.initEnum(Integer.parseInt(obj.toString()));
            } else if (pBPrimitiveField instanceof PBFixed32Field) {
                pBPrimitiveField2 = PBField.initFixed32(Integer.parseInt(obj.toString()));
            } else if (pBPrimitiveField instanceof PBFixed64Field) {
                pBPrimitiveField2 = PBField.initFixed64(Long.parseLong(obj.toString()));
            } else if (pBPrimitiveField instanceof PBFloatField) {
                pBPrimitiveField2 = PBField.initFloat(Float.parseFloat(obj.toString()));
            } else if (pBPrimitiveField instanceof PBInt32Field) {
                pBPrimitiveField2 = PBField.initInt32(Integer.parseInt(obj.toString()));
            } else if (pBPrimitiveField instanceof PBInt64Field) {
                pBPrimitiveField2 = PBField.initInt64(Long.parseLong(obj.toString()));
            } else if (pBPrimitiveField instanceof PBSFixed32Field) {
                pBPrimitiveField2 = PBField.initSFixed32(Integer.parseInt(obj.toString()));
            } else if (pBPrimitiveField instanceof PBSFixed64Field) {
                pBPrimitiveField2 = PBField.initSFixed64(Long.parseLong(obj.toString()));
            } else if (pBPrimitiveField instanceof PBSInt32Field) {
                pBPrimitiveField2 = PBField.initSInt32(Integer.parseInt(obj.toString()));
            } else if (pBPrimitiveField instanceof PBSInt64Field) {
                pBPrimitiveField2 = PBField.initSInt64(Long.parseLong(obj.toString()));
            } else if ((pBPrimitiveField instanceof PBStringField) && obj.getClass() == String.class) {
                pBPrimitiveField2 = PBField.initString((String) String.class.cast(obj));
            } else if (pBPrimitiveField instanceof PBUInt32Field) {
                pBPrimitiveField2 = PBField.initUInt32(Integer.parseInt(obj.toString()));
            } else {
                if (pBPrimitiveField instanceof PBUInt64Field) {
                    pBPrimitiveField2 = PBField.initUInt64(Long.parseLong(obj.toString()));
                }
                pBPrimitiveField2 = null;
            }
            if (pBPrimitiveField2 != null && pBPrimitiveField2.getClass() == pBPrimitiveField.getClass()) {
                return pBPrimitiveField2;
            }
            GdtLog.e(TAG, "pbFromJsonPrimitive error");
            return null;
        }
        GdtLog.e(TAG, "pbFromJsonPrimitive error");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0073  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static PBField pbRepeatFromJsonArray(@Nullable PBField pBField, @Nullable JSONArray jSONArray) {
        Object obj;
        PBField pBField2;
        Object obj2;
        Object obj3;
        PBField initRepeat;
        Field declaredField;
        boolean isAccessible;
        if (pBField != null && jSONArray != null && !JSONObject.NULL.equals(jSONArray)) {
            try {
                declaredField = pBField.getClass().getDeclaredField("helper");
                isAccessible = declaredField.isAccessible();
                declaredField.setAccessible(true);
                obj = declaredField.get(pBField);
            } catch (IllegalAccessException e16) {
                e = e16;
                obj = null;
            } catch (NoSuchFieldException unused) {
                obj = null;
            }
            try {
                declaredField.setAccessible(isAccessible);
            } catch (IllegalAccessException e17) {
                e = e17;
                GdtLog.e(TAG, "getClassOfPBArray", e);
            } catch (NoSuchFieldException unused2) {
            }
            if (obj instanceof PBField) {
                pBField2 = (PBField) PBField.class.cast(obj);
            } else {
                if ((obj instanceof Class) && ((Class) obj).getSuperclass() == MessageMicro.class) {
                    try {
                        obj2 = ((Class) Class.class.cast(obj)).newInstance();
                    } catch (IllegalAccessException e18) {
                        GdtLog.e(TAG, "getClassOfPBArray", e18);
                        obj2 = null;
                        if (obj2 instanceof MessageMicro) {
                        }
                        pBField2 = null;
                        if (pBField2 == null) {
                        }
                    } catch (InstantiationException e19) {
                        GdtLog.e(TAG, "getClassOfPBArray", e19);
                        obj2 = null;
                        if (obj2 instanceof MessageMicro) {
                        }
                        pBField2 = null;
                        if (pBField2 == null) {
                        }
                    }
                    if (obj2 instanceof MessageMicro) {
                        pBField2 = (PBField) MessageMicro.class.cast(obj2);
                    }
                }
                pBField2 = null;
            }
            if (pBField2 == null) {
                GdtLog.e(TAG, "pbRepeatFromJsonArray error");
                return null;
            }
            if (isPBPrimitive(pBField2.getClass())) {
                try {
                    obj3 = pBField2.getClass().getField("__repeatHelper__").get(pBField2);
                } catch (IllegalAccessException e26) {
                    GdtLog.e(TAG, "pbRepeatFromJsonArray", e26);
                    obj3 = null;
                    if (obj3 instanceof PBField) {
                    }
                    initRepeat = null;
                    if (initRepeat == null) {
                    }
                } catch (NoSuchFieldException unused3) {
                    obj3 = null;
                    if (obj3 instanceof PBField) {
                    }
                    initRepeat = null;
                    if (initRepeat == null) {
                    }
                }
                if (obj3 instanceof PBField) {
                    initRepeat = PBField.initRepeat((PBField) PBField.class.cast(obj3));
                }
                initRepeat = null;
            } else {
                if (isPBMessage(pBField2.getClass())) {
                    initRepeat = PBField.initRepeatMessage(((MessageMicro) MessageMicro.class.cast(pBField2)).getClass());
                }
                initRepeat = null;
            }
            if (initRepeat == null) {
                GdtLog.e(TAG, "pbRepeatFromJsonArray error");
                return null;
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    Object obj4 = jSONArray.get(i3);
                    if (obj4 != null && !JSONObject.NULL.equals(obj4)) {
                        addOfPB(initRepeat, getOfPB(pbFromJson(pBField2, obj4)));
                    }
                } catch (JSONException e27) {
                    GdtLog.e(TAG, "pbRepeatFromJsonArray", e27);
                }
            }
            return initRepeat;
        }
        GdtLog.e(TAG, "pbRepeatFromJsonArray error");
        return null;
    }

    @Nullable
    private static JSONArray pbRepeatToJson(@Nullable PBField pBField) {
        Object ofPB;
        if (pBField == null || !isPBRepeat(pBField.getClass()) || (ofPB = getOfPB(pBField)) == null) {
            return null;
        }
        if (!(ofPB instanceof List)) {
            GdtLog.e(TAG, "pbRepeatToJson error");
            return null;
        }
        List list = (List) List.class.cast(ofPB);
        if (list == null) {
            GdtLog.e(TAG, "pbRepeatToJson error");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (obj instanceof PBField) {
                obj = pbToJson((PBField) PBField.class.cast(obj));
            }
            if (obj != null && !JSONObject.NULL.equals(obj)) {
                jSONArray.mo162put(obj);
            }
        }
        if (jSONArray.length() <= 0) {
            return null;
        }
        return jSONArray;
    }

    @Nullable
    public static Object pbToJson(@Nullable PBField pBField) {
        if (pBField == null) {
            GdtLog.e(TAG, "pbToJson error");
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
        GdtLog.e(TAG, "pbToJson error, " + pBField.getClass().getName() + " is not supported");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void setOfPB(@Nullable Object obj, @Nullable Object obj2, @Nullable Class cls) {
        if (obj != null && obj2 != null && cls != null) {
            try {
                obj.getClass().getMethod("set", cls).invoke(obj, obj2);
                return;
            } catch (Throwable th5) {
                GdtLog.e(TAG, "setOfPB", th5);
                return;
            }
        }
        GdtLog.e(TAG, "setOfPB error");
    }
}
