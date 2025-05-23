package com.tencent.luggage.wxa.standalone_open_runtime.app;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.luggage.wxa.ka.a;
import com.tencent.luggage.wxa.q7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/luggage/wxa/standalone_open_runtime/app/WxaIPCContainerService0;", "Lcom/tencent/luggage/wxa/ka/a;", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "<init>", "()V", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public class WxaIPCContainerService0 extends a {
    @Override // com.tencent.luggage.wxa.ka.a, android.app.Service
    public IBinder onBind(Intent intent) {
        Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
            Context applicationContext2 = applicationContext.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "applicationContext");
            b.a(applicationContext2);
        }
        return super.onBind(intent);
    }
}
