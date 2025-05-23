package com.tencent.mobileqq.guild.feed.presenter;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.report.GuildFeedReportTable12003;
import com.tencent.mobileqq.guild.feed.util.am;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.report.GuildChannelReportManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;

/* compiled from: P */
/* loaded from: classes13.dex */
public class g extends GuildBaseFeedChildPresenter<ij1.g> implements View.OnClickListener {
    GuildFeedSingleImageComponents F;

    public g(GuildFeedDefaultInitBean guildFeedDefaultInitBean) {
        super(guildFeedDefaultInitBean);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t(View view) {
        T t16;
        String pageForumType;
        if (view != null && (t16 = this.f222800d) != 0 && ((ij1.g) t16).b() != null) {
            GuildFeedBaseInitBean q16 = ax.q(this.f222805m.getContext());
            GProStFeed b16 = ((ij1.g) this.f222800d).b();
            if (q16 == null) {
                pageForumType = "";
            } else {
                pageForumType = q16.getPageForumType(q16.getPageId());
            }
            GuildFeedReportTable12003.b(new GuildFeedReportTable12003.a(com.tencent.mobileqq.guild.feed.report.f.b(b16, pageForumType).K(ReportConst.ACTION.FULLSCREEN).J("success").Y("pg_channel_forum_page")));
            GuildChannelReportManager.f231987a.f(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST, null);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void o(@NonNull View view) {
        super.o(view);
        gj1.a.a().d().requestPreloadViewForViewStub((ViewStub) view.findViewById(R.id.wb7), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.f165499wb4) {
            GProStImage gProStImage = ((ij1.g) this.f222800d).b().images.get(0);
            GProStFeed b16 = ((ij1.g) this.f222800d).b();
            if (b16 != null) {
                com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.j.f221614a.b((ImageView) view, b16, gProStImage, this.D.getBusinessType(), com.tencent.mobileqq.guild.feed.feedsquare.data.g.a(((ij1.g) this.f222800d).p(), false));
                t(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter, com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.RequestPreloadViewListener
    public void onPreloadResult(View view) {
        super.onPreloadResult(view);
        GuildFeedSingleImageComponents guildFeedSingleImageComponents = new GuildFeedSingleImageComponents(new a());
        this.F = guildFeedSingleImageComponents;
        guildFeedSingleImageComponents.h(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void k(ij1.g gVar, int i3) {
        super.k(gVar, i3);
        if (this.f222805m == null) {
            return;
        }
        this.F.g(new GProStFeedDetailRspWrapper(((ij1.g) this.f222800d).b(), am.e(((ij1.g) this.f222800d).b(), "pg_channel_forum_page")), i3, null);
        c(this.F.mImageView, "em_sgrp_forum_full_screen");
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void n() {
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements GuildFeedSingleImageComponents.b {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents.b
        @Nullable
        public Object a() {
            return null;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents.b
        public void c(@NonNull ImageView imageView) {
            g.this.onClick(imageView);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents.b
        public void b(@NonNull View view) {
        }
    }
}
