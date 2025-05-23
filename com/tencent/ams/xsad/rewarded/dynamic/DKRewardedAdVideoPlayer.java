package com.tencent.ams.xsad.rewarded.dynamic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.ams.dsdk.view.video.DKVideoPlayer;
import com.tencent.ams.xsad.rewarded.player.DefaultRewardedAdPlayer;
import com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer;
import com.tencent.ams.xsad.rewarded.utils.OnActivityLifecycleChanged;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DKRewardedAdVideoPlayer extends FrameLayout implements DKVideoPlayer, RewardedAdPlayer.a, OnActivityLifecycleChanged.c {
    static IPatchRedirector $redirector_;
    private boolean C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private RewardedAdPlayer f71770d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f71771e;

    /* renamed from: f, reason: collision with root package name */
    private AudioManager f71772f;

    /* renamed from: h, reason: collision with root package name */
    private DKVideoPlayer.OnVideoPlayListener f71773h;

    /* renamed from: i, reason: collision with root package name */
    private c f71774i;

    /* renamed from: m, reason: collision with root package name */
    private TimeUpdateRunnable f71775m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKRewardedAdVideoPlayer.this);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.dynamic.DKRewardedAdVideoPlayer.b
        public void onVolumeChanged(int i3) {
            int streamMaxVolume;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (DKRewardedAdVideoPlayer.this.f71773h == null) {
                return;
            }
            try {
                if (DKRewardedAdVideoPlayer.this.f71772f == null) {
                    streamMaxVolume = 0;
                } else {
                    streamMaxVolume = DKRewardedAdVideoPlayer.this.f71772f.getStreamMaxVolume(3);
                }
                float f16 = 0.0f;
                if (streamMaxVolume > 0.0f) {
                    f16 = i3 / streamMaxVolume;
                }
                com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", "onVolumeChanged, volume: " + i3 + ", max: " + streamMaxVolume + ", v: " + f16);
                if (DKRewardedAdVideoPlayer.this.f71773h != null) {
                    DKRewardedAdVideoPlayer.this.f71773h.onVolumeChange(f16);
                }
            } catch (Throwable th5) {
                com.tencent.ams.xsad.rewarded.utils.c.b("DKRewardAdVideoPlayer", "notify volume changed error.", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface b {
        void onVolumeChanged(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private b f71778a;

        public c(b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            } else {
                this.f71778a = bVar;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (intent != null && "android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && (intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0)) != intent.getIntExtra("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", 0)) {
                this.f71778a.onVolumeChanged(intExtra);
            }
        }
    }

    public DKRewardedAdVideoPlayer(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f71770d = null;
        this.f71771e = false;
        this.f71772f = null;
        this.f71773h = null;
        this.f71774i = null;
        this.f71775m = null;
        this.C = false;
        this.D = 0;
        g();
    }

    private synchronized void e() {
        this.D = getDuration();
        DKVideoPlayer.OnVideoPlayListener onVideoPlayListener = this.f71773h;
        if (onVideoPlayListener != null) {
            onVideoPlayListener.onPlay();
        }
        TimeUpdateRunnable timeUpdateRunnable = this.f71775m;
        if (timeUpdateRunnable == null || !timeUpdateRunnable.f71776d) {
            this.f71775m = new TimeUpdateRunnable(this, null);
            WorkThreadManager.getInstance().getImmediateThreadPool().execute(this.f71775m);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private RewardedAdPlayer f() {
        RewardedAdPlayer rewardedAdPlayer;
        Class<? extends RewardedAdPlayer> c16 = com.tencent.ams.xsad.rewarded.c.f().c();
        if (c16 != null) {
            try {
                rewardedAdPlayer = c16.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable th5) {
                com.tencent.ams.xsad.rewarded.utils.c.b("DKRewardAdVideoPlayer", "create ad player failed", th5);
            }
            if (rewardedAdPlayer != null) {
                return new DefaultRewardedAdPlayer();
            }
            return rewardedAdPlayer;
        }
        rewardedAdPlayer = null;
        if (rewardedAdPlayer != null) {
        }
    }

    private void g() {
        RewardedAdPlayer f16 = f();
        this.f71770d = f16;
        f16.b(getContext(), this);
        this.f71770d.d(this);
        this.f71770d.setOutputMute(h());
    }

    private boolean h() {
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        this.f71772f = audioManager;
        if (audioManager == null) {
            return true;
        }
        int streamVolume = SystemMethodProxy.getStreamVolume(audioManager, 3);
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", "current volume: " + streamVolume);
        if (streamVolume <= 0) {
            return true;
        }
        return false;
    }

    private void i() {
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", "onActivityPause");
        RewardedAdPlayer rewardedAdPlayer = this.f71770d;
        if (rewardedAdPlayer != null) {
            rewardedAdPlayer.onActivityPause();
        }
    }

    private void j() {
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", "onActivityResume");
        RewardedAdPlayer rewardedAdPlayer = this.f71770d;
        if (rewardedAdPlayer != null) {
            rewardedAdPlayer.onActivityResume();
        }
    }

    private void k() {
        Context context = getContext();
        if (this.f71774i == null && context != null) {
            c cVar = new c(new a());
            this.f71774i = cVar;
            context.registerReceiver(cVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
        }
    }

    private void l() {
        Context context;
        if (this.f71774i != null && (context = getContext()) != null) {
            context.unregisterReceiver(this.f71774i);
        }
        this.f71774i = null;
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", "onPlayComplete");
        DKVideoPlayer.OnVideoPlayListener onVideoPlayListener = this.f71773h;
        if (onVideoPlayListener != null) {
            int i3 = this.D;
            onVideoPlayListener.onTimeUpdate(i3, i3);
            onVideoPlayListener.onEnded();
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.utils.OnActivityLifecycleChanged.c
    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else if (i3 == 3) {
            i();
        } else if (i3 == 4) {
            j();
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public int getCurrentPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        RewardedAdPlayer rewardedAdPlayer = this.f71770d;
        if (rewardedAdPlayer != null) {
            return rewardedAdPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public int getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        RewardedAdPlayer rewardedAdPlayer = this.f71770d;
        if (rewardedAdPlayer != null) {
            return rewardedAdPlayer.getDuration();
        }
        return 0;
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        RewardedAdPlayer rewardedAdPlayer = this.f71770d;
        if (rewardedAdPlayer != null) {
            return rewardedAdPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer.a
    public void l1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", "onPlayError");
        DKVideoPlayer.OnVideoPlayListener onVideoPlayListener = this.f71773h;
        if (onVideoPlayListener != null) {
            onVideoPlayListener.onError(i3, "play failed");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", NodeProps.ON_ATTACHED_TO_WINDOW);
        super.onAttachedToWindow();
        k();
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        RewardedAdPlayer rewardedAdPlayer = this.f71770d;
        if (rewardedAdPlayer != null) {
            rewardedAdPlayer.stop();
        }
        this.f71770d = null;
        this.f71773h = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", NodeProps.ON_DETACHED_FROM_WINDOW);
        super.onDetachedFromWindow();
        l();
        OnActivityLifecycleChanged.e(this);
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer.a
    public void onPlayStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", HippyQQPagView.EventName.ON_PLAY_START);
            e();
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer, android.widget.MediaController.MediaPlayerControl
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", "pause");
        RewardedAdPlayer rewardedAdPlayer = this.f71770d;
        if (rewardedAdPlayer != null) {
            rewardedAdPlayer.pause();
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer, android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        RewardedAdPlayer rewardedAdPlayer = this.f71770d;
        if (rewardedAdPlayer != null) {
            rewardedAdPlayer.seekTo(i3);
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setAutoPlay(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", "setAutoPlay, isAutoPlay: " + this.f71771e);
        this.f71771e = z16;
        RewardedAdPlayer rewardedAdPlayer = this.f71770d;
        if (rewardedAdPlayer != null) {
            rewardedAdPlayer.setAutoPlay(z16);
        }
        if (z16) {
            start();
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setLoop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", "setLoop, isLooper: " + z16);
        this.C = z16;
        RewardedAdPlayer rewardedAdPlayer = this.f71770d;
        if (rewardedAdPlayer != null) {
            rewardedAdPlayer.a(z16);
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setMute(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", "setMute, isMute: " + z16);
        RewardedAdPlayer rewardedAdPlayer = this.f71770d;
        if (rewardedAdPlayer != null) {
            rewardedAdPlayer.setOutputMute(z16);
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setObjectFit(DKVideoPlayer.ObjectFit objectFit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) objectFit);
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setVid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", "vid: " + str);
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setVideoPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", "setVideoPath, videoPath: " + str);
        RewardedAdPlayer.b bVar = new RewardedAdPlayer.b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f71841a = jSONObject.optString("url");
            bVar.f71842b = new HashMap();
            JSONObject optJSONObject = jSONObject.optJSONObject("videoParams");
            if (optJSONObject != null) {
                bVar.f71842b.put("vid", optJSONObject.optString("vid"));
                bVar.f71842b.put("duration", Long.valueOf(optJSONObject.optLong("duration")));
                bVar.f71842b.put(QAdRewardDefine$VideoParams.CACHE_PATH, optJSONObject.optString(QAdRewardDefine$VideoParams.CACHE_PATH));
                bVar.f71842b.put("fileSize", Integer.valueOf(optJSONObject.optInt("fileSize")));
                bVar.f71842b.put("definition", optJSONObject.optString("definition"));
                bVar.f71842b.put("isCached", Boolean.valueOf(optJSONObject.optBoolean("isCached")));
            }
        } catch (Throwable th5) {
            com.tencent.ams.xsad.rewarded.utils.c.b("DKRewardAdVideoPlayer", "to json error.", th5);
        }
        this.f71770d.c(bVar);
        if (this.f71771e) {
            start();
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setVideoPlayListener(DKVideoPlayer.OnVideoPlayListener onVideoPlayListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) onVideoPlayListener);
        } else {
            this.f71773h = onVideoPlayListener;
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setVolume(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
            return;
        }
        AudioManager audioManager = this.f71772f;
        if (audioManager != null) {
            try {
                int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                int i3 = (int) (streamMaxVolume * f16);
                com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", "setVolume, value: " + f16 + ", maxVolume: " + streamMaxVolume + ", realVolume: " + i3);
                this.f71772f.setStreamVolume(3, i3, 4);
            } catch (Throwable th5) {
                com.tencent.ams.xsad.rewarded.utils.c.b("DKRewardAdVideoPlayer", "set volume error. value: " + f16, th5);
            }
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", "start");
        RewardedAdPlayer rewardedAdPlayer = this.f71770d;
        if (rewardedAdPlayer != null) {
            rewardedAdPlayer.start();
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardAdVideoPlayer", "stop");
        RewardedAdPlayer rewardedAdPlayer = this.f71770d;
        if (rewardedAdPlayer != null) {
            rewardedAdPlayer.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class TimeUpdateRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private volatile boolean f71776d;

        TimeUpdateRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f71776d = false;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKRewardedAdVideoPlayer.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f71776d = true;
            while (DKRewardedAdVideoPlayer.this.isPlaying()) {
                int currentPosition = DKRewardedAdVideoPlayer.this.getCurrentPosition();
                int duration = DKRewardedAdVideoPlayer.this.getDuration();
                DKVideoPlayer.OnVideoPlayListener onVideoPlayListener = DKRewardedAdVideoPlayer.this.f71773h;
                if (onVideoPlayListener != null) {
                    onVideoPlayListener.onTimeUpdate(currentPosition, duration);
                }
                try {
                    LockMethodProxy.sleep(200L);
                } catch (InterruptedException e16) {
                    com.tencent.ams.xsad.rewarded.utils.c.b("DKRewardAdVideoPlayer", "sleep error.", e16);
                }
            }
            this.f71776d = false;
        }

        /* synthetic */ TimeUpdateRunnable(DKRewardedAdVideoPlayer dKRewardedAdVideoPlayer, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dKRewardedAdVideoPlayer, (Object) aVar);
        }
    }
}
