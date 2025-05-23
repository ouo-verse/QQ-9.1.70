package com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy;

import android.content.Context;
import android.media.AudioManager;
import android.view.Surface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.render.player.IPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u0006J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0006J\u0016\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0006J\u000e\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0004R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u0004\u0018\u00010&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010*R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010/R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00101R\u0016\u00103\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00102R\u0016\u00104\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u00102R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00105R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u00106R$\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0005\u0010-\u001a\u0004\b8\u00109R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010;\u00a8\u0006?"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/o;", "", "Lcom/tencent/tavcut/render/player/IPlayer;", "f", "", "l", "", "b", "Landroid/view/Surface;", "surface", "", "width", "height", "g", tl.h.F, "", "e", "()Ljava/lang/Long;", "Lcom/tencent/tavcut/render/player/IPlayer$a;", "playerListener", "c", "Lcom/tencent/tav/coremedia/CMTime;", "cmTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "j", "k", "Lcom/tencent/tavcut/session/a;", "iCutSession", "isAutoPlay", "p", "o", "isLoopPlay", DomainData.DOMAIN_NAME, "", "a", "Ljava/lang/String;", "TAG", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Landroid/media/AudioManager;", "Landroid/media/AudioManager;", "audioManager", "d", "Z", "isAllowInterrupt", "Lcom/tencent/tavcut/render/player/IPlayer;", "player", "Lcom/tencent/tavcut/session/a;", "I", "surfaceWidth", "surfaceHeight", "Lcom/tencent/tavcut/render/player/IPlayer$a;", "Landroid/view/Surface;", "<set-?>", "isResetting", "()Z", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "audioFocusChangeListener", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class o {

    /* renamed from: o, reason: collision with root package name */
    private static final String f347979o;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private AudioManager audioManager;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private com.tencent.tavcut.session.a iCutSession;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int surfaceWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int surfaceHeight;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private IPlayer.a playerListener;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private Surface surface;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isResetting;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "WS_TavPlayer@" + Integer.toHexString(hashCode());

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isAllowInterrupt = true;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isAutoPlay = true;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private IPlayer player = f();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.n
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i3) {
            o.d(o.this, i3);
        }
    };

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        f347979o = "WS_TavPlayer@" + Integer.toHexString(companion.hashCode());
    }

    private final void b() {
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            return;
        }
        audioManager.abandonAudioFocus(this.audioFocusChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(o this$0, int i3) {
        IPlayer iPlayer;
        IPlayer iPlayer2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == -2 || i3 == -1) {
            if (this$0.isAllowInterrupt && (iPlayer = this$0.player) != null) {
                iPlayer.pause();
                return;
            }
            return;
        }
        if (i3 == 1 && (iPlayer2 = this$0.player) != null) {
            iPlayer2.play();
        }
    }

    private final IPlayer f() {
        ee4.b.a(this.TAG, "newVersion, onSurfaceTextureAvailable: use surfaceTexture");
        IPlayer g16 = od4.b.f422509e.g(null);
        IPlayer.a aVar = this.playerListener;
        if (aVar != null) {
            g16.a(aVar);
        }
        this.isResetting = false;
        return g16;
    }

    private final boolean l() {
        Context context = this.context;
        if (context == null) {
            return true;
        }
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            Object systemService = context.getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            audioManager = (AudioManager) systemService;
        }
        if (this.audioManager == null) {
            this.audioManager = audioManager;
        }
        return audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 1) == 1;
    }

    public final void c(IPlayer.a playerListener) {
        Intrinsics.checkNotNullParameter(playerListener, "playerListener");
        ee4.b.a(this.TAG, "setPlayerListener() called with: playerListener = [" + playerListener + "],player = " + this.player);
        this.playerListener = playerListener;
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            iPlayer.a(playerListener);
        }
    }

    public final Long e() {
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            return Long.valueOf(iPlayer.getDurationUs());
        }
        return null;
    }

    public final void g(Surface surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        this.surfaceWidth = width;
        this.surfaceHeight = height;
        this.surface = surface;
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            iPlayer.setUpSurface(surface, width, height);
        }
    }

    public final void h() {
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            iPlayer.destroySurface();
        }
        this.surface = null;
    }

    public final synchronized void i() {
        ee4.b.a(this.TAG, "pause: player = " + this.player);
        if (this.player != null) {
            b();
            IPlayer iPlayer = this.player;
            if (iPlayer != null) {
                iPlayer.pause();
            }
        } else {
            this.isAutoPlay = false;
        }
    }

    public final synchronized void j() {
        IPlayer iPlayer;
        ee4.b.a(this.TAG, "play: player = " + this.player);
        if (this.player != null) {
            if (l() && (iPlayer = this.player) != null) {
                iPlayer.play();
            }
        } else {
            this.isAutoPlay = true;
        }
    }

    public final synchronized void k() {
        ee4.b.a(this.TAG, "release: player = " + this.player);
        if (this.player != null) {
            b();
            IPlayer iPlayer = this.player;
            if (iPlayer != null) {
                iPlayer.release();
            }
            this.player = null;
        }
        this.isResetting = false;
    }

    public final void m(CMTime cmTime) {
        Intrinsics.checkNotNullParameter(cmTime, "cmTime");
        ee4.b.a(this.TAG, "seekToTime() called with: cmTime = [" + cmTime + "],player = " + this.player);
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            iPlayer.seek(cmTime.getTimeUs());
        }
    }

    public final void n(boolean isLoopPlay) {
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            iPlayer.setLoopPlay(isLoopPlay);
        }
    }

    public final void o() {
        com.tencent.tavcut.session.a aVar = this.iCutSession;
        if (aVar != null) {
            aVar.l(this.player);
        }
        this.iCutSession = null;
    }

    public final void p(com.tencent.tavcut.session.a iCutSession, boolean isAutoPlay) {
        Intrinsics.checkNotNullParameter(iCutSession, "iCutSession");
        ee4.b.a(this.TAG, "updateComposition() called with: iCutSession = [" + iCutSession + "]");
        this.iCutSession = iCutSession;
        this.isAutoPlay = isAutoPlay;
        IPlayer iPlayer = this.player;
        if (iPlayer == null) {
            this.player = f();
        } else {
            iCutSession.p(iPlayer);
        }
    }
}
