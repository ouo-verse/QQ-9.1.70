package com.tencent.tav;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.tav.decoder.logger.Logger;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes26.dex */
public class Utils {
    private static final String FIELD_NAME_HANDLER_M_QUEUE = "mQueue";
    private static final String FIELD_NAME_MESSAGE_NEXT = "next";
    private static final String FIELD_NAME_MESSAGE_QUEUE_M_MESSAGES = "mMessages";
    private static final String TAG = "Utils";
    public static final long UNIT_TIME = 1000;
    public static final long UNIT_TIME_NS_TO_MS = 1000000;
    public static final long UNIT_TIME_NS_TO_US = 1000;

    public static <T> boolean arrayContains(T[] tArr, T t16) {
        for (T t17 : tArr) {
            if (Objects.equals(t16, t17)) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap flipYBitmap(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, -1.0f, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    @NonNull
    public static ArrayList<Message> getContinuesMessage(int i3, Class cls, Handler handler) throws NoSuchFieldException, IllegalAccessException {
        Message messageFromHandler = getMessageFromHandler(handler);
        ArrayList<Message> arrayList = new ArrayList<>();
        while (messageFromHandler != null) {
            if (messageFromHandler.what == i3 && cls.isInstance(messageFromHandler.obj)) {
                arrayList.add(messageFromHandler);
            } else if (messageFromHandler.getTarget() == handler) {
                break;
            }
            Field declaredField = Message.class.getDeclaredField(FIELD_NAME_MESSAGE_NEXT);
            declaredField.setAccessible(true);
            messageFromHandler = (Message) declaredField.get(messageFromHandler);
        }
        return arrayList;
    }

    public static long getCurrentUsTime() {
        return System.nanoTime() / 1000;
    }

    @Nullable
    public static Object getDeclaredFieldValue(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        if (obj == null) {
            return null;
        }
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Message getMessageFromHandler(Handler handler) throws NoSuchFieldException, IllegalAccessException {
        MessageQueue queue = handler.getLooper().getQueue();
        Field declaredField = MessageQueue.class.getDeclaredField(FIELD_NAME_MESSAGE_QUEUE_M_MESSAGES);
        declaredField.setAccessible(true);
        return (Message) declaredField.get(queue);
    }

    public static String getPhoneName() {
        String str = Build.MANUFACTURER.toUpperCase() + " " + DeviceInfoMonitor.getModel();
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace(" ", "_").replace(Marker.ANY_NON_NULL_MARKER, "").replace("(t)", "");
    }

    public static <T> T getDeclaredFieldValue(Class<T> cls, Object obj, String str, T t16) {
        if (Build.VERSION.SDK_INT > 29) {
            Logger.d("Utils", "getDeclaredField: sdk > 29, return defaultValue");
            return t16;
        }
        try {
            T t17 = (T) getDeclaredFieldValue(obj, str);
            return (t17 == null || !t17.getClass().equals(cls)) ? t16 : t17;
        } catch (IllegalAccessException | NoSuchFieldException e16) {
            Logger.w("Utils", "getDeclaredField: " + e16);
            return t16;
        }
    }
}
