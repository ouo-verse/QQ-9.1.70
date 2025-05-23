package com.tencent.biz.qqcircle.immersive.utils;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.beans.QCircleFeedAlbumInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ab {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f90057a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f90058b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f90059c = false;

    /* renamed from: d, reason: collision with root package name */
    private static final Map<String, Integer> f90060d;

    /* renamed from: e, reason: collision with root package name */
    private static final Map<Integer, Integer> f90061e;

    static {
        HashMap hashMap = new HashMap();
        f90060d = hashMap;
        HashMap hashMap2 = new HashMap();
        f90061e = hashMap2;
        hashMap.put("pg_xsj_explore_page", 10);
        hashMap.put(QCircleDaTongConstant.PageId.PG_XSJ_FOLLOWING_PAGE, 1);
        hashMap.put("pg_xsj_friendtab_explore_page", 75);
        hashMap.put(QCircleDaTongConstant.PageId.PG_XSJ_AVATAR_APERTURE_PAGE, 93);
        hashMap.put("pg_xsj_gzh_page", 61);
        hashMap.put(QCircleDaTongConstant.PageId.PG_XSJ_SHARE_MID_PAGE, 15);
        hashMap.put(QCircleDaTongConstant.PageId.PG_XSJ_QZONE_MID_PAGE, 90);
        hashMap.put(QCircleDaTongConstant.PageId.PG_XSJ_QZONE_VIDEO_TAB_MID_PAGE, 90);
        hashMap.put(QCircleDaTongConstant.PageId.PG_XSJ_QZONE_SHARE_ITEM, 90);
        hashMap.put(QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE, 47);
        hashMap.put("pg_xsj_profile_page", 8);
        hashMap2.put(200, 90);
    }

    public static QCircleAlbumBean a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        boolean z17;
        boolean z18;
        if (!k(feedCloudMeta$StFeed)) {
            QLog.d("GFF-QFSFullScreenUtils", 1, "[generateAlbumInfo] current album info is empty, generate fail.");
            return null;
        }
        FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum = feedCloudMeta$StFeed.album_infos.get(0).album.get();
        String str = feedCloudMeta$FeedAlbum.owner.f398463id.get();
        long j3 = feedCloudMeta$FeedAlbum.f398441id.get();
        String str2 = feedCloudMeta$FeedAlbum.title.get();
        String str3 = feedCloudMeta$FeedAlbum.description.get();
        String str4 = feedCloudMeta$FeedAlbum.cover_url.get();
        if (feedCloudMeta$FeedAlbum.collection_info.status.get() == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (feedCloudMeta$FeedAlbum.status.get() == 2) {
            z18 = true;
        } else {
            z18 = false;
        }
        QCircleAlbumBean qCircleAlbumBean = new QCircleAlbumBean(new QCircleFeedAlbumInfo(str, j3, str2, str3, str4, z17, z18));
        if (z16) {
            qCircleAlbumBean.setFeed(feedCloudMeta$StFeed);
        }
        return qCircleAlbumBean;
    }

    public static Object b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!k(feedCloudMeta$StFeed)) {
            QLog.d("GFF-QFSFullScreenUtils", 4, "[getAlbumId] current album info is empty, generate fail.");
            return null;
        }
        try {
            return Long.valueOf(feedCloudMeta$StFeed.album_infos.get(0).album.get().f398441id.get());
        } catch (Throwable th5) {
            QLog.e("GFF-QFSFullScreenUtils", 1, "[getAlbumId] ex: ", th5);
            return null;
        }
    }

    public static FeedCloudMeta$StFeed c(QFSLayerAlbumViewModel qFSLayerAlbumViewModel, String str) {
        List<e30.b> N2;
        if (qFSLayerAlbumViewModel == null) {
            N2 = null;
        } else {
            N2 = qFSLayerAlbumViewModel.N2();
        }
        return com.tencent.biz.qqcircle.utils.bj.f((e30.b) RFSafeListUtils.get(N2, com.tencent.biz.qqcircle.utils.bj.d(N2, str) + 1));
    }

    public static long d(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!k(feedCloudMeta$StFeed)) {
            return 0L;
        }
        try {
            return feedCloudMeta$StFeed.album_infos.get(0).feed_serial_number.get();
        } catch (Throwable th5) {
            QLog.e("GFF-QFSFullScreenUtils", 1, "[getAlbumId] ex: ", th5);
            return 0L;
        }
    }

    public static String e(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QCircleAlbumBean a16 = a(feedCloudMeta$StFeed, false);
        if (a16 != null && a16.getFeedAlbumInfo() != null) {
            return a16.getFeedAlbumInfo().title;
        }
        return null;
    }

    private static String f(QCircleInitBean qCircleInitBean) {
        QCircleReportBean fromReportBean;
        if (qCircleInitBean == null) {
            fromReportBean = null;
        } else {
            fromReportBean = qCircleInitBean.getFromReportBean();
        }
        if (fromReportBean != null) {
            return fromReportBean.getDtCustomPagId();
        }
        return "";
    }

    private static String g(QCircleInitBean qCircleInitBean) {
        QCircleReportBean fromReportBean;
        if (qCircleInitBean == null) {
            fromReportBean = null;
        } else {
            fromReportBean = qCircleInitBean.getFromReportBean();
        }
        if (fromReportBean != null) {
            return fromReportBean.getDtFromPageId();
        }
        return "";
    }

    private static String h(QCircleInitBean qCircleInitBean) {
        QCircleReportBean fromReportBean;
        if (qCircleInitBean == null) {
            fromReportBean = null;
        } else {
            fromReportBean = qCircleInitBean.getFromReportBean();
        }
        if (fromReportBean != null) {
            return fromReportBean.getDtPageId();
        }
        return "";
    }

    private static int i(QCircleInitBean qCircleInitBean) {
        QCircleReportBean fromReportBean;
        if (qCircleInitBean == null) {
            fromReportBean = null;
        } else {
            fromReportBean = qCircleInitBean.getFromReportBean();
        }
        if (fromReportBean != null) {
            return fromReportBean.getFromPageId();
        }
        return -1;
    }

    private static int j(QCircleInitBean qCircleInitBean) {
        QCircleReportBean fromReportBean;
        if (qCircleInitBean == null) {
            fromReportBean = null;
        } else {
            fromReportBean = qCircleInitBean.getFromReportBean();
        }
        if (fromReportBean != null) {
            return fromReportBean.getPageId();
        }
        return -1;
    }

    private static boolean k(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        PBRepeatMessageField<FeedCloudMeta$FeedAlbumInfo> pBRepeatMessageField;
        if (feedCloudMeta$StFeed != null && (pBRepeatMessageField = feedCloudMeta$StFeed.album_infos) != null && !pBRepeatMessageField.get().isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean l(FeedCloudMeta$StFeed feedCloudMeta$StFeed, QCircleInitBean qCircleInitBean) {
        if (k(feedCloudMeta$StFeed) && u(qCircleInitBean)) {
            return true;
        }
        return false;
    }

    public static boolean m(QFSLayerAlbumViewModel qFSLayerAlbumViewModel, String str) {
        List<e30.b> N2;
        int size;
        if (qFSLayerAlbumViewModel == null) {
            N2 = null;
        } else {
            N2 = qFSLayerAlbumViewModel.N2();
        }
        int d16 = com.tencent.biz.qqcircle.utils.bj.d(N2, str) + 1;
        if (N2 == null) {
            size = 0;
        } else {
            size = N2.size();
        }
        if (d16 >= size) {
            return true;
        }
        return false;
    }

    public static boolean n(QFSLayerAlbumViewModel qFSLayerAlbumViewModel) {
        List<e30.b> N2;
        if (qFSLayerAlbumViewModel == null) {
            N2 = null;
        } else {
            N2 = qFSLayerAlbumViewModel.N2();
        }
        if (N2 != null && N2.size() == 1) {
            return true;
        }
        return false;
    }

    public static boolean o(QCircleInitBean qCircleInitBean) {
        Serializable serializable;
        if (qCircleInitBean != null) {
            serializable = qCircleInitBean.getBusinessData("fullScreenAlbumMode");
        } else {
            serializable = null;
        }
        if ((serializable instanceof Boolean) && ((Boolean) serializable).booleanValue()) {
            return true;
        }
        return false;
    }

    public static boolean p() {
        return uq3.o.H0();
    }

    private static boolean q(QCircleInitBean qCircleInitBean) {
        FeedCloudMeta$StFeed feed;
        boolean z16;
        List<Integer> list = null;
        if (qCircleInitBean == null) {
            feed = null;
        } else {
            feed = qCircleInitBean.getFeed();
        }
        if (feed != null) {
            list = feed.opMask2.get();
        }
        if (list != null && list.contains(50)) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean w3 = w(qCircleInitBean);
        if (z16 != f90057a || w3 != f90058b) {
            QLog.d("GFF-QFSFullScreenUtils", 1, "[isAllPushPageFullScreenPageExp] isFullScreenExp: " + z16 + " | isScenePageEnabledScroll: " + w3);
        }
        f90057a = z16;
        f90058b = w3;
        if (!z16 || !w3) {
            return false;
        }
        return true;
    }

    public static boolean r(QCircleInitBean qCircleInitBean) {
        QCircleReportBean fromReportBean;
        if (qCircleInitBean == null) {
            fromReportBean = null;
        } else {
            fromReportBean = qCircleInitBean.getFromReportBean();
        }
        if (fromReportBean != null && fromReportBean.getPageId() == 503) {
            return true;
        }
        return false;
    }

    public static boolean s(QCircleInitBean qCircleInitBean) {
        boolean p16 = p();
        if (f90059c != p16) {
            f90059c = p16;
            QLog.d("GFF-QFSFullScreenUtils", 1, "[isEnableOtherPageFullScreenScroll] sIsEnableOtherPageFullScreenScrollPrint: " + f90059c);
        }
        return p16;
    }

    public static boolean t(QCircleInitBean qCircleInitBean) {
        return r(qCircleInitBean);
    }

    public static boolean u(QCircleInitBean qCircleInitBean) {
        boolean p16 = p();
        boolean r16 = r(qCircleInitBean);
        if (!p16 && r16) {
            return q(qCircleInitBean);
        }
        return s(qCircleInitBean);
    }

    public static boolean v(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StVideo = feedCloudMeta$StFeed.video) != null && feedCloudMeta$StVideo.orientation.get() == 2) {
            return true;
        }
        return false;
    }

    private static boolean w(QCircleInitBean qCircleInitBean) {
        if (uq3.c.A5()) {
            return true;
        }
        return r(qCircleInitBean);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int x(QCircleInitBean qCircleInitBean) {
        Integer num;
        int intValue;
        int j3 = j(qCircleInitBean);
        int i3 = i(qCircleInitBean);
        String h16 = h(qCircleInitBean);
        String g16 = g(qCircleInitBean);
        String f16 = f(qCircleInitBean);
        if (!TextUtils.isEmpty(h16)) {
            Map<String, Integer> map = f90060d;
            if (map.containsKey(h16)) {
                num = map.get(h16);
                if (num != null) {
                    intValue = 17;
                } else {
                    intValue = num.intValue();
                }
                Integer valueOf = Integer.valueOf(intValue);
                QLog.d("GFF-QFSFullScreenUtils", 1, "[obtainFullScreenSourceType] dcPageId: " + j3 + " | dcFromPageId: " + i3 + " | dtPageId: " + h16 + " | dtFromPageId: " + g16 + " | dtCustomPagId: " + f16 + " | sourceType: " + valueOf);
                return valueOf.intValue();
            }
        }
        if (!TextUtils.isEmpty(g16)) {
            Map<String, Integer> map2 = f90060d;
            if (map2.containsKey(g16)) {
                num = map2.get(g16);
                if (num != null) {
                }
                Integer valueOf2 = Integer.valueOf(intValue);
                QLog.d("GFF-QFSFullScreenUtils", 1, "[obtainFullScreenSourceType] dcPageId: " + j3 + " | dcFromPageId: " + i3 + " | dtPageId: " + h16 + " | dtFromPageId: " + g16 + " | dtCustomPagId: " + f16 + " | sourceType: " + valueOf2);
                return valueOf2.intValue();
            }
        }
        if (!TextUtils.isEmpty(f16)) {
            Map<String, Integer> map3 = f90060d;
            if (map3.containsKey(f16)) {
                num = map3.get(f16);
                if (num != null) {
                }
                Integer valueOf22 = Integer.valueOf(intValue);
                QLog.d("GFF-QFSFullScreenUtils", 1, "[obtainFullScreenSourceType] dcPageId: " + j3 + " | dcFromPageId: " + i3 + " | dtPageId: " + h16 + " | dtFromPageId: " + g16 + " | dtCustomPagId: " + f16 + " | sourceType: " + valueOf22);
                return valueOf22.intValue();
            }
        }
        if (j3 > -1) {
            Map<Integer, Integer> map4 = f90061e;
            if (map4.containsKey(Integer.valueOf(j3))) {
                num = map4.get(Integer.valueOf(j3));
                if (num != null) {
                }
                Integer valueOf222 = Integer.valueOf(intValue);
                QLog.d("GFF-QFSFullScreenUtils", 1, "[obtainFullScreenSourceType] dcPageId: " + j3 + " | dcFromPageId: " + i3 + " | dtPageId: " + h16 + " | dtFromPageId: " + g16 + " | dtCustomPagId: " + f16 + " | sourceType: " + valueOf222);
                return valueOf222.intValue();
            }
        }
        if (i3 > -1) {
            Map<Integer, Integer> map5 = f90061e;
            if (map5.containsKey(Integer.valueOf(i3))) {
                num = map5.get(Integer.valueOf(i3));
                if (num != null) {
                }
                Integer valueOf2222 = Integer.valueOf(intValue);
                QLog.d("GFF-QFSFullScreenUtils", 1, "[obtainFullScreenSourceType] dcPageId: " + j3 + " | dcFromPageId: " + i3 + " | dtPageId: " + h16 + " | dtFromPageId: " + g16 + " | dtCustomPagId: " + f16 + " | sourceType: " + valueOf2222);
                return valueOf2222.intValue();
            }
        }
        if (!TextUtils.isEmpty(g16) && g16.startsWith("pg_xsj_circle")) {
            num = 55;
        } else {
            num = null;
        }
        if (num != null) {
        }
        Integer valueOf22222 = Integer.valueOf(intValue);
        QLog.d("GFF-QFSFullScreenUtils", 1, "[obtainFullScreenSourceType] dcPageId: " + j3 + " | dcFromPageId: " + i3 + " | dtPageId: " + h16 + " | dtFromPageId: " + g16 + " | dtCustomPagId: " + f16 + " | sourceType: " + valueOf22222);
        return valueOf22222.intValue();
    }
}
