package com.tencent.util;

import com.tencent.common.app.AppInterface;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IUtilApi {
    void dispatchReport(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9);

    String getFeatureValueAioConfig();

    boolean isActiveReporting();

    void reportHttpsSniMethod(int i3, String str, int i16, String str2);
}
