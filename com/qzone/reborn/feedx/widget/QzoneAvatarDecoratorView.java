package com.qzone.reborn.feedx.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.qzone.cover.ui.QzoneComponentDecorator;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qzone.util.QZLog;
import cooperation.vip.manager.MonitorManager;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QzoneAvatarDecoratorView extends QzoneComponentDecorator {

    /* renamed from: d0, reason: collision with root package name */
    protected static final OvalProcessor f55961d0 = new OvalProcessor();
    private volatile Drawable M;
    volatile Drawable N;
    private volatile Drawable P;
    QzoneComponentDecorator Q;
    private Rect R;
    protected int S;
    protected int T;
    protected int U;
    protected int V;
    protected int W;

    /* renamed from: a0, reason: collision with root package name */
    private ImageLoader.ImageLoadListener f55962a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f55963b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f55964c0;

    public QzoneAvatarDecoratorView(Context context) {
        super(context);
        this.S = ViewUtils.dip2px(120.0f);
        this.T = ViewUtils.dip2px(115.0f);
        this.U = ViewUtils.dip2px(19.0f);
        this.V = ViewUtils.dip2px(19.0f);
        this.W = ViewUtils.dip2px(48.0f);
        h();
    }

    private void h() {
        this.f55962a0 = new a(this);
    }

    @Override // com.qzone.cover.ui.QzoneComponentDecorator
    public int a() {
        QzoneComponentDecorator qzoneComponentDecorator = this.Q;
        if (qzoneComponentDecorator != null) {
            return qzoneComponentDecorator.a();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.cover.ui.QzoneComponentDecorator
    public void f() {
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneAvatarDecorator", 2, "updateData");
        }
        try {
            i(this.f46742e);
        } catch (Exception e16) {
            MonitorManager.f().h(7, 9, " load avatar exception " + e16, false);
            QZLog.e("QzoneAvatarDecorator", "loadAvatar, run exception", e16);
        }
        try {
            this.M = getContext().getResources().getDrawable(R.drawable.g17);
            int i3 = (QzoneComponentDecorator.E - this.f46746m) / 2;
            int i16 = this.f46744h;
            int i17 = this.f46745i;
            int i18 = this.f46746m;
            this.R = new Rect(i3 + i16, i3 + i17, i18 + i3 + i16, i18 + i3 + i17);
            setBoundsForDrawable();
            postInvalidate();
        } catch (Exception e17) {
            MonitorManager.f().h(7, 9, " prepare resource exception " + e17, false);
            QZLog.e("QzoneAvatarDecorator", "prepareResource, run exception", e17);
        } catch (OutOfMemoryError e18) {
            MonitorManager.f().h(7, 6, " prepare resource oom " + e18, false);
            QZLog.e("QzoneAvatarDecorator", "prepareResource, run error", e18);
        }
    }

    protected void g(Canvas canvas) {
        canvas.translate(this.f46744h, this.f46745i);
        if (QzoneComponentDecorator.K != null && a() == 1 && this.M != null) {
            canvas.translate((QzoneComponentDecorator.E - QzoneComponentDecorator.J) / 2, this.W);
            QzoneComponentDecorator.K.draw(canvas);
            canvas.translate((-(QzoneComponentDecorator.E - QzoneComponentDecorator.J)) / 2, -this.W);
        }
        if (this.M != null && a() == 1 && !this.C) {
            this.M.draw(canvas);
        }
        try {
            if (this.N != null) {
                int i3 = (QzoneComponentDecorator.E - this.f46746m) / 2;
                float f16 = i3;
                canvas.translate(f16, f16);
                Drawable drawable = this.N;
                int i16 = this.f46746m;
                drawable.setBounds(0, 0, i16, i16);
                this.N.draw(canvas);
                float f17 = -i3;
                canvas.translate(f17, f17);
            }
        } catch (RuntimeException e16) {
            QZLog.e("QzoneAvatarDecorator", e16 + "");
        }
        if (this.P != null) {
            int dip2px = QzoneComponentDecorator.E + ViewUtils.dip2px(12.5f);
            int dip2px2 = ((QzoneComponentDecorator.F / 2) - this.V) - ViewUtils.dip2px(2.0f);
            if (this.f55963b0 || this.f55964c0) {
                dip2px2 = ViewUtils.dip2px(2.0f);
            }
            canvas.translate(dip2px, dip2px2);
            this.P.setBounds(0, 0, this.U, this.V);
            this.P.draw(canvas);
            canvas.translate(-dip2px, -dip2px2);
        }
        canvas.translate(-this.f46744h, -this.f46745i);
    }

    public void i(String str) {
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.useMainThread = true;
        obtain.extraProcessor = f55961d0;
        int i3 = this.f46746m;
        obtain.clipHeight = i3;
        obtain.clipWidth = i3;
        Drawable loadImage = ImageLoader.getInstance().loadImage("avatar://" + str, this.f55962a0, obtain);
        if (loadImage != null) {
            this.N = loadImage;
        }
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.cover.ui.QzoneComponentDecorator, android.view.View
    public void onDraw(Canvas canvas) {
        g(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(this.S, this.T);
    }

    protected void setBoundsForDrawable() {
        if (this.M != null) {
            Drawable drawable = this.M;
            int i3 = QzoneComponentDecorator.E;
            drawable.setBounds(0, 0, i3, i3);
        }
    }

    public void setFacadeDecorator(QzoneComponentDecorator qzoneComponentDecorator) {
        this.Q = qzoneComponentDecorator;
    }

    public void setHasFamily(boolean z16) {
        this.f55964c0 = z16;
    }

    public void setIsDaRen(boolean z16) {
        this.f55963b0 = z16;
    }

    public void setOnlyAvatarView(int i3) {
        this.f46745i = 0;
        this.f46744h = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.S = i3;
        this.T = i3;
        this.f46746m = i3;
        QzoneComponentDecorator.E = i3;
        QzoneComponentDecorator.F = i3;
    }

    public QzoneAvatarDecoratorView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.S = ViewUtils.dip2px(120.0f);
        this.T = ViewUtils.dip2px(115.0f);
        this.U = ViewUtils.dip2px(19.0f);
        this.V = ViewUtils.dip2px(19.0f);
        this.W = ViewUtils.dip2px(48.0f);
        h();
    }

    public QzoneAvatarDecoratorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.S = ViewUtils.dip2px(120.0f);
        this.T = ViewUtils.dip2px(115.0f);
        this.U = ViewUtils.dip2px(19.0f);
        this.V = ViewUtils.dip2px(19.0f);
        this.W = ViewUtils.dip2px(48.0f);
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QzoneAvatarDecoratorView> f55965d;

        public a(QzoneAvatarDecoratorView qzoneAvatarDecoratorView) {
            this.f55965d = new WeakReference<>(qzoneAvatarDecoratorView);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            QzoneAvatarDecoratorView qzoneAvatarDecoratorView = this.f55965d.get();
            if (qzoneAvatarDecoratorView != null) {
                if (drawable != null) {
                    qzoneAvatarDecoratorView.N = drawable;
                }
                QzoneComponentDecorator qzoneComponentDecorator = qzoneAvatarDecoratorView.Q;
                if (qzoneComponentDecorator != null) {
                    qzoneComponentDecorator.d();
                }
                qzoneAvatarDecoratorView.postInvalidate();
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
