package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class CollectAnimation {
    public boolean fromLeft;

    /* renamed from: id, reason: collision with root package name */
    public String f114259id;
    public boolean isPlaying;
    public Function0<Unit> onFinish;
    public boolean waitFroRemove;

    public CollectAnimation(String str, boolean z16, boolean z17, boolean z18, Function0<Unit> function0) {
        this.f114259id = str;
        this.fromLeft = z16;
        this.isPlaying = z17;
        this.waitFroRemove = z18;
        this.onFinish = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.f114259id.hashCode() * 31;
        boolean z16 = this.fromLeft;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        boolean z17 = this.isPlaying;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z18 = this.waitFroRemove;
        return this.onFinish.hashCode() + ((i18 + (z18 ? 1 : z18 ? 1 : 0)) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("CollectAnimation(id=");
        m3.append(this.f114259id);
        m3.append(", fromLeft=");
        m3.append(this.fromLeft);
        m3.append(", isPlaying=");
        m3.append(this.isPlaying);
        m3.append(", waitFroRemove=");
        m3.append(this.waitFroRemove);
        m3.append(", onFinish=");
        m3.append(this.onFinish);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CollectAnimation)) {
            return false;
        }
        CollectAnimation collectAnimation = (CollectAnimation) obj;
        return Intrinsics.areEqual(this.f114259id, collectAnimation.f114259id) && this.fromLeft == collectAnimation.fromLeft && this.isPlaying == collectAnimation.isPlaying && this.waitFroRemove == collectAnimation.waitFroRemove && Intrinsics.areEqual(this.onFinish, collectAnimation.onFinish);
    }
}
