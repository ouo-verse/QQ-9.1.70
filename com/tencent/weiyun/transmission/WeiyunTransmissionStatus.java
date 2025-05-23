package com.tencent.weiyun.transmission;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class WeiyunTransmissionStatus {
    static IPatchRedirector $redirector_ = null;
    private static final SparseIntArray DEFAULT_VALUE;
    private static final SparseArray<String> KEY_MAP_4_GLOBAL;
    private static final SparseArray<String> KEY_MAP_4_USER;
    private static final String SP_NAME = "com.tencent.weiyun.pref.transmission_status";
    private static final String TAG = "WeiyunTransmissionStatus";
    public static final int TYPE_BACKGROUND_MODE = 6;
    public static final int TYPE_LOGIN_STATUS = 4;
    public static final int TYPE_NETWORK_STATUS = 5;
    public static final int TYPE_SERVER_IP = 1;
    public static final int TYPE_TRAN_ONLY_WIFI = 3;
    public static final int TYPE_UPLOAD_SERVER_IP = 2;
    public static final int VALUE_INVALID = -1;
    public static final int VALUE_NO = 1;
    public static final int VALUE_SERVER_IP_DEV = 2;
    public static final int VALUE_SERVER_IP_EXP = 4;
    public static final int VALUE_SERVER_IP_RELEASE = 1;
    public static final int VALUE_SERVER_IP_TEST = 3;
    public static final int VALUE_UPLOAD_SERVER_IP_RELEASE = 0;
    public static final int VALUE_UPLOAD_SERVER_IP_TEST = 5;
    public static final int VALUE_YES = 0;
    private static Singleton<WeiyunTransmissionStatus, Void> sInstance;
    private final SparseArray<HashSet<StatusChangeListener>> mListeners;
    private final SparseIntArray mValues;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface StatusChangeListener {
        void onStatusChanged(int i3, int i16, int i17);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11606);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        KEY_MAP_4_GLOBAL = sparseArray;
        sparseArray.put(1, "key_server_ip");
        sparseArray.put(2, "key_upload_server_ip");
        SparseArray<String> sparseArray2 = new SparseArray<>();
        KEY_MAP_4_USER = sparseArray2;
        sparseArray2.put(3, "key_tran_only_wifi");
        SparseIntArray sparseIntArray = new SparseIntArray();
        DEFAULT_VALUE = sparseIntArray;
        sparseIntArray.put(1, 1);
        sparseIntArray.put(2, 0);
        sparseIntArray.put(3, 1);
        sparseIntArray.put(4, 1);
        sparseIntArray.put(5, -1);
        sparseIntArray.put(6, 1);
        sInstance = new Singleton<WeiyunTransmissionStatus, Void>() { // from class: com.tencent.weiyun.transmission.WeiyunTransmissionStatus.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.weiyun.utils.Singleton
            public WeiyunTransmissionStatus create(Void r46) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new WeiyunTransmissionStatus(null) : (WeiyunTransmissionStatus) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46);
            }
        };
    }

    /* synthetic */ WeiyunTransmissionStatus(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            return;
        }
        iPatchRedirector.redirect((short) 16, (Object) this, (Object) anonymousClass1);
    }

    public static WeiyunTransmissionStatus getInstance() {
        return sInstance.get(null);
    }

    private static int getInt4All(String str, int i3) {
        return WeiyunTransmissionGlobal.getInstance().getHostInterface().getSharedPreferences(SP_NAME, 4).getInt(str, i3);
    }

    private static int getInt4Single(String str, String str2, int i3) {
        return WeiyunTransmissionGlobal.getInstance().getHostInterface().getSharedPreferences(SP_NAME, 4).getInt(str2 + str, i3);
    }

    private int getValue(int i3) {
        int i16;
        synchronized (this.mValues) {
            i16 = this.mValues.get(i3, DEFAULT_VALUE.get(i3));
        }
        return i16;
    }

    private void initUserStatus(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.mValues) {
            int i3 = 0;
            while (true) {
                SparseArray<String> sparseArray = KEY_MAP_4_USER;
                if (i3 < sparseArray.size()) {
                    int keyAt = sparseArray.keyAt(i3);
                    this.mValues.put(keyAt, getInt4Single(str, sparseArray.valueAt(i3), DEFAULT_VALUE.get(keyAt)));
                    i3++;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0015, code lost:
    
        if (r6 != 1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x001b, code lost:
    
        if (r6 != 5) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0020, code lost:
    
        if (r6 <= 4) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0010, code lost:
    
        if (r6 != 1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isValueValid(int i3, int i16) {
        boolean z16 = false;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return true;
                    }
                    if (i16 != 0) {
                    }
                    z16 = true;
                } else {
                    if (i16 != 0) {
                    }
                    z16 = true;
                }
            } else {
                if (i16 != 0) {
                }
                z16 = true;
            }
        } else if (i16 >= 1) {
        }
        return z16;
    }

    private void notifyObservers(int i3, int i16, int i17) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mListeners) {
            HashSet<StatusChangeListener> hashSet = this.mListeners.get(i3);
            if (hashSet != null) {
                arrayList.addAll(hashSet);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((StatusChangeListener) it.next()).onStatusChanged(i3, i16, i17);
        }
    }

    private static void saveInt4All(String str, int i3) {
        WeiyunTransmissionGlobal.getInstance().getHostInterface().getSharedPreferences(SP_NAME, 4).edit().putInt(str, i3).commit();
    }

    private static void saveInt4Single(String str, String str2, int i3) {
        WeiyunTransmissionGlobal.getInstance().getHostInterface().getSharedPreferences(SP_NAME, 4).edit().putInt(str2 + str, i3).commit();
    }

    private boolean setValue(int i3, int i16, boolean z16, boolean z17, String str) {
        int i17;
        if (!isValueValid(i3, i16)) {
            return false;
        }
        synchronized (this.mValues) {
            i17 = this.mValues.get(i3, -1);
            if (i17 != i16) {
                this.mValues.put(i3, i16);
            }
        }
        if (i17 != i16) {
            notifyObservers(i3, i17, i16);
            if (z16) {
                if (z17) {
                    String str2 = KEY_MAP_4_GLOBAL.get(i3);
                    if (!TextUtils.isEmpty(str2)) {
                        saveInt4All(str2, i16);
                        return true;
                    }
                    return true;
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                String str3 = KEY_MAP_4_USER.get(i3);
                if (!TextUtils.isEmpty(str3)) {
                    saveInt4Single(str, str3, i16);
                    return true;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public void addListener(int i3, StatusChangeListener statusChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3, (Object) statusChangeListener);
            return;
        }
        if (statusChangeListener != null && i3 > 0) {
            synchronized (this.mListeners) {
                HashSet<StatusChangeListener> hashSet = this.mListeners.get(i3);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    this.mListeners.put(i3, hashSet);
                }
                hashSet.add(statusChangeListener);
            }
        }
    }

    public int getNetworkStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return getValue(5);
    }

    public int getServerIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return getValue(1);
    }

    public int getUploadServerIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return getValue(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initGlobalStatus(Context context) {
        int networkType = NetworkUtils.getNetworkType(context);
        synchronized (this.mValues) {
            int i3 = 0;
            while (true) {
                SparseArray<String> sparseArray = KEY_MAP_4_GLOBAL;
                if (i3 < sparseArray.size()) {
                    int keyAt = sparseArray.keyAt(i3);
                    this.mValues.put(keyAt, getInt4All(sparseArray.valueAt(i3), DEFAULT_VALUE.get(keyAt)));
                    i3++;
                } else {
                    this.mValues.put(5, networkType);
                }
            }
        }
    }

    public boolean isBackgroundMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (getValue(6) == 0) {
            return true;
        }
        return false;
    }

    public boolean isLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (getValue(4) == 0) {
            return true;
        }
        return false;
    }

    public boolean isTranOnlyWifi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (getValue(3) == 0) {
            return true;
        }
        return false;
    }

    public void onReceiveNetChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        TsLog.i(TAG, "onReceiveNetChanged: isNetEffective=" + z16);
        setValue(5, NetworkUtils.getNetworkType(WeiyunTransmissionGlobal.getInstance().getContext()), false, false, null);
    }

    public void removeListener(int i3, StatusChangeListener statusChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) statusChangeListener);
            return;
        }
        if (statusChangeListener != null && i3 > 0) {
            synchronized (this.mListeners) {
                HashSet<StatusChangeListener> hashSet = this.mListeners.get(i3);
                if (hashSet != null) {
                    hashSet.remove(statusChangeListener);
                }
            }
        }
    }

    public boolean setBackgroundMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, z16)).booleanValue();
        }
        return setValue(6, !z16 ? 1 : 0, false, false, null);
    }

    public boolean setLoginStatus(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) str)).booleanValue();
        }
        if (i3 == 0) {
            initUserStatus(str);
        } else {
            synchronized (this.mValues) {
                int i16 = 0;
                while (true) {
                    SparseArray<String> sparseArray = KEY_MAP_4_USER;
                    if (i16 >= sparseArray.size()) {
                        break;
                    }
                    this.mValues.delete(sparseArray.keyAt(i16));
                    i16++;
                }
            }
        }
        return setValue(4, i3, false, false, null);
    }

    public boolean setServerIp(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
        }
        return setValue(1, i3, z16, true, null);
    }

    public boolean setTranOnlyWifi(int i3, boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16), str)).booleanValue();
        }
        return setValue(3, i3, z16, false, str);
    }

    public boolean setUploadServerIp(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
        }
        return setValue(2, i3, z16, true, null);
    }

    WeiyunTransmissionStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mListeners = new SparseArray<>();
            this.mValues = new SparseIntArray();
        }
    }
}
