package com.tencent.biz.pubaccount.weishi.verticalvideo.data;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSRecommendRequest;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.dv;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.web.api.IVasAdvWeb;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSVerticalDataManager {

    /* renamed from: d, reason: collision with root package name */
    private static String f81938d = "";

    /* renamed from: a, reason: collision with root package name */
    private volatile String f81939a = "";

    /* renamed from: b, reason: collision with root package name */
    private volatile String f81940b = "";

    /* renamed from: c, reason: collision with root package name */
    private volatile String f81941c = "";

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public List<j> f81948a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f81949b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f81950c;

        /* renamed from: d, reason: collision with root package name */
        public Object f81951d;

        public b(List<j> list, boolean z16, boolean z17, Object obj) {
            this.f81948a = list;
            this.f81949b = z16;
            this.f81950c = z17;
            this.f81951d = obj;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final WSVerticalDataManager f81952a = new WSVerticalDataManager();
    }

    WSVerticalDataManager() {
    }

    public static WSVerticalDataManager j() {
        return c.f81952a;
    }

    private void k(ArrayList<stSimpleMetaFeed> arrayList) {
        if (CollectionUtils.isEmpty(arrayList)) {
            return;
        }
        dv.g(arrayList.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b m(com.tencent.biz.pubaccount.weishi.net.common.g<stSimpleGetFeedListRsp> gVar, stSimpleGetFeedListRsp stsimplegetfeedlistrsp, com.tencent.biz.pubaccount.weishi.net.d dVar, boolean z16, jz.c<j> cVar, boolean z17, Object obj, long j3) {
        x.i("weishi-beacon", "\u8bf7\u6c42\u64ad\u653e\u9875\uff08\u63a8\u8350)\u8017\u65f6\uff1a" + (System.currentTimeMillis() - j3) + "\u6beb\u79d2");
        if (z16) {
            o(stsimplegetfeedlistrsp, cVar, gVar != null ? gVar.getRequestScene() : 2);
        }
        this.f81940b = stsimplegetfeedlistrsp.attach_info;
        this.f81939a = stsimplegetfeedlistrsp.session;
        if (!TextUtils.isEmpty(stsimplegetfeedlistrsp.gdt_args)) {
            r(stsimplegetfeedlistrsp.gdt_args);
            p(stsimplegetfeedlistrsp.gdt_args);
        }
        if (dVar != null) {
            com.tencent.biz.pubaccount.weishi.report.c.b().d(stsimplegetfeedlistrsp.trace_id, dVar.f80962a);
        }
        ArrayList<stSimpleMetaFeed> arrayList = stsimplegetfeedlistrsp.feeds;
        k(arrayList);
        List<j> e16 = i.e(arrayList, false);
        x.j("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] itemDataList size:" + e16.size() + ", isRefresh:" + z17 + ", isFirst:" + z16 + ", mAttachInfo:" + this.f81940b + ", mLastSession:" + this.f81939a + ", gdtArgs:" + f81938d);
        return new b(e16, z17, z16, obj);
    }

    private void o(stSimpleGetFeedListRsp stsimplegetfeedlistrsp, jz.c<j> cVar, int i3) {
        if (cVar instanceof AbsWSVerticalPagePresenter) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = ((AbsWSVerticalPagePresenter) cVar).O0();
            WSVerticalPageFragment wSVerticalPageFragment = O0 instanceof WSVerticalPageFragment ? (WSVerticalPageFragment) O0 : null;
            if (wSVerticalPageFragment == null || wSVerticalPageFragment.getBaseActivity() == null || wSVerticalPageFragment.getBaseActivity().isFinishing()) {
                return;
            }
            iz.a.g().s(i3, stsimplegetfeedlistrsp.config);
        }
    }

    private void p(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("h5_render_param");
            if (optJSONObject == null) {
                str2 = "";
            } else {
                str2 = optJSONObject.optString("h5_url");
            }
            this.f81941c = str2;
            x.c("WSVerticalDataManagerLog", "h5 url from gdt_args: " + this.f81941c);
            if (TextUtils.isEmpty(this.f81941c)) {
                return;
            }
            ((IVasAdvWeb) QRoute.api(IVasAdvWeb.class)).initWebView();
        } catch (Exception e16) {
            this.f81941c = "";
            GdtLog.e("WSVerticalDataManagerLog", "Error when get conf from gdt_args", e16);
        }
    }

    private void q(boolean z16, boolean z17) {
        if (z17 || z16) {
            this.f81940b = "";
            f81938d = "";
            this.f81939a = "";
            this.f81941c = "";
        }
        if (TextUtils.isEmpty(f81938d)) {
            r("");
        }
    }

    public static void r(String str) {
        GdtLog.d("WSVerticalDataManagerLog", "setGdtArgs start = " + f81938d);
        if (TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("gdt_pageindex", 0);
                f81938d = jSONObject.toString();
                String string = LocalMultiProcConfig.getString("cache_key_gdt_args", "");
                if (!TextUtils.isEmpty(string)) {
                    GdtLog.d("WSVerticalDataManagerLog", "setGdtArgs getDeviceInfo ok" + f81938d);
                    f(new JSONObject(string), jSONObject);
                    return;
                }
                GdtLog.d("WSVerticalDataManagerLog", "setGdtArgs deviceInfo is null " + f81938d);
            } catch (JSONException e16) {
                GdtLog.e("WSVerticalDataManagerLog", "setGdtArgs", e16);
            }
        } else {
            f81938d = str;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.data.WSVerticalDataManager.2
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2;
                GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(BaseApplication.getContext(), new GdtDeviceInfoHelper.Params());
                if (create != null) {
                    qq_ad_get.QQAdGet.DeviceInfo deviceInfo = create.deviceInfo;
                    if (deviceInfo != null) {
                        try {
                            Object pbToJson = GdtJsonPbUtil.pbToJson(deviceInfo);
                            if (pbToJson != null && (pbToJson instanceof JSONObject)) {
                                jSONObject2 = (JSONObject) JSONObject.class.cast(pbToJson);
                                LocalMultiProcConfig.putString("cache_key_gdt_args", jSONObject2.toString());
                                JSONObject jSONObject3 = new JSONObject(WSVerticalDataManager.f81938d);
                                if (jSONObject2 == null && jSONObject2 != JSONObject.NULL) {
                                    WSVerticalDataManager.f(jSONObject2, jSONObject3);
                                } else {
                                    GdtLog.e("WSVerticalDataManagerLog", "onResult error");
                                }
                                GdtLog.d("WSVerticalDataManagerLog", "setGdtArgs success args =" + WSVerticalDataManager.f81938d);
                            }
                        } catch (JSONException e17) {
                            GdtLog.d("WSVerticalDataManagerLog", e17.getMessage());
                            return;
                        }
                    }
                    jSONObject2 = null;
                    JSONObject jSONObject32 = new JSONObject(WSVerticalDataManager.f81938d);
                    if (jSONObject2 == null) {
                    }
                    GdtLog.e("WSVerticalDataManagerLog", "onResult error");
                    GdtLog.d("WSVerticalDataManagerLog", "setGdtArgs success args =" + WSVerticalDataManager.f81938d);
                }
            }
        });
    }

    public String i() {
        return this.f81941c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z16, boolean z17, com.tencent.biz.pubaccount.weishi.net.common.j jVar, jz.c<j> cVar) {
        if (cVar != null) {
            cVar.i(jVar.a(), jVar.b(), z16, z17);
        }
    }

    public void g(k kVar, jz.c<j> cVar) {
        String str;
        int f16 = kVar.f();
        boolean j3 = kVar.j();
        boolean i3 = kVar.i();
        String g16 = kVar.g();
        String e16 = kVar.e();
        Object d16 = kVar.d();
        ArrayList<String> c16 = kVar.c();
        Map<String, Integer> h16 = kVar.h();
        long currentTimeMillis = System.currentTimeMillis();
        q(j3, i3);
        x.f("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][fetchVerticalListData] " + kVar + ", attachInfo:" + this.f81940b + ", lastSession:" + this.f81939a + ", videoFeedTypeMap:" + h16 + ", gdtArgs:" + f81938d);
        if (j3) {
            str = "";
        } else {
            str = this.f81940b;
        }
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSRecommendRequest(str, j3 ? (byte) 1 : (byte) 0, i3 ? (byte) 1 : (byte) 0, c16, f16, f81938d, "", this.f81939a, e16, g16, null, h16, null)).b(new a(i3, cVar, j3, d16, currentTimeMillis));
    }

    public void h(boolean z16, jz.d<j> dVar) {
        if (z16) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.data.module.b.a().a(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            jSONObject.put("deep_link_version", 1);
            jSONObject2.put("device_info", jSONObject);
            f81938d = jSONObject2.toString();
        } catch (JSONException e16) {
            GdtLog.e("WSVerticalDataManagerLog", "onResult", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(b bVar, jz.c<j> cVar) {
        if (bVar == null || cVar == null) {
            return;
        }
        cVar.d0(bVar.f81948a, bVar.f81949b, bVar.f81950c, bVar.f81951d);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends com.tencent.biz.pubaccount.weishi.net.common.b<stSimpleGetFeedListRsp, b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f81942a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ jz.c f81943b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f81944c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f81945d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f81946e;

        a(boolean z16, jz.c cVar, boolean z17, Object obj, long j3) {
            this.f81942a = z16;
            this.f81943b = cVar;
            this.f81944c = z17;
            this.f81945d = obj;
            this.f81946e = j3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
            super.b(jVar);
            WSVerticalDataManager.this.l(this.f81942a, this.f81944c, jVar, this.f81943b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public b c(com.tencent.biz.pubaccount.weishi.net.common.g<stSimpleGetFeedListRsp> gVar, stSimpleGetFeedListRsp stsimplegetfeedlistrsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            return WSVerticalDataManager.this.m(gVar, stsimplegetfeedlistrsp, dVar, this.f81942a, this.f81943b, this.f81944c, this.f81945d, this.f81946e);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(b bVar) {
            super.d(bVar);
            WSVerticalDataManager.this.n(bVar, this.f81943b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
        }
    }
}
