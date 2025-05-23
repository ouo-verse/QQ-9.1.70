package com.tencent.biz.qqstory.utils;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
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
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBSInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g {
    private static <PB extends PBPrimitiveField<PB>> String a(PB pb5) {
        if (pb5 instanceof PBBytesField) {
            return ((PBBytesField) pb5).get().toStringUtf8();
        }
        if (pb5 instanceof PBStringField) {
            return ((PBStringField) pb5).get();
        }
        if (pb5 instanceof PBBoolField) {
            return String.valueOf(((PBBoolField) pb5).get());
        }
        if (pb5 instanceof PBFixed32Field) {
            return String.valueOf(((PBFixed32Field) pb5).get());
        }
        if (pb5 instanceof PBFixed64Field) {
            return String.valueOf(((PBFixed64Field) pb5).get());
        }
        if (pb5 instanceof PBFloatField) {
            return String.valueOf(((PBFloatField) pb5).get());
        }
        if (pb5 instanceof PBInt32Field) {
            return String.valueOf(((PBInt32Field) pb5).get());
        }
        if (pb5 instanceof PBInt64Field) {
            return String.valueOf(((PBInt64Field) pb5).get());
        }
        if (pb5 instanceof PBSFixed32Field) {
            return String.valueOf(((PBSFixed32Field) pb5).get());
        }
        if (pb5 instanceof PBSInt32Field) {
            return String.valueOf(((PBSInt32Field) pb5).get());
        }
        if (pb5 instanceof PBSInt64Field) {
            return String.valueOf(((PBSInt64Field) pb5).get());
        }
        if (pb5 instanceof PBUInt32Field) {
            return String.valueOf(((PBUInt32Field) pb5).get());
        }
        if (pb5 instanceof PBUInt64Field) {
            return String.valueOf(((PBUInt64Field) pb5).get());
        }
        if (pb5 instanceof PBEnumField) {
            return String.valueOf(((PBEnumField) pb5).get());
        }
        return "(null)";
    }

    public static <PB extends MessageMicro<PB>> JSONObject b(PB pb5) {
        JSONObject jSONObject = new JSONObject();
        c(pb5, jSONObject);
        return jSONObject;
    }

    private static <PB extends MessageMicro<PB>> void c(PB pb5, JSONObject jSONObject) {
        try {
            for (Field field : pb5.getClass().getDeclaredFields()) {
                String name = field.getName();
                if (Modifier.isPublic(field.getModifiers())) {
                    Object obj = field.get(pb5);
                    if ((obj instanceof MessageMicro) && ((MessageMicro) obj).has()) {
                        jSONObject.put(name, b((MessageMicro) obj));
                    } else if ((obj instanceof PBPrimitiveField) && ((PBPrimitiveField) obj).has()) {
                        jSONObject.put(name, a((PBPrimitiveField) obj));
                    } else if (obj instanceof PBRepeatField) {
                        List list = ((PBRepeatField) obj).get();
                        JSONArray jSONArray = new JSONArray();
                        for (Object obj2 : list) {
                            if (obj2 instanceof PBPrimitiveField) {
                                jSONArray.mo162put(a((PBPrimitiveField) obj2));
                            } else if (obj2 instanceof ByteStringMicro) {
                                jSONArray.mo162put(((ByteStringMicro) obj2).toStringUtf8());
                            } else {
                                jSONArray.mo162put(String.valueOf(obj2));
                            }
                        }
                        jSONObject.put(name, jSONArray);
                    } else if (obj instanceof PBRepeatMessageField) {
                        List list2 = ((PBRepeatMessageField) obj).get();
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            jSONArray2.mo162put(b((MessageMicro) it.next()));
                        }
                        jSONObject.put(name, jSONArray2);
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static <PB extends MessageMicro<PB>> String d(PB pb5) {
        if (pb5 == null) {
            return String.valueOf(pb5);
        }
        return b(pb5).toString();
    }
}
