package com.qzone.album.business.photolist.controller;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.EditPhoto;
import NS_MOBILE_PHOTO.modify_travel_photo_scence;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.album.business.photolist.adapter.h;
import com.qzone.album.business.photolist.adapter.u;
import com.qzone.album.business.photolist.controller.ViewerModelController;
import com.qzone.album.business.photolist.ui.c;
import com.qzone.album.business.photolist.ui.header.AlbumHeaderPanel;
import com.qzone.album.business.photolist.ui.listitem.BigPhotoView;
import com.qzone.album.business.photolist.ui.listitem.PhotoView;
import com.qzone.album.data.AlbumCacheDataManager;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.AlbumDataOutShare;
import com.qzone.album.data.model.AlbumSocialInfoCacheData;
import com.qzone.album.data.model.LoveAlbumTimeEvent;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.album.data.model.RecomAlbumList;
import com.qzone.album.data.model.SharingAlbumClientAttr;
import com.qzone.album.data.model.SharingOwnerUinAttr;
import com.qzone.album.data.model.TravelAlbumData;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZoneAlbumSortPhotoRequest;
import com.qzone.album.protocol.QZoneDelBatchPhotosRequest;
import com.qzone.album.protocol.QZoneMoveBatchPhotosRequest;
import com.qzone.album.protocol.QZoneOperateTravelPhotoSceneRequest;
import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.qzone.album.protocol.QZonePhotoListRequest;
import com.qzone.album.protocol.QzoneBatchDeleteVideoRequest;
import com.qzone.album.ui.widget.QzoneGestureSelectListView;
import com.qzone.album.ui.widget.c;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.album.util.f;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.preview.event.QZoneAlbumCategoryDeletePhotoEvent;
import com.qzone.preview.event.QZoneAlbumLayerSelectPhotoEvent;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.layer.share.QZoneDeletePhotoBean;
import com.qzone.reborn.route.QZoneUserHomeBean;
import com.qzone.util.ToastUtil;
import com.qzone.util.image.NetImageInfo;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.AbsListView;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import cooperation.qzone.util.ResDownloadManger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import jp.c;

/* loaded from: classes39.dex */
public abstract class BasePhotoModelController extends i4.b implements x4.a, com.qzone.album.env.common.c, SimpleEventReceiver {
    protected ArrayList<PhotoCacheData> A0;
    protected int A1;
    protected boolean B0;
    protected int B1;
    int C0;
    FrameLayout C1;
    public AlbumSocialInfoCacheData D0;
    Drawable D1;
    public ArrayList<Integer> E0;
    Drawable E1;
    public ArrayList<String> F0;
    Drawable F1;
    public ArrayList<NetImageInfo> G0;
    Drawable G1;
    public List<PhotoCacheData> H0;
    private AlbumHeaderPanel H1;
    protected boolean I0;
    private com.qzone.album.business.photolist.ui.c I1;
    public int J0;
    protected com.qzone.album.business.photolist.ui.interactingbar.a J1;
    public boolean K0;
    protected com.qzone.album.business.photolist.ui.menu.b K1;
    public boolean L0;
    protected PhotoPoiArea L1;
    protected com.qzone.album.business.photolist.ui.menu.c M0;
    protected View M1;
    protected AlbumDataOutShare N0;
    protected int N1;
    boolean O0;
    protected View O1;
    protected Context P;
    long P0;
    protected LinearLayout P1;
    protected Activity Q;
    String Q0;
    protected LinearLayout Q1;
    protected Intent R;
    long R0;
    private BusinessAlbumInfo R1;
    public Long S;
    protected int S0;
    private n5.a S1;
    public String T;
    private boolean T0;
    protected boolean T1;
    protected String U;
    protected String U0;
    protected boolean U1;
    protected String V;
    protected Dialog V0;
    protected volatile boolean V1;
    public long W;
    protected TextView W0;
    protected u4.h W1;
    public int X;
    protected Dialog X0;
    protected boolean X1;
    public QZonePhotoListRequest.a Y;
    private jp.c Y0;
    protected boolean Y1;
    protected int Z;
    protected boolean Z0;
    protected boolean Z1;

    /* renamed from: a0, reason: collision with root package name */
    public int f42940a0;

    /* renamed from: a1, reason: collision with root package name */
    public com.qzone.album.ui.widget.c f42941a1;

    /* renamed from: a2, reason: collision with root package name */
    protected com.qzone.album.business.photolist.ui.d f42942a2;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f42943b0;

    /* renamed from: b1, reason: collision with root package name */
    protected int f42944b1;

    /* renamed from: b2, reason: collision with root package name */
    protected com.qzone.album.business.photolist.controller.d f42945b2;

    /* renamed from: c0, reason: collision with root package name */
    public int f42946c0;

    /* renamed from: c1, reason: collision with root package name */
    protected int f42947c1;

    /* renamed from: c2, reason: collision with root package name */
    protected boolean f42948c2;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f42949d0;

    /* renamed from: d1, reason: collision with root package name */
    public boolean f42950d1;

    /* renamed from: d2, reason: collision with root package name */
    private int f42951d2;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f42952e0;

    /* renamed from: e1, reason: collision with root package name */
    protected boolean f42953e1;

    /* renamed from: e2, reason: collision with root package name */
    protected RecomAlbumList f42954e2;

    /* renamed from: f0, reason: collision with root package name */
    protected int f42955f0;

    /* renamed from: f1, reason: collision with root package name */
    private boolean f42956f1;

    /* renamed from: f2, reason: collision with root package name */
    protected boolean f42957f2;

    /* renamed from: g0, reason: collision with root package name */
    boolean f42958g0;

    /* renamed from: g1, reason: collision with root package name */
    protected boolean f42959g1;

    /* renamed from: g2, reason: collision with root package name */
    private mc.a f42960g2;

    /* renamed from: h0, reason: collision with root package name */
    boolean f42961h0;

    /* renamed from: h1, reason: collision with root package name */
    protected boolean f42962h1;

    /* renamed from: h2, reason: collision with root package name */
    long f42963h2;

    /* renamed from: i0, reason: collision with root package name */
    boolean f42964i0;

    /* renamed from: i1, reason: collision with root package name */
    protected HashMap<Integer, String> f42965i1;

    /* renamed from: i2, reason: collision with root package name */
    long f42966i2;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f42967j0;

    /* renamed from: j1, reason: collision with root package name */
    protected List<PhotoCacheData> f42968j1;

    /* renamed from: j2, reason: collision with root package name */
    int f42969j2;

    /* renamed from: k0, reason: collision with root package name */
    public int f42970k0;

    /* renamed from: k1, reason: collision with root package name */
    public Map<Integer, String> f42971k1;

    /* renamed from: k2, reason: collision with root package name */
    int f42972k2;

    /* renamed from: l0, reason: collision with root package name */
    protected boolean f42973l0;

    /* renamed from: l1, reason: collision with root package name */
    protected String f42974l1;

    /* renamed from: l2, reason: collision with root package name */
    boolean f42975l2;

    /* renamed from: m0, reason: collision with root package name */
    protected int f42976m0;

    /* renamed from: m1, reason: collision with root package name */
    protected boolean f42977m1;

    /* renamed from: m2, reason: collision with root package name */
    protected c.b f42978m2;

    /* renamed from: n0, reason: collision with root package name */
    protected int f42979n0;

    /* renamed from: n1, reason: collision with root package name */
    protected boolean f42980n1;

    /* renamed from: n2, reason: collision with root package name */
    protected AbsCompatRequest.a f42981n2;

    /* renamed from: o0, reason: collision with root package name */
    protected String f42982o0;

    /* renamed from: o1, reason: collision with root package name */
    protected boolean f42983o1;

    /* renamed from: o2, reason: collision with root package name */
    LoveAlbumTimeEvent f42984o2;

    /* renamed from: p0, reason: collision with root package name */
    protected String f42985p0;

    /* renamed from: p1, reason: collision with root package name */
    protected int f42986p1;

    /* renamed from: p2, reason: collision with root package name */
    private PhotoCacheData f42987p2;

    /* renamed from: q0, reason: collision with root package name */
    protected String f42988q0;

    /* renamed from: q1, reason: collision with root package name */
    public long f42989q1;

    /* renamed from: q2, reason: collision with root package name */
    protected AbsCompatRequest.a f42990q2;

    /* renamed from: r0, reason: collision with root package name */
    protected int f42991r0;

    /* renamed from: r1, reason: collision with root package name */
    public String f42992r1;

    /* renamed from: r2, reason: collision with root package name */
    protected AbsCompatRequest.a f42993r2;

    /* renamed from: s0, reason: collision with root package name */
    protected boolean f42994s0;

    /* renamed from: s1, reason: collision with root package name */
    protected TextView f42995s1;

    /* renamed from: s2, reason: collision with root package name */
    protected AbsCompatRequest.a f42996s2;

    /* renamed from: t0, reason: collision with root package name */
    private Bundle f42997t0;

    /* renamed from: t1, reason: collision with root package name */
    protected String f42998t1;

    /* renamed from: t2, reason: collision with root package name */
    protected AbsCompatRequest.a f42999t2;

    /* renamed from: u0, reason: collision with root package name */
    protected List<PhotoCacheData[]> f43000u0;

    /* renamed from: u1, reason: collision with root package name */
    public boolean f43001u1;

    /* renamed from: u2, reason: collision with root package name */
    protected AbsCompatRequest.a f43002u2;

    /* renamed from: v0, reason: collision with root package name */
    protected List<PhotoCacheData> f43003v0;

    /* renamed from: v1, reason: collision with root package name */
    public boolean f43004v1;

    /* renamed from: v2, reason: collision with root package name */
    private QzoneGestureSelectListView.c f43005v2;

    /* renamed from: w0, reason: collision with root package name */
    protected List<PhotoCacheData> f43006w0;

    /* renamed from: w1, reason: collision with root package name */
    protected boolean f43007w1;

    /* renamed from: x0, reason: collision with root package name */
    public AlbumCacheData f43008x0;

    /* renamed from: x1, reason: collision with root package name */
    public String f43009x1;

    /* renamed from: y0, reason: collision with root package name */
    public com.qzone.album.base.Service.a f43010y0;

    /* renamed from: y1, reason: collision with root package name */
    public int f43011y1;

    /* renamed from: z0, reason: collision with root package name */
    public AlbumCacheDataManager f43012z0;

    /* renamed from: z1, reason: collision with root package name */
    protected int f43013z1;

    /* renamed from: w2, reason: collision with root package name */
    public static final int f42936w2 = -u4.a.z().o(50.0f);

    /* renamed from: x2, reason: collision with root package name */
    public static int f42937x2 = 3;

    /* renamed from: y2, reason: collision with root package name */
    public static int f42938y2 = 4;

