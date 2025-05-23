package com.qzone.module.covercomponent.ui;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
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
public class CoverJigsawView extends CoverBaseView implements PhotoLoadedListener {
    public static final int MIN_PHOTO_NUM = 3;
    public static final String TAG = "CoverJigsawView";
    private volatile Drawable J;
    private volatile Drawable K;
    private volatile Drawable L;
    private volatile Drawable M;
    private volatile Drawable N;
    private volatile Drawable P;
    private Rect Q;
    private Rect R;
    private Rect S;
    private Matrix T;
    private Matrix U;
    private Matrix V;
    private Matrix W;
    private Matrix X;
    private Matrix Y;
    private AlphaAnimation Z;

    /* renamed from: a0, reason: collision with root package name */
    private AlphaAnimation f48660a0;

    /* renamed from: b0, reason: collision with root package name */
    private AlphaAnimation f48661b0;

    /* renamed from: c0, reason: collision with root package name */
    private Transformation f48662c0;

    /* renamed from: d0, reason: collision with root package name */
    private Random f48663d0;

    /* renamed from: e0, reason: collision with root package name */
    private List<Map<Integer, String>> f48664e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f48665f0;

    /* renamed from: g0, reason: collision with root package name */
    private int[] f48666g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f48667h0;

    private Matrix i(Drawable drawable, Rect rect) {
        float f16;
        float f17;
        Matrix matrix = new Matrix();
        try {
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
        } catch (Exception e16) {
            CoverLog.w(TAG, "cropDrawable error", e16);
        }
        return matrix;
    }

