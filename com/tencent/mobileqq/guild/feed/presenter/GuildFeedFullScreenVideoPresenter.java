package com.tencent.mobileqq.guild.feed.presenter;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.biz.richframework.video.RFWBaseVideoUtils;
import com.tencent.image.URLImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.event.GuildFullScreenCloseEvent;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView;
import com.tencent.mobileqq.guild.feed.video.GuildFeedVideoView;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;

/* loaded from: classes13.dex */
public class GuildFeedFullScreenVideoPresenter implements View.OnClickListener {
    private LinearLayout C;
    private TextView D;
    private TextView E;
    private FrameLayout F;
    private RelativeLayout G;
    private TextView H;
    private TextView I;
    private ImageView J;
    private TextView K;
    private TextView L;
    private GuildUserAvatarView M;
    private ImageView N;
    private LinearLayout P;
    private LinearLayout Q;
    private View R;
    private int S;
    private int T;
    private int U;
    private boolean V = true;
    private boolean W = false;

    /* renamed from: d, reason: collision with root package name */
    private GProStFeed f222815d;

    /* renamed from: e, reason: collision with root package name */
    private GuildFeedVideoView f222816e;

    /* renamed from: f, reason: collision with root package name */
    private URLImageView f222817f;

    /* renamed from: h, reason: collision with root package name */
    private SeekBar f222818h;

