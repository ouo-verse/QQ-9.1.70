package com.tencent.qqlive.tvkplayer.qqliveasset.subtitle;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.logic.TVKThreadAnnotations;
import com.tencent.qqlive.tvkplayer.logic.TVKThreadSwitch;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSubtitleRendererControllerFactory {
    private static final String TAG = "TVKSubtitleRendererControllerThreadSwitch";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKSubtitleRendererControllerInvocationHandler implements InvocationHandler {
        private final TVKSubtitleRendererController mSubtitleRendererController;
        private final TVKThreadSwitch mThreadSwitch;

        public TVKSubtitleRendererControllerInvocationHandler(TVKThreadSwitch tVKThreadSwitch, TVKSubtitleRendererController tVKSubtitleRendererController) {
            this.mThreadSwitch = tVKThreadSwitch;
            this.mSubtitleRendererController = tVKSubtitleRendererController;
        }

        private Object handleThreadSwitch(@NonNull Method method, Object[] objArr) throws Throwable {
            if ("void".equals(method.getReturnType().getName())) {
                this.mThreadSwitch.dealThreadSwitch(method.getName(), objArr);
                return null;
            }
            return this.mThreadSwitch.dealThreadSwitchWithResult(method.getName(), objArr);
        }

        private boolean shouldSwitchThread(Method method, Object[] objArr) {
            if (TVKThreadAnnotations.getMethod(this.mSubtitleRendererController.getClass(), method.getName(), objArr) != null) {
                return true;
            }
            return false;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!shouldSwitchThread(method, objArr)) {
                return method.invoke(this.mSubtitleRendererController, objArr);
            }
            return handleThreadSwitch(method, objArr);
        }
    }

    public static ITVKSubtitleRenderer createSubtitleRendererController(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Looper looper) {
        TVKSubtitleRendererController tVKSubtitleRendererController = new TVKSubtitleRendererController(tVKQQLiveAssetPlayerContext);
        return (ITVKSubtitleRenderer) Proxy.newProxyInstance(TVKSubtitleRendererController.class.getClassLoader(), TVKSubtitleRendererController.class.getInterfaces(), new TVKSubtitleRendererControllerInvocationHandler(new TVKThreadSwitch(TAG, looper, tVKSubtitleRendererController), tVKSubtitleRendererController));
    }
}
