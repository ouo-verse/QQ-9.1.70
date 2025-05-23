package com.tencent.biz.pubaccount.weishi.verticalvideo.data;

import UserGrowth.stCollection;
import UserGrowth.stDrama;
import UserGrowth.stDramaFeed;
import UserGrowth.stDramaInfo;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.app.dv;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i {
    private static void b(stSimpleMetaFeed stsimplemetafeed, j jVar) {
        if (stsimplemetafeed.gdt_ad_type != 1 || stsimplemetafeed.gdt_ad_info == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.a.a(stsimplemetafeed);
        com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.a.b(BaseApplication.getContext(), stsimplemetafeed);
        jVar.k(com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.a.j(stsimplemetafeed));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        if (r3 == (r9.size() - 1)) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<j> c(stDrama stdrama, List<stDramaFeed> list, boolean z16) {
        stSimpleMetaFeed stsimplemetafeed;
        boolean z17;
        String n3 = n(stdrama);
        ArrayList<j> arrayList = new ArrayList<>();
        if (CollectionUtils.isEmpty(list)) {
            return arrayList;
        }
        int i3 = 0;
        while (i3 < list.size()) {
            stDramaFeed stdramafeed = list.get(i3);
            if (stdramafeed != null && (stsimplemetafeed = stdramafeed.feed) != null) {
                j f16 = f(stsimplemetafeed);
                g gVar = new g(stdramafeed.dramaID, n3, stdramafeed.num);
                gVar.e(stdrama);
                if (z16) {
                    z17 = true;
                }
                z17 = false;
                f16.o(z17);
                f16.n(gVar);
                arrayList.add(f16);
            }
            i3++;
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        if (r2 == (r7.size() - 1)) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<j> e(List<stSimpleMetaFeed> list, boolean z16) {
        boolean z17;
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isEmpty(list)) {
            return arrayList;
        }
        int i3 = 0;
        while (i3 < list.size()) {
            stSimpleMetaFeed stsimplemetafeed = list.get(i3);
            if (stsimplemetafeed != null) {
                j f16 = f(stsimplemetafeed);
                if (z16) {
                    z17 = true;
                }
                z17 = false;
                f16.o(z17);
                arrayList.add(f16);
                x.j("WSVerticalDataUtilLog", "[WSVerticalDataUtil.java][convertStSimpleFeedList] id:" + stsimplemetafeed.f25129id + ", title:" + stsimplemetafeed.feed_desc);
            }
            i3++;
        }
        return arrayList;
    }

    public static j f(stSimpleMetaFeed stsimplemetafeed) {
        j jVar = new j();
        b(stsimplemetafeed, jVar);
        stsimplemetafeed.opInfo = ez.e.i(stsimplemetafeed);
        jVar.r(ez.d.a(stsimplemetafeed));
        jVar.p(stsimplemetafeed);
        return jVar;
    }

    public static List<stSimpleMetaFeed> g(List list) {
        ArrayList arrayList = new ArrayList();
        if (CollectionUtils.isEmpty(list)) {
            return arrayList;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3) instanceof j) {
                arrayList.add(((j) list.get(i3)).e());
            }
        }
        return arrayList;
    }

    public static String h() {
        WSRedDotPushMsg z16 = bb.z();
        ty.g.f437886a.p(null);
        if (z16 == null) {
            return "";
        }
        return z16.mMsgData;
    }

    public static ArrayList<String> j(boolean z16, List<j> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (z16 && list != null) {
            for (j jVar : list) {
                if (jVar != null && jVar.e() != null) {
                    arrayList.add(jVar.e().f25129id);
                }
            }
        }
        return arrayList;
    }

    public static HashMap<String, Integer> k(boolean z16) {
        String q16 = q();
        if (!z16 && !TextUtils.isEmpty(q16)) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            hashMap.put(q16, Integer.valueOf(r()));
            return hashMap;
        }
        return new HashMap<>();
    }

    public static HashMap<String, Integer> l(boolean z16, List<j> list) {
        stSimpleMetaFeed e16;
        HashMap<String, Integer> hashMap = new HashMap<>();
        if (z16 && list != null) {
            for (j jVar : list) {
                if (jVar != null && (e16 = jVar.e()) != null) {
                    hashMap.put(e16.f25129id, Integer.valueOf(e16.video_type));
                }
            }
        }
        return hashMap;
    }

    public static String p(List<j> list) {
        stSimpleMetaFeed e16;
        if (list == null || list.isEmpty() || (e16 = list.get(0).e()) == null) {
            return "";
        }
        return e16.f25129id;
    }

    public static String q() {
        dv C = bb.C();
        if (C != null) {
            return C.d();
        }
        return "";
    }

    public static int r() {
        dv C = bb.C();
        if (C != null) {
            return C.e();
        }
        return 0;
    }

    public static List<j> d(List<stSimpleMetaFeed> list) {
        return e(list, false);
    }

    public static j a(mz.d dVar) {
        stDramaFeed h16;
        if (dVar == null || (h16 = dVar.h()) == null) {
            return null;
        }
        j jVar = new j();
        g gVar = new g(dVar.d(), n(dVar.e()), h16.num);
        gVar.e(dVar.e());
        jVar.o(dVar.k());
        jVar.n(gVar);
        jVar.p(dVar.i());
        return jVar;
    }

    public static int m(j jVar) {
        if (jVar == null || jVar.d() == null) {
            return 0;
        }
        return jVar.d().d();
    }

    private static String n(stDrama stdrama) {
        stDramaInfo stdramainfo;
        String str;
        return (stdrama == null || (stdramainfo = stdrama.dramaInfo) == null || (str = stdramainfo.name) == null) ? "" : str;
    }

    public static String o(j jVar) {
        if (jVar != null && jVar.e() != null && jVar.e().f25129id != null) {
            return jVar.e().f25129id;
        }
        return "";
    }

    public static stSimpleMetaFeed s(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.f adapter;
        if (hVar == null || (adapter = hVar.getAdapter()) == null) {
            return null;
        }
        x.i("WSVerticalDataUtilLog", "getTargetCacheFeed");
        stSimpleMetaFeed c16 = ry.a.c();
        if (c16 != null) {
            return c16;
        }
        j v3 = adapter.v();
        if (v3 != null && v3.e() != null) {
            c16 = v3.e();
        }
        if (c16 != null && !TextUtils.isEmpty(c16.feed_desc) && c16.video_type != 2) {
            return c16;
        }
        int t16 = adapter.t();
        List<j> dataList = adapter.getDataList();
        if (t16 >= dataList.size() - 2) {
            return c16;
        }
        while (true) {
            t16++;
            if (t16 >= dataList.size()) {
                return c16;
            }
            stSimpleMetaFeed e16 = dataList.get(t16).e();
            if (e16.video_type != 2) {
                if (!TextUtils.isEmpty(e16.feed_desc)) {
                    return e16;
                }
                c16 = e16;
            }
        }
    }

    public static void t(mz.d dVar, j jVar) {
        stDramaFeed h16;
        g d16;
        stSimpleMetaFeed e16;
        if (dVar == null || (h16 = dVar.h()) == null || jVar == null || (d16 = jVar.d()) == null || (e16 = jVar.e()) == null) {
            return;
        }
        h16.num = d16.d();
        h16.feed = e16;
        h16.f25115id = e16.f25129id;
    }

    public static stCollection i(j jVar) {
        if (jVar == null) {
            return null;
        }
        return jVar.b();
    }
}
