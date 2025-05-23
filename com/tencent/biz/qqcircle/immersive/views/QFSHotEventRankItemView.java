package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.beans.HotEventInfo;
import com.tencent.biz.qqcircle.beans.HotEventInfoKt;
import com.tencent.biz.qqcircle.beans.QCircleHotEventPolymerizationBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StHotTagInfo;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StVideo;
import feedcloud.FeedCloudRead$HotTagRankItem;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001LB\u001d\b\u0007\u0012\u0006\u0010F\u001a\u00020E\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G\u00a2\u0006\u0004\bI\u0010JJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001e\u0010\u0011\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0007\u001a\u00020\u0010H\u0002J(\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0010H\u0002J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0010H\u0002J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0010H\u0002J \u0010 \u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J,\u0010%\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00032\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030#H\u0002J4\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J,\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010)\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\nH\u0016J\b\u0010-\u001a\u00020\u0003H\u0014J\u001a\u0010/\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u00020\nH\u0014R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00109\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0014\u0010;\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00106R\u0014\u0010>\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010A\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00130\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006M"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/QFSHotEventRankItemView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Lfeedcloud/FeedCloudRead$HotTagRankItem;", "", "title", QQWinkConstants.TAB_SUBTITLE, "Lfeedcloud/FeedCloudMeta$StHotTagInfo;", "hotEventInfo", "", "y0", "", "rank", "v0", "", "Lfeedcloud/FeedCloudMeta$StFeed;", "feeds", "Lcom/tencent/biz/qqcircle/beans/HotEventInfo;", "u0", "feed", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "imageView", "index", "w0", "Landroid/view/View;", "itemView", "q0", "Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;", "p0", "actionType", "subActionType", "Lcooperation/qqcircle/report/QCircleLpReportDc05507$DataBuilder;", "builder", "r0", "view", "eid", "", "params", "s0", "eventId", "name", "n0", "videoId", "position", "o0", "getLayoutId", "getLogTag", "hotTagRankItem", "m0", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "hotEventRankIv", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "hotEventRankTv", "f", "hotEventTitleTv", tl.h.F, "hotEventWatchCountTv", "i", "Landroid/view/View;", "titleBar", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "corner", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "videoCovers", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSHotEventRankItemView extends QCircleBaseWidgetView<FeedCloudRead$HotTagRankItem> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<RoundCornerImageView> videoCovers;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView hotEventRankIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView hotEventRankTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView hotEventTitleTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView hotEventWatchCountTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View titleBar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int corner;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSHotEventRankItemView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Map<String, String> n0(String eventId, int rank, String name, String subTitle) {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_HOT_TOPIC_ID, eventId), TuplesKt.to("xsj_hot_topic_index", String.valueOf(rank)), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_HOT_TOPIC_NAME, name), TuplesKt.to("xsj_hot_topic_vv", subTitle));
        return mapOf;
    }

    private final Map<String, String> o0(String videoId, String eventId, int position) {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("xsj_feed_id", videoId), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_HOT_TOPIC_ID, eventId), TuplesKt.to("xsj_hot_display_index", String.valueOf(position)));
        return mapOf;
    }

    private final QCircleLayerBean p0(FeedCloudMeta$StFeed feed, HotEventInfo hotEventInfo) {
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setFeed(feed);
        qCircleLayerBean.setHotEventInfo(hotEventInfo);
        qCircleLayerBean.setGetFeedList(true);
        qCircleLayerBean.setSourceType(63);
        return qCircleLayerBean;
    }

    private final void q0(View itemView, FeedCloudMeta$StFeed feed, HotEventInfo hotEventInfo) {
        QCircleLayerBean p06 = p0(feed, hotEventInfo);
        int[] iArr = new int[2];
        itemView.getLocationInWindow(iArr);
        QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
        int i3 = iArr[0];
        p06.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i3, iArr[1], itemView.getWidth() + i3, iArr[1] + itemView.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(feed.cover.picUrl.get()));
        if (itemView instanceof ImageView) {
            p06.getTransitionAnimBean().setCoverDrawable(((ImageView) itemView).getDrawable());
        }
        com.tencent.biz.qqcircle.launcher.c.u(getContext(), p06);
    }

    private final void r0(int actionType, int subActionType, QCircleLpReportDc05507.DataBuilder builder) {
        builder.setPageId(302);
        builder.setActionType(actionType);
        builder.setSubActionType(subActionType);
        builder.setExt7(QCircleNativeSessionManager.g().getSession());
        QCircleLpReportDc05507.report(builder);
    }

    private final void s0(View view, String eid, Map<String, String> params) {
        VideoReport.setElementId(view, eid);
        VideoReport.setElementParams(view, params);
    }

    private final void u0(List<FeedCloudMeta$StFeed> feeds, HotEventInfo hotEventInfo) {
        Object orNull;
        int i3 = 0;
        for (Object obj : this.videoCovers) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            RoundCornerImageView roundCornerImageView = (RoundCornerImageView) obj;
            orNull = CollectionsKt___CollectionsKt.getOrNull(feeds, i3);
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) orNull;
            if (feedCloudMeta$StFeed != null) {
                w0(feedCloudMeta$StFeed, roundCornerImageView, i3, hotEventInfo);
            }
            i3 = i16;
        }
    }

    private final void v0(int rank) {
        int i3;
        if (rank <= 3) {
            this.hotEventRankTv.setVisibility(8);
            this.hotEventRankIv.setVisibility(0);
            if (rank != 1) {
                if (rank != 2) {
                    i3 = R.drawable.ot9;
                } else {
                    i3 = R.drawable.ot8;
                }
            } else {
                i3 = R.drawable.ot7;
            }
            this.hotEventRankIv.setImageResource(i3);
            return;
        }
        this.hotEventRankIv.setVisibility(8);
        this.hotEventRankTv.setVisibility(0);
        this.hotEventRankTv.setText(String.valueOf(rank));
    }

    private final void w0(final FeedCloudMeta$StFeed feed, final RoundCornerImageView imageView, int index, final HotEventInfo hotEventInfo) {
        String str;
        FeedCloudMeta$StImage feedCloudMeta$StImage;
        PBStringField pBStringField;
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        PBStringField pBStringField2;
        FeedCloudMeta$StVideo feedCloudMeta$StVideo2 = feed.video;
        String str2 = null;
        if (feedCloudMeta$StVideo2 != null && (feedCloudMeta$StVideo = feedCloudMeta$StVideo2.get()) != null && (pBStringField2 = feedCloudMeta$StVideo.fileId) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "-1";
        }
        int i3 = index + 1;
        final QCircleLpReportDc05507.DataBuilder dataBuilder = ua0.c.c(feed);
        dataBuilder.setExt2(hotEventInfo.getId());
        dataBuilder.setExt4(String.valueOf(hotEventInfo.getRank()));
        FeedCloudMeta$StImage feedCloudMeta$StImage2 = feed.cover;
        if (feedCloudMeta$StImage2 != null && (feedCloudMeta$StImage = feedCloudMeta$StImage2.get()) != null && (pBStringField = feedCloudMeta$StImage.picUrl) != null) {
            str2 = pBStringField.get();
        }
        com.tencent.biz.qqcircle.utils.j.a(imageView, str2, 121.0f, 148.0f);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSHotEventRankItemView.x0(QFSHotEventRankItemView.this, imageView, feed, hotEventInfo, dataBuilder, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(dataBuilder, "dataBuilder");
        r0(604, 1, dataBuilder);
        s0(imageView, "em_xsj_hot_topic_video", o0(str, hotEventInfo.getId(), i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(QFSHotEventRankItemView this$0, RoundCornerImageView imageView, FeedCloudMeta$StFeed feed, HotEventInfo hotEventInfo, QCircleLpReportDc05507.DataBuilder dataBuilder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(hotEventInfo, "$hotEventInfo");
        this$0.q0(imageView, feed, hotEventInfo);
        Intrinsics.checkNotNullExpressionValue(dataBuilder, "dataBuilder");
        this$0.r0(604, 2, dataBuilder);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void y0(String title, String subTitle, final FeedCloudMeta$StHotTagInfo hotEventInfo) {
        String hotEventId = hotEventInfo.f398452id.get();
        int i3 = hotEventInfo.rank.get();
        this.hotEventTitleTv.setText(title);
        this.hotEventWatchCountTv.setText(subTitle);
        final QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder();
        dataBuilder.setExt2(hotEventId);
        dataBuilder.setExt4(String.valueOf(i3));
        this.titleBar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSHotEventRankItemView.z0(FeedCloudMeta$StHotTagInfo.this, this, dataBuilder, view);
            }
        });
        r0(603, 1, dataBuilder);
        View view = this.titleBar;
        Intrinsics.checkNotNullExpressionValue(hotEventId, "hotEventId");
        s0(view, "em_xsj_hot_topic_entrance", n0(hotEventId, i3, title, subTitle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(FeedCloudMeta$StHotTagInfo hotEventInfo, QFSHotEventRankItemView this$0, QCircleLpReportDc05507.DataBuilder dcDataBuilder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(hotEventInfo, "$hotEventInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dcDataBuilder, "$dcDataBuilder");
        com.tencent.biz.qqcircle.launcher.c.j0(view.getContext(), new QCircleHotEventPolymerizationBean(HotEventInfoKt.toHotEventInfo(hotEventInfo)));
        this$0.r0(603, 2, dcDataBuilder);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gdg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QCircleHotEventRankItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(@Nullable FeedCloudRead$HotTagRankItem hotTagRankItem, int position) {
        FeedCloudMeta$StHotTagInfo feedCloudMeta$StHotTagInfo;
        String str;
        String str2;
        int i3;
        FeedCloudMeta$StHotTagInfo feedCloudMeta$StHotTagInfo2;
        List<FeedCloudMeta$StFeed> list = null;
        if (hotTagRankItem != null && (feedCloudMeta$StHotTagInfo2 = hotTagRankItem.info) != null) {
            feedCloudMeta$StHotTagInfo = feedCloudMeta$StHotTagInfo2.get();
        } else {
            feedCloudMeta$StHotTagInfo = null;
        }
        if (feedCloudMeta$StHotTagInfo == null) {
            QLog.e("QCircleHotEventRankItemView", 1, "bindData info is null");
            return;
        }
        PBStringField pBStringField = feedCloudMeta$StHotTagInfo.title;
        if (pBStringField != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            QLog.e("QCircleHotEventRankItemView", 1, "title cannot be null");
            str = "";
        }
        PBStringField pBStringField2 = feedCloudMeta$StHotTagInfo.subTitle;
        if (pBStringField2 != null) {
            str2 = pBStringField2.get();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            QLog.e("QCircleHotEventRankItemView", 1, "subTitle cannot be null");
        } else {
            str3 = str2;
        }
        PBUInt32Field pBUInt32Field = feedCloudMeta$StHotTagInfo.rank;
        if (pBUInt32Field != null) {
            i3 = pBUInt32Field.get();
        } else {
            i3 = position + 1;
        }
        y0(str, str3, feedCloudMeta$StHotTagInfo);
        v0(i3);
        PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField = hotTagRankItem.feedList;
        if (pBRepeatMessageField != null) {
            list = pBRepeatMessageField.get();
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        u0(list, HotEventInfoKt.toHotEventInfo(feedCloudMeta$StHotTagInfo));
    }

    public /* synthetic */ QFSHotEventRankItemView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSHotEventRankItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        List<RoundCornerImageView> listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.f70473lj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ranking_iv)");
        this.hotEventRankIv = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f70483lk);
        TextView textView = (TextView) findViewById2;
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<TextView>(R\u2026peface.DEFAULT_BOLD\n    }");
        this.hotEventRankTv = textView;
        View findViewById3 = findViewById(R.id.jq_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.title_tv)");
        this.hotEventTitleTv = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f167120l10);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.watch_count)");
        this.hotEventWatchCountTv = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.jo9);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.title_bar)");
        this.titleBar = findViewById5;
        int a16 = cx.a(4.0f);
        this.corner = a16;
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById(R.id.f11729712);
        roundCornerImageView.setCorner(a16);
        Unit unit = Unit.INSTANCE;
        RoundCornerImageView roundCornerImageView2 = (RoundCornerImageView) findViewById(R.id.f11730713);
        roundCornerImageView2.setCorner(a16);
        RoundCornerImageView roundCornerImageView3 = (RoundCornerImageView) findViewById(R.id.f11731714);
        roundCornerImageView3.setCorner(a16);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new RoundCornerImageView[]{roundCornerImageView, roundCornerImageView2, roundCornerImageView3});
        this.videoCovers = listOf;
    }
}
