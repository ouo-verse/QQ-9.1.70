package com.tencent.mobileqq.mini.ad;

import android.app.Activity;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdReportHelper;
import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JV\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/mini/ad/MiniLoadingAdCommonManager;", "", "()V", "TAG", "", "updateLoadingAdLayoutAndShow", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, "", "adJson", "name", "iconUrl", "desc", "filePath", "videoPath", "aid", "", "loadingAdListener", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/AdProxy$ILoadingAdListener;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniLoadingAdCommonManager {
    public static final MiniLoadingAdCommonManager INSTANCE = new MiniLoadingAdCommonManager();
    private static final String TAG = "MiniLoadingAdCommonManager";

    MiniLoadingAdCommonManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateLoadingAdLayoutAndShow$lambda$0(AdProxy.ILoadingAdListener loadingAdListener, String str, boolean z16) {
        Intrinsics.checkNotNullParameter(loadingAdListener, "$loadingAdListener");
        loadingAdListener.onAdDismiss(z16);
        if (z16) {
            MiniLoadingAdReportHelper.INSTANCE.reportEvent(MiniLoadingAdReportHelper.EVENT_SKIP_CLICK, null, str);
        }
    }

    public final void updateLoadingAdLayoutAndShow(Activity activity, int adType, String adJson, String name, String iconUrl, String desc, String filePath, String videoPath, long aid, final AdProxy.ILoadingAdListener loadingAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adJson, "adJson");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        Intrinsics.checkNotNullParameter(loadingAdListener, "loadingAdListener");
        MiniLoadingAdLayout miniLoadingAdLayout = new MiniLoadingAdLayout(activity);
        miniLoadingAdLayout.initUI(adType);
        boolean z16 = miniLoadingAdLayout.setupUIForSDK(null, false, adJson, name, iconUrl, desc, filePath, videoPath, aid, loadingAdListener);
        final String traceId = miniLoadingAdLayout.getTraceId();
        MiniLoadingAdReportHelper miniLoadingAdReportHelper = MiniLoadingAdReportHelper.INSTANCE;
        miniLoadingAdReportHelper.reportEvent(MiniLoadingAdReportHelper.EVENT_RENDER_START, null, traceId);
        if (z16) {
            miniLoadingAdReportHelper.reportEvent(MiniLoadingAdReportHelper.EVENT_RENDER_SUCCESS, null, traceId);
            miniLoadingAdLayout.show(new MiniLoadingAdLayout.OnDismissListener() { // from class: com.tencent.mobileqq.mini.ad.a
                @Override // com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.OnDismissListener
                public final void onDismiss(boolean z17) {
                    MiniLoadingAdCommonManager.updateLoadingAdLayoutAndShow$lambda$0(AdProxy.ILoadingAdListener.this, traceId, z17);
                }
            });
            loadingAdListener.onAdShow(miniLoadingAdLayout);
        } else {
            QLog.d(TAG, 1, "getLoadingAdLayout setup fail");
            miniLoadingAdReportHelper.reportEvent(MiniLoadingAdReportHelper.EVENT_RENDER_FAIL, null, traceId);
        }
    }
}
