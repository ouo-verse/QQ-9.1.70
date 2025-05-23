package com.tencent.mobileqq.zplan.authorize.impl.helper;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/helper/g;", "", "", "mapId", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f331490a = new g();

    g() {
    }

    public final List<String> a(String mapId) {
        List<String> emptyList;
        List<String> emptyList2;
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        try {
            IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
            byte[] bytes = "{\"defalut\":[\"com.tencent.mobileqq.zootopia.debug.ZootopiaDemoFragment\",\"com.tencent.mobileqq.zootopia.recommend.paradise.ZPlanNewParadiseFragment\",\"com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragmentV2\"]}".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] loadRawConfig = iUnitedConfigManager.loadRawConfig("zplan_auto_launch_white_page", bytes);
            if (loadRawConfig == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            JSONObject jSONObject = new JSONObject(new String(loadRawConfig, UTF_8));
            JSONArray optJSONArray = jSONObject.optJSONArray(mapId);
            if (optJSONArray == null) {
                optJSONArray = jSONObject.optJSONArray("defalut");
            }
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(optJSONArray.optString(i3));
                }
            }
            QLog.i("ZPlanConfigHelper", 1, "config => " + optJSONArray + ", list => " + arrayList);
            return arrayList;
        } catch (Exception e16) {
            QLog.e("ZPlanConfigHelper", 1, "parse fail. ", e16);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }
}
