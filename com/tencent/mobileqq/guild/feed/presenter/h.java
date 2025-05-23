package com.tencent.mobileqq.guild.feed.presenter;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.video.GuildFeedListBaseVideoView;
import com.tencent.mobileqq.guild.feed.video.widget.GuildFeedListVideoItemWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;

/* compiled from: P */
/* loaded from: classes13.dex */
public class h extends GuildBaseFeedChildPresenter<ij1.g> implements View.OnClickListener, eo1.a {
    private int F;
    private GuildFeedListVideoItemWidgetView G;

    public h(GuildFeedDefaultInitBean guildFeedDefaultInitBean) {
        super(guildFeedDefaultInitBean);
    }

    @Nullable
    private GProStVideo t(ij1.g gVar) {
        if (gVar != null && gVar.b() != null && !gVar.b().videos.isEmpty()) {
            return gVar.b().videos.get(0);
        }
        return null;
    }

    @Override // eo1.a
    public void a() {
        this.G.a();
    }

    @Override // eo1.a
    public GuildFeedListBaseVideoView d() {
        return this.G.d();
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void m() {
        QLog.d("GuildFeedChildSingleVideoPresenter", 1, "[onDetachedFromWindow] release video, pos = " + this.F);
        this.G.a();
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void o(@NonNull View view) {
        super.o(view);
        gj1.a.a().d().requestPreloadViewForViewStub((ViewStub) view.findViewById(R.id.wba), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter, com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.RequestPreloadViewListener
    public void onPreloadResult(View view) {
        super.onPreloadResult(view);
        this.G = (GuildFeedListVideoItemWidgetView) view.findViewById(R.id.f11769725);
    }

    @Override // eo1.a
    public void pause() {
        QLog.d("GuildFeedChildSingleVideoPresenter", 1, "[pause] pos = " + this.F);
        this.G.pause();
    }

    @Override // eo1.a
    public void play() {
        QLog.d("GuildFeedChildSingleVideoPresenter", 1, "[play] pos = " + this.F + " autoPlay = false");
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void k(ij1.g gVar, int i3) {
        super.k(gVar, i3);
        GProStVideo t16 = t(gVar);
        if (t16 == null) {
            QLog.e("GuildFeedChildSingleVideoPresenter", 1, "onBindData video is empty!! feedId=" + gVar.b().idd);
            return;
        }
        this.F = i3;
        QLog.d("GuildFeedChildSingleVideoPresenter", 1, "[onBindData] initVideoData pos = " + i3 + " , this is " + hashCode());
        this.G.setData(gVar, i3);
        this.G.setInitBean(this.D);
        this.G.setSortMode(this.C);
        this.G.y0(t16, null);
        c(this.G, "em_sgrp_forum_full_screen");
    }
}
