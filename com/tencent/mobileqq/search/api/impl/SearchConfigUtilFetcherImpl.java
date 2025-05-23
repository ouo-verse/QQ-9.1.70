package com.tencent.mobileqq.search.api.impl;

import com.tencent.mobileqq.search.api.ISearchConfigUtilFetcher;
import com.tencent.mobileqq.search.util.w;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchConfigUtilFetcherImpl implements ISearchConfigUtilFetcher {
    @Override // com.tencent.mobileqq.search.api.ISearchConfigUtilFetcher
    public String getSFtsSearchBarWording() {
        return w.f285090a;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchConfigUtilFetcher
    public boolean isEnableEntryModuleByType(int i3) {
        return w.s(i3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchConfigUtilFetcher
    public boolean isEnableQzoneSearch() {
        return w.t();
    }

    @Override // com.tencent.mobileqq.search.api.ISearchConfigUtilFetcher
    public boolean isSearchEnhanceEnable(String str) {
        return w.v(str);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchConfigUtilFetcher
    public void setEnableEntryModuleByType(int i3, boolean z16) {
        w.y(i3, z16);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchConfigUtilFetcher
    public void setSFtsSearchBarWording(String str) {
        w.f285090a = str;
    }
}
