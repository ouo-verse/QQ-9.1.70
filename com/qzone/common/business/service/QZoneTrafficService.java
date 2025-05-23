package com.qzone.common.business.service;

import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.app.AppConstants;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneTrafficService {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f45600a;

    /* renamed from: b, reason: collision with root package name */
    private static String[] f45601b;

    public static void e(final boolean z16, final long j3) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(new Runnable() { // from class: com.qzone.common.business.service.QZoneTrafficService.1
            @Override // java.lang.Runnable
            public void run() {
                String[] strArr;
                String[] unused = QZoneTrafficService.f45600a;
                if (z16) {
                    if (QZoneTrafficService.f45600a == null) {
                        QZoneTrafficService.f45600a = new String[]{AppConstants.FlowStatPram.PARAM_WIFIQZONE_FLOW, "param_WIFIFlow", "param_Flow"};
                    }
                    strArr = QZoneTrafficService.f45600a;
                } else {
                    if (QZoneTrafficService.f45601b == null) {
                        QZoneTrafficService.f45601b = new String[]{AppConstants.FlowStatPram.PARAM_XGQZONE_FLOW, "param_XGFlow", "param_Flow"};
                    }
                    strArr = QZoneTrafficService.f45601b;
                }
                AppRuntime qzoneAppInterface = LoginData.getInstance().getQzoneAppInterface();
                if (qzoneAppInterface != null) {
                    qzoneAppInterface.sendAppDataIncermentMsg(LoginData.getInstance().getUinString(), strArr, j3);
                }
            }
        }, 3000L);
    }
}
