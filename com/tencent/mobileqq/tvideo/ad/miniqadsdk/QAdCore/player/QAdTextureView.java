package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.qqlive.playerinterface.IQAdPlayerView;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdTextureView extends TextureView implements IQAdPlayerView {
    private static final String E = b.d(QAdTextureView.class.getSimpleName());
    public static WeakHashMap<TextureView, Integer> F = new WeakHashMap<>();
    private AtomicBoolean C;
    private TextureView.SurfaceTextureListener D;

    /* renamed from: d, reason: collision with root package name */
    private boolean f303854d;

    /* renamed from: e, reason: collision with root package name */
    private int f303855e;

    /* renamed from: f, reason: collision with root package name */
    private int f303856f;

    /* renamed from: h, reason: collision with root package name */
    private int f303857h;

    /* renamed from: i, reason: collision with root package name */
    private volatile com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.a f303858i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f303859m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
            if (!QAdTextureView.this.C.get()) {
                QAdTextureView.this.f303854d = true;
                if (QAdTextureView.this.f303858i != null) {
                    QAdTextureView.this.f303858i.onViewCreated(surfaceTexture, i3, i16);
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            QAdTextureView.this.f303854d = false;
            if (QAdTextureView.this.f303858i != null) {
                QAdTextureView.this.f303858i.onViewDestroyed(surfaceTexture);
                return true;
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
            if (!QAdTextureView.this.C.get() && QAdTextureView.this.f303858i != null) {
                QAdTextureView.this.f303858i.onViewChanged(surfaceTexture, i3, i16);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (!QAdTextureView.this.C.get() && QAdTextureView.this.f303858i != null) {
                QAdTextureView.this.f303858i.onViewChanged(surfaceTexture, QAdTextureView.this.getWidth(), QAdTextureView.this.getHeight());
            }
        }
    }

    public QAdTextureView(Context context, int i3) {
        super(context);
        this.f303854d = false;
        this.f303857h = 0;
        this.f303859m = true;
        this.D = new a();
        k(i3);
    }

    public static void j(TextureView textureView, int i3) {
        F.put(textureView, Integer.valueOf(i3));
    }

    private void k(int i3) {
        j(this, i3);
        this.C = new AtomicBoolean(false);
        setOpaque(false);
        setAlpha(0.0f);
        setScaleX(1.0001f);
        setScaleY(1.0001f);
        setSurfaceTextureListener(this.D);
    }

    private void l() {
        if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            if (this.f303859m) {
                ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = 0;
            } else {
                n.g(E, "onMeasure: not reset player topMargin: " + this.f303859m);
            }
            ((ViewGroup.MarginLayoutParams) getLayoutParams()).bottomMargin = 0;
        }
    }

    @Override // com.tencent.qqlive.playerinterface.IQAdPlayerView
    public void a(boolean z16) {
        n.e(E, "[notifyTextureView]QAdTextureView \u8bbe\u7f6eTextureView");
        this.f303859m = !z16;
    }

    @Override // com.tencent.qqlive.playerinterface.IQAdPlayerView
    public boolean b() {
        return this.f303854d;
    }

    @Override // com.tencent.qqlive.playerinterface.IQAdPlayerView
    public Object c() {
        return getSurfaceTexture();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int defaultSize = View.getDefaultSize(this.f303855e, i3);
        int defaultSize2 = View.getDefaultSize(this.f303856f, i16);
        if (this.f303855e > 0 && this.f303856f > 0) {
            l();
            int i17 = this.f303857h;
            if (i17 == 2) {
                int i18 = this.f303855e;
                int i19 = i18 * defaultSize2;
                int i26 = this.f303856f;
                if (i19 > defaultSize * i26) {
                    defaultSize = (i18 * defaultSize2) / i26;
                } else if (i18 * defaultSize2 < defaultSize * i26) {
                    defaultSize2 = (i26 * defaultSize) / i18;
                }
            } else if (i17 != 1) {
                int i27 = this.f303855e;
                int i28 = i27 * defaultSize2;
                int i29 = this.f303856f;
                if (i28 > defaultSize * i29) {
                    defaultSize2 = (i29 * defaultSize) / i27;
                } else if (i28 < defaultSize * i29) {
                    defaultSize = i28 / i29;
                }
            }
            n.g(E, "onMeasure 2, setMeasuredDimension:width = " + defaultSize + ", height = " + defaultSize2 + ", mVideoWidth = " + this.f303855e + ", mVideoHeight = " + this.f303856f);
            setMeasuredDimension(defaultSize, defaultSize2);
            return;
        }
        super.onMeasure(i3, i16);
    }

    @Override // com.tencent.qqlive.playerinterface.IQAdPlayerView
    public void setOpaqueInfo(boolean z16) {
        if (z16) {
            setOpaque(true);
            setAlpha(1.0f);
        } else {
            setOpaque(false);
            setAlpha(0.0f);
        }
    }

    @Override // com.tencent.qqlive.playerinterface.IQAdPlayerView
    public void setPlayerCallback(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.a aVar) {
        this.f303858i = aVar;
    }

    @Override // com.tencent.qqlive.playerinterface.IQAdPlayerView
    public void setVideoWidthAndHeight(final int i3, final int i16) {
        final String uuid = UUID.randomUUID().toString();
        n.e(E, "setVideoWidthAndHeight: width=" + i3 + ", height=" + i16 + ", id=" + uuid);
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.QAdTextureView.1
            @Override // java.lang.Runnable
            public void run() {
                n.e(QAdTextureView.E, "setVideoWidthAndHeight, width = " + i3 + ", height = " + i16 + ", id=" + uuid);
                QAdTextureView.this.f303855e = i3;
                QAdTextureView.this.f303856f = i16;
                QAdTextureView.this.requestLayout();
            }
        });
    }

    public void setXYaxis(int i3) {
        this.f303857h = i3;
    }

    public QAdTextureView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        this.f303854d = false;
        this.f303857h = 0;
        this.f303859m = true;
        this.D = new a();
        k(i3);
    }

    @Override // com.tencent.qqlive.playerinterface.IQAdPlayerView
    public View getPlayerView() {
        return this;
    }
}
