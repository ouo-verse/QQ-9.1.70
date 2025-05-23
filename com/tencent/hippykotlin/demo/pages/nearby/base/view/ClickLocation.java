package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.reflect.KClass;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ClickLocation {

    /* renamed from: x, reason: collision with root package name */
    public float f114210x;

    /* renamed from: y, reason: collision with root package name */
    public float f114211y;

    public /* synthetic */ ClickLocation() {
        this(0.0f, 0.0f);
    }

    public ClickLocation(float f16, float f17) {
        this.f114210x = f16;
        this.f114211y = f17;
    }

    public final ClickLocation getTargetLocation(ViewContainer<?, ?> viewContainer, KClass<?> kClass) {
        ViewContainer<?, ?> parent;
        if (viewContainer != null && !kClass.isInstance(viewContainer) && (parent = viewContainer.getParent()) != null) {
            this.f114210x = viewContainer.getFrame().getX() + this.f114210x;
            this.f114211y = viewContainer.getFrame().getY() + this.f114211y;
            return getTargetLocation(parent, kClass);
        }
        return this;
    }
}
