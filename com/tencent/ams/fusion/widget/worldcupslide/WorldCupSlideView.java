package com.tencent.ams.fusion.widget.worldcupslide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.fusion.widget.worldcupslide.MainIconLayerWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class WorldCupSlideView extends AnimatorView {
    static IPatchRedirector $redirector_ = null;
    protected static final int ALPHA_ANIMATOR_DURATION = 400;
    private static final String ARROW_ICON_BASE64 = "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAD+SURBVHgB7ZThDYJADIVvBEdgBEZwBEdwA0fQDWAD3MARGMERbgRHeF4jiQbpYZGD07wv6R/SvpbwHs4RQgghhBDydwA4hLrhwdH9EuHgCu80oTYuZ8KBRagWOl56XI6Ew8ruwDGkZ+dyouf3/rFeeZE8coFhvwttqE1XtdLTYK1cIO73eqD/pPR6LJ0L6H4XG+0jc1tlTp4tkwvE/V5+MF9grVxgxO8GnWVzAaPfDbrpc4GJfjfop8sFvvS7Yc/8uZBBRbBFgn834rmonBVFaLLfDXu1XBQWHRG6vgzP4nfD7n4uvPmr4/nnuWBGvxv3n9faTwghhBBCCCHJuQMGe1B5gbeoUAAAAABJRU5ErkJggg==";
    public static final int INTERACT_FAIL_NOT_IN_HOTAREA = -1;
    public static final int INTERACT_FAIL_NOT_MEET_CONDITIONS = -2;
    public static final int INTERACT_FAIL_OVER_TIME = -3;
    protected static final int MAIN_ICON_FLY_AWAY_ANIMATOR_DURATION = 500;
    protected static final int MAIN_ICON_GO_BACK_ANIMATOR_DURATION = 300;
    protected static final int SIZE_CHANGE_ANIMATOR_DURATION = 200;
    public static final int SURFACEVIEW_RENDER_EXCEPTION = -1;
    public static final int SURFACEVIEW_TOUCH_EXCEPTION = -2;
    protected static final String TAG = "WorldCupSlideAnimatorView";
    protected static final int UP_DOWN_SHAKE_ANIMATOR_DURATION = 600;
    private WaveBgAnimatorLayer mBgWaveLayer;
    private CallBack mCallBack;
    private Bitmap mGuideIcon;
    private float mGuideIconHeight;
    private float mGuideIconWidth;
    private GuideUILayerWrapper mGuideUILayerWrapper;
    private RectF mHotAreaRect;
    private boolean mIgnoreTouchEvent;
    private List<InteractListener> mInteractListeners;
    private volatile boolean mIsStop;
    private Bitmap mMainIcon;
    private float mMainIconHeight;
    private MainIconLayerWrapper mMainIconLayerWrapper;
    private float mMainIconWidth;
    private float mSlideThreshold;
    private String mSubTitleText;
    private float mSubTitleTextSize;
    private String mTitleText;
    private float mTitleTextSize;
    private float mTouchStartY;
    private GroupLayer mViewGroupLayer;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface CallBack {
        void onAnimationFinish();

        void onError(int i3);

        void onInteractFail(int i3, float f16, float f17);

        void onInteractStart(float f16, float f17);

        void onInteractSuccess(float f16, float f17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface InteractListener {
        void onInteractFail();

        void onInteractSuccess();

        void onTouch(MotionEvent motionEvent);

        void restart();
    }

    public WorldCupSlideView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mInteractListeners = new ArrayList();
        this.mIgnoreTouchEvent = false;
        float relativeSize = Utils.getRelativeSize(context, 240);
        this.mMainIconWidth = relativeSize;
        this.mMainIconHeight = relativeSize;
        float relativeSize2 = Utils.getRelativeSize(context, 48);
        this.mGuideIconWidth = relativeSize2;
        this.mGuideIconHeight = relativeSize2;
        this.mTitleTextSize = Utils.getRelativeSize(context, 36);
        this.mSubTitleTextSize = Utils.getRelativeSize(context, 28);
        this.mGuideIcon = Utils.bitmapFromBase64StringSafe(ARROW_ICON_BASE64, (int) this.mGuideIconWidth, (int) this.mGuideIconHeight);
        float relativeSize3 = Utils.getRelativeSize(context, 118);
        WaveBgAnimatorLayer waveBgAnimatorLayer = new WaveBgAnimatorLayer();
        this.mBgWaveLayer = waveBgAnimatorLayer;
        waveBgAnimatorLayer.setSlideMaxDistance(relativeSize3);
        addInteractListener(this.mBgWaveLayer);
        float relativeSize4 = Utils.getRelativeSize(context, -40);
        GuideUILayerWrapper guideUILayerWrapper = new GuideUILayerWrapper();
        this.mGuideUILayerWrapper = guideUILayerWrapper;
        guideUILayerWrapper.setShakeUpDistance(relativeSize4);
        this.mGuideUILayerWrapper.setSlideMaxDistance(relativeSize3);
        addInteractListener(this.mGuideUILayerWrapper);
        float relativeSize5 = Utils.getRelativeSize(context, 160);
        MainIconLayerWrapper mainIconLayerWrapper = new MainIconLayerWrapper();
        this.mMainIconLayerWrapper = mainIconLayerWrapper;
        mainIconLayerWrapper.setShakeUpDistance(relativeSize4);
        this.mMainIconLayerWrapper.setToBiggerDistance(relativeSize5);
        this.mMainIconLayerWrapper.setGobackAnimatorListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WorldCupSlideView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
            public void onAnimationFinish() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (WorldCupSlideView.this.mInteractListeners != null && WorldCupSlideView.this.mInteractListeners.size() > 0) {
                    for (InteractListener interactListener : WorldCupSlideView.this.mInteractListeners) {
                        if (interactListener != null) {
                            interactListener.restart();
                        }
                    }
                }
                WorldCupSlideView.this.mIgnoreTouchEvent = false;
            }
        });
        this.mMainIconLayerWrapper.setFlyAwayAnimatorListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WorldCupSlideView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
            public void onAnimationFinish() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    CallBack callBack = WorldCupSlideView.this.mCallBack;
                    if (callBack != null) {
                        callBack.onAnimationFinish();
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mMainIconLayerWrapper.setStateListener(new MainIconLayerWrapper.StateListener() { // from class: com.tencent.ams.fusion.widget.worldcupslide.WorldCupSlideView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WorldCupSlideView.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.worldcupslide.MainIconLayerWrapper.StateListener
            public void notifyIsIgnoreTouchEvent(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    WorldCupSlideView.this.mIgnoreTouchEvent = z16;
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                }
            }
        });
        addInteractListener(this.mMainIconLayerWrapper);
    }

    private void dispatchTouchEventToLayers(MotionEvent motionEvent) {
        List<InteractListener> list = this.mInteractListeners;
        if (list != null && list.size() > 0) {
            for (InteractListener interactListener : this.mInteractListeners) {
                if (interactListener != null) {
                    interactListener.onTouch(motionEvent);
                }
            }
        }
    }

    private void reset() {
        this.mIsStop = false;
        this.mIgnoreTouchEvent = false;
        clearLayers();
    }

    private void startShakeAnimation() {
        if (this.mIsStop) {
            return;
        }
        if (getWidth() > 0 && getHeight() > 0) {
            this.mViewGroupLayer = new GroupLayer(new AnimatorLayer[0]);
            this.mBgWaveLayer.init(getContext(), getWidth(), getHeight());
            this.mViewGroupLayer.addLayers(this.mBgWaveLayer);
            float height = (getHeight() - (this.mMainIconHeight / 2.0f)) + Utils.getRelativeSize(getContext(), 50);
            float relativeSize = ((height - (this.mMainIconHeight / 2.0f)) - Utils.getRelativeSize(getContext(), 20)) - Utils.getRelativeSize(getContext(), 32);
            float relativeSize2 = (relativeSize - Utils.getRelativeSize(getContext(), 8)) - Utils.getRelativeSize(getContext(), 42);
            float relativeSize3 = ((relativeSize2 - Utils.getRelativeSize(getContext(), 10)) - this.mGuideIconHeight) - this.mTitleTextSize;
            GuideUILayerWrapper guideUILayerWrapper = this.mGuideUILayerWrapper;
            Bitmap bitmap = this.mGuideIcon;
            float width = getWidth();
            float f16 = this.mGuideIconWidth;
            guideUILayerWrapper.setArrowBitmap(bitmap, (width - f16) / 2.0f, relativeSize3, f16, this.mGuideIconHeight);
            this.mGuideUILayerWrapper.setTitle(this.mTitleText, -1, this.mTitleTextSize, getWidth() / 2.0f, relativeSize2);
            this.mGuideUILayerWrapper.setSubTitle(this.mSubTitleText, 16777215, 0.6f, this.mSubTitleTextSize, getWidth() / 2.0f, relativeSize);
            this.mViewGroupLayer.addLayers(this.mGuideUILayerWrapper.getGuideUILayers());
            float f17 = this.mMainIconWidth;
            this.mMainIconLayerWrapper.setMainIcon(this.mMainIcon, getWidth() / 2.0f, height, f17, f17);
            this.mViewGroupLayer.addLayers(this.mMainIconLayerWrapper.getMainIconLayer());
            addLayer(this.mViewGroupLayer);
        }
        startAnimation();
    }

    protected void addInteractListener(InteractListener interactListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) interactListener);
            return;
        }
        List<InteractListener> list = this.mInteractListeners;
        if (list != null) {
            list.add(interactListener);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.AnimatorView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        CallBack callBack;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent)).booleanValue();
        }
        try {
        } catch (Throwable th5) {
            Logger.e(TAG, th5.getMessage());
            CallBack callBack2 = this.mCallBack;
            if (callBack2 != null) {
                callBack2.onError(-2);
            }
        }
        if (this.mIgnoreTouchEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.mIsStop) {
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && (callBack = this.mCallBack) != null) {
                callBack.onInteractFail(-3, motionEvent.getX(), motionEvent.getY());
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    dispatchTouchEventToLayers(motionEvent);
                }
            } else {
                dispatchTouchEventToLayers(motionEvent);
                if (this.mTouchStartY - motionEvent.getY() >= this.mSlideThreshold) {
                    List<InteractListener> list = this.mInteractListeners;
                    if (list != null && list.size() > 0) {
                        for (InteractListener interactListener : this.mInteractListeners) {
                            if (interactListener != null) {
                                interactListener.onInteractSuccess();
                            }
                        }
                    }
                    CallBack callBack3 = this.mCallBack;
                    if (callBack3 != null) {
                        callBack3.onInteractSuccess(motionEvent.getX(), motionEvent.getY());
                    }
                } else {
                    List<InteractListener> list2 = this.mInteractListeners;
                    if (list2 != null && list2.size() > 0) {
                        for (InteractListener interactListener2 : this.mInteractListeners) {
                            if (interactListener2 != null) {
                                interactListener2.onInteractFail();
                            }
                        }
                    }
                    CallBack callBack4 = this.mCallBack;
                    if (callBack4 != null) {
                        callBack4.onInteractFail(-2, motionEvent.getX(), motionEvent.getY());
                    }
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        this.mTouchStartY = motionEvent.getY();
        CallBack callBack5 = this.mCallBack;
        if (callBack5 != null) {
            callBack5.onInteractStart(motionEvent.getX(), motionEvent.getY());
        }
        boolean isPointInArea = Utils.isPointInArea(motionEvent.getX(), motionEvent.getY(), this.mHotAreaRect, 0.0f, 0.0f, 0.0f);
        if (isPointInArea) {
            dispatchTouchEventToLayers(motionEvent);
        } else {
            CallBack callBack6 = this.mCallBack;
            if (callBack6 != null) {
                callBack6.onInteractFail(-1, motionEvent.getX(), motionEvent.getY());
            }
        }
        if (isPointInArea || super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Logger.i(TAG, "onSizeChanged w:" + i3 + ", h:" + i16 + ", oldw:" + i17 + ", oldh:" + i18);
        if (isUserStarted()) {
            start();
        }
    }

    public void setCallBack(CallBack callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) callBack);
        } else {
            this.mCallBack = callBack;
        }
    }

    public void setHotArea(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        } else {
            this.mHotAreaRect = new RectF(f16, f17, f18, f19);
        }
    }

    public void setMainIcon(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
        } else {
            this.mMainIcon = Utils.createBitmap(bitmap, (int) this.mMainIconWidth, (int) this.mMainIconHeight, true);
        }
    }

    public void setSlideThreshold(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        float dp2px = Utils.dp2px(i3 / 2);
        this.mSlideThreshold = dp2px;
        MainIconLayerWrapper mainIconLayerWrapper = this.mMainIconLayerWrapper;
        if (mainIconLayerWrapper != null) {
            mainIconLayerWrapper.setSlideThreshold(dp2px);
        }
    }

    public void setText(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            this.mTitleText = str;
            this.mSubTitleText = str2;
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Logger.i(TAG, "start");
        try {
            reset();
            startShakeAnimation();
        } catch (Throwable th5) {
            Logger.e(TAG, th5.getMessage());
            CallBack callBack = this.mCallBack;
            if (callBack != null) {
                callBack.onError(-1);
            }
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mIsStop = true;
            stopAnimation(true, true);
        }
    }
}
