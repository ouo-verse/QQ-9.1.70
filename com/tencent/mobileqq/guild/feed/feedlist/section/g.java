package com.tencent.mobileqq.guild.feed.feedlist.section;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.feed.feedsquare.section.h;
import com.tencent.mobileqq.guild.feed.guildpanel.prefer.GuildFeedUserPreferListFragment;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rj1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J0\u0010\u0017\u001a\u00020\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0014J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0007H\u0016R\u001a\u0010\u001e\u001a\u00060\u001bj\u0002`\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/g;", "Lrj1/b;", "Ext", "Ltk1/a;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "newStFeed", "", "D", BdhLogUtil.LogTag.Tag_Conn, "", "getViewStubLayoutId", "Landroid/view/View;", "initContainerView", "", "onInitView", "Ltk1/c;", "bindData", "", "position", "", "", "payload", "u", UserInfo.SEX_FEMALE, "attached", "onAttachedChanged", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "Lqj1/h;", "lastFeedInfo", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h;", "components", "<init>", "()V", "E", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g<Ext extends rj1.b> extends tk1.a<Ext> implements Observer<GProStFeed> {

    /* renamed from: C, reason: from kotlin metadata */
    private qj1.h lastFeedInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.section.h components;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/g$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h$b;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements h.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g<Ext> f218596a;

        b(g<Ext> gVar) {
            this.f218596a = gVar;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.h.b
        public void a(@NotNull View rootView, @NotNull GProStFeed stFeed) {
            FragmentActivity fragmentActivity;
            GProStFeed C;
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Intrinsics.checkNotNullParameter(stFeed, "stFeed");
            Context context = rootView.getContext();
            FragmentManager fragmentManager = null;
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                fragmentManager = fragmentActivity.getSupportFragmentManager();
            }
            FragmentManager fragmentManager2 = fragmentManager;
            if (fragmentManager2 != null && (C = this.f218596a.C()) != null) {
                g<Ext> gVar = this.f218596a;
                GuildFeedUserPreferListFragment.INSTANCE.a(fragmentManager2, C, g.A(gVar).getBusinessType(), rj1.a.f431544a.d(gVar.r(), g.A(gVar)), "pg_sgrp_social_recommend");
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.h.b
        public void b(@NotNull View rootView, @NotNull GProStFeed stFeed) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Intrinsics.checkNotNullParameter(stFeed, "stFeed");
            VideoReport.setEventType(rootView, EventAgingType.REALTIME);
            String str = stFeed.idd;
            Intrinsics.checkNotNullExpressionValue(str, "stFeed.idd");
            if1.a.b(rootView, "em_sgrp_overt_like_frame", str, null, null, null, null, null, null, 252, null);
        }
    }

    public g() {
        super(FeedListSectionType.Prefer);
        this.components = new com.tencent.mobileqq.guild.feed.feedsquare.section.h(new b(this), false, 2, null);
    }

    public static final /* synthetic */ rj1.b A(g gVar) {
        return (rj1.b) gVar.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GProStFeed C() {
        Object a16 = r().a();
        if (a16 instanceof GProStFeed) {
            return (GProStFeed) a16;
        }
        return null;
    }

    private final boolean D(GProStFeed newStFeed) {
        qj1.h hVar = this.lastFeedInfo;
        if (hVar != null) {
            String str = newStFeed.idd;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lastFeedInfo");
                hVar = null;
            }
            if (Intrinsics.areEqual(str, hVar.getFeedId())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable GProStFeed newStFeed) {
        if (newStFeed != null && D(newStFeed)) {
            this.lastFeedInfo = new GProStFeedDetailRspWrapper(newStFeed, null, 2, 0 == true ? 1 : 0);
            this.components.l(newStFeed);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.g();
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        GProStFeed C = C();
        if (C != null && !TextUtils.isEmpty(C.idd)) {
            if (attached) {
                jj1.b.c().observerGlobalState(C, this);
            } else {
                jj1.b.c().removeObserverGlobalState(C, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        com.tencent.mobileqq.guild.feed.feedsquare.section.h hVar = this.components;
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        hVar.m(rootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u */
    public void onBindData(@Nullable tk1.c<Ext> bindData, int position, @Nullable List<Object> payload) {
        super.onBindData(bindData, position, payload);
        GProStFeed C = C();
        if (C != null) {
            this.lastFeedInfo = new GProStFeedDetailRspWrapper(C, null, 2, 0 == true ? 1 : 0);
        }
        this.components.k(r(), position, payload);
    }
}
