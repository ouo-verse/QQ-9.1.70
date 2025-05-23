package com.tencent.mobileqq.guild.feed.detail.banner.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.biz.richframework.video.RFWBaseVideoUtils;
import com.tencent.libra.request.Option;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.multitouchimg.MultiTouchImageView;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.detail.banner.item.GuildBannerVideoItemView;
import com.tencent.mobileqq.guild.feed.event.GuildFeedVideoCurrentTimeEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedFullScreenBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.part.GuildFeedGalleryPreloadPart;
import com.tencent.mobileqq.guild.feed.report.GuildFeedReportTable12003;
import com.tencent.mobileqq.guild.feed.report.f;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView;
import com.tencent.mobileqq.guild.feed.video.GuildFeedVideoView;
import com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.util.ImageViewPorterDuffUtils;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImageUrl;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mj1.c;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildBannerVideoItemView extends GuildBaseWidgetView<GuildFeedRichMediaData> implements c.b, View.OnClickListener, SimpleEventReceiver {
    private static volatile ConcurrentHashMap<String, Long> V = new ConcurrentHashMap<>();
    private SeekBar C;
    private View D;
    private FrameLayout E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private ImageView J;
    private Boolean K;
    private ImageView L;
    private int M;
    private int N;
    private int P;
    private int Q;
    private String R;
    private boolean S;
    private View T;
    private int U;

    /* renamed from: d, reason: collision with root package name */
    public GuildFeedRichMediaData f218461d;

    /* renamed from: e, reason: collision with root package name */
    public GProStVideo f218462e;

    /* renamed from: f, reason: collision with root package name */
    public GProStFeed f218463f;

    /* renamed from: h, reason: collision with root package name */
    private int f218464h;

    /* renamed from: i, reason: collision with root package name */
    private GuildFeedVideoView f218465i;

    /* renamed from: m, reason: collision with root package name */
    private MultiTouchImageView f218466m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GuildBannerVideoItemView.this.f218461d != null) {
                GuildFeedFullScreenBean guildFeedFullScreenBean = new GuildFeedFullScreenBean();
                guildFeedFullScreenBean.setVideoCurrentPosition(GuildBannerVideoItemView.this.M);
                guildFeedFullScreenBean.setFeed(GuildBannerVideoItemView.this.f218463f);
                guildFeedFullScreenBean.setVideo(GuildBannerVideoItemView.this.f218462e);
                GuildFeedLauncher.v(view.getContext(), guildFeedFullScreenBean);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            GuildBannerVideoItemView.this.E.requestDisallowInterceptTouchEvent(true);
            GuildBannerVideoItemView.this.C.onTouchEvent(motionEvent);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class c implements GuildBaseVideoView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f218470a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes13.dex */
        public class a extends com.tencent.mobileqq.guild.feed.video.c {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void j(ISuperPlayer iSuperPlayer) {
                if (iSuperPlayer.isPausing()) {
                    QLog.i("GuildFeedVideoItemView", 1, "startPlayIfPaused");
                    GuildBannerVideoItemView.this.M0(true);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void k(GuildFeedVideoView guildFeedVideoView) {
                ax.J(guildFeedVideoView.getSuperPlayer(), new Consumer() { // from class: com.tencent.mobileqq.guild.feed.detail.banner.item.d
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        GuildBannerVideoItemView.c.a.this.j((ISuperPlayer) obj);
                    }
                });
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void a() {
                QLog.d("GuildFeedVideoItemView", 1, "pos: " + GuildBannerVideoItemView.this.f218464h + ", firstFrameRenderCallBack");
                GuildBannerVideoItemView.this.G0(true);
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void b(String str, int i3, int i16) {
                c cVar = c.this;
                GuildBannerVideoItemView.this.H0(i3, i16, cVar.f218470a);
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void c(SeekBar seekBar, int i3, boolean z16) {
                GuildBannerVideoItemView.this.I0(seekBar, i3, z16);
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void d(SeekBar seekBar) {
                GuildBannerVideoItemView.this.c1(seekBar);
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void e(SeekBar seekBar) {
                ax.J(GuildBannerVideoItemView.this.f218465i, new Consumer() { // from class: com.tencent.mobileqq.guild.feed.detail.banner.item.c
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        GuildBannerVideoItemView.c.a.this.k((GuildFeedVideoView) obj);
                    }
                });
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void g(ISuperPlayer iSuperPlayer) {
                QLog.d("GuildFeedVideoItemView", 1, "pos: " + GuildBannerVideoItemView.this.f218464h + ", onVideoPrepared");
                GuildBannerVideoItemView.this.J0(iSuperPlayer);
            }
        }

        c(String str) {
            this.f218470a = str;
        }

        @Override // com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView.b
        public void onInitSuccess() {
            GuildBannerVideoItemView.this.f218465i.setBaseVideoViewListenerSets(new a());
            GuildBannerVideoItemView.this.f218465i.setProgressBar(GuildBannerVideoItemView.this.C);
            GuildBannerVideoItemView.this.f218465i.setLoadingView(GuildBannerVideoItemView.this.D);
            GuildBannerVideoItemView.this.f218465i.setVideoCover(GuildBannerVideoItemView.this.f218466m);
            GuildBannerVideoItemView.this.f218465i.setLoopBack(true);
            GuildBannerVideoItemView.this.f218465i.setOutPutMute(GuildBannerVideoItemView.this.Y0());
            QLog.d("GuildFeedVideoItemView", 1, "onInitSuccess");
        }
    }

    public GuildBannerVideoItemView(@NonNull Context context) {
        super(context);
        this.K = Boolean.FALSE;
        this.S = true;
        X0(this);
    }

    private void C0() {
        GProStVideo gProStVideo = this.f218462e;
        int i3 = gProStVideo.width;
        int i16 = gProStVideo.height;
        e1(ax.d(this.f218466m, i3, i16));
        ax.d(this.f218465i, i3, i16);
    }

    private void D0() {
        if (this.f218466m == null) {
            return;
        }
        GProStImage gProStImage = this.f218462e.cover;
        String str = gProStImage.picUrl;
        int i3 = gProStImage.width;
        int i16 = gProStImage.height;
        if (TextUtils.isEmpty(str)) {
            List<GProStImageUrl> n3 = bm.n(this.f218462e.cover);
            if (!n3.isEmpty()) {
                str = n3.get(0).url;
                i3 = n3.get(0).width;
                i16 = n3.get(0).height;
            }
        }
        if (TextUtils.isEmpty(str)) {
            QLog.w("GuildFeedVideoItemView", 1, "can't find video cover! fileId=" + this.f218462e.fileId + " playUrl=" + this.f218462e.playUrl);
            return;
        }
        this.f218466m.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int instantScreenWidth = DisplayUtil.getInstantScreenWidth(this.f218466m.getContext());
        int instantScreenHeight = DisplayUtil.getInstantScreenHeight(this.f218466m.getContext());
        e.a().f(new Option().setTargetView(this.f218466m).setUrl(str).setLoadingDrawable(Q0()).setRequestWidth(Math.min(instantScreenWidth, i3)).setRequestWidth(Math.min(instantScreenHeight, i16)).setPredecode(true), null);
    }

    private boolean F0() {
        if (Z0() && this.f218465i != null) {
            return false;
        }
        QLog.d("GuildFeedVideoItemView", 1, "mFeedIoc == null");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(boolean z16) {
        if (z16) {
            this.f218466m.setVisibility(8);
            this.C.setVisibility(0);
            this.I.setVisibility(0);
            this.H.setVisibility(0);
            this.L.setVisibility(0);
        } else {
            this.f218466m.setVisibility(0);
            this.C.setVisibility(8);
            this.I.setVisibility(8);
            this.H.setVisibility(8);
            this.L.setVisibility(8);
        }
        f1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(int i3, int i16, String str) {
        if (!TextUtils.isEmpty(str) && i16 == this.M && this.N == i3) {
            return;
        }
        this.I.setText(RFWBaseVideoUtils.getSocialMinSeconds(i16));
        synchronized (GuildBannerVideoItemView.class) {
            Long l3 = V.get(str);
            if (l3 == null || i16 != l3.longValue()) {
                if (Math.abs(i3 - i16) <= 2000) {
                    i16 = 0;
                }
                V.put(str, Long.valueOf(i16));
            }
        }
        this.M = i16;
        this.N = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(SeekBar seekBar, int i3, boolean z16) {
        TextView textView = this.G;
        if (textView != null && z16) {
            RFWTypefaceUtil.setNumberTypeface(textView, false);
            this.G.setText(RFWBaseVideoUtils.getSocialMinSeconds(i3) + " / ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(final ISuperPlayer iSuperPlayer) {
        if (Z0() && this.f218465i != null && this.f218461d != null) {
            GProStVideo gProStVideo = this.f218462e;
            if (RFWBaseVideoUtils.shouldVideoYFullScreen(gProStVideo.width, gProStVideo.height)) {
                iSuperPlayer.setXYaxis(1);
            } else {
                iSuperPlayer.setXYaxis(2);
            }
            K0();
            this.f218465i.start();
            QLog.d("GuildFeedVideoItemView", 1, "doOnVideoPrepare start play");
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.detail.banner.item.GuildBannerVideoItemView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (GuildBannerVideoItemView.this.F != null) {
                        RFWTypefaceUtil.setNumberTypeface(GuildBannerVideoItemView.this.F, false);
                        GuildBannerVideoItemView.this.F.setText(RFWBaseVideoUtils.getSocialMinSeconds((int) iSuperPlayer.getDurationMs()));
                        GuildBannerVideoItemView.this.H.setText(RFWBaseVideoUtils.getSocialMinSeconds((int) iSuperPlayer.getDurationMs()));
                        GuildBannerVideoItemView.this.P = RFWBaseVideoUtils.getSocialSeconds((int) iSuperPlayer.getDurationMs());
                    }
                }
            });
        }
    }

    private void K0() {
        String pageForumType;
        GuildFeedVideoView guildFeedVideoView = this.f218465i;
        if (guildFeedVideoView != null && this.f218461d != null && this.f218463f != null && this.R != null) {
            GuildFeedBaseInitBean q16 = ax.q(guildFeedVideoView.getContext());
            String str = "pg_sgrp_forum_viewer";
            if (q16 != null) {
                String str2 = q16.getFeedReportSourceInfo().getReportInfoMap().get("extra_feeds_page_id");
                if (!"pg_sgrp_forum_viewer_feeds".equals(str2)) {
                    if (q16.getBusinessType() == 7) {
                        str = "pg_group_sgrp_forum_viewer";
                    }
                } else {
                    str = str2;
                }
            }
            GProStFeed gProStFeed = this.f218463f;
            if (q16 == null) {
                pageForumType = "";
            } else {
                pageForumType = q16.getPageForumType(q16.getPageId());
            }
            Map<String, ?> d16 = f.d(gProStFeed, pageForumType);
            d16.put("video_length", Integer.valueOf(this.P));
            d16.put(QCircleLpReportDc05507.KEY_VIDEO_PLAY_TIME, Integer.valueOf(this.N));
            d16.put("video_end_type", "3");
            d16.put(QzoneCameraConst.Tag.ARG_PARAM_VIDEO_START_TIME, Integer.valueOf(this.Q));
            d16.put(QzoneCameraConst.Tag.ARG_PARAM_VIDEO_END_TIME, Long.valueOf(System.currentTimeMillis()));
            VideoEntity build = new VideoEntity.Builder().setContentId(String.valueOf(this.f218463f.meta.content.ContentID)).setPage((Object) str).setContentType(2).setVideoDuration(this.P).setVideoView((View) this.f218465i).addCustomParams(d16).ignoreReport(false).bizReady(true).build();
            ISuperPlayer superPlayer = this.f218465i.getSuperPlayer();
            if (superPlayer != null) {
                VideoReport.bindVideoPlayerInfo(superPlayer, build);
                QLog.i("GuildFeedVideoItemView", 1, "dtReportBindVideoData");
            }
        }
    }

    private void L0() {
        if (F0()) {
            return;
        }
        QLog.d("GuildFeedVideoItemView", 1, "executeFromSelected");
        d1(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(boolean z16) {
        if (F0()) {
            return;
        }
        if (this.f218465i.getSuperPlayer() == null) {
            d1(z16);
            return;
        }
        if (this.f218465i.getSuperPlayer().isPlaying()) {
            return;
        }
        if (this.f218465i.getSuperPlayer().isPausing()) {
            this.f218465i.start();
            G0(true);
        } else {
            d1(z16);
        }
    }

    private String P0(GProStVideo gProStVideo) {
        if (gProStVideo == null) {
            return "";
        }
        if (!TextUtils.isEmpty(gProStVideo.fileId)) {
            return gProStVideo.fileId;
        }
        return gProStVideo.playUrl;
    }

    private Drawable Q0() {
        Bitmap D9;
        Bitmap D92;
        String str = this.f218462e.cover.picUrl;
        if (!TextUtils.isEmpty(str) && (D92 = GuildFeedGalleryPreloadPart.D9(e.d(str))) != null) {
            QLog.d("GuildFeedVideoItemView", 1, "find video cover cache" + str);
            return new BitmapDrawable(this.f218466m.getContext().getResources(), D92);
        }
        for (GProStImageUrl gProStImageUrl : bm.n(this.f218462e.cover)) {
            String str2 = gProStImageUrl.url;
            if (!TextUtils.isEmpty(str2) && (D9 = GuildFeedGalleryPreloadPart.D9(e.d(str2))) != null) {
                QLog.d("GuildFeedVideoItemView", 1, "bitmap match, ThumbnailType:" + gProStImageUrl.levelType + ", getLoadingDrawableFromThumbnailUrl from global cache, key: " + str2);
                return new BitmapDrawable(this.f218466m.getContext().getResources(), D9);
            }
        }
        return this.f218466m.getContext().getResources().getDrawable(R.drawable.f162601b70);
    }

    private void S0(GuildFeedVideoCurrentTimeEvent guildFeedVideoCurrentTimeEvent) {
        if (guildFeedVideoCurrentTimeEvent.getFiledId().equals(this.f218461d.getVideo().fileId)) {
            V.put(P0(this.f218461d.getVideo()), Long.valueOf(guildFeedVideoCurrentTimeEvent.getCurrentTime()));
        }
    }

    private void T0() {
        this.N = 0;
        this.M = 0;
    }

    private void U0(View view) {
        View findViewById = view.findViewById(R.id.w96);
        if (findViewById instanceof ViewStub) {
            this.T = ((ViewStub) findViewById).inflate();
        }
        View view2 = this.T;
        if (view2 == null) {
            return;
        }
        view2.measure(0, 0);
        this.U = this.T.getMeasuredHeight();
        this.T.setOnClickListener(new a());
    }

    private void V0() {
        this.L.setOnClickListener(this);
        this.f218465i.setOnClickListener(this);
        this.f218466m.setOnClickListener(this);
        this.J.setOnClickListener(this);
    }

    private void W0() {
        this.f218465i.setLoadingView(this.D);
        this.f218465i.setProgressBar(this.C);
        this.E.setOnTouchListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y0() {
        return false;
    }

    private boolean Z0() {
        return this.S;
    }

    private void a() {
        if (this.f218465i == null) {
            return;
        }
        g1();
        VideoReport.unbindVideoPlayerInfo(this.f218465i);
        G0(false);
        this.f218465i.release();
    }

    private GuildBaseVideoView.b a1(String str) {
        return new c(str);
    }

    private void b1() {
        GuildFeedVideoView guildFeedVideoView = this.f218465i;
        if (guildFeedVideoView != null && guildFeedVideoView.getSuperPlayer() != null && this.f218465i.getSuperPlayer().isPlaying()) {
            VideoReport.unbindVideoPlayerInfo(this.f218465i);
            this.f218465i.pause();
            this.J.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(View view) {
        if (view == null) {
            return;
        }
        QLog.i("GuildFeedVideoItemView", 4, "seekBarSlideDtReport");
        new HashMap();
        VideoReport.setElementId(view, "em_sgrp_forum_video_start_seek");
    }

    private void d1(boolean z16) {
        long j3;
        GuildFeedRichMediaData guildFeedRichMediaData = this.f218461d;
        if (guildFeedRichMediaData == null) {
            return;
        }
        this.f218465i.setData(guildFeedRichMediaData, this.f218464h);
        String P0 = P0(this.f218462e);
        synchronized (GuildBannerVideoItemView.class) {
            QLog.d("GuildFeedVideoItemView", 1, "startANewPlayer videoKey:" + P0 + APLogFileUtil.SEPARATOR_LOG + V.containsKey(P0) + APLogFileUtil.SEPARATOR_LOG + hashCode());
            if (z16 && !TextUtils.isEmpty(P0) && V.containsKey(P0)) {
                j3 = V.get(P0).longValue();
            } else {
                j3 = 0;
            }
        }
        this.f218465i.setInitListener(a1(P0));
        this.f218465i.setVideoWithExchangeUrl(this.f218462e, (int) j3);
        this.J.setVisibility(8);
    }

    private void e1(int i3) {
        if (this.T != null && this.f218465i != null && this.f218461d != null) {
            QLog.d("GuildFeedVideoItemView", 1, "[hideVideoContainer] container should not be null." + this.f218465i.getBottom() + "orientation =" + this.f218461d.getVideo().orientation + "target = " + i3);
            if (this.f218461d.isVideoScreenPlay() && this.f218461d.getVideo().width > this.f218461d.getVideo().height && i3 != -1) {
                this.T.setVisibility(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.T.getLayoutParams();
                layoutParams.topMargin = (i3 / 2) + (this.U / 2) + cx.a(12.0f);
                layoutParams.gravity = 17;
                this.T.setLayoutParams(layoutParams);
                return;
            }
            this.T.setVisibility(8);
        }
    }

    private void f1() {
        if (!this.f218465i.r0()) {
            this.J.setVisibility(8);
            this.L.setImageResource(R.drawable.f9o);
        } else {
            this.J.setVisibility(0);
            this.L.setImageResource(R.drawable.f9n);
        }
    }

    private void g1() {
        String pageForumType;
        if (this.f218463f != null && this.R != null) {
            GuildFeedBaseInitBean q16 = ax.q(this.f218465i.getContext());
            GProStFeed gProStFeed = this.f218463f;
            if (q16 == null) {
                pageForumType = "";
            } else {
                pageForumType = q16.getPageForumType(q16.getPageId());
            }
            GuildFeedReportTable12003.b(new GuildFeedReportTable12003.a(f.b(gProStFeed, pageForumType).K("play_video").J("success").p0(String.valueOf(this.P)).c0(String.valueOf(this.N)).d0("2").Y(this.R)));
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public void bindData(GuildFeedRichMediaData guildFeedRichMediaData, int i3) {
        if (guildFeedRichMediaData == null) {
            return;
        }
        if (guildFeedRichMediaData.getPageId() != null) {
            this.R = guildFeedRichMediaData.getPageId();
        }
        this.f218461d = guildFeedRichMediaData;
        this.f218464h = i3;
        this.f218462e = guildFeedRichMediaData.getVideo();
        T0();
        this.J.setVisibility(8);
        C0();
        D0();
        G0(false);
    }

    public MultiTouchImageView N0() {
        return this.f218466m;
    }

    public int O0() {
        return this.M;
    }

    @Override // mj1.c.b
    public void X(int i3) {
        b1();
    }

    protected void X0(View view) {
        this.f218465i = (GuildFeedVideoView) view.findViewById(R.id.x4k);
        this.C = (SeekBar) view.findViewById(R.id.wuj);
        this.D = view.findViewById(R.id.x4i);
        this.E = (FrameLayout) view.findViewById(R.id.wzr);
        this.F = (TextView) view.findViewById(R.id.f165645x41);
        this.G = (TextView) view.findViewById(R.id.f165640x32);
        this.H = (TextView) view.findViewById(R.id.wul);
        this.I = (TextView) view.findViewById(R.id.wuk);
        this.f218466m = (MultiTouchImageView) view.findViewById(R.id.wco);
        this.J = (ImageView) view.findViewById(R.id.f165520wg0);
        this.L = (ImageView) view.findViewById(R.id.x4j);
        this.Q = ((int) System.currentTimeMillis()) / 1000;
        ImageViewPorterDuffUtils.f235385a.c(this.f218466m);
        W0();
        V0();
        U0(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedVideoCurrentTimeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.enf;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        SimpleEventBus.getInstance().registerReceiver(this);
        super.onAttachedToWindow();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.x4j || view.getId() == R.id.x4k || view.getId() == R.id.wco || view.getId() == R.id.f165520wg0) {
            if (this.f218465i.r0()) {
                this.f218465i.start();
                this.K = Boolean.FALSE;
            } else {
                this.f218465i.pause();
                this.K = Boolean.TRUE;
            }
            f1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        a();
    }

    public void onPause() {
        b1();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFeedVideoCurrentTimeEvent) {
            S0((GuildFeedVideoCurrentTimeEvent) simpleBaseEvent);
        }
    }

    public void onResume() {
        if (!this.K.booleanValue()) {
            M0(true);
        }
    }

    @Override // mj1.c.b
    public void onSelected(int i3) {
        QLog.d("GuildFeedVideoItemView", 1, "onSelected, itemPos: " + this.f218464h + ", curPos: " + i3);
        if (this.f218464h == i3) {
            L0();
        } else {
            b1();
        }
    }

    public void setFeedInfo(GProStFeed gProStFeed) {
        this.f218463f = gProStFeed;
    }
}
