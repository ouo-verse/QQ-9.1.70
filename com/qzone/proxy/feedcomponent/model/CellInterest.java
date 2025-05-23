package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_interest;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellInterest implements SmartParcelable {
    public static final String INTEREST_LIST_TAB = "interset_list";

    @NeedParcel
    public String desc;

    @NeedParcel
    public int num;
    public String unikey;

    @NeedParcel
    public ArrayList<User> users;
    public String displayUserStr = "";
    public String displayEllipsisStr = "";

    public void calculateDisplayStr(String str) {
        this.displayUserStr = com.qzone.proxy.feedcomponent.util.d.f(this, "\u3001", 15);
        this.displayEllipsisStr = com.qzone.proxy.feedcomponent.util.d.e(this, "\u3001", 15);
        if (!TextUtils.isEmpty(this.displayUserStr)) {
            this.unikey = str + INTEREST_LIST_TAB;
            return;
        }
        this.unikey = null;
    }

    public static CellInterest create(l lVar) {
        if (lVar == null || lVar.H == null) {
            return null;
        }
        CellInterest cellInterest = new CellInterest();
        cell_interest cell_interestVar = lVar.H;
        cellInterest.num = cell_interestVar.num;
        cellInterest.desc = cell_interestVar.desc;
        if (cell_interestVar.users != null) {
            cellInterest.users = new ArrayList<>();
            int size = lVar.H.users.size();
            for (int i3 = 0; i3 < size; i3++) {
                User q16 = com.qzone.proxy.feedcomponent.util.e.q(lVar.H.users.get(i3));
                com.qzone.proxy.feedcomponent.util.e.c(lVar, q16);
                cellInterest.users.add(q16);
            }
        }
        return cellInterest;
    }
}
