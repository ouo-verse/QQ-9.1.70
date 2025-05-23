package com.tencent.mobileqq.guild.feed.gallery.widget.item;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.biz.richframework.video.RFWBaseVideoUtils;
import com.tencent.libra.request.Option;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.api.impl.GuildFeedImagePreDecoder;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.event.GuildFeedVideoCurrentTimeEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryImmersiveEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryItemReLayoutEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryRateEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGallerySeekBarInitEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGallerySeekbarShowEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryShowContentEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.report.GuildFeedReportTable12003;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView;
import com.tencent.mobileqq.guild.feed.video.GuildFeedVideoPlayParamManager;
import com.tencent.mobileqq.guild.feed.video.GuildFeedVideoView;
import com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImageUrl;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jk1.b;
import mj1.c;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildBannerVideoItemViewV2 extends GuildBaseWidgetView<GuildFeedRichMediaData> implements c.b, SimpleEventReceiver {
    private SeekBar C;
    private View D;
    private FrameLayout E;
    private TextView F;
    private TextView G;
    private LinearLayout H;
    private ImageView I;
    private Boolean J;
    private int K;
    private int L;
    private int M;
    private int N;
    private String P;
    private boolean Q;
    private long R;
    private long S;
    private boolean T;
    private com.tencent.biz.qqcircle.widgets.multitouchimg.d U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f219910a0;

    /* renamed from: b0, reason: collision with root package name */
    private View.OnLayoutChangeListener f219911b0;

    /* renamed from: d, reason: collision with root package name */
    public GuildFeedRichMediaData f219912d;

    /* renamed from: e, reason: collision with root package name */
    public GProStVideo f219913e;

    /* renamed from: f, reason: collision with root package name */
    public GProStFeed f219914f;

    /* renamed from: h, reason: collision with root package name */
    private int f219915h;

    /* renamed from: i, reason: collision with root package name */
    private GuildFeedVideoView f219916i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f219917m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        private float f219919d;

        /* renamed from: e, reason: collision with root package name */
        private float f219920e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f219921f = false;

        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        
            if (r4 != 3) goto L18;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            GuildBannerVideoItemViewV2.this.E.requestDisallowInterceptTouchEvent(true);
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (Math.abs(motionEvent.getX() - this.f219919d) <= Math.abs(motionEvent.getY() - this.f219920e)) {
                            return true;
                        }
                        this.f219921f = true;
                        GuildBannerVideoItemViewV2.this.C.onTouchEvent(motionEvent);
                    }
                }
                if (this.f219921f) {
                    GuildBannerVideoItemViewV2.this.C.onTouchEvent(motionEvent);
                }
            } else {
                this.f219919d = motionEvent.getX();
                this.f219920e = motionEvent.getY();
                this.f219921f = false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements GuildBaseVideoView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f219923a;

        /* compiled from: P */
        /* loaded from: classes13.dex */
        class a extends com.tencent.mobileqq.guild.feed.video.c {
            a() {
            }

            private void h(boolean z16) {
                QLog.i(GuildBannerVideoItemViewV2.this.getTag(), 1, "[onSeekBarDragStateChanged] isUnderDragState: " + z16);
                j(z16);
                k(z16);
                i(z16);
            }

            private void i(boolean z16) {
                SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryShowContentEvent(!z16, GuildBannerVideoItemViewV2.this.f219914f.idd));
            }

            private void j(boolean z16) {
                int i3;
                if (z16) {
                    i3 = R.dimen.ce6;
                } else {
                    i3 = R.dimen.ce7;
                }
                int dimensionPixelSize = GuildBannerVideoItemViewV2.this.getResources().getDimensionPixelSize(i3);
                if (Build.VERSION.SDK_INT >= 29) {
                    GuildBannerVideoItemViewV2.this.C.setMaxHeight(dimensionPixelSize);
                    GuildBannerVideoItemViewV2.this.C.setMinHeight(dimensionPixelSize);
                }
            }

            private void k(boolean z16) {
                int i3;
                LinearLayout linearLayout = GuildBannerVideoItemViewV2.this.H;
                if (z16) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                linearLayout.setVisibility(i3);
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void a() {
                QLog.d(GuildBannerVideoItemViewV2.this.getTag(), 1, "pos: " + GuildBannerVideoItemViewV2.this.f219915h + ", firstFrameRenderCallBack");
                GuildBannerVideoItemViewV2.this.H0(true);
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void b(String str, int i3, int i16) {
                GuildFeedVideoPlayParamManager guildFeedVideoPlayParamManager = GuildFeedVideoPlayParamManager.f223979d;
                GuildBannerVideoItemViewV2 guildBannerVideoItemViewV2 = GuildBannerVideoItemViewV2.this;
                guildFeedVideoPlayParamManager.h(guildBannerVideoItemViewV2.P0(guildBannerVideoItemViewV2.f219913e), i16);
                b bVar = b.this;
                GuildBannerVideoItemViewV2.this.I0(i3, i16, bVar.f219923a);
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void c(SeekBar seekBar, int i3, boolean z16) {
                GuildBannerVideoItemViewV2.this.J0(seekBar, i3, z16);
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void d(SeekBar seekBar) {
                QLog.d(GuildBannerVideoItemViewV2.this.getTag(), 4, "[onStartTrackingTouch] ");
                h(true);
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void e(SeekBar seekBar) {
                QLog.d(GuildBannerVideoItemViewV2.this.getTag(), 4, "[onStopTrackingTouch] ");
                h(false);
                GuildBannerVideoItemViewV2.this.q1();
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void g(ISuperPlayer iSuperPlayer) {
                QLog.d(GuildBannerVideoItemViewV2.this.getTag(), 1, "pos: " + GuildBannerVideoItemViewV2.this.f219915h + ", onVideoPrepared");
                GuildBannerVideoItemViewV2.this.K0(iSuperPlayer);
            }
        }

        b(String str) {
            this.f219923a = str;
        }

        @Override // com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView.b
        public void onInitSuccess() {
            GuildBannerVideoItemViewV2.this.f219916i.setBaseVideoViewListenerSets(new a());
            GuildBannerVideoItemViewV2.this.f219916i.setProgressBar(GuildBannerVideoItemViewV2.this.C);
            GuildBannerVideoItemViewV2.this.f219916i.setLoadingView(GuildBannerVideoItemViewV2.this.D);
            GuildBannerVideoItemViewV2.this.f219916i.setVideoCover(GuildBannerVideoItemViewV2.this.f219917m);
            GuildBannerVideoItemViewV2.this.f219916i.setLoopBack(true);
            GuildBannerVideoItemViewV2.this.f219916i.setOutPutMute(GuildBannerVideoItemViewV2.this.b1());
            QLog.d(GuildBannerVideoItemViewV2.this.getTag(), 1, "onInitSuccess");
        }
    }

    public GuildBannerVideoItemViewV2(@NonNull Context context) {
        super(context);
        this.J = Boolean.FALSE;
        this.Q = false;
        this.R = 0L;
        this.S = 0L;
        this.T = false;
        this.V = -1;
        this.f219910a0 = false;
        this.f219911b0 = new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.item.i
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                GuildBannerVideoItemViewV2.this.f1(view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        };
        a1(this);
    }

    private void D0() {
        GProStVideo gProStVideo = this.f219913e;
        int i3 = gProStVideo.width;
        int i16 = gProStVideo.height;
        QLog.i(getTag(), 1, "[adjustViewSize] videoWidth=" + i3 + ", videoHeight=" + i16);
        ax.c(this.f219916i, i3, i16);
        ax.c(this.f219917m, i3, i16);
    }

    private void E0() {
        if (this.f219917m == null) {
            return;
        }
        GProStImage gProStImage = this.f219913e.cover;
        String str = gProStImage.picUrl;
        int i3 = gProStImage.width;
        int i16 = gProStImage.height;
        if (TextUtils.isEmpty(str)) {
            List<GProStImageUrl> n3 = bm.n(this.f219913e.cover);
            if (!n3.isEmpty()) {
                str = n3.get(0).url;
                i3 = n3.get(0).width;
                i16 = n3.get(0).height;
            }
        }
        if (TextUtils.isEmpty(str)) {
            QLog.w(getTag(), 1, "can't find video cover! fileId=" + this.f219913e.fileId + " playUrl=" + this.f219913e.playUrl);
            return;
        }
        this.f219917m.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Option b16 = com.tencent.mobileqq.guild.feed.gallery.b.b(str, i3, i16, false);
        BitmapDrawable bitmapDrawable = GuildFeedImagePreDecoder.INSTANCE.get(bm.a(this.f219913e.cover));
        if (bitmapDrawable != null) {
            QLog.i(getTag(), 1, "[preloadBitmap] hit video " + this.f219913e.cover.picUrl);
            b16.setLoadingDrawable(bitmapDrawable);
            this.f219917m.setImageDrawable(b16.getLoadingDrawable());
        }
        b16.setTargetView(this.f219917m);
        com.tencent.mobileqq.guild.picload.e.a().f(b16, null);
        this.f219917m.setTag(R.id.w8w, b16);
        mk1.b.f416885a.a(getContext().hashCode()).a(b16);
    }

    private boolean G0() {
        if (c1() && this.f219916i != null) {
            return false;
        }
        QLog.d(getTag(), 4, "[canNotPlay] isOnScreen()=" + c1() + ", mPlayView=" + this.f219916i);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(boolean z16) {
        if (z16) {
            this.f219917m.setVisibility(8);
            this.C.setVisibility(0);
        } else {
            this.f219917m.setVisibility(0);
            this.C.setVisibility(8);
        }
        s1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(int i3, int i16, String str) {
        if (!TextUtils.isEmpty(str) && i16 == this.K && this.L == i3) {
            return;
        }
        if (!c1()) {
            QLog.w(getTag(), 1, "[doOnProgress] currently invisible. pausePlayer");
            l1();
            return;
        }
        GuildFeedVideoView guildFeedVideoView = this.f219916i;
        if (guildFeedVideoView != null && guildFeedVideoView.getChildAt(0) != null && this.f219916i.getChildAt(0).getWidth() == 0) {
            this.T = true;
            SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryItemReLayoutEvent());
        }
        synchronized (GuildBannerVideoItemViewV2.class) {
            b.Companion companion = jk1.b.INSTANCE;
            if (i16 != companion.a().f(str)) {
                if (Math.abs(i3 - i16) <= 2000) {
                    i16 = 0;
                }
                companion.a().h(str, i16);
            }
        }
        this.K = i16;
        this.L = i3;
        if (this.R <= 0) {
            this.R = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(SeekBar seekBar, int i3, boolean z16) {
        TextView textView = this.G;
        if (textView != null && z16) {
            RFWTypefaceUtil.setNumberTypeface(textView, false);
            this.G.setText(RFWBaseVideoUtils.getSocialMinSeconds(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(final ISuperPlayer iSuperPlayer) {
        if (c1() && this.f219916i != null && this.f219912d != null) {
            L0();
            r1("doOnVideoPrepare");
            QLog.i(getTag(), 1, "[doOnVideoPrepare] videoWidth=" + iSuperPlayer.getVideoWidth() + ", videoHeight=" + iSuperPlayer.getVideoHeight());
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.item.GuildBannerVideoItemViewV2.3
                @Override // java.lang.Runnable
                public void run() {
                    if (GuildBannerVideoItemViewV2.this.F != null) {
                        RFWTypefaceUtil.setNumberTypeface(GuildBannerVideoItemViewV2.this.F, false);
                        GuildBannerVideoItemViewV2.this.F.setText(RFWBaseVideoUtils.getSocialMinSeconds((int) iSuperPlayer.getDurationMs()));
                        GuildBannerVideoItemViewV2.this.M = RFWBaseVideoUtils.getSocialSeconds((int) iSuperPlayer.getDurationMs());
                    }
                }
            });
        }
    }

    private void L0() {
        String pageForumType;
        GuildFeedVideoView guildFeedVideoView = this.f219916i;
        if (guildFeedVideoView != null && this.f219912d != null && this.f219914f != null && this.P != null) {
            GuildFeedBaseInitBean q16 = ax.q(guildFeedVideoView.getContext());
            GProStFeed gProStFeed = this.f219914f;
            if (q16 == null) {
                pageForumType = "";
            } else {
                pageForumType = q16.getPageForumType(q16.getPageId());
            }
            Map<String, ?> d16 = com.tencent.mobileqq.guild.feed.report.f.d(gProStFeed, pageForumType);
            if (q16 instanceof GuildFeedGalleryInitBean) {
                d16.putAll(mk1.e.c((GuildFeedGalleryInitBean) q16));
            }
            d16.put("video_length", Integer.valueOf(this.M));
            d16.put(QCircleLpReportDc05507.KEY_VIDEO_PLAY_TIME, Integer.valueOf(this.L));
            d16.put("video_end_type", "3");
            d16.put(QzoneCameraConst.Tag.ARG_PARAM_VIDEO_START_TIME, Integer.valueOf(this.N));
            d16.put(QzoneCameraConst.Tag.ARG_PARAM_VIDEO_END_TIME, Long.valueOf(System.currentTimeMillis()));
            VideoEntity build = new VideoEntity.Builder().setContentId(String.valueOf(this.f219914f.meta.content.ContentID)).setPage((Object) this.P).setContentType(2).setVideoDuration(this.M).setVideoView((View) this.f219916i).addCustomParams(d16).ignoreReport(false).bizReady(true).build();
            ISuperPlayer superPlayer = this.f219916i.getSuperPlayer();
            if (superPlayer != null) {
                VideoReport.bindVideoPlayerInfo(superPlayer, build);
                QLog.i(getTag(), 1, "dtReportBindVideoData");
            }
        }
    }

    private void M0() {
        if (G0()) {
            return;
        }
        QLog.d(getTag(), 1, "executeFromSelected");
        p1(true);
    }

    private void N0(boolean z16) {
        if (G0()) {
            QLog.d(getTag(), 4, "[executePlay] 01 return, canNotPlay");
            return;
        }
        if (this.f219916i.getSuperPlayer() == null) {
            p1(z16);
            return;
        }
        if (this.f219916i.getSuperPlayer().isPlaying()) {
            QLog.d(getTag(), 4, "[executePlay] 02 return, isPlaying");
        } else {
            if (this.f219916i.getSuperPlayer().isPausing()) {
                r1("executePlay");
                H0(true);
                QLog.d(getTag(), 4, "[executePlay] 03 return, isPausing");
                return;
            }
            p1(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String P0(GProStVideo gProStVideo) {
        return jk1.b.INSTANCE.a().d(gProStVideo);
    }

    private void Q0(GuildFeedGalleryImmersiveEvent.NotifyVerticalPageSelectedEvent notifyVerticalPageSelectedEvent) {
        this.V = notifyVerticalPageSelectedEvent.getVerticalPosition();
        QLog.d(getTag(), 4, "[handleNotifyVerticalPageSelectedEvent] mEventVerticalPosition=" + this.V);
    }

    private void S0(GuildFeedGalleryRateEvent guildFeedGalleryRateEvent) {
        setPlayRate(guildFeedGalleryRateEvent.getRate());
    }

    private boolean T0() {
        if (this.f219916i == null || !this.J.booleanValue() || this.f219916i.r0()) {
            return false;
        }
        QLog.w(getTag(), 1, "handleReAttachedStatusError");
        E0();
        H0(false);
        this.f219916i.setHasPaused(true);
        s1();
        return true;
    }

    private void U0(GuildFeedGallerySeekbarShowEvent guildFeedGallerySeekbarShowEvent) {
        int i3;
        QLog.i("BaseWidgetView", 4, "handleSeekbarShowEvent toShow=" + guildFeedGallerySeekbarShowEvent.getToShow());
        SeekBar seekBar = this.C;
        if (guildFeedGallerySeekbarShowEvent.getToShow()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        seekBar.setVisibility(i3);
    }

    private void V0(GuildFeedVideoCurrentTimeEvent guildFeedVideoCurrentTimeEvent) {
        if (guildFeedVideoCurrentTimeEvent.getFiledId().equals(this.f219912d.getVideo().fileId)) {
            jk1.b.INSTANCE.a().g(this.f219912d.getVideo(), (int) guildFeedVideoCurrentTimeEvent.getCurrentTime());
        }
    }

    private void W0(View view) {
        this.f219917m = (ImageView) view.findViewById(R.id.wcn);
    }

    private void X0() {
        this.L = 0;
        this.K = 0;
    }

    private void Y0() {
        this.f219916i.setLoadingView(this.D);
        this.f219916i.setProgressBar(this.C);
        o1();
    }

    private void Z0() {
        ViewGroup viewGroup;
        if (getRootView() != null && (viewGroup = (ViewGroup) getRootView().findViewById(R.id.ulf)) != null) {
            viewGroup.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.item.j
                @Override // java.lang.Runnable
                public final void run() {
                    GuildBannerVideoItemViewV2.this.e1();
                }
            });
        }
    }

    private void a() {
        if (this.f219916i == null) {
            return;
        }
        if (this.R > 0 && this.S <= 0) {
            this.S = System.currentTimeMillis();
        }
        QLog.i(getTag(), 1, "[releasePlayer] start");
        this.T = false;
        t1();
        VideoReport.unbindVideoPlayerInfo(this.f219916i);
        H0(false);
        this.f219916i.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b1() {
        return false;
    }

    private boolean c1() {
        if (!this.Q && !isShown()) {
            return false;
        }
        return true;
    }

    private boolean d1() {
        if (this.V == this.W) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e1() {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGallerySeekBarInitEvent(this.E));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f1(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (this.f219910a0) {
            n1(false);
            QLog.e(getTag(), 1, "[OnLayoutChangeListener]->adjustViewSize()");
            D0();
        }
    }

    private GuildBaseVideoView.b h1(String str) {
        return new b(str);
    }

    private void l1() {
        GuildFeedVideoView guildFeedVideoView = this.f219916i;
        if (guildFeedVideoView != null && guildFeedVideoView.getSuperPlayer() != null) {
            this.T = false;
            boolean isPlaying = this.f219916i.getSuperPlayer().isPlaying();
            QLog.i(getTag(), 1, "[pausePlayer] last playState: isPlaying[" + isPlaying + "]");
            if (isPlaying) {
                VideoReport.unbindVideoPlayerInfo(this.f219916i);
                this.f219916i.pause();
                this.I.setVisibility(0);
                this.S = System.currentTimeMillis();
                t1();
            }
        }
    }

    private void n1(boolean z16) {
        this.f219910a0 = z16;
    }

    private void o1() {
        this.E.setOnTouchListener(new a());
    }

    private void p1(boolean z16) {
        if (this.f219912d == null) {
            return;
        }
        QLog.e(getTag(), 1, "[startANewPlayer] start play mEventVerticalPosition=" + this.V + ", mDisplayVerticalPosition=" + this.W + "------------------------------------------------->");
        this.f219916i.setData(this.f219912d, this.f219915h);
        String P0 = P0(this.f219913e);
        long d16 = (long) GuildFeedVideoPlayParamManager.f223979d.d(P0);
        synchronized (GuildBannerVideoItemViewV2.class) {
            QLog.d(getTag(), 1, "startANewPlayer videoKey:" + P0 + ", continuePlay: " + z16 + APLogFileUtil.SEPARATOR_LOG + hashCode() + ", globalOffset: " + d16);
            if (d16 == 0) {
                if (z16 && !TextUtils.isEmpty(P0)) {
                    d16 = jk1.b.INSTANCE.a().f(P0);
                } else {
                    d16 = 0;
                }
            }
        }
        this.f219916i.setInitListener(h1(P0));
        this.f219916i.setVideoWithExchangeUrl(this.f219913e, (int) d16);
        this.I.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1() {
        GuildFeedVideoView guildFeedVideoView = this.f219916i;
        if (guildFeedVideoView != null && guildFeedVideoView.getSuperPlayer() != null && this.f219916i.getSuperPlayer().isPausing()) {
            QLog.i("BaseWidgetView", 1, "startPlayIfPaused");
            N0(true);
        }
    }

    private void r1(@Nullable String str) {
        if (!c1()) {
            QLog.w(getTag(), 1, "[startPlayer] ignore. not on screen");
            return;
        }
        this.T = false;
        QLog.i(getTag(), 1, "[startPlayer] source: " + str);
        this.f219916i.start();
        this.R = System.currentTimeMillis();
    }

    private void s1() {
        if (!this.f219916i.r0()) {
            this.I.setVisibility(8);
        } else {
            this.I.setVisibility(0);
        }
    }

    private void setPlayRate(float f16) {
        GuildFeedVideoView guildFeedVideoView = this.f219916i;
        if (guildFeedVideoView != null && f16 > 0.0f && guildFeedVideoView.getSuperPlayer() != null) {
            if (!this.f219916i.getSuperPlayer().isPlaying()) {
                this.f219916i.start();
                s1();
            }
            this.f219916i.setPlayRate(f16);
        }
    }

    private void t1() {
        String str;
        int i3;
        String str2;
        if (this.f219914f == null || (str = this.P) == null || "pg_group_sgrp_forum_viewer_feeds".equals(str)) {
            return;
        }
        long j3 = this.R;
        if (j3 > 0) {
            long j16 = this.S;
            if (j16 > 0) {
                long j17 = j16 - j3;
                if (j17 > 0 && j17 <= 86400000) {
                    GuildFeedBaseInitBean q16 = ax.q(this.f219916i.getContext());
                    if (q16 != null) {
                        str2 = q16.getPageForumType(q16.getPageId());
                        i3 = q16.getImmersiveSource();
                    } else {
                        i3 = 6;
                        str2 = "";
                    }
                    GuildFeedReportTable12003.b(new GuildFeedReportTable12003.a(com.tencent.mobileqq.guild.feed.report.f.b(this.f219914f, str2).K("play_video").J("success").p0(String.valueOf(this.M)).c0(String.valueOf(j17)).d0("2").X(String.valueOf(i3)).Y(this.P)));
                    if (QLog.isColorLevel()) {
                        QLog.d(getTag(), 1, "videoPlayReport playDuration " + j17 + ", ");
                    }
                    this.S = 0L;
                    this.R = 0L;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public void bindData(GuildFeedRichMediaData guildFeedRichMediaData, int i3) {
        if (guildFeedRichMediaData == null) {
            return;
        }
        if (guildFeedRichMediaData.getPageId() != null) {
            this.P = guildFeedRichMediaData.getPageId();
        }
        this.f219912d = guildFeedRichMediaData;
        this.f219915h = i3;
        this.f219913e = guildFeedRichMediaData.getVideo();
        X0();
        this.I.setVisibility(8);
        E0();
        H0(false);
    }

    public ImageView O0() {
        return this.f219917m;
    }

    @Override // mj1.c.b
    public void X(int i3) {
        l1();
        this.J = Boolean.FALSE;
    }

    protected void a1(View view) {
        this.f219916i = (GuildFeedVideoView) view.findViewById(R.id.x4k);
        this.C = (SeekBar) view.findViewById(R.id.wuj);
        this.D = view.findViewById(R.id.x4i);
        this.E = (FrameLayout) view.findViewById(R.id.wzr);
        this.F = (TextView) view.findViewById(R.id.f165645x41);
        this.G = (TextView) view.findViewById(R.id.f165640x32);
        this.H = (LinearLayout) view.findViewById(R.id.wou);
        W0(view);
        this.I = (ImageView) view.findViewById(R.id.f165520wg0);
        this.N = ((int) System.currentTimeMillis()) / 1000;
        Y0();
    }

    public boolean g1() {
        return this.T;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedVideoCurrentTimeEvent.class);
        arrayList.add(GuildFeedGallerySeekbarShowEvent.class);
        arrayList.add(GuildFeedGalleryRateEvent.class);
        arrayList.add(GuildFeedGalleryImmersiveEvent.NotifyVerticalPageSelectedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.enh;
    }

    public void i1() {
        ImageView imageView = this.f219917m;
        if (imageView != null) {
            Object tag = imageView.getTag(R.id.w8w);
            if (tag instanceof Option) {
                Option option = (Option) tag;
                this.f219917m.setImageResource(R.drawable.f162601b70);
                com.tencent.mobileqq.guild.picload.e.a().h(option);
                mk1.b.f416885a.a(getContext().hashCode()).c(option);
            }
        }
    }

    public void j1() {
        this.J = Boolean.FALSE;
        a();
        i1();
    }

    public void k1() {
        if (this.f219916i.r0()) {
            if (this.f219916i.getSuperPlayer() != null && this.f219916i.getSuperPlayer().isPausing()) {
                r1(NodeProps.ON_CLICK);
            } else {
                QLog.i(getTag(), 1, "[onSingleClick] Player is invalid ! do executePlay");
                N0(true);
            }
            this.J = Boolean.FALSE;
        } else {
            l1();
            this.J = Boolean.TRUE;
        }
        s1();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        if (QLog.isColorLevel()) {
            QLog.e(getTag(), 1, NodeProps.ON_ATTACHED_TO_WINDOW);
        }
        n1(true);
        addOnLayoutChangeListener(this.f219911b0);
        SimpleEventBus.getInstance().registerReceiver(this);
        m1();
        T0();
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (QLog.isColorLevel()) {
            QLog.e(getTag(), 1, "[onConfigurationChanged]-");
        }
        n1(true);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (QLog.isColorLevel()) {
            QLog.e(getTag(), 1, NodeProps.ON_DETACHED_FROM_WINDOW);
        }
        removeOnLayoutChangeListener(this.f219911b0);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public void onPause() {
        QLog.i(getTag(), 1, "[onPause] start");
        this.Q = false;
        l1();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFeedVideoCurrentTimeEvent) {
            V0((GuildFeedVideoCurrentTimeEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedGallerySeekbarShowEvent) {
            U0((GuildFeedGallerySeekbarShowEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildFeedGalleryRateEvent) {
            S0((GuildFeedGalleryRateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildFeedGalleryImmersiveEvent.NotifyVerticalPageSelectedEvent) {
            Q0((GuildFeedGalleryImmersiveEvent.NotifyVerticalPageSelectedEvent) simpleBaseEvent);
        }
    }

    public void onResume() {
        QLog.w(getTag(), 1, "[onResume] 01 start mEventVerticalPosition=" + this.V + ", mDisplayVerticalPosition=" + this.W);
        m1();
        if (!d1()) {
            QLog.w(getTag(), 1, "[onResume] 02 isVerticalCurrentPagerShown =" + d1());
        }
        this.Q = true;
        if (!this.J.booleanValue()) {
            QLog.e(getTag(), 1, "[onResume] 03 executePlay~");
            N0(true);
        }
        Z0();
    }

    @Override // mj1.c.b
    public void onSelected(int i3) {
        QLog.d(getTag(), 1, "onSelected, itemPos: " + this.f219915h + ", curPos: " + i3);
        this.J = Boolean.FALSE;
        if (this.f219915h == i3) {
            M0();
        } else {
            l1();
        }
    }

    public void setDisplayVerticalPosition(int i3) {
        this.W = i3;
        QLog.d(getTag(), 4, "[setDisplayVerticalPosition] mDisplayVerticalPosition=" + this.W);
    }

    public void setExtraOnDoubleTapListener(com.tencent.biz.qqcircle.widgets.multitouchimg.d dVar) {
        this.U = dVar;
    }

    public void setFeedInfo(GProStFeed gProStFeed) {
        this.f219914f = gProStFeed;
    }

    @Override // android.view.View
    public String getTag() {
        return "Guild_Feed_GAL_GuildFeedVideoItemView2_" + hashCode();
    }

    private void m1() {
    }
}
