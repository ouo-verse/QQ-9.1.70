package com.tenpay.sdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;
import com.tenpay.util.Utils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QQVideoView extends VideoView {
    private int mVideoHeight;
    private int mVideoWidth;

    public QQVideoView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mVideoWidth = Utils.getScreenWidth(context);
        this.mVideoHeight = Utils.getScreenHeight(context);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        setMeasuredDimension(this.mVideoWidth, this.mVideoHeight);
    }

    public void release() {
        setOnPreparedListener(null);
        setOnErrorListener(null);
        setOnCompletionListener(null);
    }

    public void setDimension(int i3, int i16) {
        if (this.mVideoWidth > 0) {
            this.mVideoWidth = i3;
        }
        if (this.mVideoHeight > 0) {
            this.mVideoHeight = i16;
        }
    }

    public QQVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public QQVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init(context);
    }
}
