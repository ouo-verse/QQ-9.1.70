package com.qzone.album.business.albumlist.controller;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import b5.b;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.base.Service.QzoneAlbumPicDownloadService;
import com.qzone.album.business.albumlist.viewmodel.PhotoCategoryDetailViewModel;
import com.qzone.album.business.photolist.adapter.QZonePersonalAlbumRecentAdapter;
import com.qzone.album.business.photolist.controller.AbsViewerModeController;
import com.qzone.album.business.photolist.controller.BasePhotoModelController;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QzoneShareToOutsiteRequest;
import com.qzone.album.ui.widget.AlbumDialog;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.lifecycle.utils.ViewModelProviders;
import com.qzone.detail.ui.component.FeedDetailCommentTips;
import com.qzone.misc.network.downloader.i;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.util.P2VUtil;
import com.qzone.util.ar;
import com.qzone.widget.FlexiableProcessImageView;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.AbsListView;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import cooperation.qzone.util.ResDownloadManger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes39.dex */
public class PhotoCategoryDetailsController extends i4.a {
    private Long C;
    private com.qzone.album.base.Service.a D;
    private LinearLayout E;
    private Button F;
    private RelativeLayout G;
    private FlexiableProcessImageView H;
    private TextView I;
    private TextView J;
    private ImageView K;
    private RelativeLayout L;
    private TextView M;
    private int N;
    private boolean P;
    private QZonePersonalAlbumRecentAdapter.j Q;
    private View R;
    private FrameLayout S;
    private int T;
    private int U;
    private b5.b V;
    private b.c W;
    private b.c X;
    private b.c Y;
    private b.c Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f42107a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f42108b0;

    /* renamed from: c0, reason: collision with root package name */
    String f42109c0;

    /* renamed from: d0, reason: collision with root package name */
    String f42110d0;

    /* renamed from: e0, reason: collision with root package name */
    String f42111e0;

    /* renamed from: f, reason: collision with root package name */
    private PhotoCategoryDetailViewModel f42112f;

    /* renamed from: f0, reason: collision with root package name */
    String f42113f0;

    /* renamed from: g0, reason: collision with root package name */
    String f42114g0;

    /* renamed from: h, reason: collision with root package name */
    private QZonePullToRefreshListView f42115h;

    /* renamed from: h0, reason: collision with root package name */
    private View.OnClickListener f42116h0;

    /* renamed from: i, reason: collision with root package name */
    private QZonePersonalAlbumRecentAdapter f42117i;

    /* renamed from: i0, reason: collision with root package name */
    private AbsCompatRequest.a f42118i0;

    /* renamed from: j0, reason: collision with root package name */
    private Handler f42119j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f42120k0;

    /* renamed from: l0, reason: collision with root package name */
    private View.OnClickListener f42121l0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f42122m;

    /* renamed from: m0, reason: collision with root package name */
    private View.OnClickListener f42123m0;

    /* renamed from: n0, reason: collision with root package name */
    private View.OnClickListener f42124n0;

    /* renamed from: o0, reason: collision with root package name */
    private View.OnClickListener f42125o0;

    /* renamed from: p0, reason: collision with root package name */
    private AdapterView.OnItemClickListener f42126p0;

    /* renamed from: q0, reason: collision with root package name */
    protected Dialog f42127q0;

