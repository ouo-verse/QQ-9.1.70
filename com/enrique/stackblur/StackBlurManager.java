package com.enrique.stackblur;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.v8.renderscript.RSRuntimeException;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.FileOutputStream;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes2.dex */
public class StackBlurManager {
    static final ExecutorService EXECUTOR;
    static int EXECUTOR_THREADS = 0;
    private static final String TAG = "StackBlurManager";
    private static volatile boolean hasRS;
    private final Bitmap _image;
    private Bitmap _result;
    private boolean mDbg = true;
    private final BlurProcess _blurProcess = new JavaBlurProcess();

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        EXECUTOR_THREADS = availableProcessors;
        EXECUTOR = ProxyExecutors.newFixedThreadPool(availableProcessors);
        hasRS = true;
    }

    public StackBlurManager(Bitmap bitmap) {
        this._image = bitmap;
    }

    public int getExecutorThreads() {
        return EXECUTOR_THREADS;
    }

    public Bitmap getImage() {
        return this._image;
    }

    public Bitmap process(int i3) {
        long uptimeMillis = SystemClock.uptimeMillis();
        this._result = this._blurProcess.blur(this._image, i3);
        if (this.mDbg) {
            Log.i(TAG, "process: " + this._blurProcess + ContainerUtils.KEY_VALUE_DELIMITER + (SystemClock.uptimeMillis() - uptimeMillis) + " ms");
        }
        return this._result;
    }

    public Bitmap processNatively(int i3) {
        long uptimeMillis = SystemClock.uptimeMillis();
        NativeBlurProcess nativeBlurProcess = new NativeBlurProcess();
        this._result = nativeBlurProcess.blur(this._image, i3);
        if (this.mDbg) {
            Log.i(TAG, "processNatively: " + nativeBlurProcess + ContainerUtils.KEY_VALUE_DELIMITER + (SystemClock.uptimeMillis() - uptimeMillis) + " ms");
        }
        return this._result;
    }

    public Bitmap processRenderScript(Context context, float f16, int i3) {
        BlurProcess nativeBlurProcess;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (hasRS) {
            try {
                nativeBlurProcess = new RSBlurProcess(context, i3);
            } catch (RSRuntimeException unused) {
                nativeBlurProcess = new NativeBlurProcess();
                hasRS = false;
            }
        } else {
            nativeBlurProcess = new NativeBlurProcess();
        }
        this._result = nativeBlurProcess.blur(this._image, f16);
        if (this.mDbg) {
            Log.i(TAG, "processRenderScript: " + nativeBlurProcess + ContainerUtils.KEY_VALUE_DELIMITER + (SystemClock.uptimeMillis() - uptimeMillis) + " ms");
        }
        return this._result;
    }

    public Bitmap processSdkRenderScript(Context context, float f16) {
        long uptimeMillis = SystemClock.uptimeMillis();
        SdkRSBlurProcess sdkRSBlurProcess = new SdkRSBlurProcess(context);
        this._result = sdkRSBlurProcess.blur(this._image, f16);
        if (this.mDbg) {
            Log.i(TAG, "processSdkRenderScript: " + sdkRSBlurProcess + ContainerUtils.KEY_VALUE_DELIMITER + (SystemClock.uptimeMillis() - uptimeMillis) + " ms");
        }
        return this._result;
    }

    public Bitmap returnBlurredImage() {
        return this._result;
    }

    public void saveIntoFile(String str) {
        try {
            this._result.compress(Bitmap.CompressFormat.PNG, 90, new FileOutputStream(str));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void setDbg(boolean z16) {
        this.mDbg = z16;
    }

    public void setExecutorThreads(int i3) {
        EXECUTOR_THREADS = i3;
    }
}
