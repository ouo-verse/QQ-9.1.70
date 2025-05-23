package com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class LoadFailParams {
    public final int code;

    /* renamed from: msg, reason: collision with root package name */
    public final String f114177msg;

    public LoadFailParams(int i3, String str) {
        this.code = i3;
        this.f114177msg = str;
    }

    public final int hashCode() {
        int i3 = this.code * 31;
        String str = this.f114177msg;
        return i3 + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("LoadFailParams(code=");
        m3.append(this.code);
        m3.append(", msg=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.f114177msg, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoadFailParams)) {
            return false;
        }
        LoadFailParams loadFailParams = (LoadFailParams) obj;
        return this.code == loadFailParams.code && Intrinsics.areEqual(this.f114177msg, loadFailParams.f114177msg);
    }
}
