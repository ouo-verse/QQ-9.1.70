package com.tencent.qqlive.tvkplayer.report.api;

import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKReportFactoryCreator {
    private static final String REPORT_FACTORY_CLASS_NAME = "com.tencent.qqlive.tvkplayer.report.factory.TVKReportFactory";
    private static final String TAG = "TVKReportFactoryCreator";
    private static final ITVKReportFactory sReportFactory = createReportFactoryInstance();

    private static ITVKReportFactory createReportFactoryInstance() {
        try {
            return (ITVKReportFactory) Class.forName(REPORT_FACTORY_CLASS_NAME).newInstance();
        } catch (ReflectiveOperationException | RuntimeException e16) {
            TVKLogUtil.e(TAG, "[createReportFactoryInstance] Fail to create report factory: " + e16);
            return null;
        }
    }

    public static ITVKReportFactory getReportFactory() {
        return sReportFactory;
    }
}
