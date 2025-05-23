package com.tencent.ams.fusion.widget.animatorplayer.node;

import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import com.tencent.ams.fusion.widget.animatorplayer.AnimationClickInfo;
import com.tencent.ams.fusion.widget.animatorplayer.AnimationItem;
import com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayInfo;
import com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.IAnimatorView;
import com.tencent.ams.fusion.widget.animatorview.TextureAnimatorView;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.RotationAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ScaleAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.TranslateAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BrokenLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class NodeAnimationPlayer implements AnimationPlayer, Animator.AnimatorListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "NodeAnimationPlayer";
    private AnimationPlayer.AnimationClickListener mAnimationItemClickListener;
    private final List<AnimationItem> mAnimationItems;
    private AnimationPlayer.AnimationPlayListener mAnimationPlayListener;
    private GroupLayer mAnimatorLayer;
    private final IAnimatorView mAnimatorView;
    private AnimationItem mInvalidItem;
    private boolean mIsReadyToPlay;
    private int mPlayError;

    /* loaded from: classes3.dex */
    class AnimatorViewTouchListener implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        AnimatorViewTouchListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NodeAnimationPlayer.this);
            }
        }

        private AnimationItem findAnimationItemByPosition(float f16, float f17) {
            if (NodeAnimationPlayer.this.mAnimatorLayer != null) {
                List<AnimatorLayer> layers = NodeAnimationPlayer.this.mAnimatorLayer.getLayers();
                for (int i3 = 0; i3 < layers.size(); i3++) {
                    AnimatorLayer animatorLayer = layers.get(i3);
                    if (isTouchInLayer(animatorLayer, f16, f17)) {
                        Object tag = animatorLayer.getTag();
                        if (tag instanceof AnimationItem) {
                            AnimationItem animationItem = (AnimationItem) tag;
                            if (animationItem.getElementType() != 3) {
                                animationItem.setElementTrueWidth((int) (animatorLayer.getWidth() * animatorLayer.getScaleX()));
                                animationItem.setElementTrueHeight((int) (animatorLayer.getHeight() * animatorLayer.getScaleY()));
                                return animationItem;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return null;
            }
            return null;
        }

        private boolean isTouchInLayer(AnimatorLayer animatorLayer, float f16, float f17) {
            if (animatorLayer != null) {
                return isLayerContainsPoint(animatorLayer, f16, f17);
            }
            return false;
        }

        public boolean isLayerContainsPoint(AnimatorLayer animatorLayer, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, animatorLayer, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            RectF rectF = new RectF();
            rectF.left = animatorLayer.getX() + ((animatorLayer.getWidth() * (1.0f - animatorLayer.getScaleX())) / 2.0f);
            rectF.top = animatorLayer.getY() + ((animatorLayer.getHeight() * (1.0f - animatorLayer.getScaleY())) / 2.0f);
            rectF.right = rectF.left + (animatorLayer.getWidth() * animatorLayer.getScaleX());
            rectF.bottom = rectF.top + (animatorLayer.getHeight() * animatorLayer.getScaleY());
            return Utils.isPointInArea(f16, f17, rectF, animatorLayer.getRotationDegrees(), animatorLayer.getPx(), animatorLayer.getPy());
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (NodeAnimationPlayer.this.mAnimationItemClickListener != null && NodeAnimationPlayer.this.mAnimatorView.isUserStarted() && motionEvent.getAction() == 0) {
                AnimationItem findAnimationItemByPosition = findAnimationItemByPosition(motionEvent.getX(), motionEvent.getY());
                AnimationClickInfo animationClickInfo = new AnimationClickInfo();
                animationClickInfo.f70534x = motionEvent.getX();
                animationClickInfo.f70535y = motionEvent.getY();
                animationClickInfo.item = findAnimationItemByPosition;
                NodeAnimationPlayer.this.mAnimationItemClickListener.onAnimationClick(animationClickInfo);
                if (animationClickInfo.item != null) {
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    @interface ViewType {
        public static final int SURFACE = 1;
        public static final int TEXTURE = 2;
    }

    public NodeAnimationPlayer(ViewGroup viewGroup) {
        this(viewGroup, 1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewGroup);
    }

    private Animator createAnimatorFromAnimationInfo(AnimationItem animationItem, AnimatorLayer animatorLayer) {
        List<AnimationItem.AnimationNode> nodeList = animationItem.getNodeList();
        AnimationItem.AnimationNode animationNode = null;
        if (nodeList == null || nodeList.size() == 0) {
            return null;
        }
        if (nodeList.size() == 1) {
            return new KeepAnimator(animatorLayer);
        }
        SequentialAnimator sequentialAnimator = new SequentialAnimator(animatorLayer);
        AnimationItem.AnimationNode animationNode2 = nodeList.get(0);
        for (AnimationItem.AnimationNode animationNode3 : nodeList) {
            if (animationNode3 != null) {
                sequentialAnimator.addAnimator(createNodeAnimator(animatorLayer, animationNode2, animationNode, animationNode3));
                animationNode = animationNode3;
            }
        }
        sequentialAnimator.setStartDelay(animationNode2.getDuration());
        return sequentialAnimator;
    }

    private AnimatorLayer createLayerFromAnimationInfo(AnimationItem animationItem) {
        BrokenLayer brokenLayer;
        AnimatorLayer animatorLayer;
        if (animationItem == null) {
            return null;
        }
        if (animationItem.getElementType() == 1) {
            BitmapLayer bitmapLayer = new BitmapLayer(animationItem.getBitmapElement());
            bitmapLayer.setWidth(animationItem.getElementWidth());
            bitmapLayer.setHeight(animationItem.getElementHeight());
            animatorLayer = bitmapLayer;
        } else if (animationItem.getElementType() == 2) {
            TextLayer textLayer = new TextLayer(animationItem.getTextElement(), animationItem.getTextColor(), animationItem.getTextSize());
            textLayer.setTextAlign(Paint.Align.CENTER);
            animatorLayer = textLayer;
        } else if (animationItem.getElementType() == 3) {
            Rect brokenElement = animationItem.getBrokenElement();
            if (animationItem.getBrokenBottomMargin() != Integer.MIN_VALUE) {
                brokenLayer = new BrokenLayer(brokenElement, animationItem.getBrokenBottomMargin());
            } else {
                brokenLayer = new BrokenLayer(brokenElement);
            }
            animatorLayer = brokenLayer;
        } else {
            Logger.w(TAG, "animation type not support: " + animationItem.getElementType());
            return null;
        }
        if (animationItem.getElementType() == 3) {
            animatorLayer.setAnimator(new KeepAnimator(animatorLayer));
        } else {
            animatorLayer.setCenterX(animationItem.getStartCenterPoint().x);
            animatorLayer.setCenterY(animationItem.getStartCenterPoint().y);
            Animator createAnimatorFromAnimationInfo = createAnimatorFromAnimationInfo(animationItem, animatorLayer);
            if (createAnimatorFromAnimationInfo == null) {
                return null;
            }
            animatorLayer.setAnimator(createAnimatorFromAnimationInfo);
        }
        return animatorLayer;
    }

    private Animator createNodeAnimator(AnimatorLayer animatorLayer, AnimationItem.AnimationNode animationNode, AnimationItem.AnimationNode animationNode2, AnimationItem.AnimationNode animationNode3) {
        if (animationNode2 != null && animationNode3 != null) {
            GroupAnimator groupAnimator = new GroupAnimator(animatorLayer, new Animator[0]);
            PointF point = animationNode.getPoint();
            PointF point2 = animationNode2.getPoint();
            PointF point3 = animationNode3.getPoint();
            if (point != null && point2 != null && point3 != null) {
                float f16 = point2.x;
                float f17 = point.x;
                float f18 = f16 - f17;
                float f19 = point3.x - f17;
                float f26 = point2.y;
                float f27 = point.y;
                groupAnimator.addAnimators(new TranslateAnimator(animatorLayer, f18, f19, f26 - f27, point3.y - f27));
            }
            if (animationNode2.getAlpha() != 1.0f || animationNode3.getAlpha() != 1.0f) {
                groupAnimator.addAnimators(new AlphaAnimator(animatorLayer, animationNode2.getAlpha(), animationNode3.getAlpha()));
            }
            if (animationNode2.getScale() != 1.0f || animationNode3.getScale() != 1.0f) {
                groupAnimator.addAnimators(new ScaleAnimator(animatorLayer, animationNode2.getScale(), animationNode3.getScale(), animationNode2.getScale(), animationNode3.getScale()));
            }
            if (animationNode2.getRotate() != 0.0f || animationNode3.getRotate() != 0.0f) {
                RotationAnimator rotationAnimator = new RotationAnimator(animatorLayer);
                rotationAnimator.setRotationDegrees(animationNode2.getRotate(), animationNode3.getRotate());
                groupAnimator.addAnimators(rotationAnimator);
            }
            groupAnimator.setDuration(animationNode3.getDuration());
            if (animationNode3.isNeedBezier() && animationNode3.getBezierC1() != null && animationNode3.getBezierC2() != null) {
                try {
                    groupAnimator.setInterpolator(new PathInterpolator(animationNode3.getBezierC1().x, animationNode3.getBezierC1().y, animationNode3.getBezierC2().x, animationNode3.getBezierC2().y));
                } catch (Throwable unused) {
                    Logger.w(TAG, "set interpolator failed: c1 = " + animationNode3.getBezierC1() + ", c2 = " + animationNode3.getBezierC2());
                }
            }
            return groupAnimator;
        }
        return null;
    }

    private int validAnimationItem(AnimationItem animationItem) {
        if (animationItem.getElementType() == 1) {
            if (animationItem.getBitmapElement() == null) {
                return 102;
            }
            if (animationItem.getElementWidth() <= 0 || animationItem.getElementHeight() <= 0) {
                return 103;
            }
        } else if (animationItem.getElementType() == 2) {
            if (animationItem.getTextElement() == null) {
                return 102;
            }
            if (animationItem.getTextColor() == 0 || animationItem.getTextSize() == 0.0f) {
                return 103;
            }
        } else if (animationItem.getElementType() == 3 && animationItem.getBrokenElement() == null) {
            return 102;
        }
        if (animationItem.getElementType() != 3) {
            if (animationItem.getNodeList() == null || animationItem.getNodeList().size() == 0) {
                return 104;
            }
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void clearAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.mAnimatorView.stopAnimation();
        this.mAnimatorView.clearCanvas();
        this.mAnimatorView.clearLayers();
        this.mAnimatorLayer = null;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
    public void onAnimationFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        AnimationPlayer.AnimationPlayListener animationPlayListener = this.mAnimationPlayListener;
        if (animationPlayListener != null) {
            animationPlayListener.onComplete();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.mAnimatorView.pauseAnimation();
        AnimationPlayer.AnimationPlayListener animationPlayListener = this.mAnimationPlayListener;
        if (animationPlayListener != null) {
            animationPlayListener.onPause();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.mAnimatorView.resumeAnimation();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void setAnimationClickListener(AnimationPlayer.AnimationClickListener animationClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animationClickListener);
        } else {
            this.mAnimationItemClickListener = animationClickListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void setAnimationPlayInfo(AnimationPlayInfo animationPlayInfo) {
        List<AnimationItem> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animationPlayInfo);
            return;
        }
        if (animationPlayInfo != null) {
            list = animationPlayInfo.getAnimationItems();
        } else {
            list = null;
        }
        if (list != null) {
            GroupLayer groupLayer = new GroupLayer(new AnimatorLayer[0]);
            for (AnimationItem animationItem : list) {
                if (animationItem != null) {
                    this.mAnimationItems.add(animationItem);
                    int validAnimationItem = validAnimationItem(animationItem);
                    this.mPlayError = validAnimationItem;
                    if (validAnimationItem != 0) {
                        Logger.w(TAG, "setAnimationItems invalid item: " + animationItem);
                        this.mInvalidItem = animationItem;
                        return;
                    }
                    AnimatorLayer createLayerFromAnimationInfo = createLayerFromAnimationInfo(animationItem);
                    if (createLayerFromAnimationInfo != null) {
                        createLayerFromAnimationInfo.setTag(animationItem);
                        groupLayer.addLayers(createLayerFromAnimationInfo);
                    }
                }
            }
            if (groupLayer.getLayers().size() > 0) {
                this.mAnimatorView.clearLayers();
                this.mAnimatorView.addLayer(groupLayer);
                this.mAnimatorLayer = groupLayer;
                this.mIsReadyToPlay = true;
            }
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void setAnimationPlayListener(AnimationPlayer.AnimationPlayListener animationPlayListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) animationPlayListener);
        } else {
            this.mAnimationPlayListener = animationPlayListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.mIsReadyToPlay) {
            this.mAnimatorView.startAnimation();
            AnimationPlayer.AnimationPlayListener animationPlayListener = this.mAnimationPlayListener;
            if (animationPlayListener != null) {
                animationPlayListener.onStart();
                return;
            }
            return;
        }
        if (this.mAnimationPlayListener != null) {
            List<AnimationItem> list = this.mAnimationItems;
            if (list != null && list.size() != 0) {
                this.mAnimationPlayListener.onError(this.mInvalidItem, this.mPlayError);
            } else {
                this.mAnimationPlayListener.onError(null, 101);
            }
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.mAnimatorView.stopAnimation();
        clearAnimation();
        AnimationPlayer.AnimationPlayListener animationPlayListener = this.mAnimationPlayListener;
        if (animationPlayListener != null) {
            animationPlayListener.onStop();
        }
    }

    public NodeAnimationPlayer(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
            return;
        }
        this.mAnimationItems = new ArrayList();
        if (i3 == 2) {
            this.mAnimatorView = new TextureAnimatorView(viewGroup.getContext());
        } else {
            this.mAnimatorView = new AnimatorView(viewGroup.getContext());
        }
        ((View) this.mAnimatorView).setOnTouchListener(new AnimatorViewTouchListener());
        this.mAnimatorView.setAnimationListener(this);
        viewGroup.addView((View) this.mAnimatorView, new ViewGroup.LayoutParams(-1, -1));
    }
}
