package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/config/business/d;", "b", "", "content", "c", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e {
    @NotNull
    public static final BrowserOpenBean b() {
        BrowserOpenBean browserOpenBean = (BrowserOpenBean) com.tencent.mobileqq.config.am.s().x(627);
        if (browserOpenBean == null) {
            return new BrowserOpenBean();
        }
        return browserOpenBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BrowserOpenBean c(String str) {
        int i3;
        int i16;
        if (str == null) {
            return null;
        }
        try {
            BrowserOpenBean browserOpenBean = new BrowserOpenBean();
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("set_top_app");
            if (optJSONArray != null) {
                i3 = optJSONArray.length();
            } else {
                i3 = 0;
            }
            for (int i17 = 0; i17 < i3; i17++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i17);
                if (jSONObject2 != null) {
                    String name = jSONObject2.optString("name");
                    String title = jSONObject2.optString("title");
                    String icon = jSONObject2.optString("icon");
                    String jumpUrl = jSONObject2.optString("jump_url");
                    String packageName = jSONObject2.optString("package_name");
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    Intrinsics.checkNotNullExpressionValue(title, "title");
                    Intrinsics.checkNotNullExpressionValue(icon, "icon");
                    Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
                    Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
                    browserOpenBean.b().add(new com.tencent.mobileqq.browser.b(name, title, icon, jumpUrl, packageName, false));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("black_list_app");
            if (optJSONArray2 != null) {
                i16 = optJSONArray2.length();
            } else {
                i16 = 0;
            }
            for (int i18 = 0; i18 < i16; i18++) {
                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i18);
                if (jSONObject3 != null) {
                    String pkg = jSONObject3.optString("package");
                    List<String> a16 = browserOpenBean.a();
                    Intrinsics.checkNotNullExpressionValue(pkg, "pkg");
                    a16.add(pkg);
                }
            }
            return browserOpenBean;
        } catch (Exception e16) {
            QLog.e("[BrowserOpt] H5BrowserOpenConfProcessor", 1, "parse: failed. ", e16);
            return null;
        }
    }
}
