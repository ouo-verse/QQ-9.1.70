package com.tencent.biz.pubaccount.weishi.recommend;

import UserGrowth.stCardInfo;
import UserGrowth.stCollection;
import UserGrowth.stCollectionCardInfo;
import UserGrowth.stH5OpInfo;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.qcoroutine.api.g;
import com.tencent.mobileqq.qcoroutine.api.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mz.h;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSGridItemExpose {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Integer, String> f81360a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Integer, String> f81361b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<Integer, stSimpleMetaFeed> f81362c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<Integer, String> f81363d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private final String f81364e;

    public WSGridItemExpose(String str) {
        this.f81364e = str;
    }

    private void k(stReportItem streportitem, stSimpleMetaFeed stsimplemetafeed, int i3) {
        x.c("WSFeedsItemExposeLog", "[WSGridItemExpose.java][exposeVideoCard] mSubTabId:" + this.f81364e + ", position:" + i3 + ", feedVideoType:" + stsimplemetafeed.video_type + ", title:" + stsimplemetafeed.feed_desc);
        int i16 = stsimplemetafeed.video_type;
        if (i16 != 1 && i16 != 6) {
            a.c("gzh_exposure", stsimplemetafeed, streportitem, 0, this.f81364e);
        }
        this.f81362c.put(Integer.valueOf(i3), stsimplemetafeed);
        this.f81363d.put(Integer.valueOf(i3), stsimplemetafeed.f25129id);
        if (this.f81362c.size() == 8) {
            q(this.f81362c, this.f81363d);
            this.f81362c.clear();
            this.f81363d.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(int i3, List list) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (int i16 = 0; i16 < i3; i16++) {
            if (i16 < list.size()) {
                stSimpleMetaFeed stsimplemetafeed = (stSimpleMetaFeed) list.get(i16);
                if (!this.f81360a.containsKey(Integer.valueOf(i16))) {
                    this.f81360a.put(Integer.valueOf(i16), stsimplemetafeed.f25129id);
                    x.b("weishi-report", "put:" + i16);
                    hashMap.put(Integer.valueOf(i16), stsimplemetafeed);
                    hashMap2.put(Integer.valueOf(i16), stsimplemetafeed.f25129id);
                }
            }
        }
        q(hashMap, hashMap2);
        r(hashMap, this.f81364e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(int i3, stSimpleMetaFeed stsimplemetafeed) {
        if (this.f81360a.containsKey(Integer.valueOf(i3))) {
            return;
        }
        this.f81360a.put(Integer.valueOf(i3), stsimplemetafeed.f25129id);
        stReportItem b16 = com.tencent.biz.pubaccount.weishi.report.a.b(stsimplemetafeed, i3);
        if (stsimplemetafeed.video_type == 9) {
            g(stsimplemetafeed, i3, this.f81364e);
        } else {
            k(b16, stsimplemetafeed, i3);
        }
    }

    private void p(stSimpleMetaFeed stsimplemetafeed, Integer num) {
        stH5OpInfo sth5opinfo = stsimplemetafeed.h5_op_info;
        if (sth5opinfo != null && sth5opinfo.type > 0) {
            stReportItem b16 = com.tencent.biz.pubaccount.weishi.report.a.b(stsimplemetafeed, num.intValue());
            int i3 = sth5opinfo.type;
            if (i3 == 1) {
                b16.pagetype = 9;
            } else {
                b16.pagetype = 14;
            }
            b16.optype = 6;
            WSReportDc00898.u(6, i3, num.intValue(), stsimplemetafeed.h5_op_info.f25120id);
            a.q("gzh_exposure", 0, stsimplemetafeed, this.f81364e);
            x.i("weishi-report", "luopan report H5");
            return;
        }
        if (stsimplemetafeed.video_type == 6) {
            WSReportDc00898.s(false);
            x.i("weishi-report", "luopan report NOW");
        } else {
            x.b("weishi-report", "luopan normal is no need report");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Map<Integer, stSimpleMetaFeed> map, Map<Integer, String> map2) {
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        if (map.size() > 0) {
            for (Map.Entry<Integer, stSimpleMetaFeed> entry : map.entrySet()) {
                Integer key = entry.getKey();
                stSimpleMetaFeed value = entry.getValue();
                p(value, key);
                String i3 = bb.i(value);
                if (!TextUtils.isEmpty(i3)) {
                    sb5.append(i3);
                    sb5.append("_");
                    sb6.append("0");
                    sb6.append("_");
                }
            }
            if (sb5.length() > 1) {
                sb5 = new StringBuilder(sb5.substring(0, sb5.length() - 1));
            }
            if (sb6.length() > 1) {
                sb6 = new StringBuilder(sb6.substring(0, sb6.length() - 1));
            }
        } else {
            x.l("weishi-report", "\u63a8\u8350\u4e0a\u62a5\u7684feeds\u4e3a0\u4e2a");
        }
        if (map2.size() > 0) {
            StringBuilder sb7 = new StringBuilder();
            for (Map.Entry<Integer, String> entry2 : map2.entrySet()) {
                Integer key2 = entry2.getKey();
                String value2 = entry2.getValue();
                x.i("weishi-report", "898\u5b9e\u65f6\u4e0a\u62a5:" + value2 + ", upos:" + key2);
                if (!TextUtils.isEmpty(value2)) {
                    sb7.append(value2);
                    sb7.append("_");
                }
            }
            if (sb7.length() > 1) {
                sb7 = new StringBuilder(sb7.substring(0, sb7.length() - 1));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("feedid", sb7.toString());
            hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_COVER_TYPE, sb5.toString());
            hashMap.put("dynamic_cover", sb6.toString());
            JSONObject jSONObject = new JSONObject(hashMap);
            x.l("weishi-report", "jsonObj:" + jSONObject);
            WSReportDc00898.o(303, jSONObject.toString());
            return;
        }
        x.l("weishi-report", "898\u4e0a\u62a5\u7684feeds\u4e3a0\u4e2a");
    }

    public void f() {
        this.f81360a.clear();
        this.f81361b.clear();
    }

    public void h(int i3, h hVar) {
        if (this.f81361b.containsKey(Integer.valueOf(i3))) {
            return;
        }
        this.f81361b.put(Integer.valueOf(i3), hVar.d());
        a.o(this.f81364e, i3, hVar.d(), hVar.g());
    }

    public void j(final List<stSimpleMetaFeed> list, boolean z16, final int i3) {
        x.j("WSFeedsItemExposeLog", "[WSGridItemExpose.java][exposeRefreshCard] mSubTabId:" + this.f81364e + ", lastVisiblePosition:" + i3);
        g gVar = new g("Weishi_WSGridItemExpose_RefreshReport", i.b.f261780e, new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.recommend.b
            @Override // java.lang.Runnable
            public final void run() {
                WSGridItemExpose.this.n(i3, list);
            }
        });
        gVar.m("group_id_ws_grid_expose");
        com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.e(gVar);
    }

    public int l() {
        return this.f81360a.size();
    }

    public void m(final stSimpleMetaFeed stsimplemetafeed, final int i3) {
        g gVar = new g("Weishi_WSGridItemExpose_ScrollReport", i.b.f261780e, new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.recommend.c
            @Override // java.lang.Runnable
            public final void run() {
                WSGridItemExpose.this.o(i3, stsimplemetafeed);
            }
        });
        gVar.m("group_id_ws_grid_expose");
        com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.e(gVar);
    }

    public void s() {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.recommend.WSGridItemExpose.1
            @Override // java.lang.Runnable
            public void run() {
                WSGridItemExpose wSGridItemExpose = WSGridItemExpose.this;
                wSGridItemExpose.q(wSGridItemExpose.f81362c, WSGridItemExpose.this.f81363d);
                WSGridItemExpose.this.f81362c.clear();
                WSGridItemExpose.this.f81363d.clear();
            }
        });
    }

    private static void g(stSimpleMetaFeed stsimplemetafeed, int i3, String str) {
        stCardInfo stcardinfo;
        stCollectionCardInfo stcollectioncardinfo;
        ArrayList<stCollection> arrayList;
        if (stsimplemetafeed == null || (stcardinfo = stsimplemetafeed.cardInfo) == null || (stcollectioncardinfo = stcardinfo.collectionCardInfo) == null || (arrayList = stcollectioncardinfo.collectionList) == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        int i16 = 0;
        while (i16 < arrayList.size()) {
            int i17 = i16 + 1;
            sb5.append(i17);
            sb5.append("_");
            sb5.append(arrayList.get(i16).cid);
            sb5.append(",");
            i16 = i17;
        }
        a.k(i3, stsimplemetafeed, sb5.toString().substring(0, r0.length() - 1), str);
    }

    public static void r(HashMap<Integer, stSimpleMetaFeed> hashMap, String str) {
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        for (Map.Entry<Integer, stSimpleMetaFeed> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            stSimpleMetaFeed value = entry.getValue();
            stReportItem b16 = com.tencent.biz.pubaccount.weishi.report.a.b(value, key.intValue());
            int i3 = b16.video_type;
            if (i3 == 9) {
                g(value, key.intValue(), str);
            } else if (i3 != 1 && i3 != 6) {
                a.c("gzh_exposure", value, b16, 0, str);
            }
        }
    }

    public void i(List<h> list) {
        if (list == null) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            h(i3, list.get(i3));
        }
    }
}
