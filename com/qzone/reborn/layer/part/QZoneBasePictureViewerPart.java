package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.util.Consumer;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.FeedActionPanelActivity;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.detail.ui.component.g;
import com.qzone.feed.panorama.PanoramaLayout;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.BasePictureViewer;
import com.qzone.preview.PictureAdapter;
import com.qzone.preview.business.BasePicureViewController;
import com.qzone.preview.service.PictureManager;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.util.ToastUtil;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.libra.util.ImageContentType;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.mini.api.QQMiniManager;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.api.IWinkMediaHelper;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.listener.INetEngineListener;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.sharpP.SharpPDecoderHelper;
import com.tencent.sharpP.SharpPDecoderWrapper;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.remote.Callback;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import cooperation.qzone.util.SystemUtil;
import cooperation.qzone.util.WeakReferenceHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import libavif.AvifDecoder;
import libavif.AvifImage;

/* loaded from: classes37.dex */
public abstract class QZoneBasePictureViewerPart extends com.qzone.reborn.base.k implements DialogInterface.OnCancelListener, com.qzone.preview.b {

    /* renamed from: s0, reason: collision with root package name */
    private static final String f57771s0 = ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).getDownloadBasePath() + ImageContentType.IMAGE_PREFIX;

    /* renamed from: t0, reason: collision with root package name */
    protected static int f57772t0 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_PHOTO_LIST_LOADMORE_COUNT, 50);

    /* renamed from: u0, reason: collision with root package name */
    static long f57773u0 = -1;
    protected BasePicureViewController H;
    private Dialog K;
    private int L;
    private String M;
    private BasePictureViewer.n N;
    private boolean P;
    private boolean Q;
    protected PanoramaLayout R;
    protected int T;
    protected boolean V;
    private long W;
    private int X;
    private String Y;
    protected int Z;

    /* renamed from: a0, reason: collision with root package name */
    @Deprecated
    private boolean f57774a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f57775b0;

    /* renamed from: c0, reason: collision with root package name */
    public GalleryManager f57776c0;

    /* renamed from: d, reason: collision with root package name */
    LayoutInflater f57777d;

    /* renamed from: d0, reason: collision with root package name */
    protected boolean f57778d0;

    /* renamed from: e, reason: collision with root package name */
    protected int f57779e;

    /* renamed from: e0, reason: collision with root package name */
    public int f57780e0;

    /* renamed from: f0, reason: collision with root package name */
    public ListView f57782f0;

    /* renamed from: g0, reason: collision with root package name */
    public com.qzone.preview.e f57783g0;

    /* renamed from: h, reason: collision with root package name */
    protected com.qzone.detail.ui.component.g f57784h;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f57785h0;

    /* renamed from: i0, reason: collision with root package name */
    boolean f57787i0;

    /* renamed from: j0, reason: collision with root package name */
    private Handler f57788j0;

    /* renamed from: k0, reason: collision with root package name */
    long f57789k0;

    /* renamed from: l0, reason: collision with root package name */
    private Handler f57790l0;

    /* renamed from: m0, reason: collision with root package name */
    private Handler f57792m0;

    /* renamed from: n0, reason: collision with root package name */
    private long f57793n0;

    /* renamed from: o0, reason: collision with root package name */
    IQzoneShareApi.WXShareListener f57794o0;

    /* renamed from: p0, reason: collision with root package name */
    private Handler f57795p0;

    /* renamed from: q0, reason: collision with root package name */
    private Handler f57796q0;

    /* renamed from: r0, reason: collision with root package name */
    protected ShareActionSheet.OnItemClickListener f57797r0;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f57781f = false;

    /* renamed from: i, reason: collision with root package name */
    final List<ShareActionSheetBuilder.ActionSheetItem> f57786i = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    final List<ShareActionSheetBuilder.ActionSheetItem> f57791m = new ArrayList();
    private boolean C = true;
    protected boolean D = false;
    protected boolean E = true;
    protected boolean F = true;
    private boolean G = false;
    private boolean I = true;
    private HashMap<Integer, s6.a> J = new HashMap<>();
    private boolean S = false;
    protected int U = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes37.dex */
    public static class WeChatForwardHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QZoneBasePictureViewerPart> f57810a;

        WeChatForwardHandler(QZoneBasePictureViewerPart qZoneBasePictureViewerPart) {
            this.f57810a = new WeakReference<>(qZoneBasePictureViewerPart);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 == 1) {
                ToastUtil.o(R.string.gk7, 4);
            } else if (i3 == 2) {
                Object obj = message.obj;
                if (obj != null && (obj instanceof String) && this.f57810a.get() != null) {
                    final String str = (String) message.obj;
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneBasePictureViewerPart.WeChatForwardHandler.1
                        @Override // java.lang.Runnable
                        public void run() {
                            byte[] i16 = com.qzone.util.image.c.i(str);
                            if (WeChatForwardHandler.this.f57810a.get() != null) {
                                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).addObserver(((QZoneBasePictureViewerPart) WeChatForwardHandler.this.f57810a.get()).f57794o0);
                            }
                            if (QZoneBasePictureViewerPart.S9() && WeChatForwardHandler.this.f57810a.get() != null && ((QZoneBasePictureViewerPart) WeChatForwardHandler.this.f57810a.get()).f57780e0 != 1) {
                                ShareUtils.r(((QZoneBasePictureViewerPart) WeChatForwardHandler.this.f57810a.get()).getActivity(), 9, ShareUtils.d.a(((QZoneBasePictureViewerPart) WeChatForwardHandler.this.f57810a.get()).H.b(), ((QZoneBasePictureViewerPart) WeChatForwardHandler.this.f57810a.get()).H.G(), com.qzone.util.image.c.u(str)), 1);
                            } else {
                                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), str, i16, 0);
                            }
                        }
                    });
                }
                QZLog.d("[PhotoAlbum]BasePictureViewer", 1, "forwardPictureForWXChat time cost:" + (System.currentTimeMillis() - QZoneBasePictureViewerPart.f57773u0));
            } else if (i3 == 3) {
                ToastUtil.o(R.string.gk6, 4);
            }
            if (this.f57810a.get() != null) {
                this.f57810a.get().U = 0;
            }
            QZoneBasePictureViewerPart.f57773u0 = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ShareActionSheetBuilder.ActionSheetItem f57812d;

        a(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
            this.f57812d = actionSheetItem;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            long j3;
            PhotoInfo b16 = QZoneBasePictureViewerPart.this.H.b();
            ShareActionSheetBuilder.ActionSheetItem actionSheetItem = this.f57812d;
            if (actionSheetItem.action != 9) {
                QZoneBasePictureViewerPart.this.wa(b16, actionSheetItem);
            } else {
                PhotoParam G = QZoneBasePictureViewerPart.this.H.G();
                PictureManager pictureManager = PictureManager.getInstance();
                Handler handler = QZoneBasePictureViewerPart.this.getHandler();
                int i16 = b16.appid;
                int i17 = i16 == 4 ? -1 : 1;
                String str = b16.pssCellId;
                String str2 = b16.albumId;
                String str3 = b16.lloc;
                if (G != null) {
                    j3 = G.ownerUin;
                } else {
                    j3 = b16.uploaduin;
                }
                pictureManager.getOutShareUrl(handler, i16, i17, str, str2, str3, null, 1, j3, 2, null);
                QZoneBasePictureViewerPart.this.tb(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchingUrl", "\u6b63\u5728\u83b7\u53d6\u5206\u4eaburl"));
                QZoneBasePictureViewerPart.this.P = false;
            }
            QZoneBasePictureViewerPart.this.Ya();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "\u53d6\u6d88\u5206\u4eab");
            QZoneBasePictureViewerPart.this.P = false;
            QZoneBasePictureViewerPart.this.Ya();
        }
    }

    /* loaded from: classes37.dex */
    class c implements ShareActionSheet.OnItemClickListener {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            QZoneBasePictureViewerPart.this.bb(actionSheetItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZoneBasePictureViewerPart.this.la();
            QZoneBasePictureViewerPart.this.P = false;
            QZoneBasePictureViewerPart.this.Ya();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "\u53d6\u6d88\u5206\u4eab");
            QZoneBasePictureViewerPart.this.P = false;
            QZoneBasePictureViewerPart.this.Ya();
        }
    }

    /* loaded from: classes37.dex */
    class g extends GalleryManager {
        g() {
        }

        @Override // com.tencent.common.galleryactivity.GalleryManager
        public com.tencent.common.galleryactivity.c g(Activity activity, com.tencent.common.galleryactivity.e eVar) {
            QZoneFeedxGalleryScene qZoneFeedxGalleryScene = new QZoneFeedxGalleryScene(activity, QZoneBasePictureViewerPart.this, eVar);
            qZoneFeedxGalleryScene.l1(QZoneBasePictureViewerPart.this.Sa());
            return qZoneFeedxGalleryScene;
        }

        @Override // com.tencent.common.galleryactivity.GalleryManager
        public com.tencent.common.galleryactivity.e h(Activity activity) {
            return QZoneBasePictureViewerPart.this.H;
        }

        @Override // com.tencent.common.galleryactivity.GalleryManager
        public com.tencent.common.galleryactivity.f i(Activity activity, com.tencent.common.galleryactivity.e eVar) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class h implements AdapterView.OnItemClickListener {
        h() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            QZoneBasePictureViewerPart.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class k extends Handler {
        k() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                ToastUtil.o(R.string.gkh, 4);
                return;
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                ToastUtil.o(R.string.gkk, 4);
                return;
            }
            Object obj = message.obj;
            if (obj == null || !(obj instanceof String)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(QzoneIPCModule.PIC_PATH, (String) obj);
            int i16 = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneIPCModule", QzoneIPCModule.ACTION_SAVE_CUSTOMEMOTION, bundle).data.getInt(QzoneIPCModule.RESULT_CODE);
            if (i16 != 0) {
                if (i16 == 2) {
                    ToastUtil.o(R.string.f170070f0, 4);
                } else {
                    ToastUtil.o(R.string.cwa, 4);
                }
            }
            if (QZLog.isColorLevel()) {
                QZLog.i("[PhotoAlbum]BasePictureViewer", "resultcode:" + i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class l extends Handler {
        l() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == -1) {
                QZoneBasePictureViewerPart.this.ha();
                QZLog.i(QZLog.TO_DEVICE_TAG, 1, "forwardPictureForChat copyPictures-save error: unknown");
                QZoneBasePictureViewerPart qZoneBasePictureViewerPart = QZoneBasePictureViewerPart.this;
                qZoneBasePictureViewerPart.U = 0;
                qZoneBasePictureViewerPart.f57793n0 = -1L;
                return;
            }
            if (i3 == 1) {
                QZoneBasePictureViewerPart.this.ha();
                ToastUtil.o(R.string.gk7, 4);
                QZoneBasePictureViewerPart qZoneBasePictureViewerPart2 = QZoneBasePictureViewerPart.this;
                qZoneBasePictureViewerPart2.U = 0;
                qZoneBasePictureViewerPart2.f57793n0 = -1L;
                return;
            }
            if (i3 != 2) {
                if (i3 == 3) {
                    QZoneBasePictureViewerPart.this.ha();
                    ToastUtil.o(R.string.gk6, 4);
                    QZoneBasePictureViewerPart qZoneBasePictureViewerPart3 = QZoneBasePictureViewerPart.this;
                    qZoneBasePictureViewerPart3.U = 0;
                    qZoneBasePictureViewerPart3.f57793n0 = -1L;
                    return;
                }
                if (i3 != 4) {
                    return;
                }
                if (QZoneBasePictureViewerPart.this.K == null || !QZoneBasePictureViewerPart.this.K.isShowing()) {
                    QZoneBasePictureViewerPart.this.tb(com.qzone.util.l.a(R.string.jzl));
                    return;
                }
                return;
            }
            QZoneBasePictureViewerPart.this.ha();
            Object obj = message.obj;
            if (obj != null && (obj instanceof String)) {
                String str = (String) obj;
                QZoneBasePictureViewerPart qZoneBasePictureViewerPart4 = QZoneBasePictureViewerPart.this;
                if (qZoneBasePictureViewerPart4.V) {
                    qZoneBasePictureViewerPart4.ub(str);
                } else {
                    qZoneBasePictureViewerPart4.xb(str);
                }
            }
            QZLog.d("[PhotoAlbum]BasePictureViewer", 1, "forwardPictureForChat time cost:" + (System.currentTimeMillis() - QZoneBasePictureViewerPart.this.f57793n0));
            QZoneBasePictureViewerPart qZoneBasePictureViewerPart5 = QZoneBasePictureViewerPart.this;
            qZoneBasePictureViewerPart5.U = 0;
            qZoneBasePictureViewerPart5.f57793n0 = -1L;
        }
    }

    /* loaded from: classes37.dex */
    class m implements IQzoneShareApi.WXShareListener {
        m() {
        }

        @Override // com.tencent.qzonehub.api.IQzoneShareApi.WXShareListener
        public void onWXShareResp(BaseResp baseResp) {
            int i3 = baseResp.errCode;
            if (i3 == 0) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastShared", "\u5df2\u5206\u4eab"), 5);
            } else if (i3 != -2) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastShareFail", ShareJsPlugin.ERRMSG_INVITE_REQUIRE), 4);
            }
        }
    }

    public QZoneBasePictureViewerPart() {
        this.f57774a0 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_SHOW_SHARE_BUTTONS, 1) == 1;
        this.f57775b0 = -1;
        this.f57776c0 = new g();
        this.f57778d0 = false;
        this.f57780e0 = 0;
        this.f57787i0 = false;
        this.f57789k0 = -1L;
        this.f57793n0 = -1L;
        this.f57794o0 = new m();
        this.f57796q0 = new n(this);
        this.f57797r0 = new c();
    }

    private void Aa(String str) {
        PhotoInfo b16 = this.H.b();
        ShareUtils.g gVar = new ShareUtils.g();
        gVar.f44741b = b16.shareTitle;
        gVar.f44742c = b16.shareSummary;
        gVar.f44743d = b16.sharePhotoUrl;
        gVar.f44740a = str;
        ShareUtils.q(getActivity(), 10, gVar);
    }

    public static String Ca(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            QZLog.w("[PhotoAlbum]BasePictureViewer", "---getDowndloadUrlForGif:photoInfo is null.");
            return "";
        }
        String a16 = com.qzone.util.aj.a(photoInfo);
        if (!TextUtils.isEmpty(a16) && SharpPUtils.isSharpP(a16)) {
            File imageFile = ImageLoader.getInstance().getImageFile(a16);
            if (imageFile == null || SharpPUtils.isSharpP(imageFile)) {
                a16 = a16.replace("&t=6", "").replace("t=6", "").replace("ek=1", "sharpp=1&ek=1");
                if (QZLog.isColorLevel()) {
                    QZLog.w("[PhotoAlbum]BasePictureViewer", "---getDowndloadUrlForGif--downloadUrl:" + a16);
                }
            }
        } else {
            QZLog.w("[PhotoAlbum]BasePictureViewer", "---getDowndloadUrlForGif:url is empty.");
        }
        return a16;
    }

    public static File Da(ImageLoader imageLoader, PhotoInfo photoInfo) {
        File imageFile = !TextUtils.isEmpty(photoInfo.orgUrl) ? imageLoader.getImageFile(photoInfo.orgUrl) : null;
        if ((imageFile == null || !imageFile.exists()) && !TextUtils.isEmpty(photoInfo.downloadUrl)) {
            imageFile = imageLoader.getImageFile(photoInfo.downloadUrl);
        }
        if ((imageFile == null || !imageFile.exists()) && photoInfo.photoType == 2) {
            imageFile = imageLoader.getImageFile(Ca(photoInfo));
        }
        if (imageFile == null || !imageFile.exists()) {
            imageFile = imageLoader.getImageFile(photoInfo.bigUrl);
        }
        return (imageFile != null || photoInfo.hasLoaded) ? imageFile : imageLoader.getImageFile(photoInfo.currentUrl);
    }

    private void Ea() {
        long j3;
        String str;
        long j16;
        PhotoInfo b16 = this.H.b();
        HashMap hashMap = new HashMap(1);
        if (b16.videoflag == 1) {
            hashMap.put(1, b16.videodata.videoUrl.url);
            hashMap.put(11, "1");
        }
        PhotoParam G = this.H.G();
        if (b16.appid != 311) {
            PictureManager pictureManager = PictureManager.getInstance();
            Handler handler = getHandler();
            if (TextUtils.isEmpty(b16.pssCellId)) {
                str = b16.albumId;
            } else {
                str = b16.pssCellId;
            }
            String str2 = b16.albumId;
            String str3 = b16.lloc;
            if (G != null) {
                j16 = G.ownerUin;
            } else {
                j16 = b16.uploaduin;
            }
            pictureManager.getOutShareUrl(handler, 4, 3, str, str2, str3, null, 3, j16, 2, hashMap);
        } else {
            String str4 = G != null ? G.cell_id : null;
            if (TextUtils.isEmpty(str4)) {
                if (TextUtils.isEmpty(b16.pssCellId)) {
                    str4 = b16.albumId;
                } else {
                    str4 = b16.pssCellId;
                }
            }
            String str5 = str4;
            PictureManager pictureManager2 = PictureManager.getInstance();
            Handler handler2 = getHandler();
            int i3 = b16.appid;
            String str6 = b16.albumId;
            String str7 = b16.lloc;
            if (G != null) {
                j3 = G.ownerUin;
            } else {
                j3 = b16.uploaduin;
            }
            pictureManager2.getOutShareUrl(handler2, i3, 3, str5, str6, str7, null, 3, j3, 2, hashMap);
        }
        tb(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchingUrl", "\u6b63\u5728\u83b7\u53d6\u5206\u4eaburl"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Fa() {
        if (this.H == null) {
            return "";
        }
        if (Ta()) {
            if (this.H.m0()) {
                return WinkDaTongReportConstant.ElementParamValue.QZONE_ALBUM_VIDEO_LAYER_PAGE;
            }
            return WinkDaTongReportConstant.ElementParamValue.QZONE_SHUOSHUO_VIDEO_LAYER_PAGE;
        }
        if (this.H.m0()) {
            return WinkDaTongReportConstant.ElementParamValue.QZONE_ALBUM_PIC_LAYER_PAGE;
        }
        return WinkDaTongReportConstant.ElementParamValue.QZONE_SHUOSHUO_PIC_LAYER_PAGE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Oa(String str) {
        VideoInfo videoInfo;
        IWinkMediaHelper iWinkMediaHelper = (IWinkMediaHelper) QRoute.api(IWinkMediaHelper.class);
        if (Ta()) {
            PhotoInfo b16 = this.H.b();
            if (b16 == null || (videoInfo = b16.videodata) == null) {
                return false;
            }
            return iWinkMediaHelper.isSupportVideoFormat(videoInfo.width, videoInfo.height, (int) videoInfo.validVideoTime);
        }
        return iWinkMediaHelper.isSupportImageFormat(new File(str));
    }

    static /* bridge */ /* synthetic */ boolean S9() {
        return qb();
    }

    public static String Ua(String str) {
        int indexOf;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        com.qzone.util.image.c.n(str, options);
        QZLog.i("QzonePhotoUtil", 1, "judgeImageFormat, path: " + str + ", outMimeType: " + options.outMimeType);
        if (options.outWidth > 0 && options.outHeight > 0 && options.outMimeType == null) {
            return "webp";
        }
        String str2 = options.outMimeType;
        if (str2 != null && (indexOf = str2.indexOf(47)) != -1) {
            return options.outMimeType.substring(indexOf + 1);
        }
        if (SharpPUtils.isSharpP(new File(str))) {
            QZLog.i("QzonePhotoUtil", 1, "judgeImageFormat, path: " + str + ", isSharpP");
            return "sharpp";
        }
        if (com.tencent.qzone.avif.a.a(new File(str))) {
            QZLog.i("QzonePhotoUtil", 1, "judgeImageFormat, path: " + str + ", isAvif");
            return "avif";
        }
        return "png";
    }

    private void Wa() {
        if (this.Q || !this.H.V()) {
            return;
        }
        BasePictureViewer.n nVar = this.N;
        if (nVar != null) {
            nVar.c();
        }
        this.Q = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ya() {
        BasePictureViewer.n nVar;
        if (this.P || (nVar = this.N) == null) {
            return;
        }
        nVar.b();
    }

    private void Za() {
        BasePictureViewer.n nVar;
        if (this.P || (nVar = this.N) == null) {
            return;
        }
        nVar.d();
    }

    private void ba(final int i3, final String str, final Handler handler) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneBasePictureViewerPart.9
            @Override // java.lang.Runnable
            public void run() {
                QZoneBasePictureViewerPart qZoneBasePictureViewerPart = QZoneBasePictureViewerPart.this;
                if (qZoneBasePictureViewerPart.f57780e0 == 1) {
                    final PhotoInfo[] P = qZoneBasePictureViewerPart.H.P();
                    if (QZoneBasePictureViewerPart.this.U == 0) {
                        Message obtain = Message.obtain();
                        obtain.what = 4;
                        handler.sendMessage(obtain);
                    }
                    if (P != null) {
                        QZoneBasePictureViewerPart qZoneBasePictureViewerPart2 = QZoneBasePictureViewerPart.this;
                        if (qZoneBasePictureViewerPart2.U < P.length) {
                            qZoneBasePictureViewerPart2.getHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneBasePictureViewerPart.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass9 anonymousClass9;
                                    QZoneBasePictureViewerPart qZoneBasePictureViewerPart3;
                                    int i16;
                                    PhotoInfo[] photoInfoArr = P;
                                    if (photoInfoArr == null || (i16 = (qZoneBasePictureViewerPart3 = QZoneBasePictureViewerPart.this).U) >= photoInfoArr.length || i16 < 0) {
                                        return;
                                    }
                                    qZoneBasePictureViewerPart3.cb(i3, photoInfoArr[i16]);
                                }
                            });
                        }
                    }
                    if (P != null) {
                        QZoneBasePictureViewerPart qZoneBasePictureViewerPart3 = QZoneBasePictureViewerPart.this;
                        if (qZoneBasePictureViewerPart3.U == P.length - 1) {
                            qZoneBasePictureViewerPart3.da(P, str, handler);
                            return;
                        }
                        return;
                    }
                    return;
                }
                PhotoInfo b16 = qZoneBasePictureViewerPart.H.b();
                if (!QZoneBasePictureViewerPart.this.Ra(b16)) {
                    if (QZoneBasePictureViewerPart.this.Ka(b16)) {
                        QZoneBasePictureViewerPart.this.getHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneBasePictureViewerPart.9.3
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                QZoneBasePictureViewerPart qZoneBasePictureViewerPart4 = QZoneBasePictureViewerPart.this;
                                qZoneBasePictureViewerPart4.ma(i3, qZoneBasePictureViewerPart4.H.F(), false);
                            }
                        });
                        return;
                    } else {
                        QZoneBasePictureViewerPart qZoneBasePictureViewerPart4 = QZoneBasePictureViewerPart.this;
                        qZoneBasePictureViewerPart4.ca(qZoneBasePictureViewerPart4.getActivity(), b16, str, handler);
                        return;
                    }
                }
                QZoneBasePictureViewerPart.this.getHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneBasePictureViewerPart.9.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                        QZoneBasePictureViewerPart.this.H0(i3);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da(PhotoInfo[] photoInfoArr, String str, Handler handler) {
        Message message;
        Bitmap c16;
        int i3;
        int i16;
        Bitmap bitmap;
        Message obtain = Message.obtain();
        if (photoInfoArr != null && photoInfoArr.length != 0) {
            if (!CacheManager.isExternalAvailable()) {
                obtain.what = 3;
                QZLog.i(QZLog.TO_DEVICE_TAG, 1, "copyPictures-save error sd is not writable");
                handler.sendMessage(obtain);
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ImageLoader imageLoader = ImageLoader.getInstance();
            for (PhotoInfo photoInfo : photoInfoArr) {
                File Da = Da(imageLoader, photoInfo);
                if (Da != null && Da.exists()) {
                    String Ua = Ua(Da.getAbsolutePath());
                    if (Ua == null) {
                        obtain.what = 1;
                        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "copyPictures-save error postfix == null");
                        handler.sendMessage(obtain);
                        return;
                    }
                    arrayList.add(Ua);
                    arrayList2.add(Da);
                } else {
                    obtain.what = -1;
                    QZLog.i(QZLog.TO_DEVICE_TAG, 1, "copyPictures-save error file == null");
                    Drawable imageByUrlInMemory = ImageManager.getInstance().getImageByUrlInMemory(photoInfo.bigUrl);
                    if ((imageByUrlInMemory instanceof ImageDrawable) && (bitmap = ((ImageDrawable) imageByUrlInMemory).getBitmapRef().getBitmap()) != null && !bitmap.isRecycled()) {
                        String str2 = str + (System.currentTimeMillis() + ".jpeg");
                        boolean V = com.qzone.util.image.c.V(bitmap, str2, Bitmap.CompressFormat.JPEG, 90, false);
                        obtain.what = V ? 2 : 1;
                        if (V) {
                            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "copyPictures-loadBitmap saveSuccess");
                            obtain.obj = str2;
                        }
                    }
                    handler.sendMessage(obtain);
                    return;
                }
            }
            int i17 = getActivity().getResources().getDisplayMetrics().widthPixels;
            Runtime runtime = Runtime.getRuntime();
            long maxMemory = runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
            ArrayList arrayList3 = new ArrayList();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            int i18 = 0;
            for (int i19 = 0; i19 < arrayList.size(); i19++) {
                if (((String) arrayList.get(i19)).equals("sharpp")) {
                    SharpPDecoderWrapper.SharpPFeatureWrapper featureInfo = new SharpPDecoderHelper(((File) arrayList2.get(i19)).getAbsolutePath()).getFeatureInfo();
                    if (featureInfo != null) {
                        i3 = featureInfo.getWidth();
                        i16 = featureInfo.getHeight();
                    }
                    i16 = -1;
                    i3 = -1;
                } else if (((String) arrayList.get(i19)).equals("avif")) {
                    AvifImage g16 = AvifDecoder.c(FileUtils.readFile(((File) arrayList2.get(i19)).getAbsolutePath())).g();
                    if (g16 != null) {
                        i3 = g16.b();
                        i16 = g16.a();
                    }
                    i16 = -1;
                    i3 = -1;
                } else {
                    BitmapFactory.decodeFile(((File) arrayList2.get(i19)).getAbsolutePath(), options);
                    i3 = options.outWidth;
                    i16 = options.outHeight;
                }
                if (i3 > 0 && i16 > 0) {
                    int i26 = (int) ((i16 * i17) / i3);
                    arrayList3.add(Integer.valueOf(i26));
                    i18 += i26;
                } else {
                    arrayList3.add(0);
                }
            }
            int i27 = i17 * i18 * 2;
            int i28 = i18;
            while (i27 > maxMemory * 0.85d) {
                int size = arrayList2.size() - 1;
                i28 -= ((Integer) arrayList3.get(size)).intValue();
                i27 -= (((Integer) arrayList3.get(size)).intValue() * i17) * 2;
                arrayList2.remove(size);
                arrayList.remove(size);
                arrayList3.remove(size);
            }
            if (i28 > 0 && i17 > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(i17, i28, Bitmap.Config.RGB_565);
                options.inJustDecodeBounds = false;
                int i29 = 0;
                for (int i36 = 0; i36 < arrayList.size(); i36++) {
                    try {
                        if ("sharpp".equals(arrayList.get(i36))) {
                            QZLog.i("[PhotoAlbum]BasePictureViewer", "sharpp file");
                            c16 = SharpPUtils.decodeSharpP(((File) arrayList2.get(i36)).getAbsolutePath());
                        } else if (((String) arrayList.get(i36)).equals("avif")) {
                            c16 = com.tencent.qzone.image.api.a.c().a((File) arrayList2.get(i36), ((File) arrayList2.get(i36)).getAbsolutePath(), 0, 0);
                        } else {
                            if ("gif".equals(arrayList.get(i36))) {
                                QZLog.i("[PhotoAlbum]BasePictureViewer", "gif file");
                            } else {
                                QZLog.i("[PhotoAlbum]BasePictureViewer", "webp file");
                            }
                            c16 = com.qzone.util.image.c.c(BitmapFactory.decodeFile(((File) arrayList2.get(i36)).getAbsolutePath(), options), 90);
                        }
                        if (c16 != null) {
                            try {
                                if (i36 < arrayList3.size() && ((Integer) arrayList3.get(i36)).intValue() > 0) {
                                    PhotoUtils.drawBitmap(createBitmap, com.qzone.util.image.c.F(c16, i17 / c16.getWidth()), i29);
                                    i29 += ((Integer) arrayList3.get(i36)).intValue();
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                QZLog.w("[PhotoAlbum]BasePictureViewer", "copy picture error ", th);
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                }
                Bitmap F = createBitmap.getHeight() > 29999 ? com.qzone.util.image.c.F(createBitmap, 29999 / createBitmap.getHeight()) : createBitmap;
                String str3 = System.currentTimeMillis() + ".jpeg";
                String str4 = str + str3;
                if (com.qzone.util.image.c.W(F, str, str3, Bitmap.CompressFormat.JPEG, 90, true)) {
                    message = obtain;
                    message.what = 2;
                    message.obj = str4;
                    QZLog.i("[PhotoAlbum]BasePictureViewer", "------file save success:" + str3);
                } else {
                    message = obtain;
                    message.what = 1;
                    QZLog.i("[PhotoAlbum]BasePictureViewer", "------file save error:" + str3);
                }
                handler.sendMessage(message);
                return;
            }
            obtain.what = 1;
            handler.sendMessage(obtain);
            QZLog.i("[PhotoAlbum]BasePictureViewer", "------file save error: width: " + i17 + ", height: " + i28 + ", url: " + Arrays.toString(photoInfoArr));
            return;
        }
        obtain.what = 1;
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "copyPictures-save error photoInfos == null");
        handler.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha() {
        try {
            Dialog dialog = this.K;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.K.dismiss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la() {
        VideoInfo videoInfo;
        VideoUrl videoUrl;
        BasePicureViewController basePicureViewController = this.H;
        if (basePicureViewController == null || basePicureViewController.b() == null) {
            return;
        }
        PhotoInfo b16 = this.H.b();
        String str = b16.downloadUrl;
        String str2 = b16.albumId + "_" + b16.lloc;
        if (TextUtils.isEmpty(str) && (videoInfo = b16.videodata) != null && (videoUrl = videoInfo.downloadVideoUrl) != null && !TextUtils.isEmpty(videoUrl.url)) {
            str = b16.videodata.downloadVideoUrl.url;
            str2 = b16.videodata.albumid + "_" + b16.videodata.lloc + ".mp4";
        }
        ga();
        tb(getContext().getResources().getString(R.string.f2199767v));
        if (this.f57780e0 == 1) {
            ToastUtil.n(R.string.f21969674);
            ha();
        } else {
            na(str, str2, new f());
        }
    }

    private void lb() {
        PhotoInfo b16 = this.H.b();
        VideoInfo videoInfo = b16.videodata;
        if (videoInfo == null) {
            return;
        }
        VideoUrl videoUrl = videoInfo.downloadVideoUrl;
        if (videoUrl != null && !TextUtils.isEmpty(videoUrl.url)) {
            QLog.d("QzonePhotoUtil", 1, "saveVideo downloadVideoUrl: " + b16.videodata.downloadVideoUrl.url);
            PictureManager.getInstance().downloadVideo(b16.videodata.downloadVideoUrl.url, null);
            return;
        }
        VideoUrl videoUrl2 = b16.videodata.originVideoUrl;
        if (videoUrl2 != null && !TextUtils.isEmpty(videoUrl2.url)) {
            QLog.d("QzonePhotoUtil", 1, "saveVideo originVideoUrl: " + b16.videodata.originVideoUrl.url);
            PictureManager.getInstance().downloadVideo(b16.videodata.originVideoUrl.url, null);
            return;
        }
        VideoUrl videoUrl3 = b16.videodata.videoUrl;
        if (videoUrl3 == null || TextUtils.isEmpty(videoUrl3.url)) {
            return;
        }
        QLog.d("QzonePhotoUtil", 1, "saveVideo videoUrl: " + b16.videodata.videoUrl.url);
        PictureManager.getInstance().downloadVideo(b16.videodata.videoUrl.url, null);
    }

    private void oa(final String str, final String str2, final String str3, final INetEngineListener iNetEngineListener) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneBasePictureViewerPart.17
            @Override // java.lang.Runnable
            public void run() {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str4 = str2 + str3;
                if (!new File(str4).exists()) {
                    HttpNetReq httpNetReq = new HttpNetReq();
                    httpNetReq.mCallback = new a();
                    httpNetReq.mReqUrl = str;
                    QLog.d("[PhotoAlbum]BasePictureViewer", 1, "req.mReqUrl = " + httpNetReq.mReqUrl);
                    httpNetReq.mHttpMethod = 0;
                    httpNetReq.mOutPath = str4;
                    QLog.d("[PhotoAlbum]BasePictureViewer", 1, "req.mOutPath = " + httpNetReq.mOutPath);
                    httpNetReq.mContinuErrorLimit = 2;
                    ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendReq(httpNetReq);
                    return;
                }
                iNetEngineListener.getFilePath(str4);
            }

            /* renamed from: com.qzone.reborn.layer.part.QZoneBasePictureViewerPart$17$a */
            /* loaded from: classes37.dex */
            class a implements com.tencent.mobileqq.transfile.INetEngineListener {
                a() {
                }

                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onResp(NetResp netResp) {
                    NetReq netReq;
                    if (netResp != null && netResp.mResult == 0 && (netReq = netResp.mReq) != null && !TextUtils.isEmpty(netReq.mOutPath)) {
                        iNetEngineListener.getFilePath(netResp.mReq.mOutPath);
                    } else {
                        iNetEngineListener.getFilePath("");
                    }
                }

                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
                }
            }
        }, 64, null, false);
    }

    private static boolean qb() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_SETTING_SHARE_SINGLE_BIG_PICTURE_AS_WECHAT_MINI_PROGRAM, 1) == 1;
    }

    private void ra(Bundle bundle) {
        String str;
        String str2;
        String string = bundle.getString("url", "");
        bundle.getString("mini_title", "");
        PhotoInfo b16 = this.H.b();
        ShareUtils.g gVar = new ShareUtils.g();
        if (TextUtils.isEmpty(b16.shareTitle)) {
            str = "\u5206\u4eabQQ\u7a7a\u95f4\u7684\u7167\u7247";
        } else {
            str = b16.shareTitle;
        }
        gVar.f44741b = str;
        gVar.f44742c = "\u6765\u81eaQQ\u7a7a\u95f4";
        if (TextUtils.isEmpty(b16.sharePhotoUrl)) {
            str2 = b16.bigUrl;
        } else {
            str2 = b16.sharePhotoUrl;
        }
        gVar.f44743d = str2;
        gVar.f44740a = string;
        ShareUtils.r(getActivity(), 10, gVar, 0);
    }

    private void rb() {
        ShareUtils.s(getActivity(), new d(), new e());
        this.P = true;
    }

    private void sb(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        ShareUtils.s(getContext(), new a(actionSheetItem), new b());
        this.P = true;
    }

    private void ta(String str, String str2) {
        PhotoInfo b16 = this.H.b();
        VideoInfo videoInfo = b16.videodata;
        if (videoInfo == null || videoInfo.videoUrl == null) {
            return;
        }
        ShareUtils.f fVar = new ShareUtils.f();
        fVar.f44741b = b16.shareTitle;
        fVar.f44742c = b16.shareSummary;
        fVar.f44743d = b16.sharePhotoUrl;
        fVar.f44740a = str;
        fVar.f44728h = Ga(b16.videodata);
        VideoInfo videoInfo2 = b16.videodata;
        int i3 = (int) (videoInfo2.videoTime / 1000);
        fVar.f44729i = i3;
        fVar.f44730j = i3;
        fVar.f44731k = videoInfo2.width;
        fVar.f44732l = videoInfo2.height;
        fVar.f44733m = str2;
        fVar.f44736p = this.V;
        fVar.f44737q = this.W;
        fVar.f44738r = this.X;
        fVar.f44739s = this.Y;
        ShareUtils.o(getActivity(), fVar, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb(String str) {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        if (this.K == null) {
            ReportDialog reportDialog = new ReportDialog(getActivity(), R.style.f174269ui);
            this.K = reportDialog;
            reportDialog.setContentView(R.layout.bqd);
            this.K.findViewById(R.id.kja).setVisibility(8);
            this.K.findViewById(R.id.cib).setVisibility(0);
        }
        ((TextView) this.K.findViewById(R.id.dialogText)).setText(str);
        this.K.show();
    }

    private void ua() {
        PhotoInfo b16 = this.H.b();
        if (b16 == null) {
            return;
        }
        int d16 = ShareUtils.d(this.H.h0(), b16.shareSpaceRight, b16.shareAlbumRight, true, false);
        if (d16 == 0) {
            la();
        } else if (d16 == 4) {
            rb();
        }
        ga();
    }

    private void va(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (this.V) {
            this.L = 72;
        } else {
            this.L = 2;
        }
        PhotoInfo b16 = this.H.b();
        int d16 = ShareUtils.d(this.H.h0(), b16.shareSpaceRight, b16.shareAlbumRight, true, false);
        if (d16 == 0) {
            wa(b16, actionSheetItem);
        } else {
            if (d16 != 4) {
                return;
            }
            sb(actionSheetItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa(PhotoInfo photoInfo, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        VideoInfo videoInfo = photoInfo.videodata;
        if (videoInfo == null || videoInfo.videoUrl == null) {
            return;
        }
        com.qzone.reborn.layer.share.d.V(getHostActivity(), photoInfo, actionSheetItem, false);
    }

    private void za(Bundle bundle) {
        String string = bundle.getString("url", "");
        String string2 = bundle.getString("mini_id", "");
        String string3 = bundle.getString("mini_path", "");
        String string4 = bundle.getString("mini_title", "");
        boolean a16 = ShareUtils.a(string2, string3);
        PhotoInfo b16 = this.H.b();
        ShareUtils.g gVar = new ShareUtils.g();
        gVar.f44741b = b16.shareTitle;
        gVar.f44742c = b16.shareSummary;
        gVar.f44743d = b16.sharePhotoUrl;
        gVar.f44740a = string;
        Activity activity = getActivity();
        if (qb() && a16) {
            gVar = ShareUtils.d.b(b16, string2, string3, string4);
        }
        ShareUtils.r(activity, 9, gVar, (qb() && a16) ? 1 : 0);
    }

    public String Ga(VideoInfo videoInfo) {
        VideoUrl videoUrl = videoInfo.downloadVideoUrl;
        if (videoUrl != null && !TextUtils.isEmpty(videoUrl.url)) {
            return videoInfo.downloadVideoUrl.url;
        }
        return videoInfo.videoUrl.url;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ha() {
        return this.S;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ia(QZoneResult qZoneResult) {
        ha();
        if (qZoneResult != null && qZoneResult.getSucceed()) {
            Bundle bundle = qZoneResult.getBundle();
            if (bundle == null) {
                QZLog.e("[PhotoAlbum]shareOutSide", "[PhotoAlbum]BasePictureViewer data == null");
                return;
            }
            String string = bundle.getString("msg", "");
            int i3 = bundle.getInt("iShareOutType", 0);
            if (i3 == 1) {
                ToastUtil.s(string, 4);
                return;
            } else if (i3 != 3) {
                pb(bundle);
                return;
            } else {
                pb(bundle);
                return;
            }
        }
        ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchUrlFail", "\u83b7\u53d6\u5206\u4eab\u4fe1\u606f\u5931\u8d25"), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ja(QZoneResult qZoneResult) {
        String str;
        ha();
        if (qZoneResult != null && qZoneResult.getSucceed() && (qZoneResult.getData() instanceof String)) {
            ta(this.M, (String) qZoneResult.getData());
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleGetVideoIdResult: ");
        if (qZoneResult != null) {
            str = qZoneResult.getMessage();
        } else {
            str = "result is null";
        }
        sb5.append(str);
        QZLog.e("[PhotoAlbum]BasePictureViewer", sb5.toString());
        ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastGetSharingVIDFail", "\u83b7\u53d6\u5206\u4eabVID\u5931\u8d25"), 4);
    }

    public boolean Ma() {
        PhotoInfo b16 = this.H.b();
        return b16 != null && b16.photoType == 2;
    }

    protected boolean Na() {
        com.qzone.detail.ui.component.g gVar = this.f57784h;
        return gVar != null && gVar.isShowing();
    }

    protected boolean Pa() {
        if (this.f57775b0 == -1) {
            this.f57775b0 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_IS_PHOTO_SAVE, 1);
        }
        return this.f57775b0 == 1;
    }

    @Override // com.qzone.preview.b
    public void S7(boolean z16) {
        ob(z16);
    }

    protected boolean Sa() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T9(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) this.f57776c0.k().g();
        if (relativeLayout == null || view == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.qzone.util.ar.k() / 2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        view.setId(R.id.b4p);
        relativeLayout.addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ta() {
        return com.qzone.util.z.b(this.H.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U9(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) this.f57776c0.k().g();
        if (relativeLayout == null || view == null || !(view.getContext() instanceof Activity)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10, -1);
        layoutParams.addRule(11, -1);
        layoutParams.setMargins(0, com.qzone.util.ar.d(13.0f) + SystemUtil.getNotchHeight(view.getContext(), (Activity) view.getContext()), com.qzone.util.ar.d(12.0f), 0);
        relativeLayout.addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V9(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) this.f57776c0.k().g();
        if (relativeLayout == null || view == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        view.setId(R.id.f166517ft0);
        relativeLayout.addView(view, layoutParams);
    }

    public void Va(String str) {
        yo.g gVar = new yo.g(str);
        ha();
        yo.d.b(getActivity(), gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W9(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) this.f57776c0.k().g();
        if (relativeLayout == null || view == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10, -1);
        layoutParams.addRule(14, -1);
        view.setId(R.id.f166518ft1);
        relativeLayout.addView(view, layoutParams);
    }

    @Override // com.qzone.preview.b
    public boolean X() {
        return true;
    }

    protected void X9(Activity activity) {
        RelativeLayout relativeLayout = (RelativeLayout) this.f57776c0.k().g();
        if (relativeLayout != null) {
            this.f57782f0 = new ListView(activity);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13, -1);
            this.f57782f0.setId(R.id.f166519ft2);
            this.f57782f0.setBackgroundResource(R.color.black);
            relativeLayout.addView(this.f57782f0, layoutParams);
            this.f57782f0.setSelector(R.color.ajr);
            this.f57782f0.setVerticalScrollBarEnabled(false);
            this.f57782f0.setScrollbarFadingEnabled(false);
            this.f57782f0.setOnItemClickListener(new h());
            this.f57782f0.setOnScrollListener(new i());
            com.qzone.preview.e eVar = new com.qzone.preview.e(this, this.H);
            this.f57783g0 = eVar;
            this.f57782f0.setAdapter((ListAdapter) eVar);
            if (this.f57776c0.k() instanceof com.tencent.common.galleryactivity.c) {
                ((com.tencent.common.galleryactivity.c) this.f57776c0.k()).w().setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xa() {
        BasePictureViewer.n nVar;
        if (this.P || (nVar = this.N) == null) {
            return;
        }
        nVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareActionSheetBuilder.ActionSheetItem Z9(int i3, int i16, @Deprecated int i17, @Deprecated int i18, boolean z16) {
        if (this.f57784h == null) {
            return null;
        }
        if (z16) {
            ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(i16);
            if (i3 == 1) {
                this.f57786i.add(build);
            } else {
                this.f57791m.add(build);
            }
        }
        this.f57784h.updateUI();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aa(boolean z16) {
        PhotoInfo b16 = this.H.b();
        if (b16 == null) {
            return false;
        }
        if (!Ta()) {
            return true;
        }
        int d16 = ShareUtils.d(this.H.h0(), b16.shareSpaceRight, b16.shareAlbumRight, false, z16);
        return d16 == 0 || d16 == 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ab() {
        return this.f57776c0.o();
    }

    protected void ea() {
        if (this.C) {
            try {
                g.a aVar = new g.a();
                aVar.context = getContext();
                com.qzone.detail.ui.component.g gVar = new com.qzone.detail.ui.component.g(aVar);
                this.f57784h = gVar;
                gVar.setActionSheetTitle(getContext().getString(R.string.hja));
                this.f57784h.setIntentForStartForwardRecentActivity(new Intent());
                this.f57786i.clear();
                this.f57791m.clear();
                this.f57784h.setActionSheetItems(this.f57786i, this.f57791m);
                if (this.H.j()) {
                    Z9(1, 3, R.string.gjo, R.drawable.qzone_icon_action_sheet_qzone, true);
                }
                Z9(1, 2, R.string.gkm, R.drawable.qzone_detail_panel_qq, true);
                Z9(1, 203, R.string.f2203068r, R.drawable.mzr, true);
                if (this.H.m() && Ha()) {
                    Z9(1, 9, R.string.gkn, R.drawable.cco, true);
                }
                if (this.H.n() && Ha()) {
                    Z9(1, 10, R.string.b59, R.drawable.qzone_icon_action_sheet_pengyouquan, true);
                }
                this.f57784h.setItemClickListenerV2(this.f57797r0);
                if (this.H.l()) {
                    Z9(2, 39, R.string.gkf, R.drawable.qzone_more_menu_download, Pa());
                }
                if (!Ta() && this.f57780e0 != 1 && !this.H.f49894x) {
                    Z9(2, 48, R.string.gkg, R.drawable.qzone_more_menu_saveasemotion, Pa());
                }
                Y9();
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ga() {
        com.qzone.detail.ui.component.g gVar;
        if (Na() && (gVar = this.f57784h) != null) {
            try {
                gVar.dismiss();
                Ya();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    protected abstract void gb();

    @Override // com.qzone.preview.b
    public Handler getHandler() {
        return this.f57796q0;
    }

    @Override // com.qzone.preview.b
    public Activity getHostActivity() {
        return getActivity();
    }

    @Override // com.qzone.preview.b
    public ListView getListView() {
        return this.f57782f0;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "[PhotoAlbum]BasePictureViewer";
    }

    @Override // com.qzone.preview.b
    public int getShowType() {
        return this.f57780e0;
    }

    @Override // com.qzone.preview.b
    public GalleryManager h7() {
        return this.f57776c0;
    }

    @Override // com.qzone.preview.b
    public boolean h9() {
        return false;
    }

    protected void hb(Bundle bundle) {
        if (NetworkState.getNetworkType() == 2) {
            this.f57779e = 3;
        } else {
            this.f57779e = bundle.getInt("preload_flag", 0);
        }
        this.C = bundle.getBoolean(PictureConst.KEY_SHOW_MENU, true);
        BasePictureViewer.X0 = bundle.getInt("mode");
        this.G = bundle.getBoolean("need_clear_cache", false);
        this.I = bundle.getBoolean("fromQZone", true);
        this.T = bundle.getInt(PictureConst.KEY_ALL_PHOTO_COUNT);
        this.U = bundle.getInt(PictureConst.KEY_PHOTO_INDEX_IN_ALBUM);
        PictureManager.needDownloadReport = bundle.getBoolean(QZoneHelper.QZoneAlbumConstants.KEY_NEED_DOWNLOAD_REPORT, false);
        PictureManager.downloadReportKey = bundle.getString(QZoneHelper.QZoneAlbumConstants.KEY_DOWNLOAD_REPORT_KEY);
        BasePicureViewController picureViewController = PictureManager.getInstance().getPicureViewController(BasePictureViewer.X0, this);
        this.H = picureViewController;
        picureViewController.Y(bundle);
        this.E = bundle.getBoolean(PictureConst.KEY_NEED_BACK_ANIMATION, true);
    }

    public void ia(Map<String, Object> map) {
        BasePicureViewController basePicureViewController = this.H;
        map.put("xsj_target_qq", Long.valueOf(basePicureViewController != null ? basePicureViewController.L() : 0L));
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SHAREPANE_SOURCE, Fa());
        map.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_QQ_SHARE_PANEL);
        VideoReport.reportEvent("ev_xsj_sharepanel_action", null, map);
    }

    @Override // com.qzone.preview.b
    public int j0() {
        return this.f57779e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ja() {
        if (this.f57784h != null) {
            try {
                if (getActivity() == null || getActivity().isFinishing()) {
                    return;
                }
                this.f57784h.show();
                this.f57784h.setCancelListener(this);
                Xa();
            } catch (Exception e16) {
                e16.printStackTrace();
                QZLog.w(e16);
            } catch (OutOfMemoryError e17) {
                e17.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jb() {
        if (this.f57789k0 == -1) {
            this.f57789k0 = System.currentTimeMillis();
        }
        if (this.f57788j0 == null) {
            this.f57788j0 = new j();
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE);
        QLog.i("[PhotoAlbum]BasePictureViewer", 1, "save picture dest path is " + sDKPrivatePath);
        ba(3, sDKPrivatePath, this.f57788j0);
    }

    protected void kb() {
        if (this.f57790l0 == null) {
            this.f57790l0 = new k();
        }
        ba(3, VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE), this.f57790l0);
        LpReportInfo_pf00064.allReport(134, 1, 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mb(int i3, boolean z16) {
        com.qzone.detail.ui.component.g gVar = this.f57784h;
        if (gVar != null) {
            gVar.s0(i3, z16);
            this.f57784h.updateUI();
        }
    }

    @Override // com.qzone.preview.b
    public Callback n7() {
        return null;
    }

    public void na(String str, String str2, INetEngineListener iNetEngineListener) {
        oa(str, f57771s0, str2, iNetEngineListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nb(int i3) {
        com.qzone.detail.ui.component.g gVar = this.f57784h;
        if (gVar != null) {
            gVar.p0(i3);
            this.f57784h.updateUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.f57780e0 == 1) {
            this.f57783g0.notifyDataSetChanged();
            updateUI();
        } else {
            this.f57776c0.k().h();
        }
    }

    @Override // com.qzone.preview.b
    public /* synthetic */ TextView o3() {
        return com.qzone.preview.a.a(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        return ab();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Ya();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f57776c0.p(configuration);
        Za();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        fb(activity);
        activity.getWindow().setSoftInputMode(32);
        PictureManager.getInstance();
        this.f57777d = LayoutInflater.from(activity);
        Intent intent = activity.getIntent();
        if (bundle != null) {
            onRestore(bundle);
        } else if (intent != null && intent.getExtras() != null) {
            hb(intent.getExtras());
        } else {
            w5.b.g("[PhotoAlbum]BasePictureViewer", 1, "parseData error: bundle is null");
            finish();
            return;
        }
        try {
            this.f57776c0.q(activity);
        } catch (Exception e16) {
            RFWLog.e("[PhotoAlbum]BasePictureViewer", RFWLog.USR, e16);
        }
        La(activity, intent);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        getHandler().removeCallbacksAndMessages(null);
        GalleryManager galleryManager = this.f57776c0;
        if (galleryManager != null) {
            if (galleryManager.l() != null && this.f57776c0.l().x() != null && (this.f57776c0.l().x() instanceof PictureAdapter)) {
                ((PictureAdapter) this.f57776c0.l().x()).h0();
            }
            this.f57776c0.r(activity);
        }
        if (this.G) {
            ImageLoader.getInstance().clear(false);
        }
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).removeObserver(this.f57794o0);
        com.qzone.detail.ui.component.g gVar = this.f57784h;
        if (gVar != null) {
            gVar.setItemClickListenerV2(null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        Xa();
        if (this.I && com.tencent.mobileqq.simpleui.b.c()) {
            QzoneOnlineTimeCollectRptService.getInstance().closeTrace();
        }
        SmallScreenUtils.A(BaseApplication.getContext(), false);
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        Ya();
        if (this.I && com.tencent.mobileqq.simpleui.b.c()) {
            QzoneOnlineTimeCollectRptService.getInstance().beginTrace(3);
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            activity.getWindow().addFlags(67108864);
        }
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, false);
        SmallScreenUtils.A(BaseApplication.getContext(), true);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneBasePictureViewerPart.12
            @Override // java.lang.Runnable
            public void run() {
                QZoneBasePictureViewerPart.this.S = ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).isWXinstalled() && ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).isWxSupportTimeLine();
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        super.onPartSaveInstanceState(activity, bundle);
        bundle.putInt("preload_flag", this.f57779e);
        bundle.putBoolean(PictureConst.KEY_SHOW_MENU, this.C);
        bundle.putBoolean(PictureConst.KEY_SHOW_TAG, this.D);
        bundle.putBoolean(PictureConst.KEY_NEED_BACK_ANIMATION, this.E);
        bundle.putInt("mode", BasePictureViewer.X0);
        bundle.putLong(PictureConst.KEY_UIN_ONSAVEINSTANCESTATE, LoginData.getInstance().getUin());
        this.H.M0(bundle);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(Activity activity) {
        super.onPartStart(activity);
        this.f57776c0.v(getActivity());
    }

    protected void onRestore(Bundle bundle) {
        this.f57779e = bundle.getInt("preload_flag");
        this.C = bundle.getBoolean(PictureConst.KEY_SHOW_MENU);
        this.D = bundle.getBoolean(PictureConst.KEY_SHOW_TAG);
        this.E = bundle.getBoolean(PictureConst.KEY_NEED_BACK_ANIMATION);
        BasePictureViewer.X0 = bundle.getInt("mode");
        LoginData.getInstance().setUin(bundle.getLong(PictureConst.KEY_UIN_ONSAVEINSTANCESTATE));
        BasePicureViewController picureViewController = PictureManager.getInstance().getPicureViewController(BasePictureViewer.X0, this);
        this.H = picureViewController;
        picureViewController.K0(bundle);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
    }

    public void pa() {
        if (this.f57793n0 == -1) {
            this.f57793n0 = System.currentTimeMillis();
        }
        LpReportInfo_pf00064.report(301, 8, 2);
        if (this.f57792m0 == null) {
            this.f57792m0 = new l();
        }
        ba(4, VFSAssistantUtils.getSDKPrivatePath("photo/"), this.f57792m0);
    }

    @Override // com.qzone.preview.b
    public void q1() {
        if (this.f57778d0) {
            return;
        }
        this.f57778d0 = true;
        ToastUtil.n(R.string.ghi);
    }

    public void qa() {
        f57773u0 = System.currentTimeMillis();
        IQzoneShareApi iQzoneShareApi = (IQzoneShareApi) QRoute.api(IQzoneShareApi.class);
        if (iQzoneShareApi.isWXinstalled() && iQzoneShareApi.isWxSupportTimeLine()) {
            LpReportInfo_pf00064.report(301, 8, 3);
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath("photo/");
            if (this.f57795p0 == null) {
                this.f57795p0 = new WeChatForwardHandler(this);
            }
            ba(5, sDKPrivatePath, this.f57795p0);
            return;
        }
        ToastUtil.n(R.string.gjq);
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).jmpWeixinDetail(getActivity());
    }

    protected void ub(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(getActivity(), DirectForwardActivity.class);
        intent.putExtra("toUin", String.valueOf(this.W));
        intent.putExtra("uinType", this.X);
        intent.putExtra("nickName", this.Y);
        intent.putExtra("forward_type", 1);
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, str);
        intent.putExtra("key_flag_from_plugin", true);
        getActivity().startActivityForResult(intent, 1000);
    }

    @Override // com.qzone.preview.b
    public void updateUI() {
        BasePicureViewController basePicureViewController = this.H;
        basePicureViewController.E = this.f57785h0;
        this.f57785h0 = false;
        if (basePicureViewController.l0()) {
            gb();
            Wa();
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneBasePictureViewerPart.4
            @Override // java.lang.Runnable
            public void run() {
                QZoneBasePictureViewerPart qZoneBasePictureViewerPart = QZoneBasePictureViewerPart.this;
                qZoneBasePictureViewerPart.H.x0(qZoneBasePictureViewerPart.n7());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vb(Context context, int i3, String str, Parcelable parcelable, String str2) {
        Intent intent = new Intent(context, (Class<?>) FeedActionPanelActivity.class);
        intent.putExtra("extraRequestCode", i3);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY, str2);
        intent.putExtra("canVertical", true);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.FEED_TEXT_HINT_INTENT_KEY, str);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_REFER_ACTIVITY, "[PhotoAlbum]BasePictureViewer");
        if (!BasePicureViewController.o0()) {
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_FONT_ICON, 1);
        }
        intent.putExtra("show_barrage_effect_icon", this.H.f49877g.appid == 311);
        String stringExtra = getActivity().getIntent().getStringExtra(QQWinkConstants.KEY_PREVIOUS_ACTIVITY);
        BasePicureViewController basePicureViewController = this.H;
        if (basePicureViewController.f49891u) {
            if (!basePicureViewController.f49877g.isShareAlbum && (com.qzone.util.am.h(stringExtra) || (!stringExtra.contains(QQBrowserActivity.class.getSimpleName()) && !stringExtra.contains(QQMiniManager.getAppBrandUIClass().getSimpleName())))) {
                intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_KEY_ICON, FeedActionPanelActivity.J1);
            } else {
                intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_KEY_ICON, FeedActionPanelActivity.I1);
            }
        }
        if (parcelable != null) {
            intent.putExtra("extraIntentKeyParcelable", parcelable);
        }
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SYSTEM_TRANSPARENTBAR, 0);
        intent.putExtra("extrauserapidcomment", false);
        intent.putExtra("is_qun_album", BasePicureViewController.o0());
        com.qzone.feed.utils.b.f(getActivity(), intent, i3);
    }

    @Override // com.qzone.preview.b
    public void w1() {
        if (this.C && !Na()) {
            ea();
            yb();
            ClickReport.e(4, getActivity().getIntent().getStringExtra("refer"), 301, 6, 1);
            Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
            buildElementParams.put("xsj_action_type", "panel_exp");
            ia(buildElementParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wb(Context context, int i3, String str, Parcelable parcelable, String str2) {
        Intent intent = new Intent(context, (Class<?>) FeedActionPanelActivity.class);
        intent.putExtra("extraRequestCode", i3);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY, str2);
        intent.putExtra("canVertical", true);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.FEED_TEXT_HINT_INTENT_KEY, str);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_REFER_ACTIVITY, "[PhotoAlbum]BasePictureViewer");
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_KEY_ICON, FeedActionPanelActivity.I1);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SHOW_PICCOMMENT, FeedActionPanelActivity.L1);
        if (parcelable != null) {
            intent.putExtra("extraIntentKeyParcelable", parcelable);
        }
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SYSTEM_TRANSPARENTBAR, 0);
        intent.putExtra("extrauserapidcomment", false);
        intent.putExtra("input_text_allow_empty", true);
        com.qzone.feed.utils.b.f(getActivity(), intent, i3);
    }

    @Override // com.qzone.preview.b
    public void x2(BasePictureViewer.n nVar) {
        this.N = nVar;
    }

    protected void xb(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(getActivity(), ForwardRecentActivity.class);
        intent.putExtra("forward_type", 1);
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, str);
        intent.putExtra("key_flag_from_plugin", true);
        if (QZoneConfigHelper.v()) {
            intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
            intent.putExtra("isFromShare", true);
            intent.putExtra("sendMultiple", true);
        }
        getActivity().startActivityForResult(intent, 1000);
    }

    @Override // com.qzone.preview.b
    public boolean z0() {
        return false;
    }

    /* loaded from: classes37.dex */
    private static class n extends WeakReferenceHandler<QZoneBasePictureViewerPart> {
        n(QZoneBasePictureViewerPart qZoneBasePictureViewerPart) {
            super(qZoneBasePictureViewerPart);
        }

        @Override // cooperation.qzone.util.WeakReferenceHandler
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void handleMessage(QZoneBasePictureViewerPart qZoneBasePictureViewerPart, Message message) {
            if (message != null) {
                qZoneBasePictureViewerPart.onHandleMessage(message);
            }
        }
    }

    private void pb(Bundle bundle) {
        QZLog.d("[PhotoAlbum]shareOutSide", 1, "[PhotoAlbum]BasePictureViewer", " handleGetShareUrlResult rsp:", bundle.toString());
        int i3 = this.L;
        if (i3 == 9) {
            za(bundle);
        } else if (i3 == 10) {
            ra(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void La(Activity activity, Intent intent) {
        this.f57781f = false;
        ClickReport.e(4, intent.getStringExtra("refer"), 301, 1);
        this.f57780e0 = intent.getIntExtra(PeakConstants.KEY_SHOW_TYPE, 0);
        this.Z = intent.getIntExtra(PeakConstants.KEY_MIN_PHOTO_COUNT, 0);
        if (1 == this.f57780e0) {
            X9(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ib() {
        this.Q = false;
    }

    private void Ba(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        this.L = 10;
        PhotoInfo b16 = this.H.b();
        int d16 = ShareUtils.d(this.H.h0(), b16.shareSpaceRight, b16.shareAlbumRight, true, false);
        if (d16 == 0) {
            Aa(b16.shareWeixinUrl);
        } else {
            if (d16 != 4) {
                return;
            }
            sb(actionSheetItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ka(PhotoInfo photoInfo) {
        return photoInfo != null && !TextUtils.isEmpty(photoInfo.downloadUrl) && ImageLoader.getInstance().getImageFile(photoInfo.downloadUrl) == null && ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) == null;
    }

    private void sa() {
        long j3;
        String str;
        long j16;
        this.L = 10;
        PhotoInfo b16 = this.H.b();
        HashMap hashMap = new HashMap(1);
        hashMap.put(1, b16.bigUrl);
        hashMap.put(2, "0");
        hashMap.put(10, "1");
        PhotoParam G = this.H.G();
        if (b16.appid != 311) {
            PictureManager pictureManager = PictureManager.getInstance();
            Handler handler = getHandler();
            if (TextUtils.isEmpty(b16.pssCellId)) {
                str = b16.albumId;
            } else {
                str = b16.pssCellId;
            }
            String str2 = b16.albumId;
            String str3 = b16.lloc;
            if (G != null) {
                j16 = G.ownerUin;
            } else {
                j16 = b16.uploaduin;
            }
            pictureManager.getOutShareUrl(handler, 4, 1, str, str2, str3, null, 0, j16, 2, hashMap);
        } else {
            String str4 = G != null ? G.cell_id : null;
            if (TextUtils.isEmpty(str4)) {
                if (TextUtils.isEmpty(b16.pssCellId)) {
                    str4 = b16.albumId;
                } else {
                    str4 = b16.pssCellId;
                }
            }
            String str5 = str4;
            PictureManager pictureManager2 = PictureManager.getInstance();
            Handler handler2 = getHandler();
            int i3 = b16.appid;
            String str6 = b16.albumId;
            String str7 = b16.lloc;
            if (G != null) {
                j3 = G.ownerUin;
            } else {
                j3 = b16.uploaduin;
            }
            pictureManager2.getOutShareUrl(handler2, i3, 1, str5, str6, str7, null, 0, j3, 2, hashMap);
        }
        tb(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchingUrl", "\u6b63\u5728\u83b7\u53d6\u5206\u4eaburl"));
    }

    private void xa() {
        this.L = 9;
        PhotoInfo b16 = this.H.b();
        int d16 = ShareUtils.d(this.H.h0(), b16.shareSpaceRight, b16.shareAlbumRight, true, true);
        QZLog.d("[PhotoAlbum]shareOutSide", 1, "forwardVideoForWXChat rightResult:", Integer.valueOf(d16), " isGuest:", Boolean.valueOf(this.H.h0()), " spaceRight:", Integer.valueOf(b16.shareSpaceRight), " albumRight:", Integer.valueOf(b16.shareAlbumRight));
        if (d16 == 0 || d16 == 4) {
            Ea();
        }
    }

    @Override // com.qzone.preview.b
    public void k0(View view) {
        if (view == null || view.getTag() == null) {
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof AlbumCacheData) {
            AlbumCacheData albumCacheData = (AlbumCacheData) tag;
            long j3 = albumCacheData.ownerUin;
            LoginData.getInstance().getUin();
            if (com.qzone.album.util.d.f(albumCacheData.albumrights) && !albumCacheData.allowAccess) {
                getContext().startActivity(com.qzone.common.activities.base.ak.H(getActivity(), albumCacheData.albumid, albumCacheData.albumname, Long.valueOf(j3), albumCacheData.albumquestion, albumCacheData.busi_param, 0, null, albumCacheData.albumtype, false));
                return;
            }
            BusinessAlbumInfo createFrom = BusinessAlbumInfo.createFrom(albumCacheData.albumid, albumCacheData.albumtype, albumCacheData.albumname, albumCacheData.getLloc(), albumCacheData.albumrights, albumCacheData.albumnum, albumCacheData.anonymity, albumCacheData.individual, albumCacheData.operatemask, albumCacheData.allow_share, albumCacheData.isSharingAlbumOnServer(), com.qzone.album.util.b.a(albumCacheData), albumCacheData.isSharingOwner);
            createFrom.mUin = j3;
            createFrom.mCover = albumCacheData.getLloc();
            createFrom.isIndividualityAlbum = albumCacheData.individual != 0;
            createFrom.sortType = albumCacheData.sortType;
            getActivity().startActivity(com.qzone.common.activities.base.ak.I(getActivity(), createFrom, 0));
            int albumThemeTypeValue = albumCacheData.getAlbumThemeTypeValue();
            if (albumThemeTypeValue == 1) {
                ClickReport.r("", "", "", true, "56", "1");
            } else if (albumThemeTypeValue == 8) {
                ClickReport.r("", "", "", true, "56", "2");
            } else {
                if (albumThemeTypeValue != 9) {
                    return;
                }
                ClickReport.r("", "", "", true, "56", "3");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ra(PhotoInfo photoInfo) {
        if (photoInfo != null && Qa(photoInfo) && ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) == null) {
            return true;
        }
        if (photoInfo == null || photoInfo.photoType != 2 || ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) != null) {
            return false;
        }
        String Ca = Ca(photoInfo);
        File imageFile = ImageLoader.getInstance().getImageFile(Ca);
        if (imageFile == null) {
            return true;
        }
        if (SharpPUtils.isSharpP(imageFile)) {
            ImageLoader.getInstance().removeImageFile(Ca);
            return true;
        }
        QZLog.i("[PhotoAlbum]BasePictureViewer", 1, "-----needn't to download file for sharpp gif.");
        return false;
    }

    public void fb(Activity activity) {
        activity.setTheme(R.style.f173749jl);
        try {
            Window.class.getMethod("addExtraFlags", Integer.TYPE).invoke(activity.getWindow(), 1792);
        } catch (Exception unused) {
            QZLog.i("[PhotoAlbum]BasePictureViewer", "addExtraFlags not found.");
        }
    }

    public static boolean Qa(PhotoInfo photoInfo) {
        return (photoInfo == null || photoInfo.photoType != 2 || TextUtils.isEmpty(photoInfo.orgUrl)) ? false : true;
    }

    private void ob(boolean z16) {
        try {
            if (z16) {
                getActivity().getWindow().addFlags(128);
            } else {
                getActivity().getWindow().clearFlags(128);
            }
        } catch (Throwable th5) {
            QLog.e("[PhotoAlbum]BasePictureViewer", 1, "[setScreenOn] error: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bb(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (actionSheetItem == null) {
            return false;
        }
        int i3 = actionSheetItem.action;
        this.V = false;
        this.W = 0L;
        this.X = 0;
        this.Y = null;
        if (i3 != 2) {
            if (i3 == 39) {
                if (!QZonePermission.requestStoragePermission(getActivity(), QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
                    return true;
                }
                if (!Pa()) {
                    QZLog.e("[PhotoAlbum]BasePictureViewer", "[MORE_SAVE] this function is closed and not suposed to show!");
                    return true;
                }
                if (Ta()) {
                    lb();
                    ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "24", true);
                } else {
                    jb();
                    ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "2", true);
                }
                ga();
                return true;
            }
            if (i3 == 48) {
                if (!Ta()) {
                    kb();
                }
                ga();
                return true;
            }
            if (i3 == 203) {
                Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
                buildElementParams.put("xsj_action_type", "share");
                buildElementParams.put("xsj_share_target", WinkDaTongReportConstant.ElementParamValue.LITTLE_WORLD);
                ia(buildElementParams);
                if (Ta()) {
                    ua();
                } else {
                    la();
                }
                return true;
            }
            if (i3 == 9) {
                if (Ta()) {
                    xa();
                } else {
                    qa();
                }
                ga();
                ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "30", true);
                return true;
            }
            if (i3 == 10) {
                if (Ta()) {
                    Ba(actionSheetItem);
                } else {
                    sa();
                }
                ga();
                return true;
            }
            if (i3 != 72 && i3 != 73) {
                return false;
            }
        }
        if (i3 == 72) {
            this.V = true;
            this.W = Long.parseLong(actionSheetItem.uin);
            this.X = actionSheetItem.uinType;
            this.Y = actionSheetItem.label;
        }
        if (Ta()) {
            va(actionSheetItem);
        } else {
            pa();
        }
        ga();
        ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "29", true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0148 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0192 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00db A[Catch: OutOfMemoryError -> 0x0142, TryCatch #3 {OutOfMemoryError -> 0x0142, blocks: (B:49:0x00d5, B:51:0x00db, B:53:0x00f0, B:65:0x00e4), top: B:48:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f0 A[Catch: OutOfMemoryError -> 0x0142, TRY_LEAVE, TryCatch #3 {OutOfMemoryError -> 0x0142, blocks: (B:49:0x00d5, B:51:0x00db, B:53:0x00f0, B:65:0x00e4), top: B:48:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e4 A[Catch: OutOfMemoryError -> 0x0142, TryCatch #3 {OutOfMemoryError -> 0x0142, blocks: (B:49:0x00d5, B:51:0x00db, B:53:0x00f0, B:65:0x00e4), top: B:48:0x00d5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ca(Context context, PhotoInfo photoInfo, String str, Handler handler) {
        int i3;
        int i16;
        Bitmap bitmap;
        String str2;
        boolean z16;
        boolean z17;
        Bitmap a16;
        Message obtain = Message.obtain();
        if (photoInfo == null) {
            obtain.what = 1;
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "copyPictrue-save error photoInfo == null");
            handler.sendMessage(obtain);
            return;
        }
        QLog.d("QzonePhotoUtil", 1, "copyPicture: " + photoInfo.downloadUrl);
        File Da = Da(ImageLoader.getInstance(), photoInfo);
        if (Da == null) {
            i3 = 2;
            i16 = 1;
        } else {
            if (Da.exists()) {
                String Ua = Ua(Da.getAbsolutePath());
                if (Ua == null) {
                    obtain.what = 1;
                    QZLog.i(QZLog.TO_DEVICE_TAG, 1, "copyPictrue-save error postfix == null");
                    handler.sendMessage(obtain);
                    return;
                }
                boolean equals = Ua.equals("webp");
                if (equals) {
                    try {
                        Bitmap decodeFile = BitmapFactory.decodeFile(Da.getAbsolutePath());
                        if (decodeFile != null) {
                            String str3 = str + (String.valueOf(System.currentTimeMillis()) + ".jpeg");
                            try {
                                z17 = com.qzone.util.image.c.V(decodeFile, str3, Bitmap.CompressFormat.JPEG, 90, true);
                                str2 = str3;
                            } catch (OutOfMemoryError e16) {
                                e = e16;
                                str2 = str3;
                                QZLog.w("[PhotoAlbum]BasePictureViewer", "Out of Memory ", e);
                                z16 = false;
                                if (!Ua.equals("sharpp")) {
                                }
                                QZLog.i("[PhotoAlbum]BasePictureViewer", "sharpp file");
                                try {
                                    if (!Ua.equals("sharpp")) {
                                    }
                                    if (a16 != null) {
                                    }
                                } catch (OutOfMemoryError e17) {
                                    e = e17;
                                }
                                if (!equals) {
                                }
                                if (equals) {
                                    obtain.what = 2;
                                    obtain.obj = str2;
                                }
                                handler.sendMessage(obtain);
                                return;
                            }
                        } else {
                            z17 = false;
                            str2 = null;
                        }
                        z16 = z17;
                    } catch (OutOfMemoryError e18) {
                        e = e18;
                        str2 = null;
                    }
                } else {
                    z16 = false;
                    str2 = null;
                }
                if (!Ua.equals("sharpp") || Ua.equals("avif")) {
                    QZLog.i("[PhotoAlbum]BasePictureViewer", "sharpp file");
                    if (!Ua.equals("sharpp")) {
                        a16 = SharpPUtils.decodeSharpP(Da.getAbsolutePath());
                    } else {
                        a16 = com.tencent.qzone.image.api.a.c().a(Da, photoInfo.bigUrl, 0, 0);
                    }
                    if (a16 != null) {
                        String str4 = String.valueOf(System.currentTimeMillis()) + ".jpeg";
                        String str5 = str + str4;
                        try {
                            if (com.qzone.util.image.c.V(a16, str5, Bitmap.CompressFormat.JPEG, 90, true)) {
                                obtain.what = 2;
                                obtain.obj = str5;
                                handler.sendMessage(obtain);
                                QZLog.i("[PhotoAlbum]BasePictureViewer", "------sharpp file save success:" + str4);
                                return;
                            }
                            str2 = str5;
                        } catch (OutOfMemoryError e19) {
                            e = e19;
                            str2 = str5;
                            QZLog.w("[PhotoAlbum]BasePictureViewer", "Out of Memory ", e);
                            if (!equals) {
                            }
                            if (equals) {
                            }
                            handler.sendMessage(obtain);
                            return;
                        }
                    }
                }
                if ((!equals && !z16) || !equals) {
                    String str6 = str + (String.valueOf(System.currentTimeMillis()) + "." + Ua);
                    com.tencent.component.network.utils.FileUtils.copyFiles(new File(Da.getAbsolutePath()), new File(str6));
                    obtain.what = 2;
                    obtain.obj = str6;
                } else if (equals && z16) {
                    obtain.what = 2;
                    obtain.obj = str2;
                }
                handler.sendMessage(obtain);
                return;
            }
            i16 = 1;
            i3 = 2;
        }
        obtain.what = i16;
        QZLog.i(QZLog.TO_DEVICE_TAG, i16, "copyPictrue-save error file == null");
        Drawable imageByUrlInMemory = ImageManager.getInstance().getImageByUrlInMemory(photoInfo.bigUrl);
        if ((imageByUrlInMemory instanceof ImageDrawable) && (bitmap = ((ImageDrawable) imageByUrlInMemory).getBitmapRef().getBitmap()) != null && !bitmap.isRecycled()) {
            String str7 = str + (String.valueOf(System.currentTimeMillis()) + ".jpeg");
            boolean V = com.qzone.util.image.c.V(bitmap, str7, Bitmap.CompressFormat.JPEG, 90, false);
            obtain.what = V ? i3 : 1;
            if (V) {
                QZLog.i(QZLog.TO_DEVICE_TAG, 1, "copyPictrue-loadBitmap saveSuccess");
                obtain.obj = str7;
            }
        }
        handler.sendMessage(obtain);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i16 == 0) {
            return;
        }
        if (i16 == -1) {
            switch (i3) {
                case 1000:
                    break;
                case 1001:
                    this.f57787i0 = true;
                    finish();
                    break;
                case 1002:
                    finish();
                    break;
                case 1003:
                    this.H.i1(Long.parseLong(intent.getStringExtra("extra_choose_friend_uin")), intent.getStringExtra("extra_choose_friend_name"), intent.getStringExtra("extraChooseFriendRemark"), intent.getIntExtra("key_selected_share_touch_face_position", -1));
                    break;
                case 1004:
                    this.H.j1(Long.parseLong(intent.getStringExtra("extra_choose_friend_uin")), intent.getStringExtra("extra_choose_friend_name"), intent.getStringExtra("extraChooseFriendRemark"), intent.getIntExtra("key_selected_share_touch_face_position", -1));
                    break;
                default:
                    QZLog.e("[PhotoAlbum]BasePictureViewer", "onActivityResult requestCode: " + i3 + " without process");
                    break;
            }
        }
        super.onActivityResult(i3, i16, intent);
    }

    @Override // com.qzone.preview.b
    public void U7() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y9() {
    }

    @Override // com.qzone.preview.b
    public void o5() {
    }

    @Override // com.qzone.preview.b
    public void y1() {
    }

    protected void yb() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class j extends Handler {
        j() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == -1) {
                QZoneBasePictureViewerPart qZoneBasePictureViewerPart = QZoneBasePictureViewerPart.this;
                qZoneBasePictureViewerPart.f57789k0 = -1L;
                qZoneBasePictureViewerPart.U = 0;
                return;
            }
            if (i3 == 1) {
                QZoneBasePictureViewerPart.this.ha();
                ToastUtil.o(R.string.gkh, 4);
                QZoneBasePictureViewerPart qZoneBasePictureViewerPart2 = QZoneBasePictureViewerPart.this;
                qZoneBasePictureViewerPart2.f57789k0 = -1L;
                qZoneBasePictureViewerPart2.U = 0;
                return;
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return;
                    }
                    if (QZoneBasePictureViewerPart.this.K == null || !QZoneBasePictureViewerPart.this.K.isShowing()) {
                        QZoneBasePictureViewerPart.this.tb(com.qzone.util.l.a(R.string.jzm));
                        return;
                    }
                    return;
                }
                QZoneBasePictureViewerPart.this.ha();
                if (QZonePermission.requestStoragePermission(QZoneBasePictureViewerPart.this.getActivity(), QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
                    ToastUtil.o(R.string.gkk, 4);
                    QZoneBasePictureViewerPart qZoneBasePictureViewerPart3 = QZoneBasePictureViewerPart.this;
                    qZoneBasePictureViewerPart3.f57789k0 = -1L;
                    qZoneBasePictureViewerPart3.U = 0;
                    return;
                }
                return;
            }
            QZoneBasePictureViewerPart.this.ha();
            String string = QZoneBasePictureViewerPart.this.getContext().getString(R.string.gki);
            Object obj = message.obj;
            if (obj != null && (obj instanceof String)) {
                String str = (String) obj;
                RFWSaveUtil.insertMedia(BaseApplication.getContext(), str, new a());
                ToastUtil.s(string, 5);
                QZLog.d("[PhotoAlbum]BasePictureViewer", 1, "savePicture time cost:" + (System.currentTimeMillis() - QZoneBasePictureViewerPart.this.f57789k0) + ", filePath: " + str);
            }
            QZoneBasePictureViewerPart qZoneBasePictureViewerPart4 = QZoneBasePictureViewerPart.this;
            qZoneBasePictureViewerPart4.f57789k0 = -1L;
            qZoneBasePictureViewerPart4.U = 0;
        }

        /* loaded from: classes37.dex */
        class a implements Consumer<RFWSaveMediaResultBean> {
            a() {
            }

            @Override // androidx.core.util.Consumer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(RFWSaveMediaResultBean rFWSaveMediaResultBean) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class f implements INetEngineListener {
        f() {
        }

        @Override // com.tencent.mobileqq.wink.listener.INetEngineListener
        public void getFilePath(String str) {
            if (TextUtils.isEmpty(str) || !QZoneBasePictureViewerPart.this.Oa(str)) {
                if (QZoneBasePictureViewerPart.this.Oa(str)) {
                    QZoneBasePictureViewerPart.this.ha();
                    return;
                } else {
                    ToastUtil.n(R.string.f21969674);
                    QZoneBasePictureViewerPart.this.ha();
                    return;
                }
            }
            QZoneBasePictureViewerPart.this.Va("mqqapi://qcircle/openqqpublish?target=3&exit_dialog=1&mediaPath=" + str + ContainerUtils.FIELD_DELIMITER + WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID + ContainerUtils.KEY_VALUE_DELIMITER + QZoneBasePictureViewerPart.this.Fa());
        }

        @Override // com.tencent.mobileqq.wink.listener.INetEngineListener
        public void isSuccess(boolean z16) {
        }
    }

    @Override // com.qzone.preview.b
    public void H0(int i3) {
    }

    @Override // com.qzone.preview.b
    public void S0(boolean z16) {
    }

    @Override // com.qzone.preview.b
    public void d1(boolean z16) {
    }

    protected void onHandleMessage(Message message) {
    }

    public void cb(int i3, PhotoInfo photoInfo) {
    }

    protected void eb(AbsListView absListView, int i3) {
    }

    public void ma(int i3, PhotoInfo photoInfo, boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class i implements AbsListView.OnScrollListener {
        i() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            QZoneBasePictureViewerPart.this.eb(absListView, i3);
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        }
    }
}
