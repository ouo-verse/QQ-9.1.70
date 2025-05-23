package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import feedcloud.FeedCloudWatchlater$Feed;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 J2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001KB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\u001a\u0010\u001c\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001aH\u0014J\u0012\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0012\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%H\u0014R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00102R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u00102R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010\u001e\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006L"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/QFSWatchLaterItemView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Lfeedcloud/FeedCloudWatchlater$Feed;", "Landroid/view/View$OnClickListener;", "Lfeedcloud/FeedCloudMeta$StFeed;", QCircleScheme.AttrDetail.FEED_INFO, "", "o0", "l0", "objData", "p0", "watchLaterFeed", "", "r0", "timeDuration", "", "q0", "", "hasFinish", "s0", "k0", "Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;", "getDetailInitBean", "n0", "Landroid/content/Context;", "context", "", "viewType", "initView", "getLayoutId", com.tencent.luggage.wxa.c8.c.G, "m0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcooperation/qqcircle/report/QCircleReportBean;", "getReportBean", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lcom/tencent/biz/qqcircle/widgets/QCircleRoundImageView;", "d", "Lcom/tencent/biz/qqcircle/widgets/QCircleRoundImageView;", "coverIv", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "e", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "titleTv", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "timeDescTv", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", tl.h.F, "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "avatarView", "i", "authorNameTv", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/LinearLayout;", "albumTagLayout", BdhLogUtil.LogTag.Tag_Conn, "watchFinishTagView", "Landroid/util/Size;", "D", "Landroid/util/Size;", "defAvatarSize", "E", "Lfeedcloud/FeedCloudWatchlater$Feed;", UserInfo.SEX_FEMALE, "I", "<init>", "(Landroid/content/Context;)V", "G", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSWatchLaterItemView extends QCircleBaseWidgetView<FeedCloudWatchlater$Feed> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView watchFinishTagView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Size defAvatarSize;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private FeedCloudWatchlater$Feed watchLaterFeed;

    /* renamed from: F, reason: from kotlin metadata */
    private int pos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QCircleRoundImageView coverIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QCircleAsyncTextView titleTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView timeDescTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QCircleAvatarView avatarView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView authorNameTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LinearLayout albumTagLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSWatchLaterItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final QCircleLayerBean getDetailInitBean() {
        String str;
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        FeedCloudWatchlater$Feed feedCloudWatchlater$Feed = this.watchLaterFeed;
        if (feedCloudWatchlater$Feed != null) {
            qCircleLayerBean.setFeed(feedCloudWatchlater$Feed.feed_info.get());
        }
        qCircleLayerBean.setUseLoadingPic(true);
        qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
        qCircleLayerBean.setFeedListBusiReqData(new QQCircleFeedBase$StFeedListBusiReqData());
        try {
            qCircleLayerBean.setFromReportBean(getReportBean().m466clone());
        } catch (Exception unused) {
        }
        qCircleLayerBean.setSourceType(ErrorCode.ERROR_SDK_CLI_TYPE_INVALID);
        QCircleExtraTypeInfo qCircleExtraTypeInfo = getQCircleExtraTypeInfo();
        if (qCircleExtraTypeInfo != null) {
            str = qCircleExtraTypeInfo.mGlobalViewModelKey;
        } else {
            str = null;
        }
        qCircleLayerBean.setGlobalViewModelKey(str);
        qCircleLayerBean.setPreRenderType(10014);
        return qCircleLayerBean;
    }

    private final void k0(FeedCloudMeta$StFeed feedInfo) {
        int i3;
        List<FeedCloudMeta$FeedAlbumInfo> list = feedInfo.album_infos.get();
        LinearLayout linearLayout = this.albumTagLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumTagLayout");
            linearLayout = null;
        }
        if (list.isEmpty()) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        linearLayout.setVisibility(i3);
    }

    private final void l0(FeedCloudMeta$StFeed feedInfo) {
        String str;
        if (TextUtils.isEmpty(feedInfo.cover.layerPicUrl.get())) {
            str = feedInfo.cover.picUrl.get();
        } else {
            str = feedInfo.cover.layerPicUrl.get();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Option url = Option.obtain().setUrl(str);
        QCircleRoundImageView qCircleRoundImageView = this.coverIv;
        if (qCircleRoundImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverIv");
            qCircleRoundImageView = null;
        }
        Option requestHeight = url.setTargetView(qCircleRoundImageView).setRequestWidth(cx.a(56.0f)).setRequestHeight(cx.a(74.0f));
        requestHeight.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(requestHeight);
    }

    private final void n0() {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        PBStringField pBStringField;
        VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudWatchlater$Feed feedCloudWatchlater$Feed = this.watchLaterFeed;
        if (feedCloudWatchlater$Feed != null && (feedCloudMeta$StFeed = feedCloudWatchlater$Feed.feed_info) != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_feed_id", str);
        params.put("xsj_index", Integer.valueOf(this.pos + 1));
        VideoReport.setElementReuseIdentifier(this, str + hashCode());
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementParams(this, params);
    }

    private final void o0(FeedCloudMeta$StFeed feedInfo) {
        QCircleAsyncTextView qCircleAsyncTextView = this.titleTv;
        QCircleAvatarView qCircleAvatarView = null;
        if (qCircleAsyncTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            qCircleAsyncTextView = null;
        }
        qCircleAsyncTextView.setIsEllipsizeEnd(true);
        QCircleAsyncTextView qCircleAsyncTextView2 = this.titleTv;
        if (qCircleAsyncTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            qCircleAsyncTextView2 = null;
        }
        qCircleAsyncTextView2.setPreloadParserInfo(uc0.a.b(feedInfo));
        QCircleAsyncTextView qCircleAsyncTextView3 = this.titleTv;
        if (qCircleAsyncTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            qCircleAsyncTextView3 = null;
        }
        qCircleAsyncTextView3.setNeedSpecialAreaBold(false);
        QCircleAsyncTextView qCircleAsyncTextView4 = this.titleTv;
        if (qCircleAsyncTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            qCircleAsyncTextView4 = null;
        }
        qCircleAsyncTextView4.setSpecialClickAreaColor(R.color.qui_common_text_primary);
        QCircleAsyncTextView qCircleAsyncTextView5 = this.titleTv;
        if (qCircleAsyncTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            qCircleAsyncTextView5 = null;
        }
        qCircleAsyncTextView5.setText(feedInfo.content.get());
        TextView textView = this.authorNameTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorNameTv");
            textView = null;
        }
        textView.setText(feedInfo.poster.nick.get());
        QCircleAvatarView qCircleAvatarView2 = this.avatarView;
        if (qCircleAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        } else {
            qCircleAvatarView = qCircleAvatarView2;
        }
        qCircleAvatarView.setUser(feedInfo.poster.get(), this.defAvatarSize);
    }

    private final void p0(FeedCloudWatchlater$Feed objData) {
        String q06 = q0(r0(objData));
        String q07 = q0(objData.feed_info.video.duration.get());
        String str = com.tencent.biz.qqcircle.utils.h.a(R.string.f1911043w) + q06 + "/" + q07;
        TextView textView = this.timeDescTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeDescTv");
            textView = null;
        }
        textView.setText(str);
    }

    private final String q0(long timeDuration) {
        long j3 = timeDuration / 1000;
        long j16 = 60;
        long j17 = j3 / j16;
        long j18 = j3 % j16;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.CHINA, "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j17), Long.valueOf(j18)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return format;
    }

    private final long r0(FeedCloudWatchlater$Feed watchLaterFeed) {
        String N = com.tencent.biz.qqcircle.immersive.utils.r.N(watchLaterFeed.feed_info.video.playUrl.get());
        Long e16 = com.tencent.biz.qqcircle.immersive.manager.f.f().e(N);
        long j3 = watchLaterFeed.watch_time.get();
        if (e16 != null) {
            j3 = e16.longValue();
        }
        com.tencent.biz.qqcircle.immersive.manager.f.f().n(N, Long.valueOf(j3));
        return j3;
    }

    private final void s0(boolean hasFinish) {
        boolean z16;
        PBBoolField pBBoolField;
        boolean z17;
        FeedCloudWatchlater$Feed feedCloudWatchlater$Feed = this.watchLaterFeed;
        int i3 = 0;
        if (feedCloudWatchlater$Feed != null) {
            z16 = com.tencent.biz.qqcircle.immersive.manager.f.f().h(feedCloudWatchlater$Feed.feed_info.f398449id.get());
        } else {
            z16 = false;
        }
        FeedCloudWatchlater$Feed feedCloudWatchlater$Feed2 = this.watchLaterFeed;
        if (feedCloudWatchlater$Feed2 != null && (pBBoolField = feedCloudWatchlater$Feed2.is_completed) != null) {
            if (!hasFinish && !z16) {
                z17 = false;
            } else {
                z17 = true;
            }
            pBBoolField.set(z17);
        }
        TextView textView = this.watchFinishTagView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("watchFinishTagView");
            textView = null;
        }
        if (!hasFinish && !z16) {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gtx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(@Nullable Context context, int viewType) {
        super.initView(context, viewType);
        View findViewById = getRootView().findViewById(R.id.f57592nq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026s_watch_later_item_cover)");
        this.coverIv = (QCircleRoundImageView) findViewById;
        View findViewById2 = getRootView().findViewById(R.id.f57622nt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026s_watch_later_item_title)");
        this.titleTv = (QCircleAsyncTextView) findViewById2;
        View findViewById3 = getRootView().findViewById(R.id.f57612ns);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026fs_watch_later_item_time)");
        this.timeDescTv = (TextView) findViewById3;
        View findViewById4 = getRootView().findViewById(R.id.f57582np);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026_watch_later_item_avatar)");
        this.avatarView = (QCircleAvatarView) findViewById4;
        View findViewById5 = getRootView().findViewById(R.id.f57572no);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026h_later_item_author_name)");
        this.authorNameTv = (TextView) findViewById5;
        View findViewById6 = getRootView().findViewById(R.id.f57552nm);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026tch_later_item_album_tag)");
        this.albumTagLayout = (LinearLayout) findViewById6;
        View findViewById7 = getRootView().findViewById(R.id.f57602nr);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026ch_later_item_finish_tag)");
        this.watchFinishTagView = (TextView) findViewById7;
        this.defAvatarSize = com.tencent.biz.qqcircle.immersive.utils.n.a(context, R.dimen.d38);
        QCircleRoundImageView qCircleRoundImageView = this.coverIv;
        if (qCircleRoundImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverIv");
            qCircleRoundImageView = null;
        }
        qCircleRoundImageView.setRoundRect(cx.a(4.0f));
        setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(@NotNull FeedCloudWatchlater$Feed objData, int pos) {
        Intrinsics.checkNotNullParameter(objData, "objData");
        this.watchLaterFeed = objData;
        this.pos = pos;
        FeedCloudMeta$StFeed feedInfo = objData.feed_info.get();
        Intrinsics.checkNotNullExpressionValue(feedInfo, "feedInfo");
        o0(feedInfo);
        l0(feedInfo);
        p0(objData);
        k0(feedInfo);
        s0(objData.is_completed.get());
        n0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        long j3;
        long j16;
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        PBStringField pBStringField;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        FeedCloudMeta$StVideo feedCloudMeta$StVideo2;
        PBUInt32Field pBUInt32Field;
        PBUInt64Field pBUInt64Field;
        PBBoolField pBBoolField;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            FeedCloudWatchlater$Feed feedCloudWatchlater$Feed = this.watchLaterFeed;
            boolean z16 = false;
            if (feedCloudWatchlater$Feed != null && (pBBoolField = feedCloudWatchlater$Feed.is_completed) != null && pBBoolField.get()) {
                z16 = true;
            }
            if (z16) {
                FeedCloudWatchlater$Feed feedCloudWatchlater$Feed2 = this.watchLaterFeed;
                if (feedCloudWatchlater$Feed2 != null && (pBUInt64Field = feedCloudWatchlater$Feed2.watch_time) != null) {
                    j3 = pBUInt64Field.get();
                } else {
                    j3 = 0;
                }
                FeedCloudWatchlater$Feed feedCloudWatchlater$Feed3 = this.watchLaterFeed;
                if (feedCloudWatchlater$Feed3 != null && (feedCloudMeta$StFeed2 = feedCloudWatchlater$Feed3.feed_info) != null && (feedCloudMeta$StVideo2 = feedCloudMeta$StFeed2.video) != null && (pBUInt32Field = feedCloudMeta$StVideo2.duration) != null) {
                    j16 = pBUInt32Field.get();
                } else {
                    j16 = 0;
                }
                if (Math.abs(j3 - j16) < 2) {
                    FeedCloudWatchlater$Feed feedCloudWatchlater$Feed4 = this.watchLaterFeed;
                    if (feedCloudWatchlater$Feed4 != null && (feedCloudMeta$StFeed = feedCloudWatchlater$Feed4.feed_info) != null && (feedCloudMeta$StVideo = feedCloudMeta$StFeed.video) != null && (pBStringField = feedCloudMeta$StVideo.playUrl) != null) {
                        str = pBStringField.get();
                    } else {
                        str = null;
                    }
                    com.tencent.biz.qqcircle.immersive.manager.f.f().n(com.tencent.biz.qqcircle.immersive.utils.r.N(str), 0L);
                }
            }
            com.tencent.biz.qqcircle.launcher.c.u(getContext(), getDetailInitBean());
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        FeedCloudWatchlater$Feed feedCloudWatchlater$Feed = this.watchLaterFeed;
        if (feedCloudWatchlater$Feed != null) {
            QCircleAsyncTextView qCircleAsyncTextView = this.titleTv;
            if (qCircleAsyncTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTv");
                qCircleAsyncTextView = null;
            }
            qCircleAsyncTextView.setText(feedCloudWatchlater$Feed.feed_info.content.get());
        }
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView, com.tencent.biz.qqcircle.richframework.part.a
    @NotNull
    public QCircleReportBean getReportBean() {
        QCircleReportBean reportBean = QCircleReportBean.getReportBean(getLogTag(), this.mReportBean);
        Intrinsics.checkNotNullExpressionValue(reportBean, "getReportBean(logTag, mReportBean)");
        return reportBean;
    }
}
