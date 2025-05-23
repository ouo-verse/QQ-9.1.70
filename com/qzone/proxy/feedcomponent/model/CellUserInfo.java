package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_userinfo;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellUserInfo implements SmartParcelable {

    @NeedParcel
    public int actionType;

    @NeedParcel
    public ArrayList<String> luckyMoneyPics;
    public String uniKey;

    @NeedParcel
    public User user;

    public int getActionType() {
        return this.actionType;
    }

    public ArrayList<String> getLuckyMoneyPics() {
        return this.luckyMoneyPics;
    }

    public User getUser() {
        if (this.user == null) {
            this.user = new User();
        }
        return this.user;
    }

    public User getUserV2() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellUserInfo {\n");
        sb5.append("actionType=");
        sb5.append(this.actionType);
        sb5.append("\n");
        if (this.user != null) {
            sb5.append("user=");
            sb5.append(this.user);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.uniKey)) {
            sb5.append("uniKey=");
            sb5.append(this.uniKey);
        }
        sb5.append("}");
        return sb5.toString();
    }

    public static CellUserInfo create(l lVar) {
        if (lVar == null || lVar.f50342b == null) {
            return null;
        }
        CellUserInfo cellUserInfo = new CellUserInfo();
        User q16 = com.qzone.proxy.feedcomponent.util.e.q(lVar.f50342b.user);
        com.qzone.proxy.feedcomponent.util.e.c(lVar, q16);
        cellUserInfo.user = q16;
        cell_userinfo cell_userinfoVar = lVar.f50342b;
        cellUserInfo.actionType = cell_userinfoVar.actiontype;
        if (cell_userinfoVar.luckyMoneyPics != null) {
            cellUserInfo.luckyMoneyPics = new ArrayList<>();
            Iterator<String> it = lVar.f50342b.luckyMoneyPics.iterator();
            while (it.hasNext()) {
                cellUserInfo.luckyMoneyPics.add(it.next());
            }
        }
        return cellUserInfo;
    }

    public static CellUserInfo createWithLocalInfo(CellUserInfo cellUserInfo, l lVar) {
        if (lVar == null || lVar.f50342b == null) {
            return null;
        }
        CellUserInfo cellUserInfo2 = new CellUserInfo();
        User q16 = com.qzone.proxy.feedcomponent.util.e.q(lVar.f50342b.user);
        com.qzone.proxy.feedcomponent.util.e.c(lVar, q16);
        if (lVar.f50367n0 == null && cellUserInfo != null) {
            com.qzone.proxy.feedcomponent.util.e.u(cellUserInfo.user, q16);
        }
        cellUserInfo2.user = q16;
        cell_userinfo cell_userinfoVar = lVar.f50342b;
        cellUserInfo2.actionType = cell_userinfoVar.actiontype;
        if (cell_userinfoVar.luckyMoneyPics != null) {
            cellUserInfo2.luckyMoneyPics = new ArrayList<>();
            Iterator<String> it = lVar.f50342b.luckyMoneyPics.iterator();
            while (it.hasNext()) {
                cellUserInfo2.luckyMoneyPics.add(it.next());
            }
        }
        return cellUserInfo2;
    }
}
