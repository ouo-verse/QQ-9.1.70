package com.tencent.ams.fusion.widget.animatorplayer.physics;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.SystemClock;
import com.tencent.ams.fusion.tbox.collision.shapes.PolygonShape;
import com.tencent.ams.fusion.tbox.common.Vec2;
import com.tencent.ams.fusion.tbox.dynamics.Body;
import com.tencent.ams.fusion.tbox.dynamics.BodyDef;
import com.tencent.ams.fusion.tbox.dynamics.BodyType;
import com.tencent.ams.fusion.tbox.dynamics.FixtureDef;
import com.tencent.ams.fusion.tbox.dynamics.World;
import com.tencent.ams.fusion.widget.animatorplayer.AnimationItem;
import com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayInfo;
import com.tencent.ams.fusion.widget.animatorplayer.physics.PhysicsEngine;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class TBox2dPhysicsEngine implements PhysicsEngine {
    static IPatchRedirector $redirector_ = null;
    private static final float DEFAULT_DENSITY = 1.0f;
    private static final int POSITION_ITERATIONS = 10;
    private static final float RATE = 100.0f;
    private static final String TAG = "PhysicsEngine";
    private static final int VELOCITY_ITERATIONS = 10;
    private CopyOnWriteArrayList<AnimationItem> animationItems;
    private volatile boolean isAllBodySleepCalled;
    private long lastGenTime;
    private volatile long mAnimationBaseTime;
    private volatile int mAnimationItemCount;
    private PhysicsEngineStateListener mEngineStateListener;
    private boolean mFixedRotation;
    private float mFriction;
    private float mGravity;
    private float mGravityAngle;
    private float mRestitution;
    private float mStepTimeGap;
    private World mWorld;

    /* loaded from: classes3.dex */
    public static class AnimationBodyItemIterator implements PhysicsEngine.AnimationItemIterator {
        static IPatchRedirector $redirector_;
        private BodyIterator mBodyIterator;
        private AnimationItem mCurrentItem;

        public AnimationBodyItemIterator(Body body) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) body);
            } else {
                this.mBodyIterator = new BodyIterator(body);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (this.mCurrentItem != null) {
                return true;
            }
            while (true) {
                if (!this.mBodyIterator.hasNext()) {
                    break;
                }
                Body next = this.mBodyIterator.next();
                if (next.m_userData instanceof AnimationItem) {
                    AnimationItem animationItem = (AnimationItem) next.m_userData;
                    AnimationItem.AnimationBody body = animationItem.getBody();
                    if (next.isActive() && body != null && !body.isBorder()) {
                        this.mCurrentItem = animationItem;
                        break;
                    }
                }
            }
            if (this.mCurrentItem != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.mBodyIterator.remove();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public AnimationItem next() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AnimationItem) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            AnimationItem animationItem = this.mCurrentItem;
            this.mCurrentItem = null;
            return animationItem;
        }
    }

    /* loaded from: classes3.dex */
    private static class BodyIterator implements Iterator<Body> {
        static IPatchRedirector $redirector_;
        private Body mCurrentBody;

        public BodyIterator(Body body) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) body);
            } else {
                this.mCurrentBody = body;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (this.mCurrentBody != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.mCurrentBody = null;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Body next() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Body) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            Body body = this.mCurrentBody;
            this.mCurrentBody = body.m_next;
            return body;
        }
    }

    public TBox2dPhysicsEngine(AnimationPlayInfo animationPlayInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) animationPlayInfo);
            return;
        }
        this.mFixedRotation = true;
        this.lastGenTime = 0L;
        this.isAllBodySleepCalled = false;
        this.mAnimationItemCount = Integer.MIN_VALUE;
        initEngine(animationPlayInfo);
    }

    private void createEdge(float f16, float f17, float f18) {
        createPolygon(null, f16, 0.0f, 0.0f, f18, true);
        createPolygon(null, f17, 0.0f, 0.0f, f18, true);
        createPolygon(null, f16, f18, f17 - f16, 0.0f, true);
    }

    private void createPolygon(Bitmap bitmap, float f16, float f17, float f18, float f19, boolean z16) {
        PolygonShape polygonShape = new PolygonShape();
        float f26 = f18 / 2.0f;
        float f27 = f19 / 2.0f;
        polygonShape.setAsBox(f26 / 100.0f, f27 / 100.0f);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.friction = this.mFriction;
        fixtureDef.density = 1.0f;
        fixtureDef.shape = polygonShape;
        fixtureDef.restitution = this.mRestitution;
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set((f26 + f16) / 100.0f, (f27 + f17) / 100.0f);
        bodyDef.type = z16 ? BodyType.STATIC : BodyType.DYNAMIC;
        AnimationItem.AnimationBody animationBody = new AnimationItem.AnimationBody();
        animationBody.setBorder(z16);
        animationBody.setElementX(f16);
        animationBody.setElementY(f17);
        AnimationItem createImageItem = AnimationItem.createImageItem(null, (int) f18, (int) f19);
        createImageItem.setBody(animationBody);
        Body createBody = this.mWorld.createBody(bodyDef);
        createBody.m_userData = createImageItem;
        createBody.createFixture(fixtureDef);
    }

    private float getCross(PointF pointF, PointF pointF2, PointF pointF3) {
        float f16 = pointF2.x;
        float f17 = pointF.x;
        float f18 = pointF3.y;
        float f19 = pointF.y;
        return ((f16 - f17) * (f18 - f19)) - ((pointF3.x - f17) * (pointF2.y - f19));
    }

    private void initEngine(AnimationPlayInfo animationPlayInfo) {
        if (animationPlayInfo == null) {
            return;
        }
        this.mRestitution = animationPlayInfo.getRestitution();
        this.mFriction = animationPlayInfo.getFriction();
        this.mFixedRotation = animationPlayInfo.getFixedRotation();
        this.mGravity = animationPlayInfo.getGravity();
        this.mGravityAngle = animationPlayInfo.getGravityAngle();
        this.mWorld = new World(new Vec2(this.mGravity * ((float) Math.cos(this.mGravityAngle)), this.mGravity * ((float) Math.sin(this.mGravityAngle))), true);
        if (!Utils.isEmpty(animationPlayInfo.getAnimationItems())) {
            int i3 = 0;
            for (AnimationItem animationItem : animationPlayInfo.getAnimationItems()) {
                if (animationItem != null && animationItem.getElementType() == 1) {
                    i3++;
                    createPolygon(animationItem);
                }
            }
            this.mAnimationItemCount = i3;
        }
        if (animationPlayInfo.isStackable()) {
            Logger.d(TAG, "init stackable area");
            createEdge(animationPlayInfo.getPileUpAreaLeft(), animationPlayInfo.getPileUpAreaRight(), animationPlayInfo.getPileUpAreaY());
        }
    }

    private boolean isClickInBoxArea(AnimationItem animationItem, float f16, float f17) {
        AnimationItem.AnimationBody animationBody;
        if (animationItem != null) {
            animationBody = animationItem.getBody();
        } else {
            animationBody = null;
        }
        if (animationBody == null) {
            return false;
        }
        float elementX = animationBody.getElementX();
        float elementY = animationBody.getElementY();
        float elementWidth = animationItem.getElementWidth() * animationBody.getScale();
        float elementHeight = animationItem.getElementHeight() * animationBody.getScale();
        RectF rectF = new RectF();
        rectF.left = elementX;
        rectF.top = elementY;
        rectF.right = elementWidth + elementX;
        rectF.bottom = elementY + elementHeight;
        float f18 = elementHeight / 2.0f;
        return Utils.isPointInArea(f16, f17, rectF, (float) Math.toDegrees(animationBody.getAngle()), elementX + f18, elementY + f18);
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.physics.PhysicsEngine
    public void dynamicLogic() {
        AnimationItem animationItem;
        AnimationItem.AnimationBody body;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        World world = this.mWorld;
        if (world == null) {
            Logger.d(TAG, "null world");
            return;
        }
        world.step(this.mStepTimeGap, 10, 10);
        BodyIterator bodyIterator = new BodyIterator(this.mWorld.getBodyList());
        int i3 = 0;
        while (bodyIterator.hasNext()) {
            Body next = bodyIterator.next();
            if ((next.m_userData instanceof AnimationItem) && (body = (animationItem = (AnimationItem) next.m_userData).getBody()) != null && !body.isBorder()) {
                if (!next.isActive()) {
                    if (body.getAnimationTime() < SystemClock.uptimeMillis() - this.mAnimationBaseTime) {
                        next.setActive(true);
                    }
                }
                if (next.isActive()) {
                    Vec2 position = next.getPosition();
                    if (position != null) {
                        body.setElementX((position.x * 100.0f) - ((animationItem.getElementWidth() * body.getScale()) / 2.0f));
                        body.setElementY((position.y * 100.0f) - ((animationItem.getElementHeight() * body.getScale()) / 2.0f));
                    }
                    body.setAngle(next.getAngle());
                }
                if (!next.isAwake()) {
                    i3++;
                    if (this.mAnimationItemCount > 0 && i3 == this.mAnimationItemCount && this.mEngineStateListener != null && !this.isAllBodySleepCalled) {
                        this.isAllBodySleepCalled = true;
                        this.mEngineStateListener.onAllBodySleep();
                    }
                }
            }
        }
        Logger.d(TAG, "sleep body count:" + i3);
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.physics.PhysicsEngine
    public long getAnimationBaseTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Long) iPatchRedirector.redirect((short) 18, (Object) this)).longValue();
        }
        return this.mAnimationBaseTime;
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.physics.PhysicsEngine
    public AnimationItem getClickBoxItem(float f16, float f17) {
        AnimationItem animationItem;
        AnimationItem.AnimationBody body;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AnimationItem) iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17));
        }
        World world = this.mWorld;
        if (world == null) {
            Logger.d(TAG, "null world or event");
            return null;
        }
        BodyIterator bodyIterator = new BodyIterator(world.getBodyList());
        while (bodyIterator.hasNext()) {
            Body next = bodyIterator.next();
            if ((next.m_userData instanceof AnimationItem) && (body = (animationItem = (AnimationItem) next.m_userData).getBody()) != null && !body.isBorder() && next.isActive() && isClickInBoxArea(animationItem, f16, f17)) {
                return animationItem;
            }
        }
        return null;
    }

    public float getFriction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        return this.mFriction;
    }

    public float getGravity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.mGravity;
    }

    public float getGravityAngle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this)).floatValue();
        }
        return this.mGravityAngle;
    }

    public float getRestitution() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, (Object) this)).floatValue();
        }
        return this.mRestitution;
    }

    public float getStepTimeGap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Float) iPatchRedirector.redirect((short) 17, (Object) this)).floatValue();
        }
        return this.mStepTimeGap;
    }

    public boolean isFixedRotation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.mFixedRotation;
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.physics.PhysicsEngine
    public void setAnimationBaseTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, j3);
        } else {
            this.mAnimationBaseTime = j3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.physics.PhysicsEngine
    public void setEngineStateListener(PhysicsEngineStateListener physicsEngineStateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) physicsEngineStateListener);
        } else {
            this.mEngineStateListener = physicsEngineStateListener;
        }
    }

    public void setFixedRotation(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.mFixedRotation = z16;
        }
    }

    public void setFriction(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else {
            this.mFriction = f16;
        }
    }

    public void setGravity(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.mGravity = f16;
        }
    }

    public void setGravityAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            this.mGravityAngle = f16;
        }
    }

    public void setRestitution(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
        } else {
            this.mRestitution = f16;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.physics.PhysicsEngine
    public void setStepTimeGap(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16));
        } else {
            this.mStepTimeGap = f16;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.physics.PhysicsEngine
    public AnimationBodyItemIterator getDrawItemIterator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AnimationBodyItemIterator) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        World world = this.mWorld;
        if (world == null) {
            Logger.d(TAG, "null world");
            return null;
        }
        return new AnimationBodyItemIterator(world.getBodyList());
    }

    private void createPolygon(AnimationItem animationItem) {
        AnimationItem.AnimationBody body = animationItem != null ? animationItem.getBody() : null;
        if (body == null) {
            return;
        }
        float elementWidth = animationItem.getElementWidth() * body.getScale();
        float elementHeight = animationItem.getElementHeight() * body.getScale();
        float elementX = body.getElementX();
        float elementY = body.getElementY();
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox((elementWidth / 2.0f) / 100.0f, (elementHeight / 2.0f) / 100.0f);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.friction = this.mFriction;
        fixtureDef.density = 1.0f;
        fixtureDef.shape = polygonShape;
        fixtureDef.restitution = this.mRestitution;
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(elementX / 100.0f, elementY / 100.0f);
        bodyDef.type = BodyType.DYNAMIC;
        bodyDef.fixedRotation = this.mFixedRotation;
        Body createBody = this.mWorld.createBody(bodyDef);
        createBody.m_userData = animationItem;
        createBody.setActive(false);
        createBody.createFixture(fixtureDef);
    }
}
