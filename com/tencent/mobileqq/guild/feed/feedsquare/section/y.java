package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.mobileqq.guild.feed.feedsquare.section.h;
import com.tencent.mobileqq.guild.feed.guildpanel.prefer.GuildFeedUserPreferListFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J*\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u001a\u0010\u001f\u001a\u00060\u001bj\u0002`\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/y;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "newStFeed", "", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "", "position", "", "", "payload", "", "M", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "stFeed", ExifInterface.LATITUDE_SOUTH, "attached", "onAttachedChanged", "", "v", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "e", "Lqj1/h;", "lastFeedInfo", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h;", "f", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h;", "components", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class y extends GuildFeedSquareFeedBaseSection implements Observer<GProStFeed> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private qj1.h lastFeedInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h components = new h(new a(), false, 2, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/y$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h$b;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements h.b {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.h.b
        public void a(@NotNull View rootView, @NotNull GProStFeed stFeed) {
            FragmentManager fragmentManager;
            FragmentManager fragmentManager2;
            FragmentActivity fragmentActivity;
            com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> context;
            Fragment fragment;
            FragmentActivity requireActivity;
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Intrinsics.checkNotNullParameter(stFeed, "stFeed");
            com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g gVar = (com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g) SectionIOCKt.getIocInterface(y.this, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g.class);
            FragmentManager fragmentManager3 = null;
            if (gVar != null && (context = gVar.getContext()) != null && (fragment = context.getFragment()) != null && (requireActivity = fragment.requireActivity()) != null) {
                fragmentManager = requireActivity.getSupportFragmentManager();
            } else {
                fragmentManager = null;
            }
            if (fragmentManager == null) {
                Context context2 = rootView.getContext();
                if (context2 instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) context2;
                } else {
                    fragmentActivity = null;
                }
                if (fragmentActivity != null) {
                    fragmentManager3 = fragmentActivity.getSupportFragmentManager();
                }
                fragmentManager2 = fragmentManager3;
            } else {
                fragmentManager2 = fragmentManager;
            }
            QLog.d(y.this.v(), 1, fragmentManager2);
            if (fragmentManager2 != null) {
                y yVar = y.this;
                GuildFeedUserPreferListFragment.INSTANCE.a(fragmentManager2, stFeed, yVar.p(), yVar.r(), "pg_sgrp_channel_feed");
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

    private final boolean R(GProStFeed newStFeed) {
        qj1.h hVar;
        if (this.mData != 0 && (hVar = this.lastFeedInfo) != null) {
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

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        GProStFeed D = D();
        if (D == null) {
            return;
        }
        GProStFeedDetailRspWrapper gProStFeedDetailRspWrapper = new GProStFeedDetailRspWrapper(D, null, 2, null);
        this.lastFeedInfo = gProStFeedDetailRspWrapper;
        this.components.k(gProStFeedDetailRspWrapper, position, payload);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable GProStFeed stFeed) {
        String str;
        String v3 = v();
        if (stFeed != null) {
            str = stFeed.idd;
        } else {
            str = null;
        }
        QLog.d(v3, 1, "onChanged stFeed id:" + str);
        if (stFeed != null && R(stFeed)) {
            this.lastFeedInfo = new GProStFeedDetailRspWrapper(stFeed, null, 2, null);
            this.components.l(stFeed);
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
        GProStFeed D = D();
        if (D != null && !TextUtils.isEmpty(D.idd)) {
            if (attached) {
                jj1.b.c().observerGlobalState(D, this);
            } else {
                jj1.b.c().removeObserverGlobalState(D, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.components.m(containerView);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.n
    @NotNull
    public String v() {
        return "GuildFeedSquareFeedPreferSection";
    }
}
