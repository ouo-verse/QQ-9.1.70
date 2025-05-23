package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.view.FilterEnum;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TeamWorkForceShare implements ShareActionSheet.OnItemClickListener, DialogInterface.OnCancelListener, a {
    private static final String E = "TeamWorkForceShare";
    private QQProgressDialog C;
    private String D = null;

    /* renamed from: d, reason: collision with root package name */
    private WebViewPlugin f291516d;

    /* renamed from: e, reason: collision with root package name */
    private AppInterface f291517e;

    /* renamed from: f, reason: collision with root package name */
    private Activity f291518f;

    /* renamed from: h, reason: collision with root package name */
    private String f291519h;

    /* renamed from: i, reason: collision with root package name */
    private String f291520i;

    /* renamed from: m, reason: collision with root package name */
    private ShareActionSheet f291521m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.TeamWorkForceShare$2, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f291523d;

        AnonymousClass2(boolean z16) {
            this.f291523d = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            final String filePath = AbsDownloader.getFilePath(TeamWorkForceShare.this.f291519h);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            final Bitmap decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(filePath, options);
            if (decodeFileWithBufferedStream == null || decodeFileWithBufferedStream.isRecycled()) {
                QLog.d(TeamWorkForceShare.E, 1, "share to wx, image decode failed, url = " + TeamWorkForceShare.this.f291519h);
                return;
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.teamwork.TeamWorkForceShare.2.1

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.teamwork.TeamWorkForceShare$2$1$a */
                /* loaded from: classes18.dex */
                class a implements WXShareHelper.a {
                    a() {
                    }

                    @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
                    public void onWXShareResp(BaseResp baseResp) {
                        byte b16;
                        if (TeamWorkForceShare.this.D != null && TeamWorkForceShare.this.D.equals(baseResp.transaction)) {
                            QLog.d(TeamWorkForceShare.E, 1, "wx rsp = " + baseResp.errCode);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (anonymousClass2.f291523d) {
                                b16 = 86;
                            } else {
                                b16 = 120;
                            }
                            TeamWorkForceShare.this.f291516d.onActivityResult(new Intent(), b16, baseResp.errCode);
                            WXShareHelper.b0().q0(this);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    WXShareHelper.b0().A(new a());
                    TeamWorkForceShare.this.D = String.valueOf(System.currentTimeMillis());
                    WXShareHelper b06 = WXShareHelper.b0();
                    String str = filePath;
                    Bitmap bitmap = decodeFileWithBufferedStream;
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    b06.v0(str, bitmap, FilterEnum.MIC_PTU_TRANS_XINXIAN, !anonymousClass2.f291523d ? 1 : 0, TeamWorkForceShare.this.D);
                }
            });
        }
    }

    public TeamWorkForceShare(WebViewPlugin webViewPlugin, JSONObject jSONObject) {
        this.f291516d = webViewPlugin;
        this.f291517e = webViewPlugin.mRuntime.b();
        this.f291518f = webViewPlugin.mRuntime.a();
        this.f291519h = jSONObject.optString("img_url");
        this.f291520i = jSONObject.optString("callback");
    }

    private void m() {
        ThreadManagerV2.post(new ImageRequestTask(this.f291519h, this), 8, null, true);
    }

    @Override // com.tencent.mobileqq.teamwork.a
    public void a(final Bitmap bitmap) {
        this.f291518f.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.TeamWorkForceShare.1
            @Override // java.lang.Runnable
            public void run() {
                TeamWorkForceShare.this.C.dismiss();
                Bitmap bitmap2 = bitmap;
                if (bitmap2 == null || bitmap2.isRecycled()) {
                    QLog.d(TeamWorkForceShare.E, 1, "decode image failed, url = " + TeamWorkForceShare.this.f291519h);
                    QQToast.makeText(TeamWorkForceShare.this.f291518f, HardCodeUtil.qqStr(R.string.u1d), 0).show();
                    return;
                }
                if (TeamWorkForceShare.this.f291521m == null) {
                    TeamWorkForceShare.this.f291518f.getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
                    ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
                    param.context = TeamWorkForceShare.this.f291518f;
                    param.fullScreen = false;
                    TeamWorkForceShare.this.f291521m = ShareActionSheetFactory.create(param);
                    Intent intent = new Intent();
                    intent.putExtra("forward_type", -3);
                    intent.putExtra(AppConstants.Key.KEY_SHARE_DATA_LINE_SUPPORT_TYPE, 1);
                    TeamWorkForceShare.this.f291521m.setIntentForStartForwardRecentActivity(intent);
                    TeamWorkForceShare.this.f291521m.setActionSheetItems(TeamWorkForceShare.this.l(), TeamWorkForceShare.this.k());
                    TeamWorkForceShare.this.f291521m.setItemClickListenerV2(TeamWorkForceShare.this);
                    TeamWorkForceShare.this.f291521m.setCancelListener(TeamWorkForceShare.this);
                    TeamWorkForceShare.this.f291521m.setRowVisibility(0, 0, 0);
                }
                TeamWorkForceShare.this.f291521m.show();
            }
        });
    }

    protected List<ShareActionSheetBuilder.ActionSheetItem> k() {
        return new ArrayList();
    }

    protected List<ShareActionSheetBuilder.ActionSheetItem> l() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        return arrayList;
    }

    public void n() {
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this.f291518f);
        this.C = qQProgressDialog;
        qQProgressDialog.show();
        m();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f291516d.onActivityResult(new Intent(), (byte) 17, -1);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        int i3;
        boolean z16;
        int i16;
        if (this.f291521m.isShowing()) {
            this.f291521m.dismiss();
        }
        int i17 = actionSheetItem.action;
        String str = E;
        QLog.d(str, 1, "action = " + actionSheetItem.action);
        if (i17 != 2) {
            if (i17 != 3) {
                if (i17 != 9) {
                    if (i17 != 10) {
                        if (i17 == 72) {
                            Bundle bundle = new Bundle();
                            bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                            bundle.putInt("key_direct_show_uin_type", actionSheetItem.uinType);
                            bundle.putString("key_direct_show_uin", actionSheetItem.uin);
                            this.f291516d.callJs(this.f291520i, String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", 1, 1, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                            WebViewFragment currentWebViewFragment = ((QQBrowserActivity) this.f291518f).getCurrentWebViewFragment();
                            if (currentWebViewFragment == null) {
                                QLog.d(str, 1, "fragment == null");
                                return;
                            }
                            Share share = (Share) currentWebViewFragment.getShare();
                            if (share == null) {
                                QLog.d(str, 1, "share == null");
                                return;
                            }
                            Bundle bundle2 = new Bundle();
                            bundle2.putBoolean("key_flag_from_plugin", true);
                            bundle2.putString("pluginName", "web_share");
                            bundle2.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, ITeamWorkUtils.DOCS_SOURCE_ICON_URL);
                            bundle2.putString("app_name", share.z());
                            bundle2.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, "web");
                            bundle2.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL, ITeamWorkUtils.DOCS_LIST_WEB_URL);
                            String B = share.B();
                            bundle2.putString("detail_url", share.getShareUrl());
                            bundle2.putString("title", B);
                            bundle2.putString("desc", share.x());
                            bundle2.putString(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION, "web");
                            bundle2.putInt("forward_type", 1001);
                            bundle2.putString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, share.A());
                            bundle2.putInt("emoInputType", 2);
                            QLog.d(str, 1, "title = " + B + ", desc = " + share.x() + ", url = " + share.getShareUrl());
                            bundle2.putString("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
                            bundle2.putBoolean("k_back", true);
                            bundle2.putString(AppConstants.Key.SHARE_BRIEF, this.f291518f.getString(R.string.f171308dy0, B));
                            bundle2.putByteArray(AppConstants.Key.STRUCT_MSG_BYTES, com.tencent.mobileqq.structmsg.i.e(bundle2).getBytes());
                            Intent intent = new Intent();
                            intent.putExtras(bundle2);
                            intent.putExtras(bundle);
                            ForwardBaseOption.startForwardActivityForResult(this.f291518f, intent, (Class<?>) ForwardRecentTranslucentActivity.class, (com.tencent.mobileqq.webview.swift.ao.b(FileReaderHelper.DOCX_EXT) << 8) | 18, -1, "");
                            return;
                        }
                        return;
                    }
                    i3 = 9;
                } else {
                    i3 = 9;
                }
                if (i17 == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    i16 = 3;
                } else {
                    i16 = 4;
                }
                if (!WXShareHelper.b0().e0()) {
                    QQToast.makeText(this.f291518f, R.string.f173257ih1, 1).show();
                    QLog.d(str, 1, "wx not installed");
                    this.f291516d.callJs(this.f291520i, String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", Integer.valueOf(i16), 1, 1, "wx not installed"));
                    return;
                } else if (!WXShareHelper.b0().f0()) {
                    QQToast.makeText(this.f291518f, R.string.f173258ih2, 1).show();
                    QLog.d(str, 1, "wx version too low");
                    this.f291516d.callJs(this.f291520i, String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", Integer.valueOf(i16), 1, 2, "wx version too low"));
                    return;
                } else {
                    this.f291516d.callJs(this.f291520i, String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", Integer.valueOf(i16), 1, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                    ThreadManagerV2.postImmediately(new AnonymousClass2(z16), null, true);
                    return;
                }
            }
            this.f291516d.callJs(this.f291520i, String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", 2, 1, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            String filePath = AbsDownloader.getFilePath(this.f291519h);
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            AppInterface appInterface = this.f291517e;
            if (appInterface != null) {
                userInfo.qzone_uin = appInterface.getAccount();
                AppInterface appInterface2 = this.f291517e;
                if (appInterface2 instanceof VideoAppInterface) {
                    userInfo.nickname = ((VideoAppInterface) appInterface2).G(0, appInterface2.getCurrentAccountUin(), null);
                } else {
                    userInfo.nickname = null;
                }
            }
            QZoneHelper.forwardToPublishMood(this.f291518f, userInfo, filePath, BaseApplication.getContext().getString(R.string.b1o), "", (com.tencent.mobileqq.webview.swift.ao.b(FileReaderHelper.DOCX_EXT) << 8) | 52);
            return;
        }
        this.f291516d.callJs(this.f291520i, String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", 1, 1, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        WebViewFragment currentWebViewFragment2 = ((QQBrowserActivity) this.f291518f).getCurrentWebViewFragment();
        if (currentWebViewFragment2 == null) {
            QLog.d(str, 1, "fragment == null");
            return;
        }
        Share share2 = (Share) currentWebViewFragment2.getShare();
        if (share2 == null) {
            QLog.d(str, 1, "share == null");
            return;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putBoolean("key_flag_from_plugin", true);
        bundle3.putString("pluginName", "web_share");
        bundle3.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, ITeamWorkUtils.DOCS_SOURCE_ICON_URL);
        bundle3.putString("app_name", share2.z());
        bundle3.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, "web");
        bundle3.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL, ITeamWorkUtils.DOCS_LIST_WEB_URL);
        String B2 = share2.B();
        bundle3.putString("detail_url", share2.getShareUrl());
        bundle3.putString("title", B2);
        bundle3.putString("desc", share2.x());
        bundle3.putString(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION, "web");
        bundle3.putInt("forward_type", 1001);
        bundle3.putString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, share2.A());
        bundle3.putInt("emoInputType", 2);
        QLog.d(str, 1, "title = " + B2 + ", desc = " + share2.x() + ", url = " + share2.getShareUrl());
        bundle3.putString("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
        bundle3.putBoolean("k_back", true);
        bundle3.putString(AppConstants.Key.SHARE_BRIEF, this.f291518f.getString(R.string.f171308dy0, B2));
        bundle3.putByteArray(AppConstants.Key.STRUCT_MSG_BYTES, com.tencent.mobileqq.structmsg.i.e(bundle3).getBytes());
        Intent intent2 = new Intent();
        intent2.putExtras(bundle3);
        ForwardBaseOption.startForwardActivityForResult(this.f291518f, intent2, (com.tencent.mobileqq.webview.swift.ao.b(FileReaderHelper.DOCX_EXT) << 8) | 18);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class ImageRequestTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private String f291528d;

        /* renamed from: e, reason: collision with root package name */
        private com.tencent.mobileqq.teamwork.a f291529e;

        public ImageRequestTask(String str, com.tencent.mobileqq.teamwork.a aVar) {
            this.f291528d = str;
            this.f291529e = aVar;
        }

        private void e() {
            HttpDownloader httpDownloader = new HttpDownloader();
            a aVar = new a();
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        DownloadParams downloadParams = new DownloadParams();
                        downloadParams.url = new URL(this.f291528d);
                        downloadParams.urlStr = this.f291528d;
                        FileOutputStream fileOutputStream2 = new FileOutputStream(AbsDownloader.getFilePath(this.f291528d));
                        try {
                            httpDownloader.downloadImage(fileOutputStream2, downloadParams, aVar);
                            fileOutputStream2.close();
                        } catch (Exception e16) {
                            e = e16;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            QLog.d(TeamWorkForceShare.E, 1, "download exception = " + e.getMessage());
                            TeamWorkForceShare.this.f291518f.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.TeamWorkForceShare.ImageRequestTask.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    TeamWorkForceShare.this.C.dismiss();
                                    QQToast.makeText(TeamWorkForceShare.this.f291518f, HardCodeUtil.qqStr(R.string.u1m), 0).show();
                                }
                            });
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e17) {
                                    e17.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Exception e18) {
                    e = e18;
                }
            } catch (Exception e19) {
                e19.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean f(boolean z16) {
            if (!z16) {
                return false;
            }
            File file = AbsDownloader.getFile(this.f291528d);
            Bitmap bitmap = null;
            if (file != null) {
                QLog.d(TeamWorkForceShare.E, 1, "file exist");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                try {
                    BaseImageUtil.decodeFileWithBufferedStream(file.getAbsolutePath(), options);
                } catch (OutOfMemoryError e16) {
                    e16.printStackTrace();
                }
                if (options.outWidth > com.tencent.mobileqq.utils.ah.M()) {
                    options.inSampleSize = (int) (com.tencent.mobileqq.utils.ah.M() / options.outWidth);
                }
                options.inJustDecodeBounds = false;
                try {
                    bitmap = BaseImageUtil.decodeFileWithBufferedStream(file.getAbsolutePath(), options);
                } catch (OutOfMemoryError e17) {
                    e17.printStackTrace();
                    QLog.d(TeamWorkForceShare.E, 1, "oom, url = " + this.f291528d);
                }
                com.tencent.mobileqq.teamwork.a aVar = this.f291529e;
                if (aVar != null) {
                    aVar.a(bitmap);
                }
                return true;
            }
            if (z16) {
                QLog.d(TeamWorkForceShare.E, 1, "file not exist, url = " + this.f291528d);
                com.tencent.mobileqq.teamwork.a aVar2 = this.f291529e;
                if (aVar2 != null) {
                    aVar2.a(null);
                }
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!f(false)) {
                e();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public class a implements URLDrawableHandler {
            a() {
            }

            @Override // com.tencent.image.URLDrawableHandler
            public boolean isCancelled() {
                return false;
            }

            @Override // com.tencent.image.URLDrawableHandler
            public void onFileDownloadFailed(int i3) {
                QLog.d(TeamWorkForceShare.E, 1, "download failed, code = " + i3 + ", url = " + ImageRequestTask.this.f291528d);
                ImageRequestTask.this.f(true);
            }

            @Override // com.tencent.image.URLDrawableHandler
            public void onFileDownloadStarted() {
                QLog.d(TeamWorkForceShare.E, 1, "start download, url = " + ImageRequestTask.this.f291528d);
            }

            @Override // com.tencent.image.URLDrawableHandler
            public void onFileDownloadSucceed(long j3) {
                QLog.d(TeamWorkForceShare.E, 1, "download success, size = " + j3 + ", url = " + ImageRequestTask.this.f291528d);
                ImageRequestTask.this.f(true);
            }

            @Override // com.tencent.image.URLDrawableHandler
            public void doCancel() {
            }

            @Override // com.tencent.image.URLDrawableHandler
            public void publishProgress(int i3) {
            }
        }
    }
}
