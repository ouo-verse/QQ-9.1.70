package com.tencent.ams.dsdk.core.wormhole;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.event.DKEventHandler;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.HippyEngine;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKWormholeManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKWormholeManager";
    private static final DKWormholeManager instance;
    private Map<String, Integer> mEngineErrorCodeMap;
    private Map<String, Integer> mEngineInitStates;
    private Map<String, DKWormholeEngine> mEngineMap;
    private DKWormholeEngineEventListener mEventListener;
    private Map<String, InitParams> mInitParamsMap;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface DKWormholeEngineEventListener {
        void onEngineInitFinish(String str, @ErrorCode int i3, long j3);

        void onEngineInitStart(String str);
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface EngineInitState {
        public static final int STATE_IDLE = 0;
        public static final int STATE_INIT_FAIL = 2;
        public static final int STATE_INIT_RUNNING = 1;
        public static final int STATE_INIT_SUCCESS = 3;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface ErrorCode {
        public static final int BUNDLE_ERROR = 4;
        public static final int BUNDLE_NOT_EXITS = 3;
        public static final int INIT_RUNNING = 5;
        public static final int NOT_SUPPORT = 1;
        public static final int OK = 0;
        public static final int OTHER = 6;
        public static final int UNKNOWN = -1;
        public static final int VENDOR_NOT_EXITS = 2;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class InitParams extends DKWormholeInitParams {
        static IPatchRedirector $redirector_;

        public InitParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17619);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            instance = new DKWormholeManager();
        }
    }

    DKWormholeManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mInitParamsMap = new ConcurrentHashMap();
        this.mEngineInitStates = new ConcurrentHashMap();
        this.mEngineMap = new ConcurrentHashMap();
        this.mEngineErrorCodeMap = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ErrorCode
    public int getErrorCode(Integer num) {
        if (num == null) {
            return 6;
        }
        if (num.intValue() == HippyEngine.EngineInitStatus.STATUS_ERR_BRIDGE.value() || num.intValue() == HippyEngine.ModuleLoadStatus.STATUS_ERR_RUN_BUNDLE.value() || num.intValue() == HippyEngine.EngineInitStatus.STATUS_INIT_EXCEPTION.value()) {
            return 4;
        }
        int intValue = num.intValue();
        if (intValue != 1) {
            if (intValue != 4) {
                switch (intValue) {
                    case 9006:
                        return 3;
                    case 9007:
                        return 4;
                    case 9008:
                    case 9009:
                        break;
                    default:
                        return 6;
                }
            }
            return 1;
        }
        return 2;
    }

    public static DKWormholeManager getInstance() {
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyInitFinish(String str, @ErrorCode int i3, long j3) {
        DKWormholeEngineEventListener dKWormholeEngineEventListener = this.mEventListener;
        if (dKWormholeEngineEventListener != null) {
            dKWormholeEngineEventListener.onEngineInitFinish(str, i3, System.currentTimeMillis() - j3);
        }
    }

    private void notifyInitStart(String str) {
        DKWormholeEngineEventListener dKWormholeEngineEventListener = this.mEventListener;
        if (dKWormholeEngineEventListener != null) {
            dKWormholeEngineEventListener.onEngineInitStart(str);
        }
    }

    public DKWormholeEngine getEngine(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (DKWormholeEngine) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            DLog.w(TAG, "getEngine error. moduleId is empty");
            return null;
        }
        return this.mEngineMap.get(str);
    }

    @ErrorCode
    public int getWormholeEngineStatus(String str) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).intValue();
        }
        if (TextUtils.isEmpty(str) || (num = this.mEngineInitStates.get(str)) == null) {
            return -1;
        }
        if (num.intValue() == 3) {
            return 0;
        }
        if (num.intValue() == 2) {
            Integer num2 = this.mEngineErrorCodeMap.get(str);
            retryInitEngine(str);
            return getErrorCode(num2);
        }
        if (num.intValue() != 0 && num.intValue() != 1) {
            return -1;
        }
        return 5;
    }

    public void initEngine(Context context, InitParams initParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) initParams);
            return;
        }
        DLog.d(TAG, "createWormholeEngine");
        long currentTimeMillis = System.currentTimeMillis();
        if (initParams == null) {
            DLog.w(TAG, "init engine failed, init params is null.");
            return;
        }
        String str = initParams.moduleId;
        String str2 = initParams.adType;
        if (TextUtils.isEmpty(str)) {
            DLog.w(TAG, "init engine failed, module id is empty.");
            return;
        }
        Integer num = this.mEngineInitStates.get(str);
        if (num == null) {
            num = 0;
            this.mEngineInitStates.put(str, num);
        }
        if (this.mEngineMap.get(str) != null && num.intValue() == 3) {
            DLog.w(TAG, "engine is already init.");
            return;
        }
        this.mEngineInitStates.put(str, 1);
        this.mInitParamsMap.put(str, initParams);
        String vendorPath = DKEngine.getVendorPath();
        DLog.d(TAG, "init vendorPath:" + vendorPath);
        notifyInitStart(str);
        DKWormholeEngine dKWormholeEngine = new DKWormholeEngine();
        this.mEngineMap.put(str, dKWormholeEngine);
        DKEventHandler dKEventHandler = initParams.eventHandler;
        if (dKEventHandler != null) {
            dKWormholeEngine.addEventHandler(dKEventHandler);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DKEngine.PARAM_KEY_JS_FILE_PATH, DKEngine.getBundlePathRealTime(str, DKConfiguration.getBundleLoadTimeout()));
        hashMap.put(DKEngine.PARAM_KEY_APP_NAME, str);
        hashMap.put(DKEngine.PARAM_KEY_AD_TYPE, str2);
        dKWormholeEngine.createEngine(context, hashMap, new DKEngine.OnCreateEngineListener(dKWormholeEngine, initParams, vendorPath, str, currentTimeMillis) { // from class: com.tencent.ams.dsdk.core.wormhole.DKWormholeManager.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ DKWormholeEngine val$engine;
            final /* synthetic */ InitParams val$initParams;
            final /* synthetic */ String val$moduleId;
            final /* synthetic */ long val$startTime;
            final /* synthetic */ String val$vendorPath;

            {
                this.val$engine = dKWormholeEngine;
                this.val$initParams = initParams;
                this.val$vendorPath = vendorPath;
                this.val$moduleId = str;
                this.val$startTime = currentTimeMillis;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DKWormholeManager.this, dKWormholeEngine, initParams, vendorPath, str, Long.valueOf(currentTimeMillis));
                }
            }

            @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
            public void onEngineInitializeError(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, i3);
                    return;
                }
                DLog.d(DKWormholeManager.TAG, "onEngineInitializeError, errorCode: " + i3);
                DKWormholeManager.this.mEngineInitStates.put(this.val$moduleId, 2);
                DKWormholeManager.this.mEngineErrorCodeMap.put(this.val$moduleId, Integer.valueOf(i3));
                DKWormholeManager.this.mEngineMap.remove(this.val$moduleId);
                DKWormholeManager dKWormholeManager = DKWormholeManager.this;
                dKWormholeManager.notifyInitFinish(this.val$moduleId, dKWormholeManager.getErrorCode(Integer.valueOf(i3)), this.val$startTime);
            }

            @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
            public void onEngineInitialized() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this);
                    return;
                }
                Log.d(DKWormholeManager.TAG, "onEngineInitialized");
                DKWormholeManager.this.mEngineInitStates.put(this.val$moduleId, 3);
                DKWormholeManager.this.mEngineErrorCodeMap.remove(this.val$moduleId);
                DKWormholeManager.this.notifyInitFinish(this.val$moduleId, 0, this.val$startTime);
            }

            @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
            public void onWillCreateEngine() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                HippyEngine.EngineInitParams initParams2 = this.val$engine.getInitParams();
                if (initParams2 != null) {
                    InitParams initParams3 = this.val$initParams;
                    if (initParams3 != null) {
                        initParams3.setHippyParams(initParams2);
                    }
                    if (this.val$vendorPath == null) {
                        initParams2.coreJSFilePath = DKEngine.getVendorPathRealTime(DKConfiguration.getBundleLoadTimeout());
                        DLog.w(DKWormholeManager.TAG, "get vendor file again: " + initParams2.coreJSFilePath);
                    }
                }
            }
        });
    }

    public boolean isWormholeReady(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str) || getWormholeEngineStatus(str) != 0) {
            return false;
        }
        return true;
    }

    void retryInitEngine(String str) {
        DLog.i(TAG, "retryInitEngine");
        if (TextUtils.isEmpty(str)) {
            DLog.w(TAG, "retry init engine failed, module id is empty.");
            return;
        }
        InitParams initParams = this.mInitParamsMap.get(str);
        if (initParams == null) {
            DLog.w(TAG, "retry init failed, init params is null.");
        } else {
            initEngine(DKEngine.getApplicationContext(), initParams);
        }
    }

    public void setDKWormholeEngineEventListener(DKWormholeEngineEventListener dKWormholeEngineEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dKWormholeEngineEventListener);
        } else {
            this.mEventListener = dKWormholeEngineEventListener;
        }
    }
}
