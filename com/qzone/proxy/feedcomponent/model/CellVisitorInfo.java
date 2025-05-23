package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_visitor;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellVisitorInfo implements SmartParcelable {
    public static final String VISIT_LIST_TAB = "visit_list";
    public String unikey;

    @NeedParcel
    public int viewCount;

    @NeedParcel
    public int viewCountByFriends;

    @NeedParcel
    public int visitorCount;

    @NeedParcel
    public ArrayList<User> visitors;
    public String visitorDecoDisplayStr = "";
    public String displayStr = "";

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellVisitorInfo {\n");
        sb5.append("viewCount: ");
        sb5.append(this.viewCount);
        sb5.append("\n");
        sb5.append("visitorCount: ");
        sb5.append(this.visitorCount);
        sb5.append("\n");
        sb5.append("viewCountByFriends: ");
        sb5.append(this.viewCountByFriends);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.displayStr)) {
            sb5.append("displayStr: ");
            sb5.append(this.displayStr);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.unikey)) {
            sb5.append("unikey: ");
            sb5.append(this.unikey);
            sb5.append("\n");
        }
        sb5.append("}");
        return sb5.toString();
    }

    public static CellVisitorInfo create(l lVar) {
        if (lVar == null || lVar.f50382v == null) {
            return null;
        }
        CellVisitorInfo cellVisitorInfo = new CellVisitorInfo();
        cell_visitor cell_visitorVar = lVar.f50382v;
        cellVisitorInfo.viewCount = cell_visitorVar.view_count;
        cellVisitorInfo.visitorCount = cell_visitorVar.visitor_count;
        cellVisitorInfo.viewCountByFriends = cell_visitorVar.view_count_byfriends;
        return cellVisitorInfo;
    }
}
