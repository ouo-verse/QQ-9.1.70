package com.tencent.biz.qqstory.boundaries.extension.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;
import com.tencent.biz.qqstory.takevideo.a;
import hd0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TrimTextureVideoView extends com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView {

    /* renamed from: w0, reason: collision with root package name */
    protected Matrix f93993w0;

    /* renamed from: x0, reason: collision with root package name */
    protected boolean f93994x0;

    public TrimTextureVideoView(Context context) {
        super(context);
        this.f93994x0 = true;
    }

    private float w(int i3, int i16) {
        return Math.max(1.0f / a.a(getResources()), (Math.min(i16, i3) * 1.0f) / Math.max(i16, i3));
    }

    private Matrix x(int i3, int i16, int i17, int i18) {
        Matrix matrix = new Matrix();
        float f16 = i3;
        float f17 = i17;
        float f18 = f16 / f17;
        float f19 = i16;
        float f26 = i18;
        float f27 = f19 / f26;
        matrix.preTranslate((i3 - i17) / 2.0f, (i16 - i18) / 2.0f);
        matrix.preScale(f17 / f16, f26 / f19);
        if (f18 >= f27) {
            matrix.postScale(f27, f27, i3 / 2, i16 / 2);
        } else {
            matrix.postScale(f18, f18, i3 / 2, i16 / 2);
        }
        return matrix;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007b, code lost:
    
        if (r1 > r6) goto L38;
     */
    @Override // com.tencent.biz.qqstory.playvideo.player.TextureVideoView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i3, int i16) {
        int i17;
        super.onMeasure(i3, i16);
        int defaultSize = View.getDefaultSize(this.E, i3);
        int defaultSize2 = View.getDefaultSize(this.F, i16);
        if (this.E > 0 && this.F > 0) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i16);
            int size2 = View.MeasureSpec.getSize(i16);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i18 = this.E;
                int i19 = i18 * size2;
                int i26 = this.F;
                if (i19 < size * i26) {
                    if (this.U) {
                        defaultSize = (i18 * size2) / i26;
                        defaultSize2 = size2;
                    } else {
                        defaultSize2 = (i26 * size) / i18;
                        defaultSize = size;
                    }
                } else if (i18 * size2 > size * i26 && this.f93994x0) {
                    if (this.U) {
                        defaultSize2 = (i26 * size) / i18;
                        defaultSize = size;
                    } else {
                        defaultSize = (i18 * size2) / i26;
                        defaultSize2 = size2;
                    }
                } else {
                    if (!this.f93994x0) {
                        super.setMeasuredDimension(size, size2);
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            } else if (mode == 1073741824) {
                int i27 = (this.F * size) / this.E;
                if (mode2 != Integer.MIN_VALUE || i27 <= size2) {
                    defaultSize2 = i27;
                    defaultSize = size;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else {
                if (mode2 == 1073741824) {
                    i17 = (this.E * size2) / this.F;
                    if (mode == Integer.MIN_VALUE) {
                    }
                } else {
                    int i28 = this.E;
                    int i29 = this.F;
                    if (mode2 == Integer.MIN_VALUE && i29 > size2) {
                        i17 = (size2 * i28) / i29;
                    } else {
                        i17 = i28;
                        size2 = i29;
                    }
                    if (mode == Integer.MIN_VALUE && i17 > size) {
                        defaultSize2 = (i29 * size) / i28;
                        defaultSize = size;
                    }
                }
                defaultSize = i17;
                defaultSize2 = size2;
            }
        }
        super.setMeasuredDimension(defaultSize, defaultSize2);
    }

    @TargetApi(14)
    public boolean v(int i3, int i16, int i17) {
        int i18;
        if (this.f94119q0 && MediaPlayer.i()) {
            i18 = i3 + 0;
        } else {
            i18 = 0;
        }
        int i19 = i3 % 180;
        if (i19 > 0 && i16 < i17) {
            setRotation(i18 + 90);
            float w3 = w(i16, i17);
            setScaleX(w3);
            setScaleY(w3);
            c.d(this.f94090d, "adjustRotation([rotation]%d, [width]%d, [height]%d), need rotate!", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return true;
        }
        if (i19 == 0 && i16 > i17) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i26 = displayMetrics.widthPixels;
            int i27 = displayMetrics.heightPixels;
            Matrix matrix = this.f93993w0;
            if (matrix == null) {
                this.f93993w0 = new Matrix();
            } else {
                matrix.reset();
            }
            this.f93994x0 = false;
            Matrix x16 = x(i26, i27, i16, i17);
            this.f93993w0 = x16;
            setTransform(x16);
            c.d(this.f94090d, "adjustRotation([rotation]%d, [width]%d, [height]%d), no need rotate but need scale!", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return false;
        }
        if (i18 != 0) {
            setRotation(i18);
            float w16 = w(i16, i17);
            setScaleX(w16);
            setScaleY(w16);
            c.d(this.f94090d, "adjustRotation([rotation]%d, [width]%d, [height]%d), need rotate! but return false", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return false;
        }
        if (i16 == i17) {
            DisplayMetrics displayMetrics2 = getResources().getDisplayMetrics();
            int i28 = displayMetrics2.widthPixels;
            int i29 = displayMetrics2.heightPixels;
            Matrix matrix2 = this.f93993w0;
            if (matrix2 == null) {
                this.f93993w0 = new Matrix();
            } else {
                matrix2.reset();
            }
            this.f93994x0 = false;
            Matrix x17 = x(i28, i29, i16, i17);
            this.f93993w0 = x17;
            setTransform(x17);
            c.d(this.f94090d, "adjustRotation([rotation]%d, [width]%d, [height]%d), no need rotate but need scale!", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return false;
        }
        c.d(this.f94090d, "adjustRotation([rotation]%d, [width]%d, [height]%d), no need rotate!", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        return false;
    }

    public TrimTextureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f93994x0 = true;
    }

    public TrimTextureVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93994x0 = true;
    }
}
