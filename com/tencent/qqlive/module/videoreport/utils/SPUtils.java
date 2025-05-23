package com.tencent.qqlive.module.videoreport.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.content.SharedPreferencesCompat;
import android.text.TextUtils;

/* loaded from: classes22.dex */
public class SPUtils {
    public static final String LAST_APP_HEART_BEAT_MAP = "last_app_heart_beat_map";
    public static final String LAST_AUDIO_HEART_BEAT_MAP = "last_audio_heart_beat_map";
    public static final String PREF_DEVICE_ACTIVATED = "pref_device_activated";
    private static final String VIDEO_REPORT_PROFILE = "video_report_profile";
    public static SharedPreferences sSharePreferences;

    /* JADX WARN: Type inference failed for: r0v2, types: [E, java.lang.String] */
    @NonNull
    public static <E> E get(@NonNull Context context, String str, @NonNull String str2, @NonNull E e16) {
        ?? r06 = (E) init(context, str).getString(str2, String.valueOf(e16));
        if (e16 instanceof String) {
            return r06;
        }
        if (e16 instanceof Integer) {
            return (E) Integer.valueOf((String) r06);
        }
        if (e16 instanceof Boolean) {
            return (E) Boolean.valueOf((String) r06);
        }
        if (e16 instanceof Float) {
            return (E) Float.valueOf((String) r06);
        }
        if (e16 instanceof Long) {
            return (E) Long.valueOf((String) r06);
        }
        return e16 instanceof Double ? (E) Double.valueOf((String) r06) : e16;
    }

    public static SharedPreferences.Editor getEdit(@NonNull Context context, String str) {
        return init(context, str).edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences init(@NonNull Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            SharedPreferences sharedPreferences = sSharePreferences;
            if (sharedPreferences == null) {
                SharedPreferences sharedPreferences2 = context.getSharedPreferences(VIDEO_REPORT_PROFILE, 0);
                sSharePreferences = sharedPreferences2;
                return sharedPreferences2;
            }
            return sharedPreferences;
        }
        return context.getSharedPreferences(str, 0);
    }

    public static void preInitAsync(@NonNull final Context context) {
        com.tencent.qqlive.module.videoreport.task.ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.utils.a
            @Override // java.lang.Runnable
            public final void run() {
                SPUtils.init(context, null);
            }
        });
    }

    public static <E> void put(@NonNull Context context, @NonNull String str, @NonNull E e16) {
        put(context, null, str, e16);
    }

    public static <E> void put(@NonNull Context context, String str, @NonNull String str2, @NonNull E e16) {
        SharedPreferences.Editor edit = init(context, str).edit();
        if ((e16 instanceof String) || (e16 instanceof Integer) || (e16 instanceof Boolean) || (e16 instanceof Float) || (e16 instanceof Long) || (e16 instanceof Double)) {
            edit.putString(str2, String.valueOf(e16));
        }
        SharedPreferencesCompat.EditorCompat.getInstance().apply(edit);
    }

    @NonNull
    public static <E> E get(@NonNull Context context, @NonNull String str, @NonNull E e16) {
        return (E) get(context, null, str, e16);
    }
}
