package com.tencent.xweb.location;

import android.location.Location;
import com.tencent.luggage.wxa.tq.g;
import com.tencent.xweb.CalledByApi;
import com.tencent.xweb.internal.ConstValue;

@CalledByApi
/* loaded from: classes27.dex */
public abstract class XWebLocationProxy {
    public final void onNewLocationAvailable(Location location) {
        g.a(ConstValue.INVOKE_RUNTIME_ID_NEW_LOCATION, new Object[]{location});
    }

    public abstract boolean start(boolean z16);

    public abstract boolean stop();
}
