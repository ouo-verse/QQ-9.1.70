package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.vr;

import java.io.Serializable;
import java.util.Map;

/* loaded from: classes19.dex */
public interface IVRPlayReport<K, V> extends Serializable {
    String getReportKey();

    Map<K, V> getReportParams();
}
