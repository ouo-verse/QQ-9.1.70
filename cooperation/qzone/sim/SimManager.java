package cooperation.qzone.sim;

import android.content.Context;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import n.b;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class SimManager {
    static final int MAIN_SIM_INDEX = 10;
    static final int RET_IS_MUTI_SIM = 10;
    static final int RET_IS_NOT_MUTI_SIM = 11;
    static final int RET_NO_SUCH_METHOD = -2;
    static final int RET_OTHER_WORNG = -3;
    static final int RET_SUCCESS = 0;
    private static final String TAG = "UniKingCardHelper/SimManager";
    static final int TRY_SIM_INDEX = 9;
    private static SimManager mInstance;
    HashMap<Integer, SimInfo> mSinInfos = new HashMap<>();
    DeviceMoreInfo mDeviceMoreInfo = new DeviceMoreInfo();

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class DeviceMoreInfo {
        public boolean mIsMultiSimEnabled = false;
        public int mSubCount = 0;
        public int mUseSimCount = 0;
        public SimInfo mDataSimInfo = null;
        public SimInfo mSencondarySimInfo = null;
        public long mGetInfoCostTime = 0;

        DeviceMoreInfo() {
        }
    }

    private void addSimInfo(int i3, SimInfo simInfo) {
        HashMap<Integer, SimInfo> hashMap = this.mSinInfos;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(i3), simInfo);
        }
    }

    private void clear() {
        HashMap<Integer, SimInfo> hashMap = this.mSinInfos;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static SimManager getInstance(String str, int i3) {
        if (mInstance == null) {
            mInstance = SimManagerFectory.createProduct(str, i3);
        }
        return mInstance;
    }

    private int initMainIMSI(Context context) {
        try {
            updataSimImsi(10, PlatformInfor.g().getIMSI());
            updataSimDataEnable(10, Boolean.TRUE);
            return 0;
        } catch (Throwable th5) {
            QZLog.e(TAG, "initMainIMSI error:" + th5.getMessage());
            return -3;
        }
    }

    private int initMainPhoneNum(Context context) {
        try {
            updataSimPhoneNum(10, DeviceInfoUtil.getPhoneNum(context));
            return 0;
        } catch (Throwable th5) {
            QZLog.e(TAG, "initMainPhoneNum error:" + th5.getMessage());
            return -3;
        }
    }

    public SimInfo getDataSimInfo() {
        SimInfo simInfo;
        if (this.mSinInfos != null) {
            for (int i3 = 0; i3 <= 10; i3++) {
                SimInfo simInfo2 = getSimInfo(i3);
                if (simInfo2 != null && simInfo2.isIseDataTrafficSim() && !TextUtils.isEmpty(simInfo2.getPhoneNum())) {
                    return simInfo2;
                }
            }
        }
        if (this.mSinInfos != null) {
            for (int i16 = 0; i16 <= 10; i16++) {
                SimInfo simInfo3 = getSimInfo(i16);
                if (simInfo3 != null && simInfo3.isIseDataTrafficSim()) {
                    return simInfo3;
                }
            }
        }
        if (this.mSinInfos != null && (simInfo = getSimInfo(10)) != null && !TextUtils.isEmpty(simInfo.getPhoneNum())) {
            return simInfo;
        }
        if (this.mSinInfos == null) {
            return null;
        }
        for (int i17 = 0; i17 <= 10; i17++) {
            SimInfo simInfo4 = getSimInfo(i17);
            if (simInfo4 != null) {
                return simInfo4;
            }
        }
        return null;
    }

    public DeviceMoreInfo getDeviceMoreInfo() {
        return this.mDeviceMoreInfo;
    }

    public SimInfo getSencodarySimInfo() {
        SimInfo dataSimInfo;
        if (this.mSinInfos == null || (dataSimInfo = getDataSimInfo()) == null) {
            return null;
        }
        for (int i3 = 0; i3 <= 10; i3++) {
            SimInfo simInfo = getSimInfo(i3);
            if (simInfo != null && !TextUtils.isEmpty(simInfo.getIMSI()) && !TextUtils.isEmpty(simInfo.getPhoneNum()) && !simInfo.getIMSI().equals(dataSimInfo.getIMSI()) && !simInfo.getPhoneNum().equals(dataSimInfo.getPhoneNum())) {
                return simInfo;
            }
        }
        for (int i16 = 0; i16 <= 10; i16++) {
            SimInfo simInfo2 = getSimInfo(i16);
            if (simInfo2 != null && !TextUtils.isEmpty(simInfo2.getPhoneNum()) && !simInfo2.getPhoneNum().equals(dataSimInfo.getPhoneNum())) {
                return simInfo2;
            }
        }
        for (int i17 = 0; i17 <= 10; i17++) {
            SimInfo simInfo3 = getSimInfo(i17);
            if (simInfo3 != null && !TextUtils.isEmpty(simInfo3.getIMSI()) && !simInfo3.getIMSI().equals(dataSimInfo.getIMSI())) {
                return simInfo3;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimInfo getSimInfo(int i3) {
        HashMap<Integer, SimInfo> hashMap = this.mSinInfos;
        if (hashMap == null || !hashMap.containsKey(Integer.valueOf(i3))) {
            return null;
        }
        return this.mSinInfos.get(Integer.valueOf(i3));
    }

    public SimInfo getSimInfoOfIMSI(String str) {
        if (this.mSinInfos == null || TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i3 = 0; i3 < 10; i3++) {
            SimInfo simInfo = getSimInfo(i3);
            if (simInfo != null && str.equals(simInfo.getIMSI()) && !TextUtils.isEmpty(simInfo.getPhoneNum())) {
                return simInfo;
            }
        }
        for (int i16 = 0; i16 <= 10; i16++) {
            SimInfo simInfo2 = getSimInfo(i16);
            if (simInfo2 != null && str.equals(simInfo2.getIMSI())) {
                return simInfo2;
            }
        }
        return null;
    }

    abstract int initAllDataByAIDL(b bVar) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, ClassCastException;

    abstract int initAllDataByAPI(Context context, int[] iArr) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, ClassCastException;

    abstract int initAllIMSI(Context context, int[] iArr) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, ClassCastException;

    public void initAllInfo(Context context) {
        if (context == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            clear();
            initMainIMSI(context);
            initMainPhoneNum(context);
            b isub = getIsub();
            int i3 = 2;
            int[] iArr = null;
            if (isub != null) {
                try {
                    iArr = isub.Z0();
                    if (iArr != null) {
                        i3 = iArr.length;
                    }
                } catch (Throwable th5) {
                    QZLog.e(TAG, "getActiveSubIdList error:" + th5.getMessage());
                }
            }
            this.mDeviceMoreInfo.mSubCount = i3;
            if (i3 > 1 && isMultiSimEnabled(context) != 11) {
                this.mDeviceMoreInfo.mIsMultiSimEnabled = true;
                initAllIMSI(context, iArr);
                initAllPhoneNum(context, iArr);
                if (initAllDataByAIDL(isub) != 0) {
                    initAllDataByAPI(context, iArr);
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    abstract int initAllPhoneNum(Context context, int[] iArr) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, ClassCastException;

    int isMultiSimEnabled(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Method method = TelephonyManager.class.getMethod("isMultiSimEnabled", new Class[0]);
            if (method != null) {
                return ((Boolean) method.invoke(telephonyManager, new Object[0])).booleanValue() ? 10 : 11;
            }
            return -3;
        } catch (Throwable th5) {
            QZLog.e(TAG, "isMultiSimEnabled error:" + th5.getMessage());
            return -3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updataSimDataEnable(int i3, Boolean bool) {
        SimInfo simInfo = getSimInfo(i3);
        if (simInfo == null) {
            simInfo = new SimInfo();
        }
        simInfo.setIsDataTrafficSim(bool.booleanValue());
        addSimInfo(i3, simInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updataSimImsi(int i3, String str) {
        SimInfo simInfo = getSimInfo(i3);
        if (simInfo == null) {
            simInfo = new SimInfo();
        }
        simInfo.setIMSI(str);
        addSimInfo(i3, simInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updataSimPhoneNum(int i3, String str) {
        SimInfo simInfo = getSimInfo(i3);
        if (simInfo == null) {
            simInfo = new SimInfo();
        }
        simInfo.setPhoneNum(str);
        addSimInfo(i3, simInfo);
    }

    public void updateAllSimInfo() {
        try {
            if (this.mSinInfos != null) {
                this.mDeviceMoreInfo.mDataSimInfo = getDataSimInfo();
                this.mDeviceMoreInfo.mSencondarySimInfo = getSencodarySimInfo();
                DeviceMoreInfo deviceMoreInfo = this.mDeviceMoreInfo;
                SimInfo simInfo = deviceMoreInfo.mDataSimInfo;
                if (simInfo != null && deviceMoreInfo.mSencondarySimInfo != null) {
                    deviceMoreInfo.mUseSimCount = 2;
                } else {
                    if (simInfo == null && deviceMoreInfo.mSencondarySimInfo == null) {
                        deviceMoreInfo.mUseSimCount = 0;
                    }
                    deviceMoreInfo.mUseSimCount = 1;
                }
            }
        } catch (Exception e16) {
            QZLog.e(TAG, "error:" + e16.getMessage());
        }
    }

    private b getIsub() {
        try {
            return b.a.j((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "isub"));
        } catch (Throwable th5) {
            QZLog.e(TAG, "getIsub error:" + th5.getMessage());
            return null;
        }
    }
}
