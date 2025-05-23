package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleGetFullScreenFeedListRequest extends QCircleGetFeedListRequest {
    public QCircleGetFullScreenFeedListRequest(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    public static String getTAG() {
        return "GFF-QCircleGetFullScreenFeedListRequest";
    }

    @Override // com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest, com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFullScreenFeeds";
    }

    @Override // com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest
    protected boolean isLoadFullScreenFeed(int i3) {
        QLog.d("GFF-QCircleGetFullScreenFeedListRequest", 1, "[isLoadFullScreenFeed] sourceType: " + i3);
        return true;
    }

    public QCircleGetFullScreenFeedListRequest(String str, String str2, boolean z16, String str3, String str4) {
        super(str, str2, z16, str3, str4);
    }

    public QCircleGetFullScreenFeedListRequest(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public QCircleGetFullScreenFeedListRequest(QCirclePolymerizationBean qCirclePolymerizationBean, String str, String str2) {
        super(qCirclePolymerizationBean, str, str2);
    }

    public QCircleGetFullScreenFeedListRequest(QCirclePolymerizeDetailBean qCirclePolymerizeDetailBean, String str, String str2) {
        super(qCirclePolymerizeDetailBean, str, str2);
    }

    public QCircleGetFullScreenFeedListRequest(QCirclePolymerizeDetailBean qCirclePolymerizeDetailBean, String str, String str2, boolean z16) {
        super(qCirclePolymerizeDetailBean, str, str2, z16);
    }

    public QCircleGetFullScreenFeedListRequest(QCircleInitBean qCircleInitBean, String str, String str2, String str3) {
        super(qCircleInitBean, str, str2, str3);
    }

    public QCircleGetFullScreenFeedListRequest(QCircleInitBean qCircleInitBean, String str) {
        super(qCircleInitBean, str);
    }

    public QCircleGetFullScreenFeedListRequest(QCircleAlbumBean qCircleAlbumBean, String str) {
        super(qCircleAlbumBean, str);
    }
}
