package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.s_presentman;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes39.dex */
public class CellPresentInfo implements SmartParcelable {

    @NeedParcel
    public long num = 0;

    @NeedParcel
    public ArrayList<PresentMan> presentmans = null;

    public static CellPresentInfo createFrom(l lVar) {
        if (lVar == null || lVar.f50373q0 == null) {
            return null;
        }
        CellPresentInfo cellPresentInfo = new CellPresentInfo();
        cellPresentInfo.num = lVar.f50373q0.num;
        cellPresentInfo.presentmans = new ArrayList<>();
        Iterator<s_presentman> it = lVar.f50373q0.presentmans.iterator();
        while (it.hasNext()) {
            cellPresentInfo.presentmans.add(new PresentMan(User.fromSUser(it.next().user)));
        }
        return cellPresentInfo;
    }
}
