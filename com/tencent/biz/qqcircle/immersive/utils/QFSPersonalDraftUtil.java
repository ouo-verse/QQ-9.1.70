package com.tencent.biz.qqcircle.immersive.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.MediaInfo;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSPersonalDraftUtil {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface Draft2PublishErrorCode {
    }

    private void a(String str, int i3) {
        WinkPublishReportQueue.INSTANCE.report(new WinkPublishQualityReportData.Builder().eventId(QCirclePublishQualityReporter.E_PUBLISH_CLICK_DRAFT_INTERRUPT).traceId(str).ext1(String.valueOf(i3)).getReportData(), 1);
    }

    private void b(String str) {
        WinkPublishReportQueue.INSTANCE.report(new WinkPublishQualityReportData.Builder().eventId(QCirclePublishQualityReporter.E_PUBLISH_CLICK_DRAFT).traceId(str).getReportData(), 1);
    }

    public int c(Context context, DraftBean draftBean, int i3) {
        boolean z16;
        String traceId = QCirclePublishQualityReporter.getTraceId();
        List<String> originPath = draftBean.getOriginPath();
        QLog.d("QFSPersonalDraftUtil", 1, "goPublish, originPathList: " + originPath);
        if (originPath != null && !originPath.isEmpty()) {
            for (String str : originPath) {
                if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                    z16 = true;
                    break;
                }
            }
            z16 = false;
            if (z16) {
                QLog.w("QFSPersonalDraftUtil", 1, "goPublish, all file deleted");
                a(traceId, -2);
                return -2;
            }
            if (!com.tencent.biz.qqcircle.launcher.c.c(context, traceId, 21)) {
                return -3;
            }
            d(traceId, context, draftBean, i3);
            b(traceId);
            return 0;
        }
        a(traceId, -1);
        return -1;
    }

    public void d(String str, Context context, DraftBean draftBean, int i3) {
        String missionId = draftBean.getMissionId();
        Bundle bundle = new Bundle();
        bundle.putString(QQWinkConstants.MISSION_ID, missionId);
        bundle.putInt(QQWinkConstants.EDITOR_ENTRANCE, i3);
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, str);
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        bundle.putString("app_key", "00000QG6YX3X0LZH");
        List<String> originPath = draftBean.getOriginPath();
        if (originPath != null && !originPath.isEmpty()) {
            bundle.putStringArrayList(QQWinkConstants.PUBLISH_DRAFT_ORIGINAL_PATHS, new ArrayList<>(originPath));
            Config.a aVar = new Config.a();
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = originPath.iterator();
            while (it.hasNext()) {
                arrayList.add(new MediaInfo(MediaType.LOCAL_ALL, "", 0, 0, it.next(), "", "", 0, 0, "", "", 0L));
            }
            aVar.c(arrayList);
            bundle.putSerializable("WINK_MEDIA_PICKER_CONFIG", aVar.a());
        }
        com.tencent.biz.qqcircle.b.f82683f.b();
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkHome(r.x(context), bundle);
    }

    public void e(String str, Context context, DraftBean draftBean, int i3, int i16) {
        String missionId = draftBean.getMissionId();
        Bundle bundle = new Bundle();
        bundle.putString(QQWinkConstants.MISSION_ID, missionId);
        bundle.putInt(QQWinkConstants.EDITOR_ENTRANCE, i3);
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, str);
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        bundle.putString("app_key", "00000QG6YX3X0LZH");
        List<String> originPath = draftBean.getOriginPath();
        if (originPath != null && !originPath.isEmpty()) {
            bundle.putStringArrayList(QQWinkConstants.PUBLISH_DRAFT_ORIGINAL_PATHS, new ArrayList<>(originPath));
        }
        com.tencent.biz.qqcircle.b.f82683f.b();
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkHome(r.x(context), bundle);
    }

    public boolean f(int i3) {
        if (i3 != -1 && i3 != -2) {
            return false;
        }
        return true;
    }
}
