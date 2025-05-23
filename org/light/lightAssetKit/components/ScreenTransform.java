package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ScreenTransform extends BasicTransform {
    private boolean interactive;
    private Rect anchor = new Rect(-1.0f, -1.0f, 1.0f, 1.0f);
    private Rect offset = new Rect();
    private Vec2 pivot = new Vec2();
    private boolean attachToParent = true;

    @Override // org.light.lightAssetKit.components.BasicTransform, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    protected void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof ScreenTransform) {
            ScreenTransform screenTransform = (ScreenTransform) componentBase;
            this.anchor = screenTransform.anchor;
            this.offset = screenTransform.offset;
            this.pivot = screenTransform.pivot;
            this.interactive = screenTransform.interactive;
            this.attachToParent = screenTransform.attachToParent;
        }
        super.doUpdate(componentBase);
    }

    public Rect getAnchor() {
        return this.anchor;
    }

    public boolean getAttachToParent() {
        return this.attachToParent;
    }

    public boolean getInteractive() {
        return this.interactive;
    }

    public Rect getOffset() {
        return this.offset;
    }

    public Vec2 getPivot() {
        return this.pivot;
    }

    public void setAnchor(Rect rect) {
        this.anchor = rect;
        reportPropertyChange("anchor", rect);
    }

    public void setAttachToParent(boolean z16) {
        this.attachToParent = z16;
        reportPropertyChange("attachToParent", Boolean.valueOf(z16));
    }

    public void setInteractive(boolean z16) {
        this.interactive = z16;
        reportPropertyChange("interactive", Boolean.valueOf(z16));
    }

    public void setOffset(Rect rect) {
        this.offset = rect;
        reportPropertyChange("offset", rect);
    }

    public void setPivot(Vec2 vec2) {
        this.pivot = vec2;
        reportPropertyChange("pivot", vec2);
    }

    @Override // org.light.lightAssetKit.components.BasicTransform, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "ScreenTransform";
    }
}
