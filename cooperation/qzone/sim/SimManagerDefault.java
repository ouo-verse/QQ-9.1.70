package cooperation.qzone.sim;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import n.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes38.dex */
public class SimManagerDefault extends SimManager {
    static final int INVOKE_TYPE_DATA = 3;
    static final int INVOKE_TYPE_IMSI = 1;
    static final int INVOKE_TYPE_PHONE_NUM = 2;
    static final int METHOD_NONE = -1;
    protected static final String TAG = "UniKingCardHelper/SimManager";
    static int mMethodDataIndex = -1;
    static int mMethodIMSIIndex = -1;
    static int mMethodPhoneNumIndex = -1;

    /* JADX WARN: Can't wrap try/catch for region: R(17:53|54|55|8|(0)|(2:35|36)|(3:37|38|39)|11|(0)|24|25|26|27|28|15|16|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c8, code lost:
    
        r12 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00cc, code lost:
    
        cooperation.qzone.util.QZLog.e(cooperation.qzone.sim.SimManagerDefault.TAG, "initAllDataByAPI 4 error:" + r12.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ca, code lost:
    
        r12 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00cb, code lost:
    
        r4 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00eb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f6 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    @Override // cooperation.qzone.sim.SimManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int initAllDataByAPI(Context context, int[] iArr) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, ClassCastException {
        boolean z16;
        int i3;
        int i16;
        boolean z17;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        Class<?> cls = telephonyManager.getClass();
        int i17 = mMethodDataIndex;
        boolean z18 = false;
        Method method = null;
        if (i17 == -1 || i17 == 1) {
            try {
                method = cls.getDeclaredMethod("initAllDataByAPI", Integer.TYPE);
                mMethodDataIndex = 1;
            } catch (Throwable th5) {
                QZLog.e(TAG, "initAllDataByAPI 1 error:" + th5.getMessage());
            }
        }
        int i18 = mMethodDataIndex;
        if (i18 == -1 || i18 == 2) {
            try {
                method = cls.getDeclaredMethod("initAllDataByAPI", Long.TYPE);
                try {
                    mMethodDataIndex = 2;
                    z16 = false;
                } catch (Throwable th6) {
                    th = th6;
                    z16 = false;
                    QZLog.e(TAG, "initAllDataByAPI 2 error:" + th.getMessage());
                    i3 = mMethodDataIndex;
                    if (i3 != -1) {
                    }
                    try {
                        method = cls.getDeclaredMethod("getDataEnabled", Integer.TYPE);
                    } catch (Throwable th7) {
                        th = th7;
                    }
                    try {
                        mMethodDataIndex = 3;
                        z16 = true;
                    } catch (Throwable th8) {
                        th = th8;
                        z16 = true;
                        QZLog.e(TAG, "initAllDataByAPI 3 error:" + th.getMessage());
                        i16 = mMethodDataIndex;
                        if (i16 != -1) {
                        }
                        method = cls.getDeclaredMethod("getDataEnabled", Long.TYPE);
                        mMethodDataIndex = 4;
                        z17 = z18;
                        Method method2 = method;
                        return mMethodDataIndex == -1 ? -2 : -2;
                    }
                    i16 = mMethodDataIndex;
                    if (i16 != -1) {
                    }
                    method = cls.getDeclaredMethod("getDataEnabled", Long.TYPE);
                    mMethodDataIndex = 4;
                    z17 = z18;
                    Method method22 = method;
                    if (mMethodDataIndex == -1) {
                    }
                }
            } catch (Throwable th9) {
                th = th9;
                z16 = true;
            }
        } else {
            z16 = true;
        }
        i3 = mMethodDataIndex;
        if (i3 != -1 || i3 == 3) {
            method = cls.getDeclaredMethod("getDataEnabled", Integer.TYPE);
            mMethodDataIndex = 3;
            z16 = true;
        }
        i16 = mMethodDataIndex;
        if (i16 != -1 || i16 == 4) {
            method = cls.getDeclaredMethod("getDataEnabled", Long.TYPE);
            mMethodDataIndex = 4;
            z17 = z18;
        } else {
            z17 = z16;
        }
        Method method222 = method;
        if (mMethodDataIndex == -1 && method222 != null) {
            return invokeMethod(3, telephonyManager, iArr, method222, z17);
        }
    }

    @Override // cooperation.qzone.sim.SimManager
    public int initAllIMSI(Context context, int[] iArr) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, ClassCastException {
        return -2;
    }

    @Override // cooperation.qzone.sim.SimManager
    protected int initAllPhoneNum(Context context, int[] iArr) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, ClassCastException {
        return -3;
    }

    @Override // cooperation.qzone.sim.SimManager
    public int initAllDataByAIDL(b bVar) {
        SimInfo simInfo;
        if (bVar == null) {
            return -2;
        }
        try {
            int O2 = bVar.O2();
            if (O2 < 0) {
                return -3;
            }
            int i3 = 0;
            while (true) {
                boolean z16 = true;
                if (i3 > 10) {
                    break;
                }
                SimInfo simInfo2 = getSimInfo(i3);
                if (simInfo2 != null) {
                    if (i3 != O2) {
                        z16 = false;
                    }
                    simInfo2.setIsDataTrafficSim(z16);
                }
                i3++;
            }
            SimInfo simInfo3 = getSimInfo(O2);
            if (simInfo3 != null && !TextUtils.isEmpty(simInfo3.getIMSI()) && (simInfo = getSimInfo(10)) != null && simInfo3.getIMSI().equals(simInfo.getIMSI())) {
                simInfo.setIsDataTrafficSim(true);
            }
            return 0;
        } catch (Throwable th5) {
            QZLog.e(TAG, "initAllDataByAIDL 1 error:" + th5.getMessage());
            return -3;
        }
    }

    int invokeMethod(int i3, TelephonyManager telephonyManager, int[] iArr, Method method, boolean z16) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, ClassCastException {
        int i16;
        Object invoke;
        boolean z17;
        for (0; i16 < 9; i16 + 1) {
            if (iArr != null && iArr.length > 0) {
                int length = iArr.length;
                int i17 = 0;
                while (true) {
                    if (i17 >= length) {
                        z17 = false;
                        break;
                    }
                    if (iArr[i17] == i16) {
                        z17 = true;
                        break;
                    }
                    i17++;
                }
                i16 = z17 ? 0 : i16 + 1;
            }
            if (z16) {
                invoke = method.invoke(telephonyManager, Integer.valueOf(i16));
            } else {
                invoke = method.invoke(telephonyManager, Long.valueOf(i16));
            }
            if (invoke != null) {
                if (i3 == 1) {
                    updataSimImsi(i16, invoke.toString());
                } else if (i3 == 2) {
                    updataSimPhoneNum(i16, invoke.toString());
                } else if (i3 == 3) {
                    updataSimDataEnable(i16, (Boolean) invoke);
                }
            }
        }
        return 0;
    }
}
