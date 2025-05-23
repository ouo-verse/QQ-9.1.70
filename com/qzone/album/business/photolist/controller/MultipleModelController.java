package com.qzone.album.business.photolist.controller;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.business.photolist.adapter.a;
import com.qzone.album.business.photolist.adapter.aa;
import com.qzone.album.business.photolist.adapter.u;
import com.qzone.album.business.photolist.ui.listitem.PhotoView;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PicContInfoCacheData;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QzoneGetPicContInfoRequest;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.common.tool.ReportUtils;
import com.qzone.preview.event.QZoneAlbumLayerSelectPhotoEvent;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.util.image.NetImageInfo;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationAIO;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationQzone;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationQzone;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.album.QzonePhotoInfo;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import oo.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class MultipleModelController extends BasePhotoModelController {
    public int D2;
    private View E2;
    private int F2;
    private boolean G2;
    private boolean H2;
    private int I2;
    private String J2;
    protected GridView K2;
    protected aa L2;
    protected HorizontalScrollView M2;
    protected TextView N2;
    protected TextView O2;
    protected TextView P2;
    int Q2;
    protected Map<String, NetImageInfo> R2;
    protected Handler S2;
    String T2;
    String U2;
    String V2;
    private Runnable W2;
    private a.f X2;
    HashMap<String, PicContInfoCacheData> Y2;
    private Handler Z2;

    /* renamed from: a3, reason: collision with root package name */
    Runnable f43097a3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements AbsCompatRequest.a {
        a() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            HashMap<String, PicContInfoCacheData> hashMap;
            if (sVar.getData() instanceof QzoneGetPicContInfoRequest.a) {
                QzoneGetPicContInfoRequest.a aVar = (QzoneGetPicContInfoRequest.a) sVar.getData();
                if (aVar != null && (hashMap = aVar.f43995b) != null) {
                    MultipleModelController.this.Y2.putAll(hashMap);
                } else {
                    com.qzone.album.env.common.a.m().W(MultipleModelController.this.T2, 4);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements a.f {
        b() {
        }

        @Override // com.qzone.album.business.photolist.adapter.a.f
        public void onClick(View view) {
            MultipleModelController.this.x5(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NetImageInfo f43102a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PhotoCacheData f43103b;

        c(NetImageInfo netImageInfo, PhotoCacheData photoCacheData) {
            this.f43102a = netImageInfo;
            this.f43103b = photoCacheData;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            MultipleModelController.this.Z2.removeCallbacks(MultipleModelController.this.f43097a3);
            MultipleModelController.this.i1();
            com.qzone.album.env.common.a.m().b("[PhotoAlbum]aioSendPhotos", "end query md5...");
            QzoneGetPicContInfoRequest.a aVar = (QzoneGetPicContInfoRequest.a) sVar.getData();
            if (aVar != null && aVar.f43994a != null) {
                HashMap<String, PicContInfoCacheData> hashMap = aVar.f43995b;
                if (hashMap != null) {
                    MultipleModelController.this.Y2.putAll(hashMap);
                }
                PicContInfoCacheData picContInfoCacheData = MultipleModelController.this.Y2.get(com.qzone.album.util.i.a(this.f43102a.getBigPath()));
                if (picContInfoCacheData != null && !TextUtils.isEmpty(picContInfoCacheData.md5)) {
                    NetImageInfo netImageInfo = this.f43102a;
                    PhotoSendParams photoSendParams = netImageInfo.sendParams;
                    photoSendParams.rawMd5 = picContInfoCacheData.md5;
                    photoSendParams.fileSize = picContInfoCacheData.size;
                    if (MultipleModelController.this.f5(netImageInfo)) {
                        this.f43103b.isChecked = true;
                        if (MultipleModelController.this.B1() != null) {
                            MultipleModelController.this.B1().notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.qzone.album.env.common.a.m().W(MultipleModelController.this.T2, 4);
                com.qzone.album.env.common.a.m().e("[PhotoAlbum]aioSendPhotos", "batchQueryMd5 onResponse picContInfo != null && !TextUtils.isEmpty(picContInfo.md5");
                return;
            }
            com.qzone.album.env.common.a.m().W(MultipleModelController.this.T2, 4);
            com.qzone.album.env.common.a.m().e("[PhotoAlbum]aioSendPhotos", "rspBean == null || pic_info == null");
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d extends Handler {
        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MultipleModelController multipleModelController = MultipleModelController.this;
            GridView gridView = multipleModelController.K2;
            if (gridView != null) {
                multipleModelController.M2.scrollTo(gridView.getLayoutParams().width, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f43106a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Looper looper, boolean z16) {
            super(looper);
            this.f43106a = z16;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            MultipleModelController.this.E3(obj, Boolean.valueOf(this.f43106a), MultipleModelController.this.f43008x0);
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f extends HdAsyncAction {
        f(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            ArrayList<PhotoCacheData> B;
            if (MultipleModelController.this.f43010y0 != null) {
                com.qzone.album.env.common.a.m().c("[PhotoAlbum] MultipleModelController", "loadDataFromCache| isInSortingMode:", Boolean.valueOf(MultipleModelController.this.f42950d1));
                if (!TextUtils.isEmpty(MultipleModelController.this.T)) {
                    MultipleModelController multipleModelController = MultipleModelController.this;
                    multipleModelController.f43008x0 = multipleModelController.f43012z0.x(multipleModelController.S.longValue(), MultipleModelController.this.T);
                    com.qzone.album.env.common.a.m().c("[PhotoAlbum] MultipleModelController", "loadDataFromCache|refreshPhotoLocalCache run");
                    if (!MultipleModelController.this.H2) {
                        if (MultipleModelController.this.G2) {
                            MultipleModelController multipleModelController2 = MultipleModelController.this;
                            B = multipleModelController2.f43012z0.D(multipleModelController2.T, false);
                        } else {
                            MultipleModelController multipleModelController3 = MultipleModelController.this;
                            B = multipleModelController3.f43012z0.B(multipleModelController3.T);
                        }
                    } else {
                        MultipleModelController multipleModelController4 = MultipleModelController.this;
                        B = multipleModelController4.f43012z0.D(multipleModelController4.T, false);
                        MultipleModelController multipleModelController5 = MultipleModelController.this;
                        ArrayList<PicContInfoCacheData> S = multipleModelController5.f43012z0.S(multipleModelController5.T);
                        com.qzone.album.env.common.a.m().c("[PhotoAlbum]aioSendPhotos", "loadDataFromCache | PicContInfoCacheData size:", Integer.valueOf(S.size()));
                        Iterator<PicContInfoCacheData> it = S.iterator();
                        while (it.hasNext()) {
                            PicContInfoCacheData next = it.next();
                            MultipleModelController.this.Y2.put(next.url, next);
                        }
                    }
                    return doNext(true, B);
                }
            }
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g implements AdapterView.OnItemClickListener {
        g() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof NetImageInfo)) {
                return;
            }
            NetImageInfo netImageInfo = (NetImageInfo) tag;
            if (MultipleModelController.this.s5(netImageInfo) && MultipleModelController.this.A5(netImageInfo) && MultipleModelController.this.B1() != null) {
                MultipleModelController.this.B1().notifyDataSetChanged();
            }
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
            MultipleModelController multipleModelController = MultipleModelController.this;
            if (!multipleModelController.f42964i0) {
                if (multipleModelController.F2 == 1) {
                    MultipleModelController.this.G5(true);
                } else {
                    MultipleModelController.this.P3(true);
                }
            } else {
                multipleModelController.t1();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (MultipleModelController.this.F0.size() == 0) {
                com.qzone.album.env.common.a.m().e("[PhotoAlbum]aioSendPhotos", "mSelectPhotoListFromQQAndQzone.size() == 0");
            } else {
                MultipleModelController multipleModelController = MultipleModelController.this;
                if (multipleModelController.Q2 == 1) {
                    multipleModelController.m5();
                } else if (!RFWApplication.isPublicVersion() || com.qzone.reborn.configx.g.f53821a.b().T()) {
                    MultipleModelController.this.l5();
                } else {
                    MultipleModelController multipleModelController2 = MultipleModelController.this;
                    multipleModelController2.n5(multipleModelController2.F0);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (MultipleModelController.this.F2 == 1) {
                MultipleModelController.this.G5(false);
            } else {
                MultipleModelController.this.P3(false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class k implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private int f43113d;

        /* renamed from: e, reason: collision with root package name */
        private int f43114e;

        /* renamed from: f, reason: collision with root package name */
        private String f43115f;

        /* renamed from: h, reason: collision with root package name */
        private PhotoCacheData f43116h;

        /* renamed from: i, reason: collision with root package name */
        private s4.d f43117i;

        public k(int i3, int i16, String str, PhotoCacheData photoCacheData, s4.d dVar) {
            this.f43113d = i3;
            this.f43114e = i16;
            this.f43115f = str;
            this.f43116h = photoCacheData;
            this.f43117i = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MultipleModelController.this.x5(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class l implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private int f43119d;

        /* renamed from: e, reason: collision with root package name */
        private int f43120e;

        /* renamed from: f, reason: collision with root package name */
        private String f43121f;

        /* renamed from: h, reason: collision with root package name */
        private PhotoCacheData f43122h;

        /* renamed from: i, reason: collision with root package name */
        private s4.d f43123i;

        public l(int i3, int i16, String str, PhotoCacheData photoCacheData, s4.d dVar) {
            this.f43119d = i3;
            this.f43120e = i16;
            this.f43121f = str;
            this.f43122h = photoCacheData;
            this.f43123i = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f43120e != 2) {
                com.qzone.album.env.common.a.m().V(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastProcessPhotoAndWait", "\u56fe\u7247\u6b63\u5728\u5904\u7406\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5\u3002"));
            } else if (!MultipleModelController.this.R2(this.f43122h)) {
                MultipleModelController multipleModelController = MultipleModelController.this;
                PhotoCacheData Z1 = multipleModelController.Z1(multipleModelController.f43000u0, this.f43119d, false);
                if (Z1 != null) {
                    MultipleModelController multipleModelController2 = MultipleModelController.this;
                    multipleModelController2.w1(Z1.index, Z1, multipleModelController2.f43000u0, false);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class m implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private s4.d f43125d;

        /* renamed from: e, reason: collision with root package name */
        private ArrayList<Integer> f43126e;

        /* renamed from: f, reason: collision with root package name */
        private ArrayList<PhotoCacheData> f43127f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes39.dex */
        public class a implements AbsCompatRequest.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f43129a;

            a(boolean z16) {
                this.f43129a = z16;
            }

            @Override // com.qzone.album.protocol.AbsCompatRequest.a
            public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
                MultipleModelController.this.Z2.removeCallbacks(MultipleModelController.this.f43097a3);
                MultipleModelController.this.i1();
                com.qzone.album.env.common.a.m().b("[PhotoAlbum]aioSendPhotos", "end query md5...");
                QzoneGetPicContInfoRequest.a aVar = (QzoneGetPicContInfoRequest.a) sVar.getData();
                if (aVar != null && aVar.f43994a != null) {
                    HashMap<String, PicContInfoCacheData> hashMap = aVar.f43995b;
                    if (hashMap != null) {
                        MultipleModelController.this.Y2.putAll(hashMap);
                    }
                    m.this.a(this.f43129a);
                    return;
                }
                com.qzone.album.env.common.a.m().b("[PhotoAlbum]aioSendPhotos", "pic_info == null");
                com.qzone.album.env.common.a.m().W(MultipleModelController.this.T2, 4);
            }
        }

        public m(s4.d dVar) {
            this.f43125d = new s4.d();
            this.f43126e = new ArrayList<>();
            this.f43127f = new ArrayList<>();
            this.f43125d = dVar;
            if (dVar != null) {
                this.f43126e = dVar.f433295b;
                this.f43127f = dVar.f433296c;
            }
        }

        public void a(boolean z16) {
            MultipleModelController.this.i5();
            ArrayList<PhotoCacheData> arrayList = this.f43127f;
            if (arrayList == null || arrayList.size() <= 0 || this.f43127f.get(0) == null) {
                return;
            }
            for (int i3 = 0; i3 < this.f43126e.size(); i3++) {
                if (this.f43127f.get(i3) != null) {
                    int intValue = this.f43126e.get(i3).intValue();
                    PhotoCacheData photoCacheData = this.f43127f.get(i3);
                    String str = photoCacheData.lloc;
                    NetImageInfo create = NetImageInfo.create(photoCacheData, MultipleModelController.this.H2);
                    if (create != null) {
                        if (z16) {
                            if (MultipleModelController.this.H2 && MultipleModelController.this.Y2 != null && TextUtils.isEmpty(create.sendParams.rawMd5) && MultipleModelController.this.Y2.containsKey(com.qzone.album.util.i.a(create.getBigPath()))) {
                                PicContInfoCacheData picContInfoCacheData = MultipleModelController.this.Y2.get(com.qzone.album.util.i.a(create.getBigPath()));
                                PhotoSendParams photoSendParams = create.sendParams;
                                photoSendParams.rawMd5 = picContInfoCacheData.md5;
                                photoSendParams.fileSize = picContInfoCacheData.size;
                            }
                            if (MultipleModelController.this.H2 && TextUtils.isEmpty(create.sendParams.rawMd5)) {
                                com.qzone.album.env.common.a.m().W(MultipleModelController.this.T2, 4);
                            } else if (MultipleModelController.this.j5()) {
                                if (!MultipleModelController.this.E0.contains(Integer.valueOf(intValue))) {
                                    MultipleModelController.this.E0.add(Integer.valueOf(intValue));
                                    if (!MultipleModelController.this.t5(create.getBigPath(), MultipleModelController.this.F0)) {
                                        photoCacheData.isChecked = true;
                                        MultipleModelController multipleModelController = MultipleModelController.this;
                                        multipleModelController.I0 = true;
                                        multipleModelController.F0.add(create.getBigPath());
                                        create.index = this.f43126e.get(i3).intValue();
                                        if (!MultipleModelController.this.G0.contains(create)) {
                                            MultipleModelController.this.G0.add(create);
                                            if (MultipleModelController.this.H2) {
                                                NetImageInfo.onPicSelectPreSend(MultipleModelController.this.G(), create.sendParams);
                                            }
                                        }
                                        MultipleModelController.this.w5();
                                        MultipleModelController.this.h5(true);
                                    }
                                }
                            } else {
                                com.qzone.album.env.common.a.m().V(String.format(u4.a.z().B().getString(R.string.gr5), Integer.valueOf(MultipleModelController.this.J0)));
                                return;
                            }
                        } else {
                            if (MultipleModelController.this.E0.contains(Integer.valueOf(intValue))) {
                                MultipleModelController.this.E0.remove(Integer.valueOf(intValue));
                            }
                            photoCacheData.isChecked = false;
                            MultipleModelController multipleModelController2 = MultipleModelController.this;
                            multipleModelController2.I0 = true;
                            multipleModelController2.C5(create.getBigPath(), MultipleModelController.this.F0);
                            create.index = this.f43126e.get(i3).intValue();
                            if (str != null && MultipleModelController.this.G0.contains(create)) {
                                MultipleModelController.this.G0.remove(create);
                            }
                            MultipleModelController.this.w5();
                            MultipleModelController.this.h5(false);
                        }
                        MultipleModelController multipleModelController3 = MultipleModelController.this;
                        multipleModelController3.W1.notifyAdapter(multipleModelController3.B1());
                    } else {
                        continue;
                    }
                }
            }
        }

        public void b(boolean z16) {
            PhotoSendParams photoSendParams;
            ArrayList<String> arrayList = new ArrayList<>(1);
            ArrayList<PhotoCacheData> arrayList2 = this.f43127f;
            if (arrayList2 == null || arrayList2.size() <= 0 || this.f43127f.get(0) == null) {
                return;
            }
            for (int i3 = 0; i3 < this.f43127f.size(); i3++) {
                if (this.f43127f.get(i3) != null) {
                    NetImageInfo create = NetImageInfo.create(this.f43127f.get(i3), MultipleModelController.this.H2);
                    if (create != null && (photoSendParams = create.sendParams) != null && !TextUtils.isEmpty(photoSendParams.rawMd5)) {
                        MultipleModelController.this.D5("hasMd5");
                    } else if (create != null && !MultipleModelController.this.Y2.containsKey(com.qzone.album.util.i.a(create.getBigPath())) && !SharpPUtils.isSharpP(create.getBigPath())) {
                        arrayList.add(create.getBigPath());
                    }
                }
            }
            if (arrayList.size() != 0) {
                MultipleModelController.this.Z2.postDelayed(MultipleModelController.this.f43097a3, 100L);
                com.qzone.album.env.common.a.m().b("[PhotoAlbum]aioSendPhotos", "query md5...");
                com.qzone.album.base.Service.a.W().r(MultipleModelController.this.S.longValue(), MultipleModelController.this.T, arrayList, new a(z16));
            } else {
                a(z16);
            }
            MultipleModelController.this.E5("hitFailure", arrayList.size());
            MultipleModelController.this.E5("hitSuccess", this.f43127f.size() - arrayList.size());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (MultipleModelController.this.H2) {
                if (!view.isSelected()) {
                    b(!view.isSelected());
                } else {
                    a(!view.isSelected());
                }
                if (!view.isSelected()) {
                    LpReportInfo_pf00064.allReport(96, 3, 4);
                } else {
                    LpReportInfo_pf00064.allReport(96, 3, 5);
                }
            } else {
                a(!view.isSelected());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public MultipleModelController(FragmentActivity fragmentActivity, u4.h hVar) {
        super(fragmentActivity, hVar);
        this.D2 = 0;
        this.F2 = 0;
        this.G2 = false;
        this.H2 = false;
        this.I2 = -1;
        this.R2 = new HashMap();
        this.S2 = new d();
        this.T2 = "";
        this.U2 = "";
        this.V2 = "";
        this.W2 = new Runnable() { // from class: com.qzone.album.business.photolist.controller.MultipleModelController.9
            @Override // java.lang.Runnable
            public void run() {
                MultipleModelController.this.z5();
            }
        };
        this.X2 = new b();
        this.Y2 = new HashMap<>(1);
        this.Z2 = new Handler(Looper.getMainLooper());
        this.f43097a3 = new Runnable() { // from class: com.qzone.album.business.photolist.controller.MultipleModelController.13
            @Override // java.lang.Runnable
            public void run() {
                MultipleModelController.this.s4("");
            }
        };
    }

    private void B5(NetImageInfo netImageInfo) {
        this.F0.remove(netImageInfo.getBigPath());
        this.I0 = true;
        if (this.G0.size() == 0 && this.F0.size() == 0) {
            this.N2.setVisibility(8);
            this.O2.setVisibility(8);
        }
        this.E0.remove(Integer.valueOf(netImageInfo.index));
        if (this.H2) {
            LpReportInfo_pf00064.allReport(96, 3, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E5(String str, int i3) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(str, String.valueOf(i3));
        ReportUtils.b("aioSendPhoto", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G5(boolean z16) {
        Intent G = G();
        if (z16) {
            ArrayList arrayList = new ArrayList();
            Iterator<NetImageInfo> it = this.G0.iterator();
            while (it.hasNext()) {
                NetImageInfo next = it.next();
                QzonePhotoInfo qzonePhotoInfo = new QzonePhotoInfo();
                qzonePhotoInfo.mAlbumId = next.mAlbumId;
                qzonePhotoInfo.mBigUrl = next.mBigPath;
                qzonePhotoInfo.mlloc = next.lloc;
                qzonePhotoInfo.mShootTime = next.shoottime;
                qzonePhotoInfo.mUploadTime = next.uploadTime;
                qzonePhotoInfo.mBigWidth = next.width;
                qzonePhotoInfo.mBigHeight = next.height;
                qzonePhotoInfo.mShouzhang_extend_map = next.shouzhang_extend_map;
                arrayList.add(qzonePhotoInfo);
            }
            G.putExtra(RemoteHandleConst.PARAM_DYNAMIC_CLOUD_PHOTOLIST, arrayList);
            G.putExtra(QZoneHelper.QZoneAlbumConstants.QZ_ALBUM_SORT_TYPE, this.f42991r0);
            this.Q.setResult(-1, G);
        } else {
            this.Q.setResult(0, G);
        }
        x1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i5() {
        if (this.f42975l2) {
            this.f42975l2 = false;
            if (v5()) {
                com.qzone.album.env.common.a.m().V(this.U2);
                return;
            }
            LocalMultiProcConfig.putBool("share", AppConstants.Preferences.QZONE_WILL_UPLOAD_TO_QUN_ALBUM + this.J2, false);
            com.qzone.album.env.common.a.m().V(this.V2);
        }
    }

    private void k5(final List<String> list) {
        com.qzone.album.env.common.a.m().J(new Runnable() { // from class: com.qzone.album.business.photolist.controller.MultipleModelController.7

            /* compiled from: P */
            /* renamed from: com.qzone.album.business.photolist.controller.MultipleModelController$7$a */
            /* loaded from: classes39.dex */
            class a implements u4.f {
                a() {
                }

                @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
                public void a(String str, ArrayList<String> arrayList) {
                    String arrays;
                    MultipleModelController.this.i1();
                    Intent intent = new Intent();
                    if (MultipleModelController.this.f42961h0) {
                        com.qzone.util.image.c.j(arrayList);
                    }
                    intent.putStringArrayListExtra(QZoneHelper.QZoneAlbumConstants.KEY_COVER_SELECTED_IMG_PATH, arrayList);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("downloadPics onDownloadSucceed  | url = ");
                    sb5.append(str);
                    sb5.append(" | path = ");
                    if (bl.b(arrayList)) {
                        arrays = "";
                    } else {
                        arrays = Arrays.toString(arrayList.toArray());
                    }
                    sb5.append(arrays);
                    sb5.append(" | mNeedChangeJPG = ");
                    sb5.append(MultipleModelController.this.f42961h0);
                    QLog.e("[PhotoAlbum] MultipleModelController", 1, sb5.toString());
                    if (arrayList != null) {
                        Iterator<String> it = arrayList.iterator();
                        while (it.hasNext()) {
                            QLog.e("[PhotoAlbum] MultipleModelController", 1, "downloadPics onDownloadSucceed | imagePath.exists" + new File(it.next()).exists());
                        }
                    }
                    com.qzone.album.env.common.a.m().W(MultipleModelController.this.I(R.string.gki), 5);
                    MultipleModelController.this.Q.setResult(-1, intent);
                    MultipleModelController.this.x1();
                }

                @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
                public void onDownloadFailed(String str) {
                    com.qzone.album.env.common.a.m().U(R.string.gkh);
                    MultipleModelController.this.i1();
                    QLog.e("[PhotoAlbum] MultipleModelController", 1, "downloadPics onDownloadFailed , url = " + str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                u4.a.z().s(System.currentTimeMillis() + "", list, new a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l5() {
        ArrayList<String> arrayList = this.F0;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList<String> arrayList3 = new ArrayList<>();
        ArrayList<NetImageInfo> arrayList4 = this.G0;
        if (arrayList4 != null && !arrayList4.isEmpty()) {
            Iterator<NetImageInfo> it = this.G0.iterator();
            while (it.hasNext()) {
                NetImageInfo next = it.next();
                PhotoCacheData photoCacheData = new PhotoCacheData();
                photoCacheData.albumid = next.mAlbumId;
                String str = next.lloc;
                photoCacheData.lloc = str;
                photoCacheData.sloc = str;
                PictureItem pictureItem = new PictureItem();
                pictureItem.bigUrl.url = next.getBigPath();
                PictureUrl pictureUrl = pictureItem.bigUrl;
                pictureUrl.width = next.width;
                pictureUrl.height = next.height;
                pictureItem.lloc = next.lloc;
                pictureItem.currentUrl.url = next.getBigPath();
                PictureUrl pictureUrl2 = pictureItem.currentUrl;
                pictureUrl2.width = next.width;
                pictureUrl2.height = next.height;
                photoCacheData.picItem = pictureItem;
                arrayList2.add(photoCacheData);
                arrayList3.add(next.lloc);
            }
        }
        rk.b bVar = new rk.b();
        bVar.q(arrayList2);
        bVar.y(arrayList3);
        bVar.w(true);
        bVar.v(O1());
        bVar.n(this.f42940a0);
        ho.i.l().r(this.Q, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m5() {
        ArrayList<NetImageInfo> arrayList;
        com.tencent.mobileqq.utils.e.e();
        Intent intent = new Intent();
        intent.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
        intent.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, "com.qzone.publish.ui.activity.QZonePublishMoodTabActivity");
        intent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", true);
        intent.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
        intent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        intent.putExtra(PeakConstants.IS_FROM_QZONE_ALBUM, true);
        ArrayList<String> arrayList2 = this.F0;
        if (arrayList2 != null && arrayList2.size() > 0) {
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.F0);
            ArrayList<NetImageInfo> arrayList3 = this.G0;
            if (arrayList3 != null && arrayList3.size() > 0) {
                arrayList = new ArrayList<>(this.G0);
            } else {
                arrayList = new ArrayList<>();
            }
            HashMap<String, PicInfo> hashMap = new HashMap<>();
            o5(arrayList, hashMap);
            intent.putExtra(PeakConstants.PHOTO_INFOS, hashMap);
            intent.putExtra(PeakConstants.PHOTO_PATHS_FROM_QZONEALBUM, com.qzone.album.util.a.d(this.G0));
            intent.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, 0);
            intent.putExtra(PeakConstants.USE_URL_PATH, true);
            intent.putExtra(PeakConstants.QZONE_ALBUM_FROM_AIO, this.H2);
        }
        intent.putExtra(PeakConstants.FROM_MINI_APP, false);
        intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, this.C0);
        intent.setClass(BaseApplication.getContext(), QzonePhotoPreviewActivity.class);
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", G().getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"));
        intent.addFlags(603979776);
        intent.putExtra(PeakConstants.FROM_SHUOSHUO, true);
        intent.putExtra(PeakConstants.KEY_SHOW_TYPE, this.Q2);
        intent.putExtra(PeakConstants.KEY_SHOW_ORIGIN_TYPE, this.Q2);
        PublicFragmentActivity.b.a(BaseApplication.getContext(), intent, PublicFragmentActivityForPeak.class, QzonePhotoPreviewActivity.class);
        QAlbumUtil.anim(q2(), true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n5(ArrayList<String> arrayList) {
        ArrayList<NetImageInfo> arrayList2;
        Intent intent = new Intent();
        intent.putExtra("PhotoConst.PHOTO_PATHS", arrayList);
        intent.putExtra(PeakConstants.PHOTO_PATHS_FROM_QZONEALBUM, com.qzone.album.util.a.d(this.G0));
        intent.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, 0);
        intent.putExtra(PeakConstants.USE_URL_PATH, true);
        intent.putExtra(PeakConstants.QZONE_ALBUM_FROM_AIO, this.H2);
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.J0);
        intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, this.C0);
        if (G().getParcelableExtra(PeakConstants.KEY_SEND_TO_AIO_INTENT) != null) {
            intent.putExtra(PeakConstants.KEY_SEND_TO_AIO_INTENT, (Intent) G().getParcelableExtra(PeakConstants.KEY_SEND_TO_AIO_INTENT));
        }
        intent.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_QZONE_PHOTO_LIST);
        intent.putExtra(PeakConstants.IS_JUMPTO_TROOP_ALBUM, this.f42975l2);
        intent.putExtra(PeakConstants.FROM_QZONE, G().getBooleanExtra(PeakConstants.FROM_QZONE, false));
        if (this.H2) {
            intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 1);
            intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationAIO.T);
            intent.putExtra(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, AlbumListCustomizationAIO.f184370j);
            intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationAIO.R);
        } else {
            intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 7);
            intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationQzone.f184396f0);
            intent.putExtra(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, AlbumListCustomizationQzone.f184373k);
            intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationQzone.P);
        }
        intent.putExtra(PhotoCommonBaseData.NEED_NEW_PHOTO_COMMON_DATA, false);
        intent.setClass(BaseApplication.getContext(), NewPhotoPreviewActivity.class);
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", G().getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"));
        ArrayList<String> arrayList3 = this.F0;
        if (arrayList3 != null && arrayList3.size() > 0) {
            ArrayList<NetImageInfo> arrayList4 = this.G0;
            if (arrayList4 != null && arrayList4.size() > 0) {
                arrayList2 = new ArrayList<>(this.G0);
            } else {
                arrayList2 = new ArrayList<>();
            }
            HashMap<String, PicInfo> hashMap = new HashMap<>();
            o5(arrayList2, hashMap);
            intent.putExtra(PeakConstants.PHOTO_INFOS, hashMap);
        }
        intent.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, G().getStringExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME));
        intent.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, G().getStringExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME));
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", G().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"));
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", G().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
        intent.putExtra("PhotoConst.PLUGIN_NAME", G().getStringExtra("PhotoConst.PLUGIN_NAME"));
        intent.putExtra("PhotoConst.PLUGIN_APK", G().getStringExtra("PhotoConst.PLUGIN_APK"));
        intent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", G().getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false));
        intent.setFlags(603979776);
        W(intent, 28);
    }

    private boolean r5(String str, String str2) {
        return com.qzone.album.util.i.a(str).equals(com.qzone.album.util.i.a(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t5(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (r5(it.next(), str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u5(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.size() != arrayList2.size()) {
            k5(arrayList);
            RFWLog.d("QZoneWatermark", RFWLog.USR, "batchDownloadPhoto by watermarkManger return not equal,originSize:", Integer.valueOf(arrayList.size()), ",outputSize:", Integer.valueOf(arrayList2.size()));
        } else {
            RFWLog.d("QZoneWatermark", RFWLog.USR, "batchDownloadPhoto by watermarkManger,size:", Integer.valueOf(arrayList2.size()));
            k5(arrayList2);
        }
    }

    private boolean v5() {
        if (QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_C2C_AIO_ENABLE_SYNC_IMAGE_TO_QZONE, 1) == 0) {
            return false;
        }
        int i3 = this.I2;
        return i3 == 0 || i3 == 1000 || i3 == 1004;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, x4.a
    public boolean A() {
        return this.H2 && QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDART_KEY_PHOTOLIST_NEED_SHOW_ALL_SELECT, 1) == 1;
    }

    boolean A5(NetImageInfo netImageInfo) {
        String str;
        int indexOf = this.G0.indexOf(netImageInfo);
        if (indexOf != -1) {
            this.G0.remove(indexOf);
        }
        boolean z16 = indexOf != -1;
        if (z16) {
            if (r5(this.F0.get(indexOf), netImageInfo.getBigPath())) {
                this.F0.remove(indexOf);
            } else {
                C5(netImageInfo.getBigPath(), this.F0);
            }
            this.I0 = true;
            if (this.G0.size() == 0 && this.F0.size() == 0) {
                this.N2.setVisibility(8);
                this.O2.setVisibility(8);
            }
            this.E0.remove(Integer.valueOf(netImageInfo.index));
            com.qzone.album.env.common.a m3 = com.qzone.album.env.common.a.m();
            Object[] objArr = new Object[4];
            objArr[0] = "[removeSelected] imageInfo.BigPath:";
            objArr[1] = netImageInfo.getBigPath();
            objArr[2] = " sendParams:";
            PhotoSendParams photoSendParams = netImageInfo.sendParams;
            if (photoSendParams != null) {
                str = photoSendParams.toString();
            } else {
                str = "";
            }
            objArr[3] = str;
            m3.b("[PhotoAlbum]aioSendPhotos", objArr);
            PhotoCacheData Z1 = Z1(this.f43000u0, netImageInfo.index, false);
            if (Z1 != null) {
                Z1.isChecked = false;
            }
            if (B1() != null) {
                B1().notifyDataSetChanged();
            }
            w5();
            h5(false);
            if (this.H2) {
                LpReportInfo_pf00064.allReport(96, 3, 2);
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void C3(Intent intent) {
        super.C3(intent);
        this.F0 = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        int intExtra = intent.getIntExtra("_input_max", -1);
        this.J0 = intExtra;
        this.D2 = intExtra;
        this.H2 = intent.getBooleanExtra(PeakConstants.QZONE_ALBUM_FROM_AIO, false);
        this.f42975l2 = intent.getBooleanExtra(PeakConstants.IS_JUMPTO_TROOP_ALBUM, false);
        this.I2 = intent.getIntExtra("uintype", -1);
        this.J2 = intent.getStringExtra("uin");
        this.Q2 = intent.getIntExtra(PeakConstants.KEY_SHOW_TYPE, 0);
        if (this.F0 == null) {
            this.F0 = new ArrayList<>(1);
        }
        ArrayList<NetImageInfo> arrayListFromBundle = ParcelableWrapper.getArrayListFromBundle(intent.getExtras(), QZoneContant.INPUT_IMAGES);
        if (arrayListFromBundle != null && arrayListFromBundle.size() > 0) {
            g5(arrayListFromBundle);
        }
        this.f42950d1 = true;
        this.C0 = intent.getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
        this.F2 = intent.getIntExtra(PeakConstants.SAVE_OPERATION, 0);
        this.G2 = intent.getBooleanExtra(QZoneHelper.Constants.KEY_IS_FILTER_VIDEO, false);
        if (intent.getBooleanExtra(QZoneHelper.Constants.KEY_IS_FROM_MAKE_BLOG, false)) {
            int i3 = BasePhotoModelController.B2;
            this.J0 = i3;
            this.D2 = i3;
            this.J0 -= intent.getIntExtra(QZoneHelper.QZoneAlbumConstants.HAS_SELECT_SIZE, i3);
        }
        com.qzone.album.env.common.a.m().b("[PhotoAlbum]p2vMakeBlog", "mCurrentQualityType:", Integer.valueOf(this.C0), " mOperation:", Integer.valueOf(this.F2), " isFilterVideo:", Boolean.valueOf(this.G2), " maxSelectCount:", Integer.valueOf(this.J0), " INIT_MAX_SELECT_COUNT:", Integer.valueOf(this.D2), " isFromAIO:", Boolean.valueOf(this.H2), " isC2C:", Boolean.valueOf(this.f42975l2), " curType:", Integer.valueOf(this.I2), " friendUin:", this.J2, " mSelectPhotoListFromQQAndQzone size:", Integer.valueOf(this.F0.size()));
    }

    public void F5() {
        if (this.F0 == null) {
            com.qzone.album.env.common.a.m().e("[PhotoAlbum]aioSendPhotos", "mSelectPhotoListFromQQAndQzone == null");
            return;
        }
        for (int i3 = 0; i3 < this.f43003v0.size(); i3++) {
            if (!TextUtils.isEmpty(this.f43003v0.get(i3).getBigUrl())) {
                if (p5(this.f43003v0.get(i3).getBigUrl()) != -1) {
                    this.f43003v0.get(i3).isChecked = true;
                } else {
                    this.f43003v0.get(i3).isChecked = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void J2() {
        super.J2();
        Resources resources = getResources();
        if (resources != null) {
            this.N1 = resources.getDimensionPixelSize(R.dimen.f159098w6);
        }
        this.T2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AIOSendNoMd5", "\u65e0\u6cd5\u53d1\u9001\u8be5\u7167\u7247\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5\u3002");
        this.U2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AIOCancelC2CQzone", "\u53d1\u9001\u7a7a\u95f4\u7167\u7247\uff0c\u5df2\u4e3a\u4f60\u53d6\u6d88\u52fe\u9009\u540c\u6b65\u7a7a\u95f4");
        this.V2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AIOCancelC2CQun", "\u53d1\u9001\u7a7a\u95f4\u7167\u7247\uff0c\u5df2\u4e3a\u4f60\u53d6\u6d88\u52fe\u9009\u4e0a\u4f20\u5230\u7fa4\u76f8\u518c");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void K2() {
        super.K2();
        super.V3(QZoneAlbumUtil.v(this.f42940a0, this, P2()));
        ((com.qzone.album.business.photolist.adapter.a) B1()).D(this.X2);
        ((com.qzone.album.business.photolist.adapter.a) B1()).B(!P2());
        ((com.qzone.album.business.photolist.adapter.a) B1()).y(true);
        ((com.qzone.album.business.photolist.adapter.a) B1()).A(V2(this.f42970k0));
        O2(true);
        this.W1.getListView().j0().setAdapter((ListAdapter) B1());
        this.W1.getListView().setSupportPullUp(true);
        E4();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.a
    public boolean M(Activity activity) {
        if (this.F2 == 1) {
            G5(false);
        } else {
            P3(false);
        }
        return false;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.a
    public void N(Activity activity) {
        super.N(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void N2() {
        super.N2();
        this.E2.findViewById(R.id.f166672ha0).setVisibility(8);
        this.E2.findViewById(R.id.h_w).setVisibility(8);
        this.E2.findViewById(R.id.f166673ha1).setVisibility(8);
        this.W1.x().setOnClickListener(new j());
        this.W1.u().setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public int O1() {
        return Math.min(super.O1(), this.D2);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public boolean O2(boolean z16) {
        j0(z16);
        super.O2(z16);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public boolean V2(int i3) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void g1() {
        super.g1();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public boolean g3(PhotoCacheData photoCacheData) {
        return p5(photoCacheData.getBigUrl()) != -1;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected ArrayList<String> h2() {
        return com.qzone.album.util.a.b(this.F0, this.G0, this.T);
    }

    protected void h5(boolean z16) {
        if (this.f42949d0) {
            return;
        }
        int size = this.G0.size();
        if (size > 0) {
            this.K2.setNumColumns(size);
            ViewGroup.LayoutParams layoutParams = this.K2.getLayoutParams();
            layoutParams.width = (int) (((this.G0.size() * 40) + ((this.G0.size() - 1) * 10) + 10) * com.qzone.album.env.common.a.m().q());
            this.K2.setLayoutParams(layoutParams);
            if (z16) {
                this.S2.sendEmptyMessageDelayed(0, 200L);
            }
        }
        aa aaVar = this.L2;
        if (aaVar != null) {
            aaVar.notifyDataSetChanged();
        }
    }

    protected boolean j5() {
        if (this.J0 < 0 || this.F0.size() < this.J0) {
            return true;
        }
        com.qzone.album.env.common.a.m().V(String.format(I(R.string.gr5), Integer.valueOf(this.D2)));
        return false;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, x4.a
    public View.OnClickListener n(s4.d dVar) {
        return new m(dVar);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void n3(boolean z16) {
        HdAsync.with(this).then(new f(com.qzone.album.env.common.a.m().u().getLooper())).then(new e(Looper.getMainLooper(), z16)).call();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void q1() {
        View inflate = getLayoutInflater().inflate(R.layout.bo6, (ViewGroup) null, false);
        this.E2 = inflate;
        this.Q.setContentView(inflate);
        N2();
        K2();
        q5();
    }

    protected void q5() {
        this.M1 = this.Q.findViewById(R.id.abs);
        this.M2 = (HorizontalScrollView) this.Q.findViewById(R.id.ii_);
        this.N2 = (TextView) this.Q.findViewById(R.id.k6q);
        this.O2 = (TextView) this.Q.findViewById(R.id.ad9);
        this.P2 = (TextView) this.Q.findViewById(R.id.dg7);
        if (this.M1.getVisibility() != 0) {
            this.M1.setVisibility(0);
        }
        w5();
        if (!this.f42949d0) {
            this.K2 = (GridView) this.Q.findViewById(R.id.imh);
            aa aaVar = new aa(this.G0, this.Q);
            this.L2 = aaVar;
            this.K2.setAdapter((ListAdapter) aaVar);
            h5(true);
            this.K2.setOnItemClickListener(new g());
        }
        if (this.H2) {
            this.M2.setVisibility(8);
        }
        if (this.Q2 == 1) {
            this.P2.setVisibility(0);
        }
        this.N2.setOnClickListener(new h());
        this.O2.setOnClickListener(new i());
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, x4.a
    public View.OnClickListener s(int i3, int i16, String str, PhotoCacheData photoCacheData, s4.d dVar) {
        return new l(i3, i16, str, photoCacheData, dVar);
    }

    public boolean s5(NetImageInfo netImageInfo) {
        return this.G0.contains(netImageInfo);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void t1() {
        if (!FeedGlobalEnv.g().isNetworkAvailable(null)) {
            com.qzone.album.env.common.a.m().V(I(R.string.ci5));
            return;
        }
        if (this.G0.size() <= 0) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        Iterator<NetImageInfo> it = this.G0.iterator();
        while (it.hasNext()) {
            NetImageInfo next = it.next();
            if (!TextUtils.isEmpty(next.getBigPath())) {
                arrayList.add(next.getBigPath());
            }
        }
        if (arrayList.size() == 0) {
            com.qzone.album.env.common.a.m().U(R.string.gkh);
            return;
        }
        s4(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoSaving", "\u6b63\u5728\u4fdd\u5b58"));
        if (oo.b.j()) {
            oo.b.f(null, 2, arrayList, new b.InterfaceC10931b() { // from class: com.qzone.album.business.photolist.controller.c
                @Override // oo.b.InterfaceC10931b
                public final void a(ArrayList arrayList2) {
                    MultipleModelController.this.u5(arrayList, arrayList2);
                }
            });
        } else {
            k5(arrayList);
        }
    }

    protected void w5() {
        String format;
        int size = this.F0.size();
        if (size > 0) {
            if (this.H2) {
                this.N2.setVisibility(0);
                format = String.format(getResources().getString(R.string.f170778a90), Integer.valueOf(size));
                this.O2.setVisibility(0);
            } else if (this.Q2 == 1) {
                String format2 = String.format(getResources().getString(R.string.f170779a91), Integer.valueOf(size));
                if (size >= 3) {
                    this.N2.setVisibility(0);
                    this.O2.setVisibility(0);
                } else {
                    this.N2.setVisibility(8);
                    this.O2.setVisibility(8);
                }
                format = format2;
            } else {
                format = String.format(getResources().getString(R.string.a8z), Integer.valueOf(size));
                this.N2.setVisibility(0);
                this.O2.setVisibility(0);
            }
            H5(format);
            return;
        }
        if (this.H2) {
            H5(I(R.string.gi9));
        } else if (this.Q2 == 1) {
            H5(I(R.string.cuc));
        } else {
            H5(I(R.string.gi8));
        }
        this.N2.setVisibility(8);
        this.O2.setVisibility(8);
    }

    public void x5(View view) {
        NetImageInfo create;
        boolean f56;
        boolean z16;
        if (view.getTag() == null) {
            QZLog.w("[PhotoAlbum] MultipleModelController", "onImageClick o == null");
            return;
        }
        int intValue = ((Integer) view.getTag()).intValue();
        PhotoCacheData Z1 = Z1(this.f43000u0, intValue, false);
        if (Z1 == null || (create = NetImageInfo.create(Z1, this.H2)) == null) {
            return;
        }
        create.index = intValue;
        if (s5(create)) {
            z16 = A5(create);
            if (z16) {
                Z1.isChecked = false;
            }
        } else {
            if (this.H2) {
                f56 = y5(Z1, create);
            } else {
                f56 = f5(create);
            }
            if (f56) {
                Z1.isChecked = true;
            } else if (view instanceof NumberCheckBox) {
                ((NumberCheckBox) view).setChecked(false);
            }
            z16 = f56;
        }
        if (!z16 || B1() == null) {
            return;
        }
        B1().notifyDataSetChanged();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, x4.a
    public View.OnClickListener z(int i3, int i16, String str, PhotoCacheData photoCacheData, s4.d dVar) {
        return new k(i3, i16, str, photoCacheData, dVar);
    }

    public void z5() {
        PhotoCacheData Z1;
        com.qzone.album.env.common.a.m().b("[PhotoAlbum]aioSendPhotos", "preGetMd5WhenIdle start...");
        if (this.W1.getListView() == null) {
            com.qzone.album.env.common.a.m().b("[PhotoAlbum]aioSendPhotos", "mPersonalPhotoListView.getListView() == null");
            return;
        }
        int firstVisiblePosition = getListView().getFirstVisiblePosition();
        int lastVisiblePosition = getListView().getLastVisiblePosition();
        QZonePullToRefreshListView listView = getListView();
        ArrayList<String> arrayList = new ArrayList<>(1);
        int i3 = lastVisiblePosition - firstVisiblePosition;
        for (int i16 = 0; i16 <= i3; i16++) {
            View childAt = listView.getChildAt(i16);
            if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof u.b)) {
                u.b bVar = (u.b) childAt.getTag();
                int i17 = 0;
                while (true) {
                    PhotoView[] photoViewArr = bVar.f42763b;
                    if (i17 < photoViewArr.length) {
                        PhotoView photoView = photoViewArr[i17];
                        if (photoView != null && photoView.getVisibility() == 0 && (Z1 = Z1(this.f43000u0, ((Integer) photoView.getTag()).intValue(), false)) != null && !Z1.isFakePhoto() && !SharpPUtils.isSharpP(Z1.getBigUrl()) && !this.Y2.containsKey(com.qzone.album.util.i.a(Z1.getBigUrl()))) {
                            arrayList.add(Z1.getBigUrl());
                        }
                        i17++;
                    }
                }
            }
        }
        com.qzone.album.env.common.a.m().b("[PhotoAlbum]aioSendPhotos", "first:", Integer.valueOf(firstVisiblePosition), " last:", Integer.valueOf(lastVisiblePosition), " query size:", Integer.valueOf(arrayList.size()));
        if (arrayList.size() != 0) {
            com.qzone.album.base.Service.a.W().r(this.S.longValue(), this.T, arrayList, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D5(String str) {
        E5(str, 1);
    }

    private int p5(String str) {
        for (int i3 = 0; i3 < this.F0.size(); i3++) {
            if (com.qzone.album.util.i.a(this.F0.get(i3)).equals(com.qzone.album.util.i.a(str))) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void o1() {
        n3(true);
        X();
    }

    private void o5(ArrayList<NetImageInfo> arrayList, HashMap<String, PicInfo> hashMap) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<NetImageInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            NetImageInfo next = it.next();
            PicInfo picInfo = new PicInfo();
            picInfo.albumid = next.mAlbumId;
            picInfo.pictype = next.type;
            String str = next.lloc;
            picInfo.sloc = str;
            picInfo.pictureid = str;
            picInfo.pic_url = next.getSmallPath();
            picInfo.picwidth = next.width;
            picInfo.picheight = next.height;
            hashMap.put(next.getBigPath(), picInfo);
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void B2(QZoneAlbumLayerSelectPhotoEvent qZoneAlbumLayerSelectPhotoEvent) {
        boolean f56;
        if (qZoneAlbumLayerSelectPhotoEvent == null || this.f43003v0 == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f43003v0.size(); i3++) {
            PhotoCacheData photoCacheData = this.f43003v0.get(i3);
            if (photoCacheData.lloc.equals(qZoneAlbumLayerSelectPhotoEvent.getLloc())) {
                NetImageInfo create = NetImageInfo.create(photoCacheData, this.H2);
                if (create == null) {
                    return;
                }
                boolean s56 = s5(create);
                com.qzone.album.env.common.a.m().b("[PhotoAlbum]aioSendPhotos", "[handlePhotoSelectStatusChange] idx: " + i3 + ", isSelected: " + s56 + ", lloc: " + photoCacheData.lloc + ", url: " + create.getBigPath());
                if (s56) {
                    f56 = A5(create);
                    if (f56) {
                        photoCacheData.isChecked = false;
                    }
                } else {
                    if (this.H2) {
                        f56 = y5(photoCacheData, create);
                    } else {
                        f56 = f5(create);
                    }
                    if (f56) {
                        photoCacheData.isChecked = true;
                    }
                }
                if (f56) {
                    F5();
                    w5();
                    h5(false);
                    if (B1() != null) {
                        B1().notifyDataSetChanged();
                        return;
                    }
                    return;
                }
            }
        }
        if (!qZoneAlbumLayerSelectPhotoEvent.getIsSelected()) {
            Iterator<NetImageInfo> it = this.G0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                NetImageInfo next = it.next();
                if (next.lloc.equals(qZoneAlbumLayerSelectPhotoEvent.getLloc())) {
                    A5(next);
                    this.R2.put(next.lloc, next);
                    break;
                }
            }
        } else if (this.R2.containsKey(qZoneAlbumLayerSelectPhotoEvent.getLloc())) {
            f5(this.R2.get(qZoneAlbumLayerSelectPhotoEvent.getLloc()));
        } else {
            com.qzone.album.env.common.a.m().e("[PhotoAlbum]aioSendPhotos", "[handlePhotoSelectStatusChange] cannot find image in deletedOtherAlbumImages, need check data, the lloc is " + qZoneAlbumLayerSelectPhotoEvent.getLloc());
        }
        F5();
    }

    protected void H5(String str) {
        TextView textView;
        if (str == null || str.trim().equals("") || (textView = this.N2) == null) {
            return;
        }
        textView.setText(str);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void P1(Map<Integer, String> map) {
        if (this.f43010y0 != null) {
            Z(2);
            this.W1.t();
            if (!this.H2) {
                this.f43010y0.i0(this.S.longValue(), this.T, this.f42985p0, this.f42991r0, this.f42988q0, null, this.f42989q1, this.f42971k1, this.f42940a0, this.f42950d1, this.f42996s2, this.G2);
            } else {
                this.f43010y0.h0(this.S.longValue(), this.T, this.f42985p0, this.f42991r0, this.f42988q0, null, this.f42989q1, this.f42971k1, this.f42940a0, this.f42950d1, this.f42996s2, 3, this.H2);
            }
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void c4(ArrayList<String> arrayList) {
        boolean f56;
        for (int i3 = 0; i3 < this.f43003v0.size(); i3++) {
            this.f43003v0.get(i3).isChecked = false;
        }
        Iterator<NetImageInfo> it = this.G0.iterator();
        while (it.hasNext()) {
            NetImageInfo next = it.next();
            if (next.mAlbumId.equals(this.T)) {
                it.remove();
                B5(next);
            }
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        boolean z16 = false;
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            for (int i17 = 0; i17 < this.f43003v0.size(); i17++) {
                if (this.f43003v0.get(i17).lloc.equals(arrayList.get(i16))) {
                    PhotoCacheData photoCacheData = this.f43003v0.get(i17);
                    NetImageInfo create = NetImageInfo.create(photoCacheData, this.H2);
                    if (create == null) {
                        return;
                    }
                    if (s5(create)) {
                        f56 = A5(create);
                        if (f56) {
                            photoCacheData.isChecked = false;
                        }
                    } else {
                        if (this.H2) {
                            f56 = y5(photoCacheData, create);
                        } else {
                            f56 = f5(create);
                        }
                        if (f56) {
                            photoCacheData.isChecked = true;
                        }
                    }
                    z16 = f56;
                }
            }
        }
        if (z16) {
            if (B1() != null) {
                B1().notifyDataSetChanged();
            }
            w5();
            h5(false);
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void l1() {
        if (this.f42962h1) {
            w2();
            return;
        }
        if (com.qzone.album.base.b.a(BasePhotoModelController.I1(this.S.longValue(), this.T, this.f42955f0))) {
            I3();
            if (!this.H2) {
                this.f43010y0.i0(this.S.longValue(), this.T, this.f42985p0, this.f42991r0, this.f42988q0, null, this.f42989q1, this.f42971k1, this.f42940a0, this.f42950d1, this.f42996s2, this.G2);
            } else {
                this.f43010y0.h0(this.S.longValue(), this.T, this.f42985p0, this.f42991r0, this.f42988q0, null, this.f42989q1, this.f42971k1, this.f42940a0, this.f42950d1, this.f42996s2, 3, this.H2);
            }
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void r1() {
        I3();
        if (!this.H2) {
            this.f43010y0.v1(this.S.longValue(), this.T, this.f42985p0, null, this.f42989q1, this.f42950d1 ? this.f42971k1 : null, this.f42940a0, this.f42991r0, this.U0, this.f42993r2, this.G2);
        } else {
            this.f43010y0.s1(this.S.longValue(), this.T, this.f42985p0, null, this.f42989q1, this.f42950d1 ? this.f42971k1 : null, this.f42940a0, this.f42991r0, this.U0, this.f42993r2, 3, this.H2);
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void y3(AbsListView absListView, int i3) {
        if (i3 != 0) {
            if (this.H2) {
                com.qzone.album.env.common.a.m().O(this.W2);
            }
        } else if (this.H2) {
            com.qzone.album.env.common.a.m().I(this.W2, 200L);
        }
    }

    private boolean g5(ArrayList<NetImageInfo> arrayList) {
        NetImageInfo next;
        boolean z16 = false;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<NetImageInfo> it = arrayList.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                if (!this.G0.contains(next)) {
                    z16 = this.G0.add(next);
                }
            }
        }
        return z16;
    }

    protected boolean f5(NetImageInfo netImageInfo) {
        String str;
        if (netImageInfo == null || !j5() || this.G0.contains(netImageInfo)) {
            return false;
        }
        boolean add = this.G0.add(netImageInfo);
        this.E0.add(Integer.valueOf(netImageInfo.index));
        if (add) {
            this.F0.add(netImageInfo.getBigPath());
            com.qzone.album.env.common.a m3 = com.qzone.album.env.common.a.m();
            Object[] objArr = new Object[4];
            objArr[0] = "[addSelected] imageInfo.BigPath:";
            objArr[1] = netImageInfo.getBigPath();
            objArr[2] = " sendParams:";
            PhotoSendParams photoSendParams = netImageInfo.sendParams;
            if (photoSendParams != null) {
                str = photoSendParams.toString();
            } else {
                str = "";
            }
            objArr[3] = str;
            m3.b("[PhotoAlbum]aioSendPhotos", objArr);
            this.I0 = true;
            if (this.M1.getVisibility() != 0 && !this.f42950d1) {
                this.M1.setVisibility(0);
            }
            w5();
            h5(true);
            NetImageInfo.onPicSelectPreSend(G(), netImageInfo.sendParams);
            i5();
            if (this.H2) {
                LpReportInfo_pf00064.allReport(96, 3, 1);
            }
        }
        return add;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C5(String str, List<String> list) {
        if (list == null) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (r5(list.get(i3), str)) {
                list.remove(i3);
                return;
            }
        }
    }

    private boolean y5(PhotoCacheData photoCacheData, NetImageInfo netImageInfo) {
        if (netImageInfo != null && j5() && !this.G0.contains(netImageInfo)) {
            if (SharpPUtils.isSharpP(netImageInfo.getBigPath())) {
                com.qzone.album.env.common.a.m().W(this.T2, 4);
                com.qzone.album.env.common.a.m().e("[PhotoAlbum]aioSendPhotos", "url is sharpp");
                return false;
            }
            PhotoSendParams photoSendParams = netImageInfo.sendParams;
            if (photoSendParams != null && TextUtils.isEmpty(photoSendParams.thumbPath)) {
                com.qzone.album.env.common.a.m().W(this.T2, 4);
                com.qzone.album.env.common.a.m().e("[PhotoAlbum]aioSendPhotos", "thumbPath is null");
                return false;
            }
            PhotoSendParams photoSendParams2 = netImageInfo.sendParams;
            if (photoSendParams2 != null && TextUtils.isEmpty(photoSendParams2.rawMd5)) {
                PicContInfoCacheData picContInfoCacheData = this.Y2.get(com.qzone.album.util.i.a(netImageInfo.getBigPath()));
                if (picContInfoCacheData != null && !TextUtils.isEmpty(picContInfoCacheData.md5)) {
                    PhotoSendParams photoSendParams3 = netImageInfo.sendParams;
                    photoSendParams3.rawMd5 = picContInfoCacheData.md5;
                    photoSendParams3.fileSize = picContInfoCacheData.size;
                    com.qzone.album.env.common.a.m().b("[PhotoAlbum]aioSendPhotos", "preAddSelected | the map hit md5 md5:", picContInfoCacheData.md5, " fileSize:", Long.valueOf(picContInfoCacheData.size), " url:", picContInfoCacheData.url);
                    D5("hitSuccess");
                } else {
                    com.qzone.album.env.common.a.m().b("[PhotoAlbum]aioSendPhotos", "preAddSelected | the map has not hit md5");
                    D5("hitFailure");
                }
            } else {
                D5("hasMd5");
            }
            PhotoSendParams photoSendParams4 = netImageInfo.sendParams;
            if (photoSendParams4 != null && TextUtils.isEmpty(photoSendParams4.rawMd5)) {
                com.qzone.album.env.common.a.m().b("[PhotoAlbum]aioSendPhotos", "query md5...");
                this.Z2.postDelayed(this.f43097a3, 100L);
                ArrayList<String> arrayList = new ArrayList<>(1);
                arrayList.add(netImageInfo.getBigPath());
                com.qzone.album.env.common.a.m().b("[PhotoAlbum]aioSendPhotos", "[request] list:", arrayList.toString());
                com.qzone.album.base.Service.a.W().r(this.S.longValue(), this.T, arrayList, new c(netImageInfo, photoCacheData));
                return false;
            }
            com.qzone.album.env.common.a.m().b("[PhotoAlbum]aioSendPhotos", "preAddSelected | md5 is not null");
            return f5(netImageInfo);
        }
        com.qzone.album.env.common.a.m().e("[PhotoAlbum]aioSendPhotos", "preAddSelected | imageInfo == null || !checkSelectedCount() || mSelectedImages.contains(imageInfo)");
        return false;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.a
    public void R(Activity activity, int i3, int i16, Intent intent) {
        if (i3 == 28) {
            if (intent == null && i16 == -1) {
                this.Q.setResult(100001);
                x1();
                QAlbumUtil.anim(this.Q, true, false);
                return;
            }
            if (intent == null) {
                return;
            }
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            int intExtra = intent.getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
            if (this.C0 != intExtra) {
                this.C0 = intExtra;
                this.I0 = true;
            }
            this.F0.removeAll(stringArrayListExtra);
            for (int i17 = 0; i17 < this.F0.size(); i17++) {
                Iterator<NetImageInfo> it = this.G0.iterator();
                while (it.hasNext()) {
                    NetImageInfo next = it.next();
                    if (com.qzone.album.util.i.a(this.F0.get(i17)).equals(com.qzone.album.util.i.a(next.getBigPath()))) {
                        this.E0.remove(Integer.valueOf(next.index));
                        it.remove();
                    }
                }
            }
            this.F0 = stringArrayListExtra;
            this.I0 = true;
            F5();
            w5();
            B1().notifyDataSetChanged();
        } else if (i3 == 1207) {
            if (i16 == -1) {
                c4(intent.getStringArrayListExtra(PictureConst.KEY_SELECTED_PHOTO_LLOC));
                return;
            }
            return;
        }
        super.R(activity, i3, i16, intent);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void v2() {
    }
}
