package cooperation.vip.ad;

import android.content.Context;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ah implements ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnVideoSizeChangedListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnTVideoNetInfoListener, ISuperPlayer.OnCompletionListener {
    private String C;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;

    /* renamed from: d, reason: collision with root package name */
    private Context f391151d;

    /* renamed from: e, reason: collision with root package name */
    private ISPlayerVideoView f391152e;

    /* renamed from: f, reason: collision with root package name */
    private ISuperPlayer f391153f;

    /* renamed from: h, reason: collision with root package name */
    private SuperPlayerVideoInfo f391154h;

    /* renamed from: i, reason: collision with root package name */
    private ISPlayerPreDownloader f391155i;

    /* renamed from: m, reason: collision with root package name */
    private String f391156m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(Context context, String str, String str2) {
        this.f391151d = context;
        this.f391156m = "UserLeadingVideo_" + str;
        this.C = str2;
        b();
    }

    private void b() {
        this.f391155i = SuperPlayerFactory.createPreDownloader(this.f391151d, 1);
        ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(this.f391151d, true);
        this.f391152e = createPlayerVideoView;
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(this.f391151d, 1, createPlayerVideoView);
        this.f391153f = createMediaPlayer;
        createMediaPlayer.setLoopback(true);
        this.f391153f.setXYaxis(2);
        this.f391154h = SuperPlayerFactory.createVideoInfoForUrl(new String[]{this.C}, 101, 0L, this.f391156m);
        i();
    }

    public ISPlayerVideoView a() {
        this.f391152e = null;
        ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(this.f391151d, true);
        this.f391152e = createPlayerVideoView;
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(this.f391151d, 1, createPlayerVideoView);
        this.f391153f = createMediaPlayer;
        createMediaPlayer.setLoopback(true);
        this.f391153f.setXYaxis(1);
        i();
        return this.f391152e;
    }

    public boolean c() {
        ISuperPlayer iSuperPlayer = this.f391153f;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isPlaying();
        }
        return false;
    }

    public void d() {
        ISuperPlayer iSuperPlayer = this.f391153f;
        if (iSuperPlayer != null) {
            iSuperPlayer.updatePlayerVideoView(this.f391152e);
            this.G = true;
            this.F = false;
            SuperPlayerOption obtain = SuperPlayerOption.obtain();
            SuperPlayerDownOption superPlayerDownOption = obtain.superPlayerDownOption;
            superPlayerDownOption.quicEnableMode = 1;
            superPlayerDownOption.enableQuicPlaintext = this.E;
            superPlayerDownOption.enableQuicConnectionMigration = true;
            obtain.bufferPacketMinTotalDurationMs = 6000L;
            obtain.isPrePlay = true;
            this.f391153f.setBusinessDownloadStrategy(10, 10, 3, 3);
            this.f391153f.openMediaPlayer(this.f391151d, SuperPlayerFactory.createVideoInfoForUrl(new String[]{this.C}, 101, 0L, this.f391156m), 0L, obtain);
        }
    }

    public void e() {
        ISuperPlayer iSuperPlayer = this.f391153f;
        if (iSuperPlayer != null) {
            iSuperPlayer.pause();
        }
    }

    public void f() {
        ISuperPlayer iSuperPlayer = this.f391153f;
        if (iSuperPlayer != null) {
            iSuperPlayer.start();
        }
    }

    public void g(ISPlayerPreDownloader.Listener listener) {
        ISPlayerPreDownloader iSPlayerPreDownloader = this.f391155i;
        if (iSPlayerPreDownloader != null) {
            iSPlayerPreDownloader.setOnPreDownloadListener(listener);
            this.f391155i.startPreDownload(this.f391154h, 8000L, 5000L);
        }
    }

    public void h() {
        ISuperPlayer iSuperPlayer = this.f391153f;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
            this.f391153f.release();
            this.f391153f.setOnVideoPreparedListener(null);
            this.f391153f.setOnInfoListener(null);
            this.f391153f.setOnErrorListener(null);
            this.f391153f.setOnDefinitionInfoListener(null);
            this.f391153f.setOnTVideoNetInfoUpdateListener(null);
            this.f391153f.setOnVideoSizeChangedListener(null);
            this.f391153f.setOnSeekCompleteListener(null);
            this.f391153f.setOnCompletionListener(null);
            this.f391153f = null;
        }
        if (this.f391152e != null) {
            this.f391152e = null;
        }
        ISPlayerPreDownloader iSPlayerPreDownloader = this.f391155i;
        if (iSPlayerPreDownloader != null) {
            iSPlayerPreDownloader.stopAllPreDownload();
            this.f391155i.destory();
            this.f391155i = null;
        }
    }

    public void i() {
        ISuperPlayer iSuperPlayer = this.f391153f;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnVideoPreparedListener(new ISuperPlayer.OnVideoPreparedListener() { // from class: cooperation.vip.ad.z
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
                public final void onVideoPrepared(ISuperPlayer iSuperPlayer2) {
                    ah.this.onVideoPrepared(iSuperPlayer2);
                }
            });
            this.f391153f.setOnInfoListener(new ISuperPlayer.OnInfoListener() { // from class: cooperation.vip.ad.aa
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
                public final boolean onInfo(ISuperPlayer iSuperPlayer2, int i3, long j3, long j16, Object obj) {
                    return ah.this.onInfo(iSuperPlayer2, i3, j3, j16, obj);
                }
            });
            this.f391153f.setOnErrorListener(new ISuperPlayer.OnErrorListener() { // from class: cooperation.vip.ad.ab
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
                public final boolean onError(ISuperPlayer iSuperPlayer2, int i3, int i16, int i17, String str) {
                    return ah.this.onError(iSuperPlayer2, i3, i16, i17, str);
                }
            });
            this.f391153f.setLoopback(true);
            this.f391153f.setOnDefinitionInfoListener(new ISuperPlayer.OnDefinitionInfoListener() { // from class: cooperation.vip.ad.ac
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener
                public final void onDefinitionInfoUpdate(ISuperPlayer iSuperPlayer2, String str, ArrayList arrayList) {
                    ah.this.onDefinitionInfoUpdate(iSuperPlayer2, str, arrayList);
                }
            });
            this.f391153f.setOnTVideoNetInfoUpdateListener(new ISuperPlayer.OnTVideoNetInfoListener() { // from class: cooperation.vip.ad.ad
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener
                public final void onTVideoNetInfoUpdate(ISuperPlayer iSuperPlayer2, TVideoNetInfo tVideoNetInfo) {
                    ah.this.onTVideoNetInfoUpdate(iSuperPlayer2, tVideoNetInfo);
                }
            });
            this.f391153f.setOnVideoSizeChangedListener(new ISuperPlayer.OnVideoSizeChangedListener() { // from class: cooperation.vip.ad.ae
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
                public final void onVideoSizeChanged(ISuperPlayer iSuperPlayer2, int i3, int i16) {
                    ah.this.onVideoSizeChanged(iSuperPlayer2, i3, i16);
                }
            });
            this.f391153f.setOnSeekCompleteListener(new ISuperPlayer.OnSeekCompleteListener() { // from class: cooperation.vip.ad.af
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
                public final void onSeekComplete(ISuperPlayer iSuperPlayer2) {
                    ah.this.onSeekComplete(iSuperPlayer2);
                }
            });
            this.f391153f.setOnCompletionListener(new ISuperPlayer.OnCompletionListener() { // from class: cooperation.vip.ad.ag
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
                public final void onCompletion(ISuperPlayer iSuperPlayer2) {
                    ah.this.onCompletion(iSuperPlayer2);
                }
            });
            this.f391153f.setOutputMute(true);
        }
    }

    public void j() {
        if (!this.G) {
            d();
        } else {
            f();
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        if (iSuperPlayer != null) {
            this.F = true;
            SimpleEventBus.getInstance().dispatchEvent(new VideoMessage(5, this.f391156m));
            QLog.d("UserLeadingVideo", 1, "onVideoPrepared" + this.f391156m);
            iSuperPlayer.start();
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
    public void onSeekComplete(ISuperPlayer iSuperPlayer) {
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener
    public void onTVideoNetInfoUpdate(ISuperPlayer iSuperPlayer, TVideoNetInfo tVideoNetInfo) {
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener
    public void onDefinitionInfoUpdate(ISuperPlayer iSuperPlayer, String str, ArrayList<String> arrayList) {
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(ISuperPlayer iSuperPlayer, int i3, int i16) {
    }
}
