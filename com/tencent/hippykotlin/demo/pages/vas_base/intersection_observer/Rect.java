package com.tencent.hippykotlin.demo.pages.vas_base.intersection_observer;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.text.StringsKt__IndentKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Rect {
    public float height;
    public float width;

    /* renamed from: x, reason: collision with root package name */
    public float f114307x;

    /* renamed from: y, reason: collision with root package name */
    public float f114308y;

    public Rect(float f16, float f17, float f18, float f19) {
        this.f114307x = f16;
        this.f114308y = f17;
        this.width = f18;
        this.height = f19;
    }

    public final void intersect(Rect rect, Margin margin) {
        Rect rect2 = new Rect(rect.f114307x, rect.f114308y, rect.width, rect.height);
        if (margin != null) {
            rect2.width += 0.0f;
            rect2.height += 0.0f;
            translate(0.0f, 0.0f);
        }
        float f16 = this.f114307x;
        if (f16 <= rect2.width && this.width + f16 >= 0.0f) {
            float f17 = this.f114308y;
            if (f17 <= rect2.height && f17 + this.height >= 0.0f) {
                float max = Math.max(f16, 0.0f);
                float max2 = Math.max(this.f114308y, 0.0f);
                float min = Math.min(this.f114307x + this.width, rect2.width);
                float min2 = Math.min(this.f114308y + this.height, rect2.height);
                this.f114307x = max;
                this.f114308y = max2;
                this.width = min - max;
                this.height = min2 - max2;
                return;
            }
        }
        this.f114307x = 0.0f;
        this.f114308y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
    }

    public final boolean isZero() {
        if (this.f114307x == 0.0f) {
            if (this.f114308y == 0.0f) {
                if (this.width == 0.0f) {
                    if (this.height == 0.0f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final String toString() {
        String trimIndent;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\n            x: ");
        m3.append(this.f114307x);
        m3.append(",\n            y: ");
        m3.append(this.f114308y);
        m3.append(",\n            width: ");
        m3.append(this.width);
        m3.append(",\n            height: ");
        m3.append(this.height);
        m3.append("\n        ");
        trimIndent = StringsKt__IndentKt.trimIndent(m3.toString());
        return trimIndent;
    }

    public final void translate(float f16, float f17) {
        this.f114307x += f16;
        this.f114308y += f17;
    }
}
