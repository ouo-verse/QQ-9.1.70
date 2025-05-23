package com.tencent.bugly.common.heapdump;

import android.os.Debug;
import android.os.Handler;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.utils.FileUtil;
import com.tencent.mobileqq.msf.core.auth.k;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class StripHeapDumper implements IHeapDumper {
    private static final String[] IGNORE_SO_LIST = {".*/librmonitor_memory.so$", ".*/libBugly_Native.so$"};
    private static final Map<String, String[]> REGISTER_SO_LIST;
    public static final String TAG = "RMonitor_Heap_StripHeapDumper";
    protected static boolean isSoLoaded;
    private Handler monitorHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class HeapDumpResult {
        public IOException exception;
        public boolean isSuccess;

        public HeapDumpResult(boolean z16, IOException iOException) {
            this.isSuccess = z16;
            this.exception = iOException;
        }
    }

    static {
        HashMap hashMap = new HashMap(2);
        REGISTER_SO_LIST = hashMap;
        hashMap.put("open", new String[]{"libart.so"});
        hashMap.put(k.f247492f, new String[]{"libc.so", "libart.so", "libbase.so", "libartbase.so"});
        isSoLoaded = FileUtil.loadLibrary("rmonitor_base");
    }

    private boolean isHprofStripEnabled() {
        if (isSoLoaded && DumpEnableChecker.isHprofStripVersionPermitted()) {
            return true;
        }
        return false;
    }

    private static native void nDisableHprofStrip();

    private static native void nEnableHprofStrip(String str);

    private static native void nSetHprofStripConfig(int i3);

    private static native void nSetIgnoreHookSo(String str);

    private static native void nSetRegisterHookSo(String str, String str2);

    private void setHprofStripConfig(int i3) {
        if (isSoLoaded) {
            nSetHprofStripConfig(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doDump(String str, HeapDumpConfig heapDumpConfig, HeapDumpResult heapDumpResult) {
        startStrip(str, heapDumpConfig);
        doDump(str, heapDumpResult);
        stopStrip(heapDumpConfig);
    }

    public void enableHprofStrip(String str) {
        nSetRegisterHookSo("libart.so", "open");
        nSetRegisterHookSo("libc.so", k.f247492f);
        nSetRegisterHookSo("libart.so", k.f247492f);
        nSetRegisterHookSo("libbase.so", k.f247492f);
        nSetRegisterHookSo("libartbase.so", k.f247492f);
        nSetIgnoreHookSo(".*/librmonitor_memory.so$");
        nSetIgnoreHookSo(".*/libBugly-rqd.so$");
        nEnableHprofStrip(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Handler getMonitorHandler() {
        if (this.monitorHandler == null) {
            this.monitorHandler = new Handler(ThreadManager.getMonitorThreadLooper());
        }
        return this.monitorHandler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDumpException(HeapDumpConfig heapDumpConfig, Exception exc) {
        IHeapDumpExceptionListener exceptionListener = heapDumpConfig.getExceptionListener();
        if (exceptionListener != null) {
            exceptionListener.onHeapDumpException(exc);
        }
    }

    protected void startStrip(String str, HeapDumpConfig heapDumpConfig) {
        if (heapDumpConfig.isEnableStrip() && isHprofStripEnabled()) {
            enableHprofStrip(str);
            setHprofStripConfig(heapDumpConfig.getStripConfig());
        }
    }

    protected void stopStrip(HeapDumpConfig heapDumpConfig) {
        if (heapDumpConfig.isEnableStrip() && isHprofStripEnabled()) {
            nDisableHprofStrip();
            setHprofStripConfig(0);
        }
    }

    private void doDump(String str, HeapDumpResult heapDumpResult) {
        try {
            Debug.dumpHprofData(str);
            heapDumpResult.isSuccess = true;
            heapDumpResult.exception = null;
        } catch (IOException e16) {
            heapDumpResult.isSuccess = false;
            heapDumpResult.exception = e16;
        }
    }
}
