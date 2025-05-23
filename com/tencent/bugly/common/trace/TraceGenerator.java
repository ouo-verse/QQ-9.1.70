package com.tencent.bugly.common.trace;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.common.constants.SPKey;
import com.tencent.bugly.common.sp.SharedPreferencesProvider;
import com.tencent.bugly.common.utils.ProcessUtil;
import com.tencent.bugly.common.utils.StringUtil;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.Random;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TraceGenerator {
    private static final int BYTE_RANGE = 255;
    public static final int SPAN_ID_LEN = 8;
    private static final String TAG = "RMonitor_trace";
    public static final int TRACE_ID_LEN = 16;
    private static final Random random = new Random();
    private static final String PROCESS_LAUNCH_ID = generateLaunchID();

    public static String generateLaunchID() {
        return StringUtil.getMD5(UUID.randomUUID().toString() + UUID.randomUUID().toString() + System.currentTimeMillis());
    }

    public static String generateRandomString(int i3) {
        byte[] bArr = new byte[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            bArr[i16] = (byte) (random.nextInt(255) - 128);
        }
        return StringUtil.bytes2HexStr(bArr).toUpperCase();
    }

    public static String generateSpanID() {
        return generateRandomString(8);
    }

    public static String generateTraceID() {
        return generateRandomString(16);
    }

    public static String getLaunchId(Context context) {
        if (ProcessUtil.isMainProcess(context)) {
            return PROCESS_LAUNCH_ID;
        }
        return getLaunchIdFromCache(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String getLaunchIdFromCache(Context context) {
        String string;
        if (context != null) {
            try {
                string = SharedPreferencesProvider.getInstance().getMultiProcessSP(context).getString(SPKey.KEY_TRACE_ID, PROCESS_LAUNCH_ID);
            } catch (Throwable th5) {
                Logger.f365497g.e(TAG, "getLaunchIdFromCache, e: " + th5.getMessage());
            }
            if (!TextUtils.isEmpty(string)) {
                return PROCESS_LAUNCH_ID;
            }
            return string;
        }
        string = "";
        if (!TextUtils.isEmpty(string)) {
        }
    }

    public static String getProcessLaunchId() {
        return PROCESS_LAUNCH_ID;
    }

    @SuppressLint({"ApplySharedPref"})
    public static void updateLaunchIdCache(Context context) {
        boolean isMainProcess = ProcessUtil.isMainProcess(context);
        if (isMainProcess) {
            try {
                SharedPreferencesProvider.getInstance().getMultiProcessSP(context).edit().putString(SPKey.KEY_TRACE_ID, PROCESS_LAUNCH_ID).commit();
            } catch (Throwable th5) {
                Logger.f365497g.e(TAG, "updateLaunchIdCache, e: " + th5.getMessage());
            }
        }
        Logger.f365497g.i(TAG, "updateLaunchIdCache, launchId: " + PROCESS_LAUNCH_ID + ", isMainProcess: " + isMainProcess);
    }
}
