package com.tencent.mobileqq.qcircle.api.impl;

import android.widget.TextView;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.request.VSNetQUICExp;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qcircle.api.event.QCircleNotifyClearCacheEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.IVFSAssistantApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleRFWApiImpl implements IQCircleRFWApi {
    private static final String TAG = "QCircleConfigApiImpl";
    private static RFWMultiDownloadHelper sMultiDownloadHelper;

    static {
        RFWMultiDownloadHelper rFWMultiDownloadHelper = new RFWMultiDownloadHelper();
        sMultiDownloadHelper = rFWMultiDownloadHelper;
        rFWMultiDownloadHelper.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/pic/background/img_aio_tofu_ark_bg.9.png", vq3.a.a()));
        sMultiDownloadHelper.start();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRFWApi
    public void checkExceptionWhetherCauseByQCircle(String str) {
        QLog.e(TAG, 1, "checkExceptionWhetherCauseByQCircle");
        ASDynamicEngine.d(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRFWApi
    public void clearQCircleCache() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qcircle.api.impl.QCircleRFWApiImpl.1
            @Override // java.lang.Runnable
            public void run() {
                FileUtils.deleteDirectory(QCircleFeedPicLoader.g().getDownloadRootPath());
                FileUtils.deleteFilesInDirectory(((IVFSAssistantApi) QRoute.api(IVFSAssistantApi.class)).getSDKPrivatePath("qcircle/"));
                QLog.e(QCircleRFWApiImpl.TAG, 1, "clearQCircleCache success");
            }
        }, 64, null, true);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRFWApi
    public String getDefaultSavePath(String str) {
        return RFWDownloaderFactory.getDownloader(vq3.a.a()).getDefaultSavePath(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRFWApi
    public String getUniKeyFromUrl(String str) {
        return QCircleFeedPicLoader.getUniKeyFromUrl(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRFWApi
    public void notifyAccountChange() {
        VSNetQUICExp.onAccountChange();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRFWApi
    public void notifyClearQCircleCache() {
        SimpleEventBus.getInstance().dispatchEvent(new QCircleNotifyClearCacheEvent());
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRFWApi
    public void setNumberTypeface(TextView textView, boolean z16) {
        RFWTypefaceUtil.setNumberTypeface(textView, z16);
    }
}
