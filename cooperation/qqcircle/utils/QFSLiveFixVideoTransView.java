package cooperation.qqcircle.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.qcircle_impl.R$styleable;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QFSLiveFixVideoTransView extends SurfaceView {
    private static final String GUILD_LIVE_BG_COLOR = "#171718";
    private static final String TAG = "QFSLiveFixVideoTransView";

    @ColorInt
    private final int bgColor;
    private SurfaceHolderCallback mSurfaceHolderCallback;

    public QFSLiveFixVideoTransView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawBackground(SurfaceHolder surfaceHolder) {
        try {
            Canvas lockCanvas = surfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                lockCanvas.drawColor(this.bgColor);
                surfaceHolder.unlockCanvasAndPost(lockCanvas);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SurfaceHolder holder = getHolder();
        if (holder != null) {
            holder.addCallback(this.mSurfaceHolderCallback);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SurfaceHolder holder = getHolder();
        if (holder != null) {
            holder.removeCallback(this.mSurfaceHolderCallback);
        }
    }

    public QFSLiveFixVideoTransView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSLiveFixVideoTransView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.QFSLiveFixVideoTransView);
        this.bgColor = obtainStyledAttributes.getColor(R$styleable.QFSLiveFixVideoTransView_bg_color, Color.parseColor(GUILD_LIVE_BG_COLOR));
        obtainStyledAttributes.recycle();
        this.mSurfaceHolderCallback = new SurfaceHolderCallback(this);
        SurfaceHolder holder = getHolder();
        if (holder != null) {
            holder.setFormat(-2);
            holder.addCallback(this.mSurfaceHolderCallback);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static class SurfaceHolderCallback implements SurfaceHolder.Callback {
        private final WeakReference<QFSLiveFixVideoTransView> mLiveFixVideoTransWeak;

        public SurfaceHolderCallback(QFSLiveFixVideoTransView qFSLiveFixVideoTransView) {
            this.mLiveFixVideoTransWeak = new WeakReference<>(qFSLiveFixVideoTransView);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
            QFSLiveFixVideoTransView qFSLiveFixVideoTransView = this.mLiveFixVideoTransWeak.get();
            if (qFSLiveFixVideoTransView != null) {
                qFSLiveFixVideoTransView.drawBackground(surfaceHolder);
            } else {
                QLog.e(QFSLiveFixVideoTransView.TAG, 1, "[surfaceChanged] trans view should not be null.");
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            QFSLiveFixVideoTransView qFSLiveFixVideoTransView = this.mLiveFixVideoTransWeak.get();
            if (qFSLiveFixVideoTransView != null) {
                qFSLiveFixVideoTransView.drawBackground(surfaceHolder);
            } else {
                QLog.e(QFSLiveFixVideoTransView.TAG, 1, "[surfaceCreated] trans view should not be null.");
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        }
    }
}
