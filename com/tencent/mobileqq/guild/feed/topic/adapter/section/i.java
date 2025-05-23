package com.tencent.mobileqq.guild.feed.topic.adapter.section;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.feed.feedsquare.section.d;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.transfile.report.ReportConstant;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0005H\u0014J(\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0014J\u0012\u0010\u001b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\rH\u0016R\u001a\u0010\"\u001a\u00060\u001ej\u0002`\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/i;", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/b;", "Lvn1/b;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "Landroid/view/View;", "commentContainer", "", "", "commentItemReportMap", "", ReportConstant.COSTREPORT_PREFIX, "newStFeed", "", "w", "data", "v", "", "getViewStubLayoutId", "containerView", "onInitView", "", "position", "", "", "payload", HippyTKDListViewAdapter.X, "y", "attached", "onAttachedChanged", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "d", "Lqj1/h;", "lastFeedInfo", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/d;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/d;", "components", "<init>", "()V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i extends com.tencent.mobileqq.guild.feed.topic.adapter.section.b<vn1.b> implements Observer<GProStFeed> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private qj1.h lastFeedInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.section.d components = new com.tencent.mobileqq.guild.feed.feedsquare.section.d(new b());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/topic/adapter/section/i$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/d$c;", "Landroid/view/View;", "commentContainer", "", "", "commentItemReportMap", "", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements d.c {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.d.c
        public void a(@NotNull View commentContainer, @NotNull Map<String, ? extends View> commentItemReportMap) {
            Intrinsics.checkNotNullParameter(commentContainer, "commentContainer");
            Intrinsics.checkNotNullParameter(commentItemReportMap, "commentItemReportMap");
            i.this.s(commentContainer, commentItemReportMap);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.d.c
        public void b(@NotNull GProStFeed stFeed) {
            Intrinsics.checkNotNullParameter(stFeed, "stFeed");
            xj1.a aVar = (xj1.a) SectionIOCKt.getIocInterface(i.this, xj1.a.class);
            if (aVar != null) {
                aVar.a(stFeed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void s(View commentContainer, final Map<String, ? extends View> commentItemReportMap) {
        VideoReport.setEventType(commentContainer, EventAgingType.REALTIME);
        if1.a.b(commentContainer, "em_sgrp_overt_comment_box", ((vn1.b) this.mData).hashCode() + "#" + commentContainer.hashCode(), null, null, null, null, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.topic.adapter.section.g
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map t16;
                t16 = i.t(commentItemReportMap, str);
                return t16;
            }
        }, 124, null);
        for (Map.Entry<String, ? extends View> entry : commentItemReportMap.entrySet()) {
            final String key = entry.getKey();
            View value = entry.getValue();
            VideoReport.setEventType(value, EventAgingType.REALTIME);
            if1.a.b(value, "em_sgrp_overt_comment", ((vn1.b) this.mData).hashCode() + "#" + commentContainer.hashCode() + key, null, null, null, null, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.topic.adapter.section.h
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map u16;
                    u16 = i.u(key, str);
                    return u16;
                }
            }, 124, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map t(Map commentItemReportMap, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(commentItemReportMap, "$commentItemReportMap");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_overt_comment_box_num", Integer.valueOf(commentItemReportMap.size())));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map u(String key, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(key, "$key");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_comment_id", key));
        return mapOf;
    }

    private final GProStFeed v(vn1.b data) {
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

    private final boolean w(GProStFeed newStFeed) {
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
        return this.components.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        GProStFeed v3 = v((vn1.b) mData);
        if (v3 != null && !TextUtils.isEmpty(v3.idd)) {
            if (attached) {
                jj1.b.c().observerGlobalState(v3, this);
            } else {
                jj1.b.c().removeObserverGlobalState(v3, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.components.k(containerView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull vn1.b data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        GProStFeed v3 = v(data);
        if (v3 != null) {
            this.lastFeedInfo = new GProStFeedDetailRspWrapper(v3, null, 2, 0 == true ? 1 : 0);
        }
        this.components.i(data.d(), position, payload);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable GProStFeed newStFeed) {
        if (newStFeed != null && w(newStFeed)) {
            this.lastFeedInfo = new GProStFeedDetailRspWrapper(newStFeed, null, 2, 0 == true ? 1 : 0);
            this.components.j(newStFeed);
        }
    }
}