    /* renamed from: i, reason: collision with root package name */
    private View f222819i;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f222820m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (GuildFeedFullScreenVideoPresenter.this.f222820m != null && GuildFeedFullScreenVideoPresenter.this.f222818h != null) {
                GuildFeedFullScreenVideoPresenter.this.f222820m.requestDisallowInterceptTouchEvent(true);
                GuildFeedFullScreenVideoPresenter.this.f222818h.onTouchEvent(motionEvent);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class b implements GuildBaseVideoView.b {

        /* loaded from: classes13.dex */
        class a extends com.tencent.mobileqq.guild.feed.video.c {
            a() {
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void a() {
                GuildFeedFullScreenVideoPresenter.this.q(true);
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void b(String str, int i3, int i16) {
                GuildFeedFullScreenVideoPresenter.this.s(i3, i16);
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void c(SeekBar seekBar, int i3, boolean z16) {
                GuildFeedFullScreenVideoPresenter.this.t(seekBar, i3, z16);
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void d(SeekBar seekBar) {
                GuildFeedFullScreenVideoPresenter.this.u(seekBar);
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void e(SeekBar seekBar) {
                GuildFeedFullScreenVideoPresenter.this.v(seekBar);
            }

            @Override // com.tencent.mobileqq.guild.feed.video.c
            public void g(ISuperPlayer iSuperPlayer) {
                GuildFeedFullScreenVideoPresenter.this.w(iSuperPlayer);
            }
        }

        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView.b
        public void onInitSuccess() {
            if (GuildFeedFullScreenVideoPresenter.this.f222816e == null) {
                return;
            }
            GuildFeedFullScreenVideoPresenter.this.f222816e.setBaseVideoViewListenerSets(new a());
            GuildFeedFullScreenVideoPresenter.this.f222816e.setProgressBar(GuildFeedFullScreenVideoPresenter.this.f222818h);
            GuildFeedFullScreenVideoPresenter.this.f222816e.setLoadingView(GuildFeedFullScreenVideoPresenter.this.f222819i, 1);
            GuildFeedFullScreenVideoPresenter.this.f222816e.setVideoCover(GuildFeedFullScreenVideoPresenter.this.f222817f);
            GuildFeedFullScreenVideoPresenter.this.f222816e.setLoopBack(true);
            GuildFeedFullScreenVideoPresenter.this.f222816e.setOutPutMute(false);
            QLog.d("QFSFullScreenVideoPresenter", 1, "onInitSuccess");
        }
    }

    public static boolean A() {
        String b16 = uq3.c.b1("qqcircle", "full_screen_view_layout", "");
        if (!TextUtils.isEmpty(b16)) {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                String str2 = Build.BRAND;
                if (!TextUtils.isEmpty(str2)) {
                    if (!b16.contains(str.toLowerCase()) && !b16.contains(str2.toLowerCase())) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private GProStVideo B() {
        GProStFeed gProStFeed = this.f222815d;
        if (gProStFeed != null) {
            int size = gProStFeed.videos.size();
            int i3 = this.U;
            if (size > i3) {
                return this.f222815d.videos.get(i3);
            }
        }
        return new GProStVideo();
    }

    private void C(LinearLayout linearLayout) {
        if (linearLayout == null) {
            QLog.d("QFSFullScreenVideoPresenter", 1, "set animation error, authorLayout is null. ");
            return;
        }
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setDuration(400L);
        linearLayout.setLayoutTransition(layoutTransition);
    }

    private void K(int i3, int i16) {
        FrameLayout.LayoutParams layoutParams;
        URLImageView uRLImageView = this.f222817f;
        if (uRLImageView != null && (layoutParams = (FrameLayout.LayoutParams) uRLImageView.getLayoutParams()) != null) {
            layoutParams.width = i3;
            layoutParams.height = i16;
            layoutParams.gravity = 17;
            this.f222817f.setLayoutParams(layoutParams);
        }
    }

    private void N(int i3, int i16) {
        FrameLayout.LayoutParams layoutParams;
        if (this.R != null && !A() && (layoutParams = (FrameLayout.LayoutParams) this.R.getLayoutParams()) != null) {
            layoutParams.width = i3;
            layoutParams.height = i16;
            layoutParams.gravity = 17;
            this.R.setLayoutParams(layoutParams);
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void O(boolean z16, SeekBar seekBar) {
        if (this.C != null && seekBar != null && this.G != null && this.P != null) {
            QLog.d("QFSFullScreenVideoPresenter", 1, "setTrackTouchView, trackState = " + z16);
            if (z16) {
                this.C.setVisibility(0);
                seekBar.setThumb(seekBar.getContext().getResources().getDrawable(R.drawable.guild_feed_full_screen_progress_track_thumb));
                this.G.setVisibility(8);
                this.P.setVisibility(8);
                return;
            }
            this.C.setVisibility(8);
            seekBar.setThumb(seekBar.getContext().getResources().getDrawable(R.drawable.guild_feed_full_screen_progress_thumb));
            this.G.setVisibility(0);
            this.P.setVisibility(0);
        }
    }

    private void P(int i3, int i16) {
        FrameLayout.LayoutParams layoutParams;
        GuildFeedVideoView guildFeedVideoView = this.f222816e;
        if (guildFeedVideoView != null && (layoutParams = (FrameLayout.LayoutParams) guildFeedVideoView.getLayoutParams()) != null) {
            layoutParams.width = i3;
            layoutParams.height = i16;
            layoutParams.gravity = 17;
            this.f222816e.setLayoutParams(layoutParams);
        }
    }

    private GuildBaseVideoView.b R() {
        return new b();
    }

    private void p(final int i3) {
        QLog.d("QFSFullScreenVideoPresenter", 1, "change play status to = " + i3);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.presenter.GuildFeedFullScreenVideoPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                if (GuildFeedFullScreenVideoPresenter.this.J != null && GuildFeedFullScreenVideoPresenter.this.f222816e != null) {
                    if (i3 == 0) {
                        GuildFeedFullScreenVideoPresenter.this.J.setImageResource(R.drawable.ohp);
                        GuildFeedFullScreenVideoPresenter.this.f222816e.start();
                    } else {
                        GuildFeedFullScreenVideoPresenter.this.J.setImageResource(R.drawable.ohq);
                        VideoReport.unbindVideoPlayerInfo(GuildFeedFullScreenVideoPresenter.this.f222816e);
                        GuildFeedFullScreenVideoPresenter.this.f222816e.pause();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i3, int i16) {
        TextView textView;
        if ((i16 == this.S && this.T == i3) || (textView = this.H) == null) {
            return;
        }
        this.S = i16;
        this.T = i3;
        textView.setText(RFWBaseVideoUtils.getSocialMinSeconds(i16) + " / ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(SeekBar seekBar, int i3, boolean z16) {
        TextView textView = this.E;
        if (textView != null && z16) {
            RFWTypefaceUtil.setNumberTypeface(textView, false);
            this.E.setText(RFWBaseVideoUtils.getSocialMinSeconds(i3) + " / ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(SeekBar seekBar) {
        O(true, seekBar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(SeekBar seekBar) {
        O(false, seekBar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final ISuperPlayer iSuperPlayer) {
        QLog.d("QFSFullScreenVideoPresenter", 1, "doOnVideoPrepare");
        p(0);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.presenter.GuildFeedFullScreenVideoPresenter.4
            @Override // java.lang.Runnable
            public void run() {
                if (GuildFeedFullScreenVideoPresenter.this.D != null && GuildFeedFullScreenVideoPresenter.this.I != null && GuildFeedFullScreenVideoPresenter.this.f222820m != null) {
                    RFWTypefaceUtil.setNumberTypeface(GuildFeedFullScreenVideoPresenter.this.D, false);
                    String socialMinSeconds = RFWBaseVideoUtils.getSocialMinSeconds((int) iSuperPlayer.getDurationMs());
                    GuildFeedFullScreenVideoPresenter.this.D.setText(socialMinSeconds);
                    GuildFeedFullScreenVideoPresenter.this.I.setText(socialMinSeconds);
                }
            }
        });
    }

    protected void D() {
        GProStUser gProStUser;
        String str;
        GProStFeed gProStFeed = this.f222815d;
        if (gProStFeed == null) {
            return;
        }
        if (!TextUtils.isEmpty(gProStFeed.idd)) {
            QLog.d("QFSFullScreenVideoPresenter", 1, "feed id = " + this.f222815d.idd);
        }
        if (this.L != null && (gProStUser = this.f222815d.poster) != null && (str = gProStUser.nick) != null && !TextUtils.isEmpty(str)) {
            this.L.setText(this.f222815d.poster.nick);
        } else {
            TextView textView = this.L;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
        if (this.K != null && this.f222815d.title.contents.size() > 0) {
            this.K.setText(FeedRichTextContentParser.f221393a.p(this.f222815d.title.contents).getFirst());
        } else {
            TextView textView2 = this.K;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        u.l(this.M, this.f222815d.poster.icon.iconUrl, null);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void E() {
        FrameLayout frameLayout = this.f222820m;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setOnTouchListener(new a());
    }

    public void F(@NonNull GProStFeed gProStFeed) {
        this.f222815d = gProStFeed;
        D();
        n();
        o();
        q(false);
        E();
    }

    public void G(@NonNull View view) {
        this.R = view;
        this.f222816e = (GuildFeedVideoView) view.findViewById(R.id.f42801kr);
        this.f222817f = (URLImageView) view.findViewById(R.id.f42651kc);
        this.J = (ImageView) view.findViewById(R.id.f42601k8);
        this.f222818h = (SeekBar) view.findViewById(R.id.f42661kd);
        this.f222819i = view.findViewById(R.id.f42791kq);
        this.f222820m = (FrameLayout) view.findViewById(R.id.f42261ja);
        this.C = (LinearLayout) view.findViewById(R.id.f42511jz);
        this.D = (TextView) view.findViewById(R.id.f42771ko);
        this.E = (TextView) view.findViewById(R.id.f42761kn);
        this.F = (FrameLayout) view.findViewById(R.id.f42721kj);
        this.G = (RelativeLayout) view.findViewById(R.id.f42491jx);
        this.H = (TextView) view.findViewById(R.id.f42811ks);
        this.I = (TextView) view.findViewById(R.id.f42831ku);
        this.K = (TextView) view.findViewById(R.id.f42471jv);
        this.L = (TextView) view.findViewById(R.id.f42381jm);
        this.M = (GuildUserAvatarView) view.findViewById(R.id.f42461ju);
        this.N = (ImageView) view.findViewById(R.id.f42411jp);
        this.P = (LinearLayout) view.findViewById(R.id.f42821kt);
        this.Q = (LinearLayout) view.findViewById(R.id.f42371jl);
        this.J.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.L.setOnClickListener(this);
        C(this.Q);
    }

    public void H() {
        QLog.d("QFSFullScreenVideoPresenter", 1, "onResume");
        this.V = true;
        x(true);
    }

    public void I() {
        QLog.d("QFSFullScreenVideoPresenter", 1, DKHippyEvent.EVENT_STOP);
        this.V = false;
        J();
    }

    protected void J() {
        if (this.f222816e == null) {
            return;
        }
        QLog.d("QFSFullScreenVideoPresenter", 1, "releasePlayer");
        VideoReport.unbindVideoPlayerInfo(this.f222816e);
        this.f222816e.release();
        q(false);
    }

    public void L(Long l3) {
        this.S = l3.intValue();
    }

    public void M(int i3) {
        this.U = i3;
    }

    protected void Q(boolean z16) {
        if (this.f222816e != null && this.f222815d != null) {
            QLog.d("QFSFullScreenVideoPresenter", 1, "startANewPlayer");
            int i3 = 0;
            this.f222816e.setData(this.f222815d, 0);
            if (z16) {
                i3 = this.S;
            }
            this.f222816e.setInitListener(R());
            GProStVideo B = B();
            this.f222816e.setVideoPath(B.fileId, B.playUrl, i3);
        }
    }

    protected void n() {
        if (this.f222815d != null && B().cover != null) {
            int i3 = B().cover.height;
            int i16 = B().cover.width;
            int screenHeight = ImmersiveUtils.getScreenHeight();
            int screenWidth = ImmersiveUtils.getScreenWidth();
            float f16 = i16;
            float f17 = i3;
            int i17 = (int) ((screenHeight / f16) * f17);
            if (i17 > screenWidth) {
                screenHeight = (int) ((screenWidth / f17) * f16);
            } else {
                screenWidth = i17;
            }
            P(screenHeight, screenWidth);
            K(screenHeight, screenWidth);
            N(screenHeight, screenWidth);
        }
    }

    protected void o() {
        com.tencent.mobileqq.guild.picload.e.a().f(new Option().setUrl(B().cover.picUrl).setTargetView(this.f222817f), null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            if (view.getId() == R.id.f42411jp) {
                SimpleEventBus.getInstance().dispatchEvent(new GuildFullScreenCloseEvent());
            } else if (view.getId() == R.id.f42601k8) {
                x(true);
            } else if (view.getId() != R.id.f42371jl && view.getId() != R.id.f42381jm) {
                view.getId();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    protected void q(final boolean z16) {
        QLog.d("QFSFullScreenVideoPresenter", 1, "change view status to = " + z16);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.presenter.GuildFeedFullScreenVideoPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                if (GuildFeedFullScreenVideoPresenter.this.f222817f != null && GuildFeedFullScreenVideoPresenter.this.f222818h != null) {
                    if (z16) {
                        GuildFeedFullScreenVideoPresenter.this.f222817f.setVisibility(8);
                        GuildFeedFullScreenVideoPresenter.this.f222818h.setVisibility(0);
                        GuildFeedFullScreenVideoPresenter.this.f222819i.setVisibility(8);
                    } else {
                        GuildFeedFullScreenVideoPresenter.this.f222817f.setVisibility(0);
                        GuildFeedFullScreenVideoPresenter.this.f222818h.setVisibility(8);
                        GuildFeedFullScreenVideoPresenter.this.f222819i.setVisibility(0);
                    }
                }
            }
        });
    }

    public void r() {
        FrameLayout frameLayout = this.F;
        if (frameLayout != null && this.G != null) {
            if (!this.W) {
                frameLayout.setVisibility(8);
                this.G.setVisibility(8);
                this.W = true;
            } else {
                frameLayout.setVisibility(0);
                this.G.setVisibility(0);
                this.W = false;
            }
        }
    }

    protected void x(boolean z16) {
        GuildFeedVideoView guildFeedVideoView;
        if (this.V && (guildFeedVideoView = this.f222816e) != null) {
            if (guildFeedVideoView.getSuperPlayer() == null) {
                Q(z16);
                return;
            }
            if (this.f222816e.getSuperPlayer().isPlaying()) {
                p(1);
            } else if (this.f222816e.getSuperPlayer().isPausing()) {
                p(0);
            } else {
                Q(z16);
            }
        }
    }

    public long y() {
        return this.S;
    }

    public String z() {
        return B().fileId;
    }
}
