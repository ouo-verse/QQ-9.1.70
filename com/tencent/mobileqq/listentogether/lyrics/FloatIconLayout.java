package com.tencent.mobileqq.listentogether.lyrics;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class FloatIconLayout extends FloatBaseLayout implements View.OnClickListener, URLDrawable.URLDrawableListener, ValueAnimator.AnimatorUpdateListener {
    RelativeLayout K;
    ImageView L;
    ImageView M;
    String N;
    ValueAnimator P;
    int Q;
    boolean R;
    boolean S;
    URLDrawable T;
    ImageView U;
    Paint V;
    int W;

    /* renamed from: a0, reason: collision with root package name */
    View f240992a0;

    /* renamed from: b0, reason: collision with root package name */
    View f240993b0;

    /* renamed from: c0, reason: collision with root package name */
    float f240994c0;

    /* renamed from: d0, reason: collision with root package name */
    ValueAnimator f240995d0;

    /* renamed from: e0, reason: collision with root package name */
    DownloadParams.DecodeHandler f240996e0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FloatIconLayout.this.f240993b0.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements DownloadParams.DecodeHandler {
        b() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            if (QLog.isDevelopLevel()) {
                QLog.d("FloatBaseLayout.Icon", 4, "ROUND_FACE_DECODER");
            }
            if (bitmap == null) {
                return null;
            }
            int i3 = FloatIconLayout.this.Q;
            return BaseImageUtil.getRoundedCornerBitmap(bitmap, i3 / 2, i3 / 2, i3 / 2);
        }
    }

    public FloatIconLayout(Context context) {
        super(context);
        this.R = false;
        this.S = false;
        this.f240996e0 = new b();
        u();
    }

    private void A(float f16) {
        float rotation = this.f240993b0.getRotation();
        if (Math.abs(f16 - rotation) < 0.5f) {
            this.f240993b0.setRotation(f16);
            return;
        }
        ValueAnimator valueAnimator = this.f240995d0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f240995d0.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(rotation, f16);
        this.f240995d0 = ofFloat;
        ofFloat.setDuration((Math.abs(r1) * 200.0f) / 28.0f);
        this.f240995d0.addUpdateListener(new a());
        this.f240995d0.start();
    }

    private void B() {
        if (n()) {
            if (this.R) {
                if (this.S) {
                    return;
                }
                this.f240994c0 = 0.0f;
                this.P.start();
                this.S = true;
                A(0.0f);
                return;
            }
            this.P.cancel();
            this.f240994c0 = 0.0f;
            A(-28.0f);
            this.S = false;
            return;
        }
        this.P.cancel();
        this.f240994c0 = 0.0f;
        this.S = false;
    }

    private void E(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("FloatBaseLayout.Icon", 2, "updateMusicIcon url:" + str + " mAlbumUrl:" + this.N);
        }
        if (TextUtils.equals(str, this.N)) {
            return;
        }
        this.N = str;
        this.f240992a0.setRotation(0.0f);
        if (!TextUtils.isEmpty(this.N)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mMemoryCacheKeySuffix = "round";
            int i3 = this.Q;
            obtain.mRequestWidth = i3;
            obtain.mRequestHeight = i3;
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            URLDrawable uRLDrawable = this.T;
            if (uRLDrawable != null) {
                uRLDrawable.setURLDrawableListener(null);
                this.T = null;
            }
            URLDrawable drawable2 = URLDrawable.getDrawable(this.N, obtain);
            this.T = drawable2;
            drawable2.setDecodeHandler(this.f240996e0);
            this.T.startDownload();
            this.T.setURLDrawableListener(this);
            this.L.setImageDrawable(this.T);
            return;
        }
        URLDrawable uRLDrawable2 = this.T;
        if (uRLDrawable2 != null) {
            uRLDrawable2.setURLDrawableListener(null);
            this.T = null;
        }
        this.L.setImageDrawable(null);
        v();
    }

    private void u() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.cap, (ViewGroup) null);
        this.K = (RelativeLayout) inflate.findViewById(R.id.d_n);
        this.M = (ImageView) inflate.findViewById(R.id.azb);
        this.L = (ImageView) inflate.findViewById(R.id.lwk);
        this.U = (ImageView) inflate.findViewById(R.id.lwl);
        this.f240992a0 = inflate.findViewById(R.id.m7_);
        this.f240993b0 = inflate.findViewById(R.id.lwo);
        addView(inflate, new FrameLayout.LayoutParams(-2, -2));
        this.M.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.L.setContentDescription(HardCodeUtil.qqStr(R.string.mle));
        this.M.setContentDescription(HardCodeUtil.qqStr(R.string.mlf));
        this.f240987e = (int) getResources().getDimension(R.dimen.b6f);
        this.f240988f = (int) getResources().getDimension(R.dimen.b6e);
        this.Q = BaseAIOUtils.f(40.0f, getResources());
        WindowManager.LayoutParams layoutParams = this.f240990i;
        layoutParams.width = this.f240987e;
        layoutParams.height = this.f240988f;
        this.P = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.P.setInterpolator(new LinearInterpolator());
        this.P.addUpdateListener(this);
        this.P.setDuration(10000L);
        this.P.setRepeatCount(-1);
        this.f240992a0.setPivotX(BaseAIOUtils.f(40.0f, getResources()) / 2);
        this.f240992a0.setPivotY(BaseAIOUtils.f(40.0f, getResources()) / 2);
        Paint paint = new Paint();
        this.V = paint;
        paint.setAntiAlias(true);
        this.V.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
        this.W = this.V.getColor();
        this.f240993b0.setPivotX(BaseAIOUtils.f(20.0f, getResources()));
        this.f240993b0.setPivotY(BaseAIOUtils.f(3.0f, getResources()));
        this.f240993b0.setRotation(-28.0f);
        this.f240994c0 = 0.0f;
        v();
    }

    private void v() {
        this.U.setVisibility(8);
    }

    private void w() {
        this.U.setVisibility(0);
    }

    private void z(int i3, int i16) {
        ((ImageView) findViewById(i3)).setImageResource(i16);
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.FloatBaseLayout
    public void destroy() {
        super.destroy();
        URLDrawable uRLDrawable = this.T;
        if (uRLDrawable != null) {
            uRLDrawable.setURLDrawableListener(null);
            this.T = null;
        }
        this.P.cancel();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        boolean z16 = "1103".equals(ThemeUtil.curThemeId) || "2920".equals(ThemeUtil.curThemeId);
        if (z16) {
            if (this.V.getColorFilter() == null) {
                this.V.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
            }
            this.V.setColor(this.W);
            canvas.saveLayer(null, this.V, 31);
        }
        super.dispatchDraw(canvas);
        if (z16) {
            canvas.restore();
        }
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.FloatBaseLayout
    public boolean l() {
        boolean l3 = super.l();
        B();
        return l3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.listentogether.lyrics.FloatBaseLayout
    public void o() {
        super.o();
        this.L.setAlpha(1.0f);
        this.M.setAlpha(1.0f);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float rotation = this.f240992a0.getRotation() + (floatValue - this.f240994c0);
        if (rotation > 360.0f) {
            rotation -= 360.0f;
        }
        this.f240992a0.setRotation(rotation);
        this.f240994c0 = floatValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.tencent.mobileqq.listentogether.lyrics.a aVar;
        int id5 = view.getId();
        if (id5 == R.id.azb) {
            com.tencent.mobileqq.listentogether.lyrics.a aVar2 = this.f240986d;
            if (aVar2 != null) {
                aVar2.f();
                return;
            }
            return;
        }
        if (id5 != R.id.lwk || (aVar = this.f240986d) == null) {
            return;
        }
        aVar.g();
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        v();
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.listentogether.lyrics.FloatBaseLayout
    public void p() {
        super.p();
        this.L.setAlpha(1.0f);
        this.M.setAlpha(1.0f);
    }

    public int s(com.tencent.mobileqq.listentogether.lyrics.b bVar) {
        return bVar.f241049a - (this.f240987e / 2);
    }

    public void setPlayState(boolean z16) {
        this.R = z16;
        B();
    }

    public int t(com.tencent.mobileqq.listentogether.lyrics.b bVar) {
        return bVar.f241050b - (this.f240988f / 2);
    }

    public void y() {
        invalidate();
    }

    public void x(int i3, boolean z16) {
        QLog.d("FloatBaseLayout.Icon", 1, String.format("[float-icon] onMutualLevelChange mutualLevel=%d vasSkinShowing=%b", Integer.valueOf(i3), Boolean.valueOf(z16)));
        if (z16) {
            return;
        }
        z(R.id.lwi, i3 != 1 ? i3 != 2 ? i3 != 3 ? R.drawable.qq_aio_listentogether_lyrics_music_bg : R.drawable.ndd : R.drawable.ndc : R.drawable.ndb);
        this.f240993b0.setBackgroundResource(R.drawable.qq_aio_listentogether_lyrics_music_point);
        z(R.id.lws, R.drawable.qq_aio_listentogether_lyrics_music_dot);
        z(R.id.azb, R.drawable.qq_aio_listentogether_lyrics_music_close);
    }

    public void C(com.tencent.mobileqq.listentogether.lyrics.b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.f241059k && !bVar.f241060l && bVar.f241056h) {
            E(bVar.f241055g);
        }
        bVar.f241051c = this.f240987e;
        bVar.f241052d = this.f240988f;
    }

    public boolean D(com.tencent.mobileqq.listentogether.lyrics.b bVar) {
        boolean l3;
        if (bVar == null) {
            return false;
        }
        boolean n3 = n();
        if (bVar.f241059k && !bVar.f241060l && bVar.f241056h) {
            l3 = q();
        } else {
            l3 = l();
        }
        boolean z16 = !l3;
        if (n3 != n()) {
            B();
        }
        return z16;
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadCanceled(URLDrawable uRLDrawable) {
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
    }
}
