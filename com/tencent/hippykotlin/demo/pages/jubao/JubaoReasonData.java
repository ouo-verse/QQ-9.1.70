package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoReasonData {
    public final String description;
    public final boolean extra;
    public final boolean moreEvidence;
    public final String name;
    public final ArrayList<JubaoTypeData> types;

    public JubaoReasonData(String str, ArrayList<JubaoTypeData> arrayList, boolean z16, boolean z17, String str2) {
        this.name = str;
        this.types = arrayList;
        this.moreEvidence = z16;
        this.extra = z17;
        this.description = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        ArrayList<JubaoTypeData> arrayList = this.types;
        int hashCode2 = (hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        boolean z16 = this.moreEvidence;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        boolean z17 = this.extra;
        return this.description.hashCode() + ((i16 + (z17 ? 1 : z17 ? 1 : 0)) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("JubaoReasonData(name=");
        m3.append(this.name);
        m3.append(", types=");
        m3.append(this.types);
        m3.append(", moreEvidence=");
        m3.append(this.moreEvidence);
        m3.append(", extra=");
        m3.append(this.extra);
        m3.append(", description=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.description, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JubaoReasonData)) {
            return false;
        }
        JubaoReasonData jubaoReasonData = (JubaoReasonData) obj;
        return Intrinsics.areEqual(this.name, jubaoReasonData.name) && Intrinsics.areEqual(this.types, jubaoReasonData.types) && this.moreEvidence == jubaoReasonData.moreEvidence && this.extra == jubaoReasonData.extra && Intrinsics.areEqual(this.description, jubaoReasonData.description);
    }
}
