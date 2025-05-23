package com.tencent.bugly.common.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Printer;
import android.view.Choreographer;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.reflect.Field;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ReflectUtil {
    private static final String TAG = "RMonitor_util_ReflectUtil";
    private static final HashMap<String, FieldInfo> cacheFields = new HashMap<>(5);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class FieldInfo {
        private final Class<?> clz;
        private Field field;
        private final String fieldName;
        private boolean flag;

        public Field getField() {
            if (this.field == null && !this.flag) {
                try {
                    Field declaredField = this.clz.getDeclaredField(this.fieldName);
                    this.field = declaredField;
                    declaredField.setAccessible(true);
                } catch (Throwable th5) {
                    Logger.f365497g.e(ReflectUtil.TAG, this.fieldName, th5.getMessage());
                }
                this.flag = true;
            }
            return this.field;
        }

        FieldInfo(Class<?> cls, String str) {
            this.field = null;
            this.flag = false;
            this.clz = cls;
            this.fieldName = str;
        }
    }

    public static Printer getCurrentPrinter(Looper looper) {
        Object instancePrivateField = getInstancePrivateField(looper, "mLogging", true);
        if (instancePrivateField instanceof Printer) {
            return (Printer) instancePrivateField;
        }
        return null;
    }

    public static Field getField(Class<?> cls, String str) {
        FieldInfo fieldInfo;
        String format = String.format("%s#%s", cls.getSimpleName(), str);
        HashMap<String, FieldInfo> hashMap = cacheFields;
        synchronized (hashMap) {
            fieldInfo = hashMap.get(format);
            if (fieldInfo == null) {
                fieldInfo = new FieldInfo(cls, str);
                hashMap.put(format, fieldInfo);
            }
        }
        return fieldInfo.getField();
    }

    public static Handler getFrameHandlerOfChoreographer(Choreographer choreographer) {
        Object instancePrivateField = getInstancePrivateField(choreographer, "mHandler", true);
        if (instancePrivateField instanceof Handler) {
            return (Handler) instancePrivateField;
        }
        return null;
    }

    public static Object getInstancePrivateField(Object obj, String str) {
        return getInstancePrivateField(obj, str, false);
    }

    public static Message getNextOfMessage(Message message) {
        Object instancePrivateField = getInstancePrivateField(message, "next", true);
        if (instancePrivateField instanceof Message) {
            return (Message) instancePrivateField;
        }
        return null;
    }

    public static Message messageOfMessageQueue(MessageQueue messageQueue) {
        Object instancePrivateField = getInstancePrivateField(messageQueue, "mMessages", true);
        if (instancePrivateField instanceof Message) {
            return (Message) instancePrivateField;
        }
        return null;
    }

    public static MessageQueue messageQueue(Looper looper) {
        Object instancePrivateField = getInstancePrivateField(looper, "mQueue", true);
        if (instancePrivateField instanceof MessageQueue) {
            return (MessageQueue) instancePrivateField;
        }
        return null;
    }

    public static Object getInstancePrivateField(Object obj, String str, boolean z16) {
        Field declaredField;
        try {
            if (obj == null) {
                declaredField = null;
            } else if (z16) {
                declaredField = getField(obj.getClass(), str);
            } else {
                declaredField = obj.getClass().getDeclaredField(str);
                declaredField.setAccessible(true);
            }
            if (declaredField != null) {
                return declaredField.get(obj);
            }
            return null;
        } catch (Throwable th5) {
            Logger.f365497g.b(TAG, "getInstancePrivateField", th5);
            return null;
        }
    }
}
