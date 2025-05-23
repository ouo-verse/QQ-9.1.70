package org.jbox2d.common;

/* compiled from: P */
/* loaded from: classes29.dex */
public class OBBViewportTransform implements IViewportTransform {
    protected final OBB box;
    private final Mat22 inv;
    private final Mat22 inv2;
    private boolean yFlip;
    private final Mat22 yFlipMat;
    private final Mat22 yFlipMatInv;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class OBB {
        public final Mat22 R = new Mat22();
        public final Vec2 center = new Vec2();
        public final Vec2 extents = new Vec2();
    }

    public OBBViewportTransform() {
        OBB obb = new OBB();
        this.box = obb;
        this.yFlip = false;
        Mat22 mat22 = new Mat22(1.0f, 0.0f, 0.0f, -1.0f);
        this.yFlipMat = mat22;
        this.yFlipMatInv = mat22.invert();
        this.inv = new Mat22();
        this.inv2 = new Mat22();
        obb.R.setIdentity();
    }

    @Override // org.jbox2d.common.IViewportTransform
    public Vec2 getCenter() {
        return this.box.center;
    }

    @Override // org.jbox2d.common.IViewportTransform
    public Vec2 getExtents() {
        return this.box.extents;
    }

    @Override // org.jbox2d.common.IViewportTransform
    public void getScreenToWorld(Vec2 vec2, Vec2 vec22) {
        vec22.set(vec2);
        vec22.subLocal(this.box.extents);
        this.box.R.invertToOut(this.inv2);
        this.inv2.mulToOut(vec22, vec22);
        if (this.yFlip) {
            this.yFlipMatInv.mulToOut(vec22, vec22);
        }
        vec22.addLocal(this.box.center);
    }

    @Override // org.jbox2d.common.IViewportTransform
    public void getScreenVectorToWorld(Vec2 vec2, Vec2 vec22) {
        this.inv.set(this.box.R);
        this.inv.invertLocal();
        this.inv.mulToOut(vec2, vec22);
        if (this.yFlip) {
            this.yFlipMatInv.mulToOut(vec22, vec22);
        }
    }

    public Mat22 getTransform() {
        return this.box.R;
    }

    @Override // org.jbox2d.common.IViewportTransform
    public void getWorldToScreen(Vec2 vec2, Vec2 vec22) {
        float f16 = vec2.f423649x;
        OBB obb = this.box;
        Vec2 vec23 = obb.center;
        vec22.f423649x = f16 - vec23.f423649x;
        vec22.f423650y = vec2.f423650y - vec23.f423650y;
        obb.R.mulToOut(vec22, vec22);
        if (this.yFlip) {
            this.yFlipMat.mulToOut(vec22, vec22);
        }
        float f17 = vec22.f423649x;
        Vec2 vec24 = this.box.extents;
        vec22.f423649x = f17 + vec24.f423649x;
        vec22.f423650y += vec24.f423650y;
    }

    @Override // org.jbox2d.common.IViewportTransform
    public void getWorldVectorToScreen(Vec2 vec2, Vec2 vec22) {
        this.box.R.mulToOut(vec2, vec22);
        if (this.yFlip) {
            this.yFlipMatInv.mulToOut(vec22, vec22);
        }
    }

    @Override // org.jbox2d.common.IViewportTransform
    public boolean isYFlip() {
        return this.yFlip;
    }

    public void mulByTransform(Mat22 mat22) {
        this.box.R.mulLocal(mat22);
    }

    public void set(OBBViewportTransform oBBViewportTransform) {
        this.box.center.set(oBBViewportTransform.box.center);
        this.box.extents.set(oBBViewportTransform.box.extents);
        this.box.R.set(oBBViewportTransform.box.R);
        this.yFlip = oBBViewportTransform.yFlip;
    }

    @Override // org.jbox2d.common.IViewportTransform
    public void setCamera(float f16, float f17, float f18) {
        this.box.center.set(f16, f17);
        Mat22.createScaleTransform(f18, this.box.R);
    }

    @Override // org.jbox2d.common.IViewportTransform
    public void setCenter(Vec2 vec2) {
        this.box.center.set(vec2);
    }

    @Override // org.jbox2d.common.IViewportTransform
    public void setExtents(Vec2 vec2) {
        this.box.extents.set(vec2);
    }

    public void setTransform(Mat22 mat22) {
        this.box.R.set(mat22);
    }

    @Override // org.jbox2d.common.IViewportTransform
    public void setYFlip(boolean z16) {
        this.yFlip = z16;
    }

    @Override // org.jbox2d.common.IViewportTransform
    public void setCenter(float f16, float f17) {
        this.box.center.set(f16, f17);
    }

    @Override // org.jbox2d.common.IViewportTransform
    public void setExtents(float f16, float f17) {
        this.box.extents.set(f16, f17);
    }
}
