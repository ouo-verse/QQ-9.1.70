package com.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.mobileqq.R;
import common.config.service.QZoneConfigHelper;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AvatarImageView extends AsyncImageView {
    public static final OvalProcessor F = new OvalProcessor();
    public static final int G = AreaConst.dp10;
    public static final int H = AreaConst.dp14;
    private String C;
    private Drawable D;
    private int E;

    /* renamed from: d, reason: collision with root package name */
    private int f60170d;

    /* renamed from: e, reason: collision with root package name */
    private int f60171e;

    /* renamed from: f, reason: collision with root package name */
    private int f60172f;

    /* renamed from: h, reason: collision with root package name */
    private int f60173h;

    /* renamed from: i, reason: collision with root package name */
    protected RectF f60174i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f60175m;

    public AvatarImageView(Context context) {
        super(context);
        this.f60171e = R.drawable.arb;
        this.f60172f = 0;
        this.f60173h = 0;
        this.f60174i = new RectF();
        this.D = null;
        this.E = G;
        h();
    }

    private void h() {
        setScaleType(ImageView.ScaleType.FIT_XY);
        setAsyncImageProcessor(F);
        setDefaultAvatar(R.drawable.f160830com);
        setForeground(this.f60171e);
        setAsyncPreferQuality(true);
    }

    private void i() {
        Paint paint = new Paint(3);
        this.f60175m = paint;
        paint.setColor(0);
        this.f60175m.setDither(true);
        this.f60175m.setStyle(Paint.Style.STROKE);
    }

    public void j(long j3) {
        k(g(j3));
    }

    public void k(String str) {
        this.C = str;
        if (getWidth() > 0 && getHeight() > 0 && QZoneConfigHelper.D()) {
            setAsyncClipSize(getWidth(), getHeight());
        }
        setAsyncImage(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.D;
        if (drawable != null && drawable.getIntrinsicHeight() != 0) {
            int intrinsicWidth = (this.D.getIntrinsicWidth() * this.E) / this.D.getIntrinsicHeight();
            int i3 = this.E;
            int width = getWidth();
            int height = getHeight();
            this.D.setBounds(width - intrinsicWidth, height - i3, width, height);
            this.D.draw(canvas);
        }
        if (this.f60172f == 0 || this.f60173h == 0 || this.f60175m == null) {
            return;
        }
        this.f60174i.set(r0 / 2, r0 / 2, getWidth() - (this.f60172f / 2), getHeight() - (this.f60172f / 2));
        canvas.drawRoundRect(this.f60174i, getWidth() / 2, getWidth() / 2, this.f60175m);
    }

    public void setDefaultAvatar(int i3) {
        setDefaultImage(i3);
    }

    @Override // com.qzone.widget.AsyncImageView, com.qzone.widget.AsyncImageable
    public void setDefaultImage(int i3) {
        super.setDefaultImage(i3);
        this.f60170d = i3;
    }

    public void setRightCornerIcon(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            this.D = null;
            return;
        }
        if (i3 > 0) {
            this.E = i3;
        }
        this.D = ImageLoader.getInstance(getContext()).loadImage(str, new a(), (ImageLoader.Options) null);
        postInvalidate();
    }

    public void setSelector(int i3) {
        this.f60171e = i3;
        setForeground(i3);
    }

    public void setStrokeColor(int i3) {
        this.f60173h = i3;
        if (this.f60175m == null) {
            i();
        }
        this.f60175m.setColor(i3);
    }

    public void setStrokeWidth(int i3) {
        this.f60172f = i3;
        if (this.f60175m == null) {
            i();
        }
        this.f60175m.setStrokeWidth(i3);
    }

    public static String g(long j3) {
        if (j3 <= 0) {
            return null;
        }
        return "avatar://" + j3;
    }

    public AvatarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AvatarImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60171e = R.drawable.arb;
        this.f60172f = 0;
        this.f60173h = 0;
        this.f60174i = new RectF();
        this.D = null;
        this.E = G;
        h();
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements ImageLoader.ImageLoadListener {
        a() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            AvatarImageView.this.D = drawable;
            AvatarImageView.this.postInvalidate();
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
