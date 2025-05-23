package org.jbox2d.collision;

import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;
import org.jbox2d.pooling.IWorldPool;
import org.jbox2d.pooling.normal.DefaultWorldPool;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AABB {
    public final Vec2 lowerBound;
    public final Vec2 upperBound;

    public AABB() {
        this.lowerBound = new Vec2();
        this.upperBound = new Vec2();
    }

    public static final boolean testOverlap(AABB aabb, AABB aabb2) {
        Vec2 vec2 = aabb2.lowerBound;
        float f16 = vec2.f423649x;
        Vec2 vec22 = aabb.upperBound;
        if (f16 - vec22.f423649x <= 0.0f && vec2.f423650y - vec22.f423650y <= 0.0f) {
            Vec2 vec23 = aabb.lowerBound;
            float f17 = vec23.f423649x;
            Vec2 vec24 = aabb2.upperBound;
            if (f17 - vec24.f423649x <= 0.0f && vec23.f423650y - vec24.f423650y <= 0.0f) {
                return true;
            }
        }
        return false;
    }

    public final void combine(AABB aabb, AABB aabb2) {
        Vec2 vec2 = this.lowerBound;
        Vec2 vec22 = aabb.lowerBound;
        float f16 = vec22.f423649x;
        Vec2 vec23 = aabb2.lowerBound;
        float f17 = vec23.f423649x;
        if (f16 >= f17) {
            f16 = f17;
        }
        vec2.f423649x = f16;
        float f18 = vec22.f423650y;
        float f19 = vec23.f423650y;
        if (f18 >= f19) {
            f18 = f19;
        }
        vec2.f423650y = f18;
        Vec2 vec24 = this.upperBound;
        Vec2 vec25 = aabb.upperBound;
        float f26 = vec25.f423649x;
        Vec2 vec26 = aabb2.upperBound;
        float f27 = vec26.f423649x;
        if (f26 <= f27) {
            f26 = f27;
        }
        vec24.f423649x = f26;
        float f28 = vec25.f423650y;
        float f29 = vec26.f423650y;
        if (f28 <= f29) {
            f28 = f29;
        }
        vec24.f423650y = f28;
    }

    public final boolean contains(AABB aabb) {
        Vec2 vec2 = this.lowerBound;
        float f16 = vec2.f423649x;
        Vec2 vec22 = aabb.lowerBound;
        if (f16 > vec22.f423649x && vec2.f423650y > vec22.f423650y) {
            Vec2 vec23 = aabb.upperBound;
            float f17 = vec23.f423649x;
            Vec2 vec24 = this.upperBound;
            if (f17 > vec24.f423649x && vec23.f423650y > vec24.f423650y) {
                return true;
            }
        }
        return false;
    }

    public final Vec2 getCenter() {
        Vec2 vec2 = new Vec2(this.lowerBound);
        vec2.addLocal(this.upperBound);
        vec2.mulLocal(0.5f);
        return vec2;
    }

    public final void getCenterToOut(Vec2 vec2) {
        Vec2 vec22 = this.lowerBound;
        float f16 = vec22.f423649x;
        Vec2 vec23 = this.upperBound;
        vec2.f423649x = (f16 + vec23.f423649x) * 0.5f;
        vec2.f423650y = (vec22.f423650y + vec23.f423650y) * 0.5f;
    }

    public final Vec2 getExtents() {
        Vec2 vec2 = new Vec2(this.upperBound);
        vec2.subLocal(this.lowerBound);
        vec2.mulLocal(0.5f);
        return vec2;
    }

    public final void getExtentsToOut(Vec2 vec2) {
        Vec2 vec22 = this.upperBound;
        float f16 = vec22.f423649x;
        Vec2 vec23 = this.lowerBound;
        vec2.f423649x = (f16 - vec23.f423649x) * 0.5f;
        vec2.f423650y = (vec22.f423650y - vec23.f423650y) * 0.5f;
    }

    public final float getPerimeter() {
        Vec2 vec2 = this.upperBound;
        float f16 = vec2.f423649x;
        Vec2 vec22 = this.lowerBound;
        return (((f16 - vec22.f423649x) + vec2.f423650y) - vec22.f423650y) * 2.0f;
    }

    public final void getVertices(Vec2[] vec2Arr) {
        vec2Arr[0].set(this.lowerBound);
        vec2Arr[1].set(this.lowerBound);
        Vec2 vec2 = vec2Arr[1];
        float f16 = vec2.f423649x;
        Vec2 vec22 = this.upperBound;
        vec2.f423649x = f16 + (vec22.f423649x - this.lowerBound.f423649x);
        vec2Arr[2].set(vec22);
        vec2Arr[3].set(this.upperBound);
        vec2Arr[3].f423649x -= this.upperBound.f423649x - this.lowerBound.f423649x;
    }

    public final boolean isValid() {
        Vec2 vec2 = this.upperBound;
        float f16 = vec2.f423649x;
        Vec2 vec22 = this.lowerBound;
        if (f16 - vec22.f423649x < 0.0f || vec2.f423650y - vec22.f423650y < 0.0f || !vec22.isValid() || !this.upperBound.isValid()) {
            return false;
        }
        return true;
    }

    public final boolean raycast(RayCastOutput rayCastOutput, RayCastInput rayCastInput) {
        return raycast(rayCastOutput, rayCastInput, new DefaultWorldPool(4, 4));
    }

    public final void set(AABB aabb) {
        Vec2 vec2 = aabb.lowerBound;
        Vec2 vec22 = this.lowerBound;
        vec22.f423649x = vec2.f423649x;
        vec22.f423650y = vec2.f423650y;
        Vec2 vec23 = aabb.upperBound;
        Vec2 vec24 = this.upperBound;
        vec24.f423649x = vec23.f423649x;
        vec24.f423650y = vec23.f423650y;
    }

    public final String toString() {
        return "AABB[" + this.lowerBound + " . " + this.upperBound + "]";
    }

    public final boolean raycast(RayCastOutput rayCastOutput, RayCastInput rayCastInput, IWorldPool iWorldPool) {
        float f16;
        float f17;
        Vec2 popVec2 = iWorldPool.popVec2();
        Vec2 popVec22 = iWorldPool.popVec2();
        Vec2 popVec23 = iWorldPool.popVec2();
        Vec2 popVec24 = iWorldPool.popVec2();
        popVec2.set(rayCastInput.f423628p1);
        popVec22.set(rayCastInput.f423629p2).subLocal(rayCastInput.f423628p1);
        Vec2.absToOut(popVec22, popVec23);
        float f18 = -3.4028235E38f;
        float f19 = Float.MAX_VALUE;
        if (popVec23.f423649x < 1.1920929E-7f) {
            float f26 = popVec2.f423649x;
            if (f26 < this.lowerBound.f423649x || this.upperBound.f423649x < f26) {
                iWorldPool.pushVec2(4);
                return false;
            }
        } else {
            float f27 = 1.0f / popVec22.f423649x;
            float f28 = this.lowerBound.f423649x;
            float f29 = popVec2.f423649x;
            float f36 = (f28 - f29) * f27;
            float f37 = (this.upperBound.f423649x - f29) * f27;
            if (f36 > f37) {
                f16 = 1.0f;
                f36 = f37;
                f37 = f36;
            } else {
                f16 = -1.0f;
            }
            if (f36 > -3.4028235E38f) {
                popVec24.setZero();
                popVec24.f423649x = f16;
                f18 = f36;
            }
            f19 = MathUtils.min(Float.MAX_VALUE, f37);
            if (f18 > f19) {
                iWorldPool.pushVec2(4);
                return false;
            }
        }
        if (popVec23.f423650y < 1.1920929E-7f) {
            float f38 = popVec2.f423650y;
            if (f38 < this.lowerBound.f423650y || this.upperBound.f423650y < f38) {
                iWorldPool.pushVec2(4);
                return false;
            }
        } else {
            float f39 = 1.0f / popVec22.f423650y;
            float f46 = this.lowerBound.f423650y;
            float f47 = popVec2.f423650y;
            float f48 = (f46 - f47) * f39;
            float f49 = (this.upperBound.f423650y - f47) * f39;
            if (f48 > f49) {
                f17 = 1.0f;
                f49 = f48;
                f48 = f49;
            } else {
                f17 = -1.0f;
            }
            if (f48 > f18) {
                popVec24.setZero();
                popVec24.f423650y = f17;
                f18 = f48;
            }
            if (f18 > MathUtils.min(f19, f49)) {
                iWorldPool.pushVec2(4);
                return false;
            }
        }
        if (f18 >= 0.0f && rayCastInput.maxFraction >= f18) {
            rayCastOutput.fraction = f18;
            Vec2 vec2 = rayCastOutput.normal;
            vec2.f423649x = popVec24.f423649x;
            vec2.f423650y = popVec24.f423650y;
            iWorldPool.pushVec2(4);
            return true;
        }
        iWorldPool.pushVec2(4);
        return false;
    }

    public AABB(AABB aabb) {
        this(aabb.lowerBound, aabb.upperBound);
    }

    public AABB(Vec2 vec2, Vec2 vec22) {
        this.lowerBound = vec2.clone();
        this.upperBound = vec22.clone();
    }

    public final void combine(AABB aabb) {
        Vec2 vec2 = this.lowerBound;
        float f16 = vec2.f423649x;
        Vec2 vec22 = aabb.lowerBound;
        float f17 = vec22.f423649x;
        if (f16 >= f17) {
            f16 = f17;
        }
        vec2.f423649x = f16;
        float f18 = vec2.f423650y;
        float f19 = vec22.f423650y;
        if (f18 >= f19) {
            f18 = f19;
        }
        vec2.f423650y = f18;
        Vec2 vec23 = this.upperBound;
        float f26 = vec23.f423649x;
        Vec2 vec24 = aabb.upperBound;
        float f27 = vec24.f423649x;
        if (f26 <= f27) {
            f26 = f27;
        }
        vec23.f423649x = f26;
        float f28 = vec23.f423650y;
        float f29 = vec24.f423650y;
        if (f28 <= f29) {
            f28 = f29;
        }
        vec23.f423650y = f28;
    }
}
