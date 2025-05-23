package com.tencent.hippykotlin.demo.pages.retain.repo;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ECRetainInfoModel {
    public final e data;
    public final String retainId;
    public final String spuId;
    public final int type;

    public ECRetainInfoModel(String str, String str2, int i3, e eVar) {
        this.retainId = str;
        this.spuId = str2;
        this.type = i3;
        this.data = eVar;
    }

    public final int hashCode() {
        return this.data.hashCode() + ((BoxType$EnumUnboxingSharedUtility.ordinal(this.type) + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.spuId, this.retainId.hashCode() * 31, 31)) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ECRetainInfoModel(retainId=");
        m3.append(this.retainId);
        m3.append(", spuId=");
        m3.append(this.spuId);
        m3.append(", type=");
        m3.append(ECRetainInfoPromoteType$EnumUnboxingLocalUtility.stringValueOf(this.type));
        m3.append(", data=");
        m3.append(this.data);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ECRetainInfoModel)) {
            return false;
        }
        ECRetainInfoModel eCRetainInfoModel = (ECRetainInfoModel) obj;
        return Intrinsics.areEqual(this.retainId, eCRetainInfoModel.retainId) && Intrinsics.areEqual(this.spuId, eCRetainInfoModel.spuId) && this.type == eCRetainInfoModel.type && Intrinsics.areEqual(this.data, eCRetainInfoModel.data);
    }
}
