package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_recomed_list;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellRecommendList implements SmartParcelable {

    @NeedParcel
    public boolean isRecommended;

    @NeedParcel
    public int num;

    @NeedParcel
    public ArrayList<RecommendMan> recommendMans;
    public boolean stateChanged = true;
    public String unikey;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class RecommendMan implements SmartParcelable {

        @NeedParcel
        public User user;

        public RecommendMan() {
        }

        public RecommendMan(User user) {
            this.user = user;
        }
    }

    public ArrayList<RecommendMan> getUserList() {
        return this.recommendMans;
    }

    public static CellRecommendList create(l lVar) {
        if (lVar == null || lVar.f50387x0 == null) {
            return null;
        }
        CellRecommendList cellRecommendList = new CellRecommendList();
        cell_recomed_list cell_recomed_listVar = lVar.f50387x0;
        cellRecommendList.num = cell_recomed_listVar.num;
        cellRecommendList.isRecommended = cell_recomed_listVar.isrecomed == 1;
        if (cell_recomed_listVar.likemans != null) {
            cellRecommendList.recommendMans = new ArrayList<>();
            int size = lVar.f50387x0.likemans.size();
            for (int i3 = 0; i3 < size; i3++) {
                RecommendMan recommendMan = new RecommendMan();
                recommendMan.user = com.qzone.proxy.feedcomponent.util.e.q(lVar.f50387x0.likemans.get(i3).user);
                cellRecommendList.recommendMans.add(recommendMan);
            }
        }
        return cellRecommendList;
    }
}
