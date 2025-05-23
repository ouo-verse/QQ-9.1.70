package com.tencent.mobileqq.kandian.glue.video;

import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.avbiz.IModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VideoVolumeController implements IVideoVolumeController, IModule.FocusChangeListener {
    private static final String TAG = "VideoVolumeController";
    private AudioManager audioManager;
    private Timer mInKandianResumeTimer;
    private a phoneStateListener;
    private VolumeReceiver receiver;
    private boolean dynamicPauseReceive = false;
    private boolean mInKandianResume = true;
    private ArrayList<IVideoVolumeController.a> mEventListeners = new ArrayList<>();
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean isFocusAudio = false;
    private int referenceCount = 0;
    private Set<String> referenceHis = new HashSet();
    private boolean isBizFocusing = true;
    private boolean hadChangeVolumeAfterLossFocus = false;
    private ValueAnimator mVolumeAnimator = null;
    private boolean mGriadientAnimStart = false;
    private Runnable mRequestOrAbandonAudioFocusCallBack = new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.video.VideoVolumeController.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoVolumeController.this.isFocusAudio) {
                if (VideoVolumeController.this.audioManager != null) {
                    VideoVolumeController.this.audioManager.requestAudioFocus(null, 3, 2);
                }
            } else if (VideoVolumeController.this.audioManager != null) {
                VideoVolumeController.this.audioManager.abandonAudioFocus(null);
            }
            if (QLog.isColorLevel()) {
                QLog.d(VideoVolumeController.TAG, 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + VideoVolumeController.this.isFocusAudio);
            }
        }
    };
    private boolean shieldFirstOne = true;
    private boolean shieldVolumeChange = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class VolumeReceiver extends BroadcastReceiver {
        VolumeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (BaseApplicationImpl.getApplication().getRuntime().isBackgroundStop || BaseApplicationImpl.getApplication().getRuntime().isBackgroundPause) {
                return;
            }
            if (VideoVolumeController.this.audioManager != null) {
                if (VideoVolumeController.this.mInKandianResume) {
                    if (VideoVolumeController.this.dynamicPauseReceive) {
                        if (QLog.isColorLevel()) {
                            QLog.d(VideoVolumeController.TAG, 2, "dynamicPauseReceive true");
                            return;
                        }
                        return;
                    }
                    try {
                        if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
                            int streamVolume = SystemMethodProxy.getStreamVolume(VideoVolumeController.this.audioManager, 3);
                            if (QLog.isColorLevel()) {
                                QLog.d(VideoVolumeController.TAG, 2, "volume change:" + streamVolume);
                            }
                            if (!VideoVolumeController.this.shieldVolumeChange) {
                                VideoVolumeController.this.hadChangeVolumeAfterLossFocus = true;
                                Iterator it = VideoVolumeController.this.mEventListeners.iterator();
                                while (it.hasNext()) {
                                    ((IVideoVolumeController.a) it.next()).onSystemVolumeChanged(streamVolume);
                                }
                                return;
                            }
                            QLog.d(VideoVolumeController.TAG, 2, "volume change shield ");
                            return;
                        }
                        if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
                            boolean isWiredHeadsetOn = VideoVolumeController.this.audioManager.isWiredHeadsetOn();
                            if (VideoVolumeController.this.shieldFirstOne) {
                                VideoVolumeController.this.shieldFirstOne = false;
                                return;
                            }
                            VideoVolumeController.this.shieldVolumeChange = true;
                            Iterator it5 = VideoVolumeController.this.mEventListeners.iterator();
                            while (it5.hasNext()) {
                                ((IVideoVolumeController.a) it5.next()).onHeadsetStateChanged(isWiredHeadsetOn);
                            }
                            VideoVolumeController.this.handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.video.VideoVolumeController.VolumeReceiver.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    VideoVolumeController.this.shieldVolumeChange = false;
                                }
                            }, 200L);
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        QLog.d(VideoVolumeController.TAG, 1, "VolumeReceiver", e16);
                        return;
                    }
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(VideoVolumeController.TAG, 2, "VolumeReceiver onReceive null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a extends PhoneStateListener {
        a() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.d(VideoVolumeController.TAG, 2, "onCallStateChanged:" + i3);
            }
            if (i3 == 1) {
                VideoVolumeController.this.checkPlayStateWhenPhoneCome(true);
            } else {
                if (i3 != 2) {
                    return;
                }
                VideoVolumeController.this.checkPlayStateWhenPhoneCome(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final VideoVolumeController f240036a = new VideoVolumeController();
    }

    VideoVolumeController() {
    }

    private void cancelVolumeAnimator() {
        ValueAnimator valueAnimator = this.mVolumeAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mVolumeAnimator = null;
        this.mGriadientAnimStart = false;
    }

    public static final VideoVolumeController getInstance() {
        return b.f240036a;
    }

    private void releaseAudioManager(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "releaseAudioManager..., act:" + str);
        }
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
        }
        BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(this.receiver);
        try {
            LocationMonitor.listen((TelephonyManager) BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone"), this.phoneStateListener, 0);
        } catch (Exception e16) {
            QLog.e(TAG, 2, "releaseAudioManager: ", e16);
        }
        this.phoneStateListener = null;
        this.receiver = null;
        this.audioManager = null;
        Timer timer = this.mInKandianResumeTimer;
        if (timer != null) {
            timer.cancel();
            this.mInKandianResumeTimer.purge();
            this.mInKandianResumeTimer = null;
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController
    public void addEventListener(IVideoVolumeController.a aVar) {
        this.mEventListeners.add(aVar);
    }

    public void adjustMediaVolume(int i3) {
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            audioManager.adjustStreamVolume(3, i3, 0);
        } else {
            QLog.e(TAG, 1, "adjustMediaVolume failed for audioManager is null.");
        }
    }

    public float getMediaVolumeProgress() {
        if (this.audioManager != null) {
            return SystemMethodProxy.getStreamVolume(r0, 3) / this.audioManager.getStreamMaxVolume(3);
        }
        return 0.0f;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController
    public int getStreamMaxVolume(int i3) {
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(i3);
        }
        return 0;
    }

    public int getStreamVolume(int i3) {
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            return SystemMethodProxy.getStreamVolume(audioManager, i3);
        }
        return 0;
    }

    public void inKandianModule(View view) {
        if (view != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "inKandianModule: view=" + view);
            }
            inKandianModule(Integer.toHexString(System.identityHashCode(view)));
        }
    }

    public boolean isBizFocusing() {
        return this.isBizFocusing;
    }

    public boolean isHadChangeVolumeAfterLossFocus() {
        return this.hadChangeVolumeAfterLossFocus;
    }

    @Override // com.tencent.avbiz.IModule.FocusChangeListener
    public void onFocusGain() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onFocusGain: ");
        }
        this.isBizFocusing = true;
        this.hadChangeVolumeAfterLossFocus = false;
        Iterator<IVideoVolumeController.a> it = this.mEventListeners.iterator();
        while (it.hasNext()) {
            it.next().onFocusGain();
        }
    }

    @Override // com.tencent.avbiz.IModule.FocusChangeListener
    public void onFocusLoss() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onFocusLoss: ");
        }
        this.isBizFocusing = false;
        this.hadChangeVolumeAfterLossFocus = false;
        Iterator<IVideoVolumeController.a> it = this.mEventListeners.iterator();
        while (it.hasNext()) {
            it.next().onFocusLoss();
        }
    }

    public void onVolumeKeyPressed() {
        cancelVolumeAnimator();
        new JSONObject();
    }

    public void onVolumeMuteChanged(boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onVolumeMuteChanged isClickMutedIcon:" + z16 + " muted:" + z17);
        }
        if (z16 && z17) {
            onVolumeKeyPressed();
        }
    }

    public void outKandianModule(View view) {
        if (view != null) {
            outKandianModule(Integer.toHexString(System.identityHashCode(view)));
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController
    public void removeEventListener(IVideoVolumeController.a aVar) {
        this.mEventListeners.remove(aVar);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController
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

    public void setStreamVolume(int i3, int i16, int i17) {
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            audioManager.setStreamVolume(i3, i16, i17);
        }
    }

    public int getMediaVolume() {
        return getStreamVolume(3);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController
    public void outKandianModule(Context context) {
        if (context != null) {
            outKandianModule(Integer.toHexString(System.identityHashCode(context)));
        }
    }

    public void startVolumeGradient(int i3, int i16, int i17) {
        int max = Math.max(0, i3);
        int min = Math.min(getStreamMaxVolume(3), i16);
        if (max >= min) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "startVolumeVary failed for " + max + " to" + min);
                return;
            }
            return;
        }
        cancelVolumeAnimator();
        ValueAnimator ofInt = ValueAnimator.ofInt(max, min);
        this.mVolumeAnimator = ofInt;
        ofInt.setDuration(i17);
        this.mVolumeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.kandian.glue.video.VideoVolumeController.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                final int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (intValue != VideoVolumeController.this.getMediaVolume()) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.video.VideoVolumeController.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            VideoVolumeController.this.setStreamVolume(3, intValue, 0);
                        }
                    }, 16, null, false);
                }
                if (VideoVolumeController.this.mGriadientAnimStart || intValue <= 0) {
                    return;
                }
                VideoVolumeController.this.mGriadientAnimStart = true;
                new JSONObject();
            }
        });
        this.mVolumeAnimator.start();
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

    private void outKandianModule(String str) {
        if (!this.referenceHis.remove(str)) {
            QLog.w(TAG, 1, "outKandianModule call failed for act:" + str + " not call inKandianModule, referenceCount:" + this.referenceCount);
            return;
        }
        int i3 = this.referenceCount;
        if (i3 <= 0) {
            QLog.w(TAG, 1, "outKandianModule call failed for referenceCount is " + this.referenceCount + ", act:" + str);
            return;
        }
        this.referenceCount = i3 - 1;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "outKandianModule: hexString:" + str + " referenceCount:" + this.referenceCount + " act:" + str);
        }
        if (this.referenceCount == 0) {
            releaseAudioManager(str);
            AVBizModuleFactory.getModuleByName(Constants.Business.READINJOY).abandonAVFocus();
            Thread.dumpStack();
        }
    }

    void checkPlayStateWhenPhoneCome(boolean z16) {
        if (z16) {
            Iterator<IVideoVolumeController.a> it = this.mEventListeners.iterator();
            while (it.hasNext()) {
                it.next().onPhoneCome();
            }
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController
    public void inKandianModule(Context context) {
        if (context != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "inKandianModule: context:" + context);
            }
            inKandianModule(Integer.toHexString(System.identityHashCode(context)));
        }
    }

    private void inKandianModule(String str) {
        if (this.referenceHis.contains(str)) {
            QLog.w(TAG, 1, "inKandianModule return for repeat call, hexString:" + str);
            return;
        }
        this.referenceHis.add(str);
        this.referenceCount++;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "inKandianModule: hexString:" + str + " referenceCount:" + this.referenceCount + " act:" + str);
        }
        if (this.audioManager == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "inKandianModule create audioManager, act:" + str);
            }
            this.audioManager = (AudioManager) BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio");
            this.receiver = new VolumeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
            intentFilter.addAction("android.media.RINGER_MODE_CHANGED");
            this.shieldFirstOne = true;
            BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(this.receiver, intentFilter);
            try {
                TelephonyManager telephonyManager = (TelephonyManager) BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone");
                a aVar = new a();
                this.phoneStateListener = aVar;
                LocationMonitor.listen(telephonyManager, aVar, 32);
            } catch (Exception e16) {
                QLog.e(TAG, 2, "inKandianModule: ", e16);
            }
            IModule moduleByName = AVBizModuleFactory.getModuleByName(Constants.Business.READINJOY);
            moduleByName.setListener(this);
            moduleByName.requestAVFocus();
        }
    }
}
