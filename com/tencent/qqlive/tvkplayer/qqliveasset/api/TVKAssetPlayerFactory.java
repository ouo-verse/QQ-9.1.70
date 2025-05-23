package com.tencent.qqlive.tvkplayer.qqliveasset.api;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.render.ITVKDrawableContainer;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.hook.ITVKQQLiveAssetPlayerHookCallback;
import com.tencent.qqlive.tvkplayer.postprocess.api.ITVKVideoFxErrorListener;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.ITVKQQLiveAssetPlayerSharedOperator;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.TVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKPlayerTrigger;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.TVKMethodMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.TVKQQLiveAssetPlayerTrigger;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;

/* loaded from: classes23.dex */
public class TVKAssetPlayerFactory {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public static class AssetPlayerInvocationHandler implements InvocationHandler {
        private static final String MODULE_NAME = "AssetPlayerInvocationHandler";
        private static final Method sProcessError;
        private static final Method sStop;

        @Nullable
        private final ITVKQQLiveAssetPlayerHookCallback mHookCallback;

        @NonNull
        private final ITVKLogger mLogger;

        @NonNull
        private final TVKQQLiveAssetPlayer mTarget;

        @NonNull
        private final ITVKPlayerTrigger mTrigger;

        static {
            try {
                sStop = TVKQQLiveAssetPlayer.class.getMethod("stop", new Class[0]);
                sProcessError = TVKQQLiveAssetPlayer.class.getMethod("processError", TVKError.class);
            } catch (NoSuchMethodException e16) {
                throw new RuntimeException("no such method, please fix this problem(rename method)", e16);
            }
        }

        public AssetPlayerInvocationHandler(@NonNull TVKQQLiveAssetPlayer tVKQQLiveAssetPlayer, @NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @Nullable ITVKQQLiveAssetPlayerHookCallback iTVKQQLiveAssetPlayerHookCallback) {
            this.mTrigger = new TVKQQLiveAssetPlayerTrigger(tVKQQLiveAssetPlayerContext);
            this.mTarget = tVKQQLiveAssetPlayer;
            this.mHookCallback = iTVKQQLiveAssetPlayerHookCallback;
            this.mLogger = new TVKLogger(tVKQQLiveAssetPlayerContext, MODULE_NAME);
        }

        private void hookMethod(Method method, Object[] objArr) {
            if (this.mHookCallback != null) {
                try {
                    Method method2 = ITVKQQLiveAssetPlayerHookCallback.class.getMethod(method.getName(), method.getParameterTypes());
                    this.mLogger.debug("dealHookExecute, need execute hook, method:" + method.getName(), new Object[0]);
                    method2.invoke(this.mHookCallback, objArr);
                } catch (NoSuchMethodException unused) {
                    this.mLogger.debug("dealHookExecute, not need execute hook, method:" + method.getName(), new Object[0]);
                } catch (Exception e16) {
                    this.mLogger.error("dealHookExecute, method:" + method.getName() + ", has exception:" + e16.toString(), new Object[0]);
                }
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                hookMethod(method, objArr);
                if (!TVKMethodMatcher.isSameMethod(sStop, method) && !TVKMethodMatcher.isSameMethod(sProcessError, method)) {
                    TVKQQLiveAssetPlayerContext assetPlayerContext = this.mTarget.getAssetPlayerContext();
                    Iterator<ITVKFunction> it = this.mTrigger.findConsumeNotificationFunction(assetPlayerContext, method, objArr).iterator();
                    while (it.hasNext()) {
                        it.next().consumeNotification(method, objArr);
                    }
                    ITVKPlayerTrigger.FunctionStateMatcher findExecuteFunction = this.mTrigger.findExecuteFunction(assetPlayerContext, method, objArr);
                    ITVKFunction function = findExecuteFunction.getFunction();
                    if (function != null) {
                        ITVKStateMatcher stateMatcher = findExecuteFunction.getStateMatcher();
                        if (stateMatcher != null && !stateMatcher.isMatch(assetPlayerContext.getState())) {
                            if (!TVKAssetPlayerFactory.isMethodDeclareIllegalStateException(method)) {
                                this.mLogger.error("invoke method=" + method.getName() + " can not trigger function=" + function.getClass().getSimpleName() + " cause not match state, mState=" + assetPlayerContext.getState().state(), new Object[0]);
                                return null;
                            }
                            throw new InvocationTargetException(new IllegalStateException("method=" + method.getName() + " did not match current state=" + assetPlayerContext.getState().state() + " throw a illegal state exception"), "illegal state need throw");
                        }
                        this.mLogger.info("findExecuteFunction=" + function.getClass().getSimpleName() + " state=" + assetPlayerContext.getState(), new Object[0]);
                        return this.mTrigger.executeFunction(function, assetPlayerContext, method, objArr);
                    }
                    ITVKFunction findTakeOverFunction = this.mTrigger.findTakeOverFunction(assetPlayerContext, method, objArr);
                    if (findTakeOverFunction != null) {
                        return findTakeOverFunction.takeOverMethod(method, objArr);
                    }
                    return method.invoke(this.mTarget, objArr);
                }
                this.mTrigger.reset();
                return method.invoke(this.mTarget, objArr);
            } catch (InvocationTargetException e16) {
                this.mLogger.warn("invoke method " + method.getName() + " has exception:" + e16.getTargetException(), new Object[0]);
                throw e16.getTargetException();
            }
        }
    }

    public static ITVKQQLiveAssetPlayer createAssetPlayer(@NonNull TVKContext tVKContext, ITVKDrawableContainer iTVKDrawableContainer, @Nullable Looper looper, @Nullable Looper looper2) {
        return createAssetPlayerProxyInstance(tVKContext, iTVKDrawableContainer, looper, looper2, null);
    }

    public static ITVKQQLiveAssetPlayer createAssetPlayerProxyInstance(@NonNull TVKContext tVKContext, ITVKDrawableContainer iTVKDrawableContainer, @Nullable Looper looper, @Nullable Looper looper2, @Nullable ITVKQQLiveAssetPlayerHookCallback iTVKQQLiveAssetPlayerHookCallback) {
        TVKQQLiveAssetPlayer tVKQQLiveAssetPlayer = new TVKQQLiveAssetPlayer(tVKContext, iTVKDrawableContainer, looper, looper2);
        TVKQQLiveAssetPlayerContext assetPlayerContext = tVKQQLiveAssetPlayer.getAssetPlayerContext();
        Object newProxyInstance = Proxy.newProxyInstance(TVKQQLiveAssetPlayer.class.getClassLoader(), TVKQQLiveAssetPlayer.class.getInterfaces(), new AssetPlayerInvocationHandler(tVKQQLiveAssetPlayer, assetPlayerContext, iTVKQQLiveAssetPlayerHookCallback));
        assetPlayerContext.setPlayerSharedOperator((ITVKQQLiveAssetPlayerSharedOperator) newProxyInstance);
        tVKQQLiveAssetPlayer.setTVKTPPlayerListener((ITVKTPPlayerListener) newProxyInstance);
        tVKQQLiveAssetPlayer.setVideoFxErrorListener((ITVKVideoFxErrorListener) newProxyInstance);
        return (ITVKQQLiveAssetPlayer) newProxyInstance;
    }

    public static ITVKPlayerState createPlayerState() {
        return new TVKPlayerState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isMethodDeclareIllegalStateException(Method method) {
        for (Class<?> cls : method.getExceptionTypes()) {
            if (cls == IllegalStateException.class) {
                return true;
            }
        }
        return false;
    }
}
