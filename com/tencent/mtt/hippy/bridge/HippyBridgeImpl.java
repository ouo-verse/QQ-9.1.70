package com.tencent.mtt.hippy.bridge;

import android.content.res.AssetManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.a.b;
import com.tencent.mtt.hippy.a.f;
import com.tencent.mtt.hippy.a.h;
import com.tencent.mtt.hippy.a.o;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.mtt.hippy.common.Callback;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleInfo;
import com.tencent.mtt.hippy.utils.ArgumentUtils;
import com.tencent.mtt.hippy.utils.FileUtils;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.mtt.hippy.utils.UrlUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.lang.CharEncoding;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyBridgeImpl implements f.a, HippyBridge {
    private static volatile String mCodeCacheRootDir;
    private static final Object sBridgeSyncLock = new Object();
    private final boolean enableV8Serialization;
    private HippyBridge.a mBridgeCallback;

    @Nullable
    private com.tencent.mtt.hippy.c.a.a mCompatibleDeserializer;
    private HippyEngineContext mContext;
    private String mDebugGlobalConfig;
    private String mDebugServerHost;
    private com.tencent.mtt.hippy.a.b mDebugWebSocketClient;
    private com.tencent.mtt.hippy.a.a.a mInspector;
    private final boolean mIsDevModule;

    @Nullable
    private com.tencent.mtt.hippy.c.d.a mRecommendDeserializer;
    private com.tencent.mtt.hippy.c.c.a.a mSafeDirectReader;
    private com.tencent.mtt.hippy.c.c.a.a mSafeHeapReader;
    private final boolean mSingleThreadMode;
    private final HippyEngine.V8InitParams v8InitParams;
    private long mV8RuntimeId = 0;
    private boolean mInit = false;

    public HippyBridgeImpl(HippyEngineContext hippyEngineContext, HippyBridge.a aVar, boolean z16, boolean z17, boolean z18, String str, HippyEngine.V8InitParams v8InitParams) {
        File hippyFile;
        this.mBridgeCallback = aVar;
        this.mSingleThreadMode = z16;
        this.enableV8Serialization = z17;
        this.mIsDevModule = z18;
        this.mDebugServerHost = str;
        this.mContext = hippyEngineContext;
        this.v8InitParams = v8InitParams;
        synchronized (sBridgeSyncLock) {
            if (mCodeCacheRootDir == null && (hippyFile = FileUtils.getHippyFile(this.mContext.getGlobalConfigs().getContext())) != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(hippyFile.getAbsolutePath());
                String str2 = File.separator;
                sb5.append(str2);
                sb5.append(HippyQQFileUtil.HIPPY_CODE_CACHE_DIR);
                sb5.append(str2);
                mCodeCacheRootDir = sb5.toString();
            }
        }
        if (z17) {
            this.mCompatibleDeserializer = new com.tencent.mtt.hippy.c.a.a(null, new com.tencent.mtt.hippy.c.e.b());
            this.mRecommendDeserializer = new com.tencent.mtt.hippy.c.d.a(null, new com.tencent.mtt.hippy.c.e.b());
        }
    }

    private Object bytesToArgument(String str, String str2, ByteBuffer byteBuffer) {
        Object obj;
        try {
            if (this.enableV8Serialization) {
                obj = parseV8SerializeData(str, str2, byteBuffer);
            } else {
                obj = parseJsonData(byteBuffer);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            obj = null;
        }
        if (obj == null) {
            return new HippyArray();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initJSEngine(int i3, NativeCallback nativeCallback) {
        synchronized (HippyBridgeImpl.class) {
            try {
                this.mV8RuntimeId = initJSFramework(this.mDebugGlobalConfig.getBytes(StandardCharsets.UTF_16LE), this.mSingleThreadMode, this.enableV8Serialization, this.mIsDevModule, nativeCallback, i3, this.v8InitParams);
                this.mInit = true;
            } finally {
            }
        }
    }

    private HippyArray parseJsonData(ByteBuffer byteBuffer) {
        byte[] array;
        if (byteBuffer.isDirect()) {
            array = new byte[byteBuffer.limit()];
            byteBuffer.get(array);
        } else {
            array = byteBuffer.array();
        }
        return ArgumentUtils.parseToArray(new String(array));
    }

    @Nullable
    private Object parseV8SerializeData(@NonNull String str, @NonNull String str2, ByteBuffer byteBuffer) {
        com.tencent.mtt.hippy.c.c.a.a aVar;
        HippyNativeModuleInfo moduleInfo = this.mContext.getModuleManager().getModuleInfo(str);
        if (moduleInfo == null) {
            return null;
        }
        HippyNativeModuleInfo.HippyNativeMethod findMethod = moduleInfo.findMethod(str2);
        com.tencent.mtt.hippy.c.c cVar = this.mCompatibleDeserializer;
        if (findMethod != null && findMethod.useJSValueType()) {
            cVar = this.mRecommendDeserializer;
        }
        if (byteBuffer.isDirect()) {
            if (this.mSafeHeapReader == null) {
                this.mSafeHeapReader = new com.tencent.mtt.hippy.c.c.a.b();
            }
            aVar = this.mSafeHeapReader;
        } else {
            if (this.mSafeDirectReader == null) {
                this.mSafeDirectReader = new com.tencent.mtt.hippy.c.c.a.c();
            }
            aVar = this.mSafeDirectReader;
        }
        aVar.a(byteBuffer);
        cVar.a(aVar);
        cVar.c();
        cVar.d();
        return cVar.e();
    }

    private native void runInJsThread(long j3, Callback<Void> callback);

    public void InspectorChannel(byte[] bArr) {
        String str;
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            str = CharEncoding.UTF_16BE;
        } else {
            str = CharEncoding.UTF_16LE;
        }
        String str2 = new String(bArr, Charset.forName(str));
        com.tencent.mtt.hippy.a.b bVar = this.mDebugWebSocketClient;
        if (bVar != null) {
            bVar.a(str2);
        }
    }

    public native void callFunction(String str, long j3, NativeCallback nativeCallback, ByteBuffer byteBuffer, int i3, int i16);

    public native void callFunction(String str, long j3, NativeCallback nativeCallback, byte[] bArr, int i3, int i16);

    @Override // com.tencent.mtt.hippy.bridge.HippyBridge
    public void callFunction(String str, NativeCallback nativeCallback, ByteBuffer byteBuffer) {
        if (!this.mInit || TextUtils.isEmpty(str) || byteBuffer == null || byteBuffer.limit() == 0) {
            return;
        }
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - byteBuffer.position();
        if (byteBuffer.isDirect()) {
            callFunction(str, this.mV8RuntimeId, nativeCallback, byteBuffer, position, limit);
        } else {
            callFunction(str, this.mV8RuntimeId, nativeCallback, byteBuffer.array(), position + byteBuffer.arrayOffset(), limit);
        }
    }

    public void callNatives(String str, String str2, String str3, ByteBuffer byteBuffer) {
        LogUtils.d("jni_callback", "callNatives [moduleName:" + str + " , moduleFunc: " + str2 + "]");
        if (this.mBridgeCallback != null) {
            this.mBridgeCallback.a(str, str2, str3, bytesToArgument(str, str2, byteBuffer));
        }
    }

    public native void destroy(long j3, boolean z16, boolean z17, NativeCallback nativeCallback);

    @Override // com.tencent.mtt.hippy.bridge.HippyBridge
    public void destroy(NativeCallback nativeCallback, boolean z16) {
        destroy(this.mV8RuntimeId, this.mSingleThreadMode, z16, nativeCallback);
    }

    public void fetchResourceWithUri(final String str, final long j3) {
        final WeakReference weakReference = new WeakReference(this.mBridgeCallback);
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mtt.hippy.bridge.HippyBridgeImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (HippyBridgeImpl.this.mContext == null) {
                    return;
                }
                o devSupportManager = HippyBridgeImpl.this.mContext.getDevSupportManager();
                if (!TextUtils.isEmpty(str) && UrlUtils.isWebUrl(str) && devSupportManager != null) {
                    devSupportManager.a(str, new h() { // from class: com.tencent.mtt.hippy.bridge.HippyBridgeImpl.2.1
                        @Override // com.tencent.mtt.hippy.a.h
                        public void onDevBundleLoadReady(InputStream inputStream) {
                            try {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                byte[] bArr = new byte[2048];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read > 0) {
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    } else {
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteArray.length);
                                        allocateDirect.put(byteArray);
                                        HippyBridgeImpl hippyBridgeImpl = HippyBridgeImpl.this;
                                        hippyBridgeImpl.onResourceReady(allocateDirect, hippyBridgeImpl.mV8RuntimeId, j3);
                                        return;
                                    }
                                }
                            } catch (Throwable th5) {
                                HippyBridge.a aVar = (HippyBridge.a) weakReference.get();
                                if (aVar != null) {
                                    aVar.a(th5);
                                }
                                HippyBridgeImpl hippyBridgeImpl2 = HippyBridgeImpl.this;
                                hippyBridgeImpl2.onResourceReady(null, hippyBridgeImpl2.mV8RuntimeId, j3);
                            }
                        }

                        @Override // com.tencent.mtt.hippy.a.h
                        public void onInitDevError(Throwable th5) {
                            LogUtils.e("hippy", "requireSubResource: " + th5.getMessage());
                            HippyBridgeImpl hippyBridgeImpl = HippyBridgeImpl.this;
                            hippyBridgeImpl.onResourceReady(null, hippyBridgeImpl.mV8RuntimeId, j3);
                        }

                        @Override // com.tencent.mtt.hippy.a.h
                        public void onDevBundleReLoad() {
                        }
                    });
                    return;
                }
                LogUtils.e("HippyBridgeImpl", "fetchResourceWithUri: can not call loadRemoteResource with " + str);
            }
        });
    }

    @Override // com.tencent.mtt.hippy.bridge.HippyBridge
    public String getComponentName() {
        HippyEngineContext hippyEngineContext = this.mContext;
        if (hippyEngineContext != null) {
            return hippyEngineContext.getComponentName();
        }
        return "";
    }

    @Override // com.tencent.mtt.hippy.bridge.HippyBridge
    public long getV8RuntimeId() {
        return this.mV8RuntimeId;
    }

    @Override // com.tencent.mtt.hippy.bridge.HippyBridge
    public void initJSBridge(String str, final NativeCallback nativeCallback, final int i3) {
        this.mDebugGlobalConfig = str;
        if (this.mIsDevModule) {
            com.tencent.mtt.hippy.a.b bVar = new com.tencent.mtt.hippy.a.b();
            this.mDebugWebSocketClient = bVar;
            bVar.a(this);
            if (TextUtils.isEmpty(this.mDebugServerHost)) {
                this.mDebugServerHost = "localhost:38989";
            }
            o devSupportManager = this.mContext.getDevSupportManager();
            this.mInspector = devSupportManager.d().a(this.mContext, this.mDebugWebSocketClient);
            this.mDebugWebSocketClient.a(devSupportManager.b(this.mDebugServerHost), new b.a() { // from class: com.tencent.mtt.hippy.bridge.HippyBridgeImpl.1
                @Override // com.tencent.mtt.hippy.a.b.a
                public void a(String str2) {
                    LogUtils.d("hippyCore", "js debug socket connect success");
                    HippyBridgeImpl.this.initJSEngine(i3, nativeCallback);
                }

                @Override // com.tencent.mtt.hippy.a.b.a
                public void a(Throwable th5) {
                    LogUtils.e("hippyCore", "js debug socket connect failed");
                    HippyBridgeImpl.this.initJSEngine(i3, nativeCallback);
                }
            });
            return;
        }
        initJSEngine(i3, nativeCallback);
    }

    public native long initJSFramework(byte[] bArr, boolean z16, boolean z17, boolean z18, NativeCallback nativeCallback, long j3, HippyEngine.V8InitParams v8InitParams);

    @Override // com.tencent.mtt.hippy.bridge.HippyBridge
    public void onDestroy(boolean z16) {
        int i3;
        com.tencent.mtt.hippy.a.b bVar = this.mDebugWebSocketClient;
        if (bVar != null) {
            if (z16) {
                i3 = com.tencent.mtt.hippy.a.a.a.f336906b;
            } else {
                i3 = com.tencent.mtt.hippy.a.a.a.f336905a;
            }
            bVar.a(i3, "");
            this.mDebugWebSocketClient = null;
        }
        com.tencent.mtt.hippy.a.a.a aVar = this.mInspector;
        if (aVar != null) {
            aVar.a();
        }
        if (!this.mInit) {
            return;
        }
        if (this.enableV8Serialization) {
            com.tencent.mtt.hippy.c.a.a aVar2 = this.mCompatibleDeserializer;
            if (aVar2 != null) {
                aVar2.b().a();
            }
            com.tencent.mtt.hippy.c.d.a aVar3 = this.mRecommendDeserializer;
            if (aVar3 != null) {
                aVar3.b().a();
            }
        }
        this.mInit = false;
        this.mV8RuntimeId = 0L;
        this.mContext = null;
        this.mBridgeCallback = null;
    }

    @Override // com.tencent.mtt.hippy.a.f.a
    public void onReceiveData(String str) {
        boolean z16;
        if (this.mIsDevModule) {
            com.tencent.mtt.hippy.a.a.a aVar = this.mInspector;
            if (aVar != null && aVar.a(this.mContext, str)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                callFunction("onWebsocketMsg", (NativeCallback) null, str.getBytes(StandardCharsets.UTF_16LE));
            }
        }
    }

    public native void onResourceReady(ByteBuffer byteBuffer, long j3, long j16);

    public void reportException(String str, String str2) {
        LogUtils.e("reportException", "!!!!!!!!!!!!!!!!!!!");
        LogUtils.e("reportException", str);
        LogUtils.e("reportException", str2);
        HippyBridge.a aVar = this.mBridgeCallback;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    @Override // com.tencent.mtt.hippy.bridge.HippyBridge
    public void runInJsThread(Callback<Void> callback) {
        runInJsThread(this.mV8RuntimeId, callback);
    }

    public native void runScript(long j3, String str);

    @Override // com.tencent.mtt.hippy.bridge.HippyBridge
    public void runScript(@NonNull String str) {
        runScript(this.mV8RuntimeId, str);
    }

    public native boolean runScriptFromUri(String str, AssetManager assetManager, boolean z16, String str2, long j3, NativeCallback nativeCallback);

    @Override // com.tencent.mtt.hippy.bridge.HippyBridge
    public boolean runScriptFromUri(String str, AssetManager assetManager, boolean z16, String str2, NativeCallback nativeCallback) {
        boolean z17;
        String str3;
        if (!this.mInit) {
            return false;
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(mCodeCacheRootDir)) {
            String str4 = mCodeCacheRootDir + str2 + File.separator;
            File file = new File(str4);
            if (!file.exists() && !file.mkdirs()) {
                str3 = "";
                z17 = false;
            } else {
                z17 = z16;
                str3 = str4;
            }
            return runScriptFromUri(str, assetManager, z17, str3, this.mV8RuntimeId, nativeCallback);
        }
        LogUtils.d("HippyEngineMonitor", "runScriptFromAssets codeCacheTag is null");
        try {
            return runScriptFromUri(str, assetManager, false, "" + str2 + File.separator, this.mV8RuntimeId, nativeCallback);
        } catch (Throwable th5) {
            HippyBridge.a aVar = this.mBridgeCallback;
            if (aVar == null) {
                return false;
            }
            aVar.a(th5);
            return false;
        }
    }

    @Override // com.tencent.mtt.hippy.bridge.HippyBridge
    public void callFunction(String str, NativeCallback nativeCallback, byte[] bArr) {
        callFunction(str, nativeCallback, bArr, 0, bArr.length);
    }

    public void callNatives(String str, String str2, String str3, byte[] bArr) {
        callNatives(str, str2, str3, ByteBuffer.wrap(bArr));
    }

    @Override // com.tencent.mtt.hippy.bridge.HippyBridge
    public void callFunction(String str, NativeCallback nativeCallback, byte[] bArr, int i3, int i16) {
        if (!this.mInit || TextUtils.isEmpty(str) || bArr == null || i3 < 0 || i16 < 0 || i3 + i16 > bArr.length) {
            return;
        }
        callFunction(str, this.mV8RuntimeId, nativeCallback, bArr, i3, i16);
    }
}
