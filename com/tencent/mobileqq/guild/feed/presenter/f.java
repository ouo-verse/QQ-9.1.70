package com.tencent.mobileqq.guild.feed.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.video.GuildFeedListBaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class f extends GuildBaseFeedChildPresenter<ij1.g> implements View.OnClickListener, eo1.a {
    private RelativeLayout F;
    private TextView G;
    private GuildLongFeedContentComponents H;
    private wq0.l I;
    private final GuildLongFeedContentComponents.c J;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements GuildLongFeedContentComponents.c {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public int a() {
            f fVar = f.this;
            return mk1.e.f(fVar.D, fVar.C);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @Nullable
        public IParseRichTextConfig<GProStRichTextContent> b(@NonNull Context context) {
            return null;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public void c(@Nullable View view, @NonNull String str) {
            f.this.c(view, str);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public float d() {
            return 26.0f;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @Nullable
        public IParseRichTextConfig<GProStRichTextContent> e(@NonNull Context context) {
            return null;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public float f() {
            return 18.0f;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public float g() {
            return 26.0f;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @NonNull
        public GuildFeedBaseInitBean getInitBean() {
            return f.this.D;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @NonNull
        public View getRootView() {
            return f.this.f222805m;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public int h() {
            return 600;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public float i() {
            return 16.0f;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @Nullable
        public xj1.f j() {
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @NonNull
        public List<String> k() {
            return ((ij1.g) f.this.f222800d).o();
        }
    }

    public f(GuildFeedDefaultInitBean guildFeedDefaultInitBean) {
        super(guildFeedDefaultInitBean);
        this.I = null;
        this.J = new a();
    }

    @Override // eo1.a
    public void a() {
        this.H.K();
    }

    @Override // eo1.a
    public GuildFeedListBaseVideoView d() {
        return this.H.y();
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void m() {
        this.H.E();
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void o(@NonNull View view) {
        super.o(view);
        gj1.a.a().d().requestPreloadViewForViewStub((ViewStub) view.findViewById(R.id.wat), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            i(((ij1.g) this.f222800d).b(), 0, 1);
            p(new com.tencent.mobileqq.guild.feed.event.a(1));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter, com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.RequestPreloadViewListener
    public void onPreloadResult(View view) {
        super.onPreloadResult(view);
        this.F = (RelativeLayout) view.findViewById(R.id.war);
        this.G = (TextView) view.findViewById(R.id.wbj);
        GuildLongFeedContentComponents guildLongFeedContentComponents = new GuildLongFeedContentComponents(this.J);
        this.H = guildLongFeedContentComponents;
        guildLongFeedContentComponents.F(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // eo1.a
    public void pause() {
        QLog.d("Guild_Feed_GuildFeedChildLongContentPresenter", 1, "[pause] pos = " + this.f222801e + " " + ((ij1.g) this.f222800d).b().idd + " ");
        this.H.I();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // eo1.a
    public void play() {
        this.H.J();
        QLog.d("Guild_Feed_GuildFeedChildLongContentPresenter", 1, "[play] pos = " + this.f222801e + " " + ((ij1.g) this.f222800d).b().idd);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void k(ij1.g gVar, int i3) {
        super.k(gVar, i3);
        if (gVar != null && gVar.b() != null) {
            this.H.C(gVar, i3, null);
            if (h()) {
                c(this.f222805m, "em_sgrp_forum_feed");
            }
        }
    }
}
