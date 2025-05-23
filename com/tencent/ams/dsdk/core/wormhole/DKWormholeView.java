package com.tencent.ams.dsdk.core.wormhole;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.ams.xsad.rewarded.dynamic.method.RewardAdMethodHandler;
import com.tencent.ams.xsad.rewarded.dynamic.method.VideoPlayerMethodHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class DKWormholeView extends FrameLayout {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKWormholeView";

    @DKEngine.DKAdType
    private final String mAdType;
    private long mCurrentPosition;
    private DKWormholeEngine mEngine;
    private Application.ActivityLifecycleCallbacks mLifecycleCallbacks;
    private DKWormholeViewListener mListener;
    private final DKMethodHandler mModuleHandler;

    @DKEngine.DKModuleID
    private final String mModuleId;
    private final OnLayoutChangedListener mOnLayoutChangedListener;
    private OnShowStatusChangedListener mOnShowStatusChangedListener;
    private DKEngine.OnViewCreateListener mOnViewCreateListener;
    private final DKMethodHandler mPlayerHandler;
    private int mRootId;
    private ViewShowCheckListener mShowCheckListener;
    private String mWormholeId;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ClickInfo {
        static IPatchRedirector $redirector_;
        public int clickArea;
        public View clickView;
        public float clickX;
        public float clickY;
        public float height;
        public float width;

        public ClickInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "ClickInfo{clickArea=" + this.clickArea + ", clickX=" + this.clickX + ", clickY=" + this.clickY + ", width=" + this.width + ", height=" + this.height + ", clickView=" + this.clickView + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface DKWormholeViewListener {
        boolean handlerHippyEvent(String str, JSONObject jSONObject);

        void onAdClicked(ClickInfo clickInfo);

        void onAdPlayComplete();

        void onAdPlayFailed();

        void onAdPlayPause();

        void onAdPlayPositionUpdate(int i3);

        void onAdPlayResume();

        void onAdPlayStart();

        void onEffectExposure();

        void onOriginalExposure();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class OnLayoutChangedListener implements View.OnLayoutChangeListener {
        static IPatchRedirector $redirector_;

        OnLayoutChangedListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKWormholeView.this);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
                return;
            }
            DLog.d(DKWormholeView.TAG, "onLayoutChange, left: " + i3 + ", top: " + i16 + ", right: " + i17 + ", bottom: " + i18);
            int i29 = i17 - i3;
            int i36 = i18 - i16;
            int i37 = i27 - i19;
            int i38 = i28 - i26;
            if (view == DKWormholeView.this) {
                if (i36 != i38 || i29 != i37) {
                    DLog.i(DKWormholeView.TAG, "onSizeChanged, newWidth: " + i29 + ", newHeight: " + i36 + ", oldWidth: " + i37 + ", oldHeight: " + i38);
                    if (DKWormholeView.this.mEngine != null) {
                        HippyMap buildEventParams = DKWormholeView.this.buildEventParams();
                        if (buildEventParams != null) {
                            buildEventParams.pushInt("width", i29);
                            buildEventParams.pushInt("height", i36);
                        }
                        DKWormholeView.this.mEngine.sendEvent(DKHippyEvent.EVENT_VIEW_SIZE_CHANGED, buildEventParams);
                    }
                }
            }
        }

        /* synthetic */ OnLayoutChangedListener(DKWormholeView dKWormholeView, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dKWormholeView, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnShowStatusChangedListener {
        void onHidden();

        void onShow();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    @interface PlayerEventId {
        public static final int COMPLETE = 4;
        public static final int ERROR = 5;
        public static final int PAUSE = 2;
        public static final int RESUME = 3;
        public static final int START = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class ViewShowCheckListener implements ViewTreeObserver.OnScrollChangedListener {
        static IPatchRedirector $redirector_ = null;
        private static final float SHOWING_RATIO = 0.5f;
        private boolean isShowing;
        private final WeakReference<View> viewRef;

        public ViewShowCheckListener(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKWormholeView.this, (Object) view);
            } else {
                this.viewRef = new WeakReference<>(view);
                checkViewShow();
            }
        }

        private void checkViewShow() {
            View view = this.viewRef.get();
            if (view != null) {
                if (view.getGlobalVisibleRect(new Rect())) {
                    int width = view.getWidth() * view.getHeight();
                    if (width <= 0) {
                        DLog.w(DKWormholeView.TAG, "onScrollChanged: invalid viewArea");
                        return;
                    }
                    if ((r1.width() * r1.height()) / width >= 0.5f) {
                        if (!this.isShowing) {
                            if (DKWormholeView.this.mEngine != null) {
                                DKWormholeView.this.mEngine.sendEvent(DKHippyEvent.EVENT_VIEW_SCROLL_TO_SHOW, DKWormholeView.this.buildEventParams());
                            }
                            this.isShowing = true;
                            if (DKWormholeView.this.mOnShowStatusChangedListener != null) {
                                DKWormholeView.this.mOnShowStatusChangedListener.onShow();
                            }
                            DLog.d(DKWormholeView.TAG, "ViewShowCheckListener: view is show, wormholeId: " + DKWormholeView.this.mWormholeId + ", rootId: " + DKWormholeView.this.mRootId);
                            return;
                        }
                        return;
                    }
                    if (this.isShowing) {
                        if (DKWormholeView.this.mEngine != null) {
                            DKWormholeView.this.mEngine.sendEvent(DKHippyEvent.EVENT_VIEW_SCROLL_TO_HIDE, DKWormholeView.this.buildEventParams());
                        }
                        if (DKWormholeView.this.mOnShowStatusChangedListener != null) {
                            DKWormholeView.this.mOnShowStatusChangedListener.onHidden();
                        }
                        this.isShowing = false;
                        DLog.d(DKWormholeView.TAG, "ViewShowCheckListener: view is hide, wormholeId: " + DKWormholeView.this.mWormholeId + ", rootId: " + DKWormholeView.this.mRootId);
                    }
                }
            }
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                checkViewShow();
            }
        }
    }

    public DKWormholeView(Context context, @DKEngine.DKModuleID String str, @DKEngine.DKAdType String str2) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, str2);
            return;
        }
        this.mCurrentPosition = 0L;
        this.mOnLayoutChangedListener = new OnLayoutChangedListener(this, null);
        this.mModuleHandler = new DKMethodHandler() { // from class: com.tencent.ams.dsdk.core.wormhole.DKWormholeView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKWormholeView.this);
                }
            }

            @Override // com.tencent.ams.dsdk.event.DKMethodHandler
            public String getModuleId() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    return DKWormholeView.this.mModuleId;
                }
                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
            
                if (r8.equals(com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler.AdCommonEvent.CLICK_ACTION) == false) goto L10;
             */
            @Override // com.tencent.ams.dsdk.event.DKMethodHandler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean invoke(DKEngine dKEngine, String str3, JSONObject jSONObject, DKMethodHandler.Callback callback) throws Exception {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                char c16 = 2;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 3, this, dKEngine, str3, jSONObject, callback)).booleanValue();
                }
                str3.hashCode();
                switch (str3.hashCode()) {
                    case -1012968068:
                        if (str3.equals("onShow")) {
                            c16 = 0;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case -293028361:
                        if (str3.equals(RewardAdMethodHandler.RewardAdEvent.ON_ORIGINAL_EXPOSURE)) {
                            c16 = 1;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case 811723230:
                        break;
                    default:
                        c16 = '\uffff';
                        break;
                }
                switch (c16) {
                    case 0:
                        DKWormholeView.this.handlerEffectExposure(callback);
                        return true;
                    case 1:
                        DKWormholeView.this.handlerOriginalExposure(callback);
                        return true;
                    case 2:
                        DKWormholeView.this.handleAdClick(jSONObject, callback);
                        return true;
                    default:
                        return DKWormholeView.this.handlerOtherEvents(str3, jSONObject, callback);
                }
            }
        };
        this.mPlayerHandler = new DKMethodHandler() { // from class: com.tencent.ams.dsdk.core.wormhole.DKWormholeView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKWormholeView.this);
                }
            }

            @Override // com.tencent.ams.dsdk.event.DKMethodHandler
            public String getModuleId() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "VideoPlayer";
            }

            @Override // com.tencent.ams.dsdk.event.DKMethodHandler
            public boolean invoke(DKEngine dKEngine, String str3, JSONObject jSONObject, DKMethodHandler.Callback callback) throws Exception {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 3, this, dKEngine, str3, jSONObject, callback)).booleanValue();
                }
                str3.hashCode();
                if (!str3.equals("onPlayStatusChanged")) {
                    if (str3.equals(VideoPlayerMethodHandler.VideoPlayerEvent.ON_PLAY_PROGRESS_CHANGED)) {
                        DKWormholeView.this.handleVideoProgressChanged(jSONObject, callback);
                        return true;
                    }
                    return false;
                }
                DynamicUtils.runOnUiThread(new Runnable(jSONObject, callback) { // from class: com.tencent.ams.dsdk.core.wormhole.DKWormholeView.2.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ DKMethodHandler.Callback val$callback;
                    final /* synthetic */ JSONObject val$jsonObject;

                    {
                        this.val$jsonObject = jSONObject;
                        this.val$callback = callback;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, AnonymousClass2.this, jSONObject, callback);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                            DKWormholeView.this.handleVideoPlayStatusChanged(this.val$jsonObject, this.val$callback);
                        } else {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    }
                });
                return true;
            }
        };
        this.mModuleId = str;
        this.mAdType = str2;
        initEngine();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HippyMap buildEventParams() {
        try {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushString(DKWormholeHelper.WORMHOLE_ID, this.mWormholeId);
            return hippyMap;
        } catch (Throwable unused) {
            return null;
        }
    }

    private Application getApplication() {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (!(applicationContext instanceof Application)) {
            return null;
        }
        return (Application) applicationContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAdClick(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        DLog.i(TAG, "handleAdClick, params: " + jSONObject + ", wormholeId: " + this.mWormholeId);
        DKWormholeViewListener dKWormholeViewListener = this.mListener;
        if (dKWormholeViewListener != null) {
            dKWormholeViewListener.onAdClicked(makeClickInfo(jSONObject));
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoPlayStatusChanged(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        DLog.i(TAG, "handleVideoPlayStatusChanged, params: " + jSONObject);
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("eventId");
            this.mCurrentPosition = ((long) jSONObject.optDouble("timeOffset")) * 1000;
            DKWormholeViewListener dKWormholeViewListener = this.mListener;
            if (dKWormholeViewListener != null) {
                if (optInt != 1) {
                    if (optInt != 2) {
                        if (optInt != 3) {
                            if (optInt != 4) {
                                if (optInt == 5) {
                                    dKWormholeViewListener.onAdPlayFailed();
                                }
                            } else {
                                dKWormholeViewListener.onAdPlayComplete();
                            }
                        } else {
                            dKWormholeViewListener.onAdPlayResume();
                        }
                    } else {
                        dKWormholeViewListener.onAdPlayPause();
                    }
                } else {
                    dKWormholeViewListener.onAdPlayStart();
                }
            }
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoProgressChanged(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        if (jSONObject != null) {
            long optDouble = (long) (jSONObject.optDouble("position") * 1000.0d);
            this.mCurrentPosition = optDouble;
            DKWormholeViewListener dKWormholeViewListener = this.mListener;
            if (dKWormholeViewListener != null) {
                dKWormholeViewListener.onAdPlayPositionUpdate((int) optDouble);
            }
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerEffectExposure(DKMethodHandler.Callback callback) {
        DLog.i(TAG, "handlerEffectExposure");
        DKWormholeViewListener dKWormholeViewListener = this.mListener;
        if (dKWormholeViewListener != null) {
            dKWormholeViewListener.onEffectExposure();
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerOriginalExposure(DKMethodHandler.Callback callback) {
        DLog.i(TAG, "handlerOriginalExposure");
        DKWormholeViewListener dKWormholeViewListener = this.mListener;
        if (dKWormholeViewListener != null) {
            dKWormholeViewListener.onOriginalExposure();
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handlerOtherEvents(String str, JSONObject jSONObject, DKMethodHandler.Callback callback) {
        DLog.i(TAG, "handlerOtherEvents, methodName:" + str + ", params:" + jSONObject);
        DKWormholeViewListener dKWormholeViewListener = this.mListener;
        if (dKWormholeViewListener != null) {
            if (dKWormholeViewListener.handlerHippyEvent(str, jSONObject)) {
                if (callback != null) {
                    callback.onResult(null);
                    return true;
                }
                return true;
            }
            DLog.d(TAG, "not handler hippy event, methodName:" + str + ", params:" + jSONObject);
            return false;
        }
        return false;
    }

    private void initEngine() {
        DKWormholeEngine engine = DKWormholeManager.getInstance().getEngine(this.mModuleId);
        this.mEngine = engine;
        if (engine != null) {
            this.mRootId = engine.generateRootId(getContext());
            this.mWormholeId = this.mEngine.generateWormholeId();
        }
    }

    private ClickInfo makeClickInfo(JSONObject jSONObject) {
        ClickInfo clickInfo = new ClickInfo();
        if (jSONObject != null) {
            clickInfo.clickArea = jSONObject.optInt("click_type");
            clickInfo.clickX = jSONObject.optInt(AdCommonMethodHandler.AdCommonEventParamsKey.DOWN_X);
            clickInfo.clickY = jSONObject.optInt(AdCommonMethodHandler.AdCommonEventParamsKey.DOWN_Y);
        }
        clickInfo.clickView = this;
        clickInfo.width = getMeasuredWidth();
        clickInfo.height = getMeasuredHeight();
        return clickInfo;
    }

    private void registerHandler() {
        DLog.i(TAG, "registerHandler wormholeId: " + this.mWormholeId);
        DKWormholeEngine dKWormholeEngine = this.mEngine;
        if (dKWormholeEngine != null) {
            dKWormholeEngine.registerMethodHandler(this.mWormholeId, this.mModuleHandler);
            this.mEngine.registerMethodHandler(this.mWormholeId, this.mPlayerHandler);
        }
    }

    private void registerLifecycleListener() {
        if (this.mLifecycleCallbacks != null) {
            unregisterLifecycleListener();
        }
        this.mLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.tencent.ams.dsdk.core.wormhole.DKWormholeView.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKWormholeView.this);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
                    return;
                }
                DLog.i(DKWormholeView.TAG, "onActivityCreated, activity: " + activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NonNull Activity activity) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
                    return;
                }
                DLog.i(DKWormholeView.TAG, "onActivityDestroyed, activity: " + activity);
                if (activity == DynamicUtils.getActivityFromContext(DKWormholeView.this.getContext())) {
                    DKWormholeView.this.unregisterLifecycleListener();
                    DKWormholeView.this.destroy();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NonNull Activity activity) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
                    return;
                }
                DLog.i(DKWormholeView.TAG, "onActivityPaused, activity: " + activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NonNull Activity activity) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
                    return;
                }
                DLog.i(DKWormholeView.TAG, "onActivityResumed, activity: " + activity);
                ViewShowCheckListener viewShowCheckListener = DKWormholeView.this.mShowCheckListener;
                if (activity == DynamicUtils.getActivityFromContext(DKWormholeView.this.getContext()) && viewShowCheckListener != null && viewShowCheckListener.isShowing) {
                    DLog.i(DKWormholeView.TAG, "wormhole view resume, wormholeId: " + DKWormholeView.this.getWormholeId());
                    if (DKWormholeView.this.mEngine != null) {
                        DKWormholeView.this.mEngine.onResume();
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) bundle);
                    return;
                }
                DLog.i(DKWormholeView.TAG, "onActivitySaveInstanceState, activity: " + activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@NonNull Activity activity) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
                    return;
                }
                DLog.i(DKWormholeView.TAG, "onActivityStarted, activity: " + activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NonNull Activity activity) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
                    return;
                }
                DLog.i(DKWormholeView.TAG, "onActivityStopped, activity: " + activity);
                ViewShowCheckListener viewShowCheckListener = DKWormholeView.this.mShowCheckListener;
                if (activity == DynamicUtils.getActivityFromContext(DKWormholeView.this.getContext()) && viewShowCheckListener != null && viewShowCheckListener.isShowing) {
                    DLog.i(DKWormholeView.TAG, "wormhole view stop, wormholeId: " + DKWormholeView.this.getWormholeId());
                    if (DKWormholeView.this.mEngine != null) {
                        DKWormholeView.this.mEngine.onStop();
                    }
                }
            }
        };
        Application application = getApplication();
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
        }
    }

    private void startShowCheck() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            ViewShowCheckListener viewShowCheckListener = new ViewShowCheckListener(this);
            this.mShowCheckListener = viewShowCheckListener;
            viewTreeObserver.addOnScrollChangedListener(viewShowCheckListener);
            DLog.d(TAG, "addExposureCheck");
        }
    }

    private void stopShowCheck() {
        ViewTreeObserver viewTreeObserver;
        if (this.mShowCheckListener != null && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnScrollChangedListener(this.mShowCheckListener);
            this.mShowCheckListener = null;
            DLog.d(TAG, "removeExposureCheck");
        }
    }

    private void unregisterHandler() {
        DLog.w(TAG, "unregisterHandler wormholeId: " + this.mWormholeId);
        DKWormholeEngine dKWormholeEngine = this.mEngine;
        if (dKWormholeEngine != null) {
            dKWormholeEngine.unregisterMethodHandler(this.mWormholeId, this.mModuleHandler);
            this.mEngine.unregisterMethodHandler(this.mWormholeId, this.mPlayerHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterLifecycleListener() {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        Application application = getApplication();
        if (application != null && (activityLifecycleCallbacks = this.mLifecycleCallbacks) != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        this.mLifecycleCallbacks = null;
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        unregisterHandler();
        DKWormholeEngine dKWormholeEngine = this.mEngine;
        if (dKWormholeEngine != null) {
            dKWormholeEngine.destroyWormhole(this.mWormholeId, this.mRootId);
        }
    }

    public long getCurrentPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.mCurrentPosition;
    }

    public int getRootId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mRootId;
    }

    public String getWormholeId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mWormholeId;
    }

    public void notifyVisibleChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        DLog.i(TAG, "notifyVisibleChanged, visible: " + z16);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushBoolean(NodeProps.VISIBLE, z16);
        sendEvent(DKHippyEvent.EVENT_VIEW_VISIBLE_CHANGED, hippyMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        DLog.i(TAG, NodeProps.ON_ATTACHED_TO_WINDOW);
        super.onAttachedToWindow();
        startShowCheck();
        registerLifecycleListener();
        addOnLayoutChangeListener(this.mOnLayoutChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        DLog.i(TAG, NodeProps.ON_DETACHED_FROM_WINDOW);
        removeOnLayoutChangeListener(this.mOnLayoutChangedListener);
        stopShowCheck();
        unregisterLifecycleListener();
        super.onDetachedFromWindow();
    }

    public void sendEvent(String str, HippyMap hippyMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) hippyMap);
            return;
        }
        HippyMap buildEventParams = buildEventParams();
        if (hippyMap != null && buildEventParams != null) {
            buildEventParams.pushAll(hippyMap);
        }
        DKWormholeEngine dKWormholeEngine = this.mEngine;
        if (dKWormholeEngine != null) {
            dKWormholeEngine.sendEvent(str, buildEventParams);
        }
    }

    public void setData(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) map);
        } else {
            WorkThreadManager.getInstance().getImmediateThreadPool().execute(new Runnable(map) { // from class: com.tencent.ams.dsdk.core.wormhole.DKWormholeView.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ Map val$dataMap;

                {
                    this.val$dataMap = map;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKWormholeView.this, (Object) map);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        try {
                            DKWormholeEngine dKWormholeEngine = DKWormholeView.this.mEngine;
                            if (dKWormholeEngine != null && !DKWormholeHelper.getWormholeManager().isWormholeEngine(dKWormholeEngine.getHippyEngineContext())) {
                                DKWormholeHelper.getWormholeManager().setServerEngine(dKWormholeEngine.getHippyEngine());
                            }
                            HashMap hashMap = new HashMap(this.val$dataMap);
                            hashMap.put(DKEngine.PARAM_KEY_JS_FILE_PATH, DKEngine.getBundlePathRealTime(DKWormholeView.this.mModuleId, DKConfiguration.getBundleLoadTimeout()));
                            hashMap.put(DKEngine.PARAM_KEY_AD_TYPE, DKWormholeView.this.mAdType);
                            hashMap.put(DKEngine.PARAM_KEY_APP_NAME, DKWormholeView.this.mModuleId);
                            DKEngine.CreateViewInfo createViewInfo = new DKEngine.CreateViewInfo();
                            createViewInfo.context = DynamicUtils.getActivityFromContext(DKWormholeView.this.getContext());
                            DKWormholeView dKWormholeView = DKWormholeView.this;
                            createViewInfo.container = dKWormholeView;
                            createViewInfo.params = hashMap;
                            createViewInfo.onViewCreateListener = dKWormholeView.mOnViewCreateListener;
                            if (dKWormholeEngine != null) {
                                dKWormholeEngine.createView(createViewInfo);
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            DLog.d(DKWormholeView.TAG, "setData failed: throw exception", th5);
                            return;
                        }
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            registerHandler();
        }
    }

    public void setListener(DKWormholeViewListener dKWormholeViewListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dKWormholeViewListener);
            return;
        }
        this.mListener = dKWormholeViewListener;
        if (dKWormholeViewListener == null) {
            unregisterHandler();
        } else {
            registerHandler();
        }
    }

    public void setOnShowStatusChangedListener(OnShowStatusChangedListener onShowStatusChangedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onShowStatusChangedListener);
        } else {
            this.mOnShowStatusChangedListener = onShowStatusChangedListener;
        }
    }

    public void setOnViewCreateListener(DKEngine.OnViewCreateListener onViewCreateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onViewCreateListener);
        } else {
            this.mOnViewCreateListener = onViewCreateListener;
        }
    }

    public void updateActionButtonText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        DKWormholeEngine dKWormholeEngine = this.mEngine;
        if (dKWormholeEngine != null) {
            HippyMap buildEventParams = buildEventParams();
            if (buildEventParams != null) {
                buildEventParams.pushString("text", str);
            }
            dKWormholeEngine.sendEvent(DKHippyEvent.EVENT_UPDATE_ACTION_BUTTON_TEXT, buildEventParams);
        }
    }
}
