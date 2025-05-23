package com.tencent.ams.mosaic.jsengine.common;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.hippo.quickjs.android.JSValue;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
interface IEnv {

    /* compiled from: P */
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes3.dex */
    public @interface AppState {
        public static final int BACKGROUND = 3;
        public static final int FOREGROUND = 1;
        public static final int PERCEPTIBLE = 2;
        public static final int UNKNOWN = 0;
    }

    void addAppLifeCycleListenerDict(JSObject jSObject);

    float dp2px(float f16);

    @AppState
    int getAppState();

    String getClipboardData();

    JSValue getGlobalInfo();

    String getPlatform();

    JSObject getSafeAreaInsets();

    int getScreenHeight();

    int getScreenWidth();

    float px2dp(float f16);

    @Deprecated
    void runOnAsyncThread(JSFunction jSFunction);

    @Deprecated
    void runOnUIThread(JSFunction jSFunction);

    @Deprecated
    void runOnUIThreadDelay(JSFunction jSFunction, long j3);

    String scheduledTimer(int i3, boolean z16, JSFunction jSFunction);

    String scheduledTimerDelay(int i3, int i16, boolean z16, JSFunction jSFunction);

    String scheduledTimerDelayInAsyncThread(int i3, int i16, boolean z16, JSFunction jSFunction);

    String scheduledTimerInAsyncThread(int i3, boolean z16, JSFunction jSFunction);

    void setClipboardData(String str);

    void setUseFastImageView(boolean z16);

    void stopTimer(String str);
}
