package com.tencent.tdf.embed.mutatorsstack;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tdf.TDFJNI;
import com.tencent.tdf.embed.IGestureInfoProvider;
import com.tencent.tdf.view.INativeViewDelegate;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EmbeddedMutatorView extends FrameLayout implements INativeViewDelegate {
    static final /* synthetic */ boolean $assertionsDisabled;
    static IPatchRedirector $redirector_;
    float mIntrinsicScale;
    private boolean mMutatorMatrixReady;
    private MutatorsStack mMutatorsStack;
    private float mScreenDensity;
    View mTargetView;
    private long mTargetViewId;
    IGestureInfoProvider provider;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15005);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            $assertionsDisabled = true;
        }
    }

    public EmbeddedMutatorView(Context context, View view, float f16) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, view, Float.valueOf(f16));
            return;
        }
        this.mScreenDensity = 0.0f;
        this.mMutatorMatrixReady = false;
        this.mTargetViewId = 0L;
        this.mIntrinsicScale = 1.0f;
        this.mScreenDensity = getResources().getDisplayMetrics().density;
        this.mIntrinsicScale = f16;
        this.mTargetView = view;
        addTargetView(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addTargetView(View view) {
        super.addView(view);
        if (!$assertionsDisabled && getChildCount() != 1) {
            throw new AssertionError();
        }
        if (view instanceof IGestureInfoProvider) {
            this.provider = (IGestureInfoProvider) view;
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void deleteView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else {
            ((ViewGroup) this.mTargetView).removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        if (!this.mMutatorMatrixReady) {
            return;
        }
        canvas.save();
        if (this.mMutatorsStack != null) {
            Matrix matrix = new Matrix(this.mMutatorsStack.getFinalMatrix());
            float f16 = this.mScreenDensity;
            float f17 = this.mIntrinsicScale;
            matrix.preScale(1.0f / (f16 * f17), 1.0f / (f16 * f17));
            canvas.concat(matrix);
        }
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.mMutatorMatrixReady) {
            return false;
        }
        Matrix matrix = new Matrix(this.mMutatorsStack.getFinalMatrix());
        float f16 = this.mScreenDensity;
        float f17 = this.mIntrinsicScale;
        matrix.preScale(1.0f / (f16 * f17), 1.0f / (f16 * f17));
        Matrix matrix2 = new Matrix();
        matrix.invert(matrix2);
        motionEvent.transform(matrix2);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        motionEvent.transform(matrix);
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        if (!this.mMutatorMatrixReady) {
            return;
        }
        canvas.save();
        Iterator<Path> it = this.mMutatorsStack.getFinalClippingPaths().iterator();
        while (it.hasNext()) {
            canvas.clipPath(new Path(it.next()));
        }
        super.draw(canvas);
        canvas.restore();
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public Rect getLayoutRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Rect) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new Rect(this.mTargetView.getLeft(), this.mTargetView.getTop(), this.mTargetView.getWidth(), this.mTargetView.getHeight());
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void insertView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, i3);
        } else {
            ((ViewGroup) this.mTargetView).addView(view);
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void onDispose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    public void setMutatorsStack(MutatorsStack mutatorsStack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) mutatorsStack);
            return;
        }
        this.mMutatorMatrixReady = true;
        this.mMutatorsStack = mutatorsStack;
        setWillNotDraw(false);
    }

    public void setTargetViewId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.mTargetViewId = i3;
            this.mTargetView.setId(i3);
        }
    }

    public void tryUpdateEmbeddedViewGestureInfo(MotionEvent motionEvent, TDFJNI tdfjni) {
        IGestureInfoProvider iGestureInfoProvider;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent, (Object) tdfjni);
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if ((actionMasked == 0 || actionMasked == 5) && (iGestureInfoProvider = this.provider) != null && iGestureInfoProvider.needUpdate()) {
            Rect provideHitTestRect = this.provider.provideHitTestRect();
            tdfjni.updateGestureInfo(this.mTargetViewId, this.provider.useCustomHitTestRect(), provideHitTestRect.left, provideHitTestRect.top, provideHitTestRect.right, provideHitTestRect.bottom, this.provider.provideSupportGestures());
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void updateLayoutParams(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int ceil = (int) Math.ceil(i17 * this.mIntrinsicScale);
        int ceil2 = (int) Math.ceil(i18 * this.mIntrinsicScale);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mTargetView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(ceil, ceil2);
        } else {
            layoutParams.width = ceil;
            layoutParams.height = ceil2;
        }
        layoutParams.leftMargin = i3;
        layoutParams.topMargin = i16;
        this.mTargetView.setLayoutParams(layoutParams);
    }
}
