package com.tencent.qqmini.sdk.core.manager;

import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IRequestPermissionsResultListener;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ActivityResultManager {
    public static final int ACTION_REQUEST_API_PERMISSION = 5;
    public static final int ACTION_REQUEST_CODE_AUTHORIZATION_DIALOG = 8002;
    public static final int ACTION_REQUEST_CODE_CAMERA = 4;
    public static final int ACTION_REQUEST_CODE_CHOOSE_LOCATION = 3;
    public static final int ACTION_REQUEST_CODE_CHOOSE_MESSAGE_FILE = 6001;
    public static final int ACTION_REQUEST_CODE_CREATE_BANNER_AD = 8003;
    public static final int ACTION_REQUEST_CODE_GAME_PAY_BY_FRIEND_H5 = 3004;
    public static final int ACTION_REQUEST_CODE_GAME_PAY_BY_H5 = 3003;
    public static final int ACTION_REQUEST_CODE_GAME_PAY_BY_WX_H5 = 3005;
    public static final int ACTION_REQUEST_CODE_GAME_PAY_THROUGH_TOOL = 3002;
    public static final int ACTION_REQUEST_CODE_GET_VIDEO = 2;
    public static final int ACTION_REQUEST_CODE_LOAD_MINI_CONF = 1;
    public static final int ACTION_REQUEST_CODE_PAY = 3001;
    public static final int ACTION_REQUEST_CODE_UNITY_GAME_PAY_BY_H5 = 8001;
    public static final int ACTION_REQUEST_INTERSTITIAL_AD = 10001;
    public static final int ACTION_REQUEST_OPEN_BLUETOOTH = 6;
    public static final int ACTION_REQUEST_OPEN_GROUP_API = 9;
    public static final int ACTION_REQUEST_OPEN_GROUP_SELECTMEMBERS = 10;
    public static final int ACTION_REQUEST_PERMISSION = 9527;
    public static final int ACTION_REQUEST_PERMISSION_ACCESS_FINE_LOCATION = 9528;
    public static final int ACTION_REQUEST_REDENVELOPE_CLOSEWEBVIEW = 11007;
    public static final int ACTION_REQUEST_SELECT_PHOTO = 8;
    public static final int ACTION_REQUEST_SHARE = 7;
    public static final String TAG = "ActivityResultManager";
    private static final ActivityResultManager sInstance = new ActivityResultManager();
    private ArrayList<IActivityResultListener> mActivityResultListenerList;
    private ArrayList<IRequestPermissionsResultListener> mRequestPermissionsResultListenerList;

    ActivityResultManager() {
    }

    public static ActivityResultManager g() {
        return sInstance;
    }

    public void addActivityResultListener(IActivityResultListener iActivityResultListener) {
        QMLog.d(TAG, "addActivityResultListener " + iActivityResultListener);
        if (iActivityResultListener == null) {
            return;
        }
        try {
            if (this.mActivityResultListenerList == null) {
                this.mActivityResultListenerList = new ArrayList<>();
            }
            this.mActivityResultListenerList.add(iActivityResultListener);
        } catch (Throwable th5) {
            QMLog.e(TAG, th5.getMessage(), th5);
        }
    }

    public void addRequestPermissionResultListener(IRequestPermissionsResultListener iRequestPermissionsResultListener) {
        QMLog.d(TAG, "addRequestPermissionResultListener " + iRequestPermissionsResultListener);
        if (iRequestPermissionsResultListener == null) {
            return;
        }
        try {
            if (this.mRequestPermissionsResultListenerList == null) {
                this.mRequestPermissionsResultListenerList = new ArrayList<>();
            }
            this.mRequestPermissionsResultListenerList.add(iRequestPermissionsResultListener);
        } catch (Throwable th5) {
            QMLog.e(TAG, th5.getMessage(), th5);
        }
    }

    public void notifyActivityResultListener(int i3, int i16, Intent intent) {
        QMLog.d(TAG, "notifyActivityResultListener requestCode:" + i3 + " resultCode:" + i16);
        ArrayList<IActivityResultListener> arrayList = this.mActivityResultListenerList;
        if (arrayList != null && arrayList.size() != 0) {
            try {
                synchronized (this.mActivityResultListenerList) {
                    Iterator<IActivityResultListener> it = this.mActivityResultListenerList.iterator();
                    while (it.hasNext()) {
                        IActivityResultListener next = it.next();
                        if (next.doOnActivityResult(i3, i16, intent)) {
                            QMLog.d(TAG, "triggerListener " + next);
                            return;
                        }
                    }
                    return;
                }
            } catch (Throwable th5) {
                QMLog.e(TAG, th5.getMessage(), th5);
                return;
            }
        }
        QMLog.e(TAG, "mActivityResultListenerList == null || mActivityResultListenerList.size() == 0");
    }

    public void notifyRequestPermissionResultListener(int i3, String[] strArr, int[] iArr) {
        QMLog.d(TAG, "notifyRequestPermissionResultListener requestCode:" + i3 + " permission:" + strArr);
        ArrayList<IRequestPermissionsResultListener> arrayList = this.mRequestPermissionsResultListenerList;
        if (arrayList != null && arrayList.size() != 0) {
            try {
                synchronized (this.mRequestPermissionsResultListenerList) {
                    Iterator<IRequestPermissionsResultListener> it = this.mRequestPermissionsResultListenerList.iterator();
                    while (it.hasNext()) {
                        IRequestPermissionsResultListener next = it.next();
                        if (next.doOnRequestPermissionsResult(i3, strArr, iArr)) {
                            QMLog.d(TAG, "triggerListener " + next);
                            return;
                        }
                    }
                    return;
                }
            } catch (Throwable th5) {
                QMLog.e(TAG, th5.getMessage(), th5);
                return;
            }
        }
        QMLog.e(TAG, "mActivityResultListenerList == null || mActivityResultListenerList.size() == 0");
    }

    public void removeActivityResultListener(IActivityResultListener iActivityResultListener) {
        QMLog.d(TAG, "removeActivityResultListener " + iActivityResultListener);
        if (iActivityResultListener != null) {
            try {
                ArrayList<IActivityResultListener> arrayList = this.mActivityResultListenerList;
                if (arrayList != null) {
                    arrayList.remove(iActivityResultListener);
                }
            } catch (Throwable th5) {
                QMLog.e(TAG, th5.getMessage(), th5);
            }
        }
    }

    public void removeRequestPermissionResultListener(IRequestPermissionsResultListener iRequestPermissionsResultListener) {
        QMLog.d(TAG, "removeRequestPermissionResultListener " + iRequestPermissionsResultListener);
        if (iRequestPermissionsResultListener != null) {
            try {
                ArrayList<IRequestPermissionsResultListener> arrayList = this.mRequestPermissionsResultListenerList;
                if (arrayList != null) {
                    arrayList.remove(iRequestPermissionsResultListener);
                }
            } catch (Throwable th5) {
                QMLog.e(TAG, th5.getMessage(), th5);
            }
        }
    }
}
