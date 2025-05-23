package com.tencent.qzonehub.api.utils.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.video.QZoneVideoCompressor;
import cooperation.qzone.video.TcSdkDownloadReportServlet;
import cooperation.qzone.video.VideoComponentCallback;
import cooperation.qzone.webviewwrapper.IWebviewOnClassLoaded;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneVideoHelperImpl implements IQzoneVideoHelper {
    @Override // com.tencent.qzonehub.api.utils.IQzoneVideoHelper
    public void bindService(Context context, String str, ServiceConnection serviceConnection) {
        Intent intent = new Intent();
        intent.setClassName(context, QZoneHelper.INTENT_QZONE_VIDEO_SERVICE);
        intent.putExtra("qzone_uin", str);
        context.bindService(intent, serviceConnection, 1);
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneVideoHelper
    public void cancel(String str) {
        QZoneVideoCompressor.cancel(str);
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneVideoHelper
    public String getCacheDir(String str) {
        return CacheManager.getCacheDir(str);
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneVideoHelper
    public NewIntent getTcSdkDownloadReportServlet(Context context) {
        return new NewIntent(context, TcSdkDownloadReportServlet.class);
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneVideoHelper
    public Object getVideoComponentCallback() {
        return new VideoComponentCallback();
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneVideoHelper
    public int trimByFFmpeg(String[] strArr) {
        return QZoneVideoCompressor.trimByFFmpeg(strArr);
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneVideoHelper
    public int trimByFFmpeg(String str, String[] strArr) {
        return QZoneVideoCompressor.trimByFFmpeg(str, strArr);
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneVideoHelper
    public void preInitWebview(IWebviewOnClassLoaded iWebviewOnClassLoaded) {
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneVideoHelper
    public void forwardToBrowser(Activity activity, String str, int i3, Bundle bundle, String str2) {
    }
}
