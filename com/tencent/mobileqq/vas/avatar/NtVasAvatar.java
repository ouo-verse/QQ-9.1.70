package com.tencent.mobileqq.vas.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.mobileqq.widget.t;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.widget.URLThemeImageView;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NtVasAvatar extends URLThemeImageView implements t.a {
    protected t C;
    private boolean D;
    private long E;
    private Drawable F;
    private final Path G;
    private int H;
    private int I;

    /* renamed from: d, reason: collision with root package name */
    public boolean f308728d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f308729e;

    /* renamed from: f, reason: collision with root package name */
    public NtVasAvatarLoader f308730f;

    /* renamed from: h, reason: collision with root package name */
    protected NtAvatarLayout f308731h;

    /* renamed from: i, reason: collision with root package name */
    protected String f308732i;

    /* renamed from: m, reason: collision with root package name */
    private View.OnLongClickListener f308733m;

    public NtVasAvatar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f308728d = false;
        Path path = new Path();
        this.G = path;
        this.H = 0;
        this.I = 0;
        path.setFillType(Path.FillType.EVEN_ODD);
        setSupportMaskView(false);
    }

    private void c() {
        int i3;
        int width = getWidth();
        int height = getHeight();
        if (this.H == width && this.I == height) {
            return;
        }
        this.H = width;
        this.I = height;
        if (width > height) {
            i3 = height / 2;
        } else {
            i3 = width / 2;
        }
        this.G.reset();
        Path path = this.G;
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        float f16 = i3;
        path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
    }

    private void d(Canvas canvas) {
        float width;
        float f16;
        if (this.F != null) {
            Rect rect = new Rect(0, 0, getWidth(), getHeight());
            if (this.f308728d) {
                width = rect.width();
                f16 = 0.2f;
            } else {
                width = rect.width();
                f16 = 0.078f;
            }
            int i3 = (int) (width * f16);
            Drawable drawable = this.F;
            int i16 = rect.left + i3;
            int i17 = rect.bottom;
            drawable.setBounds(i16, i17 - ((int) (this.F.getIntrinsicHeight() * ((rect.width() - (i3 * 2)) / this.F.getIntrinsicWidth()))), rect.right - i3, i17);
            this.F.draw(canvas);
        }
    }

    private void e(Canvas canvas) {
        if (this.E <= 0) {
            return;
        }
        Typeface createFromAsset = Typeface.createFromAsset(getContext().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH);
        Paint paint = new Paint();
        paint.setTypeface(createFromAsset);
        float height = getHeight() / 7.0f;
        paint.setTextSize(height);
        paint.setColor(-1);
        canvas.drawText(f(this.E), ((getWidth() * 4) / 9.0f) + (((2.0f - (r2.length() / 2.0f)) * height) / 2.0f), (getHeight() * 9) / 10.0f, paint);
    }

    private static String f(long j3) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        if (j3 < 10000) {
            return String.valueOf(j3);
        }
        if (j3 < JsonGrayBusiId.UI_RESERVE_100000_110000) {
            return decimalFormat.format(j3 / 1000.0d).replace(".0", "") + "k";
        }
        if (j3 < 1000000) {
            return decimalFormat.format(j3 / 10000.0d).replace(".0", "") + "w";
        }
        return decimalFormat.format(j3 / 1000000.0d).replace(".0", "") + "b";
    }

    private boolean g(String str) {
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.C != null) {
            int save = canvas.save();
            c();
            canvas.clipPath(this.G);
            this.C.a(canvas);
            canvas.restoreToCount(save);
            return;
        }
        int save2 = canvas.save();
        c();
        canvas.clipPath(this.G);
        super.draw(canvas);
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public boolean hasOnLongClickListeners() {
        if (this.f308733m != null) {
            return true;
        }
        return false;
    }

    public void i() {
        NtAvatarLayout ntAvatarLayout = this.f308731h;
        if (ntAvatarLayout != null) {
            ntAvatarLayout.setGoneBelow(1);
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasAvatar", 2, "show vas avatar of " + this.f308732i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.URLThemeImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        t tVar = this.C;
        if (tVar != null) {
            tVar.b(canvas);
        } else {
            super.onDraw(canvas);
        }
        if (this.D) {
            e(canvas);
        }
        d(canvas);
    }

    @Override // com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        super.onLoadSuccessed(uRLDrawable);
        i();
        Drawable currDrawable = uRLDrawable.getCurrDrawable();
        if ((currDrawable instanceof ApngDrawable) && (MobileQQ.sMobileQQ.peekAppRuntime() instanceof AppInterface)) {
            NtVasFaceManager.n(this.f308732i, (ApngDrawable) currDrawable);
        }
    }

    @Override // com.tencent.image.URLImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f308730f = null;
    }

    public void setLoader(NtAvatarLayout ntAvatarLayout, NtVasAvatarLoader ntVasAvatarLoader) {
        this.f308729e = ntVasAvatarLoader.f308741g;
        ntVasAvatarLoader.f308741g = null;
        String str = this.f308732i;
        if (str == null) {
            str = "";
        }
        this.f308732i = str;
        boolean z16 = !str.equals(ntVasAvatarLoader.f308736b);
        String str2 = ntVasAvatarLoader.f308736b;
        this.f308732i = str2;
        boolean g16 = g(str2);
        this.D = g16;
        if (z16 || !g16) {
            setImageDrawable(this.f308729e);
        }
        if (z16) {
            this.F = null;
        }
        this.f308731h = ntAvatarLayout;
        this.f308730f = ntVasAvatarLoader;
        ntVasAvatarLoader.d(this);
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void setMosaicEffect(t tVar) {
        t tVar2 = this.C;
        if (tVar2 != null) {
            tVar2.c(null);
        }
        this.C = tVar;
        if (tVar != null) {
            tVar.c(this);
        }
        invalidate();
    }

    @Override // android.view.View
    public void setOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
        this.f308733m = onLongClickListener;
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void superDrawMosaic(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void superOnDrawMosaic(Canvas canvas) {
        super.onDraw(canvas);
    }

    public NtVasAvatar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public NtVasAvatar(Context context) {
        this(context, null);
    }

    public void h(String str, long j3) {
    }
}