    /* renamed from: z2, reason: collision with root package name */
    public static final int f42939z2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MANAGEMENT_MAX_PHOTO_NUM, 50);
    public static final int A2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DYNAMIC_MAX_PHOTO_NUM, 60);
    public static final int B2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MAKE_VIDEO_ALBUM_MAX_PHOTO_NUM, 30);
    public static final int C2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MANAGEMENT_MAX_VIDEO_NUM, 3);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements c.d {
        a() {
        }

        @Override // jp.c.d
        public void onDismiss() {
            int i3 = BasePhotoModelController.this.f42970k0;
            if (i3 == 1) {
                LpReportInfo_pf00064.allReport(86, 10, 3);
            } else if (i3 == 5) {
                LpReportInfo_pf00064.allReport(326, 3, 8);
            }
        }
    }

    /* loaded from: classes39.dex */
    public class aa implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private PhotoPoiArea f43025d;

        public aa(PhotoPoiArea photoPoiArea) {
            this.f43025d = photoPoiArea;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!BasePhotoModelController.this.P2()) {
                BasePhotoModelController.this.L1 = this.f43025d;
                u4.a z16 = u4.a.z();
                BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
                z16.b(basePhotoModelController.Q, this.f43025d, basePhotoModelController.S);
                com.qzone.album.env.common.a.m().R("368", "30", BasePhotoModelController.this.e2());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    public class ab implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private int f43027d;

        /* renamed from: e, reason: collision with root package name */
        private int f43028e;

        /* renamed from: f, reason: collision with root package name */
        private String f43029f;

        /* renamed from: h, reason: collision with root package name */
        private PhotoCacheData f43030h;

        /* renamed from: i, reason: collision with root package name */
        private s4.d f43031i;

        public ab(int i3, int i16, String str, PhotoCacheData photoCacheData, s4.d dVar) {
            this.f43027d = i3;
            this.f43028e = i16;
            this.f43029f = str;
            this.f43030h = photoCacheData;
            this.f43031i = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f43028e != 2) {
                com.qzone.album.env.common.a.m().V(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastProcessPhotoAndWait", "\u56fe\u7247\u6b63\u5728\u5904\u7406\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5\u3002"));
            } else if (BasePhotoModelController.this.R2(this.f43030h)) {
                BasePhotoModelController.this.J4();
            } else {
                boolean z16 = BasePhotoModelController.this.F0.indexOf(this.f43030h.getBigUrl()) == -1;
                if (z16) {
                    LpReportInfo_pf00064.allReport(86, 4, 1);
                } else {
                    LpReportInfo_pf00064.allReport(86, 4, 2);
                }
                BasePhotoModelController.this.b4(this.f43030h, this.f43027d, z16);
                BasePhotoModelController.this.J4();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    public class ac implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private int f43033d;

        /* renamed from: e, reason: collision with root package name */
        private int f43034e;

        /* renamed from: f, reason: collision with root package name */
        private String f43035f;

        /* renamed from: h, reason: collision with root package name */
        private PhotoCacheData f43036h;

        /* renamed from: i, reason: collision with root package name */
        private s4.d f43037i;

        public ac(int i3, int i16, String str, PhotoCacheData photoCacheData, s4.d dVar) {
            this.f43033d = i3;
            this.f43034e = i16;
            this.f43035f = str;
            this.f43036h = photoCacheData;
            this.f43037i = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f43034e != 2) {
                com.qzone.album.env.common.a.m().V(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastProcessPhotoAndWait", "\u56fe\u7247\u6b63\u5728\u5904\u7406\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5\u3002"));
            } else if (!BasePhotoModelController.this.R2(this.f43036h)) {
                BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
                PhotoCacheData Z1 = basePhotoModelController.Z1(basePhotoModelController.f43000u0, this.f43033d, false);
                if (Z1 != null) {
                    BasePhotoModelController basePhotoModelController2 = BasePhotoModelController.this;
                    basePhotoModelController2.w1(Z1.index, Z1, basePhotoModelController2.f43000u0, false);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    public class ad implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private LoveAlbumTimeEvent f43039d;

        /* renamed from: e, reason: collision with root package name */
        private long f43040e;

        public ad(LoveAlbumTimeEvent loveAlbumTimeEvent, long j3) {
            this.f43039d = loveAlbumTimeEvent;
            this.f43040e = j3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!BasePhotoModelController.this.P2()) {
                BasePhotoModelController.this.f42984o2 = this.f43039d;
                u4.a z16 = u4.a.z();
                BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
                z16.c(basePhotoModelController.Q, this.f43039d, basePhotoModelController.S.longValue(), 15);
                com.qzone.album.env.common.a.m().R("368", "30", BasePhotoModelController.this.e2());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    public class ae implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private PhotoCacheData f43042d;

        public ae(PhotoCacheData photoCacheData) {
            this.f43042d = photoCacheData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!BasePhotoModelController.this.P2()) {
                BasePhotoModelController.this.f42987p2 = this.f43042d;
                u4.a z16 = u4.a.z();
                BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
                z16.d(basePhotoModelController.Q, this.f43042d, basePhotoModelController.S.longValue(), 6);
                com.qzone.album.env.common.a.m().R("368", "7", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    public class ag implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<Integer> f43047d;

        /* renamed from: e, reason: collision with root package name */
        private ArrayList<PhotoCacheData> f43048e;

        public ag(s4.d dVar) {
            this.f43047d = new ArrayList<>();
            this.f43048e = new ArrayList<>();
            if (dVar != null) {
                this.f43047d = dVar.f433295b;
                this.f43048e = dVar.f433296c;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            boolean z16 = !view.isSelected();
            if (z16) {
                LpReportInfo_pf00064.allReport(86, 4, 3);
            } else {
                LpReportInfo_pf00064.allReport(86, 4, 4);
            }
            ArrayList<PhotoCacheData> arrayList = this.f43048e;
            if (arrayList != null && arrayList.size() > 0) {
                if (this.f43048e.get(0) != null) {
                    for (int i3 = 0; i3 < this.f43047d.size(); i3++) {
                        if (this.f43048e.get(i3) != null) {
                            int intValue = this.f43047d.get(i3).intValue();
                            PhotoCacheData photoCacheData = this.f43048e.get(i3);
                            if (!BasePhotoModelController.this.R2(photoCacheData) && !BasePhotoModelController.this.b4(photoCacheData, intValue, z16)) {
                                break;
                            }
                        }
                    }
                    BasePhotoModelController.this.J4();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    public class ah implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private PhotoCacheData f43050d;

        public ah(PhotoCacheData photoCacheData) {
            this.f43050d = photoCacheData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneUserHomeBean qZoneUserHomeBean = new QZoneUserHomeBean();
            qZoneUserHomeBean.setUin(this.f43050d.uploadUin);
            ho.i.z().t(BasePhotoModelController.this.Q, qZoneUserHomeBean);
            com.qzone.album.env.common.a.m().P(326, 14, "8", true, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    public class ai implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private s4.d f43052d;

        public ai(PhotoCacheData[] photoCacheDataArr, s4.d dVar) {
            new s4.d();
            this.f43052d = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList<PhotoCacheData> arrayList;
            EventCollector.getInstance().onViewClickedBefore(view);
            s4.d dVar = this.f43052d;
            if (dVar != null && (arrayList = dVar.f433296c) != null) {
                BasePhotoModelController.this.Q3(arrayList);
            } else {
                com.qzone.album.env.common.a.m().e("[PhotoAlbum] BasePhotoModelController", "SaveTimeClickListener onClick() mSameDayPhoto == null or mSameDayPhoto.photos == null!");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f43054a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f43055b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f43056c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AlbumCacheData f43057d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Looper looper, List list, boolean z16, List list2, AlbumCacheData albumCacheData) {
            super(looper);
            this.f43054a = list;
            this.f43055b = z16;
            this.f43056c = list2;
            this.f43057d = albumCacheData;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            List<PhotoCacheData> k3;
            if (!BasePhotoModelController.this.S2()) {
                BasePhotoModelController.this.C4(this.f43054a);
            }
            if (obj == null) {
                com.qzone.album.env.common.a.m().c("[PhotoAlbum] BasePhotoModelController", "args == null");
                return doNext(false);
            }
            BasePhotoModelController.this.f43000u0.clear();
            List<PhotoCacheData[]> list = (List) obj;
            BasePhotoModelController.this.f43000u0.addAll(list);
            ((com.qzone.album.business.photolist.adapter.a) BasePhotoModelController.this.B1()).setData(list);
            if (!BasePhotoModelController.this.S2()) {
                BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
                if (basePhotoModelController.f43001u1 && basePhotoModelController.f42962h1) {
                    k3 = ((com.qzone.album.business.photolist.adapter.a) basePhotoModelController.B1()).k(false);
                } else {
                    k3 = ((com.qzone.album.business.photolist.adapter.a) basePhotoModelController.B1()).k(!this.f43055b);
                }
                BasePhotoModelController basePhotoModelController2 = BasePhotoModelController.this;
                basePhotoModelController2.G4(k3, ((com.qzone.album.business.photolist.adapter.a) basePhotoModelController2.B1()).j());
            }
            BasePhotoModelController.this.N4();
            BasePhotoModelController basePhotoModelController3 = BasePhotoModelController.this;
            basePhotoModelController3.M4(((com.qzone.album.business.photolist.adapter.a) basePhotoModelController3.B1()).j());
            if (this.f43056c.size() != 0) {
                BasePhotoModelController basePhotoModelController4 = BasePhotoModelController.this;
                if (basePhotoModelController4.f42970k0 == 0 && basePhotoModelController4.h() && !BasePhotoModelController.this.Q2()) {
                    BasePhotoModelController.this.W1.getListView().setCoverMode(true, BasePhotoModelController.f42936w2);
                }
            }
            if (!this.f43055b) {
                BasePhotoModelController basePhotoModelController5 = BasePhotoModelController.this;
                long j3 = basePhotoModelController5.f42963h2;
                if (j3 != -1) {
                    long j16 = basePhotoModelController5.f42966i2;
                    if (j16 != -1 && j3 != 0 && j16 != 0) {
                        com.qzone.album.env.common.a.m().c("[PhotoAlbum] BasePhotoModelController", "handleLoadDataResult|mPhotos processParamsByTimeLine");
                        BasePhotoModelController basePhotoModelController6 = BasePhotoModelController.this;
                        basePhotoModelController6.J3(0, basePhotoModelController6.f42963h2, basePhotoModelController6.f42966i2);
                        BasePhotoModelController.this.m1(0);
                        BasePhotoModelController basePhotoModelController7 = BasePhotoModelController.this;
                        basePhotoModelController7.f42966i2 = -1L;
                        basePhotoModelController7.f42963h2 = -1L;
                    }
                }
            }
            BasePhotoModelController.this.I4();
            BasePhotoModelController.this.Y0(this.f43056c, this.f43055b, this.f43057d);
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f43059a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Looper looper, List list) {
            super(looper);
            this.f43059a = list;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            List list;
            BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
            if ((basePhotoModelController.f42970k0 != 0 || basePhotoModelController.f42967j0) && (list = this.f43059a) != null) {
                basePhotoModelController.f43003v0.removeAll(list);
            }
            return doNext(true, ((com.qzone.album.business.photolist.adapter.a) BasePhotoModelController.this.B1()).a(BasePhotoModelController.this.f43003v0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f43061a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f43062b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AlbumCacheData f43063c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Looper looper, List list, boolean z16, AlbumCacheData albumCacheData) {
            super(looper);
            this.f43061a = list;
            this.f43062b = z16;
            this.f43063c = albumCacheData;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            ((com.qzone.album.business.photolist.adapter.z) BasePhotoModelController.this.B1()).setData((List) obj);
            BasePhotoModelController.this.I4();
            BasePhotoModelController.this.Y0(this.f43061a, this.f43062b, this.f43063c);
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f43065a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Looper looper, List list) {
            super(looper);
            this.f43065a = list;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            return doNext(true, ((com.qzone.album.business.photolist.adapter.z) BasePhotoModelController.this.B1()).b(this.f43065a));
        }
    }

    /* loaded from: classes39.dex */
    class f implements c.b {
        f() {
        }

        @Override // com.qzone.album.business.photolist.ui.c.b
        public void a(View view) {
            if (QZoneContant.KEY_RESHIP.equals(view.getTag())) {
                BasePhotoModelController.this.s1(true, null, null, null);
                LpReportInfo_pf00064.allReport(86, 8, 1);
            } else {
                com.qzone.album.env.common.a.m().R("460", "2", "");
                LpReportInfo_pf00064.allReport(86, 7, 1);
                BasePhotoModelController.this.x3();
                BasePhotoModelController.this.f42973l0 = true;
            }
            if (BasePhotoModelController.this.D()) {
                com.qzone.album.env.common.a.m().P(95, 2, "3", true, "");
            }
        }

        @Override // com.qzone.album.business.photolist.ui.c.b
        public void b(View view) {
            com.qzone.album.env.common.a.m().R("460", "3", "");
            LpReportInfo_pf00064.allReport(86, 9, 1);
            BasePhotoModelController.this.n4();
            BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
            basePhotoModelController.f42973l0 = true;
            if (basePhotoModelController.D()) {
                com.qzone.album.env.common.a.m().P(95, 2, "4", true, "");
            }
        }

        @Override // com.qzone.album.business.photolist.ui.c.b
        public void c(View view) {
            BasePhotoModelController.this.H3();
        }

        @Override // com.qzone.album.business.photolist.ui.c.b
        public void d(View view) {
            BasePhotoModelController.this.r4();
        }

        @Override // com.qzone.album.business.photolist.ui.c.b
        public void e(View view) {
            Activity activity = BasePhotoModelController.this.Q;
            Intent x16 = ak.x(activity, activity.getString(R.string.gng), 0);
            if (BasePhotoModelController.this.f2() != null) {
                x16.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_DEFAULT_ALBUM_ID, BasePhotoModelController.this.f2().mAlbumId);
            }
            com.qzone.feed.utils.b.e(BasePhotoModelController.this.Q, x16, 22);
        }

        @Override // com.qzone.album.business.photolist.ui.c.b
        public void f(View view) {
            if (!BasePhotoModelController.this.P2()) {
                if (BasePhotoModelController.this.F0.size() == 0) {
                    return;
                }
                BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
                u4.a.z().q(BasePhotoModelController.this.Q, basePhotoModelController.f43012z0.x(basePhotoModelController.S.longValue(), BasePhotoModelController.this.T));
            }
            com.qzone.album.env.common.a.m().R("368", "4", "");
            LpReportInfo_pf00064.allReport(86, 11, 1);
            BasePhotoModelController.this.f42973l0 = true;
        }

        @Override // com.qzone.album.business.photolist.ui.c.b
        public void g(View view) {
            String str;
            BasePhotoModelController.this.m4(true);
            com.qzone.album.env.common.a m3 = com.qzone.album.env.common.a.m();
            if (!BasePhotoModelController.this.e3()) {
                str = "3";
            } else {
                str = "2";
            }
            m3.R("368", "3", str);
            int i3 = BasePhotoModelController.this.f42970k0;
            if (i3 == 1) {
                LpReportInfo_pf00064.allReport(86, 10, 1);
            } else if (i3 == 5) {
                LpReportInfo_pf00064.allReport(326, 3, 6);
            }
            BasePhotoModelController.this.f42973l0 = true;
        }

        @Override // com.qzone.album.business.photolist.ui.c.b
        public void h(View view) {
            BasePhotoModelController.this.t1();
            LpReportInfo_pf00064.allReport(86, 6, 1);
            if (BasePhotoModelController.this.D()) {
                com.qzone.album.env.common.a.m().P(95, 2, "2", true, "");
            }
        }

        @Override // com.qzone.album.business.photolist.ui.c.b
        public void i(View view) {
            BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
            int i3 = basePhotoModelController.f42970k0;
            if (i3 == 2) {
                basePhotoModelController.q3();
                BasePhotoModelController.this.Z0(false);
                if (BasePhotoModelController.this.D()) {
                    com.qzone.album.env.common.a.m().P(95, 5, "1", true, "");
                    return;
                }
                return;
            }
            if (i3 == 3) {
                basePhotoModelController.r3();
                if (BasePhotoModelController.this.D()) {
                    com.qzone.album.env.common.a.m().P(95, 7, "1", true, "");
                    return;
                }
                return;
            }
            if (i3 == 7) {
                basePhotoModelController.s3();
                BasePhotoModelController.this.Z0(false);
            }
        }

        @Override // com.qzone.album.business.photolist.ui.c.b
        public void j(View view) {
            BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
            basePhotoModelController.s1(false, basePhotoModelController.R1, BasePhotoModelController.this.S1, BasePhotoModelController.this.e0());
        }

        @Override // com.qzone.album.business.photolist.ui.c.b
        public void k(View view) {
            List<PhotoCacheData> list = BasePhotoModelController.this.f42968j1;
            if (list != null && !list.isEmpty()) {
                BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
                basePhotoModelController.Q3(basePhotoModelController.f42968j1);
                LpReportInfo_pf00064.allReport(326, 3, 3);
                return;
            }
            com.qzone.album.env.common.a.m().e("[PhotoAlbum] BasePhotoModelController", "onConfirmAll() noShootTimePhotoCacheDatas == null or noShootTimePhotoCacheDatas.size = 0 !");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f43068d;

        g(List list) {
            this.f43068d = list;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            BasePhotoModelController.this.s4(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogSaving", "\u4fdd\u5b58\u65f6\u95f4\u4e2d..."));
            ArrayList arrayList = new ArrayList();
            if (this.f43068d.size() > 0) {
                Iterator it = this.f43068d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    arrayList.add((PhotoCacheData) it.next());
                    if (arrayList.size() > BasePhotoModelController.this.f42951d2) {
                        com.qzone.album.env.common.a.m().V(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastModifyMostLimit", "\u4e00\u6b21\u6700\u591a\u4fee\u6539100\u5f20"));
                        break;
                    }
                }
                BasePhotoModelController.this.j4(arrayList);
                return;
            }
            com.qzone.album.env.common.a.m().e("[PhotoAlbum] BasePhotoModelController", "saveNoShootTimePhotoTime() photos size = 0 !");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class h implements DialogInterface.OnClickListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes39.dex */
    class i implements AbsCompatRequest.a {
        i() {
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0083  */
        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            String I;
            String I2;
            BasePhotoModelController.this.i1();
            boolean z16 = absCompatRequest instanceof QZoneAlbumSortPhotoRequest;
            if (z16) {
                BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
                if (basePhotoModelController.f42980n1) {
                    I = basePhotoModelController.I(R.string.gbd);
                    I2 = BasePhotoModelController.this.I(R.string.gjg);
                    BasePhotoModelController.this.f42980n1 = false;
                    if (!sVar.getSucceed()) {
                        com.qzone.album.env.common.a.m().W(I, 2);
                        BasePhotoModelController.this.h1();
                        BasePhotoModelController.this.g1();
                        BasePhotoModelController.this.P4();
                        BasePhotoModelController basePhotoModelController2 = BasePhotoModelController.this;
                        if (basePhotoModelController2.f42977m1) {
                            basePhotoModelController2.Z0(false);
                            BasePhotoModelController.this.o0();
                        } else if (basePhotoModelController2.f42983o1) {
                            basePhotoModelController2.o0();
                        }
                    } else if (!TextUtils.isEmpty(sVar.getMessage())) {
                        com.qzone.album.env.common.a.m().V(sVar.getMessage());
                    } else {
                        com.qzone.album.env.common.a.m().W(I2, 1);
                    }
                    BasePhotoModelController basePhotoModelController3 = BasePhotoModelController.this;
                    basePhotoModelController3.f42977m1 = false;
                    basePhotoModelController3.f42983o1 = false;
                    if (!(absCompatRequest instanceof QZoneOptAlbumRequest) || ((absCompatRequest instanceof QZoneOperateTravelPhotoSceneRequest) && ((QZoneOperateTravelPhotoSceneRequest) absCompatRequest).singleNodeModify)) {
                        basePhotoModelController3.n3(false);
                    }
                    return;
                }
            }
            if (!(absCompatRequest instanceof QZoneOperateTravelPhotoSceneRequest) && ((!z16 || BasePhotoModelController.this.f42980n1) && !(absCompatRequest instanceof QZoneOptAlbumRequest))) {
                if (absCompatRequest instanceof QZoneMoveBatchPhotosRequest) {
                    I = BasePhotoModelController.this.I(R.string.gjl);
                    I2 = BasePhotoModelController.this.I(R.string.gjj);
                } else if (!(absCompatRequest instanceof QZoneDelBatchPhotosRequest) && !(absCompatRequest instanceof QzoneBatchDeleteVideoRequest)) {
                    I = "";
                    I2 = "";
                } else {
                    I = BasePhotoModelController.this.I(R.string.gjb);
                    I2 = BasePhotoModelController.this.I(R.string.gja);
                }
            } else {
                I = BasePhotoModelController.this.I(R.string.gjh);
                I2 = BasePhotoModelController.this.I(R.string.gjg);
            }
            if (!sVar.getSucceed()) {
            }
            BasePhotoModelController basePhotoModelController32 = BasePhotoModelController.this;
            basePhotoModelController32.f42977m1 = false;
            basePhotoModelController32.f42983o1 = false;
            if (absCompatRequest instanceof QZoneOptAlbumRequest) {
            }
            basePhotoModelController32.n3(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class j implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f43072a;

        j(List list) {
            this.f43072a = list;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            if (sVar.getSucceed()) {
                com.qzone.album.env.common.a.m().W(BasePhotoModelController.this.I(R.string.gbd), 5);
                List<PhotoCacheData> list = BasePhotoModelController.this.f43003v0;
                if (list != null) {
                    list.removeAll(this.f43072a);
                    BasePhotoModelController.this.g1();
                    BasePhotoModelController.this.P4();
                    BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
                    basePhotoModelController.x2(basePhotoModelController.f43003v0, true, basePhotoModelController.g());
                    return;
                }
                return;
            }
            com.qzone.album.env.common.a.m().W(com.qzone.util.l.a(R.string.jzj) + sVar.getMessage() + ")", 4);
        }
    }

    /* loaded from: classes39.dex */
    class l implements AbsCompatRequest.a {
        l() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
            if (basePhotoModelController.f407176h != 1) {
                return;
            }
            basePhotoModelController.C0(true);
            BasePhotoModelController.this.C2(sVar);
        }
    }

    /* loaded from: classes39.dex */
    class m implements AbsCompatRequest.a {
        m() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            f.a.a("qzone_photo_list_refresh_net_time");
            BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
            basePhotoModelController.X1 = false;
            basePhotoModelController.h0();
            BasePhotoModelController.this.C0(true);
            BasePhotoModelController basePhotoModelController2 = BasePhotoModelController.this;
            if (basePhotoModelController2.f407176h != 1) {
                return;
            }
            basePhotoModelController2.D2(sVar);
        }
    }

    /* loaded from: classes39.dex */
    class n implements AbsCompatRequest.a {
        n() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
            if (basePhotoModelController.f407176h != 2) {
                return;
            }
            basePhotoModelController.s2(sVar);
        }
    }

    /* loaded from: classes39.dex */
    class o implements AbsCompatRequest.a {
        o() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            BasePhotoModelController.this.h0();
            BasePhotoModelController.this.C0(true);
            BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
            if (basePhotoModelController.f407176h != 1) {
                return;
            }
            basePhotoModelController.H2(sVar);
        }
    }

    /* loaded from: classes39.dex */
    class p implements AbsCompatRequest.a {
        p() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
            if (basePhotoModelController.f407176h != 2) {
                return;
            }
            basePhotoModelController.t2(sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class q implements AbsCompatRequest.a {
        q() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            if (sVar.getSucceed()) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastInviteSend", "\u9080\u8bf7\u4fe1\u606f\u5df2\u53d1\u9001"), 5);
            } else if (!TextUtils.isEmpty(sVar.getMessage())) {
                ToastUtil.s(sVar.getMessage(), 4);
            } else {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFailAndRetry", "\u64cd\u4f5c\u5931\u8d25\u8bf7\u91cd\u8bd5"), 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class r extends HdAsyncAction {
        r(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            if (obj == null) {
                return doNext(false);
            }
            BasePhotoModelController.this.f43000u0.clear();
            List<PhotoCacheData[]> list = (List) obj;
            BasePhotoModelController.this.f43000u0.addAll(list);
            ((com.qzone.album.business.photolist.adapter.a) BasePhotoModelController.this.B1()).setData(list);
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class s extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f43082a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(Looper looper, List list) {
            super(looper);
            this.f43082a = list;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            return doNext(true, ((com.qzone.album.business.photolist.adapter.a) BasePhotoModelController.this.B1()).a(this.f43082a));
        }
    }

    /* loaded from: classes39.dex */
    class u implements QzoneGestureSelectListView.c {

        /* renamed from: a, reason: collision with root package name */
        boolean f43085a;

        /* renamed from: b, reason: collision with root package name */
        z f43086b;

        /* renamed from: c, reason: collision with root package name */
        z f43087c;

        /* renamed from: d, reason: collision with root package name */
        z f43088d;

        u() {
        }

        @Override // com.qzone.album.ui.widget.QzoneGestureSelectListView.c
        public void a(int i3, int i16) {
            int i17 = BasePhotoModelController.f42937x2;
            if (i16 >= i17) {
                i16 = i17 - 1;
            }
            BasePhotoModelController.this.y1(this.f43085a);
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "onSelectEnd row " + i3 + " column " + i16 + " mIsSelected " + this.f43085a);
            this.f43087c = null;
            this.f43088d = null;
            this.f43086b = null;
        }

        @Override // com.qzone.album.ui.widget.QzoneGestureSelectListView.c
        public void b(int i3, int i16) {
            PhotoCacheData[] photoCacheDataArr;
            PhotoCacheData photoCacheData;
            int i17 = BasePhotoModelController.f42937x2;
            if (i16 >= i17) {
                i16 = i17 - 1;
            }
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "onSelectBegin row " + i3 + " column " + i16);
            List<PhotoCacheData[]> list = BasePhotoModelController.this.f43000u0;
            if (list == null || i3 >= list.size() || (photoCacheDataArr = BasePhotoModelController.this.f43000u0.get(i3)) == null || i16 >= photoCacheDataArr.length || (photoCacheData = photoCacheDataArr[i16]) == null || BasePhotoModelController.this.R2(photoCacheData)) {
                return;
            }
            this.f43088d = new z(i3, i16);
            this.f43087c = new z(i3, i16);
            this.f43086b = new z(i3, i16);
            PhotoCacheData photoCacheData2 = photoCacheDataArr[i16];
            this.f43085a = true ^ photoCacheData2.isChecked;
            BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
            basePhotoModelController.b4(photoCacheData2, basePhotoModelController.a2(i3, i16), this.f43085a);
            BasePhotoModelController.this.J4();
        }

        @Override // com.qzone.album.ui.widget.QzoneGestureSelectListView.c
        public void onSelectChanged(int i3, int i16) {
            z b16;
            int i17 = BasePhotoModelController.f42937x2;
            if (i16 >= i17) {
                i16 = i17 - 1;
            }
            int i18 = 0;
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "onSelectChanged row " + i3 + " column " + i16);
            if (this.f43086b == null) {
                RFWLog.e("[PhotoAlbum] BasePhotoModelController", RFWLog.USR, "onSelectChanged error, mBeginIndex is null");
                return;
            }
            z zVar = new z(i3, i16);
            z m3 = BasePhotoModelController.this.m3(this.f43086b, zVar);
            z t36 = BasePhotoModelController.this.t3(this.f43086b, zVar);
            if (zVar.c() < this.f43086b.c()) {
                z zVar2 = this.f43088d;
                this.f43088d = BasePhotoModelController.this.m3(zVar, zVar2);
                if (zVar.c() < zVar2.c() && (b16 = zVar2.b()) != null && b16.c() >= zVar.c()) {
                    if (b16.f43094a == zVar.f43094a) {
                        for (int i19 = b16.f43095b; i19 >= zVar.f43095b; i19--) {
                            BasePhotoModelController.this.g4(b16.f43094a, i19, this.f43085a);
                        }
                    } else {
                        for (int i26 = b16.f43095b; i26 >= 0; i26--) {
                            BasePhotoModelController.this.g4(b16.f43094a, i26, this.f43085a);
                        }
                        for (int i27 = b16.f43094a - 1; i27 > zVar.f43094a; i27--) {
                            for (int i28 = BasePhotoModelController.f42937x2 - 1; i28 >= 0; i28--) {
                                BasePhotoModelController.this.g4(i27, i28, this.f43085a);
                            }
                        }
                        for (int i29 = BasePhotoModelController.f42937x2 - 1; i29 >= zVar.f43095b; i29--) {
                            BasePhotoModelController.this.g4(zVar.f43094a, i29, this.f43085a);
                        }
                    }
                }
            } else {
                z zVar3 = this.f43087c;
                this.f43087c = BasePhotoModelController.this.t3(zVar, zVar3);
                if (zVar.c() > zVar3.c()) {
                    z a16 = zVar3.a();
                    if (a16.c() <= zVar.c()) {
                        if (a16.f43094a == zVar.f43094a) {
                            for (int i36 = a16.f43095b; i36 <= zVar.f43095b; i36++) {
                                BasePhotoModelController.this.g4(a16.f43094a, i36, this.f43085a);
                            }
                        } else {
                            for (int i37 = a16.f43095b; i37 < BasePhotoModelController.f42937x2; i37++) {
                                BasePhotoModelController.this.g4(a16.f43094a, i37, this.f43085a);
                            }
                            for (int i38 = a16.f43094a + 1; i38 < zVar.f43094a; i38++) {
                                for (int i39 = 0; i39 < BasePhotoModelController.f42937x2; i39++) {
                                    BasePhotoModelController.this.g4(i38, i39, this.f43085a);
                                }
                            }
                            for (int i46 = 0; i46 <= zVar.f43095b; i46++) {
                                BasePhotoModelController.this.g4(zVar.f43094a, i46, this.f43085a);
                            }
                        }
                    }
                }
            }
            z b17 = m3.b();
            z zVar4 = this.f43088d;
            if (zVar4 != null && b17 != null && zVar4.c() <= b17.c()) {
                int i47 = b17.f43094a;
                z zVar5 = this.f43088d;
                if (i47 == zVar5.f43094a) {
                    for (int i48 = zVar5.f43095b; i48 <= b17.f43095b; i48++) {
                        BasePhotoModelController.this.g4(this.f43088d.f43094a, i48, !this.f43085a);
                    }
                } else {
                    for (int i49 = zVar5.f43095b; i49 < BasePhotoModelController.f42937x2; i49++) {
                        BasePhotoModelController.this.g4(this.f43088d.f43094a, i49, !this.f43085a);
                    }
                    for (int i56 = this.f43088d.f43094a + 1; i56 < b17.f43094a; i56++) {
                        for (int i57 = 0; i57 < BasePhotoModelController.f42937x2; i57++) {
                            BasePhotoModelController.this.g4(i56, i57, !this.f43085a);
                        }
                    }
                    for (int i58 = 0; i58 <= b17.f43095b; i58++) {
                        BasePhotoModelController.this.g4(b17.f43094a, i58, !this.f43085a);
                    }
                }
            }
            z a17 = t36.a();
            if (this.f43087c != null && a17.c() <= this.f43087c.c()) {
                if (a17.f43094a == this.f43087c.f43094a) {
                    for (int i59 = a17.f43095b; i59 <= this.f43087c.f43095b; i59++) {
                        BasePhotoModelController.this.g4(a17.f43094a, i59, !this.f43085a);
                    }
                } else {
                    for (int i65 = a17.f43095b; i65 < BasePhotoModelController.f42937x2; i65++) {
                        BasePhotoModelController.this.g4(a17.f43094a, i65, !this.f43085a);
                    }
                    for (int i66 = a17.f43094a + 1; i66 < this.f43087c.f43094a; i66++) {
                        for (int i67 = 0; i67 < BasePhotoModelController.f42937x2; i67++) {
                            BasePhotoModelController.this.g4(i66, i67, !this.f43085a);
                        }
                    }
                    while (true) {
                        z zVar6 = this.f43087c;
                        if (i18 > zVar6.f43095b) {
                            break;
                        }
                        BasePhotoModelController.this.g4(zVar6.f43094a, i18, !this.f43085a);
                        i18++;
                    }
                }
            }
            if (zVar.c() < this.f43086b.c()) {
                this.f43088d = zVar;
                z zVar7 = this.f43087c;
                if (zVar7 != null && zVar7.c() > this.f43086b.c()) {
                    this.f43087c = this.f43086b;
                }
            } else {
                this.f43087c = zVar;
                z zVar8 = this.f43088d;
                if (zVar8 != null && zVar8.c() < this.f43086b.c()) {
                    this.f43088d = this.f43086b;
                }
            }
            BasePhotoModelController.this.J4();
        }
    }

    /* loaded from: classes39.dex */
    class v implements QZonePullToRefreshListView.b {
        v() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.b
        public void V9() {
            com.qzone.album.env.common.a.m().l(PerfTracer.QZONEALBUM_SHOW);
            BasePhotoModelController.this.f42960g2.a();
        }
    }

    /* loaded from: classes39.dex */
    class w implements c.b {
        w() {
        }

        @Override // com.qzone.album.ui.widget.c.b
        public void a() {
            try {
                BasePhotoModelController.this.G3();
            } catch (Throwable th5) {
                QLog.e("[PhotoAlbum] BasePhotoModelController", 1, "[opClick] error: ", th5);
            }
        }

        @Override // com.qzone.album.ui.widget.c.b
        public void b() {
            BasePhotoModelController.this.l3();
        }

        @Override // com.qzone.album.ui.widget.c.b
        public void refresh() {
            try {
                BasePhotoModelController.this.C0(false);
                BasePhotoModelController.this.l4(true);
                BasePhotoModelController.this.z4();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class x extends QQPermission.BasePermissionsListener {
        x() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            BasePhotoModelController.this.u4();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class y implements c.InterfaceC10604c {
        y() {
        }

        @Override // jp.c.InterfaceC10604c
        public void a(int i3, int i16, int i17) {
            long f16 = jp.a.f(BasePhotoModelController.this.Y0, i3, i16, i17);
            if (f16 > System.currentTimeMillis()) {
                ToastUtil.s(BasePhotoModelController.this.Q.getString(R.string.gbv), 4);
                return;
            }
            if (f16 <= 0) {
                ToastUtil.s(BasePhotoModelController.this.Q.getString(R.string.gbu), 4);
                return;
            }
            BasePhotoModelController.this.Y0.m();
            BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
            basePhotoModelController.t4(basePhotoModelController.H0, (int) (f16 / 1000));
            int i18 = BasePhotoModelController.this.f42970k0;
            if (i18 == 1) {
                LpReportInfo_pf00064.allReport(86, 10, 2);
            } else if (i18 == 5) {
                LpReportInfo_pf00064.allReport(326, 3, 7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public class z {

        /* renamed from: a, reason: collision with root package name */
        int f43094a;

        /* renamed from: b, reason: collision with root package name */
        int f43095b;

        z() {
        }

        z a() {
            int i3 = this.f43095b;
            if (i3 < BasePhotoModelController.f42937x2 - 1) {
                this.f43095b = i3 + 1;
            } else {
                this.f43094a++;
                this.f43095b = 0;
            }
            return new z(this.f43094a, this.f43095b);
        }

        z b() {
            int i3 = this.f43095b;
            if (i3 == 0) {
                int i16 = this.f43094a;
                if (i16 <= 0) {
                    return null;
                }
                this.f43094a = i16 - 1;
                this.f43095b = BasePhotoModelController.f42937x2 - 1;
            } else if (i3 > 0) {
                this.f43095b = i3 - 1;
            }
            return new z(this.f43094a, this.f43095b);
        }

        int c() {
            return BasePhotoModelController.this.a2(this.f43094a, this.f43095b);
        }

        z(int i3, int i16) {
            this.f43094a = i3;
            this.f43095b = i16;
        }
    }

    public BasePhotoModelController(FragmentActivity fragmentActivity, u4.h hVar) {
        super(fragmentActivity);
        this.f42958g0 = false;
        this.f42961h0 = true;
        this.f42964i0 = false;
        this.f42970k0 = 0;
        this.f42973l0 = false;
        this.f42991r0 = 0;
        this.f42994s0 = true;
        this.B0 = true;
        this.C0 = 0;
        this.E0 = new ArrayList<>();
        this.F0 = new ArrayList<>(1);
        this.G0 = new ArrayList<>();
        this.I0 = false;
        this.J0 = f42939z2;
        this.K0 = false;
        this.L0 = false;
        this.M0 = new com.qzone.album.business.photolist.ui.menu.c();
        this.O0 = false;
        this.P0 = 0L;
        this.Q0 = "";
        this.R0 = 0L;
        this.Z0 = true;
        this.f42944b1 = 0;
        this.f42947c1 = 0;
        this.f42950d1 = false;
        this.f42953e1 = false;
        this.f42956f1 = false;
        this.f42959g1 = false;
        this.f42962h1 = false;
        this.f42968j1 = new CopyOnWriteArrayList();
        this.f42971k1 = new HashMap();
        this.f42974l1 = null;
        this.f42977m1 = false;
        this.f42980n1 = false;
        this.f42983o1 = false;
        this.f42986p1 = 0;
        this.f43001u1 = false;
        this.f43004v1 = false;
        this.f43007w1 = false;
        this.f43009x1 = null;
        this.f43011y1 = -1;
        this.f43013z1 = -1;
        this.A1 = 0;
        this.B1 = 0;
        this.D1 = null;
        this.E1 = null;
        this.F1 = null;
        this.G1 = null;
        this.S1 = new n5.c();
        this.T1 = false;
        this.U1 = false;
        this.V1 = false;
        this.X1 = false;
        this.Y1 = false;
        this.Z1 = false;
        this.f42948c2 = false;
        this.f42951d2 = 100;
        this.f42957f2 = false;
        this.f42963h2 = -1L;
        this.f42966i2 = -1L;
        this.f42969j2 = -1;
        this.f42972k2 = -1;
        this.f42975l2 = false;
        this.f42981n2 = new i();
        this.f42990q2 = new l();
        this.f42993r2 = new m();
        this.f42996s2 = new n();
        this.f42999t2 = new o();
        this.f43002u2 = new p();
        this.f43005v2 = new u();
        this.P = com.qzone.album.env.common.a.m().n(fragmentActivity);
        this.Q = fragmentActivity;
        this.f43010y0 = com.qzone.album.base.Service.a.W();
        this.f43012z0 = AlbumCacheDataManager.J();
        this.W1 = hVar;
    }

    private void D3() {
        if (TextUtils.isEmpty(this.U0)) {
            return;
        }
        String[] split = this.U0.split(ContainerUtils.FIELD_DELIMITER);
        if (split.length > 0) {
            String str = null;
            String str2 = null;
            String str3 = null;
            for (String str4 : split) {
                if (str4.startsWith("albumid")) {
                    str = str4.replace("albumid=", "");
                } else if (str4.startsWith("res_uin")) {
                    str3 = str4.replace("res_uin=", "");
                } else if (str4.startsWith("theme")) {
                    str2 = str4.replace("theme=", "");
                }
            }
            if (!TextUtils.isEmpty(str)) {
                this.T = str;
            }
            if (!TextUtils.isEmpty(str3)) {
                try {
                    this.S = Long.valueOf(Long.parseLong(str3));
                } catch (NumberFormatException e16) {
                    e16.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(str2)) {
                this.f42940a0 = 1;
                return;
            }
            try {
                this.f42940a0 = Integer.valueOf(str2).intValue();
            } catch (NumberFormatException e17) {
                this.f42940a0 = 1;
                e17.printStackTrace();
            }
        }
    }

    private ArrayList<PhotoCacheData> E1(PhotoPoiArea photoPoiArea) {
        HashMap<Long, s4.d> hashMap;
        com.qzone.album.business.photolist.adapter.u uVar = (com.qzone.album.business.photolist.adapter.u) B1();
        if (photoPoiArea != null && (hashMap = uVar.R) != null) {
            for (Map.Entry<Long, s4.d> entry : hashMap.entrySet()) {
                if (photoPoiArea.equals(entry.getValue().f433297d)) {
                    return entry.getValue().f433296c;
                }
            }
        }
        return null;
    }

    private List<PhotoCacheData> F1() {
        PictureItem pictureItem;
        int i3;
        int i16 = this.f42970k0;
        int i17 = 0;
        ArrayList arrayList = null;
        if (i16 != 2 && i16 != 7) {
            if (i16 != 3 && !this.f42967j0) {
                while (i17 < this.f43003v0.size()) {
                    PhotoCacheData photoCacheData = this.f43003v0.get(i17);
                    if (photoCacheData.isFakePhoto() && photoCacheData.isVideo()) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(photoCacheData);
                    }
                    i17++;
                }
            } else {
                while (i17 < this.f43003v0.size()) {
                    PhotoCacheData photoCacheData2 = this.f43003v0.get(i17);
                    if (photoCacheData2.isFakePhoto() || photoCacheData2.picItem.type == 2 || (photoCacheData2.videoflag == 1 && photoCacheData2.videodata.validVideoTime > ViewerModelController.Q4)) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(photoCacheData2);
                    }
                    i17++;
                }
            }
        } else {
            while (i17 < this.f43003v0.size()) {
                PhotoCacheData photoCacheData3 = this.f43003v0.get(i17);
                if (photoCacheData3.isFakePhoto() || photoCacheData3.isVideo() || ((pictureItem = photoCacheData3.picItem) != null && ((i3 = pictureItem.flag) == 32 || i3 == 16))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(photoCacheData3);
                }
                i17++;
            }
        }
        return arrayList;
    }

    private void F4(Map<Integer, String> map) {
        if (map == null || map.get(0) == null) {
            return;
        }
        try {
            this.f42986p1 = Integer.parseInt(map.get(0));
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "mTotalNoShootTimePhotoCount:" + this.f42986p1 + " mBuis_pram:" + this.f42971k1);
            this.f42971k1 = map;
        } catch (NumberFormatException e16) {
            QZLog.e("[PhotoAlbum] BasePhotoModelController", "[updateNoShootTimePhotoCount]", e16);
        }
    }

    private void H4() {
        com.qzone.album.business.photolist.controller.d dVar = this.f42945b2;
        if (dVar != null) {
            dVar.I();
        }
    }

    public static String J1(long j3) {
        return "key_video_hasmore_pre_" + j3;
    }

    private void O3() {
        AlbumCacheData albumCacheData = this.f43008x0;
        com.qzone.album.base.Service.a.W().F(albumCacheData.createAlbumRequestModel(1, albumCacheData, -1), "", "", "", (byte) 0, new q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q3(List<PhotoCacheData> list) {
        u4.a.z().e(this.Q, new g(list), new h());
    }

    private void T3(String str) {
        PhotoCacheData photoCacheData;
        try {
            int count = B1().getCount();
            for (int i3 = 0; i3 < count; i3++) {
                PhotoCacheData[] photoCacheDataArr = (PhotoCacheData[]) B1().getItem(i3);
                if (photoCacheDataArr != null && (photoCacheData = photoCacheDataArr[0]) != null && photoCacheData != null && photoCacheData.lloc.equals(str)) {
                    this.W1.getListView().requestFocusFromTouch();
                    this.W1.getListView().setSelectionFromTop(this.f42947c1 + i3 + 1, ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID);
                    if (i3 >= 1) {
                        a1(true);
                    } else {
                        a1(false);
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(List<? extends com.qzone.component.cache.database.a> list, boolean z16, AlbumCacheData albumCacheData) {
        com.qzone.album.business.photolist.ui.interactingbar.a aVar;
        if (this.f42970k0 == 0 && this.U != null && !Q2() && !this.O0) {
            this.W1.setTitle(this.U);
            if (this.W1.z()) {
                this.W1.g1();
                this.W1.J();
            } else {
                this.W1.J1();
            }
        }
        c1(albumCacheData);
        if (this.f43013z1 == 0 && this.f43009x1 != null && !S2()) {
            T3(this.f43009x1);
        }
        if (this.f43001u1 && this.f43004v1) {
            v2();
        }
        if (z16) {
            if (list != null && list.size() != 0) {
                l4(false);
            }
            z4();
            return;
        }
        l4(false);
        if (B1().getCount() <= 0 && !com.qzone.album.util.b.f(this.f43008x0)) {
            if (this.W1.v() != null) {
                this.W1.v().setVisibility(0);
            }
            com.qzone.album.business.photolist.ui.interactingbar.a aVar2 = this.J1;
            if (aVar2 != null) {
                aVar2.d(false);
            }
            this.W1.J1();
            if (this.W1.z2() != null) {
                this.W1.z2().F();
                return;
            }
            return;
        }
        if (this.f42970k0 != 0 || (aVar = this.J1) == null || aVar == null) {
            return;
        }
        aVar.h(false);
    }

    private void a1(boolean z16) {
        if (this.Q != null) {
            if (z16) {
                this.W1.J1();
            } else {
                this.W1.g1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a2(int i3, int i16) {
        return (i3 * f42937x2) + i16;
    }

    private PhotoPoiArea b2(PhotoCacheData photoCacheData) {
        TravelAlbumData travelAlbumData;
        ArrayList<PhotoPoiArea> arrayList;
        AlbumCacheData albumCacheData = this.f43008x0;
        if (albumCacheData != null && (travelAlbumData = albumCacheData.travelData) != null && (arrayList = travelAlbumData.photoPoiAreaList) != null) {
            Iterator<PhotoPoiArea> it = arrayList.iterator();
            while (it.hasNext()) {
                PhotoPoiArea next = it.next();
                if (photoCacheData != null && next != null) {
                    long j3 = photoCacheData.shoottime;
                    if (j3 >= next.startShootTime && j3 <= next.endShootTime) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e2() {
        if (Y2()) {
            return "4";
        }
        if (e3()) {
            return "2";
        }
        if (i3()) {
            return "3";
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g4(int i3, int i16, boolean z16) {
        PhotoCacheData[] photoCacheDataArr;
        PhotoCacheData photoCacheData;
        List<PhotoCacheData[]> list = this.f43000u0;
        if (list == null || i3 >= list.size() || (photoCacheDataArr = this.f43000u0.get(i3)) == null || i16 >= photoCacheDataArr.length || (photoCacheData = photoCacheDataArr[i16]) == null || photoCacheData.isChecked == z16 || R2(photoCacheData)) {
            return;
        }
        b4(photoCacheDataArr[i16], a2(i3, i16), z16);
    }

    private void j1() {
        int i3 = this.f42970k0;
        if (i3 == 2 || i3 == 3 || i3 == 7) {
            C1(i3).a();
        }
    }

    private z k1(z zVar) {
        z zVar2 = new z();
        zVar2.f43094a = zVar.f43094a;
        zVar2.f43095b = zVar.f43095b;
        return zVar2;
    }

    private void r2() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(268435456);
        intent.addCategory("android.intent.category.HOME");
        V(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1(boolean z16) {
        if (P2() || this.f42970k0 != 1) {
            return;
        }
        LpReportInfo_pf00064.allReport(86, 4, z16 ? 5 : 6, false);
    }

    private void y2(List<? extends com.qzone.component.cache.database.a> list, boolean z16, AlbumCacheData albumCacheData) {
        List<PhotoCacheData> F1 = F1();
        ((com.qzone.album.business.photolist.adapter.a) B1()).G(this.f42991r0);
        if (this.f42962h1) {
            ((com.qzone.album.business.photolist.adapter.a) B1()).C(true);
        } else {
            ((com.qzone.album.business.photolist.adapter.a) B1()).C(true ^ this.f42994s0);
        }
        HdAsync.with(this).then(new c(com.qzone.album.env.common.a.m().u().getLooper(), F1)).then(new b(Looper.getMainLooper(), F1, z16, list, albumCacheData)).call();
    }

    private void z2(List<? extends com.qzone.component.cache.database.a> list, boolean z16, AlbumCacheData albumCacheData) {
        HdAsync.with(this).then(new e(com.qzone.album.env.common.a.m().u().getLooper(), list)).then(new d(Looper.getMainLooper(), list, z16, albumCacheData)).call();
    }

    @Override // x4.a
    public boolean A() {
        return false;
    }

    public int A1() {
        return this.f42940a0;
    }

    @Override // x4.a
    public View.OnClickListener B(LoveAlbumTimeEvent loveAlbumTimeEvent, long j3) {
        return new ad(loveAlbumTimeEvent, j3);
    }

    public BaseAdapter B1() {
        return this.f407177i;
    }

    public void B3(Activity activity) {
        if (this.X0 != null) {
            this.X0 = null;
        }
    }

    @Override // x4.a
    public long C() {
        return this.S.longValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.qzone.album.business.photolist.ui.c C1(int i3) {
        if (this.I1 == null) {
            this.I1 = new com.qzone.album.business.photolist.ui.c(this.Q, this);
        }
        this.I1.e(i3);
        return this.I1;
    }

    @Override // x4.a
    public boolean D() {
        return this.f42955f0 == 4;
    }

    @Override // com.qzone.album.env.common.c
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public QZonePullToRefreshListView R3() {
        return this.W1.getListView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D2(com.qzone.adapter.feedcomponent.s sVar) {
        int i3;
        this.W1.y();
        if (sVar == null) {
            l4(false);
            this.f42941a1.l(5);
            com.qzone.album.env.common.a.m().c(QZLog.TO_DEVICE_TAG, "[PhotoAlbum] BasePhotoModelController", "\t result is null");
            return;
        }
        int returnCode = sVar.getReturnCode();
        if (returnCode != 0) {
            if (com.qzone.album.util.d.e(returnCode)) {
                if (TextUtils.isEmpty(this.f42982o0)) {
                    e4(1);
                    o0();
                    return;
                }
                i3 = 0;
            } else {
                i3 = !com.qzone.album.util.d.d(returnCode) ? 1 : -1;
            }
            if (i3 != -1) {
                v1(i3, sVar.getMessage());
                x1();
                return;
            }
        }
        if (sVar.getSucceed()) {
            G2(sVar);
        } else {
            E2(sVar);
        }
        if (Q2()) {
            return;
        }
        O4(sVar.getNewCnt() <= 0);
    }

    @Override // x4.a
    public boolean E() {
        return this.f43001u1;
    }

    public void E4() {
        if (this.f43010y0 == null) {
            return;
        }
        com.qzone.album.env.common.a.m().H(new Runnable() { // from class: com.qzone.album.business.photolist.controller.BasePhotoModelController.6
            @Override // java.lang.Runnable
            public void run() {
                BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
                final int R = basePhotoModelController.f43012z0.R(basePhotoModelController.T);
                BasePhotoModelController.this.e0().post(new Runnable() { // from class: com.qzone.album.business.photolist.controller.BasePhotoModelController.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (R <= 0) {
                            return;
                        }
                        long longValue = BasePhotoModelController.this.S.longValue();
                        BasePhotoModelController basePhotoModelController2 = BasePhotoModelController.this;
                        if (com.qzone.album.base.b.a(BasePhotoModelController.I1(longValue, basePhotoModelController2.T, basePhotoModelController2.f42955f0))) {
                            BasePhotoModelController.this.y0(5);
                        } else {
                            BasePhotoModelController.this.y0(6);
                        }
                    }
                });
            }
        });
        if (k3()) {
            Q4();
        }
    }

    protected void F2() {
        if (Q2()) {
            this.f42941a1.l(7);
        } else if (P2()) {
            AlbumCacheData albumCacheData = this.f43008x0;
            if (albumCacheData != null && ((albumCacheData.isSharingAlbumPartner() && this.f43008x0.isInShareList()) || this.f43008x0.isSharingAlbumCreator())) {
                if (this.f43008x0.isShareInvitePanding()) {
                    this.f42941a1.l(8);
                } else {
                    this.f42941a1.l(1);
                }
                if (this.O0 && this.P0 != LoginData.getInstance().getUin()) {
                    this.f42941a1.n(false);
                } else {
                    this.f42941a1.n(true);
                }
            } else {
                this.f42941a1.l(1);
                this.f42941a1.n(false);
            }
        } else if (!h()) {
            this.f42941a1.l(1);
            this.f42941a1.n(false);
        } else {
            this.f42941a1.l(1);
            View view = this.O1;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        List<PhotoCacheData> list = this.f43003v0;
        if (list == null || list.size() != 0) {
            return;
        }
        this.W1.getListView().setCoverMode(true, -f42936w2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i4.a
    public Intent G() {
        return this.R;
    }

    public View.OnClickListener G1() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G3() {
        if (QZonePermission.requestStoragePermission(q2(), new x(), QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA)) {
            u4();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G4(List<PhotoCacheData> list, boolean z16) {
        F4(this.f42971k1);
    }

    public View.OnClickListener H1() {
        return null;
    }

    public void H2(com.qzone.adapter.feedcomponent.s sVar) {
        this.W1.y();
        if (sVar == null) {
            this.f42941a1.l(5);
            com.qzone.album.env.common.a.m().c("[PhotoAlbum] BasePhotoModelController", "[PhotoAlbum] BasePhotoModelController", "\t result is null");
            return;
        }
        f1(sVar);
        com.qzone.album.env.common.a.m().c("[PhotoAlbum] BasePhotoModelController", "[PhotoAlbum] BasePhotoModelController", "\t " + sVar.getSucceed());
        if (sVar.getSucceed()) {
            if (sVar.getNewCnt() == 0) {
                this.f42941a1.l(3);
                if (!P2()) {
                    this.f42941a1.n(!f3());
                }
            }
            o4(J1(this.S.longValue()), sVar.getHasMore());
        } else {
            this.f42941a1.l(5);
            this.W1.getListView().r0(I(R.string.gm5), sVar.getMessage());
            y0(p2());
        }
        Q4();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i4.a
    public String I(int i3) {
        return this.P.getString(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I3() {
        if (this.f42971k1 == null) {
            this.f42971k1 = new HashMap();
        }
        if (h3() || d3()) {
            if (this.f42974l1 != null) {
                this.f42971k1.put(2, this.f42974l1);
                this.f42974l1 = null;
            } else if (QZoneAlbumUtil.A(this.f42970k0)) {
                this.f42971k1.put(2, "1");
            } else if (!this.f42959g1 && !this.f42962h1) {
                this.f42971k1.put(2, "0");
            } else {
                this.f42971k1.put(2, "2");
            }
            if (S2()) {
                this.f42971k1.put(3, "1");
            } else {
                this.f42971k1.put(3, "0");
            }
        }
        this.f42959g1 = false;
    }

    public void I4() {
        if (this.f42970k0 != 0) {
            ArrayList arrayList = new ArrayList();
            List<PhotoCacheData> list = this.H0;
            if (list != null) {
                for (PhotoCacheData photoCacheData : list) {
                    if (!this.f43003v0.contains(photoCacheData)) {
                        arrayList.add(photoCacheData);
                        com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "updateSelectedPhotoInManageModel | remove PhotoCache:", photoCacheData.lloc);
                    }
                }
                this.H0.removeAll(arrayList);
                P4();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0060. Please report as an issue. */
    @Override // i4.a
    public void J(s8.b bVar) {
        int c16;
        if ("WriteOperation".equals(bVar.a()) && ((c16 = bVar.c()) == 8 || c16 == 11 || c16 == 45 || c16 == 47 || c16 == 50)) {
            z4();
        }
        if ("QzoneAlbum".equals(bVar.a()) && bVar.b() != null && (bVar.b() instanceof Object[])) {
            Object[] objArr = (Object[]) bVar.b();
            int c17 = bVar.c();
            if (c17 != 20) {
                if (c17 != 1001) {
                    if (c17 != 22) {
                        if (c17 != 23) {
                            switch (c17) {
                                case 2:
                                    Object obj = objArr[0];
                                    if (obj == null || !(obj instanceof Album)) {
                                        return;
                                    }
                                    B4((Album) obj);
                                    return;
                                case 3:
                                case 6:
                                    break;
                                case 4:
                                    H4();
                                    return;
                                case 5:
                                    H4();
                                    return;
                                case 7:
                                    n3(true);
                                    return;
                                default:
                                    switch (c17) {
                                        case 26:
                                            break;
                                        case 27:
                                            n3(false);
                                            return;
                                        case 28:
                                            z4();
                                            return;
                                        case 29:
                                            break;
                                        default:
                                            return;
                                    }
                            }
                        }
                        E3(objArr);
                        return;
                    }
                    L4();
                    return;
                }
                F3(objArr);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("isNeedFinishItself", true);
            this.Q.setResult(-1, intent);
            this.Q.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J2() {
        this.f43000u0 = new ArrayList();
        this.f43003v0 = new ArrayList();
        this.A0 = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J4() {
        P4();
        if (B1() != null) {
            B1().notifyDataSetChanged();
        }
    }

    @Override // i4.b, i4.a
    public void K(com.qzone.adapter.feedcomponent.s sVar, int i3) {
        super.K(sVar, i3);
        if (i3 == 999908) {
            if (sVar == null || !sVar.getSucceed()) {
                if (sVar != null) {
                    ToastUtil.s(sVar.getMessage(), 4);
                    return;
                }
                return;
            } else {
                if (((Integer) sVar.getData()).intValue() == 7) {
                    ToastUtil.s(q2().getResources().getString(R.string.f170824al0), 5);
                }
                Z0(false);
                return;
            }
        }
        if (i3 != 999969) {
            if (i3 != 87) {
                this.W1.y();
            }
        } else {
            BusinessAlbumInfo businessAlbumInfo = (sVar != null && sVar.getSucceed() && (sVar.getData() instanceof BusinessAlbumInfo)) ? (BusinessAlbumInfo) sVar.getData() : null;
            if (businessAlbumInfo != null) {
                this.R1 = businessAlbumInfo;
                C1(this.f42970k0).n(this.R1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AlbumHeaderPanel K1() {
        if (this.H1 == null) {
            this.H1 = new AlbumHeaderPanel(this.Q, this, this.W1);
        }
        return this.H1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K2() {
        k4((QzoneGestureSelectListView) this.Q.findViewById(R.id.flq));
        this.W1.getListView().setOnRefreshListener(new k());
        this.W1.getListView().setOnScrollListener(new t());
        this.W1.getListView().setOnFirstDrawListner(new v());
        this.f42941a1 = new com.qzone.album.ui.widget.c(this, new w());
        this.W1.getListView().setOnIndexChangedListener(this.f43005v2);
    }

    public void K3() {
        n5.a aVar = this.S1;
        if (aVar != null) {
            BusinessAlbumInfo businessAlbumInfo = this.R1;
            if (businessAlbumInfo == null) {
                aVar.b("", o5.a.a(), e0());
            } else {
                aVar.b(businessAlbumInfo.mAlbumId, businessAlbumInfo.mTitle, e0());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable L1(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return ResDownloadManger.getmInstance().getDrawableAsync(4, str, new ResDownloadManger.ResLoadListener() { // from class: com.qzone.album.business.photolist.controller.BasePhotoModelController.8
            @Override // cooperation.qzone.util.ResDownloadManger.ResLoadListener
            public void onDownloaded(int i3, String str2, final Bitmap bitmap) {
                com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "getLoadingDrawable onDownLoaded");
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qzone.album.business.photolist.controller.BasePhotoModelController.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BasePhotoModelController.this.C1.setForeground(new BitmapDrawable(bitmap));
                    }
                });
            }

            @Override // cooperation.qzone.util.ResDownloadManger.ResLoadListener
            public void onFailed(int i3, String str2) {
                com.qzone.album.env.common.a.m().i("[PhotoAlbum] BasePhotoModelController", "getLoadingDrawable onFailed");
            }
        }, options);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L2() {
        this.f42945b2 = new com.qzone.album.business.photolist.controller.d(this, this.Q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L3() {
        h4(this.f42991r0);
        ((com.qzone.album.business.photolist.adapter.a) B1()).G(this.f42991r0);
        ((com.qzone.album.business.photolist.adapter.a) B1()).C(false);
        this.f42988q0 = "";
        Map<Integer, String> map = this.f42971k1;
        if (map != null) {
            map.clear();
        }
        this.f42962h1 = false;
        this.f42959g1 = false;
        this.f42994s0 = true;
    }

    public void L4() {
        if (K1().j() != null) {
            K1().j().a1(this.f43008x0);
        }
    }

    @Override // i4.a
    public boolean M(Activity activity) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M1(int i3) {
        this.B1 = u4.a.z().F(this.T + "_" + this.f42943b0, i3, com.qzone.album.env.common.a.m().s());
    }

    protected void M2() {
        this.f43012z0.X(com.qzone.album.env.common.a.m().s());
        this.f43012z0.Y(com.qzone.album.env.common.a.m().s(), this.f42940a0);
    }

    @Override // i4.a
    public void N(Activity activity) {
        SimpleEventBus.getInstance().registerReceiver(this);
        C3(activity.getIntent());
        J2();
        M2();
        u4.a.z().g(this.Q, Q2(), k3());
        q1();
        o1();
        u4.a.z().O(this.f42940a0);
    }

    public View.OnClickListener N1() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N2() {
        i4();
        this.W1.x().setText("");
    }

    @Override // i4.a
    public void O(Activity activity) {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.D1 = null;
        this.E1 = null;
        this.F1 = null;
        this.G1 = null;
        com.qzone.album.env.common.a.m().a();
        this.f42960g2.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int O1() {
        int i3 = this.f42970k0;
        if (i3 == 2) {
            return A2;
        }
        if (i3 != 3 && i3 != 7) {
            return f42939z2;
        }
        return B2;
    }

    public boolean O2(boolean z16) {
        View d06 = d0();
        if (d06 == null) {
            return true;
        }
        d06.setBackgroundDrawable(null);
        return true;
    }

    @Override // i4.a
    public void P(Activity activity) {
        this.M0.a();
    }

    @Override // com.qzone.album.env.common.c
    public boolean P2() {
        Long l3 = this.S;
        return l3 == null || l3.longValue() != com.qzone.album.env.common.a.m().s();
    }

    public void P3(boolean z16) {
        ArrayList arrayList;
        Intent G = G();
        if (this.G0.size() >= 0) {
            arrayList = new ArrayList();
            arrayList.addAll(this.G0);
        } else {
            arrayList = null;
        }
        ParcelableWrapper.putArrayListToIntent(G, QZoneContant.OUTPUT_IMAGES, arrayList);
        G.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.F0);
        G.putExtra(PeakConstants.PHOTO_PATHS_FROM_QZONEALBUM, com.qzone.album.util.a.d(this.G0));
        G.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, this.C0);
        G.putExtra("key_selected_has_change", this.I0);
        G.putExtra(PeakConstants.IS_JUMPTO_TROOP_ALBUM, this.f42975l2);
        if (!z16 && (!this.f42950d1 || !this.f42956f1)) {
            this.Q.setResult(0, G);
        } else {
            this.Q.setResult(-1, G);
        }
        if (this.Y1) {
            r2();
        }
        x1();
    }

    protected void P4() {
        int size;
        int i3 = this.f42970k0;
        int i16 = R.string.gmr;
        if (i3 == 1 || i3 == 6) {
            List<PhotoCacheData> list = this.H0;
            size = list != null ? list.size() : -1;
            if (size > 0) {
                Resources resources = getResources();
                if (!k3()) {
                    i16 = R.string.gmp;
                }
                this.W1.setTitle(String.format(resources.getString(i16), Integer.valueOf(size)));
            } else {
                i4();
            }
            C1(this.f42970k0).r(this.F0.size());
            return;
        }
        if (i3 == 2 || i3 == 7 || i3 == 3 || i3 == 5) {
            List<PhotoCacheData> list2 = this.H0;
            size = list2 != null ? list2.size() : -1;
            if (size > 0) {
                Resources resources2 = getResources();
                if (!k3()) {
                    i16 = R.string.gmp;
                }
                this.W1.setTitle(String.format(resources2.getString(i16), Integer.valueOf(size)));
            } else {
                i4();
            }
            C1(this.f42970k0).r(this.F0.size());
        }
    }

    @Override // i4.a
    public void Q(Activity activity, Bundle bundle) {
        this.f42997t0 = bundle;
        if (bundle != null) {
            this.S = Long.valueOf(bundle.getLong("key_album_owner_uin", 0L));
            this.T = this.f42997t0.getString(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_ID);
            this.U = this.f42997t0.getString(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_NAME);
            this.f42955f0 = this.f42997t0.getInt("key_personal_album_enter_model", 0);
            this.W = this.f42997t0.getLong("key_last_upload_time");
            this.X = this.f42997t0.getInt("key_priv");
        }
    }

    public c.b Q1() {
        if (this.f42978m2 == null) {
            this.f42978m2 = new f();
        }
        return this.f42978m2;
    }

    public boolean Q2() {
        return this.f42989q1 != 0;
    }

    public void Q4() {
        if (this.P1 != null) {
            if (k3() && u4.a.z().A("key_show_old_video_hint", true) && this.f42970k0 == 0) {
                this.P1.setVisibility(0);
            } else {
                this.P1.setVisibility(8);
            }
        }
    }

    @Override // i4.a
    public void R(Activity activity, int i3, int i16, Intent intent) {
        BusinessAlbumInfo businessAlbumInfo;
        super.R(activity, i3, i16, intent);
        if (i3 == 3 || i3 == 4 || i3 == 1) {
            u4.a.z().g(this.Q, Q2(), k3());
        }
        if (i16 == 0) {
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    o0();
                    return;
                }
                if (i3 != 5) {
                    if (i3 == 6) {
                        v3(intent, i16);
                        return;
                    }
                    if (i3 == 7) {
                        u3(intent, i16);
                        return;
                    }
                    if (i3 == 8) {
                        h1();
                        LpReportInfo_pf00064.allReport(86, 8, 3);
                        return;
                    }
                    if (i3 == 12) {
                        if (i16 != -1 || intent == null) {
                            return;
                        }
                        K4(com.qzone.album.env.common.a.m().r(intent));
                        if (!this.f43008x0.isSharingAlbumOnServer()) {
                            AlbumCacheData albumCacheData = this.f43008x0;
                            if (albumCacheData.createSharingUin <= 0) {
                                albumCacheData.createSharingUin = com.qzone.album.env.common.a.m().s();
                            }
                        }
                        if (this.f43008x0.albumtype == 12) {
                            com.qzone.album.env.common.a.m().P(326, 14, "11", true, null);
                        }
                        O3();
                        return;
                    }
                    if (i3 == 15) {
                        w3(intent, i16);
                        return;
                    }
                    if (i3 == 20) {
                        if (i16 == -1 && intent != null && "deleteAlbum".equals(intent.getStringExtra(QZoneContant.KEY_EDIT_TYPE))) {
                            x1();
                            return;
                        }
                        return;
                    }
                    if (i3 == 1204) {
                        n3(false);
                        return;
                    }
                    if (i3 == 22) {
                        if (i16 != -1 || (businessAlbumInfo = (BusinessAlbumInfo) intent.getParcelableExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO)) == null) {
                            return;
                        }
                        this.R1 = businessAlbumInfo;
                        C1(this.f42970k0).n(this.R1);
                        return;
                    }
                    if (i3 == 23) {
                        if (i16 == -1 && this.f43008x0.albumtype == 12) {
                            com.qzone.album.env.common.a.m().P(326, 14, "12", true, null);
                            return;
                        }
                        return;
                    }
                    if (i3 == 1207) {
                        if (i16 == -1) {
                            c4(intent.getStringArrayListExtra(PictureConst.KEY_SELECTED_PHOTO_LLOC));
                            if (intent.getBooleanExtra(PictureConst.KEY_CONFIRM_BTN_CLICK, false)) {
                                j1();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (i3 != 1208) {
                        com.qzone.album.env.common.a.m().e("[PhotoAlbum] BasePhotoModelController", "onShellActivityResult case " + i3);
                        return;
                    }
                    LpReportInfo_pf00064.allReport(86, 11, 3);
                    u1(intent);
                    return;
                }
                return;
            }
        } else if (i16 == -1) {
            if (intent != null && "deleteAlbum".equals(intent.getStringExtra(QZoneContant.KEY_EDIT_TYPE))) {
                x1();
                return;
            }
            if (intent != null) {
                this.f42940a0 = intent.getIntExtra("albumType", 1);
                if (i3()) {
                    p3();
                }
            }
            com.qzone.album.business.photolist.ui.interactingbar.a aVar = this.J1;
            if (aVar != null) {
                aVar.d(false);
            }
            l4(true);
            L3();
            QzoneGestureSelectListView listView = this.W1.getListView();
            if (listView != null) {
                listView.postDelayed(new Runnable() { // from class: com.qzone.album.business.photolist.controller.BasePhotoModelController.25
                    @Override // java.lang.Runnable
                    public void run() {
                        BasePhotoModelController.this.o0();
                    }
                }, 500L);
                return;
            } else {
                o0();
                return;
            }
        }
        if (i16 == -1) {
            n1(intent);
            LpReportInfo_pf00064.allReport(86, 7, 3);
        }
    }

    public View.OnClickListener R1() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean R2(PhotoCacheData photoCacheData) {
        if (photoCacheData != null && photoCacheData.videoflag == 1 && P2()) {
            com.qzone.album.env.common.a.m().V(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCannotQuoteVideo", "\u6682\u4e0d\u652f\u6301\u89c6\u9891\u8f6c\u8f7d"));
            return true;
        }
        if (!j3(photoCacheData)) {
            return false;
        }
        com.qzone.album.env.common.a.m().V(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCannotSelectVideo", "\u89c6\u9891\u6b63\u5728\u8f6c\u7801,\u8bf7\u5237\u65b0\u540e\u91cd\u8bd5"));
        return true;
    }

    public View.OnClickListener S1() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean S2() {
        return this.f42970k0 == 1;
    }

    protected int S3() {
        ArrayList<String> arrayList = this.F0;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        return this.F0.size();
    }

    @Override // i4.a
    public void T(Activity activity, Bundle bundle) {
        bundle.putLong("key_album_owner_uin", this.S.longValue());
        bundle.putLong("key_last_upload_time", this.W);
        bundle.putInt("key_priv", this.X);
        bundle.putString(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_ID, this.T);
        bundle.putString(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_NAME, this.U);
        bundle.putInt("key_personal_album_enter_model", this.f42955f0);
    }

    public View.OnClickListener T1() {
        return null;
    }

    public boolean T2() {
        return (G() == null || !G().getBooleanExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_IS_PUBLIC, false) || TextUtils.isEmpty(G().getStringExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_INVITE_KEY))) ? false : true;
    }

    @Override // com.qzone.album.env.common.c
    public boolean Ta() {
        return e1();
    }

    public View.OnClickListener U1() {
        return null;
    }

    public boolean U2() {
        return this.O0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U3(int i3) {
        int i16 = this.f42940a0;
        if (i3 != i16) {
            boolean z16 = (c3(i16) && c3(i3)) ? false : true;
            this.f42940a0 = i3;
            if (z16) {
                A4();
            }
        }
    }

    public View.OnClickListener V1() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean V2(int i3) {
        if (i3 != 3 && i3 != 2) {
            return false;
        }
        return true;
    }

    public void V3(BaseAdapter baseAdapter) {
        this.f407177i = baseAdapter;
    }

    public ViewerModelController.ao W1() {
        return null;
    }

    public boolean W2() {
        return b3() && this.f42943b0 && com.qzone.album.util.b.f(this.f43008x0);
    }

    public void W3(List<PhotoCacheData> list) {
        HdAsync.with(this).then(new s(com.qzone.album.env.common.a.m().u().getLooper(), list)).then(new r(Looper.getMainLooper())).call();
    }

    public View.OnClickListener X1() {
        return null;
    }

    public boolean Y2() {
        return this.f42940a0 == 11;
    }

    public boolean Z2() {
        return this.f42970k0 == 1;
    }

    public void Z3() {
        TextView x16 = this.W1.x();
        if (x16 == null) {
            return;
        }
        if (this.f42970k0 != 0) {
            x16.setText(R.string.cancel);
            x16.setBackgroundResource(R.color.a6y);
        } else {
            x16.setText("");
            x16.setBackgroundResource(R.drawable.b5b);
        }
        x16.setVisibility(0);
    }

    @Override // x4.a
    public View.OnClickListener a(int i3, int i16) {
        return null;
    }

    @Override // i4.b
    public void a0() {
        HashMap<Integer, String> hashMap;
        com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", "[PhotoAlbum] BasePhotoModelController", " doGetMore start");
        if (this.f42950d1 && (hashMap = this.f42965i1) != null) {
            hashMap.put(2, "1");
            this.f42971k1 = this.f42965i1;
        }
        if (k3()) {
            if (this.f43010y0 == null || !com.qzone.album.base.b.a(J1(this.S.longValue()))) {
                return;
            }
            this.f43010y0.o0(this.S.longValue(), 0, this.f43002u2);
            return;
        }
        if (this.f43010y0 != null) {
            l1();
        }
    }

    public boolean a3() {
        return this.f42940a0 == 12;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a4() {
        u4.a.z().g0(this.T + "_" + this.f42943b0, this.B1, com.qzone.album.env.common.a.m().s());
    }

    @Override // x4.a
    public int b() {
        return com.qzone.album.base.b.a(I1(this.S.longValue(), this.T, this.f42955f0)) ? 1 : 0;
    }

    public boolean b3() {
        return c3(this.f42940a0);
    }

    @Override // x4.a
    public boolean c() {
        return false;
    }

    @Override // i4.b
    public void c0() {
        HashMap<Integer, String> hashMap;
        com.qzone.album.base.Service.a aVar = this.f43010y0;
        if (aVar != null) {
            if (this.f42944b1 == 0) {
                this.f42962h1 = false;
                if (this.f42950d1 && (hashMap = this.f42965i1) != null) {
                    hashMap.put(2, "1");
                    this.f42971k1 = this.f42965i1;
                }
                if (k3()) {
                    this.f43010y0.H1(this.S.longValue(), 2, this.f42999t2);
                    return;
                } else {
                    r1();
                    return;
                }
            }
            aVar.k1(this.S.longValue(), null, this.f42990q2);
        }
    }

    protected void c1(AlbumCacheData albumCacheData) {
        if (B1() == null) {
            return;
        }
        this.W1.notifyAdapter(B1());
        if (B1().getCount() <= 0 && this.f42970k0 != 0) {
            Z0(false);
            if (!P2() && h()) {
                if (P2() && k3()) {
                    this.f42941a1.n(false);
                    return;
                } else if (!k3()) {
                    this.f42941a1.l(1);
                    return;
                } else {
                    this.f42941a1.l(3);
                    this.W1.u().setVisibility(4);
                    return;
                }
            }
            if (albumCacheData != null && ((albumCacheData.isSharingAlbumPartner() && albumCacheData.isInShareList()) || albumCacheData.isSharingAlbumCreator())) {
                if (albumCacheData.isShareInvitePanding()) {
                    this.f42941a1.l(8);
                } else {
                    this.f42941a1.l(1);
                }
                this.f42941a1.n(true);
                return;
            }
            this.f42941a1.n(false);
        }
    }

    public int c2() {
        if (b3()) {
            return com.qzone.album.util.b.f(this.f43008x0) ? 2 : 1;
        }
        if (a3()) {
            return 3;
        }
        if (i3()) {
            return 5;
        }
        if (Y2()) {
            return 6;
        }
        return e3() ? 4 : 1;
    }

    public boolean c3(int i3) {
        if (i3 == 1 || i3 == 0) {
            return true;
        }
        return false;
    }

    protected void c4(ArrayList<String> arrayList) {
        String str;
        g1();
        if (arrayList != null && this.f43003v0 != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                int i3 = 0;
                while (true) {
                    if (i3 >= this.f43003v0.size()) {
                        break;
                    }
                    PhotoCacheData photoCacheData = this.f43003v0.get(i3);
                    if (photoCacheData == null || (str = photoCacheData.lloc) == null || !str.equals(next)) {
                        i3++;
                    } else if (!R2(photoCacheData)) {
                        b4(photoCacheData, 0, true);
                    }
                }
            }
        }
        J4();
    }

    @Override // x4.a
    public void d(String str) {
        this.f43009x1 = str;
    }

    protected boolean d1(int i3) {
        return false;
    }

    public View.OnClickListener d2() {
        return null;
    }

    protected boolean d3() {
        return b3() && QZoneAlbumUtil.B(this.f42991r0);
    }

    @Override // i4.b
    public Handler e0() {
        return this.W1.getHandler();
    }

    public boolean e1() {
        return this.W1.checkNetworkConnect();
    }

    public boolean e3() {
        return this.f42940a0 == 8;
    }

    @Override // x4.a
    public boolean f() {
        return this.B1 == 1;
    }

    public void f1(com.qzone.adapter.feedcomponent.s sVar) {
        int returnCode = sVar.getReturnCode();
        if (returnCode != 0) {
            int i3 = !com.qzone.album.util.d.d(returnCode) ? 1 : -1;
            if (i3 != -1) {
                com.qzone.feed.utils.b.d(this.Q, u4.a.z().J(this.Q, this.T, this.U, this.S, this.f42982o0, this.f42971k1, i3, sVar.getMessage(), this.f42940a0, false));
                x1();
            }
        }
    }

    public BusinessAlbumInfo f2() {
        if (this.R1 == null) {
            this.R1 = o5.a.b();
        }
        return this.R1;
    }

    protected boolean f3() {
        Intent intent;
        Activity activity = this.Q;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return false;
        }
        return QZoneVideoCommonUtils.REFER_SHORT_VIDEO_FOR_VIDEO_COVER.equals(intent.getStringExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_REFER));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f4(int i3, View.OnClickListener onClickListener, boolean z16) {
        this.W1.P(i3, onClickListener, z16);
    }

    @Override // x4.a
    public AlbumCacheData g() {
        return this.f43008x0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g1() {
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "clearPhotoCacheAndIndex...");
        List<PhotoCacheData> list = this.H0;
        if (list != null) {
            for (PhotoCacheData photoCacheData : list) {
                if (photoCacheData != null && (photoCacheData instanceof PhotoCacheData)) {
                    PhotoCacheData photoCacheData2 = photoCacheData;
                    if (photoCacheData2.isChecked) {
                        photoCacheData2.isChecked = false;
                    }
                }
            }
            this.H0.clear();
        }
        ArrayList<Integer> arrayList = this.E0;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<String> arrayList2 = this.F0;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
    }

    protected int g2() {
        return this.f42970k0 != 1 ? R.string.gjf : R.string.cancel;
    }

    @Override // com.qzone.album.env.common.c
    public Activity getCurrentActivity() {
        return this.Q;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneAlbumCategoryDeletePhotoEvent.class);
        arrayList.add(QZoneAlbumLayerSelectPhotoEvent.class);
        return arrayList;
    }

    @Override // x4.a
    public LayoutInflater getLayoutInflater() {
        return this.Q.getLayoutInflater();
    }

    @Override // x4.a
    public QZonePullToRefreshListView getListView() {
        return this.W1.getListView();
    }

    @Override // i4.a, x4.a
    public Resources getResources() {
        return this.P.getResources();
    }

    @Override // com.qzone.album.env.common.c
    public View getRootView() {
        return null;
    }

    @Override // x4.a
    public boolean h() {
        return this.f42955f0 == 0;
    }

    public void h1() {
        if (this.f42970k0 != 0) {
            List<PhotoCacheData> list = this.f43003v0;
            if (list != null) {
                for (PhotoCacheData photoCacheData : list) {
                    if (photoCacheData != null) {
                        photoCacheData.isChecked = false;
                    }
                }
            }
            g1();
            if (B1() != null) {
                B1().notifyDataSetChanged();
            }
        }
        I4();
    }

    protected ArrayList<String> h2() {
        return com.qzone.album.util.a.c(this.H0);
    }

    public boolean h3() {
        return e3() || i3() || Y2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h4(int i3) {
        if (!b3()) {
            if (a3()) {
                this.f42991r0 = 3;
                return;
            } else {
                this.f42991r0 = 0;
                return;
            }
        }
        this.f42991r0 = i3;
    }

    @Override // x4.a
    public View.OnClickListener i() {
        return null;
    }

    public void i1() {
        try {
            Dialog dialog = this.V0;
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public View.OnClickListener i2(int i3) {
        return null;
    }

    public boolean i3() {
        return this.f42940a0 == 9;
    }

    public void i4() {
        if (Q2()) {
            this.W1.setTitle(this.f42992r1 + com.qzone.util.l.a(R.string.jzk));
            return;
        }
        if (this.O0) {
            this.W1.E1(this.Q0, com.qzone.util.l.a(R.string.jzg) + this.R0 + com.qzone.util.l.a(R.string.jzi));
            return;
        }
        String str = this.U;
        int i3 = this.f42970k0;
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                str = getResources().getString(R.string.gba);
            } else if (i3 == 4) {
                str = getResources().getString(R.string.gbb);
            } else if (i3 == 5) {
                str = getResources().getString(R.string.gaj);
            } else if (i3 == 7) {
                str = getResources().getString(R.string.gb_);
            }
        } else if (k3()) {
            str = getResources().getString(R.string.gms);
        } else if (this.T1) {
            str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumQuoteBatch", "\u6279\u91cf\u8f6c\u8f7d");
        } else {
            str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumManageBatch", "\u6279\u91cf\u7ba1\u7406");
        }
        this.W1.setTitle(str);
        if (this.f42970k0 != 0 || this.f42957f2) {
            return;
        }
        this.W1.e1(8);
    }

    @Override // x4.a
    public View.OnClickListener j(PhotoPoiArea photoPoiArea) {
        return new aa(photoPoiArea);
    }

    public View.OnClickListener j2() {
        return null;
    }

    @Override // x4.a
    public Context k() {
        return this.Q;
    }

    @Override // i4.b
    protected boolean k0() {
        return true;
    }

    public View.OnClickListener k2() {
        return null;
    }

    public boolean k3() {
        return this.f42940a0 == 10;
    }

    public void k4(QzoneGestureSelectListView qzoneGestureSelectListView) {
        this.f407178m = qzoneGestureSelectListView;
    }

    @Override // x4.a
    public int l() {
        return this.f43011y1;
    }

    public int l2() {
        return this.f42991r0;
    }

    public void l4(boolean z16) {
        if (this.C1 == null) {
            this.C1 = (FrameLayout) this.Q.findViewById(R.id.hnc);
        }
        FrameLayout frameLayout = this.C1;
        if (frameLayout == null) {
            return;
        }
        if (!z16) {
            frameLayout.setForeground(null);
            com.qzone.album.env.common.a.m().b("[PhotoAlbum]AlbumPerformance", "showCrossOverView end");
            return;
        }
        if (e1()) {
            if (!k3()) {
                if (e3()) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    Drawable drawableAsync = ResDownloadManger.getmInstance().getDrawableAsync(4, "loading_baby", new ResDownloadManger.ResLoadListener() { // from class: com.qzone.album.business.photolist.controller.BasePhotoModelController.7
                        @Override // cooperation.qzone.util.ResDownloadManger.ResLoadListener
                        public void onDownloaded(int i3, String str, final Bitmap bitmap) {
                            com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "getBitmapDrawable onDownLoaded");
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qzone.album.business.photolist.controller.BasePhotoModelController.7.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    BasePhotoModelController.this.C1.setForeground(new BitmapDrawable(bitmap));
                                }
                            });
                        }

                        @Override // cooperation.qzone.util.ResDownloadManger.ResLoadListener
                        public void onFailed(int i3, String str) {
                            if (BasePhotoModelController.this.E1 == null) {
                                com.qzone.album.env.common.a.m().i("[PhotoAlbum] BasePhotoModelController", "mNormalGuestLoadingBg == null");
                                BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
                                basePhotoModelController.E1 = basePhotoModelController.L1("qzone_photolist_loading_guest_bg");
                                if (BasePhotoModelController.this.E1 != null) {
                                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qzone.album.business.photolist.controller.BasePhotoModelController.7.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            BasePhotoModelController basePhotoModelController2 = BasePhotoModelController.this;
                                            basePhotoModelController2.C1.setForeground(basePhotoModelController2.E1);
                                        }
                                    });
                                }
                            }
                        }
                    }, options);
                    if (drawableAsync != null) {
                        this.C1.setForeground(drawableAsync);
                        return;
                    }
                    return;
                }
                if (this.E1 == null) {
                    com.qzone.album.env.common.a.m().c("[PhotoAlbum] BasePhotoModelController", "mNormalGuestLoadingBg == null");
                    this.E1 = L1("qzone_photolist_loading_guest_bg");
                }
                this.C1.setForeground(this.E1);
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.C1.getLayoutParams();
            marginLayoutParams.topMargin = (int) getResources().getDimension(R.dimen.azw);
            this.C1.setLayoutParams(marginLayoutParams);
            if (this.G1 == null) {
                com.qzone.album.env.common.a.m().c("[PhotoAlbum] BasePhotoModelController", "mVideoGuestLoadingBg == null");
                this.G1 = L1("qzone_photolist_video_loading_guest_pic");
            }
            this.C1.setForeground(this.G1);
        }
    }

    @Override // x4.a
    public boolean m() {
        return this.f42949d0;
    }

    public LinearLayout m2() {
        return this.F;
    }

    public void m4(boolean z16) {
        long j3;
        if ((this.Z0 || z16) && !this.H0.isEmpty()) {
            this.Z0 = false;
            long j16 = 0;
            if (!k3()) {
                if (this.H0.get(r5.size() - 1).shoottime != 0) {
                    j3 = this.H0.get(r5.size() - 1).shoottime;
                } else {
                    j3 = this.H0.get(r5.size() - 1).uploadtime;
                }
                j16 = 1000 * j3;
            }
            Calendar.getInstance(Locale.CHINA).setTimeInMillis(j16);
            if (this.Y0 == null) {
                jp.c c16 = jp.a.c(this.Q);
                this.Y0 = c16;
                c16.p(new y());
                this.Y0.q(new a());
            }
            jp.a.h(this.Y0);
            this.Y0.s();
        }
    }

    @Override // x4.a
    public View.OnClickListener n(s4.d dVar) {
        return new ag(dVar);
    }

    public Dialog n2() {
        return this.V0;
    }

    @Override // x4.a
    public ArrayList<Integer> o() {
        return this.E0;
    }

    public List<View> o2(boolean z16) {
        BigPhotoView bigPhotoView;
        ArrayList arrayList = new ArrayList();
        if (this.W1.getListView() == null) {
            return arrayList;
        }
        if (this.A0.size() > 0) {
            this.A0.clear();
        }
        int firstVisiblePosition = getListView().getFirstVisiblePosition();
        int lastVisiblePosition = getListView().getLastVisiblePosition();
        QZonePullToRefreshListView listView = getListView();
        int i3 = lastVisiblePosition - firstVisiblePosition;
        for (int i16 = 0; i16 <= i3; i16++) {
            View childAt = listView.getChildAt(i16);
            if (childAt != null && childAt.getTag() != null) {
                if (childAt.getTag() instanceof u.b) {
                    u.b bVar = (u.b) childAt.getTag();
                    int i17 = 0;
                    while (true) {
                        PhotoView[] photoViewArr = bVar.f42763b;
                        if (i17 < photoViewArr.length) {
                            PhotoView photoView = photoViewArr[i17];
                            if (photoView != null && photoView.getVisibility() == 0) {
                                PhotoCacheData Z1 = Z1(this.f43000u0, ((Integer) photoView.getTag()).intValue(), z16);
                                if (Z1 != null && !Z1.isFakePhoto()) {
                                    this.A0.add(Z1);
                                    arrayList.add(photoView);
                                }
                            }
                            i17++;
                        }
                    }
                } else if ((childAt.getTag() instanceof h.d) && (bigPhotoView = ((h.d) childAt.getTag()).f42695a) != null && bigPhotoView.getVisibility() == 0 && (bigPhotoView.getTag() instanceof Integer)) {
                    PhotoCacheData Z12 = Z1(this.f43000u0, ((Integer) bigPhotoView.getTag()).intValue(), z16);
                    if (Z12 != null && !Z12.isFakePhoto()) {
                        this.A0.add(Z12);
                        arrayList.add(bigPhotoView);
                    }
                }
            }
        }
        return arrayList;
    }

    public void o4(String str, boolean z16) {
        this.W1.getListView().s0(I(R.string.gm6));
        com.qzone.album.base.b.b(str, z16);
        if (z16) {
            y0(5);
        } else if (B1().getCount() >= 2) {
            y0(7);
        } else {
            y0(6);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneAlbumCategoryDeletePhotoEvent) {
            A2((QZoneAlbumCategoryDeletePhotoEvent) simpleBaseEvent);
        }
        if (simpleBaseEvent instanceof QZoneAlbumLayerSelectPhotoEvent) {
            B2((QZoneAlbumLayerSelectPhotoEvent) simpleBaseEvent);
        }
    }

    @Override // x4.a
    public ArrayList<String> p() {
        return this.F0;
    }

    public int p2() {
        return this.G;
    }

    public void p3() {
        if (i3()) {
            com.qzone.album.env.common.a.m().c("[PhotoAlbum] BasePhotoModelController[PhotoAlbum] TraveMapFunction", "loadTravelMapForOld");
            K1().t();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p4() {
        int i3;
        int i16 = 0;
        com.qzone.album.env.common.a.m().c("[PhotoAlbum]AlbumNoShootTime", "showFooterNoShootTimeView | VISIBLE getfooterPreState():", Integer.valueOf(p2()));
        try {
            i3 = Integer.parseInt(this.f42971k1.get(0));
            try {
                i16 = Integer.parseInt(this.f42971k1.get(1));
            } catch (NumberFormatException e16) {
                e = e16;
                e.printStackTrace();
                if (i3 <= i16) {
                }
            }
        } catch (NumberFormatException e17) {
            e = e17;
            i3 = 0;
        }
        if (i3 <= i16) {
            this.f42962h1 = true;
            o4(I1(this.S.longValue(), this.T, this.f42955f0), true);
        }
    }

    @Override // x4.a
    public View.OnClickListener q(PhotoPoiArea photoPoiArea) {
        return new af(photoPoiArea, true);
    }

    public Activity q2() {
        return this.Q;
    }

    @Override // x4.a
    public View.OnClickListener r(PhotoCacheData photoCacheData) {
        return new ae(photoCacheData);
    }

    @Override // x4.a
    public View.OnClickListener s(int i3, int i16, String str, PhotoCacheData photoCacheData, s4.d dVar) {
        return new ac(i3, i16, str, photoCacheData, dVar);
    }

    public void s2(com.qzone.adapter.feedcomponent.s sVar) {
        this.W1.y();
        int i3 = 0;
        if (sVar == null) {
            com.qzone.album.env.common.a.m().c(QZLog.TO_DEVICE_TAG, "[PhotoAlbum] BasePhotoModelController", "\t result is null");
            return;
        }
        int returnCode = sVar.getReturnCode();
        if (returnCode != 0) {
            if (com.qzone.album.util.d.e(returnCode)) {
                if (TextUtils.isEmpty(this.f42982o0)) {
                    e4(1);
                    o0();
                    return;
                }
            } else {
                i3 = (TextUtils.isEmpty(this.f42982o0) || com.qzone.album.util.d.d(returnCode)) ? -1 : 1;
            }
            if (i3 != -1) {
                v1(i3, sVar.getMessage());
                x1();
                return;
            }
        }
        if (sVar.getSucceed()) {
            u2(sVar);
            BaseAdapter B1 = B1();
            if (B1 instanceof com.qzone.album.business.photolist.adapter.a) {
                this.f42968j1 = ((com.qzone.album.business.photolist.adapter.a) B1).g();
            }
            if (sVar.getObjectData() instanceof QZonePhotoListRequest.b) {
                this.f42988q0 = ((QZonePhotoListRequest.b) sVar.getObjectData()).f43965g;
            }
        } else {
            this.W1.getListView().r0(I(R.string.gm5), sVar.getMessage());
            y0(p2());
        }
        X();
        com.qzone.album.business.photolist.ui.d dVar = this.f42942a2;
        if (dVar != null) {
            dVar.n(null);
        }
    }

    public void s4(String str) {
        Dialog dialog = this.V0;
        if (dialog == null || !dialog.isShowing()) {
            if (this.V0 == null) {
                ReportDialog reportDialog = new ReportDialog(this.Q, R.style.f174269ui);
                this.V0 = reportDialog;
                reportDialog.setContentView(R.layout.bqd);
                this.W0 = (TextView) this.V0.findViewById(R.id.dialogText);
                this.V0.findViewById(R.id.kja).setVisibility(8);
                this.V0.findViewById(R.id.cib).setVisibility(0);
            }
            this.W0.setText(str);
            try {
                this.V0.show();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public void t2(com.qzone.adapter.feedcomponent.s sVar) {
        this.W1.y();
        if (sVar == null) {
            com.qzone.album.env.common.a.m().c("[PhotoAlbum] BasePhotoModelController", "[PhotoAlbum] BasePhotoModelController", "\t result is null");
            return;
        }
        f1(sVar);
        com.qzone.album.env.common.a.m().c("[PhotoAlbum] BasePhotoModelController", "[PhotoAlbum] BasePhotoModelController", "\t " + sVar.getSucceed());
        if (sVar.getSucceed()) {
            o4(J1(this.S.longValue()), sVar.getHasMore());
        } else {
            this.W1.getListView().r0(I(R.string.gm5), sVar.getMessage());
            y0(p2());
        }
        Q4();
    }

    protected void t4(List<? extends com.qzone.component.cache.database.a> list, int i3) {
        if (!e1()) {
            com.qzone.album.env.common.a.m().W(u4.a.z().B().getResources().getString(R.string.ghi), 1);
            return;
        }
        this.f42956f1 = true;
        ArrayList<String> arrayList = new ArrayList<>(list.size());
        Iterator<? extends com.qzone.component.cache.database.a> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((PhotoCacheData) it.next()).lloc);
        }
        this.f43010y0.H(this.T, arrayList, i3, this.f42965i1, new j(list));
    }

    @Override // x4.a
    public View.OnClickListener u(PhotoCacheData photoCacheData) {
        return new ah(photoCacheData);
    }

    @Override // i4.b
    public void u0() {
        final QzoneGestureSelectListView listView = this.W1.getListView();
        if (listView == null) {
            return;
        }
        listView.post(new Runnable() { // from class: com.qzone.album.business.photolist.controller.BasePhotoModelController.27
            @Override // java.lang.Runnable
            public void run() {
                listView.scrollToTop();
            }
        });
    }

    protected void u2(com.qzone.adapter.feedcomponent.s sVar) {
        F4(this.f43008x0.busi_param);
        o4(I1(this.S.longValue(), this.T, this.f42955f0), sVar.getHasMore());
        if (sVar.getHasMore() || this.f42962h1 || this.f42986p1 <= 0) {
            return;
        }
        com.qzone.album.env.common.a.m().c("[PhotoAlbum]AlbumNoShootTime", " mTotalNoShootTimePhotoCount:", Integer.valueOf(this.f42986p1));
        p4();
        this.f42962h1 = true;
        ((com.qzone.album.business.photolist.adapter.a) B1()).C(true);
        W3(this.f43003v0);
    }

    protected void u4() {
        if (!k3()) {
            v4(1);
        } else {
            w4();
        }
    }

    @Override // x4.a
    public View.OnClickListener v(PhotoPoiArea photoPoiArea) {
        return new af(photoPoiArea);
    }

    @Override // i4.b
    public void v0(int i3) {
        super.v0(i3);
    }

    protected void v1(int i3, String str) {
        com.qzone.feed.utils.b.d(this.Q, u4.a.z().J(this.Q, this.T, this.U, this.S, this.f42982o0, this.f42971k1, i3, str, this.f42940a0, this.f42952e0));
    }

    protected abstract void v2();

    @Override // x4.a
    public boolean w() {
        return this.f42955f0 == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w2() {
        I3();
        this.f43013z1 = -1;
        Map<Integer, String> map = this.f42971k1;
        if (map != null) {
            map.put(2, "1");
            com.qzone.album.env.common.a.m().c("[PhotoAlbum]AlbumNoShootTime", "getMoreList | mBuis_pram:", this.f42971k1.toString());
        }
        P1(this.f42971k1);
    }

    @Override // x4.a
    public View.OnClickListener x(PhotoCacheData[] photoCacheDataArr, s4.d dVar) {
        return new ai(photoCacheDataArr, dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x1() {
        this.W1.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void x2(List<? extends com.qzone.component.cache.database.a> list, boolean z16, AlbumCacheData albumCacheData) {
        List<PhotoCacheData[]> list2 = this.f43000u0;
        if (list2 != null) {
            list2.clear();
        }
        if (list != 0) {
            M3(albumCacheData);
            K1().C();
            this.f43003v0 = list;
            if (this.f43006w0 != null) {
                this.f43006w0 = new ArrayList(list);
            }
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "handleLoadDataResult|mPhotos size:", Integer.valueOf(this.f43003v0.size()));
            if (B1() instanceof com.qzone.album.business.photolist.adapter.z) {
                z2(list, z16, albumCacheData);
                return;
            } else {
                y2(list, z16, albumCacheData);
                return;
            }
        }
        Y0(null, z16, albumCacheData);
    }

    public void x4(int i3) {
        u4.a.z().r0(i3);
    }

    @Override // x4.a
    public boolean y() {
        return this.f42955f0 == 1;
    }

    @Override // x4.a
    public View.OnClickListener z(int i3, int i16, String str, PhotoCacheData photoCacheData, s4.d dVar) {
        return new ab(i3, i16, str, photoCacheData, dVar);
    }

    public View.OnClickListener z1() {
        return null;
    }

    public void z4() {
        if (this.W1.getListView() != null) {
            this.W1.getListView().setRefreshing(false);
        }
    }

    /* loaded from: classes39.dex */
    class t implements AbsListView.OnScrollListener {
        t() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            if (i3 <= 0) {
                BasePhotoModelController.this.W1.s1(i3, absListView, BasePhotoModelController.f42936w2);
            } else {
                BasePhotoModelController.this.W1.L0(i3);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 == 0) {
                if (BasePhotoModelController.this.W1.getListView().getLastVisiblePosition() >= BasePhotoModelController.this.W1.getListView().getCount() - 2) {
                    BasePhotoModelController.this.m0();
                }
                u4.a.z().n0();
            } else if (i3 == 2) {
                u4.a.z().q0(absListView);
            }
            BasePhotoModelController.this.y3(absListView, i3);
        }
    }

    public static String I1(long j3, String str, int i3) {
        if (i3 == 4) {
            return "KEY_PHOTOLIST_HASMORE_PRE" + str + "_" + j3 + "_FROM_ALBUM_SEARCH";
        }
        return "KEY_PHOTOLIST_HASMORE_PRE" + str + "_" + j3;
    }

    public void A3() {
        this.Z1 = true;
    }

    protected void E2(com.qzone.adapter.feedcomponent.s sVar) {
        u4.h hVar;
        l4(false);
        this.f42941a1.l(5);
        u4.h hVar2 = this.W1;
        if (hVar2 != null) {
            hVar2.getListView().r0(I(R.string.gm5), sVar.getMessage());
        }
        List<PhotoCacheData> list = this.f43003v0;
        if (list != null && list.size() == 0) {
            com.qzone.album.business.photolist.ui.interactingbar.a aVar = this.J1;
            if (aVar != null) {
                aVar.d(false);
            }
            u4.h hVar3 = this.W1;
            if (hVar3 != null) {
                hVar3.getListView().setCoverMode(true, -f42936w2);
            }
        } else {
            List<PhotoCacheData> list2 = this.f43003v0;
            if (list2 != null && list2.size() > 0 && (hVar = this.W1) != null) {
                hVar.g1();
                this.W1.J();
            }
        }
        y0(p2());
        u4.h hVar4 = this.W1;
        if (hVar4 != null && hVar4.z2() != null) {
            this.W1.z2().q();
        }
        this.U1 = false;
    }

    public void N3() {
        this.f42957f2 = false;
    }

    @Override // i4.a
    public void S(Activity activity) {
        this.B0 = true;
        this.Z1 = false;
        I2(this.P, this.Q.getWindow().peekDecorView());
        this.f42960g2.c();
    }

    public void Z0(boolean z16) {
        this.f42970k0 = 0;
        this.f42953e1 = false;
        this.L1 = null;
        K1().A(true);
        i4();
        if (this.W1.x() != null) {
            this.W1.x().setVisibility(0);
        }
        if (this.W1.u() != null) {
            this.W1.u().setText(g2());
        }
        C1(this.f42970k0).c(z16);
        List<PhotoCacheData> list = this.H0;
        if (list != null && list.size() > 0) {
            this.H0.clear();
        }
        Q4();
        BaseAdapter B1 = B1();
        if (B1 != null) {
            ((com.qzone.album.business.photolist.adapter.a) B1).y(false);
            ((com.qzone.album.business.photolist.adapter.a) B1()).G(this.f42991r0);
            W3(this.f43003v0);
        }
    }

    public void b1() {
        this.f42957f2 = true;
    }

    /* loaded from: classes39.dex */
    public class af implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private PhotoPoiArea f43044d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f43045e;

        public af(PhotoPoiArea photoPoiArea) {
            this.f43045e = false;
            this.f43044d = photoPoiArea;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!BasePhotoModelController.this.P2()) {
                BasePhotoModelController.this.L1 = this.f43044d;
                u4.a.z().c0(BasePhotoModelController.this.Q, this.f43044d);
                if (this.f43044d != null) {
                    com.qzone.album.env.common.a m3 = com.qzone.album.env.common.a.m();
                    if (TextUtils.isEmpty(this.f43044d.sceneryName)) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    m3.R("368", "4", str);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public af(PhotoPoiArea photoPoiArea, boolean z16) {
            this.f43044d = photoPoiArea;
            this.f43045e = z16;
        }
    }

    private void K4(ArrayList<s4.b> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            s4.b bVar = arrayList.get(i3);
            if (this.f43008x0.getSharingAlbumClientAttr(bVar.f433292a) != null) {
                this.f43008x0.getSharingAlbumClientAttr(bVar.f433292a).action = 4;
            } else {
                SharingAlbumClientAttr sharingAlbumClientAttr = new SharingAlbumClientAttr(bVar.f433292a, new SharingOwnerUinAttr(), bVar.f433293b, 4);
                if (this.f43008x0.sharingAlbumClientAttrArrayList == null) {
                    SharingAlbumClientAttr sharingAlbumClientAttr2 = new SharingAlbumClientAttr(this.f43008x0.createSharingUin, new SharingOwnerUinAttr(), LoginData.getInstance().getNickName(""), 4);
                    AlbumCacheData albumCacheData = this.f43008x0;
                    if (albumCacheData.sharingAlbumClientAttrArrayList == null) {
                        albumCacheData.sharingAlbumClientAttrArrayList = new ArrayList<>();
                    }
                    this.f43008x0.sharingAlbumClientAttrArrayList.add(sharingAlbumClientAttr2);
                }
                this.f43008x0.sharingAlbumClientAttrArrayList.add(sharingAlbumClientAttr);
            }
        }
    }

    public static boolean j3(PhotoCacheData photoCacheData) {
        VideoInfo videoInfo;
        int i3;
        return photoCacheData != null && photoCacheData.videoflag == 1 && (videoInfo = photoCacheData.videodata) != null && ((i3 = videoInfo.videoStatus) == 1 || i3 == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j4(ArrayList<PhotoCacheData> arrayList) {
        List<PhotoCacheData> list;
        Iterator<PhotoCacheData> it;
        Iterator<PhotoCacheData> it5;
        String str;
        String str2;
        int i3;
        long j3;
        HashMap hashMap = new HashMap();
        if (arrayList == null || arrayList.size() <= 0 || (list = this.f43003v0) == null || list.size() <= 0) {
            return;
        }
        Iterator<PhotoCacheData> it6 = arrayList.iterator();
        String str3 = null;
        long j16 = 0;
        long j17 = 0;
        long j18 = 0;
        int i16 = 0;
        while (true) {
            int i17 = 1;
            if (!it6.hasNext()) {
                break;
            }
            PhotoCacheData next = it6.next();
            if (next != null) {
                String str4 = next.unikey;
                if (str4 != null) {
                    for (PhotoCacheData photoCacheData : this.f43003v0) {
                        if (photoCacheData == null || (str = photoCacheData.unikey) == null || !str4.equals(str)) {
                            it5 = it6;
                            str3 = str3;
                            i16 = i16;
                            j17 = j17;
                        } else {
                            if (j17 == j16) {
                                j17 = photoCacheData.uploadtime;
                                it5 = it6;
                                str2 = str3;
                            } else {
                                if (j17 > j16) {
                                    Calendar calendar = Calendar.getInstance();
                                    calendar.clear();
                                    calendar.setTimeInMillis(j17 * 1000);
                                    int i18 = calendar.get(i17);
                                    int i19 = calendar.get(2);
                                    int i26 = calendar.get(5);
                                    i3 = i16;
                                    long j19 = photoCacheData.uploadtime;
                                    it5 = it6;
                                    Calendar calendar2 = Calendar.getInstance();
                                    calendar2.clear();
                                    j3 = j17;
                                    calendar2.setTimeInMillis(j19 * 1000);
                                    int i27 = calendar2.get(1);
                                    int i28 = calendar2.get(2);
                                    str2 = str3;
                                    int i29 = calendar2.get(5);
                                    if (i18 != i27 || i19 != i28 || i26 != i29) {
                                        j17 = j19;
                                        i16 = 0;
                                    }
                                } else {
                                    it5 = it6;
                                    str2 = str3;
                                    i3 = i16;
                                    j3 = j17;
                                }
                                i16 = i3;
                                j17 = j3;
                            }
                            if (i16 == 0) {
                                String str5 = photoCacheData.albumid;
                                j18 = photoCacheData.uploadtime;
                                str3 = str5;
                            } else {
                                str3 = str2;
                            }
                            long d46 = d4(photoCacheData, i16, j18);
                            j16 = 0;
                            if (d46 > 0) {
                                EditPhoto editPhoto = new EditPhoto();
                                editPhoto.modifytime = (int) d46;
                                hashMap.put(photoCacheData.lloc, editPhoto);
                            }
                            i16++;
                        }
                        it6 = it5;
                        i17 = 1;
                    }
                    it = it6;
                } else {
                    it = it6;
                }
                it6 = it;
            }
        }
        if (str3 == null || hashMap.size() <= 0) {
            return;
        }
        this.f42980n1 = true;
        List<PhotoCacheData> list2 = this.f42968j1;
        if (list2 != null && list2.size() == arrayList.size()) {
            this.f42977m1 = true;
        } else {
            this.f42983o1 = true;
        }
        this.f43010y0.P1(str3, null, new EditPhoto(), 1, null, hashMap, this.f42981n2);
    }

    protected void B2(QZoneAlbumLayerSelectPhotoEvent qZoneAlbumLayerSelectPhotoEvent) {
        if (qZoneAlbumLayerSelectPhotoEvent == null || this.f43003v0 == null) {
            return;
        }
        int photoIndex = qZoneAlbumLayerSelectPhotoEvent.getPhotoIndex();
        if (!ArrayUtils.isOutOfArrayIndex(photoIndex, this.f43003v0)) {
            PhotoCacheData photoCacheData = this.f43003v0.get(photoIndex);
            if (photoCacheData.lloc.equals(qZoneAlbumLayerSelectPhotoEvent.getLloc())) {
                if (R2(photoCacheData)) {
                    return;
                }
                b4(photoCacheData, photoIndex, qZoneAlbumLayerSelectPhotoEvent.getIsSelected());
                J4();
                return;
            }
        }
        for (int i3 = 0; i3 < this.f43003v0.size(); i3++) {
            PhotoCacheData photoCacheData2 = this.f43003v0.get(i3);
            if (photoCacheData2.lloc.equals(qZoneAlbumLayerSelectPhotoEvent.getLloc())) {
                if (R2(photoCacheData2)) {
                    return;
                }
                b4(photoCacheData2, photoIndex, qZoneAlbumLayerSelectPhotoEvent.getIsSelected());
                J4();
                return;
            }
        }
    }

    public void C2(com.qzone.adapter.feedcomponent.s sVar) {
        if (sVar == null || !sVar.getSucceed()) {
            if (sVar != null) {
                com.qzone.album.env.common.a.m().V(sVar.getMessage());
            }
        } else {
            M3(this.f43012z0.x(this.S.longValue(), this.T));
            com.qzone.feed.utils.b.d(this.Q, u4.a.z().J(this.Q, this.T, this.U, this.S, this.f42982o0, this.f42971k1, 0, sVar.getMessage(), this.f42940a0, false));
            x1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C3(Intent intent) {
        String string;
        if (intent != null) {
            this.R = intent;
            this.Y1 = intent.getBooleanExtra(QZoneHelper.Constants.KEY_FROM_ALBUM_SHORTCUT, false);
            this.f42949d0 = intent.getBooleanExtra(PeakConstants.IS_SHOW_QZONE_ALBUM, false);
            this.f42952e0 = intent.getBooleanExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_FROM_WX, false);
            this.f42967j0 = intent.getBooleanExtra(PeakConstants.IS_FROM_P2V, false);
            Bundle extras = intent.getExtras();
            if (extras != null) {
                boolean z16 = extras.getInt("mqqflag") == 1;
                this.T0 = z16;
                if (z16) {
                    this.U0 = extras.getString("cell_operation.qq_url");
                    D3();
                    string = "";
                } else {
                    this.T = extras.getString(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_ID);
                    this.S = Long.valueOf(extras.getLong("key_album_owner_uin", 0L));
                    this.W = extras.getLong("key_last_upload_time");
                    this.X = extras.getInt("key_priv");
                    string = extras.getString(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_NAME);
                    this.Z = extras.getInt(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_ANONYMITY);
                }
                if (string != null) {
                    this.U = string;
                } else {
                    this.U = "";
                }
                h4(extras.getInt(QZoneHelper.QZonePersonalAlbumContants.KEY_PHOTO_SORT_TYPE, 0));
                if (!this.T0) {
                    this.f42940a0 = extras.getInt(QZoneHelper.QZoneAlbumConstants.QZ_ALBUM_THEME, 1);
                }
                this.f42946c0 = G().getIntExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_FROM_SPACE, 0);
                this.V = extras.getString("UploadPhoto.key_album_cover");
                this.f42955f0 = extras.getInt("key_personal_album_enter_model", 0);
                this.f42958g0 = extras.getBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_SINGLE_MODEL_NO_NEED_BIG_IMG, false);
                this.f42964i0 = extras.getBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_MULTIPLE_MODEL_NEED_DOWNLOAD_IMG, false);
                this.f42961h0 = extras.getBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_SINGLE_MODEL_NO_NEED_BIG_IMG, true);
                this.O0 = extras.getBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_GET_SHARER_PHOTO_LIST, false);
                this.P0 = extras.getLong(QZoneHelper.QZonePersonalAlbumContants.KEY_GET_SHARER_PHOTO_LIST_UIN, 0L);
                this.Q0 = extras.getString(QZoneHelper.QZonePersonalAlbumContants.KEY_GET_SHARER_PHOTO_LIST_NICK, "");
                this.R0 = extras.getLong(QZoneHelper.QZonePersonalAlbumContants.KEY_GET_SHARER_PHOTO_LIST_COUNT, 0L);
                this.f42963h2 = extras.getLong(QZoneHelper.QZonePersonalAlbumContants.KEY_JUMP_PHOTOLIST_BEGIN_TIME, -1L);
                long j3 = extras.getLong(QZoneHelper.QZonePersonalAlbumContants.KEY_JUMP_PHOTOLIST_END_TIME, -1L);
                this.f42966i2 = j3;
                long j16 = this.f42963h2;
                if (j16 != -1 && j3 != -1 && j16 != 0 && j3 != 0) {
                    s4("");
                }
                this.f42989q1 = extras.getLong(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_FACE_UIN, 0L);
                this.f42992r1 = extras.getString(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_FACE_NICKNAME);
                this.f42998t1 = extras.getString(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_FACE_URL);
                this.f42943b0 = extras.getBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_IS_INDIVIDUAL_ALBUM, false);
                this.A1 = this.f42940a0;
                if (!Q2()) {
                    int t16 = com.qzone.album.env.common.a.m().t("QZoneSetting", QzoneConfig.SECONDARY_ALBUM_SHOW_MODE, 0);
                    this.B1 = t16;
                    M1(t16);
                }
                this.f42950d1 = extras.getBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_IS_SORTING_MODEL, false);
                this.f42965i1 = (HashMap) extras.getSerializable(QZoneHelper.QZonePersonalAlbumContants.KEY_SORTING_MODEL_BUSI_PARAM);
                this.f42960g2 = new mc.a("qzone_album_old_album_detail", extras.getLong(PerfTracer.PARAM_CLICK_TIME, 0L));
            }
        }
    }

    public void M3(AlbumCacheData albumCacheData) {
        if (albumCacheData != null) {
            this.f43008x0 = albumCacheData;
            com.qzone.album.env.common.a.m().c("[PhotoAlbum] BasePhotoModelController", "resetParams albume name:", this.f43008x0.albumname);
            AlbumCacheData albumCacheData2 = this.f43008x0;
            this.U = albumCacheData2.albumname;
            this.f42979n0 = albumCacheData2.albumrights;
            this.f42976m0 = albumCacheData2.albumnum;
            this.f42982o0 = albumCacheData2.albumquestion;
            this.f42985p0 = albumCacheData2.albumanswer;
            h4(albumCacheData2.sortType);
            this.f42971k1 = this.f43008x0.busi_param;
            com.qzone.album.env.common.a.m().c("[PhotoAlbum] BasePhotoModelController", "resetParams mBuis_pram:", this.f42971k1);
            AlbumCacheData albumCacheData3 = this.f43008x0;
            this.S0 = albumCacheData3.operatemask;
            this.V = albumCacheData3.getLloc();
            AlbumCacheData albumCacheData4 = this.f43008x0;
            this.Z = albumCacheData4.anonymity;
            U3(albumCacheData4.albumtype);
        }
    }

    public void P1(Map<Integer, String> map) {
        if (this.f43010y0 != null) {
            Z(2);
            this.W1.t();
            this.f43010y0.g0(this.S.longValue(), this.T, this.f42985p0, this.f42991r0, this.f42988q0, null, this.f42989q1, map, this.f42940a0, this.f42950d1, this.f42996s2);
        }
    }

    private void A2(QZoneAlbumCategoryDeletePhotoEvent qZoneAlbumCategoryDeletePhotoEvent) {
        QZoneDeletePhotoBean qZoneDeletePhotoBean;
        if (qZoneAlbumCategoryDeletePhotoEvent == null || (qZoneDeletePhotoBean = qZoneAlbumCategoryDeletePhotoEvent.deletePhotoBean) == null) {
            return;
        }
        ArrayList<String> arrayList = qZoneDeletePhotoBean.photoIdList;
        if (arrayList != null && !arrayList.isEmpty()) {
            com.qzone.album.base.Service.a.W().D(qZoneAlbumCategoryDeletePhotoEvent.deletePhotoBean.photoIdList.get(0), qZoneAlbumCategoryDeletePhotoEvent.deletePhotoBean.albumId);
            H4();
        } else {
            RFWLog.e("[PhotoAlbum] BasePhotoModelController", RFWLog.USR, "photo id list is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E3(Object... objArr) {
        List<? extends com.qzone.component.cache.database.a> list;
        Object obj;
        Object obj2;
        String str;
        if (objArr == null) {
            return;
        }
        boolean z16 = false;
        if (this.V1) {
            this.F0.clear();
            this.V1 = false;
        }
        Object obj3 = objArr[0];
        AlbumCacheData albumCacheData = null;
        if (obj3 == null || !(obj3 instanceof List)) {
            list = null;
        } else {
            list = (List) obj3;
            PhotoCacheData photoCacheData = list.isEmpty() ? null : (PhotoCacheData) list.get(0);
            if (photoCacheData != null && (str = photoCacheData.albumid) != null && !str.equals(this.T)) {
                return;
            }
            if (this.O0) {
                Iterator<? extends com.qzone.component.cache.database.a> it = list.iterator();
                while (it.hasNext()) {
                    if (((PhotoCacheData) it.next()).uploadUin != this.P0) {
                        it.remove();
                    }
                }
            }
        }
        Object obj4 = objArr[1];
        if (obj4 != null && (obj4 instanceof Boolean)) {
            z16 = ((Boolean) obj4).booleanValue();
        }
        if (objArr.length >= 3 && (obj2 = objArr[2]) != null && (obj2 instanceof AlbumCacheData)) {
            albumCacheData = (AlbumCacheData) obj2;
        }
        if (objArr.length >= 4 && (obj = objArr[3]) != null && (obj instanceof RecomAlbumList)) {
            this.f42954e2 = (RecomAlbumList) obj;
        }
        x2(list, z16, albumCacheData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F3(Object... objArr) {
        Object obj;
        Object obj2;
        if (objArr == null) {
            return;
        }
        if (!(B1() instanceof com.qzone.album.business.photolist.adapter.z) || objArr.length < 4 || (obj2 = objArr[3]) == null || !obj2.equals("DeleteQueneRefreshVideoExtraInfo")) {
            boolean z16 = false;
            Object obj3 = objArr[0];
            AlbumCacheData albumCacheData = null;
            List<? extends com.qzone.component.cache.database.a> list = (obj3 == null || !(obj3 instanceof List)) ? null : (List) obj3;
            Object obj4 = objArr[1];
            if (obj4 != null && (obj4 instanceof Boolean)) {
                z16 = ((Boolean) obj4).booleanValue();
            }
            if (objArr.length >= 3 && (obj = objArr[2]) != null && (obj instanceof AlbumCacheData)) {
                albumCacheData = (AlbumCacheData) obj;
            }
            x2(list, z16, albumCacheData);
        }
    }

    public PhotoCacheData Z1(List<PhotoCacheData[]> list, int i3, boolean z16) {
        PhotoCacheData[] photoCacheDataArr;
        if (!z16 && (B1() instanceof com.qzone.album.business.photolist.adapter.h)) {
            if (list == null || list.size() <= i3 || (photoCacheDataArr = list.get(i3)) == null || photoCacheDataArr.length == 0) {
                return null;
            }
            return list.get(i3)[0];
        }
        int i16 = f42937x2;
        int i17 = i3 / i16;
        int i18 = i3 % i16;
        if (list.size() <= i17) {
            return null;
        }
        PhotoCacheData[] photoCacheDataArr2 = list.get(i17);
        if (photoCacheDataArr2.length <= i18) {
            return null;
        }
        return photoCacheDataArr2[i18];
    }

    public void u3(Intent intent, int i3) {
        if (i3 != -1) {
            if (i3 == 0) {
                this.L1 = null;
                return;
            }
            return;
        }
        com.qzone.album.env.common.a.m().R("368", "31", e2());
        String stringExtra = intent.getStringExtra("contentIntentKey");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = " ";
        }
        PhotoPoiArea photoPoiArea = this.L1;
        if (photoPoiArea != null) {
            photoPoiArea.description = stringExtra;
            s4(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogModify", "\u6b63\u5728\u4fee\u6539..."));
            String str = this.T;
            if (str != null) {
                com.qzone.album.base.Service.a aVar = this.f43010y0;
                PhotoPoiArea photoPoiArea2 = this.L1;
                aVar.H0(str, photoPoiArea2, photoPoiArea2.startShootTime, null, null, true, this.f42981n2);
            }
        }
    }

    public void v3(Intent intent, int i3) {
        if (i3 != -1) {
            if (i3 == 0) {
                this.f42987p2 = null;
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra("contentIntentKey");
        String stringExtra2 = intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY);
        ArrayList<String> arrayList = new ArrayList<>();
        PhotoCacheData photoCacheData = this.f42987p2;
        if (photoCacheData != null) {
            arrayList.add(photoCacheData.lloc);
            this.f42987p2.desc = stringExtra;
        }
        EditPhoto editPhoto = new EditPhoto();
        editPhoto.desc = stringExtra;
        s4(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogModify", "\u6b63\u5728\u4fee\u6539..."));
        this.f43010y0.G(this.T, arrayList, editPhoto, 2, null, stringExtra2, this.f42981n2);
    }

    public void w3(Intent intent, int i3) {
        if (i3 != -1) {
            if (i3 == 0) {
                this.f42984o2 = null;
                return;
            }
            return;
        }
        com.qzone.album.env.common.a.m().R("368", "31", e2());
        if (this.f42984o2 == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("contentIntentKey");
        String stringExtra2 = intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY);
        this.f42984o2.content = stringExtra;
        AlbumCacheData albumCacheData = this.f43008x0;
        if (albumCacheData.loveAlbumTimeEventList == null) {
            albumCacheData.loveAlbumTimeEventList = new ArrayList<>();
        }
        this.f43008x0.loveAlbumTimeEventList.clear();
        this.f43008x0.loveAlbumTimeEventList.add(this.f42984o2);
        s4(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogModify", "\u6b63\u5728\u4fee\u6539..."));
        this.f43010y0.I(this.f43008x0, stringExtra2, this.f42981n2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b4(PhotoCacheData photoCacheData, int i3, boolean z16) {
        if (photoCacheData == null) {
            return true;
        }
        com.qzone.album.env.common.a.m().b("[PhotoAlbum]", "[add?", Boolean.valueOf(z16), "] photoCacheData.BigPath:", photoCacheData.getBigUrl(), " lloc:", photoCacheData.lloc);
        if (this.H0 == null) {
            this.H0 = new ArrayList();
        }
        if (!z16) {
            this.E0.remove(Integer.valueOf(i3));
            photoCacheData.isChecked = z16;
            this.H0.remove(photoCacheData);
            this.F0.remove(photoCacheData.getBigUrl());
            return true;
        }
        int S3 = S3();
        int O1 = O1();
        if (S3 < O1) {
            ArrayList<Integer> arrayList = this.E0;
            if (arrayList != null && !arrayList.contains(Integer.valueOf(i3))) {
                this.E0.add(Integer.valueOf(i3));
            }
            photoCacheData.isChecked = z16;
            if (!this.H0.contains(photoCacheData)) {
                this.H0.add(photoCacheData);
                this.F0.add(photoCacheData.getBigUrl());
            }
            return true;
        }
        com.qzone.album.env.common.a.m().V(String.format(u4.a.z().B().getString(R.string.gr5), Integer.valueOf(O1)));
        return false;
    }

    protected void e4(int i3) {
        if (i3 == 0) {
            this.f42944b1 = 0;
            C0(true);
        } else {
            this.f42944b1 = 1;
            C0(false);
        }
    }

    public boolean g3(PhotoCacheData photoCacheData) {
        List<PhotoCacheData> list;
        if (photoCacheData == null || this.f42970k0 == 0 || (list = this.H0) == null || list.size() <= 0) {
            return false;
        }
        boolean contains = this.H0.contains(photoCacheData);
        if (contains) {
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] BasePhotoModelController", "isSelected path:", photoCacheData.getBigUrl(), " lloc:", photoCacheData.lloc);
        }
        return contains;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w1(int i3, PhotoCacheData photoCacheData, List<PhotoCacheData[]> list, boolean z16) {
        PhotoCacheData Z1;
        if (this.f43008x0 == null) {
            return;
        }
        PhotoParam photoParam = new PhotoParam();
        photoParam.ownerUin = this.S.longValue();
        photoParam.albumid = this.T;
        photoParam.sortType = this.f42991r0;
        photoParam.uploadnum = this.f43003v0.size();
        photoParam.albumPriv = this.f42979n0;
        int i16 = this.f42976m0;
        if (i16 == 0) {
            i16 = this.f43003v0.size();
        }
        photoParam.albumnum = i16;
        photoParam.albumanswer = this.f42985p0;
        photoParam.busi_param = this.f42971k1;
        photoParam.albumType = this.f42940a0;
        photoParam.isShareAlbum = this.f43008x0.isSharingAlbumOnServer();
        int i17 = 0;
        if (this.O0) {
            photoParam.getPhotoExType = 6;
            photoParam.sharer = this.P0;
        } else {
            photoParam.getPhotoExType = 0;
            photoParam.sharer = 0L;
        }
        List<View> o26 = o2(z16);
        if (o26 != null && !o26.isEmpty() && ((o26.get(0) instanceof PhotoView) || (o26.get(0) instanceof BigPhotoView))) {
            View view = o26.get(0);
            if ((view.getTag() instanceof Integer) && (Z1 = Z1(list, (i17 = ((Integer) view.getTag()).intValue()), z16)) != null) {
                i17 = Z1.index;
            }
        }
        PictureViewerFactory.T(this.Q, this.A0, i3 - i17, photoParam, 1207, photoParam.albumType, photoCacheData.index, this.f43003v0.size(), h2(), O1(), this.T1 ? 8 : this.f42970k0, V2(this.f42970k0), 3);
    }

    public static void I2(Context context, View view) {
        if (context == null || view == null) {
            return;
        }
        ((InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z t3(z zVar, z zVar2) {
        int c16 = zVar == null ? -1 : zVar.c();
        int c17 = zVar2 == null ? -1 : zVar2.c();
        if (c16 == -1 && c17 == -1) {
            return null;
        }
        if (c16 > c17) {
            return k1(zVar);
        }
        return k1(zVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G2(com.qzone.adapter.feedcomponent.s sVar) {
        AlbumDataOutShare albumDataOutShare;
        String str;
        AlbumCacheData albumCacheData;
        RecomAlbumList recomAlbumList;
        ArrayList<PhotoCacheData> arrayList;
        ArrayList<PhotoCacheData> arrayList2;
        int i3;
        ArrayList<PhotoCacheData> arrayList3;
        com.qzone.album.business.photolist.ui.d dVar;
        View l3;
        if (sVar == null) {
            return;
        }
        long newCnt = sVar.getNewCnt();
        if (newCnt == 0) {
            F2();
        } else {
            if (this.f42970k0 == 0 && h() && !Q2()) {
                this.W1.getListView().setCoverMode(true, f42936w2);
            }
            if (this.O0) {
                this.W1.E1(this.Q0, com.qzone.util.l.a(R.string.jzf) + newCnt + com.qzone.util.l.a(R.string.jzh));
            }
            if (sVar.a() != null && sVar.a().getData() != null && (sVar.a().getData() instanceof QZonePhotoListRequest.b)) {
                this.Y = (QZonePhotoListRequest.a) sVar.a().getData();
                K1().C();
            }
        }
        o4(I1(this.S.longValue(), this.T, this.f42955f0), sVar.getHasMore());
        com.qzone.album.env.common.a.m().c("[PhotoAlbum] BasePhotoModelController", "mPreAlbumType:", Integer.valueOf(this.A1), " mAlbumType:", Integer.valueOf(this.f42940a0), " AlbumCacheDataUtil.hasTemplate(mAlbumCacheData):", Boolean.valueOf(com.qzone.album.util.b.f(this.f43008x0)), " getBaseAdapter() instanceof BigTemplatePhotoListAdapter:", Boolean.valueOf(B1() instanceof com.qzone.album.business.photolist.adapter.m));
        int i16 = this.A1;
        boolean z16 = (i16 == 8 || i16 == 9 || i16 == 11) ? false : true;
        int i17 = this.f42940a0;
        boolean z17 = (i17 == 8 || i17 == 9 || i17 == 11) ? false : true;
        boolean f16 = com.qzone.album.util.b.f(this.f43008x0);
        boolean z18 = f16 != this.f42943b0;
        this.f42943b0 = f16;
        if (this.f42994s0 != sVar.getHasMore()) {
            this.f42994s0 = sVar.getHasMore();
            ((com.qzone.album.business.photolist.adapter.a) B1()).C(!this.f42994s0);
            W3(this.f43003v0);
        }
        com.qzone.album.env.common.a.m().c("[PhotoAlbum] BasePhotoModelController", "individualChanged:", Boolean.valueOf(z18), " isPreNormal:", Boolean.valueOf(z16), " isNormal:", Boolean.valueOf(z17));
        if (((this.A1 != this.f42940a0 && (!z16 || !z17)) || z18) && !Q2()) {
            this.B1 = 0;
            com.qzone.album.env.common.a.m().c("[PhotoAlbum] BasePhotoModelController", "mPreAlbumType:", Integer.valueOf(this.A1), " mAlbumType:", Integer.valueOf(this.f42940a0), " mCurShowMode:", Integer.valueOf(this.B1));
            this.A1 = this.f42940a0;
            A4();
        }
        if (this.f42945b2 == null) {
            L2();
        }
        if (this.f42945b2.q(this.f43008x0)) {
            this.f42945b2.I();
            q4();
            if (this.f42970k0 == 1 && this.W1.z2() != null && (l3 = this.W1.z2().l()) != null && l3.getVisibility() == 0 && this.f42948c2) {
                this.W1.z2().s();
            }
        }
        N4();
        M4(((com.qzone.album.business.photolist.adapter.a) B1()).j());
        D4();
        this.f43001u1 = false;
        if (!((com.qzone.album.business.photolist.adapter.a) B1()).j() && this.f42970k0 != 4 && !this.O0) {
            K1().A(false);
            K1().A(true);
            y4(true);
            u2(sVar);
            BaseAdapter B1 = B1();
            if (B1 instanceof com.qzone.album.business.photolist.adapter.a) {
                this.f42968j1 = ((com.qzone.album.business.photolist.adapter.a) B1).g();
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.W1.getListView().getLayoutParams();
            layoutParams.addRule(3, -1);
            this.W1.getListView().setLayoutParams(layoutParams);
            this.W1.getListView().setCoverMode(true, f42936w2);
        }
        if (y() || w()) {
            u2(sVar);
        }
        if (sVar.getObjectData() instanceof QZonePhotoListRequest.a) {
            QZonePhotoListRequest.a aVar = (QZonePhotoListRequest.a) sVar.getObjectData();
            albumDataOutShare = aVar.f43962d;
            i3 = aVar.f43959a;
            albumCacheData = aVar.f43961c;
            String str2 = aVar.f43969k;
            ArrayList<PhotoCacheData> arrayList4 = aVar.f43967i;
            recomAlbumList = aVar.f43964f;
            arrayList = aVar.f43963e;
            str = str2;
            arrayList2 = arrayList4;
        } else {
            albumDataOutShare = null;
            str = null;
            albumCacheData = null;
            recomAlbumList = null;
            arrayList = null;
            arrayList2 = null;
            i3 = 0;
        }
        if (sVar.getObjectData() instanceof QZonePhotoListRequest.b) {
            this.f42988q0 = ((QZonePhotoListRequest.b) sVar.getObjectData()).f43965g;
        }
        if (albumCacheData != null) {
            long j3 = albumCacheData.ownerUin;
            long s16 = com.qzone.album.env.common.a.m().s();
            if (recomAlbumList != null && j3 != s16 && (dVar = this.f42942a2) != null) {
                dVar.n(recomAlbumList);
            }
        }
        if (albumDataOutShare != null) {
            this.N0 = albumDataOutShare;
            if (Q2()) {
                this.f42995s1.setText(this.P.getString(R.string.gje, Integer.valueOf(i3)));
            }
            if (albumCacheData != null) {
                this.f43008x0 = albumCacheData;
            }
            AlbumCacheData albumCacheData2 = this.f43008x0;
            if (albumCacheData2 != null) {
                arrayList3 = arrayList2;
                this.M0.f(this.P, this.Q, this.f42940a0, this.S0, this.T, this.N0, albumCacheData2, arrayList, D());
                if (arrayList3 != null && str != null && arrayList3.size() > 0) {
                    z3(str, arrayList3);
                }
                o3();
                this.U1 = true;
                this.f42960g2.d(String.valueOf(this.f42940a0));
            }
        }
        arrayList3 = arrayList2;
        if (arrayList3 != null) {
            z3(str, arrayList3);
        }
        o3();
        this.U1 = true;
        this.f42960g2.d(String.valueOf(this.f42940a0));
    }

    private long d4(PhotoCacheData photoCacheData, int i3, long j3) {
        int i16;
        if (i3 >= 0) {
            int i17 = i3 * 10;
            int i18 = i17 / 60;
            int i19 = i17 % 60;
            if (i18 >= 60) {
                i16 = i18 / 60;
                i18 %= 60;
            } else {
                i16 = 0;
            }
            int i26 = i16;
            int i27 = i18;
            if (photoCacheData != null && j3 > 0) {
                long j16 = j3 * 1000;
                if (j16 != 0) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.clear();
                    calendar.setTimeInMillis(j16);
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.clear();
                    calendar2.set(calendar.get(1), calendar.get(2), calendar.get(5), i26, i27, i19);
                    return calendar2.getTimeInMillis() / 1000;
                }
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z m3(z zVar, z zVar2) {
        if (zVar == null) {
            return zVar2;
        }
        if (zVar2 == null) {
            return zVar;
        }
        if (zVar.c() > zVar2.c()) {
            return k1(zVar2);
        }
        return k1(zVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u1(Intent intent) {
        SmartParcelable smartParcelable;
        BasePhotoModelController basePhotoModelController = this;
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        intent.getExtras().getBoolean("key_has_shoot_info");
        LbsDataV2.PoiInfo poiInfo = null;
        try {
            smartParcelable = ParcelableWrapper.getDataFromeIntent(intent, "key_select_photo_list_poi");
        } catch (Exception unused) {
            smartParcelable = null;
        }
        try {
            poiInfo = (LbsDataV2.PoiInfo) intent.getExtras().getParcelable(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI);
        } catch (Exception unused2) {
            com.qzone.album.env.common.a.m().e("[PhotoAlbum] BasePhotoModelController", "REQUEST_GET_LOCATION_FOR_POI Parcelable parse error.");
            int i3 = 1;
            basePhotoModelController.f42983o1 = true;
            if (smartParcelable == null) {
            }
            if (poiInfo == null) {
            }
        }
        int i36 = 1;
        basePhotoModelController.f42983o1 = true;
        if (smartParcelable == null && (smartParcelable instanceof PhotoPoiArea)) {
            PhotoPoiArea photoPoiArea = (PhotoPoiArea) smartParcelable;
            List<PhotoCacheData> list = basePhotoModelController.H0;
            if (list == null || list.size() <= 0) {
                return;
            }
            HashMap hashMap = new HashMap();
            for (PhotoCacheData photoCacheData : basePhotoModelController.H0) {
                EditPhoto editPhoto = new EditPhoto();
                PhotoCacheData photoCacheData2 = photoCacheData;
                long j3 = photoCacheData2.shoottime;
                if (j3 == 0) {
                    editPhoto.modifytime = (int) photoPoiArea.startShootTime;
                } else {
                    long j16 = photoPoiArea.startShootTime;
                    if (j3 < j16) {
                        editPhoto.modifytime = (int) j16;
                    } else {
                        long j17 = photoPoiArea.endShootTime;
                        if (j3 > j17) {
                            editPhoto.modifytime = (int) j17;
                        }
                    }
                }
                if (editPhoto.modifytime > 0) {
                    hashMap.put(photoCacheData2.lloc, editPhoto);
                }
            }
            if (basePhotoModelController.T == null || hashMap.size() <= 0) {
                return;
            }
            basePhotoModelController.f43010y0.P1(basePhotoModelController.T, null, new EditPhoto(), 1, null, hashMap, basePhotoModelController.f42981n2);
            return;
        }
        if (poiInfo == null) {
            if (TextUtils.isEmpty(poiInfo.poiName)) {
                poiInfo.poiName = poiInfo.address;
            }
            List<PhotoCacheData> list2 = basePhotoModelController.H0;
            if (list2 != null && list2.size() > 0) {
                Collections.sort(basePhotoModelController.H0, QZoneAlbumUtil.w(6));
                HashMap hashMap2 = new HashMap();
                for (PhotoCacheData photoCacheData3 : basePhotoModelController.H0) {
                    PhotoPoiArea b26 = basePhotoModelController.b2(photoCacheData3);
                    if (!hashMap2.containsKey(b26)) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(photoCacheData3);
                        hashMap2.put(b26, arrayList);
                    } else {
                        ((ArrayList) hashMap2.get(b26)).add(photoCacheData3);
                    }
                }
                ArrayList<modify_travel_photo_scence> arrayList2 = new ArrayList<>();
                HashMap hashMap3 = new HashMap();
                for (Map.Entry entry : hashMap2.entrySet()) {
                    PhotoPoiArea photoPoiArea2 = (PhotoPoiArea) entry.getKey();
                    PhotoPoiArea photoPoiArea3 = new PhotoPoiArea();
                    modify_travel_photo_scence modify_travel_photo_scenceVar = new modify_travel_photo_scence();
                    modify_travel_photo_scenceVar.opetype = 2;
                    modify_travel_photo_scence modify_travel_photo_scenceVar2 = new modify_travel_photo_scence();
                    modify_travel_photo_scenceVar2.opetype = i36;
                    ArrayList arrayList3 = (ArrayList) entry.getValue();
                    ArrayList<PhotoCacheData> E1 = basePhotoModelController.E1(photoPoiArea2);
                    if (photoPoiArea2 != null && arrayList3 != null) {
                        if (E1 != null) {
                            long j18 = photoPoiArea2.startShootTime;
                            long j19 = (((float) (photoPoiArea2.endShootTime - j18)) / 2.0f) + j18;
                            modify_travel_photo_scenceVar.poi_area_start_time = j18;
                            if (arrayList3.contains(E1.get(E1.size() - i36))) {
                                photoPoiArea3.photoNum = arrayList3.size();
                                photoPoiArea3.startShootTime = j19;
                                photoPoiArea3.endShootTime = photoPoiArea2.endShootTime;
                                photoPoiArea3.poiInfo = QZoneAlbumUtil.H(poiInfo);
                                photoPoiArea3.sceneryName = poiInfo.poiName;
                                photoPoiArea2.photoNum -= arrayList3.size();
                                photoPoiArea2.endShootTime = j19 - 1;
                            } else {
                                photoPoiArea3.photoNum = arrayList3.size();
                                photoPoiArea3.startShootTime = photoPoiArea2.startShootTime;
                                photoPoiArea3.endShootTime = j19;
                                photoPoiArea3.poiInfo = QZoneAlbumUtil.H(poiInfo);
                                photoPoiArea3.sceneryName = poiInfo.poiName;
                                photoPoiArea2.photoNum -= arrayList3.size();
                                photoPoiArea2.startShootTime = j19 + 1;
                            }
                            modify_travel_photo_scenceVar2.poi_area_start_time = photoPoiArea3.startShootTime;
                            modify_travel_photo_scenceVar.poi = PhotoPoiArea.convertToRequest(photoPoiArea2);
                            modify_travel_photo_scenceVar2.poi = PhotoPoiArea.convertToRequest(photoPoiArea3);
                            arrayList2.add(modify_travel_photo_scenceVar);
                            arrayList2.add(modify_travel_photo_scenceVar2);
                            Iterator<PhotoCacheData> it = E1.iterator();
                            while (it.hasNext()) {
                                PhotoCacheData next = it.next();
                                EditPhoto editPhoto2 = new EditPhoto();
                                if (arrayList3.contains(next)) {
                                    editPhoto2.modifytime = ((int) photoPoiArea3.startShootTime) + 1;
                                } else {
                                    editPhoto2.modifytime = ((int) photoPoiArea2.startShootTime) + 1;
                                }
                                hashMap3.put(next.lloc, editPhoto2);
                            }
                            i36 = 1;
                        }
                    }
                    basePhotoModelController = this;
                }
                String str = basePhotoModelController.T;
                if (str != null) {
                    basePhotoModelController.f43010y0.H0(str, new PhotoPoiArea(), 0L, arrayList2, hashMap3, false, basePhotoModelController.f42981n2);
                    return;
                }
                return;
            }
            if (basePhotoModelController.L1 != null) {
                if (TextUtils.isEmpty(poiInfo.poiId) && basePhotoModelController.L1.sceneryName.equals(poiInfo.poiName)) {
                    return;
                }
                basePhotoModelController.L1.poiInfo = QZoneAlbumUtil.H(poiInfo);
                PhotoPoiArea photoPoiArea4 = basePhotoModelController.L1;
                photoPoiArea4.sceneryName = poiInfo.poiName;
                String str2 = basePhotoModelController.T;
                if (str2 != null) {
                    basePhotoModelController.f43010y0.H0(str2, photoPoiArea4, photoPoiArea4.startShootTime, null, null, true, basePhotoModelController.f42981n2);
                }
            }
        }
    }

    /* loaded from: classes39.dex */
    class k implements QZonePullToRefreshListView.c {
        k() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void Y() {
            BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
            basePhotoModelController.X1 = false;
            basePhotoModelController.W1.y();
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullStart() {
            BasePhotoModelController.this.l0(new long[0]);
            BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
            if (basePhotoModelController.f43001u1 && !basePhotoModelController.f43004v1 && basePhotoModelController.d1(1)) {
                BasePhotoModelController.this.p1();
                BasePhotoModelController.this.W1.t();
            }
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onRefresh() {
            BasePhotoModelController basePhotoModelController = BasePhotoModelController.this;
            if ((basePhotoModelController.f43001u1 && basePhotoModelController.f43004v1) || QZoneAlbumUtil.A(basePhotoModelController.f42970k0)) {
                return;
            }
            BasePhotoModelController basePhotoModelController2 = BasePhotoModelController.this;
            basePhotoModelController2.X1 = true;
            basePhotoModelController2.e4(0);
            BasePhotoModelController.this.o0();
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullEnd() {
        }
    }

    public void A4() {
    }

    public void B4(Album album) {
    }

    protected void C4(List<PhotoCacheData> list) {
    }

    protected void D4() {
    }

    protected void H3() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M4(boolean z16) {
    }

    public void N4() {
    }

    public void O4(boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X3(boolean z16) {
    }

    protected void l1() {
    }

    protected void l3() {
    }

    public void m1(int i3) {
    }

    public void n1(Intent intent) {
    }

    public void n3(boolean z16) {
    }

    public void n4() {
    }

    public void o1() {
    }

    protected void o3() {
    }

    public void p1() {
    }

    public void q1() {
    }

    public void q3() {
    }

    protected void q4() {
    }

    protected void r1() {
    }

    public void r3() {
    }

    public void r4() {
    }

    public void s3() {
    }

    public void t1() {
    }

    public void v4(int i3) {
    }

    public void w4() {
    }

    public void x3() {
    }

    protected void y4(boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y3(int i3) {
        if (i3 == 0) {
            this.W1.getListView().setGestureSelectMode(false);
            return;
        }
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 5 || i3 == 6 || i3 == 7) {
            this.W1.getListView().setGestureSelectMode(true);
        }
    }

    @Override // x4.a
    public void e(PhotoCacheData photoCacheData, int i3) {
    }

    @Override // x4.a
    public void t(PhotoCacheData photoCacheData, int i3) {
    }

    protected void y3(AbsListView absListView, int i3) {
    }

    public void z3(String str, ArrayList<PhotoCacheData> arrayList) {
    }

    protected void J3(int i3, long j3, long j16) {
    }

    protected void s1(boolean z16, BusinessAlbumInfo businessAlbumInfo, n5.a aVar, Handler handler) {
    }
}
