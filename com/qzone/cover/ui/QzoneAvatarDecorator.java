package com.qzone.cover.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.qzone.common.account.LoginData;
import com.qzone.cover.ui.QzoneComponentDecorator;
import com.qzone.reborn.feedx.util.e;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.meta.b;
import cooperation.qzone.util.QZLog;
import cooperation.vip.manager.MonitorManager;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneAvatarDecorator extends QzoneComponentDecorator implements QzoneComponentDecorator.a {

    /* renamed from: e0, reason: collision with root package name */
    protected static final OvalProcessor f46735e0 = new OvalProcessor();
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
    private ImageLoader.ImageLoadListener f46736a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f46737b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f46738c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f46739d0;

    public QzoneAvatarDecorator(Context context) {
        super(context);
        this.S = ViewUtils.dip2px(120.0f);
        this.T = ViewUtils.dip2px(115.0f);
        this.U = ViewUtils.dip2px(19.0f);
        this.V = ViewUtils.dip2px(19.0f);
        this.W = ViewUtils.dip2px(48.0f);
        this.f46737b0 = true;
        j();
    }

    private Drawable i(String str) {
        int a16 = a();
        boolean z16 = a16 == 1;
        QLog.d("QzoneAvatarDecorator", 1, "getOutBoundFaceDrawable   | uin = " + str + " | showState = " + a16 + " | isOpenOutBound = " + z16 + " | hashcode = " + hashCode());
        if (e.d()) {
            QZoneUserAvatarView.b bVar = new QZoneUserAvatarView.b();
            bVar.f55960b = z16;
            return m(str, bVar);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.d("QzoneAvatarDecorator", 1, "getOutBoundFaceDrawable  app != QQAppInterface");
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        FaceDrawable outboundUserFaceDrawable = FaceDrawable.getOutboundUserFaceDrawable(qQAppInterface, str, (byte) 3, z16, 1);
        if (outboundUserFaceDrawable == null) {
            outboundUserFaceDrawable = FaceDrawable.getUserFaceDrawable(qQAppInterface, str, (byte) 3);
        }
        QLog.d("QzoneAvatarDecorator", 1, "getOutBoundFaceDrawable   | faceDrawable = " + outboundUserFaceDrawable + " | hashcode = " + hashCode());
        return outboundUserFaceDrawable;
    }

    private void j() {
        this.f46736a0 = new a(this);
    }

    private boolean k(String str) {
        String str2 = LoginData.getInstance().getUin() + "";
        return !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str);
    }

    private void n(String str) {
        Drawable i3 = i(str);
        if (i3 == null) {
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            obtain.useMainThread = true;
            obtain.extraProcessor = f46735e0;
            int i16 = this.f46746m;
            obtain.clipHeight = i16;
            obtain.clipWidth = i16;
            if (k(str) && km.a.f412646a.a()) {
                obtain.needCache = false;
            } else {
                obtain.needCache = true;
                i3 = ImageLoader.getInstance().loadImage("avatar://" + str, this.f46736a0, obtain);
            }
        }
        this.N = i3;
        postInvalidate();
    }

    @Override // com.qzone.cover.ui.QzoneComponentDecorator
    public int a() {
        QzoneComponentDecorator qzoneComponentDecorator = this.Q;
        if (qzoneComponentDecorator != null) {
            return qzoneComponentDecorator.a();
        }
        return 1;
    }

    @Override // com.qzone.cover.ui.QzoneComponentDecorator
    public void c(Activity activity, String str) {
        super.c(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.cover.ui.QzoneComponentDecorator
    public void f() {
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneAvatarDecorator", 2, "updateData");
        }
        try {
            l(this.f46742e);
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

    public void g() {
        if (TextUtils.isEmpty(this.f46742e)) {
            return;
        }
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.useMainThread = true;
        obtain.extraProcessor = f46735e0;
        int i3 = this.f46746m;
        obtain.clipHeight = i3;
        obtain.clipWidth = i3;
        ImageLoader.getInstance().cancel("avatar://" + this.f46742e, this.f46736a0, obtain);
    }

    protected void h(Canvas canvas) {
        canvas.translate(this.f46744h, this.f46745i);
        if (QzoneComponentDecorator.K != null && a() == 1 && this.M != null && this.f46737b0) {
            canvas.translate((QzoneComponentDecorator.E - QzoneComponentDecorator.J) / 2, this.W);
            QzoneComponentDecorator.K.draw(canvas);
            canvas.translate((-(QzoneComponentDecorator.E - QzoneComponentDecorator.J)) / 2, -this.W);
        }
        if (this.M != null && a() == 1 && !this.C && VasNormalToggle.VAS_BUG_AVATAR_BG.isEnable(false)) {
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
            if (this.f46738c0 || this.f46739d0) {
                dip2px2 = ViewUtils.dip2px(2.0f);
            }
            canvas.translate(dip2px, dip2px2);
            this.P.setBounds(0, 0, this.U, this.V);
            this.P.draw(canvas);
            canvas.translate(-dip2px, -dip2px2);
        }
        canvas.translate(-this.f46744h, -this.f46745i);
    }

    public void l(String str) {
        QzoneComponentDecorator qzoneComponentDecorator = this.Q;
        if (qzoneComponentDecorator != null) {
            qzoneComponentDecorator.d();
        }
        n(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.cover.ui.QzoneComponentDecorator, android.view.View
    public void onDraw(Canvas canvas) {
        h(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(this.S, this.T);
    }

    @Override // com.qzone.cover.ui.QzoneComponentDecorator.a
    public void onStateChange(int i3) {
        QLog.d("QzoneAvatarDecorator", 1, "onStateChange   STATE_LOAD_SUCCESS  | uin = " + this.f46742e + " | showState = " + i3);
        n(this.f46742e);
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
        if (qzoneComponentDecorator instanceof QzoneFacadeDecorator) {
            qzoneComponentDecorator.setOnShowDressStateChangeListener(this);
        }
    }

    public void setHasFamily(boolean z16) {
        this.f46739d0 = z16;
    }

    public void setIsDaRen(boolean z16) {
        this.f46738c0 = z16;
    }

    public void setIsShowAvatarTieDecorator(boolean z16) {
        this.f46737b0 = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QzoneAvatarDecorator> f46740d;

        public a(QzoneAvatarDecorator qzoneAvatarDecorator) {
            this.f46740d = new WeakReference<>(qzoneAvatarDecorator);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            String str2;
            if (options == null) {
                str2 = "";
            } else {
                str2 = options.fileRootPath;
            }
            QZLog.d("QzoneAvatarDecorator", 1, "[onImageLoaded] url: " + str + " | drawable: " + drawable + " | options file path: " + str2);
            QzoneAvatarDecorator qzoneAvatarDecorator = this.f46740d.get();
            if (qzoneAvatarDecorator != null) {
                if (drawable != null) {
                    qzoneAvatarDecorator.N = drawable;
                }
                QzoneComponentDecorator qzoneComponentDecorator = qzoneAvatarDecorator.Q;
                if (qzoneComponentDecorator != null) {
                    qzoneComponentDecorator.d();
                }
                qzoneAvatarDecorator.postInvalidate();
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

    public Drawable m(String str, QZoneUserAvatarView.b bVar) {
        QQProAvatarDrawable qQProAvatarDrawable;
        if (bVar == null) {
            bVar = new QZoneUserAvatarView.b();
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("QzoneAvatarDecorator", 1, "loadAvatarByUin  uin == null");
            return e.a();
        }
        if (this.N instanceof QQProAvatarDrawable) {
            qQProAvatarDrawable = (QQProAvatarDrawable) this.N;
        } else {
            qQProAvatarDrawable = new QQProAvatarDrawable();
        }
        b.a aVar = new b.a(1, str, 140, false);
        if (bVar.f55960b) {
            aVar.a(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG, Boolean.TRUE);
            aVar.a("KEY_BEAN_KEY_SUFFIX", "sz");
        }
        qQProAvatarDrawable.y(getContext(), new com.tencent.qqnt.avatar.fetch.c(aVar.b(), null, BaseImageUtil.getDefaultFaceDrawable(), null, true, null));
        QLog.d("QzoneAvatarDecorator", 1, "loadAvatarByUin   | uin = " + str + " | isOpenOutBound = " + bVar.f55960b + " | drawable = " + qQProAvatarDrawable + " | hashcode = " + hashCode());
        return qQProAvatarDrawable;
    }

    public QzoneAvatarDecorator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.S = ViewUtils.dip2px(120.0f);
        this.T = ViewUtils.dip2px(115.0f);
        this.U = ViewUtils.dip2px(19.0f);
        this.V = ViewUtils.dip2px(19.0f);
        this.W = ViewUtils.dip2px(48.0f);
        this.f46737b0 = true;
        j();
    }

    public QzoneAvatarDecorator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.S = ViewUtils.dip2px(120.0f);
        this.T = ViewUtils.dip2px(115.0f);
        this.U = ViewUtils.dip2px(19.0f);
        this.V = ViewUtils.dip2px(19.0f);
        this.W = ViewUtils.dip2px(48.0f);
        this.f46737b0 = true;
        j();
    }
}
