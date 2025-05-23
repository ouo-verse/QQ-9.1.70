package com.tencent.mobileqq.guild.feed.video.widget;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedListImageExKt;
import com.tencent.mobileqq.guild.feed.gallery.pb.GuildFeedRecommendParam$ItemCbData;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.report.GuildFeedReportTable12003;
import com.tencent.mobileqq.guild.feed.report.d;
import com.tencent.mobileqq.guild.feed.report.f;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.feed.video.GuildFeedListBaseVideoView;
import com.tencent.mobileqq.guild.feed.video.GuildFeedVideoPlayParamManager;
import com.tencent.mobileqq.guild.feed.video.c;
import com.tencent.mobileqq.guild.feed.video.e;
import com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.guild.report.GuildChannelReportManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProItemCbData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import ij1.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedListVideoItemWidgetView extends GuildBaseWidgetView<g> implements eo1.a, View.OnClickListener {
    private FrameLayout C;
    private final Lazy<AbsGuildFeedMediaSizeUtils> D;
    private int E;
    private String F;
    private GuildFeedBaseInitBean G;
    private GProStVideo H;
    private final Map<String, Object> I;
    private volatile boolean J;
    private final Runnable K;
    GuildFeedListBaseVideoView.b L;

    /* renamed from: d, reason: collision with root package name */
    private GuildFeedListBaseVideoView<g> f223999d;

    /* renamed from: e, reason: collision with root package name */
    private RoundCornerLayout f224000e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f224001f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f224002h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f224003i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f224004m;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements GuildFeedListBaseVideoView.b {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.guild.feed.video.widget.GuildFeedListVideoItemWidgetView$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        class C7782a extends c {
            C7782a() {
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void a() {
                QLog.d("GuildFeedListVideoItemWidgetView", 1, "firstFrameRenderCallBack| pos: " + GuildFeedListVideoItemWidgetView.this.getDataPosInList() + ", changeViewStatus true");
                GuildFeedListVideoItemWidgetView.this.V0(false);
                GuildFeedListVideoItemWidgetView.this.B0();
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void b(String str, int i3, int i16) {
                if (GuildFeedListVideoItemWidgetView.this.J) {
                    GuildFeedListVideoItemWidgetView.this.f224002h.setText(ax.y(i3 - i16));
                }
                GuildFeedVideoPlayParamManager.f223979d.h(GuildFeedListVideoItemWidgetView.this.F, i16);
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void f() {
                GuildFeedListVideoItemWidgetView.this.f224002h.setVisibility(0);
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(GuildFeedListVideoItemWidgetView.this.K);
                GuildFeedListVideoItemWidgetView.this.B0();
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void g(ISuperPlayer iSuperPlayer) {
                super.g(iSuperPlayer);
                QLog.d("GuildFeedListVideoItemWidgetView", 1, "onVideoPrepared| ----- isPlaying = " + GuildFeedListVideoItemWidgetView.this.J + ", pos = " + GuildFeedListVideoItemWidgetView.this.getDataPosInList());
                GuildFeedListVideoItemWidgetView.this.H0();
                if (GuildFeedListVideoItemWidgetView.this.J) {
                    GuildFeedListVideoItemWidgetView.this.f223999d.start();
                }
            }
        }

        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.video.GuildFeedListBaseVideoView.b
        public void onInitSuccess() {
            GuildFeedListVideoItemWidgetView.this.f223999d.setBaseVideoViewListenerSets(new C7782a());
        }
    }

    public GuildFeedListVideoItemWidgetView(@NonNull Context context) {
        this(context, null);
    }

    private void A0(GProStVideo gProStVideo, String str) {
        Pair<Integer, Integer> k3 = bm.k(gProStVideo.cover);
        x0(((Integer) k3.first).intValue(), ((Integer) k3.second).intValue());
        K0(gProStVideo, k3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.K, 4000L);
    }

    private int D0() {
        if (this.f223999d.getOutPutMute()) {
            return 2;
        }
        return 1;
    }

    private Map<String, Object> E0() {
        String pageForumType;
        if (getData() != null) {
            GProStFeed b16 = getData().b();
            if (b16 != null) {
                Map<String, Object> map = this.I;
                GuildFeedBaseInitBean guildFeedBaseInitBean = this.G;
                if (guildFeedBaseInitBean == null) {
                    pageForumType = "";
                } else {
                    pageForumType = guildFeedBaseInitBean.getPageForumType(guildFeedBaseInitBean.getPageId());
                }
                map.putAll(f.d(b16, pageForumType));
                this.I.put("sgrp_switch_condition", Integer.valueOf(D0()));
            }
            if (!TextUtils.isEmpty(getData().c())) {
                this.I.put("sgrp_forum_trace_id", getData().c());
            }
        }
        return new ConcurrentHashMap(this.I);
    }

    private void G0(View view) {
        if (this.f223999d.getSuperPlayer() != null && this.f223999d.getSuperPlayer().isPlaying()) {
            L0();
            d.a("clck", view, "em_sgrp_video_edit_mute", E0());
        } else {
            QLog.d("GuildFeedListVideoItemWidgetView", 1, "[onClick mMuteIcon] return for is not Playing");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        this.f223999d.setLoopBack(true);
        S0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AbsGuildFeedMediaSizeUtils J0() {
        return com.tencent.mobileqq.guild.feed.feedsquare.utils.g.b(this.f224000e);
    }

    private void K0(GProStVideo gProStVideo, Pair<Integer, Integer> pair, String str) {
        String h16 = bm.h(gProStVideo.cover);
        if (TextUtils.isEmpty(h16)) {
            GuildFeedListImageExKt.h(this.f224003i, gProStVideo, ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue());
        } else {
            ImageView imageView = this.f224003i;
            GuildFeedListImageExKt.e(imageView, h16, pair, str, imageView.getContext().getDrawable(R.drawable.f162601b70));
        }
    }

    private void M0(View view) {
        if (getData() != null && this.G != null && view != null) {
            GuildFeedGalleryInitBean a16 = e.a(view, getData().b(), 0, this.G);
            Q0(a16);
            mk1.e.a(a16, E0());
            a16.setImmersiveSource(mk1.e.f(this.G, this.E));
            a16.setGuildFeedPublishInfo(com.tencent.mobileqq.guild.feed.feedsquare.data.g.b(getData()));
            GuildFeedLauncher.z(this.f224000e.getContext(), a16, view);
            W0(view);
        }
    }

    private void N0() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.video.widget.GuildFeedListVideoItemWidgetView.5
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedListVideoItemWidgetView.this.f224002h.setText(ax.y(GuildFeedListVideoItemWidgetView.this.H.duration));
            }
        });
    }

    private void O0(GProStVideo gProStVideo) {
        this.H = gProStVideo;
        this.F = e.f223991a.b(gProStVideo);
    }

    private void P0() {
        GuildFeedListBaseVideoView<g> guildFeedListBaseVideoView = this.f223999d;
        if (guildFeedListBaseVideoView != null && guildFeedListBaseVideoView.getSuperPlayer() != null) {
            this.f223999d.getSuperPlayer().setXYaxis(2);
            this.f223999d.requestLayout();
        }
    }

    private void S0() {
        boolean c16 = GuildFeedVideoPlayParamManager.f223979d.c();
        this.f223999d.setOutPutMute(c16);
        T0(c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(final boolean z16) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.video.widget.GuildFeedListVideoItemWidgetView.6
                @Override // java.lang.Runnable
                public void run() {
                    GuildFeedListVideoItemWidgetView.this.T0(z16);
                }
            });
            return;
        }
        if (this.f224004m.getVisibility() == 8) {
            this.f224004m.setVisibility(0);
        }
        if (z16) {
            this.f224004m.setImageResource(R.drawable.guild_feed_item_voice_mute);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f224004m.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.rightMargin = ViewUtils.dip2px(9.0f);
            }
            this.f224004m.requestLayout();
        } else {
            this.f224004m.setImageResource(R.drawable.guild_feed_item_voice_high);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f224004m.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.rightMargin = ViewUtils.dip2px(7.0f);
            }
            this.f224004m.requestLayout();
        }
        this.f224004m.setColorFilter(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(final int i3, final int i16) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.video.widget.GuildFeedListVideoItemWidgetView.3
                @Override // java.lang.Runnable
                public void run() {
                    GuildFeedListVideoItemWidgetView.this.U0(i3, i16);
                }
            });
            return;
        }
        this.f224002h.setVisibility(0);
        this.f224002h.setText(ax.y(i3 - i16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(final boolean z16) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.video.widget.GuildFeedListVideoItemWidgetView.4
                @Override // java.lang.Runnable
                public void run() {
                    GuildFeedListVideoItemWidgetView.this.V0(z16);
                }
            });
            return;
        }
        if (z16) {
            this.f224001f.setVisibility(0);
            this.f224003i.setVisibility(0);
            this.f224002h.setVisibility(0);
        } else {
            this.f224001f.setVisibility(8);
            this.f224003i.setVisibility(8);
        }
    }

    private void W0(View view) {
        String pageForumType;
        if (view != null && getData() != null && getData().b() != null) {
            GuildFeedBaseInitBean q16 = ax.q(view.getContext());
            if (q16 == null) {
                pageForumType = "";
            } else {
                pageForumType = q16.getPageForumType(q16.getPageId());
            }
            GuildFeedReportTable12003.b(new GuildFeedReportTable12003.a(f.b(getData().b(), pageForumType).K(ReportConst.ACTION.FULLSCREEN).J("success").Y("pg_channel_forum_page")));
            GuildChannelReportManager.f231987a.f(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST, null);
        }
    }

    private void x0(int i3, int i16) {
        AbsGuildFeedMediaSizeUtils value = this.D.getValue();
        RoundCornerLayout roundCornerLayout = this.f224000e;
        if (i16 == 0) {
            i16 = i3;
        }
        value.a(roundCornerLayout, i3, i16);
        float dpToPx = ViewUtils.dpToPx(6.0f);
        this.f224000e.setRadius(dpToPx, dpToPx, dpToPx, dpToPx);
    }

    private void z0() {
        P0();
        this.f223999d.setDataPosInList(getDataPosInList());
    }

    protected void C0(View view, String str) {
        if (view != null && getData() != null) {
            d.d(view, str, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_NONE, E0());
        }
    }

    public View F0() {
        return this.f224000e;
    }

    protected void I0() {
        this.f224000e = (RoundCornerLayout) findViewById(R.id.wb_);
        this.f223999d = (GuildFeedListBaseVideoView) findViewById(R.id.x4k);
        this.f224001f = (ImageView) findViewById(R.id.wbl);
        this.f224002h = (TextView) findViewById(R.id.wbm);
        this.f224003i = (ImageView) findViewById(R.id.wbk);
        this.C = (FrameLayout) findViewById(R.id.wfk);
        ImageView imageView = (ImageView) findViewById(R.id.wfl);
        this.f224004m = imageView;
        imageView.setColorFilter(-1);
        this.C.setVisibility(8);
        this.f224000e.setOnClickListener(this);
    }

    public void L0() {
        if (this.f223999d.getOutPutMute()) {
            this.f223999d.setOutPutMute(false);
            T0(false);
            GuildFeedVideoPlayParamManager.f223979d.g(false);
        } else {
            this.f223999d.setOutPutMute(true);
            T0(true);
            GuildFeedVideoPlayParamManager.f223979d.g(true);
        }
    }

    protected void Q0(GuildFeedGalleryInitBean guildFeedGalleryInitBean) {
        Object obj = E0().get("sgrp_discover_cb_data");
        if (obj instanceof IGProItemCbData) {
            IGProItemCbData iGProItemCbData = (IGProItemCbData) obj;
            GProStFeed feed = guildFeedGalleryInitBean.getFeed();
            if (feed == null) {
                feed = new GProStFeed();
                feed.idd = guildFeedGalleryInitBean.getFeedId();
            }
            GuildFeedRecommendParam$ItemCbData guildFeedRecommendParam$ItemCbData = new GuildFeedRecommendParam$ItemCbData();
            guildFeedRecommendParam$ItemCbData.stat_data.set(iGProItemCbData.getStatData());
            guildFeedRecommendParam$ItemCbData.cb_ext_data.set(ByteStringMicro.copyFrom(iGProItemCbData.getCbExtData()));
            QLog.d("GuildFeedListVideoItemWidgetView", 4, "[tryToSetRecommendExposeParams] " + iGProItemCbData);
            feed.busiReport = guildFeedRecommendParam$ItemCbData.toByteArray();
            guildFeedGalleryInitBean.setFeed(feed);
        }
    }

    @Override // eo1.a
    public void a() {
        GuildFeedListBaseVideoView<g> guildFeedListBaseVideoView = this.f223999d;
        if (guildFeedListBaseVideoView != null) {
            guildFeedListBaseVideoView.a();
        }
        V0(true);
    }

    @Override // eo1.a
    public GuildFeedListBaseVideoView d() {
        return this.f223999d;
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.erw;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.wb_) {
            M0(view);
        } else if (view.getId() == R.id.wfk) {
            G0(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // eo1.a
    public void pause() {
        QLog.d("GuildFeedListVideoItemWidgetView", 1, "[pause]");
        if (this.f223999d.o0() != null) {
            QLog.d("GuildFeedListVideoItemWidgetView", 1, "[pause] do real pause");
            this.f223999d.o0().pause();
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.K);
        this.f224004m.setVisibility(8);
        V0(true);
        N0();
        this.J = false;
    }

    @Override // eo1.a
    public void play() {
        QLog.d("GuildFeedListVideoItemWidgetView", 1, "[play] return for autoPlay is not enabled");
    }

    public void setInitBean(GuildFeedBaseInitBean guildFeedBaseInitBean) {
        this.G = guildFeedBaseInitBean;
    }

    public void setSortMode(int i3) {
        this.E = i3;
    }

    public void y0(GProStVideo gProStVideo, @Nullable String str) {
        if (gProStVideo == null) {
            return;
        }
        QLog.d("GuildFeedListVideoItemWidgetViewGuildFeedListVideoItemWidgetView", 1, "[bindVideoInfoData]   | position = " + getDataPosInList() + " | hashcode = " + hashCode());
        O0(gProStVideo);
        A0(gProStVideo, str);
        z0();
        U0(this.H.duration, GuildFeedVideoPlayParamManager.f223979d.d(this.F));
        if (!this.f223999d.isPlaying()) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.K);
        }
        C0(this.f224004m, "em_sgrp_video_edit_mute");
    }

    public GuildFeedListVideoItemWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildFeedListVideoItemWidgetView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy<AbsGuildFeedMediaSizeUtils> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.tencent.mobileqq.guild.feed.video.widget.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                AbsGuildFeedMediaSizeUtils J0;
                J0 = GuildFeedListVideoItemWidgetView.this.J0();
                return J0;
            }
        });
        this.D = lazy;
        this.I = new ConcurrentHashMap();
        this.J = false;
        this.K = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.video.widget.GuildFeedListVideoItemWidgetView.1
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedListVideoItemWidgetView.this.f224002h.setVisibility(8);
            }
        };
        this.L = new a();
        I0();
    }
}
