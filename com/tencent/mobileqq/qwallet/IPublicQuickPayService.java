package com.tencent.mobileqq.qwallet;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

@Service(process = {""})
/* loaded from: classes16.dex */
public interface IPublicQuickPayService extends IRuntimeService {

    /* loaded from: classes16.dex */
    public interface a {
        void a(Bundle bundle);
    }

    boolean publicQuickPay(String str, JSONObject jSONObject, Context context, a aVar);
}
