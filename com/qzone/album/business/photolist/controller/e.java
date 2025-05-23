package com.qzone.album.business.photolist.controller;

import NS_MOBILE_PHOTO.PhotoSearchBoxChosenItem;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.fragment.app.FragmentActivity;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.business.downloader.DownloadQueue;
import com.qzone.album.business.photolist.adapter.a;
import com.qzone.album.business.search.SearchFilterComposition;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.AlbumDataOutShare;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.protocol.QZoneGetPhotoSearchRequest;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.util.l;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.AbsListView;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import u4.h;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e extends AbsViewerModeController {

    /* renamed from: c3, reason: collision with root package name */
    private SearchFilterComposition f43250c3;

    /* renamed from: d3, reason: collision with root package name */
    private String f43251d3;

    /* renamed from: e3, reason: collision with root package name */
    private int f43252e3;

    /* renamed from: f3, reason: collision with root package name */
    private com.qzone.album.business.photolist.ui.header.a f43253f3;

    /* renamed from: g3, reason: collision with root package name */
    private boolean f43254g3;

    /* renamed from: h3, reason: collision with root package name */
    private a.f f43255h3;
    private a.f i3;
    protected com.qzone.album.business.photolist.ui.interactingbar.d j3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f43256a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Looper looper, boolean z16) {
            super(looper);
            this.f43256a = z16;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            e.this.E3(obj, Boolean.valueOf(this.f43256a), e.this.f43008x0);
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f43258a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Looper looper, boolean z16) {
            super(looper);
            this.f43258a = z16;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            e eVar = e.this;
            if (eVar.f43010y0 != null && !TextUtils.isEmpty(eVar.T)) {
                e eVar2 = e.this;
                if (eVar2.f43008x0 == null) {
                    eVar2.f43008x0 = eVar2.f43012z0.x(eVar2.S.longValue(), e.this.T);
                }
                e eVar3 = e.this;
                if (eVar3.f43008x0 == null) {
                    com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[loadDataFromCache] failed to load AlbumCacheData");
                    return doNext(false);
                }
                ArrayList<PhotoCacheData> E = !this.f43258a ? eVar3.f43012z0.E(eVar3.T) : null;
                if (e.this.f43008x0 != null) {
                    com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[loadDataFromCache] load album cache data suc, go next");
                    return doNext(true, E);
                }
            }
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements AbsListView.OnScrollListener {
        c() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            e.this.A6(absListView, i3, i16, i17);
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            e.this.B6(absListView, i3);
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.album.business.photolist.controller.e$e, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0338e implements a.f {
        C0338e() {
        }

        @Override // com.qzone.album.business.photolist.adapter.a.f
        public void onClick(View view) {
            if (e.this.f42970k0 != 0) {
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            e eVar = e.this;
            PhotoCacheData Z1 = eVar.Z1(eVar.f43000u0, intValue, false);
            if (Z1 == null) {
                return;
            }
            LpReportInfo_pf00064.allReport(86, 2, e.this.c2());
            e.this.q6(6);
            if (!e.this.P2() || !Z1.isVideo()) {
                e.this.b4(Z1, intValue, true);
            }
            e.this.J4();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f extends com.qzone.album.business.photolist.ui.interactingbar.d {
        f() {
        }

        @Override // com.qzone.album.business.photolist.ui.interactingbar.a.InterfaceC0344a
        public void b(View view, boolean z16) {
            e eVar = e.this;
            eVar.M0.j(eVar.g());
        }

        @Override // com.qzone.album.business.photolist.ui.interactingbar.a.InterfaceC0344a
        public void c(View view) {
            e.this.C5(view, false);
            com.qzone.album.env.common.a.m().P(95, 3, "1", true, "");
        }

        @Override // com.qzone.album.business.photolist.ui.interactingbar.a.InterfaceC0344a
        public void h(View view) {
            e.this.q6(6);
            e.this.J4();
            com.qzone.album.env.common.a.m().P(95, 2, "1", true, "");
        }
    }

    public e(FragmentActivity fragmentActivity, h hVar) {
        super(fragmentActivity, hVar);
        this.f43251d3 = "";
        this.f43254g3 = true;
        this.f43255h3 = new d();
        this.i3 = new C0338e();
        this.j3 = new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B6(AbsListView absListView, int i3) {
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
            m0();
        }
        u4.a.z().n0();
        com.qzone.album.env.common.a.m().Y("qzone_album_second_page", false);
    }

    private void E6() {
        if (z6()) {
            long longValue = this.S.longValue();
            String str = this.T;
            SearchFilterComposition searchFilterComposition = this.f43250c3;
            ArrayList<Integer> arrayList = searchFilterComposition.typesSeq;
            HashMap<Integer, PhotoSearchBoxChosenItem> chosenItemMap = searchFilterComposition.toChosenItemMap();
            this.f42988q0 = null;
            com.qzone.album.base.Service.a aVar = this.f43010y0;
            if (aVar != null) {
                aVar.l1(longValue, str, arrayList, chosenItemMap, null, this.f42993r2);
            }
        }
    }

    private void F6() {
        if (((com.qzone.album.business.photolist.adapter.a) B1()) == null) {
            return;
        }
        W3(this.f43003v0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n6() {
        SearchFilterComposition searchFilterComposition;
        List<PhotoCacheData> list;
        if (this.Q == null || this.f43008x0 == null || (searchFilterComposition = this.f43250c3) == null || !searchFilterComposition.isDataValid() || (list = this.f43003v0) == null || list.isEmpty()) {
            return false;
        }
        return (this.f42994s0 && TextUtils.isEmpty(this.f42988q0)) ? false : true;
    }

    private void p6() {
        h hVar = this.W1;
        if (hVar == null) {
            return;
        }
        hVar.getListView().setOnScrollListener(new c());
        ((com.qzone.album.business.photolist.adapter.a) B1()).D(this.f43255h3);
        ((com.qzone.album.business.photolist.adapter.a) B1()).E(this.i3);
    }

    private int r6(s8.b bVar) {
        Object obj;
        if (bVar != null && bVar.b() != null) {
            try {
                Object[] objArr = (Object[]) bVar.b();
                if (objArr.length == 0) {
                    return 0;
                }
                Object obj2 = objArr[0];
                if ((obj2 != null && (obj2 instanceof String) && !((String) obj2).equals(this.T)) || (obj = objArr[1]) == null || !(obj instanceof ArrayList)) {
                    return 0;
                }
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList == null ? 0 : arrayList.size();
                com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[getDecreasedPhotoCount] decreased size = " + size);
                return size;
            } catch (Exception e16) {
                com.qzone.album.env.common.a.m().f("QZoneSearchResultList", "[getDecreasedPhotoCount] error happens -> ", e16);
            }
        }
        return 0;
    }

    private void w6(Activity activity) {
        h hVar = this.W1;
        if (hVar != null && hVar.z2() != null) {
            this.W1.z2().q();
            this.W1.z2().s();
            this.W1.z2().t();
        }
        com.qzone.album.business.photolist.ui.interactingbar.a aVar = new com.qzone.album.business.photolist.ui.interactingbar.a(this.Q, this, this.j3);
        this.J1 = aVar;
        aVar.f(2);
        b6();
    }

    private void x6() {
        com.qzone.album.business.photolist.ui.header.a aVar = new com.qzone.album.business.photolist.ui.header.a(this.Q, this.W1, this.f43250c3);
        this.f43253f3 = aVar;
        aVar.a();
    }

    private void y6() {
        if (z6() && !TextUtils.isEmpty(this.f42988q0)) {
            long longValue = this.S.longValue();
            String str = this.T;
            SearchFilterComposition searchFilterComposition = this.f43250c3;
            ArrayList<Integer> arrayList = searchFilterComposition.typesSeq;
            HashMap<Integer, PhotoSearchBoxChosenItem> chosenItemMap = searchFilterComposition.toChosenItemMap();
            com.qzone.album.base.Service.a aVar = this.f43010y0;
            if (aVar != null) {
                aVar.c0(longValue, str, arrayList, chosenItemMap, this.f42988q0, this.f42996s2, false);
                return;
            }
            return;
        }
        com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[loadMoreAlbumPhotoSearchResult] param check failed! abort load more operation");
    }

    private boolean z6() {
        SearchFilterComposition searchFilterComposition;
        return (TextUtils.isEmpty(this.T) || this.f43008x0 == null || (searchFilterComposition = this.f43250c3) == null || !searchFilterComposition.isDataValid()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void C3(Intent intent) {
        super.C3(intent);
        if (intent == null) {
            return;
        }
        try {
            u6(intent);
        } catch (Exception e16) {
            QZLog.e("QZoneSearchResultList", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void D2(s sVar) {
        com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[handleRefreshPhotoResult]");
        this.W1.y();
        if (sVar == null) {
            l4(false);
            this.f42941a1.l(5);
            com.qzone.album.env.common.a.m().c(QZLog.TO_DEVICE_TAG, "QZoneSearchResultList", "\t result is null");
            return;
        }
        if (sVar.getSucceed()) {
            G2(sVar);
        } else {
            E2(sVar);
        }
        int newCnt = (!sVar.getSucceed() || sVar.getNewCnt() <= 0) ? 0 : (int) sVar.getNewCnt();
        if (!Q2()) {
            O4(newCnt <= 0);
        }
        if (this.f43254g3) {
            com.qzone.album.env.common.a.m().P(95, 1, "", true, String.valueOf(newCnt));
            this.f43254g3 = false;
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void F2() {
        com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[handleResultNoPhoto]");
        this.f42941a1.l(15);
        this.f42941a1.n(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.AbsViewerModeController, com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void G2(s sVar) {
        long newCnt = sVar.getNewCnt();
        com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[handleResultSucceed] searchResultCnt = " + newCnt);
        if (newCnt == 0) {
            F2();
        }
        H6(newCnt);
        G6();
        o4(BasePhotoModelController.I1(this.S.longValue(), this.T, this.f42955f0), sVar.getHasMore());
        C6(sVar);
        if (this.f42994s0 != sVar.getHasMore()) {
            this.f42994s0 = sVar.getHasMore();
            W3(this.f43003v0);
        }
        this.U1 = true;
        D6(sVar);
    }

    public void G6() {
        com.qzone.album.business.photolist.ui.header.a aVar = this.f43253f3;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void H6(long j3) {
        if (this.W1 == null) {
            return;
        }
        if (j3 >= 0) {
            this.f43251d3 = j3 + l.a(R.string.f172668t73);
        } else {
            this.f43251d3 = "";
        }
        i4();
        this.f43252e3 = (int) j3;
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.a
    public void J(s8.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.a())) {
            int c16 = bVar.c();
            String a16 = bVar.a();
            if ("QzoneAlbum".equals(a16)) {
                if (c16 == 4) {
                    int r65 = r6(bVar);
                    if (r65 > 0) {
                        com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[onEventUIThread] EVENT_DELETE_BATCH_PHOTO_SUCCESS size = " + r65);
                        H6((long) (this.f43252e3 - r65));
                    }
                } else if (c16 == 5) {
                    int r66 = r6(bVar);
                    if (r66 > 0) {
                        com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[onEventUIThread] EVENT_MOVE_BATCH_PHOTO_SUCCESS size = " + r66);
                        H6((long) (this.f43252e3 - r66));
                    }
                } else if (c16 != 9) {
                    if (c16 == 30 && bVar.b() != null && (bVar.b() instanceof s)) {
                        s2((s) bVar.b());
                    }
                } else {
                    try {
                        Object[] objArr = (Object[]) bVar.b();
                        if (objArr.length >= 4 && (objArr[0] instanceof Boolean) && (objArr[1] instanceof String) && (objArr[2] instanceof ArrayList) && (objArr[3] instanceof String)) {
                            com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[onEventUIThread] EVENT_EDIT_PHOTO_DESC_RESULT");
                            t6(((Boolean) objArr[0]).booleanValue(), (String) objArr[1], (ArrayList) objArr[2], (String) objArr[3]);
                        }
                    } catch (Exception e16) {
                        com.qzone.album.env.common.a.m().f("QZoneSearchResultList", "[onEventUIThread] failed to parse message -> EVENT_EDIT_PHOTO_DESC_RESULT with exception : ", e16);
                    }
                }
            }
            if (!"WriteOperation".equals(a16)) {
                super.J(bVar);
                return;
            }
            if (c16 != 48) {
                return;
            }
            try {
                if (bVar.b() == null || !(bVar.b() instanceof Object[])) {
                    return;
                }
                Object[] objArr2 = (Object[]) bVar.b();
                if (objArr2.length >= 4 && (objArr2[0] instanceof Boolean) && (objArr2[2] instanceof String) && (objArr2[3] instanceof String) && (objArr2[4] instanceof String)) {
                    com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[onEventUIThread] EVENT_RECENT_PHOTO_COMMENTED_RESULT");
                    R5(((Boolean) objArr2[0]).booleanValue(), (String) objArr2[2], (String) objArr2[3], (String) objArr2[4]);
                    return;
                }
                return;
            } catch (Exception e17) {
                com.qzone.album.env.common.a.m().f("QZoneSearchResultList", "[onEventUIThread] failed to parse message -> EVENT_RECENT_PHOTO_COMMENTED_RESULT with exception : ", e17);
                return;
            }
        }
        com.qzone.album.env.common.a.m().e("QZoneSearchResultList", "[onEventUIThread] CAN`T get event");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void K2() {
        super.K2();
        o6();
        ((com.qzone.album.business.photolist.adapter.a) B1()).B(!P2());
        ((com.qzone.album.business.photolist.adapter.a) B1()).z(this.O0);
        ((com.qzone.album.business.photolist.adapter.a) B1()).E(this.i3);
        p6();
        O2(true);
        x6();
        this.W1.getListView().setAdapter((ListAdapter) B1());
        this.W1.getListView().setSupportPullUp(true);
        this.W1.getListView().setCoverMode(false);
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
        P3(false);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void N2() {
        super.N2();
        h hVar = this.W1;
        if (hVar == null) {
            return;
        }
        if (hVar.x() != null) {
            this.W1.x().setTextColor(-1);
            this.W1.x().setBackgroundResource(R.drawable.b5b);
        }
        if (this.W1.v() != null) {
            this.W1.v().setTextColor(-1);
        }
        if (this.W1.z2() != null) {
            this.W1.z2().q();
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public boolean O2(boolean z16) {
        j0(z16);
        if (this.Q1 == null) {
            LinearLayout linearLayout = new LinearLayout(this.Q);
            this.Q1 = linearLayout;
            linearLayout.setOrientation(1);
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

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.a
    public void R(Activity activity, int i3, int i16, Intent intent) {
        Bundle bundleExtra;
        super.R(activity, i3, i16, intent);
        if (i3 == 29 && i16 == -1 && (bundleExtra = intent.getBundleExtra("extra_key_bundle_within_intent")) != null && bundleExtra.getString("forwardAlbumBundleKeyAlbumId") != null && bundleExtra.getString("forwardAlbumBundleKeyAlbumId").equals(this.T)) {
            this.M0.h(intent.getStringExtra("contentIntentKey"));
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void Z0(boolean z16) {
        if (this.f42970k0 == 3) {
            DownloadQueue.j().f();
        }
        int i3 = this.f42970k0;
        this.f42970k0 = 0;
        this.f42950d1 = false;
        this.f42953e1 = false;
        this.L1 = null;
        if (B1() != null) {
            ((com.qzone.album.business.photolist.adapter.a) B1()).y(false);
            ((com.qzone.album.business.photolist.adapter.a) B1()).B(com.qzone.album.env.common.a.m().s() == this.S.longValue());
            ((com.qzone.album.business.photolist.adapter.a) B1()).E(this.i3);
            ((com.qzone.album.business.photolist.adapter.a) B1()).z(this.O0);
            ((com.qzone.album.business.photolist.adapter.a) B1()).F(this.f42970k0);
        }
        i4();
        Z3();
        d6(z16, i3);
        g1();
        J4();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.b
    public void a0() {
        com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[doGetMore]");
        y6();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, i4.b
    public void c0() {
        if (this.f43010y0 == null || this.f42944b1 != 0) {
            return;
        }
        if (!e1()) {
            com.qzone.album.env.common.a.m().U(R.string.gdc);
        } else {
            com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[doRefresh] network ok, go doRefresh");
            E6();
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void c1(AlbumCacheData albumCacheData) {
        if (B1() == null) {
            return;
        }
        this.W1.notifyAdapter(B1());
        if (B1().getCount() > 0) {
            return;
        }
        if (this.f42970k0 != 0) {
            Z0(false);
        }
        F2();
    }

    @Override // com.qzone.album.business.photolist.controller.AbsViewerModeController
    protected void h5(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (this.f43010y0 != null) {
            com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[doDeleteBatchPhotos]");
            this.f43010y0.B(str, arrayList, arrayList2, this.f42981n2, true);
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void i4() {
        h hVar = this.W1;
        if (hVar == null) {
            return;
        }
        int i3 = this.f42970k0;
        if (i3 == 0) {
            hVar.setTitle(this.f43251d3);
        } else if (i3 == 6) {
            this.W1.setTitle(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumManageBatch", "\u6279\u91cf\u7ba1\u7406"));
        } else {
            super.i4();
        }
    }

    @Override // com.qzone.album.business.photolist.controller.AbsViewerModeController
    protected void k5(String str, ArrayList<String> arrayList) {
        if (this.f43010y0 != null) {
            com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[doMoveBatchPhotos]");
            this.f43010y0.J0(this.T, str, arrayList, this.f42981n2, true);
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
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
            com.qzone.album.env.common.a.m().b("[PhotoAlbum]AlbumPerformance", "QZoneSearchResultList", " showCrossOverView end");
        } else {
            if (!e1() || k3()) {
                return;
            }
            if (this.D1 == null) {
                com.qzone.album.env.common.a.m().c("QZoneSearchResultList", "mNormalLoadingBg == null");
                this.D1 = L1("qzone_photolist_video_loading_guest_pic");
            }
            this.C1.setForeground(this.D1);
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void n3(boolean z16) {
        HdAsync.with(this).then(new b(com.qzone.album.env.common.a.m().u().getLooper(), z16)).then(new a(Looper.getMainLooper(), z16)).call();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void o1() {
        com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[doOnInitData]");
        n3(true);
        X();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void q1() {
        super.q1();
        com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[doOnUI]");
        h hVar = this.W1;
        if (hVar == null) {
            return;
        }
        hVar.j1(R.layout.bo6);
        l4(true);
        N2();
        K2();
        w6(this.Q);
    }

    public void q6(int i3) {
        Y3(i3);
        this.f42970k0 = i3;
        this.f42950d1 = true;
        this.f42953e1 = true;
        this.J0 = BasePhotoModelController.f42939z2;
        ((com.qzone.album.business.photolist.adapter.a) B1()).y(true);
        ((com.qzone.album.business.photolist.adapter.a) B1()).A(V2(this.f42970k0));
        ((com.qzone.album.business.photolist.adapter.a) B1()).B(com.qzone.album.env.common.a.m().s() == this.S.longValue());
        ((com.qzone.album.business.photolist.adapter.a) B1()).z(this.O0);
        ((com.qzone.album.business.photolist.adapter.a) B1()).F(i3);
        F6();
        if (this.H0 == null) {
            this.H0 = new ArrayList();
        } else {
            g1();
        }
        i4();
        Z3();
        if (p2() == 4 && i3()) {
            y0(7);
        }
        f6(i3);
        if (this.W1.z2() != null) {
            this.W1.z2().b();
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController, x4.a
    public View.OnClickListener s(int i3, int i16, String str, PhotoCacheData photoCacheData, s4.d dVar) {
        return new g();
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void s2(s sVar) {
        com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[handleGetMoreResult]");
        super.s2(sVar);
        String str = this.f42988q0;
        if (str == null || TextUtils.isEmpty(str)) {
            str = "empty (null or empty string)";
        }
        com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[handleGetMoreResult] before this paging, attachInfo = " + str);
        C6(sVar);
        this.f42994s0 = sVar.getHasMore();
        com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[handleGetMoreResult] have more pages = " + this.f42994s0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x006f, code lost:
    
        r0 = new java.util.ArrayList();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void v6(List<? extends com.qzone.component.cache.database.a> list, boolean z16) {
        PictureItem pictureItem;
        int i3;
        List<PhotoCacheData> list2;
        int i16 = this.f42970k0;
        ArrayList arrayList = null;
        if (i16 != 2 && i16 != 7) {
            if (i16 != 3 && !this.f42967j0) {
                List<PhotoCacheData> list3 = this.f43003v0;
                if (list3 != null) {
                    for (PhotoCacheData photoCacheData : list3) {
                        if (photoCacheData.isFakePhoto() && photoCacheData.isVideo()) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(photoCacheData);
                        }
                    }
                }
            } else {
                List<PhotoCacheData> list4 = this.f43003v0;
                if (list4 != null) {
                    for (PhotoCacheData photoCacheData2 : list4) {
                        if (photoCacheData2.isFakePhoto() || photoCacheData2.picItem.type == 2 || (photoCacheData2.videoflag == 1 && photoCacheData2.videodata.validVideoTime > ViewerModelController.Q4)) {
                            arrayList.add(photoCacheData2);
                        }
                    }
                }
            }
        } else {
            List<PhotoCacheData> list5 = this.f43003v0;
            if (list5 != null) {
                for (PhotoCacheData photoCacheData3 : list5) {
                    if (photoCacheData3.isFakePhoto() || photoCacheData3.isVideo() || ((pictureItem = photoCacheData3.picItem) != null && ((i3 = pictureItem.flag) == 32 || i3 == 16))) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(photoCacheData3);
                    }
                }
            }
        }
        if ((this.f42970k0 != 0 || this.f42967j0) && arrayList != null && (list2 = this.f43003v0) != null) {
            list2.removeAll(arrayList);
        }
        ((com.qzone.album.business.photolist.adapter.a) B1()).G(this.f42991r0);
        ((com.qzone.album.business.photolist.adapter.a) B1()).C(false);
        List<PhotoCacheData> list6 = this.f43003v0;
        int size = list6 == null ? 0 : list6.size();
        com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[handleLoadDataResult] ready to update photos, photos num = " + size);
        W3(this.f43003v0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    public void x2(List<? extends com.qzone.component.cache.database.a> list, boolean z16, AlbumCacheData albumCacheData) {
        com.qzone.album.business.photolist.ui.interactingbar.a aVar;
        com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[handleLoadDataResult]");
        List<PhotoCacheData[]> list2 = this.f43000u0;
        if (list2 != null) {
            list2.clear();
        }
        if (list != 0) {
            if (B1() != null) {
                this.f43003v0 = list;
                com.qzone.album.env.common.a.m().b("QZoneSearchResultList", "handleLoadDataResult|mPhotos size:", Integer.valueOf(this.f43003v0.size()));
                v6(list, z16);
            }
            I4();
        }
        c1(albumCacheData);
        if (z16) {
            if (list != 0 && list.size() != 0) {
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
            return;
        }
        if (this.f42970k0 != 0 || (aVar = this.J1) == null || aVar == null) {
            return;
        }
        aVar.h(false);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements a.f {
        d() {
        }

        @Override // com.qzone.album.business.photolist.adapter.a.f
        public void onClick(View view) {
            e eVar = e.this;
            if (eVar.B0 && eVar.f42970k0 == 0) {
                eVar.B0 = false;
                int intValue = ((Integer) view.getTag()).intValue();
                e eVar2 = e.this;
                PhotoCacheData Z1 = eVar2.Z1(eVar2.f43000u0, intValue, false);
                if (Z1 != null) {
                    if (!e.this.n6()) {
                        e.this.B0 = true;
                        return;
                    }
                    e eVar3 = e.this;
                    int s65 = eVar3.s6(Z1, eVar3.f43003v0);
                    if (s65 < 0) {
                        e.this.B0 = true;
                        return;
                    }
                    com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", "QZoneSearchResultList", " PhotoPreview start");
                    t4.a N = t4.a.N();
                    e eVar4 = e.this;
                    Activity activity = eVar4.Q;
                    long longValue = eVar4.S.longValue();
                    e eVar5 = e.this;
                    AlbumCacheData albumCacheData = eVar5.f43008x0;
                    SearchFilterComposition searchFilterComposition = eVar5.f43250c3;
                    int i3 = e.this.f43252e3;
                    e eVar6 = e.this;
                    N.C(activity, longValue, albumCacheData, searchFilterComposition, i3, eVar6.f43003v0, s65, eVar6.f42994s0, eVar6.f42988q0);
                    com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "from SearchResult to PhotoPreview");
                    return;
                }
                e.this.B0 = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A6(AbsListView absListView, int i3, int i16, int i17) {
        if (i3 > 0) {
            this.W1.L0(i3);
        }
        F5(absListView, i3, i16, i17);
        this.W1.m0(255);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            e eVar = e.this;
            if (eVar.B0) {
                eVar.B0 = false;
                int intValue = ((Integer) view.getTag()).intValue();
                e eVar2 = e.this;
                PhotoCacheData Z1 = eVar2.Z1(eVar2.f43000u0, intValue, false);
                if (Z1 != null) {
                    if (!e.this.n6()) {
                        e.this.B0 = true;
                    } else {
                        e eVar3 = e.this;
                        int s65 = eVar3.s6(Z1, eVar3.f43003v0);
                        if (s65 < 0) {
                            e.this.B0 = true;
                        } else {
                            com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", "QZoneSearchResultList", " PhotoPreview start");
                            t4.a N = t4.a.N();
                            e eVar4 = e.this;
                            Activity activity = eVar4.Q;
                            long longValue = eVar4.S.longValue();
                            e eVar5 = e.this;
                            AlbumCacheData albumCacheData = eVar5.f43008x0;
                            SearchFilterComposition searchFilterComposition = eVar5.f43250c3;
                            int i3 = e.this.f43252e3;
                            e eVar6 = e.this;
                            N.D(activity, longValue, albumCacheData, searchFilterComposition, i3, eVar6.f43003v0, s65, eVar6.f42994s0, eVar6.f42988q0, 1207, com.qzone.album.util.a.c(eVar6.H0), e.this.O1(), e.this.f42970k0);
                            com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "from SearchResult to PhotoPreview");
                        }
                    }
                } else {
                    e.this.B0 = true;
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void C6(s sVar) {
        if (sVar != null && sVar.getHasMore() && (sVar.getObjectData() instanceof QZoneGetPhotoSearchRequest.a)) {
            String str = ((QZoneGetPhotoSearchRequest.a) sVar.getObjectData()).f43937g;
            this.f42988q0 = str;
            if (str == null || TextUtils.isEmpty(str)) {
                str = "empty (null or empty string)";
            }
            com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[handleGetMoreResult] after this paging, attachInfo = " + str);
        }
    }

    private void D6(s sVar) {
        if (sVar != null && (sVar.getObjectData() instanceof QZoneGetPhotoSearchRequest.a)) {
            AlbumDataOutShare albumDataOutShare = ((QZoneGetPhotoSearchRequest.a) sVar.getObjectData()).f43939i;
            this.N0 = albumDataOutShare;
            AlbumCacheData albumCacheData = this.f43008x0;
            if (albumCacheData == null || albumDataOutShare == null) {
                return;
            }
            this.M0.f(this.P, this.Q, this.f42940a0, this.S0, this.T, albumDataOutShare, albumCacheData, (ArrayList) this.f43003v0, true);
        }
    }

    private void o6() {
        super.V3(QZoneAlbumUtil.u(1, 0, this, null, P2(), this.f42943b0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int s6(PhotoCacheData photoCacheData, List<PhotoCacheData> list) {
        if (photoCacheData != null && !TextUtils.isEmpty(photoCacheData.lloc) && list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                PhotoCacheData photoCacheData2 = list.get(i3);
                if (!TextUtils.isEmpty(photoCacheData2.lloc) && photoCacheData.lloc.equals(photoCacheData2.lloc)) {
                    return i3;
                }
            }
        }
        return -1;
    }

    private void u6(Intent intent) {
        if (intent == null) {
            return;
        }
        this.f43250c3 = SearchFilterComposition.deSerializeMeFromIntent(intent);
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void E2(s sVar) {
        String str;
        if (sVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(sVar.getMessage())) {
            str = sVar.getMessage();
        } else {
            str = "no message";
        }
        com.qzone.album.env.common.a.m().h("QZoneSearchResultList", "[handleResultFailed] message = " + str);
        l4(false);
        this.f42941a1.l(5);
        this.W1.getListView().r0(I(R.string.gm5), sVar.getMessage());
        List<PhotoCacheData> list = this.f43003v0;
        if (list != null && list.size() == 0) {
            com.qzone.album.business.photolist.ui.interactingbar.a aVar = this.J1;
            if (aVar != null) {
                aVar.d(false);
            }
        } else {
            List<PhotoCacheData> list2 = this.f43003v0;
            if (list2 != null && list2.size() > 0) {
                this.W1.g1();
                this.W1.J();
            }
        }
        y0(p2());
        this.U1 = false;
    }

    private void t6(boolean z16, String str, ArrayList<String> arrayList, String str2) {
        List<PhotoCacheData> list;
        if (!z16 || arrayList == null || arrayList.isEmpty() || (list = this.f43003v0) == null || list.size() <= 0) {
            return;
        }
        for (PhotoCacheData photoCacheData : this.f43003v0) {
            if (photoCacheData.lloc.equals(arrayList.get(0))) {
                photoCacheData.desc = str2;
                this.f43012z0.h0(photoCacheData, photoCacheData.lloc, this.T);
            }
        }
    }

    @Override // com.qzone.album.business.photolist.controller.BasePhotoModelController
    protected void v2() {
    }
}
