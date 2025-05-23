package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model.QFSPublicAccountStaggeredItemCommentHelper;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.NegativeItem;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.o;
import com.tencent.biz.qqcircle.immersive.utils.an;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0014\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0007*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0007*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002J0\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nJ0\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nJ.\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\"\u0010#\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006&"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/l;", "", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "", "e", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/o$a;", "", ReportConstant.COSTREPORT_PREFIX, "Le30/b;", "", "isNormalItem", "t", "", "type", "g", "info", "", "j", "", "exposureTimeMs", "l", "position", "spanIndex", "feedBlockData", tl.h.F, DomainData.DOMAIN_NAME, "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "view", "Lcom/tencent/qqlive/module/videoreport/dtreport/video/data/VideoEntity;", "f", "feedId", "o", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/NegativeItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class l {

    /* renamed from: a */
    @NotNull
    public static final l f87082a = new l();

    l() {
    }

    private final String e(QCircleInitBean initBean) {
        String b16 = an.b(initBean, QCircleDaTongConstant.PageId.PG_XSJ_GZH_DOUBLE_COLUMN_PAGE);
        Intrinsics.checkNotNullExpressionValue(b16, "getDTReportPage(initBean\u2026J_GZH_DOUBLE_COLUMN_PAGE)");
        return b16;
    }

    private final boolean g(int type) {
        List listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{7, 8, 6});
        return listOf.contains(Integer.valueOf(type));
    }

    public static /* synthetic */ void i(l lVar, int i3, int i16, e30.b bVar, QCircleInitBean qCircleInitBean, boolean z16, int i17, Object obj) {
        if ((i17 & 16) != 0) {
            z16 = false;
        }
        lVar.h(i3, i16, bVar, qCircleInitBean, z16);
    }

    public static final void k(o.CardExposureInfo info, QCircleInitBean initBean) {
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(initBean, "$initBean");
        VideoReport.reportEvent("dt_imp", null, f87082a.s(info, initBean));
    }

    public static final void m(long j3, o.CardExposureInfo info, QCircleInitBean initBean) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(initBean, "$initBean");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(DTParamKey.REPORT_KEY_ELEMENT_LVTM, Long.valueOf(j3)));
        mutableMapOf.putAll(f87082a.s(info, initBean));
        VideoReport.reportEvent("dt_imp_end", null, mutableMapOf);
    }

    public static final void p(QCircleInitBean qCircleInitBean, String feedId) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_NEGATIVE_POPUP), TuplesKt.to("xsj_custom_pgid", f87082a.e(qCircleInitBean)), TuplesKt.to("xsj_feed_id", feedId), TuplesKt.to("xsj_session_id", QCircleNativeSessionManager.g().getSession()), TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, "00000QG6YX3X0LZH"));
        VideoReport.reportEvent("ev_xsj_abnormal_imp", null, mapOf);
    }

    public static final void r(QCircleInitBean qCircleInitBean, String feedId, NegativeItem item) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        Intrinsics.checkNotNullParameter(item, "$item");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_NEGATIVE_POPUP), TuplesKt.to("xsj_custom_pgid", f87082a.e(qCircleInitBean)), TuplesKt.to("xsj_feed_id", feedId), TuplesKt.to("xsj_item_name", item.getTitle()), TuplesKt.to("xsj_session_id", QCircleNativeSessionManager.g().getSession()), TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, "00000QG6YX3X0LZH"));
        VideoReport.reportEvent("ev_xsj_abnormal_clck", null, mapOf);
    }

    private final Map<String, Object> s(o.CardExposureInfo cardExposureInfo, QCircleInitBean qCircleInitBean) {
        Map<String, Object> mutableMapOf;
        String str;
        boolean z16 = false;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("eid", QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT), TuplesKt.to("dt_pgid", e(qCircleInitBean)), TuplesKt.to("xsj_feed_id", cardExposureInfo.getFeedId()), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, cardExposureInfo.getPosterId()), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, cardExposureInfo.getDtTransfer()), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(cardExposureInfo.getPos())), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_LIKE_NUM, Integer.valueOf(cardExposureInfo.getCom.tencent.mobileqq.data.MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT java.lang.String())), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_REASON, cardExposureInfo.getRecommendReason()), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_COLUMN_LEFT_RIGHT, Integer.valueOf(cardExposureInfo.getSpanIndex())), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_QQLIVE_ROOM_ID, Long.valueOf(cardExposureInfo.getRoomId())), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_QQLIVE_PROGRAM_ID, cardExposureInfo.getProgramId()), TuplesKt.to("xsj_session_id", QCircleNativeSessionManager.g().getSession()), TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, "00000QG6YX3X0LZH"), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_IS_REDDOT_CARD, Boolean.valueOf(Intrinsics.areEqual(cardExposureInfo.getFeedId(), qCircleInitBean.getFeedId()))));
        if (cardExposureInfo.getFeedType() == 4) {
            mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE, 5);
            GdtAd gdtAd = cardExposureInfo.getGdtAd();
            if (gdtAd != null) {
                mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_ID, Long.valueOf(gdtAd.getAId()));
                String posId = gdtAd.getPosId();
                String str2 = "";
                if (posId == null) {
                    posId = "";
                }
                mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_POS_ID, posId);
                String traceId = gdtAd.getTraceId();
                if (traceId != null) {
                    str2 = traceId;
                }
                mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_TRACE_ID, str2);
            }
        }
        if (cardExposureInfo.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String() != null) {
            mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE1, Integer.valueOf(cardExposureInfo.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String().feedtype1.get()));
            mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE2, Integer.valueOf(cardExposureInfo.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String().feedtype2.get()));
            mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE3, Integer.valueOf(cardExposureInfo.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String().feedtype3.get()));
        }
        if (f87082a.g(cardExposureInfo.getTagType())) {
            if (cardExposureInfo.getTagType() == 6) {
                z16 = true;
            }
            if (z16) {
                str = "sgrp_channel_id";
            } else {
                str = QCircleDaTongConstant.ElementParamKey.XSJ_GROUP_ID;
            }
            mutableMapOf.put(str, cardExposureInfo.getTagId());
            mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_CORNER_MASK_NAME, cardExposureInfo.getTagText());
        }
        if (cardExposureInfo.getIsNormalItem()) {
            mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_CMT, Integer.valueOf(cardExposureInfo.getHasComment()));
        }
        return mutableMapOf;
    }

    private final Map<String, Object> t(e30.b bVar, QCircleInitBean qCircleInitBean, boolean z16) {
        QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient;
        String str;
        Map<String, Object> mutableMapOf;
        String str2;
        Object m476constructorimpl;
        PBStringField pBStringField;
        FeedCloudMeta$StFeed g16 = bVar.g();
        Object b16 = bVar.b("DITTO_REPORT_INFO_FOR_CLIENT");
        Object obj = null;
        if (b16 instanceof QQCircleFeedBase$StReportInfoForClient) {
            qQCircleFeedBase$StReportInfoForClient = (QQCircleFeedBase$StReportInfoForClient) b16;
        } else {
            qQCircleFeedBase$StReportInfoForClient = null;
        }
        if (qQCircleFeedBase$StReportInfoForClient != null && (pBStringField = qQCircleFeedBase$StReportInfoForClient.datongJsonData) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        boolean z17 = false;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("xsj_feed_id", g16.f398449id.get()), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, g16.poster.f398463id.get()), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, str), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_LIKE_NUM, Integer.valueOf(g16.likeInfo.count.get())), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_REASON, g16.recomInfo.recomReasonV2.recomReason.get()), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_QQLIVE_ROOM_ID, Long.valueOf(g16.live.room.roomId.get())), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_QQLIVE_PROGRAM_ID, bh.d(g16.live.get().liveExtInfo.get(), QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_PROGRAM_ID)), TuplesKt.to("xsj_session_id", QCircleNativeSessionManager.g().getSession()), TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, "00000QG6YX3X0LZH"), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_IS_REDDOT_CARD, Boolean.valueOf(Intrinsics.areEqual(g16.f398449id.get(), qCircleInitBean.getFeedId()))));
        if (g16.feedType.get() == 4) {
            mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE, 5);
            try {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(new GdtAd(u.e(bVar)));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (!Result.m482isFailureimpl(m476constructorimpl)) {
                obj = m476constructorimpl;
            }
            GdtAd gdtAd = (GdtAd) obj;
            if (gdtAd != null) {
                mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_ID, Long.valueOf(gdtAd.getAId()));
                String posId = gdtAd.getPosId();
                if (posId == null) {
                    posId = "";
                }
                Intrinsics.checkNotNullExpressionValue(posId, "ad.posId ?: \"\"");
                mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_POS_ID, posId);
                String traceId = gdtAd.getTraceId();
                if (traceId != null) {
                    str3 = traceId;
                }
                Intrinsics.checkNotNullExpressionValue(str3, "ad.traceId ?: \"\"");
                mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_TRACE_ID, str3);
            }
        }
        if (qQCircleFeedBase$StReportInfoForClient != null) {
            mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE1, Integer.valueOf(qQCircleFeedBase$StReportInfoForClient.feedtype1.get()));
            mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE2, Integer.valueOf(qQCircleFeedBase$StReportInfoForClient.feedtype2.get()));
            mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE3, Integer.valueOf(qQCircleFeedBase$StReportInfoForClient.feedtype3.get()));
        }
        if (f87082a.g(g16.liteBanner.business_type.get())) {
            if (g16.liteBanner.business_type.get() == 6) {
                z17 = true;
            }
            if (z17) {
                str2 = "sgrp_channel_id";
            } else {
                str2 = QCircleDaTongConstant.ElementParamKey.XSJ_GROUP_ID;
            }
            String d16 = bh.d(g16.liteBanner.extInfo.get(), "group_guild_id");
            Intrinsics.checkNotNullExpressionValue(d16, "getValueFromExtInfo(stFe\u2026.get(), \"group_guild_id\")");
            mutableMapOf.put(str2, d16);
            String d17 = bh.d(g16.liteBanner.extInfo.get(), "group_guild_title");
            Intrinsics.checkNotNullExpressionValue(d17, "getValueFromExtInfo(stFe\u2026t(), \"group_guild_title\")");
            mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_CORNER_MASK_NAME, d17);
        }
        if (z16) {
            mutableMapOf.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_CMT, Integer.valueOf(QFSPublicAccountStaggeredItemCommentHelper.f86870a.e(g16)));
        }
        return mutableMapOf;
    }

    static /* synthetic */ Map u(l lVar, e30.b bVar, QCircleInitBean qCircleInitBean, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return lVar.t(bVar, qCircleInitBean, z16);
    }

    @NotNull
    public final VideoEntity f(@NotNull QFSVideoView view, int position, int spanIndex, @NotNull e30.b feedBlockData, @NotNull QCircleInitBean initBean) {
        Map<? extends String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(feedBlockData, "feedBlockData");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Map<String, ?> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(position)), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_COLUMN_LEFT_RIGHT, Integer.valueOf(spanIndex)), TuplesKt.to("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT), TuplesKt.to("xsj_custom_pgid", e(initBean)), TuplesKt.to("xsj_target_qq", feedBlockData.g().poster.f398463id.get()));
        buildElementParams.putAll(mutableMapOf);
        buildElementParams.putAll(u(this, feedBlockData, initBean, false, 2, null));
        VideoEntity build = new VideoEntity.Builder().setContentId(feedBlockData.g().f398449id.get()).setPage((Object) e(initBean)).setVideoView((View) view).addCustomParams(buildElementParams).bizReady(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s\u2026rue)\n            .build()");
        return build;
    }

    public final void h(int i3, int i16, @NotNull e30.b feedBlockData, @NotNull QCircleInitBean initBean, boolean z16) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(feedBlockData, "feedBlockData");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3)), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_COLUMN_LEFT_RIGHT, Integer.valueOf(i16)), TuplesKt.to("eid", QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT), TuplesKt.to("dt_pgid", e(initBean)));
        mutableMapOf.putAll(t(feedBlockData, initBean, z16));
        VideoReport.reportEvent("dt_clck", null, mutableMapOf);
    }

    public final void j(@NotNull final o.CardExposureInfo info, @NotNull final QCircleInitBean initBean) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.j
            @Override // java.lang.Runnable
            public final void run() {
                l.k(o.CardExposureInfo.this, initBean);
            }
        });
    }

    public final void l(@NotNull final o.CardExposureInfo info, final long exposureTimeMs, @NotNull final QCircleInitBean initBean) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.i
            @Override // java.lang.Runnable
            public final void run() {
                l.m(exposureTimeMs, info, initBean);
            }
        });
    }

    public final void n(int i3, int i16, @NotNull e30.b feedBlockData, @NotNull QCircleInitBean initBean, boolean z16) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(feedBlockData, "feedBlockData");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3)), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_COLUMN_LEFT_RIGHT, Integer.valueOf(i16)), TuplesKt.to("eid", QCircleDaTongConstant.ElementId.EM_XSJ_EXTERNAL_CMT), TuplesKt.to("dt_pgid", e(initBean)));
        mutableMapOf.putAll(t(feedBlockData, initBean, z16));
        VideoReport.reportEvent("dt_clck", null, mutableMapOf);
    }

    public final void o(@NotNull final String feedId, @Nullable final QCircleInitBean initBean) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.h
            @Override // java.lang.Runnable
            public final void run() {
                l.p(QCircleInitBean.this, feedId);
            }
        });
    }

    public final void q(@NotNull final String feedId, @NotNull final NegativeItem item, @Nullable final QCircleInitBean qCircleInitBean) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(item, "item");
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.k
            @Override // java.lang.Runnable
            public final void run() {
                l.r(QCircleInitBean.this, feedId, item);
            }
        });
    }
}
