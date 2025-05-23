package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_forward_list;
import NS_MOBILE_FEEDS.s_user;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.ditto.area.DittoArea;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellForwardListInfo implements SmartParcelable {
    public static final String FORWARD_LIST_TAB = "forward_list";
    public String unikey;

    @NeedParcel
    public int num = 0;

    @NeedParcel
    public boolean isforward = false;

    @NeedParcel
    public ArrayList<User> fwdmans = new ArrayList<>();

    @NeedParcel
    public String actionUrl = "";

    @NeedParcel
    public String forwardkey = "";

    @NeedParcel
    public Map<String, String> extendinfo = null;
    public String displayStr = "";
    public Integer integerUnikey = -1;

    @NeedParcel
    public String forwardNumInfoFoldText = "";

    public void calculateDisplayStr(String str, boolean z16) {
        String d16 = com.qzone.proxy.feedcomponent.util.d.d(this, "\u3001", 5, z16);
        this.displayStr = d16;
        if (!TextUtils.isEmpty(d16)) {
            this.displayStr = " " + this.displayStr;
            DittoArea.removeAreaCache(this.integerUnikey);
            String str2 = str + FORWARD_LIST_TAB + "_" + System.currentTimeMillis();
            this.unikey = str2;
            this.integerUnikey = Integer.valueOf(str2.hashCode());
            return;
        }
        this.unikey = null;
        this.integerUnikey = -1;
    }

    public static CellForwardListInfo create(l lVar) {
        if (lVar == null || lVar.f50357i0 == null) {
            return null;
        }
        CellForwardListInfo cellForwardListInfo = new CellForwardListInfo();
        cell_forward_list cell_forward_listVar = lVar.f50357i0;
        cellForwardListInfo.num = cell_forward_listVar.num;
        cellForwardListInfo.isforward = cell_forward_listVar.isforward == 1;
        cellForwardListInfo.actionUrl = cell_forward_listVar.actionUrl;
        cellForwardListInfo.forwardkey = cell_forward_listVar.forwardkey;
        cellForwardListInfo.forwardNumInfoFoldText = cell_forward_listVar.txt;
        ArrayList<s_user> arrayList = cell_forward_listVar.fwdmans;
        if (arrayList != null) {
            cellForwardListInfo.fwdmans = User.fromSUserList(arrayList);
        }
        HashMap hashMap = new HashMap();
        cellForwardListInfo.extendinfo = hashMap;
        hashMap.putAll(lVar.f50357i0.extendinfo);
        return cellForwardListInfo;
    }
}
