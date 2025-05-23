package com.tencent.ams.fusion.widget.animatorplayer;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.ams.fusion.widget.animatorview.AnimatorConfig;
import com.tencent.ams.fusion.widget.animatorview.AnimatorUtils;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AnimationItem {
    static IPatchRedirector $redirector_ = null;
    public static final int NOT_SET = Integer.MIN_VALUE;
    private static final String TAG = "AnimationItem";
    private Bitmap mBitmapElement;
    private AnimationBody mBody;
    private int mBrokenBottomMargin;
    private Rect mBrokenElement;
    private int mElementHeight;
    private int mElementTrueHeight;
    private int mElementTrueWidth;
    private int mElementType;
    private Object mElementUserData;
    private int mElementWidth;
    private final List<AnimationNode> mNodeList;
    private int mTextColor;
    private String mTextElement;
    private float mTextSize;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class AnimationBody {
        static IPatchRedirector $redirector_;
        private float mAngle;
        private long mAnimationTime;
        private boolean mIsBorder;
        private float mScale;
        private float mX;
        private float mY;

        public AnimationBody() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public float getAngle() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
            }
            return this.mAngle;
        }

        public long getAnimationTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
            }
            return this.mAnimationTime;
        }

        public float getElementX() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
            }
            return this.mX;
        }

        public float getElementY() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
            }
            return this.mY;
        }

        public float getScale() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Float) iPatchRedirector.redirect((short) 12, (Object) this)).floatValue();
            }
            return this.mScale;
        }

        public boolean isBorder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.mIsBorder;
        }

        public void setAngle(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            } else {
                this.mAngle = f16;
            }
        }

        public void setAnimationTime(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, j3);
            } else {
                this.mAnimationTime = j3;
            }
        }

        public void setBorder(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
            } else {
                this.mIsBorder = z16;
            }
        }

        public void setElementX(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            } else {
                this.mX = f16;
            }
        }

        public void setElementY(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
            } else {
                this.mY = f16;
            }
        }

        public void setScale(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
            } else {
                this.mScale = f16;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "{\"mIsBorder\":" + this.mIsBorder + ",\"mAngle\":" + this.mAngle + ",\"mX\":" + this.mX + ",\"mY\":" + this.mY + ",\"mScale\":" + this.mScale + '}';
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AnimationElementType {
        public static final int BROKEN = 3;
        public static final int IMAGE = 1;
        public static final int TEXT = 2;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class AnimationNode {
        static IPatchRedirector $redirector_;
        private float mAlpha;
        private PointF mBezierC1;
        private PointF mBezierC2;
        private int mDuration;
        private boolean mNeedBezier;
        private PointF mPoint;
        private float mRotation;
        private float mScale;

        public AnimationNode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.mDuration = Integer.MIN_VALUE;
            this.mScale = -2.14748365E9f;
            this.mAlpha = -2.14748365E9f;
            this.mRotation = -2.14748365E9f;
        }

        public float getAlpha() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
            }
            return this.mAlpha;
        }

        public PointF getBezierC1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (PointF) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.mBezierC1;
        }

        public PointF getBezierC2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (PointF) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.mBezierC2;
        }

        public int getDuration() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.mDuration;
        }

        public PointF getPoint() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PointF) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.mPoint;
        }

        public float getRotate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
            }
            return this.mRotation;
        }

        public float getScale() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
            }
            return this.mScale;
        }

        public boolean isNeedBezier() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.mNeedBezier;
        }

        public void setAlpha(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
            } else {
                this.mAlpha = f16;
            }
        }

        public void setBezierC1(PointF pointF) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, (Object) pointF);
            } else {
                this.mBezierC1 = pointF;
            }
        }

        public void setBezierC2(PointF pointF) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, (Object) pointF);
            } else {
                this.mBezierC2 = pointF;
            }
        }

        public void setDuration(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, i3);
            } else {
                this.mDuration = i3;
            }
        }

        public void setNeedBezier(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, z16);
            } else {
                this.mNeedBezier = z16;
            }
        }

        public void setPoint(PointF pointF) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) pointF);
            } else {
                this.mPoint = pointF;
            }
        }

        public void setRotation(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
            } else {
                this.mRotation = f16;
            }
        }

        public void setScale(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
            } else {
                this.mScale = f16;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (String) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder("{");
            sb5.append("\"mDuration\":");
            sb5.append(this.mDuration);
            if (this.mPoint != null) {
                sb5.append(",\"mPoint_x\":");
                sb5.append(this.mPoint.x);
                sb5.append(",\"mPoint_y\":");
                sb5.append(this.mPoint.x);
            }
            sb5.append(",\"mScale\":");
            sb5.append(this.mScale);
            sb5.append(",\"mAlpha\":");
            sb5.append(this.mAlpha);
            sb5.append(",\"mRotation\":");
            sb5.append(this.mRotation);
            sb5.append(",\"mNeedBezier\":");
            sb5.append(this.mNeedBezier);
            if (this.mBezierC1 != null) {
                sb5.append(",\"mBezierC1_x\":");
                sb5.append(this.mBezierC1.x);
                sb5.append(",\"mBezierC1_y\":");
                sb5.append(this.mBezierC1.y);
            }
            if (this.mBezierC2 != null) {
                sb5.append(",\"mBezierC2_x\":");
                sb5.append(this.mBezierC2.x);
                sb5.append(",\"mBezierC2_y\":");
                sb5.append(this.mBezierC2.y);
            }
            sb5.append('}');
            return sb5.toString();
        }
    }

    AnimationItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mBrokenBottomMargin = Integer.MIN_VALUE;
            this.mNodeList = new ArrayList();
        }
    }

    public static AnimationItem createBrokenItem(Rect rect) {
        AnimationItem animationItem = new AnimationItem();
        animationItem.mBrokenElement = rect;
        animationItem.mElementType = 3;
        return animationItem;
    }

    public static AnimationItem createImageItem(Bitmap bitmap, int i3, int i16) {
        AnimationItem animationItem = new AnimationItem();
        animationItem.mBitmapElement = Utils.scaleBitmapSafe(bitmap, i3, i16);
        if (AnimatorConfig.isGrayModeOn()) {
            animationItem.mBitmapElement = AnimatorUtils.convertGrayBitmap(animationItem.mBitmapElement);
        }
        animationItem.mElementWidth = i3;
        animationItem.mElementHeight = i16;
        animationItem.mElementType = 1;
        return animationItem;
    }

    public static AnimationItem createTextItem(String str, int i3, float f16) {
        AnimationItem animationItem = new AnimationItem();
        animationItem.mTextElement = str;
        if (AnimatorConfig.isGrayModeOn()) {
            i3 = AnimatorUtils.convertGrayColor(i3);
        }
        animationItem.mTextColor = i3;
        animationItem.mTextSize = f16;
        animationItem.mElementType = 2;
        return animationItem;
    }

    public boolean addNode(AnimationNode animationNode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) animationNode)).booleanValue();
        }
        if (animationNode == null) {
            Logger.w(TAG, "can't add a null node");
            return false;
        }
        if (animationNode.mDuration == Integer.MIN_VALUE) {
            Logger.w(TAG, "can't add a node: not set duration");
            return false;
        }
        if (animationNode.mPoint == null) {
            Logger.w(TAG, "can't add a node: not set center point");
            return false;
        }
        if (animationNode.mScale == -2.14748365E9f || animationNode.mAlpha == -2.14748365E9f || animationNode.mRotation == -2.14748365E9f) {
            return false;
        }
        if (animationNode.mNeedBezier && (animationNode.mBezierC1 == null || animationNode.mBezierC2 == null)) {
            return false;
        }
        this.mNodeList.add(animationNode);
        return true;
    }

    public Bitmap getBitmapElement() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mBitmapElement;
    }

    public AnimationBody getBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (AnimationBody) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.mBody;
    }

    public int getBrokenBottomMargin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mBrokenBottomMargin;
    }

    public Rect getBrokenElement() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Rect) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mBrokenElement;
    }

    public int getElementHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mElementHeight;
    }

    public int getElementTrueHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        int i3 = this.mElementTrueHeight;
        if (i3 == 0) {
            return this.mElementHeight;
        }
        return i3;
    }

    public int getElementTrueWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        int i3 = this.mElementTrueWidth;
        if (i3 == 0) {
            return this.mElementWidth;
        }
        return i3;
    }

    public int getElementType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mElementType;
    }

    public Object getElementUserData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mElementUserData;
    }

    public int getElementWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.mElementWidth;
    }

    public List<AnimationNode> getNodeList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mNodeList;
    }

    public PointF getStartCenterPoint() {
        PointF pointF;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (PointF) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (this.mNodeList.size() > 0 && (pointF = this.mNodeList.get(0).mPoint) != null) {
            return pointF;
        }
        return new PointF(this.mElementWidth / 2.0f, this.mElementHeight / 2.0f);
    }

    public int getTextColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mTextColor;
    }

    public String getTextElement() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mTextElement;
    }

    public float getTextSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        return this.mTextSize;
    }

    public void setBody(AnimationBody animationBody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) animationBody);
        } else {
            this.mBody = animationBody;
        }
    }

    public void setElementTrueHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.mElementTrueHeight = i3;
        }
    }

    public void setElementTrueWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.mElementTrueWidth = i3;
        }
    }

    public void setElementUserData(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, obj);
        } else {
            this.mElementUserData = obj;
        }
    }

    public void setNodeList(List<AnimationNode> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) list);
        } else if (list != null) {
            Iterator<AnimationNode> it = list.iterator();
            while (it.hasNext() && addNode(it.next())) {
            }
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return "{\"mElementWidth\":" + this.mElementWidth + ",\"mElementHeight\":" + this.mElementHeight + ",\"mTextElement\":\"" + this.mTextElement + "\",\"mTextColor\":" + this.mTextColor + ",\"mTextSize\":" + this.mTextSize + ",\"mElementType\":" + this.mElementType + ",\"mNodeList\":" + this.mNodeList + ",\"mBody\":" + this.mBody + ",\"mElementTrueWidth\":" + this.mElementTrueWidth + ",\"mElementTrueHeight\":" + this.mElementTrueHeight + '}';
    }

    public static AnimationItem createBrokenItem(Rect rect, int i3) {
        AnimationItem animationItem = new AnimationItem();
        animationItem.mBrokenElement = rect;
        animationItem.mElementType = 3;
        animationItem.mBrokenBottomMargin = i3;
        return animationItem;
    }
}
