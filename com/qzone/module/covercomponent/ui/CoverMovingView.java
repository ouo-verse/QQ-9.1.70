package com.qzone.module.covercomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.Scroller;
import com.qzone.proxy.covercomponent.adapter.CoverLog;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.covercomponent.model.LoadPhotoState;
import com.qzone.proxy.covercomponent.model.PhotoLoadedListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverMovingView extends CoverBaseView implements PhotoLoadedListener {
    public static final String TAG = "CoverMovingView";
    private volatile Drawable J;
    private volatile Drawable K;
    private Rect L;
    private int M;
    private AlphaAnimation N;
    private Transformation P;
    private Scroller Q;
    private List<Map<Integer, String>> R;
    private volatile Matrix S;
    private Matrix T;
    private int U;
    private Random V;
    private int W;
    private int X;
    private int Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f48668a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f48669b0;

    /* renamed from: c0, reason: collision with root package name */
    private Context f48670c0;

    private void A() {
        if (this.Q == null || !this.D) {
            return;
        }
        try {
            if (this.Q.computeScrollOffset()) {
                int currX = this.Q.getCurrX();
                int currY = this.Q.getCurrY();
                int i3 = currX - this.Y;
                int i16 = currY - this.Z;
                this.Y = currX;
                this.Z = currY;
                this.S.postTranslate(i3, i16);
                this.f48668a0 = true;
            } else {
                B();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private synchronized void B() {
        CoverEnv.getRealTimeThreadHandler().post(new Runnable() { // from class: com.qzone.module.covercomponent.ui.CoverMovingView.1
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                int i16;
                if (CoverLog.isColorLevel()) {
                    CoverLog.d(CoverMovingView.TAG, CoverLog.CLR, "startTranslate, thread:" + Thread.currentThread().getName());
                }
                try {
                    CoverMovingView coverMovingView = CoverMovingView.this;
                    coverMovingView.S = coverMovingView.y(coverMovingView.K, CoverMovingView.this.L);
                    int i17 = CoverMovingView.this.U;
                    if (i17 != 0) {
                        if (i17 == 1) {
                            i16 = -CoverMovingView.this.X;
                            i3 = 0;
                        } else if (i17 == 2) {
                            i3 = -CoverMovingView.this.W;
                            i16 = 0;
                        } else if (i17 == 3) {
                            i3 = -CoverMovingView.this.W;
                            i16 = -CoverMovingView.this.X;
                        }
                        CoverMovingView coverMovingView2 = CoverMovingView.this;
                        Point v3 = coverMovingView2.v(coverMovingView2.W, CoverMovingView.this.X);
                        CoverMovingView.this.Y = 0;
                        CoverMovingView.this.Z = 0;
                        CoverMovingView.this.S.postTranslate(i3, i16);
                        CoverMovingView.this.Q.forceFinished(true);
                        Scroller scroller = CoverMovingView.this.Q;
                        int i18 = v3.x;
                        int i19 = v3.y;
                        scroller.startScroll(0, 0, i18, i19, CoverMovingView.this.u(i18, i19));
                        CoverMovingView.this.postInvalidate();
                    }
                    i3 = 0;
                    i16 = 0;
                    CoverMovingView coverMovingView22 = CoverMovingView.this;
                    Point v36 = coverMovingView22.v(coverMovingView22.W, CoverMovingView.this.X);
                    CoverMovingView.this.Y = 0;
                    CoverMovingView.this.Z = 0;
                    CoverMovingView.this.S.postTranslate(i3, i16);
                    CoverMovingView.this.Q.forceFinished(true);
                    Scroller scroller2 = CoverMovingView.this.Q;
                    int i182 = v36.x;
                    int i192 = v36.y;
                    scroller2.startScroll(0, 0, i182, i192, CoverMovingView.this.u(i182, i192));
                    CoverMovingView.this.postInvalidate();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Point v(int i3, int i16) {
        int nextInt = this.V.nextInt(3);
        Point point = new Point();
        int i17 = this.U;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 == 3) {
                        if (nextInt == 0) {
                            this.U = 1;
                            point.x = i3;
                            point.y = 0;
                        } else if (nextInt == 1) {
                            this.U = 0;
                            point.x = i3;
                            point.y = i16;
                        } else if (nextInt == 2) {
                            this.U = 2;
                            point.x = 0;
                            point.y = i16;
                        }
                    }
                } else if (nextInt == 0) {
                    this.U = 3;
                    point.x = 0;
                    point.y = -i16;
                } else if (nextInt == 1) {
                    this.U = 1;
                    point.x = i3;
                    point.y = -i16;
                } else if (nextInt == 2) {
                    this.U = 0;
                    point.x = i3;
                    point.y = 0;
                }
            } else if (nextInt == 0) {
                this.U = 0;
                point.x = 0;
                point.y = i16;
            } else if (nextInt == 1) {
                this.U = 2;
                point.x = -i3;
                point.y = i16;
            } else if (nextInt == 2) {
                this.U = 3;
                point.x = -i3;
                point.y = 0;
            }
        } else if (nextInt == 0) {
            this.U = 2;
            point.x = -i3;
            point.y = 0;
        } else if (nextInt == 1) {
            this.U = 3;
            point.x = -i3;
            point.y = -i16;
        } else if (nextInt == 2) {
            this.U = 1;
            point.x = 0;
            point.y = -i16;
        }
        return point;
    }

    private void w() {
        Scroller scroller = this.Q;
        if (scroller != null) {
            scroller.forceFinished(true);
        }
    }

    private void x() {
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Matrix y(Drawable drawable, Rect rect) {
        float f16;
        float f17;
        Matrix matrix = new Matrix();
        if (drawable != null && rect != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int width = rect.width();
            int height = rect.height();
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            float f18 = 0.0f;
            if (intrinsicWidth * height > width * intrinsicHeight) {
                f16 = height / intrinsicHeight;
                f18 = (width - (intrinsicWidth * f16)) * 0.5f;
                f17 = 0.0f;
            } else {
                f16 = width / intrinsicWidth;
                f17 = (height - (intrinsicHeight * f16)) * 0.5f;
            }
            matrix.setScale(f16, f16);
            matrix.postTranslate((int) (f18 + 0.5f), (int) (f17 + 0.5f));
        }
        return matrix;
    }

    private void z(Canvas canvas) {
        AlphaAnimation alphaAnimation;
        if (this.J == null || (alphaAnimation = this.N) == null) {
            return;
        }
        if (alphaAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.P)) {
            int alpha = (int) (this.P.getAlpha() * 255.0f);
            canvas.save();
            Matrix matrix = this.T;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            this.J.setAlpha(255 - alpha);
            this.J.draw(canvas);
            this.J.setAlpha(255);
            canvas.restore();
            if (alpha > 0 && this.K != null) {
                canvas.save();
                if (this.S != null) {
                    canvas.concat(this.S);
                }
                this.K.setAlpha(alpha);
                this.K.draw(canvas);
                this.K.setAlpha(255);
                canvas.restore();
            }
            this.f48669b0 = true;
            return;
        }
        if (this.K != null) {
            if (this.S != null) {
                canvas.concat(this.S);
            }
            this.K.setAlpha(255);
            this.K.draw(canvas);
            this.J = this.K;
            this.T = this.S;
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void draw(Canvas canvas) {
        A();
        z(canvas);
        if (this.f48668a0 || this.f48669b0) {
            invalidate();
            this.f48668a0 = false;
            this.f48669b0 = false;
        }
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onCoverSwitch() {
        List<Map<Integer, String>> list;
        int i3;
        if (CoverLog.isColorLevel()) {
            CoverLog.d(TAG, CoverLog.CLR, "onCoverSwitch, thread:" + Thread.currentThread().getName());
        }
        if (!this.D || (list = this.R) == null || (i3 = this.M) < 0 || i3 >= list.size()) {
            return;
        }
        loadPhoto(new LoadPhotoState(this.R.get(this.M).get(1), 0, this));
        this.M = (this.M + 1) % this.R.size();
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onInvisible() {
        super.onInvisible();
        w();
    }

    @Override // com.qzone.proxy.covercomponent.model.PhotoLoadedListener
    public void onLoadSuccess(LoadPhotoState loadPhotoState, Drawable drawable) {
        if (CoverLog.isColorLevel()) {
            CoverLog.d(TAG, CoverLog.CLR, "onLoadSuccess, thread:" + Thread.currentThread().getName());
        }
        this.K = drawable;
        if (this.N == null) {
            this.N = new AlphaAnimation(0.0f, 1.0f);
        }
        this.N.reset();
        this.N.setDuration(1500L);
        this.N.setStartTime(-1L);
        B();
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onPause() {
        super.onPause();
        w();
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onResume() {
        super.onResume();
        x();
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onVisible() {
        super.onVisible();
        x();
    }

    int u(int i3, int i16) {
        if (i3 <= 0) {
            i3 = -i3;
        }
        if (i16 <= 0) {
            i16 = -i16;
        }
        if (i3 <= i16) {
            i3 = i16;
        }
        return (int) (i3 * 40.0f);
    }

    public CoverMovingView(Context context) {
        super(1);
        this.M = -1;
        this.P = new Transformation();
        this.f48668a0 = false;
        this.f48669b0 = false;
        this.f48670c0 = context;
    }

    public boolean init(ArrayList<Map<Integer, String>> arrayList) {
        List<Map<Integer, String>> subList;
        if (arrayList == null) {
            return false;
        }
        if (CoverLog.isColorLevel()) {
            CoverLog.d(TAG, CoverLog.CLR, "init, photo size:" + arrayList.size());
        }
        if (arrayList.size() < 1) {
            return false;
        }
        if (CoverEnv.isWifiConn()) {
            subList = arrayList.subList(0, Math.min(arrayList.size(), 8));
        } else {
            subList = arrayList.subList(0, Math.min(arrayList.size(), 3));
        }
        if (this.R != null && subList.size() == this.R.size()) {
            int i3 = 0;
            while (true) {
                if (i3 >= subList.size()) {
                    i3 = -1;
                    break;
                }
                if (!CoverEnv.equalsWithNullCheck(subList.get(i3).get(1), this.R.get(i3).get(1))) {
                    break;
                }
                i3++;
            }
            if (i3 < 0) {
                if (CoverLog.isColorLevel()) {
                    CoverLog.i(TAG, CoverLog.CLR, "photo has not changed");
                }
                return false;
            }
        }
        this.Q = new Scroller(this.f48670c0, new LinearInterpolator());
        this.S = new Matrix();
        this.T = new Matrix();
        this.V = new Random(System.currentTimeMillis());
        this.J = new ColorDrawable(-16777216);
        this.N = new AlphaAnimation(0.0f, 1.0f);
        this.U = 0;
        this.R = subList;
        if (subList.size() > 1) {
            this.M = 1;
            needCoverSwitch(true);
        } else {
            needCoverSwitch(false);
        }
        int screenWidth = (int) (CoverEnv.getScreenWidth() * 1.3d);
        this.L = new Rect(0, 0, screenWidth, screenWidth);
        int i16 = (int) (screenWidth * 0.2d);
        this.W = i16;
        this.X = i16;
        loadPhoto(new LoadPhotoState(this.R.get(0).get(1), 0, this));
        return true;
    }
}
