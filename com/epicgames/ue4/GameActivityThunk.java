package com.epicgames.ue4;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import com.epicgames.ue4.Logger;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GameActivityThunk {
    public static Logger Log = new Logger("UE4", "ActivityThunk");
    private static GameActivityThunk _singleton;
    public static EGLContext context;
    public static android.opengl.EGLContext eglContext;
    private CMShowEngineInitFinishListener mCMShowEngineInitFinishListener = null;
    private CMShowEngineFirstFrameListener mCMShowEngineFirstFrameListener = null;
    private CMShowSendListener mCMShowSendListener = null;
    private CMShowGetNetStatusListener mCMShowGetNetStatusListener = null;
    private CMShowLogListener mCMShowLogListener = null;
    private CMShowProfileListener mCMShowProfileListener = null;
    private DressChangedListener mDressChangedListener = null;
    private ZPlanMallStatusListener mZPlanMallStatusListener = null;
    public RequestLeaveAvatarShowListener mRequestLeaveAvatarShowListener = null;
    private CMShowReportListener mCMShowReportListener = null;
    private RecordFrameListener mRecordFrameListener = null;
    private RecordSameStyleListener mRecordSameStyleListener = null;
    private FireEventToMainProcessListener mFireEventToMainProcessListener = null;
    public RequestShowFeedbackListener mRequestShowFeedbackListener = null;
    private q0.b mLuaBridge = new q0.b();
    private DecodeImage2RGBA8Listener mDecodeImage2RGBA8Listener = null;
    public OpenLightAIPhotoSelectorListener mOpenLightAIPhotoSelectorListener = null;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface CMShowEngineFirstFrameListener {
        void onFirstFrame();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface CMShowEngineInitFinishListener {
        void onEngineInitFinish(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface CMShowGetNetStatusListener {
        int onCMShowGetNetStatus();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface CMShowLogListener {
        void onCMShowLog(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface CMShowProfileListener {
        int onCMShowGetProfile();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface CMShowReportListener {
        boolean onCMShowReportListener(String str, String str2, String str3, Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface CMShowSendListener {
        boolean onCMShowSend(String str, byte[] bArr);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface DecodeImage2RGBA8Listener {
        Bitmap onDecodeImage2RGBA8(String str, String str2, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface DressChangedListener {
        void onDressChanged(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface FireEventToMainProcessListener {
        void onReceiverEvent(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface OpenLightAIPhotoSelectorListener {
        void onOpenLightAIPhotoSelector();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface RecordFrameListener {
        void onFrameTick(long j3, int i3);

        void onRecordEnd(int i3, int i16);

        void onRecordStart(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface RecordSameStyleListener {
        void onRecordSameStyleAudioFrame(int i3, byte[] bArr, int i16, int i17);

        void onRecordSameStyleEnd(int i3);

        int onRecordSameStyleStart(int i3, int i16, int i17, int i18, int i19, int i26, String str);

        void onRecordSameStyleVideoFrame(int i3, byte[] bArr, int i16, int i17);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface RequestLeaveAvatarShowListener {
        void onRequestLeaveAvatarShow();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface RequestShowFeedbackListener {
        void onRequestShowFeedback();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface ZPlanMallStatusListener {
        void onAvatarSaved();
    }

    public static boolean AndroidThunkJava_IsEmbeddedToApp() {
        return true;
    }

    public static boolean AndroidThunkJava_IsStandalone() {
        return UE4.standalone;
    }

    public static GameActivityThunk Get() {
        return _singleton;
    }

    public static GameActivityThunk GetSingleton() {
        InitSingleton();
        return _singleton;
    }

    public static void InitSingleton() {
        if (_singleton == null) {
            _singleton = new GameActivityThunk();
        }
    }

    public void CMShowDressCostumeResult(int i3, int i16) {
        DressChangedListener dressChangedListener = this.mDressChangedListener;
        if (dressChangedListener != null) {
            dressChangedListener.onDressChanged(i3, i16);
        }
    }

    public void CMShowEndRecord(int i3, int i16) {
        RecordFrameListener recordFrameListener = this.mRecordFrameListener;
        if (recordFrameListener != null) {
            recordFrameListener.onRecordEnd(i3, i16);
        }
    }

    public void CMShowEngineFirstFrame() {
        Log.debug("onEngineFirstFrame");
        CMShowEngineFirstFrameListener cMShowEngineFirstFrameListener = this.mCMShowEngineFirstFrameListener;
        if (cMShowEngineFirstFrameListener != null) {
            cMShowEngineFirstFrameListener.onFirstFrame();
        }
    }

    public void CMShowEngineInitFinish(boolean z16) {
        Log.debug("onEngineInitFinish, succ test:" + z16);
        CMShowEngineInitFinishListener cMShowEngineInitFinishListener = this.mCMShowEngineInitFinishListener;
        if (cMShowEngineInitFinishListener != null) {
            cMShowEngineInitFinishListener.onEngineInitFinish(z16);
        }
    }

    public void CMShowFireEventToMainProcess(int i3, String str) {
        Log.debug("onRecordFrameCallback, evnetType:" + i3 + "; content: " + str);
        FireEventToMainProcessListener fireEventToMainProcessListener = this.mFireEventToMainProcessListener;
        if (fireEventToMainProcessListener != null) {
            fireEventToMainProcessListener.onReceiverEvent(i3, str);
        }
    }

    public int CMShowGetNetStatus() {
        CMShowGetNetStatusListener cMShowGetNetStatusListener = this.mCMShowGetNetStatusListener;
        if (cMShowGetNetStatusListener != null) {
            return cMShowGetNetStatusListener.onCMShowGetNetStatus();
        }
        return -1;
    }

    public int CMShowGetProfile() {
        CMShowProfileListener cMShowProfileListener = this.mCMShowProfileListener;
        if (cMShowProfileListener != null) {
            return cMShowProfileListener.onCMShowGetProfile();
        }
        return -1;
    }

    public void CMShowLog(int i3, String str) {
        String str2;
        if (!UE4.hasOption(3) && this.mCMShowLogListener != null) {
            if (i3 != 0) {
                if (i3 != 1) {
                    str2 = "CMShowWarning";
                    if (i3 != 2 && i3 == 3) {
                        str2 = "CMShowError";
                    }
                } else {
                    str2 = "CMShowInfo";
                }
            } else {
                str2 = "CMShowLog";
            }
            this.mCMShowLogListener.onCMShowLog(i3, str2 + MsgSummary.STR_COLON + str);
        }
    }

    public void CMShowOnAvatarSaved() {
        ZPlanMallStatusListener zPlanMallStatusListener = this.mZPlanMallStatusListener;
        if (zPlanMallStatusListener != null) {
            zPlanMallStatusListener.onAvatarSaved();
        }
    }

    public boolean CMShowReport(String str, String str2, String str3, Object obj) {
        CMShowReportListener cMShowReportListener = this.mCMShowReportListener;
        if (cMShowReportListener != null) {
            return cMShowReportListener.onCMShowReportListener(str, str2, str3, obj);
        }
        return false;
    }

    public void CMShowRequestLeaveAvatarShow() {
        GameActivityNative.LeaveAvatarShow();
        if (GameActivityNative.CanFinish()) {
            RequestLeaveAvatarShowListener requestLeaveAvatarShowListener = this.mRequestLeaveAvatarShowListener;
            if (requestLeaveAvatarShowListener != null) {
                requestLeaveAvatarShowListener.onRequestLeaveAvatarShow();
            }
            if (GameActivityBase.clientActivity != null) {
                Log.warn("UE4, CMShowRequestLeaveAvatarShow: finish Activity:" + GameActivityBase.clientActivity);
                GameActivityBase.clientActivity.finish();
                return;
            }
            Log.warn("UE4, CMShowRequestLeaveAvatarShow: no activity to finish");
        }
    }

    public void CMShowRequestShowFeedback() {
        Log.debug("onRequestShowFeedback");
        RequestShowFeedbackListener requestShowFeedbackListener = this.mRequestShowFeedbackListener;
        if (requestShowFeedbackListener != null) {
            requestShowFeedbackListener.onRequestShowFeedback();
        }
    }

    public boolean CMShowSend(String str, byte[] bArr) {
        CMShowSendListener cMShowSendListener = this.mCMShowSendListener;
        if (cMShowSendListener != null) {
            return cMShowSendListener.onCMShowSend(str, bArr);
        }
        return false;
    }

    public void CMShowStartRecord(int i3, int i16) {
        RecordFrameListener recordFrameListener = this.mRecordFrameListener;
        if (recordFrameListener != null) {
            recordFrameListener.onRecordStart(i3, i16);
        }
    }

    public Bitmap DecodeImage2RGBA8(String str, String str2, int i3, int i16) {
        DecodeImage2RGBA8Listener decodeImage2RGBA8Listener = this.mDecodeImage2RGBA8Listener;
        if (decodeImage2RGBA8Listener != null) {
            return decodeImage2RGBA8Listener.onDecodeImage2RGBA8(str, str2, i3, i16);
        }
        Log.error("DecodeImage2RGBA8 mDecodeImage2RGBA8Listener not exist!");
        return null;
    }

    public void GetCurrentContext() {
        Log.debug("Light: GetCurrentContext java");
        context = ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
        eglContext = EGL14.eglGetCurrentContext();
    }

    public p0.c GetLuaBridge() {
        return this.mLuaBridge;
    }

    public void OnFrameTickCallback(long j3, int i3) {
        Log.debug("OnFrameTickCallback.");
        RecordFrameListener recordFrameListener = this.mRecordFrameListener;
        if (recordFrameListener != null) {
            recordFrameListener.onFrameTick(j3, i3);
        }
    }

    public String OnLuaEvent(String str, String str2, int i3) {
        return this.mLuaBridge.l(str, str2, i3);
    }

    public void OnRecordSameStyleAudioFrame(int i3, byte[] bArr, int i16, int i17) {
        Log.debug("OnRecordSameStyleAudioFrame called with TaskID:" + i3 + ", DataSize:" + i16 + ", Pts:" + i17);
        RecordSameStyleListener recordSameStyleListener = this.mRecordSameStyleListener;
        if (recordSameStyleListener != null) {
            recordSameStyleListener.onRecordSameStyleAudioFrame(i3, bArr, i16, i17);
        }
    }

    public void OnRecordSameStyleEnd(int i3) {
        Log.debug("OnRecordSameStyleEnd called with TaskID " + i3);
        RecordSameStyleListener recordSameStyleListener = this.mRecordSameStyleListener;
        if (recordSameStyleListener != null) {
            recordSameStyleListener.onRecordSameStyleEnd(i3);
        }
    }

    public int OnRecordSameStyleStart(int i3, int i16, int i17, int i18, int i19, int i26, String str) {
        Log.debug("OnRecordSameStyleStart called with VideoFrameWidth:" + i3 + ", VideoFrameHeight:" + i16 + ", FrameRate:" + i17 + ", AudioSampleRate:" + i18 + ", AudioChannels:" + i19 + ", AudioSampleNumPerFrame:" + i26 + ", SavePath:" + str);
        RecordSameStyleListener recordSameStyleListener = this.mRecordSameStyleListener;
        if (recordSameStyleListener != null) {
            int onRecordSameStyleStart = recordSameStyleListener.onRecordSameStyleStart(i3, i16, i17, i18, i19, i26, str);
            Log.debug("OnRecordSameStyleStart called with listener returned " + onRecordSameStyleStart);
            return onRecordSameStyleStart;
        }
        Log.debug("OnRecordSameStyleStart called with null listener");
        return -1;
    }

    public void OnRecordSameStyleVideoFrame(int i3, byte[] bArr, int i16, int i17) {
        Log.debug("OnRecordSameStyleVideoFrame called with TaskID:" + i3 + ", DataSize:" + i16 + ", Pts:" + i17);
        if (this.mRecordSameStyleListener != null) {
            Log.debug("OnRecordSameStyleVideoFrame called with listener");
            this.mRecordSameStyleListener.onRecordSameStyleVideoFrame(i3, bArr, i16, i17);
        }
    }

    public void OpenLightAIPhotoSelector() {
        Log.debug("onOpenLightAIPhotoSelector");
        OpenLightAIPhotoSelectorListener openLightAIPhotoSelectorListener = this.mOpenLightAIPhotoSelectorListener;
        if (openLightAIPhotoSelectorListener != null) {
            openLightAIPhotoSelectorListener.onOpenLightAIPhotoSelector();
        }
    }

    public void setCMShowDressCostumeListener(DressChangedListener dressChangedListener) {
        this.mDressChangedListener = dressChangedListener;
    }

    public void setCMShowEngineFirstFrameListener(CMShowEngineFirstFrameListener cMShowEngineFirstFrameListener) {
        this.mCMShowEngineFirstFrameListener = cMShowEngineFirstFrameListener;
    }

    public void setCMShowEngineInitFinishListener(CMShowEngineInitFinishListener cMShowEngineInitFinishListener) {
        this.mCMShowEngineInitFinishListener = cMShowEngineInitFinishListener;
    }

    public void setCMShowGetNetStatusListener(CMShowGetNetStatusListener cMShowGetNetStatusListener) {
        this.mCMShowGetNetStatusListener = cMShowGetNetStatusListener;
    }

    public void setCMShowLogListener(CMShowLogListener cMShowLogListener) {
        this.mCMShowLogListener = cMShowLogListener;
        Logger.RegisterCallback(new Logger.ILoggerCallback() { // from class: com.epicgames.ue4.GameActivityThunk.1
            @Override // com.epicgames.ue4.Logger.ILoggerCallback
            public void LoggerCallback(String str, String str2, String str3) {
                CMShowLogListener cMShowLogListener2;
                if (!UE4.hasOption(3) && (cMShowLogListener2 = GameActivityThunk.this.mCMShowLogListener) != null) {
                    cMShowLogListener2.onCMShowLog(3, str2 + ":" + str3);
                }
            }
        });
    }

    public void setCMShowProfileListener(CMShowProfileListener cMShowProfileListener) {
        this.mCMShowProfileListener = cMShowProfileListener;
    }

    public void setCMShowReportListenerListener(CMShowReportListener cMShowReportListener) {
        this.mCMShowReportListener = cMShowReportListener;
    }

    public void setCMShowSendListener(CMShowSendListener cMShowSendListener) {
        this.mCMShowSendListener = cMShowSendListener;
    }

    public void setDecodeImage2RGBA8Listener(DecodeImage2RGBA8Listener decodeImage2RGBA8Listener) {
        this.mDecodeImage2RGBA8Listener = decodeImage2RGBA8Listener;
    }

    public void setFireEventToMainProcessListener(FireEventToMainProcessListener fireEventToMainProcessListener) {
        this.mFireEventToMainProcessListener = fireEventToMainProcessListener;
    }

    public void setOpenLightAIPhotoSelectorListener(OpenLightAIPhotoSelectorListener openLightAIPhotoSelectorListener) {
        this.mOpenLightAIPhotoSelectorListener = openLightAIPhotoSelectorListener;
    }

    public void setRecordFrameListener(RecordFrameListener recordFrameListener) {
        this.mRecordFrameListener = recordFrameListener;
    }

    public void setRecordSameStyleListener(RecordSameStyleListener recordSameStyleListener) {
        this.mRecordSameStyleListener = recordSameStyleListener;
    }

    public void setRequestLeaveAvatarShowListener(RequestLeaveAvatarShowListener requestLeaveAvatarShowListener) {
        this.mRequestLeaveAvatarShowListener = requestLeaveAvatarShowListener;
    }

    public void setRequestShowFeedbackListener(RequestShowFeedbackListener requestShowFeedbackListener) {
        this.mRequestShowFeedbackListener = requestShowFeedbackListener;
    }

    public void setZPlanMallStatusListener(ZPlanMallStatusListener zPlanMallStatusListener) {
        this.mZPlanMallStatusListener = zPlanMallStatusListener;
    }

    public void LoggerCallback(String str, String str2, String str3) {
    }
}