    private void j(Canvas canvas) {
        AlphaAnimation alphaAnimation;
        if (this.M == null || (alphaAnimation = this.Z) == null) {
            return;
        }
        if (alphaAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.f48662c0)) {
            int alpha = (int) (this.f48662c0.getAlpha() * 255.0f);
            canvas.save();
            canvas.clipRect(this.Q);
            Matrix matrix = this.W;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            this.M.setAlpha(255 - alpha);
            this.M.draw(canvas);
            this.M.setAlpha(255);
            canvas.restore();
            if (alpha > 0 && this.J != null) {
                canvas.save();
                canvas.clipRect(this.Q);
                Matrix matrix2 = this.T;
                if (matrix2 != null) {
                    canvas.concat(matrix2);
                }
                this.J.setAlpha(alpha);
                this.J.draw(canvas);
                this.J.setAlpha(255);
                canvas.restore();
            }
            postInvalidate();
            return;
        }
        if (this.J != null) {
            canvas.save();
            canvas.clipRect(this.Q);
            Matrix matrix3 = this.T;
            if (matrix3 != null) {
                canvas.concat(matrix3);
            }
            this.J.setAlpha(255);
            this.J.draw(canvas);
            canvas.restore();
            this.M = this.J;
            this.W = this.T;
        }
    }

    private void k(Canvas canvas) {
        AlphaAnimation alphaAnimation;
        if (this.P == null || (alphaAnimation = this.f48661b0) == null) {
            return;
        }
        if (alphaAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.f48662c0)) {
            int alpha = (int) (this.f48662c0.getAlpha() * 255.0f);
            canvas.save();
            canvas.clipRect(this.S);
            Rect rect = this.S;
            canvas.translate(rect.left, rect.top);
            Matrix matrix = this.Y;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            this.P.setAlpha(255 - alpha);
            this.P.draw(canvas);
            this.P.setAlpha(255);
            canvas.restore();
            if (alpha > 0 && this.L != null) {
                canvas.save();
                canvas.clipRect(this.S);
                Rect rect2 = this.S;
                canvas.translate(rect2.left, rect2.top);
                Matrix matrix2 = this.V;
                if (matrix2 != null) {
                    canvas.concat(matrix2);
                }
                this.L.setAlpha(alpha);
                this.L.draw(canvas);
                this.L.setAlpha(255);
                canvas.restore();
            }
            postInvalidate();
            return;
        }
        if (this.L != null) {
            canvas.save();
            canvas.clipRect(this.S);
            Rect rect3 = this.S;
            canvas.translate(rect3.left, rect3.top);
            Matrix matrix3 = this.V;
            if (matrix3 != null) {
                canvas.concat(matrix3);
            }
            this.L.setAlpha(255);
            this.L.draw(canvas);
            canvas.restore();
            this.P = this.L;
            this.Y = this.V;
        }
    }

    private void l(Canvas canvas) {
        AlphaAnimation alphaAnimation;
        if (this.N == null || (alphaAnimation = this.f48660a0) == null) {
            return;
        }
        if (alphaAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.f48662c0)) {
            int alpha = (int) (this.f48662c0.getAlpha() * 255.0f);
            canvas.save();
            canvas.clipRect(this.R);
            Rect rect = this.R;
            canvas.translate(rect.left, rect.top);
            Matrix matrix = this.X;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            this.N.setAlpha(255 - alpha);
            this.N.draw(canvas);
            this.N.setAlpha(255);
            canvas.restore();
            if (alpha > 0 && this.K != null) {
                canvas.save();
                canvas.clipRect(this.R);
                Rect rect2 = this.R;
                canvas.translate(rect2.left, rect2.top);
                Matrix matrix2 = this.U;
                if (matrix2 != null) {
                    canvas.concat(matrix2);
                }
                this.K.setAlpha(alpha);
                this.K.draw(canvas);
                this.K.setAlpha(255);
                canvas.restore();
            }
            postInvalidate();
            return;
        }
        if (this.K != null) {
            canvas.save();
            canvas.clipRect(this.R);
            Rect rect3 = this.R;
            canvas.translate(rect3.left, rect3.top);
            Matrix matrix3 = this.U;
            if (matrix3 != null) {
                canvas.concat(matrix3);
            }
            this.K.setAlpha(255);
            this.K.draw(canvas);
            canvas.restore();
            this.N = this.K;
            this.X = this.U;
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void draw(Canvas canvas) {
        j(canvas);
        l(canvas);
        k(canvas);
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onCoverSwitch() {
        List<Map<Integer, String>> list;
        int i3;
        int[] iArr;
        if (!this.D || (list = this.f48664e0) == null || list.size() <= 0 || (i3 = this.f48665f0) < 0 || i3 >= this.f48664e0.size()) {
            return;
        }
        int i16 = this.f48665f0;
        boolean z16 = false;
        do {
            try {
                if (i16 >= this.f48664e0.size()) {
                    i16 %= this.f48664e0.size();
                }
                iArr = this.f48666g0;
                if (i16 == iArr[0] || i16 == iArr[1] || i16 == iArr[2]) {
                    i16++;
                } else {
                    z16 = true;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        } while (!z16);
        iArr[this.f48667h0] = i16;
        loadPhoto(new LoadPhotoState(this.f48664e0.get(i16).get(1), this.f48667h0, this));
        this.f48665f0 = (i16 + 1) % this.f48664e0.size();
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onDestroy() {
        super.onDestroy();
        this.f48664e0 = null;
    }

    @Override // com.qzone.proxy.covercomponent.model.PhotoLoadedListener
    public synchronized void onLoadSuccess(LoadPhotoState loadPhotoState, Drawable drawable) {
        if (CoverLog.isColorLevel()) {
            CoverLog.d(TAG, CoverLog.CLR, "onLoadSuccess, mDrawIndex:" + this.f48667h0 + ", thread:" + Thread.currentThread().getName());
        }
        int i3 = loadPhotoState.orientation;
        if (i3 == 0) {
            this.J = drawable;
            this.T = i(this.J, this.Q);
            this.Z.reset();
            this.Z.setDuration(1500L);
            this.Z.setStartTime(-1L);
        } else if (i3 == 1) {
            this.K = drawable;
            this.U = i(this.K, this.R);
            this.f48660a0.reset();
            this.f48660a0.setDuration(1500L);
            this.f48660a0.setStartTime(-1L);
        } else if (i3 == 2) {
            this.L = drawable;
            this.V = i(this.L, this.S);
            this.f48661b0.reset();
            this.f48661b0.setDuration(1500L);
            this.f48661b0.setStartTime(-1L);
        }
        if (this.f48663d0 == null) {
            this.f48663d0 = new Random(CoverEnv.getLoginUin());
        }
        this.f48667h0 = this.f48663d0.nextInt(3);
        postInvalidate();
    }

    public CoverJigsawView() {
        super(2);
        this.f48662c0 = new Transformation();
        this.f48665f0 = -1;
        this.f48667h0 = 0;
    }

    public boolean init(ArrayList<Map<Integer, String>> arrayList) {
        List<Map<Integer, String>> subList;
        if (arrayList == null) {
            return false;
        }
        if (CoverLog.isColorLevel()) {
            CoverLog.d(TAG, CoverLog.CLR, "init, photo size:" + arrayList.size());
        }
        if (arrayList.size() < 3) {
            return false;
        }
        if (CoverEnv.isWifiConn()) {
            subList = arrayList.subList(0, Math.min(arrayList.size(), 8));
        } else {
            subList = arrayList.subList(0, Math.min(arrayList.size(), 3));
        }
        if (this.f48664e0 != null && subList.size() == this.f48664e0.size()) {
            int i3 = 0;
            while (true) {
                if (i3 >= subList.size()) {
                    i3 = -1;
                    break;
                }
                if (!CoverEnv.equalsWithNullCheck(subList.get(i3).get(1), this.f48664e0.get(i3).get(1))) {
                    break;
                }
                i3++;
            }
            if (i3 < 0) {
                if (CoverLog.isColorLevel()) {
                    CoverLog.d(TAG, CoverLog.CLR, "photo has not changed");
                }
                return false;
            }
        }
        this.M = new ColorDrawable(-16777216);
        this.N = new ColorDrawable(-16777216);
        this.P = new ColorDrawable(-16777216);
        this.Z = new AlphaAnimation(0.0f, 1.0f);
        this.f48660a0 = new AlphaAnimation(0.0f, 1.0f);
        this.f48661b0 = new AlphaAnimation(0.0f, 1.0f);
        this.f48664e0 = subList;
        if (subList.size() > 3) {
            needCoverSwitch(true);
            this.f48665f0 = 3;
        } else {
            needCoverSwitch(false);
        }
        this.f48666g0 = new int[]{0, 1, 2};
        int screenWidth = CoverEnv.getScreenWidth();
        int i16 = (int) (screenWidth * 0.618d);
        int i17 = screenWidth >> 1;
        this.Q = new Rect(0, 0, i16, screenWidth);
        int i18 = i16 + 4;
        this.R = new Rect(i18, 0, screenWidth, i17);
        this.S = new Rect(i18, i17 + 4, screenWidth, screenWidth);
        loadPhoto(new LoadPhotoState(this.f48664e0.get(0).get(1), 0, this));
        int i19 = this.f48664e0.size() > 3 ? 1 : 2;
        loadPhoto(new LoadPhotoState(this.f48664e0.get(1).get(Integer.valueOf(i19)), 1, this));
        loadPhoto(new LoadPhotoState(this.f48664e0.get(2).get(Integer.valueOf(i19)), 2, this));
        return true;
    }
}
