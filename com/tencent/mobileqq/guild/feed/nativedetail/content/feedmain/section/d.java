package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section;

import android.content.Context;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quitagview.QUITagIcon;
import com.tencent.biz.qui.quitagview.QUITagSize;
import com.tencent.biz.qui.quitagview.QUITagType;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.biz.qui.quitagview.QUITagViewConfig;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0002J4\u0010\u0014\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0002H\u0014R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001a\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/e;", "Landroid/view/View;", "view", "", "isClick", "", "", "params", "", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "data", "", "position", "", "", "payloads", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$c;", "payload", "t", "", "getViewStubLayoutId", "containerView", "onInitView", "d", "Landroid/view/View;", "approvalStatusContainer", "Lcom/tencent/biz/qui/quitagview/QUITagView;", "e", "Lcom/tencent/biz/qui/quitagview/QUITagView;", "approvalStatusTag", "f", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View approvalStatusContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUITagView approvalStatusTag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View rootView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(QUITagView this_apply, FeedDetailMainData feedDetailMainData, d this$0, View view) {
        Map<String, Object> map;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PageInfo nearestPageInfoWithPgId = ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).getNearestPageInfoWithPgId(this_apply);
        if (nearestPageInfoWithPgId != null) {
            map = ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).getPageInfoParams(nearestPageInfoWithPgId);
        } else {
            map = null;
        }
        GuildFeedPublishUtils guildFeedPublishUtils = GuildFeedPublishUtils.f222315a;
        Context context = this_apply.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Object a16 = feedDetailMainData.getFeedDetail().a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
        guildFeedPublishUtils.A(context, (GProStFeed) a16, map);
        this$0.x(this_apply, true, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void x(View view, boolean isClick, Map<String, ?> params) {
        String str;
        if (isClick) {
            str = "clck";
        } else {
            str = "imp";
        }
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        if (params == null) {
            params = new HashMap<>();
        }
        iGuildDTReportApi.reportDtEventManual(view, "em_sgrp_violation_tip", str, params);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.suz};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.rootView = containerView;
        this.approvalStatusContainer = containerView.findViewById(R.id.w7r);
        this.approvalStatusTag = (QUITagView) containerView.findViewById(R.id.vyp);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    protected void t(@Nullable final FeedDetailMainData data, int position, @Nullable List<Object> payloads, @Nullable FeedDetailMainData.c.C7755c payload) {
        View view;
        qj1.h feedDetail;
        Unit unit = null;
        if (data != null && (feedDetail = data.getFeedDetail()) != null) {
            int j3 = feedDetail.j();
            if (j3 != 1) {
                if (j3 != 2) {
                    View view2 = this.approvalStatusContainer;
                    if (view2 != null) {
                        view2.setVisibility(8);
                    }
                } else {
                    final QUITagView qUITagView = this.approvalStatusTag;
                    if (qUITagView != null) {
                        QUITagType qUITagType = QUITagType.COLOR_RED;
                        QUITagSize qUITagSize = QUITagSize.MIDDLE;
                        QUITagIcon qUITagIcon = new QUITagIcon(R.drawable.qui_caution_circle, null, false, 6, null);
                        String string = qUITagView.getResources().getString(R.string.zxv);
                        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.\u2026string.feed_not_approved)");
                        qUITagView.setConfig(new QUITagViewConfig(qUITagType, qUITagSize, qUITagIcon, string));
                        x(qUITagView, false, null);
                        qUITagView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.c
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view3) {
                                d.w(QUITagView.this, data, this, view3);
                            }
                        });
                    }
                    View view3 = this.approvalStatusContainer;
                    if (view3 != null) {
                        view3.setVisibility(0);
                    }
                }
            } else {
                QUITagView qUITagView2 = this.approvalStatusTag;
                if (qUITagView2 != null) {
                    QUITagType qUITagType2 = QUITagType.COLOR_ORANGE;
                    QUITagSize qUITagSize2 = QUITagSize.MIDDLE;
                    QUITagIcon qUITagIcon2 = new QUITagIcon(R.drawable.qui_time, null, false, 6, null);
                    String string2 = qUITagView2.getResources().getString(R.string.zxs);
                    Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(com.\u2026i.R.string.feed_in_audit)");
                    qUITagView2.setConfig(new QUITagViewConfig(qUITagType2, qUITagSize2, qUITagIcon2, string2));
                }
                View view4 = this.approvalStatusContainer;
                if (view4 != null) {
                    view4.setVisibility(0);
                }
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null && (view = this.approvalStatusContainer) != null) {
            view.setVisibility(8);
        }
    }
}
