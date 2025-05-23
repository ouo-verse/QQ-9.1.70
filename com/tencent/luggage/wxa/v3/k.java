package com.tencent.luggage.wxa.v3;

import android.app.Activity;
import android.os.Build;
import com.tencent.luggage.opensdk.OpenSDKBridgedActivity;
import com.tencent.luggage.wxa.g6.t;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k extends com.tencent.luggage.wxa.g6.r {
    public static final Class<? extends Activity> ACTIVITY_CLASS = OpenSDKBridgedActivity.class;

    public k(t tVar) {
        super(tVar);
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void b() {
        super.b();
        if (getContext() instanceof Activity) {
            j();
        }
    }

    public final void j() {
        boolean z16;
        if (Build.VERSION.SDK_INT >= 26) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getWindow() == null) {
            return;
        }
        com.tencent.luggage.wxa.lo.f.b(getWindow());
        com.tencent.luggage.wxa.lo.f.b(getWindow(), true);
        if (z16) {
            com.tencent.luggage.wxa.lo.f.a(getWindow());
            com.tencent.luggage.wxa.lo.f.a(getWindow(), true);
        }
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void onResume() {
        super.onResume();
        setResult(-1);
        overridePendingTransition(0, 0);
        finish();
    }
}
