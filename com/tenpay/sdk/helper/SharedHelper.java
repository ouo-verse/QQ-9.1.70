package com.tenpay.sdk.helper;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.wrapper.SoterWrapperApi;
import com.tenpay.QwLog;
import com.tenpay.api.QFuncProxy;
import com.tenpay.sdk.Cgi;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SharedHelper {
    public static final String QB_TENPAY_FP_ = "qb_tenpay_fp_";
    private static final String SOTER_BUSI_TYPE = "soter_busi_type";
    private static final String SOTER_ISOPENED = "soter_isopened";
    private static final String SOTER_OPEN_FID = "soter_open_fid";
    private static final String TAG = "SharedHelper";
    private static Lock lock = new ReentrantLock();

    /* renamed from: sp, reason: collision with root package name */
    private static SharedPreferences f386892sp = null;
    private static final String sp_name = "tenpay_sdk_config";

    public static boolean closeFinger(final String str) {
        QwLog.i("uin = " + str);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.helper.g
            @Override // java.lang.Runnable
            public final void run() {
                SharedHelper.lambda$closeFinger$0(str);
            }
        }, 64, null, false);
        return true;
    }

    public static String[] fingersLocal(String str) {
        return ((String) getValue(BaseApplication.getContext().getSharedPreferences(QB_TENPAY_FP_ + str, 0), SOTER_OPEN_FID, "")).split("\\|");
    }

    public static int getCurSoterBusiType(String str) {
        return ((Integer) getValue(BaseApplication.getContext().getSharedPreferences(QB_TENPAY_FP_ + str, 0), "soter_busi_type", (Object) 1)).intValue();
    }

    public static Object getUValue(Context context, String str, String str2, Object obj) {
        init(context);
        return getValue(f386892sp, str2 + "_" + QFuncProxy.md5(str.getBytes()), obj);
    }

    public static Object getValue(Context context, String str, Object obj) {
        init(context);
        return getValue(f386892sp, str, obj);
    }

    private static void init(Context context) {
        synchronized (SharedHelper.class) {
            if (f386892sp == null) {
                f386892sp = context.getSharedPreferences(sp_name, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$closeFinger$0(String str) {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(QB_TENPAY_FP_ + str, 0);
        setValue(sharedPreferences, SOTER_OPEN_FID, "");
        setValue(sharedPreferences, SOTER_ISOPENED, Boolean.FALSE);
        try {
            SoterWrapperApi.removeAuthKeyByScene(Cgi.scene_FingerPay);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    public static boolean openFinger(String str, String str2, int i3) {
        QwLog.i("uin = " + str);
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(QB_TENPAY_FP_ + str, 0);
        setValue(sharedPreferences, SOTER_OPEN_FID, str2);
        setValue(sharedPreferences, SOTER_ISOPENED, Boolean.TRUE);
        setValue(sharedPreferences, "soter_busi_type", Integer.valueOf(i3));
        return true;
    }

    public static void setUValue(Context context, String str, String str2, Object obj) {
        init(context);
        setValue(f386892sp, str2 + "_" + QFuncProxy.md5(str.getBytes()), obj);
    }

    public static void setValue(Context context, String str, Object obj) {
        init(context);
        setValue(f386892sp, str, obj);
    }

    public static boolean soterOpen(String str) {
        return ((Boolean) getValue(BaseApplication.getContext().getSharedPreferences(QB_TENPAY_FP_ + str, 0), SOTER_ISOPENED, Boolean.FALSE)).booleanValue();
    }

    public static boolean updateFingersLocal(String str, List<String> list, String str2) {
        QwLog.i("new finger = " + str2);
        if (list == null) {
            list = Arrays.asList(fingersLocal(str));
        }
        if (list.contains(str2)) {
            QwLog.i("fingee has contained in local...");
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer(str2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            stringBuffer.append("|");
            stringBuffer.append(list.get(i3));
        }
        QwLog.i("finnal fingers = " + ((Object) stringBuffer));
        setValue(BaseApplication.getContext().getSharedPreferences(QB_TENPAY_FP_ + str, 0), SOTER_OPEN_FID, stringBuffer.toString());
        return true;
    }

    private static Object getValue(SharedPreferences sharedPreferences, String str, Object obj) {
        Object string;
        lock.lock();
        if (obj == null) {
            obj = "";
        }
        try {
            if (obj.getClass() == Integer.class) {
                string = Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
            } else if (obj.getClass() == Boolean.class) {
                string = Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
            } else if (obj.getClass() == Float.class) {
                string = Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
            } else if (obj.getClass() == Long.class) {
                string = Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
            } else {
                if (obj.getClass() != String.class) {
                    return obj;
                }
                string = sharedPreferences.getString(str, (String) obj);
            }
            return string;
        } finally {
            lock.unlock();
        }
    }

    private static void setValue(SharedPreferences sharedPreferences, String str, Object obj) {
        lock.lock();
        if (obj == null) {
            obj = "";
        }
        try {
            if (obj.getClass() == Integer.class) {
                sharedPreferences.edit().putInt(str, ((Integer) obj).intValue()).commit();
            } else if (obj.getClass() == Boolean.class) {
                sharedPreferences.edit().putBoolean(str, ((Boolean) obj).booleanValue()).commit();
            } else if (obj.getClass() == Float.class) {
                sharedPreferences.edit().putFloat(str, ((Float) obj).floatValue()).commit();
            } else if (obj.getClass() == Long.class) {
                sharedPreferences.edit().putLong(str, ((Long) obj).longValue()).commit();
            } else if (obj.getClass() == String.class) {
                sharedPreferences.edit().putString(str, (String) obj).commit();
            }
        } finally {
            lock.unlock();
        }
    }
}
