package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import g25.k;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class RegularDelegateData extends AbsDelegateData {
    public final List<k> data;
    public final String tabId;
    public final String tabName;

    public final int hashCode() {
        return this.tabId.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.tabName, this.data.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("RegularDelegateData(data=");
        m3.append(this.data);
        m3.append(", tabName=");
        m3.append(this.tabName);
        m3.append(", tabId=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.tabId, ')');
    }

    public RegularDelegateData(List<k> list, String str, String str2) {
        super(5);
        this.data = list;
        this.tabName = str;
        this.tabId = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegularDelegateData)) {
            return false;
        }
        RegularDelegateData regularDelegateData = (RegularDelegateData) obj;
        return Intrinsics.areEqual(this.data, regularDelegateData.data) && Intrinsics.areEqual(this.tabName, regularDelegateData.tabName) && Intrinsics.areEqual(this.tabId, regularDelegateData.tabId);
    }
}
