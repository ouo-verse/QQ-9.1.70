package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ma extends lu {
    @Override // com.tencent.mapsdk.internal.lu
    public final byte[] f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        NetResponse doGet = NetManager.getInstance().builder().url(str).doGet();
        if (doGet != null && doGet.available()) {
            return doGet.data;
        }
        return super.f(str);
    }
}
