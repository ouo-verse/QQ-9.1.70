package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ViewPropertyAnimatorCompat {
    static final ViewPropertyAnimatorCompatImpl IMPL = new KitKatViewPropertyAnimatorCompatImpl();
    static final int LISTENER_TAG_ID = 2113929216;
    private static final String TAG = "ViewAnimatorCompat";
    private WeakReference<View> mView;
    private Runnable mStartAction = null;
    private Runnable mEndAction = null;
    private int mOldLayerType = -1;

    /* loaded from: classes.dex */
    static class ICSViewPropertyAnimatorCompatImpl extends BaseViewPropertyAnimatorCompatImpl {
        WeakHashMap<View, Integer> mLayerMap = null;

        /* loaded from: classes.dex */
        static class MyVpaListener implements ViewPropertyAnimatorListener {
            ViewPropertyAnimatorCompat mVpa;

            MyVpaListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
                this.mVpa = viewPropertyAnimatorCompat;
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener;
                Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                } else {
                    viewPropertyAnimatorListener = null;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
                if (this.mVpa.mOldLayerType >= 0) {
                    ViewCompat.setLayerType(view, this.mVpa.mOldLayerType, null);
                    this.mVpa.mOldLayerType = -1;
                }
                if (this.mVpa.mEndAction != null) {
                    this.mVpa.mEndAction.run();
                }
                Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }
            }

            @Override // android.support.v4.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
                if (this.mVpa.mOldLayerType >= 0) {
                    ViewCompat.setLayerType(view, 2, null);
                }
                if (this.mVpa.mStartAction != null) {
                    this.mVpa.mStartAction.run();
                }
                Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            }
        }

        ICSViewPropertyAnimatorCompatImpl() {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void alpha(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.alpha(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void alphaBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.alphaBy(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void cancel(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompatICS.cancel(view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public long getDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return ViewPropertyAnimatorCompatICS.getDuration(view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public long getStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return ViewPropertyAnimatorCompatICS.getStartDelay(view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.rotation(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.rotationBy(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.rotationX(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.rotationXBy(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.rotationY(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.rotationYBy(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.scaleX(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.scaleXBy(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.scaleY(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.scaleYBy(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j3) {
            ViewPropertyAnimatorCompatICS.setDuration(view, j3);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Interpolator interpolator) {
            ViewPropertyAnimatorCompatICS.setInterpolator(view, interpolator);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            view.setTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID, viewPropertyAnimatorListener);
            ViewPropertyAnimatorCompatICS.setListener(view, new MyVpaListener(viewPropertyAnimatorCompat));
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j3) {
            ViewPropertyAnimatorCompatICS.setStartDelay(view, j3);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void start(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompatICS.start(view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.translationX(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.translationXBy(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.translationY(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.translationYBy(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompatICS.setListener(view, new MyVpaListener(viewPropertyAnimatorCompat));
            viewPropertyAnimatorCompat.mEndAction = runnable;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            viewPropertyAnimatorCompat.mOldLayerType = ViewCompat.getLayerType(view);
            ViewPropertyAnimatorCompatICS.setListener(view, new MyVpaListener(viewPropertyAnimatorCompat));
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompatICS.setListener(view, new MyVpaListener(viewPropertyAnimatorCompat));
            viewPropertyAnimatorCompat.mStartAction = runnable;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.x(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.xBy(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.y(view, f16);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            ViewPropertyAnimatorCompatICS.yBy(view, f16);
        }
    }

    /* loaded from: classes.dex */
    static class JBMr2ViewPropertyAnimatorCompatImpl extends JBViewPropertyAnimatorCompatImpl {
        JBMr2ViewPropertyAnimatorCompatImpl() {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public Interpolator getInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return ViewPropertyAnimatorCompatJellybeanMr2.getInterpolator(view);
        }
    }

    /* loaded from: classes.dex */
    static class JBViewPropertyAnimatorCompatImpl extends ICSViewPropertyAnimatorCompatImpl {
        JBViewPropertyAnimatorCompatImpl() {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            ViewPropertyAnimatorCompatJB.setListener(view, viewPropertyAnimatorListener);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompatJB.withEndAction(view, runnable);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompatJB.withLayer(view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompatJB.withStartAction(view, runnable);
        }
    }

    /* loaded from: classes.dex */
    static class KitKatViewPropertyAnimatorCompatImpl extends JBMr2ViewPropertyAnimatorCompatImpl {
        KitKatViewPropertyAnimatorCompatImpl() {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl, android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setUpdateListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
            ViewPropertyAnimatorCompatKK.setUpdateListener(view, viewPropertyAnimatorUpdateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface ViewPropertyAnimatorCompatImpl {
        void alpha(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void alphaBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void cancel(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        long getDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        Interpolator getInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        long getStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        void rotation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void rotationBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void rotationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void rotationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void rotationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void rotationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void scaleX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void scaleXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void scaleY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void scaleYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void setDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j3);

        void setInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Interpolator interpolator);

        void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener);

        void setStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j3);

        void setUpdateListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener);

        void start(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        void translationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void translationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void translationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void translationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable);

        void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable);

        void x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);

        void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewPropertyAnimatorCompat(View view) {
        this.mView = new WeakReference<>(view);
    }

    public ViewPropertyAnimatorCompat alpha(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.alpha(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.alphaBy(this, view, f16);
        }
        return this;
    }

    public void cancel() {
        View view = this.mView.get();
        if (view != null) {
            IMPL.cancel(this, view);
        }
    }

    public long getDuration() {
        View view = this.mView.get();
        if (view != null) {
            return IMPL.getDuration(this, view);
        }
        return 0L;
    }

    public Interpolator getInterpolator() {
        View view = this.mView.get();
        if (view != null) {
            return IMPL.getInterpolator(this, view);
        }
        return null;
    }

    public long getStartDelay() {
        View view = this.mView.get();
        if (view != null) {
            return IMPL.getStartDelay(this, view);
        }
        return 0L;
    }

    public ViewPropertyAnimatorCompat rotation(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.rotation(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.rotationBy(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.rotationX(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.rotationXBy(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.rotationY(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.rotationYBy(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.scaleX(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.scaleXBy(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.scaleY(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.scaleYBy(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long j3) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.setDuration(this, view, j3);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.setInterpolator(this, view, interpolator);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.setListener(this, view, viewPropertyAnimatorListener);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long j3) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.setStartDelay(this, view, j3);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.setUpdateListener(this, view, viewPropertyAnimatorUpdateListener);
        }
        return this;
    }

    public void start() {
        View view = this.mView.get();
        if (view != null) {
            IMPL.start(this, view);
        }
    }

    public ViewPropertyAnimatorCompat translationX(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.translationX(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.translationXBy(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.translationY(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.translationYBy(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.withEndAction(this, view, runnable);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withLayer() {
        View view = this.mView.get();
        if (view != null) {
            IMPL.withLayer(this, view);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.withStartAction(this, view, runnable);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat x(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.x(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.xBy(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat y(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.y(this, view, f16);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f16) {
        View view = this.mView.get();
        if (view != null) {
            IMPL.yBy(this, view, f16);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BaseViewPropertyAnimatorCompatImpl implements ViewPropertyAnimatorCompatImpl {
        WeakHashMap<View, Runnable> mStarterMap = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class Starter implements Runnable {
            WeakReference<View> mViewRef;
            ViewPropertyAnimatorCompat mVpa;

            @Override // java.lang.Runnable
            public void run() {
                BaseViewPropertyAnimatorCompatImpl.this.startAnimation(this.mVpa, this.mViewRef.get());
            }

            Starter(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
                this.mViewRef = new WeakReference<>(view);
                this.mVpa = viewPropertyAnimatorCompat;
            }
        }

        BaseViewPropertyAnimatorCompatImpl() {
        }

        private void postStartMessage(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            Runnable runnable;
            WeakHashMap<View, Runnable> weakHashMap = this.mStarterMap;
            if (weakHashMap != null) {
                runnable = weakHashMap.get(view);
            } else {
                runnable = null;
            }
            if (runnable == null) {
                runnable = new Starter(viewPropertyAnimatorCompat, view);
                if (this.mStarterMap == null) {
                    this.mStarterMap = new WeakHashMap<>();
                }
                this.mStarterMap.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }

        private void removeStartMessage(View view) {
            Runnable runnable;
            WeakHashMap<View, Runnable> weakHashMap = this.mStarterMap;
            if (weakHashMap != null && (runnable = weakHashMap.get(view)) != null) {
                view.removeCallbacks(runnable);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startAnimation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorListener viewPropertyAnimatorListener;
            Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            if (tag instanceof ViewPropertyAnimatorListener) {
                viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
            } else {
                viewPropertyAnimatorListener = null;
            }
            Runnable runnable = viewPropertyAnimatorCompat.mStartAction;
            Runnable runnable2 = viewPropertyAnimatorCompat.mEndAction;
            if (runnable != null) {
                runnable.run();
            }
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(view);
                viewPropertyAnimatorListener.onAnimationEnd(view);
            }
            if (runnable2 != null) {
                runnable2.run();
            }
            WeakHashMap<View, Runnable> weakHashMap = this.mStarterMap;
            if (weakHashMap != null) {
                weakHashMap.remove(view);
            }
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void alpha(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void alphaBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void cancel(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public long getDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return 0L;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public Interpolator getInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return null;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public long getStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            return 0L;
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void rotationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void scaleYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            view.setTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID, viewPropertyAnimatorListener);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void start(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            removeStartMessage(view);
            startAnimation(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void translationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            viewPropertyAnimatorCompat.mEndAction = runnable;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            viewPropertyAnimatorCompat.mStartAction = runnable;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f16) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j3) {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Interpolator interpolator) {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j3) {
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl
        public void setUpdateListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        }
    }
}