    /* renamed from: r0, reason: collision with root package name */
    protected TextView f42128r0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements QZonePersonalAlbumRecentAdapter.j {
        a() {
        }

        @Override // com.qzone.album.business.photolist.adapter.QZonePersonalAlbumRecentAdapter.j
        public void onSelectedChanged(int i3) {
            if (PhotoCategoryDetailsController.this.f42107a0 != 2 || i3 <= BasePhotoModelController.B2) {
                PhotoCategoryDetailsController.this.f42108b0 = i3;
                PhotoCategoryDetailsController.this.W1();
                PhotoCategoryDetailsController photoCategoryDetailsController = PhotoCategoryDetailsController.this;
                photoCategoryDetailsController.T1(photoCategoryDetailsController.f42107a0);
            }
        }
    }

    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {

        /* loaded from: classes39.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
                PhotoCategoryDetailsController.this.l1().sendEmptyMessage(10101);
            }
        }

        /* renamed from: com.qzone.album.business.albumlist.controller.PhotoCategoryDetailsController$b$b, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class DialogInterfaceOnClickListenerC0313b implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC0313b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int id5 = view.getId();
            if (id5 == R.id.fns || id5 == R.id.fnt) {
                u4.c.a().h(((i4.a) PhotoCategoryDetailsController.this).f407174e, -1, 1234);
                u4.c.a().r("326", "6", "5");
            } else if (id5 == R.id.f164811ay4) {
                if (PhotoCategoryDetailsController.this.f42107a0 != 2) {
                    AlbumDialog albumDialog = new AlbumDialog(((i4.a) PhotoCategoryDetailsController.this).f407174e, R.style.qZoneInputDialog);
                    String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleRemovePhoto", "\u79fb\u9664\u7167\u7247");
                    String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogMessageRemovePhoto", "\u4ec5\u4ece\u8be5\u5206\u7c7b\u79fb\u9664\u7167\u7247,\u5e76\u4e0d\u4f1a\u5220\u9664\u7167\u7247");
                    albumDialog.setContentView(R.layout.bhq);
                    albumDialog.X(2);
                    albumDialog.setTitle(config);
                    albumDialog.Q(config2);
                    albumDialog.a0(com.qzone.util.l.a(R.string.ket), new a());
                    albumDialog.Y(com.qzone.util.l.a(R.string.j6l), new DialogInterfaceOnClickListenerC0313b());
                    albumDialog.show();
                } else {
                    PhotoCategoryDetailsController.this.l1().sendEmptyMessage(TVKEventId.PLAYER_STATE_PAUSE);
                }
            } else if (id5 == R.id.ivTitleBtnLeft) {
                if (PhotoCategoryDetailsController.this.f42107a0 == 1 || PhotoCategoryDetailsController.this.f42107a0 == 2) {
                    PhotoCategoryDetailsController.this.e1(0);
                } else {
                    PhotoCategoryDetailsController photoCategoryDetailsController = PhotoCategoryDetailsController.this;
                    photoCategoryDetailsController.M(((i4.a) photoCategoryDetailsController).f407174e);
                }
            } else if (id5 == R.id.dsj) {
                if (PhotoCategoryDetailsController.this.f42107a0 == 0) {
                    PhotoCategoryDetailsController.this.V.h(8);
                    PhotoCategoryDetailsController.this.V.m(view);
                    PhotoCategoryDetailsController.this.E1();
                } else {
                    PhotoCategoryDetailsController.this.V.e();
                }
            } else if (id5 == R.id.fnv) {
                PhotoCategoryDetailsController.this.Q1("");
                com.qzone.album.base.Service.a.W().O1(PhotoCategoryDetailsController.this.C.longValue(), 1, PhotoCategoryDetailsController.this.f42112f.S1().getValue().categoryId, PhotoCategoryDetailsController.this.f42112f.S1().getValue().groupid_list, PhotoCategoryDetailsController.this.f42112f.S1().getValue().avatarUrl, 4, PhotoCategoryDetailsController.this.f42118i0);
                LpReportInfo_pf00064.allReport(326, 6, 7);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class c implements AbsCompatRequest.a {
        c() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            String str2;
            PhotoCategoryDetailsController.this.o1();
            QzoneShareToOutsiteRequest.a aVar = (QzoneShareToOutsiteRequest.a) sVar.getData();
            if (sVar.getSucceed()) {
                Integer num = (Integer) absCompatRequest.getParam("key_from_share_type");
                String str3 = aVar.f43998c;
                String str4 = aVar.f43999d;
                String str5 = aVar.f44000e;
                String str6 = aVar.f44001f;
                if (TextUtils.isEmpty(str6)) {
                    str6 = com.qzone.util.l.a(R.string.p48);
                }
                String str7 = str6;
                QZLog.d("[PhotoAlbum]PhotoCategoryDetailsController", 2, "PhotoCategoryDetailsController MSG_GET_SHARE_TO_OUSITE success mPhotoCategorySummaryInfo.uin:" + PhotoCategoryDetailsController.this.f42112f.S1().getValue().uin + " type:" + num + " url:" + str3 + " avatarUrl:" + str4 + " title:" + str5 + " summary:" + str7);
                PhotoCategoryDetailsController.this.g1();
                int intValue = num.intValue();
                if (intValue == 0) {
                    PhotoCategoryDetailsController.this.M1(str3, str4, str5, str7, 0L, "");
                    return;
                }
                if (intValue == 1) {
                    PhotoCategoryDetailsController.this.j1(str3, str5, str4, str7);
                    return;
                }
                if (intValue == 2) {
                    PhotoCategoryDetailsController.this.P1(str3, str4, str5, str7, 9);
                    return;
                }
                if (intValue == 3) {
                    PhotoCategoryDetailsController.this.P1(str3, str4, str5, str7, 10);
                    return;
                } else {
                    if (intValue != 4) {
                        return;
                    }
                    PhotoCategoryDetailsController photoCategoryDetailsController = PhotoCategoryDetailsController.this;
                    photoCategoryDetailsController.M1(str3, str4, str5, str7, photoCategoryDetailsController.f42112f.S1().getValue().faceUin, PhotoCategoryDetailsController.this.f42112f.S1().getValue().nick);
                    return;
                }
            }
            ImageManagerEnv.getLogger().d("[PhotoAlbum]PhotoCategoryDetailsController", "MSG_GET_SHARE_TO_OUSITE fail");
            com.qzone.album.env.common.a m3 = com.qzone.album.env.common.a.m();
            if (TextUtils.isEmpty(aVar.f43997b)) {
                str2 = String.valueOf(i3);
            } else {
                str2 = aVar.f43997b;
            }
            m3.V(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f42153d;

        e(ArrayList arrayList) {
            this.f42153d = arrayList;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (PhotoCategoryDetailsController.this.f42120k0) {
                u4.a.z().k(this.f42153d);
                PhotoCategoryDetailsController.this.f42120k0 = false;
            }
        }
    }

    /* loaded from: classes39.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PhotoCategoryDetailsController.this.V.e();
            com.qzone.album.base.Service.a.W().O1(PhotoCategoryDetailsController.this.C.longValue(), 1, PhotoCategoryDetailsController.this.f42112f.S1().getValue().categoryId, PhotoCategoryDetailsController.this.f42112f.S1().getValue().groupid_list, PhotoCategoryDetailsController.this.f42112f.S1().getValue().avatarUrl, 1, PhotoCategoryDetailsController.this.f42118i0);
            LpReportInfo_pf00064.allReport(326, 6, 8);
            PhotoCategoryDetailsController.this.Q1("");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PhotoCategoryDetailsController.this.V.e();
            com.qzone.album.base.Service.a.W().O1(PhotoCategoryDetailsController.this.C.longValue(), 1, PhotoCategoryDetailsController.this.f42112f.S1().getValue().categoryId, PhotoCategoryDetailsController.this.f42112f.S1().getValue().groupid_list, PhotoCategoryDetailsController.this.f42112f.S1().getValue().avatarUrl, 0, PhotoCategoryDetailsController.this.f42118i0);
            LpReportInfo_pf00064.allReport(326, 6, 9);
            PhotoCategoryDetailsController.this.Q1("");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class h implements Observer<PhotoCategorySummaryInfo> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(PhotoCategorySummaryInfo photoCategorySummaryInfo) {
            QZLog.d("[PhotoAlbum]PhotoCategoryDetailsController", 1, "photoCategorySummaryInfo onChanged");
            PhotoCategoryDetailsController.this.x1(photoCategorySummaryInfo);
            PhotoCategoryDetailsController.this.O1();
            PhotoCategoryDetailsController.this.s1();
        }
    }

    /* loaded from: classes39.dex */
    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PhotoCategoryDetailsController.this.V.e();
            com.qzone.album.base.Service.a.W().O1(PhotoCategoryDetailsController.this.C.longValue(), 1, PhotoCategoryDetailsController.this.f42112f.S1().getValue().categoryId, PhotoCategoryDetailsController.this.f42112f.S1().getValue().groupid_list, PhotoCategoryDetailsController.this.f42112f.S1().getValue().avatarUrl, 2, PhotoCategoryDetailsController.this.f42118i0);
            LpReportInfo_pf00064.allReport(326, 6, 10);
            PhotoCategoryDetailsController.this.Q1("");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PhotoCategoryDetailsController.this.V.e();
            com.qzone.album.base.Service.a.W().O1(PhotoCategoryDetailsController.this.C.longValue(), 1, PhotoCategoryDetailsController.this.f42112f.S1().getValue().categoryId, PhotoCategoryDetailsController.this.f42112f.S1().getValue().groupid_list, PhotoCategoryDetailsController.this.f42112f.S1().getValue().avatarUrl, 3, PhotoCategoryDetailsController.this.f42118i0);
            LpReportInfo_pf00064.allReport(326, 6, 11);
            PhotoCategoryDetailsController.this.Q1("");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class l implements AdapterView.OnItemClickListener {

        /* loaded from: classes39.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
                PhotoCategoryDetailsController.this.l1().sendEmptyMessage(TVKEventId.PLAYER_STATE_START_PLAY);
            }
        }

        /* loaded from: classes39.dex */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }

        l() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            if (PhotoCategoryDetailsController.this.V != null && !PhotoCategoryDetailsController.this.V.f27877a.get(i3).e().equals(PhotoCategoryDetailsController.this.f42109c0)) {
                PhotoCategoryDetailsController.this.V.e();
                if (PhotoCategoryDetailsController.this.V.f27877a != null && PhotoCategoryDetailsController.this.V.f27877a.get(i3) != null && PhotoCategoryDetailsController.this.V.f27877a.get(i3).e() != null) {
                    if (PhotoCategoryDetailsController.this.V.f27877a.get(i3).e().equals(PhotoCategoryDetailsController.this.f42110d0)) {
                        PhotoCategoryDetailsController.this.e1(1);
                        PhotoCategoryDetailsController.this.D1();
                    } else if (PhotoCategoryDetailsController.this.V.f27877a.get(i3).e().equals(PhotoCategoryDetailsController.this.f42111e0)) {
                        AlbumDialog albumDialog = new AlbumDialog(((i4.a) PhotoCategoryDetailsController.this).f407174e, R.style.qZoneInputDialog);
                        albumDialog.setContentView(R.layout.bhq);
                        albumDialog.X(2);
                        albumDialog.setTitle(PhotoCategoryDetailsController.this.f42111e0);
                        albumDialog.Q(PhotoCategoryDetailsController.this.f42113f0);
                        albumDialog.a0(com.qzone.util.l.a(R.string.ket), new a());
                        albumDialog.Y(com.qzone.util.l.a(R.string.j6l), new b());
                        albumDialog.show();
                        u4.c.a().r("326", "6", "4");
                    } else if (PhotoCategoryDetailsController.this.V.f27877a.get(i3).e().equals(PhotoCategoryDetailsController.this.f42114g0)) {
                        int i16 = PhotoCategoryDetailsController.this.f42112f.S1().getValue().categoryType;
                        if (i16 == 1) {
                            u4.c.a().r("326", "6", "12");
                        } else if (i16 == 4) {
                            u4.c.a().r("326", "9", "5");
                        }
                        PhotoCategoryDetailsController.this.e1(2);
                    }
                }
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* loaded from: classes39.dex */
    class m implements Observer<ArrayList<PhotoCategorySinglePicInfo>> {
        m() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(ArrayList<PhotoCategorySinglePicInfo> arrayList) {
            Object[] objArr = new Object[4];
            objArr[0] = "photosList onChanged... currentMode:";
            objArr[1] = Integer.valueOf(PhotoCategoryDetailsController.this.f42107a0);
            objArr[2] = " photoCategorySinglePicInfos size:";
            objArr[3] = Integer.valueOf(arrayList != null ? arrayList.size() : 0);
            QZLog.d("[PhotoAlbum]PhotoCategoryDetailsController", 1, objArr);
            ArrayList<PhotoCacheData> y16 = PhotoCategoryDetailsController.this.f42117i.y();
            Object[] objArr2 = new Object[2];
            objArr2[0] = "selectedList size:";
            objArr2[1] = Integer.valueOf(y16 != null ? y16.size() : 0);
            QZLog.d("[PhotoAlbum]PhotoCategoryDetailsController", 1, objArr2);
            if (arrayList == null || arrayList.size() <= 0) {
                PhotoCategoryDetailsController.this.H1(false);
            } else {
                PhotoCategoryDetailsController.this.f42122m = arrayList.get(arrayList.size() - 1).hasMore == 1;
                if (PhotoCategoryDetailsController.this.f42107a0 == 2) {
                    PhotoCategoryDetailsController.this.f42117i.R(PhotoCategoryDetailsController.this.B1(arrayList), 0, y16);
                } else {
                    PhotoCategoryDetailsController.this.f42117i.R(PhotoCategoryDetailsController.this.B1(arrayList), PhotoCategoryDetailsController.this.f42112f.S1().getValue().categoryType, y16);
                }
                PhotoCategoryDetailsController.this.f42117i.notifyDataSetChanged();
            }
            PhotoCategoryDetailsController.this.V1();
            PhotoCategoryDetailsController.this.W1();
            PhotoCategoryDetailsController.this.U1();
            PhotoCategoryDetailsController.this.O1();
        }
    }

    /* loaded from: classes39.dex */
    class n implements Observer<Integer> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f42165d;

        n(Activity activity) {
            this.f42165d = activity;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            QZLog.d("[PhotoAlbum]PhotoCategoryDetailsController", 1, "UICallback onChanged... type:", num);
            if (num == null) {
                return;
            }
            int intValue = num.intValue();
            if (intValue == -1) {
                if (PhotoCategoryDetailsController.this.f42115h != null) {
                    PhotoCategoryDetailsController.this.f42115h.l0();
                }
                PhotoCategoryDetailsController photoCategoryDetailsController = PhotoCategoryDetailsController.this;
                photoCategoryDetailsController.J1(photoCategoryDetailsController.T);
                return;
            }
            if (intValue == 1) {
                PhotoCategoryDetailsController.this.o1();
                return;
            }
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return;
                    }
                    PhotoCategoryDetailsController.this.o1();
                    com.qzone.album.env.common.a.m().V(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFail", "\u64cd\u4f5c\u5931\u8d25"));
                    return;
                }
                PhotoCategoryDetailsController.this.o1();
                com.qzone.album.env.common.a.m().V(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastRemoveSuccess", "\u79fb\u9664\u6210\u529f"));
                com.qzone.album.base.Service.a.W().N0(16);
                PhotoCategoryDetailsController.this.M(this.f42165d);
                return;
            }
            PhotoCategoryDetailsController.this.o1();
            ArrayList h16 = PhotoCategoryDetailsController.this.h1(PhotoCategoryDetailsController.this.f42117i.y());
            if (PhotoCategoryDetailsController.this.f42112f.S1().getValue() != null) {
                if (h16 != null && h16.size() > 0) {
                    for (int i3 = 0; i3 < h16.size(); i3++) {
                        PhotoCategorySinglePicInfo photoCategorySinglePicInfo = (PhotoCategorySinglePicInfo) h16.get(i3);
                        if (PhotoCategoryDetailsController.this.f42112f.S1().getValue().photoNumber > 0) {
                            if (PhotoCategoryDetailsController.this.f42112f.T1().getValue().contains(photoCategorySinglePicInfo)) {
                                PhotoCategoryDetailsController.this.f42112f.T1().getValue().remove(photoCategorySinglePicInfo);
                            }
                        } else {
                            PhotoCategoryDetailsController.this.f42112f.T1().getValue().clear();
                            PhotoCategoryDetailsController.this.D.N0(16);
                            PhotoCategoryDetailsController.this.M(this.f42165d);
                        }
                    }
                }
                PhotoCategoryDetailsController.this.f42112f.T1().postValue(PhotoCategoryDetailsController.this.f42112f.T1().getValue());
            }
            PhotoCategoryDetailsController.this.P = false;
            PhotoCategoryDetailsController.this.f42117i.S(0);
            PhotoCategoryDetailsController.this.e1(1);
            com.qzone.album.env.common.a.m().V(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastRemoveFromCategory", "\u5df2\u4ece\u8be5\u5206\u7c7b\u79fb\u9664"));
            PhotoCategoryDetailsController.this.D.N0(16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class q extends ImageProcessor {
        q() {
        }

        @Override // com.tencent.component.media.image.ImageProcessor
        public Drawable process(Drawable drawable) {
            return new RoundCornerProcessor(6.0f).process(new SpecifiedSizeCropByPivotProcessor(PhotoCategoryDetailsController.this.N, PhotoCategoryDetailsController.this.N).process(drawable));
        }
    }

    public PhotoCategoryDetailsController(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.f42122m = false;
        this.P = false;
        this.T = 5;
        this.U = -1;
        this.f42107a0 = 0;
        this.f42108b0 = 0;
        this.f42109c0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewShareTo", "\u5206\u4eab\u5230");
        this.f42110d0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewManageBatch", "\u6279\u91cf\u7ba1\u7406");
        this.f42111e0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewRemovePeople", "\u79fb\u9664\u6b64\u4eba");
        this.f42113f0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewRemovePeopleFromList", "\u79fb\u9664\u540e\u4e0d\u4f1a\u51fa\u73b0\u5728\u4eba\u7269\u5217\u8868\u4e2d");
        this.f42114g0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewMakeDynamic", "\u5236\u4f5c\u89c6\u9891");
        this.f42116h0 = new b();
        this.f42118i0 = new c();
        this.f42119j0 = new d();
        this.f42120k0 = false;
        this.f42121l0 = new f();
        this.f42123m0 = new g();
        this.f42124n0 = new i();
        this.f42125o0 = new j();
        this.f42126p0 = new l();
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailsController", 2, "PhotoCategoryDetailsController");
        this.C = Long.valueOf(com.qzone.album.env.common.a.m().s());
        this.D = com.qzone.album.base.Service.a.W();
        PhotoCategoryDetailViewModel photoCategoryDetailViewModel = (PhotoCategoryDetailViewModel) ViewModelProviders.of((BaseActivity) this.f407174e).get(PhotoCategoryDetailViewModel.class);
        this.f42112f = photoCategoryDetailViewModel;
        photoCategoryDetailViewModel.X1(this.f407174e);
    }

    private boolean A1() {
        return t4.a.N().K(this.f407174e, this.R);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<PhotoCacheData> B1(ArrayList<PhotoCategorySinglePicInfo> arrayList) {
        PhotoCacheData photoCacheData;
        ArrayList<PhotoCacheData> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<PhotoCategorySinglePicInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                PhotoCategorySinglePicInfo next = it.next();
                if (next != null && (photoCacheData = next.singlePicInfo) != null) {
                    arrayList2.add(photoCacheData);
                }
            }
        }
        return arrayList2;
    }

    private void C1() {
        u4.c.a().o(this.f407174e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1() {
        if (this.f42112f.S1().getValue() != null) {
            int i3 = this.f42112f.S1().getValue().categoryType;
            if (i3 == 1) {
                u4.c.a().r("326", "6", "3");
            } else {
                if (i3 != 4) {
                    return;
                }
                u4.c.a().r("326", "9", "3");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1() {
        if (this.f42112f.S1().getValue() != null) {
            int i3 = this.f42112f.S1().getValue().categoryType;
            if (i3 == 1) {
                u4.c.a().r("326", "6", "2");
            } else {
                if (i3 != 4) {
                    return;
                }
                u4.c.a().r("326", "9", "2");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F1() {
        if (this.f42112f.S1().getValue() != null) {
            int i3 = this.f42112f.S1().getValue().categoryType;
            if (i3 == 1) {
                u4.c.a().r("326", "6", "6");
            } else if (i3 == 2) {
                u4.c.a().r("326", "8", "2");
            } else {
                if (i3 != 4) {
                    return;
                }
                u4.c.a().r("326", "9", "4");
            }
        }
    }

    private void G1() {
        if (this.f42112f.S1().getValue() != null) {
            int i3 = this.f42112f.S1().getValue().categoryType;
            if (i3 == 1) {
                u4.c.a().r("326", "6", "1");
            } else if (i3 == 2) {
                u4.c.a().r("326", "8", "1");
            } else {
                if (i3 != 4) {
                    return;
                }
                u4.c.a().r("326", "9", "1");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H1(final boolean z16) {
        if (!u4.c.a().k(this.f407174e)) {
            n1(u4.c.a().k(this.f407174e));
            u4.c.a().l(this.f407174e);
        } else {
            J1(1);
            N1();
            com.qzone.album.env.common.a.m().u().post(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.PhotoCategoryDetailsController.9
                @Override // java.lang.Runnable
                public void run() {
                    PhotoCategoryDetailsController.this.f42112f.i2(z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I1(ArrayList<PhotoCategorySinglePicInfo> arrayList) {
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailsController", 2, "PhotoCategoryDetailsController begin set album info");
        if (arrayList != null && arrayList.size() > 0 && this.f42112f.R1() != null && this.f42112f.R1().getValue().size() > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                for (int i16 = 0; i16 < this.f42112f.R1().getValue().size(); i16++) {
                    if (arrayList.get(i3) != null && !TextUtils.isEmpty(arrayList.get(i3).albumId) && this.f42112f.R1().getValue().get(i16) != null && arrayList.get(i3).albumId.equals(this.f42112f.R1().getValue().get(i16).albumid)) {
                        arrayList.get(i3).albumInfo = this.f42112f.R1().getValue().get(i16);
                    }
                }
            }
        }
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailsController", 2, "PhotoCategoryDetailsController end set album info");
    }

    private final void K1(int i3, boolean z16) {
        if (this.S == null || this.R == null) {
            return;
        }
        t4.a.N().L(this.f407174e, this.R, i3);
        if (z16) {
            this.T = i3;
        }
        if (i3 == 3) {
            if (this.S.getVisibility() != 8) {
                this.S.setVisibility(8);
            }
        } else if (this.S.getVisibility() != 0) {
            this.S.setVisibility(0);
        }
    }

    private void L1(ArrayList<String> arrayList) {
        this.f42117i.m();
        if (arrayList == null) {
            return;
        }
        this.f42117i.S(arrayList.size());
        int i3 = 0;
        for (int i16 = 0; i16 < this.f42117i.p().size(); i16++) {
            int i17 = 0;
            while (true) {
                if (i17 >= arrayList.size()) {
                    break;
                }
                if (this.f42117i.p().get(i16).f42627a.lloc.equals(arrayList.get(i17))) {
                    this.f42117i.p().get(i16).f42628b = true;
                    QZonePersonalAlbumRecentAdapter qZonePersonalAlbumRecentAdapter = this.f42117i;
                    qZonePersonalAlbumRecentAdapter.F.add(qZonePersonalAlbumRecentAdapter.p().get(i16).f42627a);
                    i3++;
                    break;
                }
                i17++;
            }
            if (i3 == arrayList.size()) {
                break;
            }
        }
        this.f42108b0 = arrayList.size();
        W1();
        T1(this.f42107a0);
        this.f42117i.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M1(String str, String str2, String str3, String str4, long j3, String str5) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ShareUtils.e eVar = new ShareUtils.e();
        eVar.f44740a = str;
        eVar.f44711h = 2;
        eVar.f44743d = str2;
        eVar.f44712i = QZoneShareManager.QQ_SHARE_APPID;
        eVar.f44713j = 1;
        eVar.f44742c = str4;
        eVar.f44741b = str3;
        eVar.f44715l = true;
        eVar.f44717n = j3;
        eVar.f44719p = str5;
        ShareUtils.n(this.f407174e, eVar, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N1() {
        u4.c.a().C(this.f407174e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1() {
        if (this.M != null && this.L != null) {
            if (this.f42112f.S1().getValue() != null && this.f42112f.S1().getValue().faceUin != 0 && this.f42112f.S1().getValue().faceUin != com.qzone.album.env.common.a.m().s() && this.f42112f.S1().getValue().faceStatus != 3) {
                this.M.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewShareToFriend", "\u5206\u4eab\u7ed9\u597d\u53cb"));
                this.L.setVisibility(0);
                return;
            } else {
                this.L.setVisibility(8);
                return;
            }
        }
        QZLog.w("[PhotoAlbum]PhotoCategoryDetailsController", 1, "mShareText == null || mShareLayout == null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P1(String str, String str2, String str3, String str4, int i3) {
        ShareUtils.g gVar = new ShareUtils.g();
        gVar.f44741b = str3;
        gVar.f44743d = str2;
        gVar.f44740a = str;
        gVar.f44742c = str4;
        ShareUtils.q(this.f407174e, i3, gVar);
    }

    private void R1() {
        u4.c.a().p(this.f407174e);
    }

    private void S1(boolean z16) {
        this.f42117i.M(z16);
        this.f42117i.notifyDataSetChanged();
        if (z16) {
            this.E.setVisibility(0);
        } else {
            this.E.setVisibility(8);
        }
        T1(this.f42107a0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U1() {
        QZonePersonalAlbumRecentAdapter qZonePersonalAlbumRecentAdapter = this.f42117i;
        if (qZonePersonalAlbumRecentAdapter == null) {
            return;
        }
        if (qZonePersonalAlbumRecentAdapter.getCount() > 0) {
            if (this.f42122m) {
                J1(5);
                return;
            } else {
                J1(7);
                return;
            }
        }
        f1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V1() {
        if (this.f42112f.S1().getValue() != null && this.f42112f.S1().getValue().categoryType == 1) {
            FlexiableProcessImageView flexiableProcessImageView = this.H;
            if (flexiableProcessImageView != null) {
                flexiableProcessImageView.setAsyncImage(this.f42112f.S1().getValue().avatarUrl);
            }
            int i3 = this.f42107a0;
            if (i3 == 0) {
                this.G.setVisibility(0);
            } else if (i3 == 1 || i3 == 2) {
                this.G.setVisibility(8);
            }
        } else {
            this.G.setVisibility(8);
        }
        if (this.f42112f.S1().getValue() != null) {
            this.J.setText(String.valueOf(this.f42112f.S1().getValue().photoNumber) + com.qzone.util.l.a(R.string.f172286p40));
            if (!TextUtils.isEmpty(this.f42112f.S1().getValue().nick) && (this.f42112f.S1().getValue().faceStatus == 1 || this.f42112f.S1().getValue().faceStatus == 2 || this.f42112f.S1().getValue().categoryType != 1)) {
                this.I.setText(this.f42112f.S1().getValue().nick);
                this.I.setTextColor(-16777216);
                this.K.setVisibility(0);
            } else {
                this.I.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewAddName", "\u6dfb\u52a0\u540d\u5b57"));
                this.I.setTextColor(-4473925);
                this.K.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1() {
        u4.c.a().z(this.f407174e, com.qzone.util.l.a(R.string.f171898lr0));
        if (this.f42112f.S1().getValue() != null) {
            if (this.f42112f.S1().getValue().categoryType != 1 && this.f42112f.S1().getValue().categoryType != 4) {
                if (this.f42112f.S1().getValue().categoryType == 2) {
                    u4.c.a().B(this.f407174e, this.f42112f.S1().getValue().nick);
                    return;
                }
                return;
            }
            int i3 = this.f42107a0;
            if (i3 == 0) {
                u4.c.a().A(this.f407174e, 0);
                u4.c.a().w(this.f407174e, R.drawable.b5b);
                u4.c.a().y(this.f407174e, u4.c.a().d(this.f407174e), u4.c.a().f(this.f407174e), u4.c.a().e(this.f407174e), u4.c.a().c(this.f407174e));
                u4.c.a().m(this.f407174e);
                u4.c.a().u(this.f407174e, R.drawable.qzone_skin_feeddetail_more);
                u4.c.a().v(this.f407174e, 0);
                u4.c.a().t(this.f407174e, com.qzone.util.l.a(R.string.f172287p45));
                u4.c.a().s(this.f407174e, this.f42116h0);
                if (this.f42112f.S1().getValue().categoryType != 4 || this.f42112f.S1().getValue().nick == null || this.f42112f.S1().getValue().nick.length() <= 0) {
                    return;
                }
                u4.c.a().B(this.f407174e, this.f42112f.S1().getValue().nick);
                return;
            }
            if (i3 == 1 || i3 == 2) {
                u4.c.a().A(this.f407174e, 8);
                if (this.f42108b0 > 0) {
                    u4.c.a().B(this.f407174e, com.qzone.util.l.a(R.string.p46) + this.f42108b0 + ")");
                } else if (this.f42107a0 == 1) {
                    u4.c.a().B(this.f407174e, this.f42110d0);
                } else {
                    u4.c.a().B(this.f407174e, this.f42114g0);
                }
                u4.c.a().z(this.f407174e, com.qzone.util.l.a(R.string.j6l));
                u4.c.a().w(this.f407174e, 0);
                u4.c.a().y(this.f407174e, 0, u4.c.a().f(this.f407174e), u4.c.a().e(this.f407174e), u4.c.a().c(this.f407174e));
                u4.c.a().x(this.f407174e, this.f42116h0);
                u4.c.a().v(this.f407174e, 8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(int i3) {
        this.f42107a0 = i3;
        this.f42108b0 = 0;
        this.f42117i.m();
        if (this.f42107a0 == 2) {
            ArrayList<PhotoCacheData> V5 = AbsViewerModeController.V5(B1(this.f42112f.T1().getValue()));
            if (V5 != null && V5.size() > 0) {
                int i16 = this.f42112f.S1().getValue().categoryType;
                if (i16 == 1) {
                    u4.c.a().r("326", "6", "13");
                } else if (i16 == 4) {
                    u4.c.a().r("326", "9", "6");
                }
                this.f42117i.Q(V5, 0);
                this.f42117i.N(BasePhotoModelController.B2);
                this.f42117i.notifyDataSetChanged();
            } else {
                com.qzone.album.env.common.a.m().U(R.string.gip);
                e1(0);
                return;
            }
        } else {
            this.f42117i.N(50);
            this.f42117i.Q(B1(this.f42112f.T1().getValue()), this.f42112f.S1().getValue().categoryType);
            this.f42117i.notifyDataSetChanged();
        }
        this.P = !this.P;
        W1();
        V1();
        S1(this.P);
    }

    private void f1() {
        QZonePersonalAlbumRecentAdapter qZonePersonalAlbumRecentAdapter = this.f42117i;
        if (qZonePersonalAlbumRecentAdapter == null || !qZonePersonalAlbumRecentAdapter.isEmpty()) {
            return;
        }
        J1(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<PhotoCategorySinglePicInfo> h1(ArrayList<PhotoCacheData> arrayList) {
        String str;
        String str2;
        ArrayList<PhotoCategorySinglePicInfo> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0 && this.f42112f.T1().getValue() != null && this.f42112f.T1().getValue().size() > 0) {
            Iterator<PhotoCategorySinglePicInfo> it = this.f42112f.T1().getValue().iterator();
            while (it.hasNext()) {
                PhotoCategorySinglePicInfo next = it.next();
                Iterator<PhotoCacheData> it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    PhotoCacheData next2 = it5.next();
                    PhotoCacheData photoCacheData = next.singlePicInfo;
                    if (photoCacheData != null && (str = photoCacheData.lloc) != null && (str2 = next2.lloc) != null && str.equals(str2)) {
                        arrayList2.add(next);
                    }
                }
            }
        }
        return arrayList2;
    }

    private void i1() {
        if (this.f42112f.G) {
            return;
        }
        H1(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(String str, String str2, String str3, String str4) {
        u4.a.z().x(this.f407174e.getApplicationContext(), com.qzone.album.env.common.a.m().s() + "", str, str2, str3, str4, null, 0);
    }

    private ArrayList<LocalMediaInfo> k1(ArrayList<String> arrayList) {
        ArrayList<LocalMediaInfo> arrayList2 = new ArrayList<>();
        if (arrayList == null) {
            return arrayList2;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            String str = arrayList.get(i16);
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            String fileName = FileManagerUtil.getFileName(str);
            localMediaInfo.path = str;
            String mimeType = MimeTypesTools.getMimeType(H(), fileName);
            localMediaInfo.mMimeType = mimeType;
            String[] mimeType2 = MimeHelper.getMimeType(mimeType);
            if (MimeHelper.validateVideoType(localMediaInfo.mMimeType)) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                mediaMetadataRetriever.release();
                localMediaInfo.mediaWidth = Integer.parseInt(extractMetadata);
                localMediaInfo.mediaHeight = Integer.parseInt(extractMetadata2);
                localMediaInfo.mDuration = Long.parseLong(extractMetadata3);
                localMediaInfo.position = Integer.valueOf(i3);
                arrayList2.add(localMediaInfo);
            } else {
                if (mimeType2 != null && "image".equals(mimeType2[0]) && MimeHelper.validateImageType(mimeType2[1])) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(str, options);
                    localMediaInfo.mediaWidth = options.outWidth;
                    localMediaInfo.mediaHeight = options.outHeight;
                    localMediaInfo.mDuration = 1500L;
                    localMediaInfo.position = Integer.valueOf(i3);
                    arrayList2.add(localMediaInfo);
                }
            }
            i3++;
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler l1() {
        return this.f42119j0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int m1() {
        View childAt = this.f42115h.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (-childAt.getTop()) + (this.f42115h.getFirstVisiblePosition() * childAt.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        u4.c.a().i(this.f407174e);
    }

    private void p1() {
        QZonePullToRefreshListView qZonePullToRefreshListView = this.f42115h;
        if (qZonePullToRefreshListView != null) {
            qZonePullToRefreshListView.l0();
        }
        o1();
    }

    private View q1() {
        View inflate = LayoutInflater.from(this.f407174e).inflate(R.layout.bom, (ViewGroup) null);
        this.N = ar.e(60.0f);
        this.G = (RelativeLayout) inflate.findViewById(R.id.fnr);
        this.H = (FlexiableProcessImageView) inflate.findViewById(R.id.fnq);
        TextView textView = (TextView) inflate.findViewById(R.id.fns);
        this.I = textView;
        textView.setMaxWidth(ar.l() - ar.e(157.0f));
        this.I.setOnClickListener(this.f42116h0);
        this.I.setMaxWidth((getResources().getDisplayMetrics().widthPixels / 5) * 2);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.fnt);
        this.K = imageView;
        imageView.setOnClickListener(this.f42116h0);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.fnv);
        this.L = relativeLayout;
        relativeLayout.setOnClickListener(this.f42116h0);
        this.M = (TextView) inflate.findViewById(R.id.fnw);
        O1();
        this.J = (TextView) inflate.findViewById(R.id.fnp);
        FlexiableProcessImageView flexiableProcessImageView = this.H;
        int i3 = this.N;
        flexiableProcessImageView.setAsyncClipSize(i3, i3);
        this.H.setAsyncImageProcessor(new q());
        FlexiableProcessImageView flexiableProcessImageView2 = this.H;
        int i16 = this.N;
        com.qzone.album.util.c.c(flexiableProcessImageView2, i16, i16);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1() {
        if (this.V != null) {
            return;
        }
        b5.b bVar = new b5.b(this.f407174e);
        this.V = bVar;
        bVar.l(this.f42126p0);
        if (this.C.longValue() == com.qzone.album.env.common.a.m().s()) {
            if (this.f42112f.S1().getValue() != null && this.f42112f.S1().getValue().categoryType == 1) {
                b5.b bVar2 = this.V;
                Objects.requireNonNull(bVar2);
                this.W = new b.c();
                Drawable drawable = ResDownloadManger.getmInstance().getDrawable(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_icon_fenxiang", new k());
                if (drawable != null) {
                    this.W.h(drawable);
                }
                this.W.g(new int[]{R.drawable.qzone_icon_action_sheet_share_to_qzone, R.drawable.qzone_icon_action_sheet_share_to_qq, R.drawable.qzone_icon_action_sheet_share_to_wx, R.drawable.qzone_icon_action_sheet_share_to_wx_circle}, new View.OnClickListener[]{this.f42121l0, this.f42123m0, this.f42124n0, this.f42125o0});
                this.W.j(this.f42109c0);
                this.V.d(this.W);
            }
            if (P2VUtil.d().g()) {
                P2VUtil.d().j(H().getApplicationContext());
                b5.b bVar3 = this.V;
                Objects.requireNonNull(bVar3);
                b.c cVar = new b.c();
                this.Z = cVar;
                cVar.h(getResources().getDrawable(R.drawable.fvk));
                this.Z.j(this.f42114g0);
                this.V.d(this.Z);
            }
            b5.b bVar4 = this.V;
            Objects.requireNonNull(bVar4);
            b.c cVar2 = new b.c();
            this.X = cVar2;
            cVar2.h(getResources().getDrawable(R.drawable.f162197fy2));
            this.X.j(this.f42110d0);
            this.V.d(this.X);
            if (this.f42112f.S1().getValue() == null || this.f42112f.S1().getValue().categoryType != 1) {
                return;
            }
            b5.b bVar5 = this.V;
            Objects.requireNonNull(bVar5);
            b.c cVar3 = new b.c();
            this.Y = cVar3;
            cVar3.h(getResources().getDrawable(R.drawable.f162294gb4));
            this.Y.j(this.f42111e0);
            this.V.d(this.Y);
        }
    }

    private void t1() {
        this.Q = new a();
    }

    private boolean u1(boolean z16) {
        boolean z17 = false;
        if (this.R != null) {
            return false;
        }
        QZonePullToRefreshListView qZonePullToRefreshListView = this.f42115h;
        if (qZonePullToRefreshListView != null && qZonePullToRefreshListView.j0() != null) {
            this.S = new FrameLayout(this.f407174e);
            this.f42115h.j0().addFooterView(this.S);
            FeedDetailCommentTips feedDetailCommentTips = new FeedDetailCommentTips(this.f407174e, l1());
            this.R = feedDetailCommentTips;
            View d16 = feedDetailCommentTips.d();
            if (d16 != null) {
                d16.setBackgroundDrawable(null);
            }
            ((FeedDetailCommentTips) this.R).setLoadingDataText(this.f407174e.getString(R.string.f170931b54));
            ((FeedDetailCommentTips) this.R).setLoadingMoreDataText(this.f407174e.getString(R.string.f170932b55));
            z17 = true;
            ((FeedDetailCommentTips) this.R).K = true;
            if (!z16) {
                J1(5);
            } else {
                this.T = 3;
                J1(3);
            }
            this.S.addView(this.R);
        }
        return z17;
    }

    private void y1(String str, int i3, FaceData faceData, int i16) {
        ArrayList<FaceData> arrayList;
        PhotoCacheData v3 = this.f42117i.v(str);
        if (v3 == null || (arrayList = v3.faceList) == null || i3 >= arrayList.size()) {
            return;
        }
        QZLog.d("[PhotoAlbum]FaceFuntion", 1, "onEventFaceChangeResult index:", Integer.valueOf(i3), " unikey:", str, " op:", Integer.valueOf(i16));
        v3.faceList.set(i3, faceData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1() {
        if (A1()) {
            i1();
        }
    }

    @Override // i4.a
    public void J(s8.b bVar) {
        super.J(bVar);
        if (bVar == null || bVar.b() == null || !(bVar.b() instanceof Object[])) {
            return;
        }
        Object[] objArr = (Object[]) bVar.b();
        if ("QzoneAlbum".equals(bVar.a())) {
            int c16 = bVar.c();
            if (c16 == 9) {
                if (objArr.length >= 4) {
                    Object obj = objArr[0];
                    if ((obj instanceof Boolean) && (objArr[1] instanceof String) && (objArr[2] instanceof ArrayList) && (objArr[3] instanceof String)) {
                        this.f42112f.e2(((Boolean) obj).booleanValue(), (String) objArr[1], (ArrayList) objArr[2], (String) objArr[3]);
                        return;
                    }
                    return;
                }
                return;
            }
            if (c16 == 11) {
                QZLog.i("[PhotoAlbum]PhotoCategoryDetailsController", 4, "category getMore");
                if (objArr.length == 2) {
                    Object obj2 = objArr[0];
                    if (obj2 instanceof s) {
                        Object obj3 = objArr[1];
                        if (obj3 instanceof Boolean) {
                            this.f42112f.g2((s) obj2, ((Boolean) obj3).booleanValue());
                            com.qzone.album.env.common.a.m().u().post(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.PhotoCategoryDetailsController.17
                                @Override // java.lang.Runnable
                                public void run() {
                                    PhotoCategoryDetailsController.this.f42112f.W1();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (c16 != 15) {
                if (c16 == 24 && objArr.length >= 4) {
                    Object obj4 = objArr[0];
                    if (obj4 instanceof String) {
                        Object obj5 = objArr[1];
                        if ((obj5 instanceof Integer) && (objArr[2] instanceof FaceData) && (objArr[3] instanceof Integer)) {
                            y1((String) obj4, ((Integer) obj5).intValue(), (FaceData) objArr[2], ((Integer) objArr[3]).intValue());
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (objArr.length >= 0) {
                Object obj6 = objArr[0];
                if (obj6 instanceof ArrayList) {
                    this.f42112f.d2((ArrayList) obj6);
                    return;
                }
                return;
            }
            return;
        }
        if ("WriteOperation".equals(bVar.a())) {
            int c17 = bVar.c();
            if (c17 != 7) {
                if (c17 == 48 && objArr.length >= 4) {
                    Object obj7 = objArr[0];
                    if ((obj7 instanceof Boolean) && (objArr[2] instanceof String) && (objArr[3] instanceof String) && (objArr[4] instanceof String)) {
                        this.f42112f.h2(((Boolean) obj7).booleanValue(), (String) objArr[2], (String) objArr[3], (String) objArr[4]);
                        return;
                    }
                    return;
                }
                return;
            }
            if (objArr.length >= 5) {
                Object obj8 = objArr[0];
                if (obj8 instanceof String) {
                    Object obj9 = objArr[1];
                    if ((obj9 instanceof Boolean) && (objArr[2] instanceof String) && (objArr[3] instanceof Integer) && (objArr[4] instanceof Integer)) {
                        this.f42112f.f2(this.f42117i, (String) obj8, ((Boolean) obj9).booleanValue(), (String) objArr[2], ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue());
                    }
                }
            }
        }
    }

    @Override // i4.a
    public void L(boolean z16) {
        super.L(z16);
        n1(z16);
    }

    @Override // i4.a
    public boolean M(Activity activity) {
        int i3 = this.f42107a0;
        if (i3 != 1 && i3 != 2) {
            Intent intent = new Intent();
            intent.putExtra("key_photo_category_modify", this.f42112f.H);
            activity.setResult(-1, intent);
            activity.finish();
            return false;
        }
        e1(0);
        return true;
    }

    @Override // i4.a
    public void N(Activity activity) {
        super.N(activity);
        activity.setContentView(R.layout.bon);
        C1();
        r1();
        BaseActivity baseActivity = (BaseActivity) activity;
        this.f42112f.S1().observe(baseActivity, new h());
        this.f42112f.T1().observe(baseActivity, new m());
        this.f42112f.U1().observe(baseActivity, new n(activity));
        G1();
    }

    @Override // i4.a
    public void O(Activity activity) {
        super.O(activity);
        R1();
        FlexiableProcessImageView flexiableProcessImageView = this.H;
        if (flexiableProcessImageView != null) {
            flexiableProcessImageView.setAsyncImageProcessor(null);
            this.H.clearAsyncImage();
            this.H = null;
        }
    }

    public void Q1(String str) {
        Dialog dialog = this.f42127q0;
        if (dialog == null || !dialog.isShowing()) {
            if (this.f42127q0 == null) {
                ReportDialog reportDialog = new ReportDialog(this.f407174e, R.style.f174269ui);
                this.f42127q0 = reportDialog;
                reportDialog.setContentView(R.layout.bqd);
                this.f42128r0 = (TextView) this.f42127q0.findViewById(R.id.dialogText);
                this.f42127q0.findViewById(R.id.kja).setVisibility(8);
                this.f42127q0.findViewById(R.id.cib).setVisibility(0);
            }
            this.f42128r0.setText(str);
            try {
                this.f42127q0.show();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // i4.a
    public void R(Activity activity, int i3, int i16, Intent intent) {
        super.R(activity, i3, i16, intent);
        if (i3 == 1207) {
            if (i16 == -1) {
                L1(intent.getStringArrayListExtra(PictureConst.KEY_SELECTED_PHOTO_LLOC));
            }
        } else if (i3 == 1234 && i16 == -1) {
            Message obtain = Message.obtain();
            obtain.what = 10102;
            obtain.obj = intent;
            l1().sendMessage(obtain);
        }
    }

    public void g1() {
        try {
            Dialog dialog = this.f42127q0;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.f42127q0.dismiss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void w1(ArrayList<PhotoCacheData> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (!FeedGlobalEnv.g().isNetworkAvailable(null)) {
            com.qzone.album.env.common.a.m().V(I(R.string.ci5));
            return;
        }
        if (arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            PhotoCacheData photoCacheData = arrayList.get(i3);
            if (photoCacheData.videoflag == 1 && photoCacheData.videodata != null) {
                arrayList2.add(Integer.valueOf(i3));
                arrayList4.add(photoCacheData.videodata.videoUrl.url);
            } else {
                PictureUrl picUrlDec = photoCacheData.picItem.getPicUrlDec();
                if (picUrlDec != null && !TextUtils.isEmpty(picUrlDec.url)) {
                    arrayList3.add(picUrlDec.url);
                }
            }
        }
        if (arrayList3.size() == 0 && arrayList4.size() == 0) {
            u4.a.z().r0(R.string.gih);
            return;
        }
        Q1(I(R.string.gii));
        Dialog dialog = this.f42127q0;
        if (dialog != null) {
            dialog.setOnDismissListener(new e(arrayList3));
        }
        if (arrayList3.size() <= 0 && arrayList4.size() > 0) {
            com.qzone.album.env.common.a.m().J(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.PhotoCategoryDetailsController.15

                /* renamed from: com.qzone.album.business.albumlist.controller.PhotoCategoryDetailsController$15$b */
                /* loaded from: classes39.dex */
                class b implements DialogInterface.OnClickListener {
                    b() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        PhotoCategoryDetailsController.this.g1();
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    PhotoCategoryDetailsController.this.f42120k0 = true;
                    AbsViewerModeController.q5(arrayList4, new a(), new b());
                }

                /* renamed from: com.qzone.album.business.albumlist.controller.PhotoCategoryDetailsController$15$a */
                /* loaded from: classes39.dex */
                class a implements i.f {
                    a() {
                    }

                    @Override // com.qzone.misc.network.downloader.i.f
                    public void A(String str, int i3, String str2) {
                        PhotoCategoryDetailsController.this.f42120k0 = false;
                        com.qzone.album.env.common.a.m().W(PhotoCategoryDetailsController.this.getResources().getString(R.string.gih), 1);
                        PhotoCategoryDetailsController.this.g1();
                    }

                    @Override // com.qzone.misc.network.downloader.i.f
                    public void y(ArrayList<String> arrayList) {
                        PhotoCategoryDetailsController.this.v1(arrayList, false);
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
            com.qzone.album.env.common.a.m().J(new AnonymousClass16(arrayList3, arrayList4, arrayList2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1(int i3) {
        K1(i3, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1(ArrayList<String> arrayList, boolean z16) {
        this.f42120k0 = false;
        if (!z16) {
            this.f42117i.notifyDataSetChanged();
            e1(0);
        }
        com.qzone.util.image.c.j(arrayList);
        ArrayList<LocalMediaInfo> k16 = k1(arrayList);
        g1();
        if (k16.size() == 0) {
            com.qzone.album.env.common.a.m().U(R.string.gin);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("qzone_slide_show_matters", k16);
        bundle.putInt("edit_video_type", 10001);
        bundle.putInt("qq_sub_business_id", 3);
        bundle.putInt("qqstory_slide_show_scene", 22);
        bundle.putInt("entrance_qzone_p2v", 17);
        ((IJumpUtil) QRoute.api(IJumpUtil.class)).jumpToSlideShowEditVideoActivityForQzone(H(), bundle);
    }

    /* loaded from: classes39.dex */
    class d extends Handler {

        /* loaded from: classes39.dex */
        class a extends QQPermission.BasePermissionsListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ArrayList f42151a;

            a(ArrayList arrayList) {
                this.f42151a = arrayList;
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                super.onAllGranted();
                PhotoCategoryDetailsController.this.w1(this.f42151a);
                PhotoCategoryDetailsController.this.f42117i.m();
            }
        }

        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            if (u4.c.a().k(((i4.a) PhotoCategoryDetailsController.this).f407174e)) {
                PhotoCategoryDetailsController.this.N1();
                int i3 = message.what;
                if (i3 == -10001) {
                    PhotoCategoryDetailsController.this.z1();
                    return;
                }
                switch (i3) {
                    case 10101:
                        PhotoCategoryDetailsController.this.f42112f.Q1(PhotoCategoryDetailsController.this.f42117i.y(), PhotoCategoryDetailsController.this.C.longValue());
                        return;
                    case 10102:
                        PhotoCategoryDetailsController.this.f42112f.b2((Intent) message.obj);
                        return;
                    case TVKEventId.PLAYER_STATE_START_PLAY /* 10103 */:
                        PhotoCategoryDetailsController.this.f42112f.P1();
                        return;
                    case TVKEventId.PLAYER_STATE_PAUSE /* 10104 */:
                        PhotoCategoryDetailsController.this.o1();
                        ArrayList<PhotoCacheData> z16 = PhotoCategoryDetailsController.this.f42117i.z();
                        if (z16 != null) {
                            int i16 = PhotoCategoryDetailsController.this.f42112f.S1().getValue().categoryType;
                            if (i16 == 1) {
                                u4.c.a().r("326", "6", "14");
                            } else if (i16 == 4) {
                                u4.c.a().r("326", "9", "7");
                            }
                            if (QZonePermission.requestStoragePermission(((i4.a) PhotoCategoryDetailsController.this).f407174e, new a(z16), QQPermissionConstants.Business.SCENE.QQ_QZONE_VIDEO_EDIT_READ_MEDIA)) {
                                PhotoCategoryDetailsController.this.w1(z16);
                                PhotoCategoryDetailsController.this.f42117i.m();
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            u4.c.a().l(((i4.a) PhotoCategoryDetailsController.this).f407174e);
        }
    }

    private void n1(boolean z16) {
        if (z16) {
            return;
        }
        p1();
        J1(this.T);
        f1();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qzone.album.business.albumlist.controller.PhotoCategoryDetailsController$7, reason: invalid class name */
    /* loaded from: classes39.dex */
    public class AnonymousClass7 implements QZonePersonalAlbumRecentAdapter.f {
        AnonymousClass7() {
        }

        @Override // com.qzone.album.business.photolist.adapter.QZonePersonalAlbumRecentAdapter.f
        public void a(View view, final ArrayList<PhotoCacheData> arrayList, final int i3) {
            if (view == null || arrayList == null || arrayList.isEmpty() || i3 < 0 || i3 >= arrayList.size()) {
                return;
            }
            com.qzone.album.env.common.a.m().u().post(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.PhotoCategoryDetailsController.7.1
                @Override // java.lang.Runnable
                public void run() {
                    ((i4.a) PhotoCategoryDetailsController.this).f407174e.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.PhotoCategoryDetailsController.7.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            new ArrayList();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            ArrayList h16 = PhotoCategoryDetailsController.this.h1(arrayList);
                            PhotoCategoryDetailsController.this.I1(h16);
                            if (PhotoCategoryDetailsController.this.f42107a0 == 2) {
                                FragmentActivity fragmentActivity = ((i4.a) PhotoCategoryDetailsController.this).f407174e;
                                ArrayList<PhotoCacheData> arrayList2 = PhotoCategoryDetailsController.this.f42117i.F;
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                PictureViewerFactory.J(fragmentActivity, h16, arrayList2, i3, 0, PhotoCategoryDetailsController.this.f42107a0 == 2 ? BasePhotoModelController.B2 : 50, 1207);
                                return;
                            }
                            FragmentActivity fragmentActivity2 = ((i4.a) PhotoCategoryDetailsController.this).f407174e;
                            long longValue = PhotoCategoryDetailsController.this.C.longValue();
                            ArrayList<PhotoCacheData> arrayList3 = PhotoCategoryDetailsController.this.f42117i.F;
                            AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                            PictureViewerFactory.K(fragmentActivity2, longValue, h16, arrayList3, i3, PhotoCategoryDetailsController.this.f42122m, 1207);
                        }
                    });
                }
            });
            PhotoCategoryDetailsController.this.F1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1(int i3) {
        if (i3 == 2) {
            if (this.f42108b0 > 0) {
                this.F.setText(com.qzone.util.l.a(R.string.p47) + this.f42108b0 + ")");
            } else {
                this.F.setText(com.qzone.util.l.a(R.string.ket));
            }
        } else {
            this.F.setText(com.qzone.util.l.a(R.string.p3y));
        }
        if (this.f42108b0 > 0) {
            this.F.setClickable(true);
            this.F.setEnabled(true);
            this.F.setTextColor(-1);
        } else {
            this.F.setClickable(false);
            this.F.setEnabled(false);
            this.F.setTextColor(-4473925);
        }
    }

    private void r1() {
        QZonePullToRefreshListView qZonePullToRefreshListView = (QZonePullToRefreshListView) F(R.id.ay5);
        this.f42115h = qZonePullToRefreshListView;
        qZonePullToRefreshListView.g0().setHeaderLayoutBackgroundColor(Color.parseColor("#ececec"));
        this.f42115h.g0().setTextColor(Color.parseColor("#777777"));
        this.f42115h.addHeaderView(q1(), null, false);
        this.f42115h.setOnRefreshListener(new o());
        this.f42115h.setOnScrollListener(new p());
        this.E = (LinearLayout) F(R.id.f164810ay3);
        Button button = (Button) F(R.id.f164811ay4);
        this.F = button;
        button.setOnClickListener(this.f42116h0);
        t1();
        u1(true);
        QZonePersonalAlbumRecentAdapter qZonePersonalAlbumRecentAdapter = new QZonePersonalAlbumRecentAdapter(this.f407174e, B1(this.f42112f.T1().getValue()), 2, this.Q);
        this.f42117i = qZonePersonalAlbumRecentAdapter;
        qZonePersonalAlbumRecentAdapter.O(new AnonymousClass7());
        if (this.f42117i != null) {
            this.f42115h.j0().setAdapter((ListAdapter) this.f42117i);
            this.f42117i.notifyDataSetChanged();
        }
        this.f42115h.setSupportPullUp(true);
        U1();
        com.qzone.album.util.p.a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1(PhotoCategorySummaryInfo photoCategorySummaryInfo) {
        if (photoCategorySummaryInfo == null) {
            return;
        }
        if ((TextUtils.isEmpty(photoCategorySummaryInfo.avatarUrl) && TextUtils.isEmpty(photoCategorySummaryInfo.nick)) ? false : true) {
            this.f407174e.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.PhotoCategoryDetailsController.4
                @Override // java.lang.Runnable
                public void run() {
                    PhotoCategoryDetailsController.this.V1();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class p implements AbsListView.OnScrollListener {
        p() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            if (PhotoCategoryDetailsController.this.f42107a0 == 0 && PhotoCategoryDetailsController.this.f42112f.S1().getValue() != null && PhotoCategoryDetailsController.this.f42112f.S1().getValue().categoryType == 1) {
                String g16 = u4.c.a().g(((i4.a) PhotoCategoryDetailsController.this).f407174e);
                if (PhotoCategoryDetailsController.this.m1() > 190) {
                    if (PhotoCategoryDetailsController.this.f42112f.S1().getValue().nick == null || g16 == null || g16.equals(PhotoCategoryDetailsController.this.f42112f.S1().getValue().nick)) {
                        return;
                    }
                    u4.c.a().B(((i4.a) PhotoCategoryDetailsController.this).f407174e, PhotoCategoryDetailsController.this.f42112f.S1().getValue().nick);
                    return;
                }
                if (g16 == null || !g16.equals("  ")) {
                    u4.c.a().B(((i4.a) PhotoCategoryDetailsController.this).f407174e, "  ");
                }
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if ((i3 == 0 || i3 == 2) && !PhotoCategoryDetailsController.this.f42115h.isOverscrollHeadVisiable() && PhotoCategoryDetailsController.this.f42115h.j0().getLastVisiblePosition() >= PhotoCategoryDetailsController.this.f42115h.j0().getCount() - 2) {
                PhotoCategoryDetailsController.this.z1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qzone.album.business.albumlist.controller.PhotoCategoryDetailsController$16, reason: invalid class name */
    /* loaded from: classes39.dex */
    public class AnonymousClass16 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f42132d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f42133e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f42134f;

        AnonymousClass16(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            this.f42132d = arrayList;
            this.f42133e = arrayList2;
            this.f42134f = arrayList3;
        }

        @Override // java.lang.Runnable
        public void run() {
            PhotoCategoryDetailsController.this.f42120k0 = true;
            u4.a.z().t(((i4.a) PhotoCategoryDetailsController.this).f407174e.getApplicationContext(), System.currentTimeMillis() + "", this.f42132d, new a());
        }

        /* renamed from: com.qzone.album.business.albumlist.controller.PhotoCategoryDetailsController$16$a */
        /* loaded from: classes39.dex */
        class a implements u4.f {

            /* renamed from: com.qzone.album.business.albumlist.controller.PhotoCategoryDetailsController$16$a$b */
            /* loaded from: classes39.dex */
            class b implements DialogInterface.OnClickListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    PhotoCategoryDetailsController.this.g1();
                }
            }

            a() {
            }

            @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
            public void a(String str, ArrayList<String> arrayList) {
                ArrayList arrayList2 = new ArrayList();
                if (AnonymousClass16.this.f42132d.size() > 0) {
                    for (int i3 = 0; i3 < AnonymousClass16.this.f42132d.size(); i3++) {
                        String p16 = QzoneAlbumPicDownloadService.p((String) AnonymousClass16.this.f42132d.get(i3));
                        if (!TextUtils.isEmpty(p16)) {
                            arrayList2.add(p16);
                        } else {
                            com.qzone.album.env.common.a.m().b("[PhotoAlbum]PhotoCategoryDetailsController", "p2v picDownload - tempPath is null");
                        }
                    }
                }
                if (AnonymousClass16.this.f42133e.size() <= 0) {
                    PhotoCategoryDetailsController.this.v1(arrayList2, false);
                } else {
                    AbsViewerModeController.q5(AnonymousClass16.this.f42133e, new C0311a(arrayList2), new b());
                }
            }

            @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
            public void onDownloadFailed(String str) {
                PhotoCategoryDetailsController.this.f42120k0 = false;
                com.qzone.album.env.common.a.m().W(PhotoCategoryDetailsController.this.getResources().getString(R.string.gih), 1);
                PhotoCategoryDetailsController.this.g1();
            }

            /* renamed from: com.qzone.album.business.albumlist.controller.PhotoCategoryDetailsController$16$a$a, reason: collision with other inner class name */
            /* loaded from: classes39.dex */
            class C0311a implements i.f {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ArrayList f42136a;

                C0311a(ArrayList arrayList) {
                    this.f42136a = arrayList;
                }

                @Override // com.qzone.misc.network.downloader.i.f
                public void A(String str, int i3, String str2) {
                    com.qzone.album.env.common.a.m().W(PhotoCategoryDetailsController.this.getResources().getString(R.string.gkh), 1);
                    PhotoCategoryDetailsController.this.g1();
                }

                @Override // com.qzone.misc.network.downloader.i.f
                public void y(ArrayList<String> arrayList) {
                    ArrayList arrayList2 = new ArrayList();
                    if (AnonymousClass16.this.f42134f.size() == 0) {
                        arrayList2.addAll(this.f42136a);
                    } else {
                        int size = this.f42136a.size() + arrayList.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            if (AnonymousClass16.this.f42134f.contains(Integer.valueOf(i3))) {
                                arrayList2.add(arrayList.get(0));
                                arrayList.remove(0);
                            } else {
                                arrayList2.add((String) this.f42136a.get(0));
                                this.f42136a.remove(0);
                            }
                        }
                    }
                    PhotoCategoryDetailsController.this.v1(arrayList2, false);
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
    /* loaded from: classes39.dex */
    public class o implements QZonePullToRefreshListView.c {
        o() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void Y() {
            PhotoCategoryDetailsController.this.o1();
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onRefresh() {
            PhotoCategoryDetailsController.this.H1(false);
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullEnd() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullStart() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class k implements ResDownloadManger.ResLoadListener {
        k() {
        }

        @Override // cooperation.qzone.util.ResDownloadManger.ResLoadListener
        public void onDownloaded(int i3, String str, Bitmap bitmap) {
            PhotoCategoryDetailsController.this.W.h(new BitmapDrawable(bitmap));
        }

        @Override // cooperation.qzone.util.ResDownloadManger.ResLoadListener
        public void onFailed(int i3, String str) {
        }
    }
}
