package com.tencent.could.huiyansdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.could.component.common.ai.callback.CrashListener;
import com.tencent.could.component.common.ai.log.AiLog;
import com.tencent.could.component.common.ai.utils.CloudCrashHandler;
import com.tencent.could.huiyansdk.activitys.MainAuthActivity;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.base.HuiYanBaseCallBack;
import com.tencent.could.huiyansdk.callback.e;
import com.tencent.could.huiyansdk.common.a;
import com.tencent.could.huiyansdk.entity.AuthUiConfig;
import com.tencent.could.huiyansdk.entity.CameraRiskParamConfig;
import com.tencent.could.huiyansdk.entity.CompareResult;
import com.tencent.could.huiyansdk.entity.HuiYanBaseConfig;
import com.tencent.could.huiyansdk.entity.HuiYanSdkConfig;
import com.tencent.could.huiyansdk.entity.LanguageStyle;
import com.tencent.could.huiyansdk.entity.LiveDataCheckResult;
import com.tencent.could.huiyansdk.entity.TuringResultCacheEntity;
import com.tencent.could.huiyansdk.entity.UpdateYtConfig;
import com.tencent.could.huiyansdk.enums.AuthState;
import com.tencent.could.huiyansdk.enums.HuiYanAuthEvent;
import com.tencent.could.huiyansdk.enums.HuiYanAuthTipsEvent;
import com.tencent.could.huiyansdk.enums.HuiYanEncryptMode;
import com.tencent.could.huiyansdk.enums.HuiYanLiveMode;
import com.tencent.could.huiyansdk.enums.PageColorStyle;
import com.tencent.could.huiyansdk.enums.VideoSize;
import com.tencent.could.huiyansdk.exception.AuthException;
import com.tencent.could.huiyansdk.fragments.AuthingFragment;
import com.tencent.could.huiyansdk.fragments.BaseFragment;
import com.tencent.could.huiyansdk.helper.b;
import com.tencent.could.huiyansdk.manager.b;
import com.tencent.could.huiyansdk.manager.c;
import com.tencent.could.huiyansdk.manager.f;
import com.tencent.could.huiyansdk.manager.i;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.turing.f;
import com.tencent.could.huiyansdk.utils.CommonUtils;
import com.tencent.could.huiyansdk.utils.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HuiYanSdkImp {
    static IPatchRedirector $redirector_ = null;
    private static final String ERROR_INFO = "please call init() function first!";
    private static final String PAGE_NAME_FILTER = "com.tencent.could";
    private static final String TAG = "HuiYanSdkImp";
    private AuthUiConfig authUiConfig;
    private CameraRiskParamConfig cameraRiskParamConfig;
    private WeakReference<Context> contextResReference;
    private HuiYanAuthTipsEvent currentExtraTipsEvent;
    private HuiYanSdkEventCallBack eventCallBack;
    private HuiYanExtraCallBack extraCallBack;
    private HuiYanInputDataCallBack inputDataCallBack;
    private volatile boolean isCurrentFinish;
    private boolean isExitDoNeedShow;
    private HuiYanSdkCallBack sdkCallBack;
    private HuiYanSdkConfig sdkConfig;

    /* compiled from: P */
    /* renamed from: com.tencent.could.huiyansdk.api.HuiYanSdkImp$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$tencent$could$huiyansdk$enums$HuiYanEncryptMode;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18426);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            HuiYanEncryptMode.values();
            int[] iArr = new int[2];
            $SwitchMap$com$tencent$could$huiyansdk$enums$HuiYanEncryptMode = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class HuiYanSdkImpHolder {
        static IPatchRedirector $redirector_;
        private static final HuiYanSdkImp INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11519);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new HuiYanSdkImp(null);
            }
        }

        HuiYanSdkImpHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public /* synthetic */ HuiYanSdkImp(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCallBackWithEvent(int i3, boolean z16, boolean z17) {
        onAuthEvent(getAuthEventByActionType(i3, z16), z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWithCompareResultData(String str) {
        c.b.f100154a.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWithConfigDataSuccess(String str) {
        if (this.isCurrentFinish) {
            k.a.f100197a.a(2, TAG, "ConfigDataSuccess but isCurrentFinish is ture!");
            return;
        }
        HuiYanSdkCallBack huiYanSdkCallBack = this.sdkCallBack;
        if (huiYanSdkCallBack != null) {
            huiYanSdkCallBack.onSelectSuccess(str);
        }
    }

    private long getActionVideoFrame() {
        return 20L;
    }

    private HuiYanAuthEvent getAuthEventByActionType(int i3, boolean z16) {
        switch (i3) {
            case 1:
                if (z16) {
                    return HuiYanAuthEvent.BLINK_CHECK_DONE;
                }
                return HuiYanAuthEvent.BLINK_CHECK;
            case 2:
                if (z16) {
                    return HuiYanAuthEvent.OPEN_MOUTH_CHECK_DONE;
                }
                return HuiYanAuthEvent.OPEN_MOUTH_CHECK;
            case 3:
                if (z16) {
                    return HuiYanAuthEvent.NOD_HEAD_CHECK_DONE;
                }
                return HuiYanAuthEvent.NOD_HEAD_CHECK;
            case 4:
                if (z16) {
                    return HuiYanAuthEvent.SHAKE_HEAD_CHECK_DONE;
                }
                return HuiYanAuthEvent.SHAKE_HEAD_CHECK;
            case 5:
                if (z16) {
                    return HuiYanAuthEvent.SILENCE_CHECK_DONE;
                }
                return HuiYanAuthEvent.SILENCE_CHECK;
            case 6:
                return HuiYanAuthEvent.ALL_ACTION_DONE;
            default:
                return HuiYanAuthEvent.NONE;
        }
    }

    public static HuiYanSdkImp getInstance() {
        return HuiYanSdkImpHolder.INSTANCE;
    }

    private int getModeMethodIdByMode(HuiYanEncryptMode huiYanEncryptMode) {
        if (huiYanEncryptMode.ordinal() == 1) {
            return 1;
        }
        return 0;
    }

    private void initOthers(Context context) {
        f fVar = f.a.f100288a;
        try {
            fVar.f100277f = new TuringResultCacheEntity();
            fVar.c();
            fVar.f100273b = false;
            fVar.f100287p = false;
            fVar.f100278g.a(context);
            k.a.f100197a.a(1, "TuringSdkHelper", "call turing interface init finish");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e16) {
            k.a.f100197a.a(2, "TuringSdkHelper", "create and init turing help error " + e16.getLocalizedMessage());
            fVar.f100278g = null;
            fVar.f100282k = false;
        }
        CloudCrashHandler.instance().init(context, "huiyan", true, PAGE_NAME_FILTER, false);
        CloudCrashHandler.instance().addCrashListener(new CrashListener() { // from class: com.tencent.could.huiyansdk.api.HuiYanSdkImp.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HuiYanSdkImp.this);
                }
            }

            @Override // com.tencent.could.component.common.ai.callback.CrashListener
            public void onCrash(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                } else {
                    HuiYanSdkImp.this.sendBuriedPointInfo("CrashStage", "UncatchCrash", str);
                    HuiYanSdkImp.this.sendOperateInfo("Crash", 1, 1L, str);
                }
            }
        });
    }

    private void startActivityFunction() {
        boolean z16;
        Intent intent;
        Context startActivityContext;
        Context a16 = HuiYanBaseApi.b.f100031a.a();
        if (a16 == null) {
            doOnFail(216, ERROR_INFO);
            return;
        }
        HuiYanSdkConfig huiYanSdkConfig = this.sdkConfig;
        if (huiYanSdkConfig != null && (startActivityContext = huiYanSdkConfig.getStartActivityContext()) != null && (startActivityContext instanceof Activity)) {
            z16 = false;
            a16 = startActivityContext;
        } else {
            z16 = true;
        }
        if (this.sdkConfig.isLandMode()) {
            intent = new Intent(a16, (Class<?>) MainAuthActivity.class);
        } else {
            intent = new Intent(a16, (Class<?>) MainAuthActivity.class);
        }
        k.a.f100197a.a(1, TAG, "useAppContext: " + z16);
        if (z16) {
            intent.addFlags(268435456);
        }
        a16.startActivity(intent);
        sendBuriedPointInfo("InitSDKStage", "HuiYanInitSuccess", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateYouTuConfig(HuiYanSdkConfig huiYanSdkConfig) {
        int[] changeActions;
        try {
            k kVar = k.a.f100197a;
            kVar.a(1, TAG, "update you tu config!");
            com.tencent.could.huiyansdk.helper.b bVar = b.a.f100123a;
            bVar.f100122c = huiYanSdkConfig.isOpenFullLog();
            bVar.a("timeout_countdown_ms", huiYanSdkConfig.getAuthTimeOutMs());
            bVar.a("action_frame_num", getActionVideoFrame());
            bVar.a("secondary_roll_threshold", huiYanSdkConfig.getBestImageRoll());
            bVar.a("secondary_yaw_threshold", huiYanSdkConfig.getBestImageYaw());
            bVar.a("secondary_pitch_threshold", huiYanSdkConfig.getBestImagePitch());
            bVar.a("continuous_angle_num_threshold", this.sdkConfig.getBestImageContinuousFrameNum());
            bVar.a("need_angle_detect_reflection", huiYanSdkConfig.isOpenAngleDetect());
            if (huiYanSdkConfig.isOpenAngleDetect()) {
                bVar.b("correction_angle_action_type", "1,5");
            } else if (bVar.f100120a != null) {
                String a16 = bVar.a();
                if (bVar.f100120a.has(a16)) {
                    JSONObject jSONObject = bVar.f100120a.getJSONObject(a16);
                    jSONObject.remove("correction_angle_action_type");
                    bVar.f100120a.put(a16, jSONObject);
                }
            }
            if (huiYanSdkConfig.isLandMode()) {
                bVar.a("screen_orientation", 1L);
                bVar.a("smallface_ratio_threshold", huiYanSdkConfig.getLandCloseRatio());
            } else {
                bVar.a("screen_orientation", 0L);
                bVar.a("smallface_ratio_threshold", huiYanSdkConfig.getPortraitCloseRatio());
            }
            if (huiYanSdkConfig.isUseBestFaceImage()) {
                bVar.a("need_face_quality", true);
                bVar.a("need_local_face_best_image", false);
            }
            if (huiYanSdkConfig.isUseBackCamera()) {
                bVar.a("rear_camera_tag", 1L);
            }
            String useCustomerModelPath = huiYanSdkConfig.getUseCustomerModelPath();
            if (TextUtils.isEmpty(useCustomerModelPath)) {
                kVar.a(1, "YouTuSdkHelper", "no need load model!");
            } else {
                bVar.a("resource_online", true);
                if (!useCustomerModelPath.endsWith("/")) {
                    useCustomerModelPath = useCustomerModelPath + "/";
                }
                bVar.b("resource_download_path", useCustomerModelPath);
            }
            HuiYanLiveMode huiYanLiveMode = huiYanSdkConfig.getHuiYanLiveMode();
            if (huiYanLiveMode == HuiYanLiveMode.ACTION_REFLECT_MODE) {
                bVar.a("need_encrypt", true ^ huiYanSdkConfig.isCloseEncrypt());
                if (!huiYanSdkConfig.isCloseEncrypt()) {
                    bVar.a("enhance_encrypt_method", getModeMethodIdByMode(huiYanSdkConfig.getEncryptMode()));
                }
            }
            if (huiYanLiveMode == HuiYanLiveMode.ACTION_MODE && (changeActions = CommonUtils.changeActions(huiYanSdkConfig.getActions())) != null) {
                bVar.a("action_default_seq", changeActions);
            }
        } catch (JSONException unused) {
            k.a.f100197a.a(2, TAG, "update you tu config error!");
        }
    }

    public void closeCurrentUi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this);
        } else {
            CommonUtils.closeCurrentFragment();
        }
    }

    public void doAuthTipsEvent(HuiYanAuthTipsEvent huiYanAuthTipsEvent, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, huiYanAuthTipsEvent, Boolean.valueOf(z16));
            return;
        }
        if (huiYanAuthTipsEvent != null && huiYanAuthTipsEvent != HuiYanAuthTipsEvent.NONE) {
            if (z16) {
                if (this.currentExtraTipsEvent == huiYanAuthTipsEvent) {
                    return;
                } else {
                    this.currentExtraTipsEvent = huiYanAuthTipsEvent;
                }
            }
            HuiYanSdkEventCallBack huiYanSdkEventCallBack = this.eventCallBack;
            if (huiYanSdkEventCallBack != null) {
                huiYanSdkEventCallBack.onAuthTipsEvent(huiYanAuthTipsEvent);
            }
        }
    }

    public void doOnFail(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) str);
            return;
        }
        this.isCurrentFinish = true;
        k kVar = k.a.f100197a;
        kVar.a(2, TAG, "huiyan failed, code: " + i3 + " msg:" + str);
        if (this.sdkCallBack != null) {
            kVar.a();
            Context context = CommonUtils.getContext();
            if (context != null && !TextUtils.isEmpty(str) && str.contains(String.valueOf(400103))) {
                this.sdkCallBack.onFail(229, context.getString(R.string.txy_yt_face_ref_angle_detect_error));
            } else {
                this.sdkCallBack.onFail(i3, str);
            }
        }
        f.a.f100180a.b();
        releaseCallBack();
    }

    public void doOnPrepare(HuiYanOperationConfigCallBack huiYanOperationConfigCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) huiYanOperationConfigCallBack);
            return;
        }
        HuiYanExtraCallBack huiYanExtraCallBack = this.extraCallBack;
        if (huiYanExtraCallBack != null) {
            huiYanExtraCallBack.onPrepare(huiYanOperationConfigCallBack);
        }
    }

    public void doOnStreamRiskDataSuccess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        HuiYanExtraCallBack huiYanExtraCallBack = this.extraCallBack;
        if (huiYanExtraCallBack != null) {
            huiYanExtraCallBack.onStreamRiskDataSuccess(str);
        }
    }

    public void doOnTuringFaceDataSuccess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        HuiYanExtraCallBack huiYanExtraCallBack = this.extraCallBack;
        if (huiYanExtraCallBack != null) {
            huiYanExtraCallBack.onTuringFaceDataSuccess(str);
        }
    }

    public AuthUiConfig getAuthUiConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (AuthUiConfig) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.authUiConfig;
    }

    public CameraRiskParamConfig getCameraRiskParamConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (CameraRiskParamConfig) iPatchRedirector.redirect((short) 59, (Object) this);
        }
        return this.cameraRiskParamConfig;
    }

    public long getCutVideoDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Long) iPatchRedirector.redirect((short) 53, (Object) this)).longValue();
        }
        HuiYanSdkConfig huiYanSdkConfig = this.sdkConfig;
        if (huiYanSdkConfig == null) {
            return 2000L;
        }
        return huiYanSdkConfig.getCutVideoDuration();
    }

    public HuiYanSdkEventCallBack getEventCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (HuiYanSdkEventCallBack) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.eventCallBack;
    }

    public HuiYanExtraCallBack getExtraCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (HuiYanExtraCallBack) iPatchRedirector.redirect((short) 57, (Object) this);
        }
        return this.extraCallBack;
    }

    public HuiYanInputDataCallBack getInputDataCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (HuiYanInputDataCallBack) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return this.inputDataCallBack;
    }

    public String getLanguageCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        HuiYanSdkConfig huiYanSdkConfig = this.sdkConfig;
        if (huiYanSdkConfig == null) {
            return "";
        }
        return huiYanSdkConfig.getLanguageCode();
    }

    public LanguageStyle getLanguageStyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (LanguageStyle) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        HuiYanSdkConfig huiYanSdkConfig = this.sdkConfig;
        if (huiYanSdkConfig == null) {
            return LanguageStyle.AUTO;
        }
        return huiYanSdkConfig.getLanguageStyle();
    }

    public PageColorStyle getPageColorStyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (PageColorStyle) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        HuiYanSdkConfig huiYanSdkConfig = this.sdkConfig;
        if (huiYanSdkConfig == null) {
            return PageColorStyle.Light;
        }
        return huiYanSdkConfig.getPageColorStyle();
    }

    public Context getResContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Context) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        WeakReference<Context> weakReference = this.contextResReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public HuiYanSdkConfig getSdkConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (HuiYanSdkConfig) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        if (this.sdkConfig == null) {
            this.sdkConfig = new HuiYanSdkConfig();
        }
        return this.sdkConfig;
    }

    public String getTruingSdkVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (String) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        return f.a.f100288a.a();
    }

    public void init(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        HuiYanBaseApi huiYanBaseApi = HuiYanBaseApi.b.f100031a;
        huiYanBaseApi.getClass();
        if (context != null) {
            huiYanBaseApi.a(context);
            System.loadLibrary("YTLiveness");
        }
        initOthers(context);
    }

    public void initNoLoadLibs(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        HuiYanBaseApi huiYanBaseApi = HuiYanBaseApi.b.f100031a;
        huiYanBaseApi.getClass();
        if (context != null) {
            huiYanBaseApi.a(context);
        }
        initOthers(context);
    }

    public void initiativeUpdateSdkConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.could.huiyansdk.helper.b bVar = b.a.f100123a;
        if (bVar.f100120a == null) {
            k.a.f100197a.a(2, "YouTuSdkHelper", "sdk config json is null!");
        } else {
            YtSDKKitFramework.getInstance().updateSDKSetting(YtSDKKitConfigHelper.getSDKConfig(bVar.b(), bVar.f100120a));
        }
    }

    public boolean isCurrentFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this)).booleanValue();
        }
        return this.isCurrentFinish;
    }

    public boolean isExitDoNeedShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        return this.isExitDoNeedShow;
    }

    public boolean isLandMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Boolean) iPatchRedirector.redirect((short) 54, (Object) this)).booleanValue();
        }
        HuiYanSdkConfig huiYanSdkConfig = this.sdkConfig;
        if (huiYanSdkConfig == null) {
            return false;
        }
        return huiYanSdkConfig.isLandMode();
    }

    public boolean isNeedCutRecordVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this)).booleanValue();
        }
        HuiYanSdkConfig huiYanSdkConfig = this.sdkConfig;
        if (huiYanSdkConfig == null) {
            return true;
        }
        return huiYanSdkConfig.isCutRecordVideo();
    }

    public boolean isOpenCameraRiskParamCheck() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Boolean) iPatchRedirector.redirect((short) 60, (Object) this)).booleanValue();
        }
        CameraRiskParamConfig cameraRiskParamConfig = this.cameraRiskParamConfig;
        if (cameraRiskParamConfig == null || cameraRiskParamConfig.getStage() == 0) {
            return false;
        }
        return true;
    }

    public boolean isUsing720p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        AuthUiConfig authUiConfig = this.authUiConfig;
        if (authUiConfig != null && authUiConfig.getVideoSize() == VideoSize.SIZE_720P) {
            return true;
        }
        return false;
    }

    public boolean isWaitingUserCompare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        HuiYanSdkConfig huiYanSdkConfig = this.sdkConfig;
        if (huiYanSdkConfig == null) {
            return false;
        }
        return huiYanSdkConfig.isWaitingUserCompare();
    }

    public void onAuthEvent(HuiYanAuthEvent huiYanAuthEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            onAuthEvent(huiYanAuthEvent, true);
        } else {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) huiYanAuthEvent);
        }
    }

    public void onCompareSuccess(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.isCurrentFinish = true;
        k kVar = k.a.f100197a;
        kVar.a();
        HuiYanSdkCallBack huiYanSdkCallBack = this.sdkCallBack;
        if (huiYanSdkCallBack != null) {
            huiYanSdkCallBack.onCompareSuccess(str, str2);
        } else {
            kVar.a(2, TAG, "HuiYan onCompareSuccess code! ");
        }
    }

    public void onMainViewCreate(View view) {
        HuiYanSdkEventCallBack huiYanSdkEventCallBack;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) view);
        } else if (view != null && (huiYanSdkEventCallBack = this.eventCallBack) != null) {
            huiYanSdkEventCallBack.onMainViewCreate(view);
        }
    }

    public void onMainViewDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        HuiYanSdkEventCallBack huiYanSdkEventCallBack = this.eventCallBack;
        if (huiYanSdkEventCallBack != null) {
            huiYanSdkEventCallBack.onMainViewDestroy();
        }
    }

    public void realStartCheck() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        getInstance().onAuthEvent(HuiYanAuthEvent.START_AUTH);
        c cVar = c.b.f100154a;
        cVar.getClass();
        cVar.a(AuthState.START_CAMERA_PREVIEW, (Object) null);
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        HuiYanBaseApi huiYanBaseApi = HuiYanBaseApi.b.f100031a;
        if (huiYanBaseApi.f100028b != null) {
            huiYanBaseApi.f100028b = null;
        }
        l.a.f100309a.f100308b = false;
        AiLog.release();
        k kVar = k.a.f100197a;
        kVar.b();
        com.tencent.could.huiyansdk.turing.f fVar = f.a.f100288a;
        kVar.a(1, "TuringSdkHelper", "call release.");
        fVar.f100282k = false;
        if (fVar.f100278g != null) {
            fVar.f100278g.d();
            fVar.f100278g = null;
        }
        if (this.sdkCallBack != null) {
            this.sdkCallBack = null;
        }
        if (this.eventCallBack != null) {
            this.eventCallBack = null;
        }
        this.isCurrentFinish = false;
    }

    public void releaseCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.sdkCallBack != null) {
            this.sdkCallBack = null;
        }
        if (this.extraCallBack != null) {
            this.extraCallBack = null;
        }
        this.isCurrentFinish = true;
    }

    public void sendBuriedPointInfo(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, str, str2, str3);
            return;
        }
        HuiYanExtraCallBack huiYanExtraCallBack = this.extraCallBack;
        if (huiYanExtraCallBack != null) {
            huiYanExtraCallBack.onBuriedPointCallBack(str, str2, str3);
        }
    }

    public void sendOperateInfo(String str, int i3, long j3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2);
            return;
        }
        HuiYanExtraCallBack huiYanExtraCallBack = this.extraCallBack;
        if (huiYanExtraCallBack != null) {
            huiYanExtraCallBack.updateOperateInfo(str, i3, j3, str2);
        }
    }

    public void sendOperateTimeInfo(String str, int i3, boolean z16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), str2);
            return;
        }
        HuiYanExtraCallBack huiYanExtraCallBack = this.extraCallBack;
        if (huiYanExtraCallBack != null) {
            huiYanExtraCallBack.onOperateTimeEvent(str, i3, z16, str2);
        }
    }

    public void sendOperateTimeInfoEnd(String str, boolean z16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, str, Boolean.valueOf(z16), str2);
            return;
        }
        HuiYanExtraCallBack huiYanExtraCallBack = this.extraCallBack;
        if (huiYanExtraCallBack != null) {
            huiYanExtraCallBack.onOperateTimeEvent(str, 2, z16, str2);
        }
    }

    public void sendOperateTimeInfoStart(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) str);
            return;
        }
        HuiYanExtraCallBack huiYanExtraCallBack = this.extraCallBack;
        if (huiYanExtraCallBack != null) {
            huiYanExtraCallBack.onOperateTimeEvent(str, 1, false, "");
        }
    }

    public void setActivityExitFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
        } else {
            this.isExitDoNeedShow = true;
        }
    }

    public void setAuthUiConfig(AuthUiConfig authUiConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) authUiConfig);
        } else {
            this.authUiConfig = authUiConfig;
        }
    }

    public void setCameraRiskParamConfig(CameraRiskParamConfig cameraRiskParamConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) cameraRiskParamConfig);
        } else {
            this.cameraRiskParamConfig = cameraRiskParamConfig;
        }
    }

    public void setContextResReference(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) context);
        } else {
            this.contextResReference = new WeakReference<>(context);
        }
    }

    public void setCurrentFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        } else {
            this.isCurrentFinish = true;
        }
    }

    public void setExtraCallBack(HuiYanExtraCallBack huiYanExtraCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) huiYanExtraCallBack);
        } else {
            this.extraCallBack = huiYanExtraCallBack;
        }
    }

    public void setHuiYanSdkEventCallback(HuiYanSdkEventCallBack huiYanSdkEventCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) huiYanSdkEventCallBack);
        } else {
            this.eventCallBack = huiYanSdkEventCallBack;
        }
    }

    public void setInputDataCallBack(HuiYanInputDataCallBack huiYanInputDataCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) huiYanInputDataCallBack);
        } else {
            this.inputDataCallBack = huiYanInputDataCallBack;
        }
    }

    public void setLoggerCallback(String str, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) str, (Object) eVar);
            return;
        }
        k kVar = k.a.f100197a;
        synchronized (kVar.f100190b) {
            kVar.f100191c = str;
            kVar.f100192d = eVar;
            a.C1019a.f100038a.f100037f = true;
            if (kVar.f100193e == null) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("logger-thread");
                kVar.f100193e = baseHandlerThread;
                baseHandlerThread.start();
                kVar.f100194f = new i(kVar, kVar.f100193e.getLooper());
            }
        }
    }

    public void setTuringVideoParams(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str, (Object) str2);
            return;
        }
        getSdkConfig();
        boolean z16 = !TextUtils.isEmpty(str);
        com.tencent.could.huiyansdk.turing.f fVar = f.a.f100288a;
        TuringResultCacheEntity turingResultCacheEntity = fVar.f100277f;
        if (turingResultCacheEntity != null) {
            turingResultCacheEntity.setNeedFrameCheck(z16);
        }
        fVar.a(str);
        TuringResultCacheEntity turingResultCacheEntity2 = fVar.f100277f;
        if (turingResultCacheEntity2 != null) {
            turingResultCacheEntity2.setExtraInfo(str2);
        }
    }

    public void showErrorDialog(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3, (Object) str);
            return;
        }
        c cVar = c.b.f100154a;
        cVar.getClass();
        CompareResult compareResult = new CompareResult();
        compareResult.setErrorCode(i3);
        compareResult.setErrorMsg(str);
        cVar.a(AuthState.AUTH_ERROR_DIALOG, compareResult);
    }

    public void startHuiYanCheck(HuiYanSdkConfig huiYanSdkConfig, HuiYanSdkCallBack huiYanSdkCallBack) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) huiYanSdkConfig, (Object) huiYanSdkCallBack);
            return;
        }
        this.sdkConfig = huiYanSdkConfig;
        this.isExitDoNeedShow = false;
        this.currentExtraTipsEvent = HuiYanAuthTipsEvent.NONE;
        this.sdkCallBack = huiYanSdkCallBack;
        this.isCurrentFinish = false;
        HuiYanBaseApi huiYanBaseApi = HuiYanBaseApi.b.f100031a;
        huiYanBaseApi.f100028b = new HuiYanBaseCallBack() { // from class: com.tencent.could.huiyansdk.api.HuiYanSdkImp.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HuiYanSdkImp.this);
                }
            }

            @Override // com.tencent.could.huiyansdk.base.HuiYanBaseCallBack
            public void getCompareResultData(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) str);
                } else {
                    k.a.f100197a.a(2, HuiYanSdkImp.TAG, "get compare result data.");
                    HuiYanSdkImp.this.doWithCompareResultData(str);
                }
            }

            @Override // com.tencent.could.huiyansdk.base.HuiYanBaseCallBack
            public void getConfigDataSuccess(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 5)) {
                    HuiYanSdkImp.this.doWithConfigDataSuccess(str);
                } else {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) str);
                }
            }

            @Override // com.tencent.could.huiyansdk.base.HuiYanBaseCallBack
            public void isHaveReflectionMode(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 11)) {
                    iPatchRedirector2.redirect((short) 11, (Object) this, z16);
                } else {
                    c.b.f100154a.f100149r = z16;
                }
            }

            @Override // com.tencent.could.huiyansdk.base.HuiYanBaseCallBack
            public void onActionEventChange(int i16, boolean z16, boolean z17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    HuiYanSdkImp.this.doCallBackWithEvent(i16, z16, z17);
                    if (!z16) {
                        c cVar = c.b.f100154a;
                        if (cVar.f100134c) {
                            cVar.a(AuthState.ON_ENTRY_OTHER_ACTION, (Object) null);
                        }
                    }
                    if (i16 == 6) {
                        c cVar2 = c.b.f100154a;
                        if (cVar2.f100149r) {
                            k.a.f100197a.a(1, "AuthStateManager", "isOpenReflectionMode is true");
                            YtSDKKitFramework.getInstance().doPause();
                            cVar2.a(AuthState.ALL_ACTION_DONE, (Object) null);
                            return;
                        }
                        k.a.f100197a.a(1, "AuthStateManager", "isOpenReflectionMode is false not need call ALL_ACTION_DONE");
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17));
            }

            @Override // com.tencent.could.huiyansdk.base.HuiYanBaseCallBack
            public void onFail(int i16, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this, i16, (Object) str);
                    return;
                }
                HuiYanSdkImp.this.closeCurrentUi();
                HuiYanSdkImp.this.doOnFail(i16, str);
                HuiYanSdkImp.this.sendBuriedPointInfo("InitSDKStage", "HuiYanInitError", "code: " + i16 + " msg: " + str);
            }

            @Override // com.tencent.could.huiyansdk.base.HuiYanBaseCallBack
            public void onGetBotBestFaceImage() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 10)) {
                    iPatchRedirector2.redirect((short) 10, (Object) this);
                } else {
                    c.b.f100154a.a(AuthState.ON_EXIT_BOT, (Object) null);
                }
            }

            @Override // com.tencent.could.huiyansdk.base.HuiYanBaseCallBack
            public void onLiveDataCallBackInfo(String str, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 12)) {
                    iPatchRedirector2.redirect((short) 12, (Object) this, (Object) str, (Object) str2);
                    return;
                }
                HuiYanExtraCallBack extraCallBack = HuiYanSdkImp.getInstance().getExtraCallBack();
                if (extraCallBack != null) {
                    extraCallBack.onLiveDataCallBackInfo(str, str2);
                }
            }

            @Override // com.tencent.could.huiyansdk.base.HuiYanBaseCallBack
            public void onOperateTimeEvent(String str, int i16, boolean z16, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 8)) {
                    iPatchRedirector2.redirect((short) 8, this, str, Integer.valueOf(i16), Boolean.valueOf(z16), str2);
                } else {
                    HuiYanSdkImp.this.sendOperateTimeInfo(str, i16, z16, str2);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:50:0x016a  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x018f  */
            /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
            @Override // com.tencent.could.huiyansdk.base.HuiYanBaseCallBack
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onTipEvent(HashMap<String, Object> hashMap) {
                int i16;
                int i17;
                HuiYanAuthTipsEvent huiYanAuthTipsEvent;
                HuiYanAuthTipsEvent huiYanAuthTipsEvent2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) hashMap);
                    return;
                }
                c cVar = c.b.f100154a;
                cVar.getClass();
                Context resContext = HuiYanSdkImp.getInstance().getResContext();
                if (resContext == null) {
                    k.a.f100197a.a(2, "AuthStateManager", "context is null");
                    return;
                }
                if (hashMap.containsKey(StateEvent.Name.UI_EXTRA_TIPS)) {
                    String str = (String) hashMap.get(StateEvent.Name.UI_EXTRA_TIPS);
                    if (TextUtils.isEmpty(str)) {
                        HuiYanAuthTipsEvent huiYanAuthTipsEvent3 = HuiYanAuthTipsEvent.NONE;
                        com.tencent.could.huiyansdk.callback.b bVar = cVar.f100133b;
                        if (bVar != null) {
                            ((com.tencent.could.huiyansdk.fragments.e) bVar).a(resContext, -1, huiYanAuthTipsEvent3);
                        }
                    } else {
                        int identifier = resContext.getResources().getIdentifier(str, HippyControllerProps.STRING, resContext.getPackageName());
                        if (cVar.a(identifier, cVar.f100137f)) {
                            SparseArray<HuiYanAuthTipsEvent> sparseArray = cVar.f100143l;
                            if (sparseArray == null) {
                                huiYanAuthTipsEvent2 = HuiYanAuthTipsEvent.NONE;
                            } else {
                                huiYanAuthTipsEvent2 = sparseArray.get(identifier);
                                if (huiYanAuthTipsEvent2 == null) {
                                    huiYanAuthTipsEvent2 = HuiYanAuthTipsEvent.NONE;
                                }
                            }
                            com.tencent.could.huiyansdk.callback.b bVar2 = cVar.f100133b;
                            if (bVar2 != null) {
                                ((com.tencent.could.huiyansdk.fragments.e) bVar2).a(resContext, identifier, huiYanAuthTipsEvent2);
                            }
                        }
                    }
                } else {
                    HuiYanAuthTipsEvent huiYanAuthTipsEvent4 = HuiYanAuthTipsEvent.NONE;
                    com.tencent.could.huiyansdk.callback.b bVar3 = cVar.f100133b;
                    if (bVar3 != null) {
                        ((com.tencent.could.huiyansdk.fragments.e) bVar3).a(resContext, -1, huiYanAuthTipsEvent4);
                    }
                }
                String str2 = (String) hashMap.get(StateEvent.Name.UI_TIPS);
                k kVar = k.a.f100197a;
                if (kVar.f100192d != null && kVar.f100194f != null) {
                    Message obtainMessage = kVar.f100194f.obtainMessage();
                    obtainMessage.what = 0;
                    obtainMessage.obj = str2;
                    kVar.f100194f.sendMessage(obtainMessage);
                }
                if (!TextUtils.isEmpty(str2)) {
                    i16 = resContext.getResources().getIdentifier(str2, HippyControllerProps.STRING, resContext.getPackageName());
                    if (i16 == R.string.rst_failed) {
                        String string = resContext.getString(R.string.txy_local_check_fail);
                        if (hashMap.containsKey("error_code")) {
                            Integer num = (Integer) hashMap.get("error_code");
                            if (num.intValue() == 4194307) {
                                string = resContext.getString(R.string.txy_local_check_out_time);
                            }
                            string = string + "(code:" + num + ")";
                        }
                        HuiYanSdkImp.getInstance().sendBuriedPointInfo("AuthCheckStage", "YouTuLocalCheckError", string);
                        CompareResult compareResult = new CompareResult();
                        compareResult.setErrorCode(228);
                        compareResult.setErrorMsg(string);
                        cVar.a(AuthState.AUTH_FAIL, compareResult);
                    } else if (!cVar.a(i16, cVar.f100138g)) {
                        if (i16 != -1 && i16 != R.string.fl_no_face && i16 != R.string.msg_fsm_pause && !cVar.f100134c) {
                            cVar.f100134c = true;
                            f.a.f100288a.f100273b = true;
                            cVar.a(AuthState.ON_FIRST_FOUND_FACE, (Object) null);
                            kVar.a(2, "AuthStateManager", "found face!");
                        }
                        if (i16 == R.string.msg_fsm_pause && HuiYanSdkImp.getInstance().isOpenCameraRiskParamCheck()) {
                            i16 = R.string.fl_pose_keep;
                        }
                        if (i16 == -1) {
                            if (cVar.f100140i == i16) {
                                cVar.f100141j = 0;
                            } else {
                                int i18 = cVar.f100141j;
                                if (i18 >= 3) {
                                    cVar.f100140i = i16;
                                    cVar.f100139h = i16;
                                    cVar.f100141j = 0;
                                    i17 = i16;
                                    if (i17 == -1) {
                                        int i19 = cVar.f100146o;
                                        AuthUiConfig authUiConfig = HuiYanSdkImp.getInstance().getAuthUiConfig();
                                        if (HuiYanSdkImp.getInstance().getPageColorStyle() == PageColorStyle.Dark && authUiConfig != null && authUiConfig.getFeedBackTxtColor() == -1) {
                                            i19 = resContext.getResources().getColor(R.color.cxh);
                                        }
                                        if (i16 != -1 && cVar.a(i16, cVar.f100135d)) {
                                            i19 = cVar.f100145n;
                                        }
                                        String string2 = resContext.getResources().getString(i16);
                                        com.tencent.could.huiyansdk.callback.b bVar4 = cVar.f100133b;
                                        if (bVar4 != null) {
                                            ((com.tencent.could.huiyansdk.fragments.e) bVar4).a(string2, i19);
                                        }
                                        int color = resContext.getResources().getColor(R.color.f158007cx1);
                                        if (cVar.a(i16, cVar.f100135d)) {
                                            cVar.a(cVar.f100147p);
                                        } else if (i16 != -1) {
                                            if (cVar.a(i16, cVar.f100136e)) {
                                                cVar.a(cVar.f100148q);
                                            } else {
                                                com.tencent.could.huiyansdk.callback.b bVar5 = cVar.f100133b;
                                                if (bVar5 != null) {
                                                    ((com.tencent.could.huiyansdk.fragments.e) bVar5).b(color);
                                                }
                                            }
                                        }
                                        SparseArray<HuiYanAuthTipsEvent> sparseArray2 = cVar.f100143l;
                                        if (sparseArray2 == null) {
                                            huiYanAuthTipsEvent = HuiYanAuthTipsEvent.NONE;
                                        } else {
                                            huiYanAuthTipsEvent = sparseArray2.get(i16);
                                            if (huiYanAuthTipsEvent == null) {
                                                huiYanAuthTipsEvent = HuiYanAuthTipsEvent.NONE;
                                            }
                                        }
                                        if (huiYanAuthTipsEvent == null) {
                                            HuiYanSdkImp.getInstance().doAuthTipsEvent(HuiYanAuthTipsEvent.NONE, false);
                                            return;
                                        } else {
                                            if (cVar.f100144m != huiYanAuthTipsEvent) {
                                                HuiYanSdkImp.getInstance().doAuthTipsEvent(huiYanAuthTipsEvent, false);
                                                cVar.f100144m = huiYanAuthTipsEvent;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    return;
                                }
                                if (cVar.f100139h != i16) {
                                    cVar.f100139h = i16;
                                    cVar.f100141j = 0;
                                } else {
                                    cVar.f100141j = i18 + 1;
                                }
                            }
                            i17 = -1;
                            if (i17 == -1) {
                            }
                        } else {
                            return;
                        }
                    }
                }
                i16 = -1;
                if (i16 == -1) {
                }
            }

            @Override // com.tencent.could.huiyansdk.base.HuiYanBaseCallBack
            public void onYouTuConfigLoadSuccess() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, (Object) this);
                    return;
                }
                if (HuiYanSdkImp.this.sdkConfig != null) {
                    HuiYanSdkImp huiYanSdkImp = HuiYanSdkImp.this;
                    huiYanSdkImp.updateYouTuConfig(huiYanSdkImp.sdkConfig);
                }
                HuiYanSdkImp.this.sendOperateTimeInfoEnd("StartYTAuthUseTime", false, "");
            }

            @Override // com.tencent.could.huiyansdk.base.HuiYanBaseCallBack
            public void updateOperateInfo(String str, int i16, long j3, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 9)) {
                    iPatchRedirector2.redirect((short) 9, this, str, Integer.valueOf(i16), Long.valueOf(j3), str2);
                } else {
                    HuiYanSdkImp.this.sendOperateInfo(str, i16, j3, str2);
                }
            }
        };
        l.a.f100309a.f100307a = this.sdkConfig.isOpenLog();
        HuiYanBaseConfig huiYanBaseConfig = new HuiYanBaseConfig();
        huiYanBaseConfig.setLicense(this.sdkConfig.getAuthLicense());
        huiYanBaseConfig.setModelPath(this.sdkConfig.getUseCustomerModelPath());
        huiYanBaseConfig.setHuiYanLiveMode(this.sdkConfig.getHuiYanLiveMode());
        sendOperateTimeInfoStart("StartYTAuthUseTime");
        huiYanBaseApi.f100029c = huiYanBaseConfig;
        try {
            i3 = b.a.f100123a.b(huiYanBaseConfig.getLicense());
        } catch (AuthException e16) {
            k.a.f100197a.a(2, "HuiYanBaseApi", "init error:" + e16.f100040b);
            HuiYanBaseCallBack huiYanBaseCallBack = huiYanBaseApi.f100028b;
            if (huiYanBaseCallBack != null) {
                huiYanBaseCallBack.onFail(e16.f100039a, e16.f100040b);
            }
            i3 = -1;
        }
        if (i3 != 0) {
            sendBuriedPointInfo("InitSDKStage", "YouTuInitError", "error code: " + i3);
            return;
        }
        sendBuriedPointInfo("InitSDKStage", "YouTuInitSuccess", "");
        startActivityFunction();
    }

    public void startNextStepByLight(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        this.isExitDoNeedShow = false;
        HuiYanSdkConfig sdkConfig = getSdkConfig();
        LiveDataCheckResult checkHaveColorData = CommonUtils.checkHaveColorData(str);
        if (sdkConfig.isUseBackCamera() && checkHaveColorData.isHaveColorData()) {
            k.a.f100197a.a(2, TAG, "have color data!");
            getInstance().sendBuriedPointInfo("AuthCheckStage", "AuthLocalFail", "back camera have color data!");
            CompareResult compareResult = new CompareResult();
            compareResult.setErrorCode(227);
            compareResult.setErrorMsg(getResContext().getResources().getString(R.string.txy_use_back_camera_with_reflective));
            HuiYanSdk.stopAuthAction(compareResult);
            return;
        }
        getInstance().updateConfigWithNoAction(checkHaveColorData.isNoAction());
        getInstance().initiativeUpdateSdkConfig();
        HuiYanBaseApi huiYanBaseApi = HuiYanBaseApi.b.f100031a;
        huiYanBaseApi.getClass();
        com.tencent.could.huiyansdk.helper.b bVar = b.a.f100123a;
        if (TextUtils.isEmpty(str)) {
            HuiYanBaseCallBack huiYanBaseCallBack = huiYanBaseApi.f100028b;
            if (huiYanBaseCallBack == null) {
                Log.e("HuiYanBaseApi", "send error callback, but callback is null!");
            } else {
                huiYanBaseCallBack.onFail(226, "");
            }
        } else if (bVar.f100121b == null) {
            HuiYanBaseCallBack huiYanBaseCallBack2 = huiYanBaseApi.f100028b;
            if (huiYanBaseCallBack2 == null) {
                Log.e("HuiYanBaseApi", "send error callback, but callback is null!");
            } else {
                huiYanBaseCallBack2.onFail(221, "");
            }
        } else {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("response", str);
            bVar.f100121b.onNetworkResponseEvent(hashMap, null);
        }
        realStartCheck();
    }

    public void stopAuthAction(CompareResult compareResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) compareResult);
            return;
        }
        BaseFragment a16 = b.a.f100131a.a();
        if (a16 instanceof AuthingFragment) {
            ((AuthingFragment) a16).a((Object) compareResult);
        } else {
            k.a.f100197a.a(2, TAG, "current fragment is null!");
            CommonUtils.sendErrorAndExitAuth(compareResult.getErrorCode(), compareResult.getErrorMsg());
        }
    }

    public void switchFragmentNoStackSwitchUi(BaseFragment baseFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) baseFragment);
            return;
        }
        com.tencent.could.huiyansdk.manager.b bVar = b.a.f100131a;
        synchronized (bVar) {
            if (baseFragment == null) {
                k.a.f100197a.a(2, "AuthFragmentManager", "switchFragmentNoStackSwitchUi input fragment is null!");
            } else {
                BaseFragment a16 = bVar.a();
                if (a16 == null) {
                    k.a.f100197a.a(2, "AuthFragmentManager", "switchFragmentNoStackSwitchUi currentFragment is null!");
                } else {
                    FragmentActivity activity = a16.getActivity();
                    if (activity == null) {
                        k.a.f100197a.a(2, "AuthFragmentManager", "switchFragmentNoStackSwitchUi currentActivity is null!");
                    } else {
                        activity.runOnUiThread(new com.tencent.could.huiyansdk.manager.a(bVar, baseFragment));
                    }
                }
            }
        }
    }

    public void updateConfigWithNoAction(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        try {
            b.a.f100123a.a("check_eye_open", z16);
        } catch (JSONException e16) {
            k.a.f100197a.a(2, TAG, "update sdk config error: " + e16.getLocalizedMessage());
        }
    }

    public void updateYtConfigFunction(UpdateYtConfig updateYtConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) updateYtConfig);
            return;
        }
        com.tencent.could.huiyansdk.helper.b bVar = b.a.f100123a;
        if (bVar.f100120a != null && updateYtConfig != null) {
            try {
                k kVar = k.a.f100197a;
                kVar.a(1, "YouTuSdkHelper", "need update yt config");
                if (updateYtConfig.angleDetectConfig != null) {
                    kVar.a(1, "YouTuSdkHelper", "update yt config: " + updateYtConfig.toString());
                    bVar.b("correction_angle_action_type", "1,5");
                    bVar.a("secondary_roll_threshold", updateYtConfig.angleDetectConfig.secondaryRollThreshold);
                    bVar.a("secondary_yaw_threshold", updateYtConfig.angleDetectConfig.secondaryYawThreshold);
                    bVar.a("secondary_pitch_threshold", updateYtConfig.angleDetectConfig.secondaryPitchThreshold);
                    return;
                }
                return;
            } catch (JSONException e16) {
                k.a.f100197a.a(2, "YouTuSdkHelper", "update yt config error: " + e16.getLocalizedMessage());
                return;
            }
        }
        k.a.f100197a.a(2, "YouTuSdkHelper", "update sdk config json is null!");
    }

    HuiYanSdkImp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isExitDoNeedShow = false;
            this.isCurrentFinish = false;
        }
    }

    public void onAuthEvent(HuiYanAuthEvent huiYanAuthEvent, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, huiYanAuthEvent, Boolean.valueOf(z16));
            return;
        }
        if (huiYanAuthEvent == HuiYanAuthEvent.NONE) {
            k.a.f100197a.a(2, TAG, "Auth event is none");
            return;
        }
        k.a.f100197a.a(2, TAG, "<auth event>: " + huiYanAuthEvent);
        HuiYanSdkEventCallBack huiYanSdkEventCallBack = this.eventCallBack;
        if (huiYanSdkEventCallBack != null) {
            huiYanSdkEventCallBack.onAuthEvent(huiYanAuthEvent);
        }
    }
}
