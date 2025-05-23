package com.qzone.proxy.feedcomponent.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellRecommFooter implements SmartParcelable {

    @NeedParcel
    public String text = "";

    public String toString() {
        return "CellRecommFooter {\ntext: " + this.text + "\n}";
    }

    public static CellRecommFooter create(l lVar) {
        if (lVar == null || lVar.J == null) {
            return null;
        }
        CellRecommFooter cellRecommFooter = new CellRecommFooter();
        cellRecommFooter.text = lVar.J.text;
        return cellRecommFooter;
    }
}
