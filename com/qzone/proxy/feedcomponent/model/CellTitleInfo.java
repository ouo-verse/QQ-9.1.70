package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_title;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellTitleInfo implements SmartParcelable {
    public static final String TITLE_TAB = "title";

    @NeedParcel
    public int actionType;
    public String displayTitle;
    public Integer integerUnikey;
    public String likeListStr;

    @NeedParcel
    public String relation_type;

    @NeedParcel
    public int status;

    @NeedParcel
    public String title;

    @NeedParcel
    public String titleUrl;
    public String uniKey;

    @NeedParcel
    public User user;

    @NeedParcel
    public List<User> userList;

    @NeedParcel
    public int userNum;

    public boolean isEmpty() {
        List<User> list;
        return TextUtils.isEmpty(this.title) && ((list = this.userList) == null || list.size() == 0);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellTitleInfo {\n");
        if (!TextUtils.isEmpty(this.title)) {
            sb5.append("title: ");
            sb5.append(this.title);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.titleUrl)) {
            sb5.append("titleUrl: ");
            sb5.append(this.titleUrl);
            sb5.append("\n");
        }
        List<User> list = this.userList;
        if (list != null && list.size() > 0) {
            sb5.append("userList: ");
            sb5.append("\n");
            for (int i3 = 0; i3 < this.userList.size(); i3++) {
                sb5.append("[");
                sb5.append(i3);
                sb5.append("]: ");
                sb5.append(this.userList.get(i3));
                sb5.append("\n");
            }
        }
        sb5.append("userNum: ");
        sb5.append(this.userNum);
        sb5.append("\n");
        sb5.append("actionType: ");
        sb5.append(this.actionType);
        sb5.append("\n");
        if (this.user != null) {
            sb5.append("user: ");
            sb5.append(this.user);
            sb5.append(",\n");
        }
        if (!TextUtils.isEmpty(this.relation_type)) {
            sb5.append("relation_type: ");
            sb5.append(this.relation_type);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.displayTitle)) {
            sb5.append("displayTitle: ");
            sb5.append(this.displayTitle);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.likeListStr)) {
            sb5.append("likeListStr: ");
            sb5.append(this.likeListStr);
            sb5.append("\n");
        }
        sb5.append("status: ");
        sb5.append(this.status);
        sb5.append("\n}");
        return sb5.toString();
    }

    public static CellTitleInfo create(l lVar) {
        if (lVar == null || lVar.f50346d == null) {
            return null;
        }
        CellTitleInfo cellTitleInfo = new CellTitleInfo();
        cell_title cell_titleVar = lVar.f50346d;
        cellTitleInfo.title = cell_titleVar.title;
        cellTitleInfo.titleUrl = cell_titleVar.titleurl;
        if (cell_titleVar.userlist != null) {
            cellTitleInfo.userList = new ArrayList();
            int size = lVar.f50346d.userlist.size();
            for (int i3 = 0; i3 < size; i3++) {
                User q16 = com.qzone.proxy.feedcomponent.util.e.q(lVar.f50346d.userlist.get(i3));
                com.qzone.proxy.feedcomponent.util.e.c(lVar, q16);
                cellTitleInfo.userList.add(q16);
            }
        }
        cell_title cell_titleVar2 = lVar.f50346d;
        cellTitleInfo.userNum = cell_titleVar2.usernum;
        cellTitleInfo.actionType = cell_titleVar2.actiontype;
        cellTitleInfo.user = User.fromSUser(cell_titleVar2.user);
        cell_title cell_titleVar3 = lVar.f50346d;
        cellTitleInfo.relation_type = cell_titleVar3.relation_type;
        cellTitleInfo.status = cell_titleVar3.status;
        return cellTitleInfo;
    }
}
