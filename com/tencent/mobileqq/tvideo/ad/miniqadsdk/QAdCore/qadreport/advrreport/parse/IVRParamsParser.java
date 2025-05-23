package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.parse;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* loaded from: classes19.dex */
public interface IVRParamsParser<K, V> {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface ParamType {
    }

    Map<K, V> a(int i3);
}
