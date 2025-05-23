package com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl;

import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.base.ad.model.u;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.tangramsplash.c.e;
import com.qq.e.comm.plugin.tangramsplash.d.f;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SharedPreferencedUtil;
import com.qzone.publish.business.task.compress.VideoCompressTask;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a {
    public static void a(List<r> list, boolean z16, com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.c cVar, boolean z17) {
        if (!g.b(list) && cVar != null) {
            try {
                CopyOnWriteArrayList<r> copyOnWriteArrayList = new CopyOnWriteArrayList(list);
                for (r rVar : copyOnWriteArrayList) {
                    if (rVar != null) {
                        if (rVar.ax()) {
                            cVar.f40032c = rVar;
                        }
                        if (com.qq.e.comm.plugin.tangramsplash.a.c.a(rVar)) {
                            cVar.f40031b = rVar;
                        }
                    }
                }
                if (z16) {
                    cVar.f40033d = new CopyOnWriteArrayList(copyOnWriteArrayList);
                    cVar.f40034e = new CopyOnWriteArrayList(copyOnWriteArrayList);
                    return;
                }
                if (z17) {
                    cVar.f40033d = new CopyOnWriteArrayList(copyOnWriteArrayList);
                    return;
                }
                SparseArray<r> a16 = e.a().a(copyOnWriteArrayList, cVar.a());
                if (a16 != null && a16.size() > 0) {
                    if (com.qq.e.comm.plugin.j.c.a("splashSelectEffectListWithoutRotIndex", 0, 1)) {
                        cVar.f40033d = a(a16);
                        ArrayList arrayList = new ArrayList();
                        for (int i3 = 0; i3 < a16.size(); i3++) {
                            r rVar2 = a16.get(i3);
                            if (rVar2 != null && rVar2.az() == 1) {
                                arrayList.add(rVar2);
                            }
                        }
                        cVar.f40034e = arrayList;
                        return;
                    }
                    List a17 = a(a16);
                    cVar.f40033d = a17;
                    cVar.f40034e = a17;
                    return;
                }
                return;
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
                return;
            }
        }
        GDTLogger.e("generateOrderListInFusionSDK preload info invalid.");
    }

    private static List a(SparseArray sparseArray) {
        if (g.a(sparseArray)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(sparseArray.size());
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            arrayList.add(sparseArray.valueAt(i3));
        }
        return arrayList;
    }

    private static JSONArray a(JSONObject jSONObject, String str) {
        if (!y.a(jSONObject)) {
            StatTracer.trackEvent(100042, 0, (com.qq.e.comm.plugin.stat.b) null);
            return null;
        }
        int optInt = jSONObject.optInt("ret");
        if (optInt != 0) {
            StatTracer.trackEvent(BusinessInfoCheckUpdateItem.UIAPPID_WALLET_ACCOUNT_WEILIDAI, optInt, (com.qq.e.comm.plugin.stat.b) null);
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (!y.a(optJSONObject)) {
            StatTracer.trackEvent(100072, (JSONObject) null, (JSONObject) null);
            return null;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
        if (!y.a(optJSONObject2)) {
            StatTracer.trackEvent(VideoCompressTask.VIDEO_COMPRESS_RESULT_FILE_NOT_EXIST, (JSONObject) null, (JSONObject) null);
            return null;
        }
        int optInt2 = optJSONObject2.optInt("ret");
        if (optInt2 != 0) {
            StatTracer.trackEvent(100092, optInt2, (com.qq.e.comm.plugin.stat.b) null);
            return null;
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("list");
        if (!y.a(optJSONArray)) {
            return optJSONArray;
        }
        StatTracer.trackEvent(AudienceReportConst.EVENT_ID_ENTER_ROOM_FAILURE, optInt2, (com.qq.e.comm.plugin.stat.b) null);
        return null;
    }

    public static void a(JSONObject jSONObject, com.qq.e.comm.plugin.base.ad.b bVar, String str, String str2, String str3, r rVar, List<r> list, boolean z16) {
        JSONArray a16 = a(jSONObject, str2);
        if (y.a(a16)) {
            return;
        }
        for (int i3 = 0; i3 < a16.length(); i3++) {
            JSONObject optJSONObject = a16.optJSONObject(i3);
            r rVar2 = new r(str, str2, str3, bVar);
            rVar2.e(optJSONObject);
            if (z16 && SharedPreferencedUtil.getInt(rVar2.bn(), -1) != -1) {
                SharedPreferencedUtil.putInt(rVar2.bn(), rVar2.bc());
            }
            if (!TextUtils.isEmpty(rVar2.bw()) && !TextUtils.isEmpty(rVar2.bv()) && !str2.equals(rVar2.bw())) {
                a(jSONObject, bVar, str, rVar2.bw(), str3, rVar2, list, z16);
            }
            if (list != null) {
                list.add(rVar2);
            }
            if (rVar != null && rVar.bx() == null && rVar2.s().equals(rVar.bw()) && rVar2.bn().equals(rVar.bv())) {
                rVar.a(f.b(rVar2));
                rVar2.q(true);
                return;
            }
        }
    }

    public static void a(Map<String, List<r>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, List<r>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                List<r> value = entry.getValue();
                if (!g.b(value)) {
                    for (r rVar : value) {
                        if (rVar != null) {
                            Map<String, List<u>> cg5 = rVar.cg();
                            if (cg5 == null) {
                                cg5 = new ConcurrentHashMap<>();
                                rVar.a(cg5);
                            }
                            ArrayList arrayList = new ArrayList();
                            List<u> bs5 = rVar.bs();
                            boolean z16 = false;
                            if (!g.b(bs5)) {
                                for (u uVar : bs5) {
                                    if (uVar != null && key.equals(uVar.a())) {
                                        arrayList.add(uVar);
                                        z16 = true;
                                    }
                                }
                            }
                            if (z16) {
                                cg5.put(key, arrayList);
                            }
                        }
                    }
                }
            }
        }
    }
}
