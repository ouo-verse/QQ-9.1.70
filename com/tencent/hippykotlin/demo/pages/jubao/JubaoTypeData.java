package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoTypeData {

    /* renamed from: id, reason: collision with root package name */
    public final Integer f114200id;
    public final String name;

    public JubaoTypeData(String str, Integer num) {
        this.name = str;
        this.f114200id = num;
    }

    public final int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        Integer num = this.f114200id;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("JubaoTypeData(name=");
        m3.append(this.name);
        m3.append(", id=");
        m3.append(this.f114200id);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JubaoTypeData)) {
            return false;
        }
        JubaoTypeData jubaoTypeData = (JubaoTypeData) obj;
        return Intrinsics.areEqual(this.name, jubaoTypeData.name) && Intrinsics.areEqual(this.f114200id, jubaoTypeData.f114200id);
    }
}
