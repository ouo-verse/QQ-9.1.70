package com.tencent.hippykotlin.demo.pages.base.model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class KTVEntry {
    public final String key;
    public final String value;

    public KTVEntry() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final int hashCode() {
        return this.value.hashCode() + (this.key.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("KTVEntry(key=");
        m3.append(this.key);
        m3.append(", value=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.value, ')');
    }

    public KTVEntry(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public /* synthetic */ KTVEntry(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KTVEntry)) {
            return false;
        }
        KTVEntry kTVEntry = (KTVEntry) obj;
        return Intrinsics.areEqual(this.key, kTVEntry.key) && Intrinsics.areEqual(this.value, kTVEntry.value);
    }
}
