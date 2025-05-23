package com.qzone.album.business.photolist.controller;

import NS_MOBILE_PHOTO.RecommendPhotos;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qzone.album.base.Service.QzoneAlbumPicDownloadService;
import com.qzone.album.business.downloader.DownloadQueue;
import com.qzone.album.business.downloader.PhotoDownloadQueueTask;
import com.qzone.album.business.downloader.VideoDownloadQueueTask;
import com.qzone.album.business.photolist.ui.menu.QZoneMakeVideoPopupMenu;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZonePhotoListRequest;
import com.qzone.album.ui.widget.AlbumDialog;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.common.account.LoginData;
import com.qzone.common.tool.ReportUtils;
import com.qzone.misc.network.downloader.i;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.util.image.NetImageInfo;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.util.ImageContentType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.listener.INetEngineListener;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.picker.MediaInfo;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.impl.QzoneWinkOutputRouter;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.AbsListView;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.album.QzonePhotoInfo;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import oo.b;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class AbsViewerModeController extends BasePhotoModelController {

    /* renamed from: b3, reason: collision with root package name */
    public static final long f42867b3 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_MAX_P2V_VIDEO_DURING, 15000L);
    protected int D2;
    protected int E2;
    protected int F2;
    protected QZoneMakeVideoPopupMenu G2;
    protected String H2;
    protected ArrayList<PhotoCacheData> I2;
    protected RecommendPhotos J2;
    private IWinkEditorResourceAPI K2;
    public volatile boolean L2;
    private volatile boolean M2;
    private volatile boolean N2;
    private ArrayList<MediaInfo> O2;
    private volatile int P2;
    protected View.OnClickListener Q2;
    protected View.OnClickListener R2;
    protected View.OnClickListener S2;
    protected boolean T2;
    protected int U2;
    ArrayList<String> V2;
    ArrayList<String> W2;
    AlbumDialog X2;
    protected boolean Y2;
    protected BroadcastReceiver Z2;

    /* renamed from: a3, reason: collision with root package name */
    private Runnable f42868a3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            AbsViewerModeController.this.Y2 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            AbsViewerModeController.this.v5();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (AbsViewerModeController.this.Y2) {
                return;
            }
            u4.a z16 = u4.a.z();
            AbsViewerModeController absViewerModeController = AbsViewerModeController.this;
            z16.Z(absViewerModeController.Q, absViewerModeController.U2, "jhan_plxz", 27);
            AbsViewerModeController.this.Y2 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            AbsViewerModeController.this.Y2 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !intent.getAction().equals("action_h5pay_callback")) {
                return;
            }
            String stringExtra = intent.getStringExtra("h5pay_callback_json");
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                if (jSONObject.has("status") && "success".equalsIgnoreCase(jSONObject.getString("status"))) {
                    QZLog.d("[PhotoAlbum] BasePhotoModelController", 2, "vipType: ", jSONObject.optString("vipType", null), " json:", stringExtra);
                    AlbumDialog albumDialog = AbsViewerModeController.this.X2;
                    if (albumDialog != null && albumDialog.isShowing()) {
                        AbsViewerModeController.this.X2.dismiss();
                    }
                    AbsViewerModeController absViewerModeController = AbsViewerModeController.this;
                    absViewerModeController.r5(absViewerModeController.V2, absViewerModeController.W2, false);
                    AbsViewerModeController.this.Y2 = false;
                }
            } catch (Exception e16) {
                if (QZLog.isColorLevel()) {
                    QZLog.d("[PhotoAlbum] BasePhotoModelController", 2, "handleJsRequest: ", e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AbsViewerModeController.this.X3(false);
            if (AbsViewerModeController.this.H5()) {
                com.qzone.album.env.common.a.m().V(AbsViewerModeController.this.I(R.string.f173015gh3));
            } else if (qo.c.c()) {
                QLog.e("[PhotoAlbum] BasePhotoModelController", 1, "makePicVideoClickListener onClick block by res not ready!");
                AbsViewerModeController.this.G2.e();
            } else {
                AbsViewerModeController.this.X3(false);
                AbsViewerModeController.this.u5(3);
                AbsViewerModeController.this.G2.e();
                LpReportInfo_pf00064.allReport(326, 2, 60);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZonePermission.requestStoragePermission(AbsViewerModeController.this.getCurrentActivity(), QQPermissionConstants.Business.SCENE.QQ_QZONE_VIDEO_EDIT_READ_MEDIA)) {
                AbsViewerModeController.this.X3(false);
                AbsViewerModeController.this.G2.e();
                DownloadQueue.j().B();
                AbsViewerModeController.this.Z5();
                AbsViewerModeController absViewerModeController = AbsViewerModeController.this;
                absViewerModeController.P5(absViewerModeController.G2.j(), AbsViewerModeController.this.G2.i());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AbsViewerModeController.this.X3(false);
            if (AbsViewerModeController.this.H5()) {
                com.qzone.album.env.common.a.m().V(AbsViewerModeController.this.I(R.string.f173015gh3));
            } else {
                LpReportInfo_pf00064.allReport(326, 2, 47);
                AbsViewerModeController.this.u5(7);
                AbsViewerModeController.this.G2.e();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class i implements AbsCompatRequest.a {
        i() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "reportP2VRecommend|resultWrapper.getSucceed():", Boolean.valueOf(sVar.getSucceed()));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class j implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f42905d;

        j(ArrayList arrayList) {
            this.f42905d = arrayList;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (AbsViewerModeController.this.T2) {
                u4.a.z().k(this.f42905d);
                AbsViewerModeController.this.T2 = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class l implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f42909d;

        l(ArrayList arrayList) {
            this.f42909d = arrayList;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (AbsViewerModeController.this.T2) {
                u4.a.z().k(this.f42909d);
                AbsViewerModeController.this.T2 = false;
            }
            AbsViewerModeController.this.x5();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class m implements DialogInterface.OnDismissListener {
        m() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            AbsViewerModeController.this.M2 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class n implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f42912d;

        n(ArrayList arrayList) {
            this.f42912d = arrayList;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (AbsViewerModeController.this.T2) {
                u4.a.z().k(this.f42912d);
                AbsViewerModeController.this.T2 = false;
            }
            AbsViewerModeController.this.x5();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class s extends TypeToken<List<MetaMaterial>> {
        s() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class t implements DialogInterface.OnClickListener {
        t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            AbsViewerModeController.this.V1 = true;
            if (AbsViewerModeController.this.k3()) {
                return;
            }
            AbsViewerModeController.this.i5();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class u implements DialogInterface.OnClickListener {
        u() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class v implements DialogInterface.OnClickListener {
        v() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            AbsViewerModeController.this.V1 = true;
            if (AbsViewerModeController.this.k3()) {
                return;
            }
            AbsViewerModeController.this.i5();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class w implements DialogInterface.OnClickListener {
        w() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class x implements DialogInterface.OnDismissListener {
        x() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            AbsViewerModeController.this.Y2 = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class y extends QQPermission.BasePermissionsListener {
        y() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            AbsViewerModeController.this.j5();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class z implements DialogInterface.OnClickListener {
        z() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (AbsViewerModeController.this.Y2) {
                return;
            }
            u4.a z16 = u4.a.z();
            AbsViewerModeController absViewerModeController = AbsViewerModeController.this;
            z16.Z(absViewerModeController.Q, absViewerModeController.U2, "jhan_plxz", 27);
            AbsViewerModeController.this.Y2 = true;
        }
    }

    public AbsViewerModeController(FragmentActivity fragmentActivity, u4.h hVar) {
        super(fragmentActivity, hVar);
        this.F2 = 2;
        this.J2 = null;
        this.K2 = (IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class);
        this.P2 = 0;
        this.T2 = false;
        this.U2 = -1;
        this.V2 = new ArrayList<>();
        this.W2 = new ArrayList<>();
        this.X2 = null;
        this.Y2 = false;
        this.Z2 = null;
        this.f42868a3 = new Runnable() { // from class: com.qzone.album.business.photolist.controller.AbsViewerModeController.32
            @Override // java.lang.Runnable
            public void run() {
                AbsViewerModeController.this.g6();
            }
        };
    }

    private List<MetaMaterial> A5() {
        String string = LocalMultiProcConfig.getString(IWinkEditorResourceAPI.RECOMMEND_METAMATERIALS, null);
        if (!TextUtils.isEmpty(string)) {
            List<MetaMaterial> list = (List) new Gson().fromJson(string, new s().getType());
            LocalMultiProcConfig.putString(IWinkEditorResourceAPI.RECOMMEND_METAMATERIALS, "");
            QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "metaMaterials.size() = " + list.size());
            return list;
        }
        QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "getRecommendList metaMaterials.size() = null");
        return null;
    }

    private void B5(com.qzone.adapter.feedcomponent.s sVar) {
        i1();
        this.M0.e(sVar);
    }

    private void E5(boolean z16) {
        this.G2 = new QZoneMakeVideoPopupMenu(this.Q, this.f42940a0);
        this.Q2 = new f();
        this.R2 = new g();
        this.S2 = new h();
        this.G2.f(z16);
        this.G2.t(this.H2, this.I2);
        this.G2.w();
        this.G2.s(QZoneMakeVideoPopupMenu.f43658w, this.R2);
        this.G2.s(QZoneMakeVideoPopupMenu.f43659x, this.Q2);
        this.G2.s(QZoneMakeVideoPopupMenu.f43660y, this.S2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I5(ArrayList<MediaInfo> arrayList, MetaMaterial metaMaterial) {
        QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "jumpAndCloseDialog");
        S5();
        if (this.L2 || this.N2) {
            return;
        }
        this.L2 = true;
        T5(arrayList, metaMaterial);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M5(ArrayList<String> arrayList) {
        com.qzone.util.image.c.j(arrayList);
        qo.c.e(H(), com.qzone.util.image.c.p(H(), arrayList));
        g5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N5(ArrayList arrayList) {
        if (this.V2.size() != arrayList.size()) {
            n5(this.V2);
            RFWLog.d("QZoneWatermark", RFWLog.USR, "executeDownloadPhotoList by watermarkManger return not equal,originSize:", Integer.valueOf(this.V2.size()), ",outputSize:", Integer.valueOf(arrayList.size()));
        } else {
            RFWLog.d("QZoneWatermark", RFWLog.USR, "executeDownloadPhotoList by watermarkManger,size:", Integer.valueOf(arrayList.size()));
            n5(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O5(ArrayList arrayList) {
        if (this.V2.size() != arrayList.size()) {
            r5(this.V2, this.W2, false);
            RFWLog.d("[PhotoAlbum] BasePhotoModelController", RFWLog.USR, "executeDownloadVideoAndPhotos by watermarkManger return not equal,originSize:", Integer.valueOf(this.V2.size()), ",outputSize:", Integer.valueOf(arrayList.size()));
        } else {
            RFWLog.d("[PhotoAlbum] BasePhotoModelController", RFWLog.USR, "executeDownloadVideoAndPhotos by watermarkManger,size:", Integer.valueOf(arrayList.size()));
            r5(arrayList, this.W2, false);
        }
    }

    private void Q5(boolean z16) {
        QZoneMakeVideoPopupMenu qZoneMakeVideoPopupMenu = this.G2;
        if (qZoneMakeVideoPopupMenu == null || qZoneMakeVideoPopupMenu.f43677q != this.f42940a0) {
            if (qZoneMakeVideoPopupMenu != null) {
                QZLog.w("[PhotoAlbum]p2vMakeBlog", 1, "needToRecreatePicVideoMenu mMakeVideoPopupMenu.mAlbumType:", Integer.valueOf(qZoneMakeVideoPopupMenu.f43677q), " mAlbumType:", Integer.valueOf(this.f42940a0));
            }
            this.G2 = null;
            E5(z16);
        }
    }

    private void T5(ArrayList<MediaInfo> arrayList, MetaMaterial metaMaterial) {
        if (arrayList != null && metaMaterial != null) {
            QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "mediaInfos: " + arrayList.size() + "material: " + metaMaterial.f30533id);
        } else {
            QLog.e("[PhotoAlbum] BasePhotoModelController", 1, "error: mediaInfos: " + arrayList + "material: " + metaMaterial);
        }
        Intent intent = new Intent();
        intent.putExtra(QQWinkConstants.IS_QZONE_AUTO_TEMPLATE, true);
        intent.putExtra(QQWinkConstants.KEY_QZONE_MEDIA_INFOS, arrayList);
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QZONE");
        intent.putExtra(QQWinkConstants.KEY_QZONE_AUTO_TEMPLATE_MATERIAL, metaMaterial);
        intent.putExtra(QQWinkConstants.KEY_QZONE_AUTO_TEMPLATE_DISABLE_SYNC_QCIRCLE, zm.d.f452771a.c());
        intent.putExtra("wink_output_point", 4L);
        intent.putExtra("wink_output_route", QzoneWinkOutputRouter.ROUTE_PATH);
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQZoneTemplatePreviewFragment(this.Q, intent, 1001);
    }

    public static ArrayList<PhotoCacheData> V5(List<PhotoCacheData> list) {
        ArrayList<PhotoCacheData> arrayList = new ArrayList<>();
        for (PhotoCacheData photoCacheData : list) {
            if (!photoCacheData.isFakePhoto() && !photoCacheData.isGif() && (photoCacheData.videoflag != 1 || photoCacheData.videodata.validVideoTime <= f42867b3)) {
                arrayList.add(photoCacheData);
            }
        }
        return arrayList;
    }

    private void Y5(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        HashMap hashMap = new HashMap(2);
        if (arrayList != null && arrayList.size() != 0) {
            hashMap.put("photoCounts", String.valueOf(arrayList.size()));
        }
        if (arrayList2 != null && arrayList2.size() != 0) {
            hashMap.put("videoCounts", String.valueOf(arrayList2.size()));
        }
        if (NetworkState.isWifiConn()) {
            hashMap.put("wifiDownload", String.valueOf(1));
        } else {
            hashMap.put("noWifiDownload", String.valueOf(1));
        }
        ReportUtils.b("batchDownload", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z5() {
        RecommendPhotos recommendPhotos = this.J2;
        if (recommendPhotos != null) {
            this.f43010y0.K1(this.f43008x0.ownerUin, recommendPhotos, new i());
        }
    }

    private AlbumDialog a6(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnClickListener onClickListener3) {
        AlbumDialog albumDialog = new AlbumDialog(this.Q, R.style.qZoneInputDialog);
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogMessageDownloadPhotoAndVideo", "\u9ec4\u94bb\u7279\u6743\u5c0a\u4eab\u6279\u91cf\u4e0b\u8f7d\u89c6\u9891\uff0c\u5f00\u901a\u9ec4\u94bb\u5373\u53ef\u7acb\u5373\u4f53\u9a8c");
        String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogMessageDownloadPhotoAndVideoFirstBtn", "\u4ec5\u4e0b\u8f7d\u7167\u7247");
        String config3 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogMessageDownloadPhotoAndVideoSecondBtn", "\u5f00\u901a\u9ec4\u94bb/\u6279\u91cf\u4e0b\u8f7d\u89c6\u9891");
        albumDialog.setContentView(R.layout.bhq);
        albumDialog.X(3);
        albumDialog.setTitle(I(R.string.ge5));
        albumDialog.Q(config);
        if (onClickListener == null) {
            albumDialog.S(8);
            albumDialog.c0(R.drawable.gcq);
            albumDialog.b0(config3, onClickListener2).W(com.qzone.util.l.a(R.string.j6l), onClickListener3);
        } else {
            albumDialog.c0(R.drawable.gcq);
            albumDialog.R(config2, onClickListener).b0(config3, onClickListener2).W(com.qzone.util.l.a(R.string.j6l), onClickListener3);
        }
        albumDialog.setOnDismissListener(new x());
        albumDialog.show();
        return albumDialog;
    }

    private void g5() {
        g1();
        this.W1.notifyAdapter(B1());
        Z0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g6() {
        List<MetaMaterial> A5 = A5();
        if (A5 != null) {
            QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "recommendList.size = " + A5.size());
            if (!A5.isEmpty()) {
                p5(this.O2, A5.get(0));
                return;
            } else {
                com.qzone.album.env.common.a.m().U(R.string.f2192665y);
                S5();
                return;
            }
        }
        if (!this.M2 && this.P2 < 10) {
            this.P2++;
            QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "recommendList = null and curLoaddingTimes = " + this.P2);
            RFWThreadManager.getUIHandler().postDelayed(this.f42868a3, 1000L);
            return;
        }
        p5(this.O2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i5() {
        if (!e1()) {
            com.qzone.album.env.common.a.m().U(R.string.gdc);
            return;
        }
        if (this.H0 == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (PhotoCacheData photoCacheData : this.H0) {
            if (photoCacheData instanceof PhotoCacheData) {
                PhotoCacheData photoCacheData2 = photoCacheData;
                if (this.f43008x0.isAlbumCreator() || photoCacheData2.uploadUin == com.qzone.album.env.common.a.m().s()) {
                    arrayList.add(photoCacheData2.lloc);
                    VideoInfo videoInfo = photoCacheData2.videodata;
                    if (videoInfo != null && !TextUtils.isEmpty(videoInfo.videoId)) {
                        arrayList2.add(photoCacheData2.videodata.videoId);
                    }
                }
            }
        }
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            h5(this.T, arrayList, arrayList2);
            s4(I(R.string.gj_));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j5() {
        if (this.U2 >= 1) {
            w5();
            return;
        }
        if (this.W2.size() == 0) {
            v5();
        } else if (this.V2.size() == 0) {
            this.X2 = a6(null, new z(), new a());
        } else {
            this.X2 = a6(new b(), new c(), new d());
        }
    }

    public static void q5(ArrayList<String> arrayList, i.f fVar, DialogInterface.OnClickListener onClickListener) {
        QLog.d("QzonePhotoUtil", 1, "downloadVideo: " + com.qzone.util.f.c(arrayList));
        com.qzone.misc.network.downloader.i.u().p(arrayList, fVar, onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r5(ArrayList<String> arrayList, ArrayList<String> arrayList2, boolean z16) {
        Y5(arrayList, arrayList2);
        if (arrayList.size() != 0) {
            DownloadQueue.j().b(new PhotoDownloadQueueTask(arrayList));
        }
        if (arrayList2.size() != 0) {
            DownloadQueue.j().b(new VideoDownloadQueueTask(arrayList2));
        }
        o5();
    }

    private void s5(String str, String str2, INetEngineListener iNetEngineListener) {
        t5(str, ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).getDownloadBasePath() + ImageContentType.IMAGE_PREFIX, str2, iNetEngineListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v5() {
        if (oo.b.j()) {
            oo.b.f(null, 2, this.V2, new b.InterfaceC10931b() { // from class: com.qzone.album.business.photolist.controller.b
                @Override // oo.b.InterfaceC10931b
                public final void a(ArrayList arrayList) {
                    AbsViewerModeController.this.N5(arrayList);
                }
            });
        } else {
            n5(this.V2);
        }
    }

    private void w5() {
        if (this.V2.size() == 0) {
            r5(this.V2, this.W2, false);
        } else if (oo.b.j()) {
            oo.b.f(null, 2, this.V2, new b.InterfaceC10931b() { // from class: com.qzone.album.business.photolist.controller.a
                @Override // oo.b.InterfaceC10931b
                public final void a(ArrayList arrayList) {
                    AbsViewerModeController.this.O5(arrayList);
                }
            });
        } else {
            r5(this.V2, this.W2, false);
        }
    }

    private List<LocalMediaInfo> y5(List<MediaInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (MediaInfo mediaInfo : list) {
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            localMediaInfo.mMediaType = mediaInfo.getMediaType() == MediaType.LOCAL_VIDEO ? 1 : 0;
            localMediaInfo.mediaWidth = mediaInfo.getWidth();
            localMediaInfo.mediaHeight = mediaInfo.getHeight();
            localMediaInfo.path = mediaInfo.getLocalMediaPath();
            localMediaInfo.mDuration = mediaInfo.getDuration();
            localMediaInfo.mMimeType = MimeTypesTools.getMimeType(H(), FileManagerUtil.getFileName(mediaInfo.getLocalMediaPath()));
            arrayList.add(localMediaInfo);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C5(View view, boolean z16) {
        if (this.X1) {
            return;
        }
        if (G5()) {
            com.qzone.album.env.common.a.m().V(I(R.string.f173015gh3));
            return;
        }
        if (this.G2 == null) {
            E5(z16);
        } else {
            Q5(z16);
        }
        this.G2.g();
        Activity activity = this.Q;
        if (activity != null && !activity.isFinishing()) {
            this.G2.v(view);
        }
        com.qzone.album.env.common.a.m().P(326, 2, "32", true, z5());
    }

    protected void D5() {
        com.qzone.album.business.photolist.ui.interactingbar.a aVar = this.J1;
        if (aVar != null) {
            aVar.d(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F5(AbsListView absListView, int i3, int i16, int i17) {
        if (this.f42970k0 != 0) {
            com.qzone.album.business.photolist.ui.interactingbar.a aVar = this.J1;
            if (aVar != null) {
                aVar.d(false);
                return;
            }
            return;
        }
        if (i3 == 0) {
            if (P2()) {
                return;
            }
            List<PhotoCacheData> list = this.f43003v0;
            if (list != null && list.size() > 0) {
                b6();
                return;
            }
            List<PhotoCacheData> list2 = this.f43003v0;
            if (list2 != null && list2.size() > 0) {
                b6();
                return;
            }
            com.qzone.album.business.photolist.ui.interactingbar.a aVar2 = this.J1;
            if (aVar2 != null) {
                aVar2.d(false);
                return;
            }
            return;
        }
        if (absListView.getChildAt(0) != null) {
            int top = absListView.getChildAt(0).getTop();
            int i18 = this.D2;
            if (i3 != i18) {
                if (i3 > i18) {
                    D5();
                } else {
                    b6();
                }
                this.E2 = top;
            } else if (Math.abs(top - this.E2) > this.F2) {
                int i19 = this.E2;
                if (top > i19) {
                    b6();
                } else if (top < i19) {
                    D5();
                }
                this.E2 = top;
            }
            this.D2 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void G2(com.qzone.adapter.feedcomponent.s sVar) {
        super.G2(sVar);
        if (sVar.getObjectData() instanceof QZonePhotoListRequest.a) {
            this.J2 = ((QZonePhotoListRequest.a) sVar.getObjectData()).f43968j;
        }
    }

    protected boolean G5() {
        Iterator<PhotoCacheData> it = this.f43003v0.iterator();
        while (it.hasNext()) {
            if (!it.next().isFakePhoto()) {
                return false;
            }
        }
        return true;
    }

    protected boolean H5() {
        for (PhotoCacheData photoCacheData : this.f43003v0) {
            if (!photoCacheData.isFakePhoto() && photoCacheData.videoflag != 1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.b, i4.a
    public void K(com.qzone.adapter.feedcomponent.s sVar, int i3) {
        super.K(sVar, i3);
        if (i3 != 1000083) {
            return;
        }
        B5(sVar);
    }

    public void P5(String str, ArrayList<PhotoCacheData> arrayList) {
        VideoInfo videoInfo;
        ArrayList arrayList2 = new ArrayList();
        if (!FeedGlobalEnv.g().isNetworkAvailable(null)) {
            com.qzone.album.env.common.a.m().V(I(R.string.ci5));
            x5();
            return;
        }
        if (arrayList.size() <= 0) {
            x5();
            return;
        }
        LpReportInfo_pf00064.allReport(326, 2, 38);
        ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            PhotoCacheData photoCacheData = arrayList.get(i3);
            if (photoCacheData.videoflag == 1 && (videoInfo = photoCacheData.videodata) != null && videoInfo.videoUrl != null) {
                arrayList2.add(Integer.valueOf(i3));
                arrayList4.add(photoCacheData.videodata.videoUrl.url);
                if (TextUtils.isEmpty(photoCacheData.videodata.videoUrl.url)) {
                    com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "Recommend cache.videodata.videoUrl.url is null");
                }
            } else {
                PictureUrl picUrlDec = photoCacheData.picItem.getPicUrlDec();
                if (picUrlDec != null && !TextUtils.isEmpty(picUrlDec.url)) {
                    arrayList3.add(picUrlDec.url);
                } else {
                    com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "Recommend cache.picItem.getPicUrlDec() is null");
                }
            }
        }
        if (arrayList3.size() == 0 && arrayList4.size() == 0) {
            x4(R.string.gih);
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "Recommend mPiclist.size() == 0 && mVideolist.size() is null");
            return;
        }
        s4(I(R.string.gii));
        Dialog dialog = this.V0;
        if (dialog != null) {
            dialog.setOnDismissListener(new l(arrayList3));
        }
        if (arrayList3.size() <= 0 && arrayList4.size() > 0) {
            com.qzone.album.env.common.a.m().J(new Runnable() { // from class: com.qzone.album.business.photolist.controller.AbsViewerModeController.23

                /* compiled from: P */
                /* renamed from: com.qzone.album.business.photolist.controller.AbsViewerModeController$23$b */
                /* loaded from: classes39.dex */
                class b implements DialogInterface.OnClickListener {
                    b() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        AbsViewerModeController.this.i1();
                        AbsViewerModeController.this.x5();
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbsViewerModeController.this.T2 = true;
                    AbsViewerModeController.q5(arrayList4, new a(), new b());
                }

                /* compiled from: P */
                /* renamed from: com.qzone.album.business.photolist.controller.AbsViewerModeController$23$a */
                /* loaded from: classes39.dex */
                class a implements i.f {
                    a() {
                    }

                    @Override // com.qzone.misc.network.downloader.i.f
                    public void A(String str, int i3, String str2) {
                        AbsViewerModeController.this.T2 = false;
                        com.qzone.album.env.common.a.m().W(AbsViewerModeController.this.getResources().getString(R.string.gih), 1);
                        AbsViewerModeController.this.i1();
                        com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "Recommend downloadVideo fail");
                        AbsViewerModeController.this.x5();
                    }

                    @Override // com.qzone.misc.network.downloader.i.f
                    public void y(ArrayList<String> arrayList) {
                        AbsViewerModeController.this.L5(arrayList, true);
                        AbsViewerModeController.this.x5();
                    }

                    @Override // com.qzone.misc.network.downloader.i.f
                    public void x(String str) {
                    }

                    @Override // com.qzone.misc.network.downloader.i.f
                    public void z(String str) {
                    }
                }
            });
        } else {
            com.qzone.album.env.common.a.m().J(new AnonymousClass24(arrayList3, arrayList4, arrayList2));
        }
    }

    public void S5() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.album.business.photolist.controller.AbsViewerModeController.29
            @Override // java.lang.Runnable
            public void run() {
                AbsViewerModeController.this.i1();
            }
        });
    }

    protected void U5() {
        if (this.Z2 == null) {
            this.Z2 = new e();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_h5pay_callback");
            Activity activity = this.Q;
            if (activity != null) {
                activity.registerReceiver(this.Z2, intentFilter);
            }
        }
    }

    protected ArrayList<PhotoCacheData> W5() {
        int i3;
        List<PhotoCacheData[]> list = this.f43000u0;
        if (list != null && list.size() > 0) {
            this.f43000u0.clear();
        }
        ArrayList<PhotoCacheData> arrayList = new ArrayList<>();
        for (PhotoCacheData photoCacheData : this.f43003v0) {
            if (!photoCacheData.isFakePhoto() && photoCacheData.videoflag != 1 && (i3 = photoCacheData.picItem.flag) != 32 && i3 != 16) {
                arrayList.add(photoCacheData);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X5() {
        List<PhotoCacheData[]> list = this.f43000u0;
        if (list != null && list.size() > 0) {
            this.f43000u0.clear();
        }
        ArrayList arrayList = new ArrayList();
        for (PhotoCacheData photoCacheData : this.f43003v0) {
            if (!photoCacheData.isFakePhoto()) {
                arrayList.add(photoCacheData);
            }
        }
        com.qzone.album.business.photolist.adapter.a aVar = (com.qzone.album.business.photolist.adapter.a) B1();
        if (aVar == null) {
            return;
        }
        aVar.G(this.f42991r0);
        W3(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b6() {
        com.qzone.album.business.photolist.ui.interactingbar.a aVar = this.J1;
        if (aVar != null) {
            aVar.h(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c6() {
        Activity activity;
        BroadcastReceiver broadcastReceiver = this.Z2;
        if (broadcastReceiver == null || (activity = this.Q) == null) {
            return;
        }
        activity.unregisterReceiver(broadcastReceiver);
        this.Z2 = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d6(boolean z16, int i3) {
        List<PhotoCacheData> list = this.f43003v0;
        if (list != null && list.size() > 0) {
            if (i3 == 1) {
                C1(this.f42970k0).d(new q(), this.Q.getResources().getInteger(android.R.integer.config_shortAnimTime), z16);
            } else {
                C1(this.f42970k0).c(z16);
            }
            if (this.W1.z2() != null) {
                this.W1.z2().A();
                this.W1.z2().z();
                return;
            }
            return;
        }
        com.qzone.album.business.photolist.ui.interactingbar.a aVar = this.J1;
        if (aVar != null) {
            aVar.d(false);
        }
        if (this.W1.z2() != null) {
            this.W1.z2().F();
        }
        C1(this.f42970k0).c(z16);
    }

    protected void e6(int i3) {
        C1(this.f42970k0).q(i3);
        C1(this.f42970k0).r(this.F0.size());
        C1(this.f42970k0).o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f6(int i3) {
        com.qzone.album.business.photolist.ui.interactingbar.a aVar = this.J1;
        if (aVar == null) {
            return;
        }
        if (i3 != 1 && i3 != 6) {
            C1(this.f42970k0).q(i3);
            C1(this.f42970k0).r(this.F0.size());
            this.J1.d(false);
        } else if (aVar.c() == 8) {
            e6(i3);
        } else {
            this.J1.e(true, new k(i3), this.Q.getResources().getInteger(android.R.integer.config_shortAnimTime));
        }
    }

    protected void h5(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        com.qzone.album.base.Service.a aVar = this.f43010y0;
        if (aVar != null) {
            aVar.A(str, arrayList, arrayList2, this.f42981n2);
        }
    }

    protected void k5(String str, ArrayList<String> arrayList) {
        this.f43010y0.I0(this.T, str, arrayList, this.f42981n2);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void n1(Intent intent) {
        BusinessAlbumInfo businessAlbumInfo;
        if (!e1()) {
            com.qzone.album.env.common.a.m().U(R.string.gdc);
            return;
        }
        if (intent == null || (businessAlbumInfo = (BusinessAlbumInfo) intent.getParcelableExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO)) == null) {
            return;
        }
        String str = businessAlbumInfo.mAlbumId;
        if (TextUtils.isEmpty(str) || this.H0 == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<PhotoCacheData> it = this.H0.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().lloc);
        }
        this.V1 = true;
        k5(str, arrayList);
        s4(I(R.string.gji));
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void n4() {
        String format;
        String format2;
        AlbumCacheData albumCacheData = this.f43008x0;
        if (albumCacheData == null) {
            return;
        }
        boolean isSharingAlbumOnServer = albumCacheData.isSharingAlbumOnServer();
        int i3 = R.string.gmb;
        if (isSharingAlbumOnServer && !this.f43008x0.isSharingAlbumCreator()) {
            AlbumDialog albumDialog = new AlbumDialog(this.Q, R.style.qZoneInputDialog);
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogMessageDeletePhotoAndVideo", "\u53ea\u80fd\u5220\u9664\u81ea\u5df1\u7684\u56fe\u7247\u548c\u89c6\u9891");
            albumDialog.setContentView(R.layout.bhq);
            albumDialog.X(2);
            albumDialog.setTitle(I(R.string.gmb));
            albumDialog.Q(config);
            albumDialog.a0(com.qzone.util.l.a(R.string.ket), new t());
            albumDialog.Y(com.qzone.util.l.a(R.string.j6l), new u());
            albumDialog.show();
            return;
        }
        List<PhotoCacheData> list = this.H0;
        int size = list != null ? list.size() : 0;
        if (size > 0) {
            AlbumDialog albumDialog2 = new AlbumDialog(this.Q, R.style.qZoneInputDialog);
            albumDialog2.setContentView(R.layout.bhq);
            albumDialog2.X(2);
            int i16 = k3() ? R.string.gmb : R.string.gmc;
            boolean isQzoneVip = LoginData.getInstance().isQzoneVip();
            int i17 = R.string.gmq;
            if (isQzoneVip) {
                Resources resources = getResources();
                if (!k3()) {
                    i17 = R.string.gmd;
                }
                format = String.format(resources.getString(i17), Integer.valueOf(size));
            } else {
                Resources resources2 = getResources();
                if (!k3()) {
                    i17 = R.string.gma;
                }
                format = String.format(resources2.getString(i17), Integer.valueOf(size));
            }
            Iterator<PhotoCacheData> it = this.H0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i3 = i16;
                    break;
                }
                PhotoCacheData next = it.next();
                if (next != null && (next instanceof PhotoCacheData) && next.isVideo()) {
                    format = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogMessageDeleteChooseVideo", "\u786e\u5b9a\u5220\u9664\u9009\u4e2d\u7684\u89c6\u9891\uff1f\u89c6\u9891\u5220\u9664\u540e\u65e0\u6cd5\u4ece\u56de\u6536\u7ad9\u6062\u590d");
                    break;
                }
            }
            if (k3()) {
                format2 = I(i3);
            } else {
                format2 = String.format(getResources().getString(i3), Integer.valueOf(size));
            }
            albumDialog2.setTitle(format2);
            albumDialog2.Q(format);
            albumDialog2.Z(com.qzone.util.l.a(R.string.j0q), getResources().getColor(R.color.f157028hz), new v());
            albumDialog2.Y(com.qzone.util.l.a(R.string.j6l), new w());
            albumDialog2.show();
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void q3() {
        com.qzone.album.env.common.a.m().P(326, 2, WadlProxyConsts.OPER_TYPE_MONITOR, true, z5());
        u4.a.z().j(this.Q);
        ArrayList<QzonePhotoInfo> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.H0.size(); i3++) {
            QzonePhotoInfo qzonePhotoInfo = new QzonePhotoInfo();
            PhotoCacheData photoCacheData = this.H0.get(i3);
            qzonePhotoInfo.mAlbumId = photoCacheData.albumid;
            PictureItem pictureItem = photoCacheData.picItem;
            PictureUrl pictureUrl = pictureItem.bigUrl;
            qzonePhotoInfo.mBigUrl = pictureUrl.url;
            qzonePhotoInfo.mBigHeight = pictureUrl.height;
            qzonePhotoInfo.mBigWidth = pictureUrl.width;
            qzonePhotoInfo.mlloc = pictureItem.lloc;
            arrayList.add(qzonePhotoInfo);
        }
        u5.b.o0("key_is_dynamicalbum_need_preload", true);
        com.qzone.album.base.Service.e.e().s(true);
        com.qzone.album.base.Service.e.e().q(arrayList);
        yo.d.d(o7.a.f422174a, this.P, null);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void s1(boolean z16, BusinessAlbumInfo businessAlbumInfo, n5.a aVar, Handler handler) {
        ArrayList<NetImageInfo> arrayList;
        List<PhotoCacheData> list = this.H0;
        if (list == null || list.size() < 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            Iterator<PhotoCacheData> it = this.H0.iterator();
            while (it.hasNext()) {
                arrayList.add(NetImageInfo.create(it.next()));
            }
        }
        ArrayList<NetImageInfo> arrayList2 = arrayList;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        if (z16) {
            u4.a.z().p(this.Q, this.S, arrayList2);
        } else {
            u4.a.z().r(arrayList2, businessAlbumInfo, this.S.longValue(), aVar, handler);
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void t1() {
        com.qzone.album.env.common.a.m().R("460", "1", "");
        if (this.H0.size() <= 0) {
            return;
        }
        U5();
        this.V2.clear();
        this.W2.clear();
        for (PhotoCacheData photoCacheData : this.H0) {
            if (photoCacheData.videoflag == 1) {
                if (photoCacheData.getDownloadVideoUrl() != null) {
                    String downloadVideoUrl = photoCacheData.getDownloadVideoUrl();
                    if (TextUtils.isEmpty(downloadVideoUrl)) {
                        com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "cache.videodata.videoUrl.url is null");
                        com.qzone.album.env.common.a.m().V(com.qzone.util.l.a(R.string.j0u));
                    } else {
                        this.W2.add(downloadVideoUrl);
                    }
                } else {
                    com.qzone.album.env.common.a.m().V(com.qzone.util.l.a(R.string.j0s));
                }
            } else {
                PictureUrl downloadUrl = photoCacheData.picItem.getDownloadUrl();
                if (downloadUrl != null && !TextUtils.isEmpty(downloadUrl.url)) {
                    this.V2.add(yo.f.f(downloadUrl.url, "t"));
                    QLog.d("QzonePhotoUtil", 1, "downloadPhoto: " + downloadUrl.url);
                } else {
                    QLog.d("QzonePhotoUtil", 1, "downloadPhoto: url is empty");
                }
            }
        }
        this.U2 = com.qzone.album.env.common.a.m().E(this.S.toString());
        if (QZonePermission.requestStoragePermission(this.Q, new y(), QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
            j5();
        }
    }

    public void t5(final String str, final String str2, final String str3, final INetEngineListener iNetEngineListener) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.album.business.photolist.controller.AbsViewerModeController.34
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
                    QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "req.mReqUrl = " + httpNetReq.mReqUrl);
                    httpNetReq.mHttpMethod = 0;
                    httpNetReq.mOutPath = str4;
                    QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "req.mOutPath = " + httpNetReq.mOutPath);
                    httpNetReq.mContinuErrorLimit = 2;
                    ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendReq(httpNetReq);
                    return;
                }
                iNetEngineListener.getFilePath(str4);
                iNetEngineListener.isSuccess(true);
            }

            /* compiled from: P */
            /* renamed from: com.qzone.album.business.photolist.controller.AbsViewerModeController$34$a */
            /* loaded from: classes39.dex */
            class a implements com.tencent.mobileqq.transfile.INetEngineListener {
                a() {
                }

                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onResp(NetResp netResp) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("netResp.mResult isSuccess = ");
                    sb5.append(netResp.mResult == 0);
                    QLog.d("[PhotoAlbum] BasePhotoModelController", 1, sb5.toString());
                    if (netResp.mResult == 0) {
                        iNetEngineListener.isSuccess(true);
                        iNetEngineListener.getFilePath(netResp.mReq.mOutPath);
                    } else {
                        iNetEngineListener.isSuccess(false);
                        iNetEngineListener.getFilePath("");
                    }
                }

                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
                }
            }
        }, 64, null, false);
    }

    protected void u5(int i3) {
        ArrayList<PhotoCacheData> W5;
        Y3(i3);
        this.f42970k0 = i3;
        if (this.B1 == 1) {
            this.B1 = 0;
            super.V3(QZoneAlbumUtil.u(this.f42940a0, 0, this, null, P2(), this.f42943b0));
            this.W1.getListView().setAdapter((ListAdapter) B1());
        }
        ((com.qzone.album.business.photolist.adapter.a) B1()).y(true);
        ((com.qzone.album.business.photolist.adapter.a) B1()).A(V2(this.f42970k0));
        ((com.qzone.album.business.photolist.adapter.a) B1()).x(true);
        ((com.qzone.album.business.photolist.adapter.a) B1()).B(com.qzone.album.env.common.a.m().s() == this.S.longValue());
        ((com.qzone.album.business.photolist.adapter.a) B1()).z(this.O0);
        ((com.qzone.album.business.photolist.adapter.a) B1()).F(i3);
        if (i3 == 3) {
            com.qzone.album.env.common.a.m().P(326, 2, WadlProxyConsts.OPER_TYPE_APK_SIGN, true, z5());
            this.J0 = BasePhotoModelController.B2;
            if (k3()) {
                return;
            } else {
                W5 = W5();
            }
        } else if (i3 != 7) {
            W5 = null;
        } else {
            this.J0 = BasePhotoModelController.B2;
            if (k3()) {
                return;
            } else {
                W5 = W5();
            }
        }
        if (W5 != null && W5.size() > 0) {
            if (((com.qzone.album.business.photolist.adapter.a) B1()) == null) {
                this.f42970k0 = 0;
                return;
            }
            ((com.qzone.album.business.photolist.adapter.a) B1()).G(this.f42991r0);
            this.f43006w0 = new ArrayList(this.f43003v0);
            W3(W5);
            this.f42950d1 = true;
            this.f42953e1 = true;
            K1().A(false);
            G4(null, true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.W1.getListView().getLayoutParams();
            layoutParams.addRule(3, R.id.f166672ha0);
            this.W1.getListView().setLayoutParams(layoutParams);
            this.W1.getListView().setCoverMode(false);
            u0();
            M4(true);
            if (this.H0 == null) {
                this.H0 = new ArrayList();
            } else {
                g1();
            }
            i4();
            Z3();
            C1(this.f42970k0).t(this.H0.size());
            if (p2() == 4 && i3()) {
                y0(7);
            }
            com.qzone.album.business.photolist.ui.interactingbar.a aVar = this.J1;
            if (aVar != null) {
                aVar.d(false);
            }
            if (this.W1.z2() != null) {
                this.W1.z2().b();
                this.W1.z2().a();
                this.W1.z2().s();
                this.W1.z2().t();
                return;
            }
            return;
        }
        com.qzone.album.env.common.a.m().U(R.string.gip);
        this.f42970k0 = 0;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void x3() {
        if (this.H0.size() <= 0) {
            return;
        }
        u4.a.z().W(this.Q, this.P, I(R.string.gjk), this.T);
    }

    public void x5() {
        DownloadQueue.j().f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String z5() {
        if (i3()) {
            return "travel";
        }
        if (e3()) {
            return HippyNestedScrollComponent.PRIORITY_PARENT;
        }
        if (Y2()) {
            return "lover";
        }
        return "common";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class r implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f42925a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f42926b;

        r(MetaMaterial metaMaterial, ArrayList arrayList) {
            this.f42925a = metaMaterial;
            this.f42926b = arrayList;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean z16) {
            if (!z16) {
                AbsViewerModeController.this.i1();
                com.qzone.album.env.common.a.m().U(R.string.f2192665y);
                QLog.e("[PhotoAlbum] BasePhotoModelController", 1, "download template is failed");
            } else {
                AbsViewerModeController.this.K2.getDownloadFolder(this.f42925a);
                AbsViewerModeController.this.I5(this.f42926b, this.f42925a);
            }
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L5(ArrayList<String> arrayList, boolean z16) {
        this.T2 = false;
        if (!z16) {
            g5();
        }
        com.qzone.util.image.c.j(arrayList);
        ArrayList<LocalMediaInfo> p16 = com.qzone.util.image.c.p(H(), arrayList);
        i1();
        if (p16.size() == 0) {
            com.qzone.album.env.common.a.m().U(R.string.gin);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("qzone_slide_show_matters", p16);
        bundle.putInt("edit_video_type", 10001);
        bundle.putInt("qq_sub_business_id", 3);
        bundle.putInt("qqstory_slide_show_scene", 22);
        bundle.putInt("entrance_qzone_p2v", 17);
        ((IJumpUtil) QRoute.api(IJumpUtil.class)).jumpToSlideShowEditVideoActivityForQzone(H(), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m5(ArrayList<MediaInfo> arrayList, ArrayList<LocalMediaInfo> arrayList2) {
        this.M2 = false;
        g6();
    }

    private void n5(ArrayList<String> arrayList) {
        Y5(arrayList, null);
        DownloadQueue.j().b(new PhotoDownloadQueueTask(arrayList));
        o5();
    }

    private void o5() {
        this.Y2 = false;
        this.V2.clear();
        this.W2.clear();
        h1();
    }

    public void l5(String str, ArrayList<PhotoCacheData> arrayList) {
        VideoUrl videoUrl;
        PictureUrl pictureUrl;
        VideoInfo videoInfo;
        this.N2 = false;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!FeedGlobalEnv.g().isNetworkAvailable(null)) {
            com.qzone.album.env.common.a.m().V(I(R.string.ci5));
            x5();
            return;
        }
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                PhotoCacheData photoCacheData = arrayList.get(i3);
                if (photoCacheData.videoflag == 1 && (videoInfo = photoCacheData.videodata) != null && videoInfo.videoUrl != null) {
                    arrayList3.add(Integer.valueOf(i3));
                    arrayList5.add(photoCacheData.videodata.videoUrl.url);
                    if (TextUtils.isEmpty(photoCacheData.videodata.videoUrl.url)) {
                        com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "Recommend cache.videodata.videoUrl.url is null");
                    }
                } else {
                    PictureUrl picUrlDec = photoCacheData.picItem.getPicUrlDec();
                    if (picUrlDec != null && !TextUtils.isEmpty(picUrlDec.url)) {
                        arrayList4.add(picUrlDec.url);
                    } else {
                        com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "Recommend cache.picItem.getPicUrlDec() is null");
                    }
                }
            }
            if (arrayList4.size() + arrayList5.size() != arrayList.size()) {
                x4(R.string.gih);
                com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "mPiclist.size() + mVideolist.size() != p2vRecommendList.size()");
                return;
            }
            s4(I(R.string.f21968673));
            n2().setOnDismissListener(new m());
            QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "showWaittingDialog() has shown");
            Dialog dialog = this.V0;
            if (dialog != null) {
                dialog.setOnDismissListener(new n(arrayList4));
            }
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                if (arrayList.size() > 0 && arrayList.get(i16) != null) {
                    PhotoCacheData photoCacheData2 = arrayList.get(i16);
                    PictureItem pictureItem = photoCacheData2.picItem;
                    if (pictureItem != null && (pictureUrl = pictureItem.downloadUrl) != null && !TextUtils.isEmpty(pictureUrl.url)) {
                        QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "photoCacheData.picItem.downloadUrl.url = " + photoCacheData2.picItem.downloadUrl.url);
                        s5(photoCacheData2.picItem.downloadUrl.url, photoCacheData2.picItem.albumId + "_" + photoCacheData2.picItem.lloc + ".jpeg", new o(arrayList2, arrayList, i16, photoCacheData2));
                    } else {
                        VideoInfo videoInfo2 = photoCacheData2.videodata;
                        if (videoInfo2 != null && (videoUrl = videoInfo2.downloadVideoUrl) != null && !TextUtils.isEmpty(videoUrl.url)) {
                            QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "photoCacheData.videodata.downloadVideoUrl.url = " + photoCacheData2.videodata.downloadVideoUrl.url);
                            s5(photoCacheData2.videodata.downloadVideoUrl.url, photoCacheData2.videodata.albumid + "_" + photoCacheData2.videodata.lloc + ".mp4", new p(arrayList2, arrayList, i16, photoCacheData2));
                        } else {
                            QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "photoCacheData.picItem.downloadUrl.url = null and photoCacheData.videodata.downloadVideoUrl.url = null");
                            S5();
                            com.qzone.album.env.common.a.m().W(getResources().getString(R.string.gih), 1);
                        }
                    }
                }
            }
            return;
        }
        x5();
    }

    private void p5(ArrayList<MediaInfo> arrayList, MetaMaterial metaMaterial) {
        if (metaMaterial == null) {
            QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "downloadTemplateAndJump material == null");
            I5(arrayList, null);
        } else {
            this.K2.downLoadOneResDirect(metaMaterial, new r(metaMaterial, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R5(boolean z16, String str, String str2, String str3) {
        PhotoCacheData photoCacheData;
        if (!z16) {
            com.qzone.album.env.common.a.m().W(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCommentFailWait", "\u8bc4\u8bba\u5931\u8d25,\u8bf7\u7a0d\u5019\u518d\u8bd5"), 1);
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.f43003v0.size()) {
                photoCacheData = null;
                break;
            } else {
                if (this.f43003v0.get(i3).albumid.equals(str) && this.f43003v0.get(i3).lloc.equals(str2)) {
                    photoCacheData = this.f43003v0.get(i3);
                    break;
                }
                i3++;
            }
        }
        if (photoCacheData != null && photoCacheData.appid != 311) {
            photoCacheData.cmtnum++;
            B1().notifyDataSetChanged();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < this.f43003v0.size(); i16++) {
            if (this.f43003v0.get(i16).pssUgcKey.equals(str3)) {
                arrayList.add(this.f43003v0.get(i16));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            PhotoCacheData photoCacheData2 = (PhotoCacheData) it.next();
            if (photoCacheData2 != null) {
                photoCacheData2.cmtnum++;
            }
        }
        B1().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x013a A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x013c A[Catch: all -> 0x015d, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0006, B:7:0x000a, B:8:0x000d, B:10:0x001d, B:14:0x0035, B:16:0x0048, B:19:0x0052, B:21:0x0056, B:23:0x009c, B:25:0x0106, B:29:0x013c, B:32:0x00a8, B:35:0x00b2, B:37:0x00b6, B:39:0x00fc), top: B:4:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void J5(ArrayList<String> arrayList, boolean z16, final ArrayList<MediaInfo> arrayList2, ArrayList<PhotoCacheData> arrayList3, int i3) {
        ArrayList<LocalMediaInfo> arrayList4;
        this.T2 = true;
        if (!z16) {
            g5();
        }
        ArrayList<LocalMediaInfo> p16 = com.qzone.util.image.c.p(H(), arrayList);
        if (p16.size() == 0) {
            com.qzone.album.env.common.a.m().U(R.string.gin);
            S5();
            QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "selectedDynamicMatter.size() == 0");
            return;
        }
        PhotoCacheData photoCacheData = arrayList3.get(i3);
        if (!TextUtils.isEmpty(photoCacheData.picItem.downloadUrl.url)) {
            PictureItem pictureItem = photoCacheData.picItem;
            if (p16.get(0) != null && pictureItem != null && pictureItem.downloadUrl != null) {
                MediaType mediaType = MediaType.QZONE_IMAGE;
                String str = pictureItem.albumId;
                int i16 = p16.get(0).mediaWidth;
                int i17 = p16.get(0).mediaHeight;
                String str2 = p16.get(0).path;
                String str3 = pictureItem.lloc;
                PictureUrl pictureUrl = pictureItem.downloadUrl;
                String str4 = pictureUrl.url;
                arrayList2.add(new MediaInfo(mediaType, str, i16, i17, str2, str3, str4, pictureUrl.width, pictureUrl.height, str4, pictureItem.sloc, 0L));
                if (TextUtils.isEmpty(pictureItem.albumId)) {
                    QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "picItem.albumId is empty");
                }
            }
        } else {
            VideoInfo videoInfo = photoCacheData.videodata;
            if (p16.get(0) != null && videoInfo != null && videoInfo.downloadVideoUrl != null) {
                MediaType mediaType2 = MediaType.QZONE_VIDEO;
                String str5 = videoInfo.albumid;
                int i18 = p16.get(0).mediaWidth;
                int i19 = p16.get(0).mediaHeight;
                String str6 = p16.get(0).path;
                String str7 = videoInfo.lloc;
                String str8 = videoInfo.downloadVideoUrl.url;
                arrayList4 = p16;
                arrayList2.add(new MediaInfo(mediaType2, str5, i18, i19, str6, str7, str8, videoInfo.width, videoInfo.height, str8, videoInfo.sloc, videoInfo.videoTime));
                if (TextUtils.isEmpty(videoInfo.albumid)) {
                    QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "videodata.albumid is empty");
                }
                QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "mediaInfos.size() = " + arrayList2.size() + ", p2vRecommendList.size() = " + arrayList3.size());
                if (arrayList2.size() == arrayList3.size()) {
                    return;
                }
                this.O2 = arrayList2;
                ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).requestProfileResourceMeta4QZone(y5(arrayList2));
                final ArrayList<LocalMediaInfo> arrayList5 = arrayList4;
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.album.business.photolist.controller.AbsViewerModeController.30
                    @Override // java.lang.Runnable
                    public void run() {
                        AbsViewerModeController.this.m5(arrayList2, arrayList5);
                    }
                });
                return;
            }
        }
        arrayList4 = p16;
        QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "mediaInfos.size() = " + arrayList2.size() + ", p2vRecommendList.size() = " + arrayList3.size());
        if (arrayList2.size() == arrayList3.size()) {
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void r3() {
        VideoInfo videoInfo;
        LpReportInfo_pf00064.allReport(326, 2, 36);
        ArrayList arrayList = new ArrayList();
        if (!FeedGlobalEnv.g().isNetworkAvailable(null)) {
            com.qzone.album.env.common.a.m().V(I(R.string.ci5));
            return;
        }
        if (this.H0.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < this.H0.size(); i3++) {
            PhotoCacheData photoCacheData = this.H0.get(i3);
            if (photoCacheData.videoflag == 1 && (videoInfo = photoCacheData.videodata) != null && videoInfo.videoUrl != null) {
                arrayList.add(Integer.valueOf(i3));
                arrayList3.add(photoCacheData.videodata.videoUrl.url);
                if (TextUtils.isEmpty(photoCacheData.videodata.videoUrl.url)) {
                    com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "cache.videodata.videoUrl.url is null");
                }
            } else {
                PictureUrl picUrlDec = photoCacheData.picItem.getPicUrlDec();
                if (picUrlDec != null && !TextUtils.isEmpty(picUrlDec.url)) {
                    arrayList2.add(picUrlDec.url);
                } else {
                    com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "cache.picItem.getPicUrlDec() is null");
                }
            }
        }
        if (arrayList2.size() == 0 && arrayList3.size() == 0) {
            x4(R.string.gih);
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "mPiclist.size() == 0 && mVideolist.size() is null");
            return;
        }
        s4(I(R.string.gii));
        Dialog dialog = this.V0;
        if (dialog != null) {
            dialog.setOnDismissListener(new j(arrayList2));
        }
        DownloadQueue.j().B();
        if (arrayList2.size() <= 0 && arrayList3.size() > 0) {
            com.qzone.album.env.common.a.m().J(new Runnable() { // from class: com.qzone.album.business.photolist.controller.AbsViewerModeController.20

                /* compiled from: P */
                /* renamed from: com.qzone.album.business.photolist.controller.AbsViewerModeController$20$b */
                /* loaded from: classes39.dex */
                class b implements DialogInterface.OnClickListener {
                    b() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        AbsViewerModeController.this.i1();
                        AbsViewerModeController.this.x5();
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbsViewerModeController.this.T2 = true;
                    AbsViewerModeController.q5(arrayList3, new a(), new b());
                }

                /* compiled from: P */
                /* renamed from: com.qzone.album.business.photolist.controller.AbsViewerModeController$20$a */
                /* loaded from: classes39.dex */
                class a implements i.f {
                    a() {
                    }

                    @Override // com.qzone.misc.network.downloader.i.f
                    public void A(String str, int i3, String str2) {
                        AbsViewerModeController.this.T2 = false;
                        com.qzone.album.env.common.a.m().W(AbsViewerModeController.this.getResources().getString(R.string.gih), 1);
                        AbsViewerModeController.this.i1();
                        AbsViewerModeController.this.x5();
                        com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "downloadVideo fail");
                    }

                    @Override // com.qzone.misc.network.downloader.i.f
                    public void x(String str) {
                        AbsViewerModeController.this.x5();
                    }

                    @Override // com.qzone.misc.network.downloader.i.f
                    public void y(ArrayList<String> arrayList) {
                        AbsViewerModeController.this.L5(arrayList, false);
                        AbsViewerModeController.this.x5();
                    }

                    @Override // com.qzone.misc.network.downloader.i.f
                    public void z(String str) {
                    }
                }
            });
        } else {
            com.qzone.album.env.common.a.m().J(new AnonymousClass21(arrayList2, arrayList3, arrayList));
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void s3() {
        LpReportInfo_pf00064.allReport(326, 2, 48);
        u4.a.z().j(this.Q);
        ArrayList<QzonePhotoInfo> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.H0.size(); i3++) {
            QzonePhotoInfo qzonePhotoInfo = new QzonePhotoInfo();
            PhotoCacheData photoCacheData = this.H0.get(i3);
            qzonePhotoInfo.mAlbumId = photoCacheData.albumid;
            PictureItem pictureItem = photoCacheData.picItem;
            PictureUrl pictureUrl = pictureItem.bigUrl;
            qzonePhotoInfo.mBigUrl = pictureUrl.url;
            qzonePhotoInfo.mBigHeight = pictureUrl.height;
            qzonePhotoInfo.mBigWidth = pictureUrl.width;
            qzonePhotoInfo.mlloc = pictureItem.lloc;
            qzonePhotoInfo.mShouzhang_extend_map = photoCacheData.shouzhang_extend_map;
            qzonePhotoInfo.mShootTime = photoCacheData.shoottime;
            qzonePhotoInfo.mUploadTime = photoCacheData.uploadtime;
            arrayList.add(qzonePhotoInfo);
        }
        com.qzone.album.base.Service.e.e().s(true);
        com.qzone.album.base.Service.e.e().r(true);
        com.qzone.album.base.Service.e.e().o(this.T);
        com.qzone.album.base.Service.e.e().p(this.f42940a0);
        com.qzone.album.base.Service.e.e().w(this.f42991r0);
        com.qzone.album.base.Service.e.e().q(arrayList);
        yo.d.d(o7.a.f422175b, this.P, null);
        QZLog.d("[PhotoAlbum]p2vMakeBlog", 1, "mAlbumId:", this.T, " mAlbumType:", Integer.valueOf(this.f42940a0), " mSortType:", Integer.valueOf(this.f42991r0));
    }

    /* compiled from: P */
    /* renamed from: com.qzone.album.business.photolist.controller.AbsViewerModeController$21, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass21 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f42872d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f42873e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f42874f;

        AnonymousClass21(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            this.f42872d = arrayList;
            this.f42873e = arrayList2;
            this.f42874f = arrayList3;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsViewerModeController.this.T2 = true;
            u4.a.z().t(AbsViewerModeController.this.P, System.currentTimeMillis() + "", this.f42872d, new a());
        }

        /* compiled from: P */
        /* renamed from: com.qzone.album.business.photolist.controller.AbsViewerModeController$21$a */
        /* loaded from: classes39.dex */
        class a implements u4.f {

            /* compiled from: P */
            /* renamed from: com.qzone.album.business.photolist.controller.AbsViewerModeController$21$a$b */
            /* loaded from: classes39.dex */
            class b implements DialogInterface.OnClickListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    AbsViewerModeController.this.i1();
                    AbsViewerModeController.this.x5();
                }
            }

            a() {
            }

            @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
            public void a(String str, ArrayList<String> arrayList) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < AnonymousClass21.this.f42872d.size(); i3++) {
                    String p16 = QzoneAlbumPicDownloadService.p((String) AnonymousClass21.this.f42872d.get(i3));
                    if (p16 != null) {
                        arrayList2.add(p16);
                    } else {
                        com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "p2v picDownload - tempPath is null");
                    }
                }
                if (AnonymousClass21.this.f42873e.size() > 0) {
                    AbsViewerModeController.q5(AnonymousClass21.this.f42873e, new C0332a(arrayList2), new b());
                    return;
                }
                AbsViewerModeController.this.i1();
                AbsViewerModeController.this.M5(arrayList2);
                AbsViewerModeController.this.x5();
            }

            @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
            public void onDownloadFailed(String str) {
                AbsViewerModeController.this.T2 = false;
                com.qzone.album.env.common.a.m().W(AbsViewerModeController.this.getResources().getString(R.string.gih), 1);
                AbsViewerModeController.this.i1();
                com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "downloadImage fail");
                AbsViewerModeController.this.x5();
            }

            /* compiled from: P */
            /* renamed from: com.qzone.album.business.photolist.controller.AbsViewerModeController$21$a$a, reason: collision with other inner class name */
            /* loaded from: classes39.dex */
            class C0332a implements i.f {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ArrayList f42876a;

                C0332a(ArrayList arrayList) {
                    this.f42876a = arrayList;
                }

                @Override // com.qzone.misc.network.downloader.i.f
                public void A(String str, int i3, String str2) {
                    com.qzone.album.env.common.a.m().W(AbsViewerModeController.this.getResources().getString(R.string.gkh), 1);
                    AbsViewerModeController.this.i1();
                    AbsViewerModeController.this.x5();
                }

                @Override // com.qzone.misc.network.downloader.i.f
                public void x(String str) {
                    AbsViewerModeController.this.x5();
                }

                @Override // com.qzone.misc.network.downloader.i.f
                public void y(ArrayList<String> arrayList) {
                    ArrayList arrayList2 = new ArrayList();
                    if (AnonymousClass21.this.f42874f.size() == 0) {
                        arrayList2.addAll(this.f42876a);
                    } else {
                        int size = this.f42876a.size() + arrayList.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            if (AnonymousClass21.this.f42874f.contains(Integer.valueOf(i3))) {
                                arrayList2.add(arrayList.get(0));
                                arrayList.remove(0);
                            } else if (this.f42876a.size() > 0) {
                                arrayList2.add((String) this.f42876a.get(0));
                                this.f42876a.remove(0);
                            }
                        }
                    }
                    AbsViewerModeController.this.x5();
                    AbsViewerModeController.this.L5(arrayList2, false);
                }

                @Override // com.qzone.misc.network.downloader.i.f
                public void z(String str) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.album.business.photolist.controller.AbsViewerModeController$24, reason: invalid class name */
    /* loaded from: classes39.dex */
    public class AnonymousClass24 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f42882d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f42883e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f42884f;

        AnonymousClass24(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            this.f42882d = arrayList;
            this.f42883e = arrayList2;
            this.f42884f = arrayList3;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsViewerModeController.this.T2 = true;
            u4.a.z().t(AbsViewerModeController.this.P, System.currentTimeMillis() + "", this.f42882d, new a());
        }

        /* compiled from: P */
        /* renamed from: com.qzone.album.business.photolist.controller.AbsViewerModeController$24$a */
        /* loaded from: classes39.dex */
        class a implements u4.f {

            /* compiled from: P */
            /* renamed from: com.qzone.album.business.photolist.controller.AbsViewerModeController$24$a$b */
            /* loaded from: classes39.dex */
            class b implements DialogInterface.OnClickListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    AbsViewerModeController.this.i1();
                    AbsViewerModeController.this.x5();
                }
            }

            a() {
            }

            @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
            public void a(String str, ArrayList<String> arrayList) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < AnonymousClass24.this.f42882d.size(); i3++) {
                    String p16 = QzoneAlbumPicDownloadService.p((String) AnonymousClass24.this.f42882d.get(i3));
                    if (p16 != null) {
                        arrayList2.add(p16);
                    } else {
                        com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "p2v picDownload - tempPath is null");
                    }
                }
                if (AnonymousClass24.this.f42883e.size() <= 0) {
                    AbsViewerModeController.this.L5(arrayList2, true);
                    AbsViewerModeController.this.x5();
                } else {
                    AbsViewerModeController.q5(AnonymousClass24.this.f42883e, new C0333a(arrayList2), new b());
                }
            }

            @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
            public void onDownloadFailed(String str) {
                AbsViewerModeController.this.T2 = false;
                com.qzone.album.env.common.a.m().W(AbsViewerModeController.this.getResources().getString(R.string.gih), 1);
                AbsViewerModeController.this.i1();
                com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "Recommend downloadImage fail");
                AbsViewerModeController.this.x5();
            }

            /* compiled from: P */
            /* renamed from: com.qzone.album.business.photolist.controller.AbsViewerModeController$24$a$a, reason: collision with other inner class name */
            /* loaded from: classes39.dex */
            class C0333a implements i.f {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ArrayList f42886a;

                C0333a(ArrayList arrayList) {
                    this.f42886a = arrayList;
                }

                @Override // com.qzone.misc.network.downloader.i.f
                public void A(String str, int i3, String str2) {
                    com.qzone.album.env.common.a.m().W(AbsViewerModeController.this.getResources().getString(R.string.gkh), 1);
                    AbsViewerModeController.this.x5();
                }

                @Override // com.qzone.misc.network.downloader.i.f
                public void y(ArrayList<String> arrayList) {
                    ArrayList arrayList2 = new ArrayList();
                    if (AnonymousClass24.this.f42884f.size() == 0) {
                        arrayList2.addAll(this.f42886a);
                    } else {
                        int size = this.f42886a.size() + arrayList.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            if (AnonymousClass24.this.f42884f.contains(Integer.valueOf(i3))) {
                                arrayList2.add(arrayList.get(0));
                                arrayList.remove(0);
                            } else {
                                arrayList2.add((String) this.f42886a.get(0));
                                this.f42886a.remove(0);
                            }
                        }
                    }
                    AbsViewerModeController.this.L5(arrayList2, true);
                    AbsViewerModeController.this.x5();
                }

                @Override // com.qzone.misc.network.downloader.i.f
                public void x(String str) {
                }

                @Override // com.qzone.misc.network.downloader.i.f
                public void z(String str) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class k implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f42907d;

        k(int i3) {
            this.f42907d = i3;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AbsViewerModeController.this.e6(this.f42907d);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class o implements INetEngineListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f42914a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f42915b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f42916c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PhotoCacheData f42917d;

        o(ArrayList arrayList, ArrayList arrayList2, int i3, PhotoCacheData photoCacheData) {
            this.f42914a = arrayList;
            this.f42915b = arrayList2;
            this.f42916c = i3;
            this.f42917d = photoCacheData;
        }

        @Override // com.tencent.mobileqq.wink.listener.INetEngineListener
        public void getFilePath(String str) {
            if (!TextUtils.isEmpty(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                AbsViewerModeController.this.J5(arrayList, true, this.f42914a, this.f42915b, this.f42916c);
                return;
            }
            QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "downloadVideoOrImage getFilePath is empty, idx = " + this.f42916c + ",photoCacheData.picItem.downloadUrl.url = " + this.f42917d.picItem.downloadUrl.url);
            AbsViewerModeController.this.T2 = true;
            com.qzone.album.env.common.a.m().W(AbsViewerModeController.this.getResources().getString(R.string.gih), 1);
            AbsViewerModeController.this.S5();
        }

        @Override // com.tencent.mobileqq.wink.listener.INetEngineListener
        public void isSuccess(boolean z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class p implements INetEngineListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f42919a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f42920b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f42921c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PhotoCacheData f42922d;

        p(ArrayList arrayList, ArrayList arrayList2, int i3, PhotoCacheData photoCacheData) {
            this.f42919a = arrayList;
            this.f42920b = arrayList2;
            this.f42921c = i3;
            this.f42922d = photoCacheData;
        }

        @Override // com.tencent.mobileqq.wink.listener.INetEngineListener
        public void getFilePath(String str) {
            if (!TextUtils.isEmpty(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                AbsViewerModeController.this.J5(arrayList, true, this.f42919a, this.f42920b, this.f42921c);
                return;
            }
            QLog.d("[PhotoAlbum] BasePhotoModelController", 1, "downloadVideoOrImage getFilePath is empty, idx = " + this.f42921c + ",photoCacheData.videodata.downloadVideoUrl.url = " + this.f42922d.videodata.downloadVideoUrl.url);
            AbsViewerModeController.this.T2 = true;
            com.qzone.album.env.common.a.m().W(AbsViewerModeController.this.getResources().getString(R.string.gih), 1);
            AbsViewerModeController.this.S5();
        }

        @Override // com.tencent.mobileqq.wink.listener.INetEngineListener
        public void isSuccess(boolean z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class q implements Animation.AnimationListener {
        q() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AbsViewerModeController.this.b6();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
