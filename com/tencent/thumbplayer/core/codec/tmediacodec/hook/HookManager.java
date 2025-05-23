package com.tencent.thumbplayer.core.codec.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.core.codec.tmediacodec.hook.THookTextureView;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.LogUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class HookManager {
    private static final String TAG = "HookManager";
    private static final Map<String, SurfaceCallback> sHoldCallbackMap = new ConcurrentHashMap();
    private static boolean sIsSurfaceMethodHooked;

    public static void hookSurfaceCallback(@NonNull String str, @NonNull SurfaceCallback surfaceCallback) {
        Map<String, SurfaceCallback> map = sHoldCallbackMap;
        map.put(str, surfaceCallback);
        if (LogUtils.isLogEnable()) {
            LogUtils.d(TAG, "after hookSurfaceCallback size:" + map.size() + " mHoldCallbackMap:" + map);
        }
        if (!sIsSurfaceMethodHooked) {
            sIsSurfaceMethodHooked = true;
            THookTextureView.setHookCallback(new THookTextureView.SurfaceTextureHookCallback() { // from class: com.tencent.thumbplayer.core.codec.tmediacodec.hook.HookManager.1
                @Override // com.tencent.thumbplayer.core.codec.tmediacodec.hook.THookTextureView.SurfaceTextureHookCallback
                public boolean onSurfaceTextureDestroyedCalled(@Nullable SurfaceTexture surfaceTexture) {
                    if (surfaceTexture == null) {
                        return true;
                    }
                    String obj = surfaceTexture.toString();
                    Iterator it = HookManager.sHoldCallbackMap.keySet().iterator();
                    while (it.hasNext()) {
                        if (TextUtils.equals((String) it.next(), obj)) {
                            SurfaceCallback surfaceCallback2 = (SurfaceCallback) HookManager.sHoldCallbackMap.get(obj);
                            if (surfaceCallback2 != null) {
                                surfaceCallback2.onDestroy(surfaceTexture);
                                return false;
                            }
                            return false;
                        }
                    }
                    return true;
                }
            });
        }
    }

    public static void realReleaseSurfaceTexture(@NonNull SurfaceTexture surfaceTexture) {
        try {
            LogUtils.w(TAG, "realReleaseSurfaceTexture surfaceTexture:" + surfaceTexture);
            unHookSurfaceCallback(surfaceTexture.toString());
            surfaceTexture.release();
        } catch (Throwable th5) {
            LogUtils.w(TAG, "realReleaseSurfaceTexture surfaceTexture:" + surfaceTexture + " ignoreThrowable", th5);
        }
    }

    public static void unHookSurfaceCallback(@NonNull String str) {
        sHoldCallbackMap.remove(str);
    }
}
