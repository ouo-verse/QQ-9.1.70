package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_template;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellTemplate implements SmartParcelable {

    @NeedParcel
    public String templateId;

    @NeedParcel
    public int templateType;

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellTemplate {\n");
        if (!TextUtils.isEmpty(this.templateId)) {
            sb5.append("templateId: ");
            sb5.append(this.templateId);
            sb5.append(", ");
        }
        sb5.append("templateType: ");
        sb5.append(this.templateType);
        sb5.append("\n}");
        return sb5.toString();
    }

    public static CellTemplate create(l lVar) {
        if (lVar == null || lVar.Q == null) {
            return null;
        }
        CellTemplate cellTemplate = new CellTemplate();
        cell_template cell_templateVar = lVar.Q;
        cellTemplate.templateId = cell_templateVar.f24986id;
        cellTemplate.templateType = cell_templateVar.type;
        return cellTemplate;
    }
}
