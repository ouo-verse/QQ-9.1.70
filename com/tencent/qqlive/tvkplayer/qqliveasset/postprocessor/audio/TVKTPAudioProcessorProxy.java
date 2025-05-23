package com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.audio;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.logic.TVKThreadAnnotations;
import com.tencent.qqlive.tvkplayer.logic.TVKThreadSwitch;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes23.dex */
public class TVKTPAudioProcessorProxy {
    private static final String TAG = "TVKTPAudioProcessorProxy";
    private final TVKTPAudioProcessorImpl mAudioProcessor;
    private TVKThreadSwitch mSwitch;

    public TVKTPAudioProcessorProxy(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Looper looper) {
        TVKTPAudioProcessorImpl tVKTPAudioProcessorImpl = new TVKTPAudioProcessorImpl(tVKQQLiveAssetPlayerContext);
        this.mAudioProcessor = tVKTPAudioProcessorImpl;
        this.mSwitch = new TVKThreadSwitch(TAG, looper, tVKTPAudioProcessorImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object dealThreadSwitch(Method method, Object[] objArr) throws Throwable {
        if ("void".equals(method.getReturnType().getName())) {
            this.mSwitch.dealThreadSwitch(method.getName(), objArr);
            return null;
        }
        return this.mSwitch.dealThreadSwitchWithResult(method.getName(), objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedSwitchThread(Method method, Object[] objArr) {
        if (TVKThreadAnnotations.getMethod(this.mAudioProcessor.getClass(), method.getName(), objArr) != null) {
            return true;
        }
        return false;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(this.mAudioProcessor.getClass().getClassLoader(), this.mAudioProcessor.getClass().getInterfaces(), new InvocationHandler() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.audio.TVKTPAudioProcessorProxy.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                if (TVKTPAudioProcessorProxy.this.isNeedSwitchThread(method, objArr)) {
                    return TVKTPAudioProcessorProxy.this.dealThreadSwitch(method, objArr);
                }
                return method.invoke(TVKTPAudioProcessorProxy.this.mAudioProcessor, objArr);
            }
        });
    }
}
