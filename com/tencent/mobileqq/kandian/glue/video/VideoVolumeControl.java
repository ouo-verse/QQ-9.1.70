package com.tencent.mobileqq.kandian.glue.video;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.ImageView;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.avbiz.IModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import f62.e;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.WeakHashMap;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VideoVolumeControl implements IVideoVolumeControl, IModule.FocusChangeListener {
    private static final long DURATION_RAISE_VOLUME = 5000;
    public static final String SET_MUTE_REASON_FROM_CLICK_VIDEO_NO_AUTO_PLAY = "noAutoPlayClickVideoInReadInjoy";
    public static final String SET_MUTE_REASON_FROM_KANDIAN_FEED = "jumpFromKandianFeed";
    private static final String TAG = "Q.readinjoy.video.VideoVolumeControl";
    private static final Object TOKEN_RAISE_VOLUME_TASK = new Object();
    private static VideoVolumeControl sIns;
    private AudioManager audioManager;
    private String mCurrentActivity;
    private Timer mInKandianResumeTimer;
    private b mPlayStateListener;
    private a phoneStateListener;
    private VolumeReceiver receiver;
    private boolean shouldMute;
    private boolean shouldMuteFromConfig;
    private boolean shouldMuteInReadInJoy = true;
    private boolean shouldMuteInVideoFeed = false;
    private boolean audioSwithSet = false;
    private ArrayList<WeakReference<ImageView>> videoVolumeImageView = new ArrayList<>();
    private int mOriginalRingMode = -1;
    private int mOriginalRingVolume = -1;
    private int mPreRingDode = -1;
    private boolean formDynamicTo1T3 = false;
    private boolean shouleIgnoreVolumeReceiverFristTime = true;
    private int mCurrentWhat = 0;
    private boolean dynamicPauseReceive = false;
    private boolean mInKandianResume = true;
    private int lastRaiseVolume = 0;
    private int raiseVolumeTarget = 0;
    private long raiseVolumeInterval = 0;
    private boolean raiseVolumeTaskRunning = false;
    private boolean shouldIgnoreVolumeReceiver = false;
    private final Runnable raiseVolumeTask = new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl.2
        @Override // java.lang.Runnable
        public void run() {
            VideoVolumeControl.this.doRaiseVolumeTask();
        }
    };
    private String mFirstModuleActivity = "";
    private Handler handler = new Handler(Looper.getMainLooper());
    private Map<VideoPlayManager, Boolean> videoManagers = new WeakHashMap();
    private boolean isFocusAudio = false;
    private Runnable mRequestOrAbandonAudioFocusCallBack = new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl.3
        @Override // java.lang.Runnable
        public void run() {
            if (VideoVolumeControl.this.isFocusAudio) {
                if (VideoVolumeControl.this.audioManager != null) {
                    VideoVolumeControl.this.audioManager.requestAudioFocus(null, 3, 2);
                }
            } else if (VideoVolumeControl.this.audioManager != null) {
                for (VideoPlayManager videoPlayManager : VideoVolumeControl.this.videoManagers.keySet()) {
                    if (videoPlayManager != null && videoPlayManager.L() && !videoPlayManager.J()) {
                        if (QLog.isColorLevel()) {
                            QLog.w(VideoVolumeControl.TAG, 2, "checkPlayState  IsPlaying & not Mute When abandonAudioFocus:" + videoPlayManager);
                            return;
                        }
                        return;
                    }
                }
                VideoVolumeControl.this.audioManager.abandonAudioFocus(null);
            }
            if (QLog.isColorLevel()) {
                QLog.d(VideoVolumeControl.TAG, 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + VideoVolumeControl.this.isFocusAudio);
            }
        }
    };
    private boolean shieldFirstOne = true;
    private boolean shieldVolumeChange = false;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private class VolumeReceiver extends BroadcastReceiver {
        VolumeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (BaseApplicationImpl.getApplication().getRuntime().isBackgroundStop || BaseApplicationImpl.getApplication().getRuntime().isBackgroundPause || VideoVolumeControl.this.shouldIgnoreVolumeReceiver) {
                return;
            }
            if (VideoVolumeControl.this.shouleIgnoreVolumeReceiverFristTime) {
                VideoVolumeControl.this.shouleIgnoreVolumeReceiverFristTime = false;
                return;
            }
            if (VideoVolumeControl.this.audioManager != null) {
                if (VideoVolumeControl.this.mInKandianResume) {
                    if (VideoVolumeControl.this.dynamicPauseReceive) {
                        if (QLog.isColorLevel()) {
                            QLog.d(VideoVolumeControl.TAG, 2, "dynamicPauseReceive true");
                            return;
                        }
                        return;
                    }
                    try {
                        if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
                            int streamVolume = SystemMethodProxy.getStreamVolume(VideoVolumeControl.this.audioManager, 3);
                            if (QLog.isColorLevel()) {
                                QLog.d(VideoVolumeControl.TAG, 2, "volume change:" + streamVolume);
                            }
                            if (VideoVolumeControl.this.shieldVolumeChange) {
                                QLog.d(VideoVolumeControl.TAG, 2, "volume change shield ");
                                return;
                            } else if (streamVolume == 0) {
                                VideoVolumeControl videoVolumeControl = VideoVolumeControl.this;
                                videoVolumeControl.setMute(true, "system volume 0", videoVolumeControl.mCurrentWhat);
                                return;
                            } else {
                                VideoVolumeControl videoVolumeControl2 = VideoVolumeControl.this;
                                videoVolumeControl2.setMute(false, "system volume change", videoVolumeControl2.mCurrentWhat);
                                return;
                            }
                        }
                        if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
                            boolean isWiredHeadsetOn = VideoVolumeControl.this.audioManager.isWiredHeadsetOn();
                            if (VideoVolumeControl.this.shieldFirstOne) {
                                VideoVolumeControl.this.shieldFirstOne = false;
                                return;
                            }
                            VideoVolumeControl.this.shieldVolumeChange = true;
                            if (isWiredHeadsetOn) {
                                VideoVolumeControl videoVolumeControl3 = VideoVolumeControl.this;
                                videoVolumeControl3.setMute(false, "headset on", videoVolumeControl3.mCurrentWhat);
                            } else {
                                VideoVolumeControl videoVolumeControl4 = VideoVolumeControl.this;
                                videoVolumeControl4.setMute(true, "headset off", videoVolumeControl4.mCurrentWhat);
                            }
                            VideoVolumeControl.this.handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl.VolumeReceiver.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    VideoVolumeControl.this.shieldVolumeChange = false;
                                }
                            }, 200L);
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        QLog.d(VideoVolumeControl.TAG, 1, "VolumeReceiver", e16);
                        return;
                    }
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(VideoVolumeControl.TAG, 2, "VolumeReceiver onReceive null");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends PhoneStateListener {
        a() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.d(VideoVolumeControl.TAG, 2, "onCallStateChanged:" + i3);
            }
            if (i3 == 0) {
                VideoVolumeControl.this.checkPlayStateAfterPhoneCall();
            } else if (i3 == 1) {
                VideoVolumeControl.this.checkPlayStateWhenPhoneCome(true);
            } else {
                if (i3 != 2) {
                    return;
                }
                VideoVolumeControl.this.checkPlayStateWhenPhoneCome(true);
            }
        }
    }

    VideoVolumeControl() {
        this.shouldMuteFromConfig = true;
        this.shouldMute = true;
        this.shouldMute = true;
        this.shouldMuteFromConfig = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancleRaiseVolumeTask() {
        if (this.raiseVolumeTaskRunning) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "cancleRaiseVolumeTask: ");
            }
            this.handler.removeCallbacks(this.raiseVolumeTask);
            checkAudioManager();
            this.audioManager.setStreamVolume(3, this.raiseVolumeTarget, 0);
            this.raiseVolumeTaskRunning = false;
        }
    }

    private void checkAudioManager() {
        if (this.audioManager == null) {
            this.audioManager = (AudioManager) BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRaiseVolumeTask() {
        int mediaVolume = getMediaVolume();
        if (mediaVolume == this.lastRaiseVolume && this.raiseVolumeTarget > mediaVolume) {
            int i3 = mediaVolume + 1;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "doRaiseVolumeTask: curVolume=" + mediaVolume);
            }
            checkAudioManager();
            this.audioManager.adjustStreamVolume(3, 1, 0);
            this.lastRaiseVolume = i3;
            if (i3 >= this.raiseVolumeTarget) {
                this.raiseVolumeTaskRunning = false;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "doRaiseVolumeTask: up to target finished");
                    return;
                }
                return;
            }
            this.handler.postDelayed(this.raiseVolumeTask, this.raiseVolumeInterval);
            return;
        }
        this.raiseVolumeTaskRunning = false;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doRaiseVolumeTask: fail, lastRaiseVolume=" + this.lastRaiseVolume + ", but curVolume=" + mediaVolume);
        }
    }

    public static VideoVolumeControl getInstance() {
        if (sIns == null) {
            synchronized (VideoVolumeControl.class) {
                if (sIns == null) {
                    sIns = new VideoVolumeControl();
                }
            }
        }
        return sIns;
    }

    private void runOnUIThreadIfNeeded(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
    }

    public void adjustMediaVolume(int i3) {
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            audioManager.adjustStreamVolume(3, i3, 0);
            if (SystemMethodProxy.getStreamVolume(this.audioManager, 3) == 0) {
                setMute(true, "system volume 0", this.mCurrentWhat);
            } else {
                setMute(false, "system volume change", this.mCurrentWhat);
            }
        }
    }

    void checkPlayStateAfterPhoneCall() {
        for (VideoPlayManager videoPlayManager : this.videoManagers.keySet()) {
            if (videoPlayManager != null) {
                videoPlayManager.w();
            }
        }
    }

    public int getMaxMediaVolume() {
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    public int getMediaVolume() {
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            return SystemMethodProxy.getStreamVolume(audioManager, 3);
        }
        return 0;
    }

    public float getMediaVolumeProgress() {
        if (this.audioManager != null) {
            return SystemMethodProxy.getStreamVolume(r0, 3) / this.audioManager.getStreamMaxVolume(3);
        }
        return 0.0f;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl
    public boolean isInPhoneCall(Context context) {
        return isInCall(context);
    }

    public boolean isMute() {
        return this.shouldMute;
    }

    public boolean needSmoothVideo() {
        return !this.audioSwithSet;
    }

    @Override // com.tencent.avbiz.IModule.FocusChangeListener
    public void onFocusGain() {
        for (VideoPlayManager videoPlayManager : this.videoManagers.keySet()) {
            if (videoPlayManager != null) {
                videoPlayManager.N();
            }
        }
        this.shouldMuteInReadInJoy = false;
        this.shouldMuteInVideoFeed = false;
        this.shouldMute = false;
    }

    @Override // com.tencent.avbiz.IModule.FocusChangeListener
    public void onFocusLoss() {
        for (VideoPlayManager videoPlayManager : this.videoManagers.keySet()) {
            if (videoPlayManager != null) {
                videoPlayManager.O();
            }
        }
        this.shouldMuteInReadInJoy = true;
        this.shouldMuteInVideoFeed = true;
        this.shouldMute = true;
    }

    public void outKandianModule(Activity activity) {
        if (this.mFirstModuleActivity.equals(activity.toString())) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "really outKandianModule origin is:" + this.mFirstModuleActivity + " act:" + activity.toString() + ",formDynamicTo1T3:" + this.formDynamicTo1T3);
            }
            AudioManager audioManager = this.audioManager;
            if (audioManager != null) {
                audioManager.abandonAudioFocus(null);
            }
            if (!"".equals(this.mFirstModuleActivity)) {
                BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(this.receiver);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (VideoVolumeControl.this.phoneStateListener != null) {
                                LocationMonitor.listen((TelephonyManager) BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone"), VideoVolumeControl.this.phoneStateListener, 0);
                                VideoVolumeControl.this.phoneStateListener = null;
                            }
                        } catch (Exception e16) {
                            QLog.e(VideoVolumeControl.TAG, 2, "outKandianModule: ", e16);
                        }
                    }
                }, 16, null, true);
            }
            this.mPlayStateListener = null;
            this.receiver = null;
            this.mFirstModuleActivity = "";
            this.audioManager = null;
            if (!this.formDynamicTo1T3) {
                setMute(false, "outKandianModule", 2);
                setMute(this.shouldMuteFromConfig, "outKandianModule", 1);
                this.audioSwithSet = false;
            } else {
                this.formDynamicTo1T3 = false;
                this.shouleIgnoreVolumeReceiverFristTime = false;
            }
            Timer timer = this.mInKandianResumeTimer;
            if (timer != null) {
                timer.cancel();
                this.mInKandianResumeTimer.purge();
                this.mInKandianResumeTimer = null;
            }
            IModule moduleByName = AVBizModuleFactory.getModuleByName(Constants.Business.READINJOY);
            moduleByName.setListener(this);
            moduleByName.abandonAVFocus();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 2, "outKandianModule origin:" + this.mFirstModuleActivity + " act:" + activity.toString());
        }
    }

    public void raiseVolumeSmoothly(int i3, int i16, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "raiseVolumeSmoothly: from=" + i3 + ", to=" + i16 + ", duration=" + j3);
        }
        if (i16 <= i3 || i16 <= 0 || j3 <= 0) {
            return;
        }
        this.lastRaiseVolume = i3;
        this.raiseVolumeTarget = i16;
        this.raiseVolumeInterval = ((float) j3) / (i16 - i3);
        checkAudioManager();
        this.audioManager.setStreamVolume(3, i3, 0);
        this.handler.postDelayed(this.raiseVolumeTask, this.raiseVolumeInterval);
        this.raiseVolumeTaskRunning = true;
    }

    public synchronized void requestOrAbandonAudioFocus(boolean z16, String str) {
        this.isFocusAudio = z16;
        if (this.handler != null && this.mRequestOrAbandonAudioFocusCallBack != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "requestOrAbandonAudioFocus isFocus:" + z16 + " ;what:" + str);
            }
            this.handler.removeCallbacks(this.mRequestOrAbandonAudioFocusCallBack);
            if (this.isFocusAudio) {
                this.handler.post(this.mRequestOrAbandonAudioFocusCallBack);
            } else {
                this.handler.postDelayed(this.mRequestOrAbandonAudioFocusCallBack, 2000L);
            }
        }
    }

    public void restoreFeedsVideoView(ImageView imageView) {
        this.videoVolumeImageView.add(new WeakReference<>(imageView));
    }

    public void resumeInKandianModule() {
        if (this.mInKandianResumeTimer == null) {
            this.mInKandianResumeTimer = new BaseTimer();
        }
        this.mInKandianResume = false;
        this.mInKandianResumeTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                VideoVolumeControl.this.mInKandianResume = true;
            }
        }, 2000L);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl
    public void saveConfig(boolean z16) {
        this.shouldMuteFromConfig = z16;
    }

    public void setDynamicPauseReceive(boolean z16) {
        this.dynamicPauseReceive = z16;
    }

    public void setFormDynamicTo1T3(boolean z16) {
        this.formDynamicTo1T3 = z16;
        if (z16) {
            this.shouleIgnoreVolumeReceiverFristTime = true;
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl
    public void setMute(boolean z16, String str, int i3) {
        if (!this.audioSwithSet) {
            this.audioSwithSet = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setMute :" + z16 + ", oldValue:" + this.shouldMute + " reason:" + str + " what:" + i3);
        }
        boolean z17 = false;
        if (i3 == 1 || i3 == 0) {
            for (VideoPlayManager videoPlayManager : this.videoManagers.keySet()) {
                if (videoPlayManager != null) {
                    videoPlayManager.V(z16);
                    z17 |= videoPlayManager.L();
                }
            }
            this.shouldMuteInReadInJoy = z16;
        }
        if (z17) {
            requestOrAbandonAudioFocus(!this.shouldMuteInReadInJoy, "by user click mute btn ");
        }
        if (i3 == 2 || i3 == 0) {
            this.shouldMuteInVideoFeed = z16;
        }
        this.shouldMute = z16;
        runOnUIThreadIfNeeded(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl.1
            @Override // java.lang.Runnable
            public void run() {
                if (VideoVolumeControl.this.videoVolumeImageView == null || VideoVolumeControl.this.videoVolumeImageView.size() <= 0) {
                    return;
                }
                for (int i16 = 0; i16 < VideoVolumeControl.this.videoVolumeImageView.size(); i16++) {
                    try {
                        WeakReference weakReference = (WeakReference) VideoVolumeControl.this.videoVolumeImageView.get(i16);
                        if (weakReference != null) {
                            weakReference.get();
                        }
                    } catch (Exception e16) {
                        QLog.d(VideoVolumeControl.TAG, 1, "failed to update volume view:" + e16.toString());
                        return;
                    }
                }
            }
        });
    }

    public void setShouldMuteInVideoFeed(boolean z16) {
        this.shouldMuteInVideoFeed = z16;
    }

    public void setshouldIgnoreVolumeReceiver(boolean z16) {
        this.shouldIgnoreVolumeReceiver = z16;
    }

    public boolean shouldMute() {
        return this.shouldMute;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl
    public boolean shouldMuteInReadInJoy() {
        return this.shouldMuteInReadInJoy;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl
    public void startAudioPlay() {
        if (this.audioSwithSet) {
            return;
        }
        setMute(this.shouldMuteFromConfig, "start auto play", 1);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements e {
        b() {
        }

        @Override // f62.e
        public void b(k62.b bVar, o52.c cVar, int i3, int i16, Object obj) {
            if (i16 == 0) {
                VideoVolumeControl.this.cancleRaiseVolumeTask();
                return;
            }
            if (i16 == 1 || i16 == 2 || i16 != 3) {
                return;
            }
            VideoVolumeControl.this.cancleRaiseVolumeTask();
            VideoVolumeControl videoVolumeControl = VideoVolumeControl.this;
            videoVolumeControl.setMute(videoVolumeControl.shouldMuteInReadInJoy(), "video playing", 1);
            if (VideoVolumeControl.this.shouldMuteInReadInJoy()) {
                return;
            }
            VideoVolumeControl.this.requestOrAbandonAudioFocus(true, "PLAY_STATE_PLAYING");
        }
    }

    public void inKandianModule(Activity activity) {
        if (activity == null) {
            QLog.d(TAG, 2, "inKandianModule errParam\uff0cactivity == null");
            return;
        }
        this.mCurrentActivity = activity.toString();
        if (!"".equals(this.mFirstModuleActivity)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "inKandianModule origin:" + this.mFirstModuleActivity + " act:" + activity.toString());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "real inKandianModule origin:" + this.mFirstModuleActivity + " act:" + activity.toString());
        }
        this.mFirstModuleActivity = activity.toString();
        this.audioManager = (AudioManager) BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio");
        if (this.receiver == null) {
            this.receiver = new VolumeReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        intentFilter.addAction("android.media.RINGER_MODE_CHANGED");
        this.shieldFirstOne = true;
        BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(this.receiver, intentFilter);
        if (this.phoneStateListener == null) {
            this.phoneStateListener = new a();
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl.4
            @Override // java.lang.Runnable
            public void run() {
                a aVar = VideoVolumeControl.this.phoneStateListener;
                if (aVar != null) {
                    try {
                        LocationMonitor.listen((TelephonyManager) BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone"), aVar, 32);
                    } catch (Exception e16) {
                        QLog.e(VideoVolumeControl.TAG, 2, "inKandianModule: ", e16);
                    }
                }
            }
        }, 16, null, true);
        if (this.mPlayStateListener == null) {
            this.mPlayStateListener = new b();
        }
        int ringerMode = this.audioManager.getRingerMode();
        this.mOriginalRingMode = ringerMode;
        this.mPreRingDode = ringerMode;
        IModule moduleByName = AVBizModuleFactory.getModuleByName(Constants.Business.READINJOY);
        moduleByName.setListener(this);
        moduleByName.requestAVFocus();
    }

    public static boolean isInCall(Context context) {
        try {
            int callState = SystemMethodProxy.getCallState((TelephonyManager) context.getSystemService("phone"));
            return callState == 1 || callState == 2;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "obtain inCall info failed " + e16.toString());
            return false;
        }
    }

    public void attachVideoManager(VideoPlayManager videoPlayManager) {
        if (videoPlayManager != null) {
            videoPlayManager.V(shouldMuteInReadInJoy());
            if (!this.videoManagers.containsKey(videoPlayManager)) {
                this.videoManagers.put(videoPlayManager, Boolean.TRUE);
            }
            videoPlayManager.u(this.mPlayStateListener);
            this.mCurrentWhat = 1;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addVideoManager :" + videoPlayManager + " list:" + this.videoManagers);
        }
    }

    void checkPlayStateWhenPhoneCome(boolean z16) {
        if (z16) {
            for (VideoPlayManager videoPlayManager : this.videoManagers.keySet()) {
                if (videoPlayManager != null && videoPlayManager.L()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "checkPlayStateWhenPhoneCome:" + videoPlayManager);
                    }
                    if (videoPlayManager.B() != 5) {
                        videoPlayManager.W(true);
                    }
                    videoPlayManager.P();
                }
            }
        }
    }

    public void removeVideoManager(VideoPlayManager videoPlayManager) {
        if (videoPlayManager != null) {
            this.videoManagers.remove(videoPlayManager);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "removeVideoManager :" + videoPlayManager + " list:" + this.videoManagers);
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl
    public void setMuteForce(j62.b bVar, boolean z16) {
        if (bVar != null) {
            bVar.b(z16);
        }
    }

    public boolean shouldMuteInVideoFeed(boolean z16) {
        if (!z16) {
            return this.shouldMuteInVideoFeed;
        }
        if (this.audioManager == null) {
            this.audioManager = (AudioManager) BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio");
        }
        boolean z17 = SystemMethodProxy.getStreamVolume(this.audioManager, 3) <= 0;
        this.shouldMuteInVideoFeed = z17;
        return z17;
    }
}
