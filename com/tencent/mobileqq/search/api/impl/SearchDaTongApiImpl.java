package com.tencent.mobileqq.search.api.impl;

import com.tencent.mobileqq.search.api.ISearchDaTongApi;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.search.model.af;
import com.tencent.mobileqq.search.model.ah;
import com.tencent.mobileqq.search.model.j;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.searchlocal.model.SearchHistory;
import com.tencent.mobileqq.search.util.am;
import do2.h;
import lo2.NetSearchTemplateUsedMiniAppItem;
import lo2.ad;
import lo2.ag;
import lo2.ai;
import lo2.q;
import lo2.s;
import lo2.t;
import lo2.x;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchDaTongApiImpl implements ISearchDaTongApi {
    @Override // com.tencent.mobileqq.search.api.ISearchDaTongApi
    public String getDisplayType(v vVar) {
        if (!(vVar instanceof ah) && !(vVar instanceof x) && !(vVar instanceof com.tencent.mobileqq.search.ftsmsg.a) && !(vVar instanceof h) && !(vVar instanceof j) && !(vVar instanceof t) && !(vVar instanceof ai) && !(vVar instanceof s) && !(vVar instanceof ag) && !(vVar instanceof q) && !(vVar instanceof lo2.v) && !(vVar instanceof NetSearchTemplateUsedMiniAppItem)) {
            if (!(vVar instanceof af) && !(vVar instanceof ac) && !(vVar instanceof ad)) {
                return "5";
            }
            return "2";
        }
        return "1";
    }

    @Override // com.tencent.mobileqq.search.api.ISearchDaTongApi
    public String getDocId(int i3, String str) {
        return am.d(i3, str);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchDaTongApi
    public String getFavoritDocType(v vVar) {
        if (vVar instanceof cooperation.qqfav.globalsearch.b) {
            int i3 = ((cooperation.qqfav.globalsearch.b) vVar).U;
            if (i3 == 3) {
                return "6";
            }
            if (i3 == 4) {
                return "10";
            }
            if (i3 == 5) {
                return "5";
            }
            if (i3 == 6) {
                return "9";
            }
            if (i3 == 2 || i3 == 8) {
                return "4";
            }
            return "24";
        }
        return "24";
    }

    @Override // com.tencent.mobileqq.search.api.ISearchDaTongApi
    public int getSearchHistoryType(Object obj) {
        if (obj instanceof SearchHistory) {
            return ((SearchHistory) obj).type;
        }
        return 0;
    }
}
