package com.tencent.mobileqq.app;

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
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.inject.MqqInjectorManager;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class OidbWrapper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "OidbWrapper";

    public OidbWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean dealMessageMicro(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, int i3, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        if (!atomicBoolean.get() && MessageMicro.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            MessageMicro messageMicro2 = (MessageMicro) field.get(messageMicro);
            if (messageMicro2 == null) {
                return true;
            }
            boolean has = messageMicro2.has();
            MessageMicro messageMicro3 = messageMicro2.get();
            if (z16 && !has) {
                return true;
            }
            if (!has) {
                String format = String.format("%s: NA", field.getName());
                sb5.append(str);
                sb5.append(format);
            } else {
                sb5.append(str);
                sb5.append(field.getName());
                sb5.append(": {\n");
                sb5.append(proto2String(messageMicro3, i3 + 1, z16));
                sb5.append(str);
                sb5.append("}");
            }
        }
        return false;
    }

    private static boolean dealPBBoolField(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        Object obj;
        if (!atomicBoolean.get() && PBBoolField.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBBoolField pBBoolField = (PBBoolField) field.get(messageMicro);
            if (pBBoolField == null) {
                return true;
            }
            boolean has = pBBoolField.has();
            boolean z17 = pBBoolField.get();
            Object[] objArr = new Object[2];
            objArr[0] = field.getName();
            if (has) {
                obj = Boolean.valueOf(z17);
            } else {
                obj = "NA";
            }
            objArr[1] = obj;
            String format = String.format("%s: %s", objArr);
            if (z16 && !has) {
                return true;
            }
            sb5.append(str);
            sb5.append(format);
        }
        return false;
    }

    private static boolean dealPBBytesField(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        String str2;
        if (!atomicBoolean.get() && PBBytesField.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBBytesField pBBytesField = (PBBytesField) field.get(messageMicro);
            if (pBBytesField == null) {
                return true;
            }
            boolean has = pBBytesField.has();
            Object[] objArr = new Object[2];
            objArr[0] = field.getName();
            if (has) {
                str2 = "<\u2026bytes\u2026>";
            } else {
                str2 = "NA";
            }
            objArr[1] = str2;
            String format = String.format("%s: %s", objArr);
            if (z16 && !has) {
                return true;
            }
            sb5.append(str);
            sb5.append(format);
        }
        return false;
    }

    private static boolean dealPBDoubleField(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        Object obj;
        if (!atomicBoolean.get() && PBDoubleField.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBDoubleField pBDoubleField = (PBDoubleField) field.get(messageMicro);
            if (pBDoubleField == null) {
                return true;
            }
            boolean has = pBDoubleField.has();
            double d16 = pBDoubleField.get();
            Object[] objArr = new Object[2];
            objArr[0] = field.getName();
            if (has) {
                obj = Double.valueOf(d16);
            } else {
                obj = "NA";
            }
            objArr[1] = obj;
            String format = String.format("%s: %s", objArr);
            if (z16 && !has) {
                return true;
            }
            sb5.append(str);
            sb5.append(format);
        }
        return false;
    }

    private static boolean dealPBEnumField(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        Object obj;
        if (!atomicBoolean.get() && PBEnumField.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBEnumField pBEnumField = (PBEnumField) field.get(messageMicro);
            if (pBEnumField == null) {
                return true;
            }
            boolean has = pBEnumField.has();
            int i3 = pBEnumField.get();
            Object[] objArr = new Object[2];
            objArr[0] = field.getName();
            if (has) {
                obj = Integer.valueOf(i3);
            } else {
                obj = "NA";
            }
            objArr[1] = obj;
            String format = String.format("%s: %s", objArr);
            if (z16 && !has) {
                return true;
            }
            sb5.append(str);
            sb5.append(format);
        }
        return false;
    }

    private static boolean dealPBFixed32Field(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        Object obj;
        if (!atomicBoolean.get() && PBFixed32Field.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBFixed32Field pBFixed32Field = (PBFixed32Field) field.get(messageMicro);
            boolean has = pBFixed32Field.has();
            int i3 = pBFixed32Field.get();
            Object[] objArr = new Object[2];
            objArr[0] = field.getName();
            if (has) {
                obj = Integer.valueOf(i3);
            } else {
                obj = "NA";
            }
            objArr[1] = obj;
            String format = String.format("%s: %s", objArr);
            if (z16 && !has) {
                return true;
            }
            sb5.append(str);
            sb5.append(format);
        }
        return false;
    }

    private static boolean dealPBFixed64Field(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        Object obj;
        if (!atomicBoolean.get() && PBFixed64Field.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBFixed64Field pBFixed64Field = (PBFixed64Field) field.get(messageMicro);
            if (pBFixed64Field == null) {
                return true;
            }
            boolean has = pBFixed64Field.has();
            long j3 = pBFixed64Field.get();
            Object[] objArr = new Object[2];
            objArr[0] = field.getName();
            if (has) {
                obj = Long.valueOf(j3);
            } else {
                obj = "NA";
            }
            objArr[1] = obj;
            String format = String.format("%s: %s", objArr);
            if (z16 && !has) {
                return true;
            }
            sb5.append(str);
            sb5.append(format);
        }
        return false;
    }

    private static boolean dealPBFloatField(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        Object obj;
        if (!atomicBoolean.get() && PBFloatField.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBFloatField pBFloatField = (PBFloatField) field.get(messageMicro);
            if (pBFloatField == null) {
                return true;
            }
            boolean has = pBFloatField.has();
            float f16 = pBFloatField.get();
            Object[] objArr = new Object[2];
            objArr[0] = field.getName();
            if (has) {
                obj = Float.valueOf(f16);
            } else {
                obj = "NA";
            }
            objArr[1] = obj;
            String format = String.format("%s: %s", objArr);
            if (z16 && !has) {
                return true;
            }
            sb5.append(str);
            sb5.append(format);
        }
        return false;
    }

    private static boolean dealPBInt32Field(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        Object obj;
        if (!atomicBoolean.get() && PBInt32Field.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBInt32Field pBInt32Field = (PBInt32Field) field.get(messageMicro);
            if (pBInt32Field == null) {
                return true;
            }
            boolean has = pBInt32Field.has();
            int i3 = pBInt32Field.get();
            Object[] objArr = new Object[2];
            objArr[0] = field.getName();
            if (has) {
                obj = Integer.valueOf(i3);
            } else {
                obj = "NA";
            }
            objArr[1] = obj;
            String format = String.format("%s: %s", objArr);
            if (z16 && !has) {
                return true;
            }
            sb5.append(str);
            sb5.append(format);
        }
        return false;
    }

    private static boolean dealPBInt64Field(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        Object obj;
        if (!atomicBoolean.get() && PBInt64Field.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBInt64Field pBInt64Field = (PBInt64Field) field.get(messageMicro);
            if (pBInt64Field == null) {
                return true;
            }
            boolean has = pBInt64Field.has();
            long j3 = pBInt64Field.get();
            Object[] objArr = new Object[2];
            objArr[0] = field.getName();
            if (has) {
                obj = Long.valueOf(j3);
            } else {
                obj = "NA";
            }
            objArr[1] = obj;
            String format = String.format("%s: %s", objArr);
            if (z16 && !has) {
                return true;
            }
            sb5.append(str);
            sb5.append(format);
        }
        return false;
    }

    private static boolean dealPBRepeatField(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        if (!atomicBoolean.get() && PBRepeatField.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBRepeatField pBRepeatField = (PBRepeatField) field.get(messageMicro);
            if (pBRepeatField == null) {
                return true;
            }
            boolean has = pBRepeatField.has();
            List list = pBRepeatField.get();
            if (z16 && (!has || list.isEmpty())) {
                return true;
            }
            if (!has) {
                String format = String.format("%s: [NA]", field.getName());
                sb5.append(str);
                sb5.append(format);
            } else {
                sb5.append(str);
                sb5.append(String.format("%s: [\n", field.getName()));
                for (Object obj : list) {
                    sb5.append(str);
                    sb5.append("    ");
                    sb5.append(obj);
                    if (obj != list.get(list.size() - 1)) {
                        sb5.append(",");
                    }
                    sb5.append("\n");
                }
                sb5.append(str);
                sb5.append("]");
            }
        }
        return false;
    }

    private static boolean dealPBRepeatMessageField(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, int i3, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        if (!atomicBoolean.get() && PBRepeatMessageField.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBRepeatMessageField pBRepeatMessageField = (PBRepeatMessageField) field.get(messageMicro);
            if (pBRepeatMessageField == null) {
                return true;
            }
            boolean has = pBRepeatMessageField.has();
            List<MessageMicro> list = pBRepeatMessageField.get();
            if (z16 && (!has || list.isEmpty())) {
                return true;
            }
            if (!has) {
                String format = String.format("%s: [NA]", field.getName());
                sb5.append(str);
                sb5.append(format);
            } else {
                sb5.append(str);
                sb5.append(String.format("%s: [\n", field.getName()));
                for (MessageMicro messageMicro2 : list) {
                    sb5.append(str);
                    sb5.append("    ");
                    sb5.append("{\n");
                    sb5.append(proto2String(messageMicro2, i3 + 2, z16));
                    sb5.append(str);
                    sb5.append("    ");
                    sb5.append("}");
                    if (messageMicro2 != list.get(list.size() - 1)) {
                        sb5.append(",");
                    }
                    sb5.append("\n");
                }
                sb5.append(str);
                sb5.append("]");
            }
        }
        return false;
    }

    private static boolean dealPBSFixed32Field(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        Object obj;
        if (!atomicBoolean.get() && PBSFixed32Field.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBSFixed32Field pBSFixed32Field = (PBSFixed32Field) field.get(messageMicro);
            if (pBSFixed32Field == null) {
                return true;
            }
            boolean has = pBSFixed32Field.has();
            int i3 = pBSFixed32Field.get();
            Object[] objArr = new Object[2];
            objArr[0] = field.getName();
            if (has) {
                obj = Integer.valueOf(i3);
            } else {
                obj = "NA";
            }
            objArr[1] = obj;
            String format = String.format("%s: %s", objArr);
            if (z16 && !has) {
                return true;
            }
            sb5.append(str);
            sb5.append(format);
        }
        return false;
    }

    private static boolean dealPBSFixed64Field(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        Object obj;
        if (!atomicBoolean.get() && PBSFixed64Field.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBSFixed64Field pBSFixed64Field = (PBSFixed64Field) field.get(messageMicro);
            if (pBSFixed64Field == null) {
                return true;
            }
            boolean has = pBSFixed64Field.has();
            long j3 = pBSFixed64Field.get();
            Object[] objArr = new Object[2];
            objArr[0] = field.getName();
            if (has) {
                obj = Long.valueOf(j3);
            } else {
                obj = "NA";
            }
            objArr[1] = obj;
            String format = String.format("%s: %s", objArr);
            if (z16 && !has) {
                return true;
            }
            sb5.append(str);
            sb5.append(format);
        }
        return false;
    }

    private static boolean dealPBSInt32Field(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        Object obj;
        if (atomicBoolean.get()) {
            return true;
        }
        if (PBSInt32Field.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBSInt32Field pBSInt32Field = (PBSInt32Field) field.get(messageMicro);
            if (pBSInt32Field == null) {
                return true;
            }
            boolean has = pBSInt32Field.has();
            int i3 = pBSInt32Field.get();
            Object[] objArr = new Object[2];
            objArr[0] = field.getName();
            if (has) {
                obj = Integer.valueOf(i3);
            } else {
                obj = "NA";
            }
            objArr[1] = obj;
            String format = String.format("%s: %s", objArr);
            if (z16 && !has) {
                return true;
            }
            sb5.append(str);
            sb5.append(format);
        }
        return false;
    }

    private static boolean dealPBSInt64Field(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        Object obj;
        if (atomicBoolean.get()) {
            return true;
        }
        if (PBSInt64Field.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBSInt64Field pBSInt64Field = (PBSInt64Field) field.get(messageMicro);
            if (pBSInt64Field == null) {
                return true;
            }
            boolean has = pBSInt64Field.has();
            long j3 = pBSInt64Field.get();
            Object[] objArr = new Object[2];
            objArr[0] = field.getName();
            if (has) {
                obj = Long.valueOf(j3);
            } else {
                obj = "NA";
            }
            objArr[1] = obj;
            String format = String.format("%s: %s", objArr);
            if (z16 && !has) {
                return true;
            }
            sb5.append(str);
            sb5.append(format);
        }
        return false;
    }

    private static boolean dealPBStringField(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        if (atomicBoolean.get()) {
            return true;
        }
        if (PBStringField.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBStringField pBStringField = (PBStringField) field.get(messageMicro);
            if (pBStringField == null) {
                return true;
            }
            boolean has = pBStringField.has();
            String str2 = pBStringField.get();
            Object[] objArr = new Object[2];
            objArr[0] = field.getName();
            if (!has) {
                str2 = "NA";
            }
            objArr[1] = str2;
            String format = String.format("%s: %s", objArr);
            if (z16 && !has) {
                return true;
            }
            sb5.append(str);
            sb5.append(format);
        }
        return false;
    }

    private static boolean dealPBUInt32Field(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        Object obj;
        if (atomicBoolean.get()) {
            return true;
        }
        if (PBUInt32Field.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBUInt32Field pBUInt32Field = (PBUInt32Field) field.get(messageMicro);
            if (pBUInt32Field == null) {
                return true;
            }
            boolean has = pBUInt32Field.has();
            int i3 = pBUInt32Field.get();
            Object[] objArr = new Object[2];
            objArr[0] = field.getName();
            if (has) {
                obj = Integer.valueOf(i3);
            } else {
                obj = "NA";
            }
            objArr[1] = obj;
            String format = String.format("%s: %s", objArr);
            if (z16 && !has) {
                return true;
            }
            sb5.append(str);
            sb5.append(format);
        }
        return false;
    }

    private static boolean dealPBUInt64Field(Class<?> cls, MessageMicro messageMicro, boolean z16, StringBuilder sb5, String str, Field field, AtomicBoolean atomicBoolean) throws IllegalAccessException {
        Object obj;
        if (atomicBoolean.get()) {
            return true;
        }
        if (PBUInt64Field.class.isAssignableFrom(cls)) {
            atomicBoolean.set(true);
            PBUInt64Field pBUInt64Field = (PBUInt64Field) field.get(messageMicro);
            if (pBUInt64Field == null) {
                return true;
            }
            boolean has = pBUInt64Field.has();
            long j3 = pBUInt64Field.get();
            Object[] objArr = new Object[2];
            objArr[0] = field.getName();
            if (has) {
                obj = Long.valueOf(j3);
            } else {
                obj = "NA";
            }
            objArr[1] = obj;
            String format = String.format("%s: %s", objArr);
            if (z16 && !has) {
                return true;
            }
            sb5.append(str);
            sb5.append(format);
        }
        return false;
    }

    public static int parseOIDBPkg(FromServiceMsg fromServiceMsg, Object obj, MessageMicro messageMicro) {
        return MqqInjectorManager.instance().parseOIDBPkg(fromServiceMsg, obj, messageMicro);
    }

    public static String proto2String(MessageMicro messageMicro) {
        return proto2String(messageMicro, true);
    }

    protected abstract void addBusinessObserver(ToServiceMsg toServiceMsg, BusinessObserver businessObserver, boolean z16);

    public abstract ToServiceMsg createToServiceMsg(String str);

    public ToServiceMsg makeOIDBPkg(String str, int i3, int i16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? makeOIDBPkg(str, i3, i16, bArr, 30000L) : (ToServiceMsg) iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), bArr);
    }

    public static int parseOIDBPkg(FromServiceMsg fromServiceMsg, Object obj, MessageMicro messageMicro, MessageMicro messageMicro2) {
        return MqqInjectorManager.instance().parseOIDBPkg(fromServiceMsg, obj, messageMicro, messageMicro2);
    }

    public static String proto2String(MessageMicro messageMicro, boolean z16) {
        return proto2String(messageMicro, 0, z16);
    }

    public ToServiceMsg makeOIDBPkg(String str, int i3, int i16, byte[] bArr, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? makeOIDBPkg(str, i3, i16, bArr, j3, null, false) : (ToServiceMsg) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16), bArr, Long.valueOf(j3));
    }

    public static String proto2String(MessageMicro messageMicro, int i3, boolean z16) {
        StringBuilder sb5 = new StringBuilder();
        String str = "";
        for (int i16 = i3; i16 > 0; i16--) {
            str = str + "    ";
        }
        if (messageMicro != null) {
            try {
                Field[] fields = messageMicro.getClass().getFields();
                for (Field field : fields) {
                    if (field != null) {
                        field.setAccessible(true);
                        Class<?> type = field.getType();
                        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                        if (!(dealPBBoolField(type, messageMicro, z16, sb5, str, field, atomicBoolean) | false | dealPBBytesField(type, messageMicro, z16, sb5, str, field, atomicBoolean) | dealPBDoubleField(type, messageMicro, z16, sb5, str, field, atomicBoolean) | dealPBEnumField(type, messageMicro, z16, sb5, str, field, atomicBoolean) | dealPBFixed32Field(type, messageMicro, z16, sb5, str, field, atomicBoolean) | dealPBFixed64Field(type, messageMicro, z16, sb5, str, field, atomicBoolean) | dealPBFloatField(type, messageMicro, z16, sb5, str, field, atomicBoolean) | dealPBInt32Field(type, messageMicro, z16, sb5, str, field, atomicBoolean) | dealPBInt64Field(type, messageMicro, z16, sb5, str, field, atomicBoolean) | dealPBSFixed32Field(type, messageMicro, z16, sb5, str, field, atomicBoolean) | dealPBSFixed64Field(type, messageMicro, z16, sb5, str, field, atomicBoolean) | dealPBSInt32Field(type, messageMicro, z16, sb5, str, field, atomicBoolean) | dealPBSInt64Field(type, messageMicro, z16, sb5, str, field, atomicBoolean) | dealPBStringField(type, messageMicro, z16, sb5, str, field, atomicBoolean) | dealPBUInt32Field(type, messageMicro, z16, sb5, str, field, atomicBoolean) | dealPBUInt64Field(type, messageMicro, z16, sb5, str, field, atomicBoolean) | dealPBRepeatField(type, messageMicro, z16, sb5, str, field, atomicBoolean) | dealPBRepeatMessageField(type, messageMicro, z16, sb5, str, field, i3, atomicBoolean) | dealMessageMicro(type, messageMicro, z16, sb5, str, field, i3, atomicBoolean))) {
                            if (!atomicBoolean.get()) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "unknown type {" + field.getName() + "|" + field.getType() + "}");
                                }
                            } else {
                                if (field != fields[fields.length - 1]) {
                                    sb5.append(",");
                                }
                                sb5.append("\n");
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                sb5.append("***ERROR***");
                sb5.append("\n");
                sb5.append(th5);
            }
        }
        return sb5.toString();
    }

    public ToServiceMsg makeOIDBPkg(String str, int i3, int i16, byte[] bArr, long j3, BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Integer.valueOf(i16), bArr, Long.valueOf(j3), businessObserver, Boolean.valueOf(z16));
        }
        ToServiceMsg makeOIDBPkg = MqqInjectorManager.instance().makeOIDBPkg(this, str, i3, i16, bArr, j3, businessObserver, z16);
        addBusinessObserver(makeOIDBPkg, businessObserver, z16);
        return makeOIDBPkg;
    }
}
