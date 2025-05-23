package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NavBarData {
    public final boolean showBackIcon;
    public final boolean showCloseIcon;
    public final String title;

    public /* synthetic */ NavBarData(String str, boolean z16) {
        this(str, z16, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.title.hashCode() * 31;
        boolean z16 = this.showBackIcon;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        boolean z17 = this.showCloseIcon;
        return i16 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NavBarData(title=");
        m3.append(this.title);
        m3.append(", showBackIcon=");
        m3.append(this.showBackIcon);
        m3.append(", showCloseIcon=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.showCloseIcon, ')');
    }

    public NavBarData(String str, boolean z16, boolean z17) {
        this.title = str;
        this.showBackIcon = z16;
        this.showCloseIcon = z17;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NavBarData)) {
            return false;
        }
        NavBarData navBarData = (NavBarData) obj;
        return Intrinsics.areEqual(this.title, navBarData.title) && this.showBackIcon == navBarData.showBackIcon && this.showCloseIcon == navBarData.showCloseIcon;
    }
}
