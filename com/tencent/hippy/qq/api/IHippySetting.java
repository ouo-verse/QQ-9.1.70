package com.tencent.hippy.qq.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IHippySetting extends QRouteApi {
    void clearCache();

    long getCacheSize();

    int getFixedWidth(String str);

    File getHippyFileByType(String str);

    File getModuleFile(String str);

    File getModuleFile(String str, int i3);

    File getModuleIndex(String str, int i3);

    long getModuleIndexFileLength(String str, int i3);

    int getModuleVersion(String str);

    boolean isClearingCache();

    void setModuleVersion(String str, int i3);
}
