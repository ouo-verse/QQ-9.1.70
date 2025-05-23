package com.tencent.biz.qui.quishimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qui.quishimmer.QUIShimmer;
import java.util.Observable;
import java.util.Observer;
import ud0.d;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QUIShimmerEntity {
    private static final String TAG = "QUIShimmerEntity";
    private String mBusinessTag;
    private final Paint mContentPaint;
    private final QUIShimmerDrawable mQUIShimmerDrawable;
    private boolean mShowShimmer;
    private final Observer targetRadiusObserver;
    private OnVisibilityChangeListener visibilityChangeListener;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnVisibilityChangeListener {
        void onVisibilityChanged(View view, int i3);
    }

    public QUIShimmerEntity(View view, Context context) {
        this(view, context, null);
    }

    private QUIShimmerEntity setShimmer(View view, @Nullable QUIShimmer qUIShimmer) {
        QUIShimmerDrawable qUIShimmerDrawable = this.mQUIShimmerDrawable;
        if (qUIShimmerDrawable != null) {
            qUIShimmerDrawable.setShimmer(qUIShimmer);
        } else {
            d.g(this.mBusinessTag, d.f438811e, "setShimmer failed, mQUIShimmerDrawable is null");
        }
        view.setLayerType(2, this.mContentPaint);
        return this;
    }

    private void showShimmerReal(boolean z16, boolean z17) {
        this.mShowShimmer = true;
        shouldShimmingAuto(z17);
        if (z16) {
            startSelfShimmer();
        }
        QUIShimmerDrawable qUIShimmerDrawable = this.mQUIShimmerDrawable;
        if (qUIShimmerDrawable != null) {
            qUIShimmerDrawable.invalidateSelf();
        }
    }

    private void startSelfShimmer() {
        QUIShimmerDrawable qUIShimmerDrawable = this.mQUIShimmerDrawable;
        if (qUIShimmerDrawable != null) {
            qUIShimmerDrawable.startShimmer();
        } else {
            d.g(this.mBusinessTag, d.f438811e, "startShimmer failed, mQUIShimmerDrawable is null");
        }
    }

    public boolean canShimmingAuto() {
        QUIShimmerDrawable qUIShimmerDrawable = this.mQUIShimmerDrawable;
        if (qUIShimmerDrawable != null) {
            return qUIShimmerDrawable.canShimmingAuto();
        }
        return false;
    }

    public void drawLightOnCanvas(Canvas canvas, int[] iArr) {
        if (this.mShowShimmer) {
            if (iArr.length != 2) {
                d.g(this.mBusinessTag, d.f438811e, "view location is null, stop draw");
            } else {
                this.mQUIShimmerDrawable.setLocation(iArr);
                this.mQUIShimmerDrawable.draw(canvas);
            }
        }
    }

    @Nullable
    public QUIShimmer getShimmer() {
        return this.mQUIShimmerDrawable.getShimmer();
    }

    public boolean isShimmerStarted() {
        return this.mQUIShimmerDrawable.isShimmerStarted();
    }

    public boolean isShimmerVisible() {
        return this.mShowShimmer;
    }

    public void onVisibilityChanged(View view, int i3) {
        OnVisibilityChangeListener onVisibilityChangeListener = this.visibilityChangeListener;
        if (onVisibilityChangeListener != null) {
            onVisibilityChangeListener.onVisibilityChanged(view, i3);
        }
    }

    public void removeObserver(QUIShimmerController qUIShimmerController) {
        if (qUIShimmerController == null) {
            return;
        }
        qUIShimmerController.removeObserver(this.targetRadiusObserver);
    }

    public void setAnimationToken(int i3, int i16) {
        QUIShimmerDrawable qUIShimmerDrawable = this.mQUIShimmerDrawable;
        if (qUIShimmerDrawable != null) {
            qUIShimmerDrawable.setAnimationToken(i3, i16);
        } else {
            d.g(this.mBusinessTag, d.f438811e, "setAnimationToken failed, mQUIShimmerDrawable is null");
        }
    }

    public void setBounds(int i3, int i16) {
        this.mQUIShimmerDrawable.setBounds(0, 0, i3, i16);
    }

    public void setBusinessTag(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mBusinessTag = "QUIShimmerEntity/default";
        }
        QUIShimmerDrawable qUIShimmerDrawable = this.mQUIShimmerDrawable;
        if (qUIShimmerDrawable != null) {
            qUIShimmerDrawable.setBusinessTag(str);
        }
    }

    public boolean setController(QUIShimmerController qUIShimmerController) {
        if (qUIShimmerController == null) {
            if (d.h()) {
                d.g(this.mBusinessTag, d.f438811e, "aFloat is error or mQUIShimmerDrawable is null");
            }
            return false;
        }
        Observer observer = this.targetRadiusObserver;
        if (observer != null) {
            qUIShimmerController.addObserver(observer);
            return true;
        }
        d.g(this.mBusinessTag, d.f438811e, "targetRadiusObserver is null");
        return false;
    }

    public void setOnVisibilityChangeListener(OnVisibilityChangeListener onVisibilityChangeListener) {
        this.visibilityChangeListener = onVisibilityChangeListener;
    }

    public void shouldShimmingAuto(boolean z16) {
        QUIShimmerDrawable qUIShimmerDrawable = this.mQUIShimmerDrawable;
        if (qUIShimmerDrawable != null) {
            qUIShimmerDrawable.shouldShimmingAuto(z16);
        }
    }

    public void startShimmer(QUIShimmerController qUIShimmerController) {
        if (setController(qUIShimmerController)) {
            startShimmerByController();
        } else {
            startShimmerByBusiness();
        }
    }

    public void startShimmerByBusiness() {
        showShimmerReal(true, true);
    }

    public void startShimmerByController() {
        showShimmerReal(false, false);
    }

    public void stopShimmer(QUIShimmerController qUIShimmerController) {
        removeObserver(qUIShimmerController);
        QUIShimmerDrawable qUIShimmerDrawable = this.mQUIShimmerDrawable;
        if (qUIShimmerDrawable != null) {
            qUIShimmerDrawable.stopShimmer();
            this.mQUIShimmerDrawable.invalidateSelf();
        }
        this.mShowShimmer = false;
    }

    public void updateAnimatorRepeatCount(int i3) {
        QUIShimmerDrawable qUIShimmerDrawable = this.mQUIShimmerDrawable;
        if (qUIShimmerDrawable != null) {
            qUIShimmerDrawable.updateAnimatorRepeatCount(i3);
        }
    }

    public void updateColors(int i3, int i16, int i17, int i18) {
        QUIShimmerDrawable qUIShimmerDrawable = this.mQUIShimmerDrawable;
        if (qUIShimmerDrawable != null) {
            qUIShimmerDrawable.updateColors(i3, i16, i17, i18);
        }
    }

    public void updateXfermode(PorterDuff.Mode mode) {
        QUIShimmerDrawable qUIShimmerDrawable = this.mQUIShimmerDrawable;
        if (qUIShimmerDrawable != null) {
            qUIShimmerDrawable.updateXfermode(mode);
        } else {
            d.g(this.mBusinessTag, d.f438811e, "updateXfermode mQUIShimmerDrawable is null");
        }
    }

    public boolean verifyDrawable(@NonNull Drawable drawable) {
        if (drawable == this.mQUIShimmerDrawable) {
            return true;
        }
        return false;
    }

    public QUIShimmerEntity(View view, Context context, AttributeSet attributeSet) {
        this(view, context, attributeSet, 0);
    }

    public QUIShimmerEntity(View view, Context context, AttributeSet attributeSet, int i3) {
        this.mContentPaint = new Paint();
        QUIShimmerDrawable qUIShimmerDrawable = new QUIShimmerDrawable();
        this.mQUIShimmerDrawable = qUIShimmerDrawable;
        this.mShowShimmer = true;
        this.mBusinessTag = "QUIShimmerEntity/default";
        this.targetRadiusObserver = new Observer() { // from class: com.tencent.biz.qui.quishimmer.QUIShimmerEntity.1
            @Override // java.util.Observer
            public void update(Observable observable, Object obj) {
                if (!(obj instanceof Float)) {
                    d.g(QUIShimmerEntity.this.mBusinessTag, d.f438811e, "targetRadiusObserver must be float");
                    return;
                }
                Float f16 = (Float) obj;
                if (f16 != null && f16.floatValue() > 0.0f && QUIShimmerEntity.this.mQUIShimmerDrawable != null) {
                    QUIShimmerEntity.this.mQUIShimmerDrawable.updateRadius(f16.floatValue());
                    QUIShimmerEntity.this.mQUIShimmerDrawable.invalidateSelf();
                } else {
                    d.g(QUIShimmerEntity.this.mBusinessTag, d.f438811e, "aFloat is error or mQUIShimmerDrawable is null");
                }
            }
        };
        this.visibilityChangeListener = null;
        if (view != null && context != null) {
            view.setWillNotDraw(false);
            qUIShimmerDrawable.setCallback(view);
            if (attributeSet == null) {
                setShimmer(view, new QUIShimmer.ColorHighlightBuilder().initAttributes().build());
                return;
            }
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
            try {
                setShimmer(view, new QUIShimmer.ColorHighlightBuilder().consumeAttributes(obtainStyledAttributes).build());
                return;
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        d.g(this.mBusinessTag, d.f438811e, "hostView is null or context is null");
    }
}
