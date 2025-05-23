package com.tencent.ams.fusion.widget.olympicshake.inframe;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tencent.ams.fusion.widget.olympicshake.OlympicShakeIconView;
import com.tencent.ams.fusion.widget.olympicshake.OnShakeListener;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BaseShakeView extends FrameLayout implements OnShakeListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BaseShakeView";
    private View mContentView;
    private boolean mIsShowing;
    private OlympicShakeIconView mShakeIconView;
    private OnShakeListener mShakeListener;

    public BaseShakeView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mIsShowing = false;
            initView(context);
        }
    }

    private void animateContentView() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mContentView, c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realStart() {
        if (this.mIsShowing) {
            return;
        }
        Logger.i(TAG, "realStart");
        this.mIsShowing = true;
        setVisibility(0);
        animateContentView();
        startShake(this.mContentView.getX(), this.mContentView.getY());
    }

    private void startShake(float f16, float f17) {
        Logger.i(TAG, "startShake, contentX:" + f16 + ",contentY:" + f17);
        if (this.mShakeIconView == null) {
            return;
        }
        float[] iconSize = getIconSize();
        if (iconSize != null && iconSize.length == 2) {
            this.mShakeIconView.setIconSize(iconSize[0], iconSize[1]);
        }
        float[] iconLocation = getIconLocation();
        if (iconLocation != null && iconLocation.length == 2) {
            this.mShakeIconView.setIconPosition(f16 + iconLocation[0], f17 + iconLocation[1]);
        }
        this.mShakeIconView.setOnShakeListener(this);
        this.mShakeIconView.start();
    }

    protected abstract View createContentView();

    protected abstract FrameLayout.LayoutParams getContentViewLayoutParams();

    protected abstract float[] getIconLocation();

    protected abstract float[] getIconSize();

    protected void initView(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        View createContentView = createContentView();
        this.mContentView = createContentView;
        addView(createContentView, getContentViewLayoutParams());
        OlympicShakeIconView olympicShakeIconView = new OlympicShakeIconView(context);
        this.mShakeIconView = olympicShakeIconView;
        addView(olympicShakeIconView);
        setVisibility(8);
    }

    public boolean isShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.mIsShowing;
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.OnShakeListener
    public void onShakeComplete(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Double.valueOf(d16));
            return;
        }
        OnShakeListener onShakeListener = this.mShakeListener;
        if (onShakeListener != null) {
            onShakeListener.onShakeComplete(d16);
        }
        stop(true);
    }

    @Override // com.tencent.ams.fusion.widget.olympicshake.OnShakeListener
    public void onShaking(double d16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Double.valueOf(d16), Integer.valueOf(i3));
            return;
        }
        OnShakeListener onShakeListener = this.mShakeListener;
        if (onShakeListener != null) {
            onShakeListener.onShaking(d16, i3);
        }
    }

    public void restart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Logger.i(TAG, "restart");
        stop(false);
        start();
    }

    public abstract void setContent(String str, String str2);

    public abstract void setContentViewLayoutParams(FrameLayout.LayoutParams layoutParams);

    public void setIconBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bitmap);
            return;
        }
        OlympicShakeIconView olympicShakeIconView = this.mShakeIconView;
        if (olympicShakeIconView != null) {
            olympicShakeIconView.setIconBitmap(bitmap);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onClickListener);
            return;
        }
        View view = this.mContentView;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setOnShakeListener(OnShakeListener onShakeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onShakeListener);
            return;
        }
        this.mShakeListener = onShakeListener;
        OlympicShakeIconView olympicShakeIconView = this.mShakeIconView;
        if (olympicShakeIconView != null) {
            olympicShakeIconView.setOnShakeListener(this);
        }
    }

    public void setShakeFactor(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        OlympicShakeIconView olympicShakeIconView = this.mShakeIconView;
        if (olympicShakeIconView != null) {
            olympicShakeIconView.setShakeFactor(f16, f17, f18);
        }
    }

    public void setShakeValue(float f16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), Integer.valueOf(i3));
            return;
        }
        OlympicShakeIconView olympicShakeIconView = this.mShakeIconView;
        if (olympicShakeIconView != null) {
            olympicShakeIconView.setShakeValue(f16, i3);
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Logger.i(TAG, "start");
        setVisibility(4);
        this.mContentView.setLayoutParams(getContentViewLayoutParams());
        this.mContentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.ams.fusion.widget.olympicshake.inframe.BaseShakeView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseShakeView.this);
                }
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    BaseShakeView.this.mContentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    BaseShakeView.this.realStart();
                }
            }
        });
    }

    public void stop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        if (!this.mIsShowing) {
            return;
        }
        Logger.i(TAG, "stop, detach:" + z16);
        this.mIsShowing = false;
        setVisibility(8);
        OlympicShakeIconView olympicShakeIconView = this.mShakeIconView;
        if (olympicShakeIconView != null) {
            olympicShakeIconView.stop();
        }
        if (z16) {
            Utils.safeRemoveChildView(this);
        }
    }

    public BaseShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.mIsShowing = false;
            initView(context);
        }
    }

    public BaseShakeView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.mIsShowing = false;
            initView(context);
        }
    }
}
