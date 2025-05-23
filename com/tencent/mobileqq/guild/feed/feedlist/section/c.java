package com.tencent.mobileqq.guild.feed.feedlist.section;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.feed.feedsquare.section.d;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rj1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 **\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0014J0\u0010\u001c\u001a\u00020\u000b2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0014J\u0012\u0010\u001d\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000eH\u0016R\u001a\u0010$\u001a\u00060 j\u0002`!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/c;", "Lrj1/b;", "Ext", "Ltk1/a;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "Landroid/view/View;", "commentContainer", "", "", "commentItemReportMap", "", "B", "newStFeed", "", UserInfo.SEX_FEMALE, "D", "", "getViewStubLayoutId", "initContainerView", "onInitView", "Ltk1/c;", "bindData", "", "position", "", "", "payload", "u", "G", "attached", "onAttachedChanged", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", BdhLogUtil.LogTag.Tag_Conn, "Lqj1/h;", "lastFeedInfo", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/d;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/d;", "components", "<init>", "()V", "E", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class c<Ext extends rj1.b> extends tk1.a<Ext> implements Observer<GProStFeed> {

    /* renamed from: C, reason: from kotlin metadata */
    private qj1.h lastFeedInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.section.d components;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/c$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/d$c;", "Landroid/view/View;", "commentContainer", "", "", "commentItemReportMap", "", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements d.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c<Ext> f218593a;

        b(c<Ext> cVar) {
            this.f218593a = cVar;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.d.c
        public void a(@NotNull View commentContainer, @NotNull Map<String, ? extends View> commentItemReportMap) {
            Intrinsics.checkNotNullParameter(commentContainer, "commentContainer");
            Intrinsics.checkNotNullParameter(commentItemReportMap, "commentItemReportMap");
            this.f218593a.B(commentContainer, commentItemReportMap);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.d.c
        public void b(@NotNull GProStFeed stFeed) {
            Intrinsics.checkNotNullParameter(stFeed, "stFeed");
            xj1.a aVar = (xj1.a) SectionIOCKt.getIocInterface(this.f218593a, xj1.a.class);
            if (aVar != null) {
                aVar.a(stFeed);
            }
        }
    }

    public c() {
        super(FeedListSectionType.Comment);
        this.components = new com.tencent.mobileqq.guild.feed.feedsquare.section.d(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(View commentContainer, Map<String, ? extends View> commentItemReportMap) {
        VideoReport.setEventType(commentContainer, EventAgingType.REALTIME);
        if1.a.b(commentContainer, "em_sgrp_overt_comment_box", r().hashCode() + "#" + commentContainer.hashCode(), null, null, null, null, null, null, 252, null);
        for (Map.Entry<String, ? extends View> entry : commentItemReportMap.entrySet()) {
            final String key = entry.getKey();
            View value = entry.getValue();
            VideoReport.setEventType(value, EventAgingType.REALTIME);
            if1.a.b(value, "em_sgrp_overt_comment", r().hashCode() + "#" + commentContainer.hashCode(), null, null, null, null, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.b
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map C;
                    C = c.C(key, str);
                    return C;
                }
            }, 124, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map C(String key, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(key, "$key");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_comment_id", key));
        return mapOf;
    }

    private final GProStFeed D() {
        Object a16 = r().a();
        if (a16 instanceof GProStFeed) {
            return (GProStFeed) a16;
        }
        return null;
    }

    private final boolean F(GProStFeed newStFeed) {
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
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable GProStFeed newStFeed) {
        if (newStFeed != null && F(newStFeed)) {
            this.lastFeedInfo = new GProStFeedDetailRspWrapper(newStFeed, null, 2, 0 == true ? 1 : 0);
            this.components.j(newStFeed);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.e();
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
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        com.tencent.mobileqq.guild.feed.feedsquare.section.d dVar = this.components;
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        dVar.k(rootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u */
    public void onBindData(@Nullable tk1.c<Ext> bindData, int position, @Nullable List<Object> payload) {
        super.onBindData(bindData, position, payload);
        GProStFeed D = D();
        if (D != null) {
            this.lastFeedInfo = new GProStFeedDetailRspWrapper(D, null, 2, 0 == true ? 1 : 0);
        }
        this.components.i(r(), position, payload);
    }
}
