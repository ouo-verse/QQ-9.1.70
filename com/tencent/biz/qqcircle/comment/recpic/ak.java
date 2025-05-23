package com.tencent.biz.qqcircle.comment.recpic;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.biz.qqcircle.comment.album.QFSLocalMediaInfo;
import com.tencent.biz.qqcircle.comment.recpic.sorter.StrategyImage;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u000eJ\u0014\u0010\u0013\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0014\u0010\u0014\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0019J2\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0019J0\u0010&\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u001a\u001a\u00020\u0019J,\u0010'\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u0019J0\u0010)\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010!\u001a\u00020 2\u0006\u0010(\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u001a\u001a\u00020\u0019R$\u0010/\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/ak;", "", "Lcom/tencent/biz/qqcircle/comment/recpic/sorter/c;", "image", "", tl.h.F, "a", "Lcom/tencent/biz/qqcircle/comment/recpic/an;", "bean", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/comment/recpic/ao;", DomainData.DOMAIN_NAME, "Lcom/tencent/biz/qqcircle/comment/recpic/c;", "j", "Lcom/tencent/biz/qqcircle/comment/recpic/b;", "i", "", "Lcom/tencent/biz/qqcircle/comment/recpic/d;", "beans", "l", "k", "Landroid/view/View;", "view", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "isImp", "b", "", "pageId", "status", "d", "", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/biz/qqcircle/comment/album/k;", "localMediaInfo", "Lcooperation/qqcircle/report/QCircleReportBean;", "reportBean", "f", "c", "info", "e", "Lcom/tencent/biz/qqcircle/comment/recpic/sorter/c;", "g", "()Lcom/tencent/biz/qqcircle/comment/recpic/sorter/c;", "setSelectImage", "(Lcom/tencent/biz/qqcircle/comment/recpic/sorter/c;)V", "selectImage", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ak {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ak f83788a = new ak();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static StrategyImage selectImage;

    ak() {
    }

    public final void a() {
        selectImage = null;
    }

    public final void b(@NotNull View view, @Nullable FeedCloudMeta$StFeed feed, boolean isImp) {
        String str;
        String str2;
        String str3;
        PBStringField pBStringField;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField2;
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_REC_PIC_BOX_BUTTON);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        aa aaVar = aa.f83750a;
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        boolean E = aaVar.E((Activity) context);
        Intrinsics.checkNotNullExpressionValue(params, "params");
        if (E) {
            str = "function";
        } else {
            str = QCircleDaTongConstant.ElementParamValue.PERMISSION;
        }
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, str);
        String str4 = null;
        if (feed != null && (feedCloudMeta$StUser = feed.poster) != null && (pBStringField2 = feedCloudMeta$StUser.f398463id) != null) {
            str2 = pBStringField2.get();
        } else {
            str2 = null;
        }
        String str5 = "";
        if (str2 == null) {
            str2 = "";
        }
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str2);
        if (feed != null && (pBStringField = feed.f398449id) != null) {
            str4 = pBStringField.get();
        }
        if (str4 != null) {
            str5 = str4;
        }
        params.put("xsj_feed_id", str5);
        if (isImp) {
            str3 = "ev_xsj_abnormal_imp";
        } else {
            str3 = "ev_xsj_abnormal_clck";
        }
        VideoReport.reportEvent(str3, view, params);
    }

    public final void c(@Nullable View view, @Nullable FeedCloudMeta$StFeed feed, @Nullable String pageId, boolean isImp) {
        String str;
        String str2;
        String str3;
        String str4;
        PBStringField pBStringField;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField2;
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_REC_PIC_GUIDE_BAR);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "QCircleDTParamBuilder().buildElementParams()");
        Context context = null;
        if (feed != null && (feedCloudMeta$StUser = feed.poster) != null && (pBStringField2 = feedCloudMeta$StUser.f398463id) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str);
        if (feed != null && (pBStringField = feed.f398449id) != null) {
            str2 = pBStringField.get();
        } else {
            str2 = null;
        }
        buildElementParams.put("xsj_feed_id", str2);
        buildElementParams.put("xsj_custom_pgid", pageId);
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_REC_PIC_GUIDE_BAR);
        aa aaVar = aa.f83750a;
        if (view != null) {
            context = view.getContext();
        }
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        if (aaVar.E((Activity) context)) {
            str3 = "function";
        } else {
            str3 = QCircleDaTongConstant.ElementParamValue.PERMISSION;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, str3);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        if (isImp) {
            str4 = "ev_xsj_abnormal_imp";
        } else {
            str4 = "ev_xsj_abnormal_clck";
        }
        VideoReport.reportEvent(str4, view, buildElementParams);
    }

    public final void d(@NotNull View view, @Nullable FeedCloudMeta$StFeed feed, @Nullable String pageId, @NotNull String status, boolean isImp) {
        String str;
        String str2;
        PBStringField pBStringField;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(status, "status");
        QLog.d("QFSRecPicReportHelper", 1, "[dtReportInputBarTopEntrance] ");
        String str3 = "";
        if (pageId == null) {
            pageId = "";
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_REC_PIC_OUTSIDE_BUTTON);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, status);
        String str4 = null;
        if (feed != null && (feedCloudMeta$StUser = feed.poster) != null && (pBStringField2 = feedCloudMeta$StUser.f398463id) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str);
        if (feed != null && (pBStringField = feed.f398449id) != null) {
            str4 = pBStringField.get();
        }
        if (str4 != null) {
            str3 = str4;
        }
        params.put("xsj_feed_id", str3);
        params.put("xsj_custom_pgid", pageId);
        params.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_REC_PIC_OUTSIDE_BUTTON);
        if (isImp) {
            str2 = "ev_xsj_abnormal_imp";
        } else {
            str2 = "ev_xsj_abnormal_clck";
        }
        VideoReport.reportEvent(str2, view, params);
    }

    public final void e(@NotNull View view, int pos, @NotNull StrategyImage info, @Nullable QCircleReportBean reportBean, boolean isImp) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(info, "info");
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_REC_PIC_LIST);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        int i3 = pos + 1;
        params.put("xsj_item_index", Integer.valueOf(i3));
        params.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_REC_PIC_LIST);
        String str4 = null;
        if (reportBean != null) {
            str = reportBean.getDtPageId();
        } else {
            str = null;
        }
        params.put("xsj_custom_pgid", str);
        if (reportBean != null) {
            str2 = reportBean.getFeedId();
        } else {
            str2 = null;
        }
        params.put("xsj_feed_id", str2);
        if (reportBean != null) {
            str4 = reportBean.getAuthUin();
        }
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str4);
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_PIC_REC_INFO, new RecPicReportInfo(i3, info.getStrategy(), info.getScore()).a());
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        if (isImp) {
            str3 = "ev_xsj_abnormal_imp";
        } else {
            str3 = "ev_xsj_abnormal_clck";
        }
        VideoReport.reportEvent(str3, view, params);
    }

    public final void f(@NotNull View view, int pos, @NotNull QFSLocalMediaInfo localMediaInfo, @Nullable QCircleReportBean reportBean, boolean isImp) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        if ((view.getTag(-1) instanceof Boolean) && isImp) {
            QLog.d("QFSRecPicReportHelper", 1, "[dtReportRecPic] has expose, index: " + pos);
            return;
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_CMT_CHOOSE_PIC_LIST);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        int i3 = pos + 1;
        params.put("xsj_item_index", Integer.valueOf(i3));
        params.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMT_CHOOSE_PIC_LIST);
        String str4 = null;
        if (reportBean != null) {
            str = reportBean.getDtPageId();
        } else {
            str = null;
        }
        params.put("xsj_custom_pgid", str);
        if (reportBean != null) {
            str2 = reportBean.getFeedId();
        } else {
            str2 = null;
        }
        params.put("xsj_feed_id", str2);
        if (reportBean != null) {
            str4 = reportBean.getAuthUin();
        }
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str4);
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_PIC_REC_INFO, new RecPicReportInfo(i3, localMediaInfo.getStrategy(), localMediaInfo.getScore()).a());
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        view.setTag(-1, Boolean.TRUE);
        if (isImp) {
            str3 = "ev_xsj_abnormal_imp";
        } else {
            str3 = "ev_xsj_abnormal_clck";
        }
        VideoReport.reportEvent(str3, view, params);
    }

    @Nullable
    public final StrategyImage g() {
        return selectImage;
    }

    public final void h(@NotNull StrategyImage image) {
        Intrinsics.checkNotNullParameter(image, "image");
        selectImage = image;
    }

    public final void i(@NotNull CmtClusterBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("data", bean.f());
        params.put("eid", "em_xsj_cmt_cluster");
        VideoReport.reportEvent("ev_xsj_abnormal_imp", params);
    }

    public final void j(@NotNull FeedClusterBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("data", bean.a());
        params.put("eid", "em_xsj_feed_cluster");
        VideoReport.reportEvent("ev_xsj_abnormal_imp", params);
    }

    public final void k(@NotNull List<InputClusterBean> beans) {
        Intrinsics.checkNotNullParameter(beans, "beans");
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        JSONArray jSONArray = new JSONArray();
        Iterator<InputClusterBean> it = beans.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next().a());
        }
        params.put("data", jSONArray.toString());
        params.put("eid", "em_xsj_feed_desc_cluster");
        VideoReport.reportEvent("ev_xsj_abnormal_imp", params);
    }

    public final void l(@NotNull List<InputClusterBean> beans) {
        Intrinsics.checkNotNullParameter(beans, "beans");
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        JSONArray jSONArray = new JSONArray();
        Iterator<InputClusterBean> it = beans.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next().a());
        }
        params.put("data", jSONArray.toString());
        params.put("eid", "em_xsj_input_cluster");
        VideoReport.reportEvent("ev_xsj_abnormal_imp", params);
    }

    public final void m(@NotNull RestartScanResult bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("data", bean.a());
        params.put("eid", "em_xsj_scan");
        VideoReport.reportEvent("ev_xsj_abnormal_imp", params);
    }

    public final void n(@NotNull ScanReportBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("data", bean.a());
        params.put("eid", "em_xsj_scan");
        VideoReport.reportEvent("ev_xsj_abnormal_imp", params);
    }
}
