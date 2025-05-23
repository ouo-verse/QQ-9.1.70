package com.tencent.youtu.sdkkitframework.framework;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.youtu.sdkkitframework.common.BytesPoolHelper;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.OperateInfoManager;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.YTImageData;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.httpcore.HttpHeaders;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YtFSM {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "YtFSM";
    private static YtFSM instance;
    private boolean checkUpdateTimerFlag;
    private YTImageData currentImageData;
    private YtFSMBaseState currentState;
    private YtFSMUpdateStrategy currentStrategy;
    private YtSDKKitFramework.YtSDKKitFrameworkWorkMode currentWorkMode;
    private YtSDKKitFramework.IYtSDKKitFrameworkEventListener eventListener;
    private ConcurrentLinkedQueue<Object> eventQueue;
    private long feedTimeMs;
    private String firstStateName;
    private boolean isStarted;
    private boolean needEventHandler;
    private YtSDKKitFramework.YtSDKPlatformContext sdkPlatformContex;
    private Lock startStopLock;
    private Lock stateLock;
    private Map<String, YtFSMBaseState> stateMap;
    private Thread updateEventHandler;
    private ConcurrentLinkedQueue<YtFSMUpdateData> updateQueue;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class YtFSMFireEventData {
        static IPatchRedirector $redirector_;
        public YtSDKKitFramework.YtFrameworkFireEventType eventType;
        public Object extraData;

        public YtFSMFireEventData(YtSDKKitFramework.YtFrameworkFireEventType ytFrameworkFireEventType, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, YtFSM.this, ytFrameworkFireEventType, obj);
            } else {
                this.eventType = ytFrameworkFireEventType;
                this.extraData = obj;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class YtFSMUpdateData {
        static IPatchRedirector $redirector_;
        public byte[] imageData;
        public int imageHeight;
        public int imageWidth;
        public long timeStamp;

        YtFSMUpdateData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) YtFSM.this);
        }

        public void mirror() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            int i16 = 0;
            int i17 = 0;
            while (true) {
                i3 = this.imageHeight;
                if (i17 >= i3) {
                    break;
                }
                int i18 = this.imageWidth;
                int i19 = i17 * i18;
                i17++;
                for (int i26 = (i18 * i17) - 1; i19 < i26; i26--) {
                    byte[] bArr = this.imageData;
                    byte b16 = bArr[i19];
                    bArr[i19] = bArr[i26];
                    bArr[i26] = b16;
                    i19++;
                }
            }
            int i27 = this.imageWidth * i3;
            while (i16 < this.imageHeight / 2) {
                int i28 = this.imageWidth;
                int i29 = i16 * i28;
                i16++;
                for (int i36 = (i28 * i16) - 2; i29 < i36; i36 -= 2) {
                    byte[] bArr2 = this.imageData;
                    int i37 = i29 + i27;
                    byte b17 = bArr2[i37];
                    int i38 = i36 + i27;
                    bArr2[i37] = bArr2[i38];
                    bArr2[i38] = b17;
                    int i39 = i37 + 1;
                    byte b18 = bArr2[i39];
                    int i46 = i38 + 1;
                    bArr2[i39] = bArr2[i46];
                    bArr2[i46] = b18;
                    i29 += 2;
                }
            }
        }

        public /* synthetic */ YtFSMUpdateData(YtFSM ytFSM, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) ytFSM, (Object) anonymousClass1);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class YtFSMUpdateStrategy {
        private static final /* synthetic */ YtFSMUpdateStrategy[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final YtFSMUpdateStrategy CacheStrategy;
        public static final YtFSMUpdateStrategy NoCacheStrategy;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19749);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            YtFSMUpdateStrategy ytFSMUpdateStrategy = new YtFSMUpdateStrategy("CacheStrategy", 0);
            CacheStrategy = ytFSMUpdateStrategy;
            YtFSMUpdateStrategy ytFSMUpdateStrategy2 = new YtFSMUpdateStrategy("NoCacheStrategy", 1);
            NoCacheStrategy = ytFSMUpdateStrategy2;
            $VALUES = new YtFSMUpdateStrategy[]{ytFSMUpdateStrategy, ytFSMUpdateStrategy2};
        }

        YtFSMUpdateStrategy(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static YtFSMUpdateStrategy valueOf(String str) {
            return (YtFSMUpdateStrategy) Enum.valueOf(YtFSMUpdateStrategy.class, str);
        }

        public static YtFSMUpdateStrategy[] values() {
            return (YtFSMUpdateStrategy[]) $VALUES.clone();
        }
    }

    YtFSM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.currentWorkMode = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
        this.isStarted = false;
        this.needEventHandler = false;
        this.currentStrategy = YtFSMUpdateStrategy.CacheStrategy;
        this.feedTimeMs = 0L;
        this.checkUpdateTimerFlag = true;
        this.stateMap = new ConcurrentHashMap();
        this.stateLock = new ReentrantLock();
        this.startStopLock = new ReentrantLock();
        this.updateQueue = new ConcurrentLinkedQueue<>();
        this.eventQueue = new ConcurrentLinkedQueue<>();
        BytesPoolHelper.getInstance().recycleAll();
    }

    public static synchronized void clearInstance() {
        synchronized (YtFSM.class) {
            if (instance != null) {
                instance = null;
            }
        }
    }

    public static synchronized YtFSM getInstance() {
        YtFSM ytFSM;
        synchronized (YtFSM.class) {
            if (instance == null) {
                instance = new YtFSM();
            }
            ytFSM = instance;
        }
        return ytFSM;
    }

    public void cleanUpQueue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.updateQueue.clear();
        }
    }

    public YtSDKKitFramework.YtSDKPlatformContext getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (YtSDKKitFramework.YtSDKPlatformContext) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        if (this.sdkPlatformContex == null) {
            this.sdkPlatformContex = new YtSDKKitFramework.YtSDKPlatformContext();
        }
        return this.sdkPlatformContex;
    }

    public YtFSMBaseState getStateByName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (YtFSMBaseState) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        if (this.stateMap.containsKey(str)) {
            return this.stateMap.get(str);
        }
        return null;
    }

    public YtSDKKitFramework.YtSDKKitFrameworkWorkMode getWorkMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (YtSDKKitFramework.YtSDKKitFrameworkWorkMode) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.currentWorkMode;
    }

    public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType ytFrameworkFireEventType, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) ytFrameworkFireEventType, obj);
            return;
        }
        try {
            this.eventQueue.add(new YtFSMFireEventData(ytFrameworkFireEventType, obj));
        } catch (Exception e16) {
            OperateInfoManager.getInstance().setCatchErrorData(Log.getStackTraceString(e16));
            YtLogger.e(TAG, "Handle event failed:", e16);
        }
    }

    public void handlePauseEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Iterator<YtFSMBaseState> it = this.stateMap.values().iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    public void handleResumeEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Iterator<YtFSMBaseState> it = this.stateMap.values().iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    public int registerState(YtFSMBaseState ytFSMBaseState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) ytFSMBaseState)).intValue();
        }
        YtSDKStats.getInstance().registerStateName(ytFSMBaseState.getStateSimpleName());
        this.stateMap.put(ytFSMBaseState.getStateName(), ytFSMBaseState);
        return 0;
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        YtLogger.i(TAG, "FSM reset work mode " + this.currentWorkMode);
        try {
            this.eventQueue.add("reset");
        } catch (Exception e16) {
            OperateInfoManager.getInstance().setCatchErrorData(Log.getStackTraceString(e16));
            YtLogger.e(TAG, "handle reset failed:", e16);
        }
    }

    public void sendFSMEvent(HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) hashMap);
            return;
        }
        if (this.eventListener != null) {
            if (hashMap.containsKey(StateEvent.Name.PROCESS_RESULT)) {
                String makePackUseTime = OperateInfoManager.getInstance().makePackUseTime();
                String makeCatchErrorData = OperateInfoManager.getInstance().makeCatchErrorData();
                if (!TextUtils.isEmpty(makePackUseTime)) {
                    YtLogger.d("OPERATE", "FSM EVENT:" + makePackUseTime + "\n" + makeCatchErrorData);
                    hashMap.put(StateEvent.Name.OPERATE_CATCH_ERROR, makeCatchErrorData);
                    hashMap.put(StateEvent.Name.OPERATE_PACK_USE_TIME, makePackUseTime);
                }
                YtLogger.d(TAG, "send framework event result: " + hashMap.get(StateEvent.Name.PROCESS_RESULT) + " errorcode:" + hashMap.get("error_code"));
            }
            YtLogger.d(TAG, "eventDict=" + hashMap);
            this.eventListener.onFrameworkEvent(hashMap);
            return;
        }
        YtLogger.e(TAG, "Event listener not init", null);
    }

    public void sendNetworkRequest(String str, String str2, String str3, HashMap<String, String> hashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser iYtSDKKitNetResponseParser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, str2, str3, hashMap, iYtSDKKitNetResponseParser);
        } else if (this.eventListener != null) {
            sendFSMEvent(new HashMap<String, Object>(str) { // from class: com.tencent.youtu.sdkkitframework.framework.YtFSM.2
                static IPatchRedirector $redirector_;
                public final /* synthetic */ String val$netType;

                {
                    this.val$netType = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) YtFSM.this, (Object) str);
                        return;
                    }
                    String makePackUseTime = OperateInfoManager.getInstance().makePackUseTime();
                    String makeCatchErrorData = OperateInfoManager.getInstance().makeCatchErrorData();
                    if (!TextUtils.isEmpty(makePackUseTime)) {
                        YtLogger.d("OPERATE", "NETWORK EVENT:" + makePackUseTime + "\n" + makeCatchErrorData);
                        put(StateEvent.Name.OPERATE_CATCH_ERROR, makeCatchErrorData);
                        put(StateEvent.Name.OPERATE_PACK_USE_TIME, makePackUseTime);
                    }
                    put(StateEvent.Name.UI_TIPS, str);
                }
            });
            this.eventListener.onNetworkRequestEvent(str2, str3, hashMap, iYtSDKKitNetResponseParser);
        } else {
            YtLogger.e(TAG, "Event listener not init", null);
        }
    }

    public void setContext(YtSDKKitFramework.YtSDKPlatformContext ytSDKPlatformContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) ytSDKPlatformContext);
        } else {
            this.sdkPlatformContex = ytSDKPlatformContext;
        }
    }

    public void setEventListener(YtSDKKitFramework.IYtSDKKitFrameworkEventListener iYtSDKKitFrameworkEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) iYtSDKKitFrameworkEventListener);
        } else {
            this.eventListener = iYtSDKKitFrameworkEventListener;
        }
    }

    public void start(String str, YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode, int i3, long j3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, ytSDKKitFrameworkWorkMode, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        String str2 = TAG;
        YtLogger.i(str2, "FSM start use work mode " + ytSDKKitFrameworkWorkMode);
        try {
            this.startStopLock.lock();
            if (!this.isStarted) {
                this.firstStateName = str;
                this.currentWorkMode = ytSDKKitFrameworkWorkMode;
                this.isStarted = true;
                this.needEventHandler = true;
                this.checkUpdateTimerFlag = true;
                if (this.stateMap.containsKey(str)) {
                    YtLogger.d(str2, "start set current state:" + str);
                    YtFSMBaseState ytFSMBaseState = this.stateMap.get(this.firstStateName);
                    this.currentState = ytFSMBaseState;
                    ytFSMBaseState.enter();
                } else {
                    YtLogger.e(str2, "Start " + str + " failed which is not found", null);
                }
                this.updateQueue.clear();
                BaseThread baseThread = new BaseThread(new Runnable(i3, i16, i17, j3) { // from class: com.tencent.youtu.sdkkitframework.framework.YtFSM.1
                    static IPatchRedirector $redirector_;
                    public final /* synthetic */ int val$orientation;
                    public final /* synthetic */ int val$rearCameraTAG;
                    public final /* synthetic */ int val$threadPriority;
                    public final /* synthetic */ long val$updateTimeoutMs;

                    {
                        this.val$threadPriority = i3;
                        this.val$orientation = i16;
                        this.val$rearCameraTAG = i17;
                        this.val$updateTimeoutMs = j3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, YtFSM.this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        YtFSMUpdateData ytFSMUpdateData;
                        int i18;
                        int i19;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        Process.setThreadPriority(this.val$threadPriority);
                        while (YtFSM.this.needEventHandler) {
                            if (YtFSM.this.isStarted) {
                                while (true) {
                                    ytFSMUpdateData = null;
                                    if (!YtFSM.this.eventQueue.isEmpty()) {
                                        Object poll = YtFSM.this.eventQueue.poll();
                                        if (poll instanceof String) {
                                            if (((String) poll).equals("reset")) {
                                                Iterator it = YtFSM.this.stateMap.values().iterator();
                                                while (it.hasNext()) {
                                                    ((YtFSMBaseState) it.next()).reset();
                                                }
                                                if (YtFSM.this.stateMap.containsKey(YtFSM.this.firstStateName)) {
                                                    YtLogger.d(YtFSM.TAG, "reset set current state:" + YtFSM.this.firstStateName);
                                                    YtFSM ytFSM = YtFSM.this;
                                                    ytFSM.currentState = (YtFSMBaseState) ytFSM.stateMap.get(YtFSM.this.firstStateName);
                                                    YtFSM.this.currentState.enter();
                                                } else {
                                                    YtLogger.e(YtFSM.TAG, "reset failed: " + YtFSM.this.firstStateName + " state is not found", null);
                                                }
                                                YtFSM.this.updateQueue.clear();
                                                YtFSM.this.checkUpdateTimerFlag = true;
                                            }
                                        } else if (poll instanceof YtFSMFireEventData) {
                                            YtFSMFireEventData ytFSMFireEventData = (YtFSMFireEventData) poll;
                                            YtLogger.d(YtFSM.TAG, "handleevent " + ytFSMFireEventData.eventType + " for all states");
                                            Iterator it5 = YtFSM.this.stateMap.values().iterator();
                                            while (it5.hasNext()) {
                                                ((YtFSMBaseState) it5.next()).handleEvent(ytFSMFireEventData.eventType, ytFSMFireEventData.extraData);
                                            }
                                        }
                                    } else {
                                        try {
                                            break;
                                        } finally {
                                            YtFSM.this.stateLock.unlock();
                                        }
                                    }
                                }
                                YtFSM.this.stateLock.lock();
                                if (YtFSM.this.currentStrategy == YtFSMUpdateStrategy.CacheStrategy) {
                                    ytFSMUpdateData = (YtFSMUpdateData) YtFSM.this.updateQueue.poll();
                                } else if (YtFSM.this.currentStrategy == YtFSMUpdateStrategy.NoCacheStrategy) {
                                    YtLogger.i(YtFSM.TAG, "no cache str size:" + YtFSM.this.updateQueue.size());
                                    while (YtFSM.this.updateQueue.size() > 0) {
                                        ytFSMUpdateData = (YtFSMUpdateData) YtFSM.this.updateQueue.poll();
                                    }
                                } else {
                                    YtLogger.e(YtFSM.TAG, "unknown strategy " + YtFSM.this.currentStrategy, null);
                                }
                                if (ytFSMUpdateData != null) {
                                    if (this.val$orientation == 1) {
                                        ytFSMUpdateData.mirror();
                                    }
                                    int i26 = this.val$orientation;
                                    if (i26 == 0) {
                                        i18 = ytFSMUpdateData.imageWidth;
                                    } else {
                                        i18 = ytFSMUpdateData.imageHeight;
                                    }
                                    if (i26 == 0) {
                                        i19 = ytFSMUpdateData.imageHeight;
                                    } else {
                                        i19 = ytFSMUpdateData.imageWidth;
                                    }
                                    YtFSM.this.currentImageData = YtSDKKitFrameworkTool.yuvRotateAnd2bgrImge(ytFSMUpdateData.imageData, i18, i19, YtFSM.getInstance().getContext().currentRotateState, this.val$rearCameraTAG);
                                    YtFSM.this.currentImageData.timeStamp = ytFSMUpdateData.timeStamp;
                                    BytesPoolHelper.getInstance().release(ytFSMUpdateData.imageData);
                                    if (YtFSM.this.currentState != null) {
                                        YtFSM.this.currentState.update(YtFSM.this.currentImageData, YtFSM.this.currentImageData.timeStamp);
                                    }
                                }
                            }
                            try {
                                LockMethodProxy.sleep(2L);
                            } catch (InterruptedException e16) {
                                YtLogger.e(YtFSM.TAG, "sleep failed", e16);
                                OperateInfoManager.getInstance().setCatchErrorData(Log.getStackTraceString(e16));
                            }
                            if (YtFSM.this.currentState != null && YtFSM.this.currentState.getStateSimpleName().contains("ReqResult")) {
                                YtFSM.this.checkUpdateTimerFlag = false;
                            }
                            if (YtFSM.this.checkUpdateTimerFlag && YtFSM.this.feedTimeMs > 0 && this.val$updateTimeoutMs > 0 && System.currentTimeMillis() > YtFSM.this.feedTimeMs + this.val$updateTimeoutMs) {
                                YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.framework.YtFSM.1.1
                                    static IPatchRedirector $redirector_;

                                    {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                            return;
                                        }
                                        put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                                        put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                                        put(StateEvent.Name.PROCESS_RESULT, "failed");
                                        put("error_code", Integer.valueOf(ErrorCode.YT_SDK_VERIFY_TIMEOUT));
                                        put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_VERIFY_TIMEOUT, StringCode.MSG_TIMEOUT_ERROR, HttpHeaders.TIMEOUT));
                                    }
                                });
                                YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
                                return;
                            }
                        }
                    }
                });
                this.updateEventHandler = baseThread;
                baseThread.setName("YtEventUpdateThread");
                this.updateEventHandler.start();
            }
        } catch (Exception e16) {
            YtLogger.e(TAG, "FSM error", e16);
            OperateInfoManager.getInstance().setCatchErrorData(Log.getStackTraceString(e16));
        } finally {
            this.startStopLock.unlock();
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        YtLogger.i(TAG, "FSM stop work mode " + this.currentWorkMode);
        try {
            this.startStopLock.lock();
            this.needEventHandler = false;
            Thread thread = this.updateEventHandler;
            if (thread != null && thread.isAlive()) {
                this.updateEventHandler.join();
            }
            if (this.isStarted) {
                this.isStarted = false;
                Iterator<YtFSMBaseState> it = this.stateMap.values().iterator();
                while (it.hasNext()) {
                    it.next().unload();
                }
                this.stateMap.clear();
                this.updateQueue.clear();
            }
        } catch (InterruptedException e16) {
            YtLogger.e(TAG, "FSM strop error", e16);
            OperateInfoManager.getInstance().setCatchErrorData(Log.getStackTraceString(e16));
        } finally {
            this.startStopLock.unlock();
        }
    }

    public int transitNextRound(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str)).intValue();
        }
        if (this.stateMap.containsKey(str)) {
            this.currentState.exit();
            YtLogger.d(TAG, "transitnextround set current state:" + str);
            YtFSMBaseState ytFSMBaseState = this.stateMap.get(str);
            this.currentState = ytFSMBaseState;
            if (ytFSMBaseState == null) {
                return -1;
            }
            ytFSMBaseState.enter();
            return 0;
        }
        YtLogger.e(TAG, "transitnextround faild:" + str + " state is not found", null);
        return -1;
    }

    public int transitNow(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).intValue();
        }
        if (this.stateMap.containsKey(str)) {
            this.currentState.exit();
            YtLogger.d(TAG, "transitnow set current state:" + str);
            YtFSMBaseState ytFSMBaseState = this.stateMap.get(str);
            this.currentState = ytFSMBaseState;
            ytFSMBaseState.enter();
            YTImageData yTImageData = this.currentImageData;
            if (yTImageData != null) {
                this.currentState.update(yTImageData, yTImageData.timeStamp);
            }
            return 0;
        }
        YtLogger.e(TAG, "transitnow failed:" + str + " state is not found", null);
        return -1;
    }

    public void update(byte[] bArr, int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
            return;
        }
        if (this.isStarted) {
            byte[] acquire = BytesPoolHelper.getInstance().acquire();
            if (acquire == null) {
                acquire = (byte[]) bArr.clone();
            } else {
                BytesPoolHelper.getInstance().copy(acquire, bArr);
            }
            YtFSMUpdateData ytFSMUpdateData = new YtFSMUpdateData(this, null);
            ytFSMUpdateData.imageData = acquire;
            ytFSMUpdateData.imageWidth = i3;
            ytFSMUpdateData.imageHeight = i16;
            ytFSMUpdateData.timeStamp = j3;
            if (this.updateQueue.size() >= 10) {
                this.updateQueue.poll();
                YtLogger.d(TAG, "drop frame");
            }
            this.updateQueue.add(ytFSMUpdateData);
            YtLogger.d("FSM_QUEUE", "queue size:" + this.updateQueue.size());
            this.feedTimeMs = System.currentTimeMillis();
        }
    }

    public void updateCacheStrategy(YtFSMUpdateStrategy ytFSMUpdateStrategy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) ytFSMUpdateStrategy);
        } else {
            this.currentStrategy = ytFSMUpdateStrategy;
        }
    }

    public void updateSDKSetting(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) jSONObject);
            return;
        }
        Iterator<YtFSMBaseState> it = this.stateMap.values().iterator();
        while (it.hasNext()) {
            it.next().updateSDKSetting(jSONObject);
        }
    }
}
