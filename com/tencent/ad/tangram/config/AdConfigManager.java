package com.tencent.ad.tangram.config;

import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.config.data.AdConfigForAnalysisReport;
import com.tencent.ad.tangram.config.data.AdConfigForDeeplinkLaunchTracer;
import com.tencent.ad.tangram.config.data.AdConfigForFeedback;
import com.tencent.ad.tangram.config.data.AdConfigForMsgReport;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdConfigManager {
    private static final String GROUP_ID_CLICK_LPP_REMOVE_WEB_PROCESS = "105820";
    private static final String GROUP_ID_CLICK_XIJING_V2 = "105851";
    private static final String GROUP_ID_REPORT_FOR_ANALYSIS_WITHOUT_ABTEST = "102537";
    private static final String GROUP_ID_REPORT_FOR_ANALYSIS_WITH_ABTEST = "102525";
    private static final String GROUP_ID_WX_CANVAS_VIDEO_OFFSET = "106014";
    private static volatile AdConfigManager sInstance;
    private WeakReference<Adapter> mWeakAdapter;

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public interface Adapter {
        AdConfigForAnalysisReport getConfigForAnalysisReport();

        AdConfigForDeeplinkLaunchTracer getConfigForDeeplinkLaunchTracer();

        AdConfigForFeedback getConfigForFeedback();

        AdConfigForMsgReport getConfigForMsgReport();

        boolean isReportForAnalysisEnabled();

        boolean isSwitchOn(String str, boolean z16);
    }

    private Adapter getAdapter() {
        WeakReference<Adapter> weakReference = this.mWeakAdapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdConfigManager getInstance() {
        if (sInstance == null) {
            synchronized (AdConfigManager.class) {
                if (sInstance == null) {
                    sInstance = new AdConfigManager();
                }
            }
        }
        return sInstance;
    }

    private boolean isSwitchOn(String str, boolean z16) {
        Adapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.isSwitchOn(str, z16);
        }
        return z16;
    }

    public boolean canClickLppRemoveWebProcess() {
        return isSwitchOn(GROUP_ID_CLICK_LPP_REMOVE_WEB_PROCESS, true);
    }

    public boolean canReportForAnalysisWithABTest() {
        return isSwitchOn(GROUP_ID_REPORT_FOR_ANALYSIS_WITH_ABTEST, false);
    }

    public boolean canReportForAnalysisWithoutABTest() {
        return isSwitchOn(GROUP_ID_REPORT_FOR_ANALYSIS_WITHOUT_ABTEST, true);
    }

    public AdConfigForAnalysisReport getConfigForAnalysisReport() {
        Adapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getConfigForAnalysisReport();
        }
        return null;
    }

    public AdConfigForDeeplinkLaunchTracer getConfigForDeeplinkLaunchTracer() {
        Adapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getConfigForDeeplinkLaunchTracer();
        }
        return null;
    }

    public AdConfigForFeedback getConfigForFeedback() {
        Adapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getConfigForFeedback();
        }
        return null;
    }

    public AdConfigForMsgReport getConfigForMsgReport() {
        Adapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getConfigForMsgReport();
        }
        return null;
    }

    public boolean isClickXIJINGV2Enabled() {
        return isSwitchOn(GROUP_ID_CLICK_XIJING_V2, true);
    }

    public boolean isReportForAnalysisEnabled() {
        Adapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.isReportForAnalysisEnabled();
        }
        return false;
    }

    public boolean isWXCanvasVideoOffsetEnabled() {
        return isSwitchOn(GROUP_ID_WX_CANVAS_VIDEO_OFFSET, true);
    }

    public void setAdapter(WeakReference<Adapter> weakReference) {
        this.mWeakAdapter = weakReference;
    }
}
