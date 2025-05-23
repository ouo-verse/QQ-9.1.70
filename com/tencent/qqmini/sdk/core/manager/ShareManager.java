package com.tencent.qqmini.sdk.core.manager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IShareManager;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.qqmini.sdk.utils.MiniProgramShareUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class ShareManager implements IShareManager {
    private static final String TAG = "ShareManager";

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadImageByURL(IMiniAppContext iMiniAppContext, String str, DownloaderProxy.DownloadListener downloadListener) {
        ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).download(str, null, ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPathByUrl(str), 60, downloadListener);
    }

    private AsyncResult getShareInfoResult(final InnerShareData innerShareData) {
        return new AsyncResult() { // from class: com.tencent.qqmini.sdk.core.manager.ShareManager.1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                final long j3;
                final String str;
                boolean z17;
                if (z16 && jSONObject != null) {
                    String optString = jSONObject.optString("jump_url");
                    boolean optBoolean = jSONObject.optBoolean("needShareCallBack");
                    InnerShareData innerShareData2 = innerShareData;
                    innerShareData2.needShareCallback = optBoolean;
                    innerShareData2.targetUrl = optString;
                    innerShareData2.jsonObject = jSONObject;
                    if (!optBoolean) {
                        innerShareData2.notifyShareResult(innerShareData2.fromActivity, 0, true);
                    }
                    ShareProxy shareProxy = (ShareProxy) ProxyManager.get(ShareProxy.class);
                    InnerShareData innerShareData3 = innerShareData;
                    if (shareProxy.isShareTargetAvailable(innerShareData3.fromActivity, innerShareData3.shareTarget)) {
                        InnerShareData innerShareData4 = innerShareData;
                        if (!innerShareData4.shareInMiniProcess) {
                            ShareManager.launchShareTransitiveFragment(innerShareData4);
                            return;
                        }
                        ShareProxy shareProxy2 = (ShareProxy) ProxyManager.get(ShareProxy.class);
                        InnerShareData innerShareData5 = innerShareData;
                        shareProxy2.share(innerShareData5.fromActivity, innerShareData5);
                        return;
                    }
                    return;
                }
                if (jSONObject != null) {
                    z17 = jSONObject.optBoolean("needShareCallBack");
                    j3 = jSONObject.optLong("retCode");
                    str = jSONObject.optString("errMsg");
                } else {
                    j3 = -1;
                    str = null;
                    z17 = false;
                }
                InnerShareData innerShareData6 = innerShareData;
                innerShareData6.needShareCallback = z17;
                if (!z17) {
                    innerShareData6.notifyShareResult(innerShareData6.fromActivity, 0, true);
                } else {
                    innerShareData6.notifyShareResult(innerShareData6.fromActivity, 1);
                }
                QMLog.e(ShareManager.TAG, "Failed to getShareInfo, result: " + jSONObject);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.core.manager.ShareManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        long j16 = j3;
                        if (j16 != -100070004 && j16 != -1000710003) {
                            if (j16 == -100070016) {
                                MiniToast.makeText(innerShareData.fromActivity, 0, str, 1).show();
                                return;
                            } else {
                                MiniToast.makeText(innerShareData.fromActivity, 1, "\u5c0f\u7a0b\u5e8f\u5206\u4eab\u5931\u8d25\uff0c\u53c2\u6570\u9519\u8bef", 1).show();
                                return;
                            }
                        }
                        DialogUtil.createCustomDialog(innerShareData.fromActivity, 230, ShareJsPlugin.ERRMSG_INVITE_REQUIRE, str, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.core.manager.ShareManager.1.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                QMLog.i(ShareManager.TAG, "dialog click ");
                            }
                        }, null).show();
                    }
                });
            }
        };
    }

    public static Bitmap getSharePicBitmap(Activity activity, String str) {
        try {
            Bitmap drawableToBitmap = ImageUtil.drawableToBitmap(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDrawable(activity, str, 0, 0, activity.getResources().getDrawable(R.drawable.mini_sdk_qzone_miniapp_more_button)));
            if (drawableToBitmap != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                drawableToBitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                QMLog.d(TAG, "getSharePicBitmap. ImageUtil.drawableToBitmap, out.toByteArray().length original:" + byteArray.length);
                Bitmap bitmap = drawableToBitmap;
                int i3 = 0;
                while (i3 < 10 && byteArray.length > 32768) {
                    Matrix matrix = new Matrix();
                    matrix.setScale(0.7f, 0.7f);
                    bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream2);
                    byteArray = byteArrayOutputStream2.toByteArray();
                    i3++;
                    QMLog.d(TAG, "getSharePicBitmap. ImageUtil.drawableToBitmap, out.toByteArray().length compressTo:" + byteArray.length);
                }
                QMLog.d(TAG, "getSharePicBitmap. ImageUtil.drawableToBitmap, out.toByteArray().length done:" + byteArray.length);
                return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            }
            return drawableToBitmap;
        } catch (Exception e16) {
            QMLog.w(TAG, "getSharePicBitmap. get an exception when handling URLbmp:" + e16);
            return ImageUtil.drawableToBitmap(activity.getResources().getDrawable(R.drawable.mini_sdk_qzone_miniapp_more_button));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void launchShareTransitiveFragment(InnerShareData innerShareData) {
        Activity activity = innerShareData.fromActivity;
        if (activity == null) {
            QMLog.e(TAG, "Failed to start ShareTransitiveFragment, activity is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(IPCConst.KEY_ORIGIN_TASK_ID, activity.getTaskId());
        intent.putExtra(IPCConst.KEY_SHARE_DATA, innerShareData);
        intent.setFlags(268435456);
        intent.putExtra("public_fragment_window_feature", 1);
        MiniFragmentLauncher.startTranslucent(activity, intent, MiniFragmentLauncher.FragmentType.FRAGMENT_SHARE_TRANSITIVE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareLocalPicMessage(InnerShareData innerShareData) {
        if (!innerShareData.isLocalPic) {
            QMLog.w(TAG, "shareLocalPicMessage. not local pic");
            return;
        }
        if (innerShareData.sharePicPath == null) {
            QMLog.w(TAG, "shareLocalPicMessage. local pic is null");
        } else if (((ShareProxy) ProxyManager.get(ShareProxy.class)).isShareTargetAvailable(innerShareData.fromActivity, innerShareData.shareTarget)) {
            if (innerShareData.shareInMiniProcess) {
                ((ShareProxy) ProxyManager.get(ShareProxy.class)).share(innerShareData.fromActivity, innerShareData);
            } else {
                launchShareTransitiveFragment(innerShareData);
            }
        }
    }

    private void shareNetworkPicMessage(final IMiniAppContext iMiniAppContext, final InnerShareData innerShareData) {
        final Activity activity = innerShareData.fromActivity;
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.core.manager.ShareManager.2
            @Override // java.lang.Runnable
            public void run() {
                final ReportProgressDialog reportProgressDialog = new ReportProgressDialog(activity);
                reportProgressDialog.setMessage("\u5206\u4eab\u4e2d\uff0c\u8bf7\u7a0d\u5019");
                reportProgressDialog.show();
                ShareManager.this.downloadImageByURL(iMiniAppContext, innerShareData.sharePicPath, new DownloaderProxy.DownloadListener() { // from class: com.tencent.qqmini.sdk.core.manager.ShareManager.2.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                    public void onDownloadFailed(int i3, String str) {
                        QMLog.e(ShareManager.TAG, "shareNetworkPicMessage failed, because of picture downloadFailed");
                    }

                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                    public void onDownloadSucceed(int i3, String str, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
                        boolean z16;
                        if (str != null) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        reportProgressDialog.dismiss();
                        if (!z16) {
                            MiniToast.makeText(activity, 1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u56fe\u7247\u5206\u4eab\u5931\u8d25", 1).show(activity.getResources().getDimensionPixelSize(R.dimen.mini_sdk_title_bar_height));
                        }
                        if (z16) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            InnerShareData innerShareData2 = innerShareData;
                            innerShareData2.isLocalPic = true;
                            innerShareData2.sharePicPath = str;
                            ShareManager.this.shareLocalPicMessage(innerShareData2);
                            return;
                        }
                        QMLog.e(ShareManager.TAG, "shareNetworkPicMessage failed, because of picture downloadFailed");
                    }

                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                    public void onDownloadHeadersReceived(int i3, Map<String, List<String>> map) {
                    }

                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                    public void onDownloadProgress(float f16, long j3, long j16) {
                    }
                });
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IShareManager
    public void newShareInfoRequest(InnerShareData innerShareData) {
        if (innerShareData == null) {
            QMLog.e(TAG, "Failed to create newShareInfoRequest");
            return;
        }
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "newShareInfoRequest. title=" + innerShareData.title + ",sharePicPath=" + innerShareData.sharePicPath + ",entryPath=" + innerShareData.entryPath);
        }
        MiniAppInfo miniAppInfo = innerShareData.getMiniAppInfo();
        if (miniAppInfo == null) {
            QMLog.e(TAG, "newShareInfoRequest. mini app info is null!");
            return;
        }
        String str = innerShareData.summary;
        if (TextUtils.isEmpty(str)) {
            str = miniAppInfo.desc;
        }
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getShareInfo(MiniProgramShareUtils.newShareInfoRequest(miniAppInfo.appId, innerShareData.summary, str, (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), 1, 1, miniAppInfo.getReportType(), innerShareData.sharePicPath, null, innerShareData.entryPath, miniAppInfo.iconUrl, null, miniAppInfo.verType, miniAppInfo.versionId, innerShareData.getShareType(), innerShareData.withShareTicket, innerShareData.webURL, null, innerShareData.templateId, innerShareData.templateData, innerShareData.recvOpenId), getShareInfoResult(innerShareData));
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IShareManager
    public void shareAppMessage(InnerShareData innerShareData) {
        if (QUAUtil.isQQMainApp()) {
            ((ShareProxy) ProxyManager.get(ShareProxy.class)).onJsShareAppMessage(innerShareData);
        } else {
            newShareInfoRequest(innerShareData);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IShareManager
    public void shareAppPictureMessage(IMiniAppContext iMiniAppContext, InnerShareData innerShareData) {
        if (innerShareData == null) {
            QMLog.e(TAG, "Failed to shareAppPictureMessage. shareData is null");
            return;
        }
        QMLog.d(TAG, "shareAppPictureMessage. shareData=" + innerShareData);
        if (QUAUtil.isQQMainApp()) {
            ((ShareProxy) ProxyManager.get(ShareProxy.class)).onJsShareAppPictureMessage(innerShareData);
        } else if (innerShareData.isLocalPic) {
            shareLocalPicMessage(innerShareData);
        } else {
            shareNetworkPicMessage(iMiniAppContext, innerShareData);
        }
    }
}
