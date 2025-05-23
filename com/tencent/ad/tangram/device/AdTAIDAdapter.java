package com.tencent.ad.tangram.device;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.device.AdTAID;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public interface AdTAIDAdapter {
    @Nullable
    AdTAID.Entity getEntity(Context context);

    void init(Context context);
}
