package com.tencent.qqmini.v8rt.engine;

import android.text.TextUtils;
import com.tencent.qqmini.v8rt.anno.CallByNative;
import java.util.Iterator;
import okhttp3.HttpUrl;

/* compiled from: P */
/* loaded from: classes23.dex */
public class V8JsBridge implements INativeBuffer {
    private static final int MAX_LOG_STRING_LENGTH = 512000;
    public static final String TAG = "API-Java";

    private static IJsEngine getJsEngine(String str) {
        Iterator<IJsEngine> it = JsEngineProvider.getInstance().iterator();
        IJsEngine iJsEngine = null;
        while (it.hasNext()) {
            IJsEngine next = it.next();
            if (next.canHandleEvent(str)) {
                iJsEngine = next;
            }
        }
        return iJsEngine;
    }

    public static void jniEvalJs(int i3, int i16, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        nativeEvaluateJs(i3, i16, str);
    }

    public static Object jniEvalJsWithReturn(int i3, int i16, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return nativeEvaluateJsWithReturn(i3, i16, str);
    }

    public static long jniEvalJsWithReturnPtr(int i3, int i16, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return nativeEvaluateJsWithReturnPtr(i3, i16, str);
    }

    public static Object jniPtrJsonString(long j3, int i3) {
        if (j3 == 0) {
            return null;
        }
        return nativePtrJsonString(j3, i3);
    }

    public static int[] jsStringToJavaIntArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return new int[0];
        }
        String[] split = str.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        int[] iArr = new int[split.length];
        for (int i3 = 0; i3 < split.length; i3++) {
            try {
                iArr[i3] = Integer.parseInt(split[i3]);
            } catch (NumberFormatException unused) {
            }
        }
        return iArr;
    }

    public static native boolean nativeEvaluateCallbackJs(int i3, String str, int i16, String str2);

    public static native void nativeEvaluateJs(int i3, int i16, String str);

    public static native Object nativeEvaluateJsWithReturn(int i3, int i16, String str);

    public static native long nativeEvaluateJsWithReturnPtr(int i3, int i16, String str);

    public static native boolean nativeEvaluateSubscribeJs(int i3, String str, String str2, String str3);

    public static native void nativeGarbageCollect(int i3, int i16);

    public static native byte[] nativeGetNativeBuffer(int i3);

    public static native int nativeNewNativeBuffer(byte[] bArr, int i3, int i16);

    public static native Object nativePtrJsonString(long j3, int i3);

    @CallByNative
    public static String onScriptCall(String str, String str2, int i3, int i16) {
        String str3;
        if (str2 != null && str2.length() >= 512000) {
            Logger.i(TAG, "onScriptCall event:" + str + ", params too long: " + str2.substring(0, 511999) + ", callbackId:" + i3 + ",contextType:" + i16);
        } else {
            Logger.i(TAG, "onScriptCall event:" + str + ", params:" + str2 + ", callbackId:" + i3 + ",contextType:" + i16);
        }
        V8JsRuntime jsRuntime = Engine.getInstance().getJsRuntime(i16);
        if (jsRuntime == null) {
            Logger.e(TAG, "onScriptCall contextType is invalid " + i16 + ", is runtime released?");
            return "{}";
        }
        IServiceEventHandler serviceEventHandler = ServiceEventHandlerProvider.getInstance().getServiceEventHandler(jsRuntime);
        if (serviceEventHandler != null) {
            str3 = serviceEventHandler.onServiceNativeRequest(str, str2, i3);
        } else {
            str3 = null;
        }
        if (str3 != null) {
            return str3;
        }
        IJsEngine jsEngine = getJsEngine(str);
        if (jsEngine != null) {
            return jsEngine.onScriptCall(str, str2, i3, i16);
        }
        Logger.e(TAG, "!!! API [" + str + "] \u672a\u5b9e\u73b0  - (invoke) !!!");
        return "{}";
    }

    @CallByNative
    public static String onScriptPublish(String str, String str2, String str3, int i3) {
        Logger.i(TAG, "onScriptPublish event:" + str + ", params:" + str2 + ", contextIds:" + str3 + ",contextType:" + i3);
        if (HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(str3)) {
            str3 = "[1]";
        }
        V8JsRuntime jsRuntime = Engine.getInstance().getJsRuntime(i3);
        if (jsRuntime == null) {
            Logger.e(TAG, "onScriptPublish contextType is invalid " + i3 + ", is runtime released?");
            return "{}";
        }
        IServiceEventHandler serviceEventHandler = ServiceEventHandlerProvider.getInstance().getServiceEventHandler(jsRuntime);
        if (serviceEventHandler != null) {
            serviceEventHandler.onServiceEvent(str, str2, jsStringToJavaIntArray(str3));
        } else {
            Logger.e(TAG, "!!! API [" + str + "] \u672a\u5b9e\u73b0 - (publish) !!!");
        }
        return "{}";
    }

    @CallByNative
    public static int onWorkerCreate(String str, int i3) {
        V8JsRuntime jsRuntime = Engine.getInstance().getJsRuntime(i3);
        if (jsRuntime == null) {
            Logger.e(TAG, "onScriptCall contextType is invalid " + i3 + ", is runtime released?");
            return -1;
        }
        IWorkerEventHandler workerHandler = WorkerHandlerProvider.getInstance().getWorkerHandler(jsRuntime);
        if (workerHandler != null) {
            return workerHandler.create(str);
        }
        return 0;
    }

    @CallByNative
    public static void onWorkerPostMsgToAppService(String str, int i3) {
        V8JsRuntime jsRuntime = Engine.getInstance().getJsRuntime(i3);
        if (jsRuntime == null) {
            Logger.e(TAG, "onScriptCall contextType is invalid " + i3 + ", is runtime released?");
            return;
        }
        IWorkerEventHandler workerHandler = WorkerHandlerProvider.getInstance().getWorkerHandler(jsRuntime);
        if (workerHandler != null) {
            workerHandler.postMsgToAppService(str);
        }
    }

    @CallByNative
    public static void onWorkerPostMsgToWorker(int i3, String str, int i16) {
        V8JsRuntime jsRuntime = Engine.getInstance().getJsRuntime(i16);
        if (jsRuntime == null) {
            Logger.e(TAG, "onScriptCall contextType is invalid " + i16 + ", is runtime released?");
            return;
        }
        IWorkerEventHandler workerHandler = WorkerHandlerProvider.getInstance().getWorkerHandler(jsRuntime);
        if (workerHandler != null) {
            workerHandler.postMsgToWorker(i3, str);
        }
    }

    @CallByNative
    public static String onWorkerTerminate(int i3, int i16) {
        V8JsRuntime jsRuntime = Engine.getInstance().getJsRuntime(i16);
        if (jsRuntime == null) {
            Logger.e(TAG, "onScriptCall contextType is invalid " + i16 + ", is runtime released?");
            return "{}";
        }
        IWorkerEventHandler workerHandler = WorkerHandlerProvider.getInstance().getWorkerHandler(jsRuntime);
        if (workerHandler != null) {
            workerHandler.terminate(i3);
            return "";
        }
        return "";
    }

    @Override // com.tencent.qqmini.v8rt.engine.INativeBuffer
    public byte[] getNativeBuffer(int i3) {
        return nativeGetNativeBuffer(i3);
    }

    @Override // com.tencent.qqmini.v8rt.engine.INativeBuffer
    public int newNativeBuffer(byte[] bArr, int i3, int i16) {
        return nativeNewNativeBuffer(bArr, i3, i16);
    }
}
