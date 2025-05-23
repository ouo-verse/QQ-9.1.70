package cooperation.qzone.api.impl;

import com.qzone.app.QZoneFeedAlertService;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.api.IQZoneRedPointApi;
import xm.c;

/* loaded from: classes38.dex */
public class QZoneRedPointApiImpl implements IQZoneRedPointApi {
    private static final String TAG = "QZoneRedPointApiImpl";

    @Override // cooperation.qzone.api.IQZoneRedPointApi
    public boolean canTogetherRefreshWithQQVideo(boolean z16) {
        return c.b(z16);
    }

    @Override // cooperation.qzone.api.IQZoneRedPointApi
    public void refreshRedPoint() {
        RFWLog.d(TAG, RFWLog.USR, "refreshRedPoint");
        QZoneFeedAlertService.getInstance().getFeedAlert(RFWThreadManager.getUIHandler(), 11);
    }
}
