package com.tencent.mtt.hippy.bridge;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import com.tencent.mtt.hippy.common.Callback;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface HippyBridge {
    public static final String URI_SCHEME_ASSETS = "asset:";
    public static final String URI_SCHEME_FILE = "file:";

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(String str, String str2);

        void a(String str, String str2, String str3, Object obj);

        void a(Throwable th5);
    }

    void callFunction(String str, NativeCallback nativeCallback, ByteBuffer byteBuffer);

    void callFunction(String str, NativeCallback nativeCallback, byte[] bArr);

    void callFunction(String str, NativeCallback nativeCallback, byte[] bArr, int i3, int i16);

    void destroy(NativeCallback nativeCallback, boolean z16);

    String getComponentName();

    long getV8RuntimeId();

    void initJSBridge(String str, NativeCallback nativeCallback, int i3);

    void onDestroy(boolean z16);

    void runInJsThread(Callback<Void> callback);

    void runScript(@NonNull String str);

    boolean runScriptFromUri(String str, AssetManager assetManager, boolean z16, String str2, NativeCallback nativeCallback);
}
