package com.tencent.av.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AutoFitTextureView extends TextureView {

    /* renamed from: d, reason: collision with root package name */
    private int f73480d;

    /* renamed from: e, reason: collision with root package name */
    private int f73481e;

    public AutoFitTextureView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        super.onMeasure(i3, i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int i18 = this.f73480d;
        if (i18 != 0 && (i17 = this.f73481e) != 0) {
            if (size > (size2 * i18) / i17) {
                setMeasuredDimension(size, (i17 * size) / i18);
                return;
            } else {
                setMeasuredDimension((i18 * size2) / i17, size2);
                return;
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setAspectRatio(int i3, int i16) {
        if (i3 >= 0 && i16 >= 0) {
            this.f73480d = i3;
            this.f73481e = i16;
            requestLayout();
            return;
        }
        QLog.e("AutoFitTextureView", 1, "setAspectRatio with illegal argument");
    }

    public AutoFitTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoFitTextureView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f73480d = 0;
        this.f73481e = 0;
    }
}
