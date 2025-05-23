package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.utils.DangerousPersonToastUtils;
import com.tencent.mobileqq.mini.appbrand.utils.ShareUtils;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;
import com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareData;
import com.tencent.qzonehub.api.IQzoneShareApi;
import java.io.ByteArrayOutputStream;
import java.io.File;
import org.json.JSONObject;

@ProxyService(proxy = ShareProxy.class)
/* loaded from: classes34.dex */
public class ShareProxyImpl implements ShareProxy {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qqmini.proxyimpl.ShareProxyImpl$5, reason: invalid class name */
    /* loaded from: classes34.dex */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f347529d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ InnerShareData f347530e;

        AnonymousClass5(Activity activity, InnerShareData innerShareData) {
            this.f347529d = activity;
            this.f347530e = innerShareData;
        }

        @Override // java.lang.Runnable
        public void run() {
            final QQProgressDialog qQProgressDialog = new QQProgressDialog(this.f347529d);
            qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.l8a));
            qQProgressDialog.show();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ShareProxyImpl.5.1

                /* renamed from: com.tencent.qqmini.proxyimpl.ShareProxyImpl$5$1$a */
                /* loaded from: classes34.dex */
                class a implements URLDrawable.URLDrawableListener {
                    a() {
                    }

                    @Override // com.tencent.image.URLDrawable.URLDrawableListener
                    public void onLoadSuccessed(URLDrawable uRLDrawable) {
                        File fileInLocal = uRLDrawable.getFileInLocal();
                        boolean z16 = fileInLocal != null && fileInLocal.exists();
                        qQProgressDialog.dismiss();
                        if (!z16) {
                            QQToast.makeText(AnonymousClass5.this.f347529d, 1, HardCodeUtil.qqStr(R.string.l8c), 1).show(AnonymousClass5.this.f347529d.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        }
                        if (z16) {
                            InnerShareData innerShareData = AnonymousClass5.this.f347530e;
                            innerShareData.isLocalPic = true;
                            innerShareData.sharePicPath = fileInLocal.getPath();
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            ShareProxyImpl.this.k(anonymousClass5.f347530e);
                            return;
                        }
                        QLog.e("ShareProxyImpl", 1, "shareNetworkPicMessage failed, because of picture downloadFailed");
                    }

                    @Override // com.tencent.image.URLDrawable.URLDrawableListener
                    public void onLoadCanceled(URLDrawable uRLDrawable) {
                        QLog.e("ShareProxyImpl", 1, "onLoadCanceled");
                    }

                    @Override // com.tencent.image.URLDrawable.URLDrawableListener
                    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                        QLog.e("ShareProxyImpl", 1, "shareNetworkPicMessage failed, because of picture downloadFailed");
                    }

                    @Override // com.tencent.image.URLDrawable.URLDrawableListener
                    public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                    ShareProxyImpl.this.i(anonymousClass5.f347530e.sharePicPath, new a());
                }
            }, 128, null, true);
        }
    }

    private int h(int i3) {
        switch (i3) {
            case 0:
            case 1:
            case 4:
                return 2;
            case 2:
            case 6:
            case 7:
                return 3;
            case 3:
            case 5:
            case 8:
            default:
                return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, URLDrawable.URLDrawableListener uRLDrawableListener) {
        URLDrawable drawable = URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain());
        if (uRLDrawableListener != null) {
            if (drawable.getStatus() == 1) {
                hd0.c.a("ShareProxyImpl", "URLDrawable's status is SUCCESSED.");
                uRLDrawableListener.onLoadSuccessed(drawable);
            } else {
                hd0.c.a("ShareProxyImpl", "start load URLDrawable.");
            }
            drawable.setURLDrawableListener(uRLDrawableListener);
            drawable.downloadImediatly();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(InnerShareData innerShareData, String str, MiniAppInfo miniAppInfo) {
        Bitmap g16 = g(ImageUtil.getLocalBitmap(innerShareData.sharePicPath));
        int i3 = innerShareData.shareTarget;
        if (i3 == 3) {
            WXShareHelper.b0().M0(String.valueOf(System.currentTimeMillis()), innerShareData.title, g16, str, innerShareData.targetUrl);
        } else if (i3 == 4) {
            WXShareHelper.b0().N0(String.valueOf(System.currentTimeMillis()), innerShareData.title, g16, str, innerShareData.targetUrl);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("MiniAppInfoForQQ", MiniSdkLauncher.convert(miniAppInfo));
        bundle.putParcelable("MiniAppLaunchParamForQQ", aq.c(miniAppInfo.launchParam));
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "MiniAppTransferModule", MiniAppTransferModule.ACTION_MINI_RECORD_WX_SHARE_MINIAPP_FOR_QQ, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(MiniAppInfo miniAppInfo, Activity activity, int i3, String str, String str2, String str3) {
        q(miniAppInfo, i3, str, str2, ImageUtil.drawableToBitmap(activity.getResources().getDrawable(R.drawable.n1m)), str3);
    }

    private void t(Activity activity, String str, boolean z16, ShareData shareData) {
        ShareUtils.startSharePicToWeChat(activity, str, z16);
        if (shareData instanceof InnerShareData) {
            MiniAppInfo miniAppInfo = ((InnerShareData) shareData).getMiniAppInfo();
            Bundle bundle = new Bundle();
            if (miniAppInfo != null) {
                bundle.putParcelable("MiniAppInfoForQQ", MiniSdkLauncher.convert(miniAppInfo));
                bundle.putParcelable("MiniAppLaunchParamForQQ", aq.c(miniAppInfo.launchParam));
                BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "MiniAppTransferModule", MiniAppTransferModule.ACTION_MINI_RECORD_WX_SHARE_MINIAPP_FOR_QQ, bundle);
                return;
            }
            return;
        }
        QLog.w("ShareProxyImpl", 1, "startSharePicToWeChat shareData not inner share data");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public int getDefaultShareTarget() {
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public boolean isShareTargetAvailable(Context context, int i3) {
        return true;
    }

    public void l(InnerShareData innerShareData) {
        ThreadManager.getUIHandler().post(new AnonymousClass5(innerShareData.fromActivity, innerShareData));
    }

    public void m(InnerShareData innerShareData) {
        Activity activity;
        EntryModel entryModel;
        ShareChatModel shareChatModel;
        if (innerShareData != null && (activity = innerShareData.fromActivity) != null) {
            if (!(activity instanceof GameActivity1)) {
                QLog.e("ShareProxyImpl", 1, "shareQQArk. not GameActivity1");
            }
            MiniAppInfo miniAppInfo = innerShareData.getMiniAppInfo();
            if (miniAppInfo == null) {
                QLog.e("ShareProxyImpl", 1, "Failed to shareQQArk. miniAppInfo is null");
                return;
            }
            a aVar = new a(innerShareData);
            if (innerShareData.entryModel != null) {
                com.tencent.qqmini.sdk.launcher.model.EntryModel entryModel2 = innerShareData.entryModel;
                entryModel = new EntryModel(entryModel2.type, entryModel2.uin, entryModel2.name, entryModel2.isAdmin);
            } else {
                entryModel = null;
            }
            if (innerShareData.shareChatModel != null) {
                com.tencent.qqmini.sdk.launcher.model.ShareChatModel shareChatModel2 = innerShareData.shareChatModel;
                shareChatModel = new ShareChatModel(shareChatModel2.type, shareChatModel2.uin, shareChatModel2.name);
            } else {
                shareChatModel = null;
            }
            ShareQQArkHelper.s(innerShareData.fromActivity, new MiniArkShareModelBuilder().setAppId(miniAppInfo.appId).setTitle(miniAppInfo.name).setDescription(innerShareData.summary).setShareScene(innerShareData.shareScene).setShareTemplateType(1).setShareBusinessType(miniAppInfo.getReportType()).setPicUrl(innerShareData.sharePicPath).setVidUrl(null).setJumpUrl(innerShareData.entryPath).setIconUrl(miniAppInfo.iconUrl).setVersionType(miniAppInfo.verType).setVersionId(miniAppInfo.versionId).setWebURL(innerShareData.webURL).setTemplateId(innerShareData.templateId).setTemplateData(innerShareData.templateData).setEntryModel(entryModel).setShareChatModel(shareChatModel).setShareTarget(innerShareData.shareTarget).setRcvOpenId(innerShareData.recvOpenId).setWithShareTicket(innerShareData.withShareTicket).setMiniAppShareFrom(innerShareData.shareSource).setExtInfo(innerShareData.extInfo).setShareOrigin(innerShareData.shareOrigin).createMiniArkShareModel(), aVar);
            return;
        }
        QLog.e("ShareProxyImpl", 1, "Failed to shareQQArk. shareData or activity is null");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public void onJsShareAppMessage(Object obj) {
        if (!(obj instanceof InnerShareData)) {
            QLog.w("ShareProxyImpl", 1, "onJsShareAppMessage. Unknown type of data");
            return;
        }
        QLog.d("ShareProxyImpl", 1, "onJsShareAppMessage. data = " + obj);
        InnerShareData innerShareData = (InnerShareData) obj;
        switch (innerShareData.shareTarget) {
            case 0:
            case 2:
            case 5:
            case 6:
            case 8:
                m(innerShareData);
                return;
            case 1:
                n(innerShareData);
                return;
            case 3:
            case 4:
                o(innerShareData);
                return;
            case 7:
                s(innerShareData);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public void onJsShareAppPictureMessage(Object obj) {
        if (!(obj instanceof InnerShareData)) {
            QLog.w("ShareProxyImpl", 1, "onJsShareAppPictureMessage. Unknown type of data");
            return;
        }
        QLog.d("ShareProxyImpl", 1, "onJsShareAppMessage. data = " + obj);
        InnerShareData innerShareData = (InnerShareData) obj;
        if (innerShareData.isLocalPic) {
            k(innerShareData);
        } else {
            l(innerShareData);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public boolean shareGamePicture(Activity activity, ShareData shareData) {
        if (activity != null && (shareData instanceof InnerShareData)) {
            InnerShareData innerShareData = (InnerShareData) shareData;
            int i3 = innerShareData.shareTarget;
            if (i3 == 0) {
                ShareUtils.shareGamePicWithTail2QQ(activity, innerShareData.getMiniAppId(), innerShareData.sharePicPath, (ShareUtils.ShareSimpleCallback) null);
            } else if (i3 == 1) {
                ShareUtils.startSharePicToQzone(activity, innerShareData.sharePicPath, "");
            } else if (i3 == 3) {
                t(activity, innerShareData.sharePicPath, true, innerShareData);
            } else {
                if (i3 != 4) {
                    QLog.e("ShareProxyImpl", 1, "shareGamePicture: not support target=" + innerShareData.shareTarget);
                    return false;
                }
                t(activity, innerShareData.sharePicPath, false, innerShareData);
            }
            return true;
        }
        QLog.e("ShareProxyImpl", 1, "shareGamePicture params invalid");
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public void shareGameStructMessage(ShareData shareData, AsyncResult asyncResult) {
        InnerShareData innerShareData = (InnerShareData) shareData;
        if (innerShareData != null && asyncResult != null) {
            String str = innerShareData.sharePicPath;
            Activity activity = innerShareData.fromActivity;
            if (activity != null && !TextUtils.isEmpty(str)) {
                int i3 = innerShareData.shareTarget;
                if (i3 == 3 || i3 == 4) {
                    p(innerShareData, true);
                    asyncResult.onReceiveResult(true, null);
                    return;
                } else {
                    if (i3 == 0) {
                        ShareUtils.shareGameStructMsgToQQ(activity, innerShareData, asyncResult);
                        return;
                    }
                    QLog.e("ShareProxyImpl", 1, "shareGameStructMessage unsupport share type:" + innerShareData.shareTarget);
                    return;
                }
            }
            QLog.e("ShareProxyImpl", 1, "shareGameStructMessage localImgPath or activity null, activity=" + activity + ", localImgPath=" + str);
            return;
        }
        QLog.e("ShareProxyImpl", 1, "shareGameStructMessage shareData or asyncResult null, shareData=" + innerShareData + ", asyncResult=" + asyncResult);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public void showSharePanel(IMiniAppContext iMiniAppContext) {
        ((MiniAppProxy) AppLoaderFactory.g().getProxyManager().get(MiniAppProxy.class)).onCapsuleButtonMoreClick(iMiniAppContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class a implements MiniProgramShareUtils.OnShareListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InnerShareData f347534a;

        a(InnerShareData innerShareData) {
            this.f347534a = innerShareData;
        }

        @Override // com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener
        public void onShared(boolean z16, boolean z17) {
            if (z16) {
                InnerShareData innerShareData = this.f347534a;
                innerShareData.notifyShareResult(innerShareData.fromActivity, !z17 ? 1 : 0, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(MiniAppInfo miniAppInfo, int i3, String str, String str2, Bitmap bitmap, String str3) {
        if (i3 == 3) {
            WXShareHelper.b0().M0(String.valueOf(System.currentTimeMillis()), str, bitmap, "QQ\u5c0f\u7a0b\u5e8f \u00b7 " + str2, str3);
        } else if (i3 == 4) {
            WXShareHelper.b0().N0(String.valueOf(System.currentTimeMillis()), "QQ\u5c0f\u7a0b\u5e8f \u00b7 " + str2 + MsgSummary.STR_COLON + str, bitmap, "", str3);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("MiniAppInfoForSDK", miniAppInfo);
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "MiniAppTransferModule", MiniAppTransferModule.ACTION_MINI_RECORD_WX_SHARE_MINIAPP_FOR_SDK, bundle);
    }

    public void o(InnerShareData innerShareData) {
        p(innerShareData, false);
    }

    public void n(InnerShareData innerShareData) {
        String str;
        Activity activity = innerShareData.fromActivity;
        MiniAppInfo miniAppInfo = innerShareData.getMiniAppInfo();
        if (StringUtil.isEmpty(innerShareData.summary)) {
            str = miniAppInfo.desc;
        } else {
            str = innerShareData.summary;
        }
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareQzoneForMini(activity, miniAppInfo.appId, miniAppInfo.name, str, 1, 1, miniAppInfo.getReportType(), innerShareData.sharePicPath, innerShareData.entryPath, miniAppInfo.iconUrl, miniAppInfo.verType, miniAppInfo.versionId, innerShareData.shareSource == 11, innerShareData.shareOrigin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(InnerShareData innerShareData) {
        if (innerShareData == null) {
            return;
        }
        int i3 = innerShareData.shareTarget;
        if (i3 == 0) {
            ShareUtils.startSharePicToQQ(innerShareData.fromActivity, innerShareData.sharePicPath);
            return;
        }
        if (i3 == 1) {
            ShareUtils.startSharePicToQzone(innerShareData.fromActivity, innerShareData.sharePicPath, innerShareData.getMiniAppInfo().name);
            return;
        }
        if (i3 == 3) {
            Activity activity = innerShareData.fromActivity;
            ShareUtils.startSharePicToWeChat(activity, ShareUtils.getFileUri(activity, innerShareData.sharePicPath), true);
        } else if (i3 == 4) {
            Activity activity2 = innerShareData.fromActivity;
            ShareUtils.startSharePicToWeChat(activity2, ShareUtils.getFileUri(activity2, innerShareData.sharePicPath), false);
        } else {
            if (i3 != 5) {
                return;
            }
            ShareUtils.startSharePicToQQ(innerShareData.fromActivity, innerShareData.sharePicPath, innerShareData.shareChatModel);
        }
    }

    private void s(InnerShareData innerShareData) {
        if (innerShareData == null) {
            return;
        }
        MiniProgramShareUtils.shareUpdatableMsg(innerShareData.fromActivity, innerShareData.getMiniAppId(), h(innerShareData.getMiniAppInfo().verType), innerShareData.templateId, innerShareData.event, innerShareData.callbackId, innerShareData.subScene);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap g(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        QLog.d("AppBrandRuntime", 1, "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length original:" + byteArray.length);
        Bitmap bitmap2 = bitmap;
        int i3 = 0;
        while (i3 < 10 && byteArray.length > 32768) {
            Matrix matrix = new Matrix();
            matrix.setScale(0.7f, 0.7f);
            bitmap2 = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            bitmap2.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream2);
            byteArray = byteArrayOutputStream2.toByteArray();
            i3++;
            QLog.d("AppBrandRuntime", 1, "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length compressTo:" + byteArray.length);
        }
        QLog.d("AppBrandRuntime", 1, "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length done:" + byteArray.length);
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public void p(final InnerShareData innerShareData, boolean z16) {
        final Activity activity = innerShareData.fromActivity;
        if (!WXShareHelper.b0().e0()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ShareProxyImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(activity, 0, R.string.f173257ih1, 1).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
            });
            return;
        }
        if (!WXShareHelper.b0().f0()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ShareProxyImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(activity, 0, R.string.f173258ih2, 1).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandRuntime", 2, "startShareToWeChat. title=" + innerShareData.summary + ",sharePicPath=" + innerShareData.sharePicPath + ",entryPath=" + innerShareData.entryPath);
        }
        final MiniAppInfo miniAppInfo = innerShareData.getMiniAppInfo();
        if (miniAppInfo == null) {
            QLog.e("AppBrandRuntime", 1, "startShareToWeChat. apkgInfo is null!");
            return;
        }
        String str = innerShareData.summary;
        if (TextUtils.isEmpty(str)) {
            str = miniAppInfo.desc;
        }
        final String str2 = str;
        final int shareType = innerShareData.getShareType();
        if (z16) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.bg
                @Override // java.lang.Runnable
                public final void run() {
                    ShareProxyImpl.this.j(innerShareData, str2, miniAppInfo);
                }
            }, 64, null, true);
        } else {
            MiniProgramShareUtils.shareAsWeChatMsg(miniAppInfo.appId, miniAppInfo.name, str2, 1, 1, miniAppInfo.getReportType(), innerShareData.sharePicPath, null, innerShareData.entryPath, miniAppInfo.iconUrl, miniAppInfo.verType, miniAppInfo.versionId, null, shareType, innerShareData.shareOrigin, new MiniAppCmdInterface() { // from class: com.tencent.qqmini.proxyimpl.ShareProxyImpl.4

                /* renamed from: com.tencent.qqmini.proxyimpl.ShareProxyImpl$4$a */
                /* loaded from: classes34.dex */
                class a implements URLDrawable.URLDrawableListener {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f347527d;

                    a(String str) {
                        this.f347527d = str;
                    }

                    @Override // com.tencent.image.URLDrawable.URLDrawableListener
                    public void onLoadSuccessed(URLDrawable uRLDrawable) {
                        Bitmap drawableToBitmap = ImageUtil.drawableToBitmap(uRLDrawable.getCurrDrawable());
                        if (drawableToBitmap != null) {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            ShareProxyImpl shareProxyImpl = ShareProxyImpl.this;
                            MiniAppInfo miniAppInfo = miniAppInfo;
                            shareProxyImpl.q(miniAppInfo, shareType, str2, miniAppInfo.name, shareProxyImpl.g(drawableToBitmap), this.f347527d);
                        }
                    }

                    @Override // com.tencent.image.URLDrawable.URLDrawableListener
                    public void onLoadCanceled(URLDrawable uRLDrawable) {
                        QLog.e("AppBrandRuntime", 1, "startShareToWeChat. onLoadCanceled get an exception when handling URLbmp:");
                    }

                    @Override // com.tencent.image.URLDrawable.URLDrawableListener
                    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                        QLog.e("AppBrandRuntime", 1, "startShareToWeChat. onLoadFialed when handling URLbmp");
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        ShareProxyImpl shareProxyImpl = ShareProxyImpl.this;
                        MiniAppInfo miniAppInfo = miniAppInfo;
                        shareProxyImpl.r(miniAppInfo, activity, shareType, str2, miniAppInfo.name, this.f347527d);
                    }

                    @Override // com.tencent.image.URLDrawable.URLDrawableListener
                    public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
                        QLog.e("AppBrandRuntime", 1, "startShareToWeChat. onLoadProgressed get an exception when handling URLbmp:");
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v12, types: [int] */
                /* JADX WARN: Type inference failed for: r2v13 */
                /* JADX WARN: Type inference failed for: r2v15 */
                /* JADX WARN: Type inference failed for: r2v19 */
                /* JADX WARN: Type inference failed for: r2v20 */
                /* JADX WARN: Type inference failed for: r2v21 */
                /* JADX WARN: Type inference failed for: r2v6 */
                /* JADX WARN: Type inference failed for: r2v7 */
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public void onCmdListener(boolean z17, JSONObject jSONObject) {
                    final long j3;
                    final String str3;
                    String str4;
                    QLog.d("AppBrandRuntime", 1, "startShareToWeChat. isSuc:" + z17);
                    boolean z18 = false;
                    if (z17 && jSONObject != null) {
                        String optString = jSONObject.optString("jump_url");
                        if (jSONObject.optBoolean("needShareCallBack", false)) {
                            QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_SUC_CALLBACK, null, null);
                        }
                        try {
                            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                            Activity activity2 = activity;
                            if (activity2 != null) {
                                obtain.mFailedDrawable = activity2.getResources().getDrawable(R.drawable.n1m);
                            }
                            URLDrawable drawable = URLDrawable.getDrawable(innerShareData.sharePicPath, obtain);
                            drawable.setURLDrawableListener(new a(optString));
                            str4 = drawable.getStatus();
                            try {
                                if (str4 == 1) {
                                    Bitmap drawableToBitmap = ImageUtil.drawableToBitmap(drawable.getCurrDrawable());
                                    ShareProxyImpl shareProxyImpl = ShareProxyImpl.this;
                                    MiniAppInfo miniAppInfo2 = miniAppInfo;
                                    String str5 = optString;
                                    shareProxyImpl.q(miniAppInfo2, shareType, str2, miniAppInfo2.name, shareProxyImpl.g(drawableToBitmap), str5);
                                    str4 = str5;
                                } else {
                                    String str6 = optString;
                                    str4 = str6;
                                    if (drawable.getStatus() != 1) {
                                        drawable.startDownload();
                                        str4 = str6;
                                    }
                                }
                            } catch (Exception e16) {
                                e = e16;
                                QLog.e("AppBrandRuntime", 1, "startShareToWeChat. get an exception when handling URLbmp:" + e);
                                ShareProxyImpl shareProxyImpl2 = ShareProxyImpl.this;
                                MiniAppInfo miniAppInfo3 = miniAppInfo;
                                shareProxyImpl2.r(miniAppInfo3, activity, shareType, str2, miniAppInfo3.name, str4);
                            }
                        } catch (Exception e17) {
                            e = e17;
                            str4 = optString;
                        }
                    } else {
                        if (jSONObject != null) {
                            z18 = jSONObject.optBoolean("needShareCallBack", false);
                            j3 = jSONObject.optLong("retCode");
                            str3 = jSONObject.optString("errMsg");
                        } else {
                            j3 = -1;
                            str3 = null;
                        }
                        if (!z18) {
                            QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_SUC_CALLBACK, null, null);
                        }
                        if (activity == null) {
                            QLog.e("ShareProxyImpl", 1, "startShareToWe activity is null?!!");
                        } else {
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ShareProxyImpl.4.2

                                /* renamed from: com.tencent.qqmini.proxyimpl.ShareProxyImpl$4$2$a */
                                /* loaded from: classes34.dex */
                                class a implements DialogInterface.OnClickListener {
                                    a() {
                                    }

                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i3) {
                                        QLog.e("ShareProxyImpl", 1, "dialog click ");
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    long j16 = j3;
                                    if (j16 == -100070004 || j16 == -1000710003) {
                                        Activity activity3 = activity;
                                        DialogUtil.createCustomDialog(activity3, 233, activity3.getString(R.string.hix), str3, new a(), null).show();
                                    } else if (j16 == -100070016) {
                                        DangerousPersonToastUtils.shareErrorToast(activity, j16, str3);
                                    } else {
                                        Activity activity4 = activity;
                                        DangerousPersonToastUtils.shareErrorToast(activity4, j16, activity4.getString(R.string.c_y));
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public void sharePic(Activity activity, ShareData shareData) {
        if (activity == null || shareData == null || TextUtils.isEmpty(shareData.sharePicPath) || shareData.shareTarget != 0) {
            return;
        }
        ShareUtils.startSharePicToQQ(activity, shareData.sharePicPath);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public void share(Activity activity, ShareData shareData) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy
    public void onShareActivityResult(int i3, int i16, Intent intent) {
    }
}
