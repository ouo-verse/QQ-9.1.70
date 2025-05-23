package com.qzone.detail.ui.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.qzone.common.account.LoginData;
import com.qzone.detail.ui.component.ShareStyleChooserController;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.util.ar;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QRCodeShareViewBuilder {

    /* renamed from: a, reason: collision with root package name */
    private Context f47001a;

    /* renamed from: b, reason: collision with root package name */
    private View f47002b;

    /* renamed from: c, reason: collision with root package name */
    private QZoneUserAvatarView f47003c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f47004d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f47005e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f47006f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f47007g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f47008h;

    /* renamed from: i, reason: collision with root package name */
    private b f47009i;

    /* renamed from: j, reason: collision with root package name */
    private Bitmap f47010j;

    /* renamed from: k, reason: collision with root package name */
    private String f47011k;

    /* renamed from: l, reason: collision with root package name */
    private ShareStyleChooserController.a f47012l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void a(View view);
    }

    public QRCodeShareViewBuilder(Context context, ShareStyleChooserController.a aVar, b bVar) {
        this.f47001a = context;
        this.f47009i = bVar;
        this.f47012l = aVar;
        k();
        n();
    }

    private Bitmap j(View view) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            System.gc();
            try {
                Bitmap createBitmap2 = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                view.draw(new Canvas(createBitmap2));
                return createBitmap2;
            } catch (OutOfMemoryError unused2) {
                return null;
            }
        }
    }

    private void k() {
        View inflate = LayoutInflater.from(this.f47001a).inflate(R.layout.bql, (ViewGroup) null, false);
        this.f47002b = inflate;
        this.f47003c = (QZoneUserAvatarView) inflate.findViewById(R.id.f166736hq0);
        this.f47004d = (TextView) this.f47002b.findViewById(R.id.hq5);
        this.f47006f = (TextView) this.f47002b.findViewById(R.id.f166739hq3);
        this.f47007g = (TextView) this.f47002b.findViewById(R.id.hq7);
        this.f47005e = (TextView) this.f47002b.findViewById(R.id.f166738hq2);
        this.f47008h = (ImageView) this.f47002b.findViewById(R.id.hq6);
    }

    private void l(Runnable runnable) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m(Bitmap bitmap) {
        try {
            return com.tencent.biz.qrcode.util.h.P(this.f47001a, "temp_qrcode_share_" + System.currentTimeMillis() + LoginData.getInstance().getUin() + ".png", bitmap);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.i("QRCodeShareViewBuilder", 2, e16.getMessage());
            }
            return null;
        }
    }

    private void n() {
        ImageView imageView;
        ShareStyleChooserController.a aVar = this.f47012l;
        if (aVar != null) {
            QZoneUserAvatarView qZoneUserAvatarView = this.f47003c;
            if (qZoneUserAvatarView != null) {
                this.f47003c.setImageDrawable(com.qzone.reborn.feedx.util.e.e(qZoneUserAvatarView, aVar.f47030a, new QZoneUserAvatarView.b()));
            }
            TextView textView = this.f47004d;
            if (textView != null) {
                textView.setText(this.f47012l.f47032c);
            }
            TextView textView2 = this.f47005e;
            if (textView2 != null) {
                textView2.setText(this.f47012l.f47033d);
            }
            TextView textView3 = this.f47006f;
            if (textView3 != null) {
                if (this.f47012l.f47034e != 0) {
                    textView3.setText("\u7c89\u4e1d " + ShareStyleChooserController.j(this.f47012l.f47034e));
                } else {
                    textView3.setVisibility(8);
                }
            }
            TextView textView4 = this.f47007g;
            if (textView4 != null) {
                if (this.f47012l.f47035f != 0) {
                    textView4.setText("\u8bbf\u5ba2 " + ShareStyleChooserController.j(this.f47012l.f47035f));
                } else {
                    textView4.setVisibility(8);
                }
            }
            Bitmap g16 = g(this.f47012l.f47036g, ar.e(85.0f), ar.e(85.0f), 0);
            if (g16 != null && (imageView = this.f47008h) != null) {
                imageView.setImageBitmap(g16);
            }
            ImageLoader.getInstance().loadImageAsync(this.f47012l.f47037h, new a(), null);
        }
    }

    public void h() {
        View view = this.f47002b;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(ar.e(375.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(ar.e(670.0f), 1073741824));
            View view2 = this.f47002b;
            view2.layout(0, 0, view2.getMeasuredWidth(), this.f47002b.getMeasuredHeight());
            this.f47002b.setDrawingCacheEnabled(true);
            Bitmap drawingCache = this.f47002b.getDrawingCache();
            if (drawingCache == null) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("QRCodeShareViewBuilder", 4, "cacheBmp is null");
                }
                Bitmap j3 = j(this.f47002b);
                this.f47010j = j3;
                if (j3 == null) {
                    QZLog.e("QRCodeShareViewBuilder", "cacheBmp is null,can't show QRCode");
                    b bVar = this.f47009i;
                    if (bVar != null) {
                        bVar.a(null);
                    }
                    this.f47002b.destroyDrawingCache();
                    this.f47002b.setDrawingCacheEnabled(false);
                    return;
                }
            } else {
                try {
                    this.f47010j = drawingCache.copy(Bitmap.Config.RGB_565, true);
                } catch (OutOfMemoryError unused) {
                    QZLog.e("QRCodeShareViewBuilder", "cacheBmp copy error,can't show QRCode");
                    b bVar2 = this.f47009i;
                    if (bVar2 != null) {
                        bVar2.a(null);
                    }
                    this.f47002b.destroyDrawingCache();
                    this.f47002b.setDrawingCacheEnabled(false);
                    return;
                }
            }
            this.f47002b.destroyDrawingCache();
            this.f47002b.setDrawingCacheEnabled(false);
            ImageView imageView = new ImageView(this.f47001a);
            imageView.setImageBitmap(this.f47010j);
            b bVar3 = this.f47009i;
            if (bVar3 != null) {
                bVar3.a(imageView);
            }
        }
    }

    public void i(final Handler handler) {
        if (this.f47010j != null) {
            l(new Runnable() { // from class: com.qzone.detail.ui.component.QRCodeShareViewBuilder.2
                @Override // java.lang.Runnable
                public void run() {
                    QRCodeShareViewBuilder qRCodeShareViewBuilder = QRCodeShareViewBuilder.this;
                    qRCodeShareViewBuilder.f47011k = qRCodeShareViewBuilder.m(qRCodeShareViewBuilder.f47010j);
                    if (!CacheManager.isExternalAvailable()) {
                        Message obtainMessage = handler.obtainMessage();
                        obtainMessage.what = 3;
                        if (QLog.isDevelopLevel()) {
                            QZLog.i("QRCodeShareViewBuilder", 4, "save error:sd is not writeable");
                        }
                        handler.sendMessage(obtainMessage);
                        return;
                    }
                    if (TextUtils.isEmpty(QRCodeShareViewBuilder.this.f47011k)) {
                        Message obtainMessage2 = handler.obtainMessage();
                        obtainMessage2.what = 1;
                        if (QLog.isDevelopLevel()) {
                            QZLog.i("QRCodeShareViewBuilder", 4, "save error:save path is null");
                        }
                        handler.sendMessage(obtainMessage2);
                        return;
                    }
                    Message obtainMessage3 = handler.obtainMessage();
                    obtainMessage3.obj = QRCodeShareViewBuilder.this.f47011k;
                    obtainMessage3.what = 2;
                    if (QLog.isDevelopLevel()) {
                        QZLog.i("QRCodeShareViewBuilder", 4, "save success");
                    }
                    handler.sendMessage(obtainMessage3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements ImageLoader.ImageLoadListener {
        a() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
            QZLog.d("QRCodeShareViewBuilder", 4, "load share background canceled:" + str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            QZLog.e("QRCodeShareViewBuilder", "load share background failed:" + str);
            if (QRCodeShareViewBuilder.this.f47002b != null) {
                QRCodeShareViewBuilder.this.f47002b.setBackgroundDrawable(QRCodeShareViewBuilder.this.f47001a.getResources().getDrawable(R.drawable.f160735mk));
                QRCodeShareViewBuilder.this.h();
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            if (drawable == null || QRCodeShareViewBuilder.this.f47002b == null) {
                return;
            }
            QRCodeShareViewBuilder.this.f47002b.setBackgroundDrawable(drawable);
            QRCodeShareViewBuilder.this.h();
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    private Bitmap g(String str, int i3, int i16, int i17) {
        Bitmap createBitmap;
        long currentTimeMillis = System.currentTimeMillis();
        int e16 = ar.e(375.0f);
        int e17 = ar.e(5.0f);
        Bitmap i18 = jh.a.i(this.f47001a, jh.b.g().j(e16).k(str).g(-16777216).h(ErrorCorrectionLevel.H).i(ar.h(this.f47001a, R.drawable.g5i, e17, e17)).f());
        if (i18 == null) {
            QZLog.e("QRCodeShareViewBuilder", "generateQRCode codeBmp is null");
            return null;
        }
        try {
            createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            System.gc();
            try {
                createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused2) {
                return null;
            }
        }
        if (createBitmap == null) {
            i18.recycle();
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 600.0f, -657931, -1513240, Shader.TileMode.REPEAT));
        canvas.drawRect(0.0f, 0.0f, i3, i16, paint);
        canvas.drawBitmap(i18, (Rect) null, new Rect(i17, i17, i3 - i17, i16 - i17), (Paint) null);
        i18.recycle();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QRCodeShareViewBuilder", 4, "getQrCode cost time:" + (currentTimeMillis2 - currentTimeMillis));
        }
        return createBitmap;
    }
}
