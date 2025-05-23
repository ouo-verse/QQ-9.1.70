package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import com.qq.wx.voice.recognizer.VoiceRecognizer;
import com.qq.wx.voice.recognizer.VoiceRecognizerListener;
import com.qq.wx.voice.recognizer.VoiceRecognizerResult;
import com.qq.wx.voice.recognizer.VoiceRecordState;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.IVoiceInputHelper;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class VoiceInputHelperImpl implements VoiceRecognizerListener, IVoiceInputHelper {
    private static final String TAG = "VoiceInputHelperImpl";
    private boolean initialized = false;
    private String mCallback;
    private final Context mContext;
    private Handler mHandler;
    private final WebViewPlugin mHostPlugin;
    private QQPermission mQQPermission;
    private final AtomicLong mVoiceId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f291737a;

        a(boolean z16) {
            this.f291737a = z16;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.d(VoiceInputHelperImpl.TAG, 1, "checkPermission user grant");
            VoiceInputHelperImpl.this.removePermissionUncertainMonitor();
            if (this.f291737a) {
                VoiceInputHelperImpl.this.startInner();
            } else {
                VoiceInputHelperImpl.this.onPermissionResult(true, 0);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            QLog.e(VoiceInputHelperImpl.TAG, 1, "checkPermission user denied");
            VoiceInputHelperImpl.this.removePermissionUncertainMonitor();
            if (!this.f291737a) {
                VoiceInputHelperImpl.this.onPermissionResult(false, 1830001);
            } else {
                VoiceInputHelperImpl.this.onGetError(1830001);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1 && !VoiceInputHelperImpl.this.checkSelfPermission()) {
                QLog.e(VoiceInputHelperImpl.TAG, 1, "checkPermission uncertain");
                VoiceInputHelperImpl.this.onGetError(1830002);
            }
        }
    }

    public VoiceInputHelperImpl(WebViewPlugin webViewPlugin) {
        Context context;
        WebViewPlugin.b bVar;
        Activity a16;
        this.mHostPlugin = webViewPlugin;
        if (webViewPlugin != null && (bVar = webViewPlugin.mRuntime) != null && (a16 = bVar.a()) != null) {
            context = a16.getApplicationContext();
        } else {
            context = null;
        }
        this.mContext = context;
        if (context == null) {
            QLog.e(TAG, 1, "context is invalid.");
        }
        this.mVoiceId = new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSelfPermission() {
        AppActivity appActivity = getAppActivity();
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(appActivity, new BusinessConfig(QQPermissionConstants.Business.ID.TENCENT_DOCS_VOICE, QQPermissionConstants.Business.SCENE.TENCENT_DOCS_INPUT_VOICE));
        this.mQQPermission = qQPermission;
        if (qQPermission == null) {
            return false;
        }
        if (appActivity != null && qQPermission.hasPermission(QQPermissionConstants.Permission.RECORD_AUDIO) != 0) {
            return false;
        }
        return true;
    }

    private Activity getActivity() {
        WebViewPlugin.b bVar;
        WebViewPlugin webViewPlugin = this.mHostPlugin;
        if (webViewPlugin == null) {
            bVar = null;
        } else {
            bVar = webViewPlugin.mRuntime;
        }
        if (bVar == null) {
            return null;
        }
        return bVar.a();
    }

    private AppActivity getAppActivity() {
        Activity activity = getActivity();
        if (activity instanceof AppActivity) {
            return (AppActivity) activity;
        }
        return null;
    }

    private void keepScreenOn(boolean z16) {
        Window window;
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing() && (window = activity.getWindow()) != null) {
            if (z16) {
                window.addFlags(128);
            } else {
                window.clearFlags(128);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPermissionResult(boolean z16, int i3) {
        String str;
        String str2 = this.mCallback;
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("granted", z16);
                jSONObject.put("errorCode", i3);
                jSONObject.put("cmd", "onPermissionResult");
                str = jSONObject.toString();
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "onPermissionResult error", e16);
                str = "";
            }
            if (this.mHostPlugin != null && !TextUtils.isEmpty(str)) {
                this.mHostPlugin.callJs(str2, str);
            }
        }
    }

    private static void preInitInner(AppInterface appInterface) {
        if (appInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "voice input helper preInit invalid app");
            }
        } else {
            if (((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).isQQAppInterface(appInterface)) {
                ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).soLibraryCheckerExecute(appInterface.getApplication().getApplicationContext());
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "voice input helper preInit doing");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "voice input helper preInit app isn't QQAppInterface, app=" + appInterface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePermissionUncertainMonitor() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    private void requestPermission(boolean z16) {
        if (getAppActivity() == null) {
            return;
        }
        this.mQQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}, 2, new a(z16));
        if (this.mHandler == null) {
            this.mHandler = new b(Looper.getMainLooper());
        }
        this.mHandler.sendEmptyMessageDelayed(1, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setupInner() {
        if (!((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).soLibraryCheckerSoLibExists(this.mContext)) {
            QLog.e(TAG, 1, "setup error, so lib not exists");
            return false;
        }
        int init = VoiceRecognizer.shareInstance().init(this.mContext, IVoiceInputHelper.APP_ID, ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).soLibraryCheckerGetSoPath(this.mContext));
        if (init >= 0) {
            return true;
        }
        QLog.e(TAG, 1, "setup failed, ret=" + init);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startInner() {
        int start = VoiceRecognizer.shareInstance().start();
        if (start < 0) {
            QLog.e(TAG, 1, "start failed, ret=" + start);
            return false;
        }
        keepScreenOn(true);
        return true;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IVoiceInputHelper
    public boolean checkPermission(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "checkPermission failed, callback is invalid.");
            return false;
        }
        if (this.mHostPlugin == null) {
            return false;
        }
        this.mCallback = str;
        if (checkSelfPermission()) {
            onPermissionResult(true, 0);
            return true;
        }
        requestPermission(false);
        return false;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IVoiceInputHelper
    public void destroy() {
        this.mCallback = null;
        removePermissionUncertainMonitor();
        this.mHandler = null;
        VoiceRecognizer.shareInstance().destroy();
        keepScreenOn(false);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IVoiceInputHelper
    public boolean isInitialized() {
        return this.initialized;
    }

    @Override // com.qq.wx.voice.recognizer.VoiceRecognizerListener
    public void onGetError(int i3) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onGetError:" + i3);
        }
        String str2 = this.mCallback;
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorCode", i3);
                jSONObject.put("cmd", "error");
                str = jSONObject.toString();
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "onGetError error", e16);
                str = "";
            }
            if (this.mHostPlugin != null && !TextUtils.isEmpty(str)) {
                this.mHostPlugin.callJs(str2, str);
            }
        }
    }

    @Override // com.qq.wx.voice.recognizer.VoiceRecognizerListener
    public void onGetResult(VoiceRecognizerResult voiceRecognizerResult) {
        long j3;
        String str;
        if (voiceRecognizerResult == null) {
            return;
        }
        if (voiceRecognizerResult.isEnd) {
            j3 = this.mVoiceId.getAndIncrement();
        } else {
            j3 = this.mVoiceId.get();
        }
        String str2 = this.mCallback;
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", voiceRecognizerResult.text);
                jSONObject.put(QzoneCameraConst.Tag.ARG_PARAM_VOICE_ID, j3);
                jSONObject.put("startOffset", voiceRecognizerResult.startTime);
                jSONObject.put("endOffset", voiceRecognizerResult.stopTime);
                jSONObject.put("cmd", "result");
                str = jSONObject.toString();
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "onGetResult error", e16);
                str = "";
            }
            if (this.mHostPlugin != null && !TextUtils.isEmpty(str)) {
                this.mHostPlugin.callJs(str2, str);
            }
        }
    }

    @Override // com.qq.wx.voice.recognizer.VoiceRecognizerListener
    public void onGetVoiceRecordState(VoiceRecordState voiceRecordState) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onGetVoiceRecordState:" + voiceRecordState);
        }
        if (voiceRecordState == VoiceRecordState.Canceling || voiceRecordState == VoiceRecordState.Canceled || voiceRecordState == VoiceRecordState.Complete) {
            String str2 = this.mCallback;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("cmd", "canceled");
                    str = jSONObject.toString();
                } catch (JSONException e16) {
                    QLog.e(TAG, 1, "onGetVoiceRecordState error", e16);
                    str = "";
                }
                if (this.mHostPlugin != null && !TextUtils.isEmpty(str)) {
                    this.mHostPlugin.callJs(str2, str);
                }
            }
        }
    }

    @Override // com.qq.wx.voice.recognizer.VoiceRecognizerListener
    public void onVolumeChanged(int i3) {
        String str;
        String str2 = this.mCallback;
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, i3);
                jSONObject.put("cmd", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME);
                str = jSONObject.toString();
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "onVolumeChanged error", e16);
                str = "";
            }
            if (this.mHostPlugin != null && !TextUtils.isEmpty(str)) {
                this.mHostPlugin.callJs(str2, str);
            }
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.IVoiceInputHelper
    public void preInit(AppInterface appInterface) {
        preInitInner(appInterface);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IVoiceInputHelper
    public boolean setup() {
        if (this.mContext == null) {
            return false;
        }
        VoiceRecognizer.shareInstance().setListener(this);
        VoiceRecognizer.shareInstance().setContRes(true);
        VoiceRecognizer.shareInstance().setContReco(true);
        VoiceRecognizer.shareInstance().setResultType(1);
        VoiceRecognizer.shareInstance().setSilentTime(1000);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.VoiceInputHelperImpl.1
            @Override // java.lang.Runnable
            public void run() {
                VoiceInputHelperImpl.this.setupInner();
            }
        }, 64, null, true);
        this.initialized = true;
        return true;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IVoiceInputHelper
    public boolean start(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "start failed, callback is invalid.");
            return false;
        }
        if (this.mHostPlugin == null) {
            return false;
        }
        this.mCallback = str;
        if (checkSelfPermission()) {
            return startInner();
        }
        requestPermission(true);
        return false;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IVoiceInputHelper
    public boolean stop() {
        int stop = VoiceRecognizer.shareInstance().stop();
        if (stop < 0) {
            QLog.e(TAG, 1, "stop failed, ret=" + stop);
            return false;
        }
        keepScreenOn(false);
        return true;
    }

    @Override // com.qq.wx.voice.recognizer.VoiceRecognizerListener
    public void onGetVoicePackage(byte[] bArr, String str) {
    }
}
