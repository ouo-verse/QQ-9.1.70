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
public class e extends HuaweiApi<a> {

    /* renamed from: a, reason: collision with root package name */
    private static final Api<a> f37317a = new Api<>(HuaweiApiAvailability.HMS_API_NAME_GAME);

    /* renamed from: c, reason: collision with root package name */
    private static final a f37318c = new a();

    /* renamed from: b, reason: collision with root package name */
    private Context f37319b;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements Api.ApiOptions.Optional {
    }

    public e(Context context) {
        super(context, f37317a, f37318c, new d());
        this.f37319b = context;
    }

    public void a() {
        as.b("AccountSignInNoticeClientImpl", "request Jos Notice.", true);
        String reportEntry = HiAnalyticsClient.reportEntry(getContext(), CoreNaming.GETNOTICE, 60400300);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("noticeType", 1);
            jSONObject.put("hmsSdkVersionName", "6.4.0.302");
            jSONObject.put("cpId", Util.getCpId(this.f37319b));
            doWrite(new k(CoreNaming.GETNOTICE, jSONObject.toString(), reportEntry));
        } catch (JSONException unused) {
            as.c("AccountSignInNoticeClientImpl", "createParams Notice request meet JSONException.", true);
        }
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 1;
    }
}
