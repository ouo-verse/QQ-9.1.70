package com.tencent.state.utils;

import android.os.Bundle;
import com.tencent.state.data.Gender;
import com.tencent.state.square.data.DressInfo;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/utils/BundleParamsUtils;", "", "()V", "buildMallBundle", "Landroid/os/Bundle;", "info", "Lcom/tencent/state/square/data/DressInfo;", "getMallBundle", "getPortalBundle", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class BundleParamsUtils {
    public static final BundleParamsUtils INSTANCE = new BundleParamsUtils();

    BundleParamsUtils() {
    }

    public final Bundle buildMallBundle(DressInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("SceneType", 6);
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray((Collection) info.getGoods());
        if (info.getGender() == Gender.MALE) {
            jSONObject2.put("MaleGoods", jSONArray);
        } else if (info.getGender() == Gender.FEMALE) {
            jSONObject2.put("FemaleGoods", jSONArray);
        }
        jSONObject2.put("TabType", 0);
        jSONObject2.put("MallType", 0);
        jSONObject2.put("JumpTabId", 0);
        jSONObject.put("SceneParams", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("SubScene", jSONObject);
        Bundle bundle = new Bundle();
        bundle.putString("ueParams", jSONObject3.toString());
        return bundle;
    }

    public final Bundle getMallBundle() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("SceneType", 1);
        jSONObject.put("ViewType", 1);
        jSONObject.put("SubScene", jSONObject2);
        Bundle bundle = new Bundle();
        bundle.putString("ueParams", jSONObject.toString());
        return bundle;
    }

    public final Bundle getPortalBundle() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ViewType", 1);
        Bundle bundle = new Bundle();
        bundle.putString("ueParams", jSONObject.toString());
        return bundle;
    }
}
