package com.tencent.mapsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.map.sdk.comps.offlinemap.OfflineCity;
import com.tencent.map.sdk.comps.offlinemap.OfflineItem;
import com.tencent.map.sdk.comps.offlinemap.OfflineItemController;
import com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent;
import com.tencent.map.sdk.comps.offlinemap.OfflineMapSyncedListener;
import com.tencent.map.sdk.comps.offlinemap.OfflineNation;
import com.tencent.map.sdk.comps.offlinemap.OfflineProvince;
import com.tencent.map.sdk.comps.offlinemap.OfflineStatusChangedListener;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateRsp;
import com.tencent.mapsdk.core.components.protocol.jce.conf.SCFileUpdateRsp;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ca;
import com.tencent.mapsdk.internal.ec;
import com.tencent.mapsdk.internal.ed;
import com.tencent.mapsdk.internal.ee;
import com.tencent.mapsdk.internal.kp;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: P */
/* loaded from: classes9.dex */
public class cc extends bo implements OfflineMapComponent, ca.a {

    /* renamed from: b, reason: collision with root package name */
    public static final String f148001b = "key_offline_map_opened_cities";

    /* renamed from: c, reason: collision with root package name */
    public static final String f148002c = "key_offline_map_config_version";

    /* renamed from: d, reason: collision with root package name */
    public static final String f148003d = "key_offline_map_config_md5";

    /* renamed from: e, reason: collision with root package name */
    public static final String f148004e = "key_offline_map_config_url";

    /* renamed from: f, reason: collision with root package name */
    public static final String f148005f = "sdk_offline_city_ver.json";

    /* renamed from: g, reason: collision with root package name */
    public static final String f148006g = "offline_city_list.json";

    /* renamed from: h, reason: collision with root package name */
    private static final String f148007h = "key_offline_map_items_state";

    /* renamed from: i, reason: collision with root package name */
    private mv f148008i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f148009j;

    /* renamed from: n, reason: collision with root package name */
    private File f148013n;

    /* renamed from: o, reason: collision with root package name */
    private File f148014o;

    /* renamed from: p, reason: collision with root package name */
    private String f148015p;

    /* renamed from: q, reason: collision with root package name */
    private cd f148016q;

    /* renamed from: s, reason: collision with root package name */
    private volatile Callback<List<OfflineItem>> f148018s;

    /* renamed from: t, reason: collision with root package name */
    private WeakReference<OfflineMapSyncedListener> f148019t;

    /* renamed from: u, reason: collision with root package name */
    private volatile boolean f148020u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f148021v;

    /* renamed from: k, reason: collision with root package name */
    private List<OfflineItem> f148010k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    private List<OfflineItem> f148011l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private final Map<String, a> f148012m = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    private final Map<cb, ca> f148017r = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends JsonComposer {

        /* renamed from: a, reason: collision with root package name */
        String f148024a;

        /* renamed from: b, reason: collision with root package name */
        int f148025b;

        /* renamed from: c, reason: collision with root package name */
        boolean f148026c;

        a() {
        }
    }

    static /* synthetic */ Callback b(cc ccVar) {
        ccVar.f148018s = null;
        return null;
    }

    static /* synthetic */ boolean c(cc ccVar) {
        ccVar.f148020u = false;
        return false;
    }

