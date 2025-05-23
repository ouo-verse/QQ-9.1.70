package com.qzone.album.business.photolist.controller;

import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.ApplyJoinShareAlbum;
import NS_MOBILE_PHOTO.BannerAttachInfo;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import b5.b;
import com.qzone.album.business.downloader.DownloadQueue;
import com.qzone.album.business.photolist.adapter.a;
import com.qzone.album.business.photolist.adapter.z;
import com.qzone.album.business.photolist.ui.QZonePhotoListVipBar;
import com.qzone.album.business.photolist.ui.header.QzoneAlbumNoShootTimeHintView;
import com.qzone.album.business.photolist.ui.listitem.BigPhotoView;
import com.qzone.album.business.photolist.ui.listitem.PhotoView;
import com.qzone.album.business.photolist.ui.timeline.QZonePhotoListTimeLine;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.AlbumSocialInfoCacheData;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PublicShareCacheData;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZoneGetPhotoListByTimeLineRequest;
import com.qzone.album.protocol.QZoneJoinShareAlbumRequest;
import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.qzone.album.protocol.QZoneQueryAlbumRequest;
import com.qzone.album.ui.widget.QzoneGestureSelectListView;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.album.util.f;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.qboss.protocol.QzoneQBossAdvRequest;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.util.ToastUtil;
import com.qzone.util.ar;
import com.tencent.av.utils.ba;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import eo.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ViewerModelController extends AbsViewerModeController {
    public static final long Q4 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_MAX_P2V_VIDEO_DURING, 15000L);
    private static boolean R4 = false;
    private AdapterView.OnItemClickListener C4;
    private View.OnClickListener D4;
    AbsCompatRequest.a E4;
    private ImageLoader.ImageLoadListener F4;
    private AbsCompatRequest.a G4;
    private a.f H4;
    private a.f I4;
    private z.b J4;
    private ActionSheet.OnButtonClickListener K4;
    private AbsCompatRequest.a L4;
    private View.OnClickListener M4;
    private AbsCompatRequest.a N4;
    private AbsCompatRequest.a O4;
    private CreateShortcutSucceedReceiver P4;

    /* renamed from: b4, reason: collision with root package name */
    private View.OnClickListener f43143b4;

    /* renamed from: c3, reason: collision with root package name */
    private QZonePhotoListVipBar f43144c3;

    /* renamed from: d3, reason: collision with root package name */
    private l4.a f43145d3;

    /* renamed from: d4, reason: collision with root package name */
    private View.OnClickListener f43146d4;

    /* renamed from: e3, reason: collision with root package name */
    private QZonePhotoListTimeLine f43147e3;

    /* renamed from: f3, reason: collision with root package name */
    private ActionSheet f43148f3;

    /* renamed from: g3, reason: collision with root package name */
    private PublicShareCacheData f43149g3;

    /* renamed from: h3, reason: collision with root package name */
    private com.qzone.album.business.photolist.ui.b f43150h3;
    private View i3;
    private View.OnClickListener j3;
    private boolean k3;
    private float l3;
    final int m3;
    protected BroadcastReceiver n3;

    /* renamed from: o3, reason: collision with root package name */
    protected boolean f43151o3;

    /* renamed from: p3, reason: collision with root package name */
    protected boolean f43152p3;

    /* renamed from: p4, reason: collision with root package name */
    private View.OnClickListener f43153p4;

    /* renamed from: q3, reason: collision with root package name */
    private boolean f43154q3;

    /* renamed from: r3, reason: collision with root package name */
    private int f43155r3;

    /* renamed from: r4, reason: collision with root package name */
    private com.qzone.album.business.photolist.ui.interactingbar.d f43156r4;

    /* renamed from: s3, reason: collision with root package name */
    private View.OnClickListener f43157s3;

    /* renamed from: t3, reason: collision with root package name */
    private View.OnClickListener f43158t3;

    /* renamed from: x3, reason: collision with root package name */
    private View.OnClickListener f43159x3;

    /* renamed from: y3, reason: collision with root package name */
    private View.OnClickListener f43160y3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.album.business.photolist.controller.ViewerModelController$13, reason: invalid class name */
    /* loaded from: classes39.dex */
    public class AnonymousClass13 implements Runnable {
        AnonymousClass13() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewerModelController viewerModelController = ViewerModelController.this;
            if (viewerModelController.f43008x0 == null) {
                return;
            }
            int i3 = viewerModelController.T2() ? 2 : 32;
            String stringExtra = ViewerModelController.this.T2() ? ViewerModelController.this.G().getStringExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_INVITE_KEY) : null;
            AlbumCacheData albumCacheData = ViewerModelController.this.f43008x0;
            com.qzone.album.base.Service.a.W().z(albumCacheData.createAlbumRequestModel(2, albumCacheData, i3), "", "", i3, stringExtra, ViewerModelController.this.T2(), new AbsCompatRequest.a() { // from class: com.qzone.album.business.photolist.controller.ViewerModelController.13.1
                @Override // com.qzone.album.protocol.AbsCompatRequest.a
                public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i16, String str) {
                    if (sVar.getSucceed()) {
                        if (sVar.getData() instanceof QZoneOptAlbumRequest.a) {
                            final QZoneOptAlbumRequest.a aVar = (QZoneOptAlbumRequest.a) sVar.getData();
                            com.qzone.album.env.common.a.m().h("[PhotoAlbum] ViewerModelController", com.qzone.util.l.a(R.string.v99), aVar.f43958a);
                            ViewerModelController.this.U(new Runnable() { // from class: com.qzone.album.business.photolist.controller.ViewerModelController.13.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AlbumCacheData albumCacheData2;
                                    if (TextUtils.isEmpty(aVar.f43958a) || (albumCacheData2 = ViewerModelController.this.f43008x0) == null) {
                                        return;
                                    }
                                    albumCacheData2.setShareStatusToConfirm();
                                    ViewerModelController viewerModelController2 = ViewerModelController.this;
                                    viewerModelController2.M3(viewerModelController2.f43008x0);
                                    ViewerModelController.this.K1().C();
                                    ViewerModelController.this.D4();
                                    ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastAddToAlbumSuccess", "\u6210\u529f\u52a0\u5165\uff0c\u8be5\u76f8\u518c\u5c06\u5728\u4f60\u7684\u7a7a\u95f4\u76f8\u518c\u5217\u8868\u5c55\u793a"), 5);
                                    ViewerModelController.this.c0();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastAddToAlbumFail", "\u52a0\u5165\u76f8\u518c\u5931\u8d25\uff1a") + sVar.getMessage(), 4);
                }
            });
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.album.business.photolist.controller.ViewerModelController$28, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass28 implements z.b {
        AnonymousClass28() {
        }

        @Override // com.qzone.album.business.photolist.adapter.z.b
        public void a(final View view, final ArrayList<PhotoCacheData> arrayList, final int i3) {
            com.qzone.album.env.common.a.m().u().post(new Runnable() { // from class: com.qzone.album.business.photolist.controller.ViewerModelController.28.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewerModelController viewerModelController = ViewerModelController.this;
                    final ArrayList<AlbumCacheData> T = viewerModelController.f43012z0.T(viewerModelController.S.longValue());
                    if (T == null) {
                        T = new ArrayList<>();
                    }
                    final boolean a16 = com.qzone.album.base.b.a(BasePhotoModelController.J1(ViewerModelController.this.S.longValue()));
                    ((i4.a) ViewerModelController.this).f407174e.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.controller.ViewerModelController.28.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            t4.a N = t4.a.N();
                            FragmentActivity fragmentActivity = ((i4.a) ViewerModelController.this).f407174e;
                            long longValue = ViewerModelController.this.S.longValue();
                            ArrayList<AlbumCacheData> arrayList2 = T;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            N.B(fragmentActivity, longValue, arrayList2, arrayList, i3, a16, false, 2, view);
                        }
                    });
                }
            });
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.album.business.photolist.controller.ViewerModelController$41, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass41 implements AbsCompatRequest.a {
        AnonymousClass41() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            if (sVar.getSucceed()) {
                com.qzone.album.env.common.a.m().u().post(new Runnable() { // from class: com.qzone.album.business.photolist.controller.ViewerModelController.41.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ViewerModelController viewerModelController = ViewerModelController.this;
                        AlbumSocialInfoCacheData A = viewerModelController.f43012z0.A(viewerModelController.T);
                        ViewerModelController viewerModelController2 = ViewerModelController.this;
                        if (viewerModelController2.T == null || A == null) {
                            return;
                        }
                        final int i16 = A.commentNum + 1;
                        A.commentNum = i16;
                        viewerModelController2.e0().post(new Runnable() { // from class: com.qzone.album.business.photolist.controller.ViewerModelController.41.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ViewerModelController.this.Q7(i16);
                                com.qzone.album.env.common.a.m().W(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCommentYet", "\u5df2\u8bc4\u8bba"), 2);
                            }
                        });
                        ViewerModelController.this.f43012z0.L0(A);
                    }
                });
            } else {
                com.qzone.album.env.common.a.m().W(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCommentFailWait", "\u8bc4\u8bba\u5931\u8d25,\u8bf7\u7a0d\u5019\u518d\u8bd5"), 1);
                com.qzone.album.env.common.a.m().b("[PhotoAlbum] ViewerModelController", "onHandleMessage MSG_COMMENT_ALBUM success");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class CreateShortcutSucceedReceiver extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private Context f43178a;

        CreateShortcutSucceedReceiver() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            final Context context = this.f43178a;
            QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.qzone.album.business.photolist.controller.ViewerModelController.CreateShortcutSucceedReceiver.2

                /* compiled from: P */
                /* renamed from: com.qzone.album.business.photolist.controller.ViewerModelController$CreateShortcutSucceedReceiver$2$a */
                /* loaded from: classes39.dex */
                class a implements DialogInterface.OnClickListener {
                    a() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        if (context instanceof Activity) {
                            try {
                                if (com.qzone.album.util.h.b()) {
                                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                    intent.setData(Uri.fromParts("package", ((Activity) context).getPackageName(), null));
                                    ((Activity) context).startActivity(intent);
                                } else {
                                    ba.openPermissionActivity((Activity) context);
                                }
                            } catch (Throwable th5) {
                                QZLog.e("[PhotoAlbum] ViewerModelController", "openActivity fail!! ", th5);
                                ToastUtil.s(com.qzone.util.l.a(R.string.v97), 1);
                            }
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.qzone.component.e eVar = new com.qzone.component.e();
                    Context context2 = context;
                    eVar.h(context2, context2.getString(R.string.gao), context.getString(R.string.gan), context.getString(R.string.dk6), context.getString(R.string.gmu), new a(), null);
                }
            });
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            this.f43178a = context;
            if (intent.getBooleanExtra(QZoneHelper.QZONE_ALBUM_SHORTCUT_CREATE_FAILED, false)) {
                b();
                return;
            }
            final String stringExtra = intent.getStringExtra("UploadPhoto.key_album_id");
            final ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService("shortcut");
            ThreadManagerV2.post(new Runnable() { // from class: com.qzone.album.business.photolist.controller.ViewerModelController.CreateShortcutSucceedReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LockMethodProxy.sleep(1000L);
                        if (!QZoneHelper.isShortcutCreated_O(stringExtra, shortcutManager)) {
                            CreateShortcutSucceedReceiver.this.b();
                        } else {
                            com.tencent.open.base.ToastUtil.a().b(R.string.aez);
                        }
                    } catch (Exception e16) {
                        QZLog.e("[PhotoAlbum] ViewerModelController", 1, "shortcutReceiver onReceive error ", e16);
                        com.tencent.open.base.ToastUtil.a().b(R.string.f170347o5);
                    }
                }
            }, 2, null, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ViewerModelController.this.h3()) {
                com.qzone.album.env.common.a.m().R("368", "13", "");
            } else {
                com.qzone.album.env.common.a.m().P(326, 2, "10", true, null);
            }
            u4.a z16 = u4.a.z();
            ViewerModelController viewerModelController = ViewerModelController.this;
            z16.V(viewerModelController.P, viewerModelController.S, viewerModelController.T);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class aa implements AbsCompatRequest.a {
        aa() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            if (sVar.getSucceed()) {
                if (ViewerModelController.this.getListView() == null) {
                    return;
                }
                QZoneGetPhotoListByTimeLineRequest.a aVar = (QZoneGetPhotoListByTimeLineRequest.a) sVar.getObjectData();
                ViewerModelController viewerModelController = ViewerModelController.this;
                ArrayList<PhotoCacheData> arrayList = aVar.f43929h;
                viewerModelController.f43003v0 = arrayList;
                viewerModelController.f43008x0 = aVar.f43930i;
                if (arrayList == null) {
                    viewerModelController.f43003v0 = new ArrayList();
                }
                ViewerModelController.this.f42969j2 = ((Integer) absCompatRequest.getParam("direction")).intValue();
                ViewerModelController viewerModelController2 = ViewerModelController.this;
                long longValue = viewerModelController2.S.longValue();
                ViewerModelController viewerModelController3 = ViewerModelController.this;
                viewerModelController2.o4(BasePhotoModelController.I1(longValue, viewerModelController3.T, viewerModelController3.f42955f0), ViewerModelController.this.m7());
                BaseAdapter B1 = ViewerModelController.this.B1();
                if (B1 instanceof com.qzone.album.business.photolist.adapter.a) {
                    com.qzone.album.business.photolist.adapter.a aVar2 = (com.qzone.album.business.photolist.adapter.a) B1;
                    if (ViewerModelController.this.d1(2)) {
                        aVar2.w(null);
                    } else {
                        aVar2.w(ViewerModelController.this.f42968j1);
                        List<PhotoCacheData> list = ViewerModelController.this.f42968j1;
                        if (list != null && list.size() > 0) {
                            ViewerModelController.this.l7();
                        }
                    }
                }
                ViewerModelController viewerModelController4 = ViewerModelController.this;
                viewerModelController4.f42972k2 = viewerModelController4.B1().getCount();
                ViewerModelController viewerModelController5 = ViewerModelController.this;
                viewerModelController5.x2(viewerModelController5.f43003v0, false, viewerModelController5.f43008x0);
                return;
            }
            com.qzone.album.env.common.a.m().V(sVar.getMessage());
            ViewerModelController.this.B7();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ab implements View.OnClickListener {
        ab() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ViewerModelController.this.f43147e3 != null && !ViewerModelController.this.X1) {
                int id5 = view.getId();
                if (id5 == R.id.jsm || id5 == R.id.f165896dt3) {
                    ViewerModelController.this.f43147e3.E(true);
                    ViewerModelController viewerModelController = ViewerModelController.this;
                    o4.b.c(viewerModelController.f42940a0, viewerModelController.f42943b0);
                } else if (id5 == R.id.fqc) {
                    ViewerModelController.this.f43147e3.E(false);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class ac implements View.OnClickListener {
        ac() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ViewerModelController.this.f42945b2.K(true);
            com.qzone.album.env.common.a.m().P(326, 2, "46", true, "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class ad extends HdAsyncAction {
        ad(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            ArrayList<PhotoCacheData> arrayList;
            ViewerModelController viewerModelController = ViewerModelController.this;
            if (viewerModelController.f43010y0 != null) {
                if (viewerModelController.k3()) {
                    ViewerModelController viewerModelController2 = ViewerModelController.this;
                    arrayList = viewerModelController2.f43012z0.V(viewerModelController2.S.longValue(), 2);
                    ViewerModelController viewerModelController3 = ViewerModelController.this;
                    viewerModelController3.f43008x0 = viewerModelController3.f43012z0.x(viewerModelController3.S.longValue(), String.valueOf(ViewerModelController.this.S));
                } else if (TextUtils.isEmpty(ViewerModelController.this.T)) {
                    arrayList = null;
                } else {
                    ViewerModelController viewerModelController4 = ViewerModelController.this;
                    arrayList = viewerModelController4.f43012z0.B(viewerModelController4.T);
                    ViewerModelController viewerModelController5 = ViewerModelController.this;
                    viewerModelController5.f43008x0 = viewerModelController5.f43012z0.x(viewerModelController5.S.longValue(), ViewerModelController.this.T);
                    if (!ViewerModelController.R4) {
                        ViewerModelController.this.H7();
                    }
                }
                return doNext(true, arrayList);
            }
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class af implements DialogInterface.OnClickListener {
        af() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("editAlbumNeedScrollToEnd", true);
            ViewerModelController.this.L7(bundle);
            ViewerModelController.this.a7(bundle);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class ag implements DialogInterface.OnClickListener {
        ag() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class ah implements DialogInterface.OnClickListener {
        ah() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            try {
                ViewerModelController.this.V(InstalledAppListMonitor.getLaunchIntentForPackage(ViewerModelController.this.Q.getPackageManager(), "com.iqoo.secure"));
            } catch (Exception e16) {
                QZLog.e("[PhotoAlbum] ViewerModelController", "openActivity fail!! ", e16);
                ToastUtil.s(com.qzone.util.l.a(R.string.v98), 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class ai implements AbsListView.OnScrollListener {
        ai() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            ViewerModelController.this.E7(absListView, i3, i16, i17);
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            ViewerModelController.this.F7(absListView, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ak implements View.OnClickListener {
        ak() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ViewerModelController.this.w4();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class al implements View.OnClickListener {
        al() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            eo.c.f396879a.b();
            ViewerModelController.this.G3();
            LpReportInfo_pf00064.allReport(326, 2, 53);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class am implements View.OnClickListener {

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }

        am() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.qzone.album.ui.widget.b bVar = new com.qzone.album.ui.widget.b(((i4.a) ViewerModelController.this).f407174e, R.style.qZoneInputDialog);
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleLove", "\u7231\u5fc3\u6c14\u7403");
            String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogMessageLove", "\u4e0a\u4f20\u7167\u7247\u6216\u89c6\u9891 \u624d\u80fd\u4f7f\u7231\u5fc3\u6c14\u7403\u7684\u6c34\u91cf\u5145\u6ee1\u54e6");
            bVar.setContentView(R.layout.f169002bk0);
            bVar.Q("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_show_guide.png");
            bVar.setTitle(config);
            bVar.N(config2);
            bVar.P(((i4.a) ViewerModelController.this).f407174e.getResources().getString(R.string.gbp), new a());
            bVar.show();
            com.qzone.album.env.common.a.m().P(326, 2, "29", false, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class an implements View.OnClickListener {
        an() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.qzone.album.env.common.a.m().P(326, 2, "7", true, null);
            int id5 = view.getId();
            if (id5 == R.id.f164275qe) {
                if (com.qzone.album.util.q.b("keyAddFamilyMemberGuide")) {
                    ViewerModelController.this.M7();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("editAlbumNeedScrollToEnd", true);
                    ViewerModelController.this.L7(bundle);
                    ViewerModelController.this.a7(bundle);
                }
                com.qzone.album.env.common.a.m().P(402, 8, "1", true, ViewerModelController.this.f43008x0.albumid);
            } else if (id5 == R.id.irj) {
                ViewerModelController viewerModelController = ViewerModelController.this;
                int i3 = viewerModelController.f43008x0.albumtype;
                if (i3 == 9) {
                    if (!viewerModelController.P2()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putBoolean("editAlbumNeedScrollToEnd", true);
                        ViewerModelController.this.L7(bundle2);
                        ViewerModelController.this.a7(bundle2);
                    }
                } else if (i3 == 8) {
                    if (viewerModelController.P2()) {
                        ViewerModelController.this.O7();
                    } else if (com.qzone.album.util.q.b("keyAddFamilyMemberGuide")) {
                        ViewerModelController.this.M7();
                    } else {
                        Bundle bundle3 = new Bundle();
                        bundle3.putBoolean("editAlbumNeedScrollToEnd", true);
                        ViewerModelController.this.L7(bundle3);
                        ViewerModelController.this.a7(bundle3);
                    }
                }
                com.qzone.album.env.common.a.m().P(402, 8, "2", true, ViewerModelController.this.f43008x0.albumid);
            } else if (id5 == R.id.hn7) {
                Bundle bundle4 = new Bundle();
                bundle4.putBoolean("editAlbumNeedScrollToEnd", true);
                bundle4.putBoolean("editAlbumNeedSelectLover", true);
                ViewerModelController.this.L7(bundle4);
                ViewerModelController.this.a7(bundle4);
            } else {
                Bundle bundle5 = new Bundle();
                ViewerModelController.this.L7(bundle5);
                ViewerModelController.this.a7(bundle5);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class ao implements View.OnClickListener {
        public ao() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id5;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!ViewerModelController.this.X1 && (((id5 = view.getId()) == R.id.hce || id5 == R.id.dar || id5 == R.id.hcf) && com.qzone.album.env.common.a.m().s() == ViewerModelController.this.S.longValue() && ViewerModelController.this.f42976m0 > 0)) {
                if (id5 == R.id.dar) {
                    LpReportInfo_pf00064.allReport(326, 2, 44);
                }
                ViewerModelController.this.b7(4);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            u4.a.z().T(ViewerModelController.this.q2(), ViewerModelController.this.S.longValue(), ViewerModelController.this.T);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            u4.a.z().U(ViewerModelController.this.q2(), ViewerModelController.this.S.longValue(), ViewerModelController.this.T);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ViewerModelController.this.f42970k0 == 0) {
                com.qzone.album.env.common.a.m().P(326, 2, "1", true, ViewerModelController.this.z5());
                ViewerModelController.this.K1.h(8);
                ViewerModelController.this.K1.k(ar.e(50.0f));
                ViewerModelController.this.K1.n(view, 0, ar.e(6.0f), 1.0f);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f implements ActionSheet.OnButtonClickListener {
        f() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            ViewerModelController.this.Z6(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class g implements AdapterView.OnItemClickListener {
        g() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            String e16;
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            com.qzone.album.business.photolist.ui.menu.b bVar = ViewerModelController.this.K1;
            if (bVar != null) {
                bVar.e();
                b.c o16 = ViewerModelController.this.K1.o(i3);
                if (o16 != null && (e16 = o16.e()) != null) {
                    if (e16.equals(com.qzone.album.business.photolist.ui.menu.b.f43695o)) {
                        com.qzone.album.env.common.a.m().P(326, 2, "3", true, ViewerModelController.this.z5());
                        Bundle bundle = new Bundle();
                        ViewerModelController.this.L7(bundle);
                        ViewerModelController.this.a7(bundle);
                    } else if (e16.equals(com.qzone.album.business.photolist.ui.menu.b.f43696p)) {
                        ViewerModelController.this.P7();
                        com.qzone.album.business.photolist.ui.menu.b bVar2 = ViewerModelController.this.K1;
                        if (bVar2 != null) {
                            bVar2.u(false);
                            ViewerModelController viewerModelController = ViewerModelController.this;
                            viewerModelController.K1.t(viewerModelController.Q.getResources().getDrawable(R.drawable.f162198fy3));
                            com.qzone.album.env.common.a.m().P(326, 2, "6", true, ViewerModelController.this.z5());
                        }
                    } else if (e16.equals(com.qzone.album.business.photolist.ui.menu.b.f43697q)) {
                        ViewerModelController.this.P7();
                        com.qzone.album.business.photolist.ui.menu.b bVar3 = ViewerModelController.this.K1;
                        if (bVar3 != null) {
                            bVar3.u(true);
                            ViewerModelController viewerModelController2 = ViewerModelController.this;
                            viewerModelController2.K1.t(viewerModelController2.Q.getResources().getDrawable(R.drawable.f162196fy1));
                            com.qzone.album.env.common.a.m().P(326, 2, "6", true, ViewerModelController.this.z5());
                        }
                    } else if (e16.equals(com.qzone.album.business.photolist.ui.menu.b.f43698r)) {
                        ViewerModelController viewerModelController3 = ViewerModelController.this;
                        if (!viewerModelController3.U1) {
                            com.qzone.album.env.common.a.m().W(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchingInformation", "\u4fe1\u606f\u62c9\u53d6\u4e2d\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5"), 1);
                        } else {
                            AlbumCacheData albumCacheData = viewerModelController3.f43008x0;
                            if (albumCacheData != null && albumCacheData.allow_share != 0) {
                                viewerModelController3.d7();
                            } else {
                                com.qzone.album.env.common.a.m().W(ViewerModelController.this.I(R.string.f173018gi2), 1);
                            }
                        }
                        LpReportInfo_pf00064.allReport(326, 2, Integer.parseInt("22"));
                    } else if (e16.equals(com.qzone.album.business.photolist.ui.menu.b.f43700t)) {
                        ViewerModelController.this.g7();
                    } else if (e16.equals(com.qzone.album.business.photolist.ui.menu.b.f43699s)) {
                        ViewerModelController.this.h7();
                    } else if (e16.equals(com.qzone.album.business.photolist.ui.menu.b.f43702v)) {
                        Bundle bundle2 = new Bundle();
                        ViewerModelController.this.L7(bundle2);
                        ViewerModelController.this.a7(bundle2);
                    } else if (!TextUtils.isEmpty(o16.d())) {
                        yo.d.d(o16.d(), ViewerModelController.this.q2(), null);
                    } else if (e16.equals(com.qzone.album.business.photolist.ui.menu.b.f43703w)) {
                        ViewerModelController.this.W6();
                    }
                }
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LpReportInfo_pf00064.allReport(326, 3, 5);
            ViewerModelController.this.b7(5);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class j implements AbsCompatRequest.a {
        j() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            Map<Integer, ArrayList<tAdvDesc>> map;
            tAdvDesc tadvdesc;
            if (!sVar.getSucceed() || !(sVar.getData() instanceof QzoneQBossAdvRequest.a) || (map = ((QzoneQBossAdvRequest.a) sVar.getData()).f48461b) == null || map.get(2618) == null || map.get(2618).size() == 0 || (tadvdesc = map.get(2618).get(0)) == null) {
                return;
            }
            try {
                ViewerModelController.this.G7(tadvdesc.res_data, tadvdesc.res_traceinfo);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class k extends HdAsyncAction {
        k(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            ViewerModelController.this.f43000u0.clear();
            List<PhotoCacheData[]> list = (List) obj;
            ViewerModelController.this.f43000u0.addAll(list);
            ((com.qzone.album.business.photolist.adapter.a) ViewerModelController.this.B1()).setData(list);
            ViewerModelController viewerModelController = ViewerModelController.this;
            viewerModelController.G4(((com.qzone.album.business.photolist.adapter.a) viewerModelController.B1()).k(false), ((com.qzone.album.business.photolist.adapter.a) ViewerModelController.this.B1()).j());
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class l extends HdAsyncAction {
        l(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            List<PhotoCacheData[]> a16;
            ViewerModelController viewerModelController = ViewerModelController.this;
            if (viewerModelController.f43006w0 != null) {
                a16 = ((com.qzone.album.business.photolist.adapter.a) viewerModelController.B1()).a(ViewerModelController.this.f43006w0);
                ViewerModelController.this.f43006w0 = null;
            } else {
                a16 = ((com.qzone.album.business.photolist.adapter.a) viewerModelController.B1()).a(ViewerModelController.this.f43003v0);
            }
            return doNext(true, a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class o implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f43214a;

        o(int i3) {
            this.f43214a = i3;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            ViewerModelController.this.i1();
            if (sVar.getSucceed()) {
                com.qzone.album.env.common.a.m().W(ViewerModelController.this.I(R.string.gcl), 2);
                ViewerModelController.this.h4(this.f43214a);
                ViewerModelController.this.L3();
                ((com.qzone.album.business.photolist.adapter.a) ViewerModelController.this.B1()).G(ViewerModelController.this.f42991r0);
                ViewerModelController viewerModelController = ViewerModelController.this;
                viewerModelController.f42974l1 = "0";
                viewerModelController.o0();
                ViewerModelController.this.u0();
                return;
            }
            if (!TextUtils.isEmpty(sVar.getMessage())) {
                com.qzone.album.env.common.a.m().V(sVar.getMessage());
            } else {
                com.qzone.album.env.common.a.m().W(ViewerModelController.this.I(R.string.gck), 1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class p implements a.f {
        p() {
        }

        @Override // com.qzone.album.business.photolist.adapter.a.f
        public void onClick(View view) {
            ViewerModelController viewerModelController = ViewerModelController.this;
            if (viewerModelController.B0 && viewerModelController.f42970k0 == 0) {
                viewerModelController.B0 = false;
                int intValue = ((Integer) view.getTag()).intValue();
                ViewerModelController viewerModelController2 = ViewerModelController.this;
                PhotoCacheData Z1 = viewerModelController2.Z1(viewerModelController2.f43000u0, intValue, false);
                if (Z1 == null) {
                    ViewerModelController.this.B0 = true;
                    return;
                }
                com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", "[PhotoAlbum] ViewerModelController", " PhotoPreview start");
                ViewerModelController viewerModelController3 = ViewerModelController.this;
                viewerModelController3.c7(Z1.index, Z1, viewerModelController3.f43000u0, false, view);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class q implements a.f {
        q() {
        }

        @Override // com.qzone.album.business.photolist.adapter.a.f
        public void onClick(View view) {
            ViewerModelController viewerModelController = ViewerModelController.this;
            if (viewerModelController.f42970k0 != 0 || viewerModelController.O0) {
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            ViewerModelController viewerModelController2 = ViewerModelController.this;
            PhotoCacheData Z1 = viewerModelController2.Z1(viewerModelController2.f43000u0, intValue, false);
            if (Z1 == null) {
                return;
            }
            LpReportInfo_pf00064.allReport(86, 2, ViewerModelController.this.c2());
            if (ViewerModelController.this.P2()) {
                ViewerModelController.this.d7();
            } else {
                ViewerModelController.this.b7(1);
            }
            if (!ViewerModelController.this.R2(Z1)) {
                ViewerModelController.this.b4(Z1, intValue, true);
            }
            ViewerModelController.this.J4();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class r implements ActionSheet.OnButtonClickListener {
        r() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            String str;
            String str2;
            String str3;
            switch (ViewerModelController.this.f43148f3.getActionMenuItem(i3).action) {
                case 204:
                    AlbumCacheData albumCacheData = ViewerModelController.this.f43008x0;
                    if (albumCacheData != null) {
                        if (albumCacheData.albumtype == 11) {
                            com.qzone.album.env.common.a.m().z(ViewerModelController.this.Q, -1, 14);
                        } else if (albumCacheData.getMaxCount() - ViewerModelController.this.f43008x0.getConfirmedSharingOwnersNumber() <= 0) {
                            com.qzone.album.env.common.a.m().W(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ReachMaxLimit", "\u76f8\u518c\u5171\u4eab\u4eba\u5df2\u8fbe\u4e0a\u9650"), 4);
                        } else {
                            com.qzone.album.env.common.a m3 = com.qzone.album.env.common.a.m();
                            ViewerModelController viewerModelController = ViewerModelController.this;
                            m3.y(viewerModelController.Q, 1, viewerModelController.f43008x0.getMaxCount() - ViewerModelController.this.f43008x0.getConfirmedSharingOwnersNumber(), -1, 12, ViewerModelController.this.f43008x0.getConfirmedSharingOwnersList(), false);
                        }
                        if (ViewerModelController.this.f43008x0.albumtype == 12) {
                            com.qzone.album.env.common.a.m().P(326, 14, "9", true, null);
                            break;
                        }
                    } else {
                        return;
                    }
                    break;
                case 205:
                    if (ViewerModelController.this.f43149g3 != null) {
                        str3 = ViewerModelController.this.f43149g3.h5url;
                        str = ViewerModelController.this.f43149g3.cover;
                        str2 = ViewerModelController.this.f43149g3.desc;
                    } else {
                        str = null;
                        str2 = null;
                        str3 = null;
                    }
                    if (ViewerModelController.this.f43008x0 != null && str3 != null && str != null && str2 != null) {
                        ShareUtils.e eVar = new ShareUtils.e();
                        eVar.f44740a = str3;
                        eVar.f44711h = 2;
                        eVar.f44743d = str;
                        eVar.f44712i = QZoneShareManager.QQ_SHARE_APPID;
                        eVar.f44713j = 1;
                        eVar.f44741b = str2;
                        eVar.f44715l = true;
                        AlbumCacheData albumCacheData2 = ViewerModelController.this.f43008x0;
                        eVar.d(albumCacheData2.ark_content_invate, albumCacheData2.ark_id_invate, albumCacheData2.view_id_invate, str, str2, str3);
                        ShareUtils.n(ViewerModelController.this.Q, eVar, 0);
                        if (ViewerModelController.this.f43008x0.albumtype == 12) {
                            com.qzone.album.env.common.a.m().P(326, 14, "10", true, null);
                            break;
                        }
                    }
                    break;
                case 206:
                    ViewerModelController viewerModelController2 = ViewerModelController.this;
                    QZoneAlbumUtil.y(viewerModelController2.P, viewerModelController2.f43008x0);
                    break;
            }
            ViewerModelController viewerModelController3 = ViewerModelController.this;
            ActionSheetHelper.dismissActionSheet(viewerModelController3.Q, viewerModelController3.f43148f3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class s extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f43219a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(Looper looper, boolean z16) {
            super(looper);
            this.f43219a = z16;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            if (ViewerModelController.this.k3()) {
                ViewerModelController.this.F3(obj, Boolean.valueOf(this.f43219a), ViewerModelController.this.f43008x0);
            } else {
                ViewerModelController.this.E3(obj, Boolean.valueOf(this.f43219a), ViewerModelController.this.f43008x0);
            }
            return doNext(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class t implements View.OnClickListener {
        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ViewerModelController.this.l3();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class u implements View.OnClickListener {
        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ViewerModelController.this.V6();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class v implements View.OnClickListener {
        v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ViewerModelController.this.f43148f3 == null) {
                ViewerModelController viewerModelController = ViewerModelController.this;
                Activity activity = viewerModelController.Q;
                ActionSheet.OnButtonClickListener onButtonClickListener = viewerModelController.K4;
                AlbumCacheData albumCacheData = ViewerModelController.this.f43008x0;
                viewerModelController.f43148f3 = com.qzone.album.ui.widget.e.b(activity, onButtonClickListener, albumCacheData != null ? albumCacheData.albumtype : 1);
            }
            ViewerModelController viewerModelController2 = ViewerModelController.this;
            ActionSheetHelper.showActionSheet(viewerModelController2.Q, viewerModelController2.f43148f3);
            AlbumCacheData albumCacheData2 = ViewerModelController.this.f43008x0;
            if (albumCacheData2 != null && albumCacheData2.albumtype == 12) {
                com.qzone.album.env.common.a.m().P(326, 14, "2", true, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class w implements View.OnClickListener {

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements AbsCompatRequest.a {
            a() {
            }

            @Override // com.qzone.album.protocol.AbsCompatRequest.a
            public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
                ViewerModelController.this.j7(sVar);
            }
        }

        w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ApplyJoinShareAlbum applyJoinShareAlbum = new ApplyJoinShareAlbum();
            AlbumCacheData albumCacheData = ViewerModelController.this.f43008x0;
            long j3 = albumCacheData.createSharingUin;
            if (j3 != 0) {
                applyJoinShareAlbum.owner = j3;
            } else {
                applyJoinShareAlbum.owner = albumCacheData.ownerUin;
            }
            applyJoinShareAlbum.albumid = albumCacheData.albumid;
            if (albumCacheData.albumtype == 12) {
                com.qzone.album.env.common.a.m().P(326, 14, "13", true, null);
            }
            com.qzone.album.base.Service.a.W().F0(LoginData.getInstance().getUin(), 1, applyJoinShareAlbum, null, new a());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class x implements View.OnClickListener {
        x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getId() == R.id.hbt) {
                Object tag = view.getTag(R.id.jam);
                Object tag2 = view.getTag(R.id.f166947jb4);
                if (tag != null && (tag instanceof String) && tag2 != null && (tag2 instanceof String)) {
                    ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick((String) tag2, LoginData.getInstance().getUinString());
                    yo.d.d((String) tag, ViewerModelController.this.Q, null);
                }
                ViewerModelController.this.K1().j().setInviteOpenLoveZoneViewVisible(false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class y implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f43227d;

        y(int i3) {
            this.f43227d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getId() == R.id.ekc) {
                Bundle bundle = new Bundle();
                int i3 = this.f43227d;
                if (i3 == 1) {
                    bundle.putInt("QZoneNewAlbumActivity.key_choose_type", 1);
                    LpReportInfo_pf00064.allReport(326, 2, Integer.parseInt("17"));
                } else if (i3 == 2) {
                    bundle.putInt("QZoneNewAlbumActivity.key_choose_type", 2);
                    LpReportInfo_pf00064.allReport(326, 2, Integer.parseInt("20"));
                }
                ViewerModelController.this.L7(bundle);
                ViewerModelController.this.a7(bundle);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class z implements View.OnClickListener {
        z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            u5.b.r0("is_need_show_no_shoot_time_hint_view_" + ViewerModelController.this.T, 0, LoginData.getInstance().getUin());
            ViewerModelController.this.K1().z(false);
            ViewerModelController.this.K1().y(0);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("close", String.valueOf(1));
            com.qzone.album.env.common.a.m().S("noShootTimeReport", hashMap);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ViewerModelController(FragmentActivity fragmentActivity, u4.h hVar) {
        super(fragmentActivity, hVar);
        this.k3 = true;
        this.l3 = 2.14748365E9f;
        this.m3 = 5;
        this.f43154q3 = false;
        this.f43155r3 = 0;
        this.f43156r4 = new e();
        this.C4 = new g();
        this.D4 = new i();
        this.E4 = new m();
        this.G4 = new n();
        this.H4 = new p();
        this.I4 = new q();
        this.J4 = new AnonymousClass28();
        this.K4 = new r();
        this.L4 = new aa();
        this.M4 = new ab();
        this.N4 = new ae();
        this.O4 = new AnonymousClass41();
    }

    private void C7(int i3) {
        if (TextUtils.isEmpty(this.T)) {
            return;
        }
        ArrayList<PictureItem> arrayList = new ArrayList<>();
        for (PhotoCacheData photoCacheData : this.f43003v0) {
            if (photoCacheData.isFakePhoto()) {
                arrayList.add(photoCacheData.picItem);
            }
        }
        QZLog.d("[PhotoAlbum] ViewerModelController", 1, "onFakePhotoPreview size:", Integer.valueOf(arrayList.size()));
        u4.a.z().k0(this.Q, arrayList, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E7(AbsListView absListView, int i3, int i16, int i17) {
        QZonePhotoListTimeLine qZonePhotoListTimeLine = this.f43147e3;
        if (qZonePhotoListTimeLine != null && !this.O0) {
            qZonePhotoListTimeLine.D();
        }
        AlbumCacheData albumCacheData = this.f43008x0;
        if (albumCacheData != null && albumCacheData.isLoveAlbum()) {
            k7(absListView);
        }
        if (i3 <= 1) {
            if (!this.f43001u1 || (!this.f43004v1 && !d1(1))) {
                this.W1.s1(i3, absListView, BasePhotoModelController.f42936w2);
            }
            if (this.f43001u1 && !this.f43004v1) {
                if (d1(1)) {
                    K1().A(false);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.W1.getListView().getLayoutParams();
                    layoutParams.addRule(3, R.id.f166672ha0);
                    this.W1.getListView().setLayoutParams(layoutParams);
                    this.W1.getListView().setCoverMode(false);
                    i4();
                    this.k3 = false;
                } else if (!this.k3) {
                    K1().A(true);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.W1.getListView().getLayoutParams();
                    layoutParams2.addRule(3, -1);
                    this.W1.getListView().setLayoutParams(layoutParams2);
                    this.W1.getListView().setCoverMode(true, BasePhotoModelController.f42936w2);
                    this.k3 = true;
                }
            }
        }
        if (i3 > 0) {
            this.W1.L0(i3);
        }
        F5(absListView, i3, i16, i17);
        if (!S2()) {
            this.f42947c1 = 1;
            if (K1().k() != null && K1().k().getVisibility() == 0) {
                this.f42947c1 = 2;
            }
            if (h3()) {
                this.f42947c1++;
            }
            QZonePhotoListTimeLine qZonePhotoListTimeLine2 = this.f43147e3;
            if (qZonePhotoListTimeLine2 != null) {
                qZonePhotoListTimeLine2.x(i3);
                if (getListView() != null) {
                    this.f43147e3.y(getListView().getLastVisiblePosition() - getListView().getFooterViewsCount());
                }
            }
        }
        int i18 = this.f42970k0;
        if (i18 == 0 || i18 == 1) {
            return;
        }
        this.W1.m0(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F7(AbsListView absListView, int i3) {
        com.qzone.album.util.m.c(i3);
        mc.c.f416541a.b(i3, new com.tencent.qqnt.avatar.meta.refresh.c<>(this.f407174e.getWindow()), "QZonePersonalPhotoListActivity", "qzone_album_monitor_key_detail_album");
        if (i3 != 0) {
            if (i3 != 2) {
                com.qzone.album.env.common.a.m().X("qzone_album_second_page");
                return;
            } else {
                u4.a.z().q0(absListView);
                return;
            }
        }
        if (this.W1.getListView().getLastVisiblePosition() >= this.W1.getListView().getCount() - 2) {
            com.qzone.album.business.photolist.ui.d dVar = this.f42942a2;
            if (dVar != null && dVar.i() && this.f42942a2.h() && !this.f42942a2.g() && !this.T1) {
                return;
            } else {
                m0();
            }
        }
        u4.a.z().n0();
        com.qzone.album.env.common.a.m().Y("qzone_album_second_page", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G7(String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("image_name");
        String string2 = jSONObject.getString("url_name");
        if (string == null || string2 == null) {
            return;
        }
        K1().j().setQBossRightSideViewData(string, string2, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H7() {
        com.qzone.album.env.common.a.m().K(new Runnable() { // from class: com.qzone.album.business.photolist.controller.ViewerModelController.46
            @Override // java.lang.Runnable
            public void run() {
                AlbumCacheData albumCacheData = ViewerModelController.this.f43008x0;
                if (albumCacheData != null && albumCacheData.albumtype == 9 && albumCacheData.isSharingAlbumOnServer()) {
                    com.qzone.album.env.common.a.m().L();
                    ViewerModelController.R4 = true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L7(Bundle bundle) {
        if (this.f43149g3 != null) {
            bundle.putBoolean("hasInviteTroopSetting", true);
            bundle.putString("inviteTroopCover", this.f43149g3.cover);
            bundle.putString("inviteTroopDesc", this.f43149g3.desc);
            bundle.putString("inviteTroopH5Url", this.f43149g3.h5url);
            bundle.putString("inviteTroopSchema", this.f43149g3.schema);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M7() {
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleInviteFamily", "\u9080\u8bf7\u5bb6\u4eba\u4e00\u8d77\u4e0a\u4f20");
        String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogMessageInviteFamily", "\u5bb6\u4eba\u63a5\u53d7\u9080\u8bf7\u540e,\u4ed6\u4eec\u53ef\u4ee5\u4e0a\u4f20\u7167\u7247\u548c\u89c6\u9891,\u8fd8\u80fd\u5728\u5404\u81ea\u7a7a\u95f4\u67e5\u770b\u3002");
        com.qzone.album.ui.widget.b bVar = new com.qzone.album.ui.widget.b(this.f407174e, R.style.qZoneInputDialog);
        bVar.setContentView(R.layout.f169002bk0);
        bVar.Q("https://qzonestyle.gtimg.cn/aoi/sola/20191104215207_lPJIXL1rjE.png");
        bVar.setTitle(config);
        bVar.N(config2);
        bVar.P(this.f407174e.getResources().getString(R.string.gbp), new af());
        bVar.show();
    }

    private void N7(View view, boolean z16) {
        K1().B(view, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O7() {
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleMutiUpload", "\u76f8\u518c\u591a\u4eba\u4e0a\u4f20");
        String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogMessageInviteFamily", "\u5bb6\u4eba\u63a5\u53d7\u9080\u8bf7\u540e,\u4ed6\u4eec\u53ef\u4ee5\u4e0a\u4f20\u7167\u7247\u548c\u89c6\u9891,\u8fd8\u80fd\u5728\u5404\u81ea\u7a7a\u95f4\u67e5\u770b\u3002");
        com.qzone.album.ui.widget.b bVar = new com.qzone.album.ui.widget.b(this.Q, R.style.qZoneInputDialog);
        bVar.setContentView(R.layout.f169002bk0);
        bVar.Q("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_show_guide.png");
        bVar.setTitle(config);
        bVar.N(config2);
        bVar.setCanceledOnTouchOutside(true);
        bVar.P(this.Q.getResources().getString(R.string.gbp), new ag());
        bVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P7() {
        int i3 = this.B1 == 0 ? 1 : 0;
        this.B1 = i3;
        super.V3(QZoneAlbumUtil.u(this.f42940a0, i3, this, null, P2(), this.f42943b0));
        ((com.qzone.album.business.photolist.adapter.a) B1()).D(this.H4);
        ((com.qzone.album.business.photolist.adapter.a) B1()).E(this.I4);
        ((com.qzone.album.business.photolist.adapter.a) B1()).B(true ^ P2());
        ((com.qzone.album.business.photolist.adapter.a) B1()).z(this.O0);
        this.W1.getListView().setAdapter((ListAdapter) B1());
        x2(this.f43003v0, false, g());
        this.f43155r3 = this.B1;
        if (h()) {
            a4();
        }
        if (e3()) {
            com.qzone.album.env.common.a.m().R("368", "10", "2");
        } else if (i3()) {
            com.qzone.album.env.common.a.m().R("368", "10", "3");
        } else {
            com.qzone.album.env.common.a.m().R("368", "10", "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q7(int i3) {
        com.qzone.album.business.photolist.ui.interactingbar.a aVar = this.J1;
        if (aVar != null) {
            aVar.j(i3);
        }
        R7(i3);
    }

    private void R7(int i3) {
        if (K1().j() == null) {
            return;
        }
        K1().j().V0(i3);
    }

    private void S7(boolean z16, int i3) {
        if (K1().j() == null) {
            return;
        }
        K1().j().W0(z16, i3);
    }

    private void T6() {
        String str;
        String str2;
        if (!P2() && QZoneAlbumUtil.c() && QZoneAlbumUtil.z(this.T) && QZoneHelper.isShortcutCreated(this.T, this.P)) {
            AlbumCacheData albumCacheData = this.f43008x0;
            if (albumCacheData != null) {
                str = albumCacheData.getLloc();
            } else {
                str = this.V;
            }
            QZoneAlbumUtil.L(this.P, str, this.T, this.U, this.S.longValue(), false);
            int c26 = c2();
            if (this.Y1) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            LpReportInfo_pf00064.allReport(219, 2, c26, str2, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T7(AlbumSocialInfoCacheData albumSocialInfoCacheData) {
        com.qzone.album.business.photolist.ui.interactingbar.a aVar = this.J1;
        if (aVar != null) {
            aVar.k(albumSocialInfoCacheData.isLiked, albumSocialInfoCacheData.albumLikeNum);
            this.J1.j(albumSocialInfoCacheData.commentNum);
        }
        S7(albumSocialInfoCacheData.isLiked, albumSocialInfoCacheData.albumLikeNum);
        R7(albumSocialInfoCacheData.commentNum);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W6() {
        String str;
        if (!com.qzone.album.util.h.a(this.Q)) {
            com.qzone.component.e eVar = new com.qzone.component.e();
            Activity activity = this.Q;
            eVar.h(activity, activity.getString(R.string.gao), this.Q.getString(R.string.gan), this.Q.getString(R.string.dk6), this.Q.getString(R.string.gmu), new ah(), null);
            return;
        }
        v7(this.Q);
        AlbumCacheData albumCacheData = this.f43008x0;
        if (albumCacheData != null) {
            str = albumCacheData.getLloc();
        } else {
            str = this.V;
        }
        QZoneAlbumUtil.p(this.P, 1, str, this.T, this.U, this.S.longValue());
        LpReportInfo_pf00064.allReport(219, 1, c2());
    }

    private void X6() {
        QZonePhotoListTimeLine qZonePhotoListTimeLine;
        if (this.W1 == null || (qZonePhotoListTimeLine = this.f43147e3) == null || qZonePhotoListTimeLine.i() == null) {
            return;
        }
        this.W1.N1(this.f43147e3.i());
        if (this.W1.z2() != null) {
            this.W1.z2().t();
        }
        this.f43147e3.B(null);
    }

    private void Y6(Context context) {
        try {
            CreateShortcutSucceedReceiver createShortcutSucceedReceiver = this.P4;
            if (createShortcutSucceedReceiver != null) {
                context.unregisterReceiver(createShortcutSucceedReceiver);
            }
        } catch (Throwable th5) {
            QZLog.e("[PhotoAlbum] ViewerModelController", 1, "destroyShortcutReceiver error ", th5);
        }
        this.P4 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a7(Bundle bundle) {
        this.A1 = this.f42940a0;
        u4.a.z().i0(this.Q);
        u4.a.z().i(this.Q);
        u4.a.z().M(this.Q, this.T, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c7(int i3, PhotoCacheData photoCacheData, List<PhotoCacheData[]> list, boolean z16, View view) {
        int i16;
        String str;
        if (photoCacheData.isFakePhoto()) {
            C7(i3);
            return;
        }
        if (this.f43008x0 == null) {
            return;
        }
        PhotoParam photoParam = new PhotoParam();
        photoParam.ownerUin = this.S.longValue();
        photoParam.albumid = this.T;
        photoParam.sortType = this.f42991r0;
        photoParam.uploadnum = this.f43003v0.size();
        photoParam.albumPriv = this.f42979n0;
        int i17 = this.f42976m0;
        if (i17 == 0) {
            i17 = this.f43003v0.size();
        }
        photoParam.albumnum = i17;
        photoParam.albumanswer = this.f42985p0;
        photoParam.busi_param = this.f42971k1;
        photoParam.albumType = this.f42940a0;
        photoParam.isShareAlbum = this.f43008x0.isSharingAlbumOnServer();
        if (this.O0) {
            photoParam.getPhotoExType = 6;
            photoParam.sharer = this.P0;
        } else {
            photoParam.getPhotoExType = 0;
            photoParam.sharer = 0L;
        }
        List<View> o26 = o2(z16);
        if (o26 != null && !o26.isEmpty() && ((o26.get(0) instanceof PhotoView) || (o26.get(0) instanceof BigPhotoView))) {
            View view2 = o26.get(0);
            if (view2.getTag() instanceof Integer) {
                i16 = ((Integer) view2.getTag()).intValue();
                PhotoCacheData Z1 = Z1(list, i16, z16);
                if (Z1 != null) {
                    i16 = Z1.index;
                }
                int i18 = i3 - i16;
                rk.a aVar = new rk.a();
                aVar.q(this.A0);
                aVar.g(i18);
                aVar.h(photoParam);
                aVar.i(1204);
                aVar.n(photoParam.albumType);
                aVar.p(photoCacheData.index);
                aVar.o(this.f43003v0.size());
                if (!(view instanceof ImageView)) {
                    aVar.f((ImageView) view);
                } else if (view instanceof PhotoView) {
                    aVar.f(((PhotoView) view).b());
                }
                ArrayList<PhotoCacheData> arrayList = this.A0;
                QLog.i("[PhotoAlbum] ViewerModelController", 1, "viewPhotoSize is " + (arrayList != null ? 0 : arrayList.size()) + ", index is " + i18);
                ((rk.e) ho.i.t(rk.e.class)).p(this.Q, aVar);
                com.qzone.album.env.common.a m3 = com.qzone.album.env.common.a.m();
                String[] strArr = new String[2];
                strArr[0] = z5();
                if (this.B1 != 1) {
                    str = "bigMode";
                } else {
                    str = "smallMode";
                }
                strArr[1] = str;
                m3.P(326, 2, "30", true, strArr);
            }
        }
        i16 = 0;
        int i182 = i3 - i16;
        rk.a aVar2 = new rk.a();
        aVar2.q(this.A0);
        aVar2.g(i182);
        aVar2.h(photoParam);
        aVar2.i(1204);
        aVar2.n(photoParam.albumType);
        aVar2.p(photoCacheData.index);
        aVar2.o(this.f43003v0.size());
        if (!(view instanceof ImageView)) {
        }
        ArrayList<PhotoCacheData> arrayList2 = this.A0;
        if (arrayList2 != null) {
        }
        QLog.i("[PhotoAlbum] ViewerModelController", 1, "viewPhotoSize is " + (arrayList2 != null ? 0 : arrayList2.size()) + ", index is " + i182);
        ((rk.e) ho.i.t(rk.e.class)).p(this.Q, aVar2);
        com.qzone.album.env.common.a m36 = com.qzone.album.env.common.a.m();
        String[] strArr2 = new String[2];
        strArr2[0] = z5();
        if (this.B1 != 1) {
        }
        strArr2[1] = str;
        m36.P(326, 2, "30", true, strArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e7(String str) {
        List<PhotoCacheData> list = this.f43003v0;
        if (list == null || list.size() <= 0) {
            return -1;
        }
        for (int i3 = 0; i3 < this.f43003v0.size(); i3++) {
            if (this.f43003v0.get(i3).unikey.equals(str)) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g7() {
        com.qzone.album.env.common.a.m().P(326, 2, "4", true, null);
        this.f43151o3 = true;
        this.f43152p3 = false;
        u4.a.z().Q(this.Q, this.T);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h7() {
        MaterialItem materialItem;
        AlbumCacheData albumCacheData = this.f43008x0;
        if (albumCacheData == null || (materialItem = albumCacheData.albumTemplate) == null || materialItem.iItemId < 0) {
            return;
        }
        u4.a.z().R(this.Q, com.qzone.album.env.common.a.m().s(), "default", this.f43008x0.albumTemplate.iItemId, QCircleScheme.AttrQQGroupDetail.PERSONAL, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j7(com.qzone.adapter.feedcomponent.s sVar) {
        if (sVar.getSucceed()) {
            if (!(sVar.getData() instanceof QZoneJoinShareAlbumRequest.a)) {
                QZLog.e("[PhotoAlbum] ViewerModelController", "resultWrapper.getData() is not an instance of QZoneJoinShareAlbumRequest.RespBean");
                return;
            } else {
                i7((QZoneJoinShareAlbumRequest.a) sVar.getData());
                return;
            }
        }
        if (TextUtils.isEmpty(sVar.getMessage())) {
            return;
        }
        com.qzone.album.env.common.a.m().W(sVar.getMessage(), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l7() {
        p4();
        this.f42962h1 = true;
    }

    private void q7() {
        if (this.n3 == null) {
            this.n3 = new h();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(QZoneJsConstants.QZoneAlbumSkinJsConstants.ACTION_ALBUM_SKIN_JS_TO_QZONE);
            intentFilter.addAction(QZoneJsConstants.BROADCAST_ACTION_UPDATE_ALBUM_COMMENT_LIST);
            intentFilter.addAction(QZoneJsConstants.BROADCAST_ACTION_REFRESH_PHOTO_LIST);
            this.Q.registerReceiver(this.n3, intentFilter);
        }
    }

    private void r7(Activity activity) {
        AlbumSocialInfoCacheData albumSocialInfoCacheData;
        this.J1 = new com.qzone.album.business.photolist.ui.interactingbar.a(this.Q, this, this.f43156r4);
        if (P2()) {
            this.J1.f(1);
        } else {
            this.J1.f(0);
        }
        b6();
        if (!P2() || (albumSocialInfoCacheData = this.D0) == null) {
            return;
        }
        T7(albumSocialInfoCacheData);
    }

    private void s7() {
        K1().m();
        this.f43150h3 = new com.qzone.album.business.photolist.ui.b(this);
        if (this.O0) {
            return;
        }
        y7();
    }

    private void u7() {
        K1().A(false);
        G4(null, true);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.W1.getListView().getLayoutParams();
        layoutParams.addRule(3, R.id.f166672ha0);
        this.W1.getListView().setLayoutParams(layoutParams);
        this.W1.getListView().setCoverMode(false);
        u0();
        M4(true);
        X5();
        if (this.W1.u() != null) {
            this.W1.u().setVisibility(8);
        }
        if (p2() == 4 && i3()) {
            y0(7);
        }
    }

    private void v7(Context context) {
        try {
            if (this.P4 == null) {
                this.P4 = new CreateShortcutSucceedReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(QZoneHelper.INTENT_ACTION_CREATE_ALBUM_SHORTCUT);
                context.registerReceiver(this.P4, intentFilter);
            }
        } catch (Throwable th5) {
            QZLog.e("[PhotoAlbum] ViewerModelController", 1, "initShortcutReceiver error ", th5);
        }
    }

    private void w7() {
        if (this.f43147e3 == null) {
            QZonePhotoListTimeLine qZonePhotoListTimeLine = new QZonePhotoListTimeLine(this.Q, this);
            this.f43147e3 = qZonePhotoListTimeLine;
            qZonePhotoListTimeLine.A(this.M4);
        }
    }

    private void x7() {
        if (this.W1.z2() == null || this.W1.z2().m() == null || this.f43150h3 == null) {
            return;
        }
        View m3 = this.W1.z2().m();
        if (this.f43147e3 == null) {
            w7();
        }
        this.f43147e3.p(m3);
        if (K1().j() != null && this.i3 == null) {
            View T = K1().j().T(this.f42943b0);
            this.i3 = T;
            T.setVisibility(8);
        }
    }

    private void y7() {
        if (this.W1 == null) {
            return;
        }
        x7();
        z7();
    }

    private void z7() {
        com.qzone.album.business.photolist.ui.b bVar;
        if (this.f43147e3 == null || (bVar = this.f43150h3) == null || bVar.c() == null) {
            return;
        }
        s4.e n3 = this.f43147e3.n(this.i3);
        n3.e(this.f43150h3.c());
        this.W1.i1(n3);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void A4() {
        super.V3(QZoneAlbumUtil.u(this.f42940a0, this.B1, this, null, P2(), this.f42943b0));
        if (B1() instanceof com.qzone.album.business.photolist.adapter.a) {
            ((com.qzone.album.business.photolist.adapter.a) B1()).D(this.H4);
            ((com.qzone.album.business.photolist.adapter.a) B1()).E(this.I4);
            ((com.qzone.album.business.photolist.adapter.a) B1()).B(!P2());
            ((com.qzone.album.business.photolist.adapter.a) B1()).z(this.O0);
        }
        this.W1.getListView().setAdapter((ListAdapter) B1());
        if (this.f42943b0) {
            if (this.f42941a1.e() != null) {
                this.f42941a1.m(false);
            }
            this.W1.getListView().setEmptyView(K1().f());
        } else {
            if (K1().i() != null) {
                K1().i().setVisibility(8);
            }
            this.W1.getListView().setEmptyView(this.f42941a1.e());
        }
        x2(this.f43003v0, false, g());
        this.f43155r3 = this.B1;
        if (h()) {
            a4();
        }
        com.qzone.album.business.photolist.ui.menu.b bVar = this.K1;
        if (bVar != null) {
            if (this.f43155r3 == 0) {
                bVar.u(true);
                this.K1.t(this.Q.getResources().getDrawable(R.drawable.f162196fy1));
            } else {
                bVar.u(false);
                this.K1.t(this.Q.getResources().getDrawable(R.drawable.f162198fy3));
            }
        }
    }

    public boolean A7() {
        int i3 = this.f42970k0;
        return i3 == 2 || i3 == 3 || i3 == 7;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void B3(Activity activity) {
        K1().x();
        if (this.X0 != null) {
            this.X0 = null;
        }
        if (h()) {
            a4();
        }
        if (this.Z1 || !this.Y1) {
            return;
        }
        x1();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void D2(com.qzone.adapter.feedcomponent.s sVar) {
        super.D2(sVar);
        f.a.a("qzone_photo_list_refresh_time");
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void D4() {
        AlbumCacheData albumCacheData;
        boolean z16 = false;
        if ((!P2() || ((albumCacheData = this.f43008x0) != null && (!(!albumCacheData.isSharingAlbumMember() || this.f43008x0.isShareInvitePanding() || this.f43008x0.isSharingAlbumApplicant()) || this.f43008x0.isSharingAlbumCreator()))) && this.f42970k0 != 1 && !U2() && !A7()) {
            z16 = true;
        }
        X3(z16);
    }

    public void D7() {
        if (this.D0 == null) {
            return;
        }
        u4.a.z().X(e0(), this.T, this.D0);
        AlbumSocialInfoCacheData albumSocialInfoCacheData = this.D0;
        boolean z16 = !albumSocialInfoCacheData.isLiked;
        albumSocialInfoCacheData.isLiked = z16;
        if (z16) {
            albumSocialInfoCacheData.albumLikeNum++;
        } else {
            albumSocialInfoCacheData.albumLikeNum--;
        }
        com.qzone.album.env.common.a.m().H(new Runnable() { // from class: com.qzone.album.business.photolist.controller.ViewerModelController.24
            @Override // java.lang.Runnable
            public void run() {
                ViewerModelController viewerModelController = ViewerModelController.this;
                viewerModelController.f43012z0.L0(viewerModelController.D0);
            }
        });
        com.qzone.album.business.photolist.ui.interactingbar.a aVar = this.J1;
        if (aVar != null) {
            AlbumSocialInfoCacheData albumSocialInfoCacheData2 = this.D0;
            aVar.k(albumSocialInfoCacheData2.isLiked, albumSocialInfoCacheData2.albumLikeNum);
        }
        AlbumSocialInfoCacheData albumSocialInfoCacheData3 = this.D0;
        S7(albumSocialInfoCacheData3.isLiked, albumSocialInfoCacheData3.albumLikeNum);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public View.OnClickListener G1() {
        if (this.f43158t3 == null) {
            this.f43158t3 = new al();
        }
        return this.f43158t3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void G4(List<PhotoCacheData> list, boolean z16) {
        super.G4(list, z16);
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (PhotoCacheData photoCacheData : list) {
                if (!photoCacheData.isFakePhoto() || !photoCacheData.isVideo()) {
                    arrayList.add(photoCacheData);
                }
            }
            list.clear();
            list.addAll(arrayList);
        }
        QzoneAlbumNoShootTimeHintView k3 = K1().k();
        if (this.Y1 && k3 == null) {
            K1().s();
            k3 = K1().k();
        }
        if (z16) {
            N7(k3, false);
            return;
        }
        if (!this.K0 && !P2() && k3 != null) {
            com.qzone.album.env.common.a.m().c("[PhotoAlbum]AlbumNoShootTime", "updateNoShootTimeView | add NoShootTimeHintView");
            N7(k3, true);
            this.K0 = true;
        }
        if (list != null) {
            if (k3 != null) {
                k3.setPhotoData(list);
            }
            if (list.size() == 0) {
                if (k3 != null) {
                    k3.setVisibility(8);
                }
                N7(k3, false);
                this.K0 = false;
            } else if (k3 != null) {
                k3.setNums((HashMap) this.f42971k1);
                k3.setVisibility(0);
            }
        } else {
            if (k3 != null) {
                k3.setVisibility(8);
            }
            N7(k3, false);
            this.K0 = false;
        }
        this.f43008x0 = g();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public View.OnClickListener H1() {
        if (this.f43157s3 == null) {
            this.f43157s3 = new ak();
        }
        return this.f43157s3;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void H3() {
        CellPictureInfo cellPictureInfo = new CellPictureInfo();
        cellPictureInfo.pics = new ArrayList<>();
        Iterator<PhotoCacheData> it = this.H0.iterator();
        while (it.hasNext()) {
            cellPictureInfo.pics.add(it.next().picItem);
        }
        if (cellPictureInfo.pics.size() > 0) {
            u4.a.z().e0(this.Q, cellPictureInfo, cellPictureInfo.pics.size() - 1, -1);
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.a
    public void J(s8.b bVar) {
        Object[] objArr;
        QZonePhotoListVipBar qZonePhotoListVipBar;
        PhotoCacheData photoCacheData;
        super.J(bVar);
        if ("WriteOperation".equals(bVar.a())) {
            int c16 = bVar.c();
            if (c16 != 7) {
                if (c16 == 48 && bVar.b() != null && (bVar.b() instanceof Object[])) {
                    Object[] objArr2 = (Object[]) bVar.b();
                    if (objArr2.length >= 4) {
                        Object obj = objArr2[0];
                        if ((obj instanceof Boolean) && (objArr2[2] instanceof String) && (objArr2[3] instanceof String) && (objArr2[4] instanceof String)) {
                            R5(((Boolean) obj).booleanValue(), (String) objArr2[2], (String) objArr2[3], (String) objArr2[4]);
                        }
                    }
                }
            } else if (bVar.b() != null && (bVar.b() instanceof Object[])) {
                Object[] objArr3 = (Object[]) bVar.b();
                if (objArr3.length == 6) {
                    Object obj2 = objArr3[0];
                    if (obj2 instanceof String) {
                        Object obj3 = objArr3[2];
                        if (obj3 instanceof String) {
                            Object obj4 = objArr3[3];
                            if ((obj4 instanceof Integer) && (objArr3[4] instanceof Integer)) {
                                String str = (String) obj2;
                                String str2 = (String) obj3;
                                Integer num = (Integer) obj4;
                                if (num.intValue() >= 0 && num.intValue() < this.f43003v0.size()) {
                                    if (((Integer) objArr3[4]).intValue() == 0) {
                                        if ((TextUtils.isEmpty(str2) || !this.f43003v0.get(num.intValue()).unikey.equals(str2)) && (TextUtils.isEmpty(str) || !this.f43003v0.get(num.intValue()).pssUgcKey.equals(str))) {
                                            int i3 = 0;
                                            while (true) {
                                                if (i3 >= this.f43003v0.size()) {
                                                    photoCacheData = null;
                                                    break;
                                                } else {
                                                    if (this.f43003v0.get(i3).unikey.equals(str2)) {
                                                        photoCacheData = this.f43003v0.get(i3);
                                                        break;
                                                    }
                                                    i3++;
                                                }
                                            }
                                        } else {
                                            photoCacheData = this.f43003v0.get(num.intValue());
                                        }
                                        if (photoCacheData != null) {
                                            int i16 = photoCacheData.mylike == 0 ? 1 : 0;
                                            photoCacheData.mylike = i16;
                                            if (i16 == 1) {
                                                photoCacheData.likenum++;
                                            } else {
                                                int i17 = photoCacheData.likenum;
                                                if (i17 > 0) {
                                                    photoCacheData.likenum = i17 - 1;
                                                }
                                            }
                                            B1().notifyDataSetChanged();
                                        }
                                    } else {
                                        com.qzone.album.env.common.a.m().W(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastLikeFailWait", "\u70b9\u8d5e\u5931\u8d25,\u8bf7\u7a0d\u5019\u518d\u8bd5"), 1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if ("QzoneAlbum".equals(bVar.a())) {
            if (bVar.c() != 30) {
                return;
            }
            QZLog.i("[PhotoAlbum] ViewerModelController", 4, "viewModelController getMore");
            if (bVar.b() == null || !(bVar.b() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) bVar.b()).intValue();
            if (intValue == 2) {
                m0();
                return;
            } else {
                if (intValue == 1) {
                    p1();
                    return;
                }
                return;
            }
        }
        if ("Vip".equals(bVar.a()) && bVar.b() != null && (bVar.b() instanceof Object[])) {
            int c17 = bVar.c();
            if ((c17 == 2 || c17 == 4) && (objArr = (Object[]) bVar.b()) != null && objArr.length > 0) {
                Object obj5 = objArr[0];
                if (!(obj5 instanceof r5.a) || (qZonePhotoListVipBar = this.f43144c3) == null) {
                    return;
                }
                qZonePhotoListVipBar.f((r5.a) obj5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void J2() {
        super.J2();
        Resources resources = getResources();
        if (resources != null) {
            this.N1 = resources.getDimensionPixelSize(R.dimen.amp);
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void J3(int i3, long j3, long j16) {
        QZonePhotoListTimeLine qZonePhotoListTimeLine = this.f43147e3;
        if (qZonePhotoListTimeLine != null) {
            qZonePhotoListTimeLine.t(i3, j3, j16);
        }
    }

    public void J7() {
        QZonePhotoListTimeLine qZonePhotoListTimeLine = this.f43147e3;
        if (qZonePhotoListTimeLine != null) {
            qZonePhotoListTimeLine.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void K2() {
        super.K2();
        if (this.f42943b0) {
            M1(1);
            this.f43155r3 = this.B1;
        }
        super.V3(QZoneAlbumUtil.u(this.f42940a0, this.B1, this, null, P2(), this.f42943b0));
        if (B1() instanceof com.qzone.album.business.photolist.adapter.z) {
            ((com.qzone.album.business.photolist.adapter.z) B1()).j(this.J4);
        } else {
            ((com.qzone.album.business.photolist.adapter.a) B1()).B(!P2());
            ((com.qzone.album.business.photolist.adapter.a) B1()).z(this.O0);
            this.W1.getListView().setOnScrollListener(new ai());
            ((com.qzone.album.business.photolist.adapter.a) B1()).D(this.H4);
            ((com.qzone.album.business.photolist.adapter.a) B1()).E(this.I4);
        }
        if (i3()) {
            this.W1.getListView().setInterceptTouchEventListener(new aj());
        }
        O2(true);
        s7();
        if (this.f42943b0) {
            if (this.f42941a1.e() != null) {
                this.f42941a1.m(false);
            }
            this.W1.getListView().setEmptyView(K1().f());
        }
        this.W1.getListView().setAdapter((ListAdapter) B1());
        this.W1.getListView().setSupportPullUp(true);
        E4();
        if (this.O0) {
            u7();
        }
    }

    public void K7() {
        u4.h hVar = this.W1;
        if (hVar == null || this.f43147e3 == null) {
            return;
        }
        hVar.z2().I();
        this.f43007w1 = true;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.a
    public boolean M(Activity activity) {
        int i3 = this.f42970k0;
        if (i3 != 0) {
            if (i3 == 3) {
                DownloadQueue.j().f();
            }
            Z0(true);
            LpReportInfo_pf00064.allReport(86, 3, 1);
            return true;
        }
        QZonePhotoListTimeLine qZonePhotoListTimeLine = this.f43147e3;
        if (qZonePhotoListTimeLine != null && qZonePhotoListTimeLine.j() == 0) {
            this.f43147e3.E(false);
            return true;
        }
        com.qzone.album.business.photolist.controller.d dVar = this.f42945b2;
        if (dVar != null && dVar.z() == 0) {
            this.f42945b2.K(false);
            return true;
        }
        P3(false);
        return false;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void M4(boolean z16) {
        QZonePhotoListTimeLine qZonePhotoListTimeLine = this.f43147e3;
        if (qZonePhotoListTimeLine == null) {
            return;
        }
        if (!z16 && this.f42970k0 != 4) {
            qZonePhotoListTimeLine.F(this.f43008x0);
        } else {
            qZonePhotoListTimeLine.E(false);
            this.f43147e3.k().setVisibility(8);
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.a
    public void N(Activity activity) {
        f.a.b("qzone_photo_list_init_time");
        super.N(activity);
        q7();
        f.a.a("qzone_photo_list_init_time");
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public View.OnClickListener N1() {
        return new am();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void N2() {
        u4.h hVar;
        super.N2();
        if (h() && !Q2()) {
            u4.h hVar2 = this.W1;
            if (hVar2 != null) {
                hVar2.u().setVisibility(0);
            }
            t7();
            this.j3 = new d();
            u4.h hVar3 = this.W1;
            if (hVar3 != null && hVar3.z2() != null && this.W1.z2().g() != null) {
                this.W1.z2().q();
                this.W1.z2().g().setOnClickListener(this.j3);
            }
        }
        if ((!k3() && !n7()) || (hVar = this.W1) == null || hVar.z2() == null) {
            return;
        }
        this.W1.z2().q();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void N4() {
        QZonePhotoListTimeLine qZonePhotoListTimeLine;
        if (this.O0 || (qZonePhotoListTimeLine = this.f43147e3) == null) {
            return;
        }
        qZonePhotoListTimeLine.G();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.a
    public void O(Activity activity) {
        super.O(activity);
        K1().u();
        BroadcastReceiver broadcastReceiver = this.n3;
        if (broadcastReceiver != null) {
            this.Q.unregisterReceiver(broadcastReceiver);
        }
        if (B1() != null && !(B1() instanceof com.qzone.album.business.photolist.adapter.z)) {
            ((com.qzone.album.business.photolist.adapter.a) B1()).u();
        }
        c6();
        Y6(activity);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public boolean O2(boolean z16) {
        j0(z16);
        if (this.P1 == null && k3()) {
            LinearLayout linearLayout = new LinearLayout(this.Q);
            this.P1 = linearLayout;
            linearLayout.setOrientation(1);
            this.P1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.Q.getLayoutInflater().inflate(R.layout.bsw, this.P1);
            this.P1.setVisibility(8);
            if (m2() != null) {
                m2().addView(this.P1, 0);
            }
        }
        if (this.f42942a2 == null) {
            this.f42942a2 = new com.qzone.album.business.photolist.ui.d(this);
        }
        if (this.Q1 == null) {
            LinearLayout linearLayout2 = new LinearLayout(this.Q);
            this.Q1 = linearLayout2;
            linearLayout2.setOrientation(1);
            Resources resources = getResources();
            this.Q1.setLayoutParams(new AbsListView.LayoutParams(-1, resources != null ? resources.getDimensionPixelSize(R.dimen.aqo) : 0));
            this.Q1.setVisibility(0);
            if (m2() != null) {
                m2().addView(this.Q1, -1);
            }
        }
        super.O2(z16);
        return true;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void O4(boolean z16) {
        View l3;
        if (P2()) {
            if (this.W1.z2() != null) {
                if (this.f42948c2) {
                    this.W1.z2().H();
                } else {
                    this.W1.z2().s();
                }
                this.W1.z2().q();
            }
            com.qzone.album.business.photolist.ui.menu.b bVar = this.K1;
            if (bVar != null) {
                bVar.q(this.f42943b0);
                return;
            }
            return;
        }
        if (z16) {
            com.qzone.album.business.photolist.ui.menu.b bVar2 = this.K1;
            if (bVar2 != null) {
                bVar2.w();
            }
            if (this.W1 != null) {
                com.qzone.album.business.photolist.ui.interactingbar.a aVar = this.J1;
                if (aVar != null) {
                    aVar.d(false);
                }
                if (this.W1.z2() != null) {
                    this.W1.z2().s();
                    this.W1.z2().t();
                    this.W1.z2().F();
                    return;
                }
                return;
            }
            return;
        }
        com.qzone.album.business.photolist.ui.menu.b bVar3 = this.K1;
        if (bVar3 != null) {
            bVar3.x(this.f42940a0);
        }
        if (this.W1.z2() != null) {
            if (this.f42945b2.q(this.f43008x0)) {
                q4();
                if (this.f42970k0 == 1 && (l3 = this.W1.z2().l()) != null && l3.getVisibility() == 0 && this.f42948c2) {
                    this.W1.z2().s();
                }
            }
            this.W1.z2().q();
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.a
    public void P(Activity activity) {
        if (!this.M0.c() && !this.M0.d()) {
            this.M0.a();
        }
        K1().v();
        this.f43154q3 = false;
        D4();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void Q4() {
        if (this.P1 != null) {
            if (k3() && this.f42970k0 == 0 && com.qzone.album.env.common.a.m().t("QZoneSetting", QzoneConfig.SECONDARY_VIDEO_FOOTER, 1) == 1 && !P2()) {
                this.P1.setVisibility(0);
            } else {
                this.P1.setVisibility(8);
            }
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public View.OnClickListener R1() {
        if (this.f43143b4 == null) {
            this.f43143b4 = new b();
        }
        return this.f43143b4;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.a
    public void S(Activity activity) {
        super.S(activity);
        if (this.M0.c()) {
            this.M0.b();
        } else if (this.M0.d()) {
            this.M0.g(false);
        }
        this.B0 = true;
        BasePhotoModelController.I2(this.P, this.Q.getWindow().peekDecorView());
        if (this.f43152p3) {
            this.f43152p3 = false;
            o0();
        }
        this.f43151o3 = false;
        K1().w();
        this.f43154q3 = true;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public View.OnClickListener S1() {
        if (this.f43159x3 == null) {
            this.f43159x3 = new an();
        }
        return this.f43159x3;
    }

    public void S6() {
        QZonePhotoListTimeLine qZonePhotoListTimeLine = this.f43147e3;
        if (qZonePhotoListTimeLine != null) {
            qZonePhotoListTimeLine.e();
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public View.OnClickListener T1() {
        return new x();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public View.OnClickListener U1() {
        if (this.f43146d4 == null) {
            this.f43146d4 = new c();
        }
        return this.f43146d4;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public View.OnClickListener V1() {
        return new z();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public ao W1() {
        return new ao();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public View.OnClickListener X1() {
        if (this.f43160y3 == null) {
            this.f43160y3 = new a();
        }
        return this.f43160y3;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void Z0(boolean z16) {
        View l3;
        getListView().setSupportPullDown(true);
        if (this.f42970k0 == 3) {
            DownloadQueue.j().f();
        }
        int i3 = this.f42970k0;
        this.f42970k0 = 0;
        if (this.T1) {
            this.T1 = false;
            com.qzone.album.business.photolist.ui.d dVar = this.f42942a2;
            if (dVar != null && dVar.h()) {
                this.f42942a2.l(0);
            }
        }
        this.f42950d1 = false;
        this.f42953e1 = false;
        this.L1 = null;
        if (i3 != 1) {
            K1().A(true);
        }
        if (this.W1.z2() != null && this.W1.z2().l() != null && (l3 = this.W1.z2().l()) != null && l3.getVisibility() == 8 && this.f42948c2) {
            this.W1.z2().H();
        }
        if (this.f43155r3 == 1) {
            this.B1 = 1;
            V3(QZoneAlbumUtil.u(this.f42940a0, 1, this, null, P2(), this.f42943b0));
            this.W1.getListView().setAdapter((ListAdapter) B1());
        }
        if (B1() != null) {
            ((com.qzone.album.business.photolist.adapter.a) B1()).y(false);
            ((com.qzone.album.business.photolist.adapter.a) B1()).x(false);
            ((com.qzone.album.business.photolist.adapter.a) B1()).B(com.qzone.album.env.common.a.m().s() == this.S.longValue());
            ((com.qzone.album.business.photolist.adapter.a) B1()).D(this.H4);
            ((com.qzone.album.business.photolist.adapter.a) B1()).E(this.I4);
            ((com.qzone.album.business.photolist.adapter.a) B1()).z(this.O0);
            ((com.qzone.album.business.photolist.adapter.a) B1()).F(0);
        }
        K1().e(false);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.W1.getListView().getLayoutParams();
        layoutParams.addRule(3, -1);
        this.W1.getListView().setLayoutParams(layoutParams);
        this.W1.getListView().setCoverMode(true, BasePhotoModelController.f42936w2);
        i4();
        Z3();
        if (this.W1.u() != null) {
            this.W1.u().setVisibility(8);
        }
        d6(z16, i3);
        g1();
        M4(false);
        Q4();
        if (B1() != null) {
            HdAsync.with(this).then(new l(com.qzone.album.env.common.a.m().u().getLooper())).then(new k(Looper.getMainLooper())).call();
        }
        if (p2() == 7) {
            y0(4);
        }
        if (QZoneAlbumUtil.A(i3)) {
            u0();
            this.X1 = true;
            o0();
            LpReportInfo_pf00064.allReport(326, 3, 2);
        } else if (this.f42973l0) {
            this.f42973l0 = false;
            this.f42974l1 = "2";
            o0();
            this.f42945b2.G(true);
        }
        D4();
    }

    public void b7(int i3) {
        getListView().setSupportPullDown(false);
        Y3(i3);
        this.f42970k0 = i3;
        this.f42950d1 = true;
        this.f42953e1 = true;
        if (k3()) {
            com.qzone.album.env.common.a.m().R("354", "1", "");
            this.J0 = BasePhotoModelController.C2;
            this.P1.setVisibility(8);
        } else {
            this.J0 = BasePhotoModelController.f42939z2;
        }
        if (this.B1 == 1) {
            this.B1 = 0;
            super.V3(QZoneAlbumUtil.u(this.f42940a0, 0, this, null, P2(), this.f42943b0));
            this.W1.getListView().setAdapter((ListAdapter) B1());
        }
        ((com.qzone.album.business.photolist.adapter.a) B1()).y(true);
        ((com.qzone.album.business.photolist.adapter.a) B1()).A(V2(this.f42970k0));
        ((com.qzone.album.business.photolist.adapter.a) B1()).B(com.qzone.album.env.common.a.m().s() == this.S.longValue());
        ((com.qzone.album.business.photolist.adapter.a) B1()).z(this.O0);
        ((com.qzone.album.business.photolist.adapter.a) B1()).F(i3);
        if (QZoneAlbumUtil.A(i3)) {
            K1().A(false);
            G4(null, true);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.W1.getListView().getLayoutParams();
            layoutParams.addRule(3, R.id.f166672ha0);
            this.W1.getListView().setLayoutParams(layoutParams);
            this.W1.getListView().setCoverMode(false);
            u0();
            if (i3 == 4) {
                ((com.qzone.album.business.photolist.adapter.a) B1()).y(false);
                f4(R.string.gcd, this.D4, true);
            } else if (i3 == 5) {
                this.W1.u().setVisibility(8);
            }
            if (this.W1.z2() != null) {
                this.W1.z2().a();
            }
            LpReportInfo_pf00064.allReport(326, 3, 1);
        } else if (i3 == 1) {
            K1().e(true);
        }
        M4(true);
        if (this.H0 == null) {
            this.H0 = new ArrayList();
        } else {
            g1();
        }
        i4();
        Z3();
        X5();
        if (p2() == 4 && i3()) {
            y0(7);
        }
        f6(i3);
        if (this.W1.z2() != null) {
            this.W1.z2().b();
            View l3 = this.W1.z2().l();
            if (l3 != null && l3.getVisibility() == 0 && this.f42948c2) {
                this.W1.z2().s();
            }
            this.W1.z2().t();
        }
        if (QZoneAlbumUtil.A(i3) && this.f42986p1 >= 0) {
            this.f42962h1 = true;
            a0();
        }
        X3(false);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, x4.a
    public boolean c() {
        QZonePhotoListTimeLine qZonePhotoListTimeLine = this.f43147e3;
        if (qZonePhotoListTimeLine != null) {
            return qZonePhotoListTimeLine.f();
        }
        return super.c();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected boolean d1(int i3) {
        QZonePhotoListTimeLine qZonePhotoListTimeLine;
        if (this.f43004v1 || (qZonePhotoListTimeLine = this.f43147e3) == null) {
            return false;
        }
        return qZonePhotoListTimeLine.m(i3);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public View.OnClickListener d2() {
        return new w();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, x4.a
    public void e(PhotoCacheData photoCacheData, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("comment_single_photo_or_video_unikey", photoCacheData.unikey);
        bundle.putInt("comment_single_photo_or_video_position", i3);
        u4.a.z().b0(H(), bundle);
    }

    protected void f7() {
        if (this.f43010y0 != null) {
            if (this.f43001u1) {
                if (d1(2)) {
                    J3(2, 0L, 0L);
                    m1(2);
                    return;
                } else {
                    if (this.f42962h1) {
                        w2();
                        return;
                    }
                    return;
                }
            }
            this.f43001u1 = false;
            w2();
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, x4.a
    public View.OnClickListener i() {
        return new ao();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public View.OnClickListener i2(int i3) {
        return new y(i3);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public View.OnClickListener j2() {
        View.OnClickListener onClickListener = this.f43153p4;
        if (onClickListener != null) {
            return onClickListener;
        }
        t tVar = new t();
        this.f43153p4 = tVar;
        return tVar;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public View.OnClickListener k2() {
        return new u();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void l3() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).post(new AnonymousClass13());
    }

    protected boolean m7() {
        QZonePhotoListTimeLine qZonePhotoListTimeLine = this.f43147e3;
        if (qZonePhotoListTimeLine != null) {
            return qZonePhotoListTimeLine.f();
        }
        return false;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void n3(boolean z16) {
        HdAsync.with(this).then(new ad(com.qzone.album.env.common.a.m().u().getLooper())).then(new s(Looper.getMainLooper(), z16)).call();
    }

    public boolean n7() {
        return u4.e.d().g() || u4.e.d().e() != 0 || u4.e.d().f() || u4.e.d().c() != 0;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void o1() {
        f.a.b("qzone_photo_list_init_data_time");
        if (Q2()) {
            z4();
        } else {
            n3(true);
        }
        X();
        U6();
        f.a.a("qzone_photo_list_init_data_time");
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void o3() {
        List<PhotoCacheData> list;
        AlbumCacheData albumCacheData;
        if (!this.f43154q3 || (list = this.f43003v0) == null || list.size() == 0 || (albumCacheData = this.f43008x0) == null || !albumCacheData.isLoveAlbum()) {
            return;
        }
        com.qzone.album.base.Service.a.W().S(new j());
    }

    protected void o7() {
        u4.h hVar = this.W1;
        if (hVar != null && hVar.z2() != null && this.W1.z2().l() != null) {
            this.W1.z2().s();
        }
        this.f42948c2 = false;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void p1() {
        if (this.f43001u1 && d1(1)) {
            J3(1, 0L, 0L);
            m1(1);
        }
    }

    public void p7() {
        QZonePhotoListTimeLine qZonePhotoListTimeLine;
        if (this.W1 == null || (qZonePhotoListTimeLine = this.f43147e3) == null || qZonePhotoListTimeLine.l() == null || this.W1.z2() == null) {
            return;
        }
        if (this.W1.z2().m() != null) {
            this.W1.z2().t();
        } else {
            QZLog.w("[PhotoAlbum] ViewerModelController", "hideTimeLineTitlebarBtn() error!  timeLineBtnInTitle is null");
        }
        this.f43007w1 = false;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void q1() {
        f.a.b("qzone_photo_list_init_ui_time");
        this.W1.j1(R.layout.bo6);
        l4(true);
        N2();
        K2();
        if (!this.O0) {
            if (this.f42945b2 == null) {
                L2();
            }
            w7();
        }
        this.f43144c3 = new QZonePhotoListVipBar(this);
        if (!k3() && !this.O0) {
            r7(this.Q);
        }
        if (!G().getBooleanExtra("isPhotoListActivityNeedTitleBar", true)) {
            u4.a.z().j0(this.f407174e, 8);
        }
        f.a.a("qzone_photo_list_init_ui_time");
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void q4() {
        u4.h hVar;
        if (this.f42945b2 == null || (hVar = this.W1) == null || hVar.z2() == null || this.W1.z2().k() == null || this.f42970k0 != 0 || this.O0) {
            return;
        }
        ImageView k3 = this.W1.z2().k();
        if (k3 != null) {
            k3.setOnClickListener(new ac());
        }
        this.W1.z2().H();
        X6();
        this.f42948c2 = true;
        com.qzone.album.env.common.a.m().P(326, 2, "45", true, "");
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void r1() {
        String str;
        boolean z16;
        if (Q2()) {
            return;
        }
        if (!e1()) {
            com.qzone.album.env.common.a.m().U(R.string.gdc);
            return;
        }
        f.a.b("qzone_photo_list_refresh_time", "qzone_photo_list_refresh_net_time");
        String str2 = "";
        if (G() == null) {
            str = "";
            z16 = false;
        } else {
            boolean isEmpty = TextUtils.isEmpty(G().getStringExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_INVITE_KEY));
            if (!isEmpty) {
                str2 = G().getStringExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_INVITE_KEY);
            }
            z16 = G().getBooleanExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_IS_PUBLIC, false) && !isEmpty;
            str = str2;
        }
        AlbumCacheData albumCacheData = this.f43008x0;
        this.f43010y0.g1(this.T, this.U, this.S.longValue(), albumCacheData != null && albumCacheData.isSharingAlbum(), z16, str, this.E4);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void r4() {
        if (this.f43145d3 == null) {
            l4.a aVar = new l4.a(this.Q);
            this.f43145d3 = aVar;
            aVar.d(new f());
        }
        this.f43145d3.e(this.f42991r0);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, x4.a
    public void t(PhotoCacheData photoCacheData, int i3) {
        this.f43010y0.b1(e0(), photoCacheData, i3);
    }

    public void t7() {
        Resources resources;
        int i3;
        com.qzone.album.business.photolist.ui.menu.b bVar = new com.qzone.album.business.photolist.ui.menu.b(this.Q);
        this.K1 = bVar;
        bVar.p(P2(), this.f42940a0);
        this.K1.l(this.C4);
        if (P2() && this.f42943b0) {
            this.K1.q(true);
        }
        boolean z16 = this.B1 == 0;
        this.K1.u(z16);
        com.qzone.album.business.photolist.ui.menu.b bVar2 = this.K1;
        if (z16) {
            resources = getResources();
            i3 = R.drawable.f162196fy1;
        } else {
            resources = getResources();
            i3 = R.drawable.f162198fy3;
        }
        bVar2.t(resources.getDrawable(i3));
        this.f43155r3 = this.B1;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void v4(int i3) {
        String str;
        int i16 = this.f42946c0 == 1 ? 101 : 13;
        AlbumCacheData g16 = g();
        this.f43008x0 = g16;
        String str2 = this.T;
        int i17 = g16 == null ? Integer.MIN_VALUE : g16.albumtype;
        if (g16 != null && g16.isSharingAlbumPartner()) {
            String shareAlbumId = this.f43008x0.getShareAlbumId();
            if (!TextUtils.isEmpty(shareAlbumId)) {
                str = shareAlbumId;
                u4.a.z().p0(this.Q, str, this.U, this.V, this.Z, i3, z5(), i17, i16);
            }
        }
        str = str2;
        u4.a.z().p0(this.Q, str, this.U, this.V, this.Z, i3, z5(), i17, i16);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void w4() {
        com.qzone.album.env.common.a.m().R("354", "3", "");
        u4.a.z().o0(this.Q, null, null, null, this.Z, 10, z5());
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void x2(List<? extends com.qzone.component.cache.database.a> list, boolean z16, AlbumCacheData albumCacheData) {
        super.x2(list, z16, albumCacheData);
        T6();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void y4(boolean z16) {
        if (K1().k() == null) {
            return;
        }
        if (z16 && K1().k().b()) {
            if (this.K0) {
                return;
            }
            K1().d(0);
            return;
        }
        K1().y(0);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public View.OnClickListener z1() {
        return new v();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void z3(String str, ArrayList<PhotoCacheData> arrayList) {
        QZLog.d("QZP2V", 4, "onGetP2VRecommendData:" + str + ";size:" + arrayList.size());
        this.H2 = str;
        this.I2 = arrayList;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ae implements AbsCompatRequest.a {
        ae() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            if (sVar != null) {
                if (sVar.getSucceed()) {
                    com.qzone.album.env.common.a.m().W(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastForwardYet", "\u5df2\u8f6c\u53d1"), 2);
                } else {
                    com.qzone.album.env.common.a.m().W(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastForwardFailWait", "\u8f6c\u53d1\u5931\u8d25,\u8bf7\u7a0d\u5019\u91cd\u8bd5\u3002"), 1);
                    com.qzone.album.env.common.a.m().b("[PhotoAlbum] ViewerModelController", "OnForwardAlbum fail");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class h extends BroadcastReceiver {
        h() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if (intent.getAction().equals(QZoneJsConstants.QZoneAlbumSkinJsConstants.ACTION_ALBUM_SKIN_JS_TO_QZONE)) {
                    ViewerModelController viewerModelController = ViewerModelController.this;
                    if (viewerModelController.f43151o3) {
                        viewerModelController.f43152p3 = true;
                        com.qzone.adapter.feedcomponent.e.a(u4.a.z().E(), 17, null);
                        return;
                    }
                    return;
                }
                if (intent.getAction().equals(QZoneJsConstants.BROADCAST_ACTION_UPDATE_ALBUM_COMMENT_LIST)) {
                    ViewerModelController.this.Q7(intent.getIntExtra(QZoneHelper.QZoneAlbumConstants.KEY_ALBUM_UPDATE_COMMENT_LIST_COUNT, -1));
                } else if (intent.getAction().equals(QZoneJsConstants.BROADCAST_ACTION_REFRESH_PHOTO_LIST)) {
                    ViewerModelController.this.f43152p3 = true;
                    com.qzone.adapter.feedcomponent.e.a(u4.a.z().E(), 17, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B7() {
        this.f43004v1 = false;
        i1();
    }

    private void k7(AbsListView absListView) {
        View childAt = absListView.getChildAt(0);
        if (childAt != null) {
            float y16 = childAt.getY();
            float f16 = this.l3;
            if (f16 == 2.14748365E9f) {
                this.l3 = y16;
            } else if (y16 - f16 < -10.0f) {
                try {
                    K1().j().U();
                } catch (NullPointerException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public void d7() {
        b7(1);
        this.T1 = true;
        this.W1.setTitle(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumQuoteBatch", "\u6279\u91cf\u8f6c\u8f7d"));
        com.qzone.album.business.photolist.ui.d dVar = this.f42942a2;
        if (dVar != null) {
            dVar.l(8);
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void v2() {
        this.f43004v1 = false;
        BaseAdapter B1 = B1();
        boolean i3 = B1 instanceof com.qzone.album.business.photolist.adapter.a ? ((com.qzone.album.business.photolist.adapter.a) B1).i() : false;
        int count = B1().getCount();
        int i16 = this.f42969j2;
        if (i16 == 0) {
            if (!i3() && !e3() && !Y2()) {
                getListView().scrollToTop();
            } else {
                getListView().setSelection(count - (i3 ? ((this.f42968j1.size() / 3) + 3) + 1 : 1));
            }
            this.W1.m0(255);
        } else if (i16 != 1) {
            if (i16 == 2) {
                this.W1.m0(255);
            }
        } else if (count - this.f42972k2 > 0) {
            this.W1.getListView().setSelection((count - this.f42972k2) + 1);
            this.W1.m0(255);
        }
        this.W1.y();
        com.qzone.album.business.photolist.ui.d dVar = this.f42942a2;
        if (dVar != null && dVar.h()) {
            this.f42942a2.j(true);
            this.f42942a2.k(8);
            View d06 = d0();
            if (d06 != null) {
                d06.setVisibility(0);
            }
        }
        B7();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class aj implements QzoneGestureSelectListView.a {
        aj() {
        }

        @Override // com.qzone.album.ui.widget.QzoneGestureSelectListView.a
        public boolean a(View view) {
            return view != null && ViewerModelController.this.i3() && view == ViewerModelController.this.K1().h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V6() {
        if (this.f43008x0 != null) {
            u4.a.z().i0(this.Q);
            u4.a.z().h(this.Q);
            AlbumCacheData albumCacheData = this.f43008x0;
            long j3 = albumCacheData.createSharingUin;
            if (j3 == 0) {
                j3 = albumCacheData.ownerUin;
            }
            u4.a.z().N(this.Q, this.T, j3, this.f43008x0.loginUin, this.f43149g3);
            com.qzone.album.env.common.a.m().P(326, 14, "3", true, null);
        }
    }

    private void i7(QZoneJoinShareAlbumRequest.a aVar) {
        String config;
        if (aVar != null && aVar.f43949a == 0) {
            if (aVar.f43951c) {
                this.f43008x0.setShareStatusToConfirm();
                M3(this.f43008x0);
                K1().C();
                D4();
                config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastAddToAlbumSuccess", "\u6210\u529f\u52a0\u5165\uff0c\u8be5\u76f8\u518c\u5c06\u5728\u4f60\u7684\u7a7a\u95f4\u76f8\u518c\u5217\u8868\u5c55\u793a");
            } else {
                config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ApplySend", "\u5df2\u53d1\u9001\u7533\u8bf7\uff0c\u5f85\u521b\u5efa\u8005\u5ba1\u6838");
            }
            com.qzone.album.env.common.a.m().W(config, 5);
            c0();
            return;
        }
        QZLog.e("[PhotoAlbum] ViewerModelController", "joinShareAlbumRequest() QZoneJoinShareAlbumRequest.RespBean is null or respBean.ret == 0!");
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void C4(List<PhotoCacheData> list) {
        if (list != null && list.size() > 0) {
            AlbumCacheData g16 = g();
            this.f43008x0 = g16;
            if (g16 == null) {
                return;
            }
            if (g16.getAlbumThemeTypeValue() == 8 || this.f43008x0.getAlbumThemeTypeValue() == 9 || this.f43008x0.getAlbumThemeTypeValue() == 11) {
                if (K1().g() == null) {
                    K1().l();
                }
                if (K1().g() != null) {
                    K1().g().setAlbumData(this.f43008x0);
                    K1().g().setPhotoData(list);
                    K1().g().d();
                    return;
                }
                return;
            }
            return;
        }
        if (K1().g() != null) {
            K1().g().a();
            K1().g().d();
        }
    }

    public void I7() {
        AlbumCacheData albumCacheData;
        AlbumCacheData albumCacheData2;
        int i3;
        I3();
        this.f43009x1 = null;
        this.f43001u1 = false;
        this.f43013z1 = -1;
        BannerAttachInfo bannerAttachInfo = new BannerAttachInfo(this.W, this.X);
        if (Q2()) {
            this.f43010y0.u1(this.S.longValue(), this.T, this.f42985p0, null, this.f42989q1, this.f42950d1 ? this.f42971k1 : null, 1, this.f42991r0, this.U0, this.f42993r2, bannerAttachInfo);
        } else if (this.O0 && (albumCacheData = this.f43008x0) != null) {
            this.f43010y0.D1(albumCacheData.ownerUin, this.T, this.f42985p0, this.f42991r0, "", null, this.f42989q1, this.f42950d1 ? this.f42971k1 : null, this.U0, "", 1, 2, this.P0, this.f42993r2, bannerAttachInfo);
        } else {
            this.f43010y0.u1(this.S.longValue(), this.T, this.f42985p0, null, this.f42989q1, this.f42971k1, this.f42940a0, this.f42991r0, this.U0, this.f42993r2, bannerAttachInfo);
        }
        if (this.f43008x0 == null || S2() || (i3 = (albumCacheData2 = this.f43008x0).albumtype) == 8 || i3 == 9) {
            return;
        }
        if (albumCacheData2.individual == 0 && P2()) {
            return;
        }
        com.qzone.album.base.Service.a.W().s0(P2(), this.G4);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void l1() {
        if (this.f43001u1 && !this.f42962h1) {
            if (d1(2)) {
                J3(2, 0L, 0L);
                m1(2);
                return;
            }
            return;
        }
        if (this.f42962h1) {
            f7();
            return;
        }
        if (com.qzone.album.base.b.a(BasePhotoModelController.I1(this.S.longValue(), this.T, this.f42955f0))) {
            I3();
            if (this.O0) {
                this.f43010y0.z0(this.f43008x0.ownerUin, this.T, this.f42985p0, this.f42991r0, this.f42988q0, null, this.f42989q1, this.f42971k1, this.f42940a0, this.f42950d1, this.f42996s2, 2, this.P0);
            } else {
                this.f43010y0.g0(this.S.longValue(), this.T, this.f42985p0, this.f42991r0, this.f42988q0, null, this.f42989q1, this.f42971k1, this.f42940a0, this.f42950d1, this.f42996s2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e extends com.qzone.album.business.photolist.ui.interactingbar.d {
        e() {
        }

        @Override // com.qzone.album.business.photolist.ui.interactingbar.d, com.qzone.album.business.photolist.ui.interactingbar.a.InterfaceC0344a
        public void a(View view) {
            com.qzone.album.env.common.a.m().P(326, 2, "12", true, null);
            AlbumCacheData albumCacheData = ViewerModelController.this.f43008x0;
            if (albumCacheData != null && albumCacheData.isSharingAlbumOnServer()) {
                u4.a.z().a0(ViewerModelController.this.Q, false);
            } else {
                u4.a.z().a0(ViewerModelController.this.Q, true);
            }
        }

        @Override // com.qzone.album.business.photolist.ui.interactingbar.a.InterfaceC0344a
        public void b(View view, boolean z16) {
            com.qzone.album.env.common.a.m().P(326, 2, "2", true, null);
            ViewerModelController viewerModelController = ViewerModelController.this;
            viewerModelController.M0.j(viewerModelController.g());
        }

        @Override // com.qzone.album.business.photolist.ui.interactingbar.a.InterfaceC0344a
        public void c(View view) {
            ViewerModelController.this.C5(view, true);
        }

        @Override // com.qzone.album.business.photolist.ui.interactingbar.d, com.qzone.album.business.photolist.ui.interactingbar.a.InterfaceC0344a
        public void d(View view) {
            com.qzone.album.business.photolist.ui.interactingbar.a aVar = ViewerModelController.this.J1;
            if (aVar == null || aVar.g()) {
                return;
            }
            ViewerModelController.this.D7();
            if (ViewerModelController.this.h3()) {
                com.qzone.album.env.common.a.m().R("368", "12", "");
            } else {
                com.qzone.album.env.common.a.m().P(326, 2, "8", true, ViewerModelController.this.z5());
            }
            ViewerModelController viewerModelController = ViewerModelController.this;
            AlbumSocialInfoCacheData albumSocialInfoCacheData = viewerModelController.D0;
            if (albumSocialInfoCacheData == null || !albumSocialInfoCacheData.isLiked) {
                return;
            }
            viewerModelController.J1.a();
        }

        @Override // com.qzone.album.business.photolist.ui.interactingbar.d, com.qzone.album.business.photolist.ui.interactingbar.a.InterfaceC0344a
        public void e(View view) {
            com.qzone.album.env.common.a.m().P(326, 2, "9", true, ViewerModelController.this.z5());
            u4.a z16 = u4.a.z();
            ViewerModelController viewerModelController = ViewerModelController.this;
            z16.T(viewerModelController.Q, viewerModelController.S.longValue(), ViewerModelController.this.T);
        }

        @Override // com.qzone.album.business.photolist.ui.interactingbar.d, com.qzone.album.business.photolist.ui.interactingbar.a.InterfaceC0344a
        public void f(View view) {
            com.qzone.album.env.common.a.m().P(326, 2, "3", true, ViewerModelController.this.z5());
            Bundle bundle = new Bundle();
            ViewerModelController.this.L7(bundle);
            ViewerModelController.this.a7(bundle);
        }

        @Override // com.qzone.album.business.photolist.ui.interactingbar.a.InterfaceC0344a
        public void h(View view) {
            View view2 = ViewerModelController.this.O1;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            com.qzone.album.env.common.a.m().P(326, 2, "5", true, ViewerModelController.this.z5());
            ViewerModelController.this.b7(1);
        }

        @Override // com.qzone.album.business.photolist.ui.interactingbar.d, com.qzone.album.business.photolist.ui.interactingbar.a.InterfaceC0344a
        public void g(View view, boolean z16) {
            if (view == null) {
                return;
            }
            view.getLocationOnScreen(new int[2]);
            int f16 = ViewerModelController.this.K1.f();
            int e16 = (ar.e(50.0f) * f16) + ((f16 - 1) * ar.e(0.5f)) + ar.e(16.0f);
            if (z16) {
                ViewerModelController.this.K1.g(6);
            } else {
                ViewerModelController viewerModelController = ViewerModelController.this;
                if (viewerModelController.J1 == null) {
                    viewerModelController.K1.g(4);
                } else {
                    viewerModelController.K1.g(r0.b() - 1);
                }
            }
            ViewerModelController.this.K1.k(ar.e(50.0f));
            ViewerModelController.this.K1.j(-1);
            ViewerModelController.this.K1.h(0);
            ViewerModelController.this.K1.n(view, 0, (-e16) - ar.e(50.0f), 0.6f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class m implements AbsCompatRequest.a {
        m() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            BusinessAlbumInfo businessAlbumInfo;
            if (i3 == -11529) {
                ViewerModelController viewerModelController = ViewerModelController.this;
                if (viewerModelController.Y1) {
                    vo.b.f(viewerModelController.Q, viewerModelController.S.longValue(), "qzone_photo_list");
                    ViewerModelController.this.x1();
                    return;
                }
            }
            if (sVar.a() != null && sVar.getSucceed() && (sVar.getData() instanceof QZoneQueryAlbumRequest.a)) {
                QZoneQueryAlbumRequest.a aVar = (QZoneQueryAlbumRequest.a) sVar.getData();
                if (aVar != null && (businessAlbumInfo = aVar.f43973b) != null) {
                    ViewerModelController viewerModelController2 = ViewerModelController.this;
                    viewerModelController2.W = businessAlbumInfo.mLastUploadTime;
                    viewerModelController2.X = businessAlbumInfo.mPrivacy;
                }
                AlbumSocialInfoCacheData albumSocialInfoCacheData = aVar != null ? aVar.f43972a : null;
                ViewerModelController viewerModelController3 = ViewerModelController.this;
                viewerModelController3.D0 = albumSocialInfoCacheData;
                if (albumSocialInfoCacheData != null) {
                    viewerModelController3.K1().C();
                    ViewerModelController.this.D4();
                    ViewerModelController.this.T7(albumSocialInfoCacheData);
                    com.qzone.album.env.common.a.m().b("[PhotoAlbum] ViewerModelController", "old type:" + ViewerModelController.this.f42940a0 + " new type:" + albumSocialInfoCacheData.albumType);
                    ViewerModelController.this.f43149g3 = albumSocialInfoCacheData.albumPublicShareData;
                    ViewerModelController.this.U3(albumSocialInfoCacheData.albumType);
                }
                ViewerModelController.this.I7();
                return;
            }
            ViewerModelController.this.I7();
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void B4(Album album) {
        boolean z16;
        if (album == null) {
            return;
        }
        String str = album.albumid;
        if (TextUtils.isEmpty(str) || !str.equals(this.T)) {
            return;
        }
        this.U = album.name;
        this.f42979n0 = album.priv;
        int i3 = this.f42940a0;
        int i16 = album.type;
        if (i3 != i16) {
            this.f42940a0 = i16;
            z16 = true;
        } else {
            z16 = false;
        }
        this.f42982o0 = album.question;
        this.f42985p0 = album.answer;
        h4(0);
        this.V = album.coverurl;
        AlbumCacheData albumCacheData = this.f43008x0;
        if (albumCacheData != null) {
            albumCacheData.albumname = this.U;
            albumCacheData.albumdesc = album.desc;
            albumCacheData.albumtype = this.f42940a0;
        }
        if (albumCacheData != null && com.qzone.album.util.b.f(albumCacheData)) {
            AlbumCacheData albumCacheData2 = this.f43008x0;
            albumCacheData2.albumname = this.U;
            albumCacheData2.individual = this.f42943b0 ? 1L : 0L;
            albumCacheData2.albumdesc = album.desc;
            if (K1().j() != null) {
                K1().j().x0(this.f43008x0);
            }
        }
        if (K1().j() != null) {
            K1().j().x0(this.f43008x0);
        }
        if (z16) {
            V3(QZoneAlbumUtil.u(this.f42940a0, this.B1, this, null, P2(), this.f42943b0));
            ((com.qzone.album.business.photolist.adapter.a) B1()).D(this.H4);
            ((com.qzone.album.business.photolist.adapter.a) B1()).E(this.I4);
            ((com.qzone.album.business.photolist.adapter.a) B1()).B(!P2());
            ((com.qzone.album.business.photolist.adapter.a) B1()).z(this.O0);
            this.W1.getListView().setAdapter((ListAdapter) B1());
            this.f43012z0.Y(this.S.longValue(), this.f42940a0);
            N4();
            o7();
        }
    }

    public void Z6(int i3) {
        s4(I(R.string.gcm));
        this.f42973l0 = true;
        this.f43010y0.N1(this.S.longValue(), this.T, i3, new o(i3));
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void X3(boolean z16) {
        if (z16) {
            if (this.O1 == null) {
                this.O1 = F(R.id.l9l);
                fo.b bVar = new fo.b();
                bVar.h(new c.a());
                fo.c.o(this.O1, "em_qz_plus_suspend", bVar);
            }
            View view = this.O1;
            if (view == null) {
                return;
            }
            if (view.getVisibility() != 0) {
                this.O1.setVisibility(0);
                LpReportInfo_pf00064.allReport(326, 2, 52);
            }
            int i3 = this.f42940a0;
            if (i3 == 8) {
                this.O1.setBackgroundResource(R.drawable.fwx);
            } else if (i3 == 11) {
                this.O1.setBackgroundResource(R.drawable.hx_);
            } else {
                this.O1.setBackgroundResource(R.drawable.fww);
            }
            this.O1.setContentDescription("\u6dfb\u52a0\u7167\u7247");
            this.O1.setOnClickListener(this.f43158t3);
            return;
        }
        View view2 = this.O1;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void m1(int i3) {
        this.f43001u1 = true;
        if (this.f43010y0 == null || this.f43147e3 == null || this.f43004v1) {
            return;
        }
        this.f43004v1 = true;
        this.f43013z1 = i3;
        if (i3 == 0) {
            s4("");
        }
        m4.e h16 = this.f43147e3.h(i3);
        HashMap<Long, Long> hashMap = h16.f416113b;
        int i16 = h16.f416114c;
        int i17 = h16.f416115d;
        this.f43011y1 = h16.f416116e;
        if (!e3() && !Y2()) {
            if (i3()) {
                this.f43010y0.p0(this.S.longValue(), this.T, hashMap, this.f42991r0, null, this.f42985p0, i16, i17, 2, 0, null, i3, this.f43011y1, this.L4);
                return;
            } else {
                this.f43010y0.p0(this.S.longValue(), this.T, hashMap, this.f42991r0, null, this.f42985p0, i16, i17, 0, 0, null, i3, this.f43011y1, this.L4);
                return;
            }
        }
        this.f43010y0.p0(this.S.longValue(), this.T, hashMap, this.f42991r0, null, this.f42985p0, i16, i17, 1, 0, null, i3, this.f43011y1, this.L4);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.a
    public void R(Activity activity, int i3, int i16, final Intent intent) {
        Bundle bundleExtra;
        AlbumSocialInfoCacheData albumSocialInfoCacheData;
        Bundle bundleExtra2;
        super.R(activity, i3, i16, intent);
        if (i3 == 20) {
            QzoneGestureSelectListView listView = this.W1.getListView();
            if (listView != null) {
                listView.postDelayed(new Runnable() { // from class: com.qzone.album.business.photolist.controller.ViewerModelController.43
                    @Override // java.lang.Runnable
                    public void run() {
                        ViewerModelController.this.o0();
                    }
                }, 500L);
                return;
            } else {
                o0();
                return;
            }
        }
        if (i3 == 25) {
            if (i16 != -1 || (bundleExtra = intent.getBundleExtra("extra_key_bundle_within_intent")) == null || bundleExtra.getString("forwardAlbumBundleKeyAlbumId") == null || !bundleExtra.getString("forwardAlbumBundleKeyAlbumId").equals(this.T)) {
                return;
            }
            this.M0.i(intent.getStringExtra("contentIntentKey"));
            return;
        }
        if (i3 == 27) {
            if (i16 == 0) {
                this.Y2 = false;
                return;
            }
            return;
        }
        if (i3 != 30) {
            switch (i3) {
                case 9:
                    if (i16 == -1) {
                        com.qzone.album.base.Service.a.W().x(this.T, intent.getStringExtra("contentIntentKey"), this.f43008x0.ownerUin, intent.getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_PRIVATE_COMMENT, false), this.f43008x0.busi_param, this.O4);
                        AlbumSocialInfoCacheData albumSocialInfoCacheData2 = this.D0;
                        if (albumSocialInfoCacheData2 != null) {
                            int i17 = albumSocialInfoCacheData2.commentNum + 1;
                            albumSocialInfoCacheData2.commentNum = i17;
                            R7(i17);
                        }
                        com.qzone.album.business.photolist.ui.interactingbar.a aVar = this.J1;
                        if (aVar == null || (albumSocialInfoCacheData = this.D0) == null) {
                            return;
                        }
                        aVar.j(albumSocialInfoCacheData.commentNum);
                        return;
                    }
                    return;
                case 10:
                    if (i16 != -1 || (bundleExtra2 = intent.getBundleExtra("extra_key_bundle_within_intent")) == null || bundleExtra2.getString("forwardAlbumBundleKeyAlbumId") == null || !bundleExtra2.getString("forwardAlbumBundleKeyAlbumId").equals(this.T)) {
                        return;
                    }
                    this.f43010y0.K(this.f43008x0, intent.getStringExtra("contentIntentKey"), this.N4);
                    return;
                case 11:
                    if (intent != null) {
                        Bundle bundleExtra3 = intent.getBundleExtra("extra_key_bundle_within_intent");
                        if (i16 == -1 && bundleExtra3 != null && bundleExtra3.containsKey("comment_single_photo_or_video_position") && bundleExtra3.containsKey("comment_single_photo_or_video_unikey")) {
                            final String string = bundleExtra3.getString("comment_single_photo_or_video_unikey");
                            if (this.f43008x0.isNormalAlbum()) {
                                int i18 = bundleExtra3.getInt("comment_single_photo_or_video_position", -1);
                                if (i18 < 0 || i18 >= this.f43003v0.size() || this.f43003v0.get(i18) == null || !this.f43003v0.get(i18).unikey.equals(string)) {
                                    return;
                                }
                                this.f43010y0.y(e0(), this.f43003v0.get(i18), i18, intent.getStringExtra("contentIntentKey"), intent.getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_PRIVATE_COMMENT, false), this.f43008x0.ownerUin);
                                return;
                            }
                            com.qzone.album.env.common.a.m().K(new Runnable() { // from class: com.qzone.album.business.photolist.controller.ViewerModelController.42
                                @Override // java.lang.Runnable
                                public void run() {
                                    int e75 = ViewerModelController.this.e7(string);
                                    if (e75 < 0 || e75 >= ViewerModelController.this.f43003v0.size()) {
                                        return;
                                    }
                                    ViewerModelController viewerModelController = ViewerModelController.this;
                                    viewerModelController.f43010y0.y(viewerModelController.e0(), ViewerModelController.this.f43003v0.get(e75), e75, intent.getStringExtra("contentIntentKey"), intent.getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_PRIVATE_COMMENT, false), ViewerModelController.this.f43008x0.ownerUin);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        com.qzone.album.business.photolist.controller.d dVar = this.f42945b2;
        if (dVar != null) {
            dVar.J();
        }
    }

    private void U6() {
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class n implements AbsCompatRequest.a {
        n() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            int i16;
            tAdvDesc tadvdesc;
            com.qzone.album.business.photolist.ui.menu.b bVar;
            AlbumCacheData albumCacheData = ViewerModelController.this.f43008x0;
            if (albumCacheData == null || (i16 = albumCacheData.albumtype) == 8 || i16 == 9) {
                return;
            }
            if (sVar.getSucceed()) {
                if (sVar.getData() instanceof QzoneQBossAdvRequest.a) {
                    try {
                        Map<Integer, ArrayList<tAdvDesc>> map = ((QzoneQBossAdvRequest.a) sVar.getData()).f48461b;
                        if (((Boolean) absCompatRequest.getParam("key_is_guest_mode")).booleanValue()) {
                            tadvdesc = map.get(2493).get(0);
                        } else {
                            tadvdesc = map.get(2492).get(0);
                        }
                        if (tadvdesc != null) {
                            JSONObject jSONObject = new JSONObject(tadvdesc.res_data);
                            u4.a.z().m0(((i4.a) ViewerModelController.this).f407174e, (ViewerModelController.this.W1.z2() == null || ViewerModelController.this.W1.z2().g() == null) ? null : ViewerModelController.this.W1.z2().l(), jSONObject.optString("hintDesc"), (long) (Double.parseDouble(jSONObject.optString("duration")) * 1000.0d));
                            if (ViewerModelController.this.F4 == null) {
                                ViewerModelController.this.F4 = new a();
                            }
                            Drawable loadImage = ImageLoader.getInstance().loadImage(jSONObject.optString("icon"), ViewerModelController.this.F4);
                            if (loadImage == null || (bVar = ViewerModelController.this.K1) == null) {
                                return;
                            }
                            bVar.r(loadImage);
                            ViewerModelController.this.K1.s(loadImage);
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        com.qzone.album.env.common.a.m().f("[PhotoAlbum] ViewerModelController", "onHandleMessage MSG_PHOTO_LIST_QBOSS_TEMPLATE Exception :", e16);
                        return;
                    }
                }
                return;
            }
            com.qzone.album.env.common.a.m().e("[PhotoAlbum] ViewerModelController", "refresh QBoss Template Fail");
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements ImageLoader.ImageLoadListener {
            a() {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
                com.qzone.album.business.photolist.ui.menu.b bVar = ViewerModelController.this.K1;
                if (bVar != null) {
                    bVar.r(drawable);
                    ViewerModelController.this.K1.s(drawable);
                }
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            }
        }
    }
}
