package com.huawei.hms.hihealth.options;

import com.huawei.hms.hihealth.data.SamplePoint;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface OnActivityRecordListener {
    void onReceive(List<SamplePoint> list);

    void onStatusChange(int i3);
}
