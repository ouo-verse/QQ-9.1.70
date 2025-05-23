package com.huawei.hms.support.sms;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.hwid.ah;
import com.huawei.hms.hwid.aj;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ReadSmsManager {

    /* renamed from: a, reason: collision with root package name */
    private static final Api<Api.ApiOptions.NoOptions> f37633a = new Api<>(HuaweiApiAvailability.HMS_API_NAME_ID);

    /* renamed from: b, reason: collision with root package name */
    private static final ah f37634b = new ah();

    public static Task<Void> start(Activity activity) {
        return new aj(activity, f37633a, (Api.ApiOptions.NoOptions) null, (AbstractClientBuilder) f37634b).a();
    }

    public static Task<Void> startConsent(Activity activity, String str) {
        return new aj(activity, f37633a, (Api.ApiOptions.NoOptions) null, (AbstractClientBuilder) f37634b).a(str);
    }

    public static Task<Void> start(Context context) {
        return new aj(context, f37633a, (Api.ApiOptions.NoOptions) null, f37634b).a();
    }
}
