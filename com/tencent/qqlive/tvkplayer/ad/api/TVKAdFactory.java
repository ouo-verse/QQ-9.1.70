package com.tencent.qqlive.tvkplayer.ad.api;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKAdFactory {
    private static final String TAG = "TVKPlayer[TVKAdFactory]";

    @NonNull
    public static ITVKAdManager createAdManager(@NonNull TVKContext tVKContext, @NonNull ITVKVideoViewBase iTVKVideoViewBase, @NonNull ITVKAdListener iTVKAdListener, @NonNull Looper looper) {
        try {
            return (ITVKAdManager) Class.forName("com.tencent.qqlive.tvkplayer.ad.logic.TVKAdManager").getConstructor(TVKContext.class, ITVKVideoViewBase.class, ITVKAdListener.class, Looper.class).newInstance(tVKContext, iTVKVideoViewBase, iTVKAdListener, looper);
        } catch (Throwable th5) {
            th = th5;
            if (th instanceof InvocationTargetException) {
                th = ((InvocationTargetException) th).getTargetException();
            }
            TVKLogUtil.e(TAG, th, "create TVKAdManager failed, return TVKAdManagerEmpty instead");
            return new TVKAdManagerEmpty(tVKContext);
        }
    }

    @NonNull
    public static ITVKAdManager createAdManagerEmpty(@NonNull TVKContext tVKContext) {
        return new TVKAdManagerEmpty(tVKContext);
    }

    public static ITVKAdListener createHookAdListener(ITVKAdListener iTVKAdListener, ITVKAdListenerHookCallback iTVKAdListenerHookCallback) {
        try {
            return (ITVKAdListener) Class.forName("com.tencent.qqlive.tvkplayer.ad.logic.TVKHookAdListener").getConstructor(ITVKAdListener.class, ITVKAdListenerHookCallback.class).newInstance(iTVKAdListener, iTVKAdListenerHookCallback);
        } catch (Throwable th5) {
            th = th5;
            if (th instanceof InvocationTargetException) {
                th = ((InvocationTargetException) th).getTargetException();
            }
            TVKLogUtil.e(TAG, "createHookAdListener has exception:" + th.toString());
            return null;
        }
    }

    public static ITVKAdInit getAdInit() {
        try {
            Method method = Class.forName("com.tencent.qqlive.tvkplayer.ad.logic.TVKAdInit").getMethod("getInstance", new Class[0]);
            method.setAccessible(true);
            return (ITVKAdInit) method.invoke(null, new Object[0]);
        } catch (Throwable th5) {
            th = th5;
            if (th instanceof InvocationTargetException) {
                th = ((InvocationTargetException) th).getTargetException();
            }
            TVKLogUtil.e(TAG, "getAdInit has exception:" + th.toString());
            return null;
        }
    }
}
