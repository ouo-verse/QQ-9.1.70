package com.tencent.ad.tangram.statistics.metric;

import com.tencent.ad.tangram.annotation.AdKeep;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public interface IAdMetric {
    boolean isEnabled();

    IAdMetric setEnabled(boolean z16);

    IAdMetric setTagSet(String str, String str2);

    IAdMetric setValue(double d16);
}
