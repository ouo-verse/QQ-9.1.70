package com.tencent.mm.plugin.appbrand.video.player.thumb;

import android.content.Context;
import android.os.Looper;
import android.view.Surface;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xg.a;
import com.tencent.luggage.wxa.xg.g;
import com.tencent.luggage.wxa.y8.c;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerFactory;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.composition.TPMediaCompositionFactory;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes9.dex */
public class ThumbMediaPlayer extends a {
    public final ITPPlayerListener.IOnCompletionListener A;
    public final ITPPlayerListener.IOnVideoSizeChangedListener B;
    public final ITPPlayerListener.IOnErrorListener C;
    public final ITPPlayerListener.IOnStateChangeListener D;
    public final ITPPlayerListener.IOnInfoListener E;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f152301n;

    /* renamed from: o, reason: collision with root package name */
    public final String f152302o;

    /* renamed from: p, reason: collision with root package name */
    public final ITPPlayer f152303p;

    /* renamed from: q, reason: collision with root package name */
    public long f152304q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f152305r;

    /* renamed from: s, reason: collision with root package name */
    public volatile boolean f152306s;

    /* renamed from: t, reason: collision with root package name */
    public Integer f152307t;

    /* renamed from: u, reason: collision with root package name */
    public volatile boolean f152308u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f152309v;

    /* renamed from: w, reason: collision with root package name */
    public final AtomicBoolean f152310w;

    /* renamed from: x, reason: collision with root package name */
    public volatile boolean f152311x;

    /* renamed from: y, reason: collision with root package name */
    public final ITPPlayerListener.IOnPreparedListener f152312y;

