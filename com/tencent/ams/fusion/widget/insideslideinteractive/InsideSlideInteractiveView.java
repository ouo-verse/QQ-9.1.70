package com.tencent.ams.fusion.widget.insideslideinteractive;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class InsideSlideInteractiveView extends FrameLayout implements View.OnClickListener, InsideSlideGuideAnimatorCallback {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "InsideSlideInteractiveView";
    private GesturePathView mGesturePathView;
    private InsideSlideGuideAnimatorListener mGuideAnimatorListener;
    private InsideSlideGuideAnimatorView mGuideAnimatorView;
    private View mGuideClickView;
    private View mHolderGuideClickView;
    private Rect mSlideRect;

    public InsideSlideInteractiveView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            init(context);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeClickViewVisibility(@NonNull View view, boolean z16) {
        if (z16) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    private void init(Context context) {
        this.mGuideAnimatorView = new InsideSlideGuideAnimatorView(context);
        this.mGesturePathView = new GesturePathView(context);
        addView(this.mGuideAnimatorView, new ViewGroup.LayoutParams(-1, -1));
        addView(this.mGesturePathView, new ViewGroup.LayoutParams(-1, -1));
        initGuideAnimatorClickView(context);
    }

    private void initGuideAnimatorClickView(Context context) {
        this.mGuideClickView = initHolderGuideClickView(context);
        this.mHolderGuideClickView = initHolderGuideClickView(context);
        this.mGuideAnimatorView.setSlideGuideAnimatorCallback(this);
    }

    private View initHolderGuideClickView(Context context) {
        View view = new View(context);
        view.setOnClickListener(this);
        view.setVisibility(8);
        addView(view, new ViewGroup.LayoutParams(-1, -1));
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void letGuideClickViewRelayout(@Nullable RectF rectF, @NonNull View view, boolean z16) {
        if (z16 && rectF != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            float f16 = rectF.right;
            float f17 = rectF.left;
            marginLayoutParams.width = (int) (f16 - f17);
            float f18 = rectF.bottom;
            float f19 = rectF.top;
            marginLayoutParams.height = (int) (f18 - f19);
            marginLayoutParams.setMargins((int) f17, (int) f19, 0, 0);
            view.setLayoutParams(marginLayoutParams);
        }
    }

    private void setGestureHotArea() {
        if (getWidth() > 0 && getHeight() > 0 && this.mSlideRect != null && this.mGesturePathView != null) {
            post(new Runnable() { // from class: com.tencent.ams.fusion.widget.insideslideinteractive.InsideSlideInteractiveView.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) InsideSlideInteractiveView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) InsideSlideInteractiveView.this.mGesturePathView.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new FrameLayout.LayoutParams(InsideSlideInteractiveView.this.mSlideRect.width(), InsideSlideInteractiveView.this.mSlideRect.height());
                    }
                    layoutParams.width = InsideSlideInteractiveView.this.mSlideRect.width();
                    layoutParams.height = InsideSlideInteractiveView.this.mSlideRect.height();
                    layoutParams.leftMargin = InsideSlideInteractiveView.this.mSlideRect.left;
                    layoutParams.topMargin = InsideSlideInteractiveView.this.mSlideRect.top;
                    InsideSlideInteractiveView.this.mGesturePathView.setLayoutParams(layoutParams);
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InsideSlideGuideAnimatorListener insideSlideGuideAnimatorListener;
        InsideSlideGuideAnimatorListener insideSlideGuideAnimatorListener2;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) view);
        } else {
            if (view == this.mGuideClickView && (insideSlideGuideAnimatorListener2 = this.mGuideAnimatorListener) != null) {
                insideSlideGuideAnimatorListener2.onGuideClick();
            }
            if (view == this.mHolderGuideClickView && (insideSlideGuideAnimatorListener = this.mGuideAnimatorListener) != null) {
                insideSlideGuideAnimatorListener.onHolderGuideClick();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.ams.fusion.widget.insideslideinteractive.InsideSlideGuideAnimatorCallback
    public void onGuideVisibilityChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        } else {
            post(new Runnable(z16) { // from class: com.tencent.ams.fusion.widget.insideslideinteractive.InsideSlideInteractiveView.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$visibility;

                {
                    this.val$visibility = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, InsideSlideInteractiveView.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (InsideSlideInteractiveView.this.mGuideClickView == null) {
                        return;
                    }
                    InsideSlideInteractiveView insideSlideInteractiveView = InsideSlideInteractiveView.this;
                    insideSlideInteractiveView.changeClickViewVisibility(insideSlideInteractiveView.mGuideClickView, this.val$visibility);
                    if (InsideSlideInteractiveView.this.mGuideAnimatorView == null) {
                        return;
                    }
                    InsideSlideInteractiveView insideSlideInteractiveView2 = InsideSlideInteractiveView.this;
                    insideSlideInteractiveView2.letGuideClickViewRelayout(insideSlideInteractiveView2.mGuideAnimatorView.getGuideRect(), InsideSlideInteractiveView.this.mGuideClickView, this.val$visibility);
                }
            });
        }
    }

    @Override // com.tencent.ams.fusion.widget.insideslideinteractive.InsideSlideGuideAnimatorCallback
    public void onHolderGuideVisibilityChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            post(new Runnable(z16) { // from class: com.tencent.ams.fusion.widget.insideslideinteractive.InsideSlideInteractiveView.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$visibility;

                {
                    this.val$visibility = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, InsideSlideInteractiveView.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (InsideSlideInteractiveView.this.mHolderGuideClickView == null) {
                        return;
                    }
                    InsideSlideInteractiveView insideSlideInteractiveView = InsideSlideInteractiveView.this;
                    insideSlideInteractiveView.changeClickViewVisibility(insideSlideInteractiveView.mHolderGuideClickView, this.val$visibility);
                    if (InsideSlideInteractiveView.this.mGuideAnimatorView == null) {
                        return;
                    }
                    InsideSlideInteractiveView insideSlideInteractiveView2 = InsideSlideInteractiveView.this;
                    insideSlideInteractiveView2.letGuideClickViewRelayout(insideSlideInteractiveView2.mGuideAnimatorView.getHolderGuideRect(), InsideSlideInteractiveView.this.mHolderGuideClickView, this.val$visibility);
                }
            });
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.onSizeChanged(i3, i16, i17, i18);
            setGestureHotArea();
        }
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        Logger.i(TAG, "pause");
        InsideSlideGuideAnimatorView insideSlideGuideAnimatorView = this.mGuideAnimatorView;
        if (insideSlideGuideAnimatorView != null) {
            insideSlideGuideAnimatorView.pauseAnimation();
        }
        GesturePathView gesturePathView = this.mGesturePathView;
        if (gesturePathView != null) {
            gesturePathView.pauseAnimation();
        }
    }

    public boolean processEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) motionEvent)).booleanValue();
        }
        GesturePathView gesturePathView = this.mGesturePathView;
        if (gesturePathView != null) {
            return gesturePathView.processEvent(motionEvent);
        }
        return false;
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Logger.i(TAG, "resume");
        InsideSlideGuideAnimatorView insideSlideGuideAnimatorView = this.mGuideAnimatorView;
        if (insideSlideGuideAnimatorView != null) {
            insideSlideGuideAnimatorView.resumeAnimation();
        }
        GesturePathView gesturePathView = this.mGesturePathView;
        if (gesturePathView != null) {
            gesturePathView.resumeAnimation();
        }
    }

    public void setGestureColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        GesturePathView gesturePathView = this.mGesturePathView;
        if (gesturePathView != null) {
            gesturePathView.setGestureColor(str);
        }
    }

    public void setGestureSlideValidAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
            return;
        }
        GesturePathView gesturePathView = this.mGesturePathView;
        if (gesturePathView != null) {
            gesturePathView.setGestureSlideValidAngle(f16);
        }
    }

    public void setGestureSlideValidHeightDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        GesturePathView gesturePathView = this.mGesturePathView;
        if (gesturePathView != null) {
            gesturePathView.setGestureSlideValidHeightDp(i3);
        }
    }

    public void setGestureStrokeWidthDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        GesturePathView gesturePathView = this.mGesturePathView;
        if (gesturePathView != null) {
            gesturePathView.setGestureStrokeWidthDp(i3);
        }
    }

    public void setGestureVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        GesturePathView gesturePathView = this.mGesturePathView;
        if (gesturePathView != null) {
            gesturePathView.setGestureVisible(z16);
        }
    }

    public void setGuideArea(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) rect);
            return;
        }
        if (this.mGuideAnimatorView != null && rect != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect.width(), rect.height());
            layoutParams.leftMargin = rect.left;
            layoutParams.topMargin = rect.top;
            this.mGuideAnimatorView.setLayoutParams(layoutParams);
        }
    }

    public void setGuideRepeatCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        InsideSlideGuideAnimatorView insideSlideGuideAnimatorView = this.mGuideAnimatorView;
        if (insideSlideGuideAnimatorView != null) {
            insideSlideGuideAnimatorView.setGuideRepeatCount(i3);
        }
    }

    public void setGuideText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
        InsideSlideGuideAnimatorView insideSlideGuideAnimatorView = this.mGuideAnimatorView;
        if (insideSlideGuideAnimatorView != null) {
            insideSlideGuideAnimatorView.setGuideText(str);
        }
    }

    public void setGuideTextSizeAndColor(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Float.valueOf(f16), Integer.valueOf(i3));
            return;
        }
        InsideSlideGuideAnimatorView insideSlideGuideAnimatorView = this.mGuideAnimatorView;
        if (insideSlideGuideAnimatorView != null) {
            insideSlideGuideAnimatorView.setGuideTextSizeAndColor(f16, i3);
        }
    }

    public void setHolderGuideBackgroundColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
            return;
        }
        InsideSlideGuideAnimatorView insideSlideGuideAnimatorView = this.mGuideAnimatorView;
        if (insideSlideGuideAnimatorView != null) {
            insideSlideGuideAnimatorView.setHolderGuideBackgroundColor(i3);
        }
    }

    public void setHolderGuideTextSizeAndColor(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Float.valueOf(f16), Integer.valueOf(i3));
            return;
        }
        InsideSlideGuideAnimatorView insideSlideGuideAnimatorView = this.mGuideAnimatorView;
        if (insideSlideGuideAnimatorView != null) {
            insideSlideGuideAnimatorView.setHolderGuideTextSizeAndColor(f16, i3);
        }
    }

    public void setSlideArea(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) rect);
        } else {
            this.mSlideRect = rect;
            setGestureHotArea();
        }
    }

    public void setSlideDirection(@SlideGestureViewHelper.SlideDirection int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        GesturePathView gesturePathView = this.mGesturePathView;
        if (gesturePathView != null) {
            gesturePathView.setSlideDirection(i3);
        }
        InsideSlideGuideAnimatorView insideSlideGuideAnimatorView = this.mGuideAnimatorView;
        if (insideSlideGuideAnimatorView != null) {
            insideSlideGuideAnimatorView.setGuideDirection(i3);
        }
    }

    public void setSlideGuideAnimatorListener(InsideSlideGuideAnimatorListener insideSlideGuideAnimatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) insideSlideGuideAnimatorListener);
        } else {
            this.mGuideAnimatorListener = insideSlideGuideAnimatorListener;
        }
    }

    public void setSlideInteractiveListener(InsideSlideInteractiveListener insideSlideInteractiveListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) insideSlideInteractiveListener);
            return;
        }
        GesturePathView gesturePathView = this.mGesturePathView;
        if (gesturePathView != null) {
            gesturePathView.setSlideInteractiveListener(insideSlideInteractiveListener);
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Logger.i(TAG, "start");
        InsideSlideGuideAnimatorView insideSlideGuideAnimatorView = this.mGuideAnimatorView;
        if (insideSlideGuideAnimatorView != null) {
            insideSlideGuideAnimatorView.startAnimation();
        }
        GesturePathView gesturePathView = this.mGesturePathView;
        if (gesturePathView != null) {
            gesturePathView.startAnimation();
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Logger.i(TAG, "stop");
        InsideSlideGuideAnimatorView insideSlideGuideAnimatorView = this.mGuideAnimatorView;
        if (insideSlideGuideAnimatorView != null) {
            insideSlideGuideAnimatorView.stopAnimation();
        }
        GesturePathView gesturePathView = this.mGesturePathView;
        if (gesturePathView != null) {
            gesturePathView.stopAnimation();
        }
    }

    public InsideSlideInteractiveView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            init(context);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public InsideSlideInteractiveView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            init(context);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    @RequiresApi(api = 21)
    public InsideSlideInteractiveView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            init(context);
        } else {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }
}
