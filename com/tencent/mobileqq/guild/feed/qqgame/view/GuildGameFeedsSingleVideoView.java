package com.tencent.mobileqq.guild.feed.qqgame.view;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildGameFeedsSingleVideoView extends GuildGameFeedsView {
    private GameAdVideoView F;
    private d G;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements d {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.qqgame.view.d
        public void a() {
            on1.d dVar = GuildGameFeedsSingleVideoView.this.f223217f;
            if (dVar != null) {
                dVar.onVideoStart();
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.qqgame.view.d
        public void b() {
            on1.d dVar = GuildGameFeedsSingleVideoView.this.f223217f;
            if (dVar != null) {
                dVar.onVideoStop();
            }
        }
    }

    public GuildGameFeedsSingleVideoView(@NonNull Context context, on1.d dVar) {
        super(context, dVar);
        this.G = new a();
    }

    @Override // com.tencent.mobileqq.guild.feed.qqgame.view.GuildGameFeedsView, com.tencent.mobileqq.guild.feed.qqgame.view.BaseGuildGameFeedsView
    public void g() {
        GameAdVideoView gameAdVideoView = this.F;
        if (gameAdVideoView != null) {
            gameAdVideoView.n();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.qqgame.view.BaseGuildGameFeedsView
    public void h() {
        com.tencent.xaction.log.b.a("GuidGameFeedsSingleVideoView", 1, "onDisplayChanged");
        GameAdVideoView gameAdVideoView = this.F;
        if (gameAdVideoView == null) {
            return;
        }
        gameAdVideoView.p("from onDisplayChanged");
        this.F.setVideoData(this.f223216e);
        this.F.q("from onDisplayChanged");
    }

    @Override // com.tencent.mobileqq.guild.feed.qqgame.view.GuildGameFeedsView, com.tencent.mobileqq.guild.feed.qqgame.view.BaseGuildGameFeedsView
    public void i(boolean z16) {
        if (z16) {
            GameAdVideoView gameAdVideoView = this.F;
            if (gameAdVideoView != null) {
                gameAdVideoView.q("from onVisibleChanged");
                return;
            }
            return;
        }
        GameAdVideoView gameAdVideoView2 = this.F;
        if (gameAdVideoView2 != null) {
            gameAdVideoView2.p("from onVisibleChanged");
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.qqgame.view.GuildGameFeedsView
    public void o(@NonNull LinearLayout linearLayout) {
        com.tencent.xaction.log.b.a("GuidGameFeedsSingleVideoView", 1, "initSubContainer mSubContainer=" + linearLayout);
        this.F = new GameAdVideoView(linearLayout.getContext());
        linearLayout.addView(this.F, new LinearLayout.LayoutParams(-1, -1));
        this.F.setVideoData(this.f223216e);
        this.F.setVideoPlayerListener(this.G);
    }
}
