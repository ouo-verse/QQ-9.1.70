package p40;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLiteBanner;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f425305a;

    static {
        LinkedList linkedList = new LinkedList();
        f425305a = linkedList;
        linkedList.add("pg_xsj_gzh_page");
        linkedList.add(QCircleDaTongConstant.PageId.PG_XSJ_SHARE_MID_PAGE);
        linkedList.add(QCircleDaTongConstant.PageId.PG_XSJ_QZONE_QQ_VIDEO_PAGE);
        linkedList.add(QCircleDaTongConstant.PageId.PG_XSJ_QZONE_SHARE_ITEM);
        linkedList.add(QCircleDaTongConstant.PageId.PG_XSJ_QZONE_MID_PAGE);
    }

    public static void a(View view, e30.b bVar, QCircleInitBean qCircleInitBean) {
        if (view == null) {
            return;
        }
        if (bVar != null && bVar.g() == null && qCircleInitBean != null) {
            bVar = new e30.b(qCircleInitBean.getFeed());
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_SMALL_WINDOW_ENTRANCE);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.putAll(ua0.c.d(bVar));
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    private static String b(QCircleInitBean qCircleInitBean) {
        QCircleReportBean fromReportBean;
        if (qCircleInitBean == null) {
            fromReportBean = null;
        } else {
            fromReportBean = qCircleInitBean.getFromReportBean();
        }
        if (fromReportBean == null) {
            return null;
        }
        return fromReportBean.getDtPageId();
    }

    public static boolean c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StLiteBanner = feedCloudMeta$StFeed.liteBanner) != null && feedCloudMeta$StLiteBanner.style_type.get() == 4 && feedCloudMeta$StFeed.liteBanner.business_type.get() == 4) {
            return true;
        }
        return false;
    }

    public static boolean d(QCircleInitBean qCircleInitBean) {
        return TextUtils.equals(b(qCircleInitBean), QCircleDaTongConstant.PageId.PG_XSJ_SMALL_WINDOW_PLAY_PAGE);
    }

    public static boolean e(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        if (feedCloudMeta$StFeed == null || (feedCloudMeta$StVideo = feedCloudMeta$StFeed.video) == null || TextUtils.isEmpty(feedCloudMeta$StVideo.playUrl.get()) || com.tencent.biz.qqcircle.immersive.adapter.n.e(feedCloudMeta$StFeed) != 1003 || RFWVideoUtils.isADUrl(feedCloudMeta$StFeed.video.playUrl.get()) || c(feedCloudMeta$StFeed)) {
            return false;
        }
        return true;
    }

    public static boolean f(QCircleInitBean qCircleInitBean) {
        return false;
    }
}
