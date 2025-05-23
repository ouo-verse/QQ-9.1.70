package com.tencent.qzonehub.api.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.qzone.common.activities.base.ak;
import com.qzone.common.activities.base.bw;
import com.tencent.qzonehub.api.IQZoneActivityToFragmentProxy;

/* loaded from: classes34.dex */
public class QZoneActivityToFragmentProxyImpl implements IQZoneActivityToFragmentProxy {
    @Override // com.tencent.qzonehub.api.IQZoneActivityToFragmentProxy
    public Intent convertIntent(Context context, Intent intent, String str) {
        intent.setComponent(new ComponentName(context, ak.k(str)));
        intent.putExtra("KEY_FRAGMENT_NAME", str);
        return intent;
    }

    @Override // com.tencent.qzonehub.api.IQZoneActivityToFragmentProxy
    public boolean isConvertToFragment(String str) {
        return bw.c(str);
    }
}
