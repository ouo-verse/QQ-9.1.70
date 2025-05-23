package com.qzone.homepage.ui.Facade;

import NS_MOBILE_CUSTOM.Facade;
import NS_MOBILE_CUSTOM.mobile_facade_get_rsp;
import NS_MOBILE_CUSTOM.mobile_facade_pre_get_rsp;
import NS_QMALL_COVER.QzmallFacade;
import android.content.Context;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.homepage.ui.Facade.model.ConfigArea;
import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.qzone.homepage.ui.Facade.model.UserFacadeCacheData;
import com.qzone.util.al;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import cooperation.vip.manager.MonitorManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import n7.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class h implements IQZoneServiceListener {
    private static boolean C = false;
    private static boolean D = false;
    private static final al<h, Void> E = new a();

    /* renamed from: i, reason: collision with root package name */
    private static FacadeCacheData f47594i;

    /* renamed from: m, reason: collision with root package name */
    private static int f47595m;

    /* renamed from: e, reason: collision with root package name */
    private String f47597e;

    /* renamed from: d, reason: collision with root package name */
    private final String f47596d = "facade";

    /* renamed from: f, reason: collision with root package name */
    private final d f47598f = new d("user_facade_data", UserFacadeCacheData.class);

    /* renamed from: h, reason: collision with root package name */
    private Comparator<ConfigArea> f47599h = new c();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<h, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public h a(Void r16) {
            return new h();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements Comparator<ConfigArea> {
        c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ConfigArea configArea, ConfigArea configArea2) {
            return configArea.indexId - configArea2.indexId;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        long f47603a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f47604b;

        /* renamed from: c, reason: collision with root package name */
        String f47605c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f47606d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f47607e = new a();

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements a.InterfaceC10828a {
            a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                d dVar = d.this;
                dVar.f47603a = 0L;
                dVar.f47604b = null;
            }
        }

        public d(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f47605c = str;
            this.f47606d = cls;
        }
    }

    private void d(List<FacadeCacheData> list, List<UserFacadeCacheData> list2, mobile_facade_pre_get_rsp mobile_facade_pre_get_rspVar) {
        Map<Long, Facade> map = mobile_facade_pre_get_rspVar.mapUinFacade;
        if (map == null) {
            return;
        }
        Iterator<Map.Entry<Long, Facade>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, Facade> next = it.next();
            FacadeCacheData createFromJce = FacadeCacheData.createFromJce(next.getValue(), next.getKey().longValue());
            if (!list.contains(createFromJce)) {
                list.add(createFromJce);
            }
            list2.add(new UserFacadeCacheData(next.getKey().longValue(), createFromJce));
            it.remove();
        }
    }

    private DbCacheManager g(d dVar) {
        c(dVar);
        return dVar.f47604b;
    }

    public static h l() {
        return E.get(null);
    }

    private DbCacheManager n() {
        return g(this.f47598f);
    }

    public static boolean p() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_FACADE, QzoneConfig.SECONDARY_FACADE_JALPHA_ENABLE, true);
    }

    private void q(QZoneTask qZoneTask) {
        mobile_facade_pre_get_rsp mobile_facade_pre_get_rspVar = (mobile_facade_pre_get_rsp) qZoneTask.mRequest.rsp;
        QZoneResult result = qZoneTask.getResult(1000096);
        if (result.getSucceed() && mobile_facade_pre_get_rspVar != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            d(arrayList2, arrayList, mobile_facade_pre_get_rspVar);
            n().p0(arrayList, 1);
            com.qzone.homepage.ui.Facade.d.h().k(k(arrayList2));
            for (FacadeCacheData facadeCacheData : arrayList2) {
                if (p() && !TextUtils.isEmpty(facadeCacheData.getTransparentVideoBgUrl())) {
                    FacadeVideoDownLoaderManager.e().b(facadeCacheData.getTransparentVideoBgUrl());
                } else {
                    FacadeVideoDownLoaderManager.e().b(facadeCacheData.getVideoBgUrl());
                }
            }
            result.setSucceed(true);
        } else {
            result.setSucceed(false);
            MonitorManager.f().h(15, 1, " \u547d\u4ee4\u5b57\u62c9\u53d6\u5931\u8d25 + " + result.getSucceed() + " rsp " + mobile_facade_pre_get_rspVar, false);
        }
        qZoneTask.sendResultMsg(result);
    }

    private synchronized void s(Context context, long j3, String str) {
        u5.b.x0("FacadeService_ActingFacadeId", str, j3);
    }

    private synchronized void t(long j3, int i3) {
        u5.b.r0("FacadeService_ActingFacadeShow", i3, j3);
    }

    public synchronized int e(long j3) {
        int H;
        H = u5.b.H("FacadeService_ActingFacadeShow", 0, j3);
        f47595m = H;
        return H;
    }

    public String f(Context context, long j3) {
        return u5.b.j0(QzoneConfig.FACATE_LOCAL_DATE, "", LoginData.getInstance().getUin());
    }

    public FacadeCacheData h(long j3) {
        FacadeCacheData facadeCacheData;
        if (j3 == LoginData.getInstance().getUin() && (facadeCacheData = f47594i) != null) {
            return facadeCacheData;
        }
        UserFacadeCacheData o16 = o(j3);
        if (o16 == null || o16.mFacadeCacheData == null) {
            return null;
        }
        if (j3 == LoginData.getInstance().getUin()) {
            f47594i = o16.mFacadeCacheData;
        }
        return o16.mFacadeCacheData;
    }

    public String i() {
        return "facade";
    }

    public String j() {
        if (TextUtils.isEmpty(this.f47597e)) {
            this.f47597e = ImageManager.getCachePath(BaseApplication.getContext(), "facade");
        }
        return this.f47597e;
    }

    public String m() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(2) + "" + calendar.get(5);
    }

    public synchronized UserFacadeCacheData o(long j3) {
        return (UserFacadeCacheData) n().k0("uin=?", new String[]{"" + j3});
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3 = qZoneTask.mType;
        if (i3 == 1) {
            r(qZoneTask);
        } else {
            if (i3 != 2) {
                return;
            }
            q(qZoneTask);
        }
    }

    public void v(QzmallFacade qzmallFacade, long j3) {
        Facade facade;
        long uin = LoginData.getInstance().getUin();
        if (qzmallFacade == null || (facade = qzmallFacade.stFacade) == null) {
            if (j3 == uin) {
                t(LoginData.getInstance().getUin(), 0);
                return;
            }
            return;
        }
        if (facade == null || TextUtils.isEmpty(facade.strId)) {
            return;
        }
        FacadeCacheData createFromJce = FacadeCacheData.createFromJce(qzmallFacade.stFacade, j3);
        if (createFromJce != null && !TextUtils.isEmpty(createFromJce.mId) && !createFromJce.mId.equals("-1")) {
            n().o0(new UserFacadeCacheData(j3, createFromJce), 1);
            if (uin == j3) {
                g.l().m(new b(uin));
            }
            if (NetworkState.isWifiConn() || uin == j3) {
                g.l().k(createFromJce.mId, createFromJce.getImageWithoutAvatarUrls());
                if (p() && !TextUtils.isEmpty(createFromJce.getTransparentVideoBgUrl())) {
                    FacadeVideoDownLoaderManager.e().b(createFromJce.getTransparentVideoBgUrl());
                } else {
                    FacadeVideoDownLoaderManager.e().b(createFromJce.getVideoBgUrl());
                }
            }
            if (uin == j3) {
                t(LoginData.getInstance().getUin(), qzmallFacade.iShowOnFriDyn);
                f47595m = qzmallFacade.iShowOnFriDyn;
                return;
            }
            return;
        }
        if (LoginData.getInstance().getUin() == j3) {
            t(j3, 0);
            x(null);
            f47595m = 0;
        }
        n().o0(new UserFacadeCacheData(j3, null), 1);
    }

    public void w(boolean z16) {
        C = z16;
    }

    public void x(FacadeCacheData facadeCacheData) {
        f47594i = facadeCacheData;
    }

    public void y() {
        n().o0(new UserFacadeCacheData(LoginData.getInstance().getUin(), null), 1);
    }

    public void z(ArrayList<ConfigArea> arrayList) {
        Collections.sort(arrayList, this.f47599h);
    }

    private void c(d dVar) {
        DbCacheManager dbCacheManager;
        if (dVar == null) {
            return;
        }
        if (0 != dVar.f47603a || (dbCacheManager = dVar.f47604b) == null || dbCacheManager.isClosed()) {
            dVar.f47603a = 0L;
            DbCacheManager e16 = com.qzone.component.cache.database.c.g().e(dVar.f47606d, 0L, dVar.f47605c);
            dVar.f47604b = e16;
            e16.U(dVar.f47607e);
        }
    }

    public void u(boolean z16, boolean z17) {
        if (z17) {
            D = true;
        }
        if (!z16) {
            u5.b.x0(QzoneConfig.FACATE_LOCAL_DATE, m(), LoginData.getInstance().getUin());
        } else {
            u5.b.x0(QzoneConfig.FACATE_LOCAL_DATE, "", LoginData.getInstance().getUin());
        }
    }

    private List<String> k(List<FacadeCacheData> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<FacadeCacheData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getImageWithoutAvatarUrls());
        }
        return arrayList;
    }

    private void r(QZoneTask qZoneTask) {
        mobile_facade_get_rsp mobile_facade_get_rspVar = (mobile_facade_get_rsp) qZoneTask.mRequest.rsp;
        QZoneResult result = qZoneTask.getResult(1000095);
        if (result.getSucceed() && mobile_facade_get_rspVar != null) {
            Long l3 = (Long) qZoneTask.getParameter("uin");
            if (mobile_facade_get_rspVar.iCode == -13200) {
                s(BaseApplication.getContext(), LoginData.getInstance().getUin(), "");
                if (LoginData.getInstance().getUin() == l3.longValue()) {
                    t(LoginData.getInstance().getUin(), 0);
                }
            } else {
                FacadeCacheData createFromJce = FacadeCacheData.createFromJce(mobile_facade_get_rspVar.stFacade, l3.longValue());
                if (createFromJce != null && !TextUtils.isEmpty(createFromJce.mId) && !createFromJce.mId.equals("-1")) {
                    n().o0(new UserFacadeCacheData(l3.longValue(), createFromJce), 1);
                    g.l().k(createFromJce.mId, createFromJce.getImageUrls());
                    if (p() && !TextUtils.isEmpty(createFromJce.getTransparentVideoBgUrl())) {
                        FacadeVideoDownLoaderManager.e().b(createFromJce.getTransparentVideoBgUrl());
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("op", "set");
                        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(LoginData.getInstance().getUinString(), "qzone_jalpha_video", true, 0L, 0L, hashMap, null);
                    } else {
                        FacadeVideoDownLoaderManager.e().b(createFromJce.getVideoBgUrl());
                    }
                    Map<String, String> map = mobile_facade_get_rspVar.mapExtInfo;
                    if (map != null) {
                        map.get("visit_right");
                    }
                    if (l3.longValue() == LoginData.getInstance().getUin()) {
                        t(LoginData.getInstance().getUin(), mobile_facade_get_rspVar.iShowOnFriDyn);
                    }
                    result.setData(createFromJce);
                    result.setSucceed(true);
                } else {
                    s(BaseApplication.getContext(), LoginData.getInstance().getUin(), "");
                    if (LoginData.getInstance().getUin() == l3.longValue()) {
                        t(l3.longValue(), 0);
                        x(null);
                        f47595m = 0;
                    }
                    n().o0(new UserFacadeCacheData(l3.longValue(), null), 1);
                }
            }
        }
        qZoneTask.sendResultMsg(result);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements com.qzone.homepage.ui.Facade.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f47600a;

        b(long j3) {
            this.f47600a = j3;
        }

        @Override // com.qzone.homepage.ui.Facade.a
        public void e(String str, int i3, int i16, String str2) {
            if (h.D) {
                h.this.h(this.f47600a);
                h.D = false;
            }
        }

        @Override // com.qzone.homepage.ui.Facade.a
        public void a(String str, int i3) {
        }

        @Override // com.qzone.homepage.ui.Facade.a
        public void c(String str, int i3, int i16) {
        }

        @Override // com.qzone.homepage.ui.Facade.a
        public void b(String str, int i3, int i16, String str2) {
        }

        @Override // com.qzone.homepage.ui.Facade.a
        public void d(String str, int i3, int i16, String str2) {
        }
    }
}
