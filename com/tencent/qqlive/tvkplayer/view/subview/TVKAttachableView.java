package com.tencent.qqlive.tvkplayer.view.subview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKAttachableView extends FrameLayout {
    private int mVideoHeight;
    private int mVideoWidth;

    public TVKAttachableView(@NonNull Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            int size = View.MeasureSpec.getSize(i3);
            int size2 = View.MeasureSpec.getSize(i16);
            int i17 = this.mVideoWidth;
            int i18 = i17 * size2;
            int i19 = this.mVideoHeight;
            if (i18 > size * i19) {
                size2 = (i19 * size) / i17;
            } else {
                size = (i17 * size2) / i19;
            }
            try {
                setMeasuredDimension(size, size2);
                measureChildren(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
                return;
            } catch (Exception unused) {
                super.onMeasure(i3, i16);
                return;
            }
        }
        super.onMeasure(i3, i16);
    }

    public void setFixedSize(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            if (i3 != this.mVideoWidth || i16 != this.mVideoHeight) {
                this.mVideoWidth = i3;
                this.mVideoHeight = i16;
                TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.view.subview.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        TVKAttachableView.this.requestLayout();
                    }
                });
            }
        }
    }
}
