package com.tencent.mobileqq.qcircle.api.impl;

import android.content.Context;
import android.net.Uri;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountLauncher;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountTechReporter;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountDetailPageLaunchInfo;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountLauncherSource;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountMessageInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.k;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u001b\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountLauncher;", "Lcom/tencent/mobileqq/qcircle/api/IQCirclePublicAccountLauncher;", "()V", "Q_CIRCLE_DETAIL_PAGE_SCHEMA_PATH", "", "Q_CIRCLE_DOUBLE_ROW_PAGE_SCHEMA_PATH", "TAG", "getDoubleRowJumpUrl", "launchInfo", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountDetailPageLaunchInfo;", "hasRedDot", "", "reuseExistedPage", "getImmersiveJumpUrl", "getJumpUrl", "launchQCircleFromPublicAccount", "", "context", "Landroid/content/Context;", "source", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountLauncherSource;", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "launchQCirclePublicAccountDetailPage", "reportRedDotClick", "messageInfo", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountMessageInfo;", "parseFromLaunchInfo", "Landroid/net/Uri$Builder;", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCirclePublicAccountLauncher implements IQCirclePublicAccountLauncher {

    @NotNull
    public static final QCirclePublicAccountLauncher INSTANCE = new QCirclePublicAccountLauncher();

    @NotNull
    private static final String Q_CIRCLE_DETAIL_PAGE_SCHEMA_PATH = "mqqapi://qcircle/opendetail";

    @NotNull
    private static final String Q_CIRCLE_DOUBLE_ROW_PAGE_SCHEMA_PATH = "mqqapi://qcircle/openWaterfall";

    @NotNull
    private static final String TAG = "QCirclePublicAccountLauncher";

    QCirclePublicAccountLauncher() {
    }

    private final String getDoubleRowJumpUrl(QCirclePublicAccountDetailPageLaunchInfo launchInfo, boolean hasRedDot, boolean reuseExistedPage) {
        String str;
        Uri.Builder buildUpon = Uri.parse(Q_CIRCLE_DOUBLE_ROW_PAGE_SCHEMA_PATH).buildUpon();
        String str2 = "1";
        if (reuseExistedPage) {
            str = "1";
        } else {
            str = "0";
        }
        Uri.Builder appendQueryParameter = buildUpon.appendQueryParameter(QCircleScheme.AttrDetail.SHOULD_REUSE_EXISTED_PAGE, str);
        if (!hasRedDot) {
            str2 = "0";
        }
        Uri.Builder builder = appendQueryParameter.appendQueryParameter(QCircleScheme.AttrDetail.HAS_RED_DOT, str2).appendQueryParameter("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_GZH_DOUBLE_COLUMN_PAGE).appendQueryParameter("xsj_main_entrance", QCircleDaTongConstant.ElementParamValue.QCIRCLE_PUBLIC_ACCOUNT_MAIN_ENTRANCE).appendQueryParameter("xsj_sub_entrance", "default");
        if (launchInfo != null) {
            QCirclePublicAccountLauncher qCirclePublicAccountLauncher = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(builder, "builder");
            qCirclePublicAccountLauncher.parseFromLaunchInfo(builder, launchInfo);
        }
        String uri = builder.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "builder.build().toString()");
        return uri;
    }

    static /* synthetic */ String getDoubleRowJumpUrl$default(QCirclePublicAccountLauncher qCirclePublicAccountLauncher, QCirclePublicAccountDetailPageLaunchInfo qCirclePublicAccountDetailPageLaunchInfo, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        return qCirclePublicAccountLauncher.getDoubleRowJumpUrl(qCirclePublicAccountDetailPageLaunchInfo, z16, z17);
    }

    private final String getImmersiveJumpUrl(QCirclePublicAccountDetailPageLaunchInfo launchInfo, boolean reuseExistedPage) {
        String str;
        Uri.Builder appendQueryParameter = Uri.parse(Q_CIRCLE_DETAIL_PAGE_SCHEMA_PATH).buildUpon().appendQueryParameter("getfeedlist", "1");
        if (reuseExistedPage) {
            str = "1";
        } else {
            str = "0";
        }
        Uri.Builder builder = appendQueryParameter.appendQueryParameter(QCircleScheme.AttrDetail.SHOULD_REUSE_EXISTED_PAGE, str).appendQueryParameter(QCircleScheme.AttrDetail.ENABLE_REFRESH, "1").appendQueryParameter("sourcetype", "61").appendQueryParameter("xsj_custom_pgid", "pg_xsj_gzh_page").appendQueryParameter("xsj_main_entrance", QCircleDaTongConstant.ElementParamValue.QCIRCLE_PUBLIC_ACCOUNT_MAIN_ENTRANCE).appendQueryParameter("xsj_sub_entrance", "default");
        if (launchInfo == null) {
            String uri = builder.build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "builder.build().toString()");
            return uri;
        }
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        String uri2 = parseFromLaunchInfo(builder, launchInfo).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "builder.parseFromLaunchI\u2026hInfo).build().toString()");
        return uri2;
    }

    static /* synthetic */ String getImmersiveJumpUrl$default(QCirclePublicAccountLauncher qCirclePublicAccountLauncher, QCirclePublicAccountDetailPageLaunchInfo qCirclePublicAccountDetailPageLaunchInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return qCirclePublicAccountLauncher.getImmersiveJumpUrl(qCirclePublicAccountDetailPageLaunchInfo, z16);
    }

    private final Uri.Builder parseFromLaunchInfo(Uri.Builder builder, QCirclePublicAccountDetailPageLaunchInfo qCirclePublicAccountDetailPageLaunchInfo) {
        QCirclePublicAccountDetailPageLaunchInfo.VideoInfo videoInfo;
        String feedId = qCirclePublicAccountDetailPageLaunchInfo.getFeedId();
        if (feedId != null) {
            builder.appendQueryParameter("feedid", feedId);
        }
        Long createTimeSec = qCirclePublicAccountDetailPageLaunchInfo.getCreateTimeSec();
        if (createTimeSec != null) {
            builder.appendQueryParameter("createtime", String.valueOf(createTimeSec.longValue()));
        }
        String anchorUin = qCirclePublicAccountDetailPageLaunchInfo.getAnchorUin();
        if (anchorUin != null) {
            builder.appendQueryParameter("uin", anchorUin);
        }
        String transData = qCirclePublicAccountDetailPageLaunchInfo.getTransData();
        if (transData != null) {
            builder.appendQueryParameter("transdata", transData);
        }
        QCirclePublicAccountDetailPageLaunchInfo.FeedInfo feedInfo = qCirclePublicAccountDetailPageLaunchInfo.getFeedInfo();
        if (feedInfo != null) {
            builder.appendQueryParameter(QCircleScheme.AttrDetail.FEED_INFO, feedInfo.toJSONStr());
            builder.appendQueryParameter("type", String.valueOf(feedInfo.getType()));
            builder.appendQueryParameter("nick", feedInfo.getNick());
            builder.appendQueryParameter(QCircleSchemeAttr.Detail.AVATAR_URL, feedInfo.getAvatar());
            builder.appendQueryParameter(QCircleSchemeAttr.Detail.COVER_PIC_URL, feedInfo.getCoverUrl());
            builder.appendQueryParameter(QCircleSchemeAttr.Detail.COVER_WIDTH, String.valueOf(feedInfo.getWidth()));
            builder.appendQueryParameter(QCircleSchemeAttr.Detail.COVER_HEIGHT, String.valueOf(feedInfo.getHeight()));
            builder.appendQueryParameter("content", feedInfo.getContent());
            builder.appendQueryParameter(QCircleSchemeAttr.Detail.VIEW_NUM, String.valueOf(feedInfo.getPlayNum()));
            builder.appendQueryParameter(QCircleSchemeAttr.Detail.RECOM_REASON, feedInfo.getRecomReason());
        }
        QCirclePublicAccountDetailPageLaunchInfo.FeedInfo feedInfo2 = qCirclePublicAccountDetailPageLaunchInfo.getFeedInfo();
        if (feedInfo2 != null && (videoInfo = feedInfo2.getVideoInfo()) != null) {
            builder.appendQueryParameter("file_id", videoInfo.getFileId());
            builder.appendQueryParameter("play_url", videoInfo.getPlayUrl());
            builder.appendQueryParameter("duration", String.valueOf(videoInfo.getDuration()));
            builder.appendQueryParameter(QCircleSchemeAttr.Detail.IS_QUIC, String.valueOf(videoInfo.getIsQUIC()));
        }
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportRedDotClick(final BaseQQAppInterface app, final QCirclePublicAccountMessageInfo messageInfo, final QCirclePublicAccountLauncherSource source) {
        ((IQCirclePublicAccountMessageService) app.getRuntimeService(IQCirclePublicAccountMessageService.class)).hasUnReadMessage(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qcircle.api.impl.QCirclePublicAccountLauncher$reportRedDotClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                String jumpUrl;
                boolean startsWith$default;
                QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo = messageInfo;
                BaseQQAppInterface baseQQAppInterface = app;
                long currentTimeMillis = System.currentTimeMillis();
                boolean z17 = false;
                if (qCirclePublicAccountMessageInfo != null && (jumpUrl = qCirclePublicAccountMessageInfo.getJumpUrl()) != null) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(jumpUrl, "mqqapi://qcircle/opendetail", false, 2, null);
                    if (startsWith$default) {
                        z17 = true;
                    }
                }
                if (z17) {
                    IQCirclePublicAccountTechReporter iQCirclePublicAccountTechReporter = (IQCirclePublicAccountTechReporter) QRoute.api(IQCirclePublicAccountTechReporter.class);
                    String feedId = qCirclePublicAccountMessageInfo.getFeedId();
                    if (feedId == null) {
                        feedId = "";
                    }
                    boolean isOnFetchMsgStage = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isOnFetchMsgStage(baseQQAppInterface);
                    com.tencent.biz.qqcircle.publicaccount.f fVar = com.tencent.biz.qqcircle.publicaccount.f.f91680a;
                    String videoPlayUrl = qCirclePublicAccountMessageInfo.getVideoPlayUrl();
                    if (videoPlayUrl == null) {
                        videoPlayUrl = "";
                    }
                    boolean f16 = fVar.f(videoPlayUrl);
                    String coverUrl = qCirclePublicAccountMessageInfo.getCoverUrl();
                    iQCirclePublicAccountTechReporter.onEnterPage(feedId, isOnFetchMsgStage, z16, f16, fVar.b(coverUrl != null ? coverUrl : ""), !z16, false);
                }
                QLog.i("QCirclePublicAccountLauncher", 1, "launchQCircleFromPublicAccount report cost = " + (System.currentTimeMillis() - currentTimeMillis) + ", source=" + QCirclePublicAccountLauncherSource.this.getValue());
                ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportRedPointClick(app, NetConnInfoCenter.getServerTimeMillis(), QCirclePublicAccountLauncherSource.this, messageInfo);
            }
        });
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountLauncher
    @NotNull
    public String getJumpUrl(@Nullable QCirclePublicAccountDetailPageLaunchInfo launchInfo, boolean hasRedDot) {
        Integer num;
        if (launchInfo != null) {
            num = launchInfo.getFlowType();
        } else {
            num = null;
        }
        if (num == null) {
            num = Integer.valueOf(k.a().e(QCirclePublicAccountMessageServiceImpl.KEY_QCIRCLE_PUBLIC_ACCOUNT_FLOW_TYPE, 1));
        }
        if (num.intValue() == 1) {
            return getDoubleRowJumpUrl$default(this, launchInfo, hasRedDot, false, 4, null);
        }
        return getImmersiveJumpUrl$default(this, launchInfo, false, 2, null);
    }

    public final void launchQCircleFromPublicAccount(@NotNull Context context, @NotNull QCirclePublicAccountLauncherSource source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        launchQCircleFromPublicAccount((BaseQQAppInterface) peekAppRuntime, context, source);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountLauncher
    public void launchQCirclePublicAccountDetailPage(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, IPublicAccountDetailActivity.ROUTE_NAME);
        activityURIRequest.extra().putString("uin", AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN);
        activityURIRequest.extra().putInt("uintype", 1008);
        activityURIRequest.extra().putInt("source", 116);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountLauncher
    public void launchQCircleFromPublicAccount(@NotNull final BaseQQAppInterface app, @NotNull final Context context, @NotNull final QCirclePublicAccountLauncherSource source) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        ((IQCirclePublicAccountMessageService) app.getRuntimeService(IQCirclePublicAccountMessageService.class)).fetchLastMessageInfo(new Function1<QCirclePublicAccountMessageInfo, Unit>() { // from class: com.tencent.mobileqq.qcircle.api.impl.QCirclePublicAccountLauncher$launchQCircleFromPublicAccount$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                invoke2(qCirclePublicAccountMessageInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                String a16;
                QCirclePublicAccountLauncher qCirclePublicAccountLauncher = QCirclePublicAccountLauncher.INSTANCE;
                qCirclePublicAccountLauncher.reportRedDotClick(BaseQQAppInterface.this, qCirclePublicAccountMessageInfo, source);
                if (qCirclePublicAccountMessageInfo == null || (a16 = qCirclePublicAccountMessageInfo.getJumpUrl()) == null) {
                    a16 = IQCirclePublicAccountLauncher.a.a(qCirclePublicAccountLauncher, null, false, 2, null);
                }
                QLog.i("QCirclePublicAccountLauncher", 1, "launchQCircleFromPublicAccount, jumpUrl=" + a16);
                ax c16 = bi.c(BaseQQAppInterface.this, context, a16);
                if (c16 == null) {
                    QLog.e("QCirclePublicAccountLauncher", 1, "jumpAction parse error, newJumpUrl=" + a16);
                    return;
                }
                c16.b();
            }
        });
    }
}
