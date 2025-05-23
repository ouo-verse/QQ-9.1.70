package com.qzone.preview;

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
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.FeedActionPanelActivity;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.detail.ui.component.g;
import com.qzone.feed.panorama.PanoramaLayout;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.business.BasePicureViewController;
import com.qzone.preview.service.PictureManager;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.util.ToastUtil;
import com.qzone.util.aj;
import com.qzone.util.am;
import com.qzone.util.ar;
import com.qzone.util.z;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.network.utils.FileUtils;
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
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
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
import cooperation.qzone.util.MediaUtil;
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

/* loaded from: classes39.dex */
public abstract class BasePictureViewer extends BaseActivity implements DialogInterface.OnCancelListener, com.qzone.preview.b {
    private static final String W0 = ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).getDownloadBasePath() + ImageContentType.IMAGE_PREFIX;
    public static int X0 = 0;
    static long Y0 = -1;
    private int A0;
    private String B0;
    protected int C0;

    @Deprecated
    private boolean D0;
    protected int E0;
    private int F0;
    public GalleryManager G0;
    protected boolean H0;
    public int I0;
    public ListView J0;
    public com.qzone.preview.e K0;
    public boolean L0;
    boolean M0;
    private Handler N0;
    long O0;
    private Handler P0;
    private Handler Q0;
    private long R0;
    IQzoneShareApi.WXShareListener S0;
    private Handler T0;
    private Handler U0;
    protected ShareActionSheet.OnItemClickListener V0;

    /* renamed from: a0, reason: collision with root package name */
    LayoutInflater f49472a0;

    /* renamed from: b0, reason: collision with root package name */
    protected int f49473b0;

    /* renamed from: d0, reason: collision with root package name */
    protected com.qzone.detail.ui.component.g f49475d0;

    /* renamed from: l0, reason: collision with root package name */
    protected BasePicureViewController f49483l0;

    /* renamed from: o0, reason: collision with root package name */
    private Dialog f49486o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f49487p0;

    /* renamed from: q0, reason: collision with root package name */
    private String f49488q0;

    /* renamed from: r0, reason: collision with root package name */
    private n f49489r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f49490s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f49491t0;

    /* renamed from: u0, reason: collision with root package name */
    protected PanoramaLayout f49492u0;

    /* renamed from: w0, reason: collision with root package name */
    protected int f49494w0;

    /* renamed from: y0, reason: collision with root package name */
    protected boolean f49496y0;

    /* renamed from: z0, reason: collision with root package name */
    private long f49497z0;

    /* renamed from: c0, reason: collision with root package name */
    protected boolean f49474c0 = false;

    /* renamed from: e0, reason: collision with root package name */
    final List<ShareActionSheetBuilder.ActionSheetItem> f49476e0 = new ArrayList();

    /* renamed from: f0, reason: collision with root package name */
    final List<ShareActionSheetBuilder.ActionSheetItem> f49477f0 = new ArrayList();

    /* renamed from: g0, reason: collision with root package name */
    private boolean f49478g0 = true;

    /* renamed from: h0, reason: collision with root package name */
    protected boolean f49479h0 = false;

    /* renamed from: i0, reason: collision with root package name */
    protected boolean f49480i0 = true;

    /* renamed from: j0, reason: collision with root package name */
    protected boolean f49481j0 = true;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f49482k0 = false;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f49484m0 = true;

    /* renamed from: n0, reason: collision with root package name */
    private HashMap<Integer, s6.a> f49485n0 = new HashMap<>();

    /* renamed from: v0, reason: collision with root package name */
    private boolean f49493v0 = false;

    /* renamed from: x0, reason: collision with root package name */
    protected int f49495x0 = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public static class WeChatForwardHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<BasePictureViewer> f49510a;

        WeChatForwardHandler(BasePictureViewer basePictureViewer) {
            this.f49510a = new WeakReference<>(basePictureViewer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 == 1) {
                ToastUtil.o(R.string.gk7, 4);
            } else if (i3 == 2) {
                Object obj = message.obj;
                if (obj != null && (obj instanceof String) && this.f49510a.get() != null) {
                    final String str = (String) message.obj;
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.preview.BasePictureViewer.WeChatForwardHandler.1
                        @Override // java.lang.Runnable
                        public void run() {
                            byte[] i16 = com.qzone.util.image.c.i(str);
                            if (WeChatForwardHandler.this.f49510a.get() != null) {
                                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).addObserver(((BasePictureViewer) WeChatForwardHandler.this.f49510a.get()).S0);
                            }
                            if (BasePictureViewer.h3() && WeChatForwardHandler.this.f49510a.get() != null && ((BasePictureViewer) WeChatForwardHandler.this.f49510a.get()).I0 != 1) {
                                ShareUtils.r((Activity) WeChatForwardHandler.this.f49510a.get(), 9, ShareUtils.d.a(((BasePictureViewer) WeChatForwardHandler.this.f49510a.get()).f49483l0.b(), ((BasePictureViewer) WeChatForwardHandler.this.f49510a.get()).f49483l0.G(), com.qzone.util.image.c.u(str)), 1);
                            } else {
                                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), str, i16, 0);
                            }
                        }
                    });
                }
                QZLog.d("[PhotoAlbum]BasePictureViewer", 1, "forwardPictureForWXChat time cost:" + (System.currentTimeMillis() - BasePictureViewer.Y0));
            } else if (i3 == 3) {
                ToastUtil.o(R.string.gk6, 4);
            }
            if (this.f49510a.get() != null) {
                this.f49510a.get().f49495x0 = 0;
            }
            BasePictureViewer.Y0 = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            long j3;
            PhotoInfo b16 = BasePictureViewer.this.f49483l0.b();
            PhotoParam G = BasePictureViewer.this.f49483l0.G();
            PictureManager pictureManager = PictureManager.getInstance();
            Handler handler = BasePictureViewer.this.getHandler();
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
            BasePictureViewer.this.showWaitingDialog(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchingUrl", "\u6b63\u5728\u83b7\u53d6\u5206\u4eaburl"));
            BasePictureViewer.this.f49490s0 = false;
            BasePictureViewer.this.u4();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "\u53d6\u6d88\u5206\u4eab");
            BasePictureViewer.this.f49490s0 = false;
            BasePictureViewer.this.u4();
        }
    }

    /* loaded from: classes39.dex */
    class c implements ShareActionSheet.OnItemClickListener {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            BasePictureViewer.this.x4(actionSheetItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            BasePictureViewer.this.D3();
            BasePictureViewer.this.f49490s0 = false;
            BasePictureViewer.this.u4();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "\u53d6\u6d88\u5206\u4eab");
            BasePictureViewer.this.f49490s0 = false;
            BasePictureViewer.this.u4();
        }
    }

    /* loaded from: classes39.dex */
    class g extends GalleryManager {
        g() {
        }

        @Override // com.tencent.common.galleryactivity.GalleryManager
        public com.tencent.common.galleryactivity.c g(Activity activity, com.tencent.common.galleryactivity.e eVar) {
            QzoneGalleryScene qzoneGalleryScene = new QzoneGalleryScene(activity, BasePictureViewer.this, eVar);
            qzoneGalleryScene.g1(BasePictureViewer.this.n4());
            return qzoneGalleryScene;
        }

        @Override // com.tencent.common.galleryactivity.GalleryManager
        public com.tencent.common.galleryactivity.e h(Activity activity) {
            return BasePictureViewer.this.f49483l0;
        }

        @Override // com.tencent.common.galleryactivity.GalleryManager
        public com.tencent.common.galleryactivity.f i(Activity activity, com.tencent.common.galleryactivity.e eVar) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class h implements AdapterView.OnItemClickListener {
        h() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            BasePictureViewer.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class j extends Handler {
        j() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == -1) {
                BasePictureViewer basePictureViewer = BasePictureViewer.this;
                basePictureViewer.O0 = -1L;
                basePictureViewer.f49495x0 = 0;
                return;
            }
            if (i3 == 1) {
                BasePictureViewer.this.A3();
                ToastUtil.o(R.string.gkh, 4);
                BasePictureViewer basePictureViewer2 = BasePictureViewer.this;
                basePictureViewer2.O0 = -1L;
                basePictureViewer2.f49495x0 = 0;
                return;
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return;
                    }
                    if (BasePictureViewer.this.f49486o0 == null || !BasePictureViewer.this.f49486o0.isShowing()) {
                        BasePictureViewer.this.showWaitingDialog(com.qzone.util.l.a(R.string.jzm));
                        return;
                    }
                    return;
                }
                BasePictureViewer.this.A3();
                if (QZonePermission.requestStoragePermission(BasePictureViewer.this, QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
                    ToastUtil.o(R.string.gkk, 4);
                    BasePictureViewer basePictureViewer3 = BasePictureViewer.this;
                    basePictureViewer3.O0 = -1L;
                    basePictureViewer3.f49495x0 = 0;
                    return;
                }
                return;
            }
            BasePictureViewer.this.A3();
            String string = BasePictureViewer.this.getString(R.string.gki);
            Object obj = message.obj;
            if (obj != null && (obj instanceof String)) {
                String str = (String) obj;
                File file = new File(str);
                if (file.exists()) {
                    MediaUtil.scanFile(BaseApplication.getContext(), file);
                }
                ToastUtil.s(string, 5);
                QZLog.d("[PhotoAlbum]BasePictureViewer", 1, "savePicture time cost:" + (System.currentTimeMillis() - BasePictureViewer.this.O0) + ", filePath: " + str);
            }
            BasePictureViewer basePictureViewer4 = BasePictureViewer.this;
            basePictureViewer4.O0 = -1L;
            basePictureViewer4.f49495x0 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
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
    /* loaded from: classes39.dex */
    public class l extends Handler {
        l() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == -1) {
                BasePictureViewer.this.A3();
                QZLog.i(QZLog.TO_DEVICE_TAG, 1, "forwardPictureForChat copyPictures-save error: unknown");
                BasePictureViewer basePictureViewer = BasePictureViewer.this;
                basePictureViewer.f49495x0 = 0;
                basePictureViewer.R0 = -1L;
                return;
            }
            if (i3 == 1) {
                BasePictureViewer.this.A3();
                ToastUtil.o(R.string.gk7, 4);
                BasePictureViewer basePictureViewer2 = BasePictureViewer.this;
                basePictureViewer2.f49495x0 = 0;
                basePictureViewer2.R0 = -1L;
                return;
            }
            if (i3 != 2) {
                if (i3 == 3) {
                    BasePictureViewer.this.A3();
                    ToastUtil.o(R.string.gk6, 4);
                    BasePictureViewer basePictureViewer3 = BasePictureViewer.this;
                    basePictureViewer3.f49495x0 = 0;
                    basePictureViewer3.R0 = -1L;
                    return;
                }
                if (i3 != 4) {
                    return;
                }
                if (BasePictureViewer.this.f49486o0 == null || !BasePictureViewer.this.f49486o0.isShowing()) {
                    BasePictureViewer.this.showWaitingDialog(com.qzone.util.l.a(R.string.jzl));
                    return;
                }
                return;
            }
            BasePictureViewer.this.A3();
            Object obj = message.obj;
            if (obj != null && (obj instanceof String)) {
                String str = (String) obj;
                BasePictureViewer basePictureViewer4 = BasePictureViewer.this;
                if (basePictureViewer4.f49496y0) {
                    basePictureViewer4.S4(str);
                } else {
                    basePictureViewer4.X4(str);
                }
            }
            QZLog.d("[PhotoAlbum]BasePictureViewer", 1, "forwardPictureForChat time cost:" + (System.currentTimeMillis() - BasePictureViewer.this.R0));
            BasePictureViewer basePictureViewer5 = BasePictureViewer.this;
            basePictureViewer5.f49495x0 = 0;
            basePictureViewer5.R0 = -1L;
        }
    }

    /* loaded from: classes39.dex */
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

    /* loaded from: classes39.dex */
    public interface n {
        void a();

        void b();

        void c();

        void d();
    }

    public BasePictureViewer() {
        this.D0 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_SHOW_SHARE_BUTTONS, 1) == 1;
        this.E0 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_PHOTO_LIST_LOADMORE_COUNT, 50);
        this.F0 = -1;
        this.G0 = new g();
        this.H0 = false;
        this.I0 = 0;
        this.M0 = false;
        this.O0 = -1L;
        this.R0 = -1L;
        this.S0 = new m();
        this.U0 = new o(this);
        this.V0 = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A3() {
        try {
            Dialog dialog = this.f49486o0;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.f49486o0.dismiss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D3() {
        VideoInfo videoInfo;
        VideoUrl videoUrl;
        BasePicureViewController basePicureViewController = this.f49483l0;
        if (basePicureViewController == null || basePicureViewController.b() == null) {
            return;
        }
        PhotoInfo b16 = this.f49483l0.b();
        String str = b16.downloadUrl;
        String str2 = b16.albumId + "_" + b16.lloc;
        if (TextUtils.isEmpty(str) && (videoInfo = b16.videodata) != null && (videoUrl = videoInfo.downloadVideoUrl) != null && !TextUtils.isEmpty(videoUrl.url)) {
            str = b16.videodata.downloadVideoUrl.url;
            str2 = b16.videodata.albumid + "_" + b16.videodata.lloc + ".mp4";
        }
        z3();
        showWaitingDialog(getResources().getString(R.string.f2199767v));
        if (this.I0 == 1) {
            ToastUtil.n(R.string.f21969674);
            A3();
        } else {
            F3(str, str2, new f());
        }
    }

    private void G3(final String str, final String str2, final String str3, final INetEngineListener iNetEngineListener) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.preview.BasePictureViewer.17
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

            /* renamed from: com.qzone.preview.BasePictureViewer$17$a */
            /* loaded from: classes39.dex */
            class a implements com.tencent.mobileqq.transfile.INetEngineListener {
                a() {
                }

                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onResp(NetResp netResp) {
                    NetReq netReq;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("netResp.mResult isSuccess = ");
                    sb5.append(netResp != null && netResp.mResult == 0);
                    QLog.d("[PhotoAlbum]BasePictureViewer", 1, sb5.toString());
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

    private void I4() {
        PhotoInfo b16 = this.f49483l0.b();
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

    private void J3(Bundle bundle) {
        String str;
        String str2;
        String string = bundle.getString("url", "");
        bundle.getString("mini_title", "");
        PhotoInfo b16 = this.f49483l0.b();
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
        ShareUtils.r(this, 10, gVar, 0);
    }

    private void L3(String str, String str2) {
        PhotoInfo b16 = this.f49483l0.b();
        VideoInfo videoInfo = b16.videodata;
        if (videoInfo == null || videoInfo.videoUrl == null) {
            return;
        }
        ShareUtils.f fVar = new ShareUtils.f();
        fVar.f44741b = b16.shareTitle;
        fVar.f44742c = b16.shareSummary;
        fVar.f44743d = b16.sharePhotoUrl;
        fVar.f44740a = str;
        fVar.f44728h = b4(b16.videodata);
        VideoInfo videoInfo2 = b16.videodata;
        int i3 = (int) (videoInfo2.videoTime / 1000);
        fVar.f44729i = i3;
        fVar.f44730j = i3;
        fVar.f44731k = videoInfo2.width;
        fVar.f44732l = videoInfo2.height;
        fVar.f44733m = str2;
        fVar.f44736p = this.f49496y0;
        fVar.f44737q = this.f49497z0;
        fVar.f44738r = this.A0;
        fVar.f44739s = this.B0;
        ShareUtils.o(this, fVar, 0);
    }

    private void M3() {
        PhotoInfo b16 = this.f49483l0.b();
        if (b16 == null) {
            return;
        }
        int d16 = ShareUtils.d(this.f49483l0.h0(), b16.shareSpaceRight, b16.shareAlbumRight, true, false);
        if (d16 == 0) {
            D3();
        } else if (d16 == 4) {
            P4();
        }
        z3();
    }

    private static boolean O4() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_SETTING_SHARE_SINGLE_BIG_PICTURE_AS_WECHAT_MINI_PROGRAM, 1) == 1;
    }

    private void P3() {
        if (this.f49496y0) {
            this.f49487p0 = 72;
        } else {
            this.f49487p0 = 2;
        }
        PhotoInfo b16 = this.f49483l0.b();
        int d16 = ShareUtils.d(this.f49483l0.h0(), b16.shareSpaceRight, b16.shareAlbumRight, true, false);
        if (d16 == 0) {
            Q3(b16.shareQqUrl);
        } else {
            if (d16 != 4) {
                return;
            }
            Q4();
        }
    }

    private void P4() {
        ShareUtils.s(this, new d(), new e());
        this.f49490s0 = true;
    }

    private void Q3(String str) {
        PhotoInfo b16 = this.f49483l0.b();
        VideoInfo videoInfo = b16.videodata;
        if (videoInfo == null || videoInfo.videoUrl == null) {
            return;
        }
        this.f49488q0 = str;
        PictureManager.getInstance().getVideoId(getHandler(), b4(b16.videodata));
        showWaitingDialog(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastGetSharingVID", "\u6b63\u5728\u83b7\u53d6\u5206\u4eabVID"));
    }

    private void Q4() {
        ShareUtils.s(this, new a(), new b());
        this.f49490s0 = true;
    }

    private void S3(Bundle bundle) {
        String string = bundle.getString("url", "");
        String string2 = bundle.getString("mini_id", "");
        String string3 = bundle.getString("mini_path", "");
        String string4 = bundle.getString("mini_title", "");
        boolean a16 = ShareUtils.a(string2, string3);
        PhotoInfo b16 = this.f49483l0.b();
        ShareUtils.g gVar = new ShareUtils.g();
        gVar.f44741b = b16.shareTitle;
        gVar.f44742c = b16.shareSummary;
        gVar.f44743d = b16.sharePhotoUrl;
        gVar.f44740a = string;
        if (O4() && a16) {
            gVar = ShareUtils.d.b(b16, string2, string3, string4);
        }
        ShareUtils.r(this, 9, gVar, (O4() && a16) ? 1 : 0);
    }

    private void T3(String str) {
        PhotoInfo b16 = this.f49483l0.b();
        ShareUtils.g gVar = new ShareUtils.g();
        gVar.f44741b = b16.shareTitle;
        gVar.f44742c = b16.shareSummary;
        gVar.f44743d = b16.sharePhotoUrl;
        gVar.f44740a = str;
        ShareUtils.q(this, 10, gVar);
    }

    public static String V3(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            QZLog.w("[PhotoAlbum]BasePictureViewer", "---getDowndloadUrlForGif:photoInfo is null.");
            return "";
        }
        String a16 = aj.a(photoInfo);
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

    public static File W3(ImageLoader imageLoader, PhotoInfo photoInfo) {
        File imageFile = !TextUtils.isEmpty(photoInfo.orgUrl) ? imageLoader.getImageFile(photoInfo.orgUrl) : null;
        if ((imageFile == null || !imageFile.exists()) && !TextUtils.isEmpty(photoInfo.downloadUrl)) {
            imageFile = imageLoader.getImageFile(photoInfo.downloadUrl);
        }
        if ((imageFile == null || !imageFile.exists()) && photoInfo.photoType == 2) {
            imageFile = imageLoader.getImageFile(V3(photoInfo));
        }
        if (imageFile == null || !imageFile.exists()) {
            imageFile = imageLoader.getImageFile(photoInfo.bigUrl);
        }
        return (imageFile != null || photoInfo.hasLoaded) ? imageFile : imageLoader.getImageFile(photoInfo.currentUrl);
    }

    private void X3() {
        long j3;
        String str;
        long j16;
        PhotoInfo b16 = this.f49483l0.b();
        HashMap hashMap = new HashMap(1);
        if (b16.videoflag == 1) {
            hashMap.put(1, b16.videodata.videoUrl.url);
            hashMap.put(11, "1");
        }
        PhotoParam G = this.f49483l0.G();
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
        showWaitingDialog(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchingUrl", "\u6b63\u5728\u83b7\u53d6\u5206\u4eaburl"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a4() {
        if (this.f49483l0 == null) {
            return "";
        }
        if (o4()) {
            if (this.f49483l0.m0()) {
                return WinkDaTongReportConstant.ElementParamValue.QZONE_ALBUM_VIDEO_LAYER_PAGE;
            }
            return WinkDaTongReportConstant.ElementParamValue.QZONE_SHUOSHUO_VIDEO_LAYER_PAGE;
        }
        if (this.f49483l0.m0()) {
            return WinkDaTongReportConstant.ElementParamValue.QZONE_ALBUM_PIC_LAYER_PAGE;
        }
        return WinkDaTongReportConstant.ElementParamValue.QZONE_SHUOSHUO_PIC_LAYER_PAGE;
    }

    static /* bridge */ /* synthetic */ boolean h3() {
        return O4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i4(String str) {
        VideoInfo videoInfo;
        IWinkMediaHelper iWinkMediaHelper = (IWinkMediaHelper) QRoute.api(IWinkMediaHelper.class);
        if (o4()) {
            PhotoInfo b16 = this.f49483l0.b();
            if (b16 == null || (videoInfo = b16.videodata) == null) {
                return false;
            }
            return iWinkMediaHelper.isSupportVideoFormat(videoInfo.width, videoInfo.height, (int) videoInfo.validVideoTime);
        }
        return iWinkMediaHelper.isSupportImageFormat(new File(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m4(PhotoInfo photoInfo) {
        if ((this instanceof QzonePictureViewer) && l4(photoInfo) && photoInfo != null && ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) == null) {
            return true;
        }
        if (photoInfo == null || photoInfo.photoType != 2 || ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) != null) {
            return false;
        }
        String V3 = V3(photoInfo);
        File imageFile = ImageLoader.getInstance().getImageFile(V3);
        if (imageFile == null) {
            return true;
        }
        if (SharpPUtils.isSharpP(imageFile)) {
            ImageLoader.getInstance().removeImageFile(V3);
            return true;
        }
        QZLog.i("[PhotoAlbum]BasePictureViewer", 1, "-----needn't to download file for sharpp gif.");
        return false;
    }

    public static String p4(String str) {
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

    private void s4() {
        if (this.f49491t0 || !this.f49483l0.V()) {
            return;
        }
        n nVar = this.f49489r0;
        if (nVar != null) {
            nVar.c();
        }
        this.f49491t0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWaitingDialog(String str) {
        if (isFinishing()) {
            return;
        }
        if (this.f49486o0 == null) {
            ReportDialog reportDialog = new ReportDialog(this, R.style.f174269ui);
            this.f49486o0 = reportDialog;
            reportDialog.setContentView(R.layout.bqd);
            this.f49486o0.findViewById(R.id.kja).setVisibility(8);
            this.f49486o0.findViewById(R.id.cib).setVisibility(0);
        }
        ((TextView) this.f49486o0.findViewById(R.id.dialogText)).setText(str);
        this.f49486o0.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u4() {
        n nVar;
        if (this.f49490s0 || (nVar = this.f49489r0) == null) {
            return;
        }
        nVar.b();
    }

    private void v3(final int i3, final String str, final Handler handler) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.preview.BasePictureViewer.9
            @Override // java.lang.Runnable
            public void run() {
                BasePictureViewer basePictureViewer = BasePictureViewer.this;
                if (basePictureViewer.I0 == 1) {
                    final PhotoInfo[] P = basePictureViewer.f49483l0.P();
                    if (BasePictureViewer.this.f49495x0 == 0) {
                        Message obtain = Message.obtain();
                        obtain.what = 4;
                        handler.sendMessage(obtain);
                    }
                    if (P != null) {
                        BasePictureViewer basePictureViewer2 = BasePictureViewer.this;
                        if (basePictureViewer2.f49495x0 < P.length) {
                            basePictureViewer2.getHandler().post(new Runnable() { // from class: com.qzone.preview.BasePictureViewer.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass9 anonymousClass9;
                                    BasePictureViewer basePictureViewer3;
                                    int i16;
                                    PhotoInfo[] photoInfoArr = P;
                                    if (photoInfoArr == null || (i16 = (basePictureViewer3 = BasePictureViewer.this).f49495x0) >= photoInfoArr.length || i16 < 0) {
                                        return;
                                    }
                                    basePictureViewer3.y4(i3, photoInfoArr[i16]);
                                }
                            });
                        }
                    }
                    if (P != null) {
                        BasePictureViewer basePictureViewer3 = BasePictureViewer.this;
                        if (basePictureViewer3.f49495x0 == P.length - 1) {
                            basePictureViewer3.x3(P, str, handler);
                            return;
                        }
                        return;
                    }
                    return;
                }
                PhotoInfo b16 = basePictureViewer.f49483l0.b();
                if (!BasePictureViewer.this.m4(b16)) {
                    if (BasePictureViewer.this.f4(b16)) {
                        BasePictureViewer.this.getHandler().post(new Runnable() { // from class: com.qzone.preview.BasePictureViewer.9.3
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                BasePictureViewer basePictureViewer4 = BasePictureViewer.this;
                                basePictureViewer4.E3(i3, basePictureViewer4.f49483l0.F(), false);
                            }
                        });
                        return;
                    } else {
                        BasePictureViewer basePictureViewer4 = BasePictureViewer.this;
                        basePictureViewer4.w3(basePictureViewer4, b16, str, handler);
                        return;
                    }
                }
                BasePictureViewer.this.getHandler().post(new Runnable() { // from class: com.qzone.preview.BasePictureViewer.9.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                        BasePictureViewer.this.H0(i3);
                    }
                });
            }
        });
    }

    private void v4() {
        n nVar;
        if (this.f49490s0 || (nVar = this.f49489r0) == null) {
            return;
        }
        nVar.d();
    }

    public void B3(Map<String, Object> map) {
        BasePicureViewController basePicureViewController = this.f49483l0;
        map.put("xsj_target_qq", Long.valueOf(basePicureViewController != null ? basePicureViewController.L() : 0L));
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SHAREPANE_SOURCE, a4());
        map.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_QQ_SHARE_PANEL);
        VideoReport.reportEvent("ev_xsj_sharepanel_action", null, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C3() {
        if (this.f49475d0 != null) {
            try {
                if (isFinishing()) {
                    return;
                }
                this.f49475d0.show();
                this.f49475d0.setCancelListener(this);
                t4();
            } catch (Exception e16) {
                e16.printStackTrace();
                QZLog.w(e16);
            } catch (OutOfMemoryError e17) {
                e17.printStackTrace();
            }
        }
    }

    protected abstract void C4();

    /* JADX INFO: Access modifiers changed from: protected */
    public void D4(Bundle bundle) {
        if (NetworkState.getNetworkType() == 2) {
            this.f49473b0 = 3;
        } else {
            this.f49473b0 = bundle.getInt("preload_flag", 0);
        }
        this.f49478g0 = bundle.getBoolean(PictureConst.KEY_SHOW_MENU, true);
        X0 = bundle.getInt("mode");
        this.f49482k0 = bundle.getBoolean("need_clear_cache", false);
        this.f49484m0 = bundle.getBoolean("fromQZone", true);
        this.f49494w0 = bundle.getInt(PictureConst.KEY_ALL_PHOTO_COUNT);
        this.f49495x0 = bundle.getInt(PictureConst.KEY_PHOTO_INDEX_IN_ALBUM);
        PictureManager.needDownloadReport = bundle.getBoolean(QZoneHelper.QZoneAlbumConstants.KEY_NEED_DOWNLOAD_REPORT, false);
        PictureManager.downloadReportKey = bundle.getString(QZoneHelper.QZoneAlbumConstants.KEY_DOWNLOAD_REPORT_KEY);
        BasePicureViewController picureViewController = PictureManager.getInstance().getPicureViewController(X0, this);
        this.f49483l0 = picureViewController;
        picureViewController.Y(bundle);
        this.f49480i0 = bundle.getBoolean(PictureConst.KEY_NEED_BACK_ANIMATION, true);
    }

    public void E4() {
        if (this.f49492u0 != null) {
            ((RelativeLayout) this.G0.k().g()).removeView(this.f49492u0);
        }
    }

    public void F3(String str, String str2, INetEngineListener iNetEngineListener) {
        G3(str, W0, str2, iNetEngineListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G4() {
        if (this.O0 == -1) {
            this.O0 = System.currentTimeMillis();
        }
        if (this.N0 == null) {
            this.N0 = new j();
        }
        v3(3, AppConstants.SDCARD_IMG_SAVE, this.N0);
    }

    public void H3() {
        if (this.R0 == -1) {
            this.R0 = System.currentTimeMillis();
        }
        LpReportInfo_pf00064.report(301, 8, 2);
        if (this.Q0 == null) {
            this.Q0 = new l();
        }
        v3(4, VFSAssistantUtils.getSDKPrivatePath("photo/"), this.Q0);
    }

    protected void H4() {
        if (this.P0 == null) {
            this.P0 = new k();
        }
        v3(3, VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE), this.P0);
        LpReportInfo_pf00064.allReport(134, 1, 2);
    }

    public void I3() {
        Y0 = System.currentTimeMillis();
        IQzoneShareApi iQzoneShareApi = (IQzoneShareApi) QRoute.api(IQzoneShareApi.class);
        if (iQzoneShareApi.isWXinstalled() && iQzoneShareApi.isWxSupportTimeLine()) {
            LpReportInfo_pf00064.report(301, 8, 3);
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath("photo/");
            if (this.T0 == null) {
                this.T0 = new WeChatForwardHandler(this);
            }
            v3(5, sDKPrivatePath, this.T0);
            return;
        }
        ToastUtil.n(R.string.gjq);
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).jmpWeixinDetail(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J4(int i3, boolean z16) {
        com.qzone.detail.ui.component.g gVar = this.f49475d0;
        if (gVar != null) {
            gVar.s0(i3, z16);
            this.f49475d0.updateUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L4(int i3) {
        com.qzone.detail.ui.component.g gVar = this.f49475d0;
        if (gVar != null) {
            gVar.p0(i3);
            this.f49475d0.updateUI();
        }
    }

    protected void S4(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(getOutActivity(), DirectForwardActivity.class);
        intent.putExtra("toUin", String.valueOf(this.f49497z0));
        intent.putExtra("uinType", this.A0);
        intent.putExtra("nickName", this.B0);
        intent.putExtra("forward_type", 1);
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, str);
        intent.putExtra("key_flag_from_plugin", true);
        startActivityForResult(intent, 1000);
    }

    @Override // com.qzone.preview.b
    public void S7(boolean z16) {
        M4(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U4(Context context, int i3, String str, Parcelable parcelable, String str2) {
        Intent intent = new Intent(context, (Class<?>) FeedActionPanelActivity.class);
        intent.putExtra("extraRequestCode", i3);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY, str2);
        intent.putExtra("canVertical", true);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.FEED_TEXT_HINT_INTENT_KEY, str);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_REFER_ACTIVITY, "[PhotoAlbum]BasePictureViewer");
        if (!BasePicureViewController.o0()) {
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_FONT_ICON, 1);
        }
        intent.putExtra("show_barrage_effect_icon", this.f49483l0.f49877g.appid == 311);
        String stringExtra = getIntent().getStringExtra(QQWinkConstants.KEY_PREVIOUS_ACTIVITY);
        BasePicureViewController basePicureViewController = this.f49483l0;
        if (basePicureViewController.f49891u) {
            if (!basePicureViewController.f49877g.isShareAlbum && (am.h(stringExtra) || (!stringExtra.contains(QQBrowserActivity.class.getSimpleName()) && !stringExtra.contains(QQMiniManager.getAppBrandUIClass().getSimpleName())))) {
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
        com.qzone.feed.utils.b.f(this, intent, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V4(Context context, int i3, String str, Parcelable parcelable, String str2) {
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
        com.qzone.feed.utils.b.f(this, intent, i3);
    }

    @Override // com.qzone.preview.b
    public boolean X() {
        return true;
    }

    protected void X4(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(getOutActivity(), ForwardRecentActivity.class);
        intent.putExtra("forward_type", 1);
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, str);
        intent.putExtra("key_flag_from_plugin", true);
        if (QZoneConfigHelper.v()) {
            intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
            intent.putExtra("isFromShare", true);
            intent.putExtra("sendMultiple", true);
        }
        startActivityForResult(intent, 1000);
    }

    public String b4(VideoInfo videoInfo) {
        VideoUrl videoUrl = videoInfo.downloadVideoUrl;
        if (videoUrl != null && !TextUtils.isEmpty(videoUrl.url)) {
            return videoInfo.downloadVideoUrl.url;
        }
        return videoInfo.videoUrl.url;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c4() {
        return this.f49493v0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d4(QZoneResult qZoneResult) {
        A3();
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
                N4(bundle);
                return;
            } else {
                N4(bundle);
                return;
            }
        }
        ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchUrlFail", "\u83b7\u53d6\u5206\u4eab\u4fe1\u606f\u5931\u8d25"), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e4(QZoneResult qZoneResult) {
        String str;
        A3();
        if (qZoneResult != null && qZoneResult.getSucceed() && (qZoneResult.getData() instanceof String)) {
            L3(this.f49488q0, (String) qZoneResult.getData());
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

    public boolean g4() {
        PhotoInfo b16 = this.f49483l0.b();
        return b16 != null && b16.photoType == 2;
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    protected int getFeedListBackgroundId() {
        return -1;
    }

    @Override // com.qzone.common.activities.base.BaseActivity, com.qzone.preview.b
    public Handler getHandler() {
        return this.U0;
    }

    @Override // com.qzone.preview.b
    public ListView getListView() {
        return this.J0;
    }

    @Override // com.qzone.preview.b
    public int getShowType() {
        return this.I0;
    }

    protected boolean h4() {
        com.qzone.detail.ui.component.g gVar = this.f49475d0;
        return gVar != null && gVar.isShowing();
    }

    @Override // com.qzone.preview.b
    public GalleryManager h7() {
        return this.G0;
    }

    @Override // com.qzone.preview.b
    public View h8() {
        return null;
    }

    @Override // com.qzone.preview.b
    public boolean h9() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i3(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) this.G0.k().g();
        if (relativeLayout == null || view == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ar.k() / 2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        view.setId(R.id.b4p);
        relativeLayout.addView(view, layoutParams);
    }

    @Override // com.qzone.preview.b
    public int j0() {
        return this.f49473b0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j3(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) this.G0.k().g();
        if (relativeLayout == null || view == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10, -1);
        layoutParams.addRule(11, -1);
        layoutParams.setMargins(0, ar.d(13.0f) + SystemUtil.getNotchHeight(getOutActivity(), this), ar.d(12.0f), 0);
        relativeLayout.addView(view, layoutParams);
    }

    protected boolean k4() {
        if (this.F0 == -1) {
            this.F0 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_IS_PHOTO_SAVE, 1);
        }
        return this.F0 == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l3(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) this.G0.k().g();
        if (relativeLayout == null || view == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        view.setId(R.id.f166517ft0);
        relativeLayout.addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n3(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) this.G0.k().g();
        if (relativeLayout == null || view == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10, -1);
        layoutParams.addRule(14, -1);
        view.setId(R.id.f166518ft1);
        relativeLayout.addView(view, layoutParams);
    }

    protected boolean n4() {
        return false;
    }

    @Override // com.qzone.preview.b
    public Callback n7() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.I0 == 1) {
            this.K0.notifyDataSetChanged();
            updateUI();
        } else {
            this.G0.k().h();
        }
    }

    @Override // com.qzone.preview.b
    public /* synthetic */ TextView o3() {
        return com.qzone.preview.a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean o4() {
        return z.b(this.f49483l0.b());
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        u4();
    }

    @Override // com.qzone.common.activities.base.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.G0.p(configuration);
        v4();
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().setSoftInputMode(32);
        super.onCreate(bundle);
        waitAppRuntime();
        PictureManager.getInstance();
        this.f49472a0 = LayoutInflater.from(this);
        Intent intent = getIntent();
        if (bundle != null) {
            z4(bundle);
        } else if (intent != null && intent.getExtras() != null) {
            D4(intent.getExtras());
        } else {
            w5.b.g("[PhotoAlbum]BasePictureViewer", 1, "parseData error: bundle is null");
            finish();
            return;
        }
        this.G0.q(this);
        initData();
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        getHandler().removeCallbacksAndMessages(null);
        GalleryManager galleryManager = this.G0;
        if (galleryManager != null) {
            if (galleryManager.l() != null && this.G0.l().x() != null && (this.G0.l().x() instanceof PictureAdapter)) {
                ((PictureAdapter) this.G0.l().x()).h0();
            }
            this.G0.r(this);
        }
        if (this.f49482k0) {
            ImageLoader.getInstance().clear(false);
        }
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).removeObserver(this.S0);
        com.qzone.detail.ui.component.g gVar = this.f49475d0;
        if (gVar != null) {
            gVar.setItemClickListenerV2(null);
        }
        super.onDestroy();
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (!hasWindowFocus()) {
            return false;
        }
        if (i3 == 82) {
            PanoramaLayout panoramaLayout = this.f49492u0;
            if (panoramaLayout != null && panoramaLayout.E()) {
                return true;
            }
            if (h4()) {
                z3();
            } else {
                w1();
            }
        }
        if (i3 == 4) {
            return w4();
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i3, KeyEvent keyEvent) {
        return super.onKeyLongPress(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        t4();
        if (this.f49484m0 && com.tencent.mobileqq.simpleui.b.c()) {
            QzoneOnlineTimeCollectRptService.getInstance().closeTrace();
        }
        SmallScreenUtils.A(BaseApplication.getContext(), false);
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        u4();
        if (this.f49484m0 && com.tencent.mobileqq.simpleui.b.c()) {
            QzoneOnlineTimeCollectRptService.getInstance().beginTrace(3);
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            getWindow().addFlags(67108864);
        }
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, false);
        SmallScreenUtils.A(BaseApplication.getContext(), true);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.preview.BasePictureViewer.12
            @Override // java.lang.Runnable
            public void run() {
                BasePictureViewer.this.f49493v0 = ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).isWXinstalled() && ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).isWxSupportTimeLine();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("preload_flag", this.f49473b0);
        bundle.putBoolean(PictureConst.KEY_SHOW_MENU, this.f49478g0);
        bundle.putBoolean(PictureConst.KEY_SHOW_TAG, this.f49479h0);
        bundle.putBoolean(PictureConst.KEY_NEED_BACK_ANIMATION, this.f49480i0);
        bundle.putInt("mode", X0);
        bundle.putLong(PictureConst.KEY_UIN_ONSAVEINSTANCESTATE, LoginData.getInstance().getUin());
        this.f49483l0.M0(bundle);
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (z16) {
            this.G0.v(this);
        }
    }

    protected void p3() {
        RelativeLayout relativeLayout = (RelativeLayout) this.G0.k().g();
        if (relativeLayout != null) {
            this.J0 = new ListView(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13, -1);
            this.J0.setId(R.id.f166519ft2);
            this.J0.setBackgroundResource(R.color.black);
            relativeLayout.addView(this.J0, layoutParams);
            this.J0.setSelector(R.color.ajr);
            this.J0.setVerticalScrollBarEnabled(false);
            this.J0.setScrollbarFadingEnabled(false);
            this.J0.setOnItemClickListener(new h());
            this.J0.setOnScrollListener(new i());
            com.qzone.preview.e eVar = new com.qzone.preview.e(this, this.f49483l0);
            this.K0 = eVar;
            this.J0.setAdapter((ListAdapter) eVar);
            if (this.G0.k() instanceof com.tencent.common.galleryactivity.c) {
                ((com.tencent.common.galleryactivity.c) this.G0.k()).w().setVisibility(8);
            }
        }
    }

    @Override // com.qzone.preview.b
    public void q1() {
        if (this.H0) {
            return;
        }
        this.H0 = true;
        ToastUtil.n(R.string.ghi);
    }

    public void r4(String str) {
        yo.g gVar = new yo.g(str);
        A3();
        yo.d.b(getBaseContext(), gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareActionSheetBuilder.ActionSheetItem s3(int i3, int i16, @Deprecated int i17, @Deprecated int i18, boolean z16) {
        if (this.f49475d0 == null) {
            return null;
        }
        if (z16) {
            ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(i16);
            if (i3 == 1) {
                this.f49476e0.add(build);
            } else {
                this.f49477f0.add(build);
            }
        }
        this.f49475d0.updateUI();
        return null;
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public boolean shouldSetOrientation() {
        return false;
    }

    public void t3(PanoramaLayout panoramaLayout) {
        E4();
        this.f49492u0 = panoramaLayout;
        RelativeLayout relativeLayout = (RelativeLayout) this.G0.k().g();
        if (relativeLayout == null || panoramaLayout == null) {
            return;
        }
        relativeLayout.addView(panoramaLayout, 0, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t4() {
        n nVar;
        if (this.f49490s0 || (nVar = this.f49489r0) == null) {
            return;
        }
        nVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u3(boolean z16) {
        PhotoInfo b16 = this.f49483l0.b();
        if (b16 == null) {
            return false;
        }
        if (!o4()) {
            return true;
        }
        int d16 = ShareUtils.d(this.f49483l0.h0(), b16.shareSpaceRight, b16.shareAlbumRight, false, z16);
        return d16 == 0 || d16 == 4;
    }

    @Override // com.qzone.preview.b
    public void updateUI() {
        BasePicureViewController basePicureViewController = this.f49483l0;
        basePicureViewController.E = this.L0;
        this.L0 = false;
        if (basePicureViewController.l0()) {
            C4();
            s4();
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.preview.BasePictureViewer.4
            @Override // java.lang.Runnable
            public void run() {
                BasePictureViewer basePictureViewer = BasePictureViewer.this;
                basePictureViewer.f49483l0.x0(basePictureViewer.n7());
            }
        });
    }

    @Override // com.qzone.preview.b
    public void w1() {
        if (this.f49478g0 && !h4()) {
            y3();
            Y4();
            ClickReport.e(4, getIntent().getStringExtra("refer"), 301, 6, 1);
            Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
            buildElementParams.put("xsj_action_type", "panel_exp");
            B3(buildElementParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w4() {
        return this.G0.o();
    }

    @Override // com.qzone.preview.b
    public void x2(n nVar) {
        this.f49489r0 = nVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void y3() {
        if (this.f49478g0) {
            try {
                g.a aVar = new g.a();
                Activity outActivity = this instanceof BasePluginActivity ? ((BasePluginActivity) this).getOutActivity() : this;
                aVar.context = outActivity;
                com.qzone.detail.ui.component.g gVar = new com.qzone.detail.ui.component.g(aVar);
                this.f49475d0 = gVar;
                gVar.setActionSheetTitle(outActivity.getString(R.string.hja));
                this.f49475d0.setIntentForStartForwardRecentActivity(new Intent());
                this.f49476e0.clear();
                this.f49477f0.clear();
                this.f49475d0.setActionSheetItems(this.f49476e0, this.f49477f0);
                if (this.f49483l0.j()) {
                    s3(1, 3, R.string.gjo, R.drawable.qzone_icon_action_sheet_qzone, true);
                }
                s3(1, 2, R.string.gkm, R.drawable.qzone_detail_panel_qq, true);
                s3(1, 203, R.string.f2203068r, R.drawable.mzr, true);
                if (this.f49483l0.m() && c4()) {
                    s3(1, 9, R.string.gkn, R.drawable.cco, true);
                }
                if (this.f49483l0.n() && c4()) {
                    s3(1, 10, R.string.b59, R.drawable.qzone_icon_action_sheet_pengyouquan, true);
                }
                this.f49475d0.setItemClickListenerV2(this.V0);
                if (this.f49483l0.l()) {
                    s3(2, 39, R.string.gkf, R.drawable.qzone_more_menu_download, k4());
                }
                if (!o4() && this.I0 != 1 && !this.f49483l0.f49894x) {
                    s3(2, 48, R.string.gkg, R.drawable.qzone_more_menu_saveasemotion, k4());
                }
                r3();
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }
    }

    @Override // com.qzone.preview.b
    public boolean z0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z3() {
        com.qzone.detail.ui.component.g gVar;
        if (h4() && (gVar = this.f49475d0) != null) {
            try {
                gVar.dismiss();
                u4();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    protected void z4(Bundle bundle) {
        this.f49473b0 = bundle.getInt("preload_flag");
        this.f49478g0 = bundle.getBoolean(PictureConst.KEY_SHOW_MENU);
        this.f49479h0 = bundle.getBoolean(PictureConst.KEY_SHOW_TAG);
        this.f49480i0 = bundle.getBoolean(PictureConst.KEY_NEED_BACK_ANIMATION);
        X0 = bundle.getInt("mode");
        LoginData.getInstance().setUin(bundle.getLong(PictureConst.KEY_UIN_ONSAVEINSTANCESTATE));
        BasePicureViewController picureViewController = PictureManager.getInstance().getPicureViewController(X0, this);
        this.f49483l0 = picureViewController;
        picureViewController.K0(bundle);
    }

    /* loaded from: classes39.dex */
    private static class o extends WeakReferenceHandler<BasePictureViewer> {
        o(BasePictureViewer basePictureViewer) {
            super(basePictureViewer);
        }

        @Override // cooperation.qzone.util.WeakReferenceHandler
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void handleMessage(BasePictureViewer basePictureViewer, Message message) {
            if (message != null) {
                basePictureViewer.onHandleMessage(message);
            }
        }
    }

    private void N4(Bundle bundle) {
        QZLog.d("[PhotoAlbum]shareOutSide", 1, "[PhotoAlbum]BasePictureViewer", " handleGetShareUrlResult rsp:", bundle.toString());
        String string = bundle.getString("url", "");
        int i3 = this.f49487p0;
        if (i3 == 2 || i3 == 72) {
            Q3(string);
        } else if (i3 == 9) {
            S3(bundle);
        } else if (i3 == 10) {
            J3(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F4() {
        this.f49491t0 = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initData() {
        this.f49474c0 = false;
        ClickReport.e(4, getIntent().getStringExtra("refer"), 301, 1);
        this.I0 = getIntent().getIntExtra(PeakConstants.KEY_SHOW_TYPE, 0);
        this.C0 = getIntent().getIntExtra(PeakConstants.KEY_MIN_PHOTO_COUNT, 0);
        if (1 == this.I0) {
            p3();
        }
    }

    private void K3() {
        long j3;
        String str;
        long j16;
        this.f49487p0 = 10;
        PhotoInfo b16 = this.f49483l0.b();
        HashMap hashMap = new HashMap(1);
        hashMap.put(1, b16.bigUrl);
        hashMap.put(2, "0");
        hashMap.put(10, "1");
        PhotoParam G = this.f49483l0.G();
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
        showWaitingDialog(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchingUrl", "\u6b63\u5728\u83b7\u53d6\u5206\u4eaburl"));
    }

    private void R3() {
        this.f49487p0 = 9;
        PhotoInfo b16 = this.f49483l0.b();
        int d16 = ShareUtils.d(this.f49483l0.h0(), b16.shareSpaceRight, b16.shareAlbumRight, true, true);
        QZLog.d("[PhotoAlbum]shareOutSide", 1, "forwardVideoForWXChat rightResult:", Integer.valueOf(d16), " isGuest:", Boolean.valueOf(this.f49483l0.h0()), " spaceRight:", Integer.valueOf(b16.shareSpaceRight), " albumRight:", Integer.valueOf(b16.shareAlbumRight));
        if (d16 == 0 || d16 == 4) {
            X3();
        }
    }

    private void U3() {
        this.f49487p0 = 10;
        PhotoInfo b16 = this.f49483l0.b();
        int d16 = ShareUtils.d(this.f49483l0.h0(), b16.shareSpaceRight, b16.shareAlbumRight, true, false);
        if (d16 == 0) {
            T3(b16.shareWeixinUrl);
        } else {
            if (d16 != 4) {
                return;
            }
            Q4();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f4(PhotoInfo photoInfo) {
        return photoInfo != null && !TextUtils.isEmpty(photoInfo.downloadUrl) && ImageLoader.getInstance().getImageFile(photoInfo.downloadUrl) == null && ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) == null;
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public void IOnSetTheme() {
        setTheme(R.style.f173749jl);
        try {
            Window.class.getMethod("addExtraFlags", Integer.TYPE).invoke(getWindow(), 1792);
        } catch (Exception unused) {
            QZLog.i("[PhotoAlbum]BasePictureViewer", "addExtraFlags not found.");
        }
    }

    private void M4(boolean z16) {
        try {
            if (z16) {
                getWindow().addFlags(128);
            } else {
                getWindow().clearFlags(128);
            }
        } catch (Throwable th5) {
            QLog.e("[PhotoAlbum]BasePictureViewer", 1, "[setScreenOn] error: ", th5);
        }
    }

    public static boolean l4(PhotoInfo photoInfo) {
        return (photoInfo == null || photoInfo.photoType != 2 || TextUtils.isEmpty(photoInfo.orgUrl)) ? false : true;
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
                startActivity(ak.H(this, albumCacheData.albumid, albumCacheData.albumname, Long.valueOf(j3), albumCacheData.albumquestion, albumCacheData.busi_param, 0, null, albumCacheData.albumtype, false));
                return;
            }
            BusinessAlbumInfo createFrom = BusinessAlbumInfo.createFrom(albumCacheData.albumid, albumCacheData.albumtype, albumCacheData.albumname, albumCacheData.getLloc(), albumCacheData.albumrights, albumCacheData.albumnum, albumCacheData.anonymity, albumCacheData.individual, albumCacheData.operatemask, albumCacheData.allow_share, albumCacheData.isSharingAlbumOnServer(), com.qzone.album.util.b.a(albumCacheData), albumCacheData.isSharingOwner);
            createFrom.mUin = j3;
            createFrom.mCover = albumCacheData.getLloc();
            createFrom.isIndividualityAlbum = albumCacheData.individual != 0;
            createFrom.sortType = albumCacheData.sortType;
            startActivity(ak.I(this, createFrom, 0));
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

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean x4(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (actionSheetItem == null) {
            return false;
        }
        int i3 = actionSheetItem.action;
        this.f49496y0 = false;
        this.f49497z0 = 0L;
        this.A0 = 0;
        this.B0 = null;
        if (i3 != 2) {
            if (i3 == 39) {
                if (!QZonePermission.requestStoragePermission(this, QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
                    return true;
                }
                if (!k4()) {
                    QZLog.e("[PhotoAlbum]BasePictureViewer", "[MORE_SAVE] this function is closed and not suposed to show!");
                    return true;
                }
                if (o4()) {
                    I4();
                    ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "24", true);
                } else {
                    G4();
                    ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "2", true);
                }
                z3();
                return true;
            }
            if (i3 == 48) {
                if (!o4()) {
                    H4();
                }
                z3();
                return true;
            }
            if (i3 == 203) {
                Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
                buildElementParams.put("xsj_action_type", "share");
                buildElementParams.put("xsj_share_target", WinkDaTongReportConstant.ElementParamValue.LITTLE_WORLD);
                B3(buildElementParams);
                if (o4()) {
                    M3();
                } else {
                    D3();
                }
                return true;
            }
            if (i3 == 9) {
                if (o4()) {
                    R3();
                } else {
                    I3();
                }
                z3();
                ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "30", true);
                return true;
            }
            if (i3 == 10) {
                if (o4()) {
                    U3();
                } else {
                    K3();
                }
                z3();
                return true;
            }
            if (i3 != 72 && i3 != 73) {
                return false;
            }
        }
        if (i3 == 72) {
            this.f49496y0 = true;
            this.f49497z0 = Long.parseLong(actionSheetItem.uin);
            this.A0 = actionSheetItem.uinType;
            this.B0 = actionSheetItem.label;
        }
        if (o4()) {
            P3();
        } else {
            H3();
        }
        z3();
        ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "29", true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0178 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c1 A[Catch: OutOfMemoryError -> 0x0128, TryCatch #1 {OutOfMemoryError -> 0x0128, blocks: (B:49:0x00bb, B:51:0x00c1, B:53:0x00d6, B:65:0x00ca), top: B:48:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d6 A[Catch: OutOfMemoryError -> 0x0128, TRY_LEAVE, TryCatch #1 {OutOfMemoryError -> 0x0128, blocks: (B:49:0x00bb, B:51:0x00c1, B:53:0x00d6, B:65:0x00ca), top: B:48:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ca A[Catch: OutOfMemoryError -> 0x0128, TryCatch #1 {OutOfMemoryError -> 0x0128, blocks: (B:49:0x00bb, B:51:0x00c1, B:53:0x00d6, B:65:0x00ca), top: B:48:0x00bb }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w3(Context context, PhotoInfo photoInfo, String str, Handler handler) {
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
        File W3 = W3(ImageLoader.getInstance(), photoInfo);
        if (W3 == null) {
            i3 = 2;
            i16 = 1;
        } else {
            if (W3.exists()) {
                String p46 = p4(W3.getAbsolutePath());
                if (p46 == null) {
                    obtain.what = 1;
                    QZLog.i(QZLog.TO_DEVICE_TAG, 1, "copyPictrue-save error postfix == null");
                    handler.sendMessage(obtain);
                    return;
                }
                boolean equals = p46.equals("webp");
                if (equals) {
                    try {
                        Bitmap decodeFile = BitmapFactory.decodeFile(W3.getAbsolutePath());
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
                                if (!p46.equals("sharpp")) {
                                }
                                QZLog.i("[PhotoAlbum]BasePictureViewer", "sharpp file");
                                try {
                                    if (!p46.equals("sharpp")) {
                                    }
                                    if (a16 != null) {
                                    }
                                } catch (OutOfMemoryError e17) {
                                    e = e17;
                                }
                                if (!equals) {
                                }
                                if (equals) {
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
                if (!p46.equals("sharpp") || p46.equals("avif")) {
                    QZLog.i("[PhotoAlbum]BasePictureViewer", "sharpp file");
                    if (!p46.equals("sharpp")) {
                        a16 = SharpPUtils.decodeSharpP(W3.getAbsolutePath());
                    } else {
                        a16 = com.tencent.qzone.image.api.a.c().a(W3, photoInfo.bigUrl, 0, 0);
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
                                obtain.what = 2;
                                obtain.obj = str2;
                            }
                            handler.sendMessage(obtain);
                            return;
                        }
                    }
                }
                if ((!equals && !z16) || !equals) {
                    String str6 = str + (String.valueOf(System.currentTimeMillis()) + "." + p46);
                    FileUtils.copyFiles(new File(W3.getAbsolutePath()), new File(str6));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void x3(PhotoInfo[] photoInfoArr, String str, Handler handler) {
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
                File W3 = W3(imageLoader, photoInfo);
                if (W3 != null && W3.exists()) {
                    String p46 = p4(W3.getAbsolutePath());
                    if (p46 == null) {
                        obtain.what = 1;
                        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "copyPictures-save error postfix == null");
                        handler.sendMessage(obtain);
                        return;
                    }
                    arrayList.add(p46);
                    arrayList2.add(W3);
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
            int i17 = getResources().getDisplayMetrics().widthPixels;
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
                    AvifImage g16 = AvifDecoder.c(com.tencent.mobileqq.utils.FileUtils.readFile(((File) arrayList2.get(i19)).getAbsolutePath())).g();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i16 == 0) {
            return;
        }
        if (i16 == -1) {
            switch (i3) {
                case 1000:
                    break;
                case 1001:
                    this.M0 = true;
                    finish();
                    break;
                case 1002:
                    finish();
                    break;
                case 1003:
                    this.f49483l0.i1(Long.parseLong(intent.getStringExtra("extra_choose_friend_uin")), intent.getStringExtra("extra_choose_friend_name"), intent.getStringExtra("extraChooseFriendRemark"), intent.getIntExtra("key_selected_share_touch_face_position", -1));
                    break;
                case 1004:
                    this.f49483l0.j1(Long.parseLong(intent.getStringExtra("extra_choose_friend_uin")), intent.getStringExtra("extra_choose_friend_name"), intent.getStringExtra("extraChooseFriendRemark"), intent.getIntExtra("key_selected_share_touch_face_position", -1));
                    break;
                default:
                    QZLog.e("[PhotoAlbum]BasePictureViewer", "onActivityResult requestCode: " + i3 + " without process");
                    break;
            }
        }
        super.onActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class f implements INetEngineListener {
        f() {
        }

        @Override // com.tencent.mobileqq.wink.listener.INetEngineListener
        public void getFilePath(String str) {
            if (TextUtils.isEmpty(str) || !BasePictureViewer.this.i4(str)) {
                if (BasePictureViewer.this.i4(str)) {
                    BasePictureViewer.this.A3();
                    return;
                } else {
                    ToastUtil.n(R.string.f21969674);
                    BasePictureViewer.this.A3();
                    return;
                }
            }
            BasePictureViewer.this.r4("mqqapi://qcircle/openqqpublish?target=3&exit_dialog=1&mediaPath=" + str + ContainerUtils.FIELD_DELIMITER + WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID + ContainerUtils.KEY_VALUE_DELIMITER + BasePictureViewer.this.a4());
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
    public void U7() {
    }

    protected void Y4() {
    }

    @Override // com.qzone.preview.b
    public void d1(boolean z16) {
    }

    @Override // com.qzone.preview.b
    public Activity getHostActivity() {
        return this;
    }

    @Override // com.qzone.preview.b
    public void o5() {
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    protected void onHandleMessage(Message message) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r3() {
    }

    @Override // com.qzone.preview.b
    public void y1() {
    }

    protected void B4(AbsListView absListView, int i3) {
    }

    public void y4(int i3, PhotoInfo photoInfo) {
    }

    public void E3(int i3, PhotoInfo photoInfo, boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class i implements AbsListView.OnScrollListener {
        i() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            BasePictureViewer.this.B4(absListView, i3);
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        }
    }
}
