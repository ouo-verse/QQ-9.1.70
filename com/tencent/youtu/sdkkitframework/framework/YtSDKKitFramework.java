package com.tencent.youtu.sdkkitframework.framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.youtu.sdkkitframework.common.BytesPoolHelper;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.OperateInfoManager;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.common.YtSdkConfig;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFrameworkTool;
import com.tencent.youtu.sdkkitframework.net.YtSDKKitNetHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YtSDKKitFramework {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "YtSDKKitFramework";
    private static YtSDKKitFramework instance;
    private long defaultUpdateTimeoutMS;
    private Rect detectRect;
    private IYtSDKKitFrameworkEventListener eventListener;
    private int networkRequestTimeoutMS;
    private Rect previewRect;
    private AtomicBoolean sdkKitFrameworkStarted;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface IYTBaseFunctionListener {
        String base64Encode(byte[] bArr, int i3);

        void detectActionDone(int i3);

        HashMap<String, Integer> getFrameResult(Object obj);

        byte[] getVoiceData();
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface IYTReflectListener {
        float onGetAppBrightness();

        void onReflectEvent(ColorMatrixColorFilter colorMatrixColorFilter, float f16);

        void onReflectStart(long j3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface IYtSDKKitFrameworkEventListener {
        void onFrameworkEvent(HashMap<String, Object> hashMap);

        void onNetworkRequestEvent(String str, String str2, HashMap<String, String> hashMap, IYtSDKKitNetResponseParser iYtSDKKitNetResponseParser);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface IYtSDKKitNetResponseParser {
        void onNetworkResponseEvent(HashMap<String, String> hashMap, Exception exc);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class YtFrameworkFireEventType {
        private static final /* synthetic */ YtFrameworkFireEventType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final YtFrameworkFireEventType YT_EVENT_TRIGGER_BEGIN_LIVENESS;
        public static final YtFrameworkFireEventType YT_EVENT_TRIGGER_CANCEL_LIVENESS;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19696);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            YtFrameworkFireEventType ytFrameworkFireEventType = new YtFrameworkFireEventType("YT_EVENT_TRIGGER_BEGIN_LIVENESS", 0);
            YT_EVENT_TRIGGER_BEGIN_LIVENESS = ytFrameworkFireEventType;
            YtFrameworkFireEventType ytFrameworkFireEventType2 = new YtFrameworkFireEventType("YT_EVENT_TRIGGER_CANCEL_LIVENESS", 1);
            YT_EVENT_TRIGGER_CANCEL_LIVENESS = ytFrameworkFireEventType2;
            $VALUES = new YtFrameworkFireEventType[]{ytFrameworkFireEventType, ytFrameworkFireEventType2};
        }

        YtFrameworkFireEventType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static YtFrameworkFireEventType valueOf(String str) {
            return (YtFrameworkFireEventType) Enum.valueOf(YtFrameworkFireEventType.class, str);
        }

        public static YtFrameworkFireEventType[] values() {
            return (YtFrameworkFireEventType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class YtSDKKitFrameworkWorkMode {
        private static final /* synthetic */ YtSDKKitFrameworkWorkMode[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final YtSDKKitFrameworkWorkMode YT_FW_ACTION_TYPE;
        public static final YtSDKKitFrameworkWorkMode YT_FW_ACTREFLECT_TYPE;
        public static final YtSDKKitFrameworkWorkMode YT_FW_DETECTONLY_TYPE;
        public static final YtSDKKitFrameworkWorkMode YT_FW_OCR_TYPE;
        public static final YtSDKKitFrameworkWorkMode YT_FW_OCR_VIID_TYPE;
        public static final YtSDKKitFrameworkWorkMode YT_FW_REFLECT_TYPE;
        public static final YtSDKKitFrameworkWorkMode YT_FW_SILENT_TYPE;
        public static final YtSDKKitFrameworkWorkMode YT_FW_UNKNOWN;
        private static HashMap<Integer, YtSDKKitFrameworkWorkMode> map;
        private int value;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15727);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode = new YtSDKKitFrameworkWorkMode("YT_FW_UNKNOWN", 0, 0);
            YT_FW_UNKNOWN = ytSDKKitFrameworkWorkMode;
            YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode2 = new YtSDKKitFrameworkWorkMode("YT_FW_OCR_TYPE", 1, 1);
            YT_FW_OCR_TYPE = ytSDKKitFrameworkWorkMode2;
            YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode3 = new YtSDKKitFrameworkWorkMode("YT_FW_SILENT_TYPE", 2, 2);
            YT_FW_SILENT_TYPE = ytSDKKitFrameworkWorkMode3;
            YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode4 = new YtSDKKitFrameworkWorkMode("YT_FW_ACTION_TYPE", 3, 3);
            YT_FW_ACTION_TYPE = ytSDKKitFrameworkWorkMode4;
            YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode5 = new YtSDKKitFrameworkWorkMode("YT_FW_REFLECT_TYPE", 4, 4);
            YT_FW_REFLECT_TYPE = ytSDKKitFrameworkWorkMode5;
            YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode6 = new YtSDKKitFrameworkWorkMode("YT_FW_ACTREFLECT_TYPE", 5, 5);
            YT_FW_ACTREFLECT_TYPE = ytSDKKitFrameworkWorkMode6;
            YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode7 = new YtSDKKitFrameworkWorkMode("YT_FW_DETECTONLY_TYPE", 6, 6);
            YT_FW_DETECTONLY_TYPE = ytSDKKitFrameworkWorkMode7;
            YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode8 = new YtSDKKitFrameworkWorkMode("YT_FW_OCR_VIID_TYPE", 7, 7);
            YT_FW_OCR_VIID_TYPE = ytSDKKitFrameworkWorkMode8;
            $VALUES = new YtSDKKitFrameworkWorkMode[]{ytSDKKitFrameworkWorkMode, ytSDKKitFrameworkWorkMode2, ytSDKKitFrameworkWorkMode3, ytSDKKitFrameworkWorkMode4, ytSDKKitFrameworkWorkMode5, ytSDKKitFrameworkWorkMode6, ytSDKKitFrameworkWorkMode7, ytSDKKitFrameworkWorkMode8};
            map = new HashMap<>();
            YtSDKKitFrameworkWorkMode[] values = values();
            for (int i3 = 0; i3 < 8; i3++) {
                YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode9 = values[i3];
                map.put(Integer.valueOf(ytSDKKitFrameworkWorkMode9.value), ytSDKKitFrameworkWorkMode9);
            }
        }

        YtSDKKitFrameworkWorkMode(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        public static YtSDKKitFrameworkWorkMode valueOf(String str) {
            return (YtSDKKitFrameworkWorkMode) Enum.valueOf(YtSDKKitFrameworkWorkMode.class, str);
        }

        public static YtSDKKitFrameworkWorkMode[] values() {
            return (YtSDKKitFrameworkWorkMode[]) $VALUES.clone();
        }

        public int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.value;
        }

        public static YtSDKKitFrameworkWorkMode valueOf(int i3) {
            if (map.get(Integer.valueOf(i3)) == null) {
                return YT_FW_UNKNOWN;
            }
            return map.get(Integer.valueOf(i3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class YtSDKPlatformContext {
        static IPatchRedirector $redirector_;
        public IYTBaseFunctionListener baseFunctionListener;
        public Context currentAppContext;
        public Camera currentCamera;
        public int currentCameraId;
        public int currentRotateState;
        public int imageToComapreType;
        public Bitmap imageToCompare;
        public RelativeLayout reflectLayout;
        public IYTReflectListener reflectListener;

        public YtSDKPlatformContext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.imageToComapreType = 0;
            }
        }
    }

    YtSDKKitFramework() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.previewRect = new Rect(0, 0, 480, 640);
        this.detectRect = new Rect(10, 110, 470, 530);
        this.networkRequestTimeoutMS = 60000;
        this.defaultUpdateTimeoutMS = 8000L;
        this.sdkKitFrameworkStarted = new AtomicBoolean(false);
    }

    public static synchronized void clearInstance() {
        synchronized (YtSDKKitFramework.class) {
            instance = null;
        }
    }

    public static synchronized YtSDKKitFramework getInstance() {
        YtSDKKitFramework ytSDKKitFramework;
        synchronized (YtSDKKitFramework.class) {
            if (instance == null) {
                instance = new YtSDKKitFramework();
            }
            ytSDKKitFramework = instance;
        }
        return ytSDKKitFramework;
    }

    private YtFSMBaseState parseStateFrom(String str, JSONObject jSONObject, YtSdkConfig ytSdkConfig) {
        YtFSMBaseState ytFSMBaseState;
        YtFSMBaseState ytFSMBaseState2 = null;
        try {
            ytFSMBaseState = (YtFSMBaseState) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            ytFSMBaseState.loadStateWith(str, jSONObject, ytSdkConfig);
            return ytFSMBaseState;
        } catch (Throwable th6) {
            th = th6;
            ytFSMBaseState2 = ytFSMBaseState;
            YtLogger.e(TAG, "Parse state " + str + "failed:", th);
            OperateInfoManager.getInstance().setCatchErrorData(Log.getStackTraceString(th));
            return ytFSMBaseState2;
        }
    }

    public int deInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (!this.sdkKitFrameworkStarted.get()) {
            YtLogger.e(TAG, "YouTu SDK Kit framework is not started!!!", null);
            return MessageRecord.MSG_TYPE_TROOP_REWARD;
        }
        this.sdkKitFrameworkStarted.set(false);
        YtLogger.o(TAG, "sdk framework  deInit");
        YtSDKKitNetHelper.clearInstance();
        YtFSM.getInstance().stop();
        YtFSM.clearInstance();
        BytesPoolHelper.getInstance().recycleAll();
        YtSDKStats.getInstance().exitState();
        YtSDKStats.clearInstance();
        OperateInfoManager.getInstance().clear();
        return 0;
    }

    public void doPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            YtLogger.o(TAG, "sdk framework  doPause");
            YtFSM.getInstance().handlePauseEvent();
        }
    }

    public void doResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            YtLogger.o(TAG, "sdk framework  doResume");
            YtFSM.getInstance().handleResumeEvent();
        }
    }

    public void fireEvent(YtFrameworkFireEventType ytFrameworkFireEventType, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) ytFrameworkFireEventType, obj);
        } else {
            YtFSM.getInstance().handleEvent(ytFrameworkFireEventType, obj);
        }
    }

    public Rect getDetectRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Rect) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.detectRect;
    }

    public int getNetworkRequestTimeoutMS() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.networkRequestTimeoutMS;
    }

    public YtSDKPlatformContext getPlatformContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (YtSDKPlatformContext) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return YtFSM.getInstance().getContext();
    }

    public Rect getPreviewRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Rect) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.previewRect;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01b7 A[LOOP:0: B:55:0x01b1->B:57:0x01b7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x018a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0173 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0143 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int init(YtSDKPlatformContext ytSDKPlatformContext, JSONObject jSONObject, YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode, ArrayList<String> arrayList, IYtSDKKitFrameworkEventListener iYtSDKKitFrameworkEventListener) {
        boolean z16;
        int i3;
        int i16;
        Iterator<String> it;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, ytSDKPlatformContext, jSONObject, ytSDKKitFrameworkWorkMode, arrayList, iYtSDKKitFrameworkEventListener)).intValue();
        }
        String str = TAG;
        YtLogger.o(str, "SDK init sdk config JSON:" + jSONObject.toString());
        if (this.sdkKitFrameworkStarted.get()) {
            YtLogger.e(str, "YouTu SDK Kit framework is started!!!", null);
            return MessageRecord.MSG_TYPE_TROOP_REWARD;
        }
        this.sdkKitFrameworkStarted.set(true);
        if (ytSDKPlatformContext == null) {
            YtLogger.e(str, "Context cannot be null", null);
            return -1;
        }
        if (arrayList.isEmpty()) {
            YtLogger.e(str, "Pipeline state name cannot be empty", null);
            return -1;
        }
        if (iYtSDKKitFrameworkEventListener == null) {
            YtLogger.e(str, "Event listener cannot be null", null);
            return -1;
        }
        YtSdkConfig ytSdkConfig = new YtSdkConfig();
        ytSdkConfig.updateSDKConfig(ytSDKKitFrameworkWorkMode, jSONObject);
        if (jSONObject.has("resource_online")) {
            try {
                if (jSONObject.getBoolean("resource_online")) {
                    YtLogger.o(str, "model validity md5 start");
                    if (jSONObject.has("resource_download_path")) {
                        YtSDKKitFrameworkTool.ModelValidityCode md5ValidityByDir = new YtSDKKitFrameworkTool().md5ValidityByDir(jSONObject.getString("resource_download_path"));
                        if (md5ValidityByDir != YtSDKKitFrameworkTool.ModelValidityCode.VALIDITY_OK) {
                            YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_VERIFY_MODEL_INIT_FAIL, "\u6a21\u578b\u521d\u59cb\u5316\u5931\u8d25");
                            iYtSDKKitFrameworkEventListener.onFrameworkEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) YtSDKKitFramework.this);
                                        return;
                                    }
                                    put(StateEvent.Name.PROCESS_RESULT, "failed");
                                    put("error_code", Integer.valueOf(ErrorCode.YT_SDK_FACETRACE_INIT_FAILED));
                                    put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_FACETRACE_INIT_FAILED, StringCode.MSG_PARAM_ERROR, "Init YTFaceTrack SDK failed with "));
                                }
                            });
                            YtLogger.e(str, "init module error:" + md5ValidityByDir.name(), null);
                            return -2;
                        }
                    } else {
                        YtLogger.e(str, "resource_download_path is null", null);
                        return -2;
                    }
                }
                YtLogger.o(str, "model validity md5 done");
            } catch (JSONException e16) {
                YtLogger.e(TAG, "parse json error:", e16);
                OperateInfoManager.getInstance().setCatchErrorData(Log.getStackTraceString(e16));
                return -2;
            }
        }
        if (jSONObject.has("resource_online")) {
            try {
                z16 = jSONObject.getBoolean("resource_online");
            } catch (JSONException e17) {
                YtLogger.e(TAG, "json getBoolean 'resource_online' error", e17);
                OperateInfoManager.getInstance().setCatchErrorData(Log.getStackTraceString(e17));
            }
            if (!z16) {
                FileUtils.loadLibrary("YTLiveness");
            }
            if (jSONObject.has("need_bugly_shared")) {
                try {
                    if (jSONObject.getBoolean("need_bugly_shared")) {
                        YtSDKKitFrameworkTool.openBuglyShared(ytSDKPlatformContext.currentAppContext);
                    }
                    YtLogger.o(TAG, "update bugly shared data");
                } catch (JSONException e18) {
                    YtLogger.e(TAG, "parse json error:", e18);
                    OperateInfoManager.getInstance().setCatchErrorData(Log.getStackTraceString(e18));
                    return -3;
                }
            }
            if (jSONObject.has("screen_orientation")) {
                try {
                    i3 = jSONObject.getInt("screen_orientation");
                } catch (JSONException e19) {
                    YtLogger.e(TAG, "parse json error:", e19);
                }
                if (jSONObject.has("rear_camera_tag")) {
                    try {
                        i16 = jSONObject.getInt("rear_camera_tag");
                    } catch (JSONException e26) {
                        YtLogger.e(TAG, "parse json error:", e26);
                    }
                    YtFSM.getInstance().stop();
                    YtFSM.getInstance().setEventListener(iYtSDKKitFrameworkEventListener);
                    YtFSM.getInstance().setContext(ytSDKPlatformContext);
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        YtFSM.getInstance().registerState(parseStateFrom(it.next(), jSONObject, ytSdkConfig));
                    }
                    if (jSONObject.has("thread_priority")) {
                        try {
                            i17 = jSONObject.getInt("thread_priority");
                        } catch (JSONException e27) {
                            YtLogger.e(TAG, "failed to get priority ", e27);
                            OperateInfoManager.getInstance().setCatchErrorData(Log.getStackTraceString(e27));
                        }
                        YtFSM.getInstance().start(arrayList.get(0), ytSDKKitFrameworkWorkMode, i17, jSONObject.optLong("frame_update_timeout_ms", this.defaultUpdateTimeoutMS), i3, i16);
                        return 0;
                    }
                    i17 = -20;
                    YtFSM.getInstance().start(arrayList.get(0), ytSDKKitFrameworkWorkMode, i17, jSONObject.optLong("frame_update_timeout_ms", this.defaultUpdateTimeoutMS), i3, i16);
                    return 0;
                }
                i16 = 0;
                YtFSM.getInstance().stop();
                YtFSM.getInstance().setEventListener(iYtSDKKitFrameworkEventListener);
                YtFSM.getInstance().setContext(ytSDKPlatformContext);
                it = arrayList.iterator();
                while (it.hasNext()) {
                }
                if (jSONObject.has("thread_priority")) {
                }
                i17 = -20;
                YtFSM.getInstance().start(arrayList.get(0), ytSDKKitFrameworkWorkMode, i17, jSONObject.optLong("frame_update_timeout_ms", this.defaultUpdateTimeoutMS), i3, i16);
                return 0;
            }
            i3 = 0;
            if (jSONObject.has("rear_camera_tag")) {
            }
            i16 = 0;
            YtFSM.getInstance().stop();
            YtFSM.getInstance().setEventListener(iYtSDKKitFrameworkEventListener);
            YtFSM.getInstance().setContext(ytSDKPlatformContext);
            it = arrayList.iterator();
            while (it.hasNext()) {
            }
            if (jSONObject.has("thread_priority")) {
            }
            i17 = -20;
            YtFSM.getInstance().start(arrayList.get(0), ytSDKKitFrameworkWorkMode, i17, jSONObject.optLong("frame_update_timeout_ms", this.defaultUpdateTimeoutMS), i3, i16);
            return 0;
        }
        z16 = false;
        if (!z16) {
        }
        if (jSONObject.has("need_bugly_shared")) {
        }
        if (jSONObject.has("screen_orientation")) {
        }
        i3 = 0;
        if (jSONObject.has("rear_camera_tag")) {
        }
        i16 = 0;
        YtFSM.getInstance().stop();
        YtFSM.getInstance().setEventListener(iYtSDKKitFrameworkEventListener);
        YtFSM.getInstance().setContext(ytSDKPlatformContext);
        it = arrayList.iterator();
        while (it.hasNext()) {
        }
        if (jSONObject.has("thread_priority")) {
        }
        i17 = -20;
        YtFSM.getInstance().start(arrayList.get(0), ytSDKKitFrameworkWorkMode, i17, jSONObject.optLong("frame_update_timeout_ms", this.defaultUpdateTimeoutMS), i3, i16);
        return 0;
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            YtLogger.o(TAG, "sdk framework  reset");
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) YtSDKKitFramework.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        YtSDKStats.getInstance().reset();
                        YtFSM.getInstance().reset();
                    }
                }
            });
        }
    }

    public void setDetectRect(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) rect);
            return;
        }
        YtLogger.o(TAG, "sdk framework detectRect\uff1a" + rect.toString());
        this.detectRect = rect;
    }

    public void setNetworkRequestTimeoutMS(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        this.networkRequestTimeoutMS = i3;
    }

    public void setPreviewRect(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) rect);
            return;
        }
        YtLogger.o(TAG, "sdk framework previewRect\uff1a" + rect.toString());
        this.previewRect = rect;
    }

    public void updateSDKSetting(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) jSONObject);
        } else {
            YtFSM.getInstance().updateSDKSetting(jSONObject);
        }
    }

    public int updateWithFrameData(byte[] bArr, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).intValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis <= 946684800000L) {
            return ErrorCode.YT_SDK_TIMETICK_ERROR;
        }
        YtFSM.getInstance().update(bArr, i3, i16, currentTimeMillis);
        return 0;
    }

    public String version() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            return YtSDKKitFrameworkTool.getFrameworkVersion();
        } catch (Exception e16) {
            YtLogger.e(TAG, "so not load", e16);
            OperateInfoManager.getInstance().setCatchErrorData(Log.getStackTraceString(e16));
            return "";
        }
    }
}
