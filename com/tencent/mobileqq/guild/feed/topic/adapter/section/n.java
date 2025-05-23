package com.tencent.mobileqq.guild.feed.topic.adapter.section;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.feed.feedsquare.section.h;
import com.tencent.mobileqq.guild.feed.guildpanel.prefer.GuildFeedUserPreferListFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0014J(\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0014J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0006H\u0016R\u001a\u0010\u001d\u001a\u00060\u0019j\u0002`\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/n;", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/b;", "Lvn1/b;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "newStFeed", "", "r", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "", "position", "", "", "payload", ReportConstant.COSTREPORT_PREFIX, "t", "attached", "onAttachedChanged", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "d", "Lqj1/h;", "lastFeedInfo", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h;", "components", "<init>", "()V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class n extends com.tencent.mobileqq.guild.feed.topic.adapter.section.b<vn1.b> implements Observer<GProStFeed> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private qj1.h lastFeedInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.section.h components = new com.tencent.mobileqq.guild.feed.feedsquare.section.h(new b(), false, 2, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/topic/adapter/section/n$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/h$b;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements h.b {
        b() {
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
            com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g gVar = (com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g) SectionIOCKt.getIocInterface(n.this, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g.class);
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
            QLog.d("TopicFeedPreferSection", 1, fragmentManager2);
            if (fragmentManager2 != null) {
                n nVar = n.this;
                GuildFeedUserPreferListFragment.Companion companion = GuildFeedUserPreferListFragment.INSTANCE;
                xn1.e eVar = xn1.e.f448187a;
                Object mData = ((Section) nVar).mData;
                Intrinsics.checkNotNullExpressionValue(mData, "mData");
                companion.a(fragmentManager2, stFeed, 20, eVar.g((vn1.b) mData), "pg_sgrp_forum_topic");
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

    private final GProStFeed q(vn1.b data) {
        Object obj;
        qj1.h d16 = data.d();
        if (d16 != null) {
            obj = d16.a();
        } else {
            obj = null;
        }
        if (!(obj instanceof GProStFeed)) {
            return null;
        }
        return (GProStFeed) obj;
    }

    private final boolean r(GProStFeed newStFeed) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        GProStFeed q16 = q((vn1.b) mData);
        if (q16 != null && !TextUtils.isEmpty(q16.idd)) {
            if (attached) {
                jj1.b.c().observerGlobalState(q16, this);
            } else {
                jj1.b.c().removeObserverGlobalState(q16, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.components.m(containerView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull vn1.b data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        GProStFeed q16 = q(data);
        if (q16 != null) {
            this.lastFeedInfo = new GProStFeedDetailRspWrapper(q16, null, 2, 0 == true ? 1 : 0);
        }
        this.components.k(data.d(), position, payload);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable GProStFeed newStFeed) {
        if (newStFeed != null && r(newStFeed)) {
            this.lastFeedInfo = new GProStFeedDetailRspWrapper(newStFeed, null, 2, 0 == true ? 1 : 0);
            this.components.l(newStFeed);
        }
    }
}
