package com.tencent.component.media.image.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AspectAsyncImageView extends AsyncImageView {
    public AspectAsyncImageView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b3  */
    @Override // com.tencent.component.media.image.view.ExtendImageView, android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i3, int i16) {
        int intrinsicWidth;
        int intrinsicHeight;
        boolean z16;
        boolean z17;
        float f16;
        AspectAsyncImageView aspectAsyncImageView;
        int i17;
        int i18;
        boolean z18;
        int i19;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        Drawable drawable = getDrawable();
        if (drawable == null) {
            f16 = 0.0f;
            z16 = false;
            z17 = false;
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        } else {
            intrinsicWidth = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
            if (mode != 1073741824) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (mode2 != 1073741824) {
                z17 = true;
            } else {
                z17 = false;
            }
            f16 = intrinsicWidth / intrinsicHeight;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        if (!z16 && !z17) {
            int max = Math.max(intrinsicWidth + paddingLeft + paddingRight, getSuggestedMinimumWidth());
            int max2 = Math.max(intrinsicHeight + paddingTop + paddingBottom, getSuggestedMinimumHeight());
            i18 = View.resolveSize(max, i3);
            i17 = View.resolveSize(max2, i16);
        } else {
            int resolveSize = View.resolveSize(intrinsicWidth + paddingLeft + paddingRight, i3);
            int resolveSize2 = View.resolveSize(intrinsicHeight + paddingTop + paddingBottom, i16);
            if (f16 != 0.0f) {
                float f17 = (resolveSize2 - paddingTop) - paddingBottom;
                if (Math.abs((((resolveSize - paddingLeft) - paddingRight) / f17) - f16) > 1.0E-7d) {
                    if (z16) {
                        int i26 = ((int) (f17 * f16)) + paddingLeft + paddingRight;
                        if (z17) {
                            resolveSize = View.resolveSize(i26, i3);
                        }
                        if (i26 <= resolveSize) {
                            resolveSize = i26;
                            z18 = true;
                            if (!z18 && z17) {
                                i19 = ((int) (((resolveSize - paddingLeft) - paddingRight) / f16)) + paddingTop + paddingBottom;
                                if (!z16) {
                                    resolveSize2 = View.resolveSize(i19, i16);
                                }
                                if (i19 <= resolveSize2) {
                                    i17 = i19;
                                    i18 = resolveSize;
                                }
                            }
                        }
                    }
                    z18 = false;
                    if (!z18) {
                        i19 = ((int) (((resolveSize - paddingLeft) - paddingRight) / f16)) + paddingTop + paddingBottom;
                        if (!z16) {
                        }
                        if (i19 <= resolveSize2) {
                        }
                    }
                }
                i17 = resolveSize2;
                i18 = resolveSize;
            } else {
                aspectAsyncImageView = this;
                i17 = resolveSize2;
                i18 = resolveSize;
                aspectAsyncImageView.setMeasuredDimension(i18, i17);
            }
        }
        aspectAsyncImageView = this;
        aspectAsyncImageView.setMeasuredDimension(i18, i17);
    }

    public AspectAsyncImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AspectAsyncImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
