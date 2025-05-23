package c40;

import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {
    public static Map<String, Object> a(b40.a aVar) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, aVar.k());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_NUM, Integer.valueOf(aVar.g()));
        return buildElementParams;
    }

    public static String b(QCircleAlbumBean qCircleAlbumBean) {
        if (qCircleAlbumBean.getFeedAlbumInfo().isDraft) {
            return "draft";
        }
        if (qCircleAlbumBean.isMiddlePage()) {
            return MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK;
        }
        return "profile";
    }

    public static void c(b40.a aVar) {
        Map<String, Object> a16 = a(aVar);
        a16.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_ALBUM_ENTRANCE);
        a16.put("xsj_custom_pgid", Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED));
        VideoReport.reportEvent("ev_xsj_abnormal_clck", a16);
    }

    public static void d(b40.a aVar) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, aVar.k());
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_CLOSE_ALBUM_ENTRANCE);
        buildElementParams.put("xsj_custom_pgid", Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED));
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }
}
