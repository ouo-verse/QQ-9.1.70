package com.qzone.album.business.photolist.controller;

import NS_MOBILE_PHOTO.PhotoSearchBoxChosenItem;
import NS_MOBILE_PHOTO.PhotoSearchBoxChosenItemElem;
import NS_MOBILE_PHOTO.PhotoSearchBoxItem;
import NS_MOBILE_PHOTO.PhotoSearchBoxItemElem;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.business.photolist.ui.CommonPhotoSearchBoxView;
import com.qzone.album.business.search.PhotoSearchBoxCacheData;
import com.qzone.album.business.search.PhotoSearchBoxItemCacheData;
import com.qzone.album.business.search.PhotoSearchBoxItemElemCacheData;
import com.qzone.album.business.search.SearchFilterComposition;
import com.qzone.album.data.AlbumCacheDataManager;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZoneGetPhotoSearchRequest;
import com.qzone.album.ui.widget.c;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.report.QZonePerfReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import r4.b;
import r4.f;
import r4.g;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d implements View.OnClickListener, com.qzone.album.env.common.c {
    private View C;
    private TextView D;
    private TextView E;
    private LinearLayout F;
    private RelativeLayout G;
    private CommonPhotoSearchBoxView H;
    private r4.a I;
    private long N;

    /* renamed from: d, reason: collision with root package name */
    private Activity f43234d;

    /* renamed from: e, reason: collision with root package name */
    private AlbumCacheData f43235e;

    /* renamed from: f, reason: collision with root package name */
    private AlbumCacheData f43236f;

    /* renamed from: h, reason: collision with root package name */
    private com.qzone.album.ui.widget.c f43237h;

    /* renamed from: i, reason: collision with root package name */
    private BasePhotoModelController f43238i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f43239m = false;
    private int[] P = {8, 16, 2, 1, 4};
    private ArrayList<Integer> J = new ArrayList<>();
    private ArrayList<Integer> K = new ArrayList<>();
    private HashMap<Integer, PhotoSearchBoxChosenItem> L = new HashMap<>();
    private HashMap<Integer, PhotoSearchBoxItem> M = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f43241a;

        b(int i3) {
            this.f43241a = i3;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            QZoneGetPhotoSearchRequest.a aVar;
            if (d.this.G != null) {
                d.this.G.setVisibility(8);
            }
            d.this.E(System.currentTimeMillis() - d.this.N);
            if (!(sVar.getData() instanceof QZoneGetPhotoSearchRequest.a) || (aVar = (QZoneGetPhotoSearchRequest.a) sVar.getData()) == null || aVar.f43931a != 0) {
                if (d.this.H != null) {
                    d.this.H.e(null, d.this);
                    d.this.H.setVisibility(8);
                }
                if (d.this.f43237h != null) {
                    d.this.f43237h.l(14);
                    d.this.f43237h.m(true);
                }
                d.this.I();
                return;
            }
            d.this.H(AlbumCacheDataManager.J().x(((Long) absCompatRequest.getParam("uin")).longValue(), (String) absCompatRequest.getParam("albumId")), this.f43241a == 3);
            d.this.L();
            if (this.f43241a == 3) {
                d.this.f43239m = true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f43243d;

        c(int i3) {
            this.f43243d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            r4.c d16 = d.this.I.d(this.f43243d);
            if (d16 != null) {
                if (d16.f430703f) {
                    d.this.I.e(this.f43243d);
                    Iterator it = d.this.K.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (((Integer) it.next()).intValue() == d16.f430698a) {
                            it.remove();
                            break;
                        }
                    }
                } else {
                    d.this.I.b(this.f43243d);
                    d.this.K.add(Integer.valueOf(d16.f430698a));
                }
            }
            if (d.this.H != null) {
                d.this.H.d();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.album.business.photolist.controller.d$d, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class ViewOnClickListenerC0337d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private int f43245d;

        /* renamed from: e, reason: collision with root package name */
        private int f43246e;

        /* renamed from: f, reason: collision with root package name */
        private int f43247f;

        /* renamed from: h, reason: collision with root package name */
        private r4.b f43248h;

        public ViewOnClickListenerC0337d(int i3, int i16, int i17, r4.b bVar) {
            this.f43245d = i3;
            this.f43246e = i16;
            this.f43247f = i17;
            this.f43248h = bVar;
        }

        private int a(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 8) {
                        if (i3 != 16) {
                            return -1;
                        }
                        return 5;
                    }
                    return 4;
                }
                return 6;
            }
            return 7;
        }

        private void b(b.a aVar, int i3) {
            Iterator<PhotoSearchBoxItemElem> it;
            ArrayList<PhotoSearchBoxChosenItemElem> arrayList;
            if (aVar.f430692c) {
                if (d.this.J == null) {
                    return;
                }
                aVar.f430692c = false;
                PhotoSearchBoxItem photoSearchBoxItem = (PhotoSearchBoxItem) d.this.M.get(Integer.valueOf(i3));
                if (photoSearchBoxItem == null || (it = photoSearchBoxItem.elems.iterator()) == null) {
                    return;
                }
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PhotoSearchBoxItemElem next = it.next();
                    if (next != null && next.categoryid.equals(aVar.f430695f)) {
                        it.remove();
                        break;
                    }
                }
                if (photoSearchBoxItem.elems.size() == 0) {
                    Iterator it5 = d.this.J.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        } else if (((Integer) it5.next()).intValue() == i3) {
                            it5.remove();
                            break;
                        }
                    }
                }
                PhotoSearchBoxChosenItem photoSearchBoxChosenItem = (PhotoSearchBoxChosenItem) d.this.L.get(Integer.valueOf(i3));
                if (photoSearchBoxChosenItem != null && (arrayList = photoSearchBoxChosenItem.elems) != null) {
                    Iterator<PhotoSearchBoxChosenItemElem> it6 = arrayList.iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            break;
                        }
                        PhotoSearchBoxChosenItemElem next2 = it6.next();
                        if (next2 != null && next2.categoryid.equals(aVar.f430695f)) {
                            it6.remove();
                            break;
                        }
                    }
                }
                if (d.this.J.size() == 0) {
                    d.this.G(false);
                }
                if (a(i3) != -1) {
                    com.qzone.album.env.common.a.m().P(94, a(i3), "3", true, "");
                    return;
                }
                return;
            }
            aVar.f430692c = true;
            if (d.this.J == null) {
                d.this.J = new ArrayList();
            }
            if (d.this.M == null) {
                d.this.M = new HashMap();
            }
            if (!d.this.J.contains(Integer.valueOf(i3))) {
                d.this.J.add(Integer.valueOf(i3));
                PhotoSearchBoxItem photoSearchBoxItem2 = new PhotoSearchBoxItem();
                photoSearchBoxItem2.elems = new ArrayList<>();
                PhotoSearchBoxItemElem photoSearchBoxItemElem = new PhotoSearchBoxItemElem();
                photoSearchBoxItemElem.type = aVar.f430694e;
                photoSearchBoxItemElem.categoryid = aVar.f430695f;
                photoSearchBoxItemElem.desc = aVar.f430696g;
                photoSearchBoxItemElem.url = aVar.f430697h;
                photoSearchBoxItem2.elems.add(photoSearchBoxItemElem);
                d.this.M.put(Integer.valueOf(i3), photoSearchBoxItem2);
                PhotoSearchBoxChosenItem photoSearchBoxChosenItem2 = new PhotoSearchBoxChosenItem();
                photoSearchBoxChosenItem2.elems = new ArrayList<>();
                PhotoSearchBoxChosenItemElem photoSearchBoxChosenItemElem = new PhotoSearchBoxChosenItemElem();
                photoSearchBoxChosenItemElem.type = aVar.f430694e;
                photoSearchBoxChosenItemElem.categoryid = aVar.f430695f;
                photoSearchBoxChosenItem2.elems.add(photoSearchBoxChosenItemElem);
                d.this.L.put(Integer.valueOf(i3), photoSearchBoxChosenItem2);
            } else {
                PhotoSearchBoxItem photoSearchBoxItem3 = (PhotoSearchBoxItem) d.this.M.get(Integer.valueOf(i3));
                PhotoSearchBoxItemElem photoSearchBoxItemElem2 = new PhotoSearchBoxItemElem();
                photoSearchBoxItemElem2.type = aVar.f430694e;
                photoSearchBoxItemElem2.categoryid = aVar.f430695f;
                photoSearchBoxItemElem2.desc = aVar.f430696g;
                photoSearchBoxItemElem2.url = aVar.f430697h;
                photoSearchBoxItem3.elems.add(photoSearchBoxItemElem2);
                PhotoSearchBoxChosenItem photoSearchBoxChosenItem3 = (PhotoSearchBoxChosenItem) d.this.L.get(Integer.valueOf(i3));
                PhotoSearchBoxChosenItemElem photoSearchBoxChosenItemElem2 = new PhotoSearchBoxChosenItemElem();
                photoSearchBoxChosenItemElem2.type = aVar.f430694e;
                photoSearchBoxChosenItemElem2.categoryid = aVar.f430695f;
                photoSearchBoxChosenItem3.elems.add(photoSearchBoxChosenItemElem2);
                d.this.L.put(Integer.valueOf(i3), photoSearchBoxChosenItem3);
            }
            if (a(i3) != -1) {
                com.qzone.album.env.common.a.m().P(94, a(i3), "2", true, "");
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            j.f("AlbumPhotoSearchBox", "clicked type:" + this.f43247f);
            r4.c d16 = d.this.I.d(this.f43245d);
            if (d16 != null) {
                int i3 = this.f43247f;
                if (i3 == 0) {
                    if (a(d16.f430698a) != -1) {
                        com.qzone.album.env.common.a m3 = com.qzone.album.env.common.a.m();
                        int a16 = a(d16.f430698a);
                        if (d16.f430703f) {
                            str = "4";
                        } else {
                            str = "5";
                        }
                        m3.P(94, a16, str, true, "");
                    }
                    if (d16.f430703f) {
                        d16.c();
                    } else {
                        d16.g();
                    }
                } else if (i3 == 1) {
                    r4.b bVar = this.f43248h;
                    if (bVar instanceof f) {
                        b.a h16 = ((f) bVar).h(this.f43246e);
                        if (h16 != null) {
                            b(h16, d16.f430698a);
                        }
                        d.this.y(1);
                    }
                } else if (i3 == 2) {
                    r4.b bVar2 = this.f43248h;
                    if (bVar2 instanceof r4.d) {
                        b.a h17 = ((r4.d) bVar2).h(this.f43246e);
                        if (h17 != null) {
                            b(h17, d16.f430698a);
                        }
                        d.this.y(1);
                    }
                }
            }
            if (d.this.J != null && d.this.J.size() > 0) {
                d.this.E.setBackgroundColor(d.this.f43234d.getResources().getColor(R.color.a6d));
            } else {
                d.this.E.setBackgroundColor(d.this.f43234d.getResources().getColor(R.color.a6e));
            }
            if (d.this.H != null) {
                d.this.H.d();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public d(BasePhotoModelController basePhotoModelController, Activity activity) {
        this.f43238i = basePhotoModelController;
        this.f43234d = activity;
        C();
        A();
    }

    private void A() {
        com.qzone.album.ui.widget.c cVar = new com.qzone.album.ui.widget.c(this, new a());
        this.f43237h = cVar;
        cVar.l(14);
        this.f43237h.m(false);
    }

    private void B() {
        View view = this.C;
        if (view != null) {
            view.setOnClickListener(this);
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = this.E;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        RelativeLayout relativeLayout = this.G;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(this);
        }
    }

    private ArrayList<Integer> D(ArrayList<Integer> arrayList) {
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i3 : this.P) {
            if (arrayList.contains(Integer.valueOf(i3))) {
                arrayList2.add(Integer.valueOf(i3));
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(long j3) {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("search_cost", j3 + "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "photoSearchControllerRequestCost", true, 0L, 0L, hashMap, null);
        } catch (Exception e16) {
            j.d("AlbumPhotoSearchBox", "reportToBeacon failed ", e16);
        }
    }

    private void F(boolean z16) {
        ArrayList<Integer> arrayList;
        ArrayList<Integer> arrayList2 = this.J;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        HashMap<Integer, PhotoSearchBoxChosenItem> hashMap = this.L;
        if (hashMap != null) {
            hashMap.clear();
        }
        if (z16 && (arrayList = this.K) != null) {
            arrayList.clear();
        }
        HashMap<Integer, PhotoSearchBoxItem> hashMap2 = this.M;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        TextView textView = this.E;
        if (textView != null) {
            textView.setBackgroundColor(this.f43234d.getResources().getColor(R.color.a6e));
        }
    }

    private void s() {
        HashMap<Integer, PhotoSearchBoxItem> hashMap;
        ArrayList<Integer> arrayList = this.J;
        if (arrayList == null || arrayList.size() <= 0 || (hashMap = this.M) == null || hashMap.size() <= 0) {
            return;
        }
        SearchFilterComposition createdFromPhotoSearchBox = SearchFilterComposition.createdFromPhotoSearchBox(D(this.J), this.M);
        t4.a N = t4.a.N();
        Activity activity = this.f43234d;
        AlbumCacheData albumCacheData = this.f43235e;
        Intent T = N.T(activity, albumCacheData, albumCacheData.ownerUin, createdFromPhotoSearchBox);
        if (T != null) {
            com.qzone.feed.utils.b.e(this.f43234d, T, 30);
        }
    }

    private boolean t(int i3) {
        ArrayList<Integer> arrayList = this.K;
        return arrayList != null && arrayList.size() > 0 && this.K.contains(Integer.valueOf(i3));
    }

    private boolean w(PhotoSearchBoxItemElemCacheData photoSearchBoxItemElemCacheData) {
        PhotoSearchBoxItem photoSearchBoxItem;
        HashMap<Integer, PhotoSearchBoxItem> hashMap = this.M;
        if (hashMap == null || (photoSearchBoxItem = hashMap.get(Integer.valueOf(photoSearchBoxItemElemCacheData.type))) == null) {
            return false;
        }
        Iterator<PhotoSearchBoxItemElem> it = photoSearchBoxItem.elems.iterator();
        while (it.hasNext()) {
            PhotoSearchBoxItemElem next = it.next();
            if (next.type == photoSearchBoxItemElemCacheData.type && next.categoryid.equals(photoSearchBoxItemElemCacheData.categoryid)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i3) {
        HashMap<Integer, PhotoSearchBoxItem> hashMap;
        BasePhotoModelController basePhotoModelController = this.f43238i;
        if (basePhotoModelController != null && this.f43237h != null && !basePhotoModelController.e1()) {
            CommonPhotoSearchBoxView commonPhotoSearchBoxView = this.H;
            if (commonPhotoSearchBoxView != null) {
                commonPhotoSearchBoxView.e(null, this);
                this.H.setVisibility(8);
            }
            this.f43237h.l(0);
            this.f43237h.m(true);
            RelativeLayout relativeLayout = this.G;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            I();
            return;
        }
        if (i3 == 1) {
            ArrayList<Integer> arrayList = this.J;
            if (arrayList == null || arrayList.size() <= 0 || (hashMap = this.M) == null || hashMap.size() <= 0) {
                return;
            }
        } else {
            if (i3 != 3) {
                return;
            }
            if (this.J == null) {
                this.J = new ArrayList<>();
            }
            if (this.L == null) {
                this.L = new HashMap<>();
            }
            this.J.clear();
            this.L.clear();
        }
        RelativeLayout relativeLayout2 = this.G;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        this.N = System.currentTimeMillis();
        com.qzone.album.base.Service.a W = com.qzone.album.base.Service.a.W();
        AlbumCacheData albumCacheData = this.f43235e;
        W.q0(albumCacheData.ownerUin, albumCacheData.albumid, i3, this.J, this.L, null, new b(i3));
    }

    public void C() {
        LinearLayout linearLayout = (LinearLayout) this.f43234d.findViewById(R.id.b5x);
        this.F = linearLayout;
        if (linearLayout != null) {
            this.C = linearLayout.findViewById(R.id.ij8);
            this.D = (TextView) this.F.findViewById(R.id.iiw);
            this.E = (TextView) this.F.findViewById(R.id.iix);
            this.G = (RelativeLayout) this.F.findViewById(R.id.ij9);
            this.H = (CommonPhotoSearchBoxView) this.F.findViewById(R.id.b5w);
        }
        B();
    }

    public void G(boolean z16) {
        AlbumCacheData albumCacheData = this.f43236f;
        if (albumCacheData != null) {
            H(albumCacheData, false);
            F(z16);
            L();
        }
    }

    public void J() {
        RelativeLayout relativeLayout = this.G;
        if (relativeLayout == null || this.f43239m) {
            return;
        }
        relativeLayout.setVisibility(0);
        y(3);
    }

    public void L() {
        r4.a u16 = u();
        this.I = u16;
        if (u16 == null) {
            CommonPhotoSearchBoxView commonPhotoSearchBoxView = this.H;
            if (commonPhotoSearchBoxView != null) {
                commonPhotoSearchBoxView.e(null, this);
                this.H.setVisibility(8);
            }
            com.qzone.album.ui.widget.c cVar = this.f43237h;
            if (cVar != null) {
                cVar.l(14);
                this.f43237h.m(true);
            }
            RelativeLayout relativeLayout = this.G;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            I();
            return;
        }
        CommonPhotoSearchBoxView commonPhotoSearchBoxView2 = this.H;
        if (commonPhotoSearchBoxView2 != null) {
            commonPhotoSearchBoxView2.e(u16, this);
            if (this.H.getVisibility() != 0) {
                this.H.setVisibility(0);
            }
        }
    }

    @Override // com.qzone.album.env.common.c
    public boolean P2() {
        return false;
    }

    @Override // com.qzone.album.env.common.c
    public ListView R3() {
        CommonPhotoSearchBoxView commonPhotoSearchBoxView = this.H;
        if (commonPhotoSearchBoxView == null) {
            return null;
        }
        return commonPhotoSearchBoxView.b();
    }

    @Override // com.qzone.album.env.common.c
    public boolean Ta() {
        return this.f43238i.e1();
    }

    @Override // com.qzone.album.env.common.c
    public Activity getCurrentActivity() {
        return this.f43234d;
    }

    @Override // com.qzone.album.env.common.c
    public View getRootView() {
        return this.F;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        ArrayList<PhotoSearchBoxItemElem> arrayList;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.iiw) {
            G(true);
            com.qzone.album.env.common.a.m().P(94, 2, "", true, "");
        } else if (id5 == R.id.iix) {
            s();
            HashMap<Integer, PhotoSearchBoxItem> hashMap = this.M;
            if (hashMap != null) {
                Iterator<Integer> it = hashMap.keySet().iterator();
                i3 = 0;
                while (it.hasNext()) {
                    PhotoSearchBoxItem photoSearchBoxItem = this.M.get(Integer.valueOf(it.next().intValue()));
                    if (photoSearchBoxItem != null && (arrayList = photoSearchBoxItem.elems) != null) {
                        i3 += arrayList.size();
                    }
                }
            } else {
                i3 = 0;
            }
            com.qzone.album.env.common.a.m().P(94, 3, "", true, i3 + "");
        } else if (id5 == R.id.ij8) {
            K(false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public View.OnClickListener v(int i3) {
        return new c(i3);
    }

    public View.OnClickListener x(int i3, int i16, int i17, r4.b bVar) {
        return new ViewOnClickListenerC0337d(i3, i16, i17, bVar);
    }

    public int z() {
        LinearLayout linearLayout = this.F;
        if (linearLayout != null) {
            return linearLayout.getVisibility();
        }
        return 8;
    }

    public void I() {
        F(true);
        this.f43239m = false;
    }

    public boolean q(AlbumCacheData albumCacheData) {
        H(albumCacheData, false);
        return r(albumCacheData) && QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ALBUM_PHOTO_SEARCH_ENTRANCE_OPEN, 1) == 1;
    }

    private boolean r(AlbumCacheData albumCacheData) {
        return albumCacheData != null && albumCacheData.photoSearchStatus == 3;
    }

    private r4.a u() {
        PhotoSearchBoxCacheData photoSearchBoxCacheData;
        ArrayList<PhotoSearchBoxItemElemCacheData> arrayList;
        ArrayList<Integer> arrayList2;
        AlbumCacheData albumCacheData = this.f43235e;
        String str = null;
        if (albumCacheData == null || (photoSearchBoxCacheData = albumCacheData.photoSearchBox) == null) {
            return null;
        }
        ArrayList<Integer> arrayList3 = photoSearchBoxCacheData.types;
        Map<Integer, PhotoSearchBoxItemCacheData> map = photoSearchBoxCacheData.items;
        if (arrayList3 == null || arrayList3.size() <= 0 || map == null || map.size() <= 0 || arrayList3.size() != map.size()) {
            return null;
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator<Integer> it = arrayList3.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            PhotoSearchBoxItemCacheData photoSearchBoxItemCacheData = map.get(Integer.valueOf(intValue));
            if (photoSearchBoxItemCacheData == null || (arrayList = photoSearchBoxItemCacheData.elems) == null || arrayList.size() <= 0) {
                break;
            }
            if (intValue == 1) {
                r4.e eVar = new r4.e(photoSearchBoxItemCacheData.desc, 1, false);
                eVar.f430703f = t(1);
                int size = photoSearchBoxItemCacheData.elems.size();
                for (int i3 = 0; i3 < size && i3 < 20; i3++) {
                    PhotoSearchBoxItemElemCacheData photoSearchBoxItemElemCacheData = photoSearchBoxItemCacheData.elems.get(i3);
                    boolean w3 = w(photoSearchBoxItemElemCacheData);
                    b.a aVar = new b.a();
                    aVar.f430693d = false;
                    String str2 = photoSearchBoxItemElemCacheData.url;
                    aVar.f430690a = str2;
                    aVar.f430691b = photoSearchBoxItemElemCacheData.face_show.pic_host.nick;
                    aVar.f430692c = w3;
                    aVar.f430694e = photoSearchBoxItemElemCacheData.type;
                    aVar.f430695f = photoSearchBoxItemElemCacheData.categoryid;
                    aVar.f430696g = photoSearchBoxItemElemCacheData.desc;
                    aVar.f430697h = str2;
                    eVar.h(aVar);
                }
                arrayList4.add(eVar);
                com.qzone.album.env.common.a.m().P(94, 7, "1", true, photoSearchBoxItemCacheData.elems.size() + "");
            } else if (intValue == 2) {
                g gVar = new g(photoSearchBoxItemCacheData.desc, 2, false);
                gVar.f430703f = t(2);
                int size2 = photoSearchBoxItemCacheData.elems.size();
                for (int i16 = 0; i16 < size2 && i16 < 21; i16++) {
                    PhotoSearchBoxItemElemCacheData photoSearchBoxItemElemCacheData2 = photoSearchBoxItemCacheData.elems.get(i16);
                    boolean w16 = w(photoSearchBoxItemElemCacheData2);
                    b.a aVar2 = new b.a();
                    aVar2.f430693d = false;
                    String str3 = photoSearchBoxItemElemCacheData2.desc;
                    aVar2.f430690a = str3;
                    aVar2.f430691b = str3;
                    aVar2.f430692c = w16;
                    aVar2.f430694e = photoSearchBoxItemElemCacheData2.type;
                    aVar2.f430695f = photoSearchBoxItemElemCacheData2.categoryid;
                    aVar2.f430696g = str3;
                    aVar2.f430697h = photoSearchBoxItemElemCacheData2.url;
                    gVar.h(aVar2);
                }
                arrayList4.add(gVar);
                com.qzone.album.env.common.a.m().P(94, 6, "1", true, photoSearchBoxItemCacheData.elems.size() + "");
            } else if (intValue == 4) {
                g gVar2 = new g(photoSearchBoxItemCacheData.desc, 4, false);
                gVar2.f430703f = t(4);
                Iterator<PhotoSearchBoxItemElemCacheData> it5 = photoSearchBoxItemCacheData.elems.iterator();
                while (it5.hasNext()) {
                    PhotoSearchBoxItemElemCacheData next = it5.next();
                    boolean w17 = w(next);
                    b.a aVar3 = new b.a();
                    aVar3.f430693d = false;
                    String str4 = next.desc;
                    aVar3.f430690a = str4;
                    aVar3.f430691b = str4;
                    aVar3.f430692c = w17;
                    aVar3.f430694e = next.type;
                    aVar3.f430695f = next.categoryid;
                    aVar3.f430696g = str4;
                    aVar3.f430697h = next.url;
                    gVar2.h(aVar3);
                }
                arrayList4.add(gVar2);
            } else if (intValue == 8) {
                g gVar3 = new g(photoSearchBoxItemCacheData.desc, 8, false);
                gVar3.f430703f = t(8);
                gVar3.f430708k = 16;
                if (photoSearchBoxItemCacheData.elems.size() == 1 || (((arrayList2 = this.J) != null && arrayList2.contains(8)) || gVar3.f430703f)) {
                    gVar3.f430706i = true;
                }
                Iterator<PhotoSearchBoxItemElemCacheData> it6 = photoSearchBoxItemCacheData.elems.iterator();
                while (it6.hasNext()) {
                    PhotoSearchBoxItemElemCacheData next2 = it6.next();
                    boolean w18 = w(next2);
                    b.a aVar4 = new b.a();
                    aVar4.f430693d = false;
                    String str5 = next2.desc;
                    aVar4.f430690a = str5;
                    aVar4.f430691b = str;
                    aVar4.f430692c = w18;
                    aVar4.f430694e = next2.type;
                    aVar4.f430695f = next2.categoryid;
                    aVar4.f430696g = str5;
                    aVar4.f430697h = next2.url;
                    gVar3.h(aVar4);
                }
                arrayList4.add(gVar3);
                com.qzone.album.env.common.a.m().P(94, 4, "1", true, photoSearchBoxItemCacheData.elems.size() + "");
            } else if (intValue == 16) {
                g gVar4 = new g(photoSearchBoxItemCacheData.desc, 16, true);
                gVar4.f430707j = 8;
                Iterator<PhotoSearchBoxItemElemCacheData> it7 = photoSearchBoxItemCacheData.elems.iterator();
                while (it7.hasNext()) {
                    PhotoSearchBoxItemElemCacheData next3 = it7.next();
                    boolean w19 = w(next3);
                    b.a aVar5 = new b.a();
                    aVar5.f430693d = true;
                    String str6 = next3.desc;
                    aVar5.f430690a = str6;
                    aVar5.f430691b = str;
                    aVar5.f430692c = w19;
                    aVar5.f430694e = next3.type;
                    aVar5.f430695f = next3.categoryid;
                    aVar5.f430696g = str6;
                    aVar5.f430697h = next3.url;
                    gVar4.h(aVar5);
                }
                arrayList4.add(gVar4);
                com.qzone.album.env.common.a.m().P(94, 5, "1", true, photoSearchBoxItemCacheData.elems.size() + "");
            }
            str = null;
        }
        if (arrayList4.size() <= 0) {
            return null;
        }
        r4.a aVar6 = new r4.a();
        aVar6.a(arrayList4);
        return aVar6;
    }

    public void K(boolean z16) {
        if (z16 && !this.f43239m) {
            J();
        }
        LinearLayout linearLayout = this.F;
        if (linearLayout != null) {
            linearLayout.setVisibility(z16 ? 0 : 8);
            if (z16) {
                QZonePerfReporter.f59697a.j("custom", "photo_search_box");
                com.qzone.album.env.common.a.m().P(94, 1, "", true, "");
            }
        }
    }

    public void H(AlbumCacheData albumCacheData, boolean z16) {
        if (albumCacheData == null) {
            return;
        }
        this.f43235e = albumCacheData;
        if (z16) {
            this.f43236f = AlbumCacheDataManager.J().x(albumCacheData.ownerUin, albumCacheData.albumid);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements c.b {
        a() {
        }

        @Override // com.qzone.album.ui.widget.c.b
        public void a() {
        }

        @Override // com.qzone.album.ui.widget.c.b
        public void b() {
        }

        @Override // com.qzone.album.ui.widget.c.b
        public void refresh() {
        }
    }
}
