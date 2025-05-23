package com.tencent.mobileqq.search.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISearchConfigUtilFetcher extends QRouteApi {
    String getSFtsSearchBarWording();

    boolean isEnableEntryModuleByType(int i3);

    boolean isEnableQzoneSearch();

    boolean isSearchEnhanceEnable(String str);

    void setEnableEntryModuleByType(int i3, boolean z16);

    void setSFtsSearchBarWording(String str);
}
