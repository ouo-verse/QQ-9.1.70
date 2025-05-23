package com.tencent.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AutoVerticalScrollTextView extends TextSwitcher implements ViewSwitcher.ViewFactory, Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_NEXT_TEXT = 9001;
    private long ANIMATION_TIME;
    private long INTER_SWITCH_TIME;
    private Context mContext;
    private Rotate3dAnimation mInUp;
    private Rotate3dAnimation mOutUp;
    private Handler mUIHandler;
    private String[] textArray;
    private int textIndex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class Rotate3dAnimation extends Animation {
        static IPatchRedirector $redirector_;
        private Camera mCamera;
        private float mCenterX;
        private float mCenterY;
        private final boolean mTurnIn;
        private final boolean mTurnUp;

        public Rotate3dAnimation(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AutoVerticalScrollTextView.this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else {
                this.mTurnIn = z16;
                this.mTurnUp = z17;
            }
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f16, Transformation transformation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 1;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), transformation);
                return;
            }
            float f17 = this.mCenterX;
            float f18 = this.mCenterY;
            Camera camera2 = this.mCamera;
            if (!this.mTurnUp) {
                i3 = -1;
            }
            Matrix matrix = transformation.getMatrix();
            camera2.save();
            if (this.mTurnIn) {
                camera2.translate(0.0f, i3 * this.mCenterY * (f16 - 1.0f), 0.0f);
            } else {
                camera2.translate(0.0f, i3 * this.mCenterY * f16, 0.0f);
            }
            camera2.getMatrix(matrix);
            camera2.restore();
            matrix.preTranslate(-f17, -f18);
            matrix.postTranslate(f17, f18);
        }

        @Override // android.view.animation.Animation
        public void initialize(int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            super.initialize(i3, i16, i17, i18);
            this.mCamera = new Camera();
            this.mCenterY = AutoVerticalScrollTextView.this.getHeight();
            this.mCenterX = AutoVerticalScrollTextView.this.getWidth();
        }
    }

    public AutoVerticalScrollTextView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private Rotate3dAnimation createAnim(boolean z16, boolean z17) {
        Rotate3dAnimation rotate3dAnimation = new Rotate3dAnimation(z16, z17);
        rotate3dAnimation.setDuration(this.ANIMATION_TIME);
        rotate3dAnimation.setFillAfter(false);
        rotate3dAnimation.setInterpolator(new AccelerateInterpolator());
        return rotate3dAnimation;
    }

    private void init() {
        this.mUIHandler = new Handler(Looper.getMainLooper(), this);
        setFactory(this);
        this.mInUp = createAnim(true, true);
        this.mOutUp = createAnim(false, true);
        setInAnimation(this.mInUp);
        setOutAnimation(this.mOutUp);
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.mContext = null;
        Handler handler = this.mUIHandler;
        if (handler != null) {
            handler.removeMessages(9001);
            this.mUIHandler = null;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 9001) {
            if (this.textArray != null) {
                next();
                int i3 = this.textIndex + 1;
                this.textIndex = i3;
                String[] strArr = this.textArray;
                if (i3 >= strArr.length) {
                    this.textIndex = 0;
                }
                setText(strArr[this.textIndex]);
            }
            this.mUIHandler.removeMessages(9001);
            this.mUIHandler.sendEmptyMessageDelayed(9001, this.INTER_SWITCH_TIME);
        }
        return true;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(14.0f);
        textView.setSingleLine(true);
        textView.setGravity(17);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(Color.parseColor("#777777"));
        return textView;
    }

    public void next() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Animation inAnimation = getInAnimation();
        Rotate3dAnimation rotate3dAnimation = this.mInUp;
        if (inAnimation != rotate3dAnimation) {
            setInAnimation(rotate3dAnimation);
        }
        Animation outAnimation = getOutAnimation();
        Rotate3dAnimation rotate3dAnimation2 = this.mOutUp;
        if (outAnimation != rotate3dAnimation2) {
            setOutAnimation(rotate3dAnimation2);
        }
    }

    public void setAnimationTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            this.ANIMATION_TIME = j3;
        }
    }

    public void setInterSwitcTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.INTER_SWITCH_TIME = j3;
        }
    }

    public void setTextArray(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) strArr);
            return;
        }
        this.textArray = strArr;
        if (strArr != null && strArr.length > 0) {
            this.textIndex = 0;
            setText(strArr[0]);
            this.mUIHandler.sendEmptyMessageDelayed(9001, this.INTER_SWITCH_TIME);
        }
    }

    public AutoVerticalScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.textIndex = 0;
        this.INTER_SWITCH_TIME = 1000L;
        this.ANIMATION_TIME = 800L;
        this.mContext = context;
        init();
    }
}
