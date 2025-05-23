package com.tencent.biz.richframework.monitor.memory;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.view.ViewRootImpl;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWMemoryLeakUtils {
    private static final String LEAK_RECEIVERS = "mReceivers";
    private static final String LOADED_APK = "mLoadedApk";
    private static final String TAG = "RFWMemoryLeakUtils";

    public static void fixInputLeak(Window window) {
        InputMethodManager inputMethodManager;
        Field declaredField;
        Object obj;
        View view;
        if (window == null) {
            RFWLog.e(TAG, RFWLog.USR, "[fixInputLeak] window should not be null.");
            return;
        }
        Application application = RFWApplication.getApplication();
        if (application == null || (inputMethodManager = (InputMethodManager) application.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) == null) {
            return;
        }
        String[] strArr = {"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"};
        for (int i3 = 0; i3 < 4; i3++) {
            try {
                declaredField = InputMethodManager.class.getDeclaredField(strArr[i3]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                obj = declaredField.get(inputMethodManager);
            } catch (Throwable th5) {
                RFWLog.e(TAG, RFWLog.CLR, th5);
            }
            if (obj instanceof View) {
                view = (View) obj;
            } else {
                if ((obj instanceof ViewRootImpl) && RFWConfig.getConfigValue("101597", true)) {
                    Field declaredField2 = ViewRootImpl.class.getDeclaredField("mView");
                    if (!declaredField2.isAccessible()) {
                        declaredField2.setAccessible(true);
                    }
                    view = (View) declaredField2.get(obj);
                }
            }
            if (view.getRootView() == window.getDecorView().getRootView()) {
                declaredField.set(inputMethodManager, null);
            }
        }
        RFWLog.d(TAG, RFWLog.USR, "[fixInputLeak] input leak...");
    }

    public static void fixLoadedApkLeak(Activity activity) {
        if (activity == null) {
            RFWLog.e(TAG, RFWLog.USR, "[fixLoadedApkLeak] activity should not be null.");
            return;
        }
        try {
            Field declaredField = Application.class.getDeclaredField(LOADED_APK);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activity.getApplication());
            Field declaredField2 = obj.getClass().getDeclaredField(LEAK_RECEIVERS);
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (!(obj2 instanceof Map)) {
                RFWLog.e(TAG, RFWLog.USR, "[fixLoadedApkLeak] not instanceof map.");
                return;
            }
            Iterator it = ((Map) obj2).keySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                if (next != null && next == activity) {
                    RFWLog.d(TAG, RFWLog.USR, "[fixLoadedApkLeak] remove iterator: " + next);
                    it.remove();
                    i3++;
                }
            }
            RFWLog.d(TAG, RFWLog.USR, "[fixLoadedApkLeak] loaded remove count: " + i3);
        } catch (Throwable th5) {
            RFWLog.e(TAG, RFWLog.USR, "[fixLoadedApkLeak] ex: ", th5);
        }
    }
}
