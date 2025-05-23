package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.flashshow.util.m;
import com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager;
import com.tencent.aelight.camera.aioeditor.capture.view.StaticStickerProviderView;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiItem;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.c;
import com.tencent.biz.qqstory.model.i;
import com.tencent.biz.qqstory.model.j;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import hr.d;
import hr.e;
import hr.f;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import wr.a;

/* loaded from: classes32.dex */
public class PasterDataManager extends QIMAsyncManager implements IEventReceiver, LbsManager.d, c.a<j.c> {
    public static AtomicBoolean K = new AtomicBoolean(false);
    protected hr.d C;
    public CopyOnWriteArrayList<hr.a> F;
    private j G;
    private boolean H;

    /* renamed from: e, reason: collision with root package name */
    private Context f66820e;

    /* renamed from: f, reason: collision with root package name */
    private d f66821f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f66822h;

    /* renamed from: i, reason: collision with root package name */
    protected EditVideoDoodle.f f66823i;

    /* renamed from: m, reason: collision with root package name */
    protected hr.e f66824m;
    protected Handler D = new Handler(Looper.getMainLooper());
    public LbsManager.e E = null;
    protected Runnable I = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager.1
        @Override // java.lang.Runnable
        public void run() {
            PasterDataManager pasterDataManager = PasterDataManager.this;
            if (pasterDataManager.f66822h) {
                return;
            }
            pasterDataManager.J.a(1, Collections.EMPTY_LIST);
        }
    };
    a.j J = new a();

    /* loaded from: classes32.dex */
    class a implements a.j {
        a() {
        }

        @Override // wr.a.j
        public void a(int i3, List<bd0.a> list) {
            hd0.c.a("PasterDataManager", "onPOIPostersRequestResult callback");
            PasterDataManager pasterDataManager = PasterDataManager.this;
            pasterDataManager.f66822h = true;
            pasterDataManager.D.removeCallbacks(pasterDataManager.I);
            if (list == null) {
                list = Collections.EMPTY_LIST;
            }
            com.tencent.biz.qqstory.base.c.a().dispatch(new a.h(i3, list));
        }
    }

    /* loaded from: classes32.dex */
    class b implements m.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f66826a;

        /* loaded from: classes32.dex */
        class a extends LbsManager.c {
            a(String str) {
                super(str);
            }

            @Override // com.tencent.biz.qqstory.model.lbs.LbsManager.c, com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
            public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
                super.onLocationFinish(i3, sosoLbsInfo);
                if (i3 == 0 && sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
                    hd0.c.a("PasterDataManager", "requestPoiFaces onLocationUpdate() latitude=" + sosoLbsInfo.mLocation.mLat02 + " longitude=" + sosoLbsInfo.mLocation.mLon02);
                    PasterDataManager.this.H = true;
                    b bVar = b.this;
                    PasterDataManager.this.x(bVar.f66826a);
                    PasterDataManager.this.y(null);
                    return;
                }
                hd0.c.a("PasterDataManager", "requestPoiFaces onLocationUpdate() error");
            }
        }

        b(boolean z16) {
            this.f66826a = z16;
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.util.m.c
        public void onGetLocation() {
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new a("NewStoryTakeVideoActivity"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements m.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f66829a;

        /* loaded from: classes32.dex */
        class a extends LbsManager.c {
            a(String str) {
                super(str);
            }

            @Override // com.tencent.biz.qqstory.model.lbs.LbsManager.c, com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
            public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
                super.onLocationFinish(i3, sosoLbsInfo);
                if (i3 == 0 && sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
                    hd0.c.a("PasterDataManager", "requestPoiForCoarse onLocationUpdate() latitude=" + sosoLbsInfo.mLocation.mLat02 + " longitude=" + sosoLbsInfo.mLocation.mLon02);
                    PasterDataManager.this.H = true;
                    c cVar = c.this;
                    PasterDataManager.this.x(cVar.f66829a);
                    PasterDataManager.this.y(null);
                    return;
                }
                hd0.c.a("PasterDataManager", "requestPoiForCoarse onLocationUpdate() error");
            }
        }

        c(boolean z16) {
            this.f66829a = z16;
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.util.m.c
        public void onGetLocation() {
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new a("NewStoryTakeVideoActivity"));
        }
    }

    /* loaded from: classes32.dex */
    public static class d extends QQUIEventReceiver<PasterDataManager, a.g> {
        public d(PasterDataManager pasterDataManager) {
            super(pasterDataManager);
        }

        @Override // com.tribe.async.dispatch.QQUIEventReceiver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(PasterDataManager pasterDataManager, a.g gVar) {
            EditVideoDoodle.f fVar = pasterDataManager.f66823i;
            if (fVar != null) {
                hr.a e16 = fVar.e(gVar.f446105e.pack_id);
                if (!(e16 instanceof f)) {
                    hd0.c.t(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + gVar.f446105e.pack_id);
                    return;
                }
                f fVar2 = (f) e16;
                if (gVar.f446106f == 0) {
                    if (gVar.f446107h) {
                        hd0.c.a(this.TAG, "notify ui we finish downloading");
                        fVar2.f406067q = false;
                        fVar2.f406065o = gVar.f446105e.getLocalEmojiFolderPath();
                        fVar2.f406068r = 0;
                        fVar2.f406069s = 0;
                        fVar.f(fVar2);
                        return;
                    }
                    hd0.c.a(this.TAG, "notify ui we new progress : " + gVar.C + " / " + gVar.f446109m);
                    fVar2.f406067q = true;
                    fVar2.f406065o = null;
                    fVar2.f406068r = (int) gVar.f446109m;
                    fVar2.f406069s = (int) gVar.C;
                    fVar.f(fVar2);
                    return;
                }
                if (gVar.f446108i) {
                    PasterDataManager.B(fVar2, gVar.f446105e);
                    fVar2.f406066p.clear();
                    fVar.f(fVar2);
                    return;
                }
                fVar2.f406067q = false;
                fVar2.f406065o = null;
                fVar2.f406068r = 0;
                fVar2.f406069s = 0;
                fVar.f(fVar2);
                hd0.c.g(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + gVar.f446106f);
                id0.b.i("0X80076C9");
                id0.b.f("0X80075DE");
                return;
            }
            hd0.c.a(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
        }

        @Override // com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect
        public Class acceptEventClass() {
            return a.g.class;
        }
    }

    private void A(Map<String, Map<String, d.a>> map, String str, d.c cVar) {
        if (cVar.a() != null) {
            cVar.a().e();
        }
        Map<String, d.a> map2 = map.get(cVar.f406032k);
        if (map2 != null) {
            d.a aVar = map2.get(str);
            if (aVar == null) {
                aVar = map2.get("default");
            }
            if (aVar != null) {
                cVar.f406031j = aVar.f406018a;
                cVar.f406029h = aVar.f406019b;
                cVar.f406030i = aVar.f406020c;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void B(f fVar, DoodleEmojiItem doodleEmojiItem) {
        z(fVar, doodleEmojiItem);
        fVar.f406065o = doodleEmojiItem.getLocalEmojiFolderPath();
    }

    private void w(com.tencent.biz.qqstory.model.lbs.a aVar, boolean z16) {
        hd0.c.a("PasterDataManager", "requestPoiList");
        LbsManager lbsManager = (LbsManager) i.c(9);
        if (aVar == null) {
            aVar = LbsManager.c();
        }
        if (z16) {
            lbsManager.h(aVar, null, this);
        } else {
            lbsManager.h(aVar, this.E, this);
        }
    }

    private static void z(hr.a aVar, DoodleEmojiItem doodleEmojiItem) {
        aVar.f405989b = doodleEmojiItem.name;
        aVar.f405990c = doodleEmojiItem.icon;
        aVar.f405991d = doodleEmojiItem.download_icon;
        aVar.f405993f = doodleEmojiItem.download_wording;
        aVar.f405994g = "1".equals(doodleEmojiItem.random_position);
        aVar.f(doodleEmojiItem.config);
        aVar.f405999l = doodleEmojiItem.hide;
        aVar.f406000m = doodleEmojiItem.mask;
    }

    @Override // com.tencent.biz.qqstory.model.lbs.LbsManager.d
    public void a(int i3, LbsManager.e eVar, List<TroopBarPOI> list) {
        hd0.c.a("PasterDataManager", "onPOIListRequestResult." + i3);
        if (i3 != 0 || eVar == null) {
            return;
        }
        this.E = eVar;
        if (list == null || list.size() <= 0) {
            return;
        }
        String a16 = list.get(0).a();
        if (QLog.isColorLevel()) {
            QLog.d("PasterDataManager", 2, "onPOIListRequestResult " + a16);
        }
        String recentPOI = ShortVideoUtils.getRecentPOI(QQStoryContext.a().getCurrentAccountUin());
        Iterator<TroopBarPOI> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (TextUtils.equals(it.next().a(), recentPOI)) {
                a16 = recentPOI;
                break;
            }
        }
        D(list.get(0).f293484e, a16, true);
    }

    @Override // fr.e
    public void d() {
        if (this.f66821f != null) {
            com.tencent.biz.qqstory.base.c.a().unRegisterSubscriber(this.f66821f);
            this.f66821f = null;
        }
        j jVar = this.G;
        if (jVar != null) {
            jVar.g(this);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager
    public void i() {
        this.f66820e = BaseApplication.getContext();
        this.f66823i = new EditVideoDoodle.f();
        s();
        this.f66821f = new d(this);
        com.tencent.biz.qqstory.base.c.a().registerSubscriber(this.f66821f);
        if (QLog.isDevelopLevel()) {
            QLog.d("PasterDataManager", 4, "initPasterConfig");
        }
    }

    @Override // com.tribe.async.dispatch.IEventReceiver
    public boolean isValidate() {
        return true;
    }

    public synchronized List<hr.a> o(boolean z16) {
        hr.a aVar;
        CopyOnWriteArrayList<hr.a> copyOnWriteArrayList = this.F;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            List<DoodleEmojiItem> h16 = ((wr.a) fr.f.c(14)).h();
            this.F = new CopyOnWriteArrayList<>();
            for (DoodleEmojiItem doodleEmojiItem : h16) {
                int i3 = doodleEmojiItem.type;
                if (i3 == 1) {
                    if ("1000".equals(doodleEmojiItem.pack_id)) {
                        hr.a bVar = new hr.b(doodleEmojiItem.pack_id);
                        z(bVar, doodleEmojiItem);
                        aVar = bVar;
                    } else {
                        f fVar = new f(doodleEmojiItem.pack_id);
                        B(fVar, doodleEmojiItem);
                        aVar = fVar;
                    }
                    if ("1".equals(aVar.f405988a) && !NetworkUtil.isNetworkAvailable(this.f66820e)) {
                        aVar.f405992e = this.f66820e.getResources().getDrawable(R.drawable.fba);
                    }
                    this.F.add(aVar);
                } else if (i3 == 2) {
                    this.f66824m.f405989b = doodleEmojiItem.name;
                    if (!TextUtils.isEmpty(doodleEmojiItem.icon) && NetworkUtil.isNetworkAvailable(this.f66820e)) {
                        this.f66824m.f405990c = doodleEmojiItem.icon;
                    } else {
                        this.f66824m.f405992e = this.f66820e.getResources().getDrawable(R.drawable.fdx);
                    }
                    List<e.a> list = doodleEmojiItem.mItemList;
                    if (list != null) {
                        this.f66824m.f406043n = list;
                        if (list != null) {
                            hd0.c.a("PasterDataManager", "add doodle emoji location item name = " + this.f66824m.f406045p);
                            for (e.a aVar2 : doodleEmojiItem.mItemList) {
                                hr.e eVar = this.f66824m;
                                aVar2.f406054i = eVar.f405989b;
                                aVar2.f406047b = eVar.f406045p;
                            }
                        }
                    }
                    this.f66824m.f405994g = "1".equals(doodleEmojiItem.random_position);
                    hr.e eVar2 = this.f66824m;
                    eVar2.f405999l = doodleEmojiItem.hide;
                    eVar2.f406000m = doodleEmojiItem.mask;
                    this.F.add(eVar2);
                } else if (i3 == 3) {
                    hr.d dVar = this.C;
                    if (dVar == null) {
                        this.C = new hr.d(doodleEmojiItem.pack_id);
                    } else {
                        dVar.f405988a = doodleEmojiItem.pack_id;
                    }
                    hr.d dVar2 = this.C;
                    dVar2.f405989b = doodleEmojiItem.name;
                    dVar2.f406011n = doodleEmojiItem.mInfoItemList;
                    dVar2.f(doodleEmojiItem.config);
                    hr.d dVar3 = this.C;
                    dVar3.f405999l = doodleEmojiItem.hide;
                    dVar3.f406013p = "default";
                    dVar3.f406016s = -999;
                    dVar3.f406014q = "--";
                    dVar3.f406015r = "default";
                    List<d.c> list2 = dVar3.f406011n;
                    if (list2 != null) {
                        for (d.c cVar : list2) {
                            cVar.f406042u = this.C.f405989b;
                            if (hr.c.e(cVar.f406025d)) {
                                cVar.f406039r = this.C.f406012o;
                            }
                            Map<String, Map<String, d.a>> map = doodleEmojiItem.mCityRes;
                            if (map != null && cVar.f406025d == 7) {
                                A(map, this.C.f406013p, cVar);
                            }
                            if (cVar.f406025d == 6) {
                                hr.d dVar4 = this.C;
                                cVar.f406036o = dVar4.f406016s;
                                cVar.f406034m = dVar4.f406014q;
                                cVar.f406035n = dVar4.f406015r;
                            }
                        }
                    }
                    this.F.add(this.C);
                    this.C.f406017t = doodleEmojiItem.mCityRes;
                }
            }
            hd0.c.a("PasterDataManager", "getDoodleFacePackages, size = " + this.F.size());
            K.set(true);
        }
        if (z16) {
            StaticStickerProviderView.K(this.F);
            K.set(true);
        }
        return this.F;
    }

    public EditVideoDoodle.f p() {
        return this.f66823i;
    }

    public hr.a q(String str) {
        return this.f66823i.e(str);
    }

    public String r() {
        hr.e eVar = this.f66824m;
        if (eVar != null) {
            return eVar.f406045p;
        }
        return null;
    }

    public void v(boolean z16, Activity activity) {
        new m(activity, new c(z16)).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z16) {
        w(null, z16);
    }

    public void m() {
        this.H = false;
    }

    public List<hr.a> n() {
        return o(false);
    }

    private void D(String str, String str2, boolean z16) {
        hr.d dVar;
        Map<String, Map<String, d.a>> map;
        hr.e eVar;
        hr.d dVar2;
        if (str != null && (dVar2 = this.C) != null && !str.equals(dVar2.f406013p)) {
            this.C.f406013p = str;
        }
        boolean z17 = (str2 == null || (eVar = this.f66824m) == null || str2.equals(eVar.f406045p)) ? false : true;
        hr.e eVar2 = this.f66824m;
        if (eVar2 != null && z17) {
            eVar2.f406045p = str2;
            Iterator<e.a> it = eVar2.f406043n.iterator();
            while (it.hasNext()) {
                it.next().f406047b = str2;
            }
            if (z16) {
                this.f66823i.f(this.f66824m);
            }
        }
        hr.d dVar3 = this.C;
        if (dVar3 != null) {
            if (z17) {
                dVar3.f406012o = str2;
                for (d.c cVar : dVar3.f406011n) {
                    if (cVar.f406038q) {
                        cVar.f406039r = str2;
                    }
                }
            }
            for (d.c cVar2 : this.C.f406011n) {
                if (cVar2.f406025d == 7 && !this.C.f406013p.equals(cVar2.f406033l) && (map = (dVar = this.C).f406017t) != null) {
                    A(map, dVar.f406013p, cVar2);
                }
            }
            if (z16) {
                this.f66823i.f(this.C);
            }
        }
    }

    private void E(j.c cVar) {
        if (cVar != null) {
            this.C.f406016s = cVar.f94051a;
            String str = cVar.f94052b;
            if (str != null) {
                String[] split = str.split("\\|");
                if (split != null && split.length == 2) {
                    hr.d dVar = this.C;
                    dVar.f406014q = split[0];
                    dVar.f406015r = split[1];
                }
                for (d.c cVar2 : this.C.f406011n) {
                    if (cVar2.f406025d == 6) {
                        hr.d dVar2 = this.C;
                        cVar2.f406034m = dVar2.f406014q;
                        cVar2.f406035n = dVar2.f406015r;
                        cVar2.f406036o = dVar2.f406016s;
                    }
                }
            }
        }
    }

    private void s() {
        wr.a aVar = (wr.a) fr.f.c(14);
        aVar.r(false);
        if (this.f66824m == null) {
            hr.e eVar = new hr.e("0");
            this.f66824m = eVar;
            eVar.f406044o = true;
            String m3 = wr.a.m(aVar, "0");
            String l3 = wr.a.l(aVar, "0");
            if (!TextUtils.isEmpty(l3) && NetworkUtil.isNetworkAvailable(this.f66820e)) {
                this.f66824m.f405990c = l3;
            } else {
                this.f66824m.f405992e = this.f66820e.getResources().getDrawable(R.drawable.fdx);
            }
            this.f66824m.f(m3);
        }
        if (this.C == null) {
            this.C = new hr.d("2001");
        }
    }

    public void C(String str) {
        D(null, str, false);
    }

    @Override // com.tencent.biz.qqstory.model.c.a
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void b(boolean z16, j.c cVar) {
        if (z16) {
            E(cVar);
        }
    }

    public void y(com.tencent.biz.qqstory.model.lbs.a aVar) {
        j jVar = (j) ((com.tencent.biz.qqstory.model.d) i.c(20)).b(0);
        this.G = jVar;
        j.c j3 = jVar.j();
        if (j3 != null) {
            hd0.c.a("PasterDataManager", "get weather from cache.");
            E(j3);
            return;
        }
        hd0.c.a("PasterDataManager", "get weather from net.");
        if (aVar == null) {
            aVar = LbsManager.c();
        }
        this.G.e(this);
        this.G.f(aVar);
    }

    public void u(boolean z16, Activity activity) {
        hr.d dVar;
        if (activity == null) {
            return;
        }
        if (!this.H || (dVar = this.C) == null || "default".equals(dVar.f406013p) || "--".equals(this.C.f406014q)) {
            new m(activity, new b(z16)).c();
        }
    }
}
