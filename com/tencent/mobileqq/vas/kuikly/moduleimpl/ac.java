package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/ac;", "", "", "params", "", "a", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ac f309760a = new ac();

    ac() {
    }

    public final void a(@Nullable String params) {
        int i3;
        String str;
        if (params == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            int optInt = jSONObject.optInt("actionId");
            JSONObject optJSONObject = jSONObject.optJSONObject("info");
            if (optJSONObject != null) {
                i3 = optJSONObject.optInt("pageIndex");
            } else {
                i3 = -1;
            }
            String str2 = null;
            if (optJSONObject != null) {
                str = optJSONObject.optString("msgExtend");
            } else {
                str = null;
            }
            String str3 = "";
            if (str == null) {
                str = "";
            }
            if (optJSONObject != null) {
                str2 = optJSONObject.optString("adID");
            }
            if (str2 != null) {
                str3 = str2;
            }
            QLog.i("ReportDubheVASPublicAccountImpl", 1, "actionId:" + optInt + " infoJson:" + optJSONObject);
            VasInjectApi.getInstance().publicAccountTianshuReport(optInt, i3, str3, str);
        } catch (JSONException e16) {
            QLog.e("ReportDubheVASPublicAccountImpl", 1, "report", e16);
        }
    }
}
