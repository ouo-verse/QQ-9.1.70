package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendFeedView extends FrameLayout implements View.OnTouchListener {
    private static Bitmap H;
    private GradientDrawable C;
    private boolean D;
    private int E;

    /* renamed from: d, reason: collision with root package name */
    private int f264131d;

    /* renamed from: e, reason: collision with root package name */
    private int f264132e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f264133f;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f264134h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f264135i;

    /* renamed from: m, reason: collision with root package name */
    private final float f264136m;
    private static final int[] F = {-13900833, -37464, -12331403, -5544982};
    public static ColorFilter G = new PorterDuffColorFilter(536870912, PorterDuff.Mode.SRC_ATOP);
    private static final Map<String, WeakReference<Bitmap>> I = new HashMap();

    public ExtendFriendFeedView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032 A[Catch: Exception -> 0x0072, TryCatch #0 {Exception -> 0x0072, blocks: (B:7:0x0009, B:9:0x0010, B:11:0x0018, B:13:0x0023, B:15:0x0032, B:16:0x0040, B:18:0x004a, B:20:0x0053, B:24:0x0059, B:27:0x003a), top: B:6:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a A[Catch: Exception -> 0x0072, TryCatch #0 {Exception -> 0x0072, blocks: (B:7:0x0009, B:9:0x0010, B:11:0x0018, B:13:0x0023, B:15:0x0032, B:16:0x0040, B:18:0x004a, B:20:0x0053, B:24:0x0059, B:27:0x003a), top: B:6:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003a A[Catch: Exception -> 0x0072, TryCatch #0 {Exception -> 0x0072, blocks: (B:7:0x0009, B:9:0x0010, B:11:0x0018, B:13:0x0023, B:15:0x0032, B:16:0x0040, B:18:0x004a, B:20:0x0053, B:24:0x0059, B:27:0x003a), top: B:6:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap a(String str) {
        int i3;
        String e16;
        int lastIndexOf;
        String[] strArr = com.tencent.mobileqq.qqexpand.utils.e.f264090c;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(61)) >= 0) {
                String substring = str.substring(lastIndexOf + 1);
                if (!TextUtils.isEmpty(substring)) {
                    i3 = substring.toUpperCase().charAt(0) % strArr.length;
                    if (i3 != -1) {
                        e16 = com.tencent.mobileqq.qqexpand.utils.e.e("expand_feed_bg_default.png");
                    } else {
                        e16 = com.tencent.mobileqq.qqexpand.utils.e.e(strArr[i3]);
                    }
                    Map<String, WeakReference<Bitmap>> map = I;
                    WeakReference<Bitmap> weakReference = map.get(e16);
                    r1 = weakReference != null ? weakReference.get() : null;
                    if (r1 == null && !r1.isRecycled()) {
                        return r1;
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    options.inSampleSize = 2;
                    r1 = com.tencent.mobileqq.qqexpand.utils.e.a(e16, options);
                    map.put(e16, new WeakReference<>(r1));
                    return r1;
                }
            }
            i3 = -1;
            if (i3 != -1) {
            }
            Map<String, WeakReference<Bitmap>> map2 = I;
            WeakReference<Bitmap> weakReference2 = map2.get(e16);
            if (weakReference2 != null) {
            }
            if (r1 == null) {
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inPreferredConfig = Bitmap.Config.RGB_565;
            options2.inSampleSize = 2;
            r1 = com.tencent.mobileqq.qqexpand.utils.e.a(e16, options2);
            map2.put(e16, new WeakReference<>(r1));
            return r1;
        } catch (Exception e17) {
            QLog.e("ExtendFriendFeedView", 1, "getRandomFeedBackground fail.", e17);
            return r1;
        }
    }

    private GradientDrawable b(int i3) {
        int[] iArr = F;
        int i16 = iArr[i3 % iArr.length];
        GradientDrawable gradientDrawable = this.C;
        if (gradientDrawable == null) {
            float f16 = this.f264136m;
            this.C = com.tencent.mobileqq.qqexpand.utils.i.a(i16, 0.0f, 0.0f, f16, f16);
        } else {
            gradientDrawable.setColor(i16);
        }
        return this.C;
    }

    private void c() {
        float f16;
        float f17;
        if (this.f264133f == null) {
            Paint paint = new Paint(1);
            this.f264133f = paint;
            paint.setStyle(Paint.Style.FILL);
            this.f264133f.setAntiAlias(true);
        }
        if (this.f264131d <= 0 || this.f264132e <= 0) {
            return;
        }
        Bitmap bitmap = this.f264134h;
        if (bitmap == null || bitmap.isRecycled()) {
            if (H == null) {
                H = Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565);
                new Canvas(H).drawColor(-1);
            }
            this.f264134h = H;
        }
        int width = this.f264134h.getWidth();
        int height = this.f264134h.getHeight();
        int i3 = this.f264131d;
        float f18 = width;
        float f19 = i3 / f18;
        int i16 = this.f264132e;
        float f26 = height;
        float f27 = i16 / f26;
        if (f19 > f27) {
            f17 = ((f26 * f19) - i16) / 2.0f;
            f16 = 0.0f;
        } else {
            f16 = ((f18 * f27) - i3) / 2.0f;
            f19 = f27;
            f17 = 0.0f;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f19, f19);
        matrix.postTranslate(-f16, -f17);
        Bitmap bitmap2 = this.f264134h;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        this.f264133f.setShader(bitmapShader);
        if (this.f264135i == null) {
            this.f264135i = new RectF();
        }
        this.f264135i.set(0.0f, this.E, this.f264131d, this.f264132e);
        if (this.C != null) {
            int f28 = BaseAIOUtils.f(5.0f, getResources());
            GradientDrawable gradientDrawable = this.C;
            int i17 = this.f264132e;
            gradientDrawable.setBounds(0, i17 - f28, this.f264131d, i17);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Paint paint;
        RectF rectF = this.f264135i;
        if (rectF != null && (paint = this.f264133f) != null) {
            float f16 = this.f264136m;
            canvas.drawRoundRect(rectF, f16, f16, paint);
        }
        GradientDrawable gradientDrawable = this.C;
        if (gradientDrawable != null) {
            gradientDrawable.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f264131d = i3;
        this.f264132e = i16;
        c();
        invalidate();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z16 = true;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                }
            }
            z16 = false;
        }
        if (this.D != z16) {
            this.D = z16;
            if (z16) {
                this.f264133f.setColorFilter(G);
            } else {
                this.f264133f.setColorFilter(null);
            }
            invalidate();
        }
        return false;
    }

    public void setFeedBgParams(int i3, String str, int i16) {
        setFeedBgParams(i3, str, i16, true);
    }

    public ExtendFriendFeedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setFeedBgParams(int i3, String str, int i16, boolean z16) {
        this.E = i16;
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendFeedView", 2, "setFeedBgParams feedPosition:" + i3 + " itemPaddingTop:" + i16 + "  getPaddingTop:" + getPaddingTop());
        }
        setPadding(getPaddingLeft(), i16, getPaddingRight(), getPaddingBottom());
        this.f264134h = a(str);
        if (z16) {
            this.C = b(i3);
        } else {
            this.C = null;
        }
        c();
        invalidate();
    }

    public ExtendFriendFeedView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = 0;
        LayoutInflater.from(context).inflate(R.layout.f167377d02, (ViewGroup) this, true);
        this.f264136m = BaseAIOUtils.f(4.0f, getResources());
    }
}
