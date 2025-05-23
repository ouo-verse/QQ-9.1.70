package com.tencent.mobileqq.sharepanel.report;

import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.sharepanel.model.d;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.state.report.SquareReportConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000\u001a\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\b\u0012\u0004\u0012\u00020\u00000\u0005\u001a\u0016\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "", "", "", "b", "", "c", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "a", "qq-sharepanel-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    @NotNull
    public static final Map<String, Object> a(@NotNull SharePanelParam sharePanelParam) {
        boolean z16;
        Intrinsics.checkNotNullParameter(sharePanelParam, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sceneID", sharePanelParam.u());
        d t16 = sharePanelParam.t();
        if (t16 != null) {
            boolean z17 = true;
            if (t16.a().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                linkedHashMap.put("biz_custom_field", t16.a());
            }
            if (t16.b().length() <= 0) {
                z17 = false;
            }
            if (z17) {
                linkedHashMap.put("wake_source", t16.b());
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Map<String, Object> b(@NotNull SharePanelContactItem sharePanelContactItem) {
        Intrinsics.checkNotNullParameter(sharePanelContactItem, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int f16 = sharePanelContactItem.f();
        if (f16 != 0) {
            if (f16 == 1) {
                linkedHashMap.put("object_type", "2");
                linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, sharePanelContactItem.e());
            }
        } else {
            linkedHashMap.put("object_type", "1");
            linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, sharePanelContactItem.e());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Map<String, Object> c(@NotNull List<SharePanelContactItem> list) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SharePanelContactItem sharePanelContactItem : list) {
            int f16 = sharePanelContactItem.f();
            if (f16 != 0) {
                if (f16 == 1) {
                    arrayList2.add(sharePanelContactItem.e());
                }
            } else {
                arrayList.add(sharePanelContactItem.e());
            }
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put((String) it.next());
        }
        JSONArray jSONArray2 = new JSONArray();
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            jSONArray2.mo162put((String) it5.next());
        }
        jSONObject.put("c2c", jSONArray);
        jSONObject.put(VipFunCallConstants.KEY_GROUP, jSONArray2);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("objects_number", String.valueOf(list.size())), TuplesKt.to("touid_list", jSONObject.toString()));
        return mutableMapOf;
    }
}
