package com.tencent.mobileqq.winkreport.datong;

import android.text.TextUtils;
import com.tencent.mobileqq.winkreport.utils.WinkReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkNativeSessionManager {
    private static final String CAMERA_SESSION_FORMAT = "android_camera_session_wink_%s_%d_%d";
    private static final String SESSION_FORMAT = "android_session_wink_%s_%d_%d";
    private static final String TAG = "WinkNativeSessionManager";
    private static volatile WinkNativeSessionManager sSingleton;
    private String mCameraSessionId;
    private String mSessionId;

    public static WinkNativeSessionManager g() {
        if (sSingleton == null) {
            synchronized (WinkNativeSessionManager.class) {
                if (sSingleton == null) {
                    sSingleton = new WinkNativeSessionManager();
                }
            }
        }
        return sSingleton;
    }

    private void generateNativeCameraSessionId() {
        this.mCameraSessionId = generateNativeId(CAMERA_SESSION_FORMAT);
        QLog.i(TAG, 1, "generateNativeCameraSessionId\uff1a" + this.mCameraSessionId);
    }

    private String generateNativeId(String str) {
        return String.format(Locale.getDefault(), str, WinkReportUtils.getAccountUin(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(new Random().nextInt(100)));
    }

    private void generateNativeSessionId() {
        this.mSessionId = generateNativeId(SESSION_FORMAT);
        QLog.i(TAG, 1, "generateNativeSessionId\uff1a" + this.mSessionId);
    }

    public String getCameraSessionId() {
        generateNativeCameraSessionId();
        return this.mCameraSessionId;
    }

    public String getSessionId() {
        if (this.mSessionId == null) {
            generateNativeSessionId();
        }
        return this.mSessionId;
    }

    public void resetCameraSessionId() {
        this.mCameraSessionId = null;
    }

    public void resetSessionId() {
        this.mSessionId = null;
    }

    public String getCameraSessionId(boolean z16) {
        if (z16 || TextUtils.isEmpty(this.mCameraSessionId)) {
            generateNativeCameraSessionId();
        }
        return this.mCameraSessionId;
    }
}
