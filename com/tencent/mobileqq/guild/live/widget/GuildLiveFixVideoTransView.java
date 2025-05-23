package com.tencent.mobileqq.guild.live.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.ColorInt;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildLiveFixVideoTransView extends SurfaceView {

    /* renamed from: d, reason: collision with root package name */
    @ColorInt
    private final int f227011d;

    public GuildLiveFixVideoTransView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SurfaceHolder surfaceHolder) {
        try {
            Canvas lockCanvas = surfaceHolder.lockCanvas();
            if (lockCanvas != null) {
                lockCanvas.drawColor(this.f227011d);
                surfaceHolder.unlockCanvasAndPost(lockCanvas);
            }
        } catch (Exception unused) {
        }
    }

    public GuildLiveFixVideoTransView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildLiveFixVideoTransView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.f439556k4);
        this.f227011d = obtainStyledAttributes.getColor(up1.a.f439568l4, Color.parseColor("#171718"));
        obtainStyledAttributes.recycle();
        getHolder().setFormat(-2);
        getHolder().addCallback(new a());
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements SurfaceHolder.Callback {
        a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
            QLog.i("QGL.GuildLiveFixVideoTransView", 1, "surfaceChanged, width:" + i16 + " height:" + i17);
            GuildLiveFixVideoTransView.this.b(surfaceHolder);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            GuildLiveFixVideoTransView.this.b(surfaceHolder);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }
    }
}
