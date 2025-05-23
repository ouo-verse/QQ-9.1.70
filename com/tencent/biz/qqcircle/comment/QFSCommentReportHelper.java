package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart;
import com.tencent.biz.qqcircle.comment.recpic.RecPicReportInfo;
import com.tencent.biz.qqcircle.comment.recpic.ak;
import com.tencent.biz.qqcircle.comment.recpic.sorter.StrategyImage;
import com.tencent.biz.qqcircle.j;
import com.tencent.biz.richframework.util.RFWStringBuilderUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.common.EventData;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentReportHelper {

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.comment.QFSCommentReportHelper$6, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass6 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f83226d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f83227e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f83228f;

        @Override // java.lang.Runnable
        public void run() {
            VideoReport.setElementId(this.f83226d, this.f83227e);
            VideoReport.setElementParams(this.f83226d, this.f83228f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSCommentPanelPart> f83233a;

        public a(QFSCommentPanelPart qFSCommentPanelPart) {
            this.f83233a = new WeakReference<>(qFSCommentPanelPart);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            String str2;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            QFSCommentPanelPart qFSCommentPanelPart = this.f83233a.get();
            if (qFSCommentPanelPart == null) {
                return buildElementParams;
            }
            if (qFSCommentPanelPart.isShowMaxHeight()) {
                str2 = "full_screen";
            } else {
                str2 = "half_screen";
            }
            buildElementParams.put("xsj_status", str2);
            return buildElementParams;
        }
    }

    public static void A(final View view, final QCircleExtraTypeInfo qCircleExtraTypeInfo, final long j3, final int i3, final int i16) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.QFSCommentReportHelper.3
            @Override // java.lang.Runnable
            public void run() {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed;
                VideoReport.clearElementExposure(view, false);
                QCircleExtraTypeInfo qCircleExtraTypeInfo2 = qCircleExtraTypeInfo;
                if (qCircleExtraTypeInfo2 != null) {
                    feedCloudMeta$StFeed = qCircleExtraTypeInfo2.mFeed;
                } else {
                    feedCloudMeta$StFeed = null;
                }
                QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed)).setActionType(53).setSubActionType(2).setExt2(String.valueOf(System.currentTimeMillis() - j3)).setPageId(i3).setfpageid(i16));
            }
        });
    }

    private static void B(@Nullable final Context context, final int i3, final int i16, final QCircleExtraTypeInfo qCircleExtraTypeInfo, final int i17, final int i18) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.QFSCommentReportHelper.4
            @Override // java.lang.Runnable
            public void run() {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed;
                QCircleExtraTypeInfo qCircleExtraTypeInfo2 = QCircleExtraTypeInfo.this;
                if (qCircleExtraTypeInfo2 != null && (feedCloudMeta$StFeed = qCircleExtraTypeInfo2.mFeed) != null) {
                    QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed)).setActionType(i3).setSubActionType(i16).setToUin(QCircleExtraTypeInfo.this.mFeed.poster.f398463id.get()).setPosition(QCircleExtraTypeInfo.this.mDataPosition).setPlayScene(QCircleExtraTypeInfo.this.mPlayScene).setPageId(i17).setfpageid(i18).setExt10(ua0.c.f(context)));
                    return;
                }
                QLog.e("QCircleReportHelper_QFSCommentReportHelper", 1, "reportToLpDc05507 extraTypeInfo is null or lost feed,actionType:" + i3 + ",subActionType:" + i16);
            }
        });
    }

    public static void b(QCircleExtraTypeInfo qCircleExtraTypeInfo, int i3, int i16, int i17, int i18) {
        if (qCircleExtraTypeInfo != null && qCircleExtraTypeInfo.mFeed != null) {
            if (i3 == 103) {
                i16 = 7;
            }
            B(null, i16, 3, qCircleExtraTypeInfo, i17, i18);
        }
    }

    public static void c(final View view, final QFSCommentInfo qFSCommentInfo) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.QFSCommentReportHelper.1
            @Override // java.lang.Runnable
            public void run() {
                QCircleReportBean qCircleReportBean;
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                QFSCommentInfo qFSCommentInfo2 = QFSCommentInfo.this;
                if (qFSCommentInfo2 != null) {
                    buildElementParams.putAll(ua0.c.d(qFSCommentInfo2.mFeedBlockData));
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMTPANEL_SOURCE, Integer.valueOf(QFSCommentInfo.this.mCmtPanelSource));
                    QFSCommentInfo qFSCommentInfo3 = QFSCommentInfo.this;
                    if (qFSCommentInfo3.mCommentId != null && (qCircleReportBean = qFSCommentInfo3.mReportBean) != null && qCircleReportBean.getFromElement() != null) {
                        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTOMATIC_LOCATE_COMMENT_ID, QFSCommentInfo.this.mCommentId);
                        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_LAYER_PAGE_REF_EID, QFSCommentInfo.this.mReportBean.getFromElement());
                    }
                    QCircleExtraTypeInfo qCircleExtraTypeInfo = QFSCommentInfo.this.mExtraTypeInfo;
                    if (qCircleExtraTypeInfo != null) {
                        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(qCircleExtraTypeInfo.mDataPosition + 1));
                    }
                    FeedCloudMeta$StComment feedCloudMeta$StComment = QFSCommentInfo.this.mTargetComment;
                    if (feedCloudMeta$StComment != null) {
                        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_TYPE, QFSCommentReportHelper.o(feedCloudMeta$StComment));
                    }
                }
                buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL);
                VideoReport.setElementParams(view, buildElementParams);
                VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
                VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
            }
        });
    }

    public static void d(View view, QFSCommentPanelPart qFSCommentPanelPart) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_SWITCH_BUTTON);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setEventDynamicParams(view, new a(qFSCommentPanelPart));
    }

    public static void e(View view, QFSCommentInfo qFSCommentInfo, FeedCloudMeta$StComment feedCloudMeta$StComment, int i3) {
        g(view, qFSCommentInfo, QCircleDaTongConstant.EventId.EV_XSJ_CMT_ACTION, "delete", feedCloudMeta$StComment.postUser.f398463id.get(), i3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(View view, QFSCommentInfo qFSCommentInfo, Object obj, boolean z16, int i3) {
        String str;
        Object obj2;
        String str2;
        String str3;
        FeedCloudMeta$StComment feedCloudMeta$StComment = new FeedCloudMeta$StComment();
        FeedCloudMeta$StReply feedCloudMeta$StReply = null;
        if (obj instanceof FeedCloudMeta$StComment) {
            feedCloudMeta$StComment = (FeedCloudMeta$StComment) obj;
            str2 = feedCloudMeta$StComment.postUser.f398463id.get();
        } else {
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    Object obj3 = objArr[0];
                    if (obj3 instanceof FeedCloudMeta$StComment) {
                        feedCloudMeta$StComment = (FeedCloudMeta$StComment) obj3;
                    }
                }
                if (objArr.length > 1 && (obj2 = objArr[1]) != null && (obj2 instanceof FeedCloudMeta$StReply)) {
                    feedCloudMeta$StReply = (FeedCloudMeta$StReply) obj2;
                    str2 = feedCloudMeta$StReply.postUser.f398463id.get();
                }
            }
            str = "";
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_ID, feedCloudMeta$StComment.f398447id.get());
            if (feedCloudMeta$StReply == null) {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SUB_ACTION_TYPE, "reply");
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REPLY_ID, feedCloudMeta$StReply.f398460id.get());
            } else {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SUB_ACTION_TYPE, "cmt");
            }
            if (!z16) {
                str3 = "cancel";
            } else {
                str3 = "like";
            }
            g(view, qFSCommentInfo, QCircleDaTongConstant.EventId.EV_XSJ_CMTREPLY_LIKE_ACTION, str3, str, i3, hashMap);
        }
        str = str2;
        HashMap hashMap2 = new HashMap();
        hashMap2.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_ID, feedCloudMeta$StComment.f398447id.get());
        if (feedCloudMeta$StReply == null) {
        }
        if (!z16) {
        }
        g(view, qFSCommentInfo, QCircleDaTongConstant.EventId.EV_XSJ_CMTREPLY_LIKE_ACTION, str3, str, i3, hashMap2);
    }

    public static void g(final View view, final QFSCommentInfo qFSCommentInfo, final String str, final String str2, final String str3, int i3, final Map<String, Object> map) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.QFSCommentReportHelper.5
            @Override // java.lang.Runnable
            public void run() {
                int i16;
                QCircleReportBean qCircleReportBean;
                QFSCommentInfo qFSCommentInfo2 = QFSCommentInfo.this;
                if (qFSCommentInfo2 == null || qFSCommentInfo2.mFeedBlockData == null || qFSCommentInfo2.mFeed == null || !uq3.c.g6()) {
                    return;
                }
                if (TextUtils.equals(str, QCircleDaTongConstant.EventId.EV_XSJ_CMTREPLY_LIKE_ACTION)) {
                    VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL);
                    QFSCommentReportHelper.k(view, QFSCommentInfo.this, str, str2, str3, map);
                    return;
                }
                QLog.i("QFSCommentReportHelper", 1, "dtReportCustomShareReport eventId = " + str + " , actionType" + str2);
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams.putAll(ua0.c.d(QFSCommentInfo.this.mFeedBlockData));
                QCircleExtraTypeInfo qCircleExtraTypeInfo = QFSCommentInfo.this.mExtraTypeInfo;
                if (qCircleExtraTypeInfo != null) {
                    i16 = qCircleExtraTypeInfo.mDataPosition + 1;
                } else {
                    i16 = -1;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i16));
                if (!TextUtils.isEmpty(str3)) {
                    buildElementParams.put("xsj_target_qq", str3);
                }
                if (!TextUtils.isEmpty(str2)) {
                    buildElementParams.put("xsj_action_type", str2);
                }
                if (TextUtils.equals(str, QCircleDaTongConstant.EventId.EV_XSJ_CMT_ACTION) && (qCircleReportBean = QFSCommentInfo.this.mReportBean) != null && qCircleReportBean.getFromElement() != null) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_LAYER_PAGE_REF_EID, QFSCommentInfo.this.mReportBean.getFromElement());
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMTPANEL_SOURCE, Integer.valueOf(QFSCommentInfo.this.mCmtPanelSource));
                Map<? extends String, ? extends Object> map2 = map;
                if (map2 != null) {
                    buildElementParams.putAll(map2);
                }
                buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                if ((TextUtils.equals(str, QCircleDaTongConstant.EventId.EV_XSJ_CMT_ACTION) || TextUtils.equals(str, QCircleDaTongConstant.EventId.EV_XSJ_REPLY_ACTION)) && w20.a.j().k() > 0) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().k()));
                }
                PBRepeatMessageField<FeedCloudMeta$FeedAlbumInfo> pBRepeatMessageField = QFSCommentInfo.this.mFeed.album_infos;
                if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0 && QFSCommentInfo.this.mFeed.album_infos.get(0) != null) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, Long.valueOf(QFSCommentInfo.this.mFeed.album_infos.get(0).album.f398441id.get()));
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_SHOW_AD, Integer.valueOf(QFSCommentInfo.this.mHadAdBanner));
                FeedCloudMeta$StComment feedCloudMeta$StComment = QFSCommentInfo.this.mTargetComment;
                if (feedCloudMeta$StComment != null) {
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_TYPE, QFSCommentReportHelper.o(feedCloudMeta$StComment));
                }
                VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL);
                if (!TextUtils.isEmpty(str)) {
                    VideoReport.reportEvent(str, view, buildElementParams);
                }
            }
        });
    }

    public static void h(int i3, int i16, String str) {
        String str2;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_custom_pgid", str);
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_ASSOCIATE_EMOJI_OPTION);
        if (i16 == j.g.f91373f) {
            str2 = com.tencent.biz.qqcircle.utils.h.a(R.string.f183783k4);
        } else if (i16 == j.g.f91374g) {
            str2 = com.tencent.biz.qqcircle.utils.h.a(R.string.f183853ka);
        } else {
            str2 = "";
        }
        buildElementParams.put("xsj_item_name", str2);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    public static void i(final View view, final QCircleReportBean qCircleReportBean) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.QFSCommentReportHelper.8
            @Override // java.lang.Runnable
            public void run() {
                View view2 = view;
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    if (viewGroup.getChildAt(0) != null && (viewGroup.getChildAt(0) instanceof TextView)) {
                        TextView textView = (TextView) viewGroup.getChildAt(0);
                        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                        buildElementParams.put("xsj_item_name", textView.getText().toString());
                        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_LONGPRESS);
                        QCircleReportBean qCircleReportBean2 = qCircleReportBean;
                        if (qCircleReportBean2 != null) {
                            buildElementParams.put("xsj_custom_pgid", qCircleReportBean2.getDtPageId());
                        }
                        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
                    }
                }
            }
        });
    }

    public static void j(final com.tencent.biz.qqcircle.richframework.widget.menu.c cVar, final QCircleReportBean qCircleReportBean) {
        if (cVar == null) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.QFSCommentReportHelper.7
            @Override // java.lang.Runnable
            public void run() {
                for (com.tencent.biz.qqcircle.richframework.widget.menu.b bVar : com.tencent.biz.qqcircle.richframework.widget.menu.c.this.g()) {
                    if (bVar != null) {
                        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                        buildElementParams.put("xsj_item_name", bVar.c());
                        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_LONGPRESS);
                        QCircleReportBean qCircleReportBean2 = qCircleReportBean;
                        if (qCircleReportBean2 != null) {
                            buildElementParams.put("xsj_custom_pgid", qCircleReportBean2.getDtPageId());
                        }
                        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static void k(View view, QFSCommentInfo qFSCommentInfo, String str, String str2, String str3, Map<String, Object> map) {
        int i3;
        if (qFSCommentInfo != null && qFSCommentInfo.mFeedBlockData != null && qFSCommentInfo.mFeed != null) {
            EventData.Builder builder = EventData.builder();
            QCircleExtraTypeInfo qCircleExtraTypeInfo = qFSCommentInfo.mExtraTypeInfo;
            if (qCircleExtraTypeInfo != null) {
                i3 = qCircleExtraTypeInfo.mDataPosition + 1;
            } else {
                i3 = -1;
            }
            VideoReport.reportEvent(builder.withParam(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3)).withParams(ua0.c.d(qFSCommentInfo.mFeedBlockData)).withParam("xsj_target_qq", str3).withParam("xsj_action_type", str2).withParam("xsj_session_id", QCircleNativeSessionManager.g().getSession()).withParam(DTParamKey.REPORT_KEY_APPKEY, "00000QG6YX3X0LZH").withParam(QCircleDaTongConstant.ElementParamKey.XSJ_IS_SHOW_AD, Integer.valueOf(qFSCommentInfo.mHadAdBanner)).withParams(map).withId(str).withSource(view).withType(EventAgingType.IMMEDIATE).build());
        }
    }

    public static void l(View view, QFSCommentInfo qFSCommentInfo, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_ID, feedCloudMeta$StComment.f398447id.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REPLY_ID, feedCloudMeta$StReply.f398460id.get());
        g(view, qFSCommentInfo, QCircleDaTongConstant.EventId.EV_XSJ_REPLY_ACTION, "delete", feedCloudMeta$StReply.postUser.f398463id.get(), i3, hashMap);
    }

    public static void m(final View view) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.QFSCommentReportHelper.2
            @Override // java.lang.Runnable
            public void run() {
                VideoReport.reportEvent("imp", view, null);
            }
        });
    }

    public static String n(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return "";
        }
        int i3 = 2;
        if (feedCloudMeta$StFeed.type.get() == 2) {
            i3 = 1;
        } else if (feedCloudMeta$StFeed.type.get() != 3) {
            i3 = 0;
        }
        return String.valueOf(i3);
    }

    public static String o(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        String str = "other";
        if (feedCloudMeta$StComment == null) {
            return "other";
        }
        if (!TextUtils.isEmpty(feedCloudMeta$StComment.commentPic.picUrl.get())) {
            str = "image";
        }
        if (feedCloudMeta$StComment.commentFeed.has()) {
            str = "video";
        }
        if (!TextUtils.isEmpty(feedCloudMeta$StComment.expressionInfo.expressionURL.get())) {
            if (feedCloudMeta$StComment.expressionInfo.expression_src.get() == 10002) {
                return QCircleDaTongConstant.ElementParamValue.XSJ_CMT_TYPE_ASSOCIATE_EMOJI;
            }
            if (feedCloudMeta$StComment.expressionInfo.expression_src.get() == 10001) {
                return QCircleDaTongConstant.ElementParamValue.XSJ_CMT_TYPE_COLLECT_EMOJI;
            }
            return str;
        }
        return str;
    }

    public static String p(FeedCloudMeta$StReply feedCloudMeta$StReply) {
        String str = "other";
        if (feedCloudMeta$StReply == null) {
            return "other";
        }
        if (!TextUtils.isEmpty(feedCloudMeta$StReply.replyPic.picUrl.get())) {
            str = "image";
        }
        if (feedCloudMeta$StReply.replyFeed.has()) {
            str = "video";
        }
        if (!TextUtils.isEmpty(feedCloudMeta$StReply.expressionInfo.expressionURL.get())) {
            if (feedCloudMeta$StReply.expressionInfo.expression_src.get() == 10002) {
                return QCircleDaTongConstant.ElementParamValue.XSJ_CMT_TYPE_ASSOCIATE_EMOJI;
            }
            if (feedCloudMeta$StReply.expressionInfo.expression_src.get() == 10001) {
                return QCircleDaTongConstant.ElementParamValue.XSJ_CMT_TYPE_COLLECT_EMOJI;
            }
            return str;
        }
        return str;
    }

    @NonNull
    public static String q(boolean z16) {
        if (z16) {
            return "reply";
        }
        return "cmt";
    }

    public static String r(List<HostSelectMemberUtils.QCircleResultData> list) {
        StringBuilder obtain = RFWStringBuilderUtils.obtain();
        for (int i3 = 0; i3 < list.size(); i3++) {
            obtain.append(list.get(i3).uin);
            if (i3 < list.size() - 1) {
                obtain.append("|");
            }
        }
        return obtain.toString();
    }

    private static boolean s(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment != null && !TextUtils.isEmpty(feedCloudMeta$StComment.commentPic.picUrl.get())) {
            return true;
        }
        return false;
    }

    private static boolean t(FeedCloudMeta$StReply feedCloudMeta$StReply) {
        if (feedCloudMeta$StReply != null && !TextUtils.isEmpty(feedCloudMeta$StReply.replyPic.picUrl.get())) {
            return true;
        }
        return false;
    }

    private static void u(FeedCloudMeta$StComment feedCloudMeta$StComment, Map<String, Object> map) {
        int i3;
        ak akVar = ak.f83788a;
        StrategyImage g16 = akVar.g();
        if (g16 == null || feedCloudMeta$StComment == null || !TextUtils.equals(g16.getPath(), feedCloudMeta$StComment.commentPic.picUrl.get())) {
            return;
        }
        Object obj = g16.b().get("index");
        if (obj instanceof Integer) {
            i3 = ((Integer) obj).intValue();
        } else {
            i3 = 0;
        }
        QLog.d("QFSCommentReportHelper", 1, "[putCmtRecPicInfo] strategy: " + g16.getStrategy());
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_PIC_REC_INFO, new RecPicReportInfo(i3 + 1, g16.getStrategy(), g16.getScore()).a());
        akVar.a();
    }

    private static void v(FeedCloudMeta$StReply feedCloudMeta$StReply, Map<String, Object> map) {
        int i3;
        ak akVar = ak.f83788a;
        StrategyImage g16 = akVar.g();
        if (g16 == null || feedCloudMeta$StReply == null || !TextUtils.equals(g16.getPath(), feedCloudMeta$StReply.replyPic.picUrl.get())) {
            return;
        }
        Object obj = g16.b().get("index");
        if (obj instanceof Integer) {
            i3 = ((Integer) obj).intValue();
        } else {
            i3 = 0;
        }
        QLog.d("QFSCommentReportHelper", 1, "[putReplyRecPicInfo] strategy: " + g16.getStrategy());
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_PIC_REC_INFO, new RecPicReportInfo(i3 + 1, g16.getStrategy(), g16.getScore()).a());
        akVar.a();
    }

    public static void w(View view, FeedCloudMeta$StComment feedCloudMeta$StComment, QFSCommentInfo qFSCommentInfo, int i3, int i16, int i17, int i18, o20.d dVar) {
        String str;
        String str2;
        b(qFSCommentInfo.mExtraTypeInfo, i3, i16, i17, i18);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = qFSCommentInfo.mFeed;
        if (feedCloudMeta$StFeed != null) {
            str = feedCloudMeta$StFeed.poster.f398463id.get();
        } else {
            str = "";
        }
        String str3 = str;
        HashMap hashMap = new HashMap();
        if (dVar != null) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AT_TOUIN, dVar.c());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AT_SOURCE, dVar.b());
            if (!TextUtils.isEmpty(dVar.f421800h)) {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_ADJUST, Integer.valueOf(dVar.f421802j));
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_COMMENT_ID, dVar.f421801i);
            }
            if (dVar.f421803k) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_QUICK_REPLY, str2);
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_FROM_HALFPAGE, Integer.valueOf(s(feedCloudMeta$StComment) ? 1 : 0));
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_TYPE, o(feedCloudMeta$StComment));
        u(feedCloudMeta$StComment, hashMap);
        g(view, qFSCommentInfo, QCircleDaTongConstant.EventId.EV_XSJ_CMT_ACTION, "cmt", str3, i17, hashMap);
    }

    public static void x(View view, FeedCloudMeta$StReply feedCloudMeta$StReply, QFSCommentInfo qFSCommentInfo, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply2, int i3, int i16, int i17, int i18, o20.d dVar, String str) {
        b(qFSCommentInfo.mExtraTypeInfo, i3, i16, i17, i18);
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_ID, feedCloudMeta$StComment.f398447id.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_REPLY, "1");
        if (feedCloudMeta$StReply2 != null) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REPLY_ID, feedCloudMeta$StReply2.f398460id.get());
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("xsj_custom_pgid", str);
        }
        if (dVar != null) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AT_TOUIN, dVar.c());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AT_SOURCE, dVar.b());
            if (!TextUtils.isEmpty(dVar.f421800h)) {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_ADJUST, Integer.valueOf(dVar.f421802j));
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_COMMENT_ID, dVar.f421801i);
            }
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_QUICK_REPLY, dVar.f421803k ? "1" : "0");
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_FROM_HALFPAGE, Integer.valueOf(t(feedCloudMeta$StReply) ? 1 : 0));
        }
        String str2 = (feedCloudMeta$StReply2 != null ? feedCloudMeta$StReply2.postUser : feedCloudMeta$StComment.postUser).f398463id.get();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_TYPE, p(feedCloudMeta$StReply));
        v(feedCloudMeta$StReply, hashMap);
        g(view, qFSCommentInfo, QCircleDaTongConstant.EventId.EV_XSJ_REPLY_ACTION, "reply", str2, i17, hashMap);
    }

    public static void y(Context context, QCircleExtraTypeInfo qCircleExtraTypeInfo, int i3, int i16, int i17) {
        if (qCircleExtraTypeInfo != null && qCircleExtraTypeInfo.mFeed != null) {
            B(context, i3, 2, qCircleExtraTypeInfo, i16, i17);
        }
    }

    public static void z(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, int i3, int i16) {
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = new QQCircleDitto$StCircleDittoDataNew();
        try {
            qQCircleDitto$StCircleDittoDataNew.mergeFrom(feedCloudMeta$StComment.dittocomment.dittoDataNew.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSCommentReportHelper", 1, "onCommentFeedFeedback  e = " + e16.getMessage());
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = qQCircleDitto$StCircleDittoDataNew.feedItem.normalFeed.get();
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(ua0.c.a(feedCloudMeta$StFeed2).setToUin(feedCloudMeta$StFeed2.poster.f398463id.get()).setActionType(65).setSubActionType(6).setIndex(i3).setExt2(feedCloudMeta$StFeed.poster.f398463id.get()).setExt3(String.valueOf(feedCloudMeta$StFeed2.createTime.get())).setPageId(i16)));
    }
}
