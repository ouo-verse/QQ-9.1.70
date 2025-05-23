package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tmediacodec.hook.THookTextureView;
import com.tencent.tmediacodec.util.LogUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class HookManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "HookManager";
    private static boolean isSurfaceMethodHooked;
    private static final Map<String, SurfaceCallback> mHoldCallbackMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61576);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            mHoldCallbackMap = new ConcurrentHashMap();
        }
    }

    public HookManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void hookSurfaceCallback(@NonNull String str, @NonNull SurfaceCallback surfaceCallback) {
        Map<String, SurfaceCallback> map = mHoldCallbackMap;
        map.put(str, surfaceCallback);
        if (LogUtils.isLogEnable()) {
            LogUtils.d(TAG, "after hookSurfaceCallback size:" + map.size() + " mHoldCallbackMap:" + map);
        }
        if (!isSurfaceMethodHooked) {
            isSurfaceMethodHooked = true;
            THookTextureView.setHookCallback(new THookTextureView.SurfaceTextureHookCallback() { // from class: com.tencent.tmediacodec.hook.HookManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.tmediacodec.hook.THookTextureView.SurfaceTextureHookCallback
                public boolean onSurfaceTextureDestroyedCalled(@Nullable SurfaceTexture surfaceTexture) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) surfaceTexture)).booleanValue();
                    }
                    if (surfaceTexture == null) {
                        return true;
                    }
                    String obj = surfaceTexture.toString();
                    Iterator it = HookManager.mHoldCallbackMap.keySet().iterator();
                    while (it.hasNext()) {
                        if (TextUtils.equals((String) it.next(), obj)) {
                            SurfaceCallback surfaceCallback2 = (SurfaceCallback) HookManager.mHoldCallbackMap.get(obj);
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
        mHoldCallbackMap.remove(str);
    }
}