    private void h() {
        cd cdVar = this.f148016q;
        if (cdVar == null || cdVar.f148031e == null || this.f148010k.isEmpty()) {
            return;
        }
        LogUtil.c(ky.f149116v, "\u6dfb\u52a0item\u7684\u6570\u636e\u72b6\u6001");
        Set<String> keySet = this.f148012m.keySet();
        for (OfflineItem offlineItem : this.f148010k) {
            Iterator<cb> it = this.f148016q.f148031e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (offlineItem.getPinyin().equals(it.next().f147998c)) {
                        offlineItem.setSize(r5.f147999d);
                        Iterator<String> it5 = keySet.iterator();
                        while (true) {
                            if (it5.hasNext()) {
                                if (offlineItem.getPinyin().equals(it5.next())) {
                                    ca a16 = a(offlineItem, (OfflineStatusChangedListener) null);
                                    if (a16 != null) {
                                        offlineItem.setUpgrade(a16.checkInvalidate());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        LogUtil.c(ky.f149116v, "\u6dfb\u52a0item\u7684\u6570\u636e\u72b6\u6001\u5b8c\u6210\uff01\uff01");
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final void c_() {
        super.c_();
        for (Map.Entry<cb, ca> entry : this.f148017r.entrySet()) {
            ca value = entry.getValue();
            if (value != null) {
                value.f147977b = null;
                value.f147976a = null;
            }
            entry.setValue(null);
        }
        this.f148017r.clear();
        this.f148018s = null;
        this.f148019t = null;
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent
    public OfflineItemController getOfflineItemController(OfflineItem offlineItem, OfflineStatusChangedListener offlineStatusChangedListener) {
        if (!this.f148009j) {
            return null;
        }
        return a(offlineItem, offlineStatusChangedListener);
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent
    public synchronized List<OfflineItem> getOfflineItemList() {
        for (OfflineItem offlineItem : this.f148010k) {
            a aVar = this.f148012m.get(offlineItem.getPinyin());
            if (aVar != null) {
                offlineItem.setPercentage(aVar.f148025b);
                offlineItem.setUpgrade(aVar.f148026c);
            }
        }
        return this.f148011l;
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent
    public boolean isOfflineMapEnable() {
        return this.f148009j;
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent
    public void syncLatestData(OfflineMapSyncedListener offlineMapSyncedListener) {
        this.f148019t = new WeakReference<>(offlineMapSyncedListener);
        if (!this.f148020u) {
            e(getMapContext());
        }
    }

    private void e(bp bpVar) {
        String b16 = this.f148008i.b(f148001b, "");
        if (this.f148009j || !TextUtils.isEmpty(b16)) {
            hi hiVar = bpVar.f147918e;
            if (hiVar != null) {
                hiVar.p().a();
            }
            if (this.f148020u) {
                return;
            }
            this.f148020u = true;
            kp.a((kp.g) new kp.g<Object>() { // from class: com.tencent.mapsdk.internal.cc.2
                @Override // java.util.concurrent.Callable
                public final Object call() throws Exception {
                    cc.this.f148021v = false;
                    if (!cc.this.f148009j) {
                        cc ccVar = cc.this;
                        cc.a(ccVar, ccVar.getMapContext());
                        return null;
                    }
                    cc ccVar2 = cc.this;
                    ccVar2.f148021v = ccVar2.f();
                    cc ccVar3 = cc.this;
                    ccVar3.f148021v = cc.h(ccVar3);
                    return null;
                }
            }).a((kp.b.a) null, (kp.a<kp.b.a>) new kp.a<Object>() { // from class: com.tencent.mapsdk.internal.cc.1
                @Override // com.tencent.mapsdk.internal.kp.a, com.tencent.map.tools.Callback
                public final void callback(Object obj) {
                    OfflineMapSyncedListener offlineMapSyncedListener;
                    if (cc.this.f148018s != null) {
                        cc.this.f148018s.callback(cc.this.getOfflineItemList());
                        cc.b(cc.this);
                    }
                    cc.c(cc.this);
                    if (cc.this.f148019t != null && (offlineMapSyncedListener = (OfflineMapSyncedListener) cc.this.f148019t.get()) != null) {
                        offlineMapSyncedListener.onSynced(cc.this.f148021v);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() throws FileNotFoundException {
        bp mapContext = getMapContext();
        if (mapContext == null) {
            return false;
        }
        int b16 = this.f148008i.b(f148002c);
        String a16 = this.f148008i.a(f148003d);
        LogUtil.c(ky.f149116v, "\u68c0\u67e5\u79bb\u7ebf\u914d\u7f6e\u66f4\u65b0, \u5f53\u524dv:" + b16 + "|md5:" + a16 + "obj:" + this);
        du duVar = (du) cr.a(du.class);
        ArrayList<FileUpdateReq> arrayList = new ArrayList<>();
        FileUpdateReq fileUpdateReq = new FileUpdateReq(f148005f, b16, a16);
        arrayList.add(fileUpdateReq);
        ed.a<SCFileUpdateRsp> checkUpdate = ((df) duVar.i()).checkUpdate(ho.i(), ho.d(), ho.m(), ho.g(), mapContext.D().b(), arrayList, mapContext.D().b(), mapContext.G(), "", mapContext.F(), "");
        LogUtil.c(ky.f149116v, "\u79bb\u7ebf\u914d\u7f6e\u8bf7\u6c42\u66f4\u65b0\u7ed3\u675f\uff1a" + checkUpdate.toHumanString());
        if (checkUpdate.available()) {
            FileUpdateRsp fileUpdateRsp = checkUpdate.f148149a.vItems.get(0);
            String a17 = this.f148013n.exists() ? li.a(this.f148013n) : null;
            if (this.f148013n.exists() && (fileUpdateRsp == null || !f148005f.equals(fileUpdateRsp.sName) || fileUpdateRsp.iVersion == fileUpdateReq.iVersion || TextUtils.isEmpty(fileUpdateRsp.sUpdateUrl) || fileUpdateRsp.iFileSize == 0 || fileUpdateRsp.iFileUpdated == 0 || TextUtils.isEmpty(fileUpdateRsp.sMd5) || fileUpdateRsp.sMd5.equals(a17))) {
                LogUtil.c(ky.f149116v, "\u8df3\u8fc7\u66f4\u65b0");
            } else {
                String str = fileUpdateRsp.sUpdateUrl;
                String str2 = fileUpdateRsp.sMd5;
                int i3 = fileUpdateRsp.iVersion;
                if (fileUpdateRsp.iFileUpdated == 0 && !this.f148013n.exists()) {
                    str = this.f148008i.b(f148004e, "");
                    str2 = this.f148008i.b(f148003d, "");
                    i3 = this.f148008i.b(f148002c, 0);
                }
                if (TextUtils.isEmpty(str)) {
                    LogUtil.d(ky.f149116v, "\u79bb\u7ebf\u914d\u7f6e\u6587\u4ef6\u7684\u8bf7\u6c42\u94fe\u63a5\u4e3a\u7a7a\uff01");
                    return false;
                }
                if (NetManager.getInstance().builder().url(str).downloadTo(this.f148013n).available()) {
                    if (li.a(this.f148013n).equals(str2)) {
                        LogUtil.c(ky.f149116v, "\u79bb\u7ebf\u914d\u7f6e\u6587\u4ef6\u4e0b\u8f7d\u6210\u529f");
                        this.f148008i.a(f148002c, i3);
                        this.f148008i.a(f148003d, str2);
                        this.f148008i.a(f148004e, str);
                    } else {
                        LogUtil.c(ky.f149116v, "\u79bb\u7ebf\u914d\u7f6e\u6587\u4ef6MD5\u6821\u9a8c\u5931\u8d25");
                        kt.b(this.f148013n);
                    }
                }
            }
        } else {
            LogUtil.c(ky.f149116v, "\u79bb\u7ebf\u5730\u56fe\u914d\u7f6e\u8bf7\u6c42\u9519\u8bef\uff1a" + checkUpdate.toHumanString());
        }
        if (this.f148013n.exists()) {
            try {
                Object nextValue = new JSONTokener(new String(kt.c(this.f148013n))).nextValue();
                if (nextValue instanceof JSONObject) {
                    this.f148016q = (cd) JsonUtils.parseToModel((JSONObject) nextValue, cd.class, new Object[0]);
                    LogUtil.c(ky.f149116v, "\u521b\u5efa\u79bb\u7ebf\u914d\u7f6e\u6587\u4ef6\u5bf9\u8c61\u6570\u636e\uff1a" + this.f148016q);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        } else {
            LogUtil.d(ky.f149116v, "\u79bb\u7ebf\u914d\u7f6e\u6587\u4ef6\u4e0d\u5b58\u5728\uff01");
        }
        if (this.f148016q == null) {
            return false;
        }
        LogUtil.c(ky.f149116v, "\u83b7\u5f97\u79bb\u7ebf\u914d\u7f6e\u6210\u529f\uff01");
        return true;
    }

    private boolean g() throws JSONException {
        if (!this.f148014o.exists()) {
            LogUtil.c(ky.f149116v, "\u8bf7\u6c42\u79bb\u7ebf\u57ce\u5e02\u5217\u8868...");
            ec.a downloadOfflineMapCityList = ((df) ((du) cr.a(du.class)).i()).downloadOfflineMapCityList(this.f148015p);
            downloadOfflineMapCityList.charset = "utf-8";
            if (downloadOfflineMapCityList.available()) {
                LogUtil.c(ky.f149116v, "\u79bb\u7ebf\u57ce\u5e02\u5217\u8868\u4e0b\u8f7d\u6210\u529f");
                ee.a aVar = new ee.a(downloadOfflineMapCityList);
                if (aVar.available()) {
                    a(aVar.f148151a);
                    LogUtil.c(ky.f149116v, "\u79bb\u7ebf\u57ce\u5e02\u5217\u8868\u89e3\u6790\u6210\u529f");
                }
            }
        } else {
            a(new String(kt.c(this.f148014o)));
            LogUtil.c(ky.f149116v, "\u79bb\u7ebf\u57ce\u5e02\u5217\u8868\u4f7f\u7528\u7f13\u5b58");
        }
        List<OfflineItem> list = this.f148010k;
        if (list == null || list.isEmpty()) {
            return false;
        }
        LogUtil.c(ky.f149116v, "\u83b7\u5f97\u79bb\u7ebf\u57ce\u5e02\u5217\u8868\u6210\u529f\uff01");
        return true;
    }

    @Override // com.tencent.mapsdk.internal.ca.a
    public final void b(OfflineItem offlineItem, boolean z16) {
        if (offlineItem == null) {
            return;
        }
        String pinyin = offlineItem.getPinyin();
        a aVar = this.f148012m.get(pinyin);
        if (aVar == null) {
            aVar = new a();
            this.f148012m.put(pinyin, aVar);
        }
        aVar.f148024a = pinyin;
        aVar.f148026c = z16;
        offlineItem.setUpgrade(z16);
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final void d(bp bpVar) {
        super.d(bpVar);
        if (this.f148020u) {
            this.f148018s = null;
            this.f148020u = false;
        }
        if (this.f148012m.isEmpty()) {
            return;
        }
        String collectionToJson = JsonUtils.collectionToJson(this.f148012m.values());
        LogUtil.c(ky.f149116v, "\u4fdd\u5b58\u6301\u4e45\u5316\u72b6\u6001, json\uff1a".concat(String.valueOf(collectionToJson)));
        this.f148008i.a(f148007h, collectionToJson);
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final void a(Context context) {
        super.a(context);
        mz a16 = mz.a(context, (TencentMapOptions) null);
        ku.a(a16.f149362e);
        this.f148015p = a16.f149362e;
        this.f148013n = new File(this.f148015p, f148005f);
        this.f148014o = new File(this.f148015p, f148006g);
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent
    public void getOfflineItemList(Callback<List<OfflineItem>> callback) {
        this.f148018s = callback;
        if (this.f148020u) {
            return;
        }
        e(getMapContext());
    }

    private List<OfflineItem> e() {
        List<OfflineItem> list;
        ArrayList arrayList = new ArrayList();
        String[] split = this.f148008i.b(f148001b, "").split(",");
        if (split.length != 0 && (list = this.f148010k) != null) {
            for (OfflineItem offlineItem : list) {
                if (Arrays.binarySearch(split, offlineItem.getPinyin()) >= 0) {
                    arrayList.add(offlineItem);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mapsdk.internal.bo
    public final void a(bp bpVar) {
        super.a(bpVar);
        this.f148009j = bpVar.f147915b.isOfflineMapEnable();
        mv a16 = mx.a(c(), bpVar.D().f147927c);
        this.f148008i = a16;
        String b16 = a16.b(f148007h, "");
        LogUtil.c(ky.f149116v, "\u83b7\u53d6\u6301\u4e45\u5316\u72b6\u6001, json\uff1a".concat(String.valueOf(b16)));
        if (!TextUtils.isEmpty(b16)) {
            try {
                for (a aVar : JsonUtils.parseToList(new JSONArray(b16), a.class, new Object[0])) {
                    this.f148012m.put(aVar.f148024a, aVar);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        e(bpVar);
    }

    static /* synthetic */ boolean h(cc ccVar) throws JSONException {
        if (!ccVar.f148014o.exists()) {
            LogUtil.c(ky.f149116v, "\u8bf7\u6c42\u79bb\u7ebf\u57ce\u5e02\u5217\u8868...");
            ec.a downloadOfflineMapCityList = ((df) ((du) cr.a(du.class)).i()).downloadOfflineMapCityList(ccVar.f148015p);
            downloadOfflineMapCityList.charset = "utf-8";
            if (downloadOfflineMapCityList.available()) {
                LogUtil.c(ky.f149116v, "\u79bb\u7ebf\u57ce\u5e02\u5217\u8868\u4e0b\u8f7d\u6210\u529f");
                ee.a aVar = new ee.a(downloadOfflineMapCityList);
                if (aVar.available()) {
                    ccVar.a(aVar.f148151a);
                    LogUtil.c(ky.f149116v, "\u79bb\u7ebf\u57ce\u5e02\u5217\u8868\u89e3\u6790\u6210\u529f");
                }
            }
        } else {
            ccVar.a(new String(kt.c(ccVar.f148014o)));
            LogUtil.c(ky.f149116v, "\u79bb\u7ebf\u57ce\u5e02\u5217\u8868\u4f7f\u7528\u7f13\u5b58");
        }
        List<OfflineItem> list = ccVar.f148010k;
        if (list == null || list.isEmpty()) {
            return false;
        }
        LogUtil.c(ky.f149116v, "\u83b7\u5f97\u79bb\u7ebf\u57ce\u5e02\u5217\u8868\u6210\u529f\uff01");
        return true;
    }

    private synchronized void a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Object nextValue = new JSONTokener(str).nextValue();
        if (nextValue instanceof JSONArray) {
            List<bz> parseToList = JsonUtils.parseToList((JSONArray) nextValue, bz.class, new Object[0]);
            if (!parseToList.isEmpty()) {
                this.f148010k = new ArrayList();
                this.f148011l = new ArrayList();
                for (bz bzVar : parseToList) {
                    if (bzVar.f147969b.startsWith(sm.f150328a)) {
                        OfflineNation offlineNation = new OfflineNation();
                        offlineNation.setName(bzVar.f147968a);
                        offlineNation.setPinyin(bzVar.f147969b);
                        this.f148011l.add(offlineNation);
                        this.f148010k.add(offlineNation);
                    } else {
                        List<bz> list = bzVar.f147970c;
                        if (list != null && !list.isEmpty()) {
                            ArrayList arrayList = new ArrayList();
                            OfflineProvince offlineProvince = new OfflineProvince();
                            offlineProvince.setName(bzVar.f147968a);
                            offlineProvince.setPinyin(bzVar.f147969b);
                            offlineProvince.setCities(arrayList);
                            this.f148011l.add(offlineProvince);
                            Iterator<bz> it = bzVar.f147970c.iterator();
                            while (it.hasNext()) {
                                OfflineCity a16 = it.next().a(offlineProvince);
                                this.f148010k.add(a16);
                                arrayList.add(a16);
                            }
                        } else {
                            OfflineCity a17 = bzVar.a((OfflineProvince) null);
                            this.f148011l.add(a17);
                            this.f148010k.add(a17);
                        }
                    }
                }
                h();
            }
        }
    }

    private ca a(OfflineItem offlineItem, OfflineStatusChangedListener offlineStatusChangedListener) {
        List<OfflineItem> list;
        boolean z16;
        bp mapContext = getMapContext();
        if (offlineItem != null && (list = this.f148010k) != null && this.f148016q != null && mapContext != null) {
            Iterator<OfflineItem> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = false;
                    break;
                }
                if (it.next() == offlineItem) {
                    z16 = true;
                    break;
                }
            }
            if (z16) {
                cb a16 = this.f148016q.a(offlineItem);
                if (a16 != null) {
                    ca caVar = this.f148017r.get(a16);
                    if (caVar == null) {
                        ca caVar2 = new ca(mapContext, this.f148015p, offlineItem, a16, this.f148008i, offlineStatusChangedListener);
                        this.f148017r.put(a16, caVar2);
                        caVar = caVar2;
                    }
                    caVar.f147976a = offlineStatusChangedListener;
                    caVar.f147977b = this;
                    LogUtil.c(ky.f149116v, "\u83b7\u5f97\u79bb\u7ebf\u57ce\u5e02[" + offlineItem.getName() + "]\u7684\u914d\u7f6e\u6210\u529f\uff01");
                    return caVar;
                }
            } else {
                LogUtil.d(ky.f149116v, "\u65e0\u6548\u57ce\u5e02\uff1a".concat(String.valueOf(offlineItem)));
            }
            return null;
        }
        LogUtil.d(ky.f149116v, "\u65e0\u6548\u914d\u7f6e config:" + this.f148016q + "|item:" + offlineItem);
        return null;
    }

    private void f(bp bpVar) {
        List<OfflineItem> list;
        ArrayList arrayList = new ArrayList();
        String[] split = this.f148008i.b(f148001b, "").split(",");
        if (split.length != 0 && (list = this.f148010k) != null) {
            for (OfflineItem offlineItem : list) {
                if (Arrays.binarySearch(split, offlineItem.getPinyin()) >= 0) {
                    arrayList.add(offlineItem);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ca a16 = a((OfflineItem) it.next(), (OfflineStatusChangedListener) null);
            if (a16 != null) {
                a16.b(bpVar);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.ca.a
    public final void a(OfflineItem offlineItem, boolean z16) {
        String b16 = this.f148008i.b(f148001b, "");
        LogUtil.c(ky.f149116v, "\u5f53\u524d\u5f00\u542f\u57ce\u5e02IDS\uff1a".concat(String.valueOf(b16)));
        String[] split = b16.split(",");
        int binarySearch = Arrays.binarySearch(split, offlineItem.getPinyin());
        if (z16) {
            if (binarySearch < 0) {
                String str = b16 + offlineItem.getPinyin() + ",";
                LogUtil.c(ky.f149116v, "\u65b0\u589e\u5f00\u542f\u57ce\u5e02IDS\uff1a".concat(String.valueOf(str)));
                this.f148008i.a(f148001b, str);
                return;
            }
            return;
        }
        if (binarySearch >= 0) {
            StringBuilder sb5 = new StringBuilder();
            for (String str2 : split) {
                if (!str2.equals(offlineItem.getPinyin())) {
                    sb5.append(str2);
                    sb5.append(",");
                }
            }
            String sb6 = sb5.toString();
            LogUtil.c(ky.f149116v, "\u5269\u4f59\u5f00\u542f\u57ce\u5e02IDS\uff1a".concat(String.valueOf(sb6)));
            this.f148008i.a(f148001b, sb6);
        }
    }

    @Override // com.tencent.mapsdk.internal.ca.a
    public final void a(OfflineItem offlineItem, int i3) {
        if (offlineItem == null) {
            return;
        }
        String pinyin = offlineItem.getPinyin();
        a aVar = this.f148012m.get(pinyin);
        if (aVar == null) {
            aVar = new a();
            this.f148012m.put(pinyin, aVar);
        }
        aVar.f148024a = pinyin;
        aVar.f148025b = i3;
        offlineItem.setPercentage(i3);
    }

    static /* synthetic */ void a(cc ccVar, bp bpVar) {
        List<OfflineItem> list;
        ArrayList arrayList = new ArrayList();
        String[] split = ccVar.f148008i.b(f148001b, "").split(",");
        if (split.length != 0 && (list = ccVar.f148010k) != null) {
            for (OfflineItem offlineItem : list) {
                if (Arrays.binarySearch(split, offlineItem.getPinyin()) >= 0) {
                    arrayList.add(offlineItem);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ca a16 = ccVar.a((OfflineItem) it.next(), (OfflineStatusChangedListener) null);
            if (a16 != null) {
                a16.b(bpVar);
            }
        }
    }
}
