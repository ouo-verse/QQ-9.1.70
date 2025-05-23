package com.tencent.thumbplayer.core.utils;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@RequiresApi(api = 17)
/* loaded from: classes26.dex */
public class TPScreenRefreshRateDetector {
    public static final int DISPLAY_CHANGE = 10001;
    private static String TAG = "TPScreenRefreshRateDetector";
    private static boolean isInitted = false;
    private static WeakReference<Context> mContext;
    private static Handler mHandler;
    private static WindowManager mWindowManager;
    private static List<ScreenRefreshRateChangedListener> listeners = new LinkedList();
    private static float mCurScreenRefreshRate = 60.0f;
    private static DisplayManager mDisplayManager = null;
    private static final Object mListenerLock = new Object();
    private static DisplayManager.DisplayListener mDisplayListener = new DisplayManager.DisplayListener() { // from class: com.tencent.thumbplayer.core.utils.TPScreenRefreshRateDetector.2
        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i3) {
            if (i3 == 0) {
                TPScreenRefreshRateDetector.mHandler.sendEmptyMessage(10001);
            }
            TPNativeLog.printLog(2, TPScreenRefreshRateDetector.TAG, "onDisplayChanged displayId:" + i3);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i3) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i3) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public interface ScreenRefreshRateChangedListener {
        void onScreenRefreshRateChanged(float f16);
    }

    public static void addListener(ScreenRefreshRateChangedListener screenRefreshRateChangedListener) {
        synchronized (mListenerLock) {
            listeners.add(screenRefreshRateChangedListener);
        }
    }

    public static void deinit() {
        WeakReference<Context> weakReference;
        synchronized (TPScreenRefreshRateDetector.class) {
            if (isInitted && (weakReference = mContext) != null) {
                weakReference.clear();
                isInitted = false;
                TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector deinit succeed!");
            }
        }
    }

    private static Looper getLooper() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            return Looper.getMainLooper();
        }
        return myLooper;
    }

    public static float getScreenRefreshRate() {
        WeakReference<Context> weakReference = mContext;
        if (weakReference == null) {
            TPNativeLog.printLog(0, TAG, "Current mContext is null, set default.");
            return mCurScreenRefreshRate;
        }
        Context context = weakReference.get();
        if (context != null) {
            if (mWindowManager == null) {
                mWindowManager = (WindowManager) context.getSystemService("window");
            }
            if (mDisplayManager == null) {
                DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
                mDisplayManager = displayManager;
                displayManager.registerDisplayListener(mDisplayListener, mHandler);
            }
            WindowManager windowManager = mWindowManager;
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Display.Mode[] supportedModes = defaultDisplay.getSupportedModes();
                Display.Mode mode = defaultDisplay.getMode();
                TPNativeLog.printLog(2, TAG, "getMode width:" + mode.getPhysicalWidth() + " height:" + mode.getPhysicalHeight() + " refreshRate:" + mode.getRefreshRate() + " ModeId:" + mode.getModeId());
                String str = TAG;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getSupportedModes length:");
                sb5.append(supportedModes.length);
                TPNativeLog.printLog(2, str, sb5.toString());
                for (int i3 = 0; i3 < supportedModes.length; i3++) {
                    TPNativeLog.printLog(2, TAG, "getSupportedModes width:" + supportedModes[i3].getPhysicalWidth() + " height:" + supportedModes[i3].getPhysicalHeight() + " refreshRate:" + supportedModes[i3].getRefreshRate() + " ModeId:" + supportedModes[i3].getModeId());
                }
                mCurScreenRefreshRate = mode.getRefreshRate();
            }
        }
        return mCurScreenRefreshRate;
    }

    public static void init(Context context) {
        synchronized (TPScreenRefreshRateDetector.class) {
            TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector init enter!");
            if (isInitted) {
                return;
            }
            mContext = new WeakReference<>(context.getApplicationContext());
            isInitted = true;
            initHandleMsg();
            TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector init succeed!");
        }
    }

    public static void initHandleMsg() {
        mHandler = new Handler(getLooper()) { // from class: com.tencent.thumbplayer.core.utils.TPScreenRefreshRateDetector.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 10001 && TPScreenRefreshRateDetector.mDisplayManager != null) {
                    Display display = TPScreenRefreshRateDetector.mDisplayManager.getDisplay(0);
                    if (display == null) {
                        TPNativeLog.printLog(2, TPScreenRefreshRateDetector.TAG, "handleMessage DISPLAY_CHANGE, no valid built-in display found");
                    } else {
                        Display.Mode mode = display.getMode();
                        TPNativeLog.printLog(2, TPScreenRefreshRateDetector.TAG, "handleMessage DISPLAY_CHANGE, mode:" + mode);
                        TPScreenRefreshRateDetector.notifyScreenRefreshRateChange(mode.getRefreshRate());
                    }
                }
                super.handleMessage(message);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyScreenRefreshRateChange(float f16) {
        boolean z16;
        if (Math.abs(f16 - mCurScreenRefreshRate) >= 1.0f) {
            TPNativeLog.printLog(2, TAG, "notifyScreenRefreshRateChange Change From " + mCurScreenRefreshRate + " to " + f16);
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        mCurScreenRefreshRate = f16;
        synchronized (mListenerLock) {
            Iterator<ScreenRefreshRateChangedListener> it = listeners.iterator();
            while (it.hasNext()) {
                it.next().onScreenRefreshRateChanged(f16);
            }
        }
    }

    public static void removeListener(ScreenRefreshRateChangedListener screenRefreshRateChangedListener) {
        synchronized (mListenerLock) {
            listeners.remove(screenRefreshRateChangedListener);
        }
    }
}
