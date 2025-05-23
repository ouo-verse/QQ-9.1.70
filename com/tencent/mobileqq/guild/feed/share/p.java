package com.tencent.mobileqq.guild.feed.share;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView;
import com.tencent.mobileqq.guild.feed.video.GuildFeedVideoView;
import com.tencent.mobileqq.guild.media.floatwindow.FloatWindowPermissionHandler;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.SPlayerVideoView;

/* compiled from: P */
/* loaded from: classes13.dex */
public class p extends com.tencent.mobileqq.guild.feed.share.a {

    /* renamed from: h, reason: collision with root package name */
    private static final int f223410h = ScreenUtil.dip2px(50.0f);

    /* renamed from: d, reason: collision with root package name */
    private FloatWindowPermissionHandler f223411d;

    /* renamed from: e, reason: collision with root package name */
    private IVideoOuterStatusListener f223412e;

    /* renamed from: f, reason: collision with root package name */
    private GuildFeedVideoView f223413f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f223414g = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements FloatWindowPermissionHandler.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f223415a;

        a(String str) {
            this.f223415a = str;
        }

        @Override // com.tencent.mobileqq.guild.media.floatwindow.FloatWindowPermissionHandler.a
        public void a(boolean z16) {
            p.this.C(z16, this.f223415a);
            p.this.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b extends GuildPicStateListener {
        b(boolean z16) {
            super(z16);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, Option option) {
            if (loadState == LoadState.STATE_SUCCESS && p.this.f223412e != null) {
                p.this.f223412e.onSetVideoCover(option.getResultBitMap());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class c implements IVideoInnerStatusListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoClose(int i3) {
            QLog.d("GuildFeedPlayerFloatOpe", 1, "notifyVideoClose " + i3);
            p.this.H();
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoSeek(int i3) {
            QLog.d("GuildFeedPlayerFloatOpe", 1, "notifyVideoSeek seek " + i3);
            if (p.this.z() == null) {
                return;
            }
            p pVar = p.this;
            pVar.I((i3 * pVar.z().getDurationMs()) / 100);
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoStart() {
            ISuperPlayer z16 = p.this.z();
            if (z16 == null) {
                return;
            }
            long currentPositionMs = z16.getCurrentPositionMs();
            long durationMs = z16.getDurationMs();
            QLog.d("GuildFeedPlayerFloatOpe", 1, "current position " + currentPositionMs + " duration: " + durationMs);
            if (currentPositionMs < 0 || durationMs <= 0 || currentPositionMs > durationMs) {
                p.this.t();
                z16 = p.this.z();
            }
            if (p.this.f223412e != null && z16 != null) {
                z16.setLoopback(true);
                p.this.L();
                p.this.f223412e.onVideoStart((int) durationMs);
                QLog.d("GuildFeedPlayerFloatOpe", 1, "no more, player repeat");
                return;
            }
            QLog.e("GuildFeedPlayerFloatOpe", 1, "mOuterStatusListener or superPlayer is null " + z16);
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoStop() {
            QLog.d("GuildFeedPlayerFloatOpe", 1, "notifyVideoStop");
            p.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class d implements GuildBaseVideoView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f223419a;

        /* compiled from: P */
        /* loaded from: classes13.dex */
        class a extends com.tencent.mobileqq.guild.feed.video.c {
            a() {
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void a() {
                super.a();
                if (p.this.f223412e != null && p.this.z() != null) {
                    p.this.f223412e.onVideoStart((int) p.this.z().getDurationMs());
                }
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void b(String str, int i3, int i16) {
                super.b(str, i3, i16);
                if (p.this.f223412e != null) {
                    p.this.f223412e.onVideoProgressUpdate(i16);
                    jk1.b.INSTANCE.a().h(d.this.f223419a, i16);
                }
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void g(ISuperPlayer iSuperPlayer) {
                p.this.v(iSuperPlayer);
            }
        }

        d(String str) {
            this.f223419a = str;
        }

        @Override // com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView.b
        public void onInitSuccess() {
            p.this.f223413f.setBaseVideoViewListenerSets(new a());
            p.this.f223413f.setLoopBack(true);
            QLog.d("GuildFeedPlayerFloatOpe", 1, "onInitSuccess");
        }
    }

    private void B(@Nullable String str) {
        if (this.f223411d == null) {
            this.f223411d = new FloatWindowPermissionHandler(a());
        }
        if (!this.f223411d.e()) {
            this.f223411d.l(new a(str));
            this.f223411d.i();
        } else {
            C(true, str);
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z16, @Nullable String str) {
        boolean z17;
        if (!z16) {
            QLog.d("GuildFeedPlayerFloatOpe", 1, "handleFloatWindowPermissionResult failed");
            return;
        }
        GProStVideo video = b().f().getVideo();
        FloatingScreenParams.FloatingBuilder floatingBuilder = new FloatingScreenParams.FloatingBuilder();
        if (video.width > video.height) {
            z17 = true;
        } else {
            z17 = false;
        }
        FloatingScreenParams build = floatingBuilder.setIsHorizontal(z17).setCanMove(true).setCanZoom(false).build();
        t();
        SPlayerVideoView y16 = y();
        if (y16 == null) {
            QLog.e("GuildFeedPlayerFloatOpe", 1, "getPlayerVideoView still null, just ignore!");
            return;
        }
        int w3 = w(BaseApplication.getContext(), y16, build, 28, str);
        if (w3 == 1) {
            ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialog(a());
            return;
        }
        if (w3 != 0) {
            QLog.e("GuildFeedPlayerFloatOpe", 1, "handleFloatWindowPermissionResult enterFloatingScreen error, result: " + w3);
            return;
        }
        D(str);
        s(str);
        r();
        com.tencent.mobileqq.guild.picload.e.a().f(new Option().setUrl(video.cover.picUrl), new b(true));
    }

    private GuildBaseVideoView.b E(String str) {
        return new d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        GuildFeedVideoView guildFeedVideoView = this.f223413f;
        if (guildFeedVideoView != null) {
            guildFeedVideoView.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        GuildFeedVideoView guildFeedVideoView = this.f223413f;
        if (guildFeedVideoView != null) {
            guildFeedVideoView.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(long j3) {
        GuildFeedVideoView guildFeedVideoView = this.f223413f;
        if (guildFeedVideoView != null) {
            guildFeedVideoView.seek(j3);
        }
    }

    private void K(ImageView imageView) {
        RelativeLayout.LayoutParams layoutParams;
        int i3;
        int i16;
        if (imageView != null && (layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams()) != null && (i3 = layoutParams.topMargin) < (i16 = f223410h)) {
            layoutParams.setMargins(layoutParams.leftMargin, i3 + i16, layoutParams.rightMargin, layoutParams.bottomMargin);
            imageView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        GuildFeedVideoView guildFeedVideoView = this.f223413f;
        if (guildFeedVideoView != null) {
            guildFeedVideoView.start();
        }
    }

    private void r() {
        ImageView imageView;
        SPlayerVideoView y16 = y();
        if (y16 != null && y16.getParent() != null) {
            ViewParent parent = y16.getParent();
            if (!(parent instanceof FrameLayout) || (imageView = (ImageView) ((FrameLayout) parent).findViewById(R.id.m2l)) == null) {
                return;
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    private void s(@Nullable String str) {
        String a16;
        if (TextUtils.isEmpty(str)) {
            a16 = "com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper";
        } else {
            a16 = x.INSTANCE.a();
        }
        com.tencent.mobileqq.qqfloatingwindow.a floatingProxyWrapper = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).getFloatingProxyWrapper(a(), a16);
        if (floatingProxyWrapper == null) {
            return;
        }
        ImageView imageView = (ImageView) floatingProxyWrapper.A(R.id.m2p);
        ImageView imageView2 = (ImageView) floatingProxyWrapper.A(R.id.m2o);
        K(imageView);
        K(imageView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GuildFeedVideoView t() {
        H();
        com.tencent.mobileqq.guild.feed.share.c b16 = b();
        b16.f().setCurrentPlayPosition(jk1.b.INSTANCE.a().e(b16.f().getVideo()));
        GProStVideo video = b16.f().getVideo();
        int currentPosition = b16.f().getCurrentPosition();
        GuildFeedVideoView guildFeedVideoView = new GuildFeedVideoView(a());
        this.f223413f = guildFeedVideoView;
        guildFeedVideoView.setData(b16.f(), currentPosition);
        this.f223413f.setInitListener(E(x(video)));
        this.f223413f.setVideoWithExchangeUrl(video, currentPosition);
        return this.f223413f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        FloatWindowPermissionHandler floatWindowPermissionHandler = this.f223411d;
        if (floatWindowPermissionHandler == null) {
            return;
        }
        floatWindowPermissionHandler.f();
        this.f223411d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(ISuperPlayer iSuperPlayer) {
        if (this.f223413f == null) {
            return;
        }
        b().f().getVideo();
        iSuperPlayer.setXYaxis(0);
        this.f223413f.start();
        if (this.f223414g && a() != null) {
            a().finish();
        }
        QLog.d("GuildFeedPlayerFloatOpe", 1, "doOnVideoPrepare start play finishWhenViewPrepared:", Boolean.valueOf(this.f223414g));
    }

    private int w(Context context, View view, FloatingScreenParams floatingScreenParams, int i3, @Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).enterFloatingScreen(context, view, floatingScreenParams, i3);
        }
        return ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).enterFloatingScreen(context, view, floatingScreenParams, i3, str);
    }

    private String x(GProStVideo gProStVideo) {
        if (gProStVideo == null) {
            return "";
        }
        if (!TextUtils.isEmpty(gProStVideo.fileId)) {
            return gProStVideo.fileId;
        }
        return gProStVideo.playUrl;
    }

    private SPlayerVideoView y() {
        GuildFeedVideoView guildFeedVideoView = this.f223413f;
        if (guildFeedVideoView != null && guildFeedVideoView.o0() != null) {
            return (SPlayerVideoView) this.f223413f.o0().getVideoView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ISuperPlayer z() {
        GuildFeedVideoView guildFeedVideoView = this.f223413f;
        if (guildFeedVideoView != null) {
            return guildFeedVideoView.getSuperPlayer();
        }
        return null;
    }

    public void A(@Nullable String str) {
        if (b() != null && b().f() != null && a() != null) {
            B(str);
        } else {
            QLog.e("GuildFeedPlayerFloatOpe", 1, "operate, check the building params");
        }
    }

    public void D(@Nullable String str) {
        String a16;
        if (TextUtils.isEmpty(str)) {
            a16 = "com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper";
        } else {
            a16 = x.INSTANCE.a();
        }
        QLog.i("GuildFeedPlayerFloatOpe", 1, "[initFloatListener] ");
        IVideoOuterStatusListener floatingVideoListener = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(new c(), a16);
        this.f223412e = floatingVideoListener;
        if (floatingVideoListener != null) {
            floatingVideoListener.onVideoSize(b().f().getRenderWidth(), b().f().getRenderHeight());
        }
    }

    public void F() {
        A(null);
    }

    public void J(boolean z16) {
        this.f223414g = z16;
    }
}
