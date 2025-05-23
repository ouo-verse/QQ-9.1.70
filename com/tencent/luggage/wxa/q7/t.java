package com.tencent.luggage.wxa.q7;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class t {
    public static final Bundle b(BaseResp baseResp) {
        Bundle bundle = new Bundle();
        baseResp.toBundle(bundle);
        return bundle;
    }
}
