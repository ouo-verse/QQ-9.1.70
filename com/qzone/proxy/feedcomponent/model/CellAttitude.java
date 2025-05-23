package com.qzone.proxy.feedcomponent.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellAttitude implements SmartParcelable {

    @NeedParcel
    public int num = 0;

    public static CellAttitude create(l lVar) {
        if (lVar == null || lVar.f50377s0 == null) {
            return null;
        }
        CellAttitude cellAttitude = new CellAttitude();
        cellAttitude.num = lVar.f50377s0.num;
        return cellAttitude;
    }
}
