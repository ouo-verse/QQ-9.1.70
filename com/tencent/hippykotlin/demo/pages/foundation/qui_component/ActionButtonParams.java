package com.tencent.hippykotlin.demo.pages.foundation.qui_component;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ActionButtonParams {
    public final int index;
    public final String text;

    public ActionButtonParams(int i3, String str) {
        this.index = i3;
        this.text = str;
    }

    public final int hashCode() {
        return this.text.hashCode() + (this.index * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ActionButtonParams(index=");
        m3.append(this.index);
        m3.append(", text=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.text, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionButtonParams)) {
            return false;
        }
        ActionButtonParams actionButtonParams = (ActionButtonParams) obj;
        return this.index == actionButtonParams.index && Intrinsics.areEqual(this.text, actionButtonParams.text);
    }
}
