package com.tencent.biz.qqcircle.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class cf {

    /* renamed from: a, reason: collision with root package name */
    private static FeedCloudMeta$StFeed f92742a;

    public static void a(Context context, int i3, QCircleReportBean qCircleReportBean, int i16, String str) {
        if (com.tencent.biz.qqcircle.immersive.views.search.util.p.q(context) != null && qCircleReportBean != null && f92742a != null) {
            if (TextUtils.isEmpty(str)) {
                RFWLog.d("QFSSearchClickDCReportUtils", RFWLog.USR, "[reportSearchClickToDc5507] searchText:" + str);
                return;
            }
            RFWLog.d("QFSSearchClickDCReportUtils", RFWLog.USR, "[reportSearchClickToDc5507] actionType: " + i3 + " | pageId: " + i16 + " | suggestText: " + str);
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(ua0.c.c(f92742a)).setActionType(i3).setSubActionType(2).setfpageid(qCircleReportBean.getFromPageId()).setExt3(str).setPageId(i16).setRequestId(com.tencent.biz.qqcircle.immersive.utils.ba.d(f92742a)));
            return;
        }
        RFWLog.d("QFSSearchClickDCReportUtils", RFWLog.USR, "[reportSearchClickToDc5507] current report param should not be null.");
    }

    public static void b() {
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference != null && weakReference.get() != null) {
            f92742a = QFSVideoView.D.get().getData();
            RFWLog.d("QFSSearchClickDCReportUtils", RFWLog.USR, "[updateSearchLastFeed] feed id: " + bj.g(f92742a));
            return;
        }
        f92742a = null;
    }
}
