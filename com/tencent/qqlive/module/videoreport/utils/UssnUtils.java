package com.tencent.qqlive.module.videoreport.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.content.SharedPreferencesCompat;

/* compiled from: P */
/* loaded from: classes22.dex */
public class UssnUtils {
    private static final int DEFAULT_NO_USSN = 0;
    private static final String DT_USSN_SP_KEY = "dt_ussn_sp_key";
    private static final String USSN_SP_PROFILE = "ussn_sp_profile";
    private static volatile long sUssn;

    /* renamed from: sp, reason: collision with root package name */
    public static SharedPreferences f345334sp;

    private static synchronized long generateNewUssnAndCache() {
        long currentTimeMillis;
        synchronized (UssnUtils.class) {
            currentTimeMillis = System.currentTimeMillis() * 1000;
            saveUssn(currentTimeMillis);
        }
        return currentTimeMillis;
    }

    public static synchronized long generateUssn() {
        synchronized (UssnUtils.class) {
            if (sUssn > 0) {
                sUssn = updateUssnAndCache(sUssn);
                return sUssn;
            }
            long ussnFromSP = getUssnFromSP();
            if (ussnFromSP > 0) {
                sUssn = updateUssnAndCache(ussnFromSP);
                return sUssn;
            }
            sUssn = generateNewUssnAndCache();
            return sUssn;
        }
    }

    private static long getUssnFromSP() {
        Context context = ReportUtils.getContext();
        if (context == null) {
            return 0L;
        }
        return init(context).getLong(DT_USSN_SP_KEY, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences init(@NonNull Context context) {
        if (f345334sp == null) {
            f345334sp = context.getSharedPreferences(USSN_SP_PROFILE, 0);
        }
        return f345334sp;
    }

    public static void preInitAsync(@NonNull final Context context) {
        com.tencent.qqlive.module.videoreport.task.ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                UssnUtils.init(context);
            }
        });
    }

    private static synchronized void saveUssn(long j3) {
        synchronized (UssnUtils.class) {
            Context context = ReportUtils.getContext();
            if (context == null) {
                return;
            }
            SharedPreferences.Editor edit = init(context).edit();
            edit.putLong(DT_USSN_SP_KEY, j3);
            SharedPreferencesCompat.EditorCompat.getInstance().apply(edit);
        }
    }

    private static synchronized long updateUssnAndCache(long j3) {
        long j16;
        synchronized (UssnUtils.class) {
            j16 = j3 + 1;
            saveUssn(j16);
        }
        return j16;
    }
}
