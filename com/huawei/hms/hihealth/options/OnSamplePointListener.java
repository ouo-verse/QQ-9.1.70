package com.huawei.hms.hihealth.options;

import com.huawei.hms.hihealth.data.SamplePoint;

/* loaded from: classes2.dex */
public interface OnSamplePointListener {
    void onException(int i3, String str);

    void onSamplePoint(SamplePoint samplePoint);
}
