package com.qq.e.tg.nativ;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.mtt.hippy.dom.node.NodeProps;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class MediaView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f40537a;

    /* renamed from: b, reason: collision with root package name */
    private int f40538b;

    public MediaView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NewApi"})
    protected final void onAttachedToWindow() {
        GDTLogger.d(NodeProps.ON_ATTACHED_TO_WINDOW);
        super.onAttachedToWindow();
        if (!isHardwareAccelerated()) {
            GDTLogger.e("Hardware acceleration is off");
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i3, int i16) {
        if ((SDKStatus.getSDKVersionCode() == 11 || SDKStatus.getSDKVersionCode() == 12) && this.f40537a > 0 && this.f40538b > 0) {
            int size = View.MeasureSpec.getSize(i3);
            int size2 = View.MeasureSpec.getSize(i16);
            int i17 = this.f40538b;
            int i18 = size * i17;
            int i19 = this.f40537a;
            if (i18 >= i19 * size2 && size2 != 0) {
                if (size * i17 <= i19 * size2 && size != 0) {
                    i3 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                } else {
                    i3 = View.MeasureSpec.makeMeasureSpec((i19 * size2) / i17, 1073741824);
                }
                i16 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
            } else {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                i16 = View.MeasureSpec.makeMeasureSpec((size * this.f40538b) / this.f40537a, 1073741824);
                i3 = makeMeasureSpec;
            }
        }
        super.onMeasure(i3, i16);
    }

    public final void setRatio(int i3, int i16) {
        this.f40537a = i3;
        this.f40538b = i16;
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
