package com.tencent.mobileqq.qqlive.trtc.audio.audioeffect;

import androidx.annotation.Keep;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/* compiled from: P */
@Keep
/* loaded from: classes17.dex */
public class RTCMusicAccompanyStateStrategy {
    static IPatchRedirector $redirector_ = null;
    private static final int RTC_API_BASE = 1;

    @Permit(values = {6, 7, 10, 11, 9})
    public static final int RTC_API_GET_DURATION = 21;

    @Permit(values = {1, 5, 6, 7, 10, 11, 9})
    public static final int RTC_API_GET_POSITION = 23;

    @Permit(values = {6})
    public static final int RTC_API_PAUSE = 8;

    @Permit(values = {7, 9})
    public static final int RTC_API_RESUME = 6;

    @Permit(values = {6, 7, 9})
    public static final int RTC_API_SEEK_TO = 14;

    @Permit(values = {1, 5, 6, 7, 9})
    public static final int RTC_API_SET_LOOP_BACK = 16;

    @Permit(values = {1, 11})
    public static final int RTC_API_START = 7;

    @Permit(values = {5, 6, 7, 9, 12})
    public static final int RTC_API_STOP = 9;

    @Permit(values = {6, 7, 9})
    public static final int RTC_API_SWITCH_ACCOMPANY_TYPE = 15;
    private static final int RTC_CB_BASE = 100;

    @Permit(values = {5, 6, 7})
    public static final int RTC_CB_ON_COMPLETE = 102;

    @Permit(values = {5, 6, 7})
    public static final int RTC_CB_ON_ERROR = 104;

    @Permit(values = {5})
    public static final int RTC_CB_ON_STARTED = 101;
    private static final String TAG = "RTCMusicAccompanyStateStrategy";

    /* compiled from: P */
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface API {
    }

    /* compiled from: P */
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface Callback {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes17.dex */
    public @interface Permit {
        int[] values() default {0};
    }

    public RTCMusicAccompanyStateStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean permission(int i3, int i16) {
        try {
            Class<?> cls = Class.forName(RTCMusicAccompanyStateStrategy.class.getName());
            Field[] declaredFields = cls.getDeclaredFields();
            QLog.e(TAG, 1, "permission: cmd:" + i3 + ", clazz:" + cls);
            int length = declaredFields.length;
            for (int i17 = 0; i17 < length; i17++) {
                Field field = declaredFields[i17];
                if (field.getType().toString().equals(PoiListCacheRecord.WEIGHT_TYPE)) {
                    field.setAccessible(true);
                    if (i3 == field.getInt(cls)) {
                        Permit permit = (Permit) field.getAnnotation(Permit.class);
                        QLog.e(TAG, 1, "permission: field:" + field);
                        QLog.e(TAG, 1, "permission: permit:" + permit);
                        if (permit == null) {
                            return false;
                        }
                        for (int i18 : permit.values()) {
                            if (i16 == i18) {
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        return false;
    }

    public static boolean validStateCall(int i3, RTCMusicAccompanyState rTCMusicAccompanyState) {
        return permission(i3, rTCMusicAccompanyState.c());
    }

    public static boolean validStateCallback(int i3, RTCMusicAccompanyState rTCMusicAccompanyState) {
        return permission(i3, rTCMusicAccompanyState.c());
    }
}
