package com.tencent.hippykotlin.demo.pages.vas_base.intersection_observer;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangle$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__IndentKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class IntersectionObserverEntry {
    public final float intersectionRatio;
    public final Rect intersectionRect;
    public final boolean isIntersecting;
    public final ObservableView<?, ?> target;

    public IntersectionObserverEntry(ObservableView<?, ?> observableView, float f16, Rect rect, boolean z16) {
        this.target = observableView;
        this.intersectionRatio = f16;
        this.intersectionRect = rect;
        this.isIntersecting = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = (this.intersectionRect.hashCode() + PopoverTriangle$$ExternalSyntheticOutline0.m(this.intersectionRatio, this.target.hashCode() * 31, 31)) * 31;
        boolean z16 = this.isIntersecting;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final String toString() {
        String trimIndent;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\n            target: ");
        m3.append(Reflection.getOrCreateKotlinClass(this.target.getClass()).getSimpleName());
        m3.append("\n            intersectionRatio: ");
        m3.append(this.intersectionRatio);
        m3.append("\n            isIntersecting: ");
        m3.append(this.isIntersecting);
        m3.append("\n        ");
        trimIndent = StringsKt__IndentKt.trimIndent(m3.toString());
        return trimIndent;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntersectionObserverEntry)) {
            return false;
        }
        IntersectionObserverEntry intersectionObserverEntry = (IntersectionObserverEntry) obj;
        return Intrinsics.areEqual(this.target, intersectionObserverEntry.target) && Float.compare(this.intersectionRatio, intersectionObserverEntry.intersectionRatio) == 0 && Intrinsics.areEqual(this.intersectionRect, intersectionObserverEntry.intersectionRect) && this.isIntersecting == intersectionObserverEntry.isIntersecting;
    }
}