    /* renamed from: z, reason: collision with root package name */
    public final ITPPlayerListener.IOnSeekCompleteListener f152313z;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThumbMediaPlayer(Context context) {
        this(context, null, false, false, false, 30, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.luggage.wxa.xg.a, com.tencent.luggage.wxa.xg.g
    public void a(double d16) {
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getCurrentPosition() {
        ITPPlayer iTPPlayer = this.f152303p;
        if (i()) {
            try {
                w.a(e(), "getCurrentPosition");
                return (int) iTPPlayer.getCurrentPositionMs();
            } catch (Exception e16) {
                w.b(e(), "getCurrentPosition, fail since " + e16);
                a(e16);
            }
        } else {
            w.f(e(), "getCurrentPosition, player is not available");
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getDuration() {
        ITPPlayer iTPPlayer = this.f152303p;
        if (i()) {
            try {
                w.a(e(), "getDuration");
                return (int) iTPPlayer.getDurationMs();
            } catch (Exception e16) {
                w.b(e(), "getDuration, fail since " + e16);
                a(e16);
            }
        } else {
            w.f(e(), "getDuration, player is not available");
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getPlayerType() {
        return 3;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getVideoHeight() {
        ITPPlayer iTPPlayer = this.f152303p;
        if (i()) {
            try {
                w.a(e(), "getVideoHeight");
                return iTPPlayer.getVideoHeight();
            } catch (Exception e16) {
                w.b(e(), "getVideoHeight, fail since " + e16);
                a(e16);
            }
        } else {
            w.f(e(), "getVideoHeight, player is not available");
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getVideoWidth() {
        ITPPlayer iTPPlayer = this.f152303p;
        if (i()) {
            try {
                w.a(e(), "getVideoWidth");
                return iTPPlayer.getVideoWidth();
            } catch (Exception e16) {
                w.b(e(), "getVideoWidth, fail since " + e16);
                a(e16);
            }
        } else {
            w.f(e(), "getVideoWidth, player is not available");
        }
        return 0;
    }

    public final boolean h() {
        if (3 == this.f152303p.getCurrentState()) {
            return true;
        }
        return false;
    }

    public final boolean i() {
        return !this.f152306s;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public boolean isPlaying() {
        ITPPlayer iTPPlayer = this.f152303p;
        if (i()) {
            try {
                w.a(e(), "isPlaying");
                if (5 != iTPPlayer.getCurrentState()) {
                    return false;
                }
                return true;
            } catch (Exception e16) {
                w.b(e(), "isPlaying, fail since " + e16);
                a(e16);
                return false;
            }
        }
        w.f(e(), "isPlaying, player is not available");
        return false;
    }

    public final void j() {
        if (this.f152310w.getAndSet(false)) {
            this.f152303p.pauseDownload();
        } else {
            w.d(this.f152302o, "pausePlayerDownload, not downloading");
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void pause() {
        ITPPlayer iTPPlayer = this.f152303p;
        Unit unit = Unit.INSTANCE;
        if (i()) {
            try {
                w.a(e(), "pause");
                if (!h() && !isPlaying()) {
                    w.f(this.f152302o, "pause, is not preparing and not playing");
                } else {
                    iTPPlayer.pause();
                    j();
                    b(4);
                }
                return;
            } catch (Exception e16) {
                w.b(e(), "pause, fail since " + e16);
                a(e16);
                return;
            }
        }
        w.f(e(), "pause, player is not available");
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void prepareAsync() {
        ITPPlayer iTPPlayer = this.f152303p;
        Unit unit = Unit.INSTANCE;
        if (i()) {
            try {
                w.a(e(), "prepareAsync");
                if (getState() == 0) {
                    w.f(this.f152302o, "prepareAsync, idle");
                } else if (h()) {
                    w.f(this.f152302o, "prepareAsync, isPreparing");
                } else if (g()) {
                    w.f(this.f152302o, "prepareAsync, isPrepared");
                } else {
                    iTPPlayer.prepareAsync();
                }
                return;
            } catch (Exception e16) {
                w.b(e(), "prepareAsync, fail since " + e16);
                a(e16);
                return;
            }
        }
        w.f(e(), "prepareAsync, player is not available");
    }

    @Override // com.tencent.luggage.wxa.xg.a, com.tencent.luggage.wxa.xg.g
    public void release() {
        Unit unit = Unit.INSTANCE;
        if (i()) {
            try {
                w.a(e(), "release");
                this.f152303p.setOnPreparedListener((ITPPlayerListener.IOnPreparedListener) null);
                this.f152303p.setOnSeekCompleteListener((ITPPlayerListener.IOnSeekCompleteListener) null);
                this.f152303p.setOnCompletionListener((ITPPlayerListener.IOnCompletionListener) null);
                this.f152303p.setOnVideoSizeChangedListener((ITPPlayerListener.IOnVideoSizeChangedListener) null);
                this.f152303p.setOnErrorListener((ITPPlayerListener.IOnErrorListener) null);
                this.f152303p.setOnPlayerStateChangeListener((ITPPlayerListener.IOnStateChangeListener) null);
                this.f152303p.setOnInfoListener((ITPPlayerListener.IOnInfoListener) null);
                this.f152303p.release();
                b(-2);
            } catch (Exception e16) {
                w.b(e(), "release, fail since " + e16);
                a(e16);
            }
        } else {
            w.f(e(), "release, player is not available");
        }
        super.release();
        this.f152306s = true;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void reset() {
        ITPPlayer iTPPlayer = this.f152303p;
        Unit unit = Unit.INSTANCE;
        if (i()) {
            try {
                w.a(e(), "reset");
                iTPPlayer.reset();
                b(0);
                return;
            } catch (Exception e16) {
                w.b(e(), "reset, fail since " + e16);
                a(e16);
                return;
            }
        }
        w.f(e(), "reset, player is not available");
    }

    @Override // com.tencent.luggage.wxa.xg.a, com.tencent.luggage.wxa.xg.g
    public void setMinBufferDuration(long j3) {
        this.f152304q = j3;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void setMute(boolean z16) {
        ITPPlayer iTPPlayer = this.f152303p;
        Unit unit = Unit.INSTANCE;
        if (i()) {
            try {
                w.a(e(), "setMute");
                iTPPlayer.setOutputMute(z16);
                return;
            } catch (Exception e16) {
                w.b(e(), "setMute, fail since " + e16);
                a(e16);
                return;
            }
        }
        w.f(e(), "setMute, player is not available");
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void setSurface(Surface surface) {
        ITPPlayer iTPPlayer = this.f152303p;
        Unit unit = Unit.INSTANCE;
        if (i()) {
            try {
                w.a(e(), V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface);
                iTPPlayer.setSurface(surface);
                return;
            } catch (Exception e16) {
                w.b(e(), V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface + ", fail since " + e16);
                a(e16);
                return;
            }
        }
        w.f(e(), V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface + ", player is not available");
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void start() {
        ITPPlayer iTPPlayer = this.f152303p;
        Unit unit = Unit.INSTANCE;
        if (i()) {
            try {
                w.a(e(), "start");
                if (!d()) {
                    w.f(this.f152302o, "start, can not start");
                    return;
                }
                if (isPlaying()) {
                    w.f(this.f152302o, "start, isPlaying");
                    return;
                }
                if (!g()) {
                    w.f(this.f152302o, "start, is not prepared");
                    return;
                }
                if (7 == iTPPlayer.getCurrentState()) {
                    a(0L);
                }
                iTPPlayer.start();
                b(false);
                b(3);
                return;
            } catch (Exception e16) {
                w.b(e(), "start, fail since " + e16);
                a(e16);
                return;
            }
        }
        w.f(e(), "start, player is not available");
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void stop() {
        ITPPlayer iTPPlayer = this.f152303p;
        Unit unit = Unit.INSTANCE;
        if (i()) {
            try {
                w.a(e(), "stop");
                if (!d()) {
                    w.f(this.f152302o, "stop, can not start");
                } else {
                    iTPPlayer.stop();
                    j();
                    b(5);
                }
                return;
            } catch (Exception e16) {
                w.b(e(), "stop, fail since " + e16);
                a(e16);
                return;
            }
        }
        w.f(e(), "stop, player is not available");
    }

    public /* synthetic */ ThumbMediaPlayer(Context context, Looper looper, boolean z16, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : looper, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? true : z17, (i3 & 16) != 0 ? false : z18);
    }

    public void a(ITPPlayer player, int i3, long j3, long j16, Object obj) {
        Intrinsics.checkNotNullParameter(player, "player");
    }

    public final boolean d() {
        switch (this.f152303p.getCurrentState()) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    public final String e() {
        return this.f152302o;
    }

    public final ITPPlayer f() {
        return this.f152303p;
    }

    public final boolean g() {
        int currentState = this.f152303p.getCurrentState();
        return currentState == 4 || currentState == 5 || currentState == 6 || currentState == 7;
    }

    public ThumbMediaPlayer(Context context, Looper looper, boolean z16, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f152301n = z16;
        String str = "MicroMsg.AppBrand.ThumbMediaPlayer#" + hashCode();
        this.f152302o = str;
        this.f152304q = 10000L;
        this.f152310w = new AtomicBoolean(true);
        this.f152311x = true;
        ITPPlayerListener.IOnPreparedListener iOnPreparedListener = new ITPPlayerListener.IOnPreparedListener() { // from class: com.tencent.mm.plugin.appbrand.video.player.thumb.ThumbMediaPlayer$onPreparedListener$1
            public final void onPrepared(ITPPlayer iTPPlayer) {
                boolean z19;
                w.a(ThumbMediaPlayer.this.e(), "onPrepared");
                z19 = ThumbMediaPlayer.this.f152311x;
                if (z19) {
                    w.d(ThumbMediaPlayer.this.e(), "onPrepared, isPassiveDownloading, pausePlayerDownload");
                    ThumbMediaPlayer.this.j();
                }
                ThumbMediaPlayer.this.b(2);
                ThumbMediaPlayer.this.b();
            }
        };
        this.f152312y = iOnPreparedListener;
        ITPPlayerListener.IOnSeekCompleteListener iOnSeekCompleteListener = new ITPPlayerListener.IOnSeekCompleteListener() { // from class: com.tencent.mm.plugin.appbrand.video.player.thumb.ThumbMediaPlayer$onSeekCompleteListener$1
            public final void onSeekComplete(ITPPlayer iTPPlayer) {
                w.a(ThumbMediaPlayer.this.e(), "onSeekComplete");
                ThumbMediaPlayer.this.c();
            }
        };
        this.f152313z = iOnSeekCompleteListener;
        ITPPlayerListener.IOnCompletionListener iOnCompletionListener = new ITPPlayerListener.IOnCompletionListener() { // from class: com.tencent.mm.plugin.appbrand.video.player.thumb.ThumbMediaPlayer$onCompletionListener$1
            public final void onCompletion(ITPPlayer iTPPlayer) {
                w.a(ThumbMediaPlayer.this.e(), "onCompletion");
                ThumbMediaPlayer.this.b(6);
                ThumbMediaPlayer.this.a();
            }
        };
        this.A = iOnCompletionListener;
        ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener = new ITPPlayerListener.IOnVideoSizeChangedListener() { // from class: com.tencent.mm.plugin.appbrand.video.player.thumb.ThumbMediaPlayer$onVideoSizeChangedListener$1
            public final void onVideoSizeChanged(ITPPlayer iTPPlayer, long j3, long j16) {
                w.a(ThumbMediaPlayer.this.e(), "onVideoSizeChanged, width: " + j3 + ", height: " + j16);
                ThumbMediaPlayer.this.c((int) j3, (int) j16);
            }
        };
        this.B = iOnVideoSizeChangedListener;
        ITPPlayerListener.IOnErrorListener iOnErrorListener = new ITPPlayerListener.IOnErrorListener() { // from class: com.tencent.mm.plugin.appbrand.video.player.thumb.ThumbMediaPlayer$onErrorListener$1
            public final void onError(ITPPlayer iTPPlayer, int i3, int i16, long j3, long j16) {
                boolean z19;
                w.f(ThumbMediaPlayer.this.e(), "onError, errorType: " + i3 + ", errorCode: " + i16 + ", arg1: " + j3 + ", arg2: " + j16);
                if (1000 == i16) {
                    return;
                }
                if (1100 == i3) {
                    if (11070000 <= i16 && i16 < 11080000) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                        ThumbMediaPlayer.this.a(-20000, i16 - 11070000);
                        return;
                    }
                }
                ThumbMediaPlayer.this.a((-10000) - i3, i16);
            }
        };
        this.C = iOnErrorListener;
        ITPPlayerListener.IOnStateChangeListener iOnStateChangeListener = new ITPPlayerListener.IOnStateChangeListener() { // from class: com.tencent.mm.plugin.appbrand.video.player.thumb.ThumbMediaPlayer$onPlayerStateChangeListener$1
            public final void onStateChange(int i3, int i16) {
                w.a(ThumbMediaPlayer.this.e(), "onStateChange, preState: " + i3 + ", curState: " + i16);
            }
        };
        this.D = iOnStateChangeListener;
        w.a(str, "init");
        this.f152305r = z18;
        w.a(str, "init with useMinBufferDuration:" + this.f152305r);
        ThumbPlayerInitLogic.f152321a.a(context, z17, this.f152305r);
        ITPPlayer createTPPlayer = TPPlayerFactory.createTPPlayer(context, looper);
        Intrinsics.checkNotNullExpressionValue(createTPPlayer, "createTPPlayer(context, mainLooper)");
        this.f152303p = createTPPlayer;
        createTPPlayer.setOnPreparedListener(iOnPreparedListener);
        createTPPlayer.setOnSeekCompleteListener(iOnSeekCompleteListener);
        createTPPlayer.setOnCompletionListener(iOnCompletionListener);
        createTPPlayer.setOnVideoSizeChangedListener(iOnVideoSizeChangedListener);
        createTPPlayer.setOnErrorListener(iOnErrorListener);
        createTPPlayer.setOnPlayerStateChangeListener(iOnStateChangeListener);
        ITPPlayerListener.IOnInfoListener iOnInfoListener = new ITPPlayerListener.IOnInfoListener() { // from class: com.tencent.mm.plugin.appbrand.video.player.thumb.ThumbMediaPlayer.1
            public final void onInfo(ITPPlayer ttplayer, int i3, long j3, long j16, Object obj) {
                int i16;
                w.a(ThumbMediaPlayer.this.e(), "onInfo, what: " + i3 + ", arg1: " + j3 + ", arg2: " + j16 + ", extraObject: " + obj);
                if (201 == i3 && 7 == ThumbMediaPlayer.this.f().getCurrentState()) {
                    w.d(ThumbMediaPlayer.this.e(), "onInfo, buffering end when COMPLETE, notify seek complete");
                    ThumbMediaPlayer.this.c();
                }
                int i17 = 0;
                if (i3 != 106) {
                    if (i3 != 200) {
                        if (i3 == 201 && ThumbMediaPlayer.this.f152309v) {
                            ThumbMediaPlayer.this.f152309v = false;
                            i17 = com.tencent.luggage.wxa.zk.a.a(ThumbMediaPlayer.this.f());
                            i16 = 702;
                        }
                        i16 = -1;
                    } else {
                        if (!ThumbMediaPlayer.this.h() && !ThumbMediaPlayer.this.f152308u) {
                            i17 = com.tencent.luggage.wxa.zk.a.a(ThumbMediaPlayer.this.f());
                            ThumbMediaPlayer.this.f152309v = true;
                            i16 = 701;
                        }
                        i16 = -1;
                    }
                } else {
                    i16 = 3;
                }
                if (-1 != i16) {
                    ThumbMediaPlayer.this.b(i16, i17);
                }
                if (w0.c("") && 1006 == i3) {
                    if (!(obj instanceof TPPlayerMsg.TPDownLoadProgressInfo)) {
                        w.f(ThumbMediaPlayer.this.e(), "onInfo, extraObject is not TPDownLoadProgressInfo");
                    } else {
                        ThumbMediaPlayer thumbMediaPlayer = ThumbMediaPlayer.this;
                        thumbMediaPlayer.a(com.tencent.luggage.wxa.zk.a.a(thumbMediaPlayer.f()));
                    }
                }
                ThumbMediaPlayer thumbMediaPlayer2 = ThumbMediaPlayer.this;
                Intrinsics.checkNotNullExpressionValue(ttplayer, "ttplayer");
                thumbMediaPlayer2.a(ttplayer, i3, j3, j16, obj);
            }
        };
        this.E = iOnInfoListener;
        createTPPlayer.setOnInfoListener(iOnInfoListener);
        a(false);
    }

    public final Map b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", z.a());
        if (!(str == null || str.length() == 0)) {
            hashMap.put("Referrer", str);
        }
        return hashMap;
    }

    @Override // com.tencent.luggage.wxa.xg.a
    public void c() {
        this.f152308u = false;
        super.c();
        if (this.f152311x) {
            w.d(this.f152302o, "notifyOnSeekComplete, isPassiveDownloading, pausePlayerDownload");
            j();
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public g a(Class playerClass) {
        Intrinsics.checkNotNullParameter(playerClass, "playerClass");
        ThumbMediaPlayer thumbMediaPlayer = ThumbMediaPlayer.class.isAssignableFrom(playerClass) ? this : null;
        w.d(this.f152302o, "castTo, playerClass: " + playerClass + ", playerImpl: " + thumbMediaPlayer);
        return thumbMediaPlayer;
    }

    public final void b(boolean z16) {
        if (!this.f152310w.getAndSet(true)) {
            this.f152303p.resumeDownload();
            this.f152311x = z16;
        } else {
            if (this.f152308u && !z16) {
                this.f152311x = false;
            }
            w.d(this.f152302o, "resumePlayerDownload, already downloading");
        }
    }

    @Override // com.tencent.luggage.wxa.xg.a
    public void a(int i3) {
        w.a(this.f152302o, "notifyOnBufferingUpdate, percent:" + i3);
        Integer num = this.f152307t;
        if (num != null && i3 == num.intValue()) {
            return;
        }
        super.a(i3);
        this.f152307t = Integer.valueOf(i3);
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(String path, String str) {
        Intrinsics.checkNotNullParameter(path, "path");
        a(this, path, str, true, 0, 8, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x014c A[Catch: Exception -> 0x0188, TryCatch #0 {Exception -> 0x0188, blocks: (B:21:0x0039, B:23:0x007d, B:24:0x008b, B:26:0x0091, B:27:0x00d8, B:30:0x012d, B:32:0x0140, B:37:0x014c, B:39:0x0154, B:42:0x015d, B:44:0x0165, B:45:0x0184, B:48:0x0181, B:52:0x00ca), top: B:20:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015d A[Catch: Exception -> 0x0188, TryCatch #0 {Exception -> 0x0188, blocks: (B:21:0x0039, B:23:0x007d, B:24:0x008b, B:26:0x0091, B:27:0x00d8, B:30:0x012d, B:32:0x0140, B:37:0x014c, B:39:0x0154, B:42:0x015d, B:44:0x0165, B:45:0x0184, B:48:0x0181, B:52:0x00ca), top: B:20:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0165 A[Catch: Exception -> 0x0188, TryCatch #0 {Exception -> 0x0188, blocks: (B:21:0x0039, B:23:0x007d, B:24:0x008b, B:26:0x0091, B:27:0x00d8, B:30:0x012d, B:32:0x0140, B:37:0x014c, B:39:0x0154, B:42:0x015d, B:44:0x0165, B:45:0x0184, B:48:0x0181, B:52:0x00ca), top: B:20:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0181 A[Catch: Exception -> 0x0188, TryCatch #0 {Exception -> 0x0188, blocks: (B:21:0x0039, B:23:0x007d, B:24:0x008b, B:26:0x0091, B:27:0x00d8, B:30:0x012d, B:32:0x0140, B:37:0x014c, B:39:0x0154, B:42:0x015d, B:44:0x0165, B:45:0x0184, B:48:0x0181, B:52:0x00ca), top: B:20:0x0039 }] */
    @Override // com.tencent.luggage.wxa.xg.a, com.tencent.luggage.wxa.xg.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String sourceUrl, String str, String str2, boolean z16) {
        boolean startsWith$default;
        boolean z17;
        boolean z18;
        Map mapOf;
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        if (str == null || str.length() == 0) {
            if (str2 == null || str2.length() == 0) {
                a(-20000, 10000);
                return;
            }
        }
        ITPPlayer iTPPlayer = this.f152303p;
        Unit unit = Unit.INSTANCE;
        if (i()) {
            try {
                w.a(e(), "setDataSource");
                w.a(this.f152302o, "setDrmDataSource, sourceUrl: " + sourceUrl + ", provisionUrl: " + str + ", licenseUrl: " + str2 + ", isLive: " + z16);
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(sourceUrl, "file://", false, 2, null);
                if (startsWith$default) {
                    sourceUrl = sourceUrl.substring(7);
                    Intrinsics.checkNotNullExpressionValue(sourceUrl, "this as java.lang.String).substring(startIndex)");
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (this.f152305r) {
                    w.d(this.f152302o, "play mMinBufferDuration:" + this.f152304q);
                    iTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, this.f152304q));
                    iTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(304, 131072L));
                } else {
                    iTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 1000L));
                }
                iTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(504, 1L));
                iTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(206, true));
                byte[] bytes = sourceUrl.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                String a16 = c.a(bytes);
                w.d(this.f152302o, "setDrmDataSource, fileId: " + a16);
                TPVideoInfo.Builder fileId = new TPVideoInfo.Builder().fileId(a16);
                fileId.downloadParam(new TPDownloadParamData(z16 ? 5 : 3));
                iTPPlayer.setVideoInfo(fileId.build());
                ITPMediaDRMAsset createMediaDRMAsset = TPMediaCompositionFactory.createMediaDRMAsset(0, sourceUrl);
                if (str != null && str.length() != 0) {
                    z18 = false;
                    if (!z18) {
                        createMediaDRMAsset.setDrmProperty("drm_property_provision_url", str);
                    }
                    if (!(str2 != null || str2.length() == 0)) {
                        createMediaDRMAsset.setDrmProperty("drm_property_license_url", str2);
                    }
                    if (!z17) {
                        String url = createMediaDRMAsset.getUrl();
                        Intrinsics.checkNotNullExpressionValue(url, "drmAsset.url");
                        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("protocol_whitelist", "file,crypto,http,https,tls,tcp"));
                        com.tencent.luggage.wxa.zk.a.a(iTPPlayer, url, mapOf);
                    } else {
                        iTPPlayer.setDataSource(createMediaDRMAsset);
                    }
                    b(1);
                    return;
                }
                z18 = true;
                if (!z18) {
                }
                if (!(str2 != null || str2.length() == 0)) {
                }
                if (!z17) {
                }
                b(1);
                return;
            } catch (Exception e16) {
                w.b(e(), "setDataSource, fail since " + e16);
                a(e16);
                return;
            }
        }
        w.f(e(), "setDataSource, player is not available");
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(long j3) {
        ITPPlayer iTPPlayer = this.f152303p;
        Unit unit = Unit.INSTANCE;
        if (i()) {
            try {
                w.a(e(), "seekTo");
                b(true);
                iTPPlayer.seekTo((int) j3, 3);
                this.f152308u = true;
                return;
            } catch (Exception e16) {
                w.b(e(), "seekTo, fail since " + e16);
                a(e16);
                return;
            }
        }
        w.f(e(), "seekTo, player is not available");
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public boolean a(float f16) {
        ITPPlayer iTPPlayer = this.f152303p;
        if (i()) {
            try {
                w.a(e(), "setSpeed");
                iTPPlayer.setPlaySpeedRatio(f16);
                return true;
            } catch (Exception e16) {
                w.b(e(), "setSpeed, fail since " + e16);
                a(e16);
            }
        } else {
            w.f(e(), "setSpeed, player is not available");
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(float f16, float f17) {
        ITPPlayer iTPPlayer = this.f152303p;
        Unit unit = Unit.INSTANCE;
        if (i()) {
            try {
                w.a(e(), "setVolume");
                iTPPlayer.setAudioGainRatio(f16);
                return;
            } catch (Exception e16) {
                w.b(e(), "setVolume, fail since " + e16);
                a(e16);
                return;
            }
        }
        w.f(e(), "setVolume, player is not available");
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(boolean z16) {
        ITPPlayer iTPPlayer = this.f152303p;
        Unit unit = Unit.INSTANCE;
        if (i()) {
            try {
                w.a(e(), "setLooping");
                iTPPlayer.setLoopback(z16);
                return;
            } catch (Exception e16) {
                w.b(e(), "setLooping, fail since " + e16);
                a(e16);
                return;
            }
        }
        w.f(e(), "setLooping, player is not available");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(ThumbMediaPlayer thumbMediaPlayer, String str, String str2, boolean z16, int i3, int i16, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDataSource");
        }
        int i17 = i3;
        if ((i16 & 8) != 0) {
            i17 = thumbMediaPlayer.f152301n;
        }
        thumbMediaPlayer.a(str, str2, z16, i17);
    }

    public final void a(String path, String str, boolean z16, int i3) {
        boolean startsWith$default;
        List listOf;
        Intrinsics.checkNotNullParameter(path, "path");
        ITPPlayer iTPPlayer = this.f152303p;
        Unit unit = Unit.INSTANCE;
        if (i()) {
            try {
                w.a(e(), "setDataSource");
                w.a(this.f152302o, "setDataSource, path: " + path + ", referrer: " + str);
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, "file://", false, 2, null);
                if (startsWith$default) {
                    path = path.substring(7);
                    Intrinsics.checkNotNullExpressionValue(path, "this as java.lang.String).substring(startIndex)");
                }
                Map b16 = b(str);
                if (this.f152305r) {
                    w.d(this.f152302o, "play mMinBufferDuration:" + this.f152304q);
                    iTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, this.f152304q));
                    iTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(304, 131072L));
                } else {
                    iTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 1000L));
                }
                iTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(504, 1L));
                iTPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(206, z16));
                byte[] bytes = path.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                String a16 = c.a(bytes);
                w.d(this.f152302o, "setDataSource, fileId: " + a16);
                TPVideoInfo.Builder fileId = new TPVideoInfo.Builder().fileId(a16);
                TPDownloadParamData tPDownloadParamData = new TPDownloadParamData(i3);
                if (b16 != null) {
                    try {
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(b16);
                        tPDownloadParamData.setHeadersList(listOf);
                    } catch (Throwable th5) {
                        w.d(this.f152302o, "setDataSource, use custom api fail since " + th5);
                    }
                }
                fileId.downloadParam(tPDownloadParamData);
                iTPPlayer.setVideoInfo(fileId.build());
                if (b16 != null) {
                    com.tencent.luggage.wxa.zk.a.a(iTPPlayer, path, b16);
                } else {
                    iTPPlayer.setDataSource(path);
                }
                b(1);
                Unit unit2 = Unit.INSTANCE;
                return;
            } catch (Exception e16) {
                w.b(e(), "setDataSource, fail since " + e16);
                a(e16);
                return;
            }
        }
        w.f(e(), "setDataSource, player is not available");
    }

    public final void a(Exception e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        if (e16 instanceof IllegalStateException) {
            a(-10001, -1);
        } else if ((e16 instanceof IllegalArgumentException) && Intrinsics.areEqual("drm asset url is null or drm property is null", e16.getMessage())) {
            a(-20000, 10000);
        } else {
            a(-10999, -1);
        }
    }
}
