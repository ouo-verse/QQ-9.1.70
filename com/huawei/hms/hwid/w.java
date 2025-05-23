package com.huawei.hms.hwid;

import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.Util;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class w extends HuaweiApi<a> {

    /* renamed from: a, reason: collision with root package name */
    private static final Api<a> f37329a = new Api<>(HuaweiApiAvailability.HMS_API_NAME_GAME);

    /* renamed from: c, reason: collision with root package name */
    private static final a f37330c = new a();

    /* renamed from: b, reason: collision with root package name */
    private Context f37331b;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements Api.ApiOptions.Optional {
    }

    public w(Context context) {
        super(context, f37329a, f37330c, new v());
        this.f37331b = context;
    }

    public void a() {
        as.b("SignInNoticeClientImpl", "request Jos Notice.", true);
        String reportEntry = HiAnalyticsClient.reportEntry(getContext(), CoreNaming.GETNOTICE, 60400300);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("noticeType", 1);
            jSONObject.put("hmsSdkVersionName", "6.4.0.302");
            jSONObject.put("cpId", Util.getCpId(this.f37331b));
            doWrite(new ae(CoreNaming.GETNOTICE, jSONObject.toString(), reportEntry));
        } catch (JSONException unused) {
            as.c("SignInNoticeClientImpl", "createParams Notice request meet JSONException.", true);
        }
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 1;
    }
}
