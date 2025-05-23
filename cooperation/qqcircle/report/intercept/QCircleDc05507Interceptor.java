package cooperation.qqcircle.report.intercept;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.mini.api.LaunchScene;
import cooperation.qqcircle.report.QCircleLpReportDc05507;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleDc05507Interceptor extends QCircleDcBaseInterceptor {
    @Override // cooperation.qqcircle.report.intercept.QCircleDcBaseInterceptor
    public int getDcId() {
        return LaunchScene.LAUNCH_SCENE_ICGAME_LANDING_PAGE;
    }

    @Override // cooperation.qqcircle.report.intercept.QCircleDcBaseInterceptor
    @NonNull
    public String[] getFilterKeyList() {
        return new String[]{"play_url", QCircleLpReportDc05507.KEY_VIDEO_TAG, QCircleLpReportDc05507.KEY_PIC_INFO, QCircleLpReportDc05507.KEY_CLEAR, QCircleLpReportDc05507.KEY_CUBAGE, "width", QCircleLpReportDc05507.KEY_PLAY_ID, "vid", "lloc", QCircleLpReportDc05507.KEY_FEED_URL, "errorcode", "user_ip", "height", "unique_report_id", "network_type", "app_version", "rule_id"};
    }
}
