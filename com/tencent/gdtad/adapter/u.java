package com.tencent.gdtad.adapter;

import androidx.annotation.NonNull;
import com.tencent.ad.tangram.version.AdVersionAdapter;
import com.tencent.gdtad.qqproxy.GdtVersionUtil;

/* compiled from: P */
/* loaded from: classes6.dex */
public class u implements AdVersionAdapter {
    @Override // com.tencent.ad.tangram.version.AdVersionAdapter
    @NonNull
    public String getAppVersion() {
        return GdtVersionUtil.getQQVersion();
    }
}
