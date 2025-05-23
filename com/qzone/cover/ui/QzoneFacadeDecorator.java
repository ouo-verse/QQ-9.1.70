package com.qzone.cover.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.qzone.common.business.model.AvatarCacheData;
import com.qzone.cover.ui.QzoneComponentDecorator;
import com.qzone.widget.QzoneZipAnimateUtil;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasQzoneYellowThread;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.zipanimate.AnimationDrawableLoadedListener;
import cooperation.vip.manager.MonitorManager;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneFacadeDecorator extends QzoneComponentDecorator {
    protected int M;
    private volatile AnimationDrawable N;
    private volatile d P;
    private volatile com.tencent.mobileqq.vas.ui.c Q;
    private Drawable R;
    protected int S;
    protected int T;
    public volatile AvatarCacheData U;
    private volatile String V;
    public int W;

    /* renamed from: a0, reason: collision with root package name */
    public int f46759a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f46760b0;

    /* renamed from: c0, reason: collision with root package name */
    private Runnable f46761c0;

    /* renamed from: d0, reason: collision with root package name */
    private AnimationDrawableLoadedListener f46762d0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b extends AnimationDrawableLoadedListener {

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements com.tencent.mobileqq.vas.ui.d {
            a() {
            }

            @Override // com.tencent.mobileqq.vas.ui.d
            public void a(d dVar) {
                QzoneFacadeDecorator.this.P = dVar;
                QzoneFacadeDecorator.this.s();
                QzoneFacadeDecorator.this.A();
                QzoneFacadeDecorator.this.postInvalidate();
            }
        }

        b() {
        }

        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onLoadedFailed() {
            MonitorManager.f().h(7, 8, " load avatar resouce fail " + QzoneFacadeDecorator.this.V, false);
            QzoneFacadeDecorator.this.V = "";
            QZLog.w("QzoneFacadeDecorator", "getZipAnimationDrawable failed");
        }

        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onLoadedSuccess(AnimationDrawable animationDrawable) {
            QzoneFacadeDecorator.this.N = animationDrawable;
            QzoneFacadeDecorator.this.s();
            QzoneFacadeDecorator.this.A();
            QzoneFacadeDecorator.this.postInvalidate();
        }

        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onNewLoadSuccess(com.tencent.mobileqq.vas.ui.c cVar) {
            QzoneFacadeDecorator.this.Q = cVar;
            cVar.p(new a());
        }
    }

    public QzoneFacadeDecorator(Context context) {
        super(context);
        this.M = 1;
        this.S = ViewUtils.dip2px(120.0f);
        this.T = ViewUtils.dip2px(115.0f);
        this.V = "";
        this.W = ViewUtils.dip2px(92.0f);
        this.f46759a0 = ViewUtils.dip2px(105.0f);
        this.f46760b0 = true;
        this.f46761c0 = new Runnable() { // from class: com.qzone.cover.ui.QzoneFacadeDecorator.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    QzoneFacadeDecorator.this.U = com.qzone.personalize.business.b.n().c(Long.parseLong(QzoneFacadeDecorator.this.f46742e));
                    QzoneFacadeDecorator.this.p();
                } catch (Exception e16) {
                    MonitorManager.f().h(7, 9, " process avatar error " + e16, false);
                    if (QZLog.isColorLevel()) {
                        QZLog.d("QzoneFacadeDecorator", 2, "error " + e16);
                    }
                }
            }
        };
        this.f46762d0 = new b();
    }

    private void D(int i3) {
        int i16 = this.M;
        this.M = i3;
        if (i16 != i3) {
            QLog.d("QzoneFacadeDecorator", 1, "updateShowAvatarDressState   | oldState = " + i16 + " | mShowAvatarDressUp = " + this.M + " | mShowDressStateChangeListener = " + this.D);
            WeakReference<QzoneComponentDecorator.a> weakReference = this.D;
            if (weakReference != null && weakReference.get() != null) {
                this.D.get().onStateChange(this.M);
            } else {
                QLog.w("QzoneFacadeDecorator", 1, "updateShowAvatarDressState  listener == null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (QzoneZipAnimateUtil.f60590a) {
            com.tencent.mobileqq.vas.ui.c cVar = this.Q;
            if (cVar != null) {
                Drawable drawable = cVar.getDrawable();
                drawable.setBounds(0, 0, this.W, this.f46759a0);
                drawable.setCallback(this);
                return;
            }
            return;
        }
        AnimationDrawable animationDrawable = this.N;
        if (animationDrawable != null) {
            animationDrawable.setBounds(0, 0, this.W, this.f46759a0);
            animationDrawable.setVisible(true, false);
            animationDrawable.setCallback(this);
            animationDrawable.setOneShot(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(LoadState loadState, Option option) {
        BitmapDrawable bitmapDrawable;
        if (loadState == LoadState.STATE_SUCCESS && this.R != (bitmapDrawable = new BitmapDrawable(getResources(), option.getResultBitMap()))) {
            this.R = bitmapDrawable;
            bitmapDrawable.setBounds(0, 0, this.W, this.f46759a0);
            postInvalidate();
        }
    }

    private void v() {
        if (this.U.vecView == null || this.U.vecView.size() == 0 || this.U.vecView.get(0).stFileInfo == null || this.U.strId.equals("-1")) {
            return;
        }
        String str = this.U.vecView.get(0).stFileInfo.strFileUrl;
        String str2 = this.U.strId;
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneFacadeDecorator", 2, "processAnimationAvatar|mAvatarUrl:" + this.V + ", url:" + str);
        }
        if (!this.V.equals(str)) {
            this.V = str;
            QzoneZipAnimateUtil.j(this.V, "avatar_facade_decorator", str2, this.W, this.f46759a0, 110, this.f46762d0);
            s();
        }
        A();
    }

    private void x() {
        if (this.U.vecView == null || this.U.vecView.size() == 0 || this.U.strId.equals("-1")) {
            return;
        }
        String str = this.U.vecView.get(0).stFileInfo.strFileUrl;
        if (this.V.equals(str)) {
            return;
        }
        this.V = str;
        if (VasNormalToggle.VAS_QZONE_NEW_IMAGE_LOADER.isEnable(true)) {
            com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(this.V), new IPicLoadStateListener() { // from class: com.qzone.cover.ui.c
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    QzoneFacadeDecorator.this.t(loadState, option);
                }
            });
        } else {
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            obtain.useMainThread = true;
            this.R = ImageLoader.getInstance().loadImage(this.V, new a(), obtain);
        }
        Drawable drawable = this.R;
        if (drawable != null) {
            drawable.setBounds(0, 0, this.W, this.f46759a0);
            postInvalidate();
        }
    }

    private void y() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.YellowVipThread).removeTask(this.f46761c0);
    }

    public void A() {
        WeakReference<Activity> weakReference = this.f46741d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f46741d.get().runOnUiThread(new Runnable() { // from class: com.qzone.cover.ui.QzoneFacadeDecorator.4
            @Override // java.lang.Runnable
            public void run() {
                QzoneFacadeDecorator.this.z();
            }
        });
    }

    public void B() {
        if (QzoneZipAnimateUtil.f60590a) {
            d dVar = this.P;
            if (dVar != null) {
                dVar.stop();
            }
            com.tencent.mobileqq.vas.ui.c cVar = this.Q;
            if (dVar != null) {
                cVar.getDrawable().setCallback(null);
                return;
            }
            return;
        }
        AnimationDrawable animationDrawable = this.N;
        if (animationDrawable != null) {
            if (QZLog.isColorLevel()) {
                QZLog.d("QzoneFacadeDecorator", 2, "stopAndRecyleAnimationAvatar");
            }
            animationDrawable.stop();
            for (int i3 = 0; i3 < animationDrawable.getNumberOfFrames(); i3++) {
                Drawable frame = animationDrawable.getFrame(i3);
                if (frame instanceof BitmapDrawable) {
                    if (QZLog.isColorLevel()) {
                        QZLog.d("QzoneFacadeDecorator", 2, "stopAndRecyleAnimationAvatar bm:" + ((BitmapDrawable) frame).getBitmap());
                    }
                    ((BitmapDrawable) frame).getBitmap().recycle();
                }
                if (frame != null) {
                    frame.setCallback(null);
                }
            }
            animationDrawable.setCallback(null);
            this.N = null;
            this.V = "";
        }
    }

    public void C() {
        if (QzoneZipAnimateUtil.f60590a) {
            d dVar = this.P;
            if (dVar != null) {
                dVar.stop();
                return;
            }
            return;
        }
        AnimationDrawable animationDrawable = this.N;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    @Override // com.qzone.cover.ui.QzoneComponentDecorator
    public int a() {
        return this.M;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.cover.ui.QzoneComponentDecorator
    public void f() {
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneFacadeDecorator", 2, "doOnComponent isLoadAvatarDressUp:" + this.f46760b0);
        }
        if (this.f46760b0) {
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.cover.ui.QzoneComponentDecorator, android.view.View
    public void onDraw(Canvas canvas) {
        q(canvas);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(this.S, this.T);
    }

    public void p() {
        if (this.f46743f) {
            if (this.U != null && this.U.strId != null && !this.U.strId.equals("-1") && !this.C) {
                if (QZLog.isColorLevel()) {
                    QZLog.d("QzoneFacadeDecorator", 2, "mAvatar.strId:" + this.U.strId);
                }
                w();
                return;
            }
            D(1);
            C();
            this.N = null;
            this.R = null;
            this.V = "";
            postInvalidate();
            return;
        }
        w();
    }

    protected void q(Canvas canvas) {
        canvas.translate(this.f46744h, this.f46745i);
        if (this.Q != null) {
            float centerX = (QzoneComponentDecorator.E / 2) - this.Q.getDrawable().getBounds().centerX();
            float centerY = ((QzoneComponentDecorator.F / 2) - this.Q.getDrawable().getBounds().centerY()) - ViewUtils.dip2px(8.0f);
            canvas.translate(centerX, centerY);
            this.Q.getDrawable().draw(canvas);
            canvas.translate(-centerX, -centerY);
        } else if (this.N != null && this.N.getCurrent() != null && ((BitmapDrawable) this.N.getCurrent()).getBitmap() != null && !((BitmapDrawable) this.N.getCurrent()).getBitmap().isRecycled()) {
            float centerX2 = (QzoneComponentDecorator.E / 2) - this.N.getBounds().centerX();
            float centerY2 = ((QzoneComponentDecorator.F / 2) - this.N.getBounds().centerY()) - ViewUtils.dip2px(8.0f);
            canvas.translate(centerX2, centerY2);
            this.N.draw(canvas);
            canvas.translate(-centerX2, -centerY2);
        }
        Drawable drawable = this.R;
        if (drawable != null) {
            float centerX3 = (QzoneComponentDecorator.E / 2) - drawable.getBounds().centerX();
            float centerY3 = ((QzoneComponentDecorator.F / 2) - this.R.getBounds().centerY()) - ViewUtils.dip2px(8.0f);
            canvas.translate(centerX3, centerY3);
            this.R.draw(canvas);
            canvas.translate(-centerX3, -centerY3);
        }
        canvas.translate(-this.f46744h, -this.f46745i);
    }

    public void r(Activity activity, String str, boolean z16) {
        this.f46760b0 = z16;
        super.c(activity, str);
    }

    public void u() {
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneFacadeDecorator", 2, "prepareProcessAvatar");
        }
        if (VasNormalToggle.QZONE_THREAD_MOVE_SWITCH.isEnable(true)) {
            ThreadManagerV2.removeJob(this.f46761c0, 16);
        } else {
            y();
        }
        VasQzoneYellowThread.INSTANCE.execJob(this.f46761c0);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        super.verifyDrawable(drawable);
        return true;
    }

    public void w() {
        if (this.U != null) {
            if ("-1".equals(this.U.strId)) {
                D(1);
            } else {
                D(0);
            }
            if (this.U.iType == 375) {
                this.N = null;
                if (QZLog.isColorLevel()) {
                    QZLog.d("QzoneFacadeDecorator", 2, "processStaticAvatar");
                }
                try {
                    x();
                    return;
                } catch (Exception e16) {
                    MonitorManager.f().h(7, 9, " process static avatar error " + e16, false);
                    QZLog.e("QzoneFacadeDecorator", "processAvatar|" + e16.toString());
                    return;
                }
            }
            if (this.U.iType == 376) {
                this.R = null;
                if (QZLog.isColorLevel()) {
                    QZLog.d("QzoneFacadeDecorator", 2, "processAnimationAvatar");
                }
                try {
                    v();
                    return;
                } catch (Exception e17) {
                    MonitorManager.f().h(7, 9, " process facade avatar error " + e17, false);
                    QZLog.e("QzoneFacadeDecorator", "processAvatar|" + e17.toString());
                    return;
                }
            }
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneFacadeDecorator", 2, "mAvatar null");
        }
        D(1);
    }

    public void z() {
        if (QzoneZipAnimateUtil.f60590a) {
            d dVar = this.P;
            if (dVar != null) {
                dVar.restart();
                return;
            }
            return;
        }
        AnimationDrawable animationDrawable = this.N;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public QzoneFacadeDecorator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.M = 1;
        this.S = ViewUtils.dip2px(120.0f);
        this.T = ViewUtils.dip2px(115.0f);
        this.V = "";
        this.W = ViewUtils.dip2px(92.0f);
        this.f46759a0 = ViewUtils.dip2px(105.0f);
        this.f46760b0 = true;
        this.f46761c0 = new Runnable() { // from class: com.qzone.cover.ui.QzoneFacadeDecorator.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    QzoneFacadeDecorator.this.U = com.qzone.personalize.business.b.n().c(Long.parseLong(QzoneFacadeDecorator.this.f46742e));
                    QzoneFacadeDecorator.this.p();
                } catch (Exception e16) {
                    MonitorManager.f().h(7, 9, " process avatar error " + e16, false);
                    if (QZLog.isColorLevel()) {
                        QZLog.d("QzoneFacadeDecorator", 2, "error " + e16);
                    }
                }
            }
        };
        this.f46762d0 = new b();
    }

    public QzoneFacadeDecorator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M = 1;
        this.S = ViewUtils.dip2px(120.0f);
        this.T = ViewUtils.dip2px(115.0f);
        this.V = "";
        this.W = ViewUtils.dip2px(92.0f);
        this.f46759a0 = ViewUtils.dip2px(105.0f);
        this.f46760b0 = true;
        this.f46761c0 = new Runnable() { // from class: com.qzone.cover.ui.QzoneFacadeDecorator.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    QzoneFacadeDecorator.this.U = com.qzone.personalize.business.b.n().c(Long.parseLong(QzoneFacadeDecorator.this.f46742e));
                    QzoneFacadeDecorator.this.p();
                } catch (Exception e16) {
                    MonitorManager.f().h(7, 9, " process avatar error " + e16, false);
                    if (QZLog.isColorLevel()) {
                        QZLog.d("QzoneFacadeDecorator", 2, "error " + e16);
                    }
                }
            }
        };
        this.f46762d0 = new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements ImageLoader.ImageLoadListener {
        a() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
            QzoneFacadeDecorator.this.V = "";
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            MonitorManager.f().h(7, 7, " load avatar fail " + QzoneFacadeDecorator.this.V, false);
            QZLog.w("QzoneFacadeDecorator", "avatar onImageFailed");
            QzoneFacadeDecorator.this.V = "";
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            if (QzoneFacadeDecorator.this.R != drawable) {
                boolean n3 = p6.b.n(str);
                if (QZLog.isColorLevel()) {
                    QZLog.d("QzoneFacadeDecorator", 2, "processStaticAvatar|onImageLoaded|createStaticFile is " + n3);
                }
                QzoneFacadeDecorator.this.R = drawable;
                if (QzoneFacadeDecorator.this.R != null) {
                    Drawable drawable2 = QzoneFacadeDecorator.this.R;
                    QzoneFacadeDecorator qzoneFacadeDecorator = QzoneFacadeDecorator.this;
                    drawable2.setBounds(0, 0, qzoneFacadeDecorator.W, qzoneFacadeDecorator.f46759a0);
                }
                QzoneFacadeDecorator.this.postInvalidate();
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
