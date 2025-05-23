package com.tencent.gdtad;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRemote;
import com.tencent.open.downloadnew.DownloadInfo;
import java.lang.ref.WeakReference;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGdtAdAPI extends QRouteApi {
    AdError checkWeChatApp(Context context, String str, int i3);

    void doAfterLoginAndMessageLoaded();

    @Deprecated
    void doCgiReport(String str);

    String getSpUin();

    void handleGdtAdClick(GdtHandler.Params params);

    void initGdtContext(Context context, InitGdtContextParams initGdtContextParams);

    boolean isAmsSplashExceedLimit(boolean z16);

    AdClickUtil.Result jumpToWechatMiniApp(Handler handler, GdtAd gdtAd);

    @NonNull
    GdtAdLoader loadAd(GdtAdLoader.Session session, WeakReference<GdtAdLoader.Listener> weakReference, WeakReference<Context> weakReference2);

    void pauseAdFileDownload(FileManagerEntity fileManagerEntity);

    void preLoadAfterAdExposure(Context context, GdtAd gdtAd);

    void preLoadAfterAdLoaded(Context context, GdtAd gdtAd);

    void refreshAdDownloadTipBanner();

    void showFeedbackDialogFragment(AdFeedbackParams adFeedbackParams);

    void startAdFileDownload(FileManagerEntity fileManagerEntity);

    @QRemote
    void updateAdDownloadFile(DownloadInfo downloadInfo);

    void updateAdDownloadNotice(DownloadInfo downloadInfo);

    void updateAmsSplashShowTime(boolean z16, boolean z17);

    void updateSplashEmptyOrderParams(boolean z16, boolean z17, int i3);
}
