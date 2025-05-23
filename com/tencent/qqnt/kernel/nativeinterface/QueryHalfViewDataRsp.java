package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class QueryHalfViewDataRsp {
    public String topName = "";
    public String bottomGrayText = "";
    public byte[] pagingCookie = new byte[0];
    public ArrayList<HalfViewCardNode> cardNodes = new ArrayList<>();
    public HashMap<String, String> layoutMap = new HashMap<>();
    public HashMap<String, String> attrMap = new HashMap<>();

    public HashMap<String, String> getAttrMap() {
        return this.attrMap;
    }

    public String getBottomGrayText() {
        return this.bottomGrayText;
    }

    public ArrayList<HalfViewCardNode> getCardNodes() {
        return this.cardNodes;
    }

    public HashMap<String, String> getLayoutMap() {
        return this.layoutMap;
    }

    public byte[] getPagingCookie() {
        return this.pagingCookie;
    }

    public String getTopName() {
        return this.topName;
    }

    public String toString() {
        return "QueryHalfViewDataRsp{topName=" + this.topName + ",bottomGrayText=" + this.bottomGrayText + ",pagingCookie=" + this.pagingCookie + ",cardNodes=" + this.cardNodes + ",layoutMap=" + this.layoutMap + ",attrMap=" + this.attrMap + ",}";
    }
}
