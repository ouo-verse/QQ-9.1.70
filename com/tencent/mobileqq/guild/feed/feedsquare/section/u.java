package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.mobileqq.guild.feed.feedsquare.section.d;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b'\u0010(J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0014J*\u0010\u0019\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0012\u0010\u001c\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016R\u001a\u0010\"\u001a\u00060\u001ej\u0002`\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/u;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "Landroid/view/View;", "commentContainer", "", "", "commentItemReportMap", "", "U", "newStFeed", "", "X", "", "getViewStubLayoutId", "containerView", "onInitView", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "", "position", "", "", "payload", "M", "attached", "onAttachedChanged", "Y", "v", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "e", "Lqj1/h;", "lastFeedInfo", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/d;", "f", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/d;", "components", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class u extends GuildFeedSquareFeedBaseSection implements Observer<GProStFeed> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private qj1.h lastFeedInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d components = new d(new a());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/u$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/d$c;", "Landroid/view/View;", "commentContainer", "", "", "commentItemReportMap", "", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements d.c {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.d.c
        public void a(@NotNull View commentContainer, @NotNull Map<String, ? extends View> commentItemReportMap) {
            Intrinsics.checkNotNullParameter(commentContainer, "commentContainer");
            Intrinsics.checkNotNullParameter(commentItemReportMap, "commentItemReportMap");
            u.this.U(commentContainer, commentItemReportMap);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.d.c
        public void b(@NotNull GProStFeed stFeed) {
            Intrinsics.checkNotNullParameter(stFeed, "stFeed");
            xj1.a aVar = (xj1.a) SectionIOCKt.getIocInterface(u.this, xj1.a.class);
            if (aVar != null) {
                aVar.a(stFeed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(View commentContainer, final Map<String, ? extends View> commentItemReportMap) {
        com.tencent.mobileqq.guild.feed.report.d.e(commentContainer, "em_sgrp_overt_comment_box", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_ALL, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.s
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map V;
                V = u.V(u.this, commentItemReportMap, str);
                return V;
            }
        });
        for (Map.Entry<String, ? extends View> entry : commentItemReportMap.entrySet()) {
            final String key = entry.getKey();
            com.tencent.mobileqq.guild.feed.report.d.e(entry.getValue(), "em_sgrp_overt_comment", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_ALL, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.t
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map W;
                    W = u.W(u.this, key, str);
                    return W;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map V(u this$0, Map commentItemReportMap, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(commentItemReportMap, "$commentItemReportMap");
        Map<String, Object> C = this$0.C();
        C.put("sgrp_overt_comment_box_num", Integer.valueOf(commentItemReportMap.size()));
        return C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map W(u this$0, String key, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "$key");
        Map<String, Object> C = this$0.C();
        C.put("sgrp_comment_id", key);
        return C;
    }

    private final boolean X(GProStFeed newStFeed) {
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
        this.components.i(gProStFeedDetailRspWrapper, position, payload);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable GProStFeed newStFeed) {
        if (newStFeed != null && X(newStFeed)) {
            this.lastFeedInfo = new GProStFeedDetailRspWrapper(newStFeed, null, 2, null);
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
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.components.k(containerView);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.n
    @NotNull
    public String v() {
        return "GuildFeedSquareFeedCommentSection";
    }
}
