package com.tencent.ams.fusion.widget.animatorplayer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: classes3.dex */
public class AnimationPlayInfo {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_FPS = 60;
    private static final float DEFAULT_FRACTION = 0.5f;
    private static final float DEFAULT_GRAVITY = 10.0f;
    private static final float DEFAULT_GRAVITY_ANGLE = 1.5707964f;
    private static final float DEFAULT_RESTITUTION = 0.5f;
    private List<AnimationItem> mAnimationItem;
    private int mAnimationType;
    private int mFPS;
    private boolean mFixedRotation;
    private float mFriction;
    private float mGravity;
    private float mGravityAngle;
    private boolean mIsStackable;
    private int mPileUpAreaLeft;
    private int mPileUpAreaRight;
    private int mPileUpAreaY;
    private float mRestitution;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AnimationType {
        public static final int NODE = 1;
        public static final int PHYSICS = 2;
        public static final int UNKNOWN = 0;
    }

    public AnimationPlayInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mAnimationType = 0;
        this.mGravity = 10.0f;
        this.mGravityAngle = 1.5707964f;
        this.mFriction = 0.5f;
        this.mRestitution = 0.5f;
        this.mFPS = 60;
        this.mFixedRotation = false;
        this.mIsStackable = true;
    }

    public List<AnimationItem> getAnimationItems() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mAnimationItem;
    }

    public int getAnimationType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mAnimationType;
    }

    public int getFPS() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return this.mFPS;
    }

    public boolean getFixedRotation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.mFixedRotation;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return this.mGravity;
    }

    public float getGravityAngle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.mGravityAngle;
    }

    public int getPileUpAreaLeft() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.mPileUpAreaLeft;
    }

    public int getPileUpAreaRight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.mPileUpAreaRight;
    }

    public int getPileUpAreaY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.mPileUpAreaY;
    }

    public float getRestitution() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Float) iPatchRedirector.redirect((short) 14, (Object) this)).floatValue();
        }
        return this.mRestitution;
    }

    public boolean isStackable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.mIsStackable;
    }

    public void setAnimationItems(List<AnimationItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        } else {
            this.mAnimationItem = list;
        }
    }

    public void setAnimationType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.mAnimationType = i3;
        }
    }

    public void setFPS(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.mFPS = i3;
        }
    }

    public void setFixedRotation(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            this.mGravity = f16;
        }
    }

    public void setGravityAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        } else {
            this.mGravityAngle = f16;
        }
    }

    public void setPileUpAreaLeft(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.mPileUpAreaLeft = i3;
        }
    }

    public void setPileUpAreaRight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.mPileUpAreaRight = i3;
        }
    }

    public void setPileUpAreaY(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.mPileUpAreaY = i3;
        }
    }

    public void setRestitution(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
        } else {
            this.mRestitution = f16;
        }
    }

    public void setStackable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        } else {
            this.mIsStackable = z16;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return "{\"mAnimationItem\":" + this.mAnimationItem + ",\"mGravity\":" + this.mGravity + ",\"mGravityAngle\":" + this.mGravityAngle + ",\"mFriction\":" + this.mFriction + ",\"mFixedRotation\":" + this.mFixedRotation + ",\"mRestitution\":" + this.mRestitution + ",\"mPileUpAreaLeft\":" + this.mPileUpAreaLeft + ",\"mPileUpAreaRight\":" + this.mPileUpAreaRight + ",\"mPileUpAreaY\":" + this.mPileUpAreaY + ",\"mFPS\":" + this.mFPS + '}';
    }
}
