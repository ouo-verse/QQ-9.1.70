package com.tencent.biz.qqcircle.immersive.views.search.util;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.KeyEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewParent;
import android.widget.SeekBar;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.events.QFSVideoOnPlayEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.immersive.views.search.QFSVideoTaskRunner;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class QFSSearchVideoPlayHelper {

    /* renamed from: a, reason: collision with root package name */
    private final b f91205a;

    /* renamed from: b, reason: collision with root package name */
    private final a f91206b;

    /* renamed from: c, reason: collision with root package name */
    private String f91207c;

    /* renamed from: d, reason: collision with root package name */
    private String f91208d;

    /* renamed from: e, reason: collision with root package name */
    private d f91209e;

    /* renamed from: f, reason: collision with root package name */
    private QFSVideoView f91210f;

    /* renamed from: g, reason: collision with root package name */
    private int f91211g;

    /* renamed from: h, reason: collision with root package name */
    private FeedCloudMeta$StFeed f91212h;

    /* renamed from: i, reason: collision with root package name */
    private int f91213i;

    /* renamed from: j, reason: collision with root package name */
    private VideoCallback f91214j;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f91216l;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f91217m;

    /* renamed from: k, reason: collision with root package name */
    private final c f91215k = new c();

    /* renamed from: n, reason: collision with root package name */
    private boolean f91218n = true;

    /* renamed from: o, reason: collision with root package name */
    private boolean f91219o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f91220p = true;

    /* renamed from: q, reason: collision with root package name */
    private final AtomicBoolean f91221q = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 extends QFSVideoTaskRunner.QFSVideoTask {
        AnonymousClass1(String str) {
            super(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j() {
            ISuperPlayer A = QFSSearchVideoPlayHelper.this.A();
            if (A != null) {
                QFSSearchVideoPlayHelper.this.J(A);
            } else {
                QFSSearchVideoPlayHelper.this.U();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSSearchVideoPlayHelper.this.M(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.s
                @Override // java.lang.Runnable
                public final void run() {
                    QFSSearchVideoPlayHelper.AnonymousClass1.this.j();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass2 extends QFSVideoTaskRunner.QFSVideoTask {
        final /* synthetic */ Runnable C;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Runnable runnable) {
            super(str);
            this.C = runnable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(Runnable runnable) {
            if (QFSSearchVideoPlayHelper.this.A() == null || QFSSearchVideoPlayHelper.this.f91210f.isRelease()) {
                QFSSearchVideoPlayHelper.this.G("#stop: not playing");
                return;
            }
            QFSSearchVideoPlayHelper.this.G("#stop: subThread");
            QFSSearchVideoPlayHelper.this.f91210f.stop();
            if (runnable != null) {
                runnable.run();
            }
            QFSSearchVideoPlayHelper.this.f91215k.d();
            QFSSearchVideoPlayHelper.this.K();
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSSearchVideoPlayHelper qFSSearchVideoPlayHelper = QFSSearchVideoPlayHelper.this;
            final Runnable runnable = this.C;
            qFSSearchVideoPlayHelper.M(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.t
                @Override // java.lang.Runnable
                public final void run() {
                    QFSSearchVideoPlayHelper.AnonymousClass2.this.j(runnable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper$3, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass3 extends QFSVideoTaskRunner.QFSVideoTask {
        AnonymousClass3(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            final QFSSearchVideoPlayHelper qFSSearchVideoPlayHelper = QFSSearchVideoPlayHelper.this;
            qFSSearchVideoPlayHelper.M(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.u
                @Override // java.lang.Runnable
                public final void run() {
                    QFSSearchVideoPlayHelper.u(QFSSearchVideoPlayHelper.this);
                }
            });
        }
    }

    /* loaded from: classes4.dex */
    public interface a {
        boolean H();

        void onPlay();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void setStatusLoading();

        void setStatusPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c implements IRFWPlayerPrepareListener, IRFWPlayerSecondBufferListener, IRFWPlayErrorStatusListener {
        private Boolean C;
        private long D;
        private boolean E;

        /* renamed from: d, reason: collision with root package name */
        private long f91223d;

        /* renamed from: e, reason: collision with root package name */
        private long f91224e;

        /* renamed from: f, reason: collision with root package name */
        private long f91225f;

        /* renamed from: h, reason: collision with root package name */
        private int f91226h;

        /* renamed from: i, reason: collision with root package name */
        private int f91227i;

        /* renamed from: m, reason: collision with root package name */
        private boolean f91228m;

        c() {
        }

        private void a(int i3, String str, long j3) {
            boolean z16;
            long j16 = this.f91225f - this.f91224e;
            long j17 = QFSSearchVideoPlayHelper.this.f91212h.video.duration.get();
            HashMap hashMap = new HashMap(20);
            hashMap.put("errorCode", String.valueOf(i3));
            hashMap.put("errorMessage", str);
            Boolean bool = this.C;
            if (bool != null) {
                hashMap.put("hitPreRender", String.valueOf(bool.booleanValue() ? 1 : 0));
            }
            hashMap.put("hasCache", String.valueOf(this.f91228m ? 1 : 0));
            boolean isHitVideoCache = QFSSearchVideoPlayHelper.this.f91210f.isHitVideoCache();
            hashMap.put("playerHitCache", String.valueOf(isHitVideoCache ? 1 : 0));
            QLog.d("QFSSearchVideoPlayHelper", 2, "#doReport: hasPreRendered=" + this.C + ", hasCache=" + this.f91228m + ", playerHitCache=" + isHitVideoCache);
            hashMap.put("netType", p.l());
            p.a k3 = p.k(QFSSearchVideoPlayHelper.this.f91212h);
            hashMap.put("predictNetSpeed", String.valueOf(k3.f91280a));
            hashMap.put("videoRate", String.valueOf(k3.f91281b));
            hashMap.put("netSpeedLevel", String.valueOf(k3.f91282c));
            hashMap.put("duration", String.valueOf(j17));
            hashMap.put("position", String.valueOf(QFSSearchVideoPlayHelper.this.f91211g));
            hashMap.put("tag", QFSSearchVideoPlayHelper.this.f91207c);
            hashMap.put("pageId", QFSSearchVideoPlayHelper.this.f91208d);
            hashMap.put("firstFrameLoadTime", String.valueOf(j3));
            hashMap.put("firstFrameRenderTime", String.valueOf(j16));
            hashMap.put("secondBufferCount", String.valueOf(this.f91226h));
            hashMap.put("totalSecondBufferTime", String.valueOf(this.f91227i));
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            ua0.j.h(z16, hashMap);
        }

        private void e(int i3, String str) {
            if (!this.E && p.B(QFSSearchVideoPlayHelper.this.f91212h)) {
                this.E = true;
                long j3 = this.f91224e - this.f91223d;
                if (i3 == 0 && j3 < 0) {
                    return;
                }
                a(i3, str, j3);
            }
        }

        void b() {
            if (!p.B(QFSSearchVideoPlayHelper.this.f91212h)) {
                return;
            }
            boolean z16 = false;
            this.E = false;
            this.f91223d = System.currentTimeMillis();
            this.f91224e = 0L;
            this.f91225f = 0L;
            this.f91226h = 0;
            this.f91227i = 0;
            if (RFWVideoUtils.checkCacheExist(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), QFSSearchVideoPlayHelper.this.f91210f.N0(), QFSSearchVideoPlayHelper.this.f91212h.video.fileId.get()) || RFWVideoUtils.checkCacheExist(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), QFSSearchVideoPlayHelper.this.f91210f.getPlayOptionUrl(), QFSSearchVideoPlayHelper.this.f91212h.video.fileId.get())) {
                z16 = true;
            }
            this.f91228m = z16;
            this.C = QFSSearchPrerenderManager.J(QFSSearchVideoPlayHelper.this.f91207c, QFSSearchVideoPlayHelper.this.f91212h);
        }

        void c() {
            e(0, "");
        }

        void d() {
            e(0, "");
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
            this.f91225f = System.currentTimeMillis();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener
        public void onSecondBufferEnd() {
            this.f91227i = (int) (this.f91227i + (System.currentTimeMillis() - this.D));
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener
        public void onSecondBufferStart() {
            this.f91226h++;
            this.D = System.currentTimeMillis();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
        public void onVideoPlayError(int i3, int i16, int i17, String str) {
            e(i17, "module=" + i3 + ", errorType=" + i16 + ", extraInfo=" + str);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            this.f91224e = System.currentTimeMillis();
        }
    }

    /* loaded from: classes4.dex */
    public interface d extends IRFWPlayerLooperListener {
        void R();

        int b0();

        void c0(int i3, int i16);

        void d0();

        void o0();

        void onCompletion();

        boolean onPlayError(int i3);

        void p0(ISuperPlayer iSuperPlayer);
    }

    public QFSSearchVideoPlayHelper(b bVar, a aVar, String str, String str2) {
        this.f91205a = bVar;
        this.f91206b = aVar;
        this.f91207c = str;
        this.f91208d = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public ISuperPlayer A() {
        return this.f91210f.getSuperPlayer();
    }

    private boolean C() {
        FeedCloudMeta$StFeed data = this.f91210f.getData();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f91212h;
        if (data != null && feedCloudMeta$StFeed != null) {
            return data.f398449id.get().equals(feedCloudMeta$StFeed.f398449id.get());
        }
        return false;
    }

    private boolean D() {
        ISuperPlayer realPlayer;
        RFWPlayer qCirclePlayer = this.f91210f.getQCirclePlayer();
        boolean z16 = false;
        if (qCirclePlayer != null && qCirclePlayer.isPlaying() && (realPlayer = qCirclePlayer.getRealPlayer()) != null && (realPlayer.isPlaying() || realPlayer.isBuffering())) {
            z16 = true;
        }
        G("#isPlaying: playing=" + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        this.f91209e.d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        this.f91209e.o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str) {
        String str2;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f91212h;
        if (feedCloudMeta$StFeed != null) {
            str2 = feedCloudMeta$StFeed.content.get();
        } else {
            str2 = "";
        }
        if (QLog.isColorLevel()) {
            QLog.d("QFSSearchVideoPlayHelper", 2, str + ", hashCode=" + hashCode() + ", title=" + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.f91210f.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.q
            @Override // java.lang.Runnable
            public final void run() {
                QFSSearchVideoPlayHelper.this.E();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void J(ISuperPlayer iSuperPlayer) {
        if (!C()) {
            G("#playWhenOldPlayerIsExist: different video");
            U();
            return;
        }
        if (D()) {
            G("#playWhenOldPlayerIsExist: isPlaying");
            return;
        }
        if (iSuperPlayer.isPausing()) {
            int b06 = this.f91209e.b0();
            if (iSuperPlayer.getCurrentPositionMs() != b06) {
                iSuperPlayer.seekTo(b06, 3);
            }
            G("#playWhenOldPlayerIsExist: directly start");
            this.f91210f.start();
            this.f91210f.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.r
                @Override // java.lang.Runnable
                public final void run() {
                    QFSSearchVideoPlayHelper.this.F();
                }
            });
            return;
        }
        G("#playWhenOldPlayerIsExist: start again");
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void L() {
        if (A() != null && !this.f91210f.isRelease()) {
            G("#release: subThread");
            this.f91210f.release();
            this.f91215k.c();
            return;
        }
        G("#release: not playing");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(Runnable runnable) {
        try {
            if (!this.f91221q.compareAndSet(false, true)) {
                return false;
            }
            try {
                runnable.run();
                return true;
            } catch (Exception e16) {
                QLog.w("QFSSearchVideoPlayHelper", 1, e16.getMessage(), e16);
                H();
                throw e16;
            }
        } finally {
            this.f91221q.set(false);
        }
    }

    public static void N(String str, int i3) {
        SimpleEventBus.getInstance().dispatchEvent(new QFSVideoOnPlayEvent(str, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void U() {
        this.f91213i = 0;
        this.f91210f.setData(this.f91212h, this.f91211g);
        this.f91210f.setForbidReport(this.f91219o);
        RFWPlayerOptions fromType = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setPlayUrl(p.m(this.f91212h)).setFileId(this.f91212h.video.fileId.get()).setStVideo(gb0.b.k(this.f91212h.video)).setStartOffset(this.f91209e.b0()).setIsMutualExclusion(this.f91220p).setFromType(11);
        x(fromType);
        G("#startANewPlayer");
        this.f91215k.b();
        this.f91210f.loadPlayOptions(fromType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void u(QFSSearchVideoPlayHelper qFSSearchVideoPlayHelper) {
        qFSSearchVideoPlayHelper.L();
    }

    private void x(RFWPlayerOptions rFWPlayerOptions) {
        if (this.f91214j == null) {
            this.f91214j = new VideoCallback();
        }
        rFWPlayerOptions.setPlayIOC(this.f91214j);
        rFWPlayerOptions.getListenerSet().addSDKInitListeners(this.f91214j);
        rFWPlayerOptions.getListenerSet().addSeekListeners(this.f91214j);
        rFWPlayerOptions.getListenerSet().addPrepareListeners(this.f91214j);
        rFWPlayerOptions.getListenerSet().addSecondBufferListeners(this.f91214j);
        rFWPlayerOptions.getListenerSet().addErrorStatusListener(this.f91214j);
        rFWPlayerOptions.getListenerSet().addLooperListeners(this.f91214j);
        rFWPlayerOptions.getListenerSet().addCompletionListener(this.f91214j);
        if (p.B(this.f91212h)) {
            rFWPlayerOptions.getListenerSet().addPrepareListeners(this.f91215k);
            rFWPlayerOptions.getListenerSet().addSecondBufferListeners(this.f91215k);
            rFWPlayerOptions.getListenerSet().addErrorStatusListener(this.f91215k);
        }
    }

    private Size z(int i3, int i16) {
        int min;
        int i17;
        int i18 = this.f91212h.video.width.get();
        int i19 = this.f91212h.video.height.get();
        float f16 = i19 / i18;
        if (f16 > i16 / i3) {
            i17 = Math.min(i18, i3);
            min = (int) (i17 * f16);
        } else {
            min = Math.min(i19, i16);
            i17 = (int) (min / f16);
        }
        return new Size(i17, min);
    }

    public String B() {
        return this.f91207c;
    }

    @MainThread
    public void I() {
        G("#play");
        this.f91216l = false;
        this.f91217m = true;
        this.f91206b.onPlay();
        QFSVideoTaskRunner.e().a(new AnonymousClass1("videoView.play-" + hashCode()));
    }

    @MainThread
    public void K() {
        G("#release");
        this.f91217m = false;
        this.f91216l = false;
        if (RFWThreadManager.isMainThread()) {
            QFSVideoTaskRunner.e().a(new AnonymousClass3("videoView.release-" + hashCode()));
            return;
        }
        L();
    }

    public void O(boolean z16) {
        this.f91219o = z16;
    }

    public void P(boolean z16) {
        this.f91218n = z16;
    }

    public void Q(int i3) {
        this.f91211g = i3;
    }

    public void R(d dVar) {
        this.f91209e = dVar;
    }

    public void S(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f91212h = feedCloudMeta$StFeed;
    }

    public void T(QFSVideoView qFSVideoView) {
        this.f91210f = qFSVideoView;
    }

    @MainThread
    public void V(Runnable runnable) {
        G("#stop");
        this.f91217m = false;
        QFSVideoTaskRunner.e().a(new AnonymousClass2("videoView.stop-" + hashCode(), runnable));
    }

    public Bitmap y(int i3, int i16) {
        Bitmap bitmap = null;
        if (this.f91216l) {
            KeyEvent.Callback childAt = this.f91210f.getChildAt(0);
            if (!(childAt instanceof ISPlayerVideoView)) {
                return null;
            }
            View renderView = ((ISPlayerVideoView) childAt).getRenderView();
            if (!(renderView instanceof TextureView)) {
                return null;
            }
            Size z16 = z(i3, i16);
            try {
                bitmap = ((TextureView) renderView).getBitmap(z16.getWidth(), z16.getHeight());
                G("#fetchSnapshot success");
                return bitmap;
            } catch (Throwable th5) {
                QLog.w("QFSSearchVideoPlayHelper", 1, th5.getMessage(), th5);
                return bitmap;
            }
        }
        QLog.w("QFSSearchVideoPlayHelper", 1, "#fetchSnapshot: frame is invalid");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class VideoCallback extends RFWPlayerIOC implements IRFWPlayerSdkInitListener, IRFWPlayerSeekListener, IRFWPlayerPrepareListener, IRFWPlayerSecondBufferListener, IRFWPlayErrorStatusListener, IRFWPlayerLooperListener, IRFWPlayerCompletionListener {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper$VideoCallback$1, reason: invalid class name */
        /* loaded from: classes4.dex */
        public class AnonymousClass1 extends QFSVideoTaskRunner.QFSVideoTask {
            final /* synthetic */ RFWPlayer C;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str, RFWPlayer rFWPlayer) {
                super(str);
                this.C = rFWPlayer;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void k() {
                QFSSearchVideoPlayHelper.this.f91210f.setOutPutMute(QFSSearchVideoPlayHelper.this.f91206b.H());
                if (!QFSSearchVideoPlayHelper.this.f91210f.isShown()) {
                    QFSSearchVideoPlayHelper.this.G("#onVideoPrepared: video view is not shown");
                    QFSSearchVideoPlayHelper.this.f91210f.setVisibility(0);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void l(RFWPlayer rFWPlayer) {
                if (!QFSSearchVideoPlayHelper.this.f91217m) {
                    QFSSearchVideoPlayHelper.this.G("#onVideoPrepared: can not play 1");
                    QFSSearchVideoPlayHelper.this.H();
                    return;
                }
                ISuperPlayer realPlayer = rFWPlayer.getRealPlayer();
                if (realPlayer == null) {
                    QFSSearchVideoPlayHelper.this.G("#onVideoPrepared: superPlayer is null");
                    return;
                }
                realPlayer.setXYaxis(2);
                QFSSearchVideoPlayHelper.this.G("#onVideoPrepared: start");
                if (QFSSearchVideoPlayHelper.this.f91209e != null) {
                    QFSSearchVideoPlayHelper.this.f91209e.p0(realPlayer);
                }
                QFSSearchVideoPlayHelper.this.f91210f.start();
                QFSSearchVideoPlayHelper.this.f91210f.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.ab
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSSearchVideoPlayHelper.VideoCallback.AnonymousClass1.this.k();
                    }
                });
            }

            @Override // java.lang.Runnable
            public void run() {
                QFSSearchVideoPlayHelper qFSSearchVideoPlayHelper = QFSSearchVideoPlayHelper.this;
                final RFWPlayer rFWPlayer = this.C;
                qFSSearchVideoPlayHelper.M(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.aa
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSSearchVideoPlayHelper.VideoCallback.AnonymousClass1.this.l(rFWPlayer);
                    }
                });
            }
        }

        VideoCallback() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            QFSSearchVideoPlayHelper.this.f91205a.setStatusPlay();
            QFSSearchPrerenderManager.E(QFSSearchVideoPlayHelper.this.f91210f.getContext()).w(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            QFSSearchVideoPlayHelper.this.f91205a.setStatusLoading();
            QFSSearchPrerenderManager.E(QFSSearchVideoPlayHelper.this.f91210f.getContext()).w(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(int i3) {
            if (!QFSSearchVideoPlayHelper.this.f91209e.onPlayError(i3)) {
                QCircleToast.j(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f171205d51), 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h() {
            View childAt = QFSSearchVideoPlayHelper.this.f91210f.getChildAt(0);
            if ((childAt instanceof ISPlayerVideoView) && childAt.getHeight() == 0) {
                QFSSearchVideoPlayHelper.this.G("#tryFixDeadViewTree: dead view tree");
                for (ViewParent viewParent = QFSSearchVideoPlayHelper.this.f91210f; viewParent != null; viewParent = viewParent.getParent()) {
                    viewParent.requestLayout();
                }
            }
        }

        private void i() {
            QFSSearchVideoPlayHelper.this.f91210f.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.z
                @Override // java.lang.Runnable
                public final void run() {
                    QFSSearchVideoPlayHelper.VideoCallback.this.h();
                }
            });
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public RFWPlayerReportInfo<e30.b> getBusinessReportInfo() {
            return null;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            return true;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            QFSSearchVideoPlayHelper.this.f91209e.onCompletion();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
            QFSSearchVideoPlayHelper.this.G("#onFirstFrameRendered");
            QFSSearchVideoPlayHelper.this.f91216l = true;
            QFSSearchVideoPlayHelper.this.f91209e.o0();
            QFSSearchVideoPlayHelper.this.f91210f.setOutPutMute(QFSSearchVideoPlayHelper.this.f91206b.H());
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
        public void onInitSuccess(RFWPlayer rFWPlayer) {
            QFSSearchVideoPlayHelper.this.G("#onInitSuccess");
            QFSSearchVideoPlayHelper.this.f91210f.setLoopBack(QFSSearchVideoPlayHelper.this.f91218n);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onProgress(String str, int i3, int i16) {
            if (i16 == QFSSearchVideoPlayHelper.this.f91213i) {
                return;
            }
            if (QFSSearchVideoPlayHelper.this.f91213i > i16) {
                QFSSearchVideoPlayHelper.this.f91209e.R();
            }
            QFSSearchVideoPlayHelper.this.f91216l = true;
            QFSSearchVideoPlayHelper.this.f91213i = i16;
            QFSSearchVideoPlayHelper.this.f91209e.c0(i3, i16);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener
        public void onSecondBufferEnd() {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.x
                @Override // java.lang.Runnable
                public final void run() {
                    QFSSearchVideoPlayHelper.VideoCallback.this.e();
                }
            });
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener
        public void onSecondBufferStart() {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.w
                @Override // java.lang.Runnable
                public final void run() {
                    QFSSearchVideoPlayHelper.VideoCallback.this.f();
                }
            });
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopEnd() {
            QFSSearchVideoPlayHelper.this.f91209e.onVideoLoopEnd();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopStart() {
            QFSSearchVideoPlayHelper.this.f91209e.onVideoLoopStart();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
        public void onVideoPlayError(int i3, int i16, final int i17, String str) {
            String str2;
            if (QFSSearchVideoPlayHelper.this.f91212h != null) {
                str2 = p.m(QFSSearchVideoPlayHelper.this.f91212h);
            } else {
                str2 = "";
            }
            QLog.w("QFSSearchVideoPlayHelper", 1, "#onVideoPlayError: module=" + i3 + ", errorType=" + i16 + ", errorCode=" + i17 + ", extraInfo=" + str + ", videoUrl=" + str2);
            QFSSearchVideoPlayHelper.this.f91210f.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.y
                @Override // java.lang.Runnable
                public final void run() {
                    QFSSearchVideoPlayHelper.VideoCallback.this.g(i17);
                }
            });
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            if (QFSSearchVideoPlayHelper.this.f91217m) {
                QFSVideoTaskRunner.e().a(new AnonymousClass1("videoView.start-" + QFSSearchVideoPlayHelper.this.hashCode(), rFWPlayer));
            } else {
                QFSSearchVideoPlayHelper.this.G("#onVideoPrepared: can not play 2, videoView visible=" + QFSSearchVideoPlayHelper.this.f91210f.isShown());
                QFSSearchVideoPlayHelper.this.H();
            }
            i();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        }
    }
}
